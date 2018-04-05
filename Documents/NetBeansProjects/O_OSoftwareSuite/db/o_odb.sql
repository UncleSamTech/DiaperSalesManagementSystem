-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 04, 2017 at 11:29 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `o_odb`
--

-- --------------------------------------------------------

--
-- Table structure for table `customertable`
--

CREATE TABLE IF NOT EXISTS `customertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(200) NOT NULL,
  `customerType` varchar(200) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `customer_id` varchar(100) NOT NULL,
  `date` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `customertable`
--

INSERT INTO `customertable` (`id`, `fullName`, `customerType`, `phone`, `customer_id`, `date`) VALUES
(1, 'Default', 'Default', 'Default', 'Default', 'default');

-- --------------------------------------------------------

--
-- Table structure for table `dailysales`
--

CREATE TABLE IF NOT EXISTS `dailysales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(200) NOT NULL,
  `customer_id` varchar(100) NOT NULL,
  `itemSold` varchar(200) NOT NULL,
  `unitPrice` double NOT NULL,
  `qtySold` int(11) NOT NULL,
  `invoiceAmount` double NOT NULL,
  `invoiceNo` int(11) NOT NULL,
  `prodId` varchar(200) NOT NULL,
  `receiptNo` int(11) NOT NULL,
  `date` varchar(200) NOT NULL,
  `location` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `dailysales`
--

INSERT INTO `dailysales` (`id`, `fullName`, `customer_id`, `itemSold`, `unitPrice`, `qtySold`, `invoiceAmount`, `invoiceNo`, `prodId`, `receiptNo`, `date`, `location`) VALUES
(1, 'Default', 'Default', 'Default', 0, 0, 0, 0, 'Default', 0, 'default', 'Default');

-- --------------------------------------------------------

--
-- Table structure for table `manager_login`
--

CREATE TABLE IF NOT EXISTS `manager_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(200) NOT NULL,
  `user_name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `manager_login`
--

INSERT INTO `manager_login` (`id`, `manager_name`, `user_name`, `password`) VALUES
(1, 'Samuel', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `pamp_warehouse`
--

CREATE TABLE IF NOT EXISTS `pamp_warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(200) NOT NULL,
  `location` varchar(200) NOT NULL,
  `prod_type` varchar(200) NOT NULL,
  `qty_in_stock` int(100) NOT NULL DEFAULT '0',
  `unit_price` double NOT NULL DEFAULT '0',
  `prod_id` varchar(200) NOT NULL,
  `amt_equivalent` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `pamp_warehouse`
--

INSERT INTO `pamp_warehouse` (`id`, `date`, `location`, `prod_type`, `qty_in_stock`, `unit_price`, `prod_id`, `amt_equivalent`) VALUES
(1, ' 4/ 4/ 2017', 'WareHouse', 'CARRY PACK NEW BORN(12 * 10)', 0, 0, 'RY PACK NEW BORN(12 * 10)010\n', 0),
(2, ' 4/ 4/ 2017', 'WareHouse', 'CARRY PACK MINI(10 * 10)', 0, 0, 'RY PACK MINI(10 * 10)010\n', 0),
(3, ' 4/ 4/ 2017', 'WareHouse', 'CARRY PACK MEDIUM(9 * 10)', 0, 0, 'RY PACK MEDIUM(9 * 10)010\n', 0),
(4, ' 4/ 4/ 2017', 'WareHouse', 'CARRY PACK MAXI(8 * 10)', 0, 0, 'RY PACK MAXI(8 * 10)010\n', 0),
(5, ' 4/ 4/ 2017', 'WareHouse', 'CARRY PACK JNR(7 * 10)', 0, 0, 'RY PACK JNR(7 * 10)010\n', 0),
(6, ' 4/ 4/ 2017', 'WareHouse', 'ECO PACK NEW BORN(52 * 4)', 0, 0, ' PACK NEW BORN(52 * 4)010\n', 0),
(7, ' 4/ 4/ 2017', 'WareHouse', 'ECO PACK MINI(42 * 4)', 0, 0, ' PACK MINI(42 * 4)010\n', 0),
(8, ' 4/ 4/ 2017', 'WareHouse', 'ECO PACK MEDIUM(38 * 4)', 0, 0, ' PACK MEDIUM(38 * 4)010\n', 0),
(9, ' 4/ 4/ 2017', 'WareHouse', 'ECO  PACK MAXI(34 * 4)', 0, 0, '  PACK MAXI(34 * 4)010\n', 0),
(10, ' 4/ 4/ 2017', 'WareHouse', 'ECO PACK JNR(30 * 4)', 0, 0, ' PACK JNR(30 * 4)010\n', 0),
(11, ' 4/ 4/ 2017', 'WareHouse', 'JUMBO PACK NEW BORN(105 * 3)', 0, 0, 'BO PACK NEW BORN(105 * 3)010\n', 0),
(12, ' 4/ 4/ 2017', 'WareHouse', 'JUMBO PACK MINI(100 * 3)', 0, 0, 'BO PACK MINI(100 * 3)010\n', 0),
(13, ' 4/ 4/ 2017', 'WareHouse', 'JUMBO PACK MEDIUM(92 * 3)', 0, 0, 'BO PACK MEDIUM(92 * 3)010\n', 0),
(14, ' 4/ 4/ 2017', 'WareHouse', 'JUMBO PACK MAXI(84 * 3)', 0, 0, 'BO PACK MAXI(84 * 3)010\n', 0),
(15, ' 4/ 4/ 2017', 'WareHouse', 'JUMBO PACK JNR(74 * 3)', 0, 0, 'BO PACK JNR(74 * 3)010\n', 0);

-- --------------------------------------------------------

--
-- Table structure for table `staff_login`
--

CREATE TABLE IF NOT EXISTS `staff_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `branch_name` varchar(200) NOT NULL,
  `user_name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `staff_login`
--

INSERT INTO `staff_login` (`id`, `branch_name`, `user_name`, `password`) VALUES
(1, 'Rita', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `totalsales`
--

CREATE TABLE IF NOT EXISTS `totalsales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(100) NOT NULL,
  `amtRec` double NOT NULL,
  `ledgBal` double NOT NULL,
  `totalSales` double NOT NULL,
  `date` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `totalsales`
--

INSERT INTO `totalsales` (`id`, `customer_id`, `amtRec`, `ledgBal`, `totalSales`, `date`) VALUES
(1, 'Default', 0, 0, 0, 'default');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
