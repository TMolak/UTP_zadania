package zad4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class XList<T> extends ArrayList<T> {

    //Kontruktory
    public XList() {
    }

    public XList(T... el) {
        super(Arrays.asList(el));
    }

    public XList(Collection<T> collection) {
        super(collection);
    }

    //Metody of
    public static <U> XList<U> of(U... el) {
        return new XList<>(el);
    }

    public static <U> XList<U> of(Collection<U> el) {
        return new XList<>(el);
    }

    //ofChars(napis) - zwraca x-listę znaków napisu,
    public static XList<String> charsOf(String napis) {
        char[] charsTab = napis.toCharArray();
        XList<String> xListOfChars = new XList<>();
        for (char str : charsTab) {
            xListOfChars.add(String.valueOf(str));
        }
        return xListOfChars;
    }

    //ofTokens(napis, [ sep ]) - zwraca x-listę symboli napisu, rozdzielonych separatorami z sep (jesśi brak - to białymi znakami).
    public static XList<String> tokensOf(String napis, String sep) {
        return new XList<>(napis.split(sep));
    }

    public static XList<String> tokensOf(String napis) {
        return new XList<>(napis.split("\s"));
    }
//Reszta metod

    //union(dowolna_kolekcja)  -  zwraca  nową x-list z dołączaną do tej x-list  zawartością kolekcji,
    public XList<T> union(T... elements) {
        XList<T> resultList = new XList<>();
        for (T t : elements) {
            resultList.add(t);
        }
        return resultList;
    }

    public XList<T> union(Collection<T> elements) {
        XList<T> resultList = new XList<>(this);
        resultList.addAll(elements);
        return resultList;
    }

    //diff(dowolna_kolekcja) - zwraca x-list zawierającą te elementy tej x-list, które nie występują w kolekcji,
    public XList<T> diff(Collection<T> coll) {
        XList<T> resultList = new XList<>(this);
        resultList.removeAll(XList.of(coll));
        return resultList;
    }

    //unique() - zwraca nową x-list, która zawiera wszystkie niepowtarzające się elementy tej x-list
    public XList<T> unique() {
        XList<T> resultList = new XList<>();
        for (T t : this) {
            if (!resultList.contains(t)) {
                resultList.add(t);
            }
        }
        return resultList;
    }

    //combine() - zwraca x-listę list-kombinacji elementów z poszczególnych kolekcji, będących elementami tej x-listy
    public XList<T> combine() {
        return null;
    }

    //collect(Function) - zwraca nową x-listę, której elemenatmi są wyniki funkcji stosowanej wobec elementów tej x-listy,
    public <T> XList<String> collect(Function<XList<T>, String> function) {
        XList<T> resultList = new XList<>();
        for (XList<T> l : (XList<XList<T>>) this) {
            resultList.add((T) function.apply(l));
        }
        return (XList<String>) resultList;
    }

    //join([sep]) - zwraca napis, będący połączeniem elementów tej x-listy, z ewentualnie wstawionym pomiędzy nie separatorem,
    public String join(String sep) {
        return this.join(sep);
    }

    public String join() {
        return join("");
    }

    //forEachWithIndex(konsumer_z_dwoma argumentami: element, index) - do iterowania po liście z dostępem i do elementów i do ich indeksów.
    public void forEachWithIndex(BiConsumer<T, Integer> consumer) {
        for (int i = 0; i < this.size(); i++) {
            consumer.accept(this.get(i), i);
        }
    }
}
