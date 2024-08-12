/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.SessionConfig
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.SessionConfig;

private static final class UseCaseAttachState.UseCaseAttachInfo {
    private boolean mActive = false;
    private boolean mAttached = false;
    private final SessionConfig mSessionConfig;

    UseCaseAttachState.UseCaseAttachInfo(SessionConfig sessionConfig) {
        this.mSessionConfig = sessionConfig;
    }

    boolean getActive() {
        return this.mActive;
    }

    boolean getAttached() {
        return this.mAttached;
    }

    SessionConfig getSessionConfig() {
        return this.mSessionConfig;
    }

    void setActive(boolean bl) {
        this.mActive = bl;
    }

    void setAttached(boolean bl) {
        this.mAttached = bl;
    }
}
