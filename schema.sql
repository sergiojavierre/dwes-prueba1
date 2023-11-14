create database planificador;

use planificador;

create table proyectos (
	id int unsigned primary key AUTO_INCREMENT,
    nombre varchar(255)
);

create table especialidades(
	codigo varchar(5) primary key,
    nombre varchar(255)
);

create table especialistas(
	id int unsigned primary key AUTO_INCREMENT,
    nombre varchar(255),
    especialidad varchar(5),
    foreign key (especialidad) references especialidades(codigo)
);

create table tareas(
	codigo varchar(5) primary key,
    nombre varchar(255),
    proyecto int unsigned,
    especialidad varchar(5),
    especialista int unsigned,
    foreign key (proyecto) references proyectos(id),
    foreign key (especialidad) references especialidades(codigo),
    foreign key (especialista) references especialistas(id)
);