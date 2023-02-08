package com.x.genx;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;

import javax.swing.*;

/**
 * @author dingrui
 * @since 2023/2/9
 */
public class MyModuleWizardStep extends ModuleWizardStep {

    @Override
    public JComponent getComponent() {
        // TODO: 2023/2/9
        return new JLabel("Provide some setting here");
    }

    @Override
    public void updateDataModel() {
        // TODO: 2023/2/9
    }
}
