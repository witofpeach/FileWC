import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите относительный или абсолютный путь к файлу с текстом: ");

        String path = bufferedReader.readLine();

        try (Stream<String> fileStream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
            WordCounter wordCounter = new WordCounter(fileStream);
            wordCounter.printWordCount();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
