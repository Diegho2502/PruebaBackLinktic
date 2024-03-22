CREATE TABLE IF NOT EXISTS asegurados (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     tipo_identificacion integer NOT NULL,
     numero_identificacion varchar(255) not null,
     apellidos varchar(255) not null,
     nombres varchar(255) not null,
     sexo integer not null,
     fecha_nacimiento varchar(255)
);

INSERT INTO asegurados (tipo_identificacion, numero_identificacion, apellidos, nombres, sexo, fecha_nacimiento) VALUES (1, '79000001', 'APELLIDO1', 'NOMBRE1', 1, '10-ene-45
');
INSERT INTO asegurados (tipo_identificacion, numero_identificacion, apellidos, nombres, sexo, fecha_nacimiento) VALUES (1, '79000002', 'APELLIDO2', 'NOMBRE2', 1, '10-ene-50');
INSERT INTO asegurados (tipo_identificacion, numero_identificacion, apellidos, nombres, sexo, fecha_nacimiento) VALUES (1, '79000003', 'APELLIDO3', 'NOMBRE3', 1, '10-ene-55');
INSERT INTO asegurados (tipo_identificacion, numero_identificacion, apellidos, nombres, sexo, fecha_nacimiento) VALUES (2, '79000004', 'APELLIDO4', 'NOMBRE4', 2, '10-ene-60
');
INSERT INTO asegurados (tipo_identificacion, numero_identificacion, apellidos, nombres, sexo, fecha_nacimiento) VALUES (2, '79000005', 'APELLIDO5', 'NOMBRE5', 2, '10-ene-65');
INSERT INTO asegurados (tipo_identificacion, numero_identificacion, apellidos, nombres, sexo, fecha_nacimiento) VALUES (2, '79000006', 'APELLIDO6', 'NOMBRE6', 2, '10-ene-70');

CREATE TABLE IF NOT EXISTS amparos (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        nombre varchar(255) not null
     );

INSERT INTO amparos (nombre) values ('Muerte accidental'), ('Desmembración'), ('Auxilio funerario'), ('Renta vitalicia');

CREATE TABLE IF NOT EXISTS primas (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     codigo integer not null,
     edad_minima integer not null,
     edad_maxima integer not null,
     porcentaje_prima double
     );

INSERT INTO primas (codigo, edad_minima, edad_maxima, porcentaje_prima) values (1, 18, 45, 0.02304),
                                                                               (1, 46, 75, 0.02012),
                                                                               (2, 18, 50, 0.1809),
                                                                               (2, 51, 70, 0.16043),
                                                                               (3, 18, 60, 0.14123),
                                                                               (3, 61, 70, 0.1545),
                                                                               (4, 18, 50, 0.12123),
                                                                               (4, 51, 70, 0.1809)

