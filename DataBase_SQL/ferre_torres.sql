-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-06-2018 a las 04:59:29
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
  `nombre` varchar(200) NOT NULL,
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
(1, 'Martillo', '10.00', '11.50', '11.00', 8, 6, 4, 4, 15, 1, 0, 0, 0, 0),
(2, 'Tubo PBC', '6.00', '6.78', '0.00', 0, 20, 0, 10, 13, 0, 0, 0, 0, 0),
(3, 'Tubo PBC', '6.00', '6.78', '0.00', 0, 20, 5, 10, 13, 0, 0, 0, 0, 0),
(4, 'Tubo PBC', '6.00', '6.78', '0.00', 0, 20, 5, 10, 13, 0, 0, 0, 0, 0),
(5, 'Destornishador', '6.70', '7.57', '0.00', 0, 9, 5, 10, 13, 1, 1, 0, 0, 0),
(6, 'Tubo PBC', '6.70', '6.78', '0.00', 0, 20, 5, 10, 13, 1, 0, 0, 0, 0),
(7, 'Tubo PBC', '6.70', '6.78', '0.00', 2, 20, 5, 10, 13, 1, 0, 0, 0, 0),
(8, 'Soldador de Estaño', '8.00', '9.60', '0.00', 0, 5, 4, 1, 20, 0, 0, 0, 0, 0);

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
  `rol` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `nombre`, `passwd`, `rol`) VALUES
(1, 'admin', 'Administrador - ROOT', 'admin', 'ADMIN'),
(2, 'Vendedor 1', 'Vendedor - Prueba', '1234', 'NORMAL');

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
  ADD PRIMARY KEY (`codigo`);

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
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
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
