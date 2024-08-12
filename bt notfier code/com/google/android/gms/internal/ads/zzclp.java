/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.IOUtils
 *  com.google.android.gms.internal.ads.zzag
 *  com.google.android.gms.internal.ads.zzaj
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzay
 *  com.google.android.gms.internal.ads.zzayn
 *  com.google.android.gms.internal.ads.zzayy
 *  com.google.android.gms.internal.ads.zzayz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcln
 *  com.google.android.gms.internal.ads.zzclo
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
import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzayn;
import com.google.android.gms.internal.ads.zzayy;
import com.google.android.gms.internal.ads.zzayz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcln;
import com.google.android.gms.internal.ads.zzclo;
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

public final class zzclp
extends zzag {
    private final Context zza;
    private final zzaj zzb;
    private final zzclo zzc;
    private final String zzd;
    private final int zze;
    private final boolean zzf;
    private InputStream zzg;
    private boolean zzh;
    private Uri zzi;
    private volatile zzayn zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private long zzo;
    private zzfsm<Long> zzp;
    private final AtomicLong zzq;

    public zzclp(Context context, zzaj zzaj2, String string, int n, zzay zzay2, zzclo zzclo2) {
        super(false);
        this.zza = context;
        this.zzb = zzaj2;
        this.zzc = zzclo2;
        this.zzd = string;
        this.zze = n;
        this.zzk = false;
        this.zzl = false;
        this.zzm = false;
        this.zzn = false;
        this.zzo = 0L;
        this.zzq = new AtomicLong(-1L);
        this.zzp = null;
        context = zzbjl.zzbl;
        this.zzf = (Boolean)zzbet.zzc().zzc((zzbjd)context);
        this.zza(zzay2);
    }

    private final boolean zzr() {
        if (!this.zzf) {
            return false;
        }
        zzbjd zzbjd2 = zzbjl.zzcL;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            if (!this.zzm) return true;
        }
        zzbjd2 = zzbjl.zzcM;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return false;
        if (this.zzn) return false;
        return true;
    }

    public final int zzg(byte[] byArray, int n, int n2) throws IOException {
        if (!this.zzh) throw new IOException("Attempt to read closed GcacheDataSource.");
        InputStream inputStream = this.zzg;
        n = inputStream != null ? inputStream.read(byArray, n, n2) : this.zzb.zzg(byArray, n, n2);
        if (this.zzf) {
            if (this.zzg == null) return n;
        }
        this.zzd(n);
        return n;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final long zzh(zzan object) throws IOException {
        long l;
        long l2;
        Object object2;
        block24: {
            block23: {
                void var1_5;
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
                                            if (this.zzh) throw new IOException("Attempt to open an already open GcacheDataSource.");
                                            bl = true;
                                            this.zzh = true;
                                            this.zzi = ((zzan)object).zza;
                                            if (!this.zzf) {
                                                this.zzc((zzan)object);
                                            }
                                            this.zzj = zzayn.zza((Uri)((zzan)object).zza);
                                            object2 = zzbjl.zzcI;
                                            if (!((Boolean)zzbet.zzc().zzc((zzbjd)object2)).booleanValue()) break block23;
                                            if (this.zzj == null) break block24;
                                            this.zzj.zzh = ((zzan)object).zzf;
                                            this.zzj.zzi = zzfmi.zza((String)this.zzd);
                                            this.zzj.zzj = this.zze;
                                            if (this.zzj.zzg) {
                                                object2 = zzbjl.zzcK;
                                                object2 = (Long)zzbet.zzc().zzc((zzbjd)object2);
                                            } else {
                                                object2 = zzbjl.zzcJ;
                                                object2 = (Long)zzbet.zzc().zzc((zzbjd)object2);
                                            }
                                            l2 = (Long)object2;
                                            l = zzt.zzj().elapsedRealtime();
                                            zzt.zzw();
                                            object2 = zzayy.zza((Context)this.zza, (zzayn)this.zzj);
                                            zzayz zzayz2 = (zzayz)object2.get(l2, TimeUnit.MILLISECONDS);
                                            try {
                                                this.zzk = zzayz2.zzc();
                                                this.zzm = zzayz2.zzd();
                                                this.zzn = zzayz2.zzf();
                                                this.zzo = zzayz2.zze();
                                                if (this.zzr()) break block18;
                                                this.zzg = zzayz2.zzb();
                                                if (!this.zzf) break block19;
                                                this.zzc((zzan)object);
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
                                        l = zzt.zzj().elapsedRealtime() - l;
                                        this.zzc.zza(true, l);
                                        this.zzl = true;
                                        object = new StringBuilder(44);
                                        ((StringBuilder)object).append("Cache connection took ");
                                        ((StringBuilder)object).append(l);
                                        ((StringBuilder)object).append("ms");
                                        com.google.android.gms.ads.internal.util.zze.zza((String)((StringBuilder)object).toString());
                                        return -1L;
                                    }
                                    l = zzt.zzj().elapsedRealtime() - l;
                                    this.zzc.zza(true, l);
                                    this.zzl = true;
                                    object2 = new StringBuilder(44);
                                    ((StringBuilder)object2).append("Cache connection took ");
                                    ((StringBuilder)object2).append(l);
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
                                l = zzt.zzj().elapsedRealtime() - l;
                                this.zzc.zza(bl3, l);
                                this.zzl = bl3;
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
                            l = zzt.zzj().elapsedRealtime() - l;
                            this.zzc.zza(bl2, l);
                            this.zzl = bl2;
                            object2 = new StringBuilder(44);
                        }
                        ((StringBuilder)object2).append("Cache connection took ");
                        ((StringBuilder)object2).append(l);
                        ((StringBuilder)object2).append("ms");
                        object2 = ((StringBuilder)object2).toString();
                    }
                    com.google.android.gms.ads.internal.util.zze.zza((String)object2);
                    break block24;
                }
                l = zzt.zzj().elapsedRealtime() - l;
                this.zzc.zza(bl, l);
                this.zzl = bl;
                object2 = new StringBuilder(44);
                ((StringBuilder)object2).append("Cache connection took ");
                ((StringBuilder)object2).append(l);
                ((StringBuilder)object2).append("ms");
                com.google.android.gms.ads.internal.util.zze.zza((String)((StringBuilder)object2).toString());
                throw var1_5;
            }
            if (this.zzj != null) {
                this.zzj.zzh = ((zzan)object).zzf;
                this.zzj.zzi = zzfmi.zza((String)this.zzd);
                this.zzj.zzj = this.zze;
                object2 = zzt.zzi().zzf(this.zzj);
            } else {
                object2 = null;
            }
            if (object2 != null && object2.zza()) {
                this.zzk = object2.zzd();
                this.zzm = object2.zzg();
                this.zzn = object2.zze();
                this.zzo = object2.zzf();
                this.zzl = true;
                if (!this.zzr()) {
                    this.zzg = object2.zzb();
                    if (!this.zzf) return -1L;
                    this.zzc((zzan)object);
                    return -1L;
                }
            }
        }
        this.zzl = false;
        object2 = object;
        if (this.zzj == null) return this.zzb.zzh((zzan)object2);
        object2 = Uri.parse((String)this.zzj.zza);
        byte[] byArray = ((zzan)object).zzc;
        l2 = ((zzan)object).zze;
        long l3 = ((zzan)object).zzf;
        l = ((zzan)object).zzg;
        String string = ((zzan)object).zzh;
        object2 = new zzan((Uri)object2, null, l2, l3, l, null, ((zzan)object).zzi);
        return this.zzb.zzh((zzan)object2);
    }

    public final Uri zzi() {
        return this.zzi;
    }

    public final void zzj() throws IOException {
        InputStream inputStream;
        if (!this.zzh) throw new IOException("Attempt to close an already closed GcacheDataSource.");
        boolean bl = false;
        this.zzh = false;
        this.zzi = null;
        if (!this.zzf || this.zzg != null) {
            bl = true;
        }
        if ((inputStream = this.zzg) != null) {
            IOUtils.closeQuietly((Closeable)inputStream);
            this.zzg = null;
        } else {
            this.zzb.zzj();
        }
        if (!bl) return;
        this.zze();
    }

    public final boolean zzk() {
        return this.zzk;
    }

    public final boolean zzl() {
        return this.zzl;
    }

    public final boolean zzm() {
        return this.zzm;
    }

    public final boolean zzn() {
        return this.zzn;
    }

    public final long zzo() {
        return this.zzo;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final long zzp() {
        if (this.zzj == null) {
            return -1L;
        }
        if (this.zzq.get() != -1L) {
            return this.zzq.get();
        }
        // MONITORENTER : this
        if (this.zzp == null) {
            zzfsn zzfsn2 = zzchg.zza;
            zzcln zzcln2 = new zzcln(this);
            this.zzp = zzfsn2.zzb((Callable)zzcln2);
        }
        // MONITOREXIT : this
        if (!this.zzp.isDone()) {
            return -1L;
        }
        try {
            this.zzq.compareAndSet(-1L, (Long)this.zzp.get());
            return this.zzq.get();
        }
        catch (InterruptedException | ExecutionException exception) {
            return -1L;
        }
    }

    final /* synthetic */ Long zzq() throws Exception {
        return zzt.zzi().zzg(this.zzj);
    }
}
