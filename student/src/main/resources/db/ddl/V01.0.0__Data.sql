-- student
CREATE TABLE IF NOT EXISTS `students` (
  `id` char(36) PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `nik` varchar(255) NOT NULL,
  UNIQUE KEY `UK_STUDENT_CODE` (`nik`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;