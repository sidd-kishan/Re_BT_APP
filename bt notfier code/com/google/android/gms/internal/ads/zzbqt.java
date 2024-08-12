/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.RemoteException
 *  com.google.android.gms.ads.h5.OnH5AdsEventListener
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbqp
 *  com.google.android.gms.internal.ads.zzbvd
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbqp;
import com.google.android.gms.internal.ads.zzbvd;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbqt {
    private final Context zza;
    private final OnH5AdsEventListener zzb;
    private zzbqp zzc;

    public zzbqt(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        boolean bl = Build.VERSION.SDK_INT >= 21;
        Preconditions.checkState((boolean)bl, (Object)"Android version must be Lollipop or higher");
        Preconditions.checkNotNull((Object)context);
        Preconditions.checkNotNull((Object)onH5AdsEventListener);
        this.zza = context;
        this.zzb = onH5AdsEventListener;
        zzbjl.zza((Context)context);
    }

    public static final boolean zzc(String string) {
        zzbjd zzbjd2 = zzbjl.zzgJ;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return false;
        }
        Preconditions.checkNotNull((Object)string);
        int n = string.length();
        zzbjd2 = zzbjl.zzgL;
        if (n > (Integer)zzbet.zzc().zzc(zzbjd2)) {
            zzcgt.zzd((String)"H5 GMSG exceeds max length");
            return false;
        }
        if (!"gmsg".equals((string = Uri.parse((String)string)).getScheme())) return false;
        if (!"mobileads.google.com".equals(string.getHost())) return false;
        if (!"/h5ads".equals(string.getPath())) return false;
        return true;
    }

    private final void zzd() {
        if (this.zzc != null) {
            return;
        }
        this.zzc = zzber.zzb().zzs(this.zza, (zzbvg)new zzbvd(), this.zzb);
    }

    public final boolean zza(String string) {
        if (!zzbqt.zzc(string)) {
            return false;
        }
        this.zzd();
        zzbqp zzbqp2 = this.zzc;
        if (zzbqp2 == null) return false;
        try {
            zzbqp2.zze(string);
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
        return true;
    }

    public final void zzb() {
        zzbjd zzbjd2 = zzbjl.zzgJ;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return;
        }
        this.zzd();
        zzbjd2 = this.zzc;
        if (zzbjd2 == null) return;
        try {
            zzbjd2.zzf();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
    }
}
