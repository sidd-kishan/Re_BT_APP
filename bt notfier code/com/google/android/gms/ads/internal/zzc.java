/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IInterface
 *  android.os.Looper
 *  com.google.android.gms.common.internal.BaseGmsClient
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 */
package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.BaseGmsClient;

public abstract class zzc<T extends IInterface>
extends BaseGmsClient<T> {
    protected zzc(Context context, Looper looper, int n, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener, String string) {
        super(context, looper, n, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }
}
