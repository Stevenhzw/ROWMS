-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 12-10-2023 a las 03:29:46
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `rowms_bd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

DROP TABLE IF EXISTS `empresas`;
CREATE TABLE IF NOT EXISTS `empresas` (
  `idEmpresa` varchar(7) COLLATE utf8mb4_general_ci NOT NULL,
  `nombreEmpresa` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `descripcionEmpresa` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `fotoEmpresa` varchar(300) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `telefonoEmpresa` varchar(9) COLLATE utf8mb4_general_ci NOT NULL,
  `direccionEmpresa` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `correoEmpresa` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `contraseñaEmpresa` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `estadoEmpresa` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idEmpresa`),
  KEY `estadoEmpresa` (`estadoEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`idEmpresa`, `nombreEmpresa`, `descripcionEmpresa`, `fotoEmpresa`, `telefonoEmpresa`, `direccionEmpresa`, `correoEmpresa`, `contraseñaEmpresa`, `estadoEmpresa`) VALUES
('EMP0001', 'Mcdonalds', 'Comida Rapida', 'ss.png', '7549-9568', 'comida rapida', 'mcdonalds@gmail.com', 'ccc', '1'),
('EMP0002', 'Burger King', 'hamberguesas', 'burger.png', '2526-2656', 'los proceres', 'burgerKing@gmail.com', '123', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

DROP TABLE IF EXISTS `estados`;
CREATE TABLE IF NOT EXISTS `estados` (
  `idEstado` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  `nombreEstado` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estados`
--

INSERT INTO `estados` (`idEstado`, `nombreEstado`) VALUES
('1', 'Activo'),
('2', 'De baja'),
('3', 'Aceptado'),
('4', 'Rechazado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plazas`
--

DROP TABLE IF EXISTS `plazas`;
CREATE TABLE IF NOT EXISTS `plazas` (
  `idPlaza` varchar(7) COLLATE utf8mb4_general_ci NOT NULL,
  `nombrePlaza` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `descripcionPlaza` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `direccionPlaza` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `empresaAfiliada` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `salarioPlaza` float NOT NULL,
  `requisitoPlaza` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `tipoPlaza` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `rubroPlaza` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `cargoPlaza` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `estadoPlaza` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `motivoRechazoPlaza` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`idPlaza`),
  KEY `estadoPlaza` (`estadoPlaza`),
  KEY `estadoPlaza_2` (`estadoPlaza`),
  KEY `empresaAfiliada` (`empresaAfiliada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `plazas`
--

INSERT INTO `plazas` (`idPlaza`, `nombrePlaza`, `descripcionPlaza`, `direccionPlaza`, `empresaAfiliada`, `salarioPlaza`, `requisitoPlaza`, `tipoPlaza`, `rubroPlaza`, `cargoPlaza`, `estadoPlaza`, `motivoRechazoPlaza`) VALUES
('PLA0001', 'Plaza de cajero', 'cajero descripcion', 'burguer santa elena', 'EMP0002', 600, 'nada', 'laboral ns', 'restaurante', 'cajero', '1', NULL),
('PLA0002', 'cocinero del macdonalds', 'de cocina', 'mcdonals santa elena', 'EMP0001', 750, 'saber cocinar', 'coss', 'restaurantes', 'cocinero', '1', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `dui` varchar(9) COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `edad` int NOT NULL,
  `genero` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `foto` varchar(300) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `telefono` varchar(9) COLLATE utf8mb4_general_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `expLaboral` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `gradoAcademico` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `correo` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `contraseña` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `empresaAfiliada` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `estado` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `rol` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`dui`),
  KEY `empresaAfiliada` (`empresaAfiliada`),
  KEY `estado` (`estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`dui`, `nombre`, `apellido`, `edad`, `genero`, `foto`, `telefono`, `direccion`, `expLaboral`, `gradoAcademico`, `correo`, `contraseña`, `empresaAfiliada`, `estado`, `rol`) VALUES
('12345678-', 'steven', 'steven', 20, 'maculino', 'sada.png', '1525-6596', 'adasd', 'asd', 'asd', 'steven@gmail.com', '123', 'EMP0001', '1', 'administrador'),
('12345698-', 'manuel', 'miranda', 20, 'amsculino', 'asd.png', '5696-6959', 'sdasdsa', 'sss', 'ssss', 'manuel@gmail.com', '123', 'EMP0001', '1', 'dependiente'),
('95966959-', 'Mikel', 'Mikes', 21, 'mascule', 'sadd.png', '2299-6959', 'guayabales', '20 años', 'si', 'mikel@gmail.com', '123', 'EMP0001', '1', 'Dependiente');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empresas`
--
ALTER TABLE `empresas`
  ADD CONSTRAINT `empresas_ibfk_1` FOREIGN KEY (`estadoEmpresa`) REFERENCES `estados` (`idEstado`);

--
-- Filtros para la tabla `plazas`
--
ALTER TABLE `plazas`
  ADD CONSTRAINT `plazas_ibfk_1` FOREIGN KEY (`estadoPlaza`) REFERENCES `estados` (`idEstado`),
  ADD CONSTRAINT `plazas_ibfk_2` FOREIGN KEY (`empresaAfiliada`) REFERENCES `empresas` (`idEmpresa`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`empresaAfiliada`) REFERENCES `empresas` (`idEmpresa`),
  ADD CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`estado`) REFERENCES `estados` (`idEstado`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
