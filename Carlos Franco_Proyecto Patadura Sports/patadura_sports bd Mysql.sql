-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-03-2016 a las 04:01:38
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `patadura sports`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `atletas`
--

CREATE TABLE IF NOT EXISTS `atletas` (
  `nombre_atletas` varchar(30) NOT NULL,
  `pais` varchar(30) NOT NULL,
  `disciplina` varchar(20) NOT NULL,
  `edad` int(11) DEFAULT NULL,
  `altura` float DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `titulos` varchar(40) DEFAULT NULL,
  `participaciones` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`nombre_atletas`,`disciplina`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `atletas`
--

INSERT INTO `atletas` (`nombre_atletas`, `pais`, `disciplina`, `edad`, `altura`, `peso`, `titulos`, `participaciones`) VALUES
('Michael Phelps', 'USA', 'Natación', 25, 1.79, 78, '2 olímpicos', '2 mundiales,4 olímpicos'),
('MikeTyson', 'USA', 'Boxeo', 39, 1.67, 90, '10 mundiales', '1 olímpico'),
('Nicolás Fruto', 'Venezuela', 'Natación', 30, 1.74, 73, 'Ninguno', '2 olímpicos'),
('raul', 'españa', 'futbol', 38, 1.7, 74, '2 mundiales', '2 olimpicos'),
('Usaín Bolt', 'Jamaica', 'Atletismo', 26, 1.7, 65, '4 mundiales', '5 olímpicos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `disciplinas`
--

CREATE TABLE IF NOT EXISTS `disciplinas` (
  `nombre` varchar(20) NOT NULL,
  `estadio` varchar(30) NOT NULL,
  `fase` varchar(20) NOT NULL,
  `fecha_y_hora` datetime NOT NULL,
  `nombre_atletas` varchar(30) NOT NULL,
  `pais` varchar(30) NOT NULL,
  `usuarioAdmin` varchar(15) NOT NULL DEFAULT 'Administrativo',
  `usuarioPeriod` varchar(15) NOT NULL DEFAULT 'Periodistico',
  PRIMARY KEY (`nombre`,`fecha_y_hora`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `disciplinas`
--

INSERT INTO `disciplinas` (`nombre`, `estadio`, `fase`, `fecha_y_hora`, `nombre_atletas`, `pais`, `usuarioAdmin`, `usuarioPeriod`) VALUES
('Atletismo', 'San Pablo', 'final', '2016-06-21 14:00:00', 'Usaín Bolt', 'Jamaica', '', 'Periodistico'),
('Atletismo', 'SanPablo', 'final', '2016-06-21 20:00:00', 'J.Blatter', 'Tongo', 'Administrativo', 'Periodistico'),
('futbol', 'Goias', 'Final', '2016-06-21 20:00:00', 'raul', 'España', 'Administrativo', 'Periodistico'),
('Gimnasia rítmica', 'Morumbí', 'Final', '2016-06-21 21:00:00', 'Nadia Komanecci', 'Rumania', 'Administrativo', 'Periodistico'),
('Pentatlon', 'Morumbí', 'Final', '2016-06-18 13:00:00', 'Ncongo Nanatí', 'Kenia', 'Administrativo', 'Periodistico'),
('Pesas', 'Campinhas', 'Semifinal', '2016-06-21 15:00:00', 'Arnold Sxwarz', 'Austria', '', 'Periodistico'),
('Ping Pong', 'Bagé', 'Final', '2016-06-21 18:00:00', 'Seuh il jong', 'Corea del sur', 'Administrativo', 'Periodistico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medallas`
--

CREATE TABLE IF NOT EXISTS `medallas` (
  `pais` varchar(30) NOT NULL,
  `nombre_atletas` varchar(30) NOT NULL,
  `disciplina` varchar(20) NOT NULL,
  `valor` varchar(10) NOT NULL,
  `fechaIngreso` date NOT NULL DEFAULT '0000-00-00',
  `usuarioAdmin` varchar(15) NOT NULL DEFAULT 'Administrativo',
  `usuarioPeriod` varchar(15) NOT NULL DEFAULT 'Periodistico',
  PRIMARY KEY (`pais`,`nombre_atletas`,`disciplina`,`fechaIngreso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `medallas`
--

INSERT INTO `medallas` (`pais`, `nombre_atletas`, `disciplina`, `valor`, `fechaIngreso`, `usuarioAdmin`, `usuarioPeriod`) VALUES
('Brasil', 'Patrick Caetano', 'Automovilismo', 'Oro', '2016-06-18', 'Administrativo', 'Periodistico'),
('Croacia', 'P.Sampras', 'Tenis', 'Oro', '2016-06-18', 'Administrativo', 'Periodistico'),
('Cuba', 'Elena Castro', 'Atletismo', 'Bronce', '2016-06-17', 'Administrativo', 'Periodistico'),
('España', 'R.Nadal', 'Tenis', 'Bronce', '2016-06-19', 'Administrativo', 'Periodistico'),
('Finlandia', 'G.Finniken', 'Remo', 'Oro', '2016-06-18', 'Administrativo', 'Periodistico'),
('Irak', 'Aibalava Latajala', 'Bala', 'Oro', '2016-06-19', 'Administrativo', 'Periodistico'),
('Kenia', 'Cocochi Ngoya', 'Atletismo', 'Plata', '2016-06-17', 'Administrativo', 'Periodistico'),
('Kenia', 'Shaka zuló', 'judo', 'Oro', '2016-06-18', 'Administrativo', 'Periodistico'),
('Noruega', 'P.Solskjaer', 'Remo', 'Plata', '2016-06-17', 'Administrativo', 'Periodistico'),
('Sudáfrica', 'Selección', 'Rugby', 'Oro', '2016-06-17', 'Administrativo', 'Periodistico'),
('Suiza', 'S.Marco', 'Atletismo', 'Oro', '2016-06-20', 'Administrativo', 'Periodistico'),
('Uruguay', 'Alejandro Foglia', 'Vela', 'Plata', '0000-00-00', 'Administrativo', 'Periodistico'),
('Uruguay', 'Débora Rodríguez', 'Atletismo', 'Oro', '2016-06-17', 'Administrativo', 'Periodistico'),
('Uruguay', 'Débora Rodríguez', 'Salto largo', 'bronce', '2016-06-16', 'Administrativo', 'Periodistico'),
('Uruguay', 'J.Posse', 'Remo', 'Bronce', '2016-06-18', 'Administrativo', 'Periodistico'),
('Uruguay', 'José Mujica', 'Equitación', 'Plata', '0000-00-00', 'Administrativo', 'Periodistico'),
('Uruguay', 'P.Cuevas', 'Tenis', 'Plata', '2016-06-17', 'Administrativo', 'Periodistico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paises`
--

CREATE TABLE IF NOT EXISTS `paises` (
  `nombre` varchar(30) NOT NULL,
  `poblacion` int(10) unsigned NOT NULL,
  `continente` varchar(30) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `paises`
--

INSERT INTO `paises` (`nombre`, `poblacion`, `continente`) VALUES
('Cuba', 8000000, 'Centroamérica'),
('Uruguay', 3000000, 'América del sur'),
('USA', 130000000, 'Norteamérica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `usuario` varchar(30) NOT NULL,
  `contrasenia` varchar(20) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  PRIMARY KEY (`usuario`,`fecha_ingreso`),
  FULLTEXT KEY `contrasenia` (`contrasenia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`usuario`, `contrasenia`, `tipo`, `fecha_ingreso`) VALUES
('Carlin', '123409', 'Administrativo', '2016-06-13 00:00:00'),
('Yanuzi', 'pastilla', 'Periodistico', '2016-06-13 00:00:00'),
('Yanuzi', 'pastilla', 'Periodistico', '2016-06-14 11:00:00'),
('Yanuzi', 'pastilla', 'Periodistico', '2016-06-15 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `selecciones`
--

CREATE TABLE IF NOT EXISTS `selecciones` (
  `nombre` varchar(30) NOT NULL,
  `integrantes` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
