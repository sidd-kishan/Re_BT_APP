/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfsi
 *  com.google.android.gms.internal.ads.zzfsj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfsi;
import com.google.android.gms.internal.ads.zzfsj;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

abstract class zzfsl<T>
extends AtomicReference<Runnable>
implements Runnable {
    private static final Runnable zza = new zzfsj(null);
    private static final Runnable zzb = new zzfsj(null);

    zzfsl() {
    }

    private final void zzb(Thread thread) {
        Runnable runnable = (Runnable)this.get();
        zzfsi zzfsi2 = null;
        int n = 0;
        int n2 = 0;
        while (true) {
            int n3;
            block8: {
                block6: {
                    block7: {
                        if (!(runnable instanceof zzfsi)) {
                            if (runnable != zzb) {
                                if (n == 0) return;
                                thread.interrupt();
                                return;
                            }
                        } else {
                            zzfsi2 = (zzfsi)runnable;
                        }
                        if ((n3 = n2 + 1) <= 1000) break block6;
                        Runnable runnable2 = zzb;
                        if (runnable == runnable2) break block7;
                        n2 = n;
                        if (!this.compareAndSet(runnable, runnable2)) break block8;
                    }
                    n = !Thread.interrupted() && n == 0 ? 0 : 1;
                    LockSupport.park(zzfsi2);
                    n2 = n;
                    break block8;
                }
                Thread.yield();
                n2 = n;
            }
            runnable = (Runnable)this.get();
            n = n2;
            n2 = n3;
        }
    }

    @Override
    public final void run() {
        Thread thread = Thread.currentThread();
        T t = null;
        if (!this.compareAndSet(null, thread)) {
            return;
        }
        boolean bl = this.zzd() ^ true;
        if (bl) {
            try {
                t = this.zza();
            }
            catch (Throwable throwable) {
                if (!this.compareAndSet(thread, zza)) {
                    this.zzb(thread);
                }
                this.zzg(throwable);
                return;
            }
        }
        if (!this.compareAndSet(thread, zza)) {
            this.zzb(thread);
        }
        if (!bl) return;
        this.zzf(t);
    }

    @Override
    public final String toString() {
        CharSequence charSequence;
        Object object = (Runnable)this.get();
        if (object == zza) {
            object = "running=[DONE]";
        } else if (object instanceof zzfsi) {
            object = "running=[INTERRUPTED]";
        } else if (object instanceof Thread) {
            object = ((Thread)object).getName();
            charSequence = new StringBuilder(String.valueOf(object).length() + 21);
            ((StringBuilder)charSequence).append("running=[RUNNING ON ");
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append("]");
            object = ((StringBuilder)charSequence).toString();
        } else {
            object = "running=[NOT STARTED YET]";
        }
        charSequence = this.zzc();
        int n = String.valueOf(charSequence).length();
        StringBuilder stringBuilder = new StringBuilder(((String)object).length() + 2 + n);
        stringBuilder.append((String)object);
        stringBuilder.append(", ");
        stringBuilder.append((String)charSequence);
        return stringBuilder.toString();
    }

    abstract T zza() throws Exception;

    abstract String zzc();

    abstract boolean zzd();

    abstract void zzf(T var1);

    abstract void zzg(Throwable var1);

    final void zzh() {
        Runnable runnable = (Runnable)this.get();
        if (!(runnable instanceof Thread)) return;
        Object object = new zzfsi(this, null);
        zzfsi.zza((zzfsi)object, (Thread)Thread.currentThread());
        if (!this.compareAndSet(runnable, object)) return;
        try {
            object = (Thread)runnable;
            ((Thread)object).interrupt();
        }
        catch (Throwable throwable) {
            if (this.getAndSet(zza) != zzb) throw throwable;
            LockSupport.unpark((Thread)runnable);
            throw throwable;
        }
        if (this.getAndSet(zza) != zzb) return;
        LockSupport.unpark((Thread)object);
    }
}
