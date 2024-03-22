/**
 * @author Molak Tomasz S26635
 */

package zad1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        BlockingQueue<Towar> blockingQueue = new LinkedBlockingQueue<>();
        AtomicBoolean finished = new AtomicBoolean(false);

        executorService.submit(() -> {
            try {
                File file = new File("../Towary.txt");
                Scanner scanner = new Scanner(file);
                int counter = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] splittedLine = line.split(" ");
                    int id_towaru = Integer.parseInt(splittedLine[0]);
                    int waga = Integer.parseInt(splittedLine[1]);

                    Towar towar = new Towar(id_towaru, waga);
                    blockingQueue.put(towar);
                    counter++;

                    if (counter % 200 == 0) {
                        System.out.println("utworzono " + counter + " obiektów");
                    }
                }
                finished.set(true);
            } catch (FileNotFoundException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {

            int totalWeight = 0;
            int counter = 0;
            while (true) {
                try {
                    Towar towar = blockingQueue.take();
                    counter++;
                    totalWeight += towar.getWaga();
                    if (counter % 100 == 0) {
                        System.out.println("policzono wagę " + counter + " towarów");
                    }
                    if (blockingQueue.isEmpty() && finished.get()) {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Sumaryczna waga wszystkich towarów: " + totalWeight);
        });
        executorService.shutdown();
    }
}
