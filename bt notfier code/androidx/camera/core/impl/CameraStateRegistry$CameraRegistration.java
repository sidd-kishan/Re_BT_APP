/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.CameraInternal$State
 *  androidx.camera.core.impl.CameraStateRegistry$OnOpenAvailableListener
 *  androidx.camera.core.impl._$$Lambda$q0_737uiXXnVhEez_6fh5OPQDB0
 */
package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl._$;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

private static class CameraStateRegistry.CameraRegistration {
    private final CameraStateRegistry.OnOpenAvailableListener mCameraAvailableListener;
    private final Executor mNotifyExecutor;
    private CameraInternal.State mState;

    CameraStateRegistry.CameraRegistration(CameraInternal.State state, Executor executor, CameraStateRegistry.OnOpenAvailableListener onOpenAvailableListener) {
        this.mState = state;
        this.mNotifyExecutor = executor;
        this.mCameraAvailableListener = onOpenAvailableListener;
    }

    CameraInternal.State getState() {
        return this.mState;
    }

    void notifyListener() {
        try {
            Executor executor = this.mNotifyExecutor;
            CameraStateRegistry.OnOpenAvailableListener onOpenAvailableListener = this.mCameraAvailableListener;
            Objects.requireNonNull(onOpenAvailableListener);
            _$.Lambda.q0_737uiXXnVhEez_6fh5OPQDB0 q0_737uiXXnVhEez_6fh5OPQDB02 = new _$.Lambda.q0_737uiXXnVhEez_6fh5OPQDB0(onOpenAvailableListener);
            executor.execute((Runnable)q0_737uiXXnVhEez_6fh5OPQDB02);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            Logger.e((String)"CameraStateRegistry", (String)"Unable to notify camera.", (Throwable)rejectedExecutionException);
        }
    }

    CameraInternal.State setState(CameraInternal.State state) {
        CameraInternal.State state2 = this.mState;
        this.mState = state;
        return state2;
    }
}
