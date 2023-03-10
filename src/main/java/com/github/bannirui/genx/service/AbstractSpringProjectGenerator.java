package com.github.bannirui.genx.service;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.github.bannirui.genx.view.FreemarkerConfiguration;
import com.github.bannirui.genx.view.GAV;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @author dingrui
 * @since 2023/2/9
 */
public abstract class AbstractSpringProjectGenerator extends FreemarkerConfiguration implements MavenProjectGenerator {

    private static final String SLASH = "/";
    private static final String DOT = ".";
    private static final String EN_CODING = "UTF-8";

    @Override
    public void gen(Project project, String entryPath, GAV gav) {
        this.genGitignore(project, entryPath);
        this.genPOM(project, entryPath, gav);
        this.genApp(project, entryPath, gav);
        this.genYml(project, entryPath);
        this.genDDD(project, entryPath, gav);
        this.genCfg(project, entryPath, gav);
    }

    // ignore
    protected abstract void genGitignore(Project project, String entryPath);

    // pom文件创建
    protected abstract void genPOM(Project project, String entryPath, GAV gav);

    // App
    protected abstract void genApp(Project project, String entryPath, GAV gav);

    // yml
    protected abstract void genYml(Project project, String entryPath);

    // DDD
    protected abstract void genDDD(Project project, String entryPath, GAV gav);

    // 配置文件
    protected abstract void genCfg(Project project, String entryPath, GAV gav);

    /**
     * 文件创建
     *
     * @param project     项目
     * @param entryPath   baseDir
     * @param packageName Java包路径
     * @param fileName    文件名
     * @param ftlName     freemarker模板文件
     * @param viewModel   渲染到freemarker模板
     */
    protected void writeFile(Project project, String entryPath, String packageName, String fileName, String ftlName, Object viewModel) {
        try {
            VirtualFile vf = createDirFromPackage(entryPath, packageName).createChildData(project, fileName);
            StringWriter sw = new StringWriter();
            Template template = super.getTemplate(ftlName);
            template.process(viewModel, sw);
            vf.setBinaryContent(sw.toString().getBytes(EN_CODING));
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    // 项目工程路径
    private static VirtualFile createDirFromPackage(String entryPath, String packageName) {
        // 目录+包路径
        String path = FileUtil.toSystemIndependentName(entryPath + SLASH + StringUtil.replace(packageName, DOT, SLASH));
        new File(path).mkdirs();
        return LocalFileSystem.getInstance().refreshAndFindFileByPath(path);
    }
}
