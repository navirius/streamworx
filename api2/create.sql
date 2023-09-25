CREATE DATABASE `api1` /*!40100 DEFAULT CHARACTER SET latin1 */;
-- api1.post definition

CREATE TABLE `api1`.`post` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `userid` int(11) NOT NULL,
                        `title` varchar(1000) DEFAULT NULL,
                        `body` varchar(5000) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;