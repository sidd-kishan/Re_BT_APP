/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Handler
 *  android.view.Surface
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.internal.ads.zzamy
 *  com.google.android.gms.internal.ads.zzamz
 *  com.google.android.gms.internal.ads.zzana
 *  com.google.android.gms.internal.ads.zzanb
 *  com.google.android.gms.internal.ads.zzanc
 *  com.google.android.gms.internal.ads.zzand
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzanq
 *  com.google.android.gms.internal.ads.zzanr
 *  com.google.android.gms.internal.ads.zzanx
 *  com.google.android.gms.internal.ads.zzaoj
 *  com.google.android.gms.internal.ads.zzaox
 *  com.google.android.gms.internal.ads.zzapq
 *  com.google.android.gms.internal.ads.zzark
 *  com.google.android.gms.internal.ads.zzasm
 *  com.google.android.gms.internal.ads.zzasn
 *  com.google.android.gms.internal.ads.zzasr
 *  com.google.android.gms.internal.ads.zzasv
 *  com.google.android.gms.internal.ads.zzatg
 *  com.google.android.gms.internal.ads.zzatm
 *  com.google.android.gms.internal.ads.zzatq
 *  com.google.android.gms.internal.ads.zzats
 *  com.google.android.gms.internal.ads.zzatu
 *  com.google.android.gms.internal.ads.zzaty
 *  com.google.android.gms.internal.ads.zzatz
 *  com.google.android.gms.internal.ads.zzaub
 *  com.google.android.gms.internal.ads.zzaud
 *  com.google.android.gms.internal.ads.zzaui
 *  com.google.android.gms.internal.ads.zzauo
 *  com.google.android.gms.internal.ads.zzavn
 *  com.google.android.gms.internal.ads.zzavy
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcir
 *  com.google.android.gms.internal.ads.zzcis
 *  com.google.android.gms.internal.ads.zzcja
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcju
 *  com.google.android.gms.internal.ads.zzcjw
 *  com.google.android.gms.internal.ads.zzcjx
 *  com.google.android.gms.internal.ads.zzcjy
 *  com.google.android.gms.internal.ads.zzcjz
 *  com.google.android.gms.internal.ads.zzcka
 *  com.google.android.gms.internal.ads.zzckb
 *  com.google.android.gms.internal.ads.zzckc
 *  com.google.android.gms.internal.ads.zzckd
 *  com.google.android.gms.internal.ads.zzcke
 *  com.google.android.gms.internal.ads.zzckf
 *  com.google.android.gms.internal.ads.zzckg
 *  com.google.android.gms.internal.ads.zzckh
 *  com.google.android.gms.internal.ads.zzflf
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.internal.ads.zzamy;
import com.google.android.gms.internal.ads.zzamz;
import com.google.android.gms.internal.ads.zzana;
import com.google.android.gms.internal.ads.zzanb;
import com.google.android.gms.internal.ads.zzanc;
import com.google.android.gms.internal.ads.zzand;
import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzanq;
import com.google.android.gms.internal.ads.zzanr;
import com.google.android.gms.internal.ads.zzanx;
import com.google.android.gms.internal.ads.zzaoj;
import com.google.android.gms.internal.ads.zzaox;
import com.google.android.gms.internal.ads.zzapq;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzasm;
import com.google.android.gms.internal.ads.zzasn;
import com.google.android.gms.internal.ads.zzasr;
import com.google.android.gms.internal.ads.zzasv;
import com.google.android.gms.internal.ads.zzatg;
import com.google.android.gms.internal.ads.zzatm;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzatu;
import com.google.android.gms.internal.ads.zzaty;
import com.google.android.gms.internal.ads.zzatz;
import com.google.android.gms.internal.ads.zzaub;
import com.google.android.gms.internal.ads.zzaud;
import com.google.android.gms.internal.ads.zzaui;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzavn;
import com.google.android.gms.internal.ads.zzavy;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcir;
import com.google.android.gms.internal.ads.zzcis;
import com.google.android.gms.internal.ads.zzcja;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcju;
import com.google.android.gms.internal.ads.zzcjw;
import com.google.android.gms.internal.ads.zzcjx;
import com.google.android.gms.internal.ads.zzcjy;
import com.google.android.gms.internal.ads.zzcjz;
import com.google.android.gms.internal.ads.zzcka;
import com.google.android.gms.internal.ads.zzckb;
import com.google.android.gms.internal.ads.zzckc;
import com.google.android.gms.internal.ads.zzckd;
import com.google.android.gms.internal.ads.zzcke;
import com.google.android.gms.internal.ads.zzckf;
import com.google.android.gms.internal.ads.zzckg;
import com.google.android.gms.internal.ads.zzckh;
import com.google.android.gms.internal.ads.zzflf;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzcki
extends zzcis
implements zzauo,
zzasm,
zzavy,
zzaoj,
zzamz {
    public static final int zzc = 0;
    private final Context zzd;
    private final zzcjy zze;
    private final zzanr zzf;
    private final zzanr zzg;
    private final zzatq zzh;
    private final zzcja zzi;
    private zzanc zzj;
    private ByteBuffer zzk;
    private boolean zzl;
    private final WeakReference<zzcjb> zzm;
    private zzcir zzn;
    private int zzo;
    private int zzp;
    private long zzq;
    private final String zzr;
    private final int zzs;
    private final Object zzt = new Object();
    private final ArrayList<zzaui> zzu;
    private volatile zzcjx zzv;
    private final Set<WeakReference<zzcju>> zzw = new HashSet<WeakReference<zzcju>>();

    public zzcki(Context object, zzcja zzcja2, zzcjb zzcjb2) {
        this.zzd = object;
        this.zzi = zzcja2;
        this.zzm = new WeakReference<zzcjb>(zzcjb2);
        this.zze = new zzcjy();
        this.zzf = new zzavn(this.zzd, zzark.zza, 0L, (Handler)com.google.android.gms.ads.internal.util.zzs.zza, (zzavy)this, -1);
        this.zzg = new zzaox(zzark.zza, null, true, (Handler)com.google.android.gms.ads.internal.util.zzs.zza, (zzaoj)this);
        this.zzh = new zzatm(null);
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza((String)"ForkedExoPlayerAdapter initialize ".concat(((Object)((Object)this)).toString()));
        }
        zza.incrementAndGet();
        object = this.zzg;
        int n = 0;
        zzcja2 = this.zzf;
        zzatq zzatq2 = this.zzh;
        zzcjy zzcjy2 = this.zze;
        object = zzand.zza((zzanr[])new zzanr[]{object, zzcja2}, (zzatu)zzatq2, (zzcjy)zzcjy2);
        this.zzj = object;
        object.zza((zzamz)this);
        this.zzo = 0;
        this.zzq = 0L;
        this.zzp = 0;
        this.zzu = new ArrayList();
        this.zzv = null;
        object = zzcjb2 != null && zzcjb2.zzn() != null ? zzcjb2.zzn() : "";
        this.zzr = object;
        if (zzcjb2 != null) {
            n = zzcjb2.zzp();
        }
        this.zzs = n;
        object = zzbjl.zzn;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
            this.zzj.zzo();
        }
        if (zzcjb2 != null && zzcjb2.zzD() > 0) {
            this.zzj.zzp(zzcjb2.zzD());
        }
        if (zzcjb2 == null) return;
        if (zzcjb2.zzE() <= 0) return;
        this.zzj.zzq(zzcjb2.zzE());
    }

    private final boolean zzY() {
        if (this.zzv == null) return false;
        if (!this.zzv.zzf()) return false;
        return true;
    }

    public final void finalize() throws Throwable {
        zza.decrementAndGet();
        if (!com.google.android.gms.ads.internal.util.zze.zzc()) return;
        com.google.android.gms.ads.internal.util.zze.zza((String)"ForkedExoPlayerAdapter finalize ".concat(((Object)((Object)this)).toString()));
    }

    public final boolean zzA() {
        if (this.zzj == null) return false;
        return true;
    }

    public final int zzB() {
        return this.zzj.zzc();
    }

    public final long zzC() {
        return this.zzj.zzm();
    }

    public final boolean zzD() {
        return this.zzj.zzf();
    }

    public final void zzE(boolean bl) {
        this.zzj.zze(bl);
    }

    public final void zzF(int n) {
        this.zze.zzg(n);
    }

    public final void zzG(int n) {
        this.zze.zzh(n);
    }

    public final long zzH() {
        return this.zzj.zzl();
    }

    public final long zzI() {
        if (this.zzY()) return 0L;
        return this.zzo;
    }

    public final long zzJ() {
        if (!this.zzY()) {
            return 0L;
        }
        if (this.zzv.zzg()) return Math.min((long)this.zzo, this.zzv.zzi());
        return 0L;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final long zzK() {
        if (this.zzY()) return this.zzv.zzj();
        Object object = this.zzt;
        synchronized (object) {
            while (!this.zzu.isEmpty()) {
                long l;
                long l2 = this.zzq;
                Object object2 = this.zzu.remove(0).zze();
                long l3 = l = 0L;
                if (object2 != null) {
                    object2 = object2.entrySet().iterator();
                    while (true) {
                        l3 = l;
                        if (!object2.hasNext()) break;
                        Map.Entry entry = (Map.Entry)object2.next();
                        if (entry == null) continue;
                        try {
                            if (entry.getKey() == null || !zzflf.zze((CharSequence)"content-length", (CharSequence)((CharSequence)entry.getKey())) || entry.getValue() == null || ((List)entry.getValue()).get(0) == null) continue;
                            l3 = Long.parseLong((String)((List)entry.getValue()).get(0));
                        }
                        catch (NumberFormatException numberFormatException) {
                            continue;
                        }
                        break;
                    }
                }
                this.zzq = l2 + l3;
            }
            return this.zzq;
        }
    }

    public final int zzL() {
        return this.zzp;
    }

    public final void zzM(boolean bl) {
        if (this.zzj == null) return;
        int n = 0;
        while (n < 2) {
            this.zzh.zzc(n, bl ^ true);
            ++n;
        }
    }

    public final long zzN() {
        return this.zzj.zzn();
    }

    public final long zzO() {
        return this.zzo;
    }

    public final void zzR(zzatz zzatz2, zzaub object) {
        if (!(zzatz2 instanceof zzaui)) {
            if (!(zzatz2 instanceof zzcjx)) return;
            this.zzv = (zzcjx)zzatz2;
            zzatz2 = (zzcjb)this.zzm.get();
            object = zzbjl.zzbl;
            if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
            if (zzatz2 == null) return;
            if (!this.zzv.zze()) return;
            object = new HashMap();
            object.put("gcacheHit", String.valueOf(this.zzv.zzg()));
            object.put("gcacheDownloaded", String.valueOf(this.zzv.zzh()));
            com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcjz((zzcjb)zzatz2, (Map)object));
            return;
        }
        object = this.zzt;
        synchronized (object) {
            this.zzu.add((zzaui)zzatz2);
            return;
        }
    }

    public final void zzS(zzatz zzatz2, int n) {
        this.zzo += n;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    final zzasr zzT(Uri var1_1, String var2_2) {
        block8: {
            block7: {
                block6: {
                    if (!this.zzl || this.zzk.limit() <= 0) break block6;
                    var2_2 = new byte[this.zzk.limit()];
                    this.zzk.get((byte[])var2_2);
                    var5_3 /* !! */  = new zzcka((byte[])var2_2);
                    ** GOTO lbl-1000
                }
                var5_3 /* !! */  = zzbjl.zzbq;
                var3_4 = (Boolean)zzbet.zzc().zzc(var5_3 /* !! */ );
                var4_5 = true;
                if (!var3_4) break block7;
                var5_3 /* !! */  = zzbjl.zzbl;
                var3_4 = var4_5;
                if (((Boolean)zzbet.zzc().zzc(var5_3 /* !! */ )).booleanValue()) break block8;
            }
            var3_4 = this.zzi.zzj == false ? var4_5 : false;
        }
        var5_3 /* !! */  = this.zzi.zzi > 0 ? new zzckb(this, (String)var2_2, var3_4) : new zzckc(this, (String)var2_2, var3_4);
        var2_2 = var5_3 /* !! */ ;
        if (this.zzi.zzj) {
            var2_2 = new zzckd(this, (zzaty)var5_3 /* !! */ );
        }
        var6_6 = this.zzk;
        var5_3 /* !! */  = var2_2;
        if (var6_6 == null) ** GOTO lbl-1000
        var5_3 /* !! */  = var2_2;
        if (var6_6.limit() > 0) {
            var5_3 /* !! */  = (zzbjd)new byte[this.zzk.limit()];
            this.zzk.get((byte[])var5_3 /* !! */ );
            var2_2 = new zzcke((zzaty)var2_2, (byte[])var5_3 /* !! */ );
        } else lbl-1000:
        // 3 sources

        {
            var2_2 = var5_3 /* !! */ ;
        }
        var5_3 /* !! */  = zzbjl.zzm;
        var5_3 /* !! */  = (Boolean)zzbet.zzc().zzc(var5_3 /* !! */ ) != false ? zzckf.zza : zzckg.zza;
        return new zzasn(var1_1, (zzaty)var2_2, (zzapq)var5_3 /* !! */ , this.zzi.zzk, (Handler)com.google.android.gms.ads.internal.util.zzs.zza, (zzasm)this, null, this.zzi.zzg);
    }

    final /* synthetic */ zzatz zzU(zzaty zzaty2) {
        return new zzcjx(this.zzd, zzaty2.zza(), this.zzr, this.zzs, (zzauo)this, (zzcjw)new zzckh(this));
    }

    final /* synthetic */ void zzV(boolean bl, long l) {
        zzcir zzcir2 = this.zzn;
        if (zzcir2 == null) return;
        zzcir2.zza(bl, l);
    }

    final /* synthetic */ zzatz zzW(String string, boolean bl) {
        zzcki zzcki2 = true != bl ? null : this;
        zzcja zzcja2 = this.zzi;
        return new zzaud(string, null, (zzauo)zzcki2, zzcja2.zzd, zzcja2.zzf, true, null);
    }

    final /* synthetic */ zzatz zzX(String string, boolean bl) {
        zzcki zzcki2 = true != bl ? null : this;
        zzcja zzcja2 = this.zzi;
        string = new zzcju(string, (zzauo)zzcki2, zzcja2.zzd, zzcja2.zzf, zzcja2.zzi);
        this.zzw.add(new WeakReference<String>(string));
        return string;
    }

    public final void zza(zzanx zzanx2, Object object) {
    }

    public final void zzb(zzatg zzatg2, zzats zzats2) {
    }

    public final void zzc(boolean bl) {
    }

    public final void zzd(boolean bl, int n) {
        zzcir zzcir2 = this.zzn;
        if (zzcir2 == null) return;
        zzcir2.zzb(n);
    }

    public final void zze(zzamy zzamy2) {
        zzcir zzcir2 = this.zzn;
        if (zzcir2 == null) return;
        zzcir2.zzu("onPlayerError", (Exception)zzamy2);
    }

    public final void zzf() {
    }

    public final void zzg(zzanq zzanq2) {
    }

    public final void zzh(zzanm zzanm2) {
        zzcjb zzcjb2 = (zzcjb)this.zzm.get();
        Object object = zzbjl.zzbl;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
        if (zzcjb2 == null) return;
        if (zzanm2 == null) return;
        object = new HashMap();
        object.put("audioMime", zzanm2.zze);
        object.put("audioSampleMime", zzanm2.zzf);
        object.put("audioCodec", zzanm2.zzc);
        zzcjb2.zze("onMetadataEvent", (Map)object);
    }

    public final void zzi(IOException iOException) {
        zzcir zzcir2 = this.zzn;
        if (zzcir2 == null) return;
        if (this.zzi.zzl) {
            zzcir2.zzv("onLoadException", (Exception)iOException);
            return;
        }
        zzcir2.zzu("onLoadError", (Exception)iOException);
    }

    public final void zzl(zzanm zzanm2) {
        zzcjb zzcjb2 = (zzcjb)this.zzm.get();
        Object object = zzbjl.zzbl;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
        if (zzcjb2 == null) return;
        if (zzanm2 == null) return;
        object = new HashMap();
        object.put("frameRate", String.valueOf(zzanm2.zzl));
        object.put("bitRate", String.valueOf(zzanm2.zzb));
        int n = zzanm2.zzj;
        int n2 = zzanm2.zzk;
        StringBuilder stringBuilder = new StringBuilder(23);
        stringBuilder.append(n);
        stringBuilder.append("x");
        stringBuilder.append(n2);
        object.put("resolution", stringBuilder.toString());
        object.put("videoMime", zzanm2.zze);
        object.put("videoSampleMime", zzanm2.zzf);
        object.put("videoCodec", zzanm2.zzc);
        zzcjb2.zze("onMetadataEvent", (Map)object);
    }

    public final void zzm(int n, long l) {
        this.zzp += n;
    }

    public final void zzn(int n, int n2, int n3, float f) {
        zzcir zzcir2 = this.zzn;
        if (zzcir2 == null) return;
        zzcir2.zzc(n, n2);
    }

    public final void zzo(Surface surface) {
        surface = this.zzn;
        if (surface == null) return;
        surface.zzC();
    }

    public final void zzp(Uri[] uriArray, String string) {
        this.zzq(uriArray, string, ByteBuffer.allocate(0), false);
    }

    public final void zzq(Uri[] zzasr2, String string, ByteBuffer zzasrArray, boolean bl) {
        if (this.zzj == null) {
            return;
        }
        this.zzk = zzasrArray;
        this.zzl = bl;
        int n = ((Uri[])zzasr2).length;
        if (n == 1) {
            zzasr2 = this.zzT(zzasr2[0], string);
        } else {
            zzasrArray = new zzasr[n];
            for (int i = 0; i < ((Uri[])zzasr2).length; ++i) {
                zzasrArray[i] = this.zzT((Uri)zzasr2[i], string);
            }
            zzasr2 = new zzasv(zzasrArray);
        }
        this.zzj.zzd(zzasr2);
        zzb.incrementAndGet();
    }

    public final void zzr(zzcir zzcir2) {
        this.zzn = zzcir2;
    }

    public final void zzs() {
        zzanc zzanc2 = this.zzj;
        if (zzanc2 == null) return;
        zzanc2.zzb((zzamz)this);
        this.zzj.zzi();
        this.zzj = null;
        zzb.decrementAndGet();
    }

    public final void zzt(Surface surface, boolean bl) {
        if (this.zzj == null) {
            return;
        }
        surface = new zzanb((zzana)this.zzf, 1, (Object)surface);
        if (bl) {
            this.zzj.zzk(new zzanb[]{surface});
            return;
        }
        this.zzj.zzj(new zzanb[]{surface});
    }

    public final void zzu(float f, boolean bl) {
        if (this.zzj == null) {
            return;
        }
        zzanb zzanb2 = new zzanb((zzana)this.zzg, 2, (Object)Float.valueOf(f));
        if (bl) {
            this.zzj.zzk(new zzanb[]{zzanb2});
            return;
        }
        this.zzj.zzj(new zzanb[]{zzanb2});
    }

    public final void zzv() {
        this.zzj.zzh();
    }

    public final void zzw(long l) {
        this.zzj.zzg(l);
    }

    public final void zzx(int n) {
        this.zze.zzi(n);
    }

    public final void zzy(int n) {
        this.zze.zzj(n);
    }

    public final void zzz(int n) {
        Iterator<WeakReference<zzcju>> iterator = this.zzw.iterator();
        while (iterator.hasNext()) {
            zzcju zzcju2 = (zzcju)iterator.next().get();
            if (zzcju2 == null) continue;
            zzcju2.zzg(n);
        }
    }
}
