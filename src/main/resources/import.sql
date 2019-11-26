/* Populate tables */

INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Ralph', 'Johnson', ' 3 toneladas de manzanas', '2017-08-08');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('John', 'Vlissides', 'john.vlissides@gmail.com', '2017-08-09');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('James', 'Gosling', 'james.gosling@gmail.com', '2017-08-010');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Bruce', 'Lee', 'bruce.lee@gmail.com', '2017-08-11');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Johnny', 'Doe', 'johnny.doe@gmail.com', '2017-08-12');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('John', 'Roe', 'john.roe@gmail.com', '2017-08-13');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Jane', 'Roe', 'jane.roe@gmail.com', '2017-08-14');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Richard', 'Doe', 'richard.doe@gmail.com', '2017-08-15');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Janie', 'Doe', 'janie.doe@gmail.com', '2017-08-16');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Phillip', 'Webb', 'phillip.webb@gmail.com', '2017-08-17');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Stephane', 'Nicoll', 'stephane.nicoll@gmail.com', '2017-08-18');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Sam', 'Brannen', 'sam.brannen@gmail.com', '2017-08-19');  
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Juergen', 'Hoeller', 'juergen.Hoeller@gmail.com', '2017-08-20'); 
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Janie', 'Roe', 'janie.roe@gmail.com', '2017-08-21');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('John', 'Smith', 'john.smith@gmail.com', '2017-08-22');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Joe', 'Bloggs', 'joe.bloggs@gmail.com', '2017-08-23');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('John', 'Stiles', 'john.stiles@gmail.com', '2017-08-24');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Richard', 'Roe', 'stiles.roe@gmail.com', '2017-08-25');


/* Creamos Usuarios*/



INSERT INTO users (username, password, enable) VALUES('jose','$2a$10$DiCwHKX.PBQ76bpVMzVnq.luFQDcBzaL94NY/6K7b25Yn75wpAhYu',1);
INSERT INTO users (username, password, enable) VALUES('admin','$2a$10$uRMUELVlI8Hx1UtHVOMQJuWUyCd3SlyyQMsytiNTFsTpg5du5ayYW',1);



/* Creamos Roles */
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_ADMIN');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_USER');


/* Creamos Productos */
INSERT INTO productos (nombre, precio, create_at) VALUES ('Manzanas', 200, 	NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Peras', 720000,   	NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Uva', 540000,     	NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Guindas', 840000, 	NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Naranjas', 440000,	NOW());

/* Creamos Estados */
INSERT INTO estados (id, nombre) VALUES (1, 'PROCESO');
INSERT INTO estados (id, nombre) VALUES (2, 'TRANSITO');
INSERT INTO estados (id, nombre) VALUES (3, 'RECHAZADO');
INSERT INTO estados (id, nombre) VALUES (4, 'VENTA');


/* Creamos Pedido */
INSERT INTO pedidos (fecha_inicio_pedido, fecha_termino_pedido , descripcion , observacion , cliente_id , estado_id ) VALUES (NOW() , NOW() , 'manazanas' , 'se necesitan 3 toneladas', 1, 2 );
INSERT INTO detalle_pedidos (cantidad, producto_id, pedido_id) VALUES (2, 1 , 1);





