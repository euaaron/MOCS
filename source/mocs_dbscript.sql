-- MySQL Script generated by MySQL Workbench
-- Tue Sep 24 09:11:23 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `nascimento` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`estabelecimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`estabelecimento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario_id` INT NOT NULL,
  `cnpj` VARCHAR(45) NULL,
  `nomeFantasia` VARCHAR(45) NULL,
  `inscEstadual` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_estabelecimento_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_estabelecimento_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `mydb`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`endEstabelecimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`endEstabelecimento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(45) NULL,
  `uf` VARCHAR(4) NULL,
  `cidade` VARCHAR(45) NULL,
  `logradouro` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `numEdificio` VARCHAR(45) NULL,
  `numComplemento` VARCHAR(16) NULL,
  `estabelecimento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_endEstabelecimento_estabelecimento1_idx` (`estabelecimento_id` ASC) VISIBLE,
  CONSTRAINT `fk_endEstabelecimento_estabelecimento1`
    FOREIGN KEY (`estabelecimento_id`)
    REFERENCES `mydb`.`estabelecimento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`comanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`comanda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` VARCHAR(45) NULL,
  `hora` VARCHAR(45) NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_comanda_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_comanda_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `mydb`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`funcao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`funcao` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `descricao` TEXT NULL,
  `nivelPermissao` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(45) NULL,
  `statusConta` TINYINT NULL,
  `estabelecimento_id` INT NOT NULL,
  `funcao_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_funcionario_estabelecimento1_idx` (`estabelecimento_id` ASC) VISIBLE,
  INDEX `fk_funcionario_funcao1_idx` (`funcao_id` ASC) VISIBLE,
  CONSTRAINT `fk_funcionario_estabelecimento1`
    FOREIGN KEY (`estabelecimento_id`)
    REFERENCES `mydb`.`estabelecimento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_funcao1`
    FOREIGN KEY (`funcao_id`)
    REFERENCES `mydb`.`funcao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`prato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`prato` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `descricao` TEXT NULL,
  `dataCriacao` VARCHAR(45) NULL,
  `cardapio_id` INT NOT NULL,
  `funcionario_id` INT NOT NULL,
  `estabelecimento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_prato_funcionario1_idx` (`funcionario_id` ASC) VISIBLE,
  INDEX `fk_prato_estabelecimento1_idx` (`estabelecimento_id` ASC) VISIBLE,
  CONSTRAINT `fk_prato_funcionario1`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `mydb`.`funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prato_estabelecimento1`
    FOREIGN KEY (`estabelecimento_id`)
    REFERENCES `mydb`.`estabelecimento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pedidio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pedidio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `prato_id` INT NOT NULL,
  `quantidade` INT NULL,
  `comanda_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pedidio_prato1_idx` (`prato_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_pedidio_comanda1_idx` (`comanda_id` ASC) VISIBLE,
  CONSTRAINT `fk_pedidio_prato1`
    FOREIGN KEY (`prato_id`)
    REFERENCES `mydb`.`prato` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedidio_comanda1`
    FOREIGN KEY (`comanda_id`)
    REFERENCES `mydb`.`comanda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`endUsuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`endUsuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(45) NULL,
  `uf` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `logradouro` VARCHAR(45) NULL,
  `numResidencia` VARCHAR(45) NULL,
  `numComplemento` VARCHAR(45) NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_endUsuario_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_endUsuario_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `mydb`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
