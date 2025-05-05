package com.example.examen.Controller;

import com.example.examen.DTO.ClienteDTO;
import com.example.examen.Model.Cliente;
import com.example.examen.Service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/cliente")
    public ResponseEntity<List<ClienteDTO>> listaClientes(){
        List<Cliente> pe = clienteService.listaClientes();
        return new ResponseEntity<>(pe.stream().map(this::convertToDto).collect(Collectors.toList()), HttpStatus.OK);
    }



    @PostMapping("/cliente")
    public ResponseEntity<?> crearCliente(@Valid @RequestBody ClienteDTO clienteDTO){
        clienteService.creacionCliente(convertToEntity(clienteDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<?> editarCliente(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable("id") Integer id){
        clienteService.editacionCliente(id,convertToEntity(clienteDTO));
        return ResponseEntity.ok("updated");
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable("id") Integer id){
        clienteService.eliminacionCliente(id);
        return ResponseEntity.ok("deleted");
    }


    private ClienteDTO convertToDto(Cliente cliente) {
        ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        return clienteDTO;
    }

    private Cliente convertToEntity(ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        return cliente;
    }

}
