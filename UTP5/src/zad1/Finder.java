/**
 * @author Molak Tomasz S26635
 */

package zad1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {

    private String fname;

    public Finder(String fname) {
        this.fname = fname;
    }

    public int getIfCount() throws IOException {
        int ifCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {
            String line;
        }

        return ifCount;
    }


    public int getStringCount(String s) throws IOException {
        int stringCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(s)) {
                    stringCount += countOccurrences(line, s);
                }
            }
        }

        return stringCount;
    }

    private int countOccurrences(String line, String target) {
        int count = 0;
        int index = line.indexOf(target);
        while (index != -1) {
            count++;
            index = line.indexOf(target, index + 1);
        }
        return count;
    }
}
