-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 09-Set-2020 às 17:49
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `mocs`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `comanda`
--

CREATE TABLE `comanda` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `hora` varchar(5) CHARACTER SET utf8 NOT NULL,
  `idCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `comanda`
--

INSERT INTO `comanda` (`id`, `data`, `hora`, `idCliente`) VALUES
(1, '2020-08-20', '18:08', 1),
(2, '2013-02-20', '22:16', 2),
(3, '2020-08-25', '12:41', 8),
(4, '2020-08-25', '15:36', 7),
(5, '2020-08-25', '08:04', 11),
(6, '2020-08-25', '12:21', 3);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `comanda`
--
ALTER TABLE `comanda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Comanda_Usuario_idx` (`idCliente`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `comanda`
--
ALTER TABLE `comanda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `comanda`
--
ALTER TABLE `comanda`
  ADD CONSTRAINT `fk_Comanda_Usuario` FOREIGN KEY (`idCliente`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
