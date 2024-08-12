/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflx
 *  com.google.android.gms.internal.ads.zzfni
 *  com.google.android.gms.internal.ads.zzfob
 *  com.google.android.gms.internal.ads.zzfoe
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfon
 *  com.google.android.gms.internal.ads.zzfot
 *  com.google.android.gms.internal.ads.zzfpz
 *  com.google.android.gms.internal.ads.zzfqa
 *  com.google.android.gms.internal.ads.zzfqb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflx;
import com.google.android.gms.internal.ads.zzfni;
import com.google.android.gms.internal.ads.zzfob;
import com.google.android.gms.internal.ads.zzfoe;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfon;
import com.google.android.gms.internal.ads.zzfot;
import com.google.android.gms.internal.ads.zzfpz;
import com.google.android.gms.internal.ads.zzfqa;
import com.google.android.gms.internal.ads.zzfqb;
import java.util.Arrays;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzfqc<K, V>
extends zzfon<K, V> {
    static final zzfon<Object, Object> zza = new zzfqc<Object, Object>(null, new Object[0], 0);
    final transient Object[] zzb;
    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzfqc(@CheckForNull Object object, Object[] objectArray, int n) {
        this.zzc = object;
        this.zzb = objectArray;
        this.zzd = n;
    }

    static <K, V> zzfqc<K, V> zzh(int n, Object[] objectArray) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        Object object;
        block14: {
            block13: {
                block12: {
                    if (n == 0) {
                        return (zzfqc)zza;
                    }
                    object = null;
                    n6 = 0;
                    n5 = 0;
                    n4 = 0;
                    if (n == 1) {
                        object = objectArray[0];
                        object.getClass();
                        Object object2 = objectArray[1];
                        object2.getClass();
                        zzfni.zza((Object)object, (Object)object2);
                        return new zzfqc<K, V>(null, objectArray, 1);
                    }
                    zzflx.zzf((int)n, (int)(objectArray.length >> 1), (String)"index");
                    n3 = zzfot.zzl((int)n);
                    if (n == 1) {
                        Object object3 = objectArray[0];
                        object3.getClass();
                        Object object4 = objectArray[1];
                        object4.getClass();
                        zzfni.zza((Object)object3, (Object)object4);
                        return new zzfqc<K, V>(object, objectArray, n);
                    }
                    n2 = n3 - 1;
                    if (n3 <= 128) break block12;
                    if (n3 <= 32768) break block13;
                    break block14;
                }
                byte[] byArray = new byte[n3];
                Arrays.fill(byArray, (byte)-1);
                block0: while (true) {
                    object = byArray;
                    if (n4 >= n) return new zzfqc<K, V>(object, objectArray, n);
                    n5 = n4 + n4;
                    object = objectArray[n5];
                    object.getClass();
                    Object object5 = objectArray[n5 ^ 1];
                    object5.getClass();
                    zzfni.zza((Object)object, (Object)object5);
                    n6 = zzfob.zza((int)object.hashCode());
                    while (true) {
                        if ((n6 = byArray[n3 = n6 & n2] & 0xFF) == 255) {
                            byArray[n3] = (byte)n5;
                            ++n4;
                            continue block0;
                        }
                        if (object.equals(objectArray[n6])) throw zzfqc.zzi(object, object5, objectArray, n6);
                        n6 = n3 + 1;
                    }
                    break;
                }
            }
            short[] sArray = new short[n3];
            Arrays.fill(sArray, (short)-1);
            n4 = n6;
            block2: while (true) {
                object = sArray;
                if (n4 >= n) return new zzfqc<K, V>(object, objectArray, n);
                n5 = n4 + n4;
                object = objectArray[n5];
                object.getClass();
                Object object6 = objectArray[n5 ^ 1];
                object6.getClass();
                zzfni.zza((Object)object, (Object)object6);
                n6 = zzfob.zza((int)object.hashCode());
                while (true) {
                    if ((n6 = (int)((char)sArray[n3 = n6 & n2])) == 65535) {
                        sArray[n3] = (short)n5;
                        ++n4;
                        continue block2;
                    }
                    if (object.equals(objectArray[n6])) throw zzfqc.zzi(object, object6, objectArray, n6);
                    n6 = n3 + 1;
                }
                break;
            }
        }
        int[] nArray = new int[n3];
        Arrays.fill(nArray, -1);
        n4 = n5;
        block4: while (true) {
            object = nArray;
            if (n4 >= n) return new zzfqc<K, V>(object, objectArray, n);
            n5 = n4 + n4;
            Object object7 = objectArray[n5];
            object7.getClass();
            object = objectArray[n5 ^ 1];
            object.getClass();
            zzfni.zza((Object)object7, (Object)object);
            n6 = zzfob.zza((int)object7.hashCode());
            while (true) {
                if ((n6 = nArray[n3 = n6 & n2]) == -1) {
                    nArray[n3] = n5;
                    ++n4;
                    continue block4;
                }
                if (object7.equals(objectArray[n6])) throw zzfqc.zzi(object7, object, objectArray, n6);
                n6 = n3 + 1;
            }
            break;
        }
    }

    private static IllegalArgumentException zzi(Object object, Object object2, Object[] object3, int n) {
        object = String.valueOf(object);
        object2 = String.valueOf(object2);
        String string = String.valueOf(object3[n]);
        String string2 = String.valueOf(object3[n ^ 1]);
        object3 = new StringBuilder(String.valueOf(object).length() + 39 + String.valueOf(object2).length() + String.valueOf(string).length() + String.valueOf(string2).length());
        ((StringBuilder)object3).append("Multiple entries with same key: ");
        ((StringBuilder)object3).append((String)object);
        ((StringBuilder)object3).append("=");
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append(" and ");
        ((StringBuilder)object3).append(string);
        ((StringBuilder)object3).append("=");
        ((StringBuilder)object3).append(string2);
        return new IllegalArgumentException(((StringBuilder)object3).toString());
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @CheckForNull
    public final V get(@CheckForNull Object var1_1) {
        block10: {
            block9: {
                block13: {
                    block12: {
                        block11: {
                            var6_2 = this.zzc;
                            var5_3 = this.zzb;
                            var2_4 /* !! */  = this.zzd;
                            if (var1_1 == null) ** GOTO lbl-1000
                            if (var2_4 /* !! */  != 1) break block11;
                            var6_2 = var5_3[0];
                            var6_2.getClass();
                            if (!var6_2.equals(var1_1)) ** GOTO lbl-1000
                            var1_1 = var5_3[1];
                            var1_1.getClass();
                            break block10;
                        }
                        if (var6_2 == null) ** GOTO lbl-1000
                        if (var6_2 instanceof byte[]) break block12;
                        if (!(var6_2 instanceof short[])) {
                            var6_2 = (int[])var6_2;
                            var3_7 = ((Object)var6_2).length;
                            var2_4 /* !! */  = zzfob.zza((int)var1_1.hashCode());
lbl21:
                            // 2 sources

                            while (true) {
                                var4_10 = var2_4 /* !! */  & var3_7 - 1;
                                if ((var2_4 /* !! */  = (int)var6_2[var4_10]) != -1) break block9;
                                break;
                            }
                        }
                        break block13;
lbl-1000:
                        // 6 sources

                        {
                            while (true) {
                                var1_1 = null;
                                break block10;
                                break;
                            }
                        }
                    }
                    var6_2 = (byte[])var6_2;
                    var3_5 = ((Object)var6_2).length;
                    var2_4 /* !! */  = zzfob.zza((int)var1_1.hashCode());
                    while (true) {
                        if ((var4_8 = var6_2[var2_4 /* !! */  &= var3_5 - 1] & 255) == 255) ** GOTO lbl-1000
                        if (var1_1.equals(var5_3[var4_8])) {
                            var1_1 = var5_3[var4_8 ^ 1];
                            break block10;
                        }
                        ++var2_4 /* !! */ ;
                    }
                }
                var6_2 = (short[])var6_2;
                var3_6 = ((Object)var6_2).length;
                var2_4 /* !! */  = zzfob.zza((int)var1_1.hashCode());
                while (true) {
                    if ((var4_9 = (char)var6_2[var2_4 /* !! */  &= var3_6 - 1]) != '\uffff') ** break;
                    ** continue;
                    if (var1_1.equals(var5_3[var4_9])) {
                        var1_1 = var5_3[var4_9 ^ '\u0001'];
                        break block10;
                    }
                    ++var2_4 /* !! */ ;
                }
            }
            if (var1_1.equals(var5_3[var2_4 /* !! */ ])) {
                var1_1 = var5_3[var2_4 /* !! */  ^ 1];
            } else {
                var2_4 /* !! */  = var4_10 + 1;
                ** continue;
            }
        }
        if (var1_1 != null) return (V)var1_1;
        return null;
    }

    public final int size() {
        return this.zzd;
    }

    final zzfot<Map.Entry<K, V>> zzd() {
        return new zzfpz((zzfon)this, this.zzb, 0, this.zzd);
    }

    final zzfot<K> zze() {
        return new zzfqa((zzfon)this, (zzfoj)new zzfqb(this.zzb, 0, this.zzd));
    }

    final zzfoe<V> zzg() {
        return new zzfqb(this.zzb, 1, this.zzd);
    }
}
