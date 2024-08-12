/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfrt
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfte
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfrt;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfte;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.CheckForNull;

abstract class zzfqv<V, X extends Throwable, F, T>
extends zzfrt<V>
implements Runnable {
    @CheckForNull
    zzfsm<? extends V> zza;
    @CheckForNull
    Class<X> zzb;
    @CheckForNull
    F zzc;

    zzfqv(zzfsm<? extends V> zzfsm2, Class<X> clazz, F f) {
        if (zzfsm2 == null) throw null;
        this.zza = zzfsm2;
        this.zzb = clazz;
        if (f == null) throw null;
        this.zzc = f;
    }

    @Override
    public final void run() {
        Object object;
        Object object2;
        F f;
        Class<X> clazz;
        zzfsm<V> zzfsm2;
        block12: {
            block11: {
                zzfsm2 = this.zza;
                clazz = this.zzb;
                f = this.zzc;
                boolean bl = true;
                boolean bl2 = zzfsm2 == null;
                boolean bl3 = clazz == null;
                if (f != null) {
                    bl = false;
                }
                if (bl | (bl2 | bl3)) return;
                if (this.isCancelled()) return;
                this.zza = null;
                try {
                    object2 = zzfsm2 instanceof zzfte ? ((zzfte)zzfsm2).zzu() : null;
                    object = object2;
                    if (object2 != null) break block11;
                    Object object3 = zzfsd.zzq(zzfsm2);
                    object = object2;
                    object2 = object3;
                    break block12;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                catch (ExecutionException executionException) {
                    object = object2 = executionException.getCause();
                    if (object2 != null) break block11;
                    object = String.valueOf(zzfsm2.getClass());
                    object2 = String.valueOf(executionException.getClass());
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 35 + String.valueOf(object2).length());
                    stringBuilder.append("Future type ");
                    stringBuilder.append((String)object);
                    stringBuilder.append(" threw ");
                    stringBuilder.append((String)object2);
                    stringBuilder.append(" without a cause");
                    object = new NullPointerException(stringBuilder.toString());
                }
            }
            object2 = null;
        }
        if (object == null) {
            this.zzp(object2);
            return;
        }
        if (clazz.isInstance(object)) {
            try {
                object = this.zzb(f, object);
                this.zzb = null;
                this.zzc = null;
                this.zza(object);
                return;
            }
            catch (Throwable throwable) {
                try {
                    this.zzq(throwable);
                    return;
                }
                finally {
                    this.zzb = null;
                    this.zzc = null;
                }
            }
        }
        this.zzr(zzfsm2);
    }

    abstract void zza(T var1);

    abstract T zzb(F var1, X var2) throws Exception;

    @CheckForNull
    protected final String zzc() {
        Object object = this.zza;
        Object object2 = this.zzb;
        Object object3 = this.zzc;
        String string = super.zzc();
        if (object != null) {
            String string2 = object.toString();
            object = new StringBuilder(string2.length() + 16);
            ((StringBuilder)object).append("inputFuture=[");
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append("], ");
            object = ((StringBuilder)object).toString();
        } else {
            object = "";
        }
        if (object2 != null && object3 != null) {
            object2 = object2.toString();
            string = object3.toString();
            object3 = new StringBuilder(((String)object).length() + 29 + ((String)object2).length() + string.length());
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append("exceptionType=[");
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append("], fallback=[");
            ((StringBuilder)object3).append(string);
            ((StringBuilder)object3).append("]");
            return ((StringBuilder)object3).toString();
        }
        if (string == null) return null;
        object = string.length() != 0 ? ((String)object).concat(string) : new String((String)object);
        return object;
    }

    protected final void zzd() {
        this.zzv((Future)this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }
}
