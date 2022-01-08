-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2021 at 06:01 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `presensi_guru`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(20) NOT NULL,
  `nama_admin` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `nama_admin`, `username`, `password`) VALUES
('101', 'SMK PGRI 28 JAKARTA', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tbabsen`
--

CREATE TABLE `tbabsen` (
  `kode` int(11) NOT NULL,
  `nip` varchar(20) NOT NULL,
  `tanggal` date NOT NULL,
  `tanggal_mulai` date NOT NULL,
  `tanggal_selesai` date NOT NULL,
  `hari` varchar(20) NOT NULL,
  `keterangan` varchar(255) NOT NULL,
  `id_admin` varchar(50) NOT NULL,
  `tahun` varchar(15) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbabsen`
--

INSERT INTO `tbabsen` (`kode`, `nip`, `tanggal`, `tanggal_mulai`, `tanggal_selesai`, `hari`, `keterangan`, `id_admin`, `tahun`) VALUES
(1, '14', '2021-03-15', '2021-03-16', '2021-03-18', '2 Hari', 'Cuti', '101', '2021');

-- --------------------------------------------------------

--
-- Table structure for table `tbabsen_siswa`
--

CREATE TABLE `tbabsen_siswa` (
  `no_absen` int(11) NOT NULL,
  `nis` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `kelas` varchar(50) NOT NULL,
  `sakit` int(10) DEFAULT NULL,
  `izin` int(10) DEFAULT NULL,
  `alpha` int(10) DEFAULT NULL,
  `tanggal` date NOT NULL,
  `id_admin` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbabsen_siswa`
--

INSERT INTO `tbabsen_siswa` (`no_absen`, `nis`, `nama`, `kelas`, `sakit`, `izin`, `alpha`, `tanggal`, `id_admin`) VALUES
(1, '123', 'Rangga', 'X OTKP 1', 1, 0, 0, '2021-03-15', '101');

-- --------------------------------------------------------

--
-- Table structure for table `tbguru`
--

CREATE TABLE `tbguru` (
  `nip_absen` varchar(20) NOT NULL,
  `nip` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jabatan` varchar(50) NOT NULL,
  `tugas` varchar(50) NOT NULL,
  `tlp` varchar(30) NOT NULL,
  `foto` text NOT NULL,
  `file` varchar(100) DEFAULT NULL,
  `id_admin` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbguru`
--

INSERT INTO `tbguru` (`nip_absen`, `nip`, `nama`, `jabatan`, `tugas`, `tlp`, `foto`, `file`, `id_admin`) VALUES
('PGRI-28-01', '1', 'Nurazis,S.E.,M.Pd.', 'KEPSEK', '-', '085880845882', 'kepsek.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\kepsek.JPG', '101'),
('PGRI-28-02', '2', 'Drs. H. Iip Abd Arief, S.', 'GURU', '-', '081296557812', 'Iip.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\Iip.JPG', '101'),
('PGRI-28-03', '3', 'Drs. Hj. Subekti Nur I', 'GURU', '-', '0218011924', 'subekti.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\subekti.JPG', '101'),
('PGRI-28-04', '4', 'Drs. Lilik Suminarti', 'GURU', 'Ka.Program AK', '0218010492', 'lilik.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\lilik.JPG', '101'),
('PGRI-28-05', '5', 'Kastaria Rajagukguk, S.Pd.', 'GURU', '-', '0214306560', 'Kastaria.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\Kastaria.JPG', '101'),
('PGRI-28-06', '6', 'Drs. Djihard Sianturi', 'GURU', '-', '0218622516', 'djihard.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\djihard.JPG', '101'),
('PGRI-28-07', '7', 'Dra. Sri Wuriantari', 'GURU', '-', '08187703328', 'test2.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test2.jpg', '101'),
('PGRI-28-08', '8', 'Miswan, M.Ag., M.Kom.', 'GURU', '-', '081310433729', 'test.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test.jpg', '101'),
('PGRI-28-09', '9', 'Hj. Mimin Sukaesih, S.Pd.', 'GURU', 'Ka.Program AP', '08187740267', 'mimin.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\mimin.JPG', '101'),
('PGRI-28-10', '10', 'Suparyono, S.Pd.', 'GURU', '-', '085289907676', 'test.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test.jpg', '101'),
('PGRI-28-11', '11', 'Marini Pakpahan, S.Pd.', 'GURU', 'Walas XII OTKP 2', '081382119264', 'marini.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\marini.JPG', '101'),
('PGRI-28-12', '12', 'Srimarwati, S.Pd.', 'GURU', 'Walas XII OTKP 1', '085691328767', 'Sri Marwati.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\Sri Marwati.JPG', '101'),
('PGRI-28-13', '13', 'Tiurlan Megawati, S.Pd.', 'GURU', 'Wabid.Kurikulum', '085776688708', 'tiurlan.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\tiurlan.JPG', '101'),
('PGRI-28-14', '14', 'Acim Mulyana, S.Si.', 'GURU', '-', '085210308585', 'test.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test.jpg', '101'),
('PGRI-28-15', '15', 'Sri Wahyuni, S.P', 'GURU', 'Walas XI OTKP 1', '081373952607', 'Sri Wahyuni.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\Sri Wahyuni.JPG', '101'),
('PGRI-28-16', '16', 'Abdul KadirS.Pd', 'GURU', '-', '081388542883', 'test.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test.jpg', '101'),
('PGRI-28-17', '17', 'Ibnu Subraja S.Kom', 'GURU', '-', '08170938160', 'test.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test.jpg', '101'),
('PGRI-28-18', '18', 'Dwi Ramadhani A. Malik S.Pd', 'GURU', 'Walas X AKL 1', '081514070881', 'test.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test.jpg', '101'),
('PGRI-28-19', '19', 'Iva Farkhanah S.E', 'GURU', '-', '081586347037', 'test.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test.jpg', '101'),
('PGRI-28-20', '20', 'Ahmad Fatoni S.Pd.I', 'GURU', '-', '02195523511', 'test.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test.jpg', '101'),
('PGRI-28-21', '21', 'Achmad Arif Amin S.Pd', 'GURU', '-', '085774332270', 'test.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test.jpg', '101'),
('PGRI-28-22', '22', 'Ade Prasetya M.Pd', 'GURU', 'Walas X AKL 3', '085780139304', 'Ade Prasetya.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\Ade Prasetya.JPG', '101'),
('PGRI-28-23', '23', 'Sri Kartini S.Pd', 'GURU', '', '085773488670', 'test2.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test2.jpg', '101'),
('PGRI-28-24', '24', 'Wulan Sri Wijayanti S.E', 'GURU', 'Walas XI AKL 1', '085780319360', 'wulan.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\wulan.JPG', '101'),
('PGRI-28-25', '25', 'Gugun Permana S.Pd', 'GURU', 'Wabid.Kesiswaan', '085692345999', 'gugun.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\gugun.JPG', '101'),
('PGRI-28-26', '26', 'H. Abdul Rozaq M.Pd', 'GURU', '-', '085959354365', 'test.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test.jpg', '101'),
('PGRI-28-27', '27', 'Renny Christina S.Pd', 'GURU', 'Walas X AKL 2', '081280019975', 'test2.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test2.jpg', '101'),
('PGRI-28-28', '28', 'Rizki Prapdipta Ramadhian S.Pd', 'GURU', 'Walas XII OTKP 3', '08568178079', 'Rizki P.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\Rizki P.JPG', '101'),
('PGRI-28-29', '29', 'Nur Firmansyah S.E', 'GURU', '-', '082112966833', 'test.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test.jpg', '101'),
('PGRI-28-30', '30', 'Elanda Dwi Saputro S.Pd', 'GURU', 'Walas XII AKL 2', '082261143528', 'test.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test.jpg', '101'),
('PGRI-28-31', '31', 'Bayu Oki Setiawan S.Pd', 'GURU', 'Walas XI OTKP 2', '081284993387', 'Bayu.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\Bayu.JPG', '101'),
('PGRI-28-32', '32', 'Retna Widiastuti S.Pd', 'GURU', 'Walas XI AKL 2', '087839539694', 'Retna.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\Retna.JPG', '101'),
('PGRI-28-33', '33', 'Anathur Youm S.Ag', 'GURU', 'Walas X OTKP 2', '-', 'anathur.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\anathur.JPG', '101'),
('PGRI-28-34', '34', 'Eni Suniah S.Pd', 'GURU', 'Walas XII AKL 1', '081284993387', 'Eni Suniah.JPG', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\GURU\\Eni Suniah.JPG', '101'),
('PGRI-28-35', '35', 'Ihsan Mustaqin S.Pd', 'GURU', '-', '082214165109', 'test.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test.jpg', '101'),
('PGRI-28-36', '36', 'Dewi Wulandari M.Pd', 'GURU', 'Walas XI AKL 3', '081380975022', 'test2.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test2.jpg', '101'),
('PGRI-28-37', '37', 'Maula Nissa Perdhana S.Pd', 'GURU', 'Walas X OTKP 1', '085765353340', 'test2.jpg', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test2.jpg', '101'),
('PGRI-28-40', '40', 'Hady', 'KEPSEK', '-', '021', 'test.png', 'C:\\Users\\Anjar\\Documents\\FotoGuru\\test.png', '101');

-- --------------------------------------------------------

--
-- Table structure for table `tbizin`
--

CREATE TABLE `tbizin` (
  `kode` int(11) NOT NULL,
  `nip` varchar(25) DEFAULT NULL,
  `ket_absen` varchar(25) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `id_admin` varchar(10) DEFAULT NULL,
  `tahun` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbizin`
--

INSERT INTO `tbizin` (`kode`, `nip`, `ket_absen`, `tanggal`, `id_admin`, `tahun`) VALUES
(1, '15', 'SAKIT', '2021-03-15', '101', '2021');

-- --------------------------------------------------------

--
-- Table structure for table `tbjabatan`
--

CREATE TABLE `tbjabatan` (
  `kode_jabatan` varchar(50) NOT NULL,
  `nama_jabatan` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbjabatan`
--

INSERT INTO `tbjabatan` (`kode_jabatan`, `nama_jabatan`) VALUES
('KEPSEK', 'KEPSEK'),
('GURU', 'GURU'),
('STAFF ', 'STAFF');

-- --------------------------------------------------------

--
-- Table structure for table `tbjam_hadir`
--

CREATE TABLE `tbjam_hadir` (
  `id_jam` varchar(10) NOT NULL,
  `jam_masuk_mulai` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbjam_hadir`
--

INSERT INTO `tbjam_hadir` (`id_jam`, `jam_masuk_mulai`) VALUES
('1', '00:10:00');

-- --------------------------------------------------------

--
-- Table structure for table `tbkehadiran`
--

CREATE TABLE `tbkehadiran` (
  `kode` int(11) NOT NULL,
  `nip` varchar(20) NOT NULL,
  `tanggal` date NOT NULL,
  `jam_masuk` time DEFAULT NULL,
  `jam_keluar` time DEFAULT NULL,
  `id_jam` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbkehadiran`
--

INSERT INTO `tbkehadiran` (`kode`, `nip`, `tanggal`, `jam_masuk`, `jam_keluar`, `id_jam`) VALUES
(1, 'PGRI-28-03', '2021-03-15', '11:35:45', '11:39:55', '1'),
(2, 'PGRI-28-06', '2021-03-15', '11:38:44', '11:39:30', '1');

-- --------------------------------------------------------

--
-- Table structure for table `tbkelas`
--

CREATE TABLE `tbkelas` (
  `kode` int(11) NOT NULL,
  `nama_kelas` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbkelas`
--

INSERT INTO `tbkelas` (`kode`, `nama_kelas`) VALUES
(1, '-'),
(2, 'X AKL 1'),
(3, 'X AKL 2'),
(4, 'X AKL 3'),
(5, 'X OTKP 1'),
(6, 'X OTKP 2'),
(7, 'X OTKP 3'),
(8, 'XI AKL 1'),
(9, 'XI AKL 2'),
(10, 'XI AKL 3'),
(11, 'XI OTKP 1'),
(12, 'XI OTKP 2'),
(13, 'XI OTKP 3'),
(14, 'XII AKL 1'),
(15, 'XII AKL 2'),
(16, 'XII AKL 3'),
(17, 'XII OTKP 1'),
(18, 'XII OTKP 2'),
(19, 'XII OTKP 3');

-- --------------------------------------------------------

--
-- Table structure for table `tbpiket`
--

CREATE TABLE `tbpiket` (
  `kode` int(11) NOT NULL,
  `kode_absen` varchar(20) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `jam_1` varchar(50) DEFAULT NULL,
  `jam_2` varchar(50) DEFAULT NULL,
  `jam_3` varchar(50) DEFAULT NULL,
  `jam_4` varchar(50) DEFAULT NULL,
  `jam_5` varchar(50) DEFAULT NULL,
  `jam_6` varchar(50) DEFAULT NULL,
  `jam_7` varchar(50) DEFAULT NULL,
  `jam_8` varchar(50) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `jam_masuk` time NOT NULL,
  `jam_keluar` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpiket`
--

INSERT INTO `tbpiket` (`kode`, `kode_absen`, `nama`, `jam_1`, `jam_2`, `jam_3`, `jam_4`, `jam_5`, `jam_6`, `jam_7`, `jam_8`, `tanggal`, `jam_masuk`, `jam_keluar`) VALUES
(1, 'PGRI-28-03', 'Drs. Hj. Subekti Nur I', 'X OTKP 2', '-', '-', '-', '-', 'X OTKP 2', '-', '-', '2021-03-15', '11:35:45', '11:39:55'),
(2, 'PGRI-28-06', 'Drs. Djihard Sianturi', 'X AKL 3', '-', '-', '-', '-', '-', '-', '-', '2021-03-15', '11:38:44', '11:39:30');

-- --------------------------------------------------------

--
-- Table structure for table `tbsiswa`
--

CREATE TABLE `tbsiswa` (
  `kode` varchar(15) NOT NULL,
  `nis` varchar(25) DEFAULT NULL,
  `nama_siswa` varchar(100) DEFAULT NULL,
  `kelas` varchar(50) DEFAULT NULL,
  `jenis_kelamin` varchar(25) DEFAULT NULL,
  `no_tlp` varchar(50) DEFAULT NULL,
  `file_foto` text,
  `foto_siswa` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbsiswa`
--

INSERT INTO `tbsiswa` (`kode`, `nis`, `nama_siswa`, `kelas`, `jenis_kelamin`, `no_tlp`, `file_foto`, `foto_siswa`) VALUES
('OTKP-01', '123', 'Rangga', 'X OTKP 1', 'Laki - Laki', '021', 'C:\\Users\\Anjar\\Pictures\\unindra.png', 'unindra.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `tbabsen`
--
ALTER TABLE `tbabsen`
  ADD PRIMARY KEY (`kode`),
  ADD KEY `nip` (`nip`),
  ADD KEY `id_admin` (`id_admin`),
  ADD KEY `kode` (`kode`);

--
-- Indexes for table `tbabsen_siswa`
--
ALTER TABLE `tbabsen_siswa`
  ADD PRIMARY KEY (`no_absen`),
  ADD KEY `id_admin` (`id_admin`),
  ADD KEY `no_absen` (`no_absen`);

--
-- Indexes for table `tbguru`
--
ALTER TABLE `tbguru`
  ADD PRIMARY KEY (`nip_absen`),
  ADD UNIQUE KEY `nip` (`nip`),
  ADD KEY `jabatan` (`jabatan`),
  ADD KEY `id_admin` (`id_admin`);

--
-- Indexes for table `tbizin`
--
ALTER TABLE `tbizin`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `tbjabatan`
--
ALTER TABLE `tbjabatan`
  ADD PRIMARY KEY (`kode_jabatan`);

--
-- Indexes for table `tbjam_hadir`
--
ALTER TABLE `tbjam_hadir`
  ADD PRIMARY KEY (`id_jam`);

--
-- Indexes for table `tbkehadiran`
--
ALTER TABLE `tbkehadiran`
  ADD PRIMARY KEY (`kode`),
  ADD KEY `id_admin` (`nip`);

--
-- Indexes for table `tbkelas`
--
ALTER TABLE `tbkelas`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `tbpiket`
--
ALTER TABLE `tbpiket`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `tbsiswa`
--
ALTER TABLE `tbsiswa`
  ADD PRIMARY KEY (`kode`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbabsen`
--
ALTER TABLE `tbabsen`
  MODIFY `kode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbabsen_siswa`
--
ALTER TABLE `tbabsen_siswa`
  MODIFY `no_absen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbizin`
--
ALTER TABLE `tbizin`
  MODIFY `kode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbkehadiran`
--
ALTER TABLE `tbkehadiran`
  MODIFY `kode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbkelas`
--
ALTER TABLE `tbkelas`
  MODIFY `kode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `tbpiket`
--
ALTER TABLE `tbpiket`
  MODIFY `kode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
