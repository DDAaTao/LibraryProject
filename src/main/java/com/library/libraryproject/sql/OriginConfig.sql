-- auto Generated on 2018-10-22 20:58:36 
-- DROP TABLE IF EXISTS origin_config; 
CREATE TABLE origin_config(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	create_time DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
	update_time DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'updateTime',
	config_name VARCHAR (50) UNIQUE NOT NULL DEFAULT '' COMMENT 'configName',
	config_body TEXT NOT NULL COMMENT 'configBody',
	delete INT (11) NOT NULL DEFAULT -1 COMMENT 'delete',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'origin_config';
