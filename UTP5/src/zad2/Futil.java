package zad2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Futil {
    public static void processDir(String dirName, String resultFileName) {
        Path startDir = Paths.get(dirName);
        Path resultFilePath = Paths.get(resultFileName);
        try{
            Files.walkFileTree(startDir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toString().endsWith(".txt")) {
                        Files.readAllLines(file, Charset.forName("Cp1250"))
                                .forEach(line ->
                                {
                                    try (FileOutputStream fos = new FileOutputStream(resultFilePath.toFile(), true)) {
                                        fos.write(line.getBytes(StandardCharsets.UTF_8));
                                        fos.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
