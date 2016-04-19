-- Dumping database structure for concretepage
CREATE DATABASE IF NOT EXISTS `concretepage`;
USE `concretepage`;

-- Dumping structure for table concretepage.comp_authorities
CREATE TABLE IF NOT EXISTS `comp_authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table concretepage.comp_authorities: ~2 rows (approximately)
INSERT INTO `comp_authorities` (`username`, `authority`) VALUES
	('krishna', 'ROLE_ADMIN'),
	('sudama', 'ROLE_USER');

-- Dumping structure for table concretepage.comp_users
CREATE TABLE IF NOT EXISTS `comp_users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table concretepage.comp_users: ~2 rows (approximately)
INSERT INTO `comp_users` (`username`, `password`, `enabled`) VALUES
	('krishna', '21a4ed0a0cf607e77e93bf7604e2bb1ad07757c5', 1),
	('sudama', '904752ad9c4ae4186c4b4897321c517de0618702', 1);