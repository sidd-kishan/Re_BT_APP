/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  com.google.android.gms.ads.VideoOptions
 *  com.google.android.gms.ads.formats.NativeAdOptions
 *  com.google.android.gms.ads.formats.NativeAdOptions$Builder
 *  com.google.android.gms.ads.mediation.NativeMediationAdRequest
 *  com.google.android.gms.ads.nativead.NativeAdOptions
 *  com.google.android.gms.internal.ads.zzbhs
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzblv
 */
package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.internal.ads.zzbhs;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzblv;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzbwj
implements NativeMediationAdRequest {
    private final Date zza;
    private final int zzb;
    private final Set<String> zzc;
    private final boolean zzd;
    private final Location zze;
    private final int zzf;
    private final zzblv zzg;
    private final List<String> zzh;
    private final boolean zzi;
    private final Map<String, Boolean> zzj;
    private final String zzk;

    public zzbwj(Date object, int n, Set<String> object2, Location location, boolean bl, int n2, zzblv zzblv2, List<String> list, boolean bl2, int n3, String string) {
        this.zza = object;
        this.zzb = n;
        this.zzc = object2;
        this.zze = location;
        this.zzd = bl;
        this.zzf = n2;
        this.zzg = zzblv2;
        this.zzi = bl2;
        this.zzk = string;
        this.zzh = new ArrayList<String>();
        this.zzj = new HashMap<String, Boolean>();
        if (list == null) return;
        object = list.iterator();
        while (object.hasNext()) {
            object2 = (String)object.next();
            if (object2.startsWith("custom:")) {
                if (((String[])(object2 = object2.split(":", 3))).length != 3) continue;
                if ("true".equals(object2[2])) {
                    this.zzj.put(object2[1], true);
                    continue;
                }
                if (!"false".equals(object2[2])) continue;
                this.zzj.put(object2[1], false);
                continue;
            }
            this.zzh.add((String)object2);
        }
    }

    public final float getAdVolume() {
        return zzbhs.zze().zzh();
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zza;
    }

    @Deprecated
    public final int getGender() {
        return this.zzb;
    }

    public final Set<String> getKeywords() {
        return this.zzc;
    }

    public final Location getLocation() {
        return this.zze;
    }

    public final NativeAdOptions getNativeAdOptions() {
        zzblv zzblv2;
        block5: {
            NativeAdOptions.Builder builder;
            block8: {
                block6: {
                    zzbis zzbis2;
                    block7: {
                        block4: {
                            zzblv2 = this.zzg;
                            builder = new NativeAdOptions.Builder();
                            if (zzblv2 != null) break block4;
                            zzblv2 = builder.build();
                            break block5;
                        }
                        int n = zzblv2.zza;
                        if (n == 2) break block6;
                        if (n == 3) break block7;
                        if (n != 4) break block8;
                        builder.setRequestCustomMuteThisAd(zzblv2.zzg);
                        builder.setMediaAspectRatio(zzblv2.zzh);
                    }
                    if ((zzbis2 = zzblv2.zzf) != null) {
                        builder.setVideoOptions(new VideoOptions(zzbis2));
                    }
                }
                builder.setAdChoicesPlacement(zzblv2.zze);
            }
            builder.setReturnUrlsForImageAssets(zzblv2.zzb);
            builder.setImageOrientation(zzblv2.zzc);
            builder.setRequestMultipleImages(zzblv2.zzd);
            zzblv2 = builder.build();
        }
        return zzblv2;
    }

    public final com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions() {
        return zzblv.zza((zzblv)this.zzg);
    }

    public final boolean isAdMuted() {
        return zzbhs.zze().zzj();
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzi;
    }

    public final boolean isTesting() {
        return this.zzd;
    }

    public final boolean isUnifiedNativeAdRequested() {
        if (!this.zzh.contains("6")) return false;
        return true;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzf;
    }

    public final boolean zza() {
        if (!this.zzh.contains("3")) return false;
        return true;
    }

    public final Map<String, Boolean> zzb() {
        return this.zzj;
    }
}
