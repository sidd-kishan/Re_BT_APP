/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 *  androidx.browser.customtabs.CustomTabsIntent
 *  androidx.browser.customtabs.CustomTabsIntent$Builder
 *  com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 *  com.google.android.gms.ads.internal.overlay.zzc
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.internal.ads.zzbkj
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzcxv
 *  com.google.android.gms.internal.ads.zzdji
 *  com.google.android.gms.internal.ads.zzdjm
 *  com.google.android.gms.internal.ads.zzdkf
 *  com.google.android.gms.internal.ads.zzdkn
 *  com.google.android.gms.internal.ads.zzeec
 *  com.google.android.gms.internal.ads.zzefp
 *  com.google.android.gms.internal.ads.zzefq
 *  com.google.android.gms.internal.ads.zzezy
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbkj;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzcxv;
import com.google.android.gms.internal.ads.zzdji;
import com.google.android.gms.internal.ads.zzdjm;
import com.google.android.gms.internal.ads.zzdkf;
import com.google.android.gms.internal.ads.zzdkn;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzefp;
import com.google.android.gms.internal.ads.zzefq;
import com.google.android.gms.internal.ads.zzezy;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzefr
implements zzeec<zzdji> {
    private final Context zza;
    private final zzdkf zzb;
    private final Executor zzc;
    private final zzezy zzd;

    public zzefr(Context context, Executor executor, zzdkf zzdkf2, zzezy zzezy2) {
        this.zza = context;
        this.zzb = zzdkf2;
        this.zzc = executor;
        this.zzd = zzezy2;
    }

    private static String zzd(zzezz object) {
        try {
            object = object.zzv.getString("tab_url");
            return object;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public final boolean zza(zzfal zzfal2, zzezz zzezz2) {
        if (!(this.zza instanceof Activity)) return false;
        if (!PlatformVersion.isAtLeastIceCreamSandwichMR1()) return false;
        if (!zzbkj.zza((Context)this.zza)) return false;
        if (TextUtils.isEmpty((CharSequence)zzefr.zzd(zzezz2))) return false;
        return true;
    }

    public final zzfsm<zzdji> zzb(zzfal zzfal2, zzezz zzezz2) {
        String string = zzefr.zzd(zzezz2);
        string = string != null ? Uri.parse((String)string) : null;
        return zzfsd.zzi((zzfsm)zzfsd.zza(null), (zzfrk)new zzefp(this, (Uri)string, zzfal2, zzezz2), (Executor)this.zzc);
    }

    final /* synthetic */ zzfsm zzc(Uri uri, zzfal zzfal2, zzezz zzezz2, Object object) throws Exception {
        try {
            object = new CustomTabsIntent.Builder();
            object = object.build();
            ((CustomTabsIntent)object).intent.setData(uri);
            uri = new zzc(((CustomTabsIntent)object).intent, null);
            object = new zzchl();
            zzdkf zzdkf2 = this.zzb;
            zzcxv zzcxv2 = new zzcxv(zzfal2, zzezz2, null);
            zzfal2 = new zzefq((zzchl)object);
            zzezz2 = new zzdjm((zzdkn)zzfal2, null);
            zzezz2 = zzdkf2.zzQ(zzcxv2, (zzdjm)zzezz2);
            zzdkf2 = zzezz2.zzi();
            zzfal2 = new zzcgz(0, 0, false, false, false);
            zzcxv2 = new AdOverlayInfoParcel((zzc)uri, null, (zzo)zzdkf2, null, (zzcgz)zzfal2, null, null);
            object.zzc((Object)zzcxv2);
            this.zzd.zzd();
            uri = zzfsd.zza((Object)zzezz2.zzh());
            return uri;
        }
        catch (Throwable throwable) {
            zze.zzg((String)"Error in CustomTabsAdRenderer", (Throwable)throwable);
            throw throwable;
        }
    }
}
