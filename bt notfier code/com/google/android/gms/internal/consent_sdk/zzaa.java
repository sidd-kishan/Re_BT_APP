/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzbb
 *  com.google.android.gms.internal.consent_sdk.zzbx
 *  com.google.android.gms.internal.consent_sdk.zzby
 *  com.google.android.gms.internal.consent_sdk.zzi
 *  com.google.android.gms.internal.consent_sdk.zzk
 *  com.google.android.gms.internal.consent_sdk.zzx
 *  com.google.android.gms.internal.consent_sdk.zzy
 *  com.google.android.gms.internal.consent_sdk.zzz
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzbb;
import com.google.android.gms.internal.consent_sdk.zzbx;
import com.google.android.gms.internal.consent_sdk.zzby;
import com.google.android.gms.internal.consent_sdk.zzi;
import com.google.android.gms.internal.consent_sdk.zzk;
import com.google.android.gms.internal.consent_sdk.zzx;
import com.google.android.gms.internal.consent_sdk.zzy;
import com.google.android.gms.internal.consent_sdk.zzz;
import java.util.HashSet;
import java.util.Iterator;

final class zzaa {
    private final zzz zza;
    private final zzby zzb;
    private int zzc = 0;
    private int zzd = 0;

    zzaa(zzz zzz2, zzby zzby2) {
        this.zza = zzz2;
        this.zzb = zzby2;
    }

    final zzy zza() throws zzk {
        switch (zzx.zza[this.zzb.zza - 1]) {
            default: {
                throw new zzk(1, "Invalid response from server.");
            }
            case 7: {
                String string = String.valueOf(this.zzb.zzd);
                string = string.length() != 0 ? "Publisher misconfiguration: ".concat(string) : new String("Publisher misconfiguration: ");
                throw new zzk(3, string);
            }
            case 6: {
                String string = String.valueOf(this.zzb.zzd);
                string = string.length() != 0 ? "Invalid response from server: ".concat(string) : new String("Invalid response from server: ");
                throw new zzk(1, string);
            }
            case 5: {
                this.zzc = 3;
                this.zzd = 0;
                break;
            }
            case 4: {
                this.zzc = 3;
                this.zzd = 1;
                break;
            }
            case 3: {
                this.zzc = 3;
                this.zzd = 2;
                break;
            }
            case 2: {
                this.zzc = 2;
                this.zzd = 0;
                break;
            }
            case 1: {
                this.zzc = 1;
                this.zzd = 0;
            }
        }
        String string = this.zzb.zzb;
        zzbb zzbb2 = string == null ? null : new zzbb(this.zzb.zzc, string);
        zzz.zza((zzz)this.zza).zza(new HashSet(this.zzb.zze));
        Iterator iterator = this.zzb.zzf.iterator();
        while (iterator.hasNext()) {
            zzbx zzbx2;
            block12: {
                block10: {
                    block11: {
                        zzbx2 = (zzbx)iterator.next();
                        int n = zzx.zzb[zzbx2.zza - 1];
                        if (n == 1) break block10;
                        if (n == 2) break block11;
                        if (n != 3) break block10;
                        string = "clear";
                        break block12;
                    }
                    string = "write";
                    break block12;
                }
                string = null;
            }
            if (string == null) continue;
            zzz.zzc((zzz)this.zza).zza(string, zzbx2.zzb, new zzi[]{zzz.zzb((zzz)this.zza)});
        }
        return new zzy(this.zzc, this.zzd, zzbb2, null);
    }
}
