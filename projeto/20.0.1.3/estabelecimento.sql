-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 09-Set-2020 às 17:44
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
-- Estrutura da tabela `estabelecimento`
--

CREATE TABLE `estabelecimento` (
  `id` int(11) NOT NULL,
  `cnpj` varchar(18) CHARACTER SET utf8 NOT NULL,
  `nomeFantasia` varchar(45) CHARACTER SET utf8 NOT NULL,
  `inscEstadual` varchar(15) CHARACTER SET utf8 NOT NULL,
  `telefone` varchar(30) CHARACTER SET utf8 NOT NULL,
  `idProprietario` int(11) NOT NULL,
  `idEndereco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `estabelecimento`
--

INSERT INTO `estabelecimento` (`id`, `cnpj`, `nomeFantasia`, `inscEstadual`, `telefone`, `idProprietario`, `idEndereco`) VALUES
(1, '78.321.196/0207-3', 'Quentinha da Realeza', '486.377.182.710', '(32)9673-5207', 7, 1),
(2, '57.844.123/6843-00', ' Arabic Feast', '198.377.600.226', '(32)9151-2040', 2, 2),
(3, '40.561.753/3000-00', 'Casa das Frutas', '266.919.428.345', '(32)9725-7430', 14, 3),
(4, '26.229.357/5543-63', 'Comida Temperada', '180.938.874.608', '(32)9604-3795', 28, 4),
(5, '19.753.278/8956-10', 'Sal e Pimenta', '543.349.256.000', '(32)3252-0165', 19, 5),
(6, '84.899.587/3794-85', 'Pizza Hut', '938.746.287.575', '(32)3297-7693', 13, 6),
(7, '87.389.765/8763-55', 'Louise\'s Desserts', '246.774.453.234', '(32)3299-8778', 10, 7);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `estabelecimento`
--
ALTER TABLE `estabelecimento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Estabelecimento_Usuario1_idx` (`idProprietario`),
  ADD KEY `fk_estabelecimento_endestabelecimento1_idx` (`idEndereco`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `estabelecimento`
--
ALTER TABLE `estabelecimento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `estabelecimento`
--
ALTER TABLE `estabelecimento`
  ADD CONSTRAINT `fk_Estabelecimento_Usuario1` FOREIGN KEY (`idProprietario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_estabelecimento_endestabelecimento1` FOREIGN KEY (`idEndereco`) REFERENCES `endestabelecimento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
