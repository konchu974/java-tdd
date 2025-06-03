package fr.afpa.converter.tool;



/**
 * Classe utilitaire permettant de passer des nombres d'une base à l'autre.
 * Base suportées:
 * - binaire
 * - décimale 
 * - hexadécimale
 */
public final class ConverterTool {

    static String[] binaires = {
            "0000", "0001", "0010", "0011",
            "0100", "0101", "0110", "0111",
            "1000", "1001", "1010", "1011",
            "1100", "1101", "1110", "1111"
    };

    static char[] hexadecimaux = {
            '0', '1', '2', '3',
            '4', '5', '6', '7',
            '8', '9', 'A', 'B',
            'C', 'D', 'E', 'F'
    };

    /**
     * Constructeur privé pour cacher celui déclaré par défaut en public.
     */
    private ConverterTool() {}

    /**
     * Convertit un nombre binaire (représentation sous forme de chaîne de
     * caractère) en sa représentation décimale.
     * 
     * @param binary Nombre binaire à traiter
     * @return Répresentation décimale du nombre, -1 si la conversion est impossible
     */
    public static int binaryToDecimal(String binary) {
        int result = 0;
        for (int i = 0; i < binary.length(); i++) {
            int bit = Integer.parseInt(binary.substring(i, i + 1), 2);
            result += bit * Math.pow(2, binary.length() - 1 - i);
        }

        return result;
    }

    /**
     * Convertit un nombre décimal en sa représentation binaire.
     * 
     * @param decimal Nombre décimal à traiter
     * @return Répresentation binaire du nombre
     */
    public static String decimalToBinary(int decimal) {
        String result = "";
        while (decimal > 0) {
            result += (decimal % 2);
            decimal /= 2;
        }
        return result;
    }

    /**
     * Convertit un nombre binaire (représentation sous forme de chaîne de
     * caractère) en sa représentation héxadécimale.
     * 
     * @param binary Nombre binaire à traiter
     * @return Répresentation héxadécimale du nombre
     */
    public static String binaryToHexadecimal(String binary) {
        String result = "";

        while (binary.length() % 4 != 0) {
        binary = "0" + binary ;
        }

        for (int i = 0; i < binary.length(); i+= 4) {
            int fin = Math.min(i + 4, binary.length());
            String sousChaine = binary.substring(i, fin);

            for (int j = 0; j < hexadecimaux.length; j++) {
                if (sousChaine.equals(binaires[j])) {
                    result += hexadecimaux[j];
                }

            }
        }


        return result;
    }

    /**
     * Convertit un nombre décimal en sa représentation héxadécimale.
     * 
     * @param decimal Nombre décimal à traiter
     * @return Répresentation binaire du nombre
     */
    public static String decimalToHexadecimal(int decimal) {
        String result = "";

        while (decimal > 0) {
            int remainder = decimal % 16;
            result = hexadecimaux[remainder] + result;
            decimal = decimal / 16;
        }

        return result;
    }

    /**
     * Convertit un nombre hexadécimal en sa représentation décimale.
     * 
     * @param hexadecimal Nombre décimal à traiter
     * @return Répresentation binaire du nombre
     */
    public static int hexadecimalToDecimal(String hexadecimal) {
        int result = Integer.parseInt(hexadecimal, 16);
        return result;
    }

    public static String hexadecimalToBinary(String hex) {
        String result = "";

        for (int i = 0; i < hex.length(); i++) {
            for (int j = 0; j < hexadecimaux.length; j++) {
                if ( hexadecimaux[j] == hex.charAt(i)) {
                    result += binaires[j];
                }
            }
        }
        return result;
    }

    /**
     * Vérifie si une chaîne de caractères en paramètre représente un nombre
     * hexadécimal
     * 
     * @param toCheck Chaîne à vérifier
     * @return true si la chaîne passée en paramètre contient des symboles
     *         hexadécimaux, faux sinon
     */
    public static boolean checkIfHexadecimal(String toCheck) {
        // TODO vérification par l'utilisation d'une REGEX
        return toCheck != null && toCheck.matches("^(0[xX])?[0-9a-fA-F]+$");
    }

    /**
     * Vérifie si une chaîne de caractères en paramètre représente un nombre entier
     * 
     * @param toCheck Chaîne à vérifier
     * @return true si la chaîne passée en paramètre contient des symboles
     *         hexadécimaux, faux sinon
     */
    public static boolean checkIfDecimal(String toCheck) {
        // TODO vérification par l'utilisation d'une REGEX
        return toCheck != null && toCheck.matches("^-?[0-9]+$");    }
}
