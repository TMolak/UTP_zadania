/**
 *
 *  @author Molak Tomasz S26635
 *
 */

package zad1;


import java.util.*;

public class Main {

  static List<String> getPricesInPLN(List<String> destinations, double xrate) {
    return ListCreator.collectFrom(destinations)
                       .when(s -> s.contains("WAW"))
                       .mapEvery( s -> {
                        String[] sTab = s.split(" ");
                        String s1 = sTab[1];
                        double price = Double.valueOf(sTab[2]);
                        price *= xrate;
                        int resultPrice = (int) price;
                        String result = "to " + s1 + " - price in PLN: " + resultPrice;
                        return result;
                       } );
  }

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
    List<String> result = getPricesInPLN(dest, ratePLNvsEUR);
    for (String r : result) System.out.println(r);
  }
}
