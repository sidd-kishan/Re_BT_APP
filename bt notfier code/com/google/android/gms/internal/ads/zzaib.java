/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.TextureView$SurfaceTextureListener
 *  com.google.android.gms.internal.ads.zzado
 *  com.google.android.gms.internal.ads.zzads
 *  com.google.android.gms.internal.ads.zzaeh
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzagk
 *  com.google.android.gms.internal.ads.zzago
 *  com.google.android.gms.internal.ads.zzahc
 *  com.google.android.gms.internal.ads.zzahf
 *  com.google.android.gms.internal.ads.zzahi
 *  com.google.android.gms.internal.ads.zzahj
 *  com.google.android.gms.internal.ads.zzahl
 *  com.google.android.gms.internal.ads.zzaho
 *  com.google.android.gms.internal.ads.zzaid
 *  com.google.android.gms.internal.ads.zzaie
 *  com.google.android.gms.internal.ads.zzaif
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzaiw
 *  com.google.android.gms.internal.ads.zzakr
 *  com.google.android.gms.internal.ads.zzaz
 *  com.google.android.gms.internal.ads.zzba
 *  com.google.android.gms.internal.ads.zzdq
 *  com.google.android.gms.internal.ads.zzmu
 *  com.google.android.gms.internal.ads.zzs
 *  com.google.android.gms.internal.ads.zzt
 *  com.google.android.gms.internal.ads.zzy
 */
package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.google.android.gms.internal.ads.zzado;
import com.google.android.gms.internal.ads.zzads;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzago;
import com.google.android.gms.internal.ads.zzahc;
import com.google.android.gms.internal.ads.zzahf;
import com.google.android.gms.internal.ads.zzahi;
import com.google.android.gms.internal.ads.zzahj;
import com.google.android.gms.internal.ads.zzahl;
import com.google.android.gms.internal.ads.zzaho;
import com.google.android.gms.internal.ads.zzaid;
import com.google.android.gms.internal.ads.zzaie;
import com.google.android.gms.internal.ads.zzaif;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzaiw;
import com.google.android.gms.internal.ads.zzakr;
import com.google.android.gms.internal.ads.zzaz;
import com.google.android.gms.internal.ads.zzba;
import com.google.android.gms.internal.ads.zzdq;
import com.google.android.gms.internal.ads.zzmu;
import com.google.android.gms.internal.ads.zzs;
import com.google.android.gms.internal.ads.zzt;
import com.google.android.gms.internal.ads.zzy;
import java.util.Iterator;

