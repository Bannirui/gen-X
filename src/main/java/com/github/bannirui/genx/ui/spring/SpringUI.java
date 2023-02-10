package com.github.bannirui.genx.ui.spring;

import javax.swing.*;

/**
 * @author dingrui
 * @since 2023/2/10
 */
public class SpringUI {
    private JPanel mainPanel;
    private JTextField groupIdField;
    private JTextField artifactIdField;
    private JTextField versionField;
    private JTextField packageField;
    private JTextField appIdField;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTextField getGroupIdField() {
        return groupIdField;
    }

    public void setGroupIdField(JTextField groupIdField) {
        this.groupIdField = groupIdField;
    }

    public JTextField getArtifactIdField() {
        return artifactIdField;
    }

    public void setArtifactIdField(JTextField artifactIdField) {
        this.artifactIdField = artifactIdField;
    }

    public JTextField getVersionField() {
        return versionField;
    }

    public void setVersionField(JTextField versionField) {
        this.versionField = versionField;
    }

    public JTextField getPackageField() {
        return packageField;
    }

    public void setPackageField(JTextField packageField) {
        this.packageField = packageField;
    }

    public JTextField getAppIdField() {
        return appIdField;
    }

    public void setAppIdField(JTextField appIdField) {
        this.appIdField = appIdField;
    }
}
