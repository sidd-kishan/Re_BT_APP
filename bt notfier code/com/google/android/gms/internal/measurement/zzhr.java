/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgc
 *  com.google.android.gms.internal.measurement.zzgy
 *  com.google.android.gms.internal.measurement.zzgz
 *  com.google.android.gms.internal.measurement.zzhn
 *  com.google.android.gms.internal.measurement.zzhs
 *  com.google.android.gms.internal.measurement.zzhw
 *  com.google.android.gms.internal.measurement.zzhx
 *  com.google.android.gms.internal.measurement.zzhy
 *  com.google.android.gms.internal.measurement.zzil
 *  com.google.android.gms.internal.measurement.zziw
 *  com.google.android.gms.internal.measurement.zziy
 *  com.google.android.gms.internal.measurement.zzje
 *  com.google.android.gms.internal.measurement.zzjf
 *  com.google.android.gms.internal.measurement.zzjg
 *  com.google.android.gms.internal.measurement.zzjw
 *  com.google.android.gms.internal.measurement.zzkf
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgy;
import com.google.android.gms.internal.measurement.zzgz;
import com.google.android.gms.internal.measurement.zzhn;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhw;
import com.google.android.gms.internal.measurement.zzhx;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzil;
import com.google.android.gms.internal.measurement.zziw;
import com.google.android.gms.internal.measurement.zziy;
import com.google.android.gms.internal.measurement.zzje;
import com.google.android.gms.internal.measurement.zzjf;
import com.google.android.gms.internal.measurement.zzjg;
import com.google.android.gms.internal.measurement.zzjw;
import com.google.android.gms.internal.measurement.zzkf;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzhr<MessageType extends zzhr<MessageType, BuilderType>, BuilderType extends zzhn<MessageType, BuilderType>>
extends zzgc<MessageType, BuilderType> {
    private static final Map<Object, zzhr<?, ?>> zza = new ConcurrentHashMap();
    protected zzjw zzc = zzjw.zza();
    protected int zzd = -1;

    static Object zzbA(Method object, Object object2, Object ... objectArray) {
        try {
            object = ((Method)object).invoke(object2, objectArray);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getCause();
            if (throwable instanceof RuntimeException) throw (RuntimeException)throwable;
            if (!(throwable instanceof Error)) throw new RuntimeException("Unexpected exception thrown by generated accessor method.", throwable);
            throw (Error)throwable;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", illegalAccessException);
        }
    }

    protected static zzhw zzbB() {
        return zzhs.zzd();
    }

    protected static zzhx zzbC() {
        return zzil.zzf();
    }

    protected static zzhx zzbD(zzhx zzhx2) {
        int n = zzhx2.size();
        n = n == 0 ? 10 : (n += n);
        return zzhx2.zzd(n);
    }

    protected static <E> zzhy<E> zzbE() {
        return zzjf.zzd();
    }

    protected static <E> zzhy<E> zzbF(zzhy<E> zzhy2) {
        int n = zzhy2.size();
        n = n == 0 ? 10 : (n += n);
        return zzhy2.zze(n);
    }

    static <T extends zzhr> T zzbx(Class<T> clazz) {
        zzhr zzhr2;
        zzhr zzhr3 = zzhr2 = zza.get(clazz);
        if (zzhr2 == null) {
            try {
                Class.forName(clazz.getName(), true, clazz.getClassLoader());
                zzhr3 = zza.get(clazz);
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new IllegalStateException("Class initialization cannot fail.", classNotFoundException);
            }
        }
        zzhr2 = zzhr3;
        if (zzhr3 != null) return (T)((Object)zzhr2);
        zzhr2 = (zzhr)((Object)((zzhr)((Object)zzkf.zzc(clazz))).zzl(6, null, null));
        if (zzhr2 == null) throw new IllegalStateException();
        zza.put(clazz, zzhr2);
        return (T)((Object)zzhr2);
    }

    protected static <T extends zzhr> void zzby(Class<T> clazz, T t) {
        zza.put(clazz, t);
    }

    protected static Object zzbz(zziw zziw2, String string, Object[] objectArray) {
        return new zzjg(zziw2, string, objectArray);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (((Object)((Object)this)).getClass() == object.getClass()) return zzje.zza().zzb(((Object)((Object)this)).getClass()).zzb((Object)this, (Object)((zzhr)((Object)object)));
        return false;
    }

    public final int hashCode() {
        int n = this.zzb;
        if (n != 0) {
            return n;
        }
        this.zzb = n = zzje.zza().zzb(((Object)((Object)this)).getClass()).zzc((Object)this);
        return n;
    }

    public final String toString() {
        return zziy.zza((zziw)this, (String)super.toString());
    }

    final int zzbq() {
        return this.zzd;
    }

    final void zzbr(int n) {
        this.zzd = n;
    }

    protected final <MessageType extends zzhr<MessageType, BuilderType>, BuilderType extends zzhn<MessageType, BuilderType>> BuilderType zzbt() {
        return (BuilderType)((zzhn)this.zzl(5, null, null));
    }

    public final BuilderType zzbu() {
        zzhn zzhn2 = (zzhn)this.zzl(5, null, null);
        zzhn2.zzaB(this);
        return (BuilderType)zzhn2;
    }

    public final void zzbv(zzgy zzgy2) throws IOException {
        zzje.zza().zzb(((Object)((Object)this)).getClass()).zzm((Object)this, zzgz.zza((zzgy)zzgy2));
    }

    public final int zzbw() {
        int n;
        int n2 = n = this.zzd;
        if (n != -1) return n2;
        this.zzd = n2 = zzje.zza().zzb(((Object)((Object)this)).getClass()).zze((Object)this);
        return n2;
    }

    protected abstract Object zzl(int var1, Object var2, Object var3);
}
