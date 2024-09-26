public class Cifrado {
    private char[] alphabet;

    public Cifrado(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public char[] getAlphabet() {
        return alphabet;
    }

    // Cifrado de texto
    public String encrypt(String text, int shift) {
        return desplazarTexto(text, shift);
    }

    // Decifrar texto
    public String decrypt(String text, int shift) {
        return desplazarTexto(text, -shift);
    }

    // Desplazamiento de texto
    private String desplazarTexto(String texto, int desplazar) {
        StringBuilder result = new StringBuilder();
        int alphabetLength = alphabet.length;

        for (char c : texto.toCharArray()) {
            int index = findIndex(c);
            if (index != -1) {  //Si el carácter existe en el alfabeto calcula el nuevo índice desplazado.
                int shiftedIndex = (index + desplazar + alphabetLength) % alphabetLength;
                result.append(alphabet[shiftedIndex]);
            } else {
                result.append(c);  //Si el carácter no está en el alfabeto, se deja igual
            }
        }

        return result.toString();
    }

    // Econtrar la posición de un carácter en el alfabeto
    private int findIndex(char c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) {
                return i;
            }
        }
        return -1;  // Carácter no encontrado
    }
}