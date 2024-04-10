package fr.afpa.converter.view;

import fr.afpa.converter.tool.ConverterTool;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.stream.Stream;

/**
 * Layout principal de l'application
 */
public class ConverterPane extends StackPane {

    private static final String DECIMAL_TEXT_FIELD_ID = "decimalTextField";
    private static final String HEXADECIMAL_TEXT_FIELD_ID = "hexadecimalTextField";
    private static final String BINARY_TEXT_FIELD_ID = "binaryTextField";

    // Décaration des éléments graphiques de la vue
    private Label decimalLabel = new Label("Décimal");
    private Label binaryLabel = new Label("Binaire");
    private Label hexadecimalLabel = new Label("Hexadécimal");
    private TextField decimalTextField = new TextField();
    private TextField binaryTextField = new TextField();
    private TextField hexadecimalTextField = new TextField();

    public ConverterPane() {
        super();
        init();
    }

    /**
     * Méthode d'initialisation des éléments graphique de la vue
     */
    private void init() {
        // ajout d'un gestionnaire d'évènement pour la saisie utilisateur
        // DecimalTextFielEventHandler est une classe interne (voir plus bas)
        decimalTextField.setId(DECIMAL_TEXT_FIELD_ID);
        decimalTextField.setOnKeyTyped(new TextFieldEventHandler());

        hexadecimalTextField.setId(HEXADECIMAL_TEXT_FIELD_ID);
        hexadecimalTextField.setOnKeyTyped(new TextFieldEventHandler());

        binaryTextField.setId(BINARY_TEXT_FIELD_ID);
        binaryTextField.setOnKeyTyped(new TextFieldEventHandler());

        // création du layout grille pour la disposition des différents composants
        GridPane gridPane = new GridPane();
        // ajout du léger padding histoire d'être civilisé
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        // ajout de gap entre les éléments pour l'élégance
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // positionnement des éléments graphiques dans la grille
        gridPane.add(decimalLabel, 0, 0);
        gridPane.add(decimalTextField, 1, 0);
        gridPane.add(binaryLabel, 0, 1);
        gridPane.add(binaryTextField, 1, 1);
        gridPane.add(hexadecimalLabel, 0, 2);
        gridPane.add(hexadecimalTextField, 1, 2);

        this.getChildren().add(gridPane);
    }

    /**
     * Classe de gestion des évènements de saisie de texte sur le champ de texte gérant les décimaux
     */
    public class TextFieldEventHandler implements EventHandler<KeyEvent> {

        /**
         * Constructeur privé pour cacher celui déclaré par défaut en public.
         */
        private TextFieldEventHandler() {
        }

        /**
         * Méthode qui va gérer l'évènement de saisie de texte dans le champ de texte décimal
         */
        @Override
        public void handle(KeyEvent event) {
            TextField inputTextField = ((TextField) event.getSource());
            String input = inputTextField.getText();

            // gestion du champ vidé par l'utilisateur
            if (input.isEmpty()) {
                switch (inputTextField.getId()) {
                    case DECIMAL_TEXT_FIELD_ID:
                        this.clearTextFields(binaryTextField, hexadecimalTextField);
                        break;
                    case HEXADECIMAL_TEXT_FIELD_ID:
                        this.clearTextFields(binaryTextField, decimalTextField);
                        break;
                    default: // binary
                        this.clearTextFields(decimalTextField, hexadecimalTextField);
                }
            }

            // Traitement de l'information et màj des autres champs
            try {

                switch (inputTextField.getId()) {
                    case DECIMAL_TEXT_FIELD_ID:
                        this.handleDecimalConversion();
                        break;
                    case HEXADECIMAL_TEXT_FIELD_ID:
                        this.handleHexadecimalConversion();
                        break;
                    default: // binary
                        this.handleBinaryConversion();
                }
                
                inputTextField.setStyle("-fx-border-color: none;");
            } catch (NumberFormatException e) {
                // traitement de l'erreur si la chaîne entrée n'est pas exploitable
                // on vide les champs de textes
                clearTextFields();
                // et on met un peu de couleur !
                inputTextField.setStyle("-fx-border-color: red;");
            }
        }

        /**
         * Vide les champs de texte + réinitialisation de le style
         */
        private void clearTextFields(TextField... textFields) {
            Stream.of(textFields).forEach(textField -> {
                textField.setText("");
                textField.setStyle("-fx-border-color: none;");
            });
        }

        /**
         * Traite la conversion à partir d'un nombre décimal
         * @throws NumberFormatException
         */
        private void handleDecimalConversion() throws NumberFormatException {
            int value = Integer.parseInt(decimalTextField.getText());
                
            // conversion de la valeur rentrée par l'utilisateur
            String binary = ConverterTool.decimalToBinary(value);
            binaryTextField.setText(binary);
            String hexadecimal = ConverterTool.decimalToHexadecimal(value); 
            hexadecimalTextField.setText(hexadecimal);
        }

        /**
         * Traite la conversion à partir d'un nombre héxadecimal
         * @throws NumberFormatException
         */
        private void handleHexadecimalConversion() throws NumberFormatException {
            String hex = hexadecimalTextField.getText();
                
            // conversion de la valeur rentrée par l'utilisateur
            String binary = ConverterTool.hexadecimalToBinary(hex);
            binaryTextField.setText(binary);
            int decimal = ConverterTool.hexadecimalToDecimal(hex); 
            decimalTextField.setText(String.valueOf(decimal));
        }

        /**
         * Traite la conversion à partir d'un nombre binaire
         * @throws NumberFormatException
         */
        private void handleBinaryConversion() throws NumberFormatException {
            String bin = binaryTextField.getText();
                
            // conversion de la valeur rentrée par l'utilisateur
            int decimal = ConverterTool.binaryToDecimal(bin);
            decimalTextField.setText(String.valueOf(decimal));
            String hex = ConverterTool.binaryToHexadecimal(bin); 
            hexadecimalTextField.setText(hex);
        }
    }
}
