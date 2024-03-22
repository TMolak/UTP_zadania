package zad1;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe<T> {

    private T x;

    private Maybe(T x) {
        this.x = x;
    }

    public static <T> Maybe<T> of(T x) {
        return new Maybe<>(x);
    }

    public void ifPresent(Consumer<T> cons) {
        if (x != null) {
            cons.accept(x);
        }
    }

    public <R> Maybe<R> map(Function<T, R> func) {
        if (x != null) {
            return Maybe.of(func.apply(x));
        } else {
            return Maybe.of(null);
        }
    }


    public T get() {
        if (x != null) {
            return x;
        } else {
            throw new NoSuchElementException("maybe is empty");
        }
    }

    public boolean isPresent() {
        if (x != null) {
            return true;
        } else {
            return false;
        }
    }

    public T orElse(T defVal) {
        return x != null ? x : defVal;
    }

    public Maybe<T> filter(Predicate<T> pred) {
        if (pred.test(x) && x == null) {
            return this;
        } else {
            return Maybe.of(null);
        }
    }

    @Override
    public String toString() {
        if (x != null) {
            return "Maybe has value " + x;
        } else {
            return "Maybe is empty";
        }
    }
}
