-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 13, 2023 at 03:16 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `aurthor`
--

CREATE TABLE `aurthor` (
  `aurthor_id` int(10) NOT NULL,
  `aurthor_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `aurthor`
--

INSERT INTO `aurthor` (`aurthor_id`, `aurthor_name`) VALUES
(1, 'Philip Pullman'),
(2, 'Lufy Foley'),
(3, 'Samrat Upadhyay'),
(4, 'Haruki Murakami'),
(5, 'Pico Iyer'),
(6, 'Saru Bhakta'),
(7, 'Subin Bhattrai'),
(8, 'Anne Frank'),
(9, 'Elie Wiesel'),
(10, 'Napolean Hill'),
(11, 'Mel Robbins');

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `bill_no` int(10) NOT NULL,
  `uid` int(10) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `customer` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`bill_no`, `uid`, `date`, `customer`) VALUES
(1, 2, '2022-04-10', 'Hello'),
(2, 2, '2022-04-10', 'Hello'),
(3, 2, '2020-05-10', 'JJD'),
(4, 2, '2020-05-10', 'JJD'),
(5, 1, '2022-04-13', 'Rikesh Maharjan'),
(6, 1, '2022-04-13', 'asdf'),
(7, 1, '2022-04-13', 'sdsasdf'),
(8, 1, '2022-04-13', 'asdfasdf'),
(9, 1, '2022-04-15', 'asdfasdf'),
(10, 1, '2022-04-15', 'adsfdasdf'),
(11, 1, '2022-04-15', 'asdfasdf'),
(12, 1, '2022-04-15', 'adsfasdf'),
(13, 1, '2022-04-15', 'werwe'),
(14, 1, '2022-04-15', 'sdfsd'),
(15, 1, '2022-04-15', 'ghjhgg'),
(16, 1, '2022-04-15', 'hjkhj'),
(17, 1, '2022-04-15', 'jkhjfg'),
(18, 1, '2022-04-15', 'fgjfgjh'),
(19, 1, '2022-04-24', 'asdf'),
(20, 1, '2022-04-25', ''),
(21, 1, '2022-04-25', ''),
(22, 1, '2022-04-25', 'adsfasdfd'),
(23, 1, '2022-04-25', 'dsfgasdf'),
(24, 1, '2022-04-25', 'sdafasf'),
(25, 1, '2022-04-25', 'asdf'),
(26, 1, '2022-04-25', 'asdf'),
(27, 1, '2022-04-26', 'addsf'),
(28, 1, '2022-04-29', 'asdfasdf'),
(29, 1, '2022-04-29', 'asdfasd'),
(30, 2, '2022-04-29', 'asdfasd'),
(31, 1, '2022-04-29', 'gopal'),
(32, 1, '2022-04-29', 'gopal'),
(33, 1, '2022-04-29', 'Gopal');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `book_id` int(10) NOT NULL,
  `book_title` varchar(100) NOT NULL,
  `cat_id` int(10) DEFAULT NULL,
  `quantity` bigint(100) NOT NULL CHECK (`quantity` > -1),
  `price` bigint(100) NOT NULL CHECK (`price` > 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `book_title`, `cat_id`, `quantity`, `price`) VALUES
(1, 'The Ruby in the Smoke', 2, 12, 550),
(2, 'The Guest List', 2, 13, 550),
(3, 'Mad Country', 1, 33, 500),
(4, 'Men Without Women', 1, 19, 1280),
(5, 'The Open Road', 6, 26, 500),
(6, 'First Person Singular', 1, 199, 1000),
(7, 'Pagal Basti', 3, 40, 474),
(8, 'Saaya', 3, 34, 400),
(9, 'The Diary of a Young Girl', 4, 25, 250),
(10, 'Night', 5, 5, 550),
(11, 'Think and Grow Rich', 7, 21, 1500),
(12, 'The 5 Second Rule', 7, 25, 700),
(13, 'Lyrax Oxford', 1, 2, 500),
(14, 'Summer Love', 3, 32, 300),
(15, 'Once Upon a Time in the North', 1, 33, 100),
(16, 'The Mouse', 1, 20, 500),
(17, 'The Monitor', 1, 355, 550);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `cat_id` int(10) NOT NULL,
  `cat_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cat_id`, `cat_name`) VALUES
(1, 'short stories'),
(2, 'thriller'),
(3, 'romance'),
(4, 'history'),
(5, 'autobiography'),
(6, 'biography'),
(7, 'self-help'),
(8, 'motivational'),
(9, 'religion');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `date` date DEFAULT NULL,
  `message` varchar(200) DEFAULT NULL,
  `time` time DEFAULT NULL,
  `book` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`date`, `message`, `time`, `book`) VALUES
('2022-04-29', '6 | First Person Singular is High on Stock. Currently 199 in stock', '21:54:33', 'First Person Singular'),
('2022-04-29', '10 | Night is Low on Stock. Currently 5 in stock', '22:22:34', 'Night'),
('2022-04-29', '13 | Lyrax Oxford is Low on Stock. Currently 2 in stock', '22:23:30', 'Lyrax Oxford'),
('2022-04-29', '17 | The Monitor is High on Stock. Currently 355 in stock', '22:28:04', 'The Monitor');

-- --------------------------------------------------------

--
-- Table structure for table `org`
--

CREATE TABLE `org` (
  `pan_no` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `location` varchar(100) DEFAULT NULL,
  `contact_no` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `org`
--

INSERT INTO `org` (`pan_no`, `name`, `location`, `contact_no`) VALUES
('602977357', 'United Book', 'Jyatha, Thamel, Kathmandu', '01-4242921');

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

CREATE TABLE `profile` (
  `profile_id` int(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `contact` varchar(15) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `profile`
--

INSERT INTO `profile` (`profile_id`, `name`, `contact`, `address`, `gender`) VALUES
(1, 'Tom Tom', '9878765677', 'Nardevi', 'Male'),
(2, 'Sam Sam', '9898989898', 'Paknajol', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `pid` int(10) NOT NULL,
  `b_id` int(10) DEFAULT NULL,
  `size` int(10) DEFAULT NULL,
  `rate` int(10) DEFAULT NULL,
  `supplier_id` int(10) DEFAULT NULL,
  `pdate` date DEFAULT NULL,
  `u_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`pid`, `b_id`, `size`, `rate`, `supplier_id`, `pdate`, `u_id`) VALUES
