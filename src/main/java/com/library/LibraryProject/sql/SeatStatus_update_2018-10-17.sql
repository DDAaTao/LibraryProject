ALTER TABLE seat_status
	ADD seat_start DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'seatStart';ALTER TABLE seat_status
	ADD seat_finish DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'seatFinish';ALTER TABLE seat_status DROP COLUMN seat_start;ALTER TABLE seat_status DROP COLUMN seat_finish;
