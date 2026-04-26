-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.4.25-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.17.0.7270
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- jspdb 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `jspdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `jspdb`;

-- 테이블 jspdb.board 구조 내보내기
CREATE TABLE IF NOT EXISTS `board` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `writer` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `title` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `content` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `regtime` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `hits` int(11) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 테이블 데이터 jspdb.board:~8 rows (대략적) 내보내기
-- DELETE FROM `board`;
INSERT INTO `board` (`num`, `writer`, `title`, `content`, `regtime`, `hits`) VALUES
	(1, '홍길동', '글1', '글의 내용 1', '2017-07-30 10:10:11', 0),
	(2, '이순신', '글2', '글의 내용 2', '2017-07-30 10:10:12', 0),
	(3, '강감찬', '글3', '글의 내용 3', '2017-07-30 10:10:13', 0),
	(4, '김수로', '글4', '글의 내용 4', '2017-07-30 10:10:14', 0),
	(5, '장길산', '글5', '글의 내용 5', '2017-07-30 10:10:15', 1),
	(6, '김수로', '글6', '글의 내용 6', '2017-07-30 10:10:16', 1),
	(7, '홍길동', '글7', '글의 내용 7', '2026-04-25 21:16:00', 4),
	(9, '이순신', '글8', '글의 내용 8', '2026-04-25 21:15:42', 2);

-- 테이블 jspdb.member 구조 내보내기
CREATE TABLE IF NOT EXISTS `member` (
  `id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pw` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 테이블 데이터 jspdb.member:~2 rows (대략적) 내보내기
-- DELETE FROM `member`;
INSERT INTO `member` (`id`, `pw`, `name`) VALUES
	('admin', '1234', '관리자'),
	('hong1', 'abcd', '홍길동'),
	('kim1', 'abcd', '김춘추');

-- 테이블 jspdb.score 구조 내보내기
CREATE TABLE IF NOT EXISTS `score` (
  `num` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `kor` int(11) DEFAULT NULL,
  `eng` int(11) DEFAULT NULL,
  `math` int(11) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 테이블 데이터 jspdb.score:~2 rows (대략적) 내보내기
-- DELETE FROM `score`;
INSERT INTO `score` (`num`, `name`, `kor`, `eng`, `math`) VALUES
	(1, '홍길동', 50, 60, 70),
	(2, '이순신', 65, 75, 85),
	(3, '강감찬', 60, 80, 70);

-- 테이블 jspdb.webhard 구조 내보내기
CREATE TABLE IF NOT EXISTS `webhard` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ftime` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fsize` int(11) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 테이블 데이터 jspdb.webhard:~0 rows (대략적) 내보내기
-- DELETE FROM `webhard`;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
