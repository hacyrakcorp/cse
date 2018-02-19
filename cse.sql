-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Lun 19 Février 2018 à 10:43
-- Version du serveur :  5.7.11
-- Version de PHP :  7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cse`
--

-- --------------------------------------------------------

--
-- Structure de la table `appartenirpromotion`
--

CREATE TABLE `appartenirpromotion` (
  `id` int(11) NOT NULL,
  `id_Utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `bulletin`
--

CREATE TABLE `bulletin` (
  `id` int(11) NOT NULL,
  `moyenneGenerale` float DEFAULT NULL,
  `appreciation` longtext,
  `mention` varchar(50) DEFAULT NULL,
  `dateSituation` date DEFAULT NULL,
  `positionGenerale` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `choisirfiliere`
--

CREATE TABLE `choisirfiliere` (
  `id` int(11) NOT NULL,
  `id_Filiere` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `comprendre`
--

CREATE TABLE `comprendre` (
  `id` int(11) NOT NULL,
  `id_Matiere` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

CREATE TABLE `eleve` (
  `age` int(11) DEFAULT NULL,
  `numRue` int(11) DEFAULT NULL,
  `libelleRue` varchar(50) DEFAULT NULL,
  `ville` varchar(25) NOT NULL,
  `codePostal` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

CREATE TABLE `filiere` (
  `id` int(11) NOT NULL,
  `libelle` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

CREATE TABLE `matiere` (
  `id` int(11) NOT NULL,
  `code` varchar(25) NOT NULL,
  `coefficient` float DEFAULT NULL,
  `libelle` varchar(50) NOT NULL,
  `commentaire` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

CREATE TABLE `note` (
  `id` int(11) NOT NULL,
  `note` float NOT NULL,
  `dateSituation` date DEFAULT NULL,
  `coefficient` int(11) NOT NULL,
  `id_Utilisateur` int(11) NOT NULL,
  `id_Utilisateur_1` int(11) NOT NULL,
  `id_TypeEvaluation` int(11) NOT NULL,
  `id_Matiere` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

CREATE TABLE `promotion` (
  `id` int(11) NOT NULL,
  `annee` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `statut`
--

CREATE TABLE `statut` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `statut`
--

INSERT INTO `statut` (`id`, `libelle`) VALUES
(1, 'administrateur'),
(2, 'responsable de filiere');

-- --------------------------------------------------------

--
-- Structure de la table `typeevaluation`
--

CREATE TABLE `typeevaluation` (
  `id` int(11) NOT NULL,
  `libelle` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `motDePasse` varchar(25) NOT NULL,
  `id_Statut` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `motDePasse`, `id_Statut`) VALUES
(1, 'Aliaga', 'Cecile', 'cecile', 1),
(2, 'Miniscloux', 'Anthony', 'anthony', 2);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `appartenirpromotion`
--
ALTER TABLE `appartenirpromotion`
  ADD PRIMARY KEY (`id`,`id_Utilisateur`),
  ADD KEY `FK_appartenirPromotion_id_Utilisateur` (`id_Utilisateur`);

--
-- Index pour la table `bulletin`
--
ALTER TABLE `bulletin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `choisirfiliere`
--
ALTER TABLE `choisirfiliere`
  ADD PRIMARY KEY (`id`,`id_Filiere`),
  ADD KEY `FK_choisirFiliere_id_Filiere` (`id_Filiere`);

--
-- Index pour la table `comprendre`
--
ALTER TABLE `comprendre`
  ADD PRIMARY KEY (`id`,`id_Matiere`),
  ADD KEY `FK_comprendre_id_Matiere` (`id_Matiere`);

--
-- Index pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `filiere`
--
ALTER TABLE `filiere`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `note`
--
ALTER TABLE `note`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Note_id_Utilisateur` (`id_Utilisateur`),
  ADD KEY `FK_Note_id_Utilisateur_1` (`id_Utilisateur_1`),
  ADD KEY `FK_Note_id_TypeEvaluation` (`id_TypeEvaluation`),
  ADD KEY `FK_Note_id_Matiere` (`id_Matiere`);

--
-- Index pour la table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `statut`
--
ALTER TABLE `statut`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `typeevaluation`
--
ALTER TABLE `typeevaluation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Utilisateur_id_Statut` (`id_Statut`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `bulletin`
--
ALTER TABLE `bulletin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `filiere`
--
ALTER TABLE `filiere`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `matiere`
--
ALTER TABLE `matiere`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `note`
--
ALTER TABLE `note`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `promotion`
--
ALTER TABLE `promotion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `statut`
--
ALTER TABLE `statut`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `typeevaluation`
--
ALTER TABLE `typeevaluation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `appartenirpromotion`
--
ALTER TABLE `appartenirpromotion`
  ADD CONSTRAINT `FK_appartenirPromotion_id` FOREIGN KEY (`id`) REFERENCES `promotion` (`id`),
  ADD CONSTRAINT `FK_appartenirPromotion_id_Utilisateur` FOREIGN KEY (`id_Utilisateur`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `choisirfiliere`
--
ALTER TABLE `choisirfiliere`
  ADD CONSTRAINT `FK_choisirFiliere_id` FOREIGN KEY (`id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FK_choisirFiliere_id_Filiere` FOREIGN KEY (`id_Filiere`) REFERENCES `filiere` (`id`);

--
-- Contraintes pour la table `comprendre`
--
ALTER TABLE `comprendre`
  ADD CONSTRAINT `FK_comprendre_id` FOREIGN KEY (`id`) REFERENCES `bulletin` (`id`),
  ADD CONSTRAINT `FK_comprendre_id_Matiere` FOREIGN KEY (`id_Matiere`) REFERENCES `matiere` (`id`);

--
-- Contraintes pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `FK_Eleve_id` FOREIGN KEY (`id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `FK_Note_id_Matiere` FOREIGN KEY (`id_Matiere`) REFERENCES `matiere` (`id`),
  ADD CONSTRAINT `FK_Note_id_TypeEvaluation` FOREIGN KEY (`id_TypeEvaluation`) REFERENCES `typeevaluation` (`id`),
  ADD CONSTRAINT `FK_Note_id_Utilisateur` FOREIGN KEY (`id_Utilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FK_Note_id_Utilisateur_1` FOREIGN KEY (`id_Utilisateur_1`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK_Utilisateur_id_Statut` FOREIGN KEY (`id_Statut`) REFERENCES `statut` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
