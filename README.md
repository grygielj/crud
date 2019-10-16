# crud


mySQL query

CREATE DATABASE `crud` /
DROP TABLE IF EXISTS `crud`.`product`;
CREATE TABLE  `crud`.`table` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(100) NOT NULL default '',
  `category` varchar(100) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
