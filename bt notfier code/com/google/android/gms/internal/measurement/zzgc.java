/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgb
 *  com.google.android.gms.internal.measurement.zzgp
 *  com.google.android.gms.internal.measurement.zzgr
 *  com.google.android.gms.internal.measurement.zzgy
 *  com.google.android.gms.internal.measurement.zzhz
 *  com.google.android.gms.internal.measurement.zzig
 *  com.google.android.gms.internal.measurement.zziw
 *  com.google.android.gms.internal.measurement.zzjd
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgp;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzgy;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzig;
import com.google.android.gms.internal.measurement.zziw;
import com.google.android.gms.internal.measurement.zzjd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class zzgc<MessageType extends zzgc<MessageType, BuilderType>, BuilderType extends zzgb<MessageType, BuilderType>>
implements zziw {
    protected int zzb = 0;

    protected static <T> void zzbs(Iterable<T> object, List<? super T> object2) {
        zzhz.zza(object);
        if (!(object instanceof zzig)) {
            if (object instanceof zzjd) {
                object2.addAll(object);
                return;
            }
            if (object2 instanceof ArrayList && object instanceof Collection) {
                ((ArrayList)object2).ensureCapacity(object2.size() + object.size());
            }
        } else {
            Object object3 = ((zzig)object).zzh();
            object = (zzig)object2;
            int n = object2.size();
            object3 = object3.iterator();
            while (object3.hasNext()) {
                object2 = object3.next();
                if (object2 == null) {
                    int n2 = object.size();
                    object2 = new StringBuilder(37);
                    ((StringBuilder)object2).append("Element at index ");
                    ((StringBuilder)object2).append(n2 - n);
                    ((StringBuilder)object2).append(" is null.");
                    object2 = ((StringBuilder)object2).toString();
                    n2 = object.size();
                    while (--n2 >= n) {
                        object.remove(n2);
                    }
                    throw new NullPointerException((String)object2);
                }
                if (object2 instanceof zzgr) {
                    object.zzf((zzgr)object2);
                    continue;
                }
                object.add((Object)((String)object2));
            }
            return;
        }
        int n = object2.size();
        Iterator iterator = object.iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            if (object == null) {
                int n3 = object2.size();
                object = new StringBuilder(37);
                object.append("Element at index ");
                object.append(n3 - n);
                object.append(" is null.");
                object = object.toString();
                n3 = object2.size();
                while (--n3 >= n) {
                    object2.remove(n3);
                }
                throw new NullPointerException((String)object);
            }
            object2.add((Object)object);
        }
    }

    public final zzgr zzbo() {
        try {
            int n = this.zzbw();
            zzgr zzgr2 = zzgr.zzb;
            byte[] byArray = new byte[n];
            zzgr2 = zzgy.zzt((byte[])byArray);
            this.zzbv((zzgy)zzgr2);
            zzgr2.zzC();
            zzgr2 = new zzgp(byArray);
            return zzgr2;
        }
        catch (IOException iOException) {
            String string = this.getClass().getName();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 72);
            stringBuilder.append("Serializing ");
            stringBuilder.append(string);
            stringBuilder.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(stringBuilder.toString(), iOException);
        }
    }

    public final byte[] zzbp() {
        try {
            byte[] byArray = new byte[this.zzbw()];
            zzgy zzgy2 = zzgy.zzt((byte[])byArray);
            this.zzbv(zzgy2);
            zzgy2.zzC();
            return byArray;
        }
        catch (IOException iOException) {
            String string = this.getClass().getName();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 72);
            stringBuilder.append("Serializing ");
            stringBuilder.append(string);
            stringBuilder.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(stringBuilder.toString(), iOException);
        }
    }

    int zzbq() {
        throw null;
    }

    void zzbr(int n) {
        throw null;
    }
}
