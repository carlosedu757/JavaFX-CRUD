package com.mycompany.projetoprincipal;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    private TableView<Cliente> tabelaClientes;
    private TextField campoNome;
    private TextField campoEmail;
    private ObservableList<Cliente> listaClientes;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CRUD de Clientes");

        tabelaClientes = new TableView<>();
        listaClientes = FXCollections.observableArrayList();

        TableColumn<Cliente, Integer> colunaId = new TableColumn<>("ID");
        colunaId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());

        TableColumn<Cliente, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());

        TableColumn<Cliente, String> colunaEmail = new TableColumn<>("Email");
        colunaEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        tabelaClientes.getColumns().add(colunaId);
        tabelaClientes.getColumns().add(colunaNome);
        tabelaClientes.getColumns().add(colunaEmail);

        tabelaClientes.setItems(listaClientes);

        Button btnAdicionar = new Button("Adicionar");
        btnAdicionar.setOnAction(event -> adicionarCliente());

        Button btnEditar = new Button("Editar");
        btnEditar.setOnAction(event -> editarCliente());

        Button btnRemover = new Button("Remover");
        btnRemover.setOnAction(event -> removerCliente());

        campoNome = new TextField();
        campoNome.setPromptText("Nome");

        campoEmail = new TextField();
        campoEmail.setPromptText("Email");

        VBox vbox = new VBox();
        vbox.getChildren().addAll(tabelaClientes, campoNome, campoEmail, btnAdicionar, btnEditar, btnRemover);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void adicionarCliente() {
        String nome = campoNome.getText();
        String email = campoEmail.getText();

        if (!nome.isEmpty() && !email.isEmpty()) {
            Cliente cliente = new Cliente(listaClientes.size() + 1, nome, email);
            listaClientes.add(cliente);

            campoNome.clear();
            campoEmail.clear();
        }
    }

    private void editarCliente() {
        Cliente clienteSelecionado = tabelaClientes.getSelectionModel().getSelectedItem();

        if (clienteSelecionado != null) {
            String novoNome = campoNome.getText();
            String novoEmail = campoEmail.getText();

            if (!novoNome.isEmpty() && !novoEmail.isEmpty()) {
                clienteSelecionado.setNome(novoNome);
                clienteSelecionado.setEmail(novoEmail);

                tabelaClientes.refresh();
                campoNome.clear();
                campoEmail.clear();
            }
        }
    }

    private void removerCliente() {
        Cliente clienteSelecionado = tabelaClientes.getSelectionModel().getSelectedItem();

        if (clienteSelecionado != null) {
            listaClientes.remove(clienteSelecionado);
            tabelaClientes.refresh();
            campoNome.clear();
            campoEmail.clear();
        }
    }
}
