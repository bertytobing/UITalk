-- course
CREATE TABLE IF NOT EXISTS `courses` (
  `id` char(36) PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  UNIQUE KEY `UK_COURSE_CODE` (`code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;