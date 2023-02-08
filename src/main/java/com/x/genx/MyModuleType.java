package com.x.genx;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.x.genx.icons.SdkIcons;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author dingrui
 * @since 2023/2/9
 */
public class MyModuleType extends ModuleType<MyModuleBuilder> {

    private static final String ID = "MY_MODULE_TYPE";

    public MyModuleType() {
        super(ID);
    }

    public static MyModuleType getInstance() {
        return ((MyModuleType) ModuleTypeManager.getInstance().findByID(ID));
    }

    @Override
    public @NotNull MyModuleBuilder createModuleBuilder() {
        return new MyModuleBuilder();
    }

    @Override
    public @NotNull
    @Nls(capitalization = Nls.Capitalization.Title) String getName() {
        return "My-Code-Archive";
    }

    @Override
    public @NotNull
    @Nls(capitalization = Nls.Capitalization.Sentence) String getDescription() {
        return "Project Archive";
    }

    @Override
    public @NotNull Icon getNodeIcon(boolean b) {
        return SdkIcons.SdkDefaultIcon;
    }

    @Override
    public ModuleWizardStep @NotNull [] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull MyModuleBuilder moduleBuilder, @NotNull ModulesProvider modulesProvider) {
        return super.createWizardSteps(wizardContext, moduleBuilder, modulesProvider);
    }
}
