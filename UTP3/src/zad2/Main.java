/**
 * @author Molak Tomasz S26635
 */

package zad2;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

/*<--
 *  niezbędne importy
 */
public class Main {
    public static void main(String[] args) {

        Function<String, List<String>> flines = (file) -> {
            List<String> lines = new ArrayList<>();
            try {
                File newFile = new File(String.valueOf(Paths.get(file)));
                Scanner scan = new Scanner(newFile);
                while (scan.hasNextLine()) {
                    lines.add(scan.nextLine());
                }
                scan.close();
            } catch (FileNotFoundException e) {
                System.out.println("Plik nie istnieje!");
                e.printStackTrace();
            }
            return lines;
        };

        Function<List<String>, String> join = (line) -> (String.join("", line));

        Function<String, List<Integer>> collectInts = (line) -> {
            List<Integer> ints = new ArrayList<>();
            for (String s : line.replaceAll("[^0-9]", " ").trim().split(" ")) {
                if (s.length() > 0) {
                    try {
                        int num = Integer.parseInt(s);
                        ints.add(num);
                    } catch (NumberFormatException e) {
                    }
                }
            }
            return ints;
        };

        Function<List<Integer>, Integer> sum = (ints) -> {
            int suma = 0;
            for (int i : ints) {
                suma += i;
            }
            return suma;
        };
        /*<--
         *  definicja operacji w postaci lambda-wyrażeń:
         *  - flines - zwraca listę wierszy z pliku tekstowego
         *  - join - łączy napisy z listy (zwraca napis połączonych ze sobą elementów listy napisów)
         *  - collectInts - zwraca listę liczb całkowitych zawartych w napisie
         *  - sum - zwraca sumę elmentów listy liczb całkowitych
         */

        String fname = System.getProperty("user.home") + "/LamComFile.txt";
        InputConverter<String> fileConv = new InputConverter<>(fname);
        List<String> lines = fileConv.convertBy(flines);
        String text = fileConv.convertBy(flines, join);
        List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
        Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

        System.out.println(lines);
        System.out.println(text);
        System.out.println(ints);
        System.out.println(sumints);

        List<String> arglist = Arrays.asList(args);
        InputConverter<List<String>> slistConv = new InputConverter<>(arglist);
        sumints = slistConv.convertBy(join, collectInts, sum);
        System.out.println(sumints);

    }
}
