-- grade
CREATE TABLE IF NOT EXISTS `grades` (
  `id` char(36) PRIMARY KEY,
  `student_id` char(36) NOT NULL,
  `course_id` char(36) NOT NULL,
  `grade` int NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;