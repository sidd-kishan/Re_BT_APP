/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbnd
 *  com.google.android.gms.internal.ads.zzbnf
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbnd;
import com.google.android.gms.internal.ads.zzbnf;

public abstract class zzbne
extends zzadk
implements zzbnf {
    public static zzbnf zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
        if (!(iInterface instanceof zzbnf)) return new zzbnd(iBinder);
        return (zzbnf)iInterface;
    }
}
