--CREATE DATABASE Consultorio


Create table tb_cliente(
IDCliente int Primary key,
Nombre varchar(40) not null,
Apellido varchar(20)not null,
IDLocalidad varchar(40)not null,
Telefono varchar(40) not null,
TipoDni varchar(5) not null,
NroDni varchar(40) not null
);


Create table tb_provincia(
IDProvincia int Primary key,
Nombre varchar(50) not null
);

Create table tb_localidad(
IDLocalidad int Primary Key,
Nombre varchar(50) not null,
IDProvincia int,
Foreign Key (IDProvincia) references TB_Provincia(IDProvincia) 
); 

Create Table tb_rol(
IDRol  int primary key,
Descripcion varchar(50) not null
);

Create Table tb_rol_Usuario(
IDUsuario_rol int primary key,
Fecha_creacion date not null,
Fecha_modificacion date,
IDRol int ,
Foreign Key (IDRol) references TB_Rol(IDRol) 
);


Create Table tb_usuario(
IDUsuario int primary Key,
Nombre varchar(50) not null,
Apellido varchar(50) not null,
IDUsuario_rol int ,
IDRol  int,
Foreign Key (IDUsuario_rol) references TB_rol_Usuario(IDUsuario_rol),
Pasword varchar(10),
Foreign Key (IDRol) references TB_Rol(IDRol)
);



Create Table tb_especialidad(
IDEspecialidad Int Primary Key,
Descripcion varchar(100) not null
);

Create Table tb_kinesiologo(
IDMatricula int Primary key,
Nombre varchar(50) not null,
Apellido varchar(50) not null,
IDEspecialidad int ,
Foreign Key (IDEspecialidad) references TB_Especialidad(IDEspecialidad) 
);


Create Table tb_turno(
IDCliente int,
Foreign Key (IDCliente) references TB_Cliente(IDCliente) ,
IDEspecialidad int ,
Foreign Key (IDEspecialidad) references TB_Especialidad(IDEspecialidad),
Fecha timestamp not null,
IDMatricula int ,
Foreign Key (IDMatricula) references TB_Kinesiologo(IDMatricula) ,
IDUsuario int ,
Foreign Key (IDUsuario) references TB_Usuario(IDUsuario)
); 

commit;



