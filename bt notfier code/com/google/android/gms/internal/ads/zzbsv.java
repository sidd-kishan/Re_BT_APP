/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zza
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.Predicate
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbsj
 *  com.google.android.gms.internal.ads.zzbsk
 *  com.google.android.gms.internal.ads.zzbsm
 *  com.google.android.gms.internal.ads.zzbsn
 *  com.google.android.gms.internal.ads.zzbso
 *  com.google.android.gms.internal.ads.zzbsp
 *  com.google.android.gms.internal.ads.zzbsq
 *  com.google.android.gms.internal.ads.zzbsr
 *  com.google.android.gms.internal.ads.zzbss
 *  com.google.android.gms.internal.ads.zzbst
 *  com.google.android.gms.internal.ads.zzbsu
 *  com.google.android.gms.internal.ads.zzbtt
 *  com.google.android.gms.internal.ads.zzbtu
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcmw
 *  com.google.android.gms.internal.ads.zzcmx
 *  com.google.android.gms.internal.ads.zzcob
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbsk;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbso;
import com.google.android.gms.internal.ads.zzbsp;
import com.google.android.gms.internal.ads.zzbsq;
import com.google.android.gms.internal.ads.zzbsr;
import com.google.android.gms.internal.ads.zzbss;
import com.google.android.gms.internal.ads.zzbst;
import com.google.android.gms.internal.ads.zzbsu;
import com.google.android.gms.internal.ads.zzbtt;
import com.google.android.gms.internal.ads.zzbtu;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcmw;
import com.google.android.gms.internal.ads.zzcmx;
import com.google.android.gms.internal.ads.zzcob;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzbsv
implements zzbsn,
zzbsk {
    private final zzcml zza;

    public zzbsv(Context context, zzcgz zzcgz2, zzaas zzaas2, zza zza2) throws zzcmw {
        zzt.zzd();
        context = zzcmx.zza((Context)context, (zzcob)zzcob.zzb(), (String)"", (boolean)false, (boolean)false, null, null, (zzcgz)zzcgz2, null, null, null, (zzazb)zzazb.zza(), null, null);
        this.zza = context;
        ((View)context).setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        zzber.zza();
        if (zzcgm.zzp()) {
            runnable.run();
            return;
        }
        zzs.zza.post(runnable);
    }

    public final void zza(String string) {
        zzbsv.zzs((Runnable)new zzbso(this, string));
    }

    public final void zzbl(String string, String string2) {
        zzbsj.zzb((zzbsk)this, (String)string, (String)string2);
    }

    public final void zzc(String string) {
        zzbsv.zzs((Runnable)new zzbsp(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", string)));
    }

    public final void zzd(String string, JSONObject jSONObject) {
        zzbsj.zzc((zzbsk)this, (String)string, (JSONObject)jSONObject);
    }

    public final void zze(String string, Map map) {
        zzbsj.zzd((zzbsk)this, (String)string, (Map)map);
    }

    public final void zzf(String string) {
        zzbsv.zzs((Runnable)new zzbsr(this, string));
    }

    public final void zzg(String string) {
        zzbsv.zzs((Runnable)new zzbsq(this, string));
    }

    public final void zzh(zzbsm zzbsm2) {
        this.zza.zzR().zzz(zzbst.zza((zzbsm)zzbsm2));
    }

    public final void zzi() {
        this.zza.destroy();
    }

    public final boolean zzj() {
        return this.zza.zzX();
    }

    public final zzbtu zzk() {
        return new zzbtu((zzbtt)this);
    }

    public final void zzl(String string, zzbpr<? super zzbtt> zzbpr2) {
        this.zza.zzab(string, (zzbpr)new zzbsu(this, zzbpr2));
    }

    public final void zzm(String string, zzbpr<? super zzbtt> zzbpr2) {
        this.zza.zzad(string, (Predicate)new zzbss(zzbpr2));
    }

    final /* synthetic */ void zzn(String string) {
        this.zza.loadUrl(string);
    }

    final /* synthetic */ void zzo(String string) {
        this.zza.loadData(string, "text/html", "UTF-8");
    }

    final /* synthetic */ void zzp(String string) {
        this.zza.loadData(string, "text/html", "UTF-8");
    }

    final /* synthetic */ void zzq(String string) {
        this.zza.zza(string);
    }

    public final void zzr(String string, JSONObject jSONObject) {
        zzbsj.zza((zzbsk)this, (String)string, (JSONObject)jSONObject);
    }
}
