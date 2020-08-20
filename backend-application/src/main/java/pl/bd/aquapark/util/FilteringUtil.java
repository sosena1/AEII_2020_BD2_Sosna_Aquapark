package pl.bd.aquapark.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Chainowalny filter, w którym argumenty mogą być nullami.
 *
 * Przykładowe użycie (patrz PatientsController):
 *
 * List<User> patients = users.getContent();
 *
 * //opcjonalne filtrowanie
 * patients = new FilteringService<>(patients)
 *         .contains(firstName, User::getFirstName)
 *         .contains(lastName, User::getLastName)
 *         .contains(contactNumber, User::getContactNumber)
 *         .contains(userId, User::getUserId)
 *         .getFiltered();
 */
public class FilteringUtil<T> {

    private List<T> filteredList;

    public FilteringUtil(List<T> input) {
        this.filteredList = new ArrayList<>(input);
    }

    public List<T> getFiltered() {
        return filteredList;
    }

    /**
     * Filtruje według Longa match.
     */
    public FilteringUtil<T> contains(Long match, LongGetter<T> getter) {
        if (match == null) return this;

        filteredList = filteredList
                .stream()
                .filter(
                        (T t) -> {
                            return ("" + getter.getLong(t)).contains("" + match);
                        })
                .collect(Collectors.toList());
        return this;
    }

    /**
     * Filtruje według stringa match. Ignoruje case.
     */
    public FilteringUtil<T> contains(String match, StringGetter<T> getter) {
        if (match == null) return this;

        String matchLowerCase = match.toLowerCase();

        filteredList = filteredList
                .stream()
                .filter(
                        (T t) -> {
                            return getter
                                    .getString(t)
                                    .toLowerCase()
                                    .contains(matchLowerCase);
                        })
                .collect(Collectors.toList());
        return this;


    }

    /**
     * Filtruje według daty match. Daty muszą być równe co do dnia.
     */
    public FilteringUtil<T> contains(Date match, DateGetter<T> getter) {
        if (match == null) return this;

        filteredList = filteredList
                .stream()
                .filter(
                        (T t) -> {
                            return DateUtil.isDayEqual(getter.getDate(t), match);
                        })
                .collect(Collectors.toList());
        return this;

    }

    /*
    Filtruje według daty (starting date może być równe lub mniejsze niż aktualna data)
     */
    public FilteringUtil<T> starts(Date startingDate, DateGetter<T> getter) {
        if (startingDate == null) return this;

        filteredList = filteredList
                .stream()
                .filter(
                        (T t) -> {
                            return !(getter.getDate(t).compareTo(startingDate) > 0); //todo test
                        })
                .collect(Collectors.toList());
        return this;
    }

    /*
    Filtruje według daty (ending date może być równe lub większe niż aktualna data)
     */
    public FilteringUtil<T> ends(Date endingDate, DateGetter<T> getter) {
        if (endingDate == null) return this;

        filteredList = filteredList
                .stream()
                .filter(
                        (T t) -> {
                            return !(getter.getDate(t).compareTo(endingDate) < 0); //todo test
                        })
                .collect(Collectors.toList());
        return this;
    }

    @FunctionalInterface
    public interface StringGetter<T> {
        String getString(T obj);
    }

    @FunctionalInterface
    public interface LongGetter<T> {
        Long getLong(T obj);
    }

    @FunctionalInterface
    public interface DateGetter<T> {
        Date getDate(T obj);
    }

}
