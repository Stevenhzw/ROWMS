-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-11-2023 a las 05:22:56
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

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
-- Estructura de tabla para la tabla `aplicantes`
--

CREATE TABLE `aplicantes` (
  `ID_aplicantes` int(11) NOT NULL,
  `Dui_aplicante` varchar(10) NOT NULL,
  `Plaza_aplicada` varchar(7) NOT NULL,
  `Estado_aplicacion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `aplicantes`
--

INSERT INTO `aplicantes` (`ID_aplicantes`, `Dui_aplicante`, `Plaza_aplicada`, `Estado_aplicacion`) VALUES
(1, '12346578-9', 'PLA0001', 'En Espera'),
(2, '12346578-9', 'PLA0002', 'Rechazado.');

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
  `estadoEmpresa` varchar(100) NOT NULL,
  `rol` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`idEmpresa`, `nombreEmpresa`, `descripcionEmpresa`, `fotoEmpresa`, `telefonoEmpresa`, `direccionEmpresa`, `correoEmpresa`, `contraseñaEmpresa`, `estadoEmpresa`, `rol`) VALUES
('EMP0001', 'Mcdonalds', 'Comida Rapida', 'ss.png', '7549-9568', 'comida rapida', 'mcdonalds@gmail.com', 'ccc', '1', 'adminEmpresa'),
('EMP0002', 'Burger King', 'hamberguesas', 'burger.png', '2526-2656', 'los proceres', 'burgerKing@gmail.com', '123', '1', 'adminEmpresa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

CREATE TABLE `estados` (
  `idEstado` varchar(11) NOT NULL,
  `nombreEstado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `plazas`
--

INSERT INTO `plazas` (`idPlaza`, `nombrePlaza`, `descripcionPlaza`, `direccionPlaza`, `empresaAfiliada`, `salarioPlaza`, `requisitoPlaza`, `tipoPlaza`, `rubroPlaza`, `cargoPlaza`, `estadoPlaza`, `motivoRechazoPlaza`) VALUES
('PLA0001', 'Plaza de cajero', 'cajero descripcion', 'burguer santa elena', 'EMP0002', 600, 'xd', 'laboral ns', 'restaurante', 'cajero', '1', NULL),
('PLA0002', 'cocinero del macdonalds', 'de cocina', 'mcdonals santa elena', 'EMP0001', 750, 'saber cocinar', 'coss', 'restaurantes', 'cocinero', '1', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `dui` varchar(10) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`dui`, `nombre`, `apellido`, `edad`, `genero`, `foto`, `telefono`, `direccion`, `expLaboral`, `gradoAcademico`, `correo`, `contraseña`, `empresaAfiliada`, `estado`, `rol`) VALUES
('12344321-0', 'sdfs', 'sdfsfd', 10, 'Femenino', NULL, '7676-8989', 'xzczcxz', '6', 'Bachillerato', 'asdads23@gomail.com', '123', NULL, '1', 'Aplicante'),
('12345678-1', 'steven', 'steven', 20, 'maculino', 'sada.png', '1525-6596', 'adasd', 'asd', 'asd', 'steven@gmail.com', '123', 'EMP0001', '1', 'administrador'),
('12345698-2', 'manuel', 'miranda', 20, 'amsculino', 'asd.png', '5696-6959', 'sdasdsa', 'sss', 'ssss', 'manuel@gmail.com', '123', 'EMP0001', '1', 'dependiente'),
('12346578-9', 'Diego Ariel', 'Martinez Lemus', 23, 'Masculino', NULL, '7243-7654', 'bla bla bla bla bla', '5', 'Educacion superior', 'diegoariel_2000@gmail.com', '123', NULL, '1', 'Aplicante'),
('95966959-3', 'Mikel', 'Mikes', 21, 'mascule', 'sadd.png', '2299-6959', 'guayabales', '20 años', 'si', 'mikel@gmail.com', '123', 'EMP0001', '1', 'Dependiente');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aplicantes`
--
ALTER TABLE `aplicantes`
  ADD PRIMARY KEY (`ID_aplicantes`),
  ADD KEY `Dui_aplicante` (`Dui_aplicante`),
  ADD KEY `Plaza_aplicada` (`Plaza_aplicada`);

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
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aplicantes`
--
ALTER TABLE `aplicantes`
  MODIFY `ID_aplicantes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aplicantes`
--
ALTER TABLE `aplicantes`
  ADD CONSTRAINT `Dui-Usuario` FOREIGN KEY (`Dui_aplicante`) REFERENCES `usuarios` (`dui`),
  ADD CONSTRAINT `Plaza-Id` FOREIGN KEY (`Plaza_aplicada`) REFERENCES `plazas` (`idPlaza`);

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
