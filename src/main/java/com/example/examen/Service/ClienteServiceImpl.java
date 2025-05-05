package com.example.examen.Service;

import com.example.examen.Model.Cliente;
import com.example.examen.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listaClientes(){
        return clienteRepository.findAll();
    }

    @Override
    public void creacionCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    @Override
    public void editacionCliente(Integer id, Cliente cliente){
        Cliente oldCliente = clienteRepository.findById(id).orElseThrow();
        oldCliente.setNombres(cliente.getNombres());
        oldCliente.setApellidoPaterno(cliente.getApellidoPaterno());
        oldCliente.setApellidoMaterno(cliente.getApellidoMaterno());
        oldCliente.setFechaNacimiento(cliente.getFechaNacimiento());
        oldCliente.setSexo(cliente.getSexo());
        oldCliente.setDireccion(cliente.getDireccion());
        oldCliente.setCorreo(cliente.getCorreo());
        clienteRepository.save(oldCliente);
    }

    @Override
    @Transactional(readOnly = true)
    public void eliminacionCliente(Integer id){
        clienteRepository.eliminarCliente(id);
    }




}
