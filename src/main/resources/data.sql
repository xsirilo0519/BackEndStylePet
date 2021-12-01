INSERT INTO rol (id,name) VALUES (1,'User'),(2,'Admin');
INSERT INTO tipo_mascota(id, name) VALUES (1,'Perro'),(2,'Gato');
INSERT INTO estilista(cedula, name) VALUES (12345,'Andres Fernandez'),(54321,'Juan Lopez'),(98765,'Manuel Caro');
INSERT INTO cortes(id, name,precio) VALUES (1,'normal',2000),(2,'perro que ladra',5000);
INSERT INTO turno(id,ced_estilista,estado,turno) VALUES (1,12345,true,'2:00'), (2,12345,true,'3:00'),(3,54321,true,'2:00'),(4,54321,true,'7:00'),(5,98765,true,'3:00'), (6,54321,true,'4:00'),(7,54321,true,'5:00');