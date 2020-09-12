-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 09-Set-2020 às 17:47
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
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL,
  `idFuncao` int(11) NOT NULL,
  `cpf` varchar(14) CHARACTER SET utf8 NOT NULL,
  `statusConta` int(1) NOT NULL,
  `nome` varchar(45) CHARACTER SET utf8 NOT NULL,
  `dataNascimento` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 NOT NULL,
  `telefone` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `senha` varchar(45) CHARACTER SET utf8 NOT NULL,
  `idEstabelecimento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `idFuncao`, `cpf`, `statusConta`, `nome`, `dataNascimento`, `email`, `telefone`, `senha`, `idEstabelecimento`) VALUES
(33, 1, '453.483.776-32', 0, 'Andre Costa', '1967-08-18', 'andre@email.com', '3295683657', 'senhaandre', 1),
(34, 2, '665.499.887-66', 1, 'Raul Nascimento', '1988-06-25', 'raul@email.com', '325768685', 'senharaul', 2),
(35, 3, '993.884.999-34', 0, 'Noah Augusto', '1975-11-25', 'noah@email.com', '3299458844', 'senhanoah', 3),
(36, 3, '247.536.334-55', 1, 'Tabatha Novaes', '1980-01-21', 'tab@email.com', '32948593458', 'senhatab', 4),
(37, 4, '184.597.387-59', 1, 'Ingrid Almeida', '1990-03-24', 'ingrid@email.com', '3294894853', 'senhain', 5),
(38, 3, '674.653.534-84', 0, 'Alessandra Duarte', '1982-12-17', 'ale@email.com', '3209560345', 'senhaale', 6),
(39, 1, '249.834.854-33', 1, 'Lara Fernandes', '1979-11-08', 'lara@email.com', '3298767654', 'senhalara', 7),
(40, 2, '945.783.457-38', 1, 'Maria Silva', '1999-06-23', 'maria@email.com', '32894589383', 'senhamaria', 7),
(41, 3, '898.766.754-89', 0, 'Patricia Diaz', '1995-03-27', 'pat@email.com', '3298787567', 'senhapat', 5),
(42, 1, '122.222.333-00', 1, 'Omar Goncalves', '2020-08-10', 'omar@email.com', '32991425235', 'senhaomar', 3);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Funcionario_Funcao1_idx` (`idFuncao`),
  ADD KEY `fk_Funcionario_Estabelecimento1_idx` (`idEstabelecimento`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_Funcionario_Estabelecimento1` FOREIGN KEY (`idEstabelecimento`) REFERENCES `estabelecimento` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Funcionario_Funcao1` FOREIGN KEY (`idFuncao`) REFERENCES `funcao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
