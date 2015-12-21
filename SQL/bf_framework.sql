/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50541
Source Host           : localhost:3306
Source Database       : bf_framework

Target Server Type    : MYSQL
Target Server Version : 50541
File Encoding         : 65001

Date: 2015-12-21 10:47:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for logging_event
-- ----------------------------
DROP TABLE IF EXISTS `logging_event`;
CREATE TABLE `logging_event` (
  `timestmp` bigint(20) NOT NULL,
  `formatted_message` text NOT NULL,
  `logger_name` varchar(254) NOT NULL,
  `level_string` varchar(254) NOT NULL,
  `thread_name` varchar(254) DEFAULT NULL,
  `reference_flag` smallint(6) DEFAULT NULL,
  `arg0` varchar(254) DEFAULT NULL,
  `arg1` varchar(254) DEFAULT NULL,
  `arg2` varchar(254) DEFAULT NULL,
  `arg3` varchar(254) DEFAULT NULL,
  `caller_filename` varchar(254) NOT NULL,
  `caller_class` varchar(254) NOT NULL,
  `caller_method` varchar(254) NOT NULL,
  `caller_line` char(4) NOT NULL,
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71471 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logging_event
-- ----------------------------
INSERT INTO `logging_event` VALUES ('1450665923618', 'FrameworkServlet \'springServlet\': initialization started', 'org.springframework.web.servlet.DispatcherServlet', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71411');
INSERT INTO `logging_event` VALUES ('1450665923621', 'Refreshing WebApplicationContext for namespace \'springServlet-servlet\': startup date [Mon Dec 21 10:45:23 CST 2015]; parent: Root WebApplicationContext', 'org.springframework.web.context.support.XmlWebApplicationContext', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71412');
INSERT INTO `logging_event` VALUES ('1450665923622', 'Loading XML bean definitions from ServletContext resource [/WEB-INF/spring-mvc.xml]', 'org.springframework.beans.factory.xml.XmlBeanDefinitionReader', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71413');
INSERT INTO `logging_event` VALUES ('1450665923758', 'JSR-330 \'javax.inject.Inject\' annotation found and supported for autowiring', 'org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71414');
INSERT INTO `logging_event` VALUES ('1450665924123', 'Mapped \"{[/backstage/login]}\" onto public java.lang.String org.lohas.bf.web.controller.backstage.BackstageIndexController.loginPage()', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71415');
INSERT INTO `logging_event` VALUES ('1450665924124', 'Mapped \"{[/backstage/index || /backstage/]}\" onto public java.lang.String org.lohas.bf.web.controller.backstage.BackstageIndexController.indexPage()', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71416');
INSERT INTO `logging_event` VALUES ('1450665924125', 'Mapped \"{[/backstage/logging/list.json]}\" onto public org.lohas.bf.web.view.DataTable.DataTables org.lohas.bf.web.controller.backstage.BackstageLoggingController.showloggingPageJson(javax.servlet.http.HttpServletRequest,java.lang.String) throws java.text.ParseException', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71417');
INSERT INTO `logging_event` VALUES ('1450665924125', 'Mapped \"{[/backstage/logging/list]}\" onto public java.lang.String org.lohas.bf.web.controller.backstage.BackstageLoggingController.showloggingPage(javax.servlet.http.HttpServletRequest)', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71418');
INSERT INTO `logging_event` VALUES ('1450665924125', 'Mapped \"{[/backstage/logging/detail.json]}\" onto public org.lohas.bf.pojo.Message org.lohas.bf.web.controller.backstage.BackstageLoggingController.loggingDetail(javax.servlet.http.HttpServletRequest,java.lang.Integer)', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71419');
INSERT INTO `logging_event` VALUES ('1450665924128', 'Mapped \"{[/backstage/user/add]}\" onto public org.lohas.bf.pojo.Message<org.lohas.bf.dao.entities.SysUser> org.lohas.bf.web.controller.backstage.BackstageSysUserController.addOne(org.lohas.bf.dao.entities.SysUser)', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71420');
INSERT INTO `logging_event` VALUES ('1450665924128', 'Mapped \"{[/backstage/user/list.json]}\" onto public org.lohas.bf.web.view.DataTable.DataTables org.lohas.bf.web.controller.backstage.BackstageSysUserController.getListPageJson(javax.servlet.http.HttpServletRequest,java.lang.String,org.lohas.bf.dao.entities.SysUser)', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71421');
INSERT INTO `logging_event` VALUES ('1450665924128', 'Mapped \"{[/backstage/user/list]}\" onto public java.lang.String org.lohas.bf.web.controller.backstage.BackstageSysUserController.showListPage(javax.servlet.http.HttpServletRequest)', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71422');
INSERT INTO `logging_event` VALUES ('1450665924128', 'Mapped \"{[/backstage/user/del]}\" onto public org.lohas.bf.pojo.Message org.lohas.bf.web.controller.backstage.BackstageSysUserController.delOne(int)', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71423');
INSERT INTO `logging_event` VALUES ('1450665924128', 'Mapped \"{[/backstage/user/update]}\" onto public org.lohas.bf.pojo.Message<org.lohas.bf.dao.entities.SysUser> org.lohas.bf.web.controller.backstage.BackstageSysUserController.updateOne(org.lohas.bf.dao.entities.SysUser)', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71424');
INSERT INTO `logging_event` VALUES ('1450665924129', 'Mapped \"{[/backstage/user/{sysUserId}]}\" onto public org.lohas.bf.pojo.Message<org.lohas.bf.dao.entities.SysUser> org.lohas.bf.web.controller.backstage.BackstageSysUserController.getSysUser(int)', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71425');
INSERT INTO `logging_event` VALUES ('1450665924130', 'Mapped \"{[/uploadFile],methods=[POST]}\" onto public void org.lohas.bf.web.controller.RootController.uploadFile(javax.servlet.http.HttpServletRequest,java.lang.String,org.springframework.web.multipart.MultipartFile[],javax.servlet.http.HttpServletResponse) throws java.io.IOException', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71426');
INSERT INTO `logging_event` VALUES ('1450665924130', 'Mapped \"{[/iframe]}\" onto public java.lang.String org.lohas.bf.web.controller.RootController.iframe(java.lang.String,java.lang.String,org.springframework.ui.Model)', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71427');
INSERT INTO `logging_event` VALUES ('1450665924130', 'Mapped \"{[/captcha]}\" onto public void org.lohas.bf.web.controller.RootController.captcha(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse) throws java.io.IOException', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71428');
INSERT INTO `logging_event` VALUES ('1450665924130', 'Mapped \"{[/ || /index]}\" onto public java.lang.String org.lohas.bf.web.controller.RootController.goIndex1()', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71429');
INSERT INTO `logging_event` VALUES ('1450665924130', 'Mapped \"{[/notice]}\" onto public java.lang.String org.lohas.bf.web.controller.RootController.goNotice()', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71430');
INSERT INTO `logging_event` VALUES ('1450665924130', 'Mapped \"{[/download]}\" onto public void org.lohas.bf.web.controller.RootController.downloadApk(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse) throws java.io.IOException,javax.servlet.ServletException', 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71431');
INSERT INTO `logging_event` VALUES ('1450665924174', 'HV000001: Hibernate Validator 4.3.0.Final', 'org.hibernate.validator.internal.util.Version', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71432');
INSERT INTO `logging_event` VALUES ('1450665925108', 'Detected @ExceptionHandler methods in exceptionHandlerAdvice', 'org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71433');
INSERT INTO `logging_event` VALUES ('1450665925225', 'Mapped URL path [/static/**] onto handler \'org.springframework.web.servlet.resource.ResourceHttpRequestHandler#0\'', 'org.springframework.web.servlet.handler.SimpleUrlHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71434');
INSERT INTO `logging_event` VALUES ('1450665925244', 'Mapped URL path [/**] onto handler \'org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler#0\'', 'org.springframework.web.servlet.handler.SimpleUrlHandlerMapping', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71435');
INSERT INTO `logging_event` VALUES ('1450665925309', 'FrameworkServlet \'springServlet\': initialization completed in 1691 ms', 'org.springframework.web.servlet.DispatcherServlet', 'INFO', 'RMI TCP Connection(3)-127.0.0.1', '1', null, null, null, null, '?', '?', '?', '-1', '71436');
INSERT INTO `logging_event` VALUES ('1450665932169', '/backstage/user/list consume 770 millis', 'org.lohas.bf.spring.interceptors.StopWatchHandlerInterceptor', 'INFO', 'http-apr-8088-exec-3', '1', null, null, null, null, '?', '?', '?', '-1', '71437');
INSERT INTO `logging_event` VALUES ('1450665932664', '{}', 'org.lohas.bf.web.controller.backstage.BackstageSysUserController', 'INFO', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71438');
INSERT INTO `logging_event` VALUES ('1450665932665', '{}', 'org.lohas.bf.web.controller.backstage.BackstageSysUserController', 'INFO', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71439');
INSERT INTO `logging_event` VALUES ('1450665932665', '{}', 'org.lohas.bf.web.controller.backstage.BackstageSysUserController', 'INFO', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71440');
INSERT INTO `logging_event` VALUES ('1450665932665', '{}', 'org.lohas.bf.web.controller.backstage.BackstageSysUserController', 'INFO', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71441');
INSERT INTO `logging_event` VALUES ('1450665932665', '{}', 'org.lohas.bf.web.controller.backstage.BackstageSysUserController', 'INFO', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71442');
INSERT INTO `logging_event` VALUES ('1450665932665', '{}', 'org.lohas.bf.web.controller.backstage.BackstageSysUserController', 'INFO', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71443');
INSERT INTO `logging_event` VALUES ('1450665932665', '{}', 'org.lohas.bf.web.controller.backstage.BackstageSysUserController', 'INFO', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71444');
INSERT INTO `logging_event` VALUES ('1450665932665', '{}', 'org.lohas.bf.web.controller.backstage.BackstageSysUserController', 'INFO', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71445');
INSERT INTO `logging_event` VALUES ('1450665932665', '{}', 'org.lohas.bf.web.controller.backstage.BackstageSysUserController', 'INFO', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71446');
INSERT INTO `logging_event` VALUES ('1450665932665', '{}', 'org.lohas.bf.web.controller.backstage.BackstageSysUserController', 'INFO', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71447');
INSERT INTO `logging_event` VALUES ('1450665932830', '==>  Preparing: select count(*) from sys_user ', 'org.lohas.bf.dao.mapper.SysUserMapper.countByExample', 'DEBUG', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71448');
INSERT INTO `logging_event` VALUES ('1450665932951', '==> Parameters: ', 'org.lohas.bf.dao.mapper.SysUserMapper.countByExample', 'DEBUG', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71449');
INSERT INTO `logging_event` VALUES ('1450665932973', '<==      Total: 1', 'org.lohas.bf.dao.mapper.SysUserMapper.countByExample', 'DEBUG', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71450');
INSERT INTO `logging_event` VALUES ('1450665932979', '==>  Preparing: select id, user_name, account_name, role_id, pwd, salt, state, create_time, modify_time, remark from sys_user order by id desc limit 0 , 10 ', 'org.lohas.bf.dao.mapper.SysUserMapper.selectByExample', 'DEBUG', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71451');
INSERT INTO `logging_event` VALUES ('1450665932987', '==> Parameters: ', 'org.lohas.bf.dao.mapper.SysUserMapper.selectByExample', 'DEBUG', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71452');
INSERT INTO `logging_event` VALUES ('1450665932992', '<==      Total: 10', 'org.lohas.bf.dao.mapper.SysUserMapper.selectByExample', 'DEBUG', 'http-apr-8088-exec-4', '1', null, null, null, null, '?', '?', '?', '-1', '71453');
INSERT INTO `logging_event` VALUES ('1450665935558', '==>  Preparing: SELECT timestmp, substring(formatted_message,1,50) as formatted_message, logger_name, level_string, thread_name, event_id FROM logging_event WHERE 1=1 order by event_id desc LIMIT ? , ? ', 'org.lohas.bf.dao.mapper.LoggingEventMapper.qryLoggingPage', 'DEBUG', 'http-apr-8088-exec-6', '1', null, null, null, null, '?', '?', '?', '-1', '71454');
INSERT INTO `logging_event` VALUES ('1450665935589', '==> Parameters: 0(Integer), 10(Integer)', 'org.lohas.bf.dao.mapper.LoggingEventMapper.qryLoggingPage', 'DEBUG', 'http-apr-8088-exec-6', '1', null, null, null, null, '?', '?', '?', '-1', '71455');
INSERT INTO `logging_event` VALUES ('1450665935602', '<==      Total: 10', 'org.lohas.bf.dao.mapper.LoggingEventMapper.qryLoggingPage', 'DEBUG', 'http-apr-8088-exec-6', '1', null, null, null, null, '?', '?', '?', '-1', '71456');
INSERT INTO `logging_event` VALUES ('1450665935604', '==>  Preparing: SELECT count(*) FROM logging_event WHERE 1=1 ', 'org.lohas.bf.dao.mapper.LoggingEventMapper.countByPage', 'DEBUG', 'http-apr-8088-exec-6', '1', null, null, null, null, '?', '?', '?', '-1', '71457');
INSERT INTO `logging_event` VALUES ('1450665935605', '==> Parameters: ', 'org.lohas.bf.dao.mapper.LoggingEventMapper.countByPage', 'DEBUG', 'http-apr-8088-exec-6', '1', null, null, null, null, '?', '?', '?', '-1', '71458');
INSERT INTO `logging_event` VALUES ('1450665935608', '<==      Total: 1', 'org.lohas.bf.dao.mapper.LoggingEventMapper.countByPage', 'DEBUG', 'http-apr-8088-exec-6', '1', null, null, null, null, '?', '?', '?', '-1', '71459');
INSERT INTO `logging_event` VALUES ('1450665978318', '==>  Preparing: SELECT timestmp, formatted_message, logger_name, level_string, thread_name, event_id FROM logging_event WHERE event_id = ? ', 'org.lohas.bf.dao.mapper.LoggingEventMapper.selectByEventId', 'DEBUG', 'http-apr-8088-exec-8', '1', null, null, null, null, '?', '?', '?', '-1', '71460');
INSERT INTO `logging_event` VALUES ('1450665978325', '==> Parameters: 71453(Integer)', 'org.lohas.bf.dao.mapper.LoggingEventMapper.selectByEventId', 'DEBUG', 'http-apr-8088-exec-8', '1', null, null, null, null, '?', '?', '?', '-1', '71461');
INSERT INTO `logging_event` VALUES ('1450665978330', '====>  Preparing: SELECT logging_event_exception.trace_line as traceLine, logging_event_exception.event_id as eventId, logging_event_exception.i as i FROM logging_event_exception WHERE event_id = ? ', 'org.lohas.bf.dao.mapper.LoggingEventMapper.selectExceptionsByEventId', 'DEBUG', 'http-apr-8088-exec-8', '1', null, null, null, null, '?', '?', '?', '-1', '71462');
INSERT INTO `logging_event` VALUES ('1450665978331', '====> Parameters: 71453(Integer)', 'org.lohas.bf.dao.mapper.LoggingEventMapper.selectExceptionsByEventId', 'DEBUG', 'http-apr-8088-exec-8', '1', null, null, null, null, '?', '?', '?', '-1', '71463');
INSERT INTO `logging_event` VALUES ('1450665978333', '<====      Total: 0', 'org.lohas.bf.dao.mapper.LoggingEventMapper.selectExceptionsByEventId', 'DEBUG', 'http-apr-8088-exec-8', '1', null, null, null, null, '?', '?', '?', '-1', '71464');
INSERT INTO `logging_event` VALUES ('1450665978333', '====>  Preparing: SELECT logging_event_property.event_id as eventId, logging_event_property.mapped_key as mappedKey, logging_event_property.mapped_value as mappedValue FROM logging_event_property WHERE event_id = ? ', 'org.lohas.bf.dao.mapper.LoggingEventMapper.selectEventPropertyByEventId', 'DEBUG', 'http-apr-8088-exec-8', '1', null, null, null, null, '?', '?', '?', '-1', '71465');
INSERT INTO `logging_event` VALUES ('1450665978334', '====> Parameters: 71453(Integer)', 'org.lohas.bf.dao.mapper.LoggingEventMapper.selectEventPropertyByEventId', 'DEBUG', 'http-apr-8088-exec-8', '1', null, null, null, null, '?', '?', '?', '-1', '71466');
INSERT INTO `logging_event` VALUES ('1450665978338', '<====      Total: 8', 'org.lohas.bf.dao.mapper.LoggingEventMapper.selectEventPropertyByEventId', 'DEBUG', 'http-apr-8088-exec-8', '1', null, null, null, null, '?', '?', '?', '-1', '71467');
INSERT INTO `logging_event` VALUES ('1450665978338', '<==      Total: 1', 'org.lohas.bf.dao.mapper.LoggingEventMapper.selectByEventId', 'DEBUG', 'http-apr-8088-exec-8', '1', null, null, null, null, '?', '?', '?', '-1', '71468');
INSERT INTO `logging_event` VALUES ('1450666047069', 'setAttribute: Non-serializable attribute CAPTCHA_SESSION_KEY', 'org.lohas.bf.spring.advice.ExceptionHandlerAdvice', 'ERROR', 'http-apr-8088-exec-6', '3', null, null, null, null, '?', '?', '?', '-1', '71469');
INSERT INTO `logging_event` VALUES ('1450666047094', 'Handler execution resulted in exception: setAttribute: Non-serializable attribute CAPTCHA_SESSION_KEY', 'org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver', 'WARN', 'http-apr-8088-exec-6', '1', null, null, null, null, '?', '?', '?', '-1', '71470');

-- ----------------------------
-- Table structure for logging_event_exception
-- ----------------------------
DROP TABLE IF EXISTS `logging_event_exception`;
CREATE TABLE `logging_event_exception` (
  `event_id` bigint(20) NOT NULL,
  `i` smallint(6) NOT NULL,
  `trace_line` varchar(254) NOT NULL,
  PRIMARY KEY (`event_id`,`i`),
  CONSTRAINT `logging_event_exception_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `logging_event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logging_event_exception
-- ----------------------------
INSERT INTO `logging_event_exception` VALUES ('71469', '0', 'java.lang.IllegalArgumentException: setAttribute: Non-serializable attribute CAPTCHA_SESSION_KEY');
INSERT INTO `logging_event_exception` VALUES ('71469', '1', '	at org.apache.catalina.session.StandardSession.setAttribute(StandardSession.java:1458) ~[catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '2', '	at org.apache.catalina.session.StandardSession.setAttribute(StandardSession.java:1419) ~[catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '3', '	at com.orangefunction.tomcat.redissessions.RedisSession.setAttribute(RedisSession.java:59) ~[tomcat-redis-session-manager-2.0.0.jar:na]');
INSERT INTO `logging_event_exception` VALUES ('71469', '4', '	at org.apache.catalina.session.StandardSessionFacade.setAttribute(StandardSessionFacade.java:154) ~[catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '5', '	at org.lohas.bf.web.controller.RootController.captcha(RootController.java:99) ~[classes/:na]');
INSERT INTO `logging_event_exception` VALUES ('71469', '6', '	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_25]');
INSERT INTO `logging_event_exception` VALUES ('71469', '7', '	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_25]');
INSERT INTO `logging_event_exception` VALUES ('71469', '8', '	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_25]');
INSERT INTO `logging_event_exception` VALUES ('71469', '9', '	at java.lang.reflect.Method.invoke(Method.java:483) ~[na:1.8.0_25]');
INSERT INTO `logging_event_exception` VALUES ('71469', '10', '	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:221) ~[spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '11', '	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:137) ~[spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '12', '	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:111) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '13', '	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:806) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '14', '	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:729) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '15', '	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:85) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '16', '	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:959) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '17', '	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:893) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '18', '	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:970) [spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '19', '	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:861) [spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '20', '	at javax.servlet.http.HttpServlet.service(HttpServlet.java:624) [servlet-api.jar:na]');
INSERT INTO `logging_event_exception` VALUES ('71469', '21', '	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:846) [spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '22', '	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731) [servlet-api.jar:na]');
INSERT INTO `logging_event_exception` VALUES ('71469', '23', '	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '24', '	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '25', '	at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:77) [spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '26', '	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '27', '	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '28', '	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '29', '	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52) [tomcat7-websocket.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '30', '	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '31', '	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '32', '	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:123) [druid-1.0.15.jar:1.0.15]');
INSERT INTO `logging_event_exception` VALUES ('71469', '33', '	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '34', '	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '35', '	at ch.qos.logback.classic.helpers.MDCInsertingServletFilter.doFilter(MDCInsertingServletFilter.java:51) [logback-classic-1.1.3.jar:na]');
INSERT INTO `logging_event_exception` VALUES ('71469', '36', '	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '37', '	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '38', '	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129) [sitemesh-2.4.2.jar:na]');
INSERT INTO `logging_event_exception` VALUES ('71469', '39', '	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77) [sitemesh-2.4.2.jar:na]');
INSERT INTO `logging_event_exception` VALUES ('71469', '40', '	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '41', '	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '42', '	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61) [shiro-web-1.2.4.jar:1.2.4]');
INSERT INTO `logging_event_exception` VALUES ('71469', '43', '	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108) [shiro-web-1.2.4.jar:1.2.4]');
INSERT INTO `logging_event_exception` VALUES ('71469', '44', '	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137) [shiro-web-1.2.4.jar:1.2.4]');
INSERT INTO `logging_event_exception` VALUES ('71469', '45', '	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125) [shiro-web-1.2.4.jar:1.2.4]');
INSERT INTO `logging_event_exception` VALUES ('71469', '46', '	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66) [shiro-web-1.2.4.jar:1.2.4]');
INSERT INTO `logging_event_exception` VALUES ('71469', '47', '	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449) [shiro-web-1.2.4.jar:1.2.4]');
INSERT INTO `logging_event_exception` VALUES ('71469', '48', '	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365) [shiro-web-1.2.4.jar:1.2.4]');
INSERT INTO `logging_event_exception` VALUES ('71469', '49', '	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90) [shiro-core-1.2.4.jar:1.2.4]');
INSERT INTO `logging_event_exception` VALUES ('71469', '50', '	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83) [shiro-core-1.2.4.jar:1.2.4]');
INSERT INTO `logging_event_exception` VALUES ('71469', '51', '	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383) [shiro-core-1.2.4.jar:1.2.4]');
INSERT INTO `logging_event_exception` VALUES ('71469', '52', '	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362) [shiro-web-1.2.4.jar:1.2.4]');
INSERT INTO `logging_event_exception` VALUES ('71469', '53', '	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125) [shiro-web-1.2.4.jar:1.2.4]');
INSERT INTO `logging_event_exception` VALUES ('71469', '54', '	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:346) [spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '55', '	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:262) [spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '56', '	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '57', '	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '58', '	at org.lohas.bf.web.filter.XssFilter.doFilter(XssFilter.java:31) [classes/:na]');
INSERT INTO `logging_event_exception` VALUES ('71469', '59', '	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '60', '	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '61', '	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:85) [spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '62', '	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]');
INSERT INTO `logging_event_exception` VALUES ('71469', '63', '	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '64', '	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '65', '	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:220) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '66', '	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:122) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '67', '	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:505) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '68', '	at com.orangefunction.tomcat.redissessions.RedisSessionHandlerValve.invoke(RedisSessionHandlerValve.java:26) [tomcat-redis-session-manager-2.0.0.jar:na]');
INSERT INTO `logging_event_exception` VALUES ('71469', '69', '	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:170) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '70', '	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '71', '	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:956) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '72', '	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '73', '	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:423) [catalina.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '74', '	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1079) [tomcat-coyote.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '75', '	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:625) [tomcat-coyote.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '76', '	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2522) [tomcat-coyote.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '77', '	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2511) [tomcat-coyote.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '78', '	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [na:1.8.0_25]');
INSERT INTO `logging_event_exception` VALUES ('71469', '79', '	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [na:1.8.0_25]');
INSERT INTO `logging_event_exception` VALUES ('71469', '80', '	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-coyote.jar:7.0.65]');
INSERT INTO `logging_event_exception` VALUES ('71469', '81', '	at java.lang.Thread.run(Thread.java:745) [na:1.8.0_25]');

-- ----------------------------
-- Table structure for logging_event_property
-- ----------------------------
DROP TABLE IF EXISTS `logging_event_property`;
CREATE TABLE `logging_event_property` (
  `event_id` bigint(20) NOT NULL,
  `mapped_key` varchar(128) NOT NULL,
  `mapped_value` text,
  PRIMARY KEY (`event_id`,`mapped_key`),
  CONSTRAINT `logging_event_property_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `logging_event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logging_event_property
-- ----------------------------
INSERT INTO `logging_event_property` VALUES ('71411', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71412', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71413', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71414', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71415', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71416', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71417', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71418', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71419', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71420', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71421', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71422', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71423', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71424', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71425', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71426', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71427', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71428', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71429', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71430', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71431', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71432', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71433', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71434', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71435', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71436', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71437', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71437', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71437', 'req.queryString', null);
INSERT INTO `logging_event_property` VALUES ('71437', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71437', 'req.requestURI', '/backstage/user/list');
INSERT INTO `logging_event_property` VALUES ('71437', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list');
INSERT INTO `logging_event_property` VALUES ('71437', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71437', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71438', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71438', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71438', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71438', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71438', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71438', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71438', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71438', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71439', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71439', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71439', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71439', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71439', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71439', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71439', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71439', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71440', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71440', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71440', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71440', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71440', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71440', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71440', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71440', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71441', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71441', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71441', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71441', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71441', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71441', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71441', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71441', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71442', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71442', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71442', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71442', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71442', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71442', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71442', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71442', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71443', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71443', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71443', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71443', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71443', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71443', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71443', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71443', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71444', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71444', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71444', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71444', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71444', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71444', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71444', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71444', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71445', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71445', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71445', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71445', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71445', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71445', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71445', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71445', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71446', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71446', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71446', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71446', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71446', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71446', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71446', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71446', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71447', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71447', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71447', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71447', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71447', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71447', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71447', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71447', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71448', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71448', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71448', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71448', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71448', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71448', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71448', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71448', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71449', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71449', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71449', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71449', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71449', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71449', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71449', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71449', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71450', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71450', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71450', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71450', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71450', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71450', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71450', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71450', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71451', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71451', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71451', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71451', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71451', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71451', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71451', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71451', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71452', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71452', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71452', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71452', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71452', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71452', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71452', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71452', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71453', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71453', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71453', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22id%22%2C%22name%22%3A%22id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22userName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22state%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22remark%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22createTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22modifyTime%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665932359');
INSERT INTO `logging_event_property` VALUES ('71453', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71453', 'req.requestURI', '/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71453', 'req.requestURL', 'http://192.168.0.14:8088/backstage/user/list.json');
INSERT INTO `logging_event_property` VALUES ('71453', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71453', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71454', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71454', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71454', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22eventId%22%2C%22name%22%3A%22event_id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22loggerName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22threadName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22formattedMessage%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22levelString%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22timestmp%22%2C%22name%22%3A%22timestmp%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665935322');
INSERT INTO `logging_event_property` VALUES ('71454', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71454', 'req.requestURI', '/backstage/logging/list.json');
INSERT INTO `logging_event_property` VALUES ('71454', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/list.json');
INSERT INTO `logging_event_property` VALUES ('71454', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71454', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71455', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71455', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71455', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22eventId%22%2C%22name%22%3A%22event_id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22loggerName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22threadName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22formattedMessage%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22levelString%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22timestmp%22%2C%22name%22%3A%22timestmp%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665935322');
INSERT INTO `logging_event_property` VALUES ('71455', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71455', 'req.requestURI', '/backstage/logging/list.json');
INSERT INTO `logging_event_property` VALUES ('71455', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/list.json');
INSERT INTO `logging_event_property` VALUES ('71455', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71455', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71456', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71456', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71456', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22eventId%22%2C%22name%22%3A%22event_id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22loggerName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22threadName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22formattedMessage%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22levelString%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22timestmp%22%2C%22name%22%3A%22timestmp%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665935322');
INSERT INTO `logging_event_property` VALUES ('71456', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71456', 'req.requestURI', '/backstage/logging/list.json');
INSERT INTO `logging_event_property` VALUES ('71456', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/list.json');
INSERT INTO `logging_event_property` VALUES ('71456', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71456', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71457', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71457', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71457', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22eventId%22%2C%22name%22%3A%22event_id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22loggerName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22threadName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22formattedMessage%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22levelString%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22timestmp%22%2C%22name%22%3A%22timestmp%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665935322');
INSERT INTO `logging_event_property` VALUES ('71457', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71457', 'req.requestURI', '/backstage/logging/list.json');
INSERT INTO `logging_event_property` VALUES ('71457', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/list.json');
INSERT INTO `logging_event_property` VALUES ('71457', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71457', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71458', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71458', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71458', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22eventId%22%2C%22name%22%3A%22event_id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22loggerName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22threadName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22formattedMessage%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22levelString%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22timestmp%22%2C%22name%22%3A%22timestmp%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665935322');
INSERT INTO `logging_event_property` VALUES ('71458', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71458', 'req.requestURI', '/backstage/logging/list.json');
INSERT INTO `logging_event_property` VALUES ('71458', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/list.json');
INSERT INTO `logging_event_property` VALUES ('71458', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71458', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71459', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71459', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71459', 'req.queryString', 'dataTablesReqPar=%7B%22draw%22%3A1%2C%22columns%22%3A%5B%7B%22data%22%3A%22eventId%22%2C%22name%22%3A%22event_id%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22loggerName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22threadName%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22formattedMessage%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22levelString%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22timestmp%22%2C%22name%22%3A%22timestmp%22%2C%22searchable%22%3Atrue%2C%22orderable%22%3Atrue%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%2C%7B%22data%22%3A%22ops%22%2C%22name%22%3A%22%22%2C%22searchable%22%3Afalse%2C%22orderable%22%3Afalse%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D%5D%2C%22order%22%3A%5B%7B%22column%22%3A0%2C%22dir%22%3A%22desc%22%7D%5D%2C%22start%22%3A0%2C%22length%22%3A10%2C%22search%22%3A%7B%22value%22%3A%22%22%2C%22regex%22%3Afalse%7D%7D&loggerName=&content=&level=&beginDate=&endDate=&_=1450665935322');
INSERT INTO `logging_event_property` VALUES ('71459', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71459', 'req.requestURI', '/backstage/logging/list.json');
INSERT INTO `logging_event_property` VALUES ('71459', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/list.json');
INSERT INTO `logging_event_property` VALUES ('71459', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71459', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71460', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71460', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71460', 'req.queryString', 'eventId=71453');
INSERT INTO `logging_event_property` VALUES ('71460', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71460', 'req.requestURI', '/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71460', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71460', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71460', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71461', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71461', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71461', 'req.queryString', 'eventId=71453');
INSERT INTO `logging_event_property` VALUES ('71461', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71461', 'req.requestURI', '/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71461', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71461', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71461', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71462', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71462', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71462', 'req.queryString', 'eventId=71453');
INSERT INTO `logging_event_property` VALUES ('71462', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71462', 'req.requestURI', '/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71462', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71462', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71462', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71463', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71463', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71463', 'req.queryString', 'eventId=71453');
INSERT INTO `logging_event_property` VALUES ('71463', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71463', 'req.requestURI', '/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71463', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71463', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71463', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71464', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71464', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71464', 'req.queryString', 'eventId=71453');
INSERT INTO `logging_event_property` VALUES ('71464', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71464', 'req.requestURI', '/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71464', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71464', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71464', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71465', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71465', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71465', 'req.queryString', 'eventId=71453');
INSERT INTO `logging_event_property` VALUES ('71465', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71465', 'req.requestURI', '/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71465', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71465', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71465', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71466', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71466', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71466', 'req.queryString', 'eventId=71453');
INSERT INTO `logging_event_property` VALUES ('71466', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71466', 'req.requestURI', '/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71466', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71466', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71466', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71467', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71467', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71467', 'req.queryString', 'eventId=71453');
INSERT INTO `logging_event_property` VALUES ('71467', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71467', 'req.requestURI', '/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71467', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71467', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71467', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71468', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71468', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71468', 'req.queryString', 'eventId=71453');
INSERT INTO `logging_event_property` VALUES ('71468', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71468', 'req.requestURI', '/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71468', 'req.requestURL', 'http://192.168.0.14:8088/backstage/logging/detail.json');
INSERT INTO `logging_event_property` VALUES ('71468', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71468', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71469', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71469', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71469', 'req.queryString', null);
INSERT INTO `logging_event_property` VALUES ('71469', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71469', 'req.requestURI', '/captcha');
INSERT INTO `logging_event_property` VALUES ('71469', 'req.requestURL', 'http://192.168.0.14:8088/captcha');
INSERT INTO `logging_event_property` VALUES ('71469', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71469', 'req.xForwardedFor', null);
INSERT INTO `logging_event_property` VALUES ('71470', 'HOSTNAME', 'DS-20151119TNBA');
INSERT INTO `logging_event_property` VALUES ('71470', 'req.method', 'GET');
INSERT INTO `logging_event_property` VALUES ('71470', 'req.queryString', null);
INSERT INTO `logging_event_property` VALUES ('71470', 'req.remoteHost', '192.168.0.14');
INSERT INTO `logging_event_property` VALUES ('71470', 'req.requestURI', '/captcha');
INSERT INTO `logging_event_property` VALUES ('71470', 'req.requestURL', 'http://192.168.0.14:8088/captcha');
INSERT INTO `logging_event_property` VALUES ('71470', 'req.userAgent', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36');
INSERT INTO `logging_event_property` VALUES ('71470', 'req.xForwardedFor', null);

-- ----------------------------
-- Table structure for sys_base_album
-- ----------------------------
DROP TABLE IF EXISTS `sys_base_album`;
CREATE TABLE `sys_base_album` (
  `id` int(11) NOT NULL,
  `summary` varchar(255) DEFAULT NULL COMMENT '简介',
  `style` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='相册表';

-- ----------------------------
-- Records of sys_base_album
-- ----------------------------

-- ----------------------------
-- Table structure for sys_base_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_base_config`;
CREATE TABLE `sys_base_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pz_type` varchar(50) DEFAULT NULL COMMENT '配置名称',
  `state` int(11) DEFAULT NULL COMMENT 'state 状态  0失效 1 正常  ',
  `pz_value` varchar(500) DEFAULT NULL COMMENT '配置值',
  `pz_value_name` varchar(100) DEFAULT NULL COMMENT '中文名称',
  `pz_value_form_name` varchar(500) DEFAULT NULL COMMENT '配置的表单名称',
  `is_default` int(11) DEFAULT NULL COMMENT '是否是默认值0不是1是',
  `is_single` int(11) DEFAULT NULL COMMENT '是否是单一值0不是 1是',
  `order_code` int(11) DEFAULT NULL COMMENT '排序字段',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `modify_time` date DEFAULT NULL COMMENT '修改时间',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='系统配置字典';

-- ----------------------------
-- Records of sys_base_config
-- ----------------------------

-- ----------------------------
-- Table structure for sys_feedback
-- ----------------------------
DROP TABLE IF EXISTS `sys_feedback`;
CREATE TABLE `sys_feedback` (
  `id` int(11) NOT NULL,
  `origin_ip` varchar(255) DEFAULT NULL COMMENT '来源ip',
  `origin_type` varchar(255) DEFAULT NULL COMMENT '来源类型{type:''android'',version:''1.0''}',
  `visitor_name` varchar(255) DEFAULT NULL COMMENT '反馈者姓名',
  `visitor_phone` varchar(255) DEFAULT NULL COMMENT '反馈者电话',
  `content` varchar(255) DEFAULT NULL COMMENT '反馈者内容',
  `is_accpet` int(2) DEFAULT '0' COMMENT '是否已经处理(0未处理)1已经处理',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统反馈表';

-- ----------------------------
-- Records of sys_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for sys_site_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_site_config`;
CREATE TABLE `sys_site_config` (
  `id` int(11) NOT NULL,
  `meta_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `meta_keywords` varchar(255) DEFAULT NULL COMMENT '关键字',
  `meta_description` varchar(255) DEFAULT NULL COMMENT '描述',
  `statistics_js` varchar(255) DEFAULT NULL COMMENT '统计js',
  `ext_css` varchar(255) DEFAULT NULL COMMENT '外部css',
  `ext_js` varchar(255) DEFAULT NULL COMMENT '外部JS',
  `state` varchar(255) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站配置表';

-- ----------------------------
-- Records of sys_site_config
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `account_name` varchar(255) DEFAULT NULL COMMENT '账户名称',
  `role_id` int(11) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `state` int(10) DEFAULT '1' COMMENT '状态1 启用 2 不启用',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('2', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('3', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('4', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('5', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('6', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('7', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('8', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('9', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('10', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('11', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('12', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('13', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('14', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('15', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('16', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('17', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('18', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('19', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('20', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('21', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('22', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('23', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('24', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('25', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('26', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('27', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('28', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('29', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('30', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('31', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('32', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('33', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('34', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('35', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('36', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('37', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('38', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('39', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('40', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('41', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('42', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('43', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('44', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('45', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('46', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('47', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('48', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('49', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('50', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
INSERT INTO `sys_user` VALUES ('51', '测试用户', '测试用户', null, null, null, '1', '2015-12-21 10:34:38', null, null);
