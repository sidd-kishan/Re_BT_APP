/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;

@FunctionalInterface
public interface AsyncFunction<I, O> {
    public ListenableFuture<O> apply(I var1) throws Exception;
}
