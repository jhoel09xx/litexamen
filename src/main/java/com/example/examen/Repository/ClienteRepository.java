package com.example.examen.Repository;

import com.example.examen.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    @Transactional
    @Procedure(name = "Cliente.eliminarCliente")
    void eliminarCliente(@Param("id") Integer id);

}
