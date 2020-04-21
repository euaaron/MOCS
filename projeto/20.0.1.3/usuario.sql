-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 19-Abr-2020 às 21:15
-- Versão do servidor: 5.7.26
-- versão do PHP: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mocs`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `dataNascimento` varchar(10) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `senha` varchar(45) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `dataNascimento`, `email`, `telefone`, `senha`, `cpf`) VALUES
(1, 'Arthur Ora', '1956-05-06', 'ora.arthur@email.com', '(32)4617-2560', 'senhaartur', '005.101.581-42'),
(2, 'Jasmine Gaga', '1985-08-25', 'gaga.jas@email.com', '(32)4500-2788', 'senhajasmine', '001.502.547-14'),
(3, 'Sofia D\'Costa Pinto', '2000-01-07', 'sofia.p@email.com', '(32)96022-5667', 'senhasofia', '184.341.105-02'),
(4, 'Manuelita Chagas', '1988-04-19', 'manu.chagas@email.com', '(32)99134-3489', 'senhamanu', '998.377.592-04'),
(5, 'Tierra Cat', '1990-03-01', 'titi.cat@email.com', '(32)97784-7609', 'senhatiti', '157.839.288-83'),
(6, 'Lana Summer', '1975-09-05', 'lana.sum@email.com', '(32)99837-0042', 'senhalana', '178.398.283-74'),
(7, 'Peter Queen', '1995-04-09', 'peter.q@email.com', '(32)8804-9945', 'senhapeter', '184.799.937-48'),
(8, 'Oliver Parker', '1984-06-04', 'oliparker@email.com', '(32)3241-4952', 'senhaoli', '167.848.655-35'),
(9, 'Freud Mercury', '1996-04-14', 'freud.nest@email.com', '(32)3202-5400', 'senhafreud', '187.643.337-45'),
(10, 'Louise Monet', '1960-03-10', 'louise.monet@email.com', '(32)3243-3348', 'senhalouise', '148.592.898-98'),
(11, 'Alvin Carter', '1989-09-27', 'alvin.carter@email.com', '(32)98876-7654', 'senhaalvin', '134.484.985-42'),
(12, 'Alan Mitchel', '1991-12-09', 'al.mitchel@email.com', '(32)98987-6654', 'senhaalan', '123.456.755-43'),
(13, 'Camila Santos', '1987-11-07', 'caca.santos@email.com', '(32)35665-4532', 'senhacamila', '195.885.768-34'),
(14, 'Violetta Pera', '1995-02-02', 'vipera@email.com', '(32)3276-5667', 'senhavi', '193.645.635-24'),
(15, 'Katleen Mendoza', '1993-11-05', 'katmendoza@email.com', '(32)32735-2525', 'senhakat', '193.746.957-43'),
(16, 'Tiago Flores', '1990-01-11', 'tiago.flo@email.com', '(32)94587-4345', 'senhatiago', '199.938.833-23'),
(17, 'Caio Braga', '1981-05-06', 'caio.braga@email.com', '(32)3255-5313', 'senhacaio', '139.994.023-23'),
(18, 'Luiz Magalhaes', '1979-01-02', 'luiz.maga@email.com', '(32)3299-8772', 'senhaluiz', '123.999.876-66'),
(19, 'Larissa Santos', '1990-04-07', 'lari.santos@email.com', '(32)3204-8554', 'senhalari', '188.876.544-45'),
(20, 'Gisele Almeida', '1980-06-09', 'gi.almeida@email.com', '(32)3211-8493', 'senhagi', '198.839.948-53'),
(21, 'Kate Homura', '1988-09-03', 'kat.homura@email.com', '(32)90992-4485', 'senhakat', '118.303.948-53'),
(22, 'Rodrigo Miller', '1974-11-16', 'rodrigo.mill@email.com', '(32)8842-4553', 'senharodrigo', '188.766.633-00'),
(23, 'Maria Antonia ', '1968-12-12', 'maria@email.com', '(32)98736-6484', 'senhamaria', '156.757.698-00'),
(24, 'Antonio de Souza', '1977-09-07', 'antonio@email.com', '(32)96438-7654', 'senhaantonio', '146.836.545-83'),
(25, 'Roberto Rodriguez', '1969-06-05', 'beto.rodriguez@email.com', '(32)6354-9506', 'senhabeto', '162.746.453-50'),
(26, 'Monica Fernades', '1998-11-07', 'monica.fer@email.com', '(32)99183-7494', 'senhamonica', '198.700.987-63'),
(27, 'Amanda Ferreira', '1976-06-01', 'amanda@email.com', '(32)95684-9509', 'senhaamanda', '194.983.234-44'),
(28, 'Rian de Paula', '1990-09-18', 'rian.paula@email.com', '(32)9955-9130', 'senharian', '193.887.000-04'),
(29, 'Daniele GonÃ§alves', '1990-09-17', 'dani.gonÃ§alves', '(32)90028-4123', 'senhadani', '100.993.847-54'),
(30, 'Felipe da Silva', '1986-03-19', 'felipe.sil@email.com', '(32)90458-3854', 'senhafelipe', '109.384.545-84');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
