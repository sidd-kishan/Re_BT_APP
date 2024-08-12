/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.dynamite.DynamiteModule
 *  com.google.android.gms.dynamite.DynamiteModule$LoadingException
 *  com.google.android.gms.dynamite.zzm
 */
package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.zzm;

final class zzc
implements zzm {
    zzc() {
    }

    public final int zza(Context context, String string, boolean bl) throws DynamiteModule.LoadingException {
        return DynamiteModule.zza((Context)context, (String)string, (boolean)bl);
    }

    public final int zzb(Context context, String string) {
        return DynamiteModule.getLocalVersion((Context)context, (String)string);
    }
}
