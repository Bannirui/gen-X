package com.github.bannirui.genx.service;

import com.intellij.openapi.project.Project;
import com.github.bannirui.genx.view.GAV;

/**
 * @author dingrui
 * @since 2023/2/9
 */
public interface MavenProjectGenerator {

    /**
     * 创建文件/源码
     *
     * @param entryPath projectLocation+projectName的全路径
     * @param gav       spring项目的配置信息
     */
    void gen(Project project, String entryPath, GAV gav);
}
