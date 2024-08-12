/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  com.google.android.gms.internal.ads.zzvl
 *  com.google.android.gms.internal.ads.zzvm
 *  com.google.android.gms.internal.ads.zzvn
 *  com.google.android.gms.internal.ads.zzvt
 *  com.google.android.gms.internal.ads.zzvy
 *  com.google.android.gms.internal.ads.zzwc
 *  com.google.android.gms.internal.ads.zzwi
 *  com.google.android.gms.internal.ads.zzwo
 *  com.google.android.gms.internal.ads.zzwp
 */
package com.google.android.gms.internal.ads;

import android.os.Process;
import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzvm;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzvy;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwi;
import com.google.android.gms.internal.ads.zzwo;
import com.google.android.gms.internal.ads.zzwp;
import java.util.concurrent.BlockingQueue;

public final class zzvo
extends Thread {
    private static final boolean zza = zzwo.zzb;
    private final BlockingQueue<zzwc<?>> zzb;
    private final BlockingQueue<zzwc<?>> zzc;
    private final zzvm zzd;
    private volatile boolean zze = false;
    private final zzwp zzf;
    private final zzvt zzg;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zzvo(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzvm zzvm2, zzvt zzvt2, byte[] byArray) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzvm2;
        this.zzg = zzvt2;
        this.zzf = new zzwp(this, blockingQueue2, zzvt2, null);
    }

    static /* synthetic */ BlockingQueue zza(zzvo zzvo2) {
        return zzvo2.zzc;
    }

    private void zzc() throws InterruptedException {
        zzwc<?> zzwc2 = this.zzb.take();
        zzwc2.zzd("cache-queue-take");
        zzwc2.zzf(1);
        try {
            zzwc2.zzm();
            zzvl zzvl2 = this.zzd.zza(zzwc2.zzj());
            if (zzvl2 == null) {
                zzwc2.zzd("cache-miss");
                if (this.zzf.zzc(zzwc2)) return;
                this.zzc.put(zzwc2);
                return;
            }
            long l = System.currentTimeMillis();
            if (zzvl2.zza(l)) {
                zzwc2.zzd("cache-hit-expired");
                zzwc2.zzk(zzvl2);
                if (this.zzf.zzc(zzwc2)) return;
                this.zzc.put(zzwc2);
                return;
            }
            zzwc2.zzd("cache-hit");
            zzvy zzvy2 = new zzvy(zzvl2.zza, zzvl2.zzg);
            zzvy2 = zzwc2.zzs(zzvy2);
            zzwc2.zzd("cache-hit-parsed");
            if (!zzvy2.zzc()) {
                zzwc2.zzd("cache-parsing-failed");
                this.zzd.zzd(zzwc2.zzj(), true);
                zzwc2.zzk(null);
                if (this.zzf.zzc(zzwc2)) return;
                this.zzc.put(zzwc2);
                return;
            }
            if (zzvl2.zzf < l) {
                zzwc2.zzd("cache-hit-refresh-needed");
                zzwc2.zzk(zzvl2);
                zzvy2.zzd = true;
                if (!this.zzf.zzc(zzwc2)) {
                    zzvl2 = this.zzg;
                    zzvn zzvn2 = new zzvn(this, zzwc2);
                    zzvl2.zza(zzwc2, (zzwi)zzvy2, (Runnable)zzvn2);
                } else {
                    this.zzg.zza(zzwc2, (zzwi)zzvy2, null);
                }
            } else {
                this.zzg.zza(zzwc2, (zzwi)zzvy2, null);
            }
            return;
        }
        finally {
            zzwc2.zzf(2);
        }
    }

    @Override
    public final void run() {
        if (zza) {
            zzwo.zza((String)"start new dispatcher", (Object[])new Object[0]);
        }
        Process.setThreadPriority((int)10);
        this.zzd.zzc();
        while (true) {
            try {
                while (true) {
                    this.zzc();
                }
            }
            catch (InterruptedException interruptedException) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzwo.zzc((String)"Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", (Object[])new Object[0]);
                continue;
            }
            break;
        }
    }

    public final void zzb() {
        this.zze = true;
        this.interrupt();
    }
}
