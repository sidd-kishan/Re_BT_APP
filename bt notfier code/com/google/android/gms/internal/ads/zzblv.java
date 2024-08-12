/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.ads.VideoOptions
 *  com.google.android.gms.ads.formats.NativeAdOptions
 *  com.google.android.gms.ads.nativead.NativeAdOptions
 *  com.google.android.gms.ads.nativead.NativeAdOptions$Builder
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzblw
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzblw;

public final class zzblv
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzblv> CREATOR = new zzblw();
    public final int zza;
    public final boolean zzb;
    public final int zzc;
    public final boolean zzd;
    public final int zze;
    public final zzbis zzf;
    public final boolean zzg;
    public final int zzh;

    public zzblv(int n, boolean bl, int n2, boolean bl2, int n3, zzbis zzbis2, boolean bl3, int n4) {
        this.zza = n;
        this.zzb = bl;
        this.zzc = n2;
        this.zzd = bl2;
        this.zze = n3;
        this.zzf = zzbis2;
        this.zzg = bl3;
        this.zzh = n4;
    }

    public zzblv(NativeAdOptions nativeAdOptions) {
        boolean bl = nativeAdOptions.shouldReturnUrlsForImageAssets();
        int n = nativeAdOptions.getImageOrientation();
        boolean bl2 = nativeAdOptions.shouldRequestMultipleImages();
        int n2 = nativeAdOptions.getAdChoicesPlacement();
        zzbis zzbis2 = nativeAdOptions.getVideoOptions() != null ? new zzbis(nativeAdOptions.getVideoOptions()) : null;
        this(4, bl, n, bl2, n2, zzbis2, nativeAdOptions.zza(), nativeAdOptions.getMediaAspectRatio());
    }

    public static com.google.android.gms.ads.nativead.NativeAdOptions zza(zzblv zzblv2) {
        NativeAdOptions.Builder builder;
        block7: {
            block5: {
                zzbis zzbis2;
                block6: {
                    builder = new NativeAdOptions.Builder();
                    if (zzblv2 == null) {
                        return builder.build();
                    }
                    int n = zzblv2.zza;
                    if (n == 2) break block5;
                    if (n == 3) break block6;
                    if (n != 4) break block7;
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
        builder.setRequestMultipleImages(zzblv2.zzd);
        return builder.build();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)2, (boolean)this.zzb);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zzc);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)4, (boolean)this.zzd);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)5, (int)this.zze);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)6, (Parcelable)this.zzf, (int)n, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)7, (boolean)this.zzg);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)8, (int)this.zzh);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
