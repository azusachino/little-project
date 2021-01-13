create
database if not exists smart_test_dev;
use
smart_test_dev;

create table if not exists class
(
    CLASS_ID
    int
    auto_increment
    comment
    '班级ID'
    primary
    key,
    GRADE_ID
    varchar
(
    2
) default '1' not null comment '年级ID',
    CLASS_NO varchar
(
    3
) default '1' not null comment '班级序号',
    ENTRY_YEAR varchar
(
    4
) default '2019' not null comment '入学年份',
    CREATE_TIME TIMESTAMP not NULL DEFAULT current_timestamp comment '创建时间',
    UPDATE_TIME TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp comment '上次修改时间',
    STATUS varchar
(
    1
) not null default '1' comment '状态 1:在校,2:已毕业'
    )
    comment '班级表';

create table if not exists paper
(
    PAPER_ID
    int
    auto_increment
    comment
    '试卷ID'
    primary
    key,
    GRADE_ID
    varchar
(
    2
) default '1' not null comment '年级ID',
    SUBJECT_ID varchar
(
    10
) not null comment '课程ID',
    USER_ID varchar
(
    10
) not null comment '出卷人ID',
    CREATE_TIME TIMESTAMP not NULL DEFAULT current_timestamp comment '创建时间',
    UPDATE_TIME TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp comment '上次修改时间',
    STATUS varchar
(
    1
) not null default '1' comment '试卷状态 1:正常,2:不可使用'
    )
    comment '试卷表';


create table if not exists question
(
    QUESTION_ID
    int
    auto_increment
    comment
    '试题ID'
    primary
    key,
    TYPE_ID
    varchar
(
    1
) default '1' not null comment '试题类型ID',
    SUBJECT_ID varchar
(
    10
) default '1' not null comment '试题课程ID',
    GRADE_ID varchar
(
    2
) default '1' not null comment '年级ID',
    KNOWLEDGE_ID varchar
(
    10
) default '1' not null comment '知识点IDs',
    USER_ID varchar
(
    10
) default '1' not null comment '出题人ID',
    DIFFICULTY varchar
(
    1
) default '0' not null comment '难易度 0:简单,1:中等,2:困难',
    TITLE varchar
(
    255
) null comment '试题内容',
    OPTION_A varchar
(
    255
) null comment '选项A',
    OPTION_B varchar
(
    255
) null comment '选项B',
    OPTION_C varchar
(
    255
) null comment '选项C',
    OPTION_D varchar
(
    255
) null comment '选项D',
    ANSWER varchar
(
    255
) null comment '参考答案',
    REMARK varchar
(
    255
) null comment '注解',
    CREATE_TIME TIMESTAMP not NULL DEFAULT current_timestamp comment '创建时间',
    UPDATE_TIME TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp comment '上次修改时间',
    STATUS varchar
(
    1
) not null default '1' comment '试题状态 1:正常,2:不可使用'
    )
    comment '试题表';

create table if not exists knowledge
(
    KNOWLEDGE_ID
    int
    auto_increment
    comment
    '知识点ID'
    primary
    key,
    SUBJECT_ID
    varchar
(
    10
) default '1' not null comment '课程ID',
    GRADE_ID varchar
(
    2
) not null comment '年级ID',
    KNOWLEDGE varchar
(
    200
) default '新知识点' not null comment '知识点名称',
    CREATE_TIME TIMESTAMP not NULL DEFAULT current_timestamp comment '创建时间',
    UPDATE_TIME TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp comment '上次修改时间',
    STATUS varchar
(
    1
) not null default '1' comment '状态 1:正常,2:不可使用'
    )
    comment '知识点表';

