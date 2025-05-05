# litexamen
examen de lit consulting

//sql server 

create database examen;
use examen;
create table dbo.cliente(
id_cliente int primary key identity(1,1),
nombres varchar(200) not null,
apellido_paterno varchar(100) not null,
apellido_materno varchar(100) not null,
fecha_nacimiento date not null,
sexo int not null,
direccion varchar(250) not null,
correo varchar(150) not null,
);

create or alter procedure dbo.eliminar_cliente
@id AS INT
AS
BEGIN
	delete from dbo.cliente where id_cliente= @id;
END;
GO
