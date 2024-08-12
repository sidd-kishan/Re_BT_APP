/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzfgc
 *  com.google.android.gms.internal.ads.zzfgd
 *  com.google.android.gms.internal.ads.zzfge
 *  com.google.android.gms.internal.ads.zzfgf
 *  com.google.android.gms.internal.ads.zzfgi
 *  com.google.android.gms.internal.ads.zzfgr
 *  com.google.android.gms.internal.ads.zzfgu
 *  com.google.android.gms.internal.ads.zzfgx
 *  com.google.android.gms.internal.ads.zzfgy
 *  com.google.android.gms.internal.ads.zzfhe
 *  com.google.android.gms.internal.ads.zzfhf
 *  com.google.android.gms.internal.ads.zzfhh
 *  com.google.android.gms.internal.ads.zzfib
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzfgc;
import com.google.android.gms.internal.ads.zzfgd;
import com.google.android.gms.internal.ads.zzfge;
import com.google.android.gms.internal.ads.zzfgf;
import com.google.android.gms.internal.ads.zzfgi;
import com.google.android.gms.internal.ads.zzfgr;
import com.google.android.gms.internal.ads.zzfgu;
import com.google.android.gms.internal.ads.zzfgx;
import com.google.android.gms.internal.ads.zzfgy;
import com.google.android.gms.internal.ads.zzfhe;
import com.google.android.gms.internal.ads.zzfhf;
import com.google.android.gms.internal.ads.zzfhh;
import com.google.android.gms.internal.ads.zzfib;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public final class zzfgg
extends zzfgc {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final zzfge zzb;
    private final zzfgd zzc;
    private final List<zzfgu> zzd = new ArrayList<zzfgu>();
    private zzfib zze;
    private zzfhe zzf;
    private boolean zzg = false;
    private boolean zzh = false;
    private final String zzi;

    zzfgg(zzfgd zzfgd2, zzfge zzfge2) {
        this.zzc = zzfgd2;
        this.zzb = zzfge2;
        this.zzi = UUID.randomUUID().toString();
        this.zzk(null);
        this.zzf = zzfge2.zzi() != zzfgf.zza && zzfge2.zzi() != zzfgf.zzc ? new zzfhh(zzfge2.zze(), null) : new zzfhf(zzfge2.zzf());
        this.zzf.zza();
        zzfgr.zza().zzb(this);
        zzfge2 = this.zzf;
        zzfgx.zza().zzb(zzfge2.zzd(), zzfgd2.zzb());
    }

    private final void zzk(View view) {
        this.zze = new zzfib(view);
    }

    public final void zza() {
        if (this.zzg) {
            return;
        }
        this.zzg = true;
        zzfgr.zza().zzc(this);
        float f = zzfgy.zza().zzf();
        this.zzf.zzj(f);
        this.zzf.zzh(this, this.zzb);
    }

    public final void zzb(View view) {
        if (this.zzh) {
            return;
        }
        if (this.zzi() == view) {
            return;
        }
        this.zzk(view);
        this.zzf.zzk();
        Object object = zzfgr.zza().zze();
        if (object == null) return;
        if (object.size() <= 0) return;
        object = object.iterator();
        while (object.hasNext()) {
            zzfgg zzfgg2 = (zzfgg)((Object)object.next());
            if (zzfgg2 == this || zzfgg2.zzi() != view) continue;
            zzfgg2.zze.clear();
        }
    }

    public final void zzc() {
        if (this.zzh) {
            return;
        }
        this.zze.clear();
        if (!this.zzh) {
            this.zzd.clear();
        }
        this.zzh = true;
        zzfhe zzfhe2 = this.zzf;
        zzfgx.zza().zzd(zzfhe2.zzd());
        zzfgr.zza().zzd(this);
        this.zzf.zzb();
        this.zzf = null;
    }

    /*
     * WARNING - void declaration
     */
    public final void zzd(View view, zzfgi zzfgi2, String string2) {
        void var3_7;
        block1: {
            if (this.zzh) return;
            if (!zza.matcher("Ad overlay").matches()) throw new IllegalArgumentException("FriendlyObstruction has improperly formatted detailed reason");
            for (zzfgu zzfgu2 : this.zzd) {
                if (zzfgu2.zza().get() != view) continue;
                break block1;
            }
            Object var3_6 = null;
        }
        if (var3_7 != null) return;
        this.zzd.add(new zzfgu(view, zzfgi2, "Ad overlay"));
    }

    public final List<zzfgu> zzf() {
        return this.zzd;
    }

    public final zzfhe zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zzi;
    }

    public final View zzi() {
        return (View)this.zze.get();
    }

    public final boolean zzj() {
        if (!this.zzg) return false;
        if (this.zzh) return false;
        return true;
    }
}
