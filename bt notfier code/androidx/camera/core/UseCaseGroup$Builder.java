/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.UseCaseGroup
 *  androidx.camera.core.ViewPort
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

public static final class UseCaseGroup.Builder {
    private final List<UseCase> mUseCases = new ArrayList<UseCase>();
    private ViewPort mViewPort;

    public UseCaseGroup.Builder addUseCase(UseCase useCase) {
        this.mUseCases.add(useCase);
        return this;
    }

    public UseCaseGroup build() {
        Preconditions.checkArgument((boolean)(this.mUseCases.isEmpty() ^ true), (Object)"UseCase must not be empty.");
        return new UseCaseGroup(this.mViewPort, this.mUseCases);
    }

    public UseCaseGroup.Builder setViewPort(ViewPort viewPort) {
        this.mViewPort = viewPort;
        return this;
    }
}
