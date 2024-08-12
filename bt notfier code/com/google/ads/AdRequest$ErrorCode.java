/*
 * Decompiled with CFR 0.152.
 */
package com.google.ads;

public static final class AdRequest.ErrorCode
extends Enum<AdRequest.ErrorCode> {
    public static final /* enum */ AdRequest.ErrorCode INTERNAL_ERROR;
    public static final /* enum */ AdRequest.ErrorCode INVALID_REQUEST;
    public static final /* enum */ AdRequest.ErrorCode NETWORK_ERROR;
    public static final /* enum */ AdRequest.ErrorCode NO_FILL;
    private static final AdRequest.ErrorCode[] zzb;
    private final String zza;

    static {
        AdRequest.ErrorCode errorCode;
        INVALID_REQUEST = new AdRequest.ErrorCode("Invalid Ad request.");
        NO_FILL = new AdRequest.ErrorCode("Ad request successful, but no ad returned due to lack of ad inventory.");
        NETWORK_ERROR = new AdRequest.ErrorCode("A network error occurred.");
        INTERNAL_ERROR = errorCode = new AdRequest.ErrorCode("There was an internal error.");
        zzb = new AdRequest.ErrorCode[]{INVALID_REQUEST, NO_FILL, NETWORK_ERROR, errorCode};
    }

    private AdRequest.ErrorCode(String string2) {
        this.zza = string2;
    }

    public static AdRequest.ErrorCode valueOf(String string) {
        return Enum.valueOf(AdRequest.ErrorCode.class, string);
    }

    public static AdRequest.ErrorCode[] values() {
        return (AdRequest.ErrorCode[])zzb.clone();
    }

    public String toString() {
        return this.zza;
    }
}
