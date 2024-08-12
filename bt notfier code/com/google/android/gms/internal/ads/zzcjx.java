/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.IOUtils
 *  com.google.android.gms.internal.ads.zzatz
 *  com.google.android.gms.internal.ads.zzaub
 *  com.google.android.gms.internal.ads.zzauo
 *  com.google.android.gms.internal.ads.zzayn
 *  com.google.android.gms.internal.ads.zzayy
 *  com.google.android.gms.internal.ads.zzayz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcjv
 *  com.google.android.gms.internal.ads.zzcjw
 *  com.google.android.gms.internal.ads.zzcki
 *  com.google.android.gms.internal.ads.zzfmi
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.ads.zzatz;
import com.google.android.gms.internal.ads.zzaub;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzayn;
import com.google.android.gms.internal.ads.zzayy;
import com.google.android.gms.internal.ads.zzayz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcjv;
import com.google.android.gms.internal.ads.zzcjw;
import com.google.android.gms.internal.ads.zzcki;
import com.google.android.gms.internal.ads.zzfmi;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

public final class zzcjx
implements zzatz {
    private final zzauo<zzatz> zza;
    private final Context zzb;
    private final zzatz zzc;
    private final zzcjw zzd;
    private final String zze;
    private final int zzf;
    private final boolean zzg;
    private InputStream zzh;
    private boolean zzi;
    private Uri zzj;
    private volatile zzayn zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private long zzp;
    private zzfsm<Long> zzq;
    private final AtomicLong zzr;

    public zzcjx(Context context, zzatz zzatz2, String string, int n, zzauo<zzatz> zzauo2, zzcjw zzcjw2) {
        this.zzb = context;
        this.zzc = zzatz2;
        this.zza = zzauo2;
        this.zzd = zzcjw2;
        this.zze = string;
        this.zzf = n;
        this.zzl = false;
        this.zzm = false;
        this.zzn = false;
        this.zzo = false;
        this.zzp = 0L;
        this.zzr = new AtomicLong(-1L);
        this.zzq = null;
        context = zzbjl.zzbl;
        this.zzg = (Boolean)zzbet.zzc().zzc((zzbjd)context);
    }

    private final void zzl(zzaub zzaub2) {
        zzauo<zzatz> zzauo2 = this.zza;
        if (zzauo2 == null) return;
        ((zzcki)zzauo2).zzR((zzatz)this, zzaub2);
    }

    private final boolean zzm() {
        if (!this.zzg) {
            return false;
        }
        zzbjd zzbjd2 = zzbjl.zzcL;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            if (!this.zzn) return true;
        }
        zzbjd2 = zzbjl.zzcM;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return false;
        if (this.zzo) return false;
        return true;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final long zza(zzaub object) throws IOException {
        Object object2;
        block24: {
            block23: {
                void var1_5;
                long l;
                long l2;
                boolean bl;
                block20: {
                    block25: {
                        block26: {
                            boolean bl2;
                            block22: {
                                boolean bl3;
                                block21: {
                                    block18: {
                                        block19: {
                                            if (this.zzi) throw new IOException("Attempt to open an already open CacheDataSource.");
                                            bl = true;
                                            this.zzi = true;
                                            this.zzj = ((zzaub)object).zza;
                                            if (!this.zzg) {
                                                this.zzl((zzaub)object);
                                            }
                                            this.zzk = zzayn.zza((Uri)((zzaub)object).zza);
                                            object2 = zzbjl.zzcI;
                                            if (!((Boolean)zzbet.zzc().zzc((zzbjd)object2)).booleanValue()) break block23;
                                            if (this.zzk == null) break block24;
                                            this.zzk.zzh = ((zzaub)object).zzc;
                                            this.zzk.zzi = zzfmi.zza((String)this.zze);
                                            this.zzk.zzj = this.zzf;
                                            if (this.zzk.zzg) {
                                                object2 = zzbjl.zzcK;
                                                object2 = (Long)zzbet.zzc().zzc((zzbjd)object2);
                                            } else {
                                                object2 = zzbjl.zzcJ;
                                                object2 = (Long)zzbet.zzc().zzc((zzbjd)object2);
                                            }
                                            l2 = (Long)object2;
                                            l = zzt.zzj().elapsedRealtime();
                                            zzt.zzw();
                                            object2 = zzayy.zza((Context)this.zzb, (zzayn)this.zzk);
                                            zzayz zzayz2 = (zzayz)object2.get(l2, TimeUnit.MILLISECONDS);
                                            try {
                                                this.zzl = zzayz2.zzc();
                                                this.zzn = zzayz2.zzd();
                                                this.zzo = zzayz2.zzf();
                                                this.zzp = zzayz2.zze();
                                                if (this.zzm()) break block18;
                                                this.zzh = zzayz2.zzb();
                                                if (!this.zzg) break block19;
                                                this.zzl((zzaub)object);
                                            }
                                            catch (Throwable throwable) {
                                                break block20;
                                            }
                                            catch (InterruptedException interruptedException) {
                                                bl3 = true;
                                                break block21;
                                            }
                                            catch (ExecutionException | TimeoutException exception) {
                                                bl2 = true;
                                                break block22;
                                            }
                                        }
                                        l2 = zzt.zzj().elapsedRealtime() - l;
                                        this.zzd.zza(true, l2);
                                        this.zzm = true;
                                        object = new StringBuilder(44);
                                        ((StringBuilder)object).append("Cache connection took ");
                                        ((StringBuilder)object).append(l2);
                                        ((StringBuilder)object).append("ms");
                                        com.google.android.gms.ads.internal.util.zze.zza((String)((StringBuilder)object).toString());
                                        return -1L;
                                    }
                                    l2 = zzt.zzj().elapsedRealtime() - l;
                                    this.zzd.zza(true, l2);
                                    this.zzm = true;
                                    object2 = new StringBuilder(44);
                                    ((StringBuilder)object2).append("Cache connection took ");
                                    ((StringBuilder)object2).append(l2);
                                    ((StringBuilder)object2).append("ms");
                                    object2 = ((StringBuilder)object2).toString();
                                    break block25;
                                    catch (Throwable throwable) {
                                        bl = false;
                                        break block20;
                                    }
                                    catch (InterruptedException interruptedException) {
                                        bl3 = false;
                                    }
                                }
                                bl = bl3;
                                object2.cancel(true);
                                bl = bl3;
                                Thread.currentThread().interrupt();
                                l2 = zzt.zzj().elapsedRealtime() - l;
                                this.zzd.zza(bl3, l2);
                                this.zzm = bl3;
                                object2 = new StringBuilder(44);
                                break block26;
                                catch (ExecutionException | TimeoutException exception) {
                                    bl2 = false;
                                }
                            }
                            bl = bl2;
                            try {
                                object2.cancel(true);
                            }
                            catch (Throwable throwable) {
                                // empty catch block
                            }
                            l2 = zzt.zzj().elapsedRealtime() - l;
                            this.zzd.zza(bl2, l2);
                            this.zzm = bl2;
                            object2 = new StringBuilder(44);
                        }
                        ((StringBuilder)object2).append("Cache connection took ");
                        ((StringBuilder)object2).append(l2);
                        ((StringBuilder)object2).append("ms");
                        object2 = ((StringBuilder)object2).toString();
                    }
                    com.google.android.gms.ads.internal.util.zze.zza((String)object2);
                    break block24;
                }
                l2 = zzt.zzj().elapsedRealtime() - l;
                this.zzd.zza(bl, l2);
                this.zzm = bl;
                object2 = new StringBuilder(44);
                ((StringBuilder)object2).append("Cache connection took ");
                ((StringBuilder)object2).append(l2);
                ((StringBuilder)object2).append("ms");
                com.google.android.gms.ads.internal.util.zze.zza((String)((StringBuilder)object2).toString());
                throw var1_5;
            }
            if (this.zzk != null) {
                this.zzk.zzh = ((zzaub)object).zzc;
                this.zzk.zzi = zzfmi.zza((String)this.zze);
                this.zzk.zzj = this.zzf;
                object2 = zzt.zzi().zzf(this.zzk);
            } else {
                object2 = null;
            }
            if (object2 != null && object2.zza()) {
                this.zzl = object2.zzd();
                this.zzn = object2.zzg();
                this.zzo = object2.zze();
                this.zzp = object2.zzf();
                this.zzm = true;
                if (!this.zzm()) {
                    this.zzh = object2.zzb();
                    if (!this.zzg) return -1L;
                    this.zzl((zzaub)object);
                    return -1L;
                }
            }
        }
        this.zzm = false;
        object2 = object;
        if (this.zzk == null) return this.zzc.zza((zzaub)object2);
        object2 = new zzaub(Uri.parse((String)this.zzk.zza), null, ((zzaub)object).zzb, ((zzaub)object).zzc, ((zzaub)object).zzd, null, 0);
        return this.zzc.zza((zzaub)object2);
    }

    public final int zzb(byte[] object, int n, int n2) throws IOException {
        if (!this.zzi) throw new IOException("Attempt to read closed CacheDataSource.");
        InputStream inputStream = this.zzh;
        n = inputStream != null ? inputStream.read((byte[])object, n, n2) : this.zzc.zzb(object, n, n2);
        if (this.zzg) {
            if (this.zzh == null) return n;
        }
        if ((object = (Object)this.zza) == null) return n;
        ((zzcki)object).zzS((zzatz)this, n);
        return n;
    }

    public final Uri zzc() {
        return this.zzj;
    }

    public final void zzd() throws IOException {
        if (!this.zzi) throw new IOException("Attempt to close an already closed CacheDataSource.");
        this.zzi = false;
        this.zzj = null;
        InputStream inputStream = this.zzh;
        if (inputStream != null) {
            IOUtils.closeQuietly((Closeable)inputStream);
            this.zzh = null;
            return;
        }
        this.zzc.zzd();
    }

    public final boolean zze() {
        return this.zzl;
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        return this.zzn;
    }

    public final boolean zzh() {
        return this.zzo;
    }

    public final long zzi() {
        return this.zzp;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final long zzj() {
        if (this.zzk == null) {
            return -1L;
        }
        if (this.zzr.get() != -1L) {
            return this.zzr.get();
        }
        // MONITORENTER : this
        if (this.zzq == null) {
            zzfsn zzfsn2 = zzchg.zza;
            zzcjv zzcjv2 = new zzcjv(this);
            this.zzq = zzfsn2.zzb((Callable)zzcjv2);
        }
        // MONITOREXIT : this
        if (!this.zzq.isDone()) {
            return -1L;
        }
        try {
            this.zzr.compareAndSet(-1L, (Long)this.zzq.get());
            return this.zzr.get();
        }
        catch (InterruptedException | ExecutionException exception) {
            return -1L;
        }
    }

    final /* synthetic */ Long zzk() throws Exception {
        return zzt.zzi().zzg(this.zzk);
    }
}
