-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 05-06-2021 a las 13:18:55
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad`
--

CREATE TABLE `actividad` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` double NOT NULL,
  `idSedeFK` int(11) NOT NULL,
  `activo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `actividad`
--

INSERT INTO `actividad` (`id`, `nombre`, `precio`, `idSedeFK`, `activo`) VALUES
(1, 'pin pon', 65, 5, 1),
(2, 'boxeo', 12, 5, 1),
(5, 'padel', 1100, 5, 1),
(6, 'petanca', 100, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`id`, `nombre`) VALUES
(1, 'los malos'),
(2, 'los buenos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `edad` int(2) NOT NULL,
  `dorsal` int(11) NOT NULL,
  `idEquipoFK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`id`, `nombre`, `edad`, `dorsal`, `idEquipoFK`) VALUES
(1, 'dani', 32, 10, 2),
(2, 'frank', 25, 70, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `id` int(11) NOT NULL,
  `metodoPago` varchar(100) NOT NULL,
  `importe` double NOT NULL,
  `pagado` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `idReservaFk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`id`, `metodoPago`, `importe`, `pagado`, `fecha`, `idReservaFk`) VALUES
(5, 'PAYPAL', 15.6, 1, '2021-06-03 22:27:13', 8),
(7, 'BIZUM', 11, 1, '2021-06-03 22:42:42', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id` int(11) NOT NULL,
  `usuarioFK` varchar(100) NOT NULL,
  `fecha` datetime NOT NULL,
  `idActividadFk` int(11) NOT NULL,
  `idEquipoUnoFK` int(11) NOT NULL,
  `idEquipoDosFK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id`, `usuarioFK`, `fecha`, `idActividadFk`, `idEquipoUnoFK`, `idEquipoDosFK`) VALUES
(8, 'pac', '1999-07-21 12:00:22', 2, 2, 2),
(10, 'pac', '2021-07-27 12:00:00', 5, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sede`
--

CREATE TABLE `sede` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `cp` int(5) NOT NULL,
  `tlf` varchar(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `provincia` varchar(100) NOT NULL,
  `activo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sede`
--

INSERT INTO `sede` (`id`, `nombre`, `direccion`, `cp`, `tlf`, `email`, `provincia`, `activo`) VALUES
(1, 'Molar', 'C/ Benahoat,126', 41750, '662354111', 'molar@gmail.com', 'Sevilla', 0),
(5, 'SAN PABLO primero', 'POL. SAN PABLO', 41012, '66543237', 'PABLO@GMAIL.COM', 'SEVILLA', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `userName` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `email` varchar(100) NOT NULL,
  `tlf` varchar(20) NOT NULL,
  `admin` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`userName`, `password`, `nombre`, `apellidos`, `dni`, `email`, `tlf`, `admin`) VALUES
('lau', 'laura2021', 'laura', 'cerdá', '55555555C', 'laura.c.rando@gmail.com', '954251478', 1),
('pac', 'paco2021', 'paco', 'pérez', '22222222C', 'paco@gmail.com', '954141458', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idSedeFK` (`idSedeFK`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idEquipoFK` (`idEquipoFK`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pago_ibfk_1` (`idReservaFk`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuarioFK` (`usuarioFK`),
  ADD KEY `reserva_ibfk_3` (`idActividadFk`),
  ADD KEY `reserva_ibfk_4` (`idEquipoUnoFK`),
  ADD KEY `reserva_ibfk_5` (`idEquipoDosFK`);

--
-- Indices de la tabla `sede`
--
ALTER TABLE `sede`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`userName`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividad`
--
ALTER TABLE `actividad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `equipo`
--
ALTER TABLE `equipo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `sede`
--
ALTER TABLE `sede`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD CONSTRAINT `actividad_ibfk_5` FOREIGN KEY (`idSedeFK`) REFERENCES `sede` (`id`);

--
-- Filtros para la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD CONSTRAINT `jugador_ibfk_1` FOREIGN KEY (`idEquipoFK`) REFERENCES `equipo` (`id`);

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`idReservaFk`) REFERENCES `reserva` (`id`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`usuarioFK`) REFERENCES `usuario` (`userName`),
  ADD CONSTRAINT `reserva_ibfk_3` FOREIGN KEY (`idActividadFk`) REFERENCES `actividad` (`id`),
  ADD CONSTRAINT `reserva_ibfk_4` FOREIGN KEY (`idEquipoUnoFK`) REFERENCES `equipo` (`id`),
  ADD CONSTRAINT `reserva_ibfk_5` FOREIGN KEY (`idEquipoDosFK`) REFERENCES `equipo` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
