package com.github.bannirui.genx.view;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;

/**
 * @author dingrui
 * @since 2023/2/9
 */
public class FreemarkerConfiguration extends Configuration {

    private static final String CLASS_PATH = "/template";
    private static final String EN_CODING = "UTF-8";

    public FreemarkerConfiguration() {
        this(CLASS_PATH);
    }

    private FreemarkerConfiguration(String baseDir) {
        super(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        setDefaultEncoding(EN_CODING);
        setClassForTemplateLoading(getClass(), baseDir);
    }

    public Template getTemplate(String ftl) throws IOException {
        return super.getTemplate(ftl, EN_CODING);
    }
}
