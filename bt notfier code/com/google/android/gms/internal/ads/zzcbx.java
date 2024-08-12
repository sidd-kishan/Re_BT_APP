/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;

public final class zzcbx
extends ContextWrapper {
    public static Context zza(Context context) {
        if (context instanceof zzcbx) return ((zzcbx)context).getBaseContext();
        Context context2 = context.getApplicationContext();
        if (context2 != null) return context2;
        return context;
    }

    public final Context getApplicationContext() {
        throw null;
    }

    public final ApplicationInfo getApplicationInfo() {
        synchronized (this) {
            throw null;
        }
    }

    public final String getPackageName() {
        synchronized (this) {
            throw null;
        }
    }

    public final String getPackageResourcePath() {
        synchronized (this) {
            throw null;
        }
    }

    public final void startActivity(Intent intent) {
        synchronized (this) {
            throw null;
        }
    }
}
