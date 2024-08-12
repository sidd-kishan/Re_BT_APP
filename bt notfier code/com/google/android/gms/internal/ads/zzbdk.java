/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.os.Bundle
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.internal.ads.zzbcx
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdj
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbhj
 *  com.google.android.gms.internal.ads.zzbhs
 *  com.google.android.gms.internal.ads.zzbio
 *  com.google.android.gms.internal.ads.zzcgm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzbcx;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdj;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbhj;
import com.google.android.gms.internal.ads.zzbhs;
import com.google.android.gms.internal.ads.zzbio;
import com.google.android.gms.internal.ads.zzcgm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class zzbdk {
    public static final zzbdk zza = new zzbdk();

    protected zzbdk() {
    }

    public final zzbdg zza(Context object, zzbhj zzbhj2) {
        Object object2 = zzbhj2.zza();
        long l = object2 != null ? ((Date)object2).getTime() : -1L;
        String string = zzbhj2.zzb();
        int n = zzbhj2.zzd();
        object2 = zzbhj2.zze();
        object2 = !object2.isEmpty() ? Collections.unmodifiableList(new ArrayList(object2)) : null;
        boolean bl = zzbhj2.zzm(object);
        Location location = zzbhj2.zzf();
        Bundle bundle = zzbhj2.zzh(AdMobAdapter.class);
        Object object3 = zzbhj2.zzt();
        if (object3 != null) {
            object3 = (object3 = object3.getQueryInfo()) != null ? object3.zza().zzd() : "";
            object3 = new zzbcx(zzbhj2.zzt().getAdString(), (String)object3);
        } else {
            object3 = null;
        }
        String string2 = zzbhj2.zzj();
        Object object4 = zzbhj2.zzl();
        object4 = object4 != null ? new zzbio(object4) : null;
        object = object.getApplicationContext();
        if (object != null) {
            object = object.getPackageName();
            zzber.zza();
            object = zzcgm.zzl((StackTraceElement[])Thread.currentThread().getStackTrace(), (String)object);
        } else {
            object = null;
        }
        boolean bl2 = zzbhj2.zzs();
        Object object5 = zzbhs.zze().zzr();
        int n2 = Math.max(zzbhj2.zzp(), object5.getTagForChildDirectedTreatment());
        int n3 = Math.max(-1, object5.getTagForUnderAgeOfConsent());
        String string3 = Collections.max(Arrays.asList(null, object5.getMaxAdContentRating()), zzbdj.zza);
        object5 = zzbhj2.zzc();
        return new zzbdg(8, l, bundle, n, object2, bl, n2, false, string2, (zzbio)object4, location, string, zzbhj2.zzo(), zzbhj2.zzq(), Collections.unmodifiableList(new ArrayList(zzbhj2.zzr())), zzbhj2.zzk(), (String)object, bl2, (zzbcx)object3, n3, string3, (List)object5, zzbhj2.zzv(), zzbhj2.zzu());
    }
}
