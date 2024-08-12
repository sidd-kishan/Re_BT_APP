/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.appset.AppSetIdClient
 *  com.google.android.gms.internal.appset.zzr
 */
package com.google.android.gms.appset;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.internal.appset.zzr;

public final class AppSet {
    private AppSet() {
    }

    public static AppSetIdClient getClient(Context context) {
        return new zzr(context);
    }
}
