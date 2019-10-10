# 项目名称
springboot搭建个人博客

# 如何运行本项目

## 安装要求
数据库：MySQL 5.7
JDK：JDK8
服务器：nginx

## 配置
### 数据库配置
'''yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/数据库名称?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false&serverTimezone=Asia/Shanghai
    username: 数据库用户名
    password: 数据库密码
'''
