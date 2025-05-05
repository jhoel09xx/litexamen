package com.example.examen.Service;

import com.example.examen.Model.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> listaClientes();

    void creacionCliente(Cliente cliente);

    void editacionCliente(Integer id, Cliente cliente);

    void eliminacionCliente(Integer id);


}
