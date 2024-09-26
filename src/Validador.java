import java.nio.file.*;

public class Validador {


    public boolean isValidKey(int key, char[] alphabet) {
        return key >= 0 && key < alphabet.length;
    }

    public boolean isFileExists(String filePath) {
        return Files.exists(Path.of(filePath));
    }
}
