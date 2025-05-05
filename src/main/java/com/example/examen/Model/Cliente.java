package com.example.examen.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Solo se permiten letras")
    @Column(name = "nombres")
    private String nombres;

    @NotBlank
    @Column(name = "apellido_paterno")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Solo se permiten letras")
    private String apellidoPaterno;

    @NotBlank
    @Column(name = "apellido-Materno")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Solo se permiten letras")
    private String apellidoMaterno;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "sexo")
    private Integer sexo;

    @NotBlank
    @Column(name = "direccion")
    private String direcion;

    @NotBlank
    @Column(name = "correo")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Correo tiene que ser valido")
    private String correo;

}
