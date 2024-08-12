/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaku
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaku;

public final class zzakw {
    private final zzaku zza;
    private boolean zzb;

    public zzakw() {
        throw null;
    }

    public zzakw(zzaku zzaku2) {
        this.zza = zzaku2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean zza() {
        synchronized (this) {
            boolean bl = this.zzb;
            if (bl) {
                return false;
            }
            this.zzb = true;
            this.notifyAll();
            return true;
        }
    }

    public final boolean zzb() {
        synchronized (this) {
            boolean bl = this.zzb;
            this.zzb = false;
            return bl;
        }
    }

    public final void zzc() throws InterruptedException {
        synchronized (this) {
            try {
                while (!this.zzb) {
                    this.wait();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final void zzd() {
        synchronized (this) {
            boolean bl = false;
            try {
                while (true) {
                    boolean bl2;
                    if (bl2 = this.zzb) {
                        if (!bl) return;
                        Thread.currentThread().interrupt();
                        return;
                    }
                    try {
                        this.wait();
                    }
                    catch (InterruptedException interruptedException) {
                        bl = true;
                    }
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final boolean zze() {
        synchronized (this) {
            boolean bl = this.zzb;
            return bl;
        }
    }
}
