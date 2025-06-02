package fr.afpa.converter.tool;
                                                                                      
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/***
 * Classe regroupant les tests à compléter.
 * 
 * Il vous est demandé de la compléter en suivant un approche TDD - Test Driven Development
 * 
 * Marche à suivre pour suivre le cycle "Rouge-Vert-Refactor" :
 * 1. Focalisez vous sur 1 fonction (par exemple "testHexadecimalToDecimal")
 * 2. Construisez un jeu de test complet (par exemple une liste de nombres à héxadécimaux à convertir)
 * 3. Ajoutez UNE SEULE assertion qui vérifie un TEST INDIVIDUEL
 * 4. Développez la fonction associée pour qu'elle retourne le bon résultat (that's tour "baby step")
 * 5. Ajoutez UNE AUTRE assertion
 * 6. Vérifiez si le test passe, développez la fonction pour qu'elle retourne le bon résultat
 * 7. Ainsi de suite jusqu'à ce que votre jeu de test soit couvert.
 * 
 * Pour certaines de ces fonctions le jeu de test vous est donné.
 * Pour d'autre, il vous faudra le créer.
 */
class ConverterToolTest {

    @DisplayName("Conversion des nombres binaires en décimaux")
    @Test
    void testBinaryToDecimal() {

        String bin1 = "10";

        // 1. Test de la première donnée de test
        assertEquals(2, ConverterTool.binaryToDecimal(bin1));

        // 2. Test d'un autre donnée de test
        String bin2 = "11";
        assertEquals(3, ConverterTool.binaryToDecimal(bin2));
        // ...

        // Bien faire attention de bien penser aux erreurs dans la conception du jeu de test
    }

    @DisplayName("Conversion des nombres décimaux en binaire")
    @Test
    void testDecimalToBinary() {
        // TODO : compléter le test

        int dec1 = 45;

        assertEquals("101101", ConverterTool.decimalToBinary(dec1));
    }

    @DisplayName("Vérification de la nature hexadécimale d'une chaîne de caractère")
    @Test
    void testIfHexadecimal() {
        assertTrue(ConverterTool.checkIfHexadecimal("1A3F"));
        assertTrue(ConverterTool.checkIfHexadecimal("abcdef"));
        assertFalse(ConverterTool.checkIfHexadecimal("1G3F"));
    }

    @DisplayName("Vérification de la nature décimale d'une chaîne de caractère")
    @Test
    void testIfDecimal() {
        assertFalse(ConverterTool.checkIfDecimal("1A3F"));
        assertTrue(ConverterTool.checkIfDecimal("12838"));
        assertTrue(ConverterTool.checkIfDecimal("1929"));
    }



    // TODO : ajouter les fonctions de test pour chacune de celles qui sont utilisées dans l'application

    @DisplayName("Conversion des nombres binaire en hexa")
    @Test
    void binaryToHexadecimal() {

        String bin1 = "11011011";

        assertEquals("DB", ConverterTool.binaryToHexadecimal(bin1));

    }

    @DisplayName("Conversion des nombres decimaux en hexa")
    @Test
    void decimalToHexadecimal() {

        int dec1 = 255;

        assertEquals("FF", ConverterTool.decimalToHexadecimal(dec1));

    }
    @DisplayName("Conversion hexadécimal vers décimal")
    @Test
    void hexadecimalToDecimal() {
        assertEquals(255, ConverterTool.hexadecimalToDecimal("FF"));
        assertEquals(16, ConverterTool.hexadecimalToDecimal("10"));
        assertEquals(0, ConverterTool.hexadecimalToDecimal("0"));
    }

    @DisplayName("Conversion hexadécimal vers binaire")
    @Test
    void hexadecimalToBinary() {
        assertEquals("11011011", ConverterTool.hexadecimalToBinary("DB"));
        assertEquals("00000000", ConverterTool.hexadecimalToBinary("00"));
        assertEquals("1111", ConverterTool.hexadecimalToBinary("F"));
    }


}
