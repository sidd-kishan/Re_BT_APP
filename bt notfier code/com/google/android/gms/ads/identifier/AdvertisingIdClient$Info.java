/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.ads.identifier;

public static final class AdvertisingIdClient.Info {
    private final String zzq;
    private final boolean zzr;

    public AdvertisingIdClient.Info(String string, boolean bl) {
        this.zzq = string;
        this.zzr = bl;
    }

    public final String getId() {
        return this.zzq;
    }

    public final boolean isLimitAdTrackingEnabled() {
        return this.zzr;
    }

    public final String toString() {
        String string = this.zzq;
        boolean bl = this.zzr;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 7);
        stringBuilder.append("{");
        stringBuilder.append(string);
        stringBuilder.append("}");
        stringBuilder.append(bl);
        return stringBuilder.toString();
    }
}
