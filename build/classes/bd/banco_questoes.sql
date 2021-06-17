-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 09-Jun-2021 às 05:32
-- Versão do servidor: 10.4.19-MariaDB
-- versão do PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `banco_questoes`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `assunto`
--

CREATE TABLE `assunto` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `fk_disciplina` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `assunto`
--

INSERT INTO `assunto` (`id`, `nome`, `fk_disciplina`) VALUES
(1, 'Evolucionismo', 1),
(2, 'Porcentagem', 2),
(4, 'Figuras de Linguagem', 10),
(7, 'Verbo To Be', 12),
(15, 'Genética', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`id`, `nome`) VALUES
(1, 'Biologia '),
(2, 'Matemática'),
(3, 'História'),
(4, 'Sociologia'),
(5, 'Filosofia'),
(6, 'Educação Física'),
(7, 'Física'),
(8, 'Química'),
(9, 'Geografia'),
(10, 'Português'),
(11, 'Espanhol'),
(12, 'Inglês');

-- --------------------------------------------------------

--
-- Estrutura da tabela `materia`
--

CREATE TABLE `materia` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `fk_disciplina` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `prova`
--

CREATE TABLE `prova` (
  `id` int(11) NOT NULL,
  `nome_prova` varchar(100) NOT NULL,
  `fk_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `prova`
--

INSERT INTO `prova` (`id`, `nome_prova`, `fk_usuario`) VALUES
(12, 'Questões de Porcentagem', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `questao_prova`
--

CREATE TABLE `questao_prova` (
  `id` int(11) NOT NULL,
  `fk_questao` int(11) NOT NULL,
  `fk_usuario` int(11) NOT NULL,
  `fk_prova` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `questoes`
--

CREATE TABLE `questoes` (
  `id` int(11) NOT NULL,
  `enunciado` text NOT NULL,
  `resposta_a` varchar(500) NOT NULL,
  `resposta_b` varchar(500) NOT NULL,
  `resposta_c` varchar(500) NOT NULL,
  `resposta_d` varchar(500) NOT NULL,
  `fk_assunto` int(11) NOT NULL,
  `fk_prova` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(200) NOT NULL,
  `isadmin` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `email`, `senha`, `isadmin`) VALUES
(1, 'Guilherme Sales', 'guilhermesales11@outlook.com', 'guilherme321', 0),
(2, 'Manoel Rabelo', 'manoel13@gmail.com', 'manoel321', 0),
(3, 'Administrador', 'adm@gmail.com', 'adm321', 1),
(5, 'Fernando Pessoa', 'fernando11@gmail.com', 'fernando', 0),
(6, 'Gustavo Linhares', 'gustavo@gmail.com', 'gustavo', 0);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `assunto`
--
ALTER TABLE `assunto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_disciplina` (`fk_disciplina`);

--
-- Índices para tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_disciplina` (`fk_disciplina`);

--
-- Índices para tabela `prova`
--
ALTER TABLE `prova`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_professor` (`fk_usuario`);

--
-- Índices para tabela `questao_prova`
--
ALTER TABLE `questao_prova`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usuario` (`fk_usuario`),
  ADD KEY `fk_questao` (`fk_questao`),
  ADD KEY `fk_prova` (`fk_prova`);

--
-- Índices para tabela `questoes`
--
ALTER TABLE `questoes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_assunto` (`fk_assunto`),
  ADD KEY `fk_provas` (`fk_prova`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `assunto`
--
ALTER TABLE `assunto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `disciplina`
--
ALTER TABLE `disciplina`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de tabela `materia`
--
ALTER TABLE `materia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `prova`
--
ALTER TABLE `prova`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `questao_prova`
--
ALTER TABLE `questao_prova`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `questoes`
--
ALTER TABLE `questoes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `assunto`
--
ALTER TABLE `assunto`
  ADD CONSTRAINT `assunto_ibfk_1` FOREIGN KEY (`fk_disciplina`) REFERENCES `disciplina` (`id`);

--
-- Limitadores para a tabela `materia`
--
ALTER TABLE `materia`
  ADD CONSTRAINT `materia_ibfk_1` FOREIGN KEY (`fk_disciplina`) REFERENCES `disciplina` (`id`);

--
-- Limitadores para a tabela `prova`
--
ALTER TABLE `prova`
  ADD CONSTRAINT `fk_professor` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`id`);

--
-- Limitadores para a tabela `questao_prova`
--
ALTER TABLE `questao_prova`
  ADD CONSTRAINT `fk_prova` FOREIGN KEY (`fk_prova`) REFERENCES `prova` (`id`),
  ADD CONSTRAINT `fk_questao` FOREIGN KEY (`fk_questao`) REFERENCES `questoes` (`id`),
  ADD CONSTRAINT `fk_usuario` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`id`);

--
-- Limitadores para a tabela `questoes`
--
ALTER TABLE `questoes`
  ADD CONSTRAINT `fk_assunto` FOREIGN KEY (`fk_assunto`) REFERENCES `assunto` (`id`),
  ADD CONSTRAINT `fk_provas` FOREIGN KEY (`fk_prova`) REFERENCES `prova` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
