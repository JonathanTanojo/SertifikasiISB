-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Jan 2024 pada 06.48
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sertifikasi`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `book`
--

CREATE TABLE `book` (
  `b_id` int(11) NOT NULL,
  `book_name` varchar(100) DEFAULT NULL,
  `book_description` varchar(255) DEFAULT NULL,
  `book_year` year(4) DEFAULT NULL,
  `book_image` varchar(255) DEFAULT NULL,
  `book_borrowed` tinyint(4) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `book`
--

INSERT INTO `book` (`b_id`, `book_name`, `book_description`, `book_year`, `book_image`, `book_borrowed`) VALUES
(1, 'The Art of Programming', 'A comprehensive guide to programming and algorithms.', '2014', 'the_art_of_programing.jpg', 1),
(2, 'Into the Unknown', 'A thrilling adventure into unexplored territories.', '2015', 'into_the_unknown.jpg', 1),
(3, 'Beyond the Stars', 'Exploring the mysteries of the cosmos and beyond.', '2015', 'book_the_stars_book.jpg', 0),
(4, 'The Silent Observer', 'A psychological thriller that will keep you on the edge of your seat.', '2016', 'the_silent_observer.jpg', 0),
(5, 'Echoes of Eternity', 'A fantasy epic with magic, adventure, and mythical creatures.', '2018', 'echoes_of_eternity.jpg', 0),
(6, 'Code Breakers', 'Unraveling the secrets of cryptography and digital security.', '2020', 'code_breakers.jpg', 0),
(7, 'Lost in Time', 'A time-traveling journey through historical events.', '2021', 'lost_in_time.jpg', 0),
(8, 'The Quantum Paradox', 'Exploring the mind-bending world of quantum physics.', '2021', 'the_quantum_paradox.jpg', 0),
(9, 'Rogue Hacker', 'A gripping tale of a hacker navigating the dark web and cyber threats.', '2020', 'rogue_hacker.jpg', 0),
(10, 'Whispers in the Wind', 'Mysteries unfold in a small town with supernatural occurrences.', '2022', 'whispers_in_the_wind.jpg', 0),
(11, 'The Last Frontier', 'An expedition to the unexplored corners of the Earth.', '2020', 'the_last_frontier.jpg', 0),
(12, 'Eternal Love', 'A timeless romance that transcends generations.', '2021', 'eternal_love.jpg', 0),
(13, 'The Mind`s Eye', 'A journey into the depths of the human mind and consciousness.', '2022', 'the_mind_eye.jpg', 0),
(14, 'City of Shadows', 'A noir-style detective story set in a gritty urban landscape.', '2022', 'city_of_shadows.jpg', 0),
(15, 'The Enchanted Forest', 'Discover the enchanting world of magical creatures and hidden wonders.', '2020', 'the_enchanted_forest.jpg', 0),
(16, 'Digital Revolution', 'The evolution of technology and its impact on society.', '2023', 'digital_revolution.jpg', 0),
(17, 'The Lost Kingdom', 'An epic tale of kingdoms, war, and the quest for power.', '2020', 'the_lost_kingdom.jpg', 0),
(18, 'Beneath the Surface', 'Uncovering the secrets hidden beneath the ocean depths.', '2023', 'beneath_the_surface.jpg', 0),
(19, 'Infinite Horizons', 'Embark on a journey through parallel universes and infinite possibilities.', '2020', 'infinite_horizons.jpg', 0),
(20, 'Whirlwind of Emotions', 'A rollercoaster of love, heartbreak, and self-discovery.', '2023', 'whirlwind_of_emotions.jpg', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `list`
--

CREATE TABLE `list` (
  `list_id` int(11) NOT NULL,
  `u_id` int(11) DEFAULT NULL,
  `b_id` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `list`
--

INSERT INTO `list` (`list_id`, `u_id`, `b_id`, `start_date`, `end_date`) VALUES
(1, 2, 4, '2024-01-06', '2024-01-13'),
(2, 2, 5, '2024-01-06', '2024-01-13'),
(3, 2, 6, '2024-01-06', '2024-01-13'),
(4, 3, 4, '2024-01-06', '2024-01-13'),
(5, 2, 1, '2024-01-06', '2024-01-13'),
(6, 2, 2, '2024-01-06', '2024-01-13'),
(7, 2, 1, '2024-01-07', '2024-01-14'),
(8, 2, 2, '2024-01-07', '2024-01-14'),
(9, 2, 3, '2024-01-07', '2024-01-14'),
(10, 2, 4, '2024-01-07', '2024-01-14'),
(11, 6, 7, '2024-01-07', '2024-01-14'),
(12, 7, 5, '2024-01-07', '2024-01-14'),
(13, 7, 1, '2024-01-07', '2024-01-14'),
(14, 8, 2, '2024-01-07', '2024-01-14');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`u_id`, `user_name`, `user_email`) VALUES
(1, 'Ahmad Rahman', 'ahmad_rahman@gmail.com'),
(2, 'Siti Nurul', 'siti_nurul@gmail.com'),
(3, 'Budi Santoso', 'budi_santoso@gmail.com'),
(4, 'Alex', 'alex01@gmail.com'),
(5, 'Bily', 'billy01@gmail.com'),
(6, 'Titi', 'titi01@gmail.com'),
(7, 'Felicia', 'felicia01@gmail.com'),
(8, 'Graciella', 'graciella01@gmail.com'),
(9, 'Marcell', 'marcell01@gmail.com'),
(10, 'Irwan', 'irwan01@gmail.com'),
(11, 'Baghiz', 'baghiz01@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`b_id`);

--
-- Indeks untuk tabel `list`
--
ALTER TABLE `list`
  ADD PRIMARY KEY (`list_id`),
  ADD KEY `FK_BOOK_LIST` (`b_id`),
  ADD KEY `FK_RELATIONSHIP_2` (`u_id`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `book`
--
ALTER TABLE `book`
  MODIFY `b_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT untuk tabel `list`
--
ALTER TABLE `list`
  MODIFY `list_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `list`
--
ALTER TABLE `list`
  ADD CONSTRAINT `FK_BOOK_LIST` FOREIGN KEY (`b_id`) REFERENCES `book` (`b_id`),
  ADD CONSTRAINT `FK_RELATIONSHIP_2` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
