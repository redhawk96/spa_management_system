-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2019 at 07:05 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tm`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `email`, `password`) VALUES
('Oshadee_95', 'oshadee@tm.com', '1');

-- --------------------------------------------------------

--
-- Stand-in structure for view `client_info`
-- (See below for the actual view)
--
CREATE TABLE `client_info` (
`client_id` int(11)
,`first_name` varchar(255)
,`last_name` varchar(255)
,`nic` varchar(255)
,`contact_no` int(255)
,`email` varchar(255)
,`spa_name` varchar(255)
,`spa_address` varchar(255)
,`spa_contact` int(255)
,`spa_image` varchar(255)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `client_login`
-- (See below for the actual view)
--
CREATE TABLE `client_login` (
`username` varchar(255)
,`password` varchar(255)
,`first_name` varchar(255)
,`last_name` varchar(255)
);

-- --------------------------------------------------------

--
-- Table structure for table `spa`
--

CREATE TABLE `spa` (
  `package_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `spa_category` varchar(255) NOT NULL,
  `spa_package` varchar(255) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spa`
--

INSERT INTO `spa` (`package_id`, `client_id`, `spa_category`, `spa_package`, `price`) VALUES
(4, 5, 'Waxing', 'Hand wax', 50),
(5, 5, 'Facial', 'Stone Facial', 67),
(6, 5, 'Facial', 'swedish massage', 200),
(7, 5, 'Body Treatment', 'body polish', 150),
(8, 5, 'Facial', 'eye contour', 44),
(9, 5, 'Waxing', 'shoulder  wax', 77),
(11, 5, 'Waxing', 'full leg wax', 88),
(12, 5, 'Body Treatment', 'airbrush tan body polish', 200),
(13, 5, 'Body Treatment', 'aroma salt tan body polish', 100),
(14, 5, 'Massage Therapy', 'Swedish Massage ', 205),
(15, 5, 'Massage Therapy', 'Deep Tissue Massage ', 250),
(16, 5, 'Massage Therapy', 'Aromatic Wellness Massage ', 150),
(17, 5, 'Massage Therapy', 'Deluxe Swedish Massage ', 170),
(18, 2, 'Waxing', 'Facila', 20),
(19, 2, 'Waxing', 'Hand wax', 50),
(20, 2, 'Facial', 'Stone Facial', 67),
(21, 5, 'Facial', 'swedish massage', 200),
(22, 2, 'Body Treatment', 'body polish', 150),
(23, 2, 'Facial', 'eye contour', 44),
(24, 2, 'Waxing', 'shoulder  wax', 77),
(25, 2, 'Waxing', 'full leg wax', 88),
(26, 2, 'Body Treatment', 'airbrush tan body polish', 200),
(27, 2, 'Body Treatment', 'aroma salt tan body polish', 100),
(28, 2, 'Massage Therapy', 'Swedish Massage ', 205),
(29, 2, 'Massage Therapy', 'Deep Tissue Massage ', 250),
(30, 2, 'Massage Therapy', 'Aromatic Wellness Massage ', 150),
(31, 2, 'Massage Therapy', 'Deluxe Swedish Massage ', 170);

-- --------------------------------------------------------

--
-- Table structure for table `spa_clients`
--

CREATE TABLE `spa_clients` (
  `client_id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `nic` varchar(255) NOT NULL,
  `contact_no` int(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `spa_name` varchar(255) NOT NULL,
  `spa_address` varchar(255) NOT NULL,
  `spa_contact` int(255) NOT NULL,
  `spa_image` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spa_clients`
--

INSERT INTO `spa_clients` (`client_id`, `username`, `first_name`, `last_name`, `nic`, `contact_no`, `email`, `spa_name`, `spa_address`, `spa_contact`, `spa_image`, `password`) VALUES
(2, 'amaya', 'dilani', 'gunawardana', '957855402v', 771396017, 'dilani@gmail.com', 'amaya', 'rajagiriya', 114266789, './/amaya.jpg', '2'),
(3, 'paradise garden', 'pavithra', 'wejesinghe', '906546782v', 112779435, 'pavitha@gmail.com', 'paradise garden', 'galle', 912343345, './/paradise garden', '7'),
(5, 'olu', 'kalani', 'silva', '965543275v', 712343456, 'kalanilakshani64@gmail.com', 'olu', 'kaluthara', 112345436, './/olu.jpg', '5'),
(6, 'ceylon', 'thisari', 'perera', '965546734v', 754324367, 'thisari@gmail.com', 'ceylon', 'kaduwela', 112343234, './/ceylon.jpg', '1'),
(7, 'lotus', 'wathisha', 'amrasinghe', '904532124v', 723456780, 'wathisha@gmail.com', 'lotus', 'thalawathugoda', 112356745, './/lotus.jpg', '1'),
(8, 'sea', 'dulana', 'mahindarathna', '964534234v', 723435678, 'dulana@gmail.com', 'sea', 'unawatuna', 112453264, './/sea@gmail.com', '6'),
(10, 'HoneyComb', 'Oshadee', 'Anuththara', '950458705V', 770897025, 'oshadeeamarasinghe@gmail.com', 'Honey Comb', 'Thalawathugoda', 117821504, '../honeyComb.jpg', '1');

-- --------------------------------------------------------

--
-- Structure for view `client_info`
--
DROP TABLE IF EXISTS `client_info`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `client_info`  AS  select `spa_clients`.`client_id` AS `client_id`,`spa_clients`.`first_name` AS `first_name`,`spa_clients`.`last_name` AS `last_name`,`spa_clients`.`nic` AS `nic`,`spa_clients`.`contact_no` AS `contact_no`,`spa_clients`.`email` AS `email`,`spa_clients`.`spa_name` AS `spa_name`,`spa_clients`.`spa_address` AS `spa_address`,`spa_clients`.`spa_contact` AS `spa_contact`,`spa_clients`.`spa_image` AS `spa_image` from `spa_clients` ;

-- --------------------------------------------------------

--
-- Structure for view `client_login`
--
DROP TABLE IF EXISTS `client_login`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `client_login`  AS  select `spa_clients`.`username` AS `username`,`spa_clients`.`password` AS `password`,`spa_clients`.`first_name` AS `first_name`,`spa_clients`.`last_name` AS `last_name` from `spa_clients` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `spa`
--
ALTER TABLE `spa`
  ADD PRIMARY KEY (`package_id`) USING BTREE,
  ADD KEY `fk_client_id` (`client_id`);

--
-- Indexes for table `spa_clients`
--
ALTER TABLE `spa_clients`
  ADD PRIMARY KEY (`client_id`),
  ADD UNIQUE KEY `nic` (`nic`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `spa`
--
ALTER TABLE `spa`
  MODIFY `package_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `spa_clients`
--
ALTER TABLE `spa_clients`
  MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `spa`
--
ALTER TABLE `spa`
  ADD CONSTRAINT `fk_client_id` FOREIGN KEY (`client_id`) REFERENCES `spa_clients` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
