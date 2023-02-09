package com.x.genx.service;

import com.intellij.openapi.project.Project;
import com.x.genx.view.GAV;

/**
 * @author dingrui
 * @since 2023/2/9
 */
public interface MavenProjectGenerator {

    void gen(Project project, String entryPath, GAV gav);
}
