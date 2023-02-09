package com.github.bannirui.genx.service;

import com.github.bannirui.genx.common.SpringState;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.github.bannirui.genx.view.GAV;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author dingrui
 * @since 2023/2/9
 */
@State(name = "SpringSettings", storages = @Storage("plugin.xml"))
public class SpringSettings implements PersistentStateComponent<SpringState> {

    private SpringState springState = new SpringState();

    public static SpringSettings getInstance() {
        return ServiceManager.getService(SpringSettings.class);
    }

    @Override
    public @Nullable SpringState getState() {
        return this.springState;
    }

    @Override
    public void loadState(@NotNull SpringState springState) {
        this.springState = springState;
    }

    public GAV getGAV() {
        return this.springState.getGav();
    }
}
