package com.x.genx.module.spring;

import com.intellij.ide.util.projectWizard.*;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.Result;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.StdModuleTypes;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.intellij.openapi.startup.StartupManager;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.DisposeAwareRunnable;
import com.x.genx.icons.MyIcons;
import com.x.genx.service.MavenProjectGenerator;
import com.x.genx.service.MyMavenProjectDataLoad;
import com.x.genx.service.impl.MySpringProjectGeneratorImpl;
import com.x.genx.ui.spring.SpringUI;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.util.Objects;

/**
 * @author dingrui
 * @since 2023/2/9
 */
public class SpringModuleBuilder extends ModuleBuilder {

    private static final String NAME = "Spring Boot";
    private static final String DESCRIPTION = "access to Spring project generating";
    private static final String SLASH = "/";

    private MavenProjectGenerator pg = new MySpringProjectGeneratorImpl();

    @Override
    public Icon getNodeIcon() {
        return MyIcons.SpringBootIcon;
    }

    @Override
    public ModuleType<?> getModuleType() {
        return StdModuleTypes.JAVA;
    }

    @Override
    public @Nls(capitalization = Nls.Capitalization.Title) String getPresentableName() {
        return NAME;
    }

    @Override
    public @NlsContexts.DetailedDescription String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public @Nullable
    @NonNls String getBuilderId() {
        return getClass().getName();
    }

    @Override
    public @Nullable ModuleWizardStep modifySettingsStep(@NotNull SettingsStep settingsStep) {
        ModuleNameLocationSettings moduleNameLocationSettings = settingsStep.getModuleNameLocationSettings();
        String artifactId = MyMavenProjectDataLoad.getInstance().getGAV().get_artifactId();
        if (Objects.nonNull(moduleNameLocationSettings) && !StringUtil.isEmptyOrSpaces(artifactId))
            moduleNameLocationSettings.setModuleName(artifactId);
        return super.modifySettingsStep(settingsStep);
    }

    @Override
    public void setupRootModel(@NotNull ModifiableRootModel rootModel) throws ConfigurationException {
        // jdk
        if (Objects.nonNull(this.myJdk)) rootModel.setSdk(this.myJdk);
        else rootModel.inheritSdk();
        // project
        Project project = rootModel.getProject();
        String projectName = project.getName();
        String projectLocation = project.getBasePath();
        String path = FileUtil.toSystemIndependentName(projectLocation + SLASH + projectName);
        new File(path).mkdirs();
        VirtualFile vf = LocalFileSystem.getInstance().refreshAndFindFileByPath(path);
        rootModel.addContentEntry(vf);
        // 工程结构
        Runnable r = () -> new WriteCommandAction<VirtualFile>(project) {
            @Override
            protected void run(@NotNull Result<? super VirtualFile> result) throws Throwable {
                pg.gen(project, getContentEntryPath(), MyMavenProjectDataLoad.getInstance().getGAV());
            }
        }.execute();
        if (ApplicationManager.getApplication().isUnitTestMode() || ApplicationManager.getApplication().isHeadlessEnvironment()) {
            r.run();
            return;
        }
        if (!project.isInitialized()) {
            StartupManager.getInstance(project).registerPostStartupActivity(DisposeAwareRunnable.create(r, project));
            return;
        }
        if (DumbService.isDumbAware(r)) r.run();
        else DumbService.getInstance(project).runWhenSmart(DisposeAwareRunnable.create(r, project));
    }

    @Override
    public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull ModulesProvider modulesProvider) {
        // 工程配置步骤
        return new ModuleWizardStep[]{new SpringModuleWizardStep(new SpringUI())};
    }
}
