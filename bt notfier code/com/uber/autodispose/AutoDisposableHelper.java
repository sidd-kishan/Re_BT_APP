/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 */
package com.uber.autodispose;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

final class AutoDisposableHelper
extends Enum<AutoDisposableHelper>
implements Disposable {
    private static final AutoDisposableHelper[] $VALUES;
    public static final /* enum */ AutoDisposableHelper DISPOSED;

    static {
        AutoDisposableHelper autoDisposableHelper;
        DISPOSED = autoDisposableHelper = new AutoDisposableHelper();
        $VALUES = new AutoDisposableHelper[]{autoDisposableHelper};
    }

    static boolean dispose(AtomicReference<Disposable> disposable) {
        AutoDisposableHelper autoDisposableHelper;
        Disposable disposable2 = disposable.get();
        if (disposable2 == (autoDisposableHelper = DISPOSED)) return false;
        if ((disposable = disposable.getAndSet((Disposable)autoDisposableHelper)) == autoDisposableHelper) return false;
        if (disposable == null) return true;
        disposable.dispose();
        return true;
    }

    public static AutoDisposableHelper valueOf(String string) {
        return Enum.valueOf(AutoDisposableHelper.class, string);
    }

    public static AutoDisposableHelper[] values() {
        return (AutoDisposableHelper[])$VALUES.clone();
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }
}
