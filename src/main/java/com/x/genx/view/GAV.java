package com.x.genx.view;

/**
 * 创建Maven项目坐标信息
 * 项目工程路径
 * 渲染到freemarker模板中
 * @author dingrui
 * @since 2023/2/9
 */
public class GAV {

    private String _groupId; // group id
    private String _artifactId; // artifact id
    private String _version; // version
    private String _package; // package

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
}
