/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftg
 *  com.google.android.gms.internal.ads.zzftj
 *  com.google.android.gms.internal.ads.zzfum
 *  com.google.android.gms.internal.ads.zzfuo
 *  com.google.android.gms.internal.ads.zzfwb
 *  com.google.android.gms.internal.ads.zzfwr
 *  com.google.android.gms.internal.ads.zzfxo
 *  com.google.android.gms.internal.ads.zzfxr
 *  com.google.android.gms.internal.ads.zzfxt
 *  com.google.android.gms.internal.ads.zzfxu
 *  com.google.android.gms.internal.ads.zzfyl
 *  com.google.android.gms.internal.ads.zzfym
 *  com.google.android.gms.internal.ads.zzfyp
 *  com.google.android.gms.internal.ads.zzfyx
 *  com.google.android.gms.internal.ads.zzfyy
 *  com.google.android.gms.internal.ads.zzfzb
 *  com.google.android.gms.internal.ads.zzgai
 *  com.google.android.gms.internal.ads.zzgau
 *  com.google.android.gms.internal.ads.zzgct
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftg;
import com.google.android.gms.internal.ads.zzftj;
import com.google.android.gms.internal.ads.zzfum;
import com.google.android.gms.internal.ads.zzfuo;
import com.google.android.gms.internal.ads.zzfwb;
import com.google.android.gms.internal.ads.zzfwr;
import com.google.android.gms.internal.ads.zzfxo;
import com.google.android.gms.internal.ads.zzfxr;
import com.google.android.gms.internal.ads.zzfxt;
import com.google.android.gms.internal.ads.zzfxu;
import com.google.android.gms.internal.ads.zzfyl;
import com.google.android.gms.internal.ads.zzfym;
import com.google.android.gms.internal.ads.zzfyp;
import com.google.android.gms.internal.ads.zzfyx;
import com.google.android.gms.internal.ads.zzfyy;
import com.google.android.gms.internal.ads.zzfzb;
import com.google.android.gms.internal.ads.zzgai;
import com.google.android.gms.internal.ads.zzgau;
import com.google.android.gms.internal.ads.zzgct;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import java.security.GeneralSecurityException;
import java.util.Arrays;

final class zzfwq
implements zzgct {
    private final String zza;
    private final int zzb;
    private zzfym zzc;
    private zzfxo zzd;
    private int zze;
    private zzfyy zzf;

    zzfwq(zzgau object) throws GeneralSecurityException {
        String string;
        this.zza = string = object.zza();
        if (string.equals(zzfuo.zzb)) {
            try {
                string = zzfyp.zzc((zzgex)object.zzc(), (zzgfm)zzgfm.zza());
                this.zzc = (zzfym)zzfum.zzh((zzgau)object);
                this.zzb = string.zza();
                return;
            }
            catch (zzggm zzggm2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", zzggm2);
            }
        }
        if (this.zza.equals(zzfuo.zza)) {
            try {
                string = zzfxr.zzd((zzgex)object.zzc(), (zzgfm)zzgfm.zza());
                this.zzd = (zzfxo)zzfum.zzh((zzgau)object);
                this.zze = string.zza().zzc();
                int n = string.zzc().zzc();
                this.zzb = this.zze + n;
                return;
            }
            catch (zzggm zzggm3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", zzggm3);
            }
        }
        if (this.zza.equals(zzfwb.zza)) {
            try {
                string = zzfzb.zzc((zzgex)object.zzc(), (zzgfm)zzgfm.zza());
                this.zzf = (zzfyy)zzfum.zzh((zzgau)object);
                this.zzb = string.zza();
                return;
            }
            catch (zzggm zzggm4) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", zzggm4);
            }
        }
        object = String.valueOf(this.zza);
        object = ((String)object).length() != 0 ? "unsupported AEAD DEM key type: ".concat((String)object) : new String("unsupported AEAD DEM key type: ");
        throw new GeneralSecurityException((String)object);
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzfwr zzb(byte[] object) throws GeneralSecurityException {
        if (((byte[])object).length != this.zzb) throw new GeneralSecurityException("Symmetric key has incorrect length");
        if (this.zza.equals(zzfuo.zzb)) {
            zzfyl zzfyl2 = zzfym.zze();
            zzfyl2.zzai((zzgga)this.zzc);
            zzfyl2.zzb(zzgex.zzs((byte[])object, (int)0, (int)this.zzb));
            object = (zzfym)zzfyl2.zzah();
            return new zzfwr((zzftg)zzfum.zzi((String)this.zza, (zzghi)object, zzftg.class));
        }
        if (this.zza.equals(zzfuo.zza)) {
            Object object2 = Arrays.copyOfRange(object, 0, this.zze);
            object = Arrays.copyOfRange(object, this.zze, this.zzb);
            zzfxt zzfxt2 = zzfxu.zzf();
            zzfxt2.zzai((zzgga)this.zzd.zzc());
            zzfxt2.zzc(zzgex.zzt((byte[])object2));
            object2 = (zzfxu)zzfxt2.zzah();
            zzfxt2 = zzgai.zzf();
            zzfxt2.zzai((zzgga)this.zzd.zzd());
            zzfxt2.zzc(zzgex.zzt((byte[])object));
            zzfxt2 = (zzgai)zzfxt2.zzah();
            object = zzfxo.zzf();
            object.zza(this.zzd.zza());
            object.zzb((zzfxu)object2);
            object.zzc((zzgai)zzfxt2);
            object = (zzfxo)object.zzah();
            return new zzfwr((zzftg)zzfum.zzi((String)this.zza, (zzghi)object, zzftg.class));
        }
        if (!this.zza.equals(zzfwb.zza)) throw new GeneralSecurityException("unknown DEM key type");
        zzfyx zzfyx2 = zzfyy.zze();
        zzfyx2.zzai((zzgga)this.zzf);
        zzfyx2.zzb(zzgex.zzs((byte[])object, (int)0, (int)this.zzb));
        object = (zzfyy)zzfyx2.zzah();
        return new zzfwr((zzftj)zzfum.zzi((String)this.zza, (zzghi)object, zzftj.class));
    }
}
