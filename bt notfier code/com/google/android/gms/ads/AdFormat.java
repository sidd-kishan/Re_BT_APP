/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.ads;

public final class AdFormat
extends Enum<AdFormat> {
    public static final /* enum */ AdFormat BANNER;
    public static final /* enum */ AdFormat INTERSTITIAL;
    public static final /* enum */ AdFormat NATIVE;
    public static final /* enum */ AdFormat REWARDED;
    public static final /* enum */ AdFormat REWARDED_INTERSTITIAL;
    public static final /* enum */ AdFormat UNKNOWN;
    private static final AdFormat[] zza;

    static {
        AdFormat adFormat;
        BANNER = new AdFormat();
        INTERSTITIAL = new AdFormat();
        REWARDED = new AdFormat();
        REWARDED_INTERSTITIAL = new AdFormat();
        NATIVE = new AdFormat();
        UNKNOWN = adFormat = new AdFormat();
        zza = new AdFormat[]{BANNER, INTERSTITIAL, REWARDED, REWARDED_INTERSTITIAL, NATIVE, adFormat};
    }

    public static AdFormat valueOf(String string) {
        return Enum.valueOf(AdFormat.class, string);
    }

    public static AdFormat[] values() {
        return (AdFormat[])zza.clone();
    }
}
