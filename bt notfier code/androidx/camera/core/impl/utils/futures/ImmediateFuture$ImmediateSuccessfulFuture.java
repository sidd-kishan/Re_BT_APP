/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.futures.ImmediateFuture
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.ImmediateFuture;

static final class ImmediateFuture.ImmediateSuccessfulFuture<V>
extends ImmediateFuture<V> {
    static final ImmediateFuture<Object> NULL_FUTURE = new ImmediateFuture.ImmediateSuccessfulFuture<Object>(null);
    private final V mValue;

    ImmediateFuture.ImmediateSuccessfulFuture(V v) {
        this.mValue = v;
    }

    public V get() {
        return this.mValue;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("[status=SUCCESS, result=[");
        stringBuilder.append(this.mValue);
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}
