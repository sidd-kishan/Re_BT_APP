/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  com.google.android.gms.internal.ads.zzecm
 *  com.google.android.gms.internal.ads.zzeco
 *  com.google.android.gms.internal.ads.zzecp
 *  com.google.android.gms.internal.ads.zzfdw
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzecm;
import com.google.android.gms.internal.ads.zzeco;
import com.google.android.gms.internal.ads.zzecp;
import com.google.android.gms.internal.ads.zzfdw;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Executor;

public final class zzecq {
    private final zzecm zza;
    private final zzfsn zzb;

    public zzecq(zzecm zzecm2, zzfsn zzfsn2) {
        this.zza = zzecm2;
        this.zzb = zzfsn2;
    }

    public final void zza(zzfdw<SQLiteDatabase, Void> zzfdw2) {
        zzfsd.zzp((zzfsm)this.zzb.zzb(zzeco.zza((zzecm)this.zza)), (zzfrz)new zzecp(this, zzfdw2), (Executor)this.zzb);
    }
}
