package com.x.genx.service.impl;

import com.intellij.openapi.project.Project;
import com.x.genx.service.AbstractSpringProjectGenerator;
import com.x.genx.view.GAV;

/**
 * @author dingrui
 * @since 2023/2/9
 */
public class MySpringProjectGeneratorImpl extends AbstractSpringProjectGenerator {

    @Override
    protected void genPOM(Project project, String entryPath, GAV gav) {
        super.writeFile(project, entryPath, "/", "pom.xml", "pom.ftl", gav);
    }
}
