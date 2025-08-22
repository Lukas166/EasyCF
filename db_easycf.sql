-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Des 2024 pada 19.45
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

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
-- Struktur dari tabel `biodata`
--

CREATE TABLE `biodata` (
  `biodata_id` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `biodata`
--

INSERT INTO `biodata` (`biodata_id`, `nama`, `email`) VALUES
(42, 'lukas', 'lukas8@gmail.com'),
(44, 'Orlando', 'orlando@gmail.com'),
(45, 'unagi', 'unagi@gmail.com'),
(46, 'orlandio', 'orlandobloem@gmail.com'),
(48, 'test', 'testing@gmail.com'),
(49, 'admin', 'admin@gmail.com');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran`
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
-- Dumping data untuk tabel `pengeluaran`
--

INSERT INTO `pengeluaran` (`pengeluaran_id`, `judul`, `deskripsi`, `tipe_pengeluaran`, `uang_keluar`, `tanggal`, `username`) VALUES
(1, 'Nasi goreng', '1 nasi goreng', 'Makanan & Minuman', 16000.00, '2024-11-27', 'user'),
(2, 'Mie Ayam Bang Lukas', '1 Mie Ayam Bakso + 1 Mie Ayam Pangsit', 'Makanan & Minuman', 36020.00, '2024-11-27', 'user'),
(3, 'Ikan', '2 ikan tenggiri', 'Belanja', 60000.00, '2024-11-11', 'user'),
(6, 'Kacamata', 'perbaiki frame', 'Belanja', 120000.00, '2024-11-21', 'user'),
(8, 'Roti bakar', '1 roti bakar coklat keju', 'Makanan & Minuman', 22000.00, '2024-11-27', 'user'),
(9, 'dssd', 'sdss', 'Makanan & Minuman', 5454454.00, '2024-11-27', 'lukas'),
(11, 'Roti bakar', '1 roti bakar coklat keju', 'Makanan & Minuman', 22000.00, '2024-11-27', 'user'),
(12, 'Kopi susu', '1 gelas kopi susu hangat', 'Makanan & Minuman', 18000.00, '2024-10-15', 'user'),
(14, 'Hadiah ulang tahun', 'Kado untuk teman', 'Lainnya', 75000.00, '2024-08-10', 'user'),
(15, 'Martabak manis', '1 loyang martabak manis coklat keju', 'Makanan & Minuman', 50000.00, '2024-07-25', 'user'),
(17, 'Sedekah', 'Donasi mingguan', 'Lainnya', 50000.00, '2024-05-12', 'user'),
(18, 'Pizza', '1 loyang pizza keju', 'Makanan & Minuman', 85000.00, '2024-04-05', 'user'),
(19, 'Sabun mandi', '2 botol sabun cair', 'Belanja', 35000.00, '2024-03-21', 'user'),
(21, 'Es teh manis', '1 gelas es teh manis dingin', 'Makanan & Minuman', 10000.00, '2024-01-25', 'user'),
(22, 'Buku catatan', '2 buku catatan', 'Belanja', 40000.00, '2024-01-10', 'user'),
(23, 'Transportasi umum', 'Tiket bus pulang-pergi', 'Lainnya', 30000.00, '2023-12-15', 'user'),
(24, 'Donat', '6 buah donat aneka rasa', 'Makanan & Minuman', 45000.00, '2023-12-05', 'user'),
(25, 'Peralatan mandi', 'Pasta gigi dan sikat gigi', 'Belanja', 25000.00, '2023-11-20', 'user'),
(27, 'Nasi goreng', '1 porsi nasi goreng spesial', 'Makanan & Minuman', 25000.00, '2023-10-30', 'user'),
(29, 'Zakat', 'Pembayaran zakat bulanan', 'Lainnya', 150000.00, '2023-10-05', 'user'),
(30, 'Kopi hitam', '1 cangkir kopi hitam panas', 'Makanan & Minuman', 15000.00, '2023-09-25', 'user'),
(31, 'Tas kerja', 'Tas selempang untuk ke kantor', 'Belanja', 250000.00, '2023-09-10', 'user'),
(33, 'Burger', '1 burger keju spesial', 'Makanan & Minuman', 30000.00, '2023-08-05', 'user'),
(35, 'Bayar internet', 'Tagihan WiFi bulanan', 'Lainnya', 250000.00, '2023-07-10', 'user'),
(36, 'Ayam goreng', '2 potong ayam goreng renyah', 'Makanan & Minuman', 35000.00, '2023-06-30', 'user'),
(37, 'Celana jeans', '1 celana jeans biru', 'Belanja', 250000.00, '2023-06-15', 'user'),
(38, 'Kursus online', 'Langganan kursus 1 bulan', 'Lainnya', 150000.00, '2023-06-05', 'user'),
(39, 'Pizza', '1 loyang pizza besar', 'Makanan & Minuman', 85000.00, '2023-05-25', 'user'),
(40, 'Belanja mingguan', 'Sayuran dan kebutuhan dapur', 'Belanja', 120000.00, '2023-05-10', 'user'),
(41, 'ikan goyeng', '1 goyeng', 'Makanan & Minuman', 250000.00, '2024-11-27', 'test'),
(43, 'Baju Tidur', '2 Baju Tidur', 'Belanja', 120000.00, '2024-07-16', 'user'),
(44, 'Pizza', '1 Pizza Margherita', 'Makanan & Minuman', 75000.00, '2024-01-15', 'user'),
(45, 'Teh Botol', '5 Teh Botol Sosro', 'Makanan & Minuman', 10000.00, '2024-02-05', 'user'),
(47, 'Headphone', '1 Bose Noise Cancelling Headphones', 'Belanja', 450000.00, '2024-03-12', 'user'),
(48, 'Gojek', 'Perjalanan ke kantor', 'Lainnya', 30000.00, '2024-03-25', 'user'),
(50, 'Makanan Siang', '1 Paket Nasi Padang', 'Makanan & Minuman', 35000.00, '2024-04-21', 'user'),
(51, 'Kopi', '2 Kopi Latte', 'Makanan & Minuman', 45000.00, '2024-05-10', 'user'),
(52, 'Kipas Angin', '1 Kipas Angin Mini', 'Belanja', 50000.00, '2024-06-03', 'user'),
(54, 'Tiket Kereta', 'Tiket Kereta Jakarta - Bandung', 'Lainnya', 120000.00, '2024-07-02', 'user'),
(55, 'Ojek Online', 'Perjalanan ke mall', 'Lainnya', 25000.00, '2024-07-19', 'user'),
(56, 'Makanan Malam', '1 Nasi Uduk', 'Makanan & Minuman', 20000.00, '2024-08-06', 'user'),
(58, 'Makanan Siang', '1 Soto Ayam', 'Makanan & Minuman', 25000.00, '2024-09-04', 'user'),
(59, 'Baju Kerja', '1 Set Baju Kerja', 'Belanja', 150000.00, '2024-09-17', 'user'),
(60, 'Paket Internet', 'Paket Data 10GB', 'Lainnya', 120000.00, '2024-10-01', 'user'),
(62, 'Sate', '1 Sate Ayam', 'Makanan & Minuman', 30000.00, '2024-11-05', 'user'),
(63, 'Makanan Siang', '1 Nasi Goreng', 'Makanan & Minuman', 25000.00, '2024-11-10', 'user'),
(64, 'Kopi', '1 Kopi Hitam', 'Makanan & Minuman', 15000.00, '2024-11-13', 'user'),
(67, 'Sate Kambing', '1 Porsi Sate Kambing', 'Makanan & Minuman', 45000.00, '2024-12-10', 'user'),
(71, 'Tepung', '5kg Tepung Terigu', 'Belanja', 60000.00, '2024-12-20', 'user'),
(72, 'Es Krim', '1 Baskom Es Krim', 'Makanan & Minuman', 30000.00, '2024-12-22', 'user'),
(74, 'Susu', '1 Susu SGM', 'Makanan & Minuman', 25000.00, '2024-12-24', 'user'),
(77, 'Makan Siang', '1 Paket Ayam Penyet', 'Makanan & Minuman', 35000.00, '2024-12-30', 'user'),
(79, 'Kopi Susu', '1 Kopi Susu Gula Aren', 'Makanan & Minuman', 20000.00, '2024-12-31', 'user'),
(83, 'Nasi Kuning', '1 Nasi Kuning Porsi Besar', 'Makanan & Minuman', 25000.00, '2024-12-07', 'user'),
(85, 'Mie Goreng', '2 Porsi Mie Goreng', 'Makanan & Minuman', 25000.00, '2024-12-10', 'user'),
(87, 'Buku Pelajaran', 'Buku Matematika', 'Belanja', 75000.00, '2024-12-02', 'user'),
(88, 'Sate Padang', '2 Porsi Sate Padang', 'Makanan & Minuman', 70000.00, '2024-12-14', 'user'),
(90, 'Kopi', '1 Kopi Hitam', 'Makanan & Minuman', 20000.00, '2024-12-17', 'user'),
(91, 'Tas Belanja', 'Tas Belanja Anyaman', 'Belanja', 50000.00, '2024-12-18', 'user'),
(93, 'Cemilan', 'Keripik Singkong', 'Makanan & Minuman', 15000.00, '2024-12-20', 'user'),
(95, 'Makanan Ringan', '1 Paket Keripik', 'Makanan & Minuman', 25000.00, '2024-12-23', 'user'),
(96, 'Minuman Soda', '1 Kaleng Minuman Soda', 'Makanan & Minuman', 15000.00, '2024-12-24', 'user'),
(99, 'Minuman Kopi', '1 Kopi Latte', 'Makanan & Minuman', 25000.00, '2024-12-28', 'user'),
(102, 'Kopi Arabica', '1 Kopi Arabica Premium', 'Makanan & Minuman', 55000.00, '2024-05-23', 'user'),
(105, 'Kue Cubir', '1 Kue Cubir', 'Makanan & Minuman', 20000.00, '2024-08-12', 'user'),
(106, 'Tas Ransel', '1 Tas Ransel Outdoor', 'Aksesoris', 350000.00, '2024-04-07', 'user'),
(107, 'Lampu Meja', '1 Lampu Meja LED', 'Perabotan', 80000.00, '2024-10-20', 'user'),
(108, 'Buku Pelajaran', '1 Buku Pelajaran Matematika', 'Buku', 50000.00, '2024-11-13', 'user'),
(111, 'Bantal Leher', '1 Bantal Leher Memory Foam', 'Perabotan', 150000.00, '2024-07-30', 'user'),
(116, 'Nasi Pecel', '1 Porsi Nasi Pecel', 'Makanan & Minuman', 25000.00, '2024-04-28', 'user'),
(118, 'Ayam Geprek', '1 Porsi Ayam Geprek', 'Makanan & Minuman', 30000.00, '2024-09-10', 'user'),
(119, 'Susu UHT', '1 Kotak Susu UHT', 'Makanan & Minuman', 10000.00, '2024-03-19', 'user');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `username` varchar(30) NOT NULL DEFAULT '',
  `password` varchar(30) NOT NULL DEFAULT '',
  `level` int(11) NOT NULL,
  `biodata_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`username`, `password`, `level`, `biodata_id`) VALUES
('admin', 'dFNATXd1d1A=', 1, 49),
('lukas', 'KRQYGDAqMAoSCg==', 0, 42),
('Orlando', 'KhMfGC0iKlA=', 0, 44),
('orlandobloem', 'dFNATXd1d1A=', 0, 46),
('test', 'dFNATXd1d1A=', 0, 48),
('unagi', 'dFNATXd1d1A=', 0, 45);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `biodata`
--
ALTER TABLE `biodata`
  ADD PRIMARY KEY (`biodata_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indeks untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD PRIMARY KEY (`pengeluaran_id`),
  ADD KEY `username` (`username`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`),
  ADD KEY `biodata_id` (`biodata_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `biodata`
--
ALTER TABLE `biodata`
  MODIFY `biodata_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  MODIFY `pengeluaran_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=121;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD CONSTRAINT `pengeluaran_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Ketidakleluasaan untuk tabel `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`biodata_id`) REFERENCES `biodata` (`biodata_id`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
