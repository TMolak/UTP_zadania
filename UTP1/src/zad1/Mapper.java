/**
 *
 *  @author Molak Tomasz S26635
 *
 */

package zad1;


public interface Mapper<T, S> { // Uwaga: interfejs musi być sparametrtyzowany
   T map(S s);
}
