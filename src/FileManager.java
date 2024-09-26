import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class FileManager {

    //Recibe la ruta del archivo como parametro String (filePath)
    //Lee el contenido de un archivo y lo devuelve como una cadena de texto (String).

    public String leerArchivo(String filePath) {

        Path path = Path.of(filePath);
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate((int) Files.size(path)); //Files.size(Path path):devuelve el tamaño del archivo en bytes
            fileChannel.read(buffer);
            buffer.flip(); //prepara el bufer para ser leido
            return new String(buffer.array());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Escribe un texto (txtcontenido) en un archivo donde la ruta es especificada (filePath),
    // (utiliza la clase FileChannel de Java NIO).
    // void: No devuelve ningún valor, solo realiza una acción (escribir en un archivo).

    public void escribirArchivoChannel(String txtcontenido, String filePath) {

        Path path = Path.of(filePath);
        ByteBuffer buffer = ByteBuffer.wrap(txtcontenido.getBytes());
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            fileChannel.write(buffer);//escribe lo que se guardo en el buffer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}