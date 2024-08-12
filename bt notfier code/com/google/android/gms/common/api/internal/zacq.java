/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.internal.RemoteCall
 *  com.google.android.gms.common.util.BiConsumer
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zacq
implements RemoteCall {
    private final BiConsumer zaa;

    zacq(BiConsumer biConsumer) {
        this.zaa = biConsumer;
    }

    public final void accept(Object object, Object object2) {
        this.zaa.accept((Object)((Api.AnyClient)object), (Object)((TaskCompletionSource)object2));
    }
}
