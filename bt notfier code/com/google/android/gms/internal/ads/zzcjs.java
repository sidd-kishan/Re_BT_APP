/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.view.Surface
 *  android.view.TextureView$SurfaceTextureListener
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcih
 *  com.google.android.gms.internal.ads.zzcii
 *  com.google.android.gms.internal.ads.zzcir
 *  com.google.android.gms.internal.ads.zzcis
 *  com.google.android.gms.internal.ads.zzciz
 *  com.google.android.gms.internal.ads.zzcja
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcjc
 *  com.google.android.gms.internal.ads.zzcjg
 *  com.google.android.gms.internal.ads.zzcjh
 *  com.google.android.gms.internal.ads.zzcji
 *  com.google.android.gms.internal.ads.zzcjj
 *  com.google.android.gms.internal.ads.zzcjk
 *  com.google.android.gms.internal.ads.zzcjl
 *  com.google.android.gms.internal.ads.zzcjm
 *  com.google.android.gms.internal.ads.zzcjn
 *  com.google.android.gms.internal.ads.zzcjo
 *  com.google.android.gms.internal.ads.zzcjp
 *  com.google.android.gms.internal.ads.zzcjq
 *  com.google.android.gms.internal.ads.zzcjr
 *  com.google.android.gms.internal.ads.zzcki
 *  com.google.android.gms.internal.ads.zzclg
 *  com.google.android.gms.internal.ads.zzclj
 *  com.google.android.gms.internal.ads.zzcmb
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcih;
import com.google.android.gms.internal.ads.zzcii;
import com.google.android.gms.internal.ads.zzcir;
import com.google.android.gms.internal.ads.zzcis;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzcja;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcjc;
import com.google.android.gms.internal.ads.zzcjg;
import com.google.android.gms.internal.ads.zzcjh;
import com.google.android.gms.internal.ads.zzcji;
import com.google.android.gms.internal.ads.zzcjj;
import com.google.android.gms.internal.ads.zzcjk;
import com.google.android.gms.internal.ads.zzcjl;
import com.google.android.gms.internal.ads.zzcjm;
import com.google.android.gms.internal.ads.zzcjn;
import com.google.android.gms.internal.ads.zzcjo;
import com.google.android.gms.internal.ads.zzcjp;
import com.google.android.gms.internal.ads.zzcjq;
import com.google.android.gms.internal.ads.zzcjr;
import com.google.android.gms.internal.ads.zzcki;
import com.google.android.gms.internal.ads.zzclg;
import com.google.android.gms.internal.ads.zzclj;
import com.google.android.gms.internal.ads.zzcmb;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class zzcjs
extends zzcii
implements TextureView.SurfaceTextureListener,
zzcir {
    private final zzcjb zzc;
    private final zzcjc zzd;
    private final boolean zze;
    private final zzcja zzf;
    private zzcih zzg;
    private Surface zzh;
    private zzcis zzi;
    private String zzj;
    private String[] zzk;
    private boolean zzl;
    private int zzm = 1;
    private zzciz zzn;
    private final boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private float zzv;

    public zzcjs(Context context, zzcjc zzcjc2, zzcjb zzcjb2, boolean bl, boolean bl2, zzcja zzcja2) {
        super(context);
        this.zze = bl2;
        this.zzc = zzcjb2;
        this.zzd = zzcjc2;
        this.zzo = bl;
        this.zzf = zzcja2;
        this.setSurfaceTextureListener(this);
        this.zzd.zza((zzcii)this);
    }

    private final boolean zzR() {
        zzcis zzcis2 = this.zzi;
        if (zzcis2 == null) return false;
        if (!zzcis2.zzA()) return false;
        if (this.zzl) return false;
        return true;
    }

    private final boolean zzS() {
        if (!this.zzR()) return false;
        if (this.zzm == 1) return false;
        return true;
    }

    private final void zzT(boolean bl) {
        int n;
        block11: {
            String[] stringArray;
            block12: {
                if (this.zzi != null) {
                    if (!bl) return;
                }
                if (this.zzj == null) return;
                if (this.zzh == null) {
                    return;
                }
                if (bl) {
                    if (!this.zzR()) {
                        com.google.android.gms.ads.internal.util.zze.zzi((String)"No valid ExoPlayerAdapter exists when switch source.");
                        return;
                    }
                    this.zzi.zzv();
                    this.zzU();
                }
                if (!this.zzj.startsWith("cache:")) break block12;
                Object object = this.zzc.zzs(this.zzj);
                if (object instanceof zzclj) {
                    object = ((zzclj)object).zzj();
                    this.zzi = object;
                    if (!object.zzA()) {
                        com.google.android.gms.ads.internal.util.zze.zzi((String)"Precached video player has been released.");
                        return;
                    }
                    break block11;
                } else if (object instanceof zzclg) {
                    zzclg zzclg2 = (zzclg)object;
                    String string = this.zzE();
                    object = zzclg2.zzc();
                    bl = zzclg2.zzb();
                    String string2 = zzclg2.zza();
                    if (string2 == null) {
                        com.google.android.gms.ads.internal.util.zze.zzi((String)"Stream cache URL is null.");
                        return;
                    }
                    zzclg2 = this.zzD();
                    this.zzi = zzclg2;
                    zzclg2.zzq(new Uri[]{Uri.parse((String)string2)}, string, (ByteBuffer)object, bl);
                    break block11;
                } else {
                    object = String.valueOf(this.zzj);
                    object = ((String)object).length() != 0 ? "Stream cache miss: ".concat((String)object) : new String("Stream cache miss: ");
                    com.google.android.gms.ads.internal.util.zze.zzi((String)object);
                    return;
                }
            }
            this.zzi = this.zzD();
            String string = this.zzE();
            Uri[] uriArray = new Uri[this.zzk.length];
            for (n = 0; n < (stringArray = this.zzk).length; ++n) {
                uriArray[n] = Uri.parse((String)stringArray[n]);
            }
            this.zzi.zzp(uriArray, string);
        }
        this.zzi.zzr((zzcir)this);
        this.zzV(this.zzh, false);
        if (!this.zzi.zzA()) return;
        this.zzm = n = this.zzi.zzB();
        if (n != 3) return;
        this.zzX();
    }

    private final void zzU() {
        if (this.zzi == null) return;
        this.zzV(null, true);
        zzcis zzcis2 = this.zzi;
        if (zzcis2 != null) {
            zzcis2.zzr(null);
            this.zzi.zzs();
            this.zzi = null;
        }
        this.zzm = 1;
        this.zzl = false;
        this.zzp = false;
        this.zzq = false;
    }

    private final void zzV(Surface surface, boolean bl) {
        zzcis zzcis2 = this.zzi;
        if (zzcis2 == null) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Trying to set surface before player is initialized.");
            return;
        }
        try {
            zzcis2.zzt(surface, bl);
            return;
        }
        catch (IOException iOException) {
            zzcgt.zzj((String)"", (Throwable)iOException);
            return;
        }
    }

    private final void zzW(float f, boolean bl) {
        zzcis zzcis2 = this.zzi;
        if (zzcis2 == null) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Trying to set volume before player is initialized.");
            return;
        }
        try {
            zzcis2.zzu(f, bl);
            return;
        }
        catch (IOException iOException) {
            zzcgt.zzj((String)"", (Throwable)iOException);
            return;
        }
    }

    private final void zzX() {
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcjg(this));
        this.zzt();
        this.zzd.zzb();
        if (!this.zzq) return;
        this.zzh();
    }

    private static String zzY(String string, Exception serializable) {
        String string2 = serializable.getClass().getCanonicalName();
        String string3 = ((Throwable)serializable).getMessage();
        int n = String.valueOf(string2).length();
        int n2 = String.valueOf(string3).length();
        serializable = new StringBuilder(string.length() + 2 + n + n2);
        ((StringBuilder)serializable).append(string);
        ((StringBuilder)serializable).append("/");
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append(":");
        ((StringBuilder)serializable).append(string3);
        return ((StringBuilder)serializable).toString();
    }

    private final void zzZ() {
        this.zzaa(this.zzr, this.zzs);
    }

    private final void zzaa(int n, int n2) {
        float f = n2 > 0 ? (float)n / (float)n2 : 1.0f;
        if (this.zzv == f) return;
        this.zzv = f;
        this.requestLayout();
    }

    private final void zzab() {
        zzcis zzcis2 = this.zzi;
        if (zzcis2 == null) return;
        zzcis2.zzM(true);
    }

    private final void zzac() {
        zzcis zzcis2 = this.zzi;
        if (zzcis2 == null) return;
        zzcis2.zzM(false);
    }

    protected final void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        int n3 = this.getMeasuredWidth();
        n = this.getMeasuredHeight();
        float f = this.zzv;
        int n4 = n3;
        n2 = n;
        if (f != 0.0f) {
            n4 = n3;
            n2 = n;
            if (this.zzn == null) {
                float f2 = n3;
                float f3 = f2 / (float)n;
                if (f > f3) {
                    n = (int)(f2 / f);
                }
                n4 = n3;
                n2 = n;
                if (f < f3) {
                    n4 = (int)((float)n * f);
                    n2 = n;
                }
            }
        }
        this.setMeasuredDimension(n4, n2);
        zzciz zzciz2 = this.zzn;
        if (zzciz2 != null) {
            zzciz2.zzc(n4, n2);
        }
        if (Build.VERSION.SDK_INT != 16) return;
        n = this.zzt;
        if ((n > 0 && n != n4 || (n = this.zzu) > 0 && n != n2) && this.zze && this.zzR() && this.zzi.zzC() > 0L && !this.zzi.zzD()) {
            this.zzW(0.0f, true);
            this.zzi.zzE(true);
            long l = this.zzi.zzC();
            long l2 = com.google.android.gms.ads.internal.zzt.zzj().currentTimeMillis();
            while (this.zzR() && this.zzi.zzC() == l && com.google.android.gms.ads.internal.zzt.zzj().currentTimeMillis() - l2 <= 250L) {
            }
            this.zzi.zzE(false);
            this.zzt();
        }
        this.zzt = n4;
        this.zzu = n2;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int n, int n2) {
        SurfaceTexture surfaceTexture2 = surfaceTexture;
        if (this.zzo) {
            surfaceTexture2 = new zzciz(this.getContext());
            this.zzn = surfaceTexture2;
            surfaceTexture2.zzb(surfaceTexture, n, n2);
            this.zzn.start();
            surfaceTexture2 = this.zzn.zze();
            if (surfaceTexture2 == null) {
                this.zzn.zzd();
                this.zzn = null;
                surfaceTexture2 = surfaceTexture;
            }
        }
        surfaceTexture = new Surface(surfaceTexture2);
        this.zzh = surfaceTexture;
        if (this.zzi == null) {
            this.zzT(false);
        } else {
            this.zzV((Surface)surfaceTexture, true);
            if (!this.zzf.zza) {
                this.zzab();
            }
        }
        if (this.zzr != 0 && this.zzs != 0) {
            this.zzZ();
        } else {
            this.zzaa(n, n2);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcjn(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.zzi();
        surfaceTexture = this.zzn;
        if (surfaceTexture != null) {
            surfaceTexture.zzd();
            this.zzn = null;
        }
        if (this.zzi != null) {
            this.zzac();
            surfaceTexture = this.zzh;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            this.zzh = null;
            this.zzV(null, true);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcjp(this));
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int n, int n2) {
        surfaceTexture = this.zzn;
        if (surfaceTexture != null) {
            surfaceTexture.zzc(n, n2);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcjo(this, n, n2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzd((zzcii)this);
        this.zza.zzb(surfaceTexture, this.zzg);
    }

    protected final void onWindowVisibilityChanged(int n) {
        StringBuilder stringBuilder = new StringBuilder(57);
        stringBuilder.append("AdExoPlayerView3 window visibility changed to ");
        stringBuilder.append(n);
        com.google.android.gms.ads.internal.util.zze.zza((String)stringBuilder.toString());
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcjq(this, n));
        super.onWindowVisibilityChanged(n);
    }

    public final void zzA(int n) {
        zzcis zzcis2 = this.zzi;
        if (zzcis2 == null) return;
        zzcis2.zzy(n);
    }

    public final void zzB(int n) {
        zzcis zzcis2 = this.zzi;
        if (zzcis2 == null) return;
        zzcis2.zzz(n);
    }

    public final void zzC() {
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcji(this));
    }

    final zzcis zzD() {
        if (!this.zzf.zzm) return new zzcki(this.zzc.getContext(), this.zzf, this.zzc);
        return new zzcmb(this.zzc.getContext(), this.zzf, this.zzc);
    }

    final String zzE() {
        return com.google.android.gms.ads.internal.zzt.zzc().zzi(this.zzc.getContext(), this.zzc.zzt().zza);
    }

    final /* synthetic */ void zzF() {
        zzcih zzcih2 = this.zzg;
        if (zzcih2 == null) return;
        zzcih2.zzk();
    }

    final /* synthetic */ void zzG(String string) {
        zzcih zzcih2 = this.zzg;
        if (zzcih2 == null) return;
        zzcih2.zzg("ExoPlayerAdapter exception", string);
    }

    final /* synthetic */ void zzH(boolean bl, long l) {
        this.zzc.zzv(bl, l);
    }

    final /* synthetic */ void zzI(int n) {
        zzcih zzcih2 = this.zzg;
        if (zzcih2 == null) return;
        zzcih2.onWindowVisibilityChanged(n);
    }

    final /* synthetic */ void zzJ() {
        zzcih zzcih2 = this.zzg;
        if (zzcih2 == null) return;
        zzcih2.zzh();
    }

    final /* synthetic */ void zzK(int n, int n2) {
        zzcih zzcih2 = this.zzg;
        if (zzcih2 == null) return;
        zzcih2.zzj(n, n2);
    }

    final /* synthetic */ void zzL() {
        zzcih zzcih2 = this.zzg;
        if (zzcih2 == null) return;
        zzcih2.zza();
    }

    final /* synthetic */ void zzM() {
        zzcih zzcih2 = this.zzg;
        if (zzcih2 == null) return;
        zzcih2.zzd();
    }

    final /* synthetic */ void zzN() {
        zzcih zzcih2 = this.zzg;
        if (zzcih2 == null) return;
        zzcih2.zzc();
    }

    final /* synthetic */ void zzO(String string) {
        zzcih zzcih2 = this.zzg;
        if (zzcih2 == null) return;
        zzcih2.zzf("ExoPlayerAdapter error", string);
    }

    final /* synthetic */ void zzP() {
        zzcih zzcih2 = this.zzg;
        if (zzcih2 == null) return;
        zzcih2.zze();
    }

    final /* synthetic */ void zzQ() {
        zzcih zzcih2 = this.zzg;
        if (zzcih2 == null) return;
        zzcih2.zzb();
    }

    public final void zza(boolean bl, long l) {
        if (this.zzc == null) return;
        zzchg.zze.execute((Runnable)new zzcjr(this, bl, l));
    }

    public final void zzb(int n) {
        if (this.zzm == n) return;
        this.zzm = n;
        if (n != 3) {
            if (n != 4) return;
            if (this.zzf.zza) {
                this.zzac();
            }
            this.zzd.zzf();
            this.zzb.zze();
            com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcjj(this));
            return;
        }
        this.zzX();
    }

    public final void zzc(int n, int n2) {
        this.zzr = n;
        this.zzs = n2;
        this.zzZ();
    }

    public final String zzd() {
        String string = true != this.zzo ? "" : " spherical";
        string = string.length() != 0 ? "ExoPlayer/3".concat(string) : new String("ExoPlayer/3");
        return string;
    }

    public final void zze(zzcih zzcih2) {
        this.zzg = zzcih2;
    }

    public final void zzf(String string) {
        if (string == null) return;
        this.zzw(string, null);
    }

    public final void zzg() {
        if (this.zzR()) {
            this.zzi.zzv();
            this.zzU();
        }
        this.zzd.zzf();
        this.zzb.zze();
        this.zzd.zzc();
    }

    public final void zzh() {
        if (!this.zzS()) {
            this.zzq = true;
            return;
        }
        if (this.zzf.zza) {
            this.zzab();
        }
        this.zzi.zzE(true);
        this.zzd.zze();
        this.zzb.zzd();
        this.zza.zza();
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcjl(this));
    }

    public final void zzi() {
        if (!this.zzS()) return;
        if (this.zzf.zza) {
            this.zzac();
        }
        this.zzi.zzE(false);
        this.zzd.zzf();
        this.zzb.zze();
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcjm(this));
    }

    public final int zzj() {
        if (!this.zzS()) return 0;
        return (int)this.zzi.zzH();
    }

    public final int zzk() {
        if (!this.zzS()) return 0;
        return (int)this.zzi.zzC();
    }

    public final void zzl(int n) {
        if (!this.zzS()) return;
        this.zzi.zzw((long)n);
    }

    public final void zzm(float f, float f2) {
        zzciz zzciz2 = this.zzn;
        if (zzciz2 == null) return;
        zzciz2.zzf(f, f2);
    }

    public final int zzn() {
        return this.zzr;
    }

    public final int zzo() {
        return this.zzs;
    }

    public final long zzp() {
        zzcis zzcis2 = this.zzi;
        if (zzcis2 == null) return -1L;
        return zzcis2.zzI();
    }

    public final long zzq() {
        zzcis zzcis2 = this.zzi;
        if (zzcis2 == null) return -1L;
        return zzcis2.zzJ();
    }

    public final long zzr() {
        zzcis zzcis2 = this.zzi;
        if (zzcis2 == null) return -1L;
        return zzcis2.zzK();
    }

    public final int zzs() {
        zzcis zzcis2 = this.zzi;
        if (zzcis2 == null) return -1;
        return zzcis2.zzL();
    }

    public final void zzt() {
        this.zzW(this.zzb.zzc(), false);
    }

    public final void zzu(String string, Exception exception) {
        String string2 = zzcjs.zzY(string, exception);
        string = string2.length() != 0 ? "ExoPlayerAdapter error: ".concat(string2) : new String("ExoPlayerAdapter error: ");
        com.google.android.gms.ads.internal.util.zze.zzi((String)string);
        this.zzl = true;
        if (this.zzf.zza) {
            this.zzac();
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcjk(this, string2));
        com.google.android.gms.ads.internal.zzt.zzg().zzl((Throwable)exception, "AdExoPlayerView.onError");
    }

    public final void zzv(String string, Exception exception) {
        String string2 = zzcjs.zzY("onLoadException", exception);
        string = string2.length() != 0 ? "ExoPlayerAdapter exception: ".concat(string2) : new String("ExoPlayerAdapter exception: ");
        com.google.android.gms.ads.internal.util.zze.zzi((String)string);
        com.google.android.gms.ads.internal.zzt.zzg().zzl((Throwable)exception, "AdExoPlayerView.onException");
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcjh(this, string2));
    }

    public final void zzw(String string, String[] object) {
        if (string == null) {
            return;
        }
        boolean bl = true;
        this.zzk = object == null ? new String[]{string} : Arrays.copyOf(object, ((String[])object).length);
        object = this.zzj;
        if (!this.zzf.zzn || object == null || string.equals(object) || this.zzm != 4) {
            bl = false;
        }
        this.zzj = string;
        this.zzT(bl);
    }

    public final void zzx(int n) {
        zzcis zzcis2 = this.zzi;
        if (zzcis2 == null) return;
        zzcis2.zzF(n);
    }

    public final void zzy(int n) {
        zzcis zzcis2 = this.zzi;
        if (zzcis2 == null) return;
        zzcis2.zzG(n);
    }

    public final void zzz(int n) {
        zzcis zzcis2 = this.zzi;
        if (zzcis2 == null) return;
        zzcis2.zzx(n);
    }
}
