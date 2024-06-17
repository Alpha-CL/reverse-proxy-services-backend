-- This file cannot be empty

DROP TABLE if EXISTS `demo`;
CREATE TABLE `demo`
(
    -- [column_name] [column_type: type | type(length)] [properties: not null | primary key | default value],
    -- [!!!] No commas at the end of the last row

    `id` INTEGER(100) NOT NULL PRIMARY KEY AUTO_INCREMENT

) AUTO_INCREMENT = 0
CHARACTER SET utf8mb4
COLLATE utf8mb4_general_ci;


