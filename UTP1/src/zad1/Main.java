/**
 * @author Molak Tomasz S26635
 */

package zad1;


import java.util.*;

public class Main {
    public Main() {
        List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12);/*<-- tu dopisać inicjację elementów listy */
        System.out.println(test1(src1));

        List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv" ); /*<-- tu dopisać inicjację elementów listy */
        System.out.println(test2(src2));
    }

    public List<Integer> test1(List<Integer> src) {
        Selector<Integer> sel = new Selector<Integer>() {
            @Override
            public boolean select(Integer integer) {
                return integer < 10;
            }
        };/*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */
        Mapper<Integer, Integer> map = new Mapper<Integer, Integer>() {
            @Override
            public Integer map(Integer num) {
                return num + 10;
            }
        };/*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */
        return ListCreator.collectFrom(src).when(sel).mapEvery(map);
    }

    public List<Integer> test2(List<String> src) {
        Selector<String> sel = new Selector<String>() {
            @Override
            public boolean select(String str) {
                return str.length() > 3;
            }
        };/*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */
        Mapper<Integer, String> map = new Mapper<Integer, String>() {
            @Override
            public Integer map(String str) {
                return (str.length() + 10);
            }
        };/*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */
        return ListCreator.collectFrom(src).when(sel).mapEvery(map);
    }

    public static void main(String[] args) {
        new Main();
    }
}
