# 项目名称

springboot搭建个人博客  

项目演示Demo [钟瓶镜的个人博客](http://106.54.230.204/)

个人博客中也有对本项目的开发过程记录
## 前台展示
前台展示请访问项目Demo进行观看，比截图体验更佳

## 后台展示

### 博客管理页面

![1570682705260](https://github.com/lany1721/blog/blob/master/images/1570682705260.png)

### 编辑页面

![](https://github.com/lany1721/blog/blob/master/images/admin_editor.png)

### 分类管理页



![1570683252179](https://github.com/lany1721/blog/blob/master/images/1570683252179.png)

### 标签管理页

![1570683554819](https://github.com/lany1721/blog/blob/master/images/1570683554819.png)

### 友链管理页

![1570683604718](https://github.com/lany1721/blog/blob/master/images/1570683604718.png)

### 编辑框

![1570683323092](https://github.com/lany1721/blog/blob/master/images/1570683323092.png)

### 删除框

![1570683393811](https://github.com/lany1721/blog/blob/master/images/1570683393811.png)

### 新增框

![1570683447416](https://github.com/lany1721/blog/blob/master/images/1570683447416.png)



# 如何运行本项目

## 安装要求

数据库：MySQL 5.7

JDK：JDK8

服务器：nginx



## 配置

### springboot配置文件

```yaml
server:
  port: 8080



spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/数据库名称?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false&serverTimezone=Asia/Shanghai
    username: 你的数据库用户名
    password: 数据库密码
logging:
  level:
    cn.zpeace.blog.mapper: debug


mybatis-plus:
  configuration:
    map-underscore-to-camel-case: true
  mapper-locations: classpath*:/mapper/**/*.xml


 
```



### 数据库配置

在你的数据库执行sql脚本导入数据表即可



### nginx配置

```shell
location / {
proxy_pass http://127.0.0.1:8080;  #代理项目的服务器地址，默认为127.0.0.1:8080

proxy_set_header   Host             $host;
proxy_set_header   X-Real-IP        $remote_addr;						
proxy_set_header   X-Forwarded-For  $proxy_add_x_forwarded_for;

}


location ~\.(css|js|png|jpg|git|jpeg|bmp|webp)$ {
root D:/nginx-dir/blog/static;  #静态资源存放的路径
}
```

配置完了使用nginx -s reload 重载一下，或者重启nginx服务器

然后在springboot配置文件中添加

```yaml
fileSever: http://localhost/
parentDirPath: D:\nginx-dir\blog\static\  
```



## 部署

如果你是部署到服务器(Linux)上，只需要在配置的时候注意文件分割符的书写不同即可



## 后期计划

- 增加Redis缓存
- 使用vue.js来进行前后端分离



## 作者

钟瓶镜



## 开源协议

MIT



## 鸣谢

该项目参考了B站视频 [Spring Boot开发小而美的个人博客系列视频课程](https://www.bilibili.com/video/av66526617)

前台页面来自于 [Hexo-melody](https://github.com/Molunerfinn/hexo-theme-melody)

感谢女友的支持和陪伴



