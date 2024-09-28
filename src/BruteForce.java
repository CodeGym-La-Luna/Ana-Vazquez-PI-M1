public class BruteForce {


    // Descifrar el texto cifrado-fuerza bruta
    public String decryptByBruteForce(String encryptedText, char[] alphabet) {
        Cifrado cifrado = new Cifrado(alphabet);
        StringBuilder combinaciones = new StringBuilder();

        // Probar todas las claves posibles
        for (int i = 0; i < alphabet.length; i++) {
            String combinacion = cifrado.decrypt(encryptedText, i);
           combinaciones.append("Desplazamiento").append(i).append(": ").append(combinacion).append("\n");
        }

        // Devolver todos los intentos para revision
        return combinaciones.toString();
    }
}