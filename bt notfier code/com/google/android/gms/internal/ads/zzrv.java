/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzow
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzow;

public final class zzrv {
    public final boolean zza;
    public final String zzb;
    public final zzow zzc;
    public final int zzd;
    public final byte[] zze;

    public zzrv(boolean bl, String string, int n, byte[] byArray, int n2, int n3, byte[] object) {
        int n4;
        block11: {
            int n5;
            block12: {
                int n6;
                block10: {
                    n6 = 0;
                    n5 = 1;
                    n4 = n == 0 ? 1 : 0;
                    boolean bl2 = object == null;
                    zzakt.zza((boolean)(n4 ^ bl2));
                    this.zza = bl;
                    this.zzb = string;
                    this.zzd = n;
                    this.zze = object;
                    if (string != null) break block10;
                    n4 = n5;
                    break block11;
                }
                switch (string.hashCode()) {
                    default: {
                        break;
                    }
                    case 3049895: {
                        if (!string.equals("cens")) break;
                        n = 1;
                        break block12;
                    }
                    case 3049879: {
                        if (!string.equals("cenc")) break;
                        n = n6;
                        break block12;
                    }
                    case 3046671: {
                        if (!string.equals("cbcs")) break;
                        n = 3;
                        break block12;
                    }
                    case 3046605: {
                        if (!string.equals("cbc1")) break;
                        n = 2;
                        break block12;
                    }
                }
                n = -1;
            }
            n4 = n5;
            if (n != 0) {
                n4 = n5;
                if (n != 1) {
                    if (n != 2 && n != 3) {
                        object = new StringBuilder(string.length() + 68);
                        ((StringBuilder)object).append("Unsupported protection scheme type '");
                        ((StringBuilder)object).append(string);
                        ((StringBuilder)object).append("'. Assuming AES-CTR crypto mode.");
                        Log.w((String)"TrackEncryptionBox", (String)((StringBuilder)object).toString());
                        n4 = n5;
                    } else {
                        n4 = 2;
                    }
                }
            }
        }
        this.zzc = new zzow(n4, byArray, n2, n3);
    }
}
