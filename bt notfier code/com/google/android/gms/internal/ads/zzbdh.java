/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzbdg
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbdg;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbdh {
    private Bundle zza = new Bundle();
    private List<String> zzb = new ArrayList<String>();
    private boolean zzc = false;
    private int zzd = -1;
    private final Bundle zze = new Bundle();
    private final Bundle zzf = new Bundle();
    private final List<String> zzg = new ArrayList<String>();
    private int zzh = -1;
    private String zzi = null;
    private final List<String> zzj = new ArrayList<String>();
    private int zzk = 60000;

    public final zzbdg zza() {
        return new zzbdg(8, -1L, this.zza, -1, this.zzb, this.zzc, this.zzd, false, null, null, null, null, this.zze, this.zzf, this.zzg, null, null, false, null, this.zzh, this.zzi, this.zzj, this.zzk, null);
    }

    public final zzbdh zzb(Bundle bundle) {
        this.zza = bundle;
        return this;
    }

    public final zzbdh zzc(List<String> list) {
        this.zzb = list;
        return this;
    }

    public final zzbdh zzd(boolean bl) {
        this.zzc = bl;
        return this;
    }

    public final zzbdh zze(int n) {
        this.zzd = n;
        return this;
    }

    public final zzbdh zzf(int n) {
        this.zzh = n;
        return this;
    }

    public final zzbdh zzg(String string) {
        this.zzi = string;
        return this;
    }

    public final zzbdh zzh(int n) {
        this.zzk = n;
        return this;
    }
}
