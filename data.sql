INSERT INTO proyectos (nombre) VALUES
('Sitio web con Spring Boot y React'),
('Aplicación Next.js con Node.js backend'),
('Despliegue en AWS con DevOps Pipeline');

INSERT INTO especialidades (codigo, nombre) VALUES
('FRONT', 'Desarrollo Frontend'),
('BACK', 'Desarrollo Backend'),
('DEVOPS', 'DevOps');

INSERT INTO especialistas (nombre, especialidad) VALUES
('Desarrollador Frontend React', 'FRONT'),
('Desarrollador Backend Spring Boot', 'BACK'),
('DevOps Engineer', 'DEVOPS'),
('Desarrollador Frontend Next.js', 'FRONT'),
('Desarrollador Backend Node.js', 'BACK'),
('DevOps Specialist AWS', 'DEVOPS');

INSERT INTO tareas (codigo, nombre, proyecto, especialidad, especialista) VALUES
('T1', 'Desarrollo de interfaz con React', 1, 'FRONT', 1),
('T2', 'Desarrollo de backend con Spring Boot', 1, 'BACK', 2),
('T3', 'Despliegue en AWS con DevOps', 3, 'DEVOPS', 3),
('T4', 'Desarrollo de componentes en Next.js', 1, 'FRONT', 4),
('T5', 'Implementación de API en Node.js', 2, 'BACK', 5),
('T6', 'Configuración de entorno en AWS', 3, 'DEVOPS', 6);
