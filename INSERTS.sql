--tb_rol
INSERT INTO tb_rol (idrol, descripcion) 
	VALUES (1, 'administrador')
INSERT INTO tb_rol (idrol, descripcion) 
	VALUES (2, 'usuario')
--tb_rol_usuario
INSERT INTO tb_rol_usuario (idusuario_rol, fecha_creacion, fecha_modificacion, idrol) 
	VALUES (1, '2018-10-21', '2018-10-21', 1)
INSERT INTO tb_rol_usuario (idusuario_rol, fecha_creacion, fecha_modificacion, idrol) 
	VALUES (2, '2018-10-21', '2018-10-21', 1)
--tb_usuario
INSERT INTO tb_usuario (idusuario, nombre, apellido, idusuario_rol, pasword, idrol) 
	VALUES (1, 'Gaston', 'Chiavasco', NULL, NULL, NULL)
--tb_especialidad
INSERT INTO tb_especialidad (idespecialidad, descripcion) 
	VALUES (1, 'postura')
INSERT INTO tb_especialidad (idespecialidad, descripcion) 
	VALUES (2, 'masoterapia')
INSERT INTO tb_especialidad (idespecialidad, descripcion) 
	VALUES (3, 'fisioterapia')
INSERT INTO tb_especialidad (idespecialidad, descripcion) 
	VALUES (4, 'neuromuscular')
--tb_kinesiologo
INSERT INTO tb_kinesiologo (idmatricula, nombre, apellido, idespecialidad) 
	VALUES (20001, 'Alberto', 'Lopez', 1);
INSERT INTO tb_kinesiologo (idmatricula, nombre, apellido, idespecialidad) 
	VALUES (20002, 'Jorge', 'Suarez', 2);
INSERT INTO tb_kinesiologo (idmatricula, nombre, apellido, idespecialidad) 
	VALUES (20003, 'Nestor', 'Martinez', 3);
INSERT INTO tb_kinesiologo (idmatricula, nombre, apellido, idespecialidad) 
	VALUES (20004, 'Javier', 'Fernandez', 4);
