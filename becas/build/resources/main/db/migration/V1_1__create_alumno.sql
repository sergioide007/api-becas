CREATE TABLE alumno (
  alumno_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  tipo_alumno VARCHAR(2) NOT NULL,
  active BIT NOT NULL,  
  PRIMARY KEY (alumno_id),
  INDEX IX_alumno_last_first_name (last_name, first_name)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;