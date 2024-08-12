/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 *  com.google.android.gms.ads.internal.overlay.zza
 *  com.google.android.gms.ads.internal.overlay.zzc
 *  com.google.android.gms.ads.internal.overlay.zzt
 *  com.google.android.gms.ads.internal.overlay.zzv
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.internal.ads.zzbcv
 */
package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zza;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbcv;

public final class zzm {
    public static final void zza(Context object, AdOverlayInfoParcel adOverlayInfoParcel, boolean bl) {
        if (adOverlayInfoParcel.zzk == 4 && adOverlayInfoParcel.zzc == null) {
            zzbcv zzbcv2 = adOverlayInfoParcel.zzb;
            if (zzbcv2 != null) {
                zzbcv2.onAdClicked();
            }
            if ((zzbcv2 = adOverlayInfoParcel.zzy) != null) {
                zzbcv2.zzb();
            }
            Activity activity = adOverlayInfoParcel.zzd.zzj();
            zzc zzc2 = adOverlayInfoParcel.zza;
            zzbcv2 = object;
            if (zzc2 != null) {
                zzbcv2 = object;
                if (zzc2.zzj) {
                    zzbcv2 = object;
                    if (activity != null) {
                        zzbcv2 = activity;
                    }
                }
            }
            zzt.zza();
            activity = adOverlayInfoParcel.zza;
            adOverlayInfoParcel = adOverlayInfoParcel.zzi;
            object = activity != null ? activity.zzi : null;
            zza.zzb((Context)zzbcv2, (zzc)activity, (zzv)adOverlayInfoParcel, (com.google.android.gms.ads.internal.overlay.zzt)object);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(object, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzm.zzd);
        intent.putExtra("shouldCallOnOverlayOpened", bl);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", (Parcelable)adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
        if (!PlatformVersion.isAtLeastLollipop()) {
            intent.addFlags(524288);
        }
        if (!(object instanceof Activity)) {
            intent.addFlags(0x10000000);
        }
        zzt.zzc();
        zzs.zzP((Context)object, (Intent)intent);
    }
}
