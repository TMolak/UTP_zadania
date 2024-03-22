package zajecia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//FileChannel channel = new FileInputStream("test.txt").getChannel();
        try (
                FileChannel inputChannel = FileChannel.open(Paths.get("test.txt"), StandardOpenOption.READ);
                FileChannel outputChannel = FileChannel.open(Paths.get("output_test.txt"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
        ){
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
            System.out.println(byteBuffer);
            inputChannel.read(byteBuffer);
            System.out.println(byteBuffer);
/* byteBuffer.limit(byteBuffer.position());
byteBuffer.position(0);*/
            byteBuffer.flip();
            CharBuffer decoded = StandardCharsets.UTF_8.decode(byteBuffer);
            System.out.println(decoded);
            System.out.println(byteBuffer);
//byteBuffer.clear();
            byteBuffer.flip();
            System.out.println(byteBuffer);
            System.out.println(outputChannel.write(Charset.forName("Cp1250").encode(decoded)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
