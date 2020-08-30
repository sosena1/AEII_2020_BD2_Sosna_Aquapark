package pl.bd.aquapark.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;
import java.util.List;

public class GetAllService {
    public static  <T> List<T> getAll(PagingAndSortingRepository<T, Long> repository) {
        long count = repository.count();

        if (count == 0) {
            return new ArrayList<>();
        }

        Page<T> allEmployeesPages = repository.findAll(PageRequest.of(0, (int) count));
        return  allEmployeesPages.getContent();
    }
}
