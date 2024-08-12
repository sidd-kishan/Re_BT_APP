/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 */
package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;

public interface DisposableContainer {
    public boolean add(Disposable var1);

    public boolean delete(Disposable var1);

    public boolean remove(Disposable var1);
}
