/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils.futures;

public interface FutureCallback<V> {
    public void onFailure(Throwable var1);

    public void onSuccess(V var1);
}
