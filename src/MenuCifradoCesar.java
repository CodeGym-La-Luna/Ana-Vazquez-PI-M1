import java.util.InputMismatchException;
import java.util.Scanner;


public class MenuCifradoCesar {

    public void menuiniciar() {

        Scanner scanner = new Scanner(System.in);
        Cifrado cifrado = new Cifrado("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzüéáíóúñÑ ¿¡.,!?-_/0123456789²º".toCharArray());
        FileManager fileManager = new FileManager();
        Validador validador = new Validador();

        boolean ejecutar = true; //controla la ejecucion del ciclo menu.

        while (ejecutar) {
            //menu del usuario
            System.out.println("Seleccione una opción:");
            System.out.println("1. Cifrar texto");
            System.out.println("2. Descifrar texto con clave");
            System.out.println("3. Descifrar texto con brute force");
            System.out.println("4. Salir");

            int opcion = -1; //declara-inicializa la variable opcion que almacenara la opcion que elija el usuario.
            boolean validInput = false; //validInput: verifica si la entrada es válida.

            // posibles entradas inválidas
            while (!validInput) {
                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    validInput = true;
                } catch (InputMismatchException e) { // Muestra mensaje de error y limpia el buffer del Scanner.
                    System.out.println("Opción inválida. Ingrese un número entero.");
                    scanner.nextLine();  // Limpiar el buffer
                }
            }

            switch (opcion) {
                case 1:
                    // Cifrar texto
                    System.out.println("Ingrese la ruta del archivo a cifrar:");
                    //C:\Users\Isa Vaz\Documents\PROY1-CIFRADOCESAR\src\Encriptar.txt
                    String inputFilePath = scanner.nextLine();
                    if (!validador.isFileExists(inputFilePath)) {
                        System.out.println("El archivo no existe.");
                        break;

                    }

                    System.out.println("Ingrese la ruta para guardar el archivo cifrado:");
                    String encryptedFilePath = scanner.nextLine();

                    System.out.println("Ingrese la clave de cifrado (número entero):");
                    int desplazamiento = -1;
                    validInput = false;

                    // Manejar posible error al ingresar la clave
                    while (!validInput) {
                        try {
                            desplazamiento = scanner.nextInt();
                            if (!validador.isValidKey(desplazamiento, cifrado.getAlphabet())) {
                                System.out.println("Clave invalida.");
                                break;
                            }
                            validInput = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Clave inválida. Ingrese un número entero.");
                            scanner.nextLine();  // Limpiar el buffer
                        }
                    }

                    String textToEncrypt = fileManager.leerArchivo(inputFilePath);
                    String encryptedText = cifrado.encrypt(textToEncrypt, desplazamiento);
                    fileManager.escribirArchivoChannel(encryptedText, encryptedFilePath);
                    System.out.println("Texto cifrado guardado en: " + encryptedFilePath);
                    break;

                case 2:
                    // Descifrar texto con clave
                    System.out.println("Ingrese la ruta del archivo cifrado:");
                    String encryptedFilePathForDecryption = scanner.nextLine();
                    if (!validador.isFileExists(encryptedFilePathForDecryption)) {
                        System.out.println("El archivo no existe.");
                        break;
                    }

                    System.out.println("Ingrese la ruta para guardar el archivo descifrado:");
                    String decryptedFilePath = scanner.nextLine();

                    System.out.println("Ingrese la clave de descifrado (número entero):");
                    int cambioaDescifrado = -1;
                    validInput = false;

                    // Manejar posible error al ingresar la clave
                    while (!validInput) {
                        try {
                            cambioaDescifrado= scanner.nextInt();
                            if (!validador.isValidKey(cambioaDescifrado, cifrado.getAlphabet())) {
                                System.out.println("Clave inválida.");
                                break;
                            }
                            validInput = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Clave inválida. Ingrese un número entero.");
                            scanner.nextLine();  // Limpiar el buffer
                        }
                    }

                    String textoaDescifrar = fileManager.leerArchivo(encryptedFilePathForDecryption);
                    String descifradoTx = cifrado.decrypt(textoaDescifrar, cambioaDescifrado);
                    fileManager.escribirArchivoChannel(descifradoTx, decryptedFilePath);
                    System.out.println("Texto descifrado guardado en: " + decryptedFilePath);
                    break;

                case 3:
                    // Descifrado con brute force
                    System.out.println("Ingrese la ruta del archivo cifrado:");
                    String encryptedFileForBruteForce = scanner.nextLine();
                    if (!validador.isFileExists(encryptedFileForBruteForce)) {
                        System.out.println("El archivo no existe.");
                        break;
                    }

                    System.out.println("Ingrese la ruta para guardar el archivo descifrado:");
                    String bruteForceOutputFile = scanner.nextLine();

                    String textoCifrado = fileManager.leerArchivo(encryptedFileForBruteForce);
                    BruteForce bruteForce = new BruteForce();
                    String bruteForcedDecryptedText = bruteForce.decryptByBruteForce(textoCifrado, cifrado.getAlphabet());
                    fileManager.escribirArchivoChannel(bruteForcedDecryptedText, bruteForceOutputFile);
                    System.out.println("Texto descifrado por fuerza bruta guardado en: " + bruteForceOutputFile);
                    break;

                case 4:
                    // Salir
                    ejecutar = false;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }


        }

        scanner.close();
    }
}


