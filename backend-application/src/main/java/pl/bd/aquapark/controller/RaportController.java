package pl.bd.aquapark.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.bd.aquapark.Roles;
import pl.bd.aquapark.dao.AquaparkAttractionMaintenance;
import pl.bd.aquapark.dao.Visit;
import pl.bd.aquapark.dto.AquaparkMaintenanceDto;
import pl.bd.aquapark.repository.AttractionMaintenanceRepository;
import pl.bd.aquapark.repository.AttractionRepository;
import pl.bd.aquapark.repository.VisitRepository;
import pl.bd.aquapark.service.DateService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/raport")
public class RaportController {

    @Autowired
    VisitRepository visitRepository;

    @Autowired
    AttractionRepository attractionRepository;

    @Autowired
    AttractionMaintenanceRepository attractionMaintenanceRepository;

    @GetMapping("/management")
    public ResponseEntity<ManagementReport> getManagementReport(HttpServletRequest httpServletRequest, @RequestParam Date start, @RequestParam Date end) {
        if (!httpServletRequest.isUserInRole(Roles.ANALYST.toString())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<Date> dates = DateService.generateDates(start, end);
        ManagementReport managementReport = new ManagementReport();

        for (Date date : dates) {
            List<Visit> visitsForDay = visitRepository.findAllByDate(date);

            BigDecimal income = new BigDecimal(0);

            for (Visit visit : visitsForDay) {
                income = income.add(visit.getValue());
            }
            managementReport.incomeByDay.put(new ComplexDate(date), income);
            managementReport.totalIncome = managementReport.totalIncome.add(income);
        }

        return ResponseEntity.ok(managementReport);
    }

    @GetMapping("/operational")
    public ResponseEntity<OperationalReport> getOperationalReport(HttpServletRequest httpServletRequest, @RequestParam Date start, @RequestParam Date end) {
        if (!httpServletRequest.isUserInRole(Roles.ANALYST.toString())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<Date> dates = DateService.generateDates(start, end);
        OperationalReport operationalReport = new OperationalReport();

        for (Date date : dates) {
            List<AquaparkAttractionMaintenance> maintenanceByDay = attractionMaintenanceRepository.findAllByDate(date);
            ComplexDate complexDate = new ComplexDate(date);

            operationalReport.maintenancesPerDay.put(complexDate, maintenanceByDay.size());

            operationalReport.maintenancesDetailed.addAll(
                    maintenanceByDay
                        .stream()
                        .map(
                            AquaparkMaintenanceDto::fromAquaparkAttractionMaintenance
                        )
                        .collect(Collectors.toList())
            );
        }

        return ResponseEntity.ok(operationalReport);
    }


    public static @Data class ManagementReport {
        @Getter(onMethod = @__( @JsonIgnore))
        private HashMap<ComplexDate, BigDecimal> incomeByDay = new HashMap<>();
        private BigDecimal totalIncome = new BigDecimal(0);

        public List<ComplexDateBigDecimal> getIncomeByDay() {
            List<ComplexDateBigDecimal> complexDateBigDecimals = new ArrayList<>();
            for (ComplexDate cd : incomeByDay.keySet()) {
                BigDecimal count = incomeByDay.get(cd);
                complexDateBigDecimals.add(new ComplexDateBigDecimal(cd.date, count));
            }
            complexDateBigDecimals.sort(Comparator.comparing(ComplexDate::getDate));
            return complexDateBigDecimals;
        }
    }

    public static @Data class OperationalReport {
        @Getter(onMethod = @__( @JsonIgnore))
        private HashMap<ComplexDate, Integer> maintenancesPerDay = new HashMap<>();
        private List<AquaparkMaintenanceDto> maintenancesDetailed = new ArrayList<>();

        public List<ComplexDateInteger> getMaintenancesByDay() {
            List<ComplexDateInteger> complexDateIntegers = new ArrayList<>();
            for (ComplexDate cd : maintenancesPerDay.keySet()) {
                Integer count = maintenancesPerDay.get(cd);
                complexDateIntegers.add(new ComplexDateInteger(cd.date, count));
            }
            complexDateIntegers.sort(Comparator.comparing(ComplexDate::getDate));
            return complexDateIntegers;
        }
    }

    public static @Data class ComplexDateInteger extends ComplexDate {
        private int value;

        public ComplexDateInteger(Date date, int value) {
            super(date);
            this.value = value;
        }
    }

    public static @Data class ComplexDateBigDecimal extends ComplexDate {
        private BigDecimal value;

        public ComplexDateBigDecimal(Date date, BigDecimal value) {
            super(date);
            this.value = value;
        }
    }

    public static @Data class ComplexDate {
        private Date date;
        private DayOfWeek dayOfWeek;

        public ComplexDate(Date date) {
            this.date = date;
            LocalDate localDate = date.toLocalDate();
            dayOfWeek = localDate.getDayOfWeek();
        }
    }
}
