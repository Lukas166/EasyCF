-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2024 at 05:43 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_easycf`
--

-- --------------------------------------------------------

--
-- Table structure for table `biodata`
--

CREATE TABLE `biodata` (
  `biodata_id` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `limit_pengeluaran` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `biodata`
--

INSERT INTO `biodata` (`biodata_id`, `nama`, `email`, `limit_pengeluaran`) VALUES
(42, 'lukas', '  Masukkan email', 21338989.00),
(43, 'yuyunajg', 'yuyunajg@gmail.com', 0.00),
(44, 'Orlando', 'orlando@gmail.com', 0.00),
(45, 'dafa', 'dafa@gmail.com', 0.00),
(46, 'ican', 'ican@gmail.com', 0.00),
(47, 'orlando1', 'orlando1@gmail.com', 0.00),
(48, 'orlando2', 'orlando2@gmail.com', 0.00),
(49, 'lukas1', 'lukas1@gmail.com', 0.00),
(50, 'devin', 'devin@gmail.com', 1565656.00),
(51, 'orlando123', 'orlando123@gmail.com', 1233333.00),
(52, 'ainur', 'ainur@gmail.com', 50000.00),
(53, 'lukasnigga', 'email@gmail.com', 1000000.00);

-- --------------------------------------------------------

--
-- Table structure for table `pengeluaran`
--

CREATE TABLE `pengeluaran` (
  `pengeluaran_id` int(11) NOT NULL,
  `judul` varchar(30) DEFAULT NULL,
  `deskripsi` text DEFAULT NULL,
  `tipe_pengeluaran` varchar(30) DEFAULT NULL,
  `uang_keluar` decimal(10,2) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengeluaran`
--

INSERT INTO `pengeluaran` (`pengeluaran_id`, `judul`, `deskripsi`, `tipe_pengeluaran`, `uang_keluar`, `tanggal`, `username`) VALUES
(4, 'Gundam', 'ngapain beli gundam', 'Belanja', 1000000.00, '2024-11-24', 'devin'),
(5, 'akksa', 'asas', 'Makanan & Minuman', 565656.00, '2024-11-24', 'devin'),
(6, 'website', 'dfsdssd', 'Belanja', 1233333.00, '2024-11-24', 'orlando123'),
(7, 'ijun', 'asdkadajs', 'Makanan & Minuman', 1000.00, '2024-11-25', 'lukas'),
(8, 'wqw', 'qwqw', 'Belanja', 100000.00, '2024-11-25', 'lukas'),
(9, 'buku', 'buku tulis', 'Belanja', 50000.00, '2024-11-26', 'ainur'),
(10, 'hehe', 'esds', 'Belanja', 50000.00, '2024-11-26', 'lukas'),
(11, 'wqwq', 'wqwqq', 'Makanan & Minuman', 30000.00, '2024-11-26', 'lukas'),
(12, 'bukubaru', 'buku tulis yang bagus', 'Belanja', 100000.00, '2024-11-26', 'lukas'),
(13, 'laptop', 'laptop asus gaming', 'Belanja', 21000000.00, '2024-11-26', 'lukas'),
(14, 'ewweew', 'dssfdsf', 'Makanan & Minuman', 3444.00, '2024-11-26', 'lukas'),
(15, 'nob', '12312', 'Makanan & Minuman', 1000000.00, '2024-11-26', 'lukasnigga'),
(16, 'assad', 'asdasd', 'Makanan & Minuman', 54545.00, '2024-11-26', 'lukas');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(30) NOT NULL DEFAULT '',
  `password` varchar(30) NOT NULL DEFAULT '',
  `biodata_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

--
-- Indexes for dumped tables
--

--
-- Indexes for table `biodata`
--
ALTER TABLE `biodata`
  ADD PRIMARY KEY (`biodata_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD PRIMARY KEY (`pengeluaran_id`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`),
  ADD KEY `biodata_id` (`biodata_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `biodata`
--
ALTER TABLE `biodata`
  MODIFY `biodata_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `pengeluaran`
--
ALTER TABLE `pengeluaran`
  MODIFY `pengeluaran_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD CONSTRAINT `pengeluaran_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`biodata_id`) REFERENCES `biodata` (`biodata_id`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
