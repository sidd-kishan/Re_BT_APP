/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.ReferenceDisposable
 */
package io.reactivex.disposables;

import io.reactivex.disposables.ReferenceDisposable;

final class RunnableDisposable
extends ReferenceDisposable<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    RunnableDisposable(Runnable runnable) {
        super((Object)runnable);
    }

    protected void onDisposed(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunnableDisposable(disposed=");
        stringBuilder.append(this.isDisposed());
        stringBuilder.append(", ");
        stringBuilder.append(this.get());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
