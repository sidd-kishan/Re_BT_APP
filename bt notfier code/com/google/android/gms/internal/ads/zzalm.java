/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  com.google.android.gms.internal.ads.zzaku
 *  com.google.android.gms.internal.ads.zzalg
 *  com.google.android.gms.internal.ads.zzalh
 *  com.google.android.gms.internal.ads.zzali
 *  com.google.android.gms.internal.ads.zzalj
 *  com.google.android.gms.internal.ads.zzalk
 *  com.google.android.gms.internal.ads.zzall
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.ads.zzaku;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzalh;
import com.google.android.gms.internal.ads.zzali;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzalk;
import com.google.android.gms.internal.ads.zzall;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class zzalm<T> {
    private final zzaku zza;
    private final zzalg zzb;
    private final zzalk<T> zzc;
    private final CopyOnWriteArraySet<zzall<T>> zzd;
    private final ArrayDeque<Runnable> zze;
    private final ArrayDeque<Runnable> zzf;
    private boolean zzg;

    public zzalm(Looper looper, zzaku zzaku2, zzalk<T> zzalk2) {
        this(new CopyOnWriteArraySet<zzall<T>>(), looper, zzaku2, zzalk2);
    }

    private zzalm(CopyOnWriteArraySet<zzall<T>> copyOnWriteArraySet, Looper looper, zzaku zzaku2, zzalk<T> zzalk2) {
        this.zza = zzaku2;
        this.zzd = copyOnWriteArraySet;
        this.zzc = zzalk2;
        this.zze = new ArrayDeque();
        this.zzf = new ArrayDeque();
        this.zzb = zzaku2.zza(looper, (Handler.Callback)new zzalh(this));
    }

    public final zzalm<T> zza(Looper looper, zzalk<T> zzalk2) {
        return new zzalm<T>(this.zzd, looper, this.zza, zzalk2);
    }

    public final void zzb(T t) {
        if (this.zzg) return;
        if (t == null) throw null;
        this.zzd.add(new zzall(t));
    }

    public final void zzc(T t) {
        Iterator<zzall<T>> iterator = this.zzd.iterator();
        while (iterator.hasNext()) {
            zzall<T> zzall2 = iterator.next();
            if (!zzall2.zza.equals(t)) continue;
            zzall2.zza(this.zzc);
            this.zzd.remove(zzall2);
        }
    }

    public final void zzd(int n, zzalj<T> zzalj2) {
        CopyOnWriteArraySet<zzall<T>> copyOnWriteArraySet = new CopyOnWriteArraySet<zzall<T>>(this.zzd);
        this.zzf.add((Runnable)new zzali(copyOnWriteArraySet, n, zzalj2));
    }

    public final void zze() {
        if (this.zzf.isEmpty()) {
            return;
        }
        if (!this.zzb.zza(0)) {
            zzalg zzalg2 = this.zzb;
            zzalg2.zze(zzalg2.zzb(0));
        }
        boolean bl = this.zze.isEmpty();
        this.zze.addAll(this.zzf);
        this.zzf.clear();
        if (bl ^ true) return;
        while (!this.zze.isEmpty()) {
            this.zze.peekFirst().run();
            this.zze.removeFirst();
        }
    }

    public final void zzf() {
        Iterator<zzall<T>> iterator = this.zzd.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.zzd.clear();
                this.zzg = true;
                return;
            }
            iterator.next().zza(this.zzc);
        }
    }
}
