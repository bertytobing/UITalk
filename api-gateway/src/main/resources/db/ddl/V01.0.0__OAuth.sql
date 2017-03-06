CREATE TABLE IF NOT EXISTS `oauth_access_token` (
  `id` bigint(20) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `token_id` varchar(255) NOT NULL,
  `token` blob NOT NULL,
  `authentication_id` varchar(255) NOT NULL,
  `user_name` varchar(255),
  `client_id` varchar(255) NOT NULL,
  `authentication` blob NOT NULL,
  `refresh_token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `oauth_client_details` (
  `id` bigint(20) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) NOT NULL,
  `client_secret` varchar(255) NOT NULL,
  `scope` varchar(255) NOT NULL,
  `authorized_grant_types` varchar(255) NOT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) NOT NULL,
  `access_token_validity` int(11) NOT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `oauth_client_token` (
  `id` bigint(20) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `token_id` varchar(255) NOT NULL,
  `token` blob NOT NULL,
  `authentication_id` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `client_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `oauth_code` (
  `id` bigint(20) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `oauth_refresh_token` (
  `id` bigint(20) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `authorities` (
    `id` int NOT NULL,
    `username` varchar(255) NOT NULL,
    `authority` varchar(255) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;
