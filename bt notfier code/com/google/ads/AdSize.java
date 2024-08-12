/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.AdSize
 */
package com.google.ads;

import android.content.Context;

@Deprecated
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER;
    public static final int FULL_WIDTH = -1;
    public static final AdSize IAB_BANNER;
    public static final AdSize IAB_LEADERBOARD;
    public static final AdSize IAB_MRECT;
    public static final AdSize IAB_WIDE_SKYSCRAPER;
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    public static final AdSize SMART_BANNER;
    private final com.google.android.gms.ads.AdSize zza;

    static {
        SMART_BANNER = new AdSize(-1, -2, "mb");
        BANNER = new AdSize(320, 50, "mb");
        IAB_MRECT = new AdSize(300, 250, "as");
        IAB_BANNER = new AdSize(468, 60, "as");
        IAB_LEADERBOARD = new AdSize(728, 90, "as");
        IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
    }

    public AdSize(int n, int n2) {
        this(new com.google.android.gms.ads.AdSize(n, n2));
    }

    private AdSize(int n, int n2, String string) {
        this(new com.google.android.gms.ads.AdSize(n, n2));
    }

    public AdSize(com.google.android.gms.ads.AdSize adSize) {
        this.zza = adSize;
    }

    public boolean equals(Object object) {
        if (!(object instanceof AdSize)) {
            return false;
        }
        object = (AdSize)object;
        return this.zza.equals((Object)((AdSize)object).zza);
    }

    public AdSize findBestSize(AdSize ... adSizeArray) {
        AdSize adSize = null;
        if (adSizeArray == null) {
            return null;
        }
        int n = this.getWidth();
        int n2 = this.getHeight();
        int n3 = adSizeArray.length;
        float f = 0.0f;
        int n4 = 0;
        while (n4 < n3) {
            AdSize adSize2 = adSizeArray[n4];
            int n5 = adSize2.getWidth();
            int n6 = adSize2.getHeight();
            AdSize adSize3 = adSize;
            float f2 = f;
            if (this.isSizeAppropriate(n5, n6)) {
                float f3 = f2 = (float)(n5 * n6) / (float)(n * n2);
                if (f2 > 1.0f) {
                    f3 = 1.0f / f2;
                }
                adSize3 = adSize;
                f2 = f;
                if (f3 > f) {
                    adSize3 = adSize2;
                    f2 = f3;
                }
            }
            ++n4;
            adSize = adSize3;
            f = f2;
        }
        return adSize;
    }

    public int getHeight() {
        return this.zza.getHeight();
    }

    public int getHeightInPixels(Context context) {
        return this.zza.getHeightInPixels(context);
    }

    public int getWidth() {
        return this.zza.getWidth();
    }

    public int getWidthInPixels(Context context) {
        return this.zza.getWidthInPixels(context);
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zza.isAutoHeight();
    }

    public boolean isCustomAdSize() {
        return false;
    }

    public boolean isFullWidth() {
        return this.zza.isFullWidth();
    }

    public boolean isSizeAppropriate(int n, int n2) {
        int n3 = this.getWidth();
        int n4 = this.getHeight();
        float f = n;
        float f2 = n3;
        if (!(f <= f2 * 1.25f)) return false;
        if (!(f >= f2 * 0.8f)) return false;
        f = n2;
        f2 = n4;
        if (!(f <= 1.25f * f2)) return false;
        if (!(f >= f2 * 0.8f)) return false;
        return true;
    }

    public String toString() {
        return this.zza.toString();
    }
}
