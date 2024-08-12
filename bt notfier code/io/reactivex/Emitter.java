/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex;

public interface Emitter<T> {
    public void onComplete();

    public void onError(Throwable var1);

    public void onNext(T var1);
}
