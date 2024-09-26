public class BruteForce {

    // Descifrar el texto cifrado-fuerza bruta
    public String decryptByBruteForce(String encryptedText, char[] alphabet) {
        Cifrado cifrado = new Cifrado(alphabet);
        StringBuilder allAttempts = new StringBuilder();

        // Probar todas las claves posibles
        for (int i = 1; i < alphabet.length; i++) {
            String attempt = cifrado.decrypt(encryptedText, i);
            allAttempts.append("Clave ").append(i).append(": ").append(attempt).append("\n");
        }

        // Devolver todos los intentos para revision
        return allAttempts.toString();
    }
}