create table if not exists test
(
    TEST_ID
    int
    auto_increment
    comment
    '考试ID'
    primary
    key,
    TEST_NAME
    varchar
(
    50
) not null comment '考试名称',
    GRADE_ID varchar
(
    2
) not null comment '年级ID',
    PAPER_ID varchar
(
    10
) not null comment '试卷ID',
    SUBJECT_ID varchar
(
    10
) not null comment '课程ID',
    START_TIME TIMESTAMP null comment '开始时间',
    END_TIME TIMESTAMP null comment '结束时间',
    TEST_TIME varchar
(
    10
) null comment '考试时长',
    CREATE_TIME TIMESTAMP not NULL DEFAULT current_timestamp comment '创建时间',
    UPDATE_TIME TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp comment '上次修改时间',
    STATUS varchar
(
    1
) not null default '1' comment '考试状态 1:尚未开始,2:正在考试,3:已结束'
    )
    comment '考试表';

create table if not exists user
(
    USER_ID
    int
    auto_increment
    comment
    '用户ID'
    primary
    key,
    LOGIN_ID
    varchar
(
    20
) not null comment '登录ID',
    USERNAME varchar
(
    10
) not null comment '姓名',
    PASSWORD varchar
(
    50
) not null comment '登陆密码',
    SEX varchar
(
    1
) null default '0' comment '性别 0:保密,1:男,2:女',
    AVATAR varchar
(
    60
) null default '../../assets/icon.jpg' comment '头像地址',
    CREATE_TIME TIMESTAMP not NULL DEFAULT current_timestamp comment '创建时间',
    UPDATE_TIME TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp comment '上次修改时间',
    LAST_LOGIN_TIME TIMESTAMP NOT NULL DEFAULT current_timestamp comment '上次登录时间',
    STATUS varchar
(
    1
) not null default '1' comment '账户状态 1:正常,2:已注销,3:长时间无人使用',
    constraint user_LOGIN_ID_index unique
(
    LOGIN_ID
)
    )
    comment '用户表';

create table if not exists permission
(
    PERMISSION_ID
    int
    auto_increment
    comment
    '权限ID'
    primary
    key,
    PERMISSION
    varchar
(
    50
) not null comment '权限'
    )
    comment '权限表';

create table if not exists role
(
    ROLE_ID
    int
    not
    null
    comment
    '用户类型ID'
    primary
    key,
    ROLE
    varchar
(
    10
) not null comment '用户类型'
    )
    comment '用户类型表';


create table if not exists subject
(
    SUBJECT_ID
    int
    auto_increment
    comment
    '课程ID'
    primary
    key,
    SUBJECT
    varchar
(
    10
) not null comment '课程名称'
    )
    comment '课程表';

create table if not exists grade
(
    GRADE_ID
    int
    auto_increment
    comment
    '年级ID'
    primary
    key,
    GRADE
    varchar
(
    10
) not null comment '年级名称'
    )
    comment '年级表';

create table if not exists type
(
    TYPE_ID
    int
    auto_increment
    comment
    '题型ID'
    primary
    key,
    TYPE
    varchar
(
    60
) default '新题型' not null comment '题型名称'
    )
    comment '题型表';

create table if not exists user_role
(
    USER_ID varchar
(
    10
) not null comment '用户ID',
    ROLE_ID varchar
(
    10
) not null default '3' comment '角色ID'
    )
    comment '用户角色关联表';

create table if not exists subject_teacher
(
    SUBJECT_ID varchar
(
    10
) not null comment '课程ID',
    USER_ID varchar
(
    10
) not null comment '教师ID'
    )
    comment '教师课程表';

create table if not exists role_permission
(
    ROLE_ID varchar
(
    10
) not null comment '角色ID',
    PERMISSION_ID varchar
(
    10
) not null comment '权限ID'
    )
    comment '角色权限表';

create table if not exists test_score
(
    TEST_ID varchar
(
    10
) not null comment '考试ID',
    USER_ID varchar
(
    10
) not null comment '学生ID',
    SCORE varchar
(
    10
) null comment '分数'
    )
    comment '考试分数表';

create table if not exists paper_question
(
    PAPER_ID varchar
(
    10
) not null comment '试卷ID',
    QUESTION_ID varchar
(
    10
) not null comment '试题ID'
    )
    comment '试卷试题表';

create table if not exists class_user
(
    CLASS_ID varchar
(
    10
) not null comment '班级ID',
    USER_ID varchar
(
    10
) not null comment '用户ID'
    )
    comment '班级关联表';
