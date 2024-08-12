/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraCaptureFailure$Reason
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureFailure;

public final class CameraCaptureFailure {
    private final Reason mReason;

    public CameraCaptureFailure(Reason reason) {
        this.mReason = reason;
    }

    public Reason getReason() {
        return this.mReason;
    }
}
