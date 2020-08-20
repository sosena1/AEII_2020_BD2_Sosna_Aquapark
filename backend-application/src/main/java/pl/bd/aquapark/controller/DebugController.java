package pl.bd.aquapark.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.bd.aquapark.util.DateUtil;

@RestController
@RequestMapping("/debug")
public class DebugController {

    @GetMapping(value = "time")
    public Object setTime(
            @RequestParam(name = "date", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
            java.util.Date date
    ) {
        DateUtil.setOverriddenDate(date);
        java.util.Date dateNew = DateUtil.getOverriddenDate();
        if (dateNew == null) {
            return "Date is null - Backend will set date correctly";
        }
        return DateUtil.getOverriddenDate();
    }


}
