/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgef
 *  com.google.android.gms.internal.ads.zzget
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfh
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzghi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgef;
import com.google.android.gms.internal.ads.zzget;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfh;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzghi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class zzgeg<MessageType extends zzgeg<MessageType, BuilderType>, BuilderType extends zzgef<MessageType, BuilderType>>
implements zzghi {
    protected int zza = 0;

    protected static <T> void zzar(Iterable<T> object, List<? super T> list) {
        zzggk.zza(object);
        if (list instanceof ArrayList) {
            ((ArrayList)list).ensureCapacity(list.size() + object.size());
        }
        int n = list.size();
        Iterator<T> iterator = object.iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            if (object == null) {
                int n2 = list.size();
                object = new StringBuilder(37);
                ((StringBuilder)object).append("Element at index ");
                ((StringBuilder)object).append(n2 - n);
                ((StringBuilder)object).append(" is null.");
                object = ((StringBuilder)object).toString();
                n2 = list.size();
                while (--n2 >= n) {
                    list.remove(n2);
                }
                throw new NullPointerException((String)object);
            }
            list.add(object);
        }
    }

    public final zzgex zzan() {
        try {
            int n = this.zzaw();
            Object object = zzgex.zzb;
            object = new byte[n];
            zzgfh zzgfh2 = zzgfh.zzu((byte[])object);
            this.zzav(zzgfh2);
            zzgfh2.zzD();
            object = new zzget((byte[])object);
            return object;
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

    public final byte[] zzao() {
        try {
            byte[] byArray = new byte[this.zzaw()];
            zzgfh zzgfh2 = zzgfh.zzu((byte[])byArray);
            this.zzav(zzgfh2);
            zzgfh2.zzD();
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

    int zzap() {
        throw null;
    }

    void zzaq(int n) {
        throw null;
    }
}
