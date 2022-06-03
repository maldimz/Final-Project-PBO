-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2022 at 09:00 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parking_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `recap`
--

CREATE TABLE `recap` (
  `id` int(11) NOT NULL,
  `license` varchar(20) NOT NULL,
  `type` varchar(10) NOT NULL,
  `price` bigint(20) NOT NULL DEFAULT 0,
  `in_time` datetime NOT NULL,
  `out_time` datetime DEFAULT NULL,
  `user_id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `recap`
--

INSERT INTO `recap` (`id`, `license`, `type`, `price`, `in_time`, `out_time`, `user_id`) VALUES
(1, 'AB1111EE', 'car', 9000, '2022-06-02 23:18:40', '2022-06-03 01:41:38', 'maulana'),
(2, 'AB3333AA', 'motorcycle', 2000, '2022-06-02 23:47:15', '2022-06-03 00:44:45', 'maulana'),
(3, 'AB3333XX', 'motorcycle', 2000, '2022-06-03 01:04:32', '2022-06-03 01:04:44', 'maulana'),
(4, 'AB1232CC', 'motorcycle', 2000, '2022-06-03 01:52:36', '2022-06-03 01:53:12', 'maulana'),
(5, 'AB1234AB', 'car', 5000, '2022-06-03 01:57:32', '2022-06-03 01:57:48', 'maulana'),
(6, 'AD1111AE', 'motorcycle', 2000, '2022-06-03 01:58:37', '2022-06-03 01:58:49', 'ichvan'),
(7, 'AA1111AA', 'car', 0, '2022-06-03 01:59:03', NULL, 'ichvan');

-- --------------------------------------------------------

--
-- Table structure for table `setting`
--

CREATE TABLE `setting` (
  `remain` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `setting`
--

INSERT INTO `setting` (`remain`) VALUES
(99);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'employee'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `role`) VALUES
('aruga', 'rhyo123', 'admin'),
('ichvan', '123', 'employee'),
('maldimz', 'dimas123', 'admin'),
('maulana', 'maul123', 'employee');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `recap`
--
ALTER TABLE `recap`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `recap`
--
ALTER TABLE `recap`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
