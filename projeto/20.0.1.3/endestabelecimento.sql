-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 09-Set-2020 às 17:46
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
-- Estrutura da tabela `endestabelecimento`
--

CREATE TABLE `endestabelecimento` (
  `id` int(11) NOT NULL,
  `cep` varchar(10) CHARACTER SET utf8 NOT NULL,
  `uf` varchar(4) CHARACTER SET utf8 NOT NULL,
  `cidade` varchar(45) CHARACTER SET utf8 NOT NULL,
  `logradouro` varchar(45) CHARACTER SET utf8 NOT NULL,
  `bairro` varchar(45) CHARACTER SET utf8 NOT NULL,
  `numEdificio` varchar(9) CHARACTER SET utf8 NOT NULL,
  `numComplemento` varchar(30) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `endestabelecimento`
--

INSERT INTO `endestabelecimento` (`id`, `cep`, `uf`, `cidade`, `logradouro`, `bairro`, `numEdificio`, `numComplemento`) VALUES
(1, '46.976-783', 'MG', 'Juiz de Fora', 'Rua Coronel Lisboa', 'Centro', '92', 'Em frente ao Mc Donalds'),
(2, '31.562-979', 'MG', 'Matias Barbosa', 'Rua Cachoeira com Agua', 'Banheirinho', '9', 'Proximo ao Bramil'),
(3, '29.876-100', 'MG', 'Matias Barbosa', 'Rua Lorivaldo de Carvalho', 'Bom Pastor', '40', ''),
(4, '82.291-678', 'MG', 'Belo Horizonte', 'Av. Rio Branco', 'Santa Cruz', '51', ''),
(5, '88.998-653', 'MG', 'Juiz de Fora', 'Av. Rio Branco', 'Centro', '98', ''),
(6, '93.487-563', 'MG', 'Juiz de Fora', 'Avenida dos Andradas', 'Centro', '567', ''),
(7, '77.665-557', 'MG', 'Juiz de Fora', 'Rua Coronel Lisboa', 'Bom Pastor', '34', '');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `endestabelecimento`
--
ALTER TABLE `endestabelecimento`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `endestabelecimento`
--
ALTER TABLE `endestabelecimento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
