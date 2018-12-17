ALTER TABLE origin_config
	ADD deleted INT(11) NOT NULL DEFAULT -1 COMMENT 'deleted';ALTER TABLE origin_config DROP COLUMN delete;
