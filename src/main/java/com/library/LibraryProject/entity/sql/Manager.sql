-- auto Generated on 2018-09-14 00:48:30 
-- DROP TABLE IF EXISTS manager; 
CREATE TABLE manager(
	manager_id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'managerId',
	manager_account VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'managerAccount',
	manager_pwd VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'managerPwd',
	manager_authority VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'managerAuthority',
	PRIMARY KEY (manager_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'manager';
