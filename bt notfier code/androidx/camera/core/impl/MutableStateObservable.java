/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.StateObservable
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.StateObservable;

public class MutableStateObservable<T>
extends StateObservable<T> {
    private MutableStateObservable(Object object, boolean bl) {
        super(object, bl);
    }

    public static <T> MutableStateObservable<T> withInitialError(Throwable throwable) {
        return new MutableStateObservable<T>(throwable, true);
    }

    public static <T> MutableStateObservable<T> withInitialState(T t) {
        return new MutableStateObservable<T>(t, false);
    }

    public void setError(Throwable throwable) {
        this.updateStateAsError(throwable);
    }

    public void setState(T t) {
        this.updateState(t);
    }
}
