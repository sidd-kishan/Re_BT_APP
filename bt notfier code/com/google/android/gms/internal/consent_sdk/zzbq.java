/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzbs
 *  com.google.android.gms.internal.consent_sdk.zzbu
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzbs;
import com.google.android.gms.internal.consent_sdk.zzbu;

final class zzbq {
    static final int[] zza;
    static final int[] zzb;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[zzbs.values().length];
        zzb = nArray;
        try {
            nArray[zzbs.zza.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            zzbq.zzb[zzbs.zzb.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            zzbq.zzb[zzbs.zzc.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            zzbq.zzb[zzbs.zzd.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        nArray = new int[zzbu.zza().length];
        zza = nArray;
        try {
            nArray[zzbu.zza - 1] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            zzbq.zza[zzbu.zzb - 1] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            zzbq.zza[zzbu.zzc - 1] = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
