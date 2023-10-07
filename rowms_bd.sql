-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-10-2023 a las 03:45:31
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

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

CREATE TABLE `empresas` (
  `idEmpresa` varchar(7) NOT NULL,
  `nombreEmpresa` varchar(100) NOT NULL,
  `descripcionEmpresa` varchar(100) NOT NULL,
  `fotoEmpresa` varchar(300) DEFAULT NULL,
  `telefonoEmpresa` varchar(9) NOT NULL,
  `direccionEmpresa` varchar(100) NOT NULL,
  `correoEmpresa` varchar(100) NOT NULL,
  `contraseñaEmpresa` varchar(100) NOT NULL,
  `estadoEmpresa` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

CREATE TABLE `estados` (
  `idEstado` varchar(11) NOT NULL,
  `nombreEstado` varchar(100) NOT NULL
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

CREATE TABLE `plazas` (
  `idPlaza` varchar(7) NOT NULL,
  `nombrePlaza` varchar(100) NOT NULL,
  `descripcionPlaza` varchar(100) NOT NULL,
  `direccionPlaza` varchar(100) NOT NULL,
  `empresaAfiliada` varchar(100) NOT NULL,
  `salarioPlaza` float NOT NULL,
  `requisitoPlaza` varchar(100) NOT NULL,
  `tipoPlaza` varchar(100) NOT NULL,
  `rubroPlaza` varchar(100) NOT NULL,
  `cargoPlaza` varchar(100) NOT NULL,
  `estadoPlaza` varchar(100) NOT NULL,
  `motivoRechazoPlaza` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `dui` varchar(9) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `edad` int(11) NOT NULL,
  `genero` varchar(100) NOT NULL,
  `foto` varchar(300) DEFAULT NULL,
  `telefono` varchar(9) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `expLaboral` varchar(100) NOT NULL,
  `gradoAcademico` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `empresaAfiliada` varchar(100) DEFAULT NULL,
  `estado` varchar(100) NOT NULL,
  `rol` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empresas`
--
ALTER TABLE `empresas`
  ADD PRIMARY KEY (`idEmpresa`),
  ADD KEY `estadoEmpresa` (`estadoEmpresa`);

--
-- Indices de la tabla `estados`
--
ALTER TABLE `estados`
  ADD PRIMARY KEY (`idEstado`);

--
-- Indices de la tabla `plazas`
--
ALTER TABLE `plazas`
  ADD PRIMARY KEY (`idPlaza`),
  ADD KEY `estadoPlaza` (`estadoPlaza`),
  ADD KEY `estadoPlaza_2` (`estadoPlaza`),
  ADD KEY `empresaAfiliada` (`empresaAfiliada`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`dui`),
  ADD KEY `empresaAfiliada` (`empresaAfiliada`),
  ADD KEY `estado` (`estado`);

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
