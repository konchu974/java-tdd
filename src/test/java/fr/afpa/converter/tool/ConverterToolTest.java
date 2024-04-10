package fr.afpa.converter.tool;
                                                                                      
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        // ...

        // Bien faire attention de bien penser aux erreurs dans la conception du jeu de test
    }

    @DisplayName("Conversion des nombres décimaux en binaire")
    @Test
    void testDecimalToBinary() {
        // TODO : compléter le test
    }
    
    @DisplayName("Vérification de la nature hexadécimale d'une chaîne de caractère")
    @Test
    void testIfHexadecimal() {
        
        // TODO : compléter le test
    }

    // TODO : ajouter les fonctions de test pour chacune de celles qui sont utilisées dans l'application
}
