/**
 * @author Molak Tomasz S26635
 */

package zad1;

import java.util.ArrayList;
import java.util.List;

public class ListCreator<T> { // Uwaga: klasa musi być sparametrtyzowana

    private List<T> firstList;

    private ListCreator(List<T> list) {
        this.firstList = list;
    }

    public static <T> ListCreator<T> collectFrom(List<T> list) {
        return new ListCreator<>(list);
    }

    public ListCreator<T> when(Selector<T> sel) {
        List<T> secondList = new ArrayList<>();
        for (T element : firstList){
            if (sel.select(element)){
                secondList.add(element);
            }
        }
        firstList = secondList;
        return this;
    }

    public <S>List<S> mapEvery(Mapper<S, T> map) {
        List<S> thirdList = new ArrayList<>();
        for(T item : firstList){
            thirdList.add(map.map(item));
        }
        return thirdList;
    }

}
