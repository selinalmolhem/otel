-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.2.12-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- tablo yapısı dökülüyor otel12.document
CREATE TABLE IF NOT EXISTS `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` text DEFAULT '0',
  `name` text DEFAULT '0',
  `type` text DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- otel12.document: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` (`id`, `path`, `name`, `type`) VALUES
	(2, '/Users/Bayoon/upload/', '1539641157129.jpg', 'image/jpeg'),
	(3, '/Users/Bayoon/upload/', '1547487788224.jpg', 'image/jpeg'),
	(5, '/Users/Bayoon/upload/', '1539878823091.zip', 'application.zip');
/*!40000 ALTER TABLE `document` ENABLE KEYS */;

-- tablo yapısı dökülüyor otel12.lokanta
CREATE TABLE IF NOT EXISTS `lokanta` (
  `lokanta_id` int(10) NOT NULL AUTO_INCREMENT,
  `menu` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `fiyat` int(5) NOT NULL,
  PRIMARY KEY (`lokanta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- otel12.lokanta: ~22 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `lokanta` DISABLE KEYS */;
INSERT INTO `lokanta` (`lokanta_id`, `menu`, `fiyat`) VALUES
	(1, 'döner', 15),
	(2, 'kola', 5),
	(3, 'meyve suyu', 4),
	(4, 'pida', 12),
	(5, 'pulgur pilavı', 10),
	(6, 'tas kebabı', 20),
	(7, 'karalahane sırması', 30),
	(8, 'izmir köftesi', 25),
	(9, 'adana köftesi', 27),
	(10, 'makrne', 10),
	(11, 'tepsi kebab', 30),
	(12, 'su', 2),
	(13, 'kahve', 5),
	(14, 'ayran', 3),
	(15, 'Sıcak Çikolatalı', 7),
	(16, 'Dondurma', 5),
	(17, 'çiğ köfte', 10),
	(18, 'taze fasuliye', 20),
	(22, 'adana kebabı', 20),
	(24, 'salata', 6),
	(25, 'baklava', 10),
	(29, 'kuru fasulye', 6);
/*!40000 ALTER TABLE `lokanta` ENABLE KEYS */;

