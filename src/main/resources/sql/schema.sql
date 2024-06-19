
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ---------------------------------------------------------------------------------------------------------------------
-- Table structure for envs
-- ---------------------------------------------------------------------------------------------------------------------
DROP TABLE
    IF
    EXISTS `envs`;
CREATE TABLE `envs`
(
    `id`          BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `label`       VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '名称',
    `create_date` DATETIME                                                      DEFAULT NULL COMMENT '创建时间',
    `modify_date` DATETIME                                                      DEFAULT NULL COMMENT '修改时间',
    `delete_date` DATETIME                                                      DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_unique` (`id`) COMMENT '唯一索引'
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
    COMMENT = '多环境';
-- ---------------------------------------------------------------------------------------------------------------------
-- Records of envs
-- ---------------------------------------------------------------------------------------------------------------------

-- ---------------------------------------------------------------------------------------------------------------------
-- Table structure for servers
-- ---------------------------------------------------------------------------------------------------------------------
DROP TABLE
    IF
    EXISTS `servers`;
CREATE TABLE `servers`
(
    `id`          BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `label`       VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '名称',
    `protocol`    VARCHAR(255)                                                  DEFAULT NULL COMMENT '协议',
    `domain`      VARCHAR(255)                                                  DEFAULT NULL COMMENT '域名',
    `create_date` DATETIME                                                      DEFAULT NULL COMMENT '创建时间',
    `modify_date` DATETIME                                                      DEFAULT NULL COMMENT '修改时间',
    `delete_date` DATETIME                                                      DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_unique` (`id`) COMMENT '唯一索引'
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
    COMMENT = '多个环境中有多个服务器';
-- ---------------------------------------------------------------------------------------------------------------------
-- Records of servers
-- ---------------------------------------------------------------------------------------------------------------------

-- ---------------------------------------------------------------------------------------------------------------------
-- Table structure for fk_t_envs_servers
-- ---------------------------------------------------------------------------------------------------------------------
DROP TABLE
    IF
    EXISTS `t_envs_servers`;
CREATE TABLE `t_envs_servers`
(
    `id`          BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `env_id`      BIGINT NOT NULL COMMENT '外键',
    `server_id`   BIGINT NOT NULL COMMENT '外键',
    `create_date` DATETIME DEFAULT NULL COMMENT '创建时间',
    `modify_date` DATETIME DEFAULT NULL COMMENT '修改时间',
    `delete_date` DATETIME DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_unique` (`id`) COMMENT '唯一索引',
    CONSTRAINT `fk_env_id` FOREIGN KEY (`env_id`) REFERENCES `envs` (`id`),
    CONSTRAINT `fk_server_id` FOREIGN KEY (`server_id`) REFERENCES `servers` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
    COMMENT = '';
-- ---------------------------------------------------------------------------------------------------------------------
-- Records of t_envs_servers
-- ---------------------------------------------------------------------------------------------------------------------

-- ---------------------------------------------------------------------------------------------------------------------
-- Table structure for services
-- ---------------------------------------------------------------------------------------------------------------------
DROP TABLE
    IF
    EXISTS `services`;
CREATE TABLE `services`
(
    `id`          BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `label`       VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '名称',
    `port`        BIGINT                                                        DEFAULT NULL COMMENT '端口',
    `create_date` DATETIME                                                      DEFAULT NULL COMMENT '创建时间',
    `modify_date` DATETIME                                                      DEFAULT NULL COMMENT '修改时间',
    `delete_date` DATETIME                                                      DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_unique` (`id`) COMMENT '唯一索引'
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
    COMMENT = '多个服务组中有多个服务';
-- ---------------------------------------------------------------------------------------------------------------------
-- Records of services
-- ---------------------------------------------------------------------------------------------------------------------

-- ---------------------------------------------------------------------------------------------------------------------
-- Table structure for service_groups
-- ---------------------------------------------------------------------------------------------------------------------
DROP TABLE
    IF
    EXISTS `service_groups`;
CREATE TABLE `service_groups`
(
    `id`          BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `service_id`  BIGINT NOT NULL COMMENT '外键',
    `label`       VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '名称',
    `create_date` DATETIME                                                      DEFAULT NULL COMMENT '创建时间',
    `modify_date` DATETIME                                                      DEFAULT NULL COMMENT '修改时间',
    `delete_date` DATETIME                                                      DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_unique` (`id`) COMMENT '唯一索引',
    CONSTRAINT `fk_service_id` FOREIGN KEY (`service_id`) REFERENCES `services` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
    COMMENT = '多个服务器中有多个服务组';
-- ---------------------------------------------------------------------------------------------------------------------
-- Records of service_groups
-- ---------------------------------------------------------------------------------------------------------------------

-- ---------------------------------------------------------------------------------------------------------------------
-- Table structure for fk_t_servers_service_groups
-- ---------------------------------------------------------------------------------------------------------------------
DROP TABLE
    IF
    EXISTS `t_servers_service_groups`;
CREATE TABLE `t_servers_service_groups`
(
    `id`               BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `server_id`        BIGINT NOT NULL COMMENT '外键',
    `service_group_id` BIGINT NOT NULL COMMENT '外键',
    `create_date`      DATETIME DEFAULT NULL COMMENT '创建时间',
    `modify_date`      DATETIME DEFAULT NULL COMMENT '修改时间',
    `delete_date`      DATETIME DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_unique` (`id`) COMMENT '唯一索引',
    CONSTRAINT `fk_server_id_1` FOREIGN KEY (`server_id`) REFERENCES `servers` (`id`),
    CONSTRAINT `fk_service_group_id` FOREIGN KEY (`service_group_id`) REFERENCES `service_groups` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
    COMMENT = '';
-- ---------------------------------------------------------------------------------------------------------------------
-- Records of t_servers_service_groups
-- ---------------------------------------------------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 1;