(1, 15, 123, 123, 1, '2022-04-08', 2),
(2, 15, 77, 123, 1, '2022-04-08', 2),
(3, 1, 6, 550, 1, '2022-04-25', 1),
(4, 15, 200, 100, 1, '2022-04-25', 1),
(5, 15, 100, 100, 1, '2022-04-25', 1),
(6, 15, 15, 100, 1, '2022-04-26', 1),
(7, 15, 144, 100, 1, '2022-04-26', 1),
(8, 15, 15, 100, 1, '2022-04-26', 1),
(9, 15, 5, 100, 1, '2022-04-26', 1),
(10, 11, 15, 1500, 1, '2022-04-29', 1),
(11, 16, 55, 500, 1, '2022-04-29', 1),
(12, 16, 15, 500, 1, '2022-04-29', 1),
(13, 17, 355, 550, 1, '2022-04-29', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `sales_id` int(10) NOT NULL,
  `book_id` int(10) DEFAULT NULL,
  `quantity` int(10) DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  `bill_no` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`sales_id`, `book_id`, `quantity`, `price`, `bill_no`) VALUES
(1, 1, 1, 550, 1),
(2, 3, 1, 500, 2),
(3, 8, 123, 400, 5),
(6, 2, 12, 550, 5),
(7, 3, 12, 500, 5),
(8, 1, 12, 550, 6),
(9, 7, 1, 474, 7),
(10, 1, 1, 550, 8),
(11, 5, 1, 500, 9),
(12, 5, 1, 500, 10),
(13, 5, 1, 500, 11),
(14, 5, 1, 500, 12),
(15, 5, 1, 500, 13),
(16, 7, 1, 474, 14),
(17, 7, 1, 474, 15),
(18, 7, 1, 474, 16),
(19, 7, 1, 474, 17),
(20, 7, 1, 474, 18),
(21, 15, 1, 123, 19),
(22, 15, 1, 123, 20),
(23, 15, 1, 123, 21),
(24, 15, 1, 123, 22),
(25, 15, 110, 123, 23),
(26, 15, 110, 100, 24),
(27, 15, 110, 100, 25),
(28, 15, 3, 100, 26),
(29, 15, 144, 100, 27),
(30, 1, 1, 550, 28),
(31, 12, 12, 700, 28),
(32, 1, 1, 550, 29),
(33, 1, 2, 550, 29),
(34, 1, 1, 550, 30),
(35, 1, 1, 550, 31),
(36, 5, 1, 500, 31),
(37, 1, 1, 550, 32),
(38, 5, 1, 500, 32),
(39, 1, 1, 550, 33),
(40, 5, 1, 500, 33),
(41, 14, 1, 300, 33);

-- --------------------------------------------------------

--
-- Table structure for table `selected_user`
--

CREATE TABLE `selected_user` (
  `suid` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supplier_id` int(10) NOT NULL,
  `supplier_name` varchar(100) NOT NULL,
  `supplier_address` varchar(100) NOT NULL,
  `supplier_phone` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplier_id`, `supplier_name`, `supplier_address`, `supplier_phone`) VALUES
(1, 'supA', 'Teku', '9890987654'),
(2, 'supB', 'Hadigaun', '9810293847');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `U_id` int(5) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(1000) NOT NULL,
  `access_level` varchar(50) DEFAULT NULL,
  `profile_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`U_id`, `username`, `password`, `access_level`, `profile_id`) VALUES
(1, 'admin', 'admin123', 'admin', 1),
(2, 'tempuser', 'tempuser1', 'seller', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aurthor`
--
ALTER TABLE `aurthor`
  ADD PRIMARY KEY (`aurthor_id`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`bill_no`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`),
  ADD KEY `cat_id` (`cat_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cat_id`);

--
-- Indexes for table `org`
--
ALTER TABLE `org`
  ADD PRIMARY KEY (`pan_no`);

--
-- Indexes for table `profile`
--
ALTER TABLE `profile`
  ADD PRIMARY KEY (`profile_id`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`pid`),
  ADD KEY `b_id` (`b_id`),
  ADD KEY `supplier_id` (`supplier_id`),
  ADD KEY `fk_user_U_id` (`u_id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`sales_id`),
  ADD KEY `book_id` (`book_id`),
  ADD KEY `bill_no` (`bill_no`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supplier_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`U_id`),
  ADD KEY `profile_id` (`profile_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aurthor`
--
ALTER TABLE `aurthor`
  MODIFY `aurthor_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `bill_no` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `cat_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `profile`
--
ALTER TABLE `profile`
  MODIFY `profile_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `pid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `sales_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `U_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`U_id`);

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`);

--
-- Constraints for table `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `fk_user_U_id` FOREIGN KEY (`u_id`) REFERENCES `user` (`U_id`),
  ADD CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`b_id`) REFERENCES `book` (`book_id`),
  ADD CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`);

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  ADD CONSTRAINT `sales_ibfk_2` FOREIGN KEY (`bill_no`) REFERENCES `bill` (`bill_no`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`profile_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
