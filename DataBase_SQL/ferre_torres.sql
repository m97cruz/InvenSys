-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 06-07-2018 a las 01:51:24
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 5.6.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cod_prod` int(11) NOT NULL,
  `producto` varchar(255) NOT NULL,
  `proveedor` varchar(255) NOT NULL,
  `pre_compra` decimal(10,2) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(11,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `compras`
--

INSERT INTO `compras` (`id`, `fecha`, `cod_prod`, `producto`, `proveedor`, `pre_compra`, `cantidad`, `precio`) VALUES
(1, '2018-06-18', 0, 'Martillo', 'Distribuidora Lopez', '6.50', 3, '19.50'),
(2, '2018-06-17', 0, 'Alicates', 'Proveedor Dominic', '5.00', 5, '25.00'),
(3, '2018-07-05', 7, 'Destornillador', 'Distribuidora Marquez', '3.00', 4, '12.00'),
(4, '2018-07-05', 10, 'Libra de clavos 2\"', 'Boom Nena', '0.50', 3, '1.50');

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
(2, 'PRETUL'),
(3, 'Marca 01'),
(5, 'Marca'),
(6, 'Marca 12'),
(7, 'Saionara');

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
(1, 'Martillo', '6.00', '7.50', '0.00', 0, 9, 10, 3, 0, 1, 4, 0, 0, 0),
(2, 'Destornillador', '3.00', '3.30', '0.00', 0, 6, 12, 1, 10, 3, 0, 4, 0, 0),
(6, 'Alicates', '4.00', '4.80', '4.00', 5, 2, 12, 3, 20, 2, 2, 0, 0, 0),
(7, 'Destornillador', '3.00', '3.30', '0.00', 0, 7, 22, 1, 10, 2, 2, 0, 0, 0),
(8, 'Cuchara De Construccion', '6.00', '7.14', '0.00', 0, 2, 22, 4, 19, 1, 4, 0, 0, 0),
(9, 'Alambre de Amarre', '0.50', '0.75', '0.00', 0, 7, 12, 4, 50, 0, 2, 4, 0, 0),
(10, 'Libra de clavos 2\"', '0.50', '0.75', '0.60', 6, 12, 20, 8, 48, 7, 8, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prod_solicita`
--

CREATE TABLE `prod_solicita` (
  `cod_prod` int(11) NOT NULL,
  `prod_nombre` varchar(255) NOT NULL,
  `marca` varchar(60) NOT NULL,
  `provs` varchar(255) NOT NULL,
  `origen` varchar(10) NOT NULL,
  `destino` varchar(10) NOT NULL,
  `precio_u` decimal(10,2) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id` int(11) NOT NULL,
  `prov_nombre` varchar(200) NOT NULL,
  `encargado` varchar(75) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `correo` varchar(110) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id`, `prov_nombre`, `encargado`, `telefono`, `direccion`, `correo`) VALUES
(2, 'Distribuidora Marquez', 'Milena Guzman', '76543344', 'San Salvador', 'distmarq@mail.com'),
(4, 'Industrias Ferreira', 'Samuel Bercian', '7890-9988', 'San Salvador', 'induferreira@mail.com'),
(5, 'prov2', '', '', '', ''),
(6, 'prov 3', '', '', '', ''),
(7, 'proveedor a', '', '', '', ''),
(8, 'Boom Nena', '', '', '', '');

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
(2, 'Vendedor 1', 'Vendedor - Prueba', '1234', 'NORMAL', '', '', '', ''),
(3, 'mau', 'Maui', 'mau', 'NORMAL', 'Cruz', 'Mikasa', '75560099', 'mcruz@mail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `producto` varchar(255) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id`, `fecha`, `producto`, `cantidad`, `total`) VALUES
(1, '2018-06-16', 'Martillo', 3, 22.5),
(2, '2018-06-16', 'Destornillador', 5, 16.5),
(3, '2018-06-16', 'lb Clavos de 2\"', 145, 145),
(4, '2018-06-17', 'Martillo', 2, 14.5),
(5, '2018-06-17', 'Destornillador', 22, 71.8),
(6, '2018-06-18', 'lb Clavos de 2\"', 3, 6),
(7, '2018-06-18', 'Alicates', 2, 9.6),
(8, '2018-06-17', 'lb Clavos de 2\"', 35, 53),
(9, '2018-06-17', 'clavo de acero libra', 9, 10.5),
(10, '2018-06-17', 'Alicates', 4, 16.8),
(11, '2018-06-18', 'Cuchara De Construccion', 11, 78.14),
(12, '2018-06-18', 'Destornillador', 3, 9.9),
(13, '2018-06-18', 'Libra de clavos 2\"', 2, 1.5),
(14, '2018-06-18', 'Martillo', 1, 7.5),
(15, '2018-06-19', 'Destornillador', 2, 6.6),
(16, '2018-06-19', 'Cuchara De Construccion', 1, 7.14),
(17, '2018-06-29', 'Libra de clavos 2\"', 5, 3.75),
(18, '2018-07-01', 'Libra de clavos 2\"', 2, 1.5),
(19, '2018-07-01', 'Martillo', 3, 21.5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cod_prod` (`cod_prod`);

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `marcas` ADD FULLTEXT KEY `FulText_Marca` (`marca`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `FK_MARCA` (`marca`);
ALTER TABLE `productos` ADD FULLTEXT KEY `NombreFullText` (`nombre`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `proveedores` ADD FULLTEXT KEY `prov_nombre` (`prov_nombre`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `marcas`
--
ALTER TABLE `marcas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
