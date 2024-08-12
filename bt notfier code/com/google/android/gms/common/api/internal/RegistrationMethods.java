/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.internal.RegisterListenerMethod
 *  com.google.android.gms.common.api.internal.RegistrationMethods$Builder
 *  com.google.android.gms.common.api.internal.UnregisterListenerMethod
 *  com.google.android.gms.common.api.internal.zacd
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zacd;

public class RegistrationMethods<A extends Api.AnyClient, L> {
    public final RegisterListenerMethod<A, L> register;
    public final UnregisterListenerMethod<A, L> zaa;
    public final Runnable zab;

    /* synthetic */ RegistrationMethods(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable, zacd zacd2) {
        this.register = registerListenerMethod;
        this.zaa = unregisterListenerMethod;
        this.zab = runnable;
    }

    public static <A extends Api.AnyClient, L> Builder<A, L> builder() {
        return new Builder(null);
    }
}
