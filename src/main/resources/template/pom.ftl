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

    <developers>
        <developer>
            <name>x</name>
            <email>x@outlook.com</email>
        </developer>
    </developers>

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

        <dependency>
            <groupId>com.zto.titans</groupId>
            <artifactId>titans-endpoint</artifactId>
        </dependency>

        <dependency>
            <groupId>com.zto.titans</groupId>
            <artifactId>titans-config</artifactId>
        </dependency>

        <dependency>
            <groupId>com.zto.titans</groupId>
            <artifactId>titans-logging</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>