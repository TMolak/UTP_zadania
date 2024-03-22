/**
 *
 *  @author Molak Tomasz S26635
 *
 */

package zad2;


/*<-- niezbędne importy */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    // Lista destynacji: port_wylotu port_przylotu cena_EUR
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = dest
            .stream()
            .filter(info -> info.contains("WAW"))
            .map(info -> {
              String[] infoTab = info.split(" ");
              String s1 = infoTab[1];
              double priceAfter = Double.valueOf(infoTab[2])*ratePLNvsEUR;
              int resultPrice = (int) priceAfter;
              String resultString = "to " + s1 + " - price in PLN: " + resultPrice;
              return resultString;
            } )
            .collect(Collectors.toList());
    /*<-- tu należy dopisać fragment
     * przy czym nie wolno używać żadnych własnych klas, jak np. ListCreator
     * ani też żadnych własnych interfejsów
     * Podpowiedź: należy użyć strumieni
     */

    for (String r : result) System.out.println(r);
  }
}
