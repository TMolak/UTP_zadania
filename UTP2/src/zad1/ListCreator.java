package zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


public class ListCreator<T> {

    private List<T> firstList;

    private ListCreator(List<T> list) {
        this.firstList = list;
    }

    public static <T> ListCreator<T> collectFrom(List<T> list) {
        return new ListCreator<>(list);
    }

    public ListCreator<T> when(Predicate<T> predicate) {
        List<T> secondList = new ArrayList<>();
        for (T s : firstList){
            if (predicate.test(s)){
                secondList.add(s);
            }
        }
        firstList = secondList;
        return this;
    }

    public <S>List<S> mapEvery(Function<T, S> function) {
        List<S> thirdList = new ArrayList<>();
        for(T t : firstList){
            thirdList.add(function.apply(t));
        }
        return thirdList;
    }
}
