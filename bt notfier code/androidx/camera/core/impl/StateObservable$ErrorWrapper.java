/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.AutoValue_StateObservable_ErrorWrapper
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.AutoValue_StateObservable_ErrorWrapper;

static abstract class StateObservable.ErrorWrapper {
    StateObservable.ErrorWrapper() {
    }

    static StateObservable.ErrorWrapper wrap(Throwable throwable) {
        return new AutoValue_StateObservable_ErrorWrapper(throwable);
    }

    public abstract Throwable getError();
}
