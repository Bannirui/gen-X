package com.x.genx.module.spring;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.options.ConfigurationException;
import com.x.genx.service.MyMavenProjectDataLoad;
import com.x.genx.ui.spring.SpringUI;
import com.x.genx.view.GAV;

import javax.swing.*;

/**
 * @author dingrui
 * @since 2023/2/9
 */
public class SpringModuleWizardStep extends ModuleWizardStep {

    private SpringUI ui;

    public SpringModuleWizardStep(SpringUI ui) {
        this.ui = ui;
    }

    @Override
    public JComponent getComponent() {
        return this.ui.getComponent();
    }

    @Override
    public void updateDataModel() {
    }

    @Override
    public boolean validate() throws ConfigurationException {
        // 获取面板信息 装载工程配置信息
        GAV gav = MyMavenProjectDataLoad.getInstance().getGAV();
        gav.set_groupId(this.ui.getGroupIdField().getText());
        gav.set_artifactId(this.ui.getArtifactIdField().getText());
        gav.set_version(this.ui.getVersionField().getText());
        gav.set_package(this.ui.getPackageField().getText());
        return super.validate();
    }
}
