/*
 * Decompiled with CFR 0.152.
 */
package androidx.activity.result.contract;

public static final class ActivityResultContract.SynchronousResult<T> {
    private final T mValue;

    public ActivityResultContract.SynchronousResult(T t) {
        this.mValue = t;
    }

    public T getValue() {
        return this.mValue;
    }
}
