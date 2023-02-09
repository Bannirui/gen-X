package com.github.bannirui.genx.module.spring;

import com.github.bannirui.genx.icons.MyIcons;
import com.github.bannirui.genx.service.MavenProjectGenerator;
import com.github.bannirui.genx.service.SpringSettings;
import com.github.bannirui.genx.service.impl.MySpringProjectGeneratorImpl;
import com.github.bannirui.genx.ui.spring.SpringUI;
import com.intellij.ide.util.projectWizard.*;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.StdModuleTypes;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.DisposeAwareRunnable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.util.Objects;

/**
 * Spring项目向导
 *
 * @author dingrui
 * @since 2023/2/9
 */
public class SpringModuleBuilder extends ModuleBuilder {

    private static final String NAME = "GEN-X::Spring";
    private static final String DESCRIPTION = "AN ACCESS TO SPRING BOOT TEMPLATE GENERATING";

    private final MavenProjectGenerator pg = new MySpringProjectGeneratorImpl();

    public SpringModuleBuilder() {
    }

    // 重写方法 挂载自定义模板
    @Override
    public @Nullable
    @NonNls String getBuilderId() {
        return getClass().getName();
    }

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

    // [New Project]回调
    @Override
    public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull ModulesProvider modulesProvider) {
        return new ModuleWizardStep[]{new SpringModuleWizardStep(new SpringUI())};
    }

    // 表单页面
    @Override
    public @Nullable ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
        return super.getCustomOptionsStep(context, parentDisposable);
    }

    // 自定义form表单提交后回调 设置模块名
    @Override
    public @Nullable ModuleWizardStep modifySettingsStep(@NotNull SettingsStep settingsStep) {
        // maven表单
        ModuleNameLocationSettings moduleNameLocationSettings = settingsStep.getModuleNameLocationSettings();
        String artifactId = SpringSettings.getInstance().getGAV().get_artifactId();
        if (Objects.nonNull(moduleNameLocationSettings) && !StringUtil.isEmptyOrSpaces(artifactId))
            moduleNameLocationSettings.setModuleName(artifactId);
        // 项目表单
        return super.modifySettingsStep(settingsStep);
    }

    @Override
    public boolean validateModuleName(@NotNull String moduleName) throws ConfigurationException {
        return super.validateModuleName(moduleName);
    }

    // module创建完成后回调
    @Override
    public void setupRootModel(@NotNull ModifiableRootModel rootModel) throws ConfigurationException {
        // jdk
        if (Objects.nonNull(this.myJdk)) rootModel.setSdk(this.myJdk);
        else rootModel.inheritSdk();
        // 工程路径
        VirtualFile vf = this.createAndGetContentEntry();
        rootModel.addContentEntry(vf);
        // project
        Project project = rootModel.getProject();
        // 工程结构
        Runnable r = () -> {
            WriteCommandAction.writeCommandAction(project).compute(() -> {
                SpringModuleBuilder.this.pg.gen(project, getContentEntryPath(), SpringSettings.getInstance().getGAV());
                return null;
            });
        };
        if (ApplicationManager.getApplication().isUnitTestMode() || ApplicationManager.getApplication().isHeadlessEnvironment()) {
            r.run();
            return;
        }
        // TODO: 2023/2/9 comment below caz of err log
        // if (!project.isInitialized()) {
        //     StartupManager.getInstance(project).registerPostStartupActivity(DisposeAwareRunnable.create(r, project));
        //     return;
        // }
        if (DumbService.isDumbAware(r)) r.run();
        else DumbService.getInstance(project).runWhenSmart(DisposeAwareRunnable.create(r, project));
    }

    private VirtualFile createAndGetContentEntry() {
        // 引导面板上的[project location] 需要填写含项目名的全路径
        String path = FileUtil.toSystemIndependentName(Objects.requireNonNull(super.getContentEntryPath()));
        new File(path).mkdirs();
        return LocalFileSystem.getInstance().refreshAndFindFileByPath(path);
    }
}
