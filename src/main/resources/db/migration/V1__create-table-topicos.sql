create table topicos(

    id bigint not null auto_increment,
    titulo varchar(25) not null unique,
    mensaje varchar(255) not null unique,
    fecha datetime not null,
    status varchar(20) not null,
    autor varchar(20) not null,
    nombre_curso varchar(30) not null,
    categoria varchar(20) not null,

    primary key(id)
);