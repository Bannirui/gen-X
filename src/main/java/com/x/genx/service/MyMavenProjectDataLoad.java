package com.x.genx.service;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.x.genx.common.MyMavenProjectData;
import com.x.genx.view.GAV;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author dingrui
 * @since 2023/2/9
 */
@State(name = "MyMavenProjectDataLoad", storages = @Storage("plugin.xml"))
public class MyMavenProjectDataLoad implements PersistentStateComponent<MyMavenProjectData> {

    private MyMavenProjectData data = new MyMavenProjectData();

    public static MyMavenProjectDataLoad getInstance() {
        return ServiceManager.getService(MyMavenProjectDataLoad.class);
    }

    @Override
    public @Nullable MyMavenProjectData getState() {
        return this.data;
    }

    @Override
    public void loadState(@NotNull MyMavenProjectData myMavenProjectData) {
        this.data = myMavenProjectData;
    }

    public GAV getGAV() {
        return this.data.getGav();
    }
}
