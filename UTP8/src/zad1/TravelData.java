package zad1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class TravelData {
    private File dir;

    public TravelData(File dir) {
        this.dir = dir;
    }

    public List<String> getOffersDescriptionsList(String loc, String dateFormat) {
        List<String> resultList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println("Processing file: " + file.getName());
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] splittedLine = line.split("\t");
                        Locale locale = Locale.forLanguageTag(splittedLine[0]);
                        String country = splittedLine[1];
                        Date startDate = simpleDateFormat.parse(splittedLine[2]);
                        Date endDate = simpleDateFormat.parse(splittedLine[3]);
                        String place = splittedLine[4];
                        double price = Double.parseDouble(splittedLine[5].replace(",", "").replace(".", ""));
                        String currency = splittedLine[6];

                        if (locale.toLanguageTag().equals(loc)) {
                            System.out.println("Adding offer: " + country + " " + startDate + " " + endDate + " " + place + " " + price + " " + currency);
                            resultList.add(
                                    country + " " +
                                            startDate + " " +
                                            endDate + " " +
                                            place + " " +
                                            price + " " +
                                            currency);
                        }
                    }
                } catch (FileNotFoundException | ParseException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }

        return resultList;
    }
}
