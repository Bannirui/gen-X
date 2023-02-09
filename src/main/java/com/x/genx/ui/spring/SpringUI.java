package com.x.genx.ui.spring;

import javax.swing.*;

/**
 * @author dingrui
 * @since 2023/2/9
 */
public class SpringUI {

    private JPanel mainPanel;
    private JTextField groupIdField; // group id
    private JTextField artifactIdField; // artifact id
    private JTextField versionField; // version
    private JTextField packageField; // package

    public JPanel getComponent() {
        return mainPanel;
    }

    public JTextField getGroupIdField() {
        return groupIdField;
    }

    public JTextField getArtifactIdField() {
        return artifactIdField;
    }

    public JTextField getVersionField() {
        return versionField;
    }

    public JTextField getPackageField() {
        return packageField;
    }
}
