/**
 * @author az
 * @since 2020-03-31
 */
open module little.mall {
    requires java.base;
    requires spring.beans;
    requires java.desktop;

    requires hutool.all;
    requires mybatis.plus.core;
    requires mybatis.plus.extension;
    requires org.apache.commons.lang3;
    requires java.annotation;
    requires org.apache.tomcat.embed.core;
    requires spring.web;
    requires spring.context;
    requires org.mybatis.spring;
    requires spring.tx;
    requires spring.webmvc;
    requires kaptcha;
    requires mybatis.plus.annotation;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires lombok;
    requires mybatis.plus.generator;
    requires spring.core;
    requires java.sql;
    requires org.apache.commons.io;
    requires org.mybatis;
    requires org.slf4j;

    exports cn.az.replica.mall;
}
