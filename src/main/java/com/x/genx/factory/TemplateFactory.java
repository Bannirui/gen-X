package com.x.genx.factory;

import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.platform.ProjectTemplate;
import com.intellij.platform.ProjectTemplatesFactory;
import com.intellij.platform.templates.BuilderBasedTemplate;
import com.x.genx.module.spring.SpringModuleBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author dingrui
 * @since 2023/2/9
 */
public class TemplateFactory extends ProjectTemplatesFactory {

    private static final String FACTORY_NAME = "My Template";

    @Override
    public String @NotNull [] getGroups() {
        return new String[]{FACTORY_NAME};
    }

    @Override
    public Icon getGroupIcon(String group) {
        // TODO: 2023/2/9
        return null;
    }

    @Override
    public ProjectTemplate @NotNull [] createTemplates(@Nullable String s, @NotNull WizardContext wizardContext) {
        return new ProjectTemplate[]{new BuilderBasedTemplate(new SpringModuleBuilder())};
    }
}
