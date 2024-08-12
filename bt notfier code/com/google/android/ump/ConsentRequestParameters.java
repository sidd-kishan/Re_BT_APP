/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.ump.ConsentDebugSettings
 *  com.google.android.ump.ConsentRequestParameters$Builder
 *  com.google.android.ump.zzb
 */
package com.google.android.ump;

import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.zzb;

/*
 * Exception performing whole class analysis ignored.
 */
public class ConsentRequestParameters {
    private final boolean zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final ConsentDebugSettings zzf;

    private ConsentRequestParameters(Builder builder) {
        this.zza = Builder.zza((Builder)builder);
        this.zzc = null;
        this.zzb = 0;
        this.zzd = null;
        this.zze = Builder.zzb((Builder)builder);
        this.zzf = Builder.zzc((Builder)builder);
    }

    /* synthetic */ ConsentRequestParameters(Builder builder, zzb zzb2) {
        this(builder);
    }

    public ConsentDebugSettings getConsentDebugSettings() {
        return this.zzf;
    }

    public boolean isTagForUnderAgeOfConsent() {
        return this.zza;
    }

    public final String zza() {
        return this.zze;
    }
}
