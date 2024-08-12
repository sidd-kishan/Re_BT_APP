/*
 * Decompiled with CFR 0.152.
 */
package com.google.ads;

public static final class AdRequest.Gender
extends Enum<AdRequest.Gender> {
    public static final /* enum */ AdRequest.Gender FEMALE;
    public static final /* enum */ AdRequest.Gender MALE;
    public static final /* enum */ AdRequest.Gender UNKNOWN;
    private static final AdRequest.Gender[] zza;

    static {
        AdRequest.Gender gender;
        UNKNOWN = new AdRequest.Gender();
        MALE = new AdRequest.Gender();
        FEMALE = gender = new AdRequest.Gender();
        zza = new AdRequest.Gender[]{UNKNOWN, MALE, gender};
    }

    public static AdRequest.Gender valueOf(String string) {
        return Enum.valueOf(AdRequest.Gender.class, string);
    }

    public static AdRequest.Gender[] values() {
        return (AdRequest.Gender[])zza.clone();
    }
}
