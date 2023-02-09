<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.zto.titans</groupId>
        <artifactId>titans-parent</artifactId>
        <version>2.8.3.RELEASE</version>
    </parent>

    <groupId>${_groupId}</groupId>
    <artifactId>${_artifactId}</artifactId>
    <version>${_version}</version>
    <name>${_artifactId}</name>

    <developers>
        <developer>
            <name>x</name>
            <email>x@outlook.com</email>
        </developer>
    </developers>

    <properties>
        <redisson.version>3.10.6</redisson.version>
        <hutool.version>5.7.18</hutool.version>
        <mapstruct.version>1.3.0.Final</mapstruct.version>
        <mybatis-typehandler.version>1.0.2</mybatis-typehandler.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.redisson</groupId>
                <artifactId>redisson-spring-boot-starter</artifactId>
                <version>${redisson.version}</version>
            </dependency>

            <dependency>
                <groupId>cn.hutool</groupId>
                <artifactId>hutool-all</artifactId>
                <version>${hutool.version}</version>
            </dependency>

            <dependency>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct</artifactId>
                <version>${mapstruct.version}</version>
            </dependency>

            <dependency>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct-processor</artifactId>
                <version>${mapstruct.version}</version>
            </dependency>

            <dependency>
                <groupId>org.mybatis</groupId>
                <artifactId>mybatis-typehandlers-jsr310</artifactId>
                <version>${mybatis-typehandler.version}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>