-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 12 mars 2024 à 19:02
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_courrier`
--

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `num_client` varchar(255) NOT NULL,
  `nom_client` varchar(255) NOT NULL,
  `prenom_client` varchar(255) NOT NULL,
  `phone_client` varchar(255) NOT NULL,
  `type_piece_client` varchar(200) NOT NULL DEFAULT '--- does not exist  ---',
  `num_piece_client` varchar(200) NOT NULL DEFAULT '--- does not exist ---'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`id`, `num_client`, `nom_client`, `prenom_client`, `phone_client`, `type_piece_client`, `num_piece_client`) VALUES
(1, 'E-304015', 'lankoande', 'urbain', '12 34 56 78', 'CNIB', 'B34567789'),
(2, 'D-272251', 'Deza', 'Serge', '98 76 54 76', 'not presence', 'not presence'),
(3, 'E-644689', 'Kone', 'Andre', '12 34 56 78', 'Paspoot', '56789876545345'),
(4, 'D-764095', 'Ouedraogo', 'Salif', '23 45 67 89', 'not presence', 'not presence'),
(5, 'E-805058', 'Diallo', 'Issa', '98 76 54 34', 'CNIB', 'B32492348'),
(6, 'D-989929', 'Kabore', 'Moussa', '57 48 43 74', 'not presence', 'not presence'),
(7, 'E-345395', 'Hien', 'Julien', '12 34 56 77', 'CNIB', 'B456789876'),
(8, 'D-339875', 'Toure', 'Oumou', '87 65 43 21', 'not presence', 'not presence'),
(9, 'R-487977', 'Deza', 'Pierre', '12 34 56 77', 'Passeport', 'b595b59nm5'),
(13, 'R-110782', 'Ouedraogo', 'Ami', '12 34 56 74', 'CNIB', 'B94387334'),
(14, 'R-230291', 'Lankoande', 'Urbain', '12 34 56 78', 'CNIB', 'B56789876'),
(18, 'E-610193', 'toto', 'toto', '85 26 25 26', 'CNIB', 'b786523'),
(19, 'D-498720', 'tata', 'tata', '75 39 51 56', 'not presence', 'not presence'),
(20, 'E-836793', 'Tindano', 'Talara', '78 45 62 30', 'Passport', 'ec5de7vcde'),
(21, 'D-908521', 'Ouoba', 'Henri', '78 95 62 39', 'not presence', 'not presence'),
(22, 'E-435751', 'Traore', 'Kadi', '78 94 56 11', 'CNIB', 'b7846255555'),
(23, 'D-779834', 'Davadogo', 'Mari', '32 16 54 98', 'not presence', 'not presence'),
(24, 'E-948785', 'Kabore', 'Ami', '78 94 56 23', 'CNIB', 'v894165446515'),
(25, 'D-279666', 'Nana', 'Francis', '58 74 19 63', 'not presence', 'not presence');

-- --------------------------------------------------------

--
-- Structure de la table `courriers`
--

CREATE TABLE `courriers` (
  `id` int(11) NOT NULL,
  `num_courrier` varchar(200) NOT NULL,
  `type_courrier` varchar(200) NOT NULL,
  `poids_courrier` varchar(200) NOT NULL,
  `destination_courrier` varchar(200) NOT NULL,
  `provenance_courrier` varchar(100) DEFAULT NULL,
  `prix_facturer_courrier` varchar(200) NOT NULL,
  `date_envoie_courrier` varchar(200) NOT NULL,
  `num_expediteur_courrier` varchar(200) NOT NULL,
  `num_destinateur_courrier` varchar(200) NOT NULL,
  `date_recuperer_courrier` varchar(200) NOT NULL DEFAULT 'Not defined',
  `num_recuperateur_courrier` varchar(200) NOT NULL DEFAULT 'Not defined',
  `status_courrier` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `courriers`
--

INSERT INTO `courriers` (`id`, `num_courrier`, `type_courrier`, `poids_courrier`, `destination_courrier`, `provenance_courrier`, `prix_facturer_courrier`, `date_envoie_courrier`, `num_expediteur_courrier`, `num_destinateur_courrier`, `date_recuperer_courrier`, `num_recuperateur_courrier`, `status_courrier`) VALUES
(3, 'C-545297', 'sac', '15', 'Ouaga', 'Bobo', '15825.0', '23/02/2024', 'E-304015', 'D-272251', 'Not presence', 'Not presence', 'RECUPERER'),
(4, 'C-502803', 'enveloppe', '1', 'BOBO', 'Ouaga', '1055.0', '23/02/2024', 'E-644689', 'D-764095', '01/03/2024', 'R-230291', 'RECUPERER'),
(5, 'C-295958', 'sac ', '12.5', 'Ouaga', 'Dori', '13187.5', '23/02/2024', 'E-805058', 'D-989929', '15-03-2024', 'R-110782', 'NON RECUPERER'),
(6, 'C-542017', 'Envelope', '0.7', 'Kaya', 'Koudougou', '738.5', '12/01/2024', 'E-345395', 'D-339875', 'Not defined', 'Not defined', 'NON_RECUPERER'),
(8, 'C-284856', 'sac', '15', 'Ouaga', 'Bobo', '15825.0', '01/03/2022', 'E-610193', 'D-498720', 'Not defined', 'Not defined', 'NON_RECUPERER'),
(9, 'C-635258', 'enveloppe', '0.4', 'Fada', 'Bogande', '422.0', '01/02/2022', 'E-836793', 'D-908521', 'Not defined', 'Not defined', 'NON_RECUPERER'),
(10, 'C-803428', 'Moto', '75', 'Ouaga', 'Kaya', '79125.0', '01/02/2022', 'E-435751', 'D-779834', 'Not defined', 'Not defined', 'NON_RECUPERER'),
(11, 'C-721646', 'sac', '5.2', 'Bobo', 'Ouaga', '5486.0', '12/03/2024', 'E-948785', 'D-279666', 'Not defined', 'Not defined', 'NON_RECUPERER');

-- --------------------------------------------------------

--
-- Structure de la table `num_unique`
--

CREATE TABLE `num_unique` (
  `id` int(11) NOT NULL,
  `num_uniq` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `num_unique`
--

INSERT INTO `num_unique` (`id`, `num_uniq`) VALUES
(27, '110782'),
(4, '128966'),
(40, '163004'),
(1, '210903'),
(25, '221164'),
(28, '230291'),
(2, '256429'),
(13, '272251'),
(56, '279666'),
(44, '284856'),
(17, '295958'),
(12, '304015'),
(37, '334179'),
(22, '339875'),
(21, '345395'),
(6, '404426'),
(51, '435751'),
(23, '487977'),
(46, '498720'),
(14, '502803'),
(39, '503843'),
(7, '508584'),
(3, '523077'),
(5, '531302'),
(20, '542017'),
(11, '545297'),
(8, '564820'),
(29, '571528'),
(9, '573636'),
(10, '582383'),
(33, '587961'),
(32, '593964'),
(41, '596570'),
(45, '610193'),
(35, '618650'),
(47, '635258'),
(57, '635687'),
(59, '642344'),
(15, '644689'),
(36, '648221'),
(54, '721646'),
(30, '729850'),
(24, '742231'),
(16, '764095'),
(42, '775095'),
(52, '779834'),
(50, '803428'),
(18, '805058'),
(34, '812532'),
(48, '836793'),
(26, '836859'),
(58, '864398'),
(49, '908521'),
(53, '943495'),
(55, '948785'),
(31, '974001'),
(38, '974393'),
(19, '989929'),
(43, '998744');

-- --------------------------------------------------------

--
-- Structure de la table `operations`
--

CREATE TABLE `operations` (
  `id` int(11) NOT NULL,
  `num_user` varchar(200) NOT NULL,
  `num_operation` varchar(200) NOT NULL,
  `description_operateur` text NOT NULL,
  `date_operation` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `prix_poids`
--

CREATE TABLE `prix_poids` (
  `id` int(11) NOT NULL,
  `prix_poid` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `prix_poids`
--

INSERT INTO `prix_poids` (`id`, `prix_poid`) VALUES
(1, 1266);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `num_user` varchar(200) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `prenom` varchar(200) NOT NULL,
  `phone` varchar(200) NOT NULL,
  `type_piece` varchar(255) NOT NULL,
  `num_piece` varchar(200) NOT NULL,
  `user_name` varchar(200) DEFAULT NULL,
  `user_pass` varchar(200) DEFAULT NULL,
  `role` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `num_user`, `nom`, `prenom`, `phone`, `type_piece`, `num_piece`, `user_name`, `user_pass`, `role`) VALUES
(1, 'U-050802', 'Lankoande', 'Urbain', '67 52 92 11', 'CNIB', 'b348943rhf0834', 'lankoande', 'PrinceAdmin', 'ADMINISTRATEUR'),
(3, 'U-334179', 'admin', 'admin', '44 44 44 44', 'PASSEPORT', 'r87dc8d98', 'admin', 'admin', 'EMPLOYER'),
(5, 'U-642344', 'Deza', 'Serge', '89 55 55 55', 'CNIB', '846515226', 'deza', '123456', 'EMPLOYER');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uniq_num_client` (`num_client`);

--
-- Index pour la table `courriers`
--
ALTER TABLE `courriers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `num_courrier` (`num_courrier`);

--
-- Index pour la table `num_unique`
--
ALTER TABLE `num_unique`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `num_uniq` (`num_uniq`);

--
-- Index pour la table `operations`
--
ALTER TABLE `operations`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `prix_poids`
--
ALTER TABLE `prix_poids`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `num_user` (`num_user`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT pour la table `courriers`
--
ALTER TABLE `courriers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `num_unique`
--
ALTER TABLE `num_unique`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT pour la table `prix_poids`
--
ALTER TABLE `prix_poids`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