-- tablo yapısı dökülüyor otel12.lokanta_musteri
CREATE TABLE IF NOT EXISTS `lokanta_musteri` (
  `musteri_id` int(10) unsigned NOT NULL,
  `lokanta_id` int(10) NOT NULL,
  `talep_tarihi` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `lokanta_musteri_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`lokanta_musteri_id`),
  KEY `musteri_id` (`musteri_id`),
  KEY `lokanta_id` (`lokanta_id`),
  CONSTRAINT `FK1musteri_lokanta_musteri` FOREIGN KEY (`musteri_id`) REFERENCES `musteri` (`musteri_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK2lokanta_lokanta_musteri` FOREIGN KEY (`lokanta_id`) REFERENCES `lokanta` (`lokanta_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- otel12.lokanta_musteri: ~20 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `lokanta_musteri` DISABLE KEYS */;
INSERT INTO `lokanta_musteri` (`musteri_id`, `lokanta_id`, `talep_tarihi`, `lokanta_musteri_id`) VALUES
	(22, 3, '2020-03-22 00:00:00', 3),
	(41, 1, '2020-05-30 00:22:40', 12),
	(17, 14, '2020-03-23 19:26:53', 15),
	(20, 5, '2020-03-23 19:27:15', 18),
	(22, 7, '2020-03-23 19:27:40', 20),
	(22, 1, '2020-03-23 20:28:01', 33),
	(35, 1, '2020-03-29 23:54:28', 61),
	(22, 6, '2020-05-28 22:54:00', 77),
	(40, 3, '2020-05-30 00:14:21', 78),
	(40, 6, '2020-05-30 00:14:21', 79),
	(41, 10, '2020-05-30 00:15:11', 80),
	(41, 11, '2020-05-30 00:15:11', 81),
	(26, 14, '2020-05-30 00:26:35', 86),
	(22, 17, '2020-05-30 00:34:35', 87),
	(45, 2, '2020-06-02 21:20:09', 94),
	(45, 4, '2020-06-02 21:20:09', 95),
	(51, 3, '2020-06-09 12:51:03', 115),
	(51, 4, '2020-06-09 12:51:03', 116),
	(45, 1, '2020-06-09 13:01:26', 117),
	(52, 29, '2020-06-09 13:03:52', 118);
/*!40000 ALTER TABLE `lokanta_musteri` ENABLE KEYS */;

-- tablo yapısı dökülüyor otel12.musteri
CREATE TABLE IF NOT EXISTS `musteri` (
  `musteri_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ad_soyad` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `TC` int(11) unsigned NOT NULL,
  `tel` int(10) unsigned NOT NULL,
  `addres` text COLLATE utf8_unicode_ci DEFAULT '0000-00-00 00:00:00',
  `personel_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`musteri_id`),
  UNIQUE KEY `TC` (`TC`),
  UNIQUE KEY `tel` (`tel`),
  KEY `personel_id` (`personel_id`),
  CONSTRAINT `personel_id` FOREIGN KEY (`personel_id`) REFERENCES `personel` (`personel_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- otel12.musteri: ~11 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `musteri` DISABLE KEYS */;
INSERT INTO `musteri` (`musteri_id`, `ad_soyad`, `TC`, `tel`, `addres`, `personel_id`) VALUES
	(17, 'fatma', 333655478, 547811224, 'malatya', 9),
	(20, 'saraa', 114222547, 512242333, 'mersin', 8),
	(22, 'fatih', 33224478, 52233112, 'malatya', 10),
	(26, 'ddd', 22222, 3333333333, 'ddddd', 7),
	(35, 'sss', 33333, 22222, 'ddd', 8),
	(40, 'muna', 66767878, 67678, 'kilis', 10),
	(41, 'maya', 987564545, 58897897, 'kilis', 10),
	(44, 'lama', 43975, 386545657, 'ankara', NULL),
	(45, 'sami', 9948747, 59380293, 'antalya', 8),
	(51, 'maram', 93894733, 587238927, 'malatya', 8),
	(52, 'raşa', 947837262, 59348874, 'kıilis', 26);
/*!40000 ALTER TABLE `musteri` ENABLE KEYS */;

-- tablo yapısı dökülüyor otel12.oda
CREATE TABLE IF NOT EXISTS `oda` (
  `oda_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `oda_no` int(5) NOT NULL DEFAULT 0,
  `oda_tipi` text COLLATE utf8_unicode_ci DEFAULT '0',
  `durum` text COLLATE utf8_unicode_ci DEFAULT '0',
  PRIMARY KEY (`oda_id`),
  UNIQUE KEY `oda_no` (`oda_no`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- otel12.oda: ~16 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `oda` DISABLE KEYS */;
INSERT INTO `oda` (`oda_id`, `oda_no`, `oda_tipi`, `durum`) VALUES
	(1, 985, ' single', 'kucuk'),
	(2, 349, ' single', 'kucuk'),
	(4, 657, ' single', 'buyuk'),
	(6, 876, ' single', 'buyuk'),
	(14, 861, 'single', 'buyuk'),
	(15, 66, 'single', 'kucuk'),
	(25, 98, 'single', 'kucuk'),
	(26, 18, ' single', 'buyuk'),
	(27, 5, ' single', 'buyuk'),
	(28, 19, ' single', 'kucuk'),
	(29, 77, ' single', 'buyuk'),
	(30, 88, ' single', 'kucuk'),
	(31, 13, ' single', 'buyuk'),
	(32, 33, ' single', 'buyuk'),
	(33, 15, ' single', 'kucuk'),
	(35, 90, 'single', 'kucuk');
/*!40000 ALTER TABLE `oda` ENABLE KEYS */;

-- tablo yapısı dökülüyor otel12.odeme
CREATE TABLE IF NOT EXISTS `odeme` (
  `odeme_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tarih` datetime NOT NULL DEFAULT current_timestamp(),
  `odeme_tipi` text COLLATE utf8_unicode_ci DEFAULT '0',
  `musteri_id` int(10) unsigned NOT NULL,
  `fiyat` int(10) unsigned NOT NULL,
  PRIMARY KEY (`odeme_id`),
  KEY `musteri_id` (`musteri_id`),
  CONSTRAINT `FK1odeme_musteri` FOREIGN KEY (`musteri_id`) REFERENCES `musteri` (`musteri_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- otel12.odeme: ~14 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `odeme` DISABLE KEYS */;
INSERT INTO `odeme` (`odeme_id`, `tarih`, `odeme_tipi`, `musteri_id`, `fiyat`) VALUES
	(18, '2020-05-30 00:38:37', 'nakit', 20, 500),
	(27, '2020-06-01 15:26:09', 'nakit', 17, 400),
	(28, '2020-06-01 15:26:29', 'kredi kart', 22, 1000),
	(29, '2020-06-01 15:26:59', 'nakit', 40, 400),
	(30, '2020-06-01 15:27:29', 'kredi kart', 40, 940),
	(31, '2020-06-01 15:27:50', 'nakit', 41, 1300),
	(32, '2020-06-01 15:28:12', 'kredi kart', 35, 580),
	(33, '2020-06-01 15:28:27', 'nakit', 20, 690),
	(34, '2020-06-01 15:28:46', 'kredi kart', 17, 1800),
	(35, '2020-06-01 15:29:15', 'kredi kart', 22, 3000),
	(37, '2020-06-02 21:26:11', 'nakit', 45, 3300),
	(38, '2020-06-05 23:53:34', 'kredi kart', 22, 8590),
	(39, '2020-06-05 23:53:56', 'nakit', 40, 4000),
	(42, '2020-06-06 00:05:59', 'nakit', 40, 4060);
/*!40000 ALTER TABLE `odeme` ENABLE KEYS */;

-- tablo yapısı dökülüyor otel12.personel
CREATE TABLE IF NOT EXISTS `personel` (
  `personel_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ad_soyad` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `TC` int(11) unsigned NOT NULL DEFAULT 0,
  `tel` int(11) unsigned NOT NULL,
  PRIMARY KEY (`personel_id`),
  UNIQUE KEY `TC` (`TC`),
  UNIQUE KEY `tel` (`tel`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- otel12.personel: ~12 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `personel` DISABLE KEYS */;
INSERT INTO `personel` (`personel_id`, `ad_soyad`, `TC`, `tel`) VALUES
	(6, 'Ahmet', 333332210, 544556981),
	(7, 'Şerin', 222478556, 542247289),
	(8, 'Fatih', 444122254, 547423337),
	(9, 'Maria', 114455227, 533442215),
	(10, 'Melek', 224478966, 522114785),
	(23, 'mahmut', 735684784, 57467846),
	(24, 'isa', 987483648, 58738937),
	(25, 'samer', 298374845, 511938478),
	(26, 'walaa', 89736387, 9847843),
	(27, 'amir', 786784634, 58397843),
	(28, 'fatime', 83487687, 587338221),
	(29, 'maha', 92827384, 58734873);
/*!40000 ALTER TABLE `personel` ENABLE KEYS */;

-- tablo yapısı dökülüyor otel12.rezervasyon
CREATE TABLE IF NOT EXISTS `rezervasyon` (
  `rezervasyon_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `musteri_id` int(10) unsigned NOT NULL DEFAULT 0,
  `oda_id` int(10) unsigned NOT NULL DEFAULT 0,
  `giris_tarihi` text COLLATE utf8_unicode_ci NOT NULL,
  `cikis_tarihi` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`rezervasyon_id`),
  UNIQUE KEY `oda_id` (`oda_id`),
  KEY `musteri_id` (`musteri_id`),
  CONSTRAINT `rezervasyon_musteri` FOREIGN KEY (`musteri_id`) REFERENCES `musteri` (`musteri_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rezervasyon_oda` FOREIGN KEY (`oda_id`) REFERENCES `oda` (`oda_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- otel12.rezervasyon: ~11 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `rezervasyon` DISABLE KEYS */;
INSERT INTO `rezervasyon` (`rezervasyon_id`, `musteri_id`, `oda_id`, `giris_tarihi`, `cikis_tarihi`) VALUES
	(34, 40, 4, '02-06-2020 ', '14-05-2020'),
	(36, 22, 2, '02-02-2020 ', '05-11-2020'),
	(38, 41, 15, '02-02-2020 ', '05-11-2020'),
	(39, 26, 25, '02-02-2020 ', '2020-04-10'),
	(41, 40, 30, '01-03-2020 ', '07-11-2020'),
	(42, 17, 29, '02-03-2020 ', '01-05-2020'),
	(43, 17, 28, '01-05-2020 ', '14-06-2020'),
	(44, 20, 27, '20-04-2020', '13-05-2020'),
	(45, 22, 26, '02-09-2020', '05-11-2020'),
	(47, 45, 35, '01-05-2020 ', '07-11-2020'),
	(49, 22, 1, '06.06.2020', '02.07.2020');
/*!40000 ALTER TABLE `rezervasyon` ENABLE KEYS */;

-- tablo yapısı dökülüyor otel12.users
CREATE TABLE IF NOT EXISTS `users` (
  `uname` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `userTuru` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- otel12.users: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`uname`, `password`, `userTuru`) VALUES
	('lana', '234', 'Admin'),
	('nuha', '123', 'User'),
	('nuha', '123', 'User');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
