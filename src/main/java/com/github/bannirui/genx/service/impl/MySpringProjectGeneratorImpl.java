package com.github.bannirui.genx.service.impl;

import com.github.bannirui.genx.service.AbstractSpringProjectGenerator;
import com.github.bannirui.genx.view.GAV;
import com.intellij.openapi.project.Project;

/**
 * @author dingrui
 * @since 2023/2/9
 */
public class MySpringProjectGeneratorImpl extends AbstractSpringProjectGenerator {

    @Override
    protected void genGitignore(Project project, String entryPath) {
        super.writeFile(project, entryPath, "/", ".gitignore", "ignore.ftl", null);
    }

    @Override
    protected void genPOM(Project project, String entryPath, GAV gav) {
        super.writeFile(project, entryPath, "/", "pom.xml", "pom.ftl", gav);
    }

    @Override
    protected void genApp(Project project, String entryPath, GAV gav) {
        super.writeFile(project, entryPath, "src/main/java/" + gav.get_package(), gav.get_upperArtifactId() + "Application.java", "Application.ftl", gav);
    }

    @Override
    protected void genYml(Project project, String entryPath) {
        super.writeFile(project, entryPath, "src/main/resources", "application.yml", "yml.ftl", null);
    }

    @Override
    protected void genDDD(Project project, String entryPath, GAV gav) {
        // controller
        super.writeFile(project, entryPath, "src/main/java/" + gav.get_package() + ".controller", "package-info.java", "controller/package-info.ftl", gav);
        // service
        super.writeFile(project, entryPath, "src/main/java/" + gav.get_package() + ".service", "package-info.java", "service/package-info.ftl", gav);
        super.writeFile(project, entryPath, "src/main/java/" + gav.get_package() + ".service.impl", "package-info.java", "service/impl/package-info.ftl", gav);
    }

    @Override
    protected void genCfg(Project project, String entryPath, GAV gav) {
        super.writeFile(project, entryPath, "src/main/resources/META-INF/", "app.properties", "app.ftl", gav);
    }
}
