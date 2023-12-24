drop database if exists clientes_proyectos_empleados_2023;
create database if not exists clientes_proyectos_empleados_2023;
use clientes_proyectos_empleados_2023;

create table clientes (
cif varchar(10) not null primary key,
nombre varchar(20) not null,
apellidos varchar(45) not null,
domicilio varchar(100),
facturacion_anual dec (15,2),
numero_empleados int
);
create table departamentos (
id_depar int primary key,
nombre varchar(45) not null,
direccion varchar(100)
);
create table perfiles (
id_perfil int not null auto_increment primary key,
nombre varchar(20)
);
create table empleados (
id_empl int not null auto_increment primary key,
nombre varchar(20) not null,
apellidos varchar(45) not null,
sexo char(1) not null,
email varchar(100) not null unique,
password varchar(45) not null,
salario dec (9,2),
fecha_ingreso date,
fecha_nacimiento date,
id_perfil int not null,
id_depar int not null,
check(sexo in('H','h','M','m')),
foreign key(id_depar) references departamentos(id_depar),
foreign key(id_perfil) references perfiles (id_perfil)
);
create table proyectos(
id_proyecto varchar(10) not null primary key,
descripcion varchar(45) not null,
fecha_inicio date,
fecha_fin_previsto date,
fecha_fin_real date,
venta_previsto dec(11,2),
costes_previsto dec(11,2),
coste_real dec (11,2),
estado varchar(15),
jefe_proyecto int,
cif varchar(10) not null,
foreign key(cif) references clientes(cif),
foreign key(jefe_proyecto) references empleados(id_empl)
);
create table proyecto_con_empleados(
numero_orden int auto_increment primary key,
id_proyecto varchar(10) not null,
id_empl int not null,
horas_asignadas int not null,
fecha_incorporacion date,
foreign key(id_proyecto) references proyectos(id_proyecto),
foreign key(id_empl) references empleados(id_empl)
);
create table facturas(
id_factura varchar(15) not null primary key,
descripcion varchar(45) not null,
id_proyecto varchar(10) not null,
foreign key(id_proyecto) references proyectos(id_proyecto)
);

INSERT INTO clientes (cif, nombre, apellidos, domicilio, facturacion_anual, numero_empleados) values
    ('A22222222', 'Carlos', 'March', 'Madrid', '12000000', '1500'),
    ('B33333333', 'Sara', 'Varas', 'Sevilla', '1500000', '345');
insert into departamentos  values
    (10,'Gestion Personas','Madrid'),
    (20,'Software','Madrid'),
    (30,'Hardware','Madrid'),
    (40,'Financiero','Sevilla');
insert into perfiles (nombre) values
    ('Control de Gestion'), ('Jefe de Proyecto'), ('Operativo'),('Recusos Humanos');
INSERT INTO empleados VALUES 
    ('100', 'esteban', 'Diaz', 'H', 'ediaz@tt.com', 'esteban',90000, '1990-01-12', '1977-02-12', 4, 10),
    ('101', 'Sara', 'Hernandez', 'M', 'shernandez@tt.com','sara', '45000', '2005-07-07', '1987-05-15', 4, 10),
    ('114', 'Rafael', 'Raphaelly', 'H',  'rraphaelly@tt.com','rafael', '78000', '2005-09-07', '1977-02-18', 2, 20),
    ('115', 'Carlos', 'Koo', 'H', 'ckoo@tt.com','carlos', '33000', '2015-09-07', '1983-02-04', 3, 20),
	('116', 'Carmen', 'Baida', 'M',  'cbaida@tt.com','carmen', '32000', '2015-09-08', '1983-12-04', 3, 20),
    ('117', 'Alejandro', 'Himuro', 'H', 'ahimuro@tt.com','alejandro', '25000', '2015-09-09', '1984-12-04', 3, 20),
    ('118', 'Eva', 'Colmenares', 'M', 'ecolmenares@tt.com','eva', '25000', '2015-09-09', '1984-12-04', 3, 20),
    ('119', 'Eva', 'Tobias','M',  'etobias@tt.com','eva', '25000', '2015-09-09', '1984-12-04', 3, 20),
    ('120', 'Raquel', 'Oliva', 'M', 'roliva@tt.com','raquel', '38000', '2015-09-09', '1982-04-21', 1, 40);
INSERT INTO proyectos (id_proyecto, descripcion, fecha_inicio, fecha_fin_previsto, fecha_fin_real, venta_previsto, costes_previsto, coste_real, estado, jefe_proyecto, cif) values
('FOR2020001', 'Formacion de habilidades directivas', '2020-01-15', '2020-07-31', '2020-07-31', '50000', '30000', '315000', 'TERMINADO', '114', 'A22222222'),
('FOR2021001', 'Formacion de jefes de proyecto', '2021-09-15', '2021-12-31', '2021-12-10', '50000', '30000', null, 'ACTIVO', '114', 'A22222222'),
('FOR2021002', 'Formacion de jefes de proyecto', '2021-09-15', '2021-12-31', '2022-01-08', '50000', '30000', null, 'ACTIVO', '114', 'B33333333'),
('FOR2021003', 'Formacion de habilidades directivas', '2022-01-01', '2022-08-31', '2022-06-30', '70000', '40000', '50000', 'TERMINADO', '115', 'B33333333');
INSERT INTO proyecto_con_empleados (`numero_orden`, `id_proyecto`, `id_empl`, `horas_asignadas`, `fecha_incorporacion`) VALUES
    ('1', 'FOR2020001', '115', '45', '2020-01-16'),
    ('2', 'FOR2020001', '116', '30', '2020-01-17'),
    ('3', 'FOR2021001', '117', '54', '2021-10-11'),
    ('4', 'FOR2021001', '118', '100', '2021-10-14');
INSERT INTO facturas (`id_factura`, `descripcion`, `id_proyecto`) VALUES
    ('F2020001', 'Formacion a cliente 1', 'FOR2020001');
select * from perfiles;


select datediff('2020-06-13', '2022-11-15');
select datediff(current_date(), '2022-11-15');


select datediff(fecha_fin_previsto, fecha_fin_real) from proyectos;
select sum(venta_previsto) from proyectos where estado = 'terminado';
select venta_previsto-coste_real from proyectos;
select datediff(current_date(), fecha_fin_previsto) from proyectos where id_proyecto='FOR2020001';