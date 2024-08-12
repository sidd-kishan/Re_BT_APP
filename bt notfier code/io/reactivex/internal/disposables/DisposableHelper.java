/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.ProtocolViolationException
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class DisposableHelper
extends Enum<DisposableHelper>
implements Disposable {
    private static final DisposableHelper[] $VALUES;
    public static final /* enum */ DisposableHelper DISPOSED;

    static {
        DisposableHelper disposableHelper;
        DISPOSED = disposableHelper = new DisposableHelper();
        $VALUES = new DisposableHelper[]{disposableHelper};
    }

    public static boolean dispose(AtomicReference<Disposable> disposable) {
        DisposableHelper disposableHelper;
        Disposable disposable2 = disposable.get();
        if (disposable2 == (disposableHelper = DISPOSED)) return false;
        if ((disposable = disposable.getAndSet((Disposable)disposableHelper)) == disposableHelper) return false;
        if (disposable == null) return true;
        disposable.dispose();
        return true;
    }

    public static boolean isDisposed(Disposable disposable) {
        boolean bl = disposable == DISPOSED;
        return bl;
    }

    public static boolean replace(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        do {
            if ((disposable2 = atomicReference.get()) != DISPOSED) continue;
            if (disposable == null) return false;
            disposable.dispose();
            return false;
        } while (!atomicReference.compareAndSet(disposable2, disposable));
        return true;
    }

    public static void reportDisposableSet() {
        RxJavaPlugins.onError((Throwable)new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        do {
            if ((disposable2 = atomicReference.get()) != DISPOSED) continue;
            if (disposable == null) return false;
            disposable.dispose();
            return false;
        } while (!atomicReference.compareAndSet(disposable2, disposable));
        if (disposable2 == null) return true;
        disposable2.dispose();
        return true;
    }

    public static boolean setOnce(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        ObjectHelper.requireNonNull((Object)disposable, (String)"d is null");
        if (atomicReference.compareAndSet(null, disposable)) return true;
        disposable.dispose();
        if (atomicReference.get() == DISPOSED) return false;
        DisposableHelper.reportDisposableSet();
        return false;
    }

    public static boolean trySet(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        if (atomicReference.compareAndSet(null, disposable)) return true;
        if (atomicReference.get() != DISPOSED) return false;
        disposable.dispose();
        return false;
    }

    public static boolean validate(Disposable disposable, Disposable disposable2) {
        if (disposable2 == null) {
            RxJavaPlugins.onError((Throwable)new NullPointerException("next is null"));
            return false;
        }
        if (disposable == null) return true;
        disposable2.dispose();
        DisposableHelper.reportDisposableSet();
        return false;
    }

    public static DisposableHelper valueOf(String string) {
        return Enum.valueOf(DisposableHelper.class, string);
    }

    public static DisposableHelper[] values() {
        return (DisposableHelper[])$VALUES.clone();
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }
}