final class zzaib
implements SurfaceHolder.Callback,
TextureView.SurfaceTextureListener,
zzmu,
zzdq,
zzakr,
zzaiw,
zzads,
zzado,
zzaif,
zzahj,
zzaeh {
    final zzaie zza;

    /* synthetic */ zzaib(zzaie zzaie2, zzaid zzaid2) {
        this.zza = zzaie2;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int n, int n2) {
        zzaie.zzS((zzaie)this.zza, (SurfaceTexture)surfaceTexture);
        zzaie.zzU((zzaie)this.zza, (int)n, (int)n2);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzaie.zzT((zzaie)this.zza, null);
        zzaie.zzU((zzaie)this.zza, (int)0, (int)0);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int n, int n2) {
        zzaie.zzU((zzaie)this.zza, (int)n, (int)n2);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int n, int n2, int n3) {
        zzaie.zzU((zzaie)this.zza, (int)n2, (int)n3);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        zzaie.zzU((zzaie)this.zza, (int)0, (int)0);
    }

    public final void zzA(Exception exception) {
        zzaie.zzf((zzaie)this.zza).zzA(exception);
    }

    public final void zzH(zzaiq zzaiq2, int n) {
    }

    public final void zzI(zzagk zzagk2, int n) {
    }

    public final void zzJ(zzs zzs2, zzt zzt2) {
    }

    public final void zzK(boolean bl) {
    }

    public final void zzL(zzahi zzahi2) {
    }

    public final void zzM(boolean bl, int n) {
    }

    public final void zzN(int n) {
        zzaie.zzY((zzaie)this.zza);
    }

    public final void zzO(boolean bl, int n) {
        zzaie.zzY((zzaie)this.zza);
    }

    public final void zzP(int n) {
    }

    public final void zzQ(boolean bl) {
    }

    public final void zzR(zzahc zzahc2) {
    }

    public final void zzS(zzaho zzaho2, zzaho zzaho3, int n) {
    }

    public final void zzT(zzahf zzahf2) {
    }

    public final void zzU(zzago zzago2) {
    }

    public final void zzV() {
    }

    public final void zza(boolean bl) {
    }

    public final void zzb(boolean bl) {
        zzaie.zzY((zzaie)this.zza);
    }

    public final void zzg(zzaz zzaz2) {
        zzaie.zzl((zzaie)this.zza, (zzaz)zzaz2);
        zzaie.zzf((zzaie)this.zza).zzg(zzaz2);
    }

    public final void zzh(String string, long l, long l2) {
        zzaie.zzf((zzaie)this.zza).zzh(string, l, l2);
    }

    public final void zzi(zzafv zzafv2, zzba zzba2) {
        zzaie.zzi((zzaie)this.zza, (zzafv)zzafv2);
        zzaie.zzf((zzaie)this.zza).zzi(zzafv2, zzba2);
    }

    public final void zzj(long l) {
        zzaie.zzf((zzaie)this.zza).zzj(l);
    }

    public final void zzk(int n, long l, long l2) {
        zzaie.zzf((zzaie)this.zza).zzk(n, l, l2);
    }

    public final void zzl(String string) {
        zzaie.zzf((zzaie)this.zza).zzl(string);
    }

    public final void zzm(zzaz zzaz2) {
        zzaie.zzf((zzaie)this.zza).zzm(zzaz2);
        zzaie.zzi((zzaie)this.zza, null);
        zzaie.zzl((zzaie)this.zza, null);
    }

    public final void zzn(boolean bl) {
        if (zzaie.zzm((zzaie)this.zza) == bl) {
            return;
        }
        zzaie.zzr((zzaie)this.zza, (boolean)bl);
        zzaie.zzW((zzaie)this.zza);
    }

    public final void zzo(Exception exception) {
        zzaie.zzf((zzaie)this.zza).zzo(exception);
    }

    public final void zzp(Exception exception) {
        zzaie.zzf((zzaie)this.zza).zzp(exception);
    }

    public final void zzr(zzaz zzaz2) {
        zzaie.zzk((zzaie)this.zza, (zzaz)zzaz2);
        zzaie.zzf((zzaie)this.zza).zzr(zzaz2);
    }

    public final void zzs(String string, long l, long l2) {
        zzaie.zzf((zzaie)this.zza).zzs(string, l, l2);
    }

    public final void zzt(zzafv zzafv2, zzba zzba2) {
        zzaie.zzh((zzaie)this.zza, (zzafv)zzafv2);
        zzaie.zzf((zzaie)this.zza).zzt(zzafv2, zzba2);
    }

    public final void zzu(int n, long l) {
        zzaie.zzf((zzaie)this.zza).zzu(n, l);
    }

    public final void zzv(String string) {
        zzaie.zzf((zzaie)this.zza).zzv(string);
    }

    public final void zzw(zzaz zzaz2) {
        zzaie.zzf((zzaie)this.zza).zzw(zzaz2);
        zzaie.zzh((zzaie)this.zza, null);
        zzaie.zzk((zzaie)this.zza, null);
    }

    public final void zzx(zzy zzy2) {
        zzaie.zzw((zzaie)this.zza, (zzy)zzy2);
        zzaie.zzf((zzaie)this.zza).zzx(zzy2);
        Iterator iterator = zzaie.zze((zzaie)this.zza).iterator();
        while (iterator.hasNext()) {
            ((zzahl)iterator.next()).zzx(zzy2);
        }
    }

    public final void zzy(Object iterator, long l) {
        zzaie.zzf((zzaie)this.zza).zzy((Object)iterator, l);
        if (zzaie.zzj((zzaie)this.zza) != iterator) return;
        iterator = zzaie.zze((zzaie)this.zza).iterator();
        while (iterator.hasNext()) {
            ((zzahl)iterator.next()).zzae();
        }
    }

    public final void zzz(long l, int n) {
        zzaie.zzf((zzaie)this.zza).zzz(l, n);
    }
}
