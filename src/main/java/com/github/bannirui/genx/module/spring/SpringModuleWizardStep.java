package com.github.bannirui.genx.module.spring;

import com.github.bannirui.genx.service.SpringSettings;
import com.github.bannirui.genx.ui.spring.SpringUI;
import com.github.bannirui.genx.view.GAV;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.options.ConfigurationException;
import org.apache.commons.lang.WordUtils;

import javax.swing.*;

/**
 * Spring项目创建引导步骤
 *
 * @author dingrui
 * @since 2023/2/9
 */
public class SpringModuleWizardStep extends ModuleWizardStep {

    private final SpringUI ui;

    public SpringModuleWizardStep(SpringUI ui) {
        this.ui = ui;
    }

    // 获取界面
    @Override
    public JComponent getComponent() {
        return this.ui.getMainPanel();
    }

    // 点击next之后回调 存储用户数据
    @Override
    public void updateDataModel() {
        // 获取面板信息 装载工程配置信息
        GAV gav = SpringSettings.getInstance().getGAV();
        gav.set_groupId(this.ui.getGroupIdField().getText());
        String aId = this.ui.getArtifactIdField().getText();
        gav.set_artifactId(aId);
        gav.set_upperArtifactId(WordUtils.capitalize(aId));
        gav.set_version(this.ui.getVersionField().getText());
        gav.set_package(this.ui.getPackageField().getText());
        gav.set_appId(this.ui.getAppIdField().getText());
    }

    @Override
    public boolean validate() throws ConfigurationException {
        return super.validate();
    }
}
