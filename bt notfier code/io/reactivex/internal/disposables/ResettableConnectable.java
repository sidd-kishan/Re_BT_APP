/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 */
package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;

public interface ResettableConnectable {
    public void resetIf(Disposable var1);
}
