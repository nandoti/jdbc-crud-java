CREATE TABLE usuario(
   id    INT PRIMARY KEY AUTOINCREMENT,
   nome  VARCHAR(30),
   email VARCHAR(30) UNIQUE,
   sexo  VARCHAR(30),
   pais  VARCHAR(30),
   senha VARCHAR(30)
);