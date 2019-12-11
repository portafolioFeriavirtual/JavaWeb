/* Populate tables */


INSERT INTO contratos (apellido, create_at, direccion_entrega, email, nombre, solicitud, estado_id) VALUES ('contreras', '2017-08-08', 'nevado', 'jo.winter0000@gmail.com', 'Jose', '1 tonelada', 1);
INSERT INTO contratos (apellido, create_at, direccion_entrega, email, nombre, solicitud, estado_id) VALUES ('contreras', '2017-08-08', 'nevado', 'jo.winter0000@gmail.com', 'Jose', '1 tonelada', 1);


/* Creamos Usuarios*/
x


INSERT INTO users (username, password, enable) VALUES('jose','$2a$10$DiCwHKX.PBQ76bpVMzVnq.luFQDcBzaL94NY/6K7b25Yn75wpAhYu',1);
INSERT INTO users (username, password, enable) VALUES('admin','$2a$10$uRMUELVlI8Hx1UtHVOMQJuWUyCd3SlyyQMsytiNTFsTpg5du5ayYW',1);
INSERT INTO users (username, password, enable) VALUES('arturo','$2a$10$uRMUELVlI8Hx1UtHVOMQJuWUyCd3SlyyQMsytiNTFsTpg5du5ayYW',1);
INSERT INTO users (username, password, enable) VALUES('carlos','$2a$10$uRMUELVlI8Hx1UtHVOMQJuWUyCd3SlyyQMsytiNTFsTpg5du5ayYW',1);
INSERT INTO users (username, password, enable) VALUES('valeria','$2a$10$uRMUELVlI8Hx1UtHVOMQJuWUyCd3SlyyQMsytiNTFsTpg5du5ayYW',1);
INSERT INTO users (username, password, enable) VALUES('montes','$2a$10$uRMUELVlI8Hx1UtHVOMQJuWUyCd3SlyyQMsytiNTFsTpg5du5ayYW',1);


/* Creamos Roles */
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_ADMIN');
INSERT INTO authorities (user_id, authority) VALUES (3, 'ROLE_TRANSPORTISTA');
INSERT INTO authorities (user_id, authority) VALUES (4, 'ROLE_PRODUCTOR');
INSERT INTO authorities (user_id, authority) VALUES (4, 'ROLE_CONSULTOR');
INSERT INTO authorities (user_id, authority) VALUES (5, 'ROLE_COMERCIANTE');
INSERT INTO authorities (user_id, authority) VALUES (5, 'ROLE_CLIENTE');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_ADMIN');


/* Creamos Productos */
INSERT INTO productos (nombre, precio, create_at) VALUES ('Manzanas', 200, 	NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Peras', 720000,   	NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Uva', 540000,     	NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Guindas', 840000, 	NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Naranjas', 440000,	NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Tomate', 10.000,	NOW());

/* Creamos Estados */
INSERT INTO estados (id, nombre) VALUES (1, 'ABIERTO');
INSERT INTO estados (id, nombre) VALUES (2, 'CERRADO');
INSERT INTO estados (id, nombre) VALUES (3, 'PACTADO');
INSERT INTO estados (id, nombre) VALUES (4, 'DEFINICION');
INSERT INTO estados (id, nombre) VALUES (5, 'EN BODEGA');
INSERT INTO estados (id, nombre) VALUES (6, 'EN CAMINO A CLIENTE');
INSERT INTO estados (id, nombre) VALUES (7, 'COMPLETADO');
INSERT INTO estados (id, nombre) VALUES (8, 'RECHAZADO');


/* Creamos Pedido */
INSERT INTO pedidos (fecha_inicio_pedido, fecha_termino_pedido , descripcion , observacion , cliente_id ) VALUES (NOW() , NOW() , 'manazanas' , 'se necesitan 3 toneladas',1  );
INSERT INTO detalle_pedidos (cantidad, producto_id, pedido_id) VALUES (2, 1 , 1);


INSERT INTO productores (inicio,termino,direccion,encargado,estado,nombre_productor,razonsocial,usuario_id) VALUES ('2019-06-01','2019-07-08','nevado323','administrador','activo','La vega','Empresa',1);
INSERT INTO productores (inicio,termino,direccion,encargado,estado,nombre_productor,razonsocial,usuario_id) VALUES ('2019-06-01','2019-07-08','nevado23' ,'administrador','activo','Lo valledor','empresa',2);
INSERT INTO productores (inicio,termino,direccion,encargado,estado,nombre_productor,razonsocial,usuario_id) VALUES ('2019-06-01','2019-07-08','nevado323','administrador','activo','el mercado','Empresa',3);
INSERT INTO productores (inicio,termino,direccion,encargado,estado,nombre_productor,razonsocial,usuario_id) VALUES ('2019-06-01','2019-07-08','nevado23' ,'administrador','activo','el dato','empresa',4);
/* Creamos Contrato  Productor */

INSERT INTO contrato_productores (inicio,termino,direccion,encargado,acuerdo,productor_id) VALUES ('2017-06-08','2017-08-08','nevado #675', 'Alberto Cortaza','Contrato 6 meses',1);


