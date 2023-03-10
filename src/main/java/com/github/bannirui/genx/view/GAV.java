package com.github.bannirui.genx.view;

/**
 * 创建Maven项目坐标信息
 * 项目工程路径
 * 渲染到freemarker模板中
 *
 * @author dingrui
 * @since 2023/2/9
 */
public class GAV {

    private String _groupId; // group id
    private String _artifactId; // artifact id
    private String _upperArtifactId; // 大写 Java源码模板渲染
    private String _version; // version
    private String _package; // package
    private String _appId;

    public String get_groupId() {
        return _groupId;
    }

    public void set_groupId(String _groupId) {
        this._groupId = _groupId;
    }

    public String get_artifactId() {
        return _artifactId;
    }

    public void set_artifactId(String _artifactId) {
        this._artifactId = _artifactId;
    }

    public String get_upperArtifactId() {
        return _upperArtifactId;
    }

    public void set_upperArtifactId(String _upperArtifactId) {
        this._upperArtifactId = _upperArtifactId;
    }

    public String get_version() {
        return _version;
    }

    public void set_version(String _version) {
        this._version = _version;
    }

    public String get_package() {
        return _package;
    }

    public void set_package(String _package) {
        this._package = _package;
    }

    public String get_appId() {
        return _appId;
    }

    public void set_appId(String _appId) {
        this._appId = _appId;
    }
}
