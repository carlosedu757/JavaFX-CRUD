package com.mycompany.projetoprincipal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cadastro de Clientes");

        // Criação dos componentes da interface gráfica
        Label nomeLabel = new Label("Nome:");
        TextField nomeField = new TextField();

        Label idadeLabel = new Label("Idade:");
        TextField idadeField = new TextField();

        Label enderecoLabel = new Label("Endereço:");
        TextArea enderecoArea = new TextArea();

        Label descontoLabel = new Label("Desconto:");
        CheckBox descontoCheckBox = new CheckBox();

        Label estadoCivilLabel = new Label("Estado Civil:");
        ComboBox<String> estadoCivilComboBox = new ComboBox<>();
        estadoCivilComboBox.getItems().addAll("Solteiro(a)", "Casado(a)", "Divorciado(a)", "Viúvo(a)");

        Label generoLabel = new Label("Gênero:");
        ToggleGroup generoToggleGroup = new ToggleGroup();
        RadioButton masculinoRadioButton = new RadioButton("Masculino");
        RadioButton femininoRadioButton = new RadioButton("Feminino");
        masculinoRadioButton.setToggleGroup(generoToggleGroup);
        femininoRadioButton.setToggleGroup(generoToggleGroup);

        Label alturaLabel = new Label("Altura:");
        Slider alturaSlider = new Slider(0, 300, 150);

        Label pesoLabel = new Label("Peso:");
        Spinner<Integer> pesoSpinner = new Spinner<>(0, 500, 70);

        Label receberEmailsLabel = new Label("Receber Emails:");
        ToggleButton receberEmailsToggleButton = new ToggleButton("Sim");

        Button cadastrarButton = new Button("Cadastrar");
        cadastrarButton.setOnAction(event -> {
            // Aqui você pode implementar a lógica para cadastrar o cliente com os dados inseridos nos campos de entrada
            Cliente cliente = new Cliente();
            cliente.listarClientes();
        });

        // Layout da interface gráfica
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.add(nomeLabel, 0, 0);
        gridPane.add(nomeField, 1, 0);
        gridPane.add(idadeLabel, 0, 1);
        gridPane.add(idadeField, 1, 1);
        gridPane.add(enderecoLabel, 0, 2);
        gridPane.add(enderecoArea, 1, 2);
        gridPane.add(descontoLabel, 0, 3);
        gridPane.add(descontoCheckBox, 1, 3);
        gridPane.add(estadoCivilLabel, 0, 4);
        gridPane.add(estadoCivilComboBox, 1, 4);
        gridPane.add(generoLabel, 0, 5);
        gridPane.add(masculinoRadioButton, 1, 5);
        gridPane.add(femininoRadioButton, 2, 5);
        gridPane.add(alturaLabel, 0, 6);
        gridPane.add(alturaSlider, 1, 6);
        gridPane.add(pesoLabel, 0, 7);
        gridPane.add(pesoSpinner, 1, 7);
        gridPane.add(receberEmailsLabel, 0, 8);
        gridPane.add(receberEmailsToggleButton, 1, 8);

        HBox hbox = new HBox(10);
        hbox.getChildren().add(cadastrarButton);

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(gridPane, hbox);

        Scene scene = new Scene(vbox, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}