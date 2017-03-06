CREATE TABLE IF NOT EXISTS `users` (
  `id` char(36) NOT NULL PRIMARY KEY,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  UNIQUE KEY `UK_USERS_USERNAME` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;