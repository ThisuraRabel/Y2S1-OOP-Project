-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 19, 2020 at 06:53 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hms`
--
CREATE DATABASE IF NOT EXISTS `hms` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `hms`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `admin_no` varchar(5) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `contract_number` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`admin_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_no`, `first_name`, `last_name`, `username`, `password`, `contract_number`, `email`) VALUES
('AD001', 'Trent', 'Bolt', 'Bolt1111', 'br', '0716782113', 'TrentBolt@gmail.com'),
('AD002', 'q', 'f', 'q', 'q', 'q', 'q'),
('AD003', 'fgh', 'bh', 'b', 'n', '822', 'v');

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
CREATE TABLE IF NOT EXISTS `appointment` (
  `appointment_no` varchar(10) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL,
  `fee` int(10) NOT NULL,
  `date` varchar(20) NOT NULL,
  `contract_num` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `d_user_name` varchar(30) NOT NULL,
  PRIMARY KEY (`appointment_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`appointment_no`, `first_name`, `last_name`, `time`, `fee`, `date`, `contract_num`, `email`, `d_user_name`) VALUES
('AP001', 'dcddcdcd', 'dcd', 'dcc', 12, 'dcdc', '123', 'cdcd', 'dcdc'),
('AP002', 'cdcd', 'dc', 'dcd', 333, 'ddc', 'dccd', 'dccc', 'segg'),
('AP003', 'tvtv', 'tvtv', 'tvt', 2324, 'tvt', 'tvtv', 'rrfr', 'segg');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE IF NOT EXISTS `doctor` (
  `doctor_no` varchar(10) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `contract_number` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `specialization` varchar(50) NOT NULL,
  `qualification` varchar(50) NOT NULL,
  PRIMARY KEY (`doctor_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`doctor_no`, `first_name`, `last_name`, `username`, `password`, `contract_number`, `email`, `specialization`, `qualification`) VALUES
('DR002', 'hbhb', 'dcdc', 'dcc', 'vv', '11', 'ss', 'vvvvv', 'xcd'),
('DR001', 'q', 'qdegerg', 'segg', 'q', 'gf', 'fy', 'vuv', 'fgg'),
('DR003', 'ssss', 'ssss', 'fvv', 'z', '1', 'ff', 'gg', 'vv'),
('DR004', 'gh', 'ghj', 'eegg', 'g', '3443', 'gcu', 'bh', 'cg');

-- --------------------------------------------------------

--
-- Table structure for table `drug`
--

DROP TABLE IF EXISTS `drug`;
CREATE TABLE IF NOT EXISTS `drug` (
  `DrugID` varchar(10) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Type` varchar(10) NOT NULL,
  `Quantity` int(5) NOT NULL,
  `ExpYear` varchar(15) NOT NULL,
  PRIMARY KEY (`DrugID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `drug`
--

INSERT INTO `drug` (`DrugID`, `Name`, `Type`, `Quantity`, `ExpYear`) VALUES
('DG001', 'qq', 'Syrup', 1, '2020'),
('DG002', 'ff', 'Tablet', 3, '2024');

-- --------------------------------------------------------

--
-- Table structure for table `lab_tech`
--

DROP TABLE IF EXISTS `lab_tech`;
CREATE TABLE IF NOT EXISTS `lab_tech` (
  `lab_tech_no` varchar(10) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `contract_number` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`lab_tech_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lab_tech`
--

INSERT INTO `lab_tech` (`lab_tech_no`, `first_name`, `last_name`, `username`, `password`, `contract_number`, `email`) VALUES
('LT001', 'gguig', 'guhi', 'fyguh', 'a', 'gfhj', 'ghj'),
('LT002', 'dgfhjk', 'dtytui', 'f', 'f', 'asdfgh', 'dsfgh');

-- --------------------------------------------------------

--
-- Table structure for table `nurse`
--

DROP TABLE IF EXISTS `nurse`;
CREATE TABLE IF NOT EXISTS `nurse` (
  `nurse_no` varchar(10) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `ward_no` varchar(10) NOT NULL,
  `contract_number` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`nurse_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nurse`
--

INSERT INTO `nurse` (`nurse_no`, `first_name`, `last_name`, `ward_no`, `contract_number`, `email`) VALUES
('NR001', 'www', 'yyyyy', '44', '222', 'fggfgf'),
('NR002', 'hghgh', 'cgvh', '1', '1', 'qqqqqqqqqqq@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `patient_no` varchar(10) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `age` varchar(3) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `nic_num` varchar(15) NOT NULL,
  `contract_num` varchar(10) NOT NULL,
  `patient_type` varchar(20) NOT NULL,
  `ward_no` varchar(20) NOT NULL,
  PRIMARY KEY (`patient_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patient_no`, `first_name`, `last_name`, `age`, `gender`, `nic_num`, `contract_num`, `patient_type`, `ward_no`) VALUES
('PD001', 'ghlj;k', 'ytui', 'k', 'Male', 'fgh', 'ghj', 'OPD Patient', ''),
('PD003', 'L', 'etryy', 'j', 'Male', 'drtyu', 'wertyy', 'OPD Patient', ''),
('PD005', 'ergfe', 'ewr', 'q', 'Male', 'qw', 'qw', 'OPD Patient', '');

-- --------------------------------------------------------

--
-- Table structure for table `pharmasist`
--

DROP TABLE IF EXISTS `pharmasist`;
CREATE TABLE IF NOT EXISTS `pharmasist` (
  `pharmasist_no` varchar(10) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `contract_number` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`pharmasist_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pharmasist`
--

INSERT INTO `pharmasist` (`pharmasist_no`, `first_name`, `last_name`, `username`, `password`, `contract_number`, `email`) VALUES
('PH003', 'tttt', 'nnnn', 'XXXXXX', 'max', '234567890', 'jjj@gmail.com'),
('PH002', 'j', 'vh', 'l', 'l', 'fgh', 'vgh'),
('PH004', 'vbn', 'v', 'fgh', 'q', '3489', 'dfg'),
('PH005', 'zxcv', 'fdghj', 'gfh', '123', '123', 'xfgh');

-- --------------------------------------------------------

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
CREATE TABLE IF NOT EXISTS `prescription` (
  `prescription_no` varchar(10) NOT NULL,
  `patient_name` varchar(30) NOT NULL,
  `age` int(5) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `desease` varchar(50) NOT NULL,
  `discription` varchar(1500) NOT NULL,
  `doctor_name` varchar(30) NOT NULL,
  PRIMARY KEY (`prescription_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prescription`
--

INSERT INTO `prescription` (`prescription_no`, `patient_name`, `age`, `gender`, `desease`, `discription`, `doctor_name`) VALUES
('PR003', 'huh', 2, 'Select', 'ghj', 'ghj', 'huh'),
('PR002', 'ftfy', 2, 'Female', 'dfg', 'fg', 'ftfy'),
('PR004', 'hj', 1, 'Female', 'bn', 'hj', 'hj'),
('PR005', 'ggg', 17, 'Male', 'nnn', 'kkkk', 'ggg');

-- --------------------------------------------------------

--
-- Table structure for table `receptionist`
--

DROP TABLE IF EXISTS `receptionist`;
CREATE TABLE IF NOT EXISTS `receptionist` (
  `receptionist_no` varchar(10) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `contract_number` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`receptionist_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receptionist`
--

INSERT INTO `receptionist` (`receptionist_no`, `first_name`, `last_name`, `username`, `password`, `contract_number`, `email`) VALUES
('RT001', 'wwwX', 'dddd', 'ggg', 'k', '12', 'fffffffff@gmail.com'),
('RT004', 'haha', 'bbb', 'njb', 'b', '234', 'bbb'),
('RT002', 'fyu', 'ghj', 'cgg', 'w', '45', 'fgh'),
('RT003', 'vch', 'vbh', 'v', 'nn', '56', 'vb');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(11) NOT NULL,
  `username` varchar(11) NOT NULL,
  `password` varchar(11) NOT NULL,
  `user_type` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`, `user_type`) VALUES
('001', 'e', 'e', 'Administrator');

-- --------------------------------------------------------

--
-- Table structure for table `ward`
--

DROP TABLE IF EXISTS `ward`;
CREATE TABLE IF NOT EXISTS `ward` (
  `WardNo` varchar(10) NOT NULL,
  `WardType` varchar(20) NOT NULL,
  `DoctorName` varchar(20) NOT NULL,
  `NoOfNurses` int(5) NOT NULL,
  `NoOfBeds` int(5) NOT NULL,
  `NoOfPatients` int(5) NOT NULL,
  PRIMARY KEY (`WardNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ward`
--

INSERT INTO `ward` (`WardNo`, `WardType`, `DoctorName`, `NoOfNurses`, `NoOfBeds`, `NoOfPatients`) VALUES
('WD001', 'Medical Ward', 'segg', 1, 4, 2),
('WD002', 'Cardiology Ward', 'ggg', 12, 13, 12);

-- --------------------------------------------------------

--
-- Table structure for table `worker_t`
--

DROP TABLE IF EXISTS `worker_t`;
CREATE TABLE IF NOT EXISTS `worker_t` (
  `workerID` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `buildingaddress` varchar(100) NOT NULL,
  `phonenumber` varchar(50) NOT NULL,
  PRIMARY KEY (`workerID`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `worker_t`
--

INSERT INTO `worker_t` (`workerID`, `firstname`, `lastname`, `buildingaddress`, `phonenumber`) VALUES
(3, 'thi', 'h', 'h', 'jk'),
(4, 'fgy', 'fg', 'fgu', 'zse'),
(5, 'kav', 'max', 'fff', '4444444');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
