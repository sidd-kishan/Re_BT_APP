/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.ViewPort
 */
package androidx.camera.core;

import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import java.util.List;

public final class UseCaseGroup {
    private final List<UseCase> mUseCases;
    private final ViewPort mViewPort;

    UseCaseGroup(ViewPort viewPort, List<UseCase> list) {
        this.mViewPort = viewPort;
        this.mUseCases = list;
    }

    public List<UseCase> getUseCases() {
        return this.mUseCases;
    }

    public ViewPort getViewPort() {
        return this.mViewPort;
    }
}
