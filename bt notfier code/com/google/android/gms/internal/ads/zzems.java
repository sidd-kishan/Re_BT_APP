/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzcge
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzemr
 *  com.google.android.gms.internal.ads.zzemt
 *  com.google.android.gms.internal.ads.zzeoh
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzesd
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzcge;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzemr;
import com.google.android.gms.internal.ads.zzemt;
import com.google.android.gms.internal.ads.zzeoh;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzesd;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzems
implements zzery<zzemt> {
    private final zzery<zzesd> zza;
    private final zzfar zzb;
    private final Context zzc;
    private final zzcge zzd;

    public zzems(zzeoh<zzesd> zzeoh2, zzfar zzfar2, Context context, zzcge zzcge2) {
        this.zza = zzeoh2;
        this.zzb = zzfar2;
        this.zzc = context;
        this.zzd = zzcge2;
    }

    public final zzfsm<zzemt> zza() {
        return zzfsd.zzj((zzfsm)this.zza.zza(), (zzfln)new zzemr(this), (Executor)zzchg.zzf);
    }

    final /* synthetic */ zzemt zzb(zzesd object) {
        float f;
        int n;
        Object object2;
        int n2;
        int n3;
        int n4;
        int n5;
        Object object3;
        int n6;
        boolean bl;
        zzbdl zzbdl2 = this.zzb.zze;
        Object object4 = zzbdl2.zzg;
        if (object4 == null) {
            object = zzbdl2.zza;
            bl = zzbdl2.zzi;
        } else {
            n6 = ((zzbdl[])object4).length;
            object3 = null;
            n5 = 0;
            n4 = 0;
            n3 = 0;
            boolean bl2 = false;
            while (true) {
                object = object3;
                bl = bl2;
                if (n5 >= n6) break;
                object = object4[n5];
                bl = object.zzi;
                n2 = n4;
                object2 = object3;
                if (!bl) {
                    n2 = n4;
                    object2 = object3;
                    if (n4 == 0) {
                        object2 = object.zza;
                        n2 = 1;
                    }
                }
                n = n3;
                boolean bl3 = bl2;
                if (bl) {
                    if (n3 == 0) {
                        n = 1;
                        bl3 = true;
                    } else {
                        n = 1;
                        bl3 = bl2;
                    }
                }
                if (n2 != 0) {
                    object = object2;
                    bl = bl3;
                    if (n != 0) break;
                }
                ++n5;
                n4 = n2;
                n3 = n;
                object3 = object2;
                bl2 = bl3;
            }
        }
        object3 = this.zzc.getResources();
        if (object3 != null && (object3 = object3.getDisplayMetrics()) != null) {
            f = object3.density;
            n5 = object3.widthPixels;
            n2 = object3.heightPixels;
            object3 = this.zzd.zzp().zzz();
        } else {
            object3 = null;
            f = 0.0f;
            n5 = 0;
            n2 = 0;
        }
        object4 = new StringBuilder();
        object2 = zzbdl2.zzg;
        if (object2 == null) return new zzemt(zzbdl2, (String)object, bl, ((StringBuilder)object4).toString(), f, n5, n2, (String)object3, this.zzb.zzp);
        int n7 = ((Resources)object2).length;
        n4 = 0;
        for (n3 = 0; n3 < n7; ++n3) {
            Resources resources = object2[n3];
            if (resources.zzi) {
                n4 = 1;
                continue;
            }
            if (((StringBuilder)object4).length() != 0) {
                ((StringBuilder)object4).append("|");
            }
            n = n6 = resources.zze;
            if (n6 == -1) {
                n = f != 0.0f ? (int)((float)resources.zzf / f) : -1;
            }
            ((StringBuilder)object4).append(n);
            ((StringBuilder)object4).append("x");
            n = n6 = resources.zzb;
            if (n6 == -2) {
                n = f != 0.0f ? (int)((float)resources.zzc / f) : -2;
            }
            ((StringBuilder)object4).append(n);
        }
        if (n4 == 0) return new zzemt(zzbdl2, (String)object, bl, ((StringBuilder)object4).toString(), f, n5, n2, (String)object3, this.zzb.zzp);
        if (((StringBuilder)object4).length() != 0) {
            ((StringBuilder)object4).insert(0, "|");
        }
        ((StringBuilder)object4).insert(0, "320x50");
        return new zzemt(zzbdl2, (String)object, bl, ((StringBuilder)object4).toString(), f, n5, n2, (String)object3, this.zzb.zzp);
    }
}
