/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl;

public static interface Observable.Observer<T> {
    public void onError(Throwable var1);

    public void onNewData(T var1);
}
