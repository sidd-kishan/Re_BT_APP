/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.internal.RegistrationMethods$Builder
 *  com.google.android.gms.common.api.internal.RemoteCall
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zacg
implements RemoteCall {
    private final RegistrationMethods.Builder zaa;

    zacg(RegistrationMethods.Builder builder) {
        this.zaa = builder;
    }

    public final void accept(Object object, Object object2) {
        this.zaa.zaa((Api.AnyClient)object, (TaskCompletionSource)object2);
    }
}
