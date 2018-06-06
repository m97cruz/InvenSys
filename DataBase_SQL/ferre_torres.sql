-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-06-2018 a las 23:17:47
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ferre_torres`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE `marcas` (
  `id` int(11) NOT NULL,
  `marca` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `marcas`
--

INSERT INTO `marcas` (`id`, `marca`) VALUES
(1, 'IMACASA'),
(2, 'PRETUL');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `pre_compra` decimal(8,2) NOT NULL,
  `pre_venta` decimal(8,2) NOT NULL,
  `pre_pack` decimal(8,2) NOT NULL,
  `cant_pack` int(11) NOT NULL,
  `local_cant` int(11) NOT NULL,
  `bodega_cant` int(11) NOT NULL,
  `repo` int(11) NOT NULL,
  `porce_gan` tinyint(4) NOT NULL,
  `marca` int(11) NOT NULL,
  `proveedor1` int(11) NOT NULL,
  `proveedor2` int(11) NOT NULL,
  `proveedor3` int(11) NOT NULL,
  `proveedor4` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `nombre`, `pre_compra`, `pre_venta`, `pre_pack`, `cant_pack`, `local_cant`, `bodega_cant`, `repo`, `porce_gan`, `marca`, `proveedor1`, `proveedor2`, `proveedor3`, `proveedor4`) VALUES
(1, 'Martillo', '6.00', '7.50', '0.00', 0, 5, 0, 3, 0, 2, 1, 0, 0, 0),
(2, 'Destornillador', '3.00', '3.30', '0.00', 0, 7, 4, 3, 10, 1, 1, 0, 0, 0),
(5, 'lb Clavos de 2\"', '1.50', '2.00', '0.00', 0, 25, 25, 12, 0, 0, 1, 0, 0, 0),
(6, 'Alicates', '4.00', '4.80', '4.00', 5, 7, 5, 3, 20, 2, 1, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prod_solicita`
--

CREATE TABLE `prod_solicita` (
  `cod_prod` int(11) NOT NULL,
  `prod_nombre` varchar(255) NOT NULL,
  `marca` varchar(60) NOT NULL,
  `origen` varchar(10) NOT NULL,
  `destino` varchar(10) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prod_solicita`
--

INSERT INTO `prod_solicita` (`cod_prod`, `prod_nombre`, `marca`, `origen`, `destino`, `cantidad`, `precio`) VALUES
(1, 'Martillo', '', 'Proveedor', 'Bodega', 7, '6.00'),
(2, 'Destornillador', '', 'Bodega', 'Local', 3, '3.00'),
(5, 'lb Clavos de 2\"', '---', 'Proveedor', 'Bodega', 5, '1.50'),
(1, 'Martillo', 'PRETUL', 'Bodega', 'Local', 4, '6.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id` int(11) NOT NULL,
  `prov_nombre` varchar(200) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `correo` varchar(110) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id`, `prov_nombre`, `telefono`, `direccion`, `correo`) VALUES
(1, 'Distribuidora Lopez', '75689400', 'San Miguel', 'dLopes@mail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `nombre` varchar(70) NOT NULL,
  `passwd` varchar(255) NOT NULL,
  `rol` varchar(6) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `nombre`, `passwd`, `rol`, `apellido`, `direccion`, `telefono`, `correo`) VALUES
(1, 'admin', 'Administrador - ROOT', 'admin', 'ADMIN', '', '', '', ''),
(2, 'Vendedor 1', 'Vendedor - Prueba', '1234', 'NORMAL', '', '', '', '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `FK_MARCA` (`marca`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `marcas`
--
ALTER TABLE `marcas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
