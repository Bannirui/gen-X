package com.github.bannirui.genx.factory;

import com.github.bannirui.genx.icons.MyIcons;
import com.github.bannirui.genx.module.spring.SpringModuleBuilder;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.platform.ProjectTemplate;
import com.intellij.platform.ProjectTemplatesFactory;
import com.intellij.platform.templates.BuilderBasedTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author dingrui
 * @since 2023/2/9
 */
public class TemplateFactory extends ProjectTemplatesFactory {

    private static final String NAME = "GEN-X";

    @Override
    public String @NotNull [] getGroups() {
        return new String[]{NAME};
    }

    @Override
    public Icon getGroupIcon(String group) {
        return MyIcons.SdkDefaultIcon;
    }

    @Override
    public ProjectTemplate @NotNull [] createTemplates(@Nullable String s, @NotNull WizardContext wizardContext) {
        // 项目向导
        return new ProjectTemplate[]{new BuilderBasedTemplate(new SpringModuleBuilder())};
    }
}
