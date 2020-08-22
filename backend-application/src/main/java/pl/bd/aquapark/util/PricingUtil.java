package pl.bd.aquapark.util;

import pl.bd.aquapark.dao.*;
import pl.bd.aquapark.repository.ConditionRepository;
import pl.bd.aquapark.repository.PriceListRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PricingUtil {

    public static PriceList getPriceListForDate(PriceListRepository priceListRepository, Date date) {
        List<PriceList> priceLists = GetAllUtil.getAll(priceListRepository);
        priceLists = new ArrayList<>(priceLists);
        priceLists.sort(Comparator.comparing(o -> ((PriceList)o).getValidityStartDate()).reversed());
        for (PriceList priceList : priceLists) {
            if (priceList.getValidityStartDate().compareTo(date) < 0) {
                return priceList;
            }
        }
        System.err.println("No pricelist for current date!");
        return priceLists.get(0);
    }

    public static PriceListItem priceListItemForSettings(PriceListRepository priceListRepository, User user, AquaparkAttraction aquaparkAttraction, Date date) {
        PriceList priceList = getPriceListForDate(priceListRepository, DateUtil.getCurrentDay());

        int userAge = DateUtil.getDiffYears(user.getBirthDate(), DateUtil.getCurrentDay());
        boolean isChild = false;
        boolean isSenior = false;
        boolean isWeekend = false;


        if (userAge < 12) {
            isChild = true;
        } else if (userAge > 65) {
            isSenior = true;
        }

        DayOfWeek dayOfWeek = DateUtil.getDayOfWeek(date);
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            isWeekend = true;
        }

        PriceListItem bestPrice = null;
        BigDecimal bestPriceValue = new BigDecimal(100000);

        for (PriceListItem priceListItem : priceList.getPriceListItems()) {
            if (!priceListItem.getAquaparkAttraction().equals(aquaparkAttraction)) {
                continue; //todo test
            }


            Conditions conditions = priceListItem.getConditions();

            if (conditions.getChildOnly() && !isChild) {
                continue;
            }
            if (conditions.getSeniorOnly() && !isSenior) {
                continue;
            }
            if (conditions.getWeekendOnly() && !isWeekend) {
                continue;
            }

            if (bestPrice == null) {
                bestPrice = priceListItem;
                bestPriceValue = bestPrice.getValue();
            } else {
                if (priceListItem.getValue().compareTo(bestPriceValue) < 0) {
                    bestPrice = priceListItem;
                    bestPriceValue = priceListItem.getValue();
                }
            }


        }

        return bestPrice;
    }

    public static Conditions getOrCreateCondition(ConditionRepository repository, boolean childOnly, boolean seniorOnly, boolean weekendOnly) {
        List<Conditions> conditions = GetAllUtil.getAll(repository);
        for (Conditions condit : conditions) {
            if (condit.getWeekendOnly() == weekendOnly
            && condit.getChildOnly() == childOnly
            && condit.getSeniorOnly() == seniorOnly) {
                return condit;
            }
        }
        Conditions conditions1 = new Conditions();
        conditions1.setSeniorOnly(seniorOnly);
        conditions1.setChildOnly(childOnly);
        conditions1.setWeekendOnly(weekendOnly);

        return repository.save(conditions1);
    }
}
