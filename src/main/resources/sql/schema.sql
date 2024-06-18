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

-- ----------------------------------------
-- Table structure for envs
-- ----------------------------------------
DROP TABLE IF EXISTS `envs`;
CREATE TABLE `envs`
(
    `id`            BIGINT NOT NULL AUTO_INCREMENT                                               COMMENT '主键',
    `label`         VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT NULL COMMENT '环境名称',

    `create_date`   DATETIME                                                        DEFAULT NULL COMMENT '创建时间',
    `modify_date`   DATETIME                                                        DEFAULT NULL COMMENT '修改时间',
    `delete_date`   DATETIME                                                        DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `label_unique` (`label`) COMMENT '唯一索引姓名'
) ENGINE=InnoDB
  AUTO_INCREMENT=0
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_general_ci COMMENT='多个环境';
-- ----------------------------------------
-- Records of envs
-- ----------------------------------------

-- ----------------------------------------
-- Table structure for servers
-- ----------------------------------------
DROP TABLE IF EXISTS `servers`;
CREATE TABLE `servers`
(
    `id`            BIGINT NOT NULL AUTO_INCREMENT                                               COMMENT '主键',
    `label`         VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT NULL COMMENT '服务器名称',
    `protocol`      VARCHAR(255)                                                    DEFAULT NULL COMMENT '协议',
    `domain`        VARCHAR(255)                                                    DEFAULT NULL COMMENT '域名',

    `create_date`   DATETIME                                                        DEFAULT NULL COMMENT '创建时间',
    `modify_date`   DATETIME                                                        DEFAULT NULL COMMENT '修改时间',
    `delete_date`   DATETIME                                                        DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `label_unique` (`label`) COMMENT '唯一索引姓名'
) ENGINE=InnoDB
  AUTO_INCREMENT=0
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_general_ci COMMENT='多个服务器( 一个环境中包含多个服务器 )';
-- ----------------------------------------
-- Records of servers
-- ----------------------------------------

-- ----------------------------------------
-- Table structure for fk_t_envs_servers
-- ----------------------------------------
DROP TABLE IF EXISTS `fk_t_envs_servers`;
CREATE TABLE `fk_t_envs_servers`
(
    `id`            BIGINT NOT NULL AUTO_INCREMENT                                               COMMENT '主键',
    `envs_id`       BIGINT NOT NULL                                                              COMMENT '外键',
    `servers_id`    BIGINT NOT NULL                                                              COMMENT '外键',

    `create_date`   DATETIME                                                        DEFAULT NULL COMMENT '创建时间',
    `modify_date`   DATETIME                                                        DEFAULT NULL COMMENT '修改时间',
    `delete_date`   DATETIME                                                        DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `label_unique` (`label`) COMMENT '唯一索引姓名'
) ENGINE=InnoDB
  AUTO_INCREMENT=0
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_general_ci COMMENT='';
-- ----------------------------------------
-- Records of t_envs_servers
-- ----------------------------------------

-- ----------------------------------------
-- Table structure for service_groups
-- ----------------------------------------
DROP TABLE IF EXISTS `service_groups`;
CREATE TABLE `service_groups`
(
    `id`            BIGINT NOT NULL AUTO_INCREMENT                                               COMMENT '主键',
    `label`         VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT NULL COMMENT '服务分组名称',

    `create_date`   DATETIME                                                        DEFAULT NULL COMMENT '创建时间',
    `modify_date`   DATETIME                                                        DEFAULT NULL COMMENT '修改时间',
    `delete_date`   DATETIME                                                        DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `label_unique` (`label`) COMMENT '唯一索引姓名'
) ENGINE=InnoDB
  AUTO_INCREMENT=0
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_general_ci COMMENT='多个分组( 一个服务器中包含多个服务分组 )';
-- ----------------------------------------
-- Records of service_groups
-- ----------------------------------------

-- ----------------------------------------
-- Table structure for services
-- ----------------------------------------
DROP TABLE IF EXISTS `services`;
CREATE TABLE `services`
(
    `id`            BIGINT NOT NULL AUTO_INCREMENT                                               COMMENT '主键',
    `group_id`      BIGINT NOT NULL                                                              COMMENT '外键',
    `label`         VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT NULL COMMENT '服务名称',

    `create_date`   DATETIME                                                        DEFAULT NULL COMMENT '创建时间',
    `modify_date`   DATETIME                                                        DEFAULT NULL COMMENT '修改时间',
    `delete_date`   DATETIME                                                        DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `label_unique` (`label`) COMMENT '唯一索引姓名'
) ENGINE=InnoDB
  AUTO_INCREMENT=0
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_general_ci COMMENT='多个服务( 一个分组中包含多个服务 )';
-- ----------------------------------------
-- Records of services
-- ----------------------------------------


ALTER TABLE `envs` ADD CONSTRAINT `fk_t_envs_servers` FOREIGN KEY (`server_id`) REFERENCES `servers` (`id`);

