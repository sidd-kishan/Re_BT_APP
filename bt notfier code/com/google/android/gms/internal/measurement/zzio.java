/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzhe
 *  com.google.android.gms.internal.measurement.zzhg
 *  com.google.android.gms.internal.measurement.zzhm
 *  com.google.android.gms.internal.measurement.zzhr
 *  com.google.android.gms.internal.measurement.zzhz
 *  com.google.android.gms.internal.measurement.zzik
 *  com.google.android.gms.internal.measurement.zzim
 *  com.google.android.gms.internal.measurement.zzin
 *  com.google.android.gms.internal.measurement.zzir
 *  com.google.android.gms.internal.measurement.zzis
 *  com.google.android.gms.internal.measurement.zzit
 *  com.google.android.gms.internal.measurement.zziu
 *  com.google.android.gms.internal.measurement.zziw
 *  com.google.android.gms.internal.measurement.zziz
 *  com.google.android.gms.internal.measurement.zzja
 *  com.google.android.gms.internal.measurement.zzjb
 *  com.google.android.gms.internal.measurement.zzjc
 *  com.google.android.gms.internal.measurement.zzjh
 *  com.google.android.gms.internal.measurement.zzji
 *  com.google.android.gms.internal.measurement.zzjj
 *  com.google.android.gms.internal.measurement.zzjv
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zzhg;
import com.google.android.gms.internal.measurement.zzhm;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zzim;
import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzir;
import com.google.android.gms.internal.measurement.zzis;
import com.google.android.gms.internal.measurement.zzit;
import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zziw;
import com.google.android.gms.internal.measurement.zziz;
import com.google.android.gms.internal.measurement.zzja;
import com.google.android.gms.internal.measurement.zzjb;
import com.google.android.gms.internal.measurement.zzjc;
import com.google.android.gms.internal.measurement.zzjh;
import com.google.android.gms.internal.measurement.zzji;
import com.google.android.gms.internal.measurement.zzjj;
import com.google.android.gms.internal.measurement.zzjv;

final class zzio
implements zzji {
    private static final zziu zzb = new zzim();
    private final zziu zza;

    public zzio() {
        zziu zziu2;
        zzhm zzhm2 = zzhm.zza();
        try {
            zziu2 = (zziu)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        }
        catch (Exception exception) {
            zziu2 = zzb;
        }
        zziu2 = new zzin(new zziu[]{zzhm2, zziu2});
        zzhz.zzb((Object)zziu2, (String)"messageInfoFactory");
        this.zza = zziu2;
    }

    private static boolean zzb(zzit zzit2) {
        if (zzit2.zzc() != 1) return false;
        return true;
    }

    public final <T> zzjh<T> zza(Class<T> zziz2) {
        zzjj.zza(zziz2);
        zzit zzit2 = this.zza.zzc(zziz2);
        if (zzit2.zza()) {
            if (!zzhr.class.isAssignableFrom((Class<?>)zziz2)) return zzja.zzf((zzjv)zzjj.zzA(), (zzhe)zzhg.zzb(), (zziw)zzit2.zzb());
            return zzja.zzf((zzjv)zzjj.zzC(), (zzhe)zzhg.zza(), (zziw)zzit2.zzb());
        }
        zziz2 = zzhr.class.isAssignableFrom((Class<?>)zziz2) ? (zzio.zzb(zzit2) ? zziz.zzk(zziz2, (zzit)zzit2, (zzjb)zzjc.zzb(), (zzik)zzik.zzd(), (zzjv)zzjj.zzC(), (zzhe)zzhg.zza(), (zzir)zzis.zzb()) : zziz.zzk(zziz2, (zzit)zzit2, (zzjb)zzjc.zzb(), (zzik)zzik.zzd(), (zzjv)zzjj.zzC(), null, (zzir)zzis.zzb())) : (zzio.zzb(zzit2) ? zziz.zzk(zziz2, (zzit)zzit2, (zzjb)zzjc.zza(), (zzik)zzik.zzc(), (zzjv)zzjj.zzA(), (zzhe)zzhg.zzb(), (zzir)zzis.zza()) : zziz.zzk(zziz2, (zzit)zzit2, (zzjb)zzjc.zza(), (zzik)zzik.zzc(), (zzjv)zzjj.zzB(), null, (zzir)zzis.zza()));
        return zziz2;
    }
}
