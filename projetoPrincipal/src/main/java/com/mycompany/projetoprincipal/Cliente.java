package com.mycompany.projetoprincipal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cliente {

    private final ObservableList<Cliente> clientes;

    public Cliente() {
        // Inicializar a lista de clientes (você pode substituir por um banco de dados real se preferir)
        clientes = FXCollections.observableArrayList();
    }

    public void criarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public ObservableList<Cliente> listarClientes() {
        return clientes;
    }

    public void atualizarCliente(Cliente cliente) {
        // Atualizar o cliente na lista ou no banco de dados
        // Implemente a lógica de atualização aqui
    }

    public void deletarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }
}
