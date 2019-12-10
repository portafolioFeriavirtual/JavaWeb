/* Populate tables */


INSERT INTO contratos (nombre, apellido, solicitud,direccion_entrega, email, create_at,estado_id) VALUES('Andes', 'Sebastian Piraña','1T Manzanas verdes','Nevado finlandia',' Andes@gmail.com', '2017-08-08',1);
INSERT INTO contratos (nombre, apellido, solicitud,direccion_entrega, email, create_at,estado_id) VALUES('Andes', 'Sebastian Piraña','1T Peras verdes   ','Nevado finlandia',' Andes@gmail.com', '2017-08-08',1);
/* Creamos Usuarios*/
x


INSERT INTO users (username, password, enable) VALUES('jose','$2a$10$DiCwHKX.PBQ76bpVMzVnq.luFQDcBzaL94NY/6K7b25Yn75wpAhYu',1);
INSERT INTO users (username, password, enable) VALUES('admin','$2a$10$uRMUELVlI8Hx1UtHVOMQJuWUyCd3SlyyQMsytiNTFsTpg5du5ayYW',1);
INSERT INTO users (username, password, enable) VALUES('arturo','$2a$10$uRMUELVlI8Hx1UtHVOMQJuWUyCd3SlyyQMsytiNTFsTpg5du5ayYW',1);
INSERT INTO users (username, password, enable) VALUES('carlos','$2a$10$uRMUELVlI8Hx1UtHVOMQJuWUyCd3SlyyQMsytiNTFsTpg5du5ayYW',1);


/* Creamos Roles */
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_ADMIN');
INSERT INTO authorities (user_id, authority) VALUES (3, 'ROLE_TRANSPORTISTA');
INSERT INTO authorities (user_id, authority) VALUES (4, 'ROLE_PRODUCTOR');

/* Creamos Productos */
INSERT INTO productos (nombre, precio, create_at) VALUES ('Manzanas', 200, 	NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Peras', 720000,   	NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Uva', 540000,     	NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Guindas', 840000, 	NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Naranjas', 440000,	NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Tomate', 10.000,	NOW());

/* Creamos Estados */
INSERT INTO estados (id, nombre) VALUES (1, 'PROCESO');
INSERT INTO estados (id, nombre) VALUES (2, 'TRANSITO');
INSERT INTO estados (id, nombre) VALUES (3, 'RECHAZADO');
INSERT INTO estados (id, nombre) VALUES (4, 'VENTA');


/* Creamos Pedido */
INSERT INTO pedidos (fecha_inicio_pedido, fecha_termino_pedido , descripcion , observacion , cliente_id ) VALUES (NOW() , NOW() , 'manazanas' , 'se necesitan 3 toneladas',1  );
INSERT INTO detalle_pedidos (cantidad, producto_id, pedido_id) VALUES (2, 1 , 1);


INSERT INTO productores (inicio,termino,direccion,encargado,estado , nombre_productor,razonsocial) VALUES ('2017-06-08','2017-08-08','nevado #675', 'Alberto Cortaza','activo','matapaco','empresa');
INSERT INTO productores (inicio,termino,direccion,encargado,estado , nombre_productor,razonsocial) VALUES ('2017-07-08','2017-08-08','nevado #672', 'Alberto Cortaza','activo','matapaco','empresa');
/* Creamos Contrato  Productor */

INSERT INTO contrato_productores (acuerdo,fin,inicio,productor_id) VALUES ('Contrato 6 meses','2017-06-08','2017-08-08',1);





