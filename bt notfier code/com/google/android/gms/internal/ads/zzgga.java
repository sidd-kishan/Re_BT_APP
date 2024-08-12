/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgeg
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfc
 *  com.google.android.gms.internal.ads.zzgfd
 *  com.google.android.gms.internal.ads.zzgfh
 *  com.google.android.gms.internal.ads.zzgfi
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzggb
 *  com.google.android.gms.internal.ads.zzggf
 *  com.google.android.gms.internal.ads.zzggi
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzggx
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghk
 *  com.google.android.gms.internal.ads.zzghq
 *  com.google.android.gms.internal.ads.zzghr
 *  com.google.android.gms.internal.ads.zzghs
 *  com.google.android.gms.internal.ads.zzght
 *  com.google.android.gms.internal.ads.zzghz
 *  com.google.android.gms.internal.ads.zzgin
 *  com.google.android.gms.internal.ads.zzgip
 *  com.google.android.gms.internal.ads.zzgiy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgeg;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfc;
import com.google.android.gms.internal.ads.zzgfd;
import com.google.android.gms.internal.ads.zzgfh;
import com.google.android.gms.internal.ads.zzgfi;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzggb;
import com.google.android.gms.internal.ads.zzggf;
import com.google.android.gms.internal.ads.zzggi;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzggx;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghk;
import com.google.android.gms.internal.ads.zzghq;
import com.google.android.gms.internal.ads.zzghr;
import com.google.android.gms.internal.ads.zzghs;
import com.google.android.gms.internal.ads.zzght;
import com.google.android.gms.internal.ads.zzghz;
import com.google.android.gms.internal.ads.zzgin;
import com.google.android.gms.internal.ads.zzgip;
import com.google.android.gms.internal.ads.zzgiy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzgga<MessageType extends zzgga<MessageType, BuilderType>, BuilderType extends zzgfw<MessageType, BuilderType>>
extends zzgeg<MessageType, BuilderType> {
    private static final Map<Object, zzgga<?, ?>> zzb = new ConcurrentHashMap();
    protected zzgip zzc = zzgip.zza();
    protected int zzd = -1;

    private static <T extends zzgga<T, ?>> T zza(T t) throws zzggm {
        if (t == null) return t;
        if (t.zzat()) {
            return t;
        }
        zzggm zzggm2 = new zzggm(new zzgin(t).getMessage());
        zzggm2.zza(t);
        throw zzggm2;
    }

    static Object zzaA(Method object, Object object2, Object ... objectArray) {
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

    protected static zzggf zzaB() {
        return zzggb.zzd();
    }

    protected static zzggf zzaC(zzggf zzggf2) {
        int n = zzggf2.size();
        n = n == 0 ? 10 : (n += n);
        return zzggf2.zzf(n);
    }

    protected static zzggi zzaD() {
        return zzggx.zzd();
    }

    protected static <E> zzggj<E> zzaE() {
        return zzghr.zzd();
    }

    protected static <E> zzggj<E> zzaF(zzggj<E> zzggj2) {
        int n = zzggj2.size();
        n = n == 0 ? 10 : (n += n);
        return zzggj2.zze(n);
    }

    static <T extends zzgga<T, ?>> T zzaG(T object, byte[] byArray, int n, int n2, zzgfm zzgfm2) throws zzggm {
        zzgga zzgga2 = (zzgga)((Object)object.zzb(4, null, null));
        try {
            zzghz zzghz2 = zzghq.zza().zzb(((Object)((Object)zzgga2)).getClass());
            object = new Object(zzgfm2);
            zzghz2.zzi((Object)zzgga2, byArray, 0, n2, object);
            zzghz2.zzj((Object)zzgga2);
            if (zzgga2.zza == 0) {
                return (T)((Object)zzgga2);
            }
            object = new Object();
            throw object;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            zzggm zzggm2 = zzggm.zzd();
            zzggm2.zza((zzghi)zzgga2);
            throw zzggm2;
        }
        catch (IOException iOException) {
            if (iOException.getCause() instanceof zzggm) {
                throw (zzggm)iOException.getCause();
            }
            zzggm zzggm3 = new zzggm(iOException);
            zzggm3.zza((zzghi)zzgga2);
            throw zzggm3;
        }
        catch (zzggm zzggm4) {
            object = zzggm4;
            if (zzggm4.zzc()) {
                object = new zzggm((IOException)((Object)zzggm4));
            }
            object.zza((zzghi)zzgga2);
            throw object;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     */
    protected static <T extends zzgga<T, ?>> T zzaH(T object, zzgex object2) throws zzggm {
        zzgfm zzgfm2 = zzgfm.zza();
        object2 = object2.zzp();
        zzgga zzgga2 = (zzgga)((Object)object.zzb(4, null, null));
        {
            catch (zzggm zzggm2) {
                throw zzggm2;
            }
            object = zzghq.zza().zzb(((Object)((Object)zzgga2)).getClass());
            object.zzf((Object)zzgga2, (zzght)zzgfd.zza((zzgfc)object2), zzgfm2);
            object.zzj((Object)zzgga2);
            {
                catch (RuntimeException runtimeException) {
                    if (!(runtimeException.getCause() instanceof zzggm)) throw runtimeException;
                    throw (zzggm)runtimeException.getCause();
                }
                catch (IOException iOException) {
                    if (iOException.getCause() instanceof zzggm) {
                        throw (zzggm)iOException.getCause();
                    }
                    object = new Object(iOException);
                    object.zza((zzghi)zzgga2);
                    throw object;
                }
                catch (zzggm zzggm3) {
                    object2 = zzggm3;
                    if (zzggm3.zzc()) {
                        object2 = new zzggm((IOException)((Object)zzggm3));
                    }
                    object2.zza((zzghi)zzgga2);
                    throw object2;
                }
                try {
                    object2.zzb(0);
                }
                catch (zzggm zzggm4) {}
                zzggm4.zza((zzghi)zzgga2);
                throw zzggm4;
                zzgga.zza(zzgga2);
                zzgga.zza(zzgga2);
                return (T)((Object)zzgga2);
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     */
    protected static <T extends zzgga<T, ?>> T zzaI(T object, zzgex object2, zzgfm zzgfm2) throws zzggm {
        object2 = object2.zzp();
        zzgga zzgga2 = (zzgga)((Object)object.zzb(4, null, null));
        {
            catch (zzggm zzggm2) {
                throw zzggm2;
            }
            object = zzghq.zza().zzb(((Object)((Object)zzgga2)).getClass());
            object.zzf((Object)zzgga2, (zzght)zzgfd.zza((zzgfc)object2), zzgfm2);
            object.zzj((Object)zzgga2);
            {
                catch (RuntimeException runtimeException) {
                    if (!(runtimeException.getCause() instanceof zzggm)) throw runtimeException;
                    throw (zzggm)runtimeException.getCause();
                }
                catch (IOException iOException) {
                    if (iOException.getCause() instanceof zzggm) {
                        throw (zzggm)iOException.getCause();
                    }
                    object2 = new zzggm(iOException);
                    object2.zza((zzghi)zzgga2);
                    throw object2;
                }
                catch (zzggm zzggm3) {
                    object2 = zzggm3;
                    if (zzggm3.zzc()) {
                        object2 = new zzggm((IOException)((Object)zzggm3));
                    }
                    object2.zza((zzghi)zzgga2);
                    throw object2;
                }
                try {
                    object2.zzb(0);
                }
                catch (zzggm zzggm4) {}
                zzggm4.zza((zzghi)zzgga2);
                throw zzggm4;
                zzgga.zza(zzgga2);
                return (T)((Object)zzgga2);
            }
        }
    }

    protected static <T extends zzgga<T, ?>> T zzaJ(T t, byte[] byArray) throws zzggm {
        t = zzgga.zzaG(t, byArray, 0, byArray.length, zzgfm.zza());
        zzgga.zza(t);
        return t;
    }

    protected static <T extends zzgga<T, ?>> T zzaK(T t, byte[] byArray, zzgfm zzgfm2) throws zzggm {
        t = zzgga.zzaG(t, byArray, 0, byArray.length, zzgfm2);
        zzgga.zza(t);
        return t;
    }

    static <T extends zzgga> T zzax(Class<T> clazz) {
        zzgga zzgga2;
        zzgga zzgga3 = zzgga2 = zzb.get(clazz);
        if (zzgga2 == null) {
            try {
                Class.forName(clazz.getName(), true, clazz.getClassLoader());
                zzgga3 = zzb.get(clazz);
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new IllegalStateException("Class initialization cannot fail.", classNotFoundException);
            }
        }
        zzgga2 = zzgga3;
        if (zzgga3 != null) return (T)((Object)zzgga2);
        zzgga2 = (zzgga)((Object)((zzgga)((Object)zzgiy.zzc(clazz))).zzb(6, null, null));
        if (zzgga2 == null) throw new IllegalStateException();
        zzb.put(clazz, zzgga2);
        return (T)((Object)zzgga2);
    }

    protected static <T extends zzgga> void zzay(Class<T> clazz, T t) {
        zzb.put(clazz, t);
    }

    protected static Object zzaz(zzghi zzghi2, String string, Object[] objectArray) {
        return new zzghs(zzghi2, string, objectArray);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (((Object)((Object)this)).getClass() == object.getClass()) return zzghq.zza().zzb(((Object)((Object)this)).getClass()).zzb((Object)this, (Object)((zzgga)((Object)object)));
        return false;
    }

    public final int hashCode() {
        int n = this.zza;
        if (n != 0) {
            return n;
        }
        this.zza = n = zzghq.zza().zzb(((Object)((Object)this)).getClass()).zzc((Object)this);
        return n;
    }

    public final String toString() {
        return zzghk.zza((zzghi)this, (String)super.toString());
    }

    final int zzap() {
        return this.zzd;
    }

    final void zzaq(int n) {
        this.zzd = n;
    }

    protected final <MessageType extends zzgga<MessageType, BuilderType>, BuilderType extends zzgfw<MessageType, BuilderType>> BuilderType zzas() {
        return (BuilderType)((zzgfw)this.zzb(5, null, null));
    }

    public final boolean zzat() {
        boolean bl = Boolean.TRUE;
        boolean bl2 = true;
        byte by = (Byte)this.zzb(1, null, null);
        if (by == 1) return bl2;
        if (by == 0) {
            bl2 = false;
        } else {
            bl2 = zzghq.zza().zzb(((Object)((Object)this)).getClass()).zzk((Object)this);
            if (!bl) return bl2;
            zzgga zzgga2 = true != bl2 ? null : this;
            this.zzb(2, (Object)zzgga2, null);
            return bl2;
        }
        return bl2;
    }

    public final BuilderType zzau() {
        zzgfw zzgfw2 = (zzgfw)this.zzb(5, null, null);
        zzgfw2.zzai(this);
        return (BuilderType)zzgfw2;
    }

    public final void zzav(zzgfh zzgfh2) throws IOException {
        zzghq.zza().zzb(((Object)((Object)this)).getClass()).zzn((Object)this, zzgfi.zza((zzgfh)zzgfh2));
    }

    public final int zzaw() {
        int n;
        int n2 = n = this.zzd;
        if (n != -1) return n2;
        this.zzd = n2 = zzghq.zza().zzb(((Object)((Object)this)).getClass()).zze((Object)this);
        return n2;
    }

    protected abstract Object zzb(int var1, Object var2, Object var3);
}
