/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.15 : Database - ry-vue
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = ''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS */`ry-vue` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `ry-vue`;

/*Table structure for table `gen_table` */

DROP TABLE IF EXISTS `gen_table`;

CREATE TABLE `gen_table`
(
    `table_id`        bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `table_name`      varchar(200)  DEFAULT '' COMMENT '表名称',
    `table_comment`   varchar(500)  DEFAULT '' COMMENT '表描述',
    `class_name`      varchar(100)  DEFAULT '' COMMENT '实体类名称',
    `tpl_category`    varchar(200)  DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
    `package_name`    varchar(100)  DEFAULT NULL COMMENT '生成包路径',
    `module_name`     varchar(30)   DEFAULT NULL COMMENT '生成模块名',
    `business_name`   varchar(30)   DEFAULT NULL COMMENT '生成业务名',
    `function_name`   varchar(50)   DEFAULT NULL COMMENT '生成功能名',
    `function_author` varchar(50)   DEFAULT NULL COMMENT '生成功能作者',
    `options`         varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
    `create_by`       varchar(64)   DEFAULT '' COMMENT '创建者',
    `create_time`     datetime      DEFAULT NULL COMMENT '创建时间',
    `update_by`       varchar(64)   DEFAULT '' COMMENT '更新者',
    `update_time`     datetime      DEFAULT NULL COMMENT '更新时间',
    `remark`          varchar(500)  DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`table_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='代码生成业务表';

/*Data for the table `gen_table` */

/*Table structure for table `gen_table_column` */

DROP TABLE IF EXISTS `gen_table_column`;

CREATE TABLE `gen_table_column`
(
    `column_id`      bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `table_id`       varchar(64)  DEFAULT NULL COMMENT '归属表编号',
    `column_name`    varchar(200) DEFAULT NULL COMMENT '列名称',
    `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
    `column_type`    varchar(100) DEFAULT NULL COMMENT '列类型',
    `java_type`      varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
    `java_field`     varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
    `is_pk`          char(1)      DEFAULT NULL COMMENT '是否主键（1是）',
    `is_increment`   char(1)      DEFAULT NULL COMMENT '是否自增（1是）',
    `is_required`    char(1)      DEFAULT NULL COMMENT '是否必填（1是）',
    `is_insert`      char(1)      DEFAULT NULL COMMENT '是否为插入字段（1是）',
    `is_edit`        char(1)      DEFAULT NULL COMMENT '是否编辑字段（1是）',
    `is_list`        char(1)      DEFAULT NULL COMMENT '是否列表字段（1是）',
    `is_query`       char(1)      DEFAULT NULL COMMENT '是否查询字段（1是）',
    `query_type`     varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
    `html_type`      varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
    `dict_type`      varchar(200) DEFAULT '' COMMENT '字典类型',
    `sort`           int(11)      DEFAULT NULL COMMENT '排序',
    `create_by`      varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`    datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`column_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='代码生成业务表字段';

/*Data for the table `gen_table_column` */

/*Table structure for table `QRTZ_BLOB_TRIGGERS` */

DROP TABLE IF EXISTS `QRTZ_BLOB_TRIGGERS`;

CREATE TABLE `QRTZ_BLOB_TRIGGERS`
(
    `sched_name`    varchar(120) NOT NULL,
    `trigger_name`  varchar(200) NOT NULL,
    `trigger_group` varchar(200) NOT NULL,
    `blob_data`     blob,
    PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`),
    CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

/*Data for the table `QRTZ_BLOB_TRIGGERS` */

/*Table structure for table `QRTZ_CALENDARS` */

DROP TABLE IF EXISTS `QRTZ_CALENDARS`;

CREATE TABLE `QRTZ_CALENDARS`
(
    `sched_name`    varchar(120) NOT NULL,
    `calendar_name` varchar(200) NOT NULL,
    `calendar`      blob         NOT NULL,
    PRIMARY KEY (`sched_name`, `calendar_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

/*Data for the table `QRTZ_CALENDARS` */

/*Table structure for table `QRTZ_CRON_TRIGGERS` */

DROP TABLE IF EXISTS `QRTZ_CRON_TRIGGERS`;

CREATE TABLE `QRTZ_CRON_TRIGGERS`
(
    `sched_name`      varchar(120) NOT NULL,
    `trigger_name`    varchar(200) NOT NULL,
    `trigger_group`   varchar(200) NOT NULL,
    `cron_expression` varchar(200) NOT NULL,
    `time_zone_id`    varchar(80) DEFAULT NULL,
    PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`),
    CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

/*Data for the table `QRTZ_CRON_TRIGGERS` */

insert into `QRTZ_CRON_TRIGGERS`(`sched_name`, `trigger_name`, `trigger_group`, `cron_expression`, `time_zone_id`)
values ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', '0/10 * * * * ?', 'Asia/Shanghai'),
       ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', '0/15 * * * * ?', 'Asia/Shanghai'),
       ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', '0/20 * * * * ?', 'Asia/Shanghai');

/*Table structure for table `QRTZ_FIRED_TRIGGERS` */

DROP TABLE IF EXISTS `QRTZ_FIRED_TRIGGERS`;

CREATE TABLE `QRTZ_FIRED_TRIGGERS`
(
    `sched_name`        varchar(120) NOT NULL,
    `entry_id`          varchar(95)  NOT NULL,
    `trigger_name`      varchar(200) NOT NULL,
    `trigger_group`     varchar(200) NOT NULL,
    `instance_name`     varchar(200) NOT NULL,
    `fired_time`        bigint(13)   NOT NULL,
    `sched_time`        bigint(13)   NOT NULL,
    `priority`          int(11)      NOT NULL,
    `state`             varchar(16)  NOT NULL,
    `job_name`          varchar(200) DEFAULT NULL,
    `job_group`         varchar(200) DEFAULT NULL,
    `is_nonconcurrent`  varchar(1)   DEFAULT NULL,
    `requests_recovery` varchar(1)   DEFAULT NULL,
    PRIMARY KEY (`sched_name`, `entry_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

/*Data for the table `QRTZ_FIRED_TRIGGERS` */

/*Table structure for table `QRTZ_JOB_DETAILS` */

DROP TABLE IF EXISTS `QRTZ_JOB_DETAILS`;

CREATE TABLE `QRTZ_JOB_DETAILS`
(
    `sched_name`        varchar(120) NOT NULL,
    `job_name`          varchar(200) NOT NULL,
    `job_group`         varchar(200) NOT NULL,
    `description`       varchar(250) DEFAULT NULL,
    `job_class_name`    varchar(250) NOT NULL,
    `is_durable`        varchar(1)   NOT NULL,
    `is_nonconcurrent`  varchar(1)   NOT NULL,
    `is_update_data`    varchar(1)   NOT NULL,
    `requests_recovery` varchar(1)   NOT NULL,
    `job_data`          blob,
    PRIMARY KEY (`sched_name`, `job_name`, `job_group`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

/*Data for the table `QRTZ_JOB_DETAILS` */

insert into `QRTZ_JOB_DETAILS`(`sched_name`, `job_name`, `job_group`, `description`, `job_class_name`, `is_durable`,
                               `is_nonconcurrent`, `is_update_data`, `requests_recovery`, `job_data`)
values ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', NULL,
        'com.ruoyi.common.utils.job.QuartzDisallowConcurrentExecution', '0', '1', '0', '0',
        '��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0\'com.ruoyi.project.monitor.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0)com.ruoyi.framework.web.domain.BaseEntity\0\0\0\0\0\0\0\0\nL\0	beginTimeq\0~\0	L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0	dataScopeq\0~\0	L\0endTimeq\0~\0	L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xppt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0b,�)�xpppt\0\0pppt\01t\00/10 * * * * ?t\0ryTask.ryNoParamst\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（无参）t\03t\01x\0'),
       ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', NULL,
        'com.ruoyi.common.utils.job.QuartzDisallowConcurrentExecution', '0', '1', '0', '0',
        '��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0\'com.ruoyi.project.monitor.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0)com.ruoyi.framework.web.domain.BaseEntity\0\0\0\0\0\0\0\0\nL\0	beginTimeq\0~\0	L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0	dataScopeq\0~\0	L\0endTimeq\0~\0	L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xppt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0b,�)�xpppt\0\0pppt\01t\00/15 * * * * ?t\0ryTask.ryParams(\'ry\')t\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（有参）t\03t\01x\0'),
       ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', NULL,
        'com.ruoyi.common.utils.job.QuartzDisallowConcurrentExecution', '0', '1', '0', '0',
        '��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0TASK_PROPERTIESsr\0\'com.ruoyi.project.monitor.domain.SysJob\0\0\0\0\0\0\0\0L\0\nconcurrentt\0Ljava/lang/String;L\0cronExpressionq\0~\0	L\0invokeTargetq\0~\0	L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0)com.ruoyi.framework.web.domain.BaseEntity\0\0\0\0\0\0\0\0\nL\0	beginTimeq\0~\0	L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0	dataScopeq\0~\0	L\0endTimeq\0~\0	L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xppt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0b,�)�xpppt\0\0pppt\01t\00/20 * * * * ?t\08ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)t\0DEFAULTsr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0系统默认（多参）t\03t\01x\0');

/*Table structure for table `QRTZ_LOCKS` */

DROP TABLE IF EXISTS `QRTZ_LOCKS`;

CREATE TABLE `QRTZ_LOCKS`
(
    `sched_name` varchar(120) NOT NULL,
    `lock_name`  varchar(40)  NOT NULL,
    PRIMARY KEY (`sched_name`, `lock_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

/*Data for the table `QRTZ_LOCKS` */

insert into `QRTZ_LOCKS`(`sched_name`, `lock_name`)
values ('RuoyiScheduler', 'STATE_ACCESS'),
       ('RuoyiScheduler', 'TRIGGER_ACCESS');

/*Table structure for table `QRTZ_PAUSED_TRIGGER_GRPS` */

DROP TABLE IF EXISTS `QRTZ_PAUSED_TRIGGER_GRPS`;

CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS`
(
    `sched_name`    varchar(120) NOT NULL,
    `trigger_group` varchar(200) NOT NULL,
    PRIMARY KEY (`sched_name`, `trigger_group`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

/*Data for the table `QRTZ_PAUSED_TRIGGER_GRPS` */

/*Table structure for table `QRTZ_SCHEDULER_STATE` */

DROP TABLE IF EXISTS `QRTZ_SCHEDULER_STATE`;

CREATE TABLE `QRTZ_SCHEDULER_STATE`
(
    `sched_name`        varchar(120) NOT NULL,
    `instance_name`     varchar(200) NOT NULL,
    `last_checkin_time` bigint(13)   NOT NULL,
    `checkin_interval`  bigint(13)   NOT NULL,
    PRIMARY KEY (`sched_name`, `instance_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

/*Data for the table `QRTZ_SCHEDULER_STATE` */

insert into `QRTZ_SCHEDULER_STATE`(`sched_name`, `instance_name`, `last_checkin_time`, `checkin_interval`)
values ('RuoyiScheduler', 'JL-PC1587785711907', 1587787380431, 15000);

/*Table structure for table `QRTZ_SIMPLE_TRIGGERS` */

DROP TABLE IF EXISTS `QRTZ_SIMPLE_TRIGGERS`;

CREATE TABLE `QRTZ_SIMPLE_TRIGGERS`
(
    `sched_name`      varchar(120) NOT NULL,
    `trigger_name`    varchar(200) NOT NULL,
    `trigger_group`   varchar(200) NOT NULL,
    `repeat_count`    bigint(7)    NOT NULL,
    `repeat_interval` bigint(12)   NOT NULL,
    `times_triggered` bigint(10)   NOT NULL,
    PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`),
    CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

/*Data for the table `QRTZ_SIMPLE_TRIGGERS` */

/*Table structure for table `QRTZ_SIMPROP_TRIGGERS` */

DROP TABLE IF EXISTS `QRTZ_SIMPROP_TRIGGERS`;

CREATE TABLE `QRTZ_SIMPROP_TRIGGERS`
(
    `sched_name`    varchar(120) NOT NULL,
    `trigger_name`  varchar(200) NOT NULL,
    `trigger_group` varchar(200) NOT NULL,
    `str_prop_1`    varchar(512)   DEFAULT NULL,
    `str_prop_2`    varchar(512)   DEFAULT NULL,
    `str_prop_3`    varchar(512)   DEFAULT NULL,
    `int_prop_1`    int(11)        DEFAULT NULL,
    `int_prop_2`    int(11)        DEFAULT NULL,
    `long_prop_1`   bigint(20)     DEFAULT NULL,
    `long_prop_2`   bigint(20)     DEFAULT NULL,
    `dec_prop_1`    decimal(13, 4) DEFAULT NULL,
    `dec_prop_2`    decimal(13, 4) DEFAULT NULL,
    `bool_prop_1`   varchar(1)     DEFAULT NULL,
    `bool_prop_2`   varchar(1)     DEFAULT NULL,
    PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`),
    CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

/*Data for the table `QRTZ_SIMPROP_TRIGGERS` */

/*Table structure for table `QRTZ_TRIGGERS` */

DROP TABLE IF EXISTS `QRTZ_TRIGGERS`;

CREATE TABLE `QRTZ_TRIGGERS`
(
    `sched_name`     varchar(120) NOT NULL,
    `trigger_name`   varchar(200) NOT NULL,
    `trigger_group`  varchar(200) NOT NULL,
    `job_name`       varchar(200) NOT NULL,
    `job_group`      varchar(200) NOT NULL,
    `description`    varchar(250) DEFAULT NULL,
    `next_fire_time` bigint(13)   DEFAULT NULL,
    `prev_fire_time` bigint(13)   DEFAULT NULL,
    `priority`       int(11)      DEFAULT NULL,
    `trigger_state`  varchar(16)  NOT NULL,
    `trigger_type`   varchar(8)   NOT NULL,
    `start_time`     bigint(13)   NOT NULL,
    `end_time`       bigint(13)   DEFAULT NULL,
    `calendar_name`  varchar(200) DEFAULT NULL,
    `misfire_instr`  smallint(2)  DEFAULT NULL,
    `job_data`       blob,
    PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`),
    KEY `sched_name` (`sched_name`, `job_name`, `job_group`),
    CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `QRTZ_JOB_DETAILS` (`sched_name`, `job_name`, `job_group`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

/*Data for the table `QRTZ_TRIGGERS` */

insert into `QRTZ_TRIGGERS`(`sched_name`, `trigger_name`, `trigger_group`, `job_name`, `job_group`, `description`,
                            `next_fire_time`, `prev_fire_time`, `priority`, `trigger_state`, `trigger_type`,
                            `start_time`, `end_time`, `calendar_name`, `misfire_instr`, `job_data`)
values ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', 'TASK_CLASS_NAME1', 'DEFAULT', NULL, 1587787310000, -1, 5,
        'PAUSED', 'CRON', 1587785712000, 0, NULL, 2, ''),
       ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', 'TASK_CLASS_NAME2', 'DEFAULT', NULL, 1587785715000, -1, 5,
        'PAUSED', 'CRON', 1587785712000, 0, NULL, 2, ''),
       ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', 'TASK_CLASS_NAME3', 'DEFAULT', NULL, 1587785720000, -1, 5,
        'PAUSED', 'CRON', 1587785712000, 0, NULL, 2, '');

/*Table structure for table `sys_config` */

DROP TABLE IF EXISTS `sys_config`;

CREATE TABLE `sys_config`
(
    `config_id`    int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
    `config_name`  varchar(100) DEFAULT '' COMMENT '参数名称',
    `config_key`   varchar(100) DEFAULT '' COMMENT '参数键名',
    `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
    `config_type`  char(1)      DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
    `create_by`    varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`  datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`       varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`config_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='参数配置表';

/*Data for the table `sys_config` */

insert into `sys_config`(`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`,
                         `create_time`, `update_by`, `update_time`, `remark`)
values (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow'),
       (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '初始化密码 123456'),
       (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '深色主题theme-dark，浅色主题theme-light');

/*Table structure for table `sys_dept` */

DROP TABLE IF EXISTS `sys_dept`;

CREATE TABLE `sys_dept`
(
    `dept_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
    `parent_id`   bigint(20)  DEFAULT '0' COMMENT '父部门id',
    `ancestors`   varchar(50) DEFAULT '' COMMENT '祖级列表',
    `dept_name`   varchar(30) DEFAULT '' COMMENT '部门名称',
    `order_num`   int(4)      DEFAULT '0' COMMENT '显示顺序',
    `leader`      varchar(20) DEFAULT NULL COMMENT '负责人',
    `phone`       varchar(11) DEFAULT NULL COMMENT '联系电话',
    `email`       varchar(50) DEFAULT NULL COMMENT '邮箱',
    `status`      char(1)     DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
    `del_flag`    char(1)     DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_by`   varchar(64) DEFAULT '' COMMENT '创建者',
    `create_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64) DEFAULT '' COMMENT '更新者',
    `update_time` datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`dept_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 200
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='部门表';

/*Data for the table `sys_dept` */

insert into `sys_dept`(`dept_id`, `parent_id`, `ancestors`, `dept_name`, `order_num`, `leader`, `phone`, `email`,
                       `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
values (100, 0, '0', '若依科技', 0, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00'),
       (101, 100, '0,100', '深圳总公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00'),
       (102, 100, '0,100', '长沙分公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00'),
       (103, 101, '0,100,101', '研发部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00'),
       (104, 101, '0,100,101', '市场部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00'),
       (105, 101, '0,100,101', '测试部门', 3, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00'),
       (106, 101, '0,100,101', '财务部门', 4, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00'),
       (107, 101, '0,100,101', '运维部门', 5, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00'),
       (108, 102, '0,100,102', '市场部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00'),
       (109, 102, '0,100,102', '财务部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00');

/*Table structure for table `sys_dict_data` */

DROP TABLE IF EXISTS `sys_dict_data`;

CREATE TABLE `sys_dict_data`
(
    `dict_code`   bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
    `dict_sort`   int(4)       DEFAULT '0' COMMENT '字典排序',
    `dict_label`  varchar(100) DEFAULT '' COMMENT '字典标签',
    `dict_value`  varchar(100) DEFAULT '' COMMENT '字典键值',
    `dict_type`   varchar(100) DEFAULT '' COMMENT '字典类型',
    `css_class`   varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
    `list_class`  varchar(100) DEFAULT NULL COMMENT '表格回显样式',
    `is_default`  char(1)      DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
    `status`      char(1)      DEFAULT '0' COMMENT '状态（0正常 1停用）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`dict_code`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 109
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='字典数据表';

/*Data for the table `sys_dict_data` */

insert into `sys_dict_data`(`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`,
                            `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`,
                            `update_time`, `remark`)
values (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00',
        '性别男'),
       (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00',
        '性别女'),
       (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00',
        '性别未知'),
       (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '显示菜单'),
       (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '隐藏菜单'),
       (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '正常状态'),
       (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '停用状态'),
       (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '正常状态'),
       (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '停用状态'),
       (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '默认分组'),
       (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '系统分组'),
       (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '系统默认是'),
       (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '系统默认否'),
       (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '通知'),
       (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '公告'),
       (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '正常状态'),
       (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '关闭状态'),
       (18, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '新增操作'),
       (19, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '修改操作'),
       (20, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '删除操作'),
       (21, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '授权操作'),
       (22, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '导出操作'),
       (23, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '导入操作'),
       (24, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '强退操作'),
       (25, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '生成操作'),
       (26, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '清空操作'),
       (27, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '正常状态'),
       (28, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '停用状态'),
       (100, 0, '文本', 'text', 'wx_rep_type', NULL, NULL, 'N', '0', 'admin', '2020-03-04 11:53:07', '', NULL, NULL),
       (101, 0, '图片', 'image', 'wx_rep_type', NULL, NULL, 'N', '0', 'admin', '2020-03-04 11:53:18', '', NULL, NULL),
       (102, 0, '语音', 'voice', 'wx_rep_type', NULL, NULL, 'N', '0', 'admin', '2020-03-04 11:53:28', '', NULL, NULL),
       (103, 0, '视频', 'video', 'wx_rep_type', NULL, NULL, 'N', '0', 'admin', '2020-03-04 11:53:39', '', NULL, NULL),
       (104, 0, '音乐', 'music', 'wx_rep_type', NULL, NULL, 'N', '0', 'admin', '2020-03-04 11:53:48', '', NULL, NULL),
       (105, 0, '图文', 'news', 'wx_rep_type', NULL, NULL, 'N', '0', 'admin', '2020-03-04 11:54:00', '', NULL, NULL),
       (106, 0, '已关注', '1', 'wx_subscribe', NULL, NULL, 'N', '0', 'admin', '2020-03-04 11:55:55', '', NULL, NULL),
       (107, 0, '取消关注', '0', 'wx_subscribe', NULL, NULL, 'N', '0', 'admin', '2020-03-04 11:56:04', '', NULL, NULL),
       (108, 0, '网页授权用户', '2', 'wx_subscribe', NULL, NULL, 'N', '0', 'admin', '2020-03-04 11:56:11', '', NULL, NULL);

/*Table structure for table `sys_dict_type` */

DROP TABLE IF EXISTS `sys_dict_type`;

CREATE TABLE `sys_dict_type`
(
    `dict_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
    `dict_name`   varchar(100) DEFAULT '' COMMENT '字典名称',
    `dict_type`   varchar(100) DEFAULT '' COMMENT '字典类型',
    `status`      char(1)      DEFAULT '0' COMMENT '状态（0正常 1停用）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`dict_id`),
    UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 102
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='字典类型表';

/*Data for the table `sys_dict_type` */

insert into `sys_dict_type`(`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`,
                            `update_time`, `remark`)
values (1, '用户性别', 'sys_user_sex', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户性别列表'),
       (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单状态列表'),
       (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统开关列表'),
       (4, '任务状态', 'sys_job_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务状态列表'),
       (5, '任务分组', 'sys_job_group', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务分组列表'),
       (6, '系统是否', 'sys_yes_no', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统是否列表'),
       (7, '通知类型', 'sys_notice_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知类型列表'),
       (8, '通知状态', 'sys_notice_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知状态列表'),
       (9, '操作类型', 'sys_oper_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作类型列表'),
       (10, '系统状态', 'sys_common_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录状态列表'),
       (100, '微信回复消息类型', 'wx_rep_type', '0', 'admin', '2020-03-04 11:52:26', '', NULL, NULL);

/*Table structure for table `sys_job` */

DROP TABLE IF EXISTS `sys_job`;

CREATE TABLE `sys_job`
(
    `job_id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '任务ID',
    `job_name`        varchar(64)  NOT NULL DEFAULT '' COMMENT '任务名称',
    `job_group`       varchar(64)  NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
    `invoke_target`   varchar(500) NOT NULL COMMENT '调用目标字符串',
    `cron_expression` varchar(255)          DEFAULT '' COMMENT 'cron执行表达式',
    `misfire_policy`  varchar(20)           DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
    `concurrent`      char(1)               DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
    `status`          char(1)               DEFAULT '0' COMMENT '状态（0正常 1暂停）',
    `create_by`       varchar(64)           DEFAULT '' COMMENT '创建者',
    `create_time`     datetime              DEFAULT NULL COMMENT '创建时间',
    `update_by`       varchar(64)           DEFAULT '' COMMENT '更新者',
    `update_time`     datetime              DEFAULT NULL COMMENT '更新时间',
    `remark`          varchar(500)          DEFAULT '' COMMENT '备注信息',
    PRIMARY KEY (`job_id`, `job_name`, `job_group`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='定时任务调度表';

/*Data for the table `sys_job` */

insert into `sys_job`(`job_id`, `job_name`, `job_group`, `invoke_target`, `cron_expression`, `misfire_policy`,
                      `concurrent`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
values (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2018-03-16 11:33:00',
        'ry', '2020-04-25 12:01:48', ''),
       (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''),
       (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3',
        '1', '1', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

/*Table structure for table `sys_job_log` */

DROP TABLE IF EXISTS `sys_job_log`;

CREATE TABLE `sys_job_log`
(
    `job_log_id`     bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
    `job_name`       varchar(64)  NOT NULL COMMENT '任务名称',
    `job_group`      varchar(64)  NOT NULL COMMENT '任务组名',
    `invoke_target`  varchar(500) NOT NULL COMMENT '调用目标字符串',
    `job_message`    varchar(500)  DEFAULT NULL COMMENT '日志信息',
    `status`         char(1)       DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
    `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
    `create_time`    datetime      DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`job_log_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='定时任务调度日志表';

/*Data for the table `sys_job_log` */

insert into `sys_job_log`(`job_log_id`, `job_name`, `job_group`, `invoke_target`, `job_message`, `status`,
                          `exception_info`, `create_time`)
values (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '系统默认（无参） 总共耗时：8毫秒', '0', '', '2020-04-25 12:01:44');

/*Table structure for table `sys_logininfor` */

DROP TABLE IF EXISTS `sys_logininfor`;

CREATE TABLE `sys_logininfor`
(
    `info_id`        bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
    `user_name`      varchar(50)  DEFAULT '' COMMENT '用户账号',
    `ipaddr`         varchar(50)  DEFAULT '' COMMENT '登录IP地址',
    `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
    `browser`        varchar(50)  DEFAULT '' COMMENT '浏览器类型',
    `os`             varchar(50)  DEFAULT '' COMMENT '操作系统',
    `status`         char(1)      DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
    `msg`            varchar(255) DEFAULT '' COMMENT '提示消息',
    `login_time`     datetime     DEFAULT NULL COMMENT '访问时间',
    PRIMARY KEY (`info_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 169
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='系统访问记录';

/*Data for the table `sys_logininfor` */

insert into `sys_logininfor`(`info_id`, `user_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`,
                             `login_time`)
values (100, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-01 10:36:33'),
       (101, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-01 11:31:53'),
       (102, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-01 20:59:30'),
       (103, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-02 11:51:07'),
       (104, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-02 12:35:33'),
       (105, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-02 12:44:56'),
       (106, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-02 12:45:03'),
       (107, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '验证码错误', '2020-03-02 14:12:31'),
       (108, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-02 16:01:36'),
       (109, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-02 20:39:09'),
       (110, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '验证码错误', '2020-03-02 21:55:03'),
       (111, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-02 21:55:11'),
       (112, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-03 10:43:01'),
       (113, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-03 10:53:48'),
       (114, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-03 10:53:58'),
       (115, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-03 11:16:32'),
       (116, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-03 11:16:40'),
       (117, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-03 14:50:47'),
       (118, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-03 15:35:41'),
       (119, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-03 15:36:52'),
       (120, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '验证码错误', '2020-03-03 15:38:03'),
       (121, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-03 15:38:08'),
       (122, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-03 16:44:39'),
       (123, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-03 20:17:03'),
       (124, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-03 20:19:41'),
       (125, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-03 20:19:56'),
       (126, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-03 21:49:43'),
       (127, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-04 10:08:55'),
       (128, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-04 10:25:07'),
       (129, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-04 14:16:50'),
       (130, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-04 15:15:52'),
       (131, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-04 17:03:31'),
       (132, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-04 17:03:41'),
       (133, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-04 17:05:33'),
       (134, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-04 17:05:39'),
       (135, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-04 17:48:30'),
       (136, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-04 21:01:02'),
       (137, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-05 11:43:13'),
       (138, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-05 14:47:14'),
       (139, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-05 15:01:35'),
       (140, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-05 15:02:42'),
       (141, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-05 15:02:52'),
       (142, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-05 15:02:58'),
       (143, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '验证码错误', '2020-03-05 17:30:10'),
       (144, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-05 17:30:18'),
       (145, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-05 19:51:04'),
       (146, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-05 20:03:30'),
       (147, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-05 20:03:38'),
       (148, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-05 20:04:30'),
       (149, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-05 20:04:36'),
       (150, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-05 20:07:39'),
       (151, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-05 20:09:24'),
       (152, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-05 20:10:03'),
       (153, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '验证码错误', '2020-03-05 20:10:15'),
       (154, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-05 20:10:21'),
       (155, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-05 20:14:34'),
       (156, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '用户不存在/密码错误', '2020-03-05 20:21:53'),
       (157, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-05 20:31:27'),
       (158, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-07 13:24:01'),
       (159, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-07 14:21:27'),
       (160, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-07 14:25:09'),
       (161, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-07 14:25:15'),
       (162, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-17 09:57:26'),
       (163, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-17 10:50:05'),
       (164, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-17 10:58:19'),
       (165, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-17 10:58:26'),
       (166, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2020-03-17 10:58:30'),
       (167, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-03-17 10:58:36'),
       (168, 'test', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2020-04-25 12:01:02');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu`
(
    `menu_id`     bigint(20)                                               NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
    `menu_name`   varchar(50)                                              NOT NULL COMMENT '菜单名称',
    `parent_id`   bigint(20)   DEFAULT '0' COMMENT '父菜单ID',
    `order_num`   int(4)       DEFAULT '0' COMMENT '显示顺序',
    `path`        varchar(200) DEFAULT '' COMMENT '路由地址',
    `component`   varchar(255) DEFAULT NULL COMMENT '组件路径',
    `is_frame`    int(1)       DEFAULT '1' COMMENT '是否为外链（0是 1否）',
    `menu_type`   char(1)      DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
    `visible`     char(1)      DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
    `status`      char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单状态（0正常 1停用）',
    `perms`       varchar(100) DEFAULT NULL COMMENT '权限标识',
    `icon`        varchar(100) DEFAULT '#' COMMENT '菜单图标',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) DEFAULT '' COMMENT '备注',
    PRIMARY KEY (`menu_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2030
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='菜单权限表';

/*Data for the table `sys_menu` */

insert into `sys_menu`(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `menu_type`,
                       `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`,
                       `remark`)
values (1, '系统管理', 0, 1, 'system', NULL, 1, 'M', '0', '0', '', 'system', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '系统管理目录'),
       (2, '系统监控', 0, 2, 'monitor', NULL, 1, 'M', '0', '0', '', 'monitor', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '系统监控目录'),
       (3, '系统工具', 0, 3, 'tool', NULL, 1, 'M', '0', '0', '', 'tool', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '系统工具目录'),
       (4, '公众号管理', 0, 0, 'wxmp', NULL, 1, 'M', '0', '0', '', 'wechat', 'admin', '2018-03-16 11:33:00', 'admin',
        '2020-03-05 14:59:21', '若依官网地址'),
       (100, '用户管理', 1, 1, 'user', 'system/user/index', 1, 'C', '0', '0', 'system:user:list', 'user', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单'),
       (101, '角色管理', 1, 2, 'role', 'system/role/index', 1, 'C', '0', '0', 'system:role:list', 'peoples', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '角色管理菜单'),
       (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', 1, 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单'),
       (103, '部门管理', 1, 4, 'dept', 'system/dept/index', 1, 'C', '0', '0', 'system:dept:list', 'tree', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '部门管理菜单'),
       (104, '岗位管理', 1, 5, 'post', 'system/post/index', 1, 'C', '0', '0', 'system:post:list', 'post', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '岗位管理菜单'),
       (105, '字典管理', 1, 6, 'dict', 'system/dict/index', 1, 'C', '0', '0', 'system:dict:list', 'dict', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '字典管理菜单'),
       (106, '参数设置', 1, 7, 'config', 'system/config/index', 1, 'C', '0', '0', 'system:config:list', 'edit', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '参数设置菜单'),
       (107, '通知公告', 1, 8, 'notice', 'system/notice/index', 1, 'C', '0', '0', 'system:notice:list', 'message', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知公告菜单'),
       (108, '日志管理', 1, 9, 'log', 'system/log/index', 1, 'M', '0', '0', '', 'log', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', '日志管理菜单'),
       (109, '在线用户', 2, 1, 'online', 'monitor/online/index', 1, 'C', '0', '0', 'monitor:online:list', 'online', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '在线用户菜单'),
       (110, '定时任务', 2, 2, 'job', 'monitor/job/index', 1, 'C', '0', '0', 'monitor:job:list', 'job', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '定时任务菜单'),
       (111, '数据监控', 2, 3, 'druid', 'monitor/druid/index', 1, 'C', '0', '0', 'monitor:druid:list', 'druid', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '数据监控菜单'),
       (112, '服务监控', 2, 4, 'server', 'monitor/server/index', 1, 'C', '0', '0', 'monitor:server:list', 'server', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '服务监控菜单'),
       (113, '表单构建', 3, 1, 'build', 'tool/build/index', 1, 'C', '0', '0', 'tool:build:list', 'build', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '表单构建菜单'),
       (114, '代码生成', 3, 2, 'gen', 'tool/gen/index', 1, 'C', '0', '0', 'tool:gen:list', 'code', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '代码生成菜单'),
       (115, '系统接口', 3, 3, 'swagger', 'tool/swagger/index', 1, 'C', '0', '0', 'tool:swagger:list', 'swagger', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统接口菜单'),
       (500, '操作日志', 108, 1, 'operlog', 'monitor/operlog/index', 1, 'C', '0', '0', 'monitor:operlog:list', 'form',
        'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作日志菜单'),
       (501, '登录日志', 108, 2, 'logininfor', 'monitor/logininfor/index', 1, 'C', '0', '0', 'monitor:logininfor:list',
        'logininfor', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录日志菜单'),
       (1001, '用户查询', 100, 1, '', '', 1, 'F', '0', '0', 'system:user:query', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1002, '用户新增', 100, 2, '', '', 1, 'F', '0', '0', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1003, '用户修改', 100, 3, '', '', 1, 'F', '0', '0', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1004, '用户删除', 100, 4, '', '', 1, 'F', '0', '0', 'system:user:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1005, '用户导出', 100, 5, '', '', 1, 'F', '0', '0', 'system:user:export', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1006, '用户导入', 100, 6, '', '', 1, 'F', '0', '0', 'system:user:import', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1007, '重置密码', 100, 7, '', '', 1, 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1008, '角色查询', 101, 1, '', '', 1, 'F', '0', '0', 'system:role:query', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1009, '角色新增', 101, 2, '', '', 1, 'F', '0', '0', 'system:role:add', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1010, '角色修改', 101, 3, '', '', 1, 'F', '0', '0', 'system:role:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1011, '角色删除', 101, 4, '', '', 1, 'F', '0', '0', 'system:role:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1012, '角色导出', 101, 5, '', '', 1, 'F', '0', '0', 'system:role:export', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1013, '菜单查询', 102, 1, '', '', 1, 'F', '0', '0', 'system:menu:query', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1014, '菜单新增', 102, 2, '', '', 1, 'F', '0', '0', 'system:menu:add', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1015, '菜单修改', 102, 3, '', '', 1, 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1016, '菜单删除', 102, 4, '', '', 1, 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1017, '部门查询', 103, 1, '', '', 1, 'F', '0', '0', 'system:dept:query', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1018, '部门新增', 103, 2, '', '', 1, 'F', '0', '0', 'system:dept:add', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1019, '部门修改', 103, 3, '', '', 1, 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1020, '部门删除', 103, 4, '', '', 1, 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1021, '岗位查询', 104, 1, '', '', 1, 'F', '0', '0', 'system:post:query', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1022, '岗位新增', 104, 2, '', '', 1, 'F', '0', '0', 'system:post:add', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1023, '岗位修改', 104, 3, '', '', 1, 'F', '0', '0', 'system:post:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1024, '岗位删除', 104, 4, '', '', 1, 'F', '0', '0', 'system:post:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1025, '岗位导出', 104, 5, '', '', 1, 'F', '0', '0', 'system:post:export', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1026, '字典查询', 105, 1, '#', '', 1, 'F', '0', '0', 'system:dict:query', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1027, '字典新增', 105, 2, '#', '', 1, 'F', '0', '0', 'system:dict:add', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1028, '字典修改', 105, 3, '#', '', 1, 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1029, '字典删除', 105, 4, '#', '', 1, 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1030, '字典导出', 105, 5, '#', '', 1, 'F', '0', '0', 'system:dict:export', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1031, '参数查询', 106, 1, '#', '', 1, 'F', '0', '0', 'system:config:query', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1032, '参数新增', 106, 2, '#', '', 1, 'F', '0', '0', 'system:config:add', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1033, '参数修改', 106, 3, '#', '', 1, 'F', '0', '0', 'system:config:edit', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1034, '参数删除', 106, 4, '#', '', 1, 'F', '0', '0', 'system:config:remove', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1035, '参数导出', 106, 5, '#', '', 1, 'F', '0', '0', 'system:config:export', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1036, '公告查询', 107, 1, '#', '', 1, 'F', '0', '0', 'system:notice:query', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1037, '公告新增', 107, 2, '#', '', 1, 'F', '0', '0', 'system:notice:add', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1038, '公告修改', 107, 3, '#', '', 1, 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1039, '公告删除', 107, 4, '#', '', 1, 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1040, '操作查询', 500, 1, '#', '', 1, 'F', '0', '0', 'monitor:operlog:query', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1041, '操作删除', 500, 2, '#', '', 1, 'F', '0', '0', 'monitor:operlog:remove', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1042, '日志导出', 500, 4, '#', '', 1, 'F', '0', '0', 'monitor:operlog:export', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1043, '登录查询', 501, 1, '#', '', 1, 'F', '0', '0', 'monitor:logininfor:query', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''),
       (1044, '登录删除', 501, 2, '#', '', 1, 'F', '0', '0', 'monitor:logininfor:remove', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''),
       (1045, '日志导出', 501, 3, '#', '', 1, 'F', '0', '0', 'monitor:logininfor:export', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''),
       (1046, '在线查询', 109, 1, '#', '', 1, 'F', '0', '0', 'monitor:online:query', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1047, '批量强退', 109, 2, '#', '', 1, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''),
       (1048, '单条强退', 109, 3, '#', '', 1, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''),
       (1049, '任务查询', 110, 1, '#', '', 1, 'F', '0', '0', 'monitor:job:query', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1050, '任务新增', 110, 2, '#', '', 1, 'F', '0', '0', 'monitor:job:add', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1051, '任务修改', 110, 3, '#', '', 1, 'F', '0', '0', 'monitor:job:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1052, '任务删除', 110, 4, '#', '', 1, 'F', '0', '0', 'monitor:job:remove', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1053, '状态修改', 110, 5, '#', '', 1, 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''),
       (1054, '任务导出', 110, 7, '#', '', 1, 'F', '0', '0', 'monitor:job:export', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', ''),
       (1055, '生成查询', 114, 1, '#', '', 1, 'F', '0', '0', 'tool:gen:query', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1056, '生成修改', 114, 2, '#', '', 1, 'F', '0', '0', 'tool:gen:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1057, '生成删除', 114, 3, '#', '', 1, 'F', '0', '0', 'tool:gen:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1058, '导入代码', 114, 2, '#', '', 1, 'F', '0', '0', 'tool:gen:import', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1059, '预览代码', 114, 4, '#', '', 1, 'F', '0', '0', 'tool:gen:preview', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (1060, '生成代码', 114, 5, '#', '', 1, 'F', '0', '0', 'tool:gen:code', '#', 'admin', '2018-03-16 11:33:00', 'ry',
        '2018-03-16 11:33:00', ''),
       (2000, '用户标签', 4, 10, 'wxusertags', 'wxmp/wxusertags/index', 1, 'C', '0', '0', 'wxmp:wxusertags:list', 'tab',
        'admin', '2020-03-03 10:47:36', 'admin', '2020-03-03 20:17:50', ''),
       (2001, '修改标签', 2000, 10, '', NULL, 1, 'F', '1', '0', 'wxmp:wxusertags:edit', '#', 'admin', '2020-03-03 11:16:13',
        '', NULL, ''),
       (2002, '公众号用户', 4, 20, 'wxuser', 'wxmp/wxuser/index', 1, 'C', '0', '0', 'wxmp:wxuser:index', 'peoples', 'admin',
        '2020-03-04 10:13:30', '', NULL, ''),
       (2003, '用户消息', 4, 30, 'wxmsg', 'wxmp/wxmsg/index', 1, 'C', '0', '0', 'wxmp:wxmsg:index', 'clipboard', 'admin',
        '2020-03-04 10:15:47', '', NULL, ''),
       (2004, '素材管理', 4, 40, 'wxmaterial', 'wxmp/wxmaterial/index', 1, 'C', '0', '0', 'wxmp:wxmsg:index', 'example',
        'admin', '2020-03-04 10:17:21', '', NULL, ''),
       (2005, '自定义菜单', 4, 50, 'wxmenu', 'wxmp/wxmenu/detail', 1, 'C', '0', '0', 'wxmp:wxmenu:get', 'cascader', 'admin',
        '2020-03-04 10:18:02', 'admin', '2020-03-04 10:29:20', ''),
       (2006, '消息自动回复', 4, 60, 'wxautoreply', 'wxmp/wxautoreply/index', 1, 'C', '0', '0', 'wxmp:wxautoreply:index',
        'dashboard', 'admin', '2020-03-04 10:18:53', '', NULL, ''),
       (2007, '数据统计', 4, 70, 'wxsummary', 'wxmp/wxsummary/index', 1, 'C', '0', '0', NULL, 'druid', 'admin',
        '2020-03-04 10:19:53', '', NULL, ''),
       (2008, '用户标签删除', 2000, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxusertags:del', '#', 'admin', '2020-03-04 17:08:10',
        '', NULL, ''),
       (2009, '用户标签新增', 2000, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxusertags:add', '#', 'admin', '2020-03-04 17:08:42',
        '', NULL, ''),
       (2010, '公众号用户新增', 2002, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxuser:add', '#', 'admin', '2020-03-04 17:15:01',
        'admin', '2020-03-04 17:16:59', ''),
       (2011, '公众号用户修改', 2002, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxuser:edit', '#', 'admin', '2020-03-04 17:16:17',
        'admin', '2020-03-04 17:17:09', ''),
       (2012, '公众号用户打标签', 2002, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxuser:tagging', '#', 'admin',
        '2020-03-04 17:16:41', '', NULL, ''),
       (2013, '公众号用户备注修改', 2002, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxuser:edit:remark', '#', 'admin',
        '2020-03-04 17:17:43', '', NULL, ''),
       (2014, '公众号用户同步', 2002, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxuser:synchro', '#', 'admin',
        '2020-03-04 17:18:09', '', NULL, ''),
       (2015, '公众号用户删除', 2002, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxuser:del', '#', 'admin', '2020-03-04 17:18:31',
        '', NULL, ''),
       (2016, '公众号用户详情', 2002, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxuser:get', '#', 'admin', '2020-03-04 17:18:55',
        '', NULL, ''),
       (2017, '用户消息新增', 2003, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxmsg:add', '#', 'admin', '2020-03-04 17:19:24', '',
        NULL, ''),
       (2018, '用户消息修改', 2003, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxmsg:edit', '#', 'admin', '2020-03-04 17:19:45', '',
        NULL, ''),
       (2019, '用户消息删除', 2003, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxmsg:del', '#', 'admin', '2020-03-04 17:20:03', '',
        NULL, ''),
       (2020, '用户消息详情', 2003, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxmsg:get', '#', 'admin', '2020-03-04 17:20:21', '',
        NULL, ''),
       (2021, '素材新增', 2004, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxmaterial:add', '#', 'admin', '2020-03-04 17:20:43',
        '', NULL, ''),
       (2022, '素材修改', 2004, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxmaterial:edit', '#', 'admin', '2020-03-04 17:21:03',
        '', NULL, ''),
       (2023, '素材删除', 2004, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxmaterial:del', '#', 'admin', '2020-03-04 17:21:24',
        '', NULL, ''),
       (2024, '素材详情', 2004, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxmaterial:get', '#', 'admin', '2020-03-04 17:21:43',
        '', NULL, ''),
       (2025, '自定义菜单发布', 2005, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxmenu:add', '#', 'admin', '2020-03-04 17:22:12',
        '', NULL, ''),
       (2026, '消息自动回复新增', 2006, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxautoreply:add', '#', 'admin',
        '2020-03-04 17:22:43', '', NULL, ''),
       (2027, '消息自动回复修改', 2006, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxautoreply:edit', '#', 'admin',
        '2020-03-04 17:23:05', '', NULL, ''),
       (2028, '消息自动回复删除', 2006, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxautoreply:del', '#', 'admin',
        '2020-03-04 17:23:36', '', NULL, ''),
       (2029, '消息自动回复详情', 2006, 0, '', NULL, 1, 'F', '0', '0', 'wxmp:wxautoreply:get', '#', 'admin',
        '2020-03-04 17:23:59', '', NULL, '');

/*Table structure for table `sys_notice` */

DROP TABLE IF EXISTS `sys_notice`;

CREATE TABLE `sys_notice`
(
    `notice_id`      int(4)      NOT NULL AUTO_INCREMENT COMMENT '公告ID',
    `notice_title`   varchar(50) NOT NULL COMMENT '公告标题',
    `notice_type`    char(1)     NOT NULL COMMENT '公告类型（1通知 2公告）',
    `notice_content` varchar(2000) DEFAULT NULL COMMENT '公告内容',
    `status`         char(1)       DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
    `create_by`      varchar(64)   DEFAULT '' COMMENT '创建者',
    `create_time`    datetime      DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(64)   DEFAULT '' COMMENT '更新者',
    `update_time`    datetime      DEFAULT NULL COMMENT '更新时间',
    `remark`         varchar(255)  DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`notice_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='通知公告表';

/*Data for the table `sys_notice` */

insert into `sys_notice`(`notice_id`, `notice_title`, `notice_type`, `notice_content`, `status`, `create_by`,
                         `create_time`, `update_by`, `update_time`, `remark`)
values (1, '温馨提醒：2018-07-01 若依新版本发布啦', '2', '新版本内容', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00',
        '管理员'),
       (2, '维护通知：2018-07-01 若依系统凌晨维护', '1', '维护内容', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00',
        '管理员');

/*Table structure for table `sys_oper_log` */

DROP TABLE IF EXISTS `sys_oper_log`;

CREATE TABLE `sys_oper_log`
(
    `oper_id`        bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
    `title`          varchar(50)   DEFAULT '' COMMENT '模块标题',
    `business_type`  int(2)        DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
    `method`         varchar(100)  DEFAULT '' COMMENT '方法名称',
    `request_method` varchar(10)   DEFAULT '' COMMENT '请求方式',
    `operator_type`  int(1)        DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
    `oper_name`      varchar(50)   DEFAULT '' COMMENT '操作人员',
    `dept_name`      varchar(50)   DEFAULT '' COMMENT '部门名称',
    `oper_url`       varchar(255)  DEFAULT '' COMMENT '请求URL',
    `oper_ip`        varchar(50)   DEFAULT '' COMMENT '主机地址',
    `oper_location`  varchar(255)  DEFAULT '' COMMENT '操作地点',
    `oper_param`     varchar(2000) DEFAULT '' COMMENT '请求参数',
    `json_result`    varchar(2000) DEFAULT '' COMMENT '返回参数',
    `status`         int(1)        DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
    `error_msg`      varchar(2000) DEFAULT '' COMMENT '错误消息',
    `oper_time`      datetime      DEFAULT NULL COMMENT '操作时间',
    PRIMARY KEY (`oper_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 161
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='操作日志记录';

/*Data for the table `sys_oper_log` */

insert into `sys_oper_log`(`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`,
                           `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`,
                           `json_result`, `status`, `error_msg`, `oper_time`)
values (100, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"wechat\",\"orderNum\":\"4\",\"menuName\":\"微信管理\",\"params\":{},\"parentId\":0,\"path\":\"weixin\",\"children\":[],\"createTime\":1521171180000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":4,\"menuType\":\"M\",\"perms\":\"\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-03 10:44:51'),
       (101, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"tab\",\"orderNum\":\"10\",\"menuName\":\"用户标签\",\"params\":{},\"parentId\":4,\"path\":\"wxusertags\",\"component\":\"wxmp/wxusertags/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-03 10:47:36'),
       (102, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"wechat\",\"orderNum\":\"4\",\"menuName\":\"公众号管理\",\"params\":{},\"parentId\":0,\"path\":\"wxmp\",\"children\":[],\"createTime\":1521171180000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":4,\"menuType\":\"M\",\"perms\":\"\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-03 10:47:55'),
       (103, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"tab\",\"orderNum\":\"10\",\"menuName\":\"用户标签\",\"params\":{},\"parentId\":4,\"path\":\"wxusertags\",\"component\":\"wxmp/wxusertags/index\",\"children\":[],\"createTime\":1583203656000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2000,\"menuType\":\"C\",\"perms\":\"wxmp:wxusertags:list\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-03 10:52:18'),
       (104, '角色管理', 2, 'com.ruoyi.project.system.controller.SysRoleController.edit()', 'PUT', 1, 'admin', NULL,
        '/system/role', '127.0.0.1', '内网IP',
        '{\"flag\":false,\"roleId\":1,\"admin\":true,\"remark\":\"管理员\",\"dataScope\":\"1\",\"delFlag\":\"0\",\"params\":{},\"roleSort\":\"1\",\"createTime\":1521171180000,\"roleKey\":\"admin\",\"roleName\":\"管理员\",\"menuIds\":[1,100,1001,1002,1003,1004,1005,1006,1007,101,1008,1009,1010,1011,1012,102,1013,1014,1015,1016,103,1017,1018,1019,1020,104,1021,1022,1023,1024,1025,105,1026,1027,1028,1029,1030,106,1031,1032,1033,1034,1035,107,1036,1037,1038,1039,108,500,1040,1041,1042,501,1043,1044,1045,2,109,1046,1047,1048,110,1049,1050,1051,1052,1053,1054,111,112,3,113,114,1055,1056,1058,1057,1059,1060,115,4,2000],\"status\":\"0\"}',
        'null', 1, '不允许操作超级管理员角色', '2020-03-03 11:07:36'),
       (105, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"1\",\"orderNum\":\"10\",\"menuName\":\"修改标签\",\"params\":{},\"parentId\":2000,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxusertags:edit\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-03 11:16:13'),
       (106, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"wechat\",\"orderNum\":\"4\",\"menuName\":\"公众号管理\",\"params\":{},\"parentId\":0,\"path\":\"wxmp\",\"children\":[],\"createTime\":1521171180000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":4,\"menuType\":\"M\",\"perms\":\"\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-03 20:17:20'),
       (107, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"tab\",\"orderNum\":\"10\",\"menuName\":\"用户标签\",\"params\":{},\"parentId\":4,\"path\":\"wxusertags\",\"component\":\"wxmp/wxusertags/index\",\"children\":[],\"createTime\":1583203656000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2000,\"menuType\":\"C\",\"perms\":\"wxmp:wxusertags:list\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-03 20:17:50'),
       (108, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"peoples\",\"orderNum\":\"20\",\"menuName\":\"公众号用户\",\"params\":{},\"parentId\":4,\"path\":\"wxuser\",\"component\":\"wxmp/wxuser/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"perms\":\"wxmp:wxuser:index\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 10:13:30'),
       (109, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"clipboard\",\"orderNum\":\"30\",\"menuName\":\"用户消息\",\"params\":{},\"parentId\":4,\"path\":\"wxmsg\",\"component\":\"wxmp/wxmsg/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"perms\":\"wxmp:wxmsg:index\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 10:15:47'),
       (110, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"example\",\"orderNum\":\"40\",\"menuName\":\"素材管理\",\"params\":{},\"parentId\":4,\"path\":\"wxmaterial\",\"component\":\"wxmp/wxmaterial/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"perms\":\"wxmp:wxmsg:index\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 10:17:21'),
       (111, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"50\",\"menuName\":\"自定义菜单\",\"params\":{},\"parentId\":4,\"path\":\"wxmenu\",\"component\":\"wxmp/wxmenu/detail\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"perms\":\"wxmp:wxmenu:get\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 10:18:02'),
       (112, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"dashboard\",\"orderNum\":\"60\",\"menuName\":\"消息自动回复\",\"params\":{},\"parentId\":4,\"path\":\"wxautoreply\",\"component\":\"wxmp/wxautoreply/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"perms\":\"wxmp:wxautoreply:index\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 10:18:53'),
       (113, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"druid\",\"orderNum\":\"70\",\"menuName\":\"数据统计\",\"params\":{},\"parentId\":4,\"path\":\"wxsummary\",\"component\":\"wxmp/wxsummary/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 10:19:53'),
       (114, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"cascader\",\"orderNum\":\"50\",\"menuName\":\"自定义菜单\",\"params\":{},\"parentId\":4,\"path\":\"wxmenu\",\"component\":\"wxmp/wxmenu/detail\",\"children\":[],\"createTime\":1583288282000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2005,\"menuType\":\"C\",\"perms\":\"wxmp:wxmenu:get\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 10:29:20'),
       (115, '字典类型', 1, 'com.ruoyi.project.system.controller.SysDictTypeController.add()', 'POST', 1, 'admin', NULL,
        '/system/dict/type', '127.0.0.1', '内网IP',
        '{\"params\":{},\"dictType\":\"wx_rep_type\",\"createBy\":\"admin\",\"dictName\":\"微信回复消息类型\",\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 11:52:26'),
       (116, '字典数据', 1, 'com.ruoyi.project.system.controller.SysDictDataController.add()', 'POST', 1, 'admin', NULL,
        '/system/dict/data', '127.0.0.1', '内网IP',
        '{\"dictValue\":\"text\",\"dictSort\":0,\"params\":{},\"dictType\":\"wx_rep_type\",\"dictLabel\":\"文本\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 11:53:07'),
       (117, '字典数据', 1, 'com.ruoyi.project.system.controller.SysDictDataController.add()', 'POST', 1, 'admin', NULL,
        '/system/dict/data', '127.0.0.1', '内网IP',
        '{\"dictValue\":\"image\",\"dictSort\":0,\"params\":{},\"dictType\":\"wx_rep_type\",\"dictLabel\":\"图片\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 11:53:18'),
       (118, '字典数据', 1, 'com.ruoyi.project.system.controller.SysDictDataController.add()', 'POST', 1, 'admin', NULL,
        '/system/dict/data', '127.0.0.1', '内网IP',
        '{\"dictValue\":\"voice\",\"dictSort\":0,\"params\":{},\"dictType\":\"wx_rep_type\",\"dictLabel\":\"语音\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 11:53:28'),
       (119, '字典数据', 1, 'com.ruoyi.project.system.controller.SysDictDataController.add()', 'POST', 1, 'admin', NULL,
        '/system/dict/data', '127.0.0.1', '内网IP',
        '{\"dictValue\":\"video\",\"dictSort\":0,\"params\":{},\"dictType\":\"wx_rep_type\",\"dictLabel\":\"视频\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 11:53:39'),
       (120, '字典数据', 1, 'com.ruoyi.project.system.controller.SysDictDataController.add()', 'POST', 1, 'admin', NULL,
        '/system/dict/data', '127.0.0.1', '内网IP',
        '{\"dictValue\":\"music\",\"dictSort\":0,\"params\":{},\"dictType\":\"wx_rep_type\",\"dictLabel\":\"音乐\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 11:53:48'),
       (121, '字典数据', 1, 'com.ruoyi.project.system.controller.SysDictDataController.add()', 'POST', 1, 'admin', NULL,
        '/system/dict/data', '127.0.0.1', '内网IP',
        '{\"dictValue\":\"news\",\"dictSort\":0,\"params\":{},\"dictType\":\"wx_rep_type\",\"dictLabel\":\"图文\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 11:54:00'),
       (122, '字典类型', 1, 'com.ruoyi.project.system.controller.SysDictTypeController.add()', 'POST', 1, 'admin', NULL,
        '/system/dict/type', '127.0.0.1', '内网IP',
        '{\"params\":{},\"dictType\":\"wx_subscribe\",\"createBy\":\"admin\",\"dictName\":\"微信用户关注状态\",\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 11:55:34'),
       (123, '字典数据', 1, 'com.ruoyi.project.system.controller.SysDictDataController.add()', 'POST', 1, 'admin', NULL,
        '/system/dict/data', '127.0.0.1', '内网IP',
        '{\"dictValue\":\"1\",\"dictSort\":0,\"params\":{},\"dictType\":\"wx_subscribe\",\"dictLabel\":\"已关注\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 11:55:55'),
       (124, '字典数据', 1, 'com.ruoyi.project.system.controller.SysDictDataController.add()', 'POST', 1, 'admin', NULL,
        '/system/dict/data', '127.0.0.1', '内网IP',
        '{\"dictValue\":\"0\",\"dictSort\":0,\"params\":{},\"dictType\":\"wx_subscribe\",\"dictLabel\":\"取消关注\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 11:56:04'),
       (125, '字典数据', 1, 'com.ruoyi.project.system.controller.SysDictDataController.add()', 'POST', 1, 'admin', NULL,
        '/system/dict/data', '127.0.0.1', '内网IP',
        '{\"dictValue\":\"2\",\"dictSort\":0,\"params\":{},\"dictType\":\"wx_subscribe\",\"dictLabel\":\"网页授权用户\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 11:56:11'),
       (126, '字典类型', 3, 'com.ruoyi.project.system.controller.SysDictTypeController.remove()', 'DELETE', 1, 'admin',
        NULL, '/system/dict/type/101', '127.0.0.1', '内网IP', '{dictIds=101}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL,
        '2020-03-04 12:12:58'),
       (127, '角色管理', 1, 'com.ruoyi.project.system.controller.SysRoleController.add()', 'POST', 1, 'admin', NULL,
        '/system/role', '127.0.0.1', '内网IP',
        '{\"flag\":false,\"roleId\":100,\"admin\":false,\"params\":{},\"roleSort\":\"0\",\"createBy\":\"admin\",\"roleKey\":\"test\",\"roleName\":\"test\",\"deptIds\":[],\"menuIds\":[1,100,1001,1002,1003,1004,1005,1006,1007,101,1008,1009,1010,1011,1012,102,1013,1014,1015,1016,103,1017,1018,1019,1020,104,1021,1022,1023,1024,1025,105,1026,1027,1028,1029,1030,106,1031,1032,1033,1034,1035,107,1036,1037,1038,1039,108,500,1040,1041,1042,501,1043,1044,1045,4,2000,2001,2002,2003,2004,2005,2006,2007],\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:01:56'),
       (128, '用户管理', 1, 'com.ruoyi.project.system.controller.SysUserController.add()', 'POST', 1, 'admin', NULL,
        '/system/user', '127.0.0.1', '内网IP',
        '{\"phonenumber\":\"18608549631\",\"admin\":false,\"password\":\"$2a$10$3jxuUvQAmkIuwtvYgXjNEOouJX89iv0lDZxWE2y.i9Ij0cIdB91Y6\",\"postIds\":[],\"email\":\"1023536325@qq.com\",\"nickName\":\"test\",\"sex\":\"0\",\"deptId\":100,\"params\":{},\"userName\":\"test\",\"userId\":100,\"createBy\":\"admin\",\"roleIds\":[],\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:02:29'),
       (129, '用户管理', 2, 'com.ruoyi.project.system.controller.SysUserController.edit()', 'PUT', 1, 'admin', NULL,
        '/system/user', '127.0.0.1', '内网IP',
        '{\"roles\":[],\"phonenumber\":\"18608549631\",\"admin\":false,\"delFlag\":\"0\",\"password\":\"\",\"updateBy\":\"admin\",\"postIds\":[],\"loginIp\":\"\",\"email\":\"1023536325@qq.com\",\"nickName\":\"test\",\"sex\":\"0\",\"deptId\":100,\"avatar\":\"\",\"dept\":{\"deptName\":\"若依科技\",\"leader\":\"若依\",\"deptId\":100,\"orderNum\":\"0\",\"params\":{},\"parentId\":0,\"children\":[],\"status\":\"0\"},\"params\":{},\"userName\":\"test\",\"userId\":100,\"createBy\":\"admin\",\"roleIds\":[100],\"createTime\":1583312549000,\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:03:28'),
       (130, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"用户标签删除\",\"params\":{},\"parentId\":2000,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxusertags:del\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:08:10'),
       (131, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"用户标签新增\",\"params\":{},\"parentId\":2000,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxusertags:add\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:08:42'),
       (132, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"公众号用户新增\",\"params\":{},\"parentId\":2002,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp_wxuser_add\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:15:01'),
       (133, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"公众号用户修改\",\"params\":{},\"parentId\":2002,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp_wxuser_edit\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:16:17'),
       (134, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"公众号用户打标签\",\"params\":{},\"parentId\":2002,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxuser:tagging\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:16:41'),
       (135, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"0\",\"menuName\":\"公众号用户新增\",\"params\":{},\"parentId\":2002,\"path\":\"\",\"children\":[],\"createTime\":1583313301000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2010,\"menuType\":\"F\",\"perms\":\"wxmp:wxuser:add\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:16:59'),
       (136, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"0\",\"menuName\":\"公众号用户修改\",\"params\":{},\"parentId\":2002,\"path\":\"\",\"children\":[],\"createTime\":1583313377000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2011,\"menuType\":\"F\",\"perms\":\"wxmp:wxuser:edit\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:17:09'),
       (137, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"公众号用户备注修改\",\"params\":{},\"parentId\":2002,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxuser:edit:remark\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:17:43'),
       (138, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"公众号用户同步\",\"params\":{},\"parentId\":2002,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxuser:synchro\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:18:09'),
       (139, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"公众号用户删除\",\"params\":{},\"parentId\":2002,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxuser:del\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:18:31'),
       (140, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"公众号用户详情\",\"params\":{},\"parentId\":2002,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxuser:get\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:18:55'),
       (141, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"用户消息新增\",\"params\":{},\"parentId\":2003,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxmsg:add\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:19:24'),
       (142, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"用户消息修改\",\"params\":{},\"parentId\":2003,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxmsg:edit\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:19:45'),
       (143, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"用户消息删除\",\"params\":{},\"parentId\":2003,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxmsg:del\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:20:03'),
       (144, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"用户消息详情\",\"params\":{},\"parentId\":2003,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxmsg:get\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:20:21'),
       (145, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"素材新增\",\"params\":{},\"parentId\":2004,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxmaterial:add\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:20:43'),
       (146, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"素材修改\",\"params\":{},\"parentId\":2004,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxmaterial:edit\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:21:03'),
       (147, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"素材删除\",\"params\":{},\"parentId\":2004,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxmaterial:del\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:21:24'),
       (148, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"素材详情\",\"params\":{},\"parentId\":2004,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxmaterial:get\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:21:43'),
       (149, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"自定义菜单发布\",\"params\":{},\"parentId\":2005,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxmenu:add\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:22:12'),
       (150, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"消息自动回复新增\",\"params\":{},\"parentId\":2006,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxautoreply:add\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:22:43'),
       (151, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"消息自动回复修改\",\"params\":{},\"parentId\":2006,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxautoreply:edit\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:23:05'),
       (152, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"消息自动回复删除\",\"params\":{},\"parentId\":2006,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxautoreply:del\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:23:36'),
       (153, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"orderNum\":\"0\",\"menuName\":\"消息自动回复详情\",\"params\":{},\"parentId\":2006,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"F\",\"perms\":\"wxmp:wxautoreply:get\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:23:59'),
       (154, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL,
        '/system/menu', '127.0.0.1', '内网IP',
        '{\"visible\":\"0\",\"icon\":\"wechat\",\"orderNum\":\"0\",\"menuName\":\"公众号管理\",\"params\":{},\"parentId\":0,\"path\":\"wxmp\",\"children\":[],\"createTime\":1521171180000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":4,\"menuType\":\"M\",\"perms\":\"\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 14:59:21'),
       (155, '角色管理', 2, 'com.ruoyi.project.system.controller.SysRoleController.edit()', 'PUT', 1, 'admin', NULL,
        '/system/role', '127.0.0.1', '内网IP',
        '{\"flag\":false,\"roleId\":100,\"admin\":false,\"dataScope\":\"1\",\"delFlag\":\"0\",\"params\":{},\"roleSort\":\"0\",\"createTime\":1583312516000,\"updateBy\":\"admin\",\"roleKey\":\"test\",\"roleName\":\"test\",\"menuIds\":[2001,2002,2010,2011,2012,2013,2014,2015,2016,2003,2017,2018,2019,2020,2004,2021,2022,2023,2024,2005,2025,2006,2026,2027,2028,2029,2007,1,100,1001,1002,1003,1004,1005,1006,1007,101,1008,1009,1010,1011,1012,102,1013,1014,1015,1016,103,1017,1018,1019,1020,104,1021,1022,1023,1024,1025,105,1026,1027,1028,1029,1030,106,1031,1032,1033,1034,1035,107,1036,1037,1038,1039,108,500,1040,1041,1042,501,1043,1044,1045,4,2000],\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 20:09:40'),
       (156, '角色管理', 2, 'com.ruoyi.project.system.controller.SysRoleController.edit()', 'PUT', 1, 'admin', NULL,
        '/system/role', '127.0.0.1', '内网IP',
        '{\"flag\":false,\"roleId\":100,\"admin\":false,\"dataScope\":\"1\",\"delFlag\":\"0\",\"params\":{},\"roleSort\":\"0\",\"createTime\":1583312516000,\"updateBy\":\"admin\",\"roleKey\":\"test\",\"roleName\":\"test\",\"menuIds\":[4,2000,2008,2009,2001,2002,2010,2011,2012,2013,2014,2015,2016,2003,2017,2018,2019,2020,2004,2021,2022,2023,2024,2005,2025,2006,2026,2027,2028,2029,2007,1,100,1001,1002,1003,1004,1005,1006,1007,101,1008,1009,1010,1011,1012,102,1013,1014,1015,1016,103,1017,1018,1019,1020,104,1021,1022,1023,1024,1025,105,1026,1027,1028,1029,1030,106,1031,1032,1033,1034,1035,107,1036,1037,1038,1039,108,500,1040,1041,1042,501,1043,1044,1045,2,109,1046,1047,1048,110,1049,1050,1051,1052,1053,1054,111,112,3,113,114,1055,1056,1058,1057,1059,1060,115],\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 20:09:59'),
       (157, '用户管理', 2, 'com.ruoyi.project.system.controller.SysUserController.edit()', 'PUT', 1, 'admin', NULL,
        '/system/user', '127.0.0.1', '内网IP',
        '{\"roles\":[{\"flag\":false,\"roleId\":100,\"admin\":false,\"dataScope\":\"1\",\"params\":{},\"roleSort\":\"0\",\"roleKey\":\"test\",\"roleName\":\"test\",\"status\":\"0\"}],\"phonenumber\":\"18608549631\",\"admin\":false,\"delFlag\":\"0\",\"password\":\"\",\"updateBy\":\"admin\",\"postIds\":[],\"loginIp\":\"\",\"email\":\"1023536325@qq.com\",\"nickName\":\"test\",\"sex\":\"0\",\"deptId\":100,\"avatar\":\"\",\"dept\":{\"deptName\":\"若依科技\",\"leader\":\"若依\",\"deptId\":100,\"orderNum\":\"0\",\"params\":{},\"parentId\":0,\"children\":[],\"status\":\"0\"},\"params\":{},\"userName\":\"test\",\"userId\":100,\"createBy\":\"admin\",\"roleIds\":[100],\"createTime\":1583312549000,\"status\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-17 10:58:41'),
       (158, '定时任务', 2, 'com.ruoyi.project.monitor.controller.SysJobController.run()', 'PUT', 1, 'test', NULL,
        '/monitor/job/run', '127.0.0.1', '内网IP',
        '{\"jobGroup\":\"DEFAULT\",\"params\":{},\"jobId\":1,\"misfirePolicy\":\"0\"}',
        '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-04-25 12:01:39'),
       (159, '定时任务', 2, 'com.ruoyi.project.monitor.controller.SysJobController.changeStatus()', 'PUT', 1, 'test', NULL,
        '/monitor/job/changeStatus', '127.0.0.1', '内网IP',
        '{\"params\":{},\"jobId\":1,\"misfirePolicy\":\"0\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0,
        NULL, '2020-04-25 12:01:44'),
       (160, '定时任务', 2, 'com.ruoyi.project.monitor.controller.SysJobController.changeStatus()', 'PUT', 1, 'test', NULL,
        '/monitor/job/changeStatus', '127.0.0.1', '内网IP',
        '{\"params\":{},\"jobId\":1,\"misfirePolicy\":\"0\",\"status\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0,
        NULL, '2020-04-25 12:01:48');

/*Table structure for table `sys_post` */

DROP TABLE IF EXISTS `sys_post`;

CREATE TABLE `sys_post`
(
    `post_id`     bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
    `post_code`   varchar(64) NOT NULL COMMENT '岗位编码',
    `post_name`   varchar(50) NOT NULL COMMENT '岗位名称',
    `post_sort`   int(4)      NOT NULL COMMENT '显示顺序',
    `status`      char(1)     NOT NULL COMMENT '状态（0正常 1停用）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`post_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='岗位信息表';

/*Data for the table `sys_post` */

insert into `sys_post`(`post_id`, `post_code`, `post_name`, `post_sort`, `status`, `create_by`, `create_time`,
                       `update_by`, `update_time`, `remark`)
values (1, 'ceo', '董事长', 1, '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''),
       (2, 'se', '项目经理', 2, '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''),
       (3, 'hr', '人力资源', 3, '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''),
       (4, 'user', '普通员工', 4, '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role`
(
    `role_id`     bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    `role_name`   varchar(30)  NOT NULL COMMENT '角色名称',
    `role_key`    varchar(100) NOT NULL COMMENT '角色权限字符串',
    `role_sort`   int(4)       NOT NULL COMMENT '显示顺序',
    `data_scope`  char(1)      DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
    `status`      char(1)      NOT NULL COMMENT '角色状态（0正常 1停用）',
    `del_flag`    char(1)      DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`role_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 101
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色信息表';

/*Data for the table `sys_role` */

insert into `sys_role`(`role_id`, `role_name`, `role_key`, `role_sort`, `data_scope`, `status`, `del_flag`, `create_by`,
                       `create_time`, `update_by`, `update_time`, `remark`)
values (1, '管理员', 'admin', 1, '1', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员'),
       (2, '普通角色', 'common', 2, '2', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '普通角色'),
       (100, 'test', 'test', 0, '1', '0', '0', 'admin', '2020-03-04 17:01:56', 'admin', '2020-03-05 20:09:59', NULL);

/*Table structure for table `sys_role_dept` */

DROP TABLE IF EXISTS `sys_role_dept`;

CREATE TABLE `sys_role_dept`
(
    `role_id` bigint(20) NOT NULL COMMENT '角色ID',
    `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
    PRIMARY KEY (`role_id`, `dept_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色和部门关联表';

/*Data for the table `sys_role_dept` */

insert into `sys_role_dept`(`role_id`, `dept_id`)
values (2, 100),
       (2, 101),
       (2, 105);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu`
(
    `role_id` bigint(20) NOT NULL COMMENT '角色ID',
    `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
    PRIMARY KEY (`role_id`, `menu_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色和菜单关联表';

/*Data for the table `sys_role_menu` */

insert into `sys_role_menu`(`role_id`, `menu_id`)
values (2, 1),
       (2, 2),
       (2, 3),
       (2, 4),
       (2, 100),
       (2, 101),
       (2, 102),
       (2, 103),
       (2, 104),
       (2, 105),
       (2, 106),
       (2, 107),
       (2, 108),
       (2, 109),
       (2, 110),
       (2, 111),
       (2, 112),
       (2, 113),
       (2, 114),
       (2, 115),
       (2, 500),
       (2, 501),
       (2, 1000),
       (2, 1001),
       (2, 1002),
       (2, 1003),
       (2, 1004),
       (2, 1005),
       (2, 1006),
       (2, 1007),
       (2, 1008),
       (2, 1009),
       (2, 1010),
       (2, 1011),
       (2, 1012),
       (2, 1013),
       (2, 1014),
       (2, 1015),
       (2, 1016),
       (2, 1017),
       (2, 1018),
       (2, 1019),
       (2, 1020),
       (2, 1021),
       (2, 1022),
       (2, 1023),
       (2, 1024),
       (2, 1025),
       (2, 1026),
       (2, 1027),
       (2, 1028),
       (2, 1029),
       (2, 1030),
       (2, 1031),
       (2, 1032),
       (2, 1033),
       (2, 1034),
       (2, 1035),
       (2, 1036),
       (2, 1037),
       (2, 1038),
       (2, 1039),
       (2, 1040),
       (2, 1041),
       (2, 1042),
       (2, 1043),
       (2, 1044),
       (2, 1045),
       (2, 1046),
       (2, 1047),
       (2, 1048),
       (2, 1049),
       (2, 1050),
       (2, 1051),
       (2, 1052),
       (2, 1053),
       (2, 1054),
       (2, 1055),
       (2, 1056),
       (2, 1057),
       (2, 1058),
       (2, 1059),
       (2, 1060),
       (100, 1),
       (100, 2),
       (100, 3),
       (100, 4),
       (100, 100),
       (100, 101),
       (100, 102),
       (100, 103),
       (100, 104),
       (100, 105),
       (100, 106),
       (100, 107),
       (100, 108),
       (100, 109),
       (100, 110),
       (100, 111),
       (100, 112),
       (100, 113),
       (100, 114),
       (100, 115),
       (100, 500),
       (100, 501),
       (100, 1001),
       (100, 1002),
       (100, 1003),
       (100, 1004),
       (100, 1005),
       (100, 1006),
       (100, 1007),
       (100, 1008),
       (100, 1009),
       (100, 1010),
       (100, 1011),
       (100, 1012),
       (100, 1013),
       (100, 1014),
       (100, 1015),
       (100, 1016),
       (100, 1017),
       (100, 1018),
       (100, 1019),
       (100, 1020),
       (100, 1021),
       (100, 1022),
       (100, 1023),
       (100, 1024),
       (100, 1025),
       (100, 1026),
       (100, 1027),
       (100, 1028),
       (100, 1029),
       (100, 1030),
       (100, 1031),
       (100, 1032),
       (100, 1033),
       (100, 1034),
       (100, 1035),
       (100, 1036),
       (100, 1037),
       (100, 1038),
       (100, 1039),
       (100, 1040),
       (100, 1041),
       (100, 1042),
       (100, 1043),
       (100, 1044),
       (100, 1045),
       (100, 1046),
       (100, 1047),
       (100, 1048),
       (100, 1049),
       (100, 1050),
       (100, 1051),
       (100, 1052),
       (100, 1053),
       (100, 1054),
       (100, 1055),
       (100, 1056),
       (100, 1057),
       (100, 1058),
       (100, 1059),
       (100, 1060),
       (100, 2000),
       (100, 2001),
       (100, 2002),
       (100, 2003),
       (100, 2004),
       (100, 2005),
       (100, 2006),
       (100, 2007),
       (100, 2008),
       (100, 2009),
       (100, 2010),
       (100, 2011),
       (100, 2012),
       (100, 2013),
       (100, 2014),
       (100, 2015),
       (100, 2016),
       (100, 2017),
       (100, 2018),
       (100, 2019),
       (100, 2020),
       (100, 2021),
       (100, 2022),
       (100, 2023),
       (100, 2024),
       (100, 2025),
       (100, 2026),
       (100, 2027),
       (100, 2028),
       (100, 2029);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user`
(
    `user_id`     bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `dept_id`     bigint(20)   DEFAULT NULL COMMENT '部门ID',
    `user_name`   varchar(30) NOT NULL COMMENT '用户账号',
    `nick_name`   varchar(30) NOT NULL COMMENT '用户昵称',
    `user_type`   varchar(2)   DEFAULT '00' COMMENT '用户类型（00系统用户）',
    `email`       varchar(50)  DEFAULT '' COMMENT '用户邮箱',
    `phonenumber` varchar(11)  DEFAULT '' COMMENT '手机号码',
    `sex`         char(1)      DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
    `avatar`      varchar(100) DEFAULT '' COMMENT '头像地址',
    `password`    varchar(100) DEFAULT '' COMMENT '密码',
    `status`      char(1)      DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
    `del_flag`    char(1)      DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `login_ip`    varchar(50)  DEFAULT '' COMMENT '最后登陆IP',
    `login_date`  datetime     DEFAULT NULL COMMENT '最后登陆时间',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 101
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户信息表';

/*Data for the table `sys_user` */

insert into `sys_user`(`user_id`, `dept_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`,
                       `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`,
                       `update_by`, `update_time`, `remark`)
values (1, 103, 'admin', '若依', '00', 'ry@163.com', '15888888888', '1', '',
        '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2018-03-16 11:33:00',
        'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员'),
       (2, 105, 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '',
        '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2018-03-16 11:33:00',
        'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '测试员'),
       (100, 100, 'test', 'test', '00', '1023536325@qq.com', '18608549631', '0', '',
        '$2a$10$3jxuUvQAmkIuwtvYgXjNEOouJX89iv0lDZxWE2y.i9Ij0cIdB91Y6', '0', '0', '', NULL, 'admin',
        '2020-03-04 17:02:29', 'admin', '2020-03-17 10:58:41', NULL);

/*Table structure for table `sys_user_post` */

DROP TABLE IF EXISTS `sys_user_post`;

CREATE TABLE `sys_user_post`
(
    `user_id` bigint(20) NOT NULL COMMENT '用户ID',
    `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
    PRIMARY KEY (`user_id`, `post_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户与岗位关联表';

/*Data for the table `sys_user_post` */

insert into `sys_user_post`(`user_id`, `post_id`)
values (1, 1),
       (2, 2);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role`
(
    `user_id` bigint(20) NOT NULL COMMENT '用户ID',
    `role_id` bigint(20) NOT NULL COMMENT '角色ID',
    PRIMARY KEY (`user_id`, `role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户和角色关联表';

/*Data for the table `sys_user_role` */

insert into `sys_user_role`(`user_id`, `role_id`)
values (1, 1),
       (2, 2),
       (100, 100);

/*Table structure for table `wx_auto_reply` */

DROP TABLE IF EXISTS `wx_auto_reply`;

CREATE TABLE `wx_auto_reply`
(
    `id`                 varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '主键',
    `create_id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '创建者',
    `create_time`        datetime                                                        DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '更新者',
    `update_time`        datetime                                                        DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `remark`             varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci         DEFAULT NULL COMMENT '备注',
    `del_flag`           char(2) CHARACTER SET utf8 COLLATE utf8_general_ci              DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
    `type`               char(2)                                                         DEFAULT NULL COMMENT '类型（1、关注时回复；2、消息回复；3、关键词回复）',
    `req_key`            varchar(64)                                                     DEFAULT NULL COMMENT '关键词',
    `req_type`           char(10)                                                        DEFAULT NULL COMMENT '请求消息类型（text：文本；image：图片；voice：语音；video：视频；shortvideo：小视频；location：地理位置）',
    `rep_type`           char(10)                                                        DEFAULT NULL COMMENT '回复消息类型（text：文本；image：图片；voice：语音；video：视频；music：音乐；news：图文）',
    `rep_mate`           char(10)                                                        DEFAULT NULL COMMENT '回复类型文本匹配类型（1、全匹配，2、半匹配）',
    `rep_content`        text COMMENT '回复类型文本保存文字',
    `rep_media_id`       varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci    DEFAULT NULL COMMENT '回复类型imge、voice、news、video的mediaID或音乐缩略图的媒体id',
    `rep_name`           varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT NULL COMMENT '回复的素材名、视频和音乐的标题',
    `rep_desc`           varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT NULL COMMENT '视频和音乐的描述',
    `rep_url`            varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT NULL COMMENT '链接',
    `rep_hq_url`         varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT NULL COMMENT '高质量链接',
    `rep_thumb_media_id` varchar(64)                                                     DEFAULT NULL COMMENT '缩略图的媒体id',
    `rep_thumb_url`      varchar(500)                                                    DEFAULT NULL COMMENT '缩略图url',
    `content`            mediumtext COMMENT '图文消息的内容',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='微信自动回复';

/*Data for the table `wx_auto_reply` */

/*Table structure for table `wx_menu` */

DROP TABLE IF EXISTS `wx_menu`;

CREATE TABLE `wx_menu`
(
    `id`                 varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单ID（click、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、pic_weixin、location_select：保存key）',
    `del_flag`           char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci      DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
    `create_time`        datetime                                                      DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`        datetime                                                      DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `sort`               int(11)                                                       DEFAULT '1' COMMENT '排序值',
    `parent_id`          varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '父菜单ID',
    `type`               char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     DEFAULT NULL COMMENT '菜单类型click、view、miniprogram、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、pic_weixin、location_select、media_id、view_limited等',
    `name`               varchar(20)                                                   DEFAULT NULL COMMENT '菜单名',
    `url`                varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'view、miniprogram保存链接',
    `ma_app_id`          varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '小程序的appid',
    `ma_page_path`       varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '小程序的页面路径',
    `rep_type`           char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     DEFAULT NULL COMMENT '回复消息类型（text：文本；image：图片；voice：语音；video：视频；music：音乐；news：图文）',
    `rep_content`        text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT 'Text:保存文字',
    `rep_media_id`       varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT 'imge、voice、news、video：mediaID',
    `rep_name`           varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '素材名、视频和音乐的标题',
    `rep_desc`           varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '视频和音乐的描述',
    `rep_url`            varchar(500)                                                  DEFAULT NULL COMMENT '链接',
    `rep_hq_url`         varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '高质量链接',
    `rep_thumb_media_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '缩略图的媒体id',
    `rep_thumb_url`      varchar(500)                                                  DEFAULT NULL COMMENT '缩略图url',
    `content`            mediumtext COMMENT '图文消息的内容',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='自定义菜单表';

/*Data for the table `wx_menu` */

/*Table structure for table `wx_msg` */

DROP TABLE IF EXISTS `wx_msg`;

CREATE TABLE `wx_msg`
(
    `id`                 varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '主键',
    `create_id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '创建者',
    `create_time`        datetime                                                        DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '更新者',
    `update_time`        datetime                                                        DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `remark`             varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci         DEFAULT NULL COMMENT '备注',
    `del_flag`           char(2) CHARACTER SET utf8 COLLATE utf8_general_ci              DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
    `app_name`           varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci    DEFAULT NULL COMMENT '公众号名称',
    `app_logo`           varchar(500)                                                    DEFAULT NULL COMMENT '公众号logo',
    `wx_user_id`         varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微信用户ID',
    `nick_name`          varchar(200)                                                    DEFAULT NULL COMMENT '微信用户昵称',
    `headimg_url`        varchar(1000)                                                   DEFAULT NULL COMMENT '微信用户头像',
    `type`               char(2)                                                         DEFAULT NULL COMMENT '消息分类（1、用户发给公众号；2、公众号发给用户；）',
    `rep_type`           char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci       DEFAULT NULL COMMENT '消息类型（text：文本；image：图片；voice：语音；video：视频；shortvideo：小视频；location：地理位置；music：音乐；news：图文；event：推送事件）',
    `rep_event`          char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci       DEFAULT NULL COMMENT '事件类型（subscribe：关注；unsubscribe：取关；CLICK、VIEW：菜单事件）',
    `rep_content`        text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '回复类型文本保存文字、地理位置信息',
    `rep_media_id`       varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci    DEFAULT NULL COMMENT '回复类型imge、voice、news、video的mediaID或音乐缩略图的媒体id',
    `rep_name`           varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT NULL COMMENT '回复的素材名、视频和音乐的标题',
    `rep_desc`           varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT NULL COMMENT '视频和音乐的描述',
    `rep_url`            varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT NULL COMMENT '链接',
    `rep_hq_url`         varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT NULL COMMENT '高质量链接',
    `content`            mediumtext COMMENT '图文消息的内容',
    `rep_thumb_media_id` varchar(64)                                                     DEFAULT NULL COMMENT '缩略图的媒体id',
    `rep_thumb_url`      varchar(500)                                                    DEFAULT NULL COMMENT '缩略图url',
    `rep_location_x`     double                                                          DEFAULT NULL COMMENT '地理位置维度',
    `rep_location_y`     double                                                          DEFAULT NULL COMMENT '地理位置经度',
    `rep_scale`          double                                                          DEFAULT NULL COMMENT '地图缩放大小',
    `read_flag`          char(2) CHARACTER SET utf8 COLLATE utf8_general_ci              DEFAULT '1' COMMENT '已读标记（1：是；0：否）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='微信消息';

/*Data for the table `wx_msg` */

/*Table structure for table `wx_user` */

DROP TABLE IF EXISTS `wx_user`;

CREATE TABLE `wx_user`
(
    `id`                    varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci       NOT NULL DEFAULT '' COMMENT '主键',
    `create_id`             varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci                DEFAULT NULL COMMENT '创建者',
    `create_time`           datetime                                                              DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_id`             varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci                DEFAULT NULL COMMENT '更新者',
    `update_time`           datetime                                                              DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `remark`                varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci               DEFAULT NULL COMMENT '用户备注',
    `del_flag`              char(2) CHARACTER SET utf8 COLLATE utf8_general_ci                    DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
    `app_type`              char(2) CHARACTER SET utf8 COLLATE utf8_general_ci                    DEFAULT NULL COMMENT '应用类型(1:小程序，2:公众号)',
    `subscribe`             char(2) CHARACTER SET utf8 COLLATE utf8_general_ci                    DEFAULT NULL COMMENT '是否订阅（1：是；0：否；2：网页授权用户）',
    `subscribe_scene`       varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci                DEFAULT NULL COMMENT '返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENEPROFILE LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他',
    `subscribe_time`        datetime                                                              DEFAULT NULL COMMENT '关注时间',
    `subscribe_num`         int(11)                                                               DEFAULT NULL COMMENT '关注次数',
    `cancel_subscribe_time` datetime                                                              DEFAULT NULL COMMENT '取消关注时间',
    `open_id`               varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户标识',
    `nick_name`             varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci         DEFAULT NULL COMMENT '昵称',
    `sex`                   char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci              DEFAULT NULL COMMENT '性别（1：男，2：女，0：未知）',
    `city`                  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT NULL COMMENT '所在城市',
    `country`               varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT NULL COMMENT '所在国家',
    `province`              varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT NULL COMMENT '所在省份',
    `phone`                 varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci                DEFAULT NULL COMMENT '手机号码',
    `language`              varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT NULL COMMENT '用户语言',
    `headimg_url`           varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci        DEFAULT NULL COMMENT '头像',
    `union_id`              varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT NULL COMMENT 'union_id',
    `group_id`              varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT NULL COMMENT '用户组',
    `tagid_list`            varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT NULL COMMENT '标签列表',
    `qr_scene_str`          varchar(64)                                                           DEFAULT NULL COMMENT '二维码扫码场景',
    `latitude`              double                                                                DEFAULT NULL COMMENT '地理位置纬度',
    `longitude`             double                                                                DEFAULT NULL COMMENT '地理位置经度',
    `precision`             double                                                                DEFAULT NULL COMMENT '地理位置精度',
    `session_key`           varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci               DEFAULT NULL COMMENT '会话密钥',
    `mall_user_id`          varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT NULL COMMENT '商城用户ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='微信用户';

/*Data for the table `wx_user` */

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
