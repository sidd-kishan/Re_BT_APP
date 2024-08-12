/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzakv
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzfll
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzsr
 *  com.google.android.gms.internal.ads.zzsu
 *  com.google.android.gms.internal.ads.zzsx
 *  com.google.android.gms.internal.ads.zzsz
 *  com.google.android.gms.internal.ads.zzta
 *  com.google.android.gms.internal.ads.zztb
 *  com.google.android.gms.internal.ads.zztd
 *  com.google.android.gms.internal.ads.zztg
 *  com.google.android.gms.internal.ads.zztk
 *  com.google.android.gms.internal.ads.zztm
 *  com.google.android.gms.internal.ads.zztn
 *  com.google.android.gms.internal.ads.zzto
 *  com.google.android.gms.internal.ads.zztp
 *  com.google.android.gms.internal.ads.zztr
 *  com.google.android.gms.internal.ads.zzts
 *  com.google.android.gms.internal.ads.zzua
 *  com.google.android.gms.internal.ads.zzub
 *  com.google.android.gms.internal.ads.zzuc
 *  com.google.android.gms.internal.ads.zzul
 *  com.google.android.gms.internal.ads.zzum
 *  com.google.android.gms.internal.ads.zzuo
 *  com.google.android.gms.internal.ads.zzuq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzakv;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzfll;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzsr;
import com.google.android.gms.internal.ads.zzsu;
import com.google.android.gms.internal.ads.zzsx;
import com.google.android.gms.internal.ads.zzsz;
import com.google.android.gms.internal.ads.zzta;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zztd;
import com.google.android.gms.internal.ads.zztg;
import com.google.android.gms.internal.ads.zztk;
import com.google.android.gms.internal.ads.zztm;
import com.google.android.gms.internal.ads.zztn;
import com.google.android.gms.internal.ads.zzto;
import com.google.android.gms.internal.ads.zztp;
import com.google.android.gms.internal.ads.zztr;
import com.google.android.gms.internal.ads.zzts;
import com.google.android.gms.internal.ads.zzua;
import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzuc;
import com.google.android.gms.internal.ads.zzul;
import com.google.android.gms.internal.ads.zzum;
import com.google.android.gms.internal.ads.zzuo;
import com.google.android.gms.internal.ads.zzuq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzsy
implements zzum {
    private final List<zzafv> zza;

    public zzsy() {
        this(0);
    }

    public zzsy(int n) {
        zzfoj zzfoj2 = zzfoj.zzi();
        this.zza = zzfoj2;
    }

    private final zzuc zzb(zzul zzul2) {
        return new zzuc(this.zzd(zzul2));
    }

    private final zzuq zzc(zzul zzul2) {
        return new zzuq(this.zzd(zzul2));
    }

    private final List<zzafv> zzd(zzul object) {
        zzamf zzamf2 = new zzamf(object.zzd);
        object = this.zza;
        while (zzamf2.zzd() > 0) {
            int n = zzamf2.zzn();
            int n2 = zzamf2.zzn();
            int n3 = zzamf2.zzg();
            if (n == 134) {
                ArrayList<zzafv> arrayList = new ArrayList<zzafv>();
                int n4 = zzamf2.zzn();
                n = 0;
                while (true) {
                    Object object2;
                    object = arrayList;
                    if (n >= (n4 & 0x1F)) break;
                    String string = zzamf2.zzE(3, zzfll.zzc);
                    int n5 = zzamf2.zzn();
                    int n6 = n5 & 0x80;
                    if (n6 != 0) {
                        n5 &= 0x3F;
                        object = "application/cea-708";
                    } else {
                        object = "application/cea-608";
                        n5 = 1;
                    }
                    byte by = (byte)zzamf2.zzn();
                    zzamf2.zzk(1);
                    if (n6 != 0) {
                        n6 = zzakv.zza;
                        object2 = (by & 0x40) != 0 ? new byte[]{1} : new byte[]{0};
                        object2 = Collections.singletonList(object2);
                    } else {
                        object2 = null;
                    }
                    zzaft zzaft2 = new zzaft();
                    zzaft2.zzN((String)object);
                    zzaft2.zzG(string);
                    zzaft2.zzaf(n5);
                    zzaft2.zzP((List)object2);
                    arrayList.add(zzaft2.zzah());
                    ++n;
                }
            }
            zzamf2.zzh(n3 + n2);
        }
        return object;
    }

    public final zzuo zza(int n, zzul zzul2) {
        if (n == 2) return new zzts((zztb)new zztd(this.zzc(zzul2)));
        if (n == 3) return new zzts((zztb)new zztp(zzul2.zzb));
        if (n == 4) return new zzts((zztb)new zztp(zzul2.zzb));
        if (n == 21) return new zzts((zztb)new zztn());
        if (n == 27) return new zzts((zztb)new zztk(this.zzb(zzul2), false, false));
        if (n == 36) return new zzts((zztb)new zztm(this.zzb(zzul2)));
        if (n == 89) return new zzts((zztb)new zzta(zzul2.zzc));
        if (n == 129) return new zzts((zztb)new zzsr(zzul2.zzb));
        if (n == 138) return new zzts((zztb)new zzsz(zzul2.zzb));
        if (n == 172) return new zzts((zztb)new zzsu(zzul2.zzb));
        if (n == 257) return new zzub((zzua)new zztr("application/vnd.dvb.ait"));
        if (n == 134) return new zzub((zzua)new zztr("application/x-scte35"));
        if (n == 135) return new zzts((zztb)new zzsr(zzul2.zzb));
        switch (n) {
            default: {
                return null;
            }
            case 17: {
                return new zzts((zztb)new zzto(zzul2.zzb));
            }
            case 16: {
                return new zzts((zztb)new zztg(this.zzc(zzul2)));
            }
            case 15: 
        }
        return new zzts((zztb)new zzsx(false, zzul2.zzb));
    }
}
