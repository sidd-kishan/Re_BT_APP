/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.util.Base64
 *  com.google.android.gms.internal.ads.zzag
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzak
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzfll
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzak;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzfll;
import java.io.IOException;
import java.net.URLDecoder;

public final class zzkn
extends zzag {
    private zzan zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzkn() {
        super(false);
    }

    public final int zzg(byte[] byArray, int n, int n2) {
        if (n2 == 0) {
            return 0;
        }
        int n3 = this.zzd;
        if (n3 == 0) {
            return -1;
        }
        n2 = Math.min(n2, n3);
        System.arraycopy(zzamq.zzd((Object)this.zzb), this.zzc, byArray, n, n2);
        this.zzc += n2;
        this.zzd -= n2;
        this.zzd(n2);
        return n2;
    }

    public final long zzh(zzan object) throws IOException {
        int n;
        this.zzb((zzan)object);
        this.zza = object;
        Object object2 = ((zzan)object).zza;
        Object object3 = object2.getScheme();
        boolean bl = "data".equals(object3);
        object3 = String.valueOf(object3);
        object3 = object3.length() != 0 ? "Unsupported scheme: ".concat((String)object3) : new String("Unsupported scheme: ");
        zzakt.zzb((boolean)bl, (Object)object3);
        object3 = zzamq.zzt((String)object2.getSchemeSpecificPart(), (String)",");
        if (((String[])object3).length != 2) {
            object = String.valueOf(object2);
            String.valueOf(object).length();
            throw zzaha.zza((String)"Unexpected URI format: ".concat(String.valueOf(object)), null);
        }
        object2 = object3[1];
        if (object3[0].contains(";base64")) {
            try {
                this.zzb = Base64.decode((String)object2, (int)0);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object = String.valueOf(object2);
                object = ((String)object).length() != 0 ? "Error while parsing Base64 encoded string: ".concat((String)object) : new String("Error while parsing Base64 encoded string: ");
                throw zzaha.zza((String)object, (Throwable)illegalArgumentException);
            }
        } else {
            this.zzb = zzamq.zzs((String)URLDecoder.decode((String)object2, zzfll.zza.name()));
        }
        long l = ((zzan)object).zzf;
        int n2 = this.zzb.length;
        if (l > (long)n2) {
            this.zzb = null;
            throw new zzak(2008);
        }
        this.zzc = n = (int)l;
        this.zzd = n = n2 - n;
        l = ((zzan)object).zzg;
        if (l != -1L) {
            this.zzd = (int)Math.min((long)n, l);
        }
        this.zzc((zzan)object);
        l = ((zzan)object).zzg;
        if (l == -1L) return this.zzd;
        return l;
    }

    public final Uri zzi() {
        zzan zzan2 = this.zza;
        if (zzan2 == null) return null;
        return zzan2.zza;
    }

    public final void zzj() {
        if (this.zzb != null) {
            this.zzb = null;
            this.zze();
        }
        this.zza = null;
    }
}
