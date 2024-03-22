/**
 * @author Molak Tomasz S26635
 */

package zad2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CustomersPurchaseSortFind {
    private List<Purchase> cart = new ArrayList<>();

    public void readFile(String path) {
        File file = new File(String.valueOf(path));
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitedLine = line.split(";");
                String id = splitedLine[0];
                String[] fullName = splitedLine[1].split(" ");
                String product = splitedLine[2];
                Double price = Double.valueOf(splitedLine[3]);
                Double quantity = Double.valueOf(splitedLine[4]);

                Purchase purchase = new Purchase(id, fullName[0], fullName[1], product, price, quantity);
                cart.add(purchase);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void showSortedBy(String sortBy) {
        List<Purchase> sortedCart = new ArrayList<>();
        sortedCart.addAll(cart);
        if (sortBy.equals("Nazwiska")) {
            sortedCart.sort(Comparator.comparing((Purchase p) -> p.getName())
                    .thenComparing(p -> p.getId()));

            System.out.println("Nazwiska");
            sortedCart.forEach((c) -> System.out.println(c));
            System.out.println();
        } else if (sortBy.equals("Koszty")){
            sortedCart.sort(Comparator.comparing((Purchase p) -> -p.getPrice() * p.getQuantity())
                    .thenComparing(p -> p.getId()));

            System.out.println("Koszty");
            sortedCart.forEach(c -> System.out.println(c + " (koszt: " + c.getPrice() * c.getQuantity() + ")"));
            System.out.println();
        } else {
            System.err.println("Niedozwolona operacja!");
        }
    }



    public void showPurchaseFor(String id) {
        System.out.println("Klient "+ id);
        cart.stream()
                .filter(p -> p.getId().equals(id))
                .forEach(System.out::println);
        System.out.println();
    }

}
