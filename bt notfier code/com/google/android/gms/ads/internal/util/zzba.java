/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbrk
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzvm
 *  com.google.android.gms.internal.ads.zzvv
 *  com.google.android.gms.internal.ads.zzvy
 *  com.google.android.gms.internal.ads.zzwc
 *  com.google.android.gms.internal.ads.zzwf
 *  com.google.android.gms.internal.ads.zzwl
 *  com.google.android.gms.internal.ads.zzwq
 *  com.google.android.gms.internal.ads.zzwr
 *  com.google.android.gms.internal.ads.zzwy
 *  com.google.android.gms.internal.ads.zzxd
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbrk;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzvm;
import com.google.android.gms.internal.ads.zzvv;
import com.google.android.gms.internal.ads.zzvy;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwl;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzwr;
import com.google.android.gms.internal.ads.zzwy;
import com.google.android.gms.internal.ads.zzxd;
import java.io.File;
import java.util.regex.Pattern;

public final class zzba
extends zzwr {
    private final Context zzc;

    private zzba(Context context, zzwq zzwq2) {
        super(zzwq2);
        this.zzc = context;
    }

    public static zzwf zzb(Context context) {
        zzba zzba2 = new zzba(context, (zzwq)new zzxd(null, null));
        context = new zzwf((zzvm)new zzwy(new File(context.getCacheDir(), "admob_volley"), 0x1400000), (zzvv)zzba2, 4);
        context.zza();
        return context;
    }

    public final zzvy zza(zzwc<?> object) throws zzwl {
        if (object.zzb() != 0) return super.zza(object);
        String string = object.zzi();
        Object object2 = zzbjl.zzcR;
        if (!Pattern.matches((String)zzbet.zzc().zzc((zzbjd)object2), string)) return super.zza(object);
        zzber.zza();
        if (!zzcgm.zzn((Context)this.zzc, (int)0xCC77C0)) return super.zza(object);
        object2 = new zzbrk(this.zzc).zza(object);
        if (object2 != null) {
            object = ((String)(object = String.valueOf(object.zzi()))).length() != 0 ? "Got gmscore asset response: ".concat((String)object) : new String("Got gmscore asset response: ");
            zze.zza((String)object);
            return object2;
        }
        object2 = String.valueOf(object.zzi());
        object2 = ((String)object2).length() != 0 ? "Failed to get gmscore asset response: ".concat((String)object2) : new String("Failed to get gmscore asset response: ");
        zze.zza((String)object2);
        return super.zza(object);
    }
}
