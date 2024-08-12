/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl;

import androidx.core.util.Preconditions;

public static final class LiveDataObservable.Result<T> {
    private final Throwable mError;
    private final T mValue;

    private LiveDataObservable.Result(T t, Throwable throwable) {
        this.mValue = t;
        this.mError = throwable;
    }

    static <T> LiveDataObservable.Result<T> fromError(Throwable throwable) {
        return new LiveDataObservable.Result<Object>(null, (Throwable)Preconditions.checkNotNull((Object)throwable));
    }

    static <T> LiveDataObservable.Result<T> fromValue(T t) {
        return new LiveDataObservable.Result<T>(t, null);
    }

    public boolean completedSuccessfully() {
        boolean bl = this.mError == null;
        return bl;
    }

    public Throwable getError() {
        return this.mError;
    }

    public T getValue() {
        if (!this.completedSuccessfully()) throw new IllegalStateException("Result contains an error. Does not contain a value.");
        return this.mValue;
    }

    public String toString() {
        CharSequence charSequence;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Result: <");
        if (this.completedSuccessfully()) {
            charSequence = new StringBuilder();
            charSequence.append("Value: ");
            charSequence.append(this.mValue);
            charSequence = charSequence.toString();
        } else {
            charSequence = new StringBuilder();
            charSequence.append("Error: ");
            charSequence.append(this.mError);
            charSequence = charSequence.toString();
        }
        stringBuilder.append((String)charSequence);
        stringBuilder.append(">]");
        return stringBuilder.toString();
    }
}
