package pl.bd.aquapark.service;

import pl.bd.aquapark.dao.PriceList;
import pl.bd.aquapark.repository.PriceListRepository;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;

public class PriceListService {

    public static PriceList getPriceListForDate(PriceListRepository priceListRepository, Date date) {
        List<PriceList> priceLists = GetAllService.getAll(priceListRepository);
        priceLists.sort(Comparator.comparing(o -> ((PriceList)o).getValidityStartDate()).reversed());
        for (PriceList priceList : priceLists) {
            if (priceList.getValidityStartDate().compareTo(date) < 0) {
                return priceList;
            }
        }
        return priceLists.get(0); //nie powinno sie zdarzyc!!!
    }
}
