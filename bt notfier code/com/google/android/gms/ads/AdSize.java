/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcelable$Creator
 *  android.util.DisplayMetrics
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads;

import android.content.Context;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgt;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FLUID;
    public static final AdSize FULL_BANNER;
    public static final int FULL_WIDTH = -1;
    public static final AdSize INVALID;
    public static final AdSize LARGE_BANNER;
    public static final AdSize LEADERBOARD;
    public static final AdSize MEDIUM_RECTANGLE;
    public static final AdSize SEARCH;
    @Deprecated
    public static final AdSize SMART_BANNER;
    public static final AdSize WIDE_SKYSCRAPER;
    public static final AdSize zza;
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;
    private boolean zzh;
    private int zzi;

    static {
        FULL_BANNER = new AdSize(468, 60, "468x60_as");
        LARGE_BANNER = new AdSize(320, 100, "320x100_as");
        LEADERBOARD = new AdSize(728, 90, "728x90_as");
        MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
        WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
        SMART_BANNER = new AdSize(-1, -2, "smart_banner");
        FLUID = new AdSize(-3, -4, "fluid");
        INVALID = new AdSize(0, 0, "invalid");
        zza = new AdSize(50, 50, "50x50_mb");
        SEARCH = new AdSize(-3, 0, "search_v2");
    }

    public AdSize(int n, int n2) {
        String string = n == -1 ? "FULL" : String.valueOf(n);
        String string2 = n2 == -2 ? "AUTO" : String.valueOf(n2);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 4 + String.valueOf(string2).length());
        stringBuilder.append(string);
        stringBuilder.append("x");
        stringBuilder.append(string2);
        stringBuilder.append("_as");
        this(n, n2, stringBuilder.toString());
    }

    AdSize(int n, int n2, String charSequence) {
        if (n < 0 && n != -1 && n != -3) {
            charSequence = new StringBuilder(37);
            ((StringBuilder)charSequence).append("Invalid width for AdSize: ");
            ((StringBuilder)charSequence).append(n);
            throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
        }
        if (n2 < 0 && n2 != -2 && n2 != -4) {
            charSequence = new StringBuilder(38);
            ((StringBuilder)charSequence).append("Invalid height for AdSize: ");
            ((StringBuilder)charSequence).append(n2);
            throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
        }
        this.zzb = n;
        this.zzc = n2;
        this.zzd = charSequence;
    }

    public static AdSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(Context object, int n) {
        object = zzcgm.zzh((Context)object, (int)n, (int)50, (int)0);
        object.zze = true;
        return object;
    }

    public static AdSize getCurrentOrientationInlineAdaptiveBannerAdSize(Context object, int n) {
        int n2 = zzcgm.zzj((Context)object, (int)0);
        if (n2 == -1) {
            return INVALID;
        }
        object = new AdSize(n, 0);
        object.zzg = n2;
        object.zzf = true;
        return object;
    }

    public static AdSize getCurrentOrientationInterscrollerAdSize(Context context, int n) {
        return AdSize.zzj(n, zzcgm.zzj((Context)context, (int)0));
    }

    public static AdSize getInlineAdaptiveBannerAdSize(int n, int n2) {
        AdSize adSize = new AdSize(n, 0);
        adSize.zzg = n2;
        adSize.zzf = true;
        if (n2 >= 32) return adSize;
        StringBuilder stringBuilder = new StringBuilder(129);
        stringBuilder.append("The maximum height set for the inline adaptive ad size was ");
        stringBuilder.append(n2);
        stringBuilder.append(" dp, which is below the minimum recommended value of 32 dp.");
        zzcgt.zzi((String)stringBuilder.toString());
        return adSize;
    }

    public static AdSize getLandscapeAnchoredAdaptiveBannerAdSize(Context object, int n) {
        object = zzcgm.zzh((Context)object, (int)n, (int)50, (int)2);
        object.zze = true;
        return object;
    }

    public static AdSize getLandscapeInlineAdaptiveBannerAdSize(Context object, int n) {
        int n2 = zzcgm.zzj((Context)object, (int)2);
        object = new AdSize(n, 0);
        if (n2 == -1) {
            return INVALID;
        }
        object.zzg = n2;
        object.zzf = true;
        return object;
    }

    public static AdSize getLandscapeInterscrollerAdSize(Context context, int n) {
        return AdSize.zzj(n, zzcgm.zzj((Context)context, (int)2));
    }

    public static AdSize getPortraitAnchoredAdaptiveBannerAdSize(Context object, int n) {
        object = zzcgm.zzh((Context)object, (int)n, (int)50, (int)1);
        object.zze = true;
        return object;
    }

    public static AdSize getPortraitInlineAdaptiveBannerAdSize(Context object, int n) {
        int n2 = zzcgm.zzj((Context)object, (int)1);
        object = new AdSize(n, 0);
        if (n2 == -1) {
            return INVALID;
        }
        object.zzg = n2;
        object.zzf = true;
        return object;
    }

    public static AdSize getPortraitInterscrollerAdSize(Context context, int n) {
        return AdSize.zzj(n, zzcgm.zzj((Context)context, (int)1));
    }

    private static AdSize zzj(int n, int n2) {
        if (n2 == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(n, 0);
        adSize.zzi = n2;
        adSize.zzh = true;
        return adSize;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof AdSize)) {
            return false;
        }
        object = (AdSize)object;
        if (this.zzb != ((AdSize)object).zzb) return false;
        if (this.zzc != ((AdSize)object).zzc) return false;
        if (!this.zzd.equals(((AdSize)object).zzd)) return false;
        return true;
    }

    public int getHeight() {
        return this.zzc;
    }

    public int getHeightInPixels(Context context) {
        int n = this.zzc;
        if (n == -4) return -1;
        if (n == -3) return -1;
        if (n == -2) return zzbdl.zza((DisplayMetrics)context.getResources().getDisplayMetrics());
        zzber.zza();
        return zzcgm.zzs((Context)context, (int)this.zzc);
    }

    public int getWidth() {
        return this.zzb;
    }

    public int getWidthInPixels(Context context) {
        int n = this.zzb;
        if (n == -3) return -1;
        if (n != -1) {
            zzber.zza();
            return zzcgm.zzs((Context)context, (int)this.zzb);
        }
        context = context.getResources().getDisplayMetrics();
        Parcelable.Creator creator = zzbdl.CREATOR;
        return context.widthPixels;
    }

    public int hashCode() {
        return this.zzd.hashCode();
    }

    public boolean isAutoHeight() {
        if (this.zzc != -2) return false;
        return true;
    }

    public boolean isFluid() {
        if (this.zzb != -3) return false;
        if (this.zzc != -4) return false;
        return true;
    }

    public boolean isFullWidth() {
        if (this.zzb != -1) return false;
        return true;
    }

    public String toString() {
        return this.zzd;
    }

    final boolean zza() {
        return this.zze;
    }

    final boolean zzb() {
        return this.zzf;
    }

    final void zzc(boolean bl) {
        this.zzf = true;
    }

    final void zzd(int n) {
        this.zzg = n;
    }

    final int zze() {
        return this.zzg;
    }

    final boolean zzf() {
        return this.zzh;
    }

    final void zzg(boolean bl) {
        this.zzh = true;
    }

    final int zzh() {
        return this.zzi;
    }

    final void zzi(int n) {
        this.zzi = n;
    }
}
