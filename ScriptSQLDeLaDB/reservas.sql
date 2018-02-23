-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.20-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para reservas_vuelos
CREATE DATABASE IF NOT EXISTS `reservas_vuelos` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `reservas_vuelos`;

-- Volcando estructura para tabla reservas_vuelos.ciudades
CREATE TABLE IF NOT EXISTS `ciudades` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla reservas_vuelos.ciudades: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT INTO `ciudades` (`id`, `descripcion`) VALUES
	(1, 'Medellin'),
	(2, 'Bogota'),
	(3, 'Cali'),
	(4, 'Cartagena'),
	(5, 'Amazonas'),
	(6, 'Pasto'),
	(7, 'Bucaramanga'),
	(8, 'Barranquilla'),
	(9, 'Boyaca');
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;

-- Volcando estructura para tabla reservas_vuelos.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `numero_di` int(11) NOT NULL,
  `tipo_di` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `FK__tipos_documentos_id` (`tipo_di`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla reservas_vuelos.persona: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`numero_di`, `tipo_di`, `nombre`, `id`) VALUES
	(700, 1, 'Carlos Robero', 1),
	(400, 2, 'Chechi Baena', 2),
	(300, 4, 'Arturo Velasquez', 3),
	(305, 4, 'Bety Caseres', 4);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

-- Volcando estructura para tabla reservas_vuelos.reserva
CREATE TABLE IF NOT EXISTS `reserva` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `persona` int(11) NOT NULL DEFAULT '0',
  `fecha_hora_salida` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `origen` int(11) NOT NULL DEFAULT '0',
  `fecha_hora_llegada` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `destino` int(11) NOT NULL DEFAULT '0',
  `precio` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_reserva_persona` (`persona`),
  KEY `FK_reserva_ciudades` (`origen`),
  KEY `FK_reserva_ciudades_2` (`destino`),
  CONSTRAINT `FK_reserva_ciudades` FOREIGN KEY (`origen`) REFERENCES `ciudades` (`id`),
  CONSTRAINT `FK_reserva_ciudades_2` FOREIGN KEY (`destino`) REFERENCES `ciudades` (`id`),
  CONSTRAINT `FK_reserva_persona` FOREIGN KEY (`persona`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla reservas_vuelos.reserva: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` (`id`, `persona`, `fecha_hora_salida`, `origen`, `fecha_hora_llegada`, `destino`, `precio`) VALUES
	(1, 1, '2018-05-02 15:00:00', 8, '2018-05-02 18:00:00', 5, 500000),
	(3, 1, '2018-06-30 08:00:00', 2, '2018-06-30 10:00:00', 1, 1000000),
	(4, 4, '2018-03-06 13:00:00', 9, '2018-03-06 17:00:00', 3, 800000),
	(6, 2, '2018-04-04 04:00:00', 7, '2018-04-04 08:00:00', 4, 600000);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;

-- Volcando estructura para tabla reservas_vuelos.tipos_documentos_id
CREATE TABLE IF NOT EXISTS `tipos_documentos_id` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla reservas_vuelos.tipos_documentos_id: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `tipos_documentos_id` DISABLE KEYS */;
INSERT INTO `tipos_documentos_id` (`id`, `descripcion`) VALUES
	(1, 'Cedula de Ciudadania'),
	(2, 'Cedula de Extranjeria'),
	(3, 'Tarjeta de Identidad'),
	(4, 'Pasaporte');
/*!40000 ALTER TABLE `tipos_documentos_id` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
