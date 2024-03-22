package zad2;

import java.util.function.Function;

public class InputConverter<T> {
    private T x;

    public InputConverter(T x) {
        this.x = x;
    }

    public <R> R convertBy(Function... functions) {
        Object result = this.x;
        for (Function function : functions) {
            result = function.apply(result);
        }
        return (R) result;
    }
}
