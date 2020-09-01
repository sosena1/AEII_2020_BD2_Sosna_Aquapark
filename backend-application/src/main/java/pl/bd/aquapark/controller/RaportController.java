package pl.bd.aquapark.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import pl.bd.aquapark.util.DateUtil;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
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
        List<Date> dates = DateUtil.generateDates(start, end);
        ManagementReport managementReport = new ManagementReport();

        for (Date date : dates) {
            List<Visit> visitsForDay = visitRepository.findAllByDate(date.toString());

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
        List<Date> dates = DateUtil.generateDates(start, end);
        OperationalReport operationalReport = new OperationalReport();

        for (Date date : dates) {
            List<AquaparkAttractionMaintenance> maintenanceByDay = attractionMaintenanceRepository.findAllByDate(date.toString());
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


    public static class ManagementReport {
        private HashMap<ComplexDate, BigDecimal> incomeByDay = new HashMap<>();
        private BigDecimal totalIncome = new BigDecimal(0);

        public ManagementReport() {
        }

        public List<ComplexDateBigDecimal> getIncomePerDay() {
            List<ComplexDateBigDecimal> complexDateBigDecimals = new ArrayList<>();
            for (ComplexDate cd : incomeByDay.keySet()) {
                BigDecimal count = incomeByDay.get(cd);
                complexDateBigDecimals.add(new ComplexDateBigDecimal(cd.date, count));
            }
            complexDateBigDecimals.sort(Comparator.comparing(ComplexDate::getDate));
            return complexDateBigDecimals;
        }

        public BigDecimal getTotalIncome() {
            return this.totalIncome;
        }

        public void setIncomeByDay(HashMap<ComplexDate, BigDecimal> incomeByDay) {
            this.incomeByDay = incomeByDay;
        }

        public void setTotalIncome(BigDecimal totalIncome) {
            this.totalIncome = totalIncome;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof ManagementReport)) return false;
            final ManagementReport other = (ManagementReport) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$incomeByDay = this.getIncomeByDay();
            final Object other$incomeByDay = other.getIncomeByDay();
            if (this$incomeByDay == null ? other$incomeByDay != null : !this$incomeByDay.equals(other$incomeByDay))
                return false;
            final Object this$totalIncome = this.getTotalIncome();
            final Object other$totalIncome = other.getTotalIncome();
            if (this$totalIncome == null ? other$totalIncome != null : !this$totalIncome.equals(other$totalIncome))
                return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof ManagementReport;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $incomeByDay = this.getIncomeByDay();
            result = result * PRIME + ($incomeByDay == null ? 43 : $incomeByDay.hashCode());
            final Object $totalIncome = this.getTotalIncome();
            result = result * PRIME + ($totalIncome == null ? 43 : $totalIncome.hashCode());
            return result;
        }

        public String toString() {
            return "RaportController.ManagementReport(incomeByDay=" + this.getIncomeByDay() + ", totalIncome=" + this.getTotalIncome() + ")";
        }

        @JsonIgnore
        public HashMap<ComplexDate, BigDecimal> getIncomeByDay() {
            return this.incomeByDay;
        }
    }

    public static class OperationalReport {
        private HashMap<ComplexDate, Integer> maintenancesPerDay = new HashMap<>();
        private List<AquaparkMaintenanceDto> maintenancesDetailed = new ArrayList<>();

        public OperationalReport() {
        }

        public List<ComplexDateInteger> getMaintenancesByDay() {
            List<ComplexDateInteger> complexDateIntegers = new ArrayList<>();
            for (ComplexDate cd : maintenancesPerDay.keySet()) {
                Integer count = maintenancesPerDay.get(cd);
                complexDateIntegers.add(new ComplexDateInteger(cd.date, count));
            }
            complexDateIntegers.sort(Comparator.comparing(ComplexDate::getDate));
            return complexDateIntegers;
        }

        public List<AquaparkMaintenanceDto> getMaintenancesDetailed() {
            return this.maintenancesDetailed;
        }

        public void setMaintenancesPerDay(HashMap<ComplexDate, Integer> maintenancesPerDay) {
            this.maintenancesPerDay = maintenancesPerDay;
        }

        public void setMaintenancesDetailed(List<AquaparkMaintenanceDto> maintenancesDetailed) {
            this.maintenancesDetailed = maintenancesDetailed;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof OperationalReport)) return false;
            final OperationalReport other = (OperationalReport) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$maintenancesPerDay = this.getMaintenancesPerDay();
            final Object other$maintenancesPerDay = other.getMaintenancesPerDay();
            if (this$maintenancesPerDay == null ? other$maintenancesPerDay != null : !this$maintenancesPerDay.equals(other$maintenancesPerDay))
                return false;
            final Object this$maintenancesDetailed = this.getMaintenancesDetailed();
            final Object other$maintenancesDetailed = other.getMaintenancesDetailed();
            if (this$maintenancesDetailed == null ? other$maintenancesDetailed != null : !this$maintenancesDetailed.equals(other$maintenancesDetailed))
                return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof OperationalReport;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $maintenancesPerDay = this.getMaintenancesPerDay();
            result = result * PRIME + ($maintenancesPerDay == null ? 43 : $maintenancesPerDay.hashCode());
            final Object $maintenancesDetailed = this.getMaintenancesDetailed();
            result = result * PRIME + ($maintenancesDetailed == null ? 43 : $maintenancesDetailed.hashCode());
            return result;
        }

        public String toString() {
            return "RaportController.OperationalReport(maintenancesPerDay=" + this.getMaintenancesPerDay() + ", maintenancesDetailed=" + this.getMaintenancesDetailed() + ")";
        }

        @JsonIgnore
        public HashMap<ComplexDate, Integer> getMaintenancesPerDay() {
            return this.maintenancesPerDay;
        }
    }

    public static class ComplexDateInteger extends ComplexDate {
        private int value;

        public ComplexDateInteger(Date date, int value) {
            super(date);
            this.value = value;
        }

        public ComplexDateInteger() {
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof ComplexDateInteger)) return false;
            final ComplexDateInteger other = (ComplexDateInteger) o;
            if (!other.canEqual((Object) this)) return false;
            if (this.getValue() != other.getValue()) return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof ComplexDateInteger;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            result = result * PRIME + this.getValue();
            return result;
        }

        public String toString() {
            return "RaportController.ComplexDateInteger(value=" + this.getValue() + ")";
        }
    }

    public static class ComplexDateBigDecimal extends ComplexDate {
        private BigDecimal value;

        public ComplexDateBigDecimal(Date date, BigDecimal value) {
            super(date);
            this.value = value;
        }

        public ComplexDateBigDecimal() {
        }

        public BigDecimal getValue() {
            return this.value;
        }

        public void setValue(BigDecimal value) {
            this.value = value;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof ComplexDateBigDecimal)) return false;
            final ComplexDateBigDecimal other = (ComplexDateBigDecimal) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$value = this.getValue();
            final Object other$value = other.getValue();
            if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof ComplexDateBigDecimal;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $value = this.getValue();
            result = result * PRIME + ($value == null ? 43 : $value.hashCode());
            return result;
        }

        public String toString() {
            return "RaportController.ComplexDateBigDecimal(value=" + this.getValue() + ")";
        }
    }

    public static class ComplexDate {
        private Date date;
        private DayOfWeek dayOfWeek;

        public ComplexDate(Date date) {
            this.date = date;
            LocalDate localDate = date.toLocalDate();
            dayOfWeek = localDate.getDayOfWeek();
        }

        public ComplexDate() {
        }

        public Date getDate() {
            return this.date;
        }

        public DayOfWeek getDayOfWeek() {
            return this.dayOfWeek;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public void setDayOfWeek(DayOfWeek dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof ComplexDate)) return false;
            final ComplexDate other = (ComplexDate) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$date = this.getDate();
            final Object other$date = other.getDate();
            if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
            final Object this$dayOfWeek = this.getDayOfWeek();
            final Object other$dayOfWeek = other.getDayOfWeek();
            if (this$dayOfWeek == null ? other$dayOfWeek != null : !this$dayOfWeek.equals(other$dayOfWeek))
                return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof ComplexDate;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $date = this.getDate();
            result = result * PRIME + ($date == null ? 43 : $date.hashCode());
            final Object $dayOfWeek = this.getDayOfWeek();
            result = result * PRIME + ($dayOfWeek == null ? 43 : $dayOfWeek.hashCode());
            return result;
        }

        public String toString() {
            return "RaportController.ComplexDate(date=" + this.getDate() + ", dayOfWeek=" + this.getDayOfWeek() + ")";
        }
    }
}
