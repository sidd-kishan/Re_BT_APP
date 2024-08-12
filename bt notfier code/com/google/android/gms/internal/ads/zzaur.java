/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzaur {
    private boolean zza;

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean zza() {
        synchronized (this) {
            boolean bl = this.zza;
            if (bl) {
                return false;
            }
            this.zza = true;
            this.notifyAll();
            return true;
        }
    }

    public final boolean zzb() {
        synchronized (this) {
            boolean bl = this.zza;
            this.zza = false;
            return bl;
        }
    }

    public final void zzc() throws InterruptedException {
        synchronized (this) {
            try {
                while (!this.zza) {
                    this.wait();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
