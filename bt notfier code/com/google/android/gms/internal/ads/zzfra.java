/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfrt
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfrt;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.CheckForNull;

abstract class zzfra<I, O, F, T>
extends zzfrt<O>
implements Runnable {
    public static final int zzc = 0;
    @CheckForNull
    zzfsm<? extends I> zza;
    @CheckForNull
    F zzb;

    zzfra(zzfsm<? extends I> zzfsm2, F f) {
        if (zzfsm2 == null) throw null;
        this.zza = zzfsm2;
        if (f == null) throw null;
        this.zzb = f;
    }

    @Override
    public final void run() {
        Object object = this.zza;
        Object object2 = this.zzb;
        boolean bl = this.isCancelled();
        boolean bl2 = true;
        boolean bl3 = object == null;
        if (object2 != null) {
            bl2 = false;
        }
        if (bl | bl3 | bl2) {
            return;
        }
        this.zza = null;
        if (object.isCancelled()) {
            this.zzr((zzfsm)object);
            return;
        }
        try {
            object = zzfsd.zzq(object);
        }
        catch (Error error) {
            this.zzq(error);
            return;
        }
        catch (RuntimeException runtimeException) {
            this.zzq(runtimeException);
            return;
        }
        catch (ExecutionException executionException) {
            this.zzq(executionException.getCause());
            return;
        }
        catch (CancellationException cancellationException) {
            this.cancel(false);
            return;
        }
        try {
            object2 = this.zzb(object2, object);
            this.zzb = null;
            this.zza(object2);
            return;
        }
        catch (Throwable throwable) {
            try {
                this.zzq(throwable);
                return;
            }
            finally {
                this.zzb = null;
            }
        }
    }

    abstract void zza(T var1);

    abstract T zzb(F var1, I var2) throws Exception;

    @CheckForNull
    protected final String zzc() {
        Object object = this.zza;
        Object object2 = this.zzb;
        CharSequence charSequence = super.zzc();
        if (object != null) {
            object = object.toString();
            StringBuilder stringBuilder = new StringBuilder(((String)object).length() + 16);
            stringBuilder.append("inputFuture=[");
            stringBuilder.append((String)object);
            stringBuilder.append("], ");
            object = stringBuilder.toString();
        } else {
            object = "";
        }
        if (object2 != null) {
            object2 = object2.toString();
            charSequence = new StringBuilder(((String)object).length() + 11 + ((String)object2).length());
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append("function=[");
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append("]");
            return ((StringBuilder)charSequence).toString();
        }
        if (charSequence == null) return null;
        object = ((String)charSequence).length() != 0 ? ((String)object).concat((String)charSequence) : new String((String)object);
        return object;
    }

    protected final void zzd() {
        this.zzv((Future)this.zza);
        this.zza = null;
        this.zzb = null;
    }
}
