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
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzaei
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzafy
 *  com.google.android.gms.internal.ads.zzagb
 *  com.google.android.gms.internal.ads.zzagk
 *  com.google.android.gms.internal.ads.zzahc
 *  com.google.android.gms.internal.ads.zzahv
 *  com.google.android.gms.internal.ads.zzahy
 *  com.google.android.gms.internal.ads.zzai
 *  com.google.android.gms.internal.ads.zzaie
 *  com.google.android.gms.internal.ads.zzaiw
 *  com.google.android.gms.internal.ads.zzaj
 *  com.google.android.gms.internal.ads.zzakr
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzao
 *  com.google.android.gms.internal.ads.zzaw
 *  com.google.android.gms.internal.ads.zzay
 *  com.google.android.gms.internal.ads.zzba
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcir
 *  com.google.android.gms.internal.ads.zzcis
 *  com.google.android.gms.internal.ads.zzcja
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcll
 *  com.google.android.gms.internal.ads.zzclm
 *  com.google.android.gms.internal.ads.zzclo
 *  com.google.android.gms.internal.ads.zzclp
 *  com.google.android.gms.internal.ads.zzclr
 *  com.google.android.gms.internal.ads.zzcls
 *  com.google.android.gms.internal.ads.zzclt
 *  com.google.android.gms.internal.ads.zzclu
 *  com.google.android.gms.internal.ads.zzclv
 *  com.google.android.gms.internal.ads.zzclw
 *  com.google.android.gms.internal.ads.zzclx
 *  com.google.android.gms.internal.ads.zzcly
 *  com.google.android.gms.internal.ads.zzclz
 *  com.google.android.gms.internal.ads.zzcma
 *  com.google.android.gms.internal.ads.zzcz
 *  com.google.android.gms.internal.ads.zzda
 *  com.google.android.gms.internal.ads.zzde
 *  com.google.android.gms.internal.ads.zzdq
 *  com.google.android.gms.internal.ads.zzdw
 *  com.google.android.gms.internal.ads.zzen
 *  com.google.android.gms.internal.ads.zzer
 *  com.google.android.gms.internal.ads.zzflf
 *  com.google.android.gms.internal.ads.zzfm
 *  com.google.android.gms.internal.ads.zzfs
 *  com.google.android.gms.internal.ads.zzgx
 *  com.google.android.gms.internal.ads.zzhc
 *  com.google.android.gms.internal.ads.zzhh
 *  com.google.android.gms.internal.ads.zzhv
 *  com.google.android.gms.internal.ads.zzij
 *  com.google.android.gms.internal.ads.zzjo
 *  com.google.android.gms.internal.ads.zzjt
 *  com.google.android.gms.internal.ads.zzjz
 *  com.google.android.gms.internal.ads.zzlz
 *  com.google.android.gms.internal.ads.zzmu
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzy
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzaei;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzafy;
import com.google.android.gms.internal.ads.zzagb;
import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzahc;
import com.google.android.gms.internal.ads.zzahv;
import com.google.android.gms.internal.ads.zzahy;
import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzaie;
import com.google.android.gms.internal.ads.zzaiw;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzakr;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzao;
import com.google.android.gms.internal.ads.zzaw;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzba;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcir;
import com.google.android.gms.internal.ads.zzcis;
import com.google.android.gms.internal.ads.zzcja;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcll;
import com.google.android.gms.internal.ads.zzclm;
import com.google.android.gms.internal.ads.zzclo;
import com.google.android.gms.internal.ads.zzclp;
import com.google.android.gms.internal.ads.zzclr;
import com.google.android.gms.internal.ads.zzcls;
import com.google.android.gms.internal.ads.zzclt;
import com.google.android.gms.internal.ads.zzclu;
import com.google.android.gms.internal.ads.zzclv;
import com.google.android.gms.internal.ads.zzclw;
import com.google.android.gms.internal.ads.zzclx;
import com.google.android.gms.internal.ads.zzcly;
import com.google.android.gms.internal.ads.zzclz;
import com.google.android.gms.internal.ads.zzcma;
import com.google.android.gms.internal.ads.zzcz;
import com.google.android.gms.internal.ads.zzda;
import com.google.android.gms.internal.ads.zzde;
import com.google.android.gms.internal.ads.zzdq;
import com.google.android.gms.internal.ads.zzdw;
import com.google.android.gms.internal.ads.zzen;
import com.google.android.gms.internal.ads.zzer;
import com.google.android.gms.internal.ads.zzflf;
import com.google.android.gms.internal.ads.zzfm;
import com.google.android.gms.internal.ads.zzfs;
import com.google.android.gms.internal.ads.zzgx;
import com.google.android.gms.internal.ads.zzhc;
import com.google.android.gms.internal.ads.zzhh;
import com.google.android.gms.internal.ads.zzhv;
import com.google.android.gms.internal.ads.zzij;
import com.google.android.gms.internal.ads.zzjo;
import com.google.android.gms.internal.ads.zzjt;
import com.google.android.gms.internal.ads.zzjz;
import com.google.android.gms.internal.ads.zzlz;
import com.google.android.gms.internal.ads.zzmu;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzy;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzcmb
extends zzcis
implements zzay,
zzda {
    public static final int zzc = 0;
    private final Context zzd;
    private final zzclm zze;
    private final zzjt zzf;
    private final zzcja zzg;
    private final WeakReference<zzcjb> zzh;
    private final zzij zzi;
    private zzaie zzj;
    private ByteBuffer zzk;
    private boolean zzl;
    private zzcir zzm;
    private int zzn;
    private int zzo;
    private long zzp;
    private final String zzq;
    private final int zzr;
    private final Object zzs;
    private final ArrayList<zzaw> zzt;
    private volatile zzclp zzu;
    private final Set<WeakReference<zzcll>> zzv;

    public zzcmb(Context object, zzcja object2, zzcjb object3) {
        block9: {
            boolean bl;
            block12: {
                block11: {
                    block10: {
                        block8: {
                            this.zzs = new Object();
                            this.zzv = new HashSet<WeakReference<zzcll>>();
                            this.zzd = object;
                            this.zzg = object2;
                            this.zzh = new WeakReference<zzcjb>((zzcjb)object3);
                            this.zze = new zzclm();
                            this.zzf = new zzjt(this.zzd);
                            if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                                com.google.android.gms.ads.internal.util.zze.zza((String)"OfficialSimpleExoPlayerAdapter initialize ".concat(((Object)((Object)this)).toString()));
                            }
                            zza.incrementAndGet();
                            object2 = new zzaei(this.zzd, (zzahy)new zzclx(this));
                            object2.zza((zzjz)this.zzf);
                            object2.zzb((zzafy)this.zze);
                            this.zzj = object2.zzc();
                            object2 = zzbjl.zzbo;
                            boolean bl2 = (Boolean)zzbet.zzc().zzc((zzbjd)object2);
                            bl = false;
                            if (!bl2) {
                                this.zzj.zzR(false);
                            }
                            this.zzj.zzG((zzda)this);
                            this.zzn = 0;
                            this.zzp = 0L;
                            this.zzo = 0;
                            this.zzt = new ArrayList();
                            this.zzu = null;
                            object2 = object3 != null && object3.zzn() != null ? object3.zzn() : "";
                            this.zzq = object2;
                            int n = object3 != null ? object3.zzp() : 0;
                            this.zzr = n;
                            object = com.google.android.gms.ads.internal.zzt.zzc().zzi(object, object3.zzt().zza);
                            if (!this.zzl || this.zzk.limit() <= 0) break block8;
                            object = new byte[this.zzk.limit()];
                            this.zzk.get((byte[])object);
                            object = new zzcls((byte[])object);
                            break block9;
                        }
                        object2 = zzbjl.zzbq;
                        if (!((Boolean)zzbet.zzc().zzc((zzbjd)object2)).booleanValue()) break block10;
                        object2 = zzbjl.zzbl;
                        if (((Boolean)zzbet.zzc().zzc((zzbjd)object2)).booleanValue()) break block11;
                    }
                    if (this.zzg.zzj) break block12;
                }
                bl = true;
            }
            object = this.zzg.zzi > 0 ? new zzclt(this, (String)object, bl) : new zzclu(this, (String)object, bl);
            object2 = object;
            if (this.zzg.zzj) {
                object2 = new zzclv(this, (zzai)object);
            }
            object3 = this.zzk;
            object = object2;
            if (object3 != null) {
                object = object2;
                if (((Buffer)object3).limit() > 0) {
                    object = new byte[this.zzk.limit()];
                    this.zzk.get((byte[])object);
                    object = new zzclw((zzai)object2, (byte[])object);
                }
            }
        }
        object2 = zzbjl.zzm;
        object2 = (Boolean)zzbet.zzc().zzc((zzbjd)object2) != false ? zzcly.zza : zzclz.zza;
        this.zzi = new zzij((zzai)object, (zzoa)object2);
    }

    private final boolean zzU() {
        if (this.zzu == null) return false;
        if (!this.zzu.zzl()) return false;
        return true;
    }

    public final void finalize() {
        zza.decrementAndGet();
        if (!com.google.android.gms.ads.internal.util.zze.zzc()) return;
        com.google.android.gms.ads.internal.util.zze.zza((String)"OfficialSimpleExoPlayerAdapter finalize ".concat(((Object)((Object)this)).toString()));
    }

    public final boolean zzA() {
        if (this.zzj == null) return false;
        return true;
    }

    public final int zzB() {
        return this.zzj.zzI();
    }

    public final long zzC() {
        return this.zzj.zzx();
    }

    public final boolean zzD() {
        return this.zzj.zzM();
    }

    public final void zzE(boolean bl) {
        this.zzj.zzL(bl);
    }

    public final void zzF(int n) {
        this.zze.zzj(n);
    }

    public final void zzG(int n) {
        this.zze.zzk(n);
    }

    public final long zzH() {
        return this.zzj.zzP();
    }

    public final long zzI() {
        if (this.zzU()) return 0L;
        return this.zzn;
    }

    public final long zzJ() {
        if (!this.zzU()) {
            return 0L;
        }
        if (this.zzu.zzm()) return Math.min((long)this.zzn, this.zzu.zzo());
        return 0L;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final long zzK() {
        if (this.zzU()) return this.zzu.zzp();
        Object object = this.zzs;
        synchronized (object) {
            while (!this.zzt.isEmpty()) {
                long l;
                long l2 = this.zzp;
                Object object2 = this.zzt.remove(0).zzf();
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
                this.zzp = l2 + l3;
            }
            return this.zzp;
        }
    }

    public final int zzL() {
        return this.zzo;
    }

    public final void zzM(boolean bl) {
        if (this.zzj == null) return;
        int n = 0;
        while (true) {
            this.zzj.zzO();
            if (n >= 2) return;
            zzjt zzjt2 = this.zzf;
            zzjo zzjo2 = zzjt2.zzc().zzg();
            zzjo2.zzs(n, bl ^ true);
            zzjt2.zzd(zzjo2);
            ++n;
        }
    }

    public final long zzN() {
        return this.zzj.zzQ();
    }

    public final long zzO() {
        return this.zzn;
    }

    final /* synthetic */ void zzR(boolean bl, long l) {
        zzcir zzcir2 = this.zzm;
        if (zzcir2 == null) return;
        zzcir2.zza(bl, l);
    }

    final /* synthetic */ zzaj zzS(String object, boolean bl) {
        zzao zzao2 = new zzao();
        zzao2.zzb(object);
        object = true != bl ? null : this;
        zzao2.zzf((zzay)object);
        zzao2.zzc(this.zzg.zzd);
        zzao2.zzd(this.zzg.zzf);
        zzao2.zze(true);
        return zzao2.zzg();
    }

    final /* synthetic */ zzaj zzT(String string, boolean bl) {
        zzcmb zzcmb2 = true != bl ? null : this;
        zzcja zzcja2 = this.zzg;
        string = new zzcll(string, (zzay)zzcmb2, zzcja2.zzd, zzcja2.zzf, zzcja2.zzi);
        this.zzv.add(new WeakReference<String>(string));
        return string;
    }

    public final void zza(zzaj zzaj2, zzan zzan2, boolean bl) {
    }

    public final void zzb(zzaj zzaj2, zzan object, boolean bl) {
        if (!(zzaj2 instanceof zzaw)) {
            if (!(zzaj2 instanceof zzclp)) return;
            this.zzu = (zzclp)zzaj2;
            zzaj2 = (zzcjb)this.zzh.get();
            object = zzbjl.zzbl;
            if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
            if (zzaj2 == null) return;
            if (!this.zzu.zzk()) return;
            object = new HashMap();
            object.put("gcacheHit", String.valueOf(this.zzu.zzm()));
            object.put("gcacheDownloaded", String.valueOf(this.zzu.zzn()));
            com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzclr((zzcjb)zzaj2, (Map)object));
            return;
        }
        object = this.zzs;
        synchronized (object) {
            this.zzt.add((zzaw)zzaj2);
            return;
        }
    }

    public final void zzc(zzaj zzaj2, zzan zzan2, boolean bl, int n) {
        this.zzn += n;
    }

    public final void zzd(zzaj zzaj2, zzan zzan2, boolean bl) {
    }

    public final void zze(zzcz zzcz2, int n) {
        zzcz2 = this.zzm;
        if (zzcz2 == null) return;
        zzcz2.zzb(n);
    }

    public final void zzf(zzcz zzcz2, zzahc zzahc2) {
        zzcz2 = this.zzm;
        if (zzcz2 == null) return;
        zzcz2.zzu("onPlayerError", (Exception)zzahc2);
    }

    public final void zzg(zzcz zzcz2, zzgx zzgx2, zzhc zzhc2, IOException iOException, boolean bl) {
        zzcz2 = this.zzm;
        if (zzcz2 == null) return;
        if (this.zzg.zzl) {
            zzcz2.zzv("onLoadException", (Exception)iOException);
            return;
        }
        zzcz2.zzu("onLoadError", (Exception)iOException);
    }

    public final void zzh(zzcz zzcz2, zzafv zzafv2, zzba object) {
        zzcz2 = (zzcjb)this.zzh.get();
        object = zzbjl.zzbl;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
        if (zzcz2 == null) return;
        if (zzafv2 == null) return;
        object = new HashMap();
        object.put("audioMime", zzafv2.zzk);
        object.put("audioSampleMime", zzafv2.zzl);
        object.put("audioCodec", zzafv2.zzi);
        zzcz2.zze("onMetadataEvent", (Map)object);
    }

    public final void zzi(zzcz zzcz2, zzafv zzafv2, zzba object) {
        zzcz2 = (zzcjb)this.zzh.get();
        object = zzbjl.zzbl;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
        if (zzcz2 == null) return;
        if (zzafv2 == null) return;
        object = new HashMap();
        object.put("frameRate", String.valueOf(zzafv2.zzs));
        object.put("bitRate", String.valueOf(zzafv2.zzh));
        int n = zzafv2.zzq;
        int n2 = zzafv2.zzr;
        StringBuilder stringBuilder = new StringBuilder(23);
        stringBuilder.append(n);
        stringBuilder.append("x");
        stringBuilder.append(n2);
        object.put("resolution", stringBuilder.toString());
        object.put("videoMime", zzafv2.zzk);
        object.put("videoSampleMime", zzafv2.zzl);
        object.put("videoCodec", zzafv2.zzi);
        zzcz2.zze("onMetadataEvent", (Map)object);
    }

    public final void zzj(zzcz zzcz2, int n, long l) {
        this.zzo += n;
    }

    public final void zzk(zzcz zzcz2, Object object, long l) {
        zzcz2 = this.zzm;
        if (zzcz2 == null) return;
        zzcz2.zzC();
    }

    public final void zzl(zzcz zzcz2, zzy zzy2) {
        zzcz2 = this.zzm;
        if (zzcz2 == null) return;
        zzcz2.zzc(zzy2.zzb, zzy2.zzc);
    }

    final zzhh zzm(Uri uri) {
        zzagb zzagb2 = new zzagb();
        zzagb2.zzb(uri);
        uri = zzagb2.zzc();
        zzagb2 = this.zzi;
        zzagb2.zza(this.zzg.zzg);
        return zzagb2.zzb((zzagk)uri);
    }

    final /* synthetic */ zzahv[] zzn(Handler handler, zzmu zzmu2, zzdq zzdq2, zzakr zzakr2, zzaiw zzaiw2) {
        zzakr2 = this.zzd;
        zzaiw2 = zzfs.zzb;
        zzen zzen2 = new zzen(null, new zzde[0], false);
        zzakr2 = new zzer((Context)zzakr2, zzfm.zza, (zzfs)zzaiw2, false, handler, zzdq2, (zzdw)zzen2);
        zzdq2 = this.zzd;
        zzaiw2 = zzfs.zzb;
        return new zzahv[]{zzakr2, new zzlz((Context)zzdq2, zzfm.zza, (zzfs)zzaiw2, 0L, false, handler, zzmu2, -1)};
    }

    final /* synthetic */ zzaj zzo(zzai zzai2) {
        return new zzclp(this.zzd, zzai2.zza(), this.zzq, this.zzr, (zzay)this, (zzclo)new zzcma(this));
    }

    public final void zzp(Uri[] uriArray, String string) {
        this.zzq(uriArray, string, ByteBuffer.allocate(0), false);
    }

    public final void zzq(Uri[] zzhh2, String zzhhArray, ByteBuffer byteBuffer, boolean bl) {
        if (this.zzj == null) {
            return;
        }
        this.zzk = byteBuffer;
        this.zzl = bl;
        int n = ((Uri[])zzhh2).length;
        if (n == 1) {
            zzhh2 = this.zzm(zzhh2[0]);
        } else {
            zzhhArray = new zzhh[n];
            for (n = 0; n < ((zzhh)zzhh2).length; ++n) {
                zzhhArray[n] = this.zzm((Uri)zzhh2[n]);
            }
            zzhh2 = new zzhv(false, false, zzhhArray);
        }
        this.zzj.zzK(zzhh2);
        this.zzj.zzJ();
        zzb.incrementAndGet();
    }

    public final void zzr(zzcir zzcir2) {
        this.zzm = zzcir2;
    }

    public final void zzs() {
        zzaie zzaie2 = this.zzj;
        if (zzaie2 == null) return;
        zzaie2.zzH((zzda)this);
        this.zzj.zzN();
        this.zzj = null;
        zzb.decrementAndGet();
    }

    public final void zzt(Surface surface, boolean bl) {
        zzaie zzaie2 = this.zzj;
        if (zzaie2 == null) {
            return;
        }
        zzaie2.zzy(surface);
    }

    public final void zzu(float f, boolean bl) {
        zzaie zzaie2 = this.zzj;
        if (zzaie2 == null) {
            return;
        }
        zzaie2.zzE(f);
    }

    public final void zzv() {
        this.zzj.zzq(false);
    }

    public final void zzw(long l) {
        zzaie zzaie2 = this.zzj;
        zzaie2.zzp(zzaie2.zzv(), l);
    }

    public final void zzx(int n) {
        this.zze.zzl(n);
    }

    public final void zzy(int n) {
        this.zze.zzm(n);
    }

    public final void zzz(int n) {
        Iterator<WeakReference<zzcll>> iterator = this.zzv.iterator();
        while (iterator.hasNext()) {
            zzcll zzcll2 = (zzcll)iterator.next().get();
            if (zzcll2 == null) continue;
            zzcll2.zzl(n);
        }
    }
}
