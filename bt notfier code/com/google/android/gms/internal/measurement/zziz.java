/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgf
 *  com.google.android.gms.internal.measurement.zzgg
 *  com.google.android.gms.internal.measurement.zzgh
 *  com.google.android.gms.internal.measurement.zzgr
 *  com.google.android.gms.internal.measurement.zzgu
 *  com.google.android.gms.internal.measurement.zzgy
 *  com.google.android.gms.internal.measurement.zzgz
 *  com.google.android.gms.internal.measurement.zzha
 *  com.google.android.gms.internal.measurement.zzhd
 *  com.google.android.gms.internal.measurement.zzhe
 *  com.google.android.gms.internal.measurement.zzhj
 *  com.google.android.gms.internal.measurement.zzhk
 *  com.google.android.gms.internal.measurement.zzho
 *  com.google.android.gms.internal.measurement.zzhr
 *  com.google.android.gms.internal.measurement.zzhs
 *  com.google.android.gms.internal.measurement.zzhv
 *  com.google.android.gms.internal.measurement.zzhy
 *  com.google.android.gms.internal.measurement.zzhz
 *  com.google.android.gms.internal.measurement.zzib
 *  com.google.android.gms.internal.measurement.zzik
 *  com.google.android.gms.internal.measurement.zzil
 *  com.google.android.gms.internal.measurement.zzip
 *  com.google.android.gms.internal.measurement.zziq
 *  com.google.android.gms.internal.measurement.zzir
 *  com.google.android.gms.internal.measurement.zzit
 *  com.google.android.gms.internal.measurement.zziw
 *  com.google.android.gms.internal.measurement.zzjb
 *  com.google.android.gms.internal.measurement.zzje
 *  com.google.android.gms.internal.measurement.zzjg
 *  com.google.android.gms.internal.measurement.zzjh
 *  com.google.android.gms.internal.measurement.zzjj
 *  com.google.android.gms.internal.measurement.zzjs
 *  com.google.android.gms.internal.measurement.zzjv
 *  com.google.android.gms.internal.measurement.zzjw
 *  com.google.android.gms.internal.measurement.zzkf
 *  com.google.android.gms.internal.measurement.zzkk
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzgu;
import com.google.android.gms.internal.measurement.zzgy;
import com.google.android.gms.internal.measurement.zzgz;
import com.google.android.gms.internal.measurement.zzha;
import com.google.android.gms.internal.measurement.zzhd;
import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zzhj;
import com.google.android.gms.internal.measurement.zzhk;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zzil;
import com.google.android.gms.internal.measurement.zzip;
import com.google.android.gms.internal.measurement.zziq;
import com.google.android.gms.internal.measurement.zzir;
import com.google.android.gms.internal.measurement.zzit;
import com.google.android.gms.internal.measurement.zziw;
import com.google.android.gms.internal.measurement.zzjb;
import com.google.android.gms.internal.measurement.zzje;
import com.google.android.gms.internal.measurement.zzjg;
import com.google.android.gms.internal.measurement.zzjh;
import com.google.android.gms.internal.measurement.zzjj;
import com.google.android.gms.internal.measurement.zzjs;
import com.google.android.gms.internal.measurement.zzjv;
import com.google.android.gms.internal.measurement.zzjw;
import com.google.android.gms.internal.measurement.zzkf;
import com.google.android.gms.internal.measurement.zzkk;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class zziz<T>
implements zzjh<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzkf.zzq();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zziw zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzik zzm;
    private final zzjv<?, ?> zzn;
    private final zzhe<?> zzo;
    private final zzjb zzp;
    private final zzir zzq;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private zziz(int[] nArray, Object[] objectArray, int n, int n2, zziw zziw2, boolean bl, boolean bl2, int[] nArray2, int n3, int n4, zzjb zzjb2, zzik zzik2, zzjv zzjv2, zzhe zzhe2, zzir zzir2, byte[] byArray) {
        this.zzc = nArray;
        this.zzd = objectArray;
        this.zze = n;
        this.zzf = n2;
        this.zzi = bl;
        bl = bl2 = false;
        if (zzhe2 != null) {
            bl = bl2;
            if (zzhe2.zza(zziw2)) {
                bl = true;
            }
        }
        this.zzh = bl;
        this.zzj = nArray2;
        this.zzk = n3;
        this.zzl = n4;
        this.zzp = zzjb2;
        this.zzm = zzik2;
        this.zzn = zzjv2;
        this.zzo = zzhe2;
        this.zzg = zziw2;
        this.zzq = zzir2;
    }

    private final int zzA(int n) {
        return this.zzc[n + 1];
    }

    private final int zzB(int n) {
        return this.zzc[n + 2];
    }

    private static int zzC(int n) {
        return n >>> 20 & 0xFF;
    }

    private static <T> double zzD(T t, long l) {
        return (Double)zzkf.zzn(t, (long)l);
    }

    private static <T> float zzE(T t, long l) {
        return ((Float)zzkf.zzn(t, (long)l)).floatValue();
    }

    private static <T> int zzF(T t, long l) {
        return (Integer)zzkf.zzn(t, (long)l);
    }

    private static <T> long zzG(T t, long l) {
        return (Long)zzkf.zzn(t, (long)l);
    }

    private static <T> boolean zzH(T t, long l) {
        return (Boolean)zzkf.zzn(t, (long)l);
    }

    private final boolean zzI(T t, T t2, int n) {
        if (this.zzK(t, n) != this.zzK(t2, n)) return false;
        return true;
    }

    private final boolean zzJ(T t, int n, int n2, int n3, int n4) {
        if (n2 == 1048575) {
            return this.zzK(t, n);
        }
        if ((n3 & n4) == 0) return false;
        return true;
    }

    private final boolean zzK(T object, int n) {
        int n2 = this.zzB(n);
        long l = n2 & 0xFFFFF;
        if (l != 1048575L) {
            if ((zzkf.zzd(object, (long)l) & 1 << (n2 >>> 20)) == 0) return false;
            return true;
        }
        n = this.zzA(n);
        l = n & 0xFFFFF;
        switch (zziz.zzC(n)) {
            default: {
                throw new IllegalArgumentException();
            }
            case 17: {
                if (zzkf.zzn(object, (long)l) == null) return false;
                return true;
            }
            case 16: {
                if (zzkf.zzf(object, (long)l) == 0L) return false;
                return true;
            }
            case 15: {
                if (zzkf.zzd(object, (long)l) == 0) return false;
                return true;
            }
            case 14: {
                if (zzkf.zzf(object, (long)l) == 0L) return false;
                return true;
            }
            case 13: {
                if (zzkf.zzd(object, (long)l) == 0) return false;
                return true;
            }
            case 12: {
                if (zzkf.zzd(object, (long)l) == 0) return false;
                return true;
            }
            case 11: {
                if (zzkf.zzd(object, (long)l) == 0) return false;
                return true;
            }
            case 10: {
                if (zzgr.zzb.equals(zzkf.zzn(object, (long)l))) return false;
                return true;
            }
            case 9: {
                if (zzkf.zzn(object, (long)l) == null) return false;
                return true;
            }
            case 8: {
                object = zzkf.zzn(object, (long)l);
                if (object instanceof String) {
                    if (((String)object).isEmpty()) return false;
                    return true;
                }
                if (!(object instanceof zzgr)) throw new IllegalArgumentException();
                if (zzgr.zzb.equals(object)) return false;
                return true;
            }
            case 7: {
                return zzkf.zzh(object, (long)l);
            }
            case 6: {
                if (zzkf.zzd(object, (long)l) == 0) return false;
                return true;
            }
            case 5: {
                if (zzkf.zzf(object, (long)l) == 0L) return false;
                return true;
            }
            case 4: {
                if (zzkf.zzd(object, (long)l) == 0) return false;
                return true;
            }
            case 3: {
                if (zzkf.zzf(object, (long)l) == 0L) return false;
                return true;
            }
            case 2: {
                if (zzkf.zzf(object, (long)l) == 0L) return false;
                return true;
            }
            case 1: {
                if (zzkf.zzj(object, (long)l) == 0.0f) return false;
                return true;
            }
            case 0: 
        }
        if (zzkf.zzl(object, (long)l) == 0.0) return false;
        return true;
    }

    private final void zzL(T t, int n) {
        long l = 0xFFFFF & (n = this.zzB(n));
        if (l == 1048575L) {
            return;
        }
        zzkf.zze(t, (long)l, (int)(1 << (n >>> 20) | zzkf.zzd(t, (long)l)));
    }

    private final boolean zzM(T t, int n, int n2) {
        if (zzkf.zzd(t, (long)(this.zzB(n2) & 0xFFFFF)) != n) return false;
        return true;
    }

    private final void zzN(T t, int n, int n2) {
        zzkf.zze(t, (long)(this.zzB(n2) & 0xFFFFF), (int)n);
    }

    private final int zzO(int n) {
        if (n < this.zze) return -1;
        if (n > this.zzf) return -1;
        return this.zzQ(n, 0);
    }

    private final int zzP(int n, int n2) {
        if (n < this.zze) return -1;
        if (n > this.zzf) return -1;
        return this.zzQ(n, n2);
    }

    private final int zzQ(int n, int n2) {
        int n3 = this.zzc.length / 3 - 1;
        while (n2 <= n3) {
            int n4 = n3 + n2 >>> 1;
            int n5 = n4 * 3;
            int n6 = this.zzc[n5];
            if (n == n6) {
                return n5;
            }
            if (n < n6) {
                n3 = n4 - 1;
                continue;
            }
            n2 = n4 + 1;
        }
        return -1;
    }

    /*
     * Unable to fully structure code
     */
    private final void zzR(T var1_1, zzgz var2_2) throws IOException {
        if (this.zzh) {
            this.zzo.zzb(var1_1);
            throw null;
        }
        var8_3 = this.zzc.length;
        var15_4 = zziz.zzb;
        var6_5 = 0;
        var4_6 = 0;
        var3_7 = 1048575;
        while (true) {
            block95: {
                if (var6_5 >= var8_3) {
                    var15_4 = this.zzn;
                    var15_4.zzi(var15_4.zzd(var1_1), var2_2);
                    return;
                }
                var11_12 = this.zzA(var6_5);
                var10_11 = this.zzc[var6_5];
                var9_10 = zziz.zzC(var11_12);
                if (var9_10 <= 17) {
                    var12_13 = this.zzc[var6_5 + 2];
                    var7_9 = var12_13 & 1048575;
                    var5_8 = var4_6;
                    var4_6 = var3_7;
                    if (var7_9 != var3_7) {
                        var5_8 = var15_4.getInt(var1_1, (long)var7_9);
                        var4_6 = var7_9;
                    }
                    var7_9 = 1 << (var12_13 >>> 20);
                    var3_7 = var4_6;
                } else {
                    var7_9 = 0;
                    var5_8 = var4_6;
                }
                var13_14 = var11_12 & 1048575;
                switch (var9_10) {
                    case 68: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzs(var10_11, var15_4.getObject(var1_1, var13_14), this.zzv(var6_5));
                        break block95;
                    }
                    case 67: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzq(var10_11, zziz.zzG(var1_1, var13_14));
                        break block95;
                    }
                    case 66: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzp(var10_11, zziz.zzF(var1_1, var13_14));
                        break block95;
                    }
                    case 65: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzd(var10_11, zziz.zzG(var1_1, var13_14));
                        break block95;
                    }
                    case 64: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzb(var10_11, zziz.zzF(var1_1, var13_14));
                        break block95;
                    }
                    case 63: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzg(var10_11, zziz.zzF(var1_1, var13_14));
                        break block95;
                    }
                    case 62: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzo(var10_11, zziz.zzF(var1_1, var13_14));
                        break block95;
                    }
                    case 61: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzn(var10_11, (zzgr)var15_4.getObject(var1_1, var13_14));
                        break block95;
                    }
                    case 60: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzr(var10_11, var15_4.getObject(var1_1, var13_14), this.zzv(var6_5));
                        break block95;
                    }
                    case 59: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        zziz.zzT(var10_11, var15_4.getObject(var1_1, var13_14), var2_2);
                        break block95;
                    }
                    case 58: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzl(var10_11, zziz.zzH(var1_1, var13_14));
                        break block95;
                    }
                    case 57: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzk(var10_11, zziz.zzF(var1_1, var13_14));
                        break block95;
                    }
                    case 56: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzj(var10_11, zziz.zzG(var1_1, var13_14));
                        break block95;
                    }
                    case 55: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzi(var10_11, zziz.zzF(var1_1, var13_14));
                        break block95;
                    }
                    case 54: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzh(var10_11, zziz.zzG(var1_1, var13_14));
                        break block95;
                    }
                    case 53: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzc(var10_11, zziz.zzG(var1_1, var13_14));
                        break block95;
                    }
                    case 52: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zze(var10_11, zziz.zzE(var1_1, var13_14));
                        break block95;
                    }
                    case 51: {
                        if (!this.zzM(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzf(var10_11, zziz.zzD(var1_1, var13_14));
                        break block95;
                    }
lbl105:
                    // 19 sources

                    default: {
                        break block95;
                    }
                    case 50: {
                        this.zzS(var2_2, var10_11, var15_4.getObject(var1_1, var13_14), var6_5);
                        break block95;
                    }
                    case 49: {
                        zzjj.zzaa((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (zzjh)this.zzv(var6_5));
                        break block95;
                    }
                    case 48: {
                        zzjj.zzN((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)true);
                        break block95;
                    }
                    case 47: {
                        zzjj.zzS((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)true);
                        break block95;
                    }
                    case 46: {
                        zzjj.zzP((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)true);
                        break block95;
                    }
                    case 45: {
                        zzjj.zzU((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)true);
                        break block95;
                    }
                    case 44: {
                        zzjj.zzV((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)true);
                        break block95;
                    }
                    case 43: {
                        zzjj.zzR((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)true);
                        break block95;
                    }
                    case 42: {
                        zzjj.zzW((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)true);
                        break block95;
                    }
                    case 41: {
                        zzjj.zzT((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)true);
                        break block95;
                    }
                    case 40: {
                        zzjj.zzO((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)true);
                        break block95;
                    }
                    case 39: {
                        zzjj.zzQ((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)true);
                        break block95;
                    }
                    case 38: {
                        zzjj.zzM((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)true);
                        break block95;
                    }
                    case 37: {
                        zzjj.zzL((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)true);
                        break block95;
                    }
                    case 36: {
                        zzjj.zzK((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)true);
                        break block95;
                    }
                    case 35: {
                        zzjj.zzJ((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)true);
                        break block95;
                    }
                    case 34: {
                        zzjj.zzN((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)false);
                        break block95;
                    }
                    case 33: {
                        zzjj.zzS((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)false);
                        break block95;
                    }
                    case 32: {
                        zzjj.zzP((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)false);
                        break block95;
                    }
                    case 31: {
                        zzjj.zzU((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)false);
                        break block95;
                    }
                    case 30: {
                        zzjj.zzV((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)false);
                        break block95;
                    }
                    case 29: {
                        zzjj.zzR((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)false);
                        break block95;
                    }
                    case 28: {
                        zzjj.zzY((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2);
                        break block95;
                    }
                    case 27: {
                        zzjj.zzZ((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (zzjh)this.zzv(var6_5));
                        break block95;
                    }
                    case 26: {
                        zzjj.zzX((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2);
                        break block95;
                    }
                    case 25: {
                        zzjj.zzW((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)false);
                        break block95;
                    }
                    case 24: {
                        zzjj.zzT((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)false);
                        break block95;
                    }
                    case 23: {
                        zzjj.zzO((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)false);
                        break block95;
                    }
                    case 22: {
                        zzjj.zzQ((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)false);
                        break block95;
                    }
                    case 21: {
                        zzjj.zzM((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)false);
                        break block95;
                    }
                    case 20: {
                        zzjj.zzL((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)false);
                        break block95;
                    }
                    case 19: {
                        zzjj.zzK((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)false);
                        break block95;
                    }
                    case 18: {
                        zzjj.zzJ((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgz)var2_2, (boolean)false);
                        break block95;
                    }
                    case 17: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzs(var10_11, var15_4.getObject(var1_1, var13_14), this.zzv(var6_5));
                        }
                        break block95;
                    }
                    case 16: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzq(var10_11, var15_4.getLong(var1_1, var13_14));
                        }
                        break block95;
                    }
                    case 15: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzp(var10_11, var15_4.getInt(var1_1, var13_14));
                        }
                        break block95;
                    }
                    case 14: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzd(var10_11, var15_4.getLong(var1_1, var13_14));
                        }
                        break block95;
                    }
                    case 13: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzb(var10_11, var15_4.getInt(var1_1, var13_14));
                        }
                        break block95;
                    }
                    case 12: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzg(var10_11, var15_4.getInt(var1_1, var13_14));
                        }
                        break block95;
                    }
                    case 11: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzo(var10_11, var15_4.getInt(var1_1, var13_14));
                        }
                        break block95;
                    }
                    case 10: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzn(var10_11, (zzgr)var15_4.getObject(var1_1, var13_14));
                        }
                        break block95;
                    }
                    case 9: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzr(var10_11, var15_4.getObject(var1_1, var13_14), this.zzv(var6_5));
                        }
                        break block95;
                    }
                    case 8: {
                        if ((var5_8 & var7_9) != 0) {
                            zziz.zzT(var10_11, var15_4.getObject(var1_1, var13_14), var2_2);
                        }
                        break block95;
                    }
                    case 7: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzl(var10_11, zzkf.zzh(var1_1, (long)var13_14));
                        }
                        break block95;
                    }
                    case 6: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzk(var10_11, var15_4.getInt(var1_1, var13_14));
                        }
                        break block95;
                    }
                    case 5: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzj(var10_11, var15_4.getLong(var1_1, var13_14));
                        }
                        break block95;
                    }
                    case 4: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzi(var10_11, var15_4.getInt(var1_1, var13_14));
                        }
                        break block95;
                    }
                    case 3: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzh(var10_11, var15_4.getLong(var1_1, var13_14));
                        }
                        break block95;
                    }
                    case 2: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzc(var10_11, var15_4.getLong(var1_1, var13_14));
                        }
                        break block95;
                    }
                    case 1: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zze(var10_11, zzkf.zzj(var1_1, (long)var13_14));
                        }
                        break block95;
                    }
                    case 0: 
                }
                if ((var5_8 & var7_9) != 0) {
                    var2_2.zzf(var10_11, zzkf.zzl(var1_1, (long)var13_14));
                }
            }
            var6_5 += 3;
            var4_6 = var5_8;
        }
    }

    private final <K, V> void zzS(zzgz zzgz2, int n, Object object, int n2) throws IOException {
        if (object == null) {
            return;
        }
        zzgz2 = (zzip)this.zzw(n2);
        throw null;
    }

    private static final void zzT(int n, Object object, zzgz zzgz2) throws IOException {
        if (object instanceof String) {
            zzgz2.zzm(n, (String)object);
            return;
        }
        zzgz2.zzn(n, (zzgr)object);
    }

    static zzjw zzf(Object object) {
        zzhr zzhr2 = (zzhr)object;
        zzjw zzjw2 = zzhr2.zzc;
        object = zzjw2;
        if (zzjw2 != zzjw.zza()) return object;
        object = zzjw.zzb();
        zzhr2.zzc = object;
        return object;
    }

    static <T> zziz<T> zzk(Class<T> zzjs2, zzit zzit2, zzjb zzjb2, zzik zzik2, zzjv<?, ?> zzjv2, zzhe<?> zzhe2, zzir zzir2) {
        if (zzit2 instanceof zzjg) {
            return zziz.zzl((zzjg)zzit2, zzjb2, zzik2, zzjv2, zzhe2, zzir2);
        }
        zzjs2 = (zzjs)zzit2;
        throw null;
    }

    static <T> zziz<T> zzl(zzjg zzjg2, zzjb zzjb2, zzik zzik2, zzjv<?, ?> zzjv2, zzhe<?> zzhe2, zzir zzir2) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int[] nArray;
        int n8;
        int n9;
        int n10;
        boolean bl = zzjg2.zzc() == 2;
        String string = zzjg2.zzd();
        int n11 = string.length();
        if (string.charAt(0) >= '\ud800') {
            n10 = 1;
            while (true) {
                n8 = n9 = n10 + 1;
                if (string.charAt(n10) >= '\ud800') {
                    n10 = n9;
                    continue;
                }
                break;
            }
        } else {
            n8 = 1;
        }
        n9 = n8 + 1;
        int n12 = string.charAt(n8);
        n10 = n9;
        n8 = n12;
        if (n12 >= 55296) {
            n10 = n12 & 0x1FFF;
            n8 = 13;
            n12 = n9;
            while (true) {
                n9 = n12 + 1;
                if ((n12 = (int)string.charAt(n12)) < 55296) break;
                n10 |= (n12 & 0x1FFF) << n8;
                n8 += 13;
                n12 = n9;
            }
            n8 = n10 | n12 << n8;
            n10 = n9;
        }
        if (n8 == 0) {
            nArray = zza;
            n7 = 0;
            n6 = 0;
            n12 = 0;
            n5 = 0;
            n4 = 0;
            n8 = 0;
            n3 = 0;
        } else {
            n8 = n10 + 1;
            n9 = n12 = (int)string.charAt(n10);
            n10 = n8;
            if (n12 >= 55296) {
                n10 = n12 & 0x1FFF;
                n9 = 13;
                n12 = n8;
                while (true) {
                    n8 = n12 + 1;
                    if ((n12 = (int)string.charAt(n12)) < 55296) break;
                    n10 |= (n12 & 0x1FFF) << n9;
                    n9 += 13;
                    n12 = n8;
                }
                n9 = n10 | n12 << n9;
                n10 = n8;
            }
            n8 = n10 + 1;
            n5 = n12 = (int)string.charAt(n10);
            n10 = n8;
            if (n12 >= 55296) {
                n12 &= 0x1FFF;
                n10 = 13;
                n3 = n8;
                while (true) {
                    n8 = n3 + 1;
                    if ((n3 = (int)string.charAt(n3)) < 55296) break;
                    n12 |= (n3 & 0x1FFF) << n10;
                    n10 += 13;
                    n3 = n8;
                }
                n5 = n12 | n3 << n10;
                n10 = n8;
            }
            n12 = n10 + 1;
            n10 = n3 = (int)string.charAt(n10);
            n8 = n12;
            if (n3 >= 55296) {
                n10 = n3 & 0x1FFF;
                n8 = 13;
                n3 = n12;
                n12 = n10;
                while (true) {
                    n10 = n3 + 1;
                    if ((n3 = (int)string.charAt(n3)) < 55296) break;
                    n12 |= (n3 & 0x1FFF) << n8;
                    n8 += 13;
                    n3 = n10;
                }
                n12 |= n3 << n8;
                n8 = n10;
                n10 = n12;
            }
            n3 = n8 + 1;
            n6 = string.charAt(n8);
            n8 = n6;
            n12 = n3;
            if (n6 >= 55296) {
                n8 = n6 & 0x1FFF;
                n12 = 13;
                n6 = n3;
                n3 = n8;
                while (true) {
                    n8 = n6 + 1;
                    if ((n6 = (int)string.charAt(n6)) < 55296) break;
                    n3 |= (n6 & 0x1FFF) << n12;
                    n12 += 13;
                    n6 = n8;
                }
                n3 |= n6 << n12;
                n12 = n8;
                n8 = n3;
            }
            n3 = n12 + 1;
            n12 = n4 = (int)string.charAt(n12);
            n6 = n3;
            if (n4 >= 55296) {
                n12 = n4 & 0x1FFF;
                n6 = 13;
                n4 = n3;
                n3 = n12;
                while (true) {
                    n12 = n4 + 1;
                    if ((n4 = (int)string.charAt(n4)) < 55296) break;
                    n3 |= (n4 & 0x1FFF) << n6;
                    n6 += 13;
                    n4 = n12;
                }
                n3 |= n4 << n6;
                n6 = n12;
                n12 = n3;
            }
            n4 = n6 + 1;
            n7 = string.charAt(n6);
            n3 = n7;
            n6 = n4;
            if (n7 >= 55296) {
                n3 = n7 & 0x1FFF;
                n6 = 13;
                n7 = n4;
                n4 = n3;
                while (true) {
                    n3 = n7 + 1;
                    if ((n7 = (int)string.charAt(n7)) < 55296) break;
                    n4 |= (n7 & 0x1FFF) << n6;
                    n6 += 13;
                    n7 = n3;
                }
                n4 |= n7 << n6;
                n6 = n3;
                n3 = n4;
            }
            n4 = n6 + 1;
            n7 = n2 = (int)string.charAt(n6);
            n6 = n4;
            if (n2 >= 55296) {
                n7 = n2 & 0x1FFF;
                n6 = 13;
                n2 = n4;
                while (true) {
                    n4 = n2 + 1;
                    if ((n2 = (int)string.charAt(n2)) < 55296) break;
                    n7 |= (n2 & 0x1FFF) << n6;
                    n6 += 13;
                    n2 = n4;
                }
                n7 |= n2 << n6;
                n6 = n4;
            }
            n2 = n6 + 1;
            n6 = n = (int)string.charAt(n6);
            n4 = n2;
            if (n >= 55296) {
                n4 = n & 0x1FFF;
                n6 = 13;
                n = n2;
                n2 = n4;
                while (true) {
                    n4 = n + 1;
                    if ((n = (int)string.charAt(n)) < 55296) break;
                    n2 |= (n & 0x1FFF) << n6;
                    n6 += 13;
                    n = n4;
                }
                n6 = n2 | n << n6;
            }
            nArray = new int[n6 + n3 + n7];
            n5 = n9 + n9 + n5;
            n7 = n9;
            n9 = n4;
            n4 = n8;
            n2 = n3;
            n3 = n5;
            n8 = n6;
            n5 = n12;
            n12 = n2;
            n6 = n10;
            n10 = n9;
        }
        Unsafe unsafe = zzb;
        Object[] objectArray = zzjg2.zze();
        Class<?> clazz = zzjg2.zzb().getClass();
        int[] nArray2 = new int[n5 * 3];
        Object[] objectArray2 = new Object[n5 + n5];
        int n13 = n8 + n12;
        n9 = n8;
        n12 = n13;
        int n14 = 0;
        n5 = 0;
        n2 = n8;
        n8 = n4;
        n = n6;
        n6 = n10;
        n10 = n11;
        while (n6 < n10) {
            int n15;
            int n16;
            int n17;
            int n18;
            int n19;
            int n20;
            block50: {
                Object object;
                block56: {
                    block57: {
                        block51: {
                            block52: {
                                block54: {
                                    block53: {
                                        block55: {
                                            block46: {
                                                block48: {
                                                    block49: {
                                                        block47: {
                                                            n20 = n6 + 1;
                                                            n11 = string.charAt(n6);
                                                            if (n11 >= 55296) {
                                                                n11 &= 0x1FFF;
                                                                n6 = 13;
                                                                while (true) {
                                                                    n4 = n20 + 1;
                                                                    if ((n20 = (int)string.charAt(n20)) < 55296) break;
                                                                    n11 |= (n20 & 0x1FFF) << n6;
                                                                    n6 += 13;
                                                                    n20 = n4;
                                                                }
                                                                n11 |= n20 << n6;
                                                            } else {
                                                                n4 = n20;
                                                            }
                                                            n6 = n4 + 1;
                                                            n19 = string.charAt(n4);
                                                            if (n19 >= 55296) {
                                                                n20 = n19 & 0x1FFF;
                                                                n19 = n6;
                                                                n6 = 13;
                                                                while (true) {
                                                                    n4 = n19 + 1;
                                                                    if ((n19 = (int)string.charAt(n19)) < 55296) break;
                                                                    n20 |= (n19 & 0x1FFF) << n6;
                                                                    n6 += 13;
                                                                    n19 = n4;
                                                                }
                                                                n19 = n20 | n19 << n6;
                                                                n6 = n4;
                                                            }
                                                            n18 = n19 & 0xFF;
                                                            n20 = n5;
                                                            if ((n19 & 0x400) != 0) {
                                                                nArray[n5] = n14;
                                                                n20 = n5 + 1;
                                                            }
                                                            if (n18 < 51) break block46;
                                                            n4 = n6 + 1;
                                                            n5 = string.charAt(n6);
                                                            if (n5 >= 55296) {
                                                                n6 = 13;
                                                                n17 = n4;
                                                                n4 = n5 &= 0x1FFF;
                                                                while (true) {
                                                                    n5 = n17 + 1;
                                                                    if ((n17 = (int)string.charAt(n17)) < 55296) break;
                                                                    n4 |= (n17 & 0x1FFF) << n6;
                                                                    n6 += 13;
                                                                    n17 = n5;
                                                                }
                                                                n4 |= n17 << n6;
                                                                n6 = n5;
                                                                n5 = n4;
                                                            } else {
                                                                n6 = n4;
                                                            }
                                                            n17 = n18 - 51;
                                                            n4 = n6;
                                                            if (n17 == 9 || n17 == 17) break block47;
                                                            n6 = n3;
                                                            if (n17 != 12) break block48;
                                                            n6 = n3;
                                                            if (bl) break block48;
                                                            n17 = n14 / 3;
                                                            n6 = n3 + 1;
                                                            objectArray2[n17 + n17 + 1] = objectArray[n3];
                                                            n3 = n6;
                                                            break block49;
                                                        }
                                                        n17 = n14 / 3;
                                                        n6 = n3 + 1;
                                                        objectArray2[n17 + n17 + 1] = objectArray[n3];
                                                        n3 = n6;
                                                    }
                                                    n6 = n3;
                                                }
                                                if ((object = objectArray[n3 = n5 + n5]) instanceof Field) {
                                                    object = (Field)object;
                                                } else {
                                                    objectArray[n3] = object = zziz.zzn(clazz, (String)object);
                                                }
                                                n16 = (int)unsafe.objectFieldOffset((Field)object);
                                                object = objectArray[++n3];
                                                if (object instanceof Field) {
                                                    object = (Field)object;
                                                } else {
                                                    objectArray[n3] = object = zziz.zzn(clazz, (String)object);
                                                }
                                                n5 = (int)unsafe.objectFieldOffset((Field)object);
                                                n15 = 0;
                                                n3 = n6;
                                                n17 = n12;
                                                n12 = n4;
                                                break block50;
                                            }
                                            n17 = n8;
                                            n4 = n3 + 1;
                                            object = zziz.zzn(clazz, (String)objectArray[n3]);
                                            if (n18 == 9 || n18 == 17) break block51;
                                            if (n18 == 27 || n18 == 49) break block52;
                                            if (n18 == 12 || n18 == 30 || n18 == 44) break block53;
                                            n3 = n4;
                                            n8 = n9;
                                            if (n18 != 50) break block54;
                                            n8 = n9 + 1;
                                            nArray[n9] = n14;
                                            n9 = n14 / 3;
                                            n9 += n9;
                                            n5 = n4 + 1;
                                            objectArray2[n9] = objectArray[n4];
                                            if ((n19 & 0x800) == 0) break block55;
                                            n3 = n5 + 1;
                                            objectArray2[n9 + 1] = objectArray[n5];
                                            break block54;
                                        }
                                        n9 = n8;
                                        n8 = n5;
                                        break block56;
                                    }
                                    n3 = n4;
                                    n8 = n9;
                                    if (bl) break block54;
                                    n3 = n14 / 3;
                                    n8 = n4 + 1;
                                    objectArray2[n3 + n3 + 1] = objectArray[n4];
                                    break block56;
                                }
                                n9 = n8;
                                break block57;
                            }
                            n3 = n14 / 3;
                            n8 = n4 + 1;
                            objectArray2[n3 + n3 + 1] = objectArray[n4];
                            break block56;
                        }
                        n8 = n14 / 3;
                        objectArray2[n8 + n8 + 1] = ((Field)object).getType();
                        n3 = n4;
                    }
                    n8 = n3;
                }
                n16 = (int)unsafe.objectFieldOffset((Field)object);
                if ((n19 & 0x1000) == 4096 && n18 <= 17) {
                    n3 = n6 + 1;
                    if ((n6 = (int)string.charAt(n6)) >= 55296) {
                        n4 = n6 & 0x1FFF;
                        n6 = 13;
                        n5 = n3;
                        while (true) {
                            n3 = n5 + 1;
                            if ((n5 = (int)string.charAt(n5)) < 55296) break;
                            n4 |= (n5 & 0x1FFF) << n6;
                            n6 += 13;
                            n5 = n3;
                        }
                        n6 = n4 | n5 << n6;
                    }
                    if ((object = objectArray[n4 = n7 + n7 + n6 / 32]) instanceof Field) {
                        object = (Field)object;
                    } else {
                        objectArray[n4] = object = zziz.zzn(clazz, (String)object);
                    }
                    n4 = (int)unsafe.objectFieldOffset((Field)object);
                    n5 = n6 % 32;
                    n6 = n4;
                    n4 = n5;
                } else {
                    n3 = n6;
                    n6 = 1048575;
                    n4 = 0;
                }
                n5 = n12;
                if (n18 >= 18) {
                    n5 = n12;
                    if (n18 <= 49) {
                        nArray[n12] = n16;
                        n5 = n12 + 1;
                    }
                }
                n15 = n8;
                n8 = n17;
                n12 = n3;
                n17 = n5;
                n3 = n15;
                n15 = n4;
                n5 = n6;
            }
            int n21 = n14 + 1;
            nArray2[n14] = n11;
            n11 = n21 + 1;
            n6 = (n19 & 0x200) != 0 ? 0x20000000 : 0;
            n4 = (n19 & 0x100) != 0 ? 0x10000000 : 0;
            nArray2[n21] = n4 | n6 | n18 << 20 | n16;
            n14 = n11 + 1;
            nArray2[n11] = n15 << 20 | n5;
            n6 = n12;
            n5 = n20;
            n12 = n17;
        }
        return new zziz<T>(nArray2, objectArray2, n, n8, zzjg2.zzb(), bl, false, nArray, n2, n13, zzjb2, zzik2, zzjv2, zzhe2, zzir2, null);
    }

    private static Field zzn(Class<?> object, String string) {
        try {
            Field field = ((Class)object).getDeclaredField(string);
            return field;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            Object object2 = ((Class)object).getDeclaredFields();
            int n = ((Field[])object2).length;
            int n2 = 0;
            while (true) {
                Object object3;
                if (n2 >= n) {
                    object = ((Class)object).getName();
                    object3 = Arrays.toString((Object[])object2);
                    object2 = new StringBuilder(String.valueOf(string).length() + 40 + String.valueOf(object).length() + String.valueOf(object3).length());
                    ((StringBuilder)object2).append("Field ");
                    ((StringBuilder)object2).append(string);
                    ((StringBuilder)object2).append(" for ");
                    ((StringBuilder)object2).append((String)object);
                    ((StringBuilder)object2).append(" not found. Known fields are ");
                    ((StringBuilder)object2).append((String)object3);
                    object = new RuntimeException(((StringBuilder)object2).toString());
                    throw object;
                }
                object3 = object2[n2];
                if (string.equals(((Field)object3).getName())) {
                    return object3;
                }
                ++n2;
            }
        }
    }

    private final void zzo(T t, T object, int n) {
        long l = this.zzA(n) & 0xFFFFF;
        if (!this.zzK(object, n)) {
            return;
        }
        Object object2 = zzkf.zzn(t, (long)l);
        object = zzkf.zzn(object, (long)l);
        if (object2 != null && object != null) {
            zzkf.zzo(t, (long)l, (Object)zzhz.zzi((Object)object2, object));
            this.zzL(t, n);
            return;
        }
        if (object == null) return;
        zzkf.zzo(t, (long)l, object);
        this.zzL(t, n);
    }

    private final void zzp(T t, T object, int n) {
        int n2 = this.zzA(n);
        int n3 = this.zzc[n];
        long l = n2 & 0xFFFFF;
        if (!this.zzM(object, n3, n)) {
            return;
        }
        Object object2 = this.zzM(t, n3, n) ? zzkf.zzn(t, (long)l) : null;
        object = zzkf.zzn(object, (long)l);
        if (object2 != null && object != null) {
            zzkf.zzo(t, (long)l, (Object)zzhz.zzi((Object)object2, object));
            this.zzN(t, n3, n);
            return;
        }
        if (object == null) return;
        zzkf.zzo(t, (long)l, object);
        this.zzN(t, n3, n);
    }

    /*
     * Unable to fully structure code
     */
    private final int zzq(T var1_1) {
        var15_2 = zziz.zzb;
        var6_4 = 0;
        var7_5 = 0;
        var2_6 = 1048575;
        for (var5_3 = 0; var5_3 < this.zzc.length; var5_3 += 3) {
            block83: {
                block84: {
                    block85: {
                        var11_12 = this.zzA(var5_3);
                        var10_11 = this.zzc[var5_3];
                        var12_13 = zziz.zzC(var11_12);
                        if (var12_13 <= 17) {
                            var3_7 = this.zzc[var5_3 + 2];
                            var4_8 = var3_7 & 1048575;
                            var9_10 = 1 << (var3_7 >>> 20);
                            var8_9 = var2_6;
                            var3_7 = var9_10;
                            if (var4_8 != var2_6) {
                                var7_5 = var15_2.getInt(var1_1, (long)var4_8);
                                var8_9 = var4_8;
                                var3_7 = var9_10;
                            }
                        } else {
                            var3_7 = 0;
                            var8_9 = var2_6;
                        }
                        var13_14 = var11_12 & 1048575;
                        switch (var12_13) {
                            default: {
                                var2_6 = var6_4;
                                break block83;
                            }
                            case 68: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var2_6 = zzgy.zzE((int)var10_11, (zziw)((zziw)var15_2.getObject(var1_1, var13_14)), (zzjh)this.zzv(var5_3));
                                break block84;
                            }
                            case 67: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var13_14 = zziz.zzG(var1_1, var13_14);
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = zzgy.zzx((long)(var13_14 >> 63 ^ var13_14 + var13_14));
                                ** GOTO lbl421
                            }
                            case 66: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var2_6 = zziz.zzF(var1_1, var13_14);
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = zzgy.zzw((int)(var2_6 >> 31 ^ var2_6 + var2_6));
                                ** GOTO lbl421
                            }
                            case 65: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                break block85;
                            }
                            case 64: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                ** GOTO lbl444
                            }
                            case 63: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var2_6 = zziz.zzF(var1_1, var13_14);
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = zzgy.zzv((int)var2_6);
                                ** GOTO lbl421
                            }
                            case 62: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var2_6 = zziz.zzF(var1_1, var13_14);
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = zzgy.zzw((int)var2_6);
                                ** GOTO lbl421
                            }
                            case 61: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var16_15 = (zzgr)var15_2.getObject(var1_1, var13_14);
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = var16_15.zzc();
                                var4_8 = zzgy.zzw((int)var2_6);
                                ** GOTO lbl393
                            }
                            case 60: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var2_6 = zzjj.zzw((int)var10_11, (Object)var15_2.getObject(var1_1, var13_14), (zzjh)this.zzv(var5_3));
                                break block84;
                            }
                            case 59: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var16_15 = var15_2.getObject(var1_1, var13_14);
                                if (!(var16_15 instanceof zzgr)) ** GOTO lbl93
                                var16_15 = (zzgr)var16_15;
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = var16_15.zzc();
                                var4_8 = zzgy.zzw((int)var2_6);
                                ** GOTO lbl393
lbl93:
                                // 1 sources

                                var16_15 = (String)var16_15;
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = zzgy.zzy((String)var16_15);
                                ** GOTO lbl421
                            }
                            case 58: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                ** GOTO lbl403
                            }
                            case 57: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                ** GOTO lbl444
                            }
                            case 56: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                break block85;
                            }
                            case 55: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var2_6 = zziz.zzF(var1_1, var13_14);
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = zzgy.zzv((int)var2_6);
                                ** GOTO lbl421
                            }
                            case 54: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var13_14 = zziz.zzG(var1_1, var13_14);
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                var3_7 = zzgy.zzx((long)var13_14);
                                ** GOTO lbl438
                            }
                            case 53: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var13_14 = zziz.zzG(var1_1, var13_14);
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                var3_7 = zzgy.zzx((long)var13_14);
                                ** GOTO lbl438
                            }
                            case 52: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                ** GOTO lbl444
                            }
                            case 51: {
                                var2_6 = var6_4;
                                if (!this.zzM(var1_1, var10_11, var5_3)) break block83;
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                break block85;
                            }
                            case 50: {
                                zzir.zza((int)var10_11, (Object)var15_2.getObject(var1_1, var13_14), (Object)this.zzw(var5_3));
                                var2_6 = var6_4;
                                break block83;
                            }
                            case 49: {
                                var2_6 = zzjj.zzz((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (zzjh)this.zzv(var5_3));
                                break block84;
                            }
                            case 48: {
                                var3_7 = zzjj.zzf((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var6_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgy.zzu((int)var10_11);
                                var4_8 = zzgy.zzw((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 47: {
                                var3_7 = zzjj.zzn((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var6_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgy.zzu((int)var10_11);
                                var4_8 = zzgy.zzw((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 46: {
                                var3_7 = zzjj.zzr((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var6_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgy.zzu((int)var10_11);
                                var4_8 = zzgy.zzw((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 45: {
                                var3_7 = zzjj.zzp((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var6_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgy.zzu((int)var10_11);
                                var4_8 = zzgy.zzw((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 44: {
                                var3_7 = zzjj.zzh((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var6_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgy.zzu((int)var10_11);
                                var4_8 = zzgy.zzw((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 43: {
                                var3_7 = zzjj.zzl((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var6_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgy.zzu((int)var10_11);
                                var4_8 = zzgy.zzw((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 42: {
                                var3_7 = zzjj.zzt((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var6_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgy.zzu((int)var10_11);
                                var4_8 = zzgy.zzw((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 41: {
                                var3_7 = zzjj.zzp((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var6_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgy.zzu((int)var10_11);
                                var4_8 = zzgy.zzw((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 40: {
                                var3_7 = zzjj.zzr((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var6_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgy.zzu((int)var10_11);
                                var4_8 = zzgy.zzw((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 39: {
                                var3_7 = zzjj.zzj((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var6_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgy.zzu((int)var10_11);
                                var4_8 = zzgy.zzw((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 38: {
                                var3_7 = zzjj.zzd((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var6_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgy.zzu((int)var10_11);
                                var4_8 = zzgy.zzw((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 37: {
                                var3_7 = zzjj.zzb((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var6_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgy.zzu((int)var10_11);
                                var4_8 = zzgy.zzw((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 36: {
                                var3_7 = zzjj.zzp((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var6_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgy.zzu((int)var10_11);
                                var4_8 = zzgy.zzw((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 35: {
                                var9_10 = zzjj.zzr((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var6_4;
                                if (var9_10 <= 0) break block83;
                                var3_7 = zzgy.zzu((int)var10_11);
                                var4_8 = zzgy.zzw((int)var9_10);
                                var2_6 = var9_10;
lbl275:
                                // 14 sources

                                var3_7 += var4_8;
                                ** GOTO lbl421
                            }
                            case 34: {
                                var2_6 = zzjj.zzg((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 33: {
                                var2_6 = zzjj.zzo((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 32: {
                                var2_6 = zzjj.zzs((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 31: {
                                var2_6 = zzjj.zzq((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 30: {
                                var2_6 = zzjj.zzi((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 29: {
                                var2_6 = zzjj.zzm((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 28: {
                                var2_6 = zzjj.zzy((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)));
                                break block84;
                            }
                            case 27: {
                                var2_6 = zzjj.zzx((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (zzjh)this.zzv(var5_3));
                                break block84;
                            }
                            case 26: {
                                var2_6 = zzjj.zzv((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)));
                                break block84;
                            }
                            case 25: {
                                var2_6 = zzjj.zzu((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 24: {
                                var2_6 = zzjj.zzq((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 23: {
                                var2_6 = zzjj.zzs((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 22: {
                                var2_6 = zzjj.zzk((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 21: {
                                var2_6 = zzjj.zze((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 20: {
                                var2_6 = zzjj.zzc((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 19: {
                                var2_6 = zzjj.zzq((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 18: {
                                var2_6 = zzjj.zzs((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 17: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgy.zzE((int)var10_11, (zziw)((zziw)var15_2.getObject(var1_1, var13_14)), (zzjh)this.zzv(var5_3));
                                break block84;
                            }
                            case 16: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var13_14 = var15_2.getLong(var1_1, var13_14);
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = zzgy.zzx((long)(var13_14 >> 63 ^ var13_14 + var13_14));
                                ** GOTO lbl421
                            }
                            case 15: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = var15_2.getInt(var1_1, var13_14);
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = zzgy.zzw((int)(var2_6 >> 31 ^ var2_6 + var2_6));
                                ** GOTO lbl421
                            }
                            case 14: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                break block85;
                            }
                            case 13: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                ** GOTO lbl444
                            }
                            case 12: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = var15_2.getInt(var1_1, var13_14);
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = zzgy.zzv((int)var2_6);
                                ** GOTO lbl421
                            }
                            case 11: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = var15_2.getInt(var1_1, var13_14);
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = zzgy.zzw((int)var2_6);
                                ** GOTO lbl421
                            }
                            case 10: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var16_15 = (zzgr)var15_2.getObject(var1_1, var13_14);
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = var16_15.zzc();
                                var4_8 = zzgy.zzw((int)var2_6);
                                ** GOTO lbl393
                            }
                            case 9: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzjj.zzw((int)var10_11, (Object)var15_2.getObject(var1_1, var13_14), (zzjh)this.zzv(var5_3));
                                break block84;
                            }
                            case 8: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var16_15 = var15_2.getObject(var1_1, var13_14);
                                if (!(var16_15 instanceof zzgr)) ** GOTO lbl395
                                var16_15 = (zzgr)var16_15;
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = var16_15.zzc();
                                var4_8 = zzgy.zzw((int)var2_6);
lbl393:
                                // 4 sources

                                var2_6 = var3_7 + (var4_8 + var2_6);
                                ** GOTO lbl422
lbl395:
                                // 1 sources

                                var16_15 = (String)var16_15;
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = zzgy.zzy((String)var16_15);
                                ** GOTO lbl421
                            }
                            case 7: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
lbl403:
                                // 2 sources

                                ++var2_6;
                                break block84;
                            }
                            case 6: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                ** GOTO lbl444
                            }
                            case 5: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                break block85;
                            }
                            case 4: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = var15_2.getInt(var1_1, var13_14);
                                var3_7 = zzgy.zzw((int)(var10_11 << 3));
                                var2_6 = zzgy.zzv((int)var2_6);
lbl421:
                                // 13 sources

                                var2_6 = var3_7 + var2_6;
lbl422:
                                // 2 sources

                                var2_6 = var6_4 + var2_6;
                                break block83;
                            }
                            case 3: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var13_14 = var15_2.getLong(var1_1, var13_14);
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                var3_7 = zzgy.zzx((long)var13_14);
                                ** GOTO lbl438
                            }
                            case 2: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var13_14 = var15_2.getLong(var1_1, var13_14);
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
                                var3_7 = zzgy.zzx((long)var13_14);
lbl438:
                                // 4 sources

                                var2_6 += var3_7;
                                break block84;
                            }
                            case 1: {
                                var2_6 = var6_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgy.zzw((int)(var10_11 << 3));
lbl444:
                                // 6 sources

                                var2_6 += 4;
                                break block84;
                            }
                            case 0: 
                        }
                        var2_6 = var6_4;
                        if ((var7_5 & var3_7) == 0) break block83;
                        var2_6 = zzgy.zzw((int)(var10_11 << 3));
                    }
                    var2_6 += 8;
                }
                var2_6 = var6_4 + var2_6;
            }
            var6_4 = var2_6;
            var2_6 = var8_9;
        }
        var15_2 = this.zzn;
        var2_6 = var15_2.zzh(var15_2.zzd(var1_1));
        if (!this.zzh) {
            return var6_4 + var2_6;
        }
        this.zzo.zzb(var1_1);
        throw null;
    }

    /*
     * Unable to fully structure code
     */
    private final int zzr(T var1_1) {
        var10_2 = zziz.zzb;
        var5_3 = 0;
        var6_4 = 0;
        while (true) {
            block82: {
                block83: {
                    block84: {
                        if (var5_3 >= this.zzc.length) {
                            var10_2 = this.zzn;
                            return var6_4 + var10_2.zzh(var10_2.zzd(var1_1));
                        }
                        var3_6 = this.zzA(var5_3);
                        var2_5 = zziz.zzC(var3_6);
                        var4_7 = this.zzc[var5_3];
                        var8_9 = var3_6 & 1048575;
                        if (var2_5 >= zzhj.zzJ.zza() && var2_5 <= zzhj.zzW.zza()) {
                            var3_6 = this.zzc[var5_3 + 2];
                        }
                        switch (var2_5) {
                            default: {
                                var2_5 = var6_4;
                                break block82;
                            }
                            case 68: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgy.zzE((int)var4_7, (zziw)((zziw)zzkf.zzn(var1_1, (long)var8_9)), (zzjh)this.zzv(var5_3));
                                break block83;
                            }
                            case 67: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var8_9 = zziz.zzG(var1_1, var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzx((long)(var8_9 >> 63 ^ var8_9 + var8_9));
                                ** GOTO lbl412
                            }
                            case 66: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zziz.zzF(var1_1, var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzw((int)(var2_5 >> 31 ^ var2_5 + var2_5));
                                ** GOTO lbl412
                            }
                            case 65: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgy.zzw((int)(var4_7 << 3));
                                break block84;
                            }
                            case 64: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgy.zzw((int)(var4_7 << 3));
                                ** GOTO lbl436
                            }
                            case 63: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zziz.zzF(var1_1, var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzv((int)var2_5);
                                ** GOTO lbl412
                            }
                            case 62: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zziz.zzF(var1_1, var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzw((int)var2_5);
                                ** GOTO lbl412
                            }
                            case 61: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var11_10 = (zzgr)zzkf.zzn(var1_1, (long)var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = var11_10.zzc();
                                var4_7 = zzgy.zzw((int)var2_5);
                                ** GOTO lbl384
                            }
                            case 60: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzjj.zzw((int)var4_7, (Object)zzkf.zzn(var1_1, (long)var8_9), (zzjh)this.zzv(var5_3));
                                break block83;
                            }
                            case 59: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var11_10 = zzkf.zzn(var1_1, (long)var8_9);
                                if (!(var11_10 instanceof zzgr)) ** GOTO lbl84
                                var11_10 = (zzgr)var11_10;
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = var11_10.zzc();
                                var4_7 = zzgy.zzw((int)var2_5);
                                ** GOTO lbl384
lbl84:
                                // 1 sources

                                var11_10 = (String)var11_10;
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzy((String)var11_10);
                                ** GOTO lbl412
                            }
                            case 58: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgy.zzw((int)(var4_7 << 3));
                                ** GOTO lbl394
                            }
                            case 57: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgy.zzw((int)(var4_7 << 3));
                                ** GOTO lbl436
                            }
                            case 56: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgy.zzw((int)(var4_7 << 3));
                                break block84;
                            }
                            case 55: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zziz.zzF(var1_1, var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzv((int)var2_5);
                                ** GOTO lbl412
                            }
                            case 54: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var8_9 = zziz.zzG(var1_1, var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzx((long)var8_9);
                                ** GOTO lbl429
                            }
                            case 53: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var8_9 = zziz.zzG(var1_1, var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzx((long)var8_9);
                                ** GOTO lbl429
                            }
                            case 52: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgy.zzw((int)(var4_7 << 3));
                                ** GOTO lbl436
                            }
                            case 51: {
                                var2_5 = var6_4;
                                if (!this.zzM(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgy.zzw((int)(var4_7 << 3));
                                break block84;
                            }
                            case 50: {
                                zzir.zza((int)var4_7, (Object)zzkf.zzn(var1_1, (long)var8_9), (Object)this.zzw(var5_3));
                                var2_5 = var6_4;
                                break block82;
                            }
                            case 49: {
                                var2_5 = zzjj.zzz((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (zzjh)this.zzv(var5_3));
                                break block83;
                            }
                            case 48: {
                                var3_6 = zzjj.zzf((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgy.zzu((int)var4_7);
                                var4_7 = zzgy.zzw((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 47: {
                                var3_6 = zzjj.zzn((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgy.zzu((int)var4_7);
                                var4_7 = zzgy.zzw((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 46: {
                                var3_6 = zzjj.zzr((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgy.zzu((int)var4_7);
                                var4_7 = zzgy.zzw((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 45: {
                                var3_6 = zzjj.zzp((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgy.zzu((int)var4_7);
                                var4_7 = zzgy.zzw((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 44: {
                                var3_6 = zzjj.zzh((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgy.zzu((int)var4_7);
                                var4_7 = zzgy.zzw((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 43: {
                                var3_6 = zzjj.zzl((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgy.zzu((int)var4_7);
                                var4_7 = zzgy.zzw((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 42: {
                                var3_6 = zzjj.zzt((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgy.zzu((int)var4_7);
                                var4_7 = zzgy.zzw((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 41: {
                                var3_6 = zzjj.zzp((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgy.zzu((int)var4_7);
                                var4_7 = zzgy.zzw((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 40: {
                                var3_6 = zzjj.zzr((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgy.zzu((int)var4_7);
                                var4_7 = zzgy.zzw((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 39: {
                                var3_6 = zzjj.zzj((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgy.zzu((int)var4_7);
                                var4_7 = zzgy.zzw((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 38: {
                                var3_6 = zzjj.zzd((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgy.zzu((int)var4_7);
                                var4_7 = zzgy.zzw((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 37: {
                                var3_6 = zzjj.zzb((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgy.zzu((int)var4_7);
                                var4_7 = zzgy.zzw((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 36: {
                                var3_6 = zzjj.zzp((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgy.zzu((int)var4_7);
                                var4_7 = zzgy.zzw((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 35: {
                                var7_8 = zzjj.zzr((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var7_8 <= 0) break block82;
                                var3_6 = zzgy.zzu((int)var4_7);
                                var4_7 = zzgy.zzw((int)var7_8);
                                var2_5 = var7_8;
lbl266:
                                // 14 sources

                                var3_6 += var4_7;
                                ** GOTO lbl412
                            }
                            case 34: {
                                var2_5 = zzjj.zzg((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 33: {
                                var2_5 = zzjj.zzo((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 32: {
                                var2_5 = zzjj.zzs((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 31: {
                                var2_5 = zzjj.zzq((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 30: {
                                var2_5 = zzjj.zzi((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 29: {
                                var2_5 = zzjj.zzm((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 28: {
                                var2_5 = zzjj.zzy((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)));
                                break block83;
                            }
                            case 27: {
                                var2_5 = zzjj.zzx((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (zzjh)this.zzv(var5_3));
                                break block83;
                            }
                            case 26: {
                                var2_5 = zzjj.zzv((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)));
                                break block83;
                            }
                            case 25: {
                                var2_5 = zzjj.zzu((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 24: {
                                var2_5 = zzjj.zzq((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 23: {
                                var2_5 = zzjj.zzs((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 22: {
                                var2_5 = zzjj.zzk((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 21: {
                                var2_5 = zzjj.zze((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 20: {
                                var2_5 = zzjj.zzc((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 19: {
                                var2_5 = zzjj.zzq((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 18: {
                                var2_5 = zzjj.zzs((int)var4_7, (List)((List)zzkf.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 17: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var2_5 = zzgy.zzE((int)var4_7, (zziw)((zziw)zzkf.zzn(var1_1, (long)var8_9)), (zzjh)this.zzv(var5_3));
                                break block83;
                            }
                            case 16: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var8_9 = zzkf.zzf(var1_1, (long)var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzx((long)(var8_9 >> 63 ^ var8_9 + var8_9));
                                ** GOTO lbl412
                            }
                            case 15: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var2_5 = zzkf.zzd(var1_1, (long)var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzw((int)(var2_5 >> 31 ^ var2_5 + var2_5));
                                ** GOTO lbl412
                            }
                            case 14: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var2_5 = zzgy.zzw((int)(var4_7 << 3));
                                break block84;
                            }
                            case 13: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var2_5 = zzgy.zzw((int)(var4_7 << 3));
                                ** GOTO lbl436
                            }
                            case 12: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var2_5 = zzkf.zzd(var1_1, (long)var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzv((int)var2_5);
                                ** GOTO lbl412
                            }
                            case 11: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var2_5 = zzkf.zzd(var1_1, (long)var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzw((int)var2_5);
                                ** GOTO lbl412
                            }
                            case 10: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var11_10 = (zzgr)zzkf.zzn(var1_1, (long)var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = var11_10.zzc();
                                var4_7 = zzgy.zzw((int)var2_5);
                                ** GOTO lbl384
                            }
                            case 9: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var2_5 = zzjj.zzw((int)var4_7, (Object)zzkf.zzn(var1_1, (long)var8_9), (zzjh)this.zzv(var5_3));
                                break block83;
                            }
                            case 8: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var11_10 = zzkf.zzn(var1_1, (long)var8_9);
                                if (!(var11_10 instanceof zzgr)) ** GOTO lbl386
                                var11_10 = (zzgr)var11_10;
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = var11_10.zzc();
                                var4_7 = zzgy.zzw((int)var2_5);
lbl384:
                                // 4 sources

                                var2_5 = var3_6 + (var4_7 + var2_5);
                                ** GOTO lbl413
lbl386:
                                // 1 sources

                                var11_10 = (String)var11_10;
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzy((String)var11_10);
                                ** GOTO lbl412
                            }
                            case 7: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var2_5 = zzgy.zzw((int)(var4_7 << 3));
lbl394:
                                // 2 sources

                                ++var2_5;
                                break block83;
                            }
                            case 6: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var2_5 = zzgy.zzw((int)(var4_7 << 3));
                                ** GOTO lbl436
                            }
                            case 5: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var2_5 = zzgy.zzw((int)(var4_7 << 3));
                                break block84;
                            }
                            case 4: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var2_5 = zzkf.zzd(var1_1, (long)var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzv((int)var2_5);
lbl412:
                                // 13 sources

                                var2_5 = var3_6 + var2_5;
lbl413:
                                // 2 sources

                                var2_5 = var6_4 + var2_5;
                                break block82;
                            }
                            case 3: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var8_9 = zzkf.zzf(var1_1, (long)var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzx((long)var8_9);
                                ** GOTO lbl429
                            }
                            case 2: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var8_9 = zzkf.zzf(var1_1, (long)var8_9);
                                var3_6 = zzgy.zzw((int)(var4_7 << 3));
                                var2_5 = zzgy.zzx((long)var8_9);
lbl429:
                                // 4 sources

                                var2_5 = var6_4 + (var3_6 + var2_5);
                                break block82;
                            }
                            case 1: {
                                var2_5 = var6_4;
                                if (!this.zzK(var1_1, var5_3)) break block82;
                                var2_5 = zzgy.zzw((int)(var4_7 << 3));
lbl436:
                                // 6 sources

                                var2_5 += 4;
                                break block83;
                            }
                            case 0: 
                        }
                        var2_5 = var6_4;
                        if (!this.zzK(var1_1, var5_3)) break block82;
                        var2_5 = zzgy.zzw((int)(var4_7 << 3));
                    }
                    var2_5 += 8;
                }
                var2_5 = var6_4 + var2_5;
            }
            var5_3 += 3;
            var6_4 = var2_5;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final int zzs(T var1_1, byte[] var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7, int var8_8, long var9_9, int var11_10, long var12_11, zzgf var14_12) throws IOException {
        block67: {
            block70: {
                block68: {
                    block69: {
                        block66: {
                            var15_13 = var3_3;
                            var18_15 = var19_14 = (zzhy)zziz.zzb.getObject(var1_1 /* !! */ , var12_11);
                            if (!var19_14.zza()) {
                                var16_16 = var19_14.size();
                                var16_16 = var16_16 == 0 ? 10 : (var16_16 += var16_16);
                                var18_15 = var19_14.zze(var16_16);
                                zziz.zzb.putObject(var1_1 /* !! */ , var12_11, (Object)var18_15);
                            }
                            switch (var11_10) {
                                default: {
                                    var11_10 = var15_13;
                                    if (var7_7 != 3) break block66;
                                    var1_1 /* !! */  = this.zzv(var8_8);
                                    var6_6 = var5_5 & -8 | 4;
                                    var3_3 = zzgg.zzj(var1_1 /* !! */ , (byte[])var2_2 /* !! */ , (int)var3_3, (int)var4_4, (int)var6_6, (zzgf)var14_12);
                                    var18_15.add(var14_12.zzc);
                                    break block67;
                                }
                                case 34: 
                                case 48: {
                                    if (var7_7 != 2) ** GOTO lbl29
                                    var1_1 /* !! */  = (zzil)var18_15;
                                    var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12);
                                    var4_4 = var14_12.zza + var3_3;
                                    while (var3_3 < var4_4) {
                                        var3_3 = zzgg.zzc((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                                        var1_1 /* !! */ .zzg(zzgu.zzc((long)var14_12.zzb));
                                    }
                                    if (var3_3 != var4_4) throw zzib.zza();
                                    break block68;
lbl29:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 == 0) {
                                        var1_1 /* !! */  = (zzil)var18_15;
                                        var3_3 = zzgg.zzc((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12);
                                        var1_1 /* !! */ .zzg(zzgu.zzc((long)var14_12.zzb));
                                        while (var3_3 < var4_4) {
                                            var6_6 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var3_3 = zzgg.zzc((byte[])var2_2 /* !! */ , (int)var6_6, (zzgf)var14_12);
                                            var1_1 /* !! */ .zzg(zzgu.zzc((long)var14_12.zzb));
                                        }
                                        return var3_3;
                                    }
                                    break block66;
                                }
                                case 33: 
                                case 47: {
                                    if (var7_7 != 2) ** GOTO lbl54
                                    var1_1 /* !! */  = (zzhs)var18_15;
                                    var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12);
                                    var4_4 = var14_12.zza + var3_3;
                                    while (var3_3 < var4_4) {
                                        var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                                        var1_1 /* !! */ .zzh(zzgu.zzb((int)var14_12.zza));
                                    }
                                    if (var3_3 != var4_4) throw zzib.zza();
                                    break block68;
lbl54:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 == 0) {
                                        var1_1 /* !! */  = (zzhs)var18_15;
                                        var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12);
                                        var1_1 /* !! */ .zzh(zzgu.zzb((int)var14_12.zza));
                                        while (var3_3 < var4_4) {
                                            var6_6 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var6_6, (zzgf)var14_12);
                                            var1_1 /* !! */ .zzh(zzgu.zzb((int)var14_12.zza));
                                        }
                                        return var3_3;
                                    }
                                    break block66;
                                }
                                case 30: 
                                case 44: {
                                    if (var7_7 != 2) ** GOTO lbl72
                                    var3_3 = zzgg.zzl((byte[])var2_2 /* !! */ , (int)var15_13, (zzhy)var18_15, (zzgf)var14_12);
                                    ** GOTO lbl75
lbl72:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 != 0) break block66;
                                    var3_3 = zzgg.zzk((int)var5_5, (byte[])var2_2 /* !! */ , (int)var3_3, (int)var4_4, (zzhy)var18_15, (zzgf)var14_12);
lbl75:
                                    // 2 sources

                                    var14_12 = (zzhr)var1_1 /* !! */ ;
                                    var2_2 /* !! */  = (byte[])var14_12.zzc;
                                    var1_1 /* !! */  = (T)var2_2 /* !! */ ;
                                    if (var2_2 /* !! */  == zzjw.zza()) {
                                        var1_1 /* !! */  = null;
                                    }
                                    if ((var1_1 /* !! */  = zzjj.zzG((int)var6_6, (List)var18_15, (zzhv)this.zzx(var8_8), var1_1 /* !! */ , this.zzn)) == null) return var3_3;
                                    var14_12.zzc = (zzjw)var1_1 /* !! */ ;
                                    return var3_3;
                                }
                                case 28: {
                                    var11_10 = var15_13;
                                    if (var7_7 != 2) break block66;
                                    var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12);
                                    var6_6 = var14_12.zza;
                                    if (var6_6 < 0) throw zzib.zzb();
                                    if (var6_6 > var2_2 /* !! */ .length - var3_3) throw zzib.zza();
                                    if (var6_6 != 0) ** GOTO lbl95
                                    var18_15.add((Object)zzgr.zzb);
                                    ** GOTO lbl99
lbl95:
                                    // 1 sources

                                    var18_15.add((Object)zzgr.zzj((byte[])var2_2 /* !! */ , (int)var3_3, (int)var6_6));
                                    while (true) {
                                        var3_3 += var6_6;
lbl99:
                                        // 3 sources

                                        while (var3_3 < var4_4) {
                                            var6_6 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var6_6, (zzgf)var14_12);
                                            var6_6 = var14_12.zza;
                                            if (var6_6 < 0) throw zzib.zzb();
                                            if (var6_6 > var2_2 /* !! */ .length - var3_3) throw zzib.zza();
                                            if (var6_6 == 0) {
                                                var18_15.add((Object)zzgr.zzb);
                                                continue;
                                            }
                                            ** GOTO lbl113
                                        }
                                        return var3_3;
lbl113:
                                        // 1 sources

                                        var18_15.add((Object)zzgr.zzj((byte[])var2_2 /* !! */ , (int)var3_3, (int)var6_6));
                                    }
                                }
                                case 27: {
                                    if (var7_7 == 2) return zzgg.zzm((zzjh)this.zzv(var8_8), (int)var5_5, (byte[])var2_2 /* !! */ , (int)var3_3, (int)var4_4, (zzhy)var18_15, (zzgf)var14_12);
                                    var11_10 = var15_13;
                                    break block66;
                                }
                                case 26: {
                                    var11_10 = var15_13;
                                    if (var7_7 != 2) break block66;
                                    if ((var9_9 & 0x20000000L) != 0L) ** GOTO lbl134
                                    var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12);
                                    var6_6 = var14_12.zza;
                                    if (var6_6 < 0) throw zzib.zzb();
                                    if (var6_6 != 0) ** GOTO lbl131
                                    var18_15.add((Object)"");
                                    ** GOTO lbl299
lbl131:
                                    // 1 sources

                                    var18_15.add((Object)new String(var2_2 /* !! */ , var3_3, var6_6, zzhz.zza));
                                    break;
lbl134:
                                    // 1 sources

                                    var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12);
                                    var7_7 = var14_12.zza;
                                    if (var7_7 < 0) throw zzib.zzb();
                                    if (var7_7 == 0) {
                                        var18_15.add((Object)"");
                                    } else {
                                        var6_6 = var3_3 + var7_7;
                                        if (zzkk.zzb((byte[])var2_2 /* !! */ , (int)var3_3, (int)var6_6) == false) throw zzib.zzf();
                                        var18_15.add((Object)new String(var2_2 /* !! */ , var3_3, var7_7, zzhz.zza));
                                        var3_3 = var6_6;
                                    }
                                    while (true) {
                                        var11_10 = var3_3;
                                        if (var3_3 < var4_4) {
                                            var6_6 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                                            var11_10 = var3_3;
                                            if (var5_5 == var14_12.zza) {
                                                var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var6_6, (zzgf)var14_12);
                                                var7_7 = var14_12.zza;
                                                if (var7_7 < 0) throw zzib.zzb();
                                                if (var7_7 == 0) {
                                                    var18_15.add((Object)"");
                                                    continue;
                                                }
                                                var6_6 = var3_3 + var7_7;
                                                if (zzkk.zzb((byte[])var2_2 /* !! */ , (int)var3_3, (int)var6_6) == false) throw zzib.zzf();
                                                var18_15.add((Object)new String(var2_2 /* !! */ , var3_3, var7_7, zzhz.zza));
                                                var3_3 = var6_6;
                                                continue;
                                            }
                                        }
                                        break block66;
                                        break;
                                    }
                                }
                                case 25: 
                                case 42: {
                                    if (var7_7 != 2) ** GOTO lbl172
                                    var1_1 /* !! */  = (zzgh)var18_15;
                                    var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12);
                                    var4_4 = var14_12.zza + var3_3;
                                    break block69;
lbl172:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 == 0) {
                                        var1_1 /* !! */  = (zzgh)var18_15;
                                        var3_3 = zzgg.zzc((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12);
                                        var17_18 = var14_12.zzb != 0L;
                                        var1_1 /* !! */ .zzd(var17_18);
                                        while (var3_3 < var4_4) {
                                            var6_6 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var3_3 = zzgg.zzc((byte[])var2_2 /* !! */ , (int)var6_6, (zzgf)var14_12);
                                            var17_18 = var14_12.zzb != 0L;
                                            var1_1 /* !! */ .zzd(var17_18);
                                        }
                                        return var3_3;
                                    }
                                    break block66;
                                }
                                case 24: 
                                case 31: 
                                case 41: 
                                case 45: {
                                    if (var7_7 != 2) ** GOTO lbl197
                                    var1_1 /* !! */  = (zzhs)var18_15;
                                    var4_4 = var14_12.zza + var3_3;
                                    for (var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12); var3_3 < var4_4; var3_3 += 4) {
                                        var1_1 /* !! */ .zzh(zzgg.zzd((byte[])var2_2 /* !! */ , (int)var3_3));
                                    }
                                    if (var3_3 != var4_4) throw zzib.zza();
                                    break block68;
lbl197:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 == 5) {
                                        var1_1 /* !! */  = (zzhs)var18_15;
                                        var1_1 /* !! */ .zzh(zzgg.zzd((byte[])var2_2 /* !! */ , (int)var3_3));
                                        while ((var3_3 = var15_13 + 4) < var4_4) {
                                            var15_13 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var1_1 /* !! */ .zzh(zzgg.zzd((byte[])var2_2 /* !! */ , (int)var15_13));
                                        }
                                        return var3_3;
                                    }
                                    break block66;
                                }
                                case 23: 
                                case 32: 
                                case 40: 
                                case 46: {
                                    if (var7_7 != 2) ** GOTO lbl218
                                    var1_1 /* !! */  = (zzil)var18_15;
                                    var4_4 = var14_12.zza + var3_3;
                                    for (var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12); var3_3 < var4_4; var3_3 += 8) {
                                        var1_1 /* !! */ .zzg(zzgg.zze((byte[])var2_2 /* !! */ , (int)var3_3));
                                    }
                                    if (var3_3 != var4_4) throw zzib.zza();
                                    break block68;
lbl218:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 == 1) {
                                        var1_1 /* !! */  = (zzil)var18_15;
                                        var1_1 /* !! */ .zzg(zzgg.zze((byte[])var2_2 /* !! */ , (int)var3_3));
                                        while ((var3_3 = var15_13 + 8) < var4_4) {
                                            var15_13 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var1_1 /* !! */ .zzg(zzgg.zze((byte[])var2_2 /* !! */ , (int)var15_13));
                                        }
                                        return var3_3;
                                    }
                                    break block66;
                                }
                                case 22: 
                                case 29: 
                                case 39: 
                                case 43: {
                                    if (var7_7 != 2) ** GOTO lbl234
                                    var3_3 = zzgg.zzl((byte[])var2_2 /* !! */ , (int)var15_13, (zzhy)var18_15, (zzgf)var14_12);
                                    break block68;
lbl234:
                                    // 1 sources

                                    if (var7_7 == 0) return zzgg.zzk((int)var5_5, (byte[])var2_2 /* !! */ , (int)var3_3, (int)var4_4, (zzhy)var18_15, (zzgf)var14_12);
                                    var11_10 = var15_13;
                                    break block66;
                                }
                                case 20: 
                                case 21: 
                                case 37: 
                                case 38: {
                                    if (var7_7 != 2) ** GOTO lbl248
                                    var1_1 /* !! */  = (zzil)var18_15;
                                    var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12);
                                    var4_4 = var14_12.zza + var3_3;
                                    while (var3_3 < var4_4) {
                                        var3_3 = zzgg.zzc((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                                        var1_1 /* !! */ .zzg(var14_12.zzb);
                                    }
                                    if (var3_3 != var4_4) throw zzib.zza();
                                    break block68;
lbl248:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 == 0) {
                                        var1_1 /* !! */  = (zzil)var18_15;
                                        var3_3 = zzgg.zzc((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12);
                                        var1_1 /* !! */ .zzg(var14_12.zzb);
                                        while (var3_3 < var4_4) {
                                            var6_6 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var3_3 = zzgg.zzc((byte[])var2_2 /* !! */ , (int)var6_6, (zzgf)var14_12);
                                            var1_1 /* !! */ .zzg(var14_12.zzb);
                                        }
                                        return var3_3;
                                    }
                                    break block66;
                                }
                                case 19: 
                                case 36: {
                                    if (var7_7 != 2) ** GOTO lbl271
                                    var1_1 /* !! */  = (zzhk)var18_15;
                                    var4_4 = var14_12.zza + var3_3;
                                    for (var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12); var3_3 < var4_4; var3_3 += 4) {
                                        var1_1 /* !! */ .zzd(Float.intBitsToFloat(zzgg.zzd((byte[])var2_2 /* !! */ , (int)var3_3)));
                                    }
                                    if (var3_3 != var4_4) throw zzib.zza();
                                    break block68;
lbl271:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 == 5) {
                                        var1_1 /* !! */  = (zzhk)var18_15;
                                        var1_1 /* !! */ .zzd(Float.intBitsToFloat(zzgg.zzd((byte[])var2_2 /* !! */ , (int)var3_3)));
                                        while ((var3_3 = var15_13 + 4) < var4_4) {
                                            var15_13 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var1_1 /* !! */ .zzd(Float.intBitsToFloat(zzgg.zzd((byte[])var2_2 /* !! */ , (int)var15_13)));
                                        }
                                        return var3_3;
                                    }
                                    break block66;
                                }
                                case 18: 
                                case 35: {
                                    if (var7_7 != 2) ** GOTO lbl292
                                    var1_1 /* !! */  = (zzha)var18_15;
                                    var4_4 = var14_12.zza + var3_3;
                                    for (var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgf)var14_12); var3_3 < var4_4; var3_3 += 8) {
                                        var1_1 /* !! */ .zzd(Double.longBitsToDouble(zzgg.zze((byte[])var2_2 /* !! */ , (int)var3_3)));
                                    }
                                    if (var3_3 != var4_4) throw zzib.zza();
                                    break block68;
lbl292:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 != 1) break block66;
                                    var1_1 /* !! */  = (zzha)var18_15;
                                    var1_1 /* !! */ .zzd(Double.longBitsToDouble(zzgg.zze((byte[])var2_2 /* !! */ , (int)var3_3)));
                                    break block70;
                                }
                            }
                            block32: while (true) {
                                var3_3 += var6_6;
lbl299:
                                // 2 sources

                                while (true) {
                                    var11_10 = var3_3;
                                    if (var3_3 >= var4_4) break block32;
                                    var6_6 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                                    var11_10 = var3_3;
                                    if (var5_5 != var14_12.zza) break block32;
                                    var3_3 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var6_6, (zzgf)var14_12);
                                    var6_6 = var14_12.zza;
                                    if (var6_6 < 0) throw zzib.zzb();
                                    if (var6_6 != 0) break;
                                    var18_15.add((Object)"");
                                }
                                var18_15.add((Object)new String(var2_2 /* !! */ , var3_3, var6_6, zzhz.zza));
                            }
                        }
                        var3_3 = var11_10;
                        break block68;
                    }
                    while (var3_3 < var4_4) {
                        var3_3 = zzgg.zzc((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                        var17_17 = var14_12.zzb != 0L;
                        var1_1 /* !! */ .zzd(var17_17);
                    }
                    if (var3_3 != var4_4) throw zzib.zza();
                }
                return var3_3;
            }
            while ((var3_3 = var15_13 + 8) < var4_4) {
                var15_13 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
                if (var5_5 != var14_12.zza) {
                    return var3_3;
                }
                var1_1 /* !! */ .zzd(Double.longBitsToDouble(zzgg.zze((byte[])var2_2 /* !! */ , (int)var15_13)));
            }
            return var3_3;
        }
        while (var3_3 < var4_4) {
            var7_7 = zzgg.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgf)var14_12);
            if (var5_5 != var14_12.zza) {
                return var3_3;
            }
            var3_3 = zzgg.zzj(var1_1 /* !! */ , (byte[])var2_2 /* !! */ , (int)var7_7, (int)var4_4, (int)var6_6, (zzgf)var14_12);
            var18_15.add(var14_12.zzc);
        }
        return var3_3;
    }

    private final <K, V> int zzt(T object, byte[] object2, int n, int n2, int n3, long l, zzgf zzgf2) throws IOException {
        Unsafe unsafe = zzb;
        Object object3 = this.zzw(n3);
        object2 = unsafe.getObject(object, l);
        if (!((zziq)object2).zze()) {
            zzgf2 = zziq.zza().zzc();
            zzir.zzb((Object)zzgf2, (Object)object2);
            unsafe.putObject(object, l, (Object)zzgf2);
        }
        object = (zzip)object3;
        throw null;
    }

    private final int zzu(T t, byte[] object, int n, int n2, int n3, int n4, int n5, int n6, int n7, long l, int n8, zzgf zzgf2) throws IOException {
        Unsafe unsafe = zzb;
        long l2 = this.zzc[n8 + 2] & 0xFFFFF;
        switch (n7) {
            default: {
                break;
            }
            case 68: {
                if (n5 != 3) return n;
                n = zzgg.zzj((zzjh)this.zzv(n8), (byte[])object, (int)n, (int)n2, (int)(n3 & 0xFFFFFFF8 | 4), (zzgf)zzgf2);
                object = unsafe.getInt(t, l2) == n4 ? (Object)unsafe.getObject(t, l) : null;
                if (object == null) {
                    unsafe.putObject(t, l, zzgf2.zzc);
                } else {
                    unsafe.putObject(t, l, zzhz.zzi((Object)object, (Object)zzgf2.zzc));
                }
                unsafe.putInt(t, l2, n4);
                break;
            }
            case 67: {
                if (n5 != 0) return n;
                n = zzgg.zzc((byte[])object, (int)n, (zzgf)zzgf2);
                unsafe.putObject(t, l, (Object)zzgu.zzc((long)zzgf2.zzb));
                unsafe.putInt(t, l2, n4);
                return n;
            }
            case 66: {
                if (n5 != 0) return n;
                n = zzgg.zza((byte[])object, (int)n, (zzgf)zzgf2);
                unsafe.putObject(t, l, (Object)zzgu.zzb((int)zzgf2.zza));
                unsafe.putInt(t, l2, n4);
                return n;
            }
            case 63: {
                if (n5 != 0) return n;
                n = zzgg.zza((byte[])object, (int)n, (zzgf)zzgf2);
                n2 = zzgf2.zza;
                object = this.zzx(n8);
                if (object != null && !object.zza(n2)) {
                    zziz.zzf(t).zzh(n3, (Object)n2);
                    break;
                }
                unsafe.putObject(t, l, (Object)n2);
                unsafe.putInt(t, l2, n4);
                break;
            }
            case 61: {
                if (n5 != 2) return n;
                n = zzgg.zzh((byte[])object, (int)n, (zzgf)zzgf2);
                unsafe.putObject(t, l, zzgf2.zzc);
                unsafe.putInt(t, l2, n4);
                return n;
            }
            case 60: {
                if (n5 != 2) return n;
                n = zzgg.zzi((zzjh)this.zzv(n8), (byte[])object, (int)n, (int)n2, (zzgf)zzgf2);
                object = unsafe.getInt(t, l2) == n4 ? (Object)unsafe.getObject(t, l) : null;
                if (object == null) {
                    unsafe.putObject(t, l, zzgf2.zzc);
                } else {
                    unsafe.putObject(t, l, zzhz.zzi((Object)object, (Object)zzgf2.zzc));
                }
                unsafe.putInt(t, l2, n4);
                break;
            }
            case 59: {
                if (n5 != 2) return n;
                n = zzgg.zza((byte[])object, (int)n, (zzgf)zzgf2);
                n2 = zzgf2.zza;
                if (n2 == 0) {
                    unsafe.putObject(t, l, (Object)"");
                } else {
                    if ((n6 & 0x20000000) != 0) {
                        if (!zzkk.zzb((byte[])object, (int)n, (int)(n + n2))) throw zzib.zzf();
                    }
                    unsafe.putObject(t, l, (Object)new String((byte[])object, n, n2, zzhz.zza));
                    n += n2;
                }
                unsafe.putInt(t, l2, n4);
                break;
            }
            case 58: {
                if (n5 != 0) return n;
                n = zzgg.zzc((byte[])object, (int)n, (zzgf)zzgf2);
                boolean bl = zzgf2.zzb != 0L;
                unsafe.putObject(t, l, (Object)bl);
                unsafe.putInt(t, l2, n4);
                return n;
            }
            case 57: 
            case 64: {
                if (n5 != 5) return n;
                unsafe.putObject(t, l, (Object)zzgg.zzd((byte[])object, (int)n));
                unsafe.putInt(t, l2, n4);
                return n + 4;
            }
            case 56: 
            case 65: {
                if (n5 != 1) return n;
                unsafe.putObject(t, l, (Object)zzgg.zze((byte[])object, (int)n));
                unsafe.putInt(t, l2, n4);
                return n + 8;
            }
            case 55: 
            case 62: {
                if (n5 != 0) return n;
                n = zzgg.zza((byte[])object, (int)n, (zzgf)zzgf2);
                unsafe.putObject(t, l, (Object)zzgf2.zza);
                unsafe.putInt(t, l2, n4);
                return n;
            }
            case 53: 
            case 54: {
                if (n5 != 0) return n;
                n = zzgg.zzc((byte[])object, (int)n, (zzgf)zzgf2);
                unsafe.putObject(t, l, (Object)zzgf2.zzb);
                unsafe.putInt(t, l2, n4);
                return n;
            }
            case 52: {
                if (n5 != 5) return n;
                unsafe.putObject(t, l, (Object)Float.valueOf(Float.intBitsToFloat(zzgg.zzd((byte[])object, (int)n))));
                unsafe.putInt(t, l2, n4);
                return n + 4;
            }
            case 51: {
                if (n5 != 1) return n;
                unsafe.putObject(t, l, (Object)Double.longBitsToDouble(zzgg.zze((byte[])object, (int)n)));
                unsafe.putInt(t, l2, n4);
                return n + 8;
            }
        }
        return n;
    }

    private final zzjh zzv(int n) {
        zzjh zzjh2;
        n /= 3;
        if ((zzjh2 = (zzjh)this.zzd[n += n]) != null) {
            return zzjh2;
        }
        zzjh2 = zzje.zza().zzb((Class)this.zzd[n + 1]);
        this.zzd[n] = zzjh2;
        return zzjh2;
    }

    private final Object zzw(int n) {
        return this.zzd[(n /= 3) + n];
    }

    private final zzhv zzx(int n) {
        return (zzhv)this.zzd[(n /= 3) + n + 1];
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final int zzy(T var1_1, byte[] var2_2, int var3_3, int var4_4, zzgf var5_5) throws IOException {
        var6_6 = var4_4;
        var19_7 = zziz.zzb;
        var8_8 = var3_3;
        var3_3 = -1;
        var10_9 = 0;
        var6_6 = 0;
        var7_10 = 1048575;
        block15: while (var8_8 < (var9_11 = var4_4)) {
            block41: {
                block40: {
                    block39: {
                        block37: {
                            block38: {
                                block34: {
                                    block35: {
                                        block36: {
                                            block33: {
                                                var9_11 = var8_8 + 1;
                                                var11_12 = var2_2[var8_8];
                                                if (var11_12 < 0) {
                                                    var9_11 = zzgg.zzb((int)var11_12, (byte[])var2_2, (int)var9_11, (zzgf)var5_5);
                                                    var11_12 = var5_5.zza;
                                                }
                                                var8_8 = var11_12 >>> 3;
                                                var13_14 = var11_12 & 7;
                                                if ((var3_3 = var8_8 > var3_3 ? this.zzP(var8_8, var10_9 / 3) : this.zzO(var8_8)) != -1) break block33;
                                                var3_3 = 0;
                                                ** GOTO lbl177
                                            }
                                            var15_16 = this.zzc[var3_3 + 1];
                                            var14_15 = zziz.zzC(var15_16);
                                            var17_18 = var15_16 & 1048575;
                                            if (var14_15 > 17) break block34;
                                            var10_9 = this.zzc[var3_3 + 2];
                                            var16_17 = true;
                                            var12_13 = 1 << (var10_9 >>> 20);
                                            if ((var10_9 &= 1048575) != var7_10) {
                                                if (var7_10 != 1048575) {
                                                    var19_7.putInt(var1_1 /* !! */ , (long)var7_10, var6_6);
                                                }
                                                if (var10_9 != 1048575) {
                                                    var6_6 = var19_7.getInt(var1_1 /* !! */ , (long)var10_9);
                                                }
                                                var20_19 = var19_7;
                                                var7_10 = var10_9;
                                                var10_9 = var6_6;
                                            } else {
                                                var20_19 = var19_7;
                                                var10_9 = var6_6;
                                            }
                                            var20_19 = var19_7;
                                            switch (var14_15) {
                                                default: {
                                                    break block35;
                                                }
                                                case 16: {
                                                    if (var13_14 != 0) break block35;
                                                    var6_6 = zzgg.zzc((byte[])var2_2, (int)var9_11, (zzgf)var5_5);
                                                    var20_19.putLong(var1_1 /* !! */ , var17_18, zzgu.zzc((long)var5_5.zzb));
                                                    ** GOTO lbl111
                                                }
                                                case 15: {
                                                    if (var13_14 != 0) break block35;
                                                    var6_6 = zzgg.zza((byte[])var2_2, (int)var9_11, (zzgf)var5_5);
                                                    var20_19.putInt(var1_1 /* !! */ , var17_18, zzgu.zzb((int)var5_5.zza));
                                                    break block36;
                                                }
                                                case 12: {
                                                    if (var13_14 != 0) break block35;
                                                    var6_6 = zzgg.zza((byte[])var2_2, (int)var9_11, (zzgf)var5_5);
                                                    var20_19.putInt(var1_1 /* !! */ , var17_18, var5_5.zza);
                                                    break block36;
                                                }
                                                case 10: {
                                                    if (var13_14 != 2) break block35;
                                                    var6_6 = zzgg.zzh((byte[])var2_2, (int)var9_11, (zzgf)var5_5);
                                                    var20_19.putObject(var1_1 /* !! */ , var17_18, var5_5.zzc);
                                                    break block36;
                                                }
                                                case 9: {
                                                    if (var13_14 != 2) break block35;
                                                    var6_6 = zzgg.zzi((zzjh)this.zzv(var3_3), (byte[])var2_2, (int)var9_11, (int)var4_4, (zzgf)var5_5);
                                                    var19_7 = var20_19.getObject(var1_1 /* !! */ , var17_18);
                                                    if (var19_7 == null) {
                                                        var20_19.putObject(var1_1 /* !! */ , var17_18, var5_5.zzc);
                                                    } else {
                                                        var20_19.putObject(var1_1 /* !! */ , var17_18, zzhz.zzi((Object)var19_7, (Object)var5_5.zzc));
                                                    }
                                                    ** GOTO lbl87
                                                }
                                                case 8: {
                                                    if (var13_14 != 2) break block35;
                                                    var6_6 = (var15_16 & 0x20000000) == 0 ? zzgg.zzf((byte[])var2_2, (int)var9_11, (zzgf)var5_5) : zzgg.zzg((byte[])var2_2, (int)var9_11, (zzgf)var5_5);
                                                    var20_19.putObject(var1_1 /* !! */ , var17_18, var5_5.zzc);
                                                    ** GOTO lbl87
                                                }
                                                case 7: {
                                                    if (var13_14 != 0) break block35;
                                                    var6_6 = zzgg.zzc((byte[])var2_2, (int)var9_11, (zzgf)var5_5);
                                                    if (var5_5.zzb == 0L) {
                                                        var16_17 = false;
                                                    }
                                                    zzkf.zzi(var1_1 /* !! */ , (long)var17_18, (boolean)var16_17);
                                                    ** GOTO lbl87
                                                }
                                                case 6: 
                                                case 13: {
                                                    if (var13_14 != 5) break block35;
                                                    var20_19.putInt(var1_1 /* !! */ , var17_18, zzgg.zzd((byte[])var2_2, (int)var9_11));
                                                    var6_6 = var9_11 + 4;
lbl87:
                                                    // 5 sources

                                                    var11_12 = var10_9 | var12_13;
                                                    var19_7 = var20_19;
                                                    var9_11 = var8_8;
                                                    var8_8 = var4_4;
                                                    var10_9 = var3_3;
                                                    var8_8 = var6_6;
                                                    var3_3 = var9_11;
                                                    var6_6 = var11_12;
                                                    continue block15;
                                                }
                                                case 5: 
                                                case 14: {
                                                    if (var13_14 != 1) break block35;
                                                    var20_19.putLong(var1_1 /* !! */ , var17_18, zzgg.zze((byte[])var2_2, (int)var9_11));
                                                    var6_6 = var9_11 + 8;
                                                    break block36;
                                                }
                                                case 4: 
                                                case 11: {
                                                    if (var13_14 != 0) break block35;
                                                    var6_6 = zzgg.zza((byte[])var2_2, (int)var9_11, (zzgf)var5_5);
                                                    var20_19.putInt(var1_1 /* !! */ , var17_18, var5_5.zza);
                                                    break block36;
                                                }
                                                case 2: 
                                                case 3: {
                                                    if (var13_14 != 0) break block35;
                                                    var6_6 = zzgg.zzc((byte[])var2_2, (int)var9_11, (zzgf)var5_5);
                                                    var20_19.putLong(var1_1 /* !! */ , var17_18, var5_5.zzb);
lbl111:
                                                    // 2 sources

                                                    var11_12 = var10_9 | var12_13;
                                                    var19_7 = var20_19;
                                                    var9_11 = var6_6;
                                                    var10_9 = var3_3;
                                                    var6_6 = var11_12;
                                                    break block37;
                                                }
                                                case 1: {
                                                    if (var13_14 != 5) break block35;
                                                    zzkf.zzk(var1_1 /* !! */ , (long)var17_18, (float)Float.intBitsToFloat(zzgg.zzd((byte[])var2_2, (int)var9_11)));
                                                    var6_6 = var9_11 + 4;
                                                    break block36;
                                                }
                                                case 0: 
                                            }
                                            if (var13_14 != 1) break block35;
                                            zzkf.zzm(var1_1 /* !! */ , (long)var17_18, (double)Double.longBitsToDouble(zzgg.zze((byte[])var2_2, (int)var9_11)));
                                            var6_6 = var9_11 + 8;
                                        }
                                        var9_11 = var3_3;
                                        var9_11 = var6_6;
                                        var6_6 = var10_9 |= var12_13;
                                        break block38;
                                    }
                                    var19_7 = var20_19;
                                    var6_6 = var10_9;
                                    ** GOTO lbl177
                                }
                                var12_13 = var3_3;
                                var21_20 = var19_7;
                                if (var14_15 != 27) break block39;
                                if (var13_14 != 2) ** GOTO lbl177
                                var22_21 = (zzhy)var21_20.getObject(var1_1 /* !! */ , var17_18);
                                var20_19 = var22_21;
                                if (!var22_21.zza()) {
                                    var10_9 = var22_21.size();
                                    var10_9 = var10_9 == 0 ? 10 : (var10_9 += var10_9);
                                    var20_19 = var22_21.zze(var10_9);
                                    var21_20.putObject(var1_1 /* !! */ , var17_18, var20_19);
                                }
                                var9_11 = zzgg.zzm((zzjh)this.zzv(var12_13), (int)var11_12, (byte[])var2_2, (int)var9_11, (int)var4_4, (zzhy)var20_19, (zzgf)var5_5);
                            }
                            var10_9 = var3_3;
                        }
                        var3_3 = var8_8;
                        var8_8 = var4_4;
                        var8_8 = var9_11;
                        continue;
                    }
                    if (var14_15 > 49) break block40;
                    var10_9 = var12_13 = this.zzs(var1_1 /* !! */ , var2_2, var9_11, var4_4, var11_12, var8_8, var13_14, var12_13, var15_16, var14_15, var17_18, var5_5);
                    if (var12_13 == var9_11) ** GOTO lbl-1000
                    var9_11 = var12_13;
                    ** GOTO lbl173
                }
                if (var14_15 != 50) break block41;
                if (var13_14 != 2) ** GOTO lbl177
                var10_9 = var12_13 = this.zzt(var1_1 /* !! */ , var2_2, var9_11, var4_4, var12_13, var17_18, var5_5);
                if (var12_13 == var9_11) ** GOTO lbl-1000
                var9_11 = var12_13;
                ** GOTO lbl173
            }
            var10_9 = var12_13 = this.zzu(var1_1 /* !! */ , var2_2, var9_11, var4_4, var11_12, var8_8, var13_14, var15_16, var14_15, var17_18, var12_13, var5_5);
            if (var12_13 != var9_11) {
                var9_11 = var12_13;
lbl173:
                // 3 sources

                var10_9 = var8_8;
                var10_9 = var3_3;
            } else lbl-1000:
            // 3 sources

            {
                var9_11 = var10_9;
lbl177:
                // 5 sources

                var9_11 = zzgg.zzn((int)var11_12, (byte[])var2_2, (int)var9_11, (int)var4_4, (zzjw)zziz.zzf(var1_1 /* !! */ ), (zzgf)var5_5);
                var10_9 = var8_8;
                var10_9 = var3_3;
            }
            var3_3 = var8_8;
            var8_8 = var4_4;
            var8_8 = var9_11;
        }
        if (var7_10 != 1048575) {
            var19_7.putInt(var1_1 /* !! */ , (long)var7_10, var6_6);
        }
        if (var8_8 == var4_4) {
            return var8_8;
        }
        var1_1 /* !! */  = zzib.zze();
        throw var1_1 /* !! */ ;
    }

    private static boolean zzz(Object object, int n, zzjh zzjh2) {
        return zzjh2.zzj(zzkf.zzn((Object)object, (long)(n & 0xFFFFF)));
    }

    public final T zza() {
        return (T)((zzhr)this.zzg).zzl(4, null, null);
    }

    /*
     * Unable to fully structure code
     */
    public final boolean zzb(T var1_1, T var2_2) {
        var4_3 = this.zzc.length;
        block23: for (var3_4 = 0; var3_4 < var4_3; var3_4 += 3) {
            block26: {
                var5_5 = this.zzA(var3_4);
                var8_7 = var5_5 & 1048575;
                switch (zziz.zzC(var5_5)) {
                    default: {
                        continue block23;
                    }
                    case 51: 
                    case 52: 
                    case 53: 
                    case 54: 
                    case 55: 
                    case 56: 
                    case 57: 
                    case 58: 
                    case 59: 
                    case 60: 
                    case 61: 
                    case 62: 
                    case 63: 
                    case 64: 
                    case 65: 
                    case 66: 
                    case 67: 
                    case 68: {
                        var6_6 = this.zzB(var3_4) & 1048575;
                        if (zzkf.zzd(var1_1, (long)var6_6) != zzkf.zzd(var2_2, (long)var6_6)) return false;
                        if (zzjj.zzD((Object)zzkf.zzn(var1_1, (long)var8_7), (Object)zzkf.zzn(var2_2, (long)var8_7))) continue block23;
                        break block26;
                    }
                    case 50: {
                        var10_8 = zzjj.zzD((Object)zzkf.zzn(var1_1, (long)var8_7), (Object)zzkf.zzn(var2_2, (long)var8_7));
                        ** GOTO lbl18
                    }
                    case 18: 
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: 
                    case 23: 
                    case 24: 
                    case 25: 
                    case 26: 
                    case 27: 
                    case 28: 
                    case 29: 
                    case 30: 
                    case 31: 
                    case 32: 
                    case 33: 
                    case 34: 
                    case 35: 
                    case 36: 
                    case 37: 
                    case 38: 
                    case 39: 
                    case 40: 
                    case 41: 
                    case 42: 
                    case 43: 
                    case 44: 
                    case 45: 
                    case 46: 
                    case 47: 
                    case 48: 
                    case 49: {
                        var10_8 = zzjj.zzD((Object)zzkf.zzn(var1_1, (long)var8_7), (Object)zzkf.zzn(var2_2, (long)var8_7));
lbl18:
                        // 2 sources

                        if (var10_8) continue block23;
                        break block26;
                    }
                    case 17: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzjj.zzD((Object)zzkf.zzn(var1_1, (long)var8_7), (Object)zzkf.zzn(var2_2, (long)var8_7)) == false) return false;
                        continue block23;
                    }
                    case 16: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzkf.zzf(var1_1, (long)var8_7) != zzkf.zzf(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 15: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzkf.zzd(var1_1, (long)var8_7) != zzkf.zzd(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 14: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzkf.zzf(var1_1, (long)var8_7) != zzkf.zzf(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 13: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzkf.zzd(var1_1, (long)var8_7) != zzkf.zzd(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 12: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzkf.zzd(var1_1, (long)var8_7) != zzkf.zzd(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 11: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzkf.zzd(var1_1, (long)var8_7) != zzkf.zzd(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 10: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzjj.zzD((Object)zzkf.zzn(var1_1, (long)var8_7), (Object)zzkf.zzn(var2_2, (long)var8_7)) == false) return false;
                        continue block23;
                    }
                    case 9: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzjj.zzD((Object)zzkf.zzn(var1_1, (long)var8_7), (Object)zzkf.zzn(var2_2, (long)var8_7)) == false) return false;
                        continue block23;
                    }
                    case 8: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzjj.zzD((Object)zzkf.zzn(var1_1, (long)var8_7), (Object)zzkf.zzn(var2_2, (long)var8_7)) == false) return false;
                        continue block23;
                    }
                    case 7: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzkf.zzh(var1_1, (long)var8_7) != zzkf.zzh(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 6: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzkf.zzd(var1_1, (long)var8_7) != zzkf.zzd(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 5: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzkf.zzf(var1_1, (long)var8_7) != zzkf.zzf(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 4: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzkf.zzd(var1_1, (long)var8_7) != zzkf.zzd(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 3: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzkf.zzf(var1_1, (long)var8_7) != zzkf.zzf(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 2: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (zzkf.zzf(var1_1, (long)var8_7) != zzkf.zzf(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 1: {
                        if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                        if (Float.floatToIntBits(zzkf.zzj(var1_1, (long)var8_7)) != Float.floatToIntBits(zzkf.zzj(var2_2, (long)var8_7))) return false;
                        continue block23;
                    }
                    case 0: 
                }
                if (this.zzI(var1_1, var2_2, var3_4) == false) return false;
                if (Double.doubleToLongBits(zzkf.zzl(var1_1, (long)var8_7)) != Double.doubleToLongBits(zzkf.zzl(var2_2, (long)var8_7))) return false;
                continue;
            }
            return false;
        }
        if (!this.zzn.zzd(var1_1).equals(this.zzn.zzd(var2_2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zzb(var1_1);
        this.zzo.zzb(var2_2);
        throw null;
    }

    /*
     * Unable to fully structure code
     */
    public final int zzc(T var1_1) {
        var5_2 = this.zzc.length;
        var3_4 = 0;
        for (var4_3 = 0; var4_3 < var5_2; var4_3 += 3) {
            block44: {
                block45: {
                    var2_5 = this.zzA(var4_3);
                    var6_6 = this.zzc[var4_3];
                    var8_8 = 1048575 & var2_5;
                    var7_7 = zziz.zzC(var2_5);
                    var2_5 = 37;
                    switch (var7_7) {
                        default: {
                            var2_5 = var3_4;
                            break block44;
                        }
                        case 68: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzkf.zzn(var1_1, (long)var8_8).hashCode();
                            break block45;
                        }
                        case 67: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzhz.zze((long)zziz.zzG(var1_1, var8_8));
                            break block45;
                        }
                        case 66: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zziz.zzF(var1_1, var8_8);
                            break block45;
                        }
                        case 65: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzhz.zze((long)zziz.zzG(var1_1, var8_8));
                            break block45;
                        }
                        case 64: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zziz.zzF(var1_1, var8_8);
                            break block45;
                        }
                        case 63: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zziz.zzF(var1_1, var8_8);
                            break block45;
                        }
                        case 62: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zziz.zzF(var1_1, var8_8);
                            break block45;
                        }
                        case 61: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzkf.zzn(var1_1, (long)var8_8).hashCode();
                            break block45;
                        }
                        case 60: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzkf.zzn(var1_1, (long)var8_8).hashCode();
                            break block45;
                        }
                        case 59: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = ((String)zzkf.zzn(var1_1, (long)var8_8)).hashCode();
                            break block45;
                        }
                        case 58: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzhz.zzf((boolean)zziz.zzH(var1_1, var8_8));
                            break block45;
                        }
                        case 57: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zziz.zzF(var1_1, var8_8);
                            break block45;
                        }
                        case 56: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzhz.zze((long)zziz.zzG(var1_1, var8_8));
                            break block45;
                        }
                        case 55: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zziz.zzF(var1_1, var8_8);
                            break block45;
                        }
                        case 54: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzhz.zze((long)zziz.zzG(var1_1, var8_8));
                            break block45;
                        }
                        case 53: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzhz.zze((long)zziz.zzG(var1_1, var8_8));
                            break block45;
                        }
                        case 52: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = Float.floatToIntBits(zziz.zzE(var1_1, var8_8));
                            break block45;
                        }
                        case 51: {
                            var2_5 = var3_4;
                            if (!this.zzM(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzhz.zze((long)Double.doubleToLongBits(zziz.zzD(var1_1, var8_8)));
                            break block45;
                        }
                        case 50: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzkf.zzn(var1_1, (long)var8_8).hashCode();
                            break block45;
                        }
                        case 18: 
                        case 19: 
                        case 20: 
                        case 21: 
                        case 22: 
                        case 23: 
                        case 24: 
                        case 25: 
                        case 26: 
                        case 27: 
                        case 28: 
                        case 29: 
                        case 30: 
                        case 31: 
                        case 32: 
                        case 33: 
                        case 34: 
                        case 35: 
                        case 36: 
                        case 37: 
                        case 38: 
                        case 39: 
                        case 40: 
                        case 41: 
                        case 42: 
                        case 43: 
                        case 44: 
                        case 45: 
                        case 46: 
                        case 47: 
                        case 48: 
                        case 49: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzkf.zzn(var1_1, (long)var8_8).hashCode();
                            break block45;
                        }
                        case 17: {
                            var10_9 = zzkf.zzn(var1_1, (long)var8_8);
                            if (var10_9 != null) {
                                var2_5 = var10_9.hashCode();
                            }
                            ** GOTO lbl166
                        }
                        case 16: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzhz.zze((long)zzkf.zzf(var1_1, (long)var8_8));
                            break block45;
                        }
                        case 15: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzkf.zzd(var1_1, (long)var8_8);
                            break block45;
                        }
                        case 14: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzhz.zze((long)zzkf.zzf(var1_1, (long)var8_8));
                            break block45;
                        }
                        case 13: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzkf.zzd(var1_1, (long)var8_8);
                            break block45;
                        }
                        case 12: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzkf.zzd(var1_1, (long)var8_8);
                            break block45;
                        }
                        case 11: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzkf.zzd(var1_1, (long)var8_8);
                            break block45;
                        }
                        case 10: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzkf.zzn(var1_1, (long)var8_8).hashCode();
                            break block45;
                        }
                        case 9: {
                            var10_9 = zzkf.zzn(var1_1, (long)var8_8);
                            if (var10_9 != null) {
                                var2_5 = var10_9.hashCode();
                            }
lbl166:
                            // 4 sources

                            var2_5 = var3_4 * 53 + var2_5;
                            break block44;
                        }
                        case 8: {
                            var2_5 = var3_4 * 53;
                            var3_4 = ((String)zzkf.zzn(var1_1, (long)var8_8)).hashCode();
                            break block45;
                        }
                        case 7: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzhz.zzf((boolean)zzkf.zzh(var1_1, (long)var8_8));
                            break block45;
                        }
                        case 6: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzkf.zzd(var1_1, (long)var8_8);
                            break block45;
                        }
                        case 5: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzhz.zze((long)zzkf.zzf(var1_1, (long)var8_8));
                            break block45;
                        }
                        case 4: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzkf.zzd(var1_1, (long)var8_8);
                            break block45;
                        }
                        case 3: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzhz.zze((long)zzkf.zzf(var1_1, (long)var8_8));
                            break block45;
                        }
                        case 2: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzhz.zze((long)zzkf.zzf(var1_1, (long)var8_8));
                            break block45;
                        }
                        case 1: {
                            var2_5 = var3_4 * 53;
                            var3_4 = Float.floatToIntBits(zzkf.zzj(var1_1, (long)var8_8));
                            break block45;
                        }
                        case 0: 
                    }
                    var2_5 = var3_4 * 53;
                    var3_4 = zzhz.zze((long)Double.doubleToLongBits(zzkf.zzl(var1_1, (long)var8_8)));
                }
                var2_5 += var3_4;
            }
            var3_4 = var2_5;
        }
        var2_5 = this.zzn.zzd(var1_1).hashCode();
        if (!this.zzh) {
            return var3_4 * 53 + var2_5;
        }
        this.zzo.zzb(var1_1);
        throw null;
    }

    public final void zzd(T t, T t2) {
        if (t2 == null) throw null;
        int n = 0;
        while (true) {
            if (n >= this.zzc.length) {
                zzjj.zzF(this.zzn, t, t2);
                if (!this.zzh) return;
                zzjj.zzE(this.zzo, t, t2);
                return;
            }
            int n2 = this.zzA(n);
            long l = 0xFFFFF & n2;
            int n3 = this.zzc[n];
            switch (zziz.zzC(n2)) {
                default: {
                    break;
                }
                case 68: {
                    this.zzp(t, t2, n);
                    break;
                }
                case 61: 
                case 62: 
                case 63: 
                case 64: 
                case 65: 
                case 66: 
                case 67: {
                    if (!this.zzM(t2, n3, n)) break;
                    zzkf.zzo(t, (long)l, (Object)zzkf.zzn(t2, (long)l));
                    this.zzN(t, n3, n);
                    break;
                }
                case 60: {
                    this.zzp(t, t2, n);
                    break;
                }
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: {
                    if (!this.zzM(t2, n3, n)) break;
                    zzkf.zzo(t, (long)l, (Object)zzkf.zzn(t2, (long)l));
                    this.zzN(t, n3, n);
                    break;
                }
                case 50: {
                    zzjj.zzI((zzir)this.zzq, t, t2, (long)l);
                    break;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 31: 
                case 32: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 47: 
                case 48: 
                case 49: {
                    this.zzm.zzb(t, t2, l);
                    break;
                }
                case 17: {
                    this.zzo(t, t2, n);
                    break;
                }
                case 16: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zzg(t, (long)l, (long)zzkf.zzf(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 15: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zze(t, (long)l, (int)zzkf.zzd(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 14: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zzg(t, (long)l, (long)zzkf.zzf(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 13: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zze(t, (long)l, (int)zzkf.zzd(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 12: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zze(t, (long)l, (int)zzkf.zzd(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 11: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zze(t, (long)l, (int)zzkf.zzd(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 10: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zzo(t, (long)l, (Object)zzkf.zzn(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 9: {
                    this.zzo(t, t2, n);
                    break;
                }
                case 8: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zzo(t, (long)l, (Object)zzkf.zzn(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 7: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zzi(t, (long)l, (boolean)zzkf.zzh(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 6: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zze(t, (long)l, (int)zzkf.zzd(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 5: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zzg(t, (long)l, (long)zzkf.zzf(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 4: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zze(t, (long)l, (int)zzkf.zzd(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 3: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zzg(t, (long)l, (long)zzkf.zzf(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 2: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zzg(t, (long)l, (long)zzkf.zzf(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 1: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zzk(t, (long)l, (float)zzkf.zzj(t2, (long)l));
                    this.zzL(t, n);
                    break;
                }
                case 0: {
                    if (!this.zzK(t2, n)) break;
                    zzkf.zzm(t, (long)l, (double)zzkf.zzl(t2, (long)l));
                    this.zzL(t, n);
                }
            }
            n += 3;
        }
    }

    public final int zze(T t) {
        int n = this.zzi ? this.zzr(t) : this.zzq(t);
        return n;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    final int zzg(T var1_1, byte[] var2_2, int var3_3, int var4_4, int var5_5, zzgf var6_6) throws IOException {
        block57: {
            block56: {
                block55: {
                    block39: {
                        var21_7 = var1_1 /* !! */ ;
                        var11_8 = var4_4;
                        var10_9 = var5_5;
                        var21_7 = var6_6 /* !! */ ;
                        var21_7 = zziz.zzb;
                        var7_10 = var3_3;
                        var8_11 = 0;
                        var13_12 = -1;
                        var14_13 = 0;
                        var3_3 = 0;
                        var9_14 = 1048575;
                        while (true) {
                            block41: {
                                block52: {
                                    block53: {
                                        block54: {
                                            block50: {
                                                block51: {
                                                    block49: {
                                                        block47: {
                                                            block42: {
                                                                block43: {
                                                                    block48: {
                                                                        block45: {
                                                                            block44: {
                                                                                block46: {
                                                                                    block40: {
                                                                                        var22_21 /* !! */  = var1_1 /* !! */ ;
                                                                                        var23_22 = var6_6 /* !! */ ;
                                                                                        if (var7_10 >= var11_8) break;
                                                                                        var12_15 = var7_10 + 1;
                                                                                        if ((var7_10 = var2_2[var7_10]) < 0) {
                                                                                            var12_15 = zzgg.zzb((int)var7_10, (byte[])var2_2, (int)var12_15, (zzgf)var23_22);
                                                                                            var7_10 = var23_22.zza;
                                                                                        }
                                                                                        var15_16 = var7_10 >>> 3;
                                                                                        var16_17 = var7_10 & 7;
                                                                                        var8_11 = var15_16 > var13_12 ? this.zzP(var15_16, var14_13 / 3) : this.zzO(var15_16);
                                                                                        if (var8_11 != -1) break block40;
                                                                                        var8_11 = var7_10;
                                                                                        var8_11 = var3_3;
                                                                                        var3_3 = var10_9;
                                                                                        var11_8 = 0;
                                                                                        var10_9 = var12_15;
                                                                                        break block41;
                                                                                    }
                                                                                    var14_13 = this.zzc[var8_11 + 1];
                                                                                    var17_18 = zziz.zzC(var14_13);
                                                                                    var18_19 = var14_13 & 1048575;
                                                                                    if (var17_18 > 17) break block42;
                                                                                    var10_9 = this.zzc[var8_11 + 2];
                                                                                    var13_12 = 1 << (var10_9 >>> 20);
                                                                                    if ((var10_9 &= 1048575) != var9_14) {
                                                                                        if (var9_14 != 1048575) {
                                                                                            var21_7.putInt(var22_21 /* !! */ , (long)var9_14, var3_3);
                                                                                        }
                                                                                        var3_3 = var21_7.getInt(var22_21 /* !! */ , (long)var10_9);
                                                                                        var9_14 = var10_9;
                                                                                        var10_9 = var3_3;
                                                                                    } else {
                                                                                        var10_9 = var3_3;
                                                                                    }
                                                                                    switch (var17_18) {
                                                                                        default: {
                                                                                            if (var16_17 != 3) break block43;
                                                                                            var3_3 = zzgg.zzj((zzjh)this.zzv(var8_11), (byte[])var2_2, (int)var12_15, (int)var4_4, (int)(var15_16 << 3 | 4), (zzgf)var6_6 /* !! */ );
                                                                                            if ((var10_9 & var13_12) != 0) break block44;
                                                                                            var21_7.putObject(var22_21 /* !! */ , var18_19, var23_22.zzc);
                                                                                            break block45;
                                                                                        }
                                                                                        case 16: {
                                                                                            if (var16_17 != 0) break block43;
                                                                                            var3_3 = zzgg.zzc((byte[])var2_2, (int)var12_15, (zzgf)var23_22);
                                                                                            var21_7.putLong(var1_1 /* !! */ , var18_19, zzgu.zzc((long)var23_22.zzb));
                                                                                            ** GOTO lbl120
                                                                                        }
                                                                                        case 15: {
                                                                                            if (var16_17 != 0) break block43;
                                                                                            var3_3 = zzgg.zza((byte[])var2_2, (int)var12_15, (zzgf)var23_22);
                                                                                            var21_7.putInt(var22_21 /* !! */ , var18_19, zzgu.zzb((int)var23_22.zza));
                                                                                            break block46;
                                                                                        }
                                                                                        case 12: {
                                                                                            if (var16_17 != 0) break block43;
                                                                                            var3_3 = zzgg.zza((byte[])var2_2, (int)var12_15, (zzgf)var23_22);
                                                                                            var12_15 = var23_22.zza;
                                                                                            var23_22 = this.zzx(var8_11);
                                                                                            if (var23_22 == null || var23_22.zza(var12_15)) ** GOTO lbl75
                                                                                            zziz.zzf(var1_1 /* !! */ ).zzh(var7_10, (Object)((long)var12_15));
                                                                                            var12_15 = var10_9;
                                                                                            var10_9 = var8_11;
                                                                                            var10_9 = var7_10;
                                                                                            var10_9 = var3_3;
                                                                                            var3_3 = var12_15;
                                                                                            break block47;
lbl75:
                                                                                            // 1 sources

                                                                                            var21_7.putInt(var22_21 /* !! */ , var18_19, var12_15);
                                                                                            break block46;
                                                                                        }
                                                                                        case 10: {
                                                                                            if (var16_17 != 2) break block43;
                                                                                            var3_3 = zzgg.zzh((byte[])var2_2, (int)var12_15, (zzgf)var23_22);
                                                                                            var21_7.putObject(var22_21 /* !! */ , var18_19, var23_22.zzc);
                                                                                            break block46;
                                                                                        }
                                                                                        case 9: {
                                                                                            if (var16_17 != 2) break block43;
                                                                                            var3_3 = zzgg.zzi((zzjh)this.zzv(var8_11), (byte[])var2_2, (int)var12_15, (int)var11_8, (zzgf)var23_22);
                                                                                            if ((var10_9 & var13_12) == 0) {
                                                                                                var21_7.putObject(var22_21 /* !! */ , var18_19, var23_22.zzc);
                                                                                            } else {
                                                                                                var21_7.putObject(var22_21 /* !! */ , var18_19, zzhz.zzi((Object)var21_7.getObject(var22_21 /* !! */ , var18_19), (Object)var23_22.zzc));
                                                                                            }
                                                                                            break block46;
                                                                                        }
                                                                                        case 8: {
                                                                                            if (var16_17 != 2) break block43;
                                                                                            var3_3 = (var14_13 & 0x20000000) == 0 ? zzgg.zzf((byte[])var2_2, (int)var12_15, (zzgf)var23_22) : zzgg.zzg((byte[])var2_2, (int)var12_15, (zzgf)var23_22);
                                                                                            var21_7.putObject(var22_21 /* !! */ , var18_19, var23_22.zzc);
                                                                                            break block46;
                                                                                        }
                                                                                        case 7: {
                                                                                            if (var16_17 != 0) break block43;
                                                                                            var3_3 = zzgg.zzc((byte[])var2_2, (int)var12_15, (zzgf)var23_22);
                                                                                            var20_20 = var23_22.zzb != 0L;
                                                                                            zzkf.zzi(var22_21 /* !! */ , (long)var18_19, (boolean)var20_20);
                                                                                            break block46;
                                                                                        }
                                                                                        case 6: 
                                                                                        case 13: {
                                                                                            if (var16_17 != 5) break block43;
                                                                                            var21_7.putInt(var22_21 /* !! */ , var18_19, zzgg.zzd((byte[])var2_2, (int)var12_15));
                                                                                            var3_3 = var12_15 + 4;
                                                                                            break block46;
                                                                                        }
                                                                                        case 5: 
                                                                                        case 14: {
                                                                                            if (var16_17 != 1) break block43;
                                                                                            var21_7.putLong(var1_1 /* !! */ , var18_19, zzgg.zze((byte[])var2_2, (int)var12_15));
                                                                                            var3_3 = var12_15 + 8;
                                                                                            break block46;
                                                                                        }
                                                                                        case 4: 
                                                                                        case 11: {
                                                                                            if (var16_17 != 0) break block43;
                                                                                            var3_3 = zzgg.zza((byte[])var2_2, (int)var12_15, (zzgf)var23_22);
                                                                                            var21_7.putInt(var22_21 /* !! */ , var18_19, var23_22.zza);
                                                                                            break block46;
                                                                                        }
                                                                                        case 2: 
                                                                                        case 3: {
                                                                                            if (var16_17 != 0) break block43;
                                                                                            var3_3 = zzgg.zzc((byte[])var2_2, (int)var12_15, (zzgf)var23_22);
                                                                                            var21_7.putLong(var1_1 /* !! */ , var18_19, var23_22.zzb);
lbl120:
                                                                                            // 2 sources

                                                                                            var12_15 = var10_9 | var13_12;
                                                                                            var10_9 = var9_14;
                                                                                            break block48;
                                                                                        }
                                                                                        case 1: {
                                                                                            if (var16_17 != 5) break block43;
                                                                                            zzkf.zzk(var22_21 /* !! */ , (long)var18_19, (float)Float.intBitsToFloat(zzgg.zzd((byte[])var2_2, (int)var12_15)));
                                                                                            var3_3 = var12_15 + 4;
                                                                                            break block46;
                                                                                        }
                                                                                        case 0: 
                                                                                    }
                                                                                    if (var16_17 != 1) break block43;
                                                                                    zzkf.zzm(var22_21 /* !! */ , (long)var18_19, (double)Double.longBitsToDouble(zzgg.zze((byte[])var2_2, (int)var12_15)));
                                                                                    var3_3 = var12_15 + 8;
                                                                                }
                                                                                var12_15 = var10_9 | var13_12;
                                                                                var10_9 = var9_14;
                                                                                break block48;
                                                                            }
                                                                            var21_7.putObject(var22_21 /* !! */ , var18_19, zzhz.zzi((Object)var21_7.getObject(var22_21 /* !! */ , var18_19), (Object)var23_22.zzc));
                                                                        }
                                                                        var12_15 = var10_9 | var13_12;
                                                                        var10_9 = var9_14;
                                                                        var11_8 = var4_4;
                                                                    }
                                                                    var10_9 = var8_11;
                                                                    var10_9 = var7_10;
                                                                    var10_9 = var3_3;
                                                                    var3_3 = var12_15;
                                                                    break block47;
                                                                }
                                                                var11_8 = var12_15;
                                                                var3_3 = var5_5;
                                                                var12_15 = var7_10;
                                                                var12_15 = var10_9;
                                                                var10_9 = var11_8;
                                                                var11_8 = var8_11;
                                                                var8_11 = var12_15;
                                                                break block41;
                                                            }
                                                            if (var17_18 != 27) break block49;
                                                            if (var16_17 != 2) break block50;
                                                            var24_23 = (zzhy)var21_7.getObject(var22_21 /* !! */ , var18_19);
                                                            var23_22 = var24_23;
                                                            if (!var24_23.zza()) {
                                                                var10_9 = var24_23.size();
                                                                var10_9 = var10_9 == 0 ? 10 : (var10_9 += var10_9);
                                                                var23_22 = var24_23.zze(var10_9);
                                                                var21_7.putObject(var22_21 /* !! */ , var18_19, (Object)var23_22);
                                                            }
                                                            var22_21 /* !! */  = this.zzv(var8_11);
                                                            var10_9 = var7_10;
                                                            var10_9 = zzgg.zzm(var22_21 /* !! */ , (int)var10_9, (byte[])var2_2, (int)var12_15, (int)var4_4, (zzhy)var23_22, (zzgf)var6_6 /* !! */ );
                                                            var11_8 = var4_4;
                                                            var12_15 = var8_11;
                                                        }
                                                        var14_13 = var8_11;
                                                        var8_11 = var7_10;
                                                        var13_12 = var15_16;
                                                        var12_15 = var5_5;
                                                        var7_10 = var10_9;
                                                        var10_9 = var12_15;
                                                        continue;
                                                    }
                                                    if (var17_18 > 49) break block51;
                                                    var10_9 = var11_8 = this.zzs(var1_1 /* !! */ , (byte[])var2_2, var12_15, var4_4, var7_10, var15_16, var16_17, var8_11, var14_13, var17_18, var18_19, var6_6 /* !! */ );
                                                    if (var11_8 == var12_15) break block52;
                                                    var10_9 = var11_8;
                                                    break block53;
                                                }
                                                if (var17_18 != 50) break block54;
                                                if (var16_17 != 2) break block50;
                                                var10_9 = var11_8 = this.zzt(var1_1 /* !! */ , (byte[])var2_2, var12_15, var4_4, var8_11, var18_19, var6_6 /* !! */ );
                                                if (var11_8 == var12_15) break block52;
                                                var10_9 = var11_8;
                                                break block53;
                                            }
                                            var10_9 = var12_15;
                                            break block52;
                                        }
                                        var10_9 = var11_8 = this.zzu(var1_1 /* !! */ , (byte[])var2_2, var12_15, var4_4, var7_10, var15_16, var16_17, var14_13, var17_18, var18_19, var8_11, var6_6 /* !! */ );
                                        if (var11_8 == var12_15) break block52;
                                        var10_9 = var11_8;
                                    }
                                    var22_21 /* !! */  = var1_1 /* !! */ ;
                                    var13_12 = var15_16;
                                    var11_8 = var4_4;
                                    var12_15 = var5_5;
                                    var22_21 /* !! */  = var6_6 /* !! */ ;
                                    var14_13 = var8_11;
                                    var8_11 = var7_10;
                                    var7_10 = var10_9;
                                    var10_9 = var12_15;
                                    continue;
                                }
                                var12_15 = var3_3;
                                var3_3 = var5_5;
                                var11_8 = var7_10;
                                var11_8 = var8_11;
                                var8_11 = var12_15;
                            }
                            var12_15 = var7_10;
                            if (var12_15 == var3_3 && var3_3 != 0) {
                                var2_2 = this;
                                var7_10 = var10_9;
                                var10_9 = var8_11;
                                var8_11 = var12_15;
                                var5_5 = var3_3;
                                break block39;
                            }
                            if (this.zzh && var6_6 /* !! */ .zzd != zzhd.zza()) {
                                var22_21 /* !! */  = this.zzg;
                                if (var6_6 /* !! */ .zzd.zzc(var22_21 /* !! */ , var15_16) != null) {
                                    var1_1 /* !! */  = (zzho)var1_1 /* !! */ ;
                                    throw null;
                                }
                                var7_10 = zzgg.zzn((int)var12_15, (byte[])var2_2, (int)var10_9, (int)var4_4, (zzjw)zziz.zzf(var1_1 /* !! */ ), (zzgf)var6_6 /* !! */ );
                            } else {
                                var7_10 = zzgg.zzn((int)var12_15, (byte[])var2_2, (int)var10_9, (int)var4_4, (zzjw)zziz.zzf(var1_1 /* !! */ ), (zzgf)var6_6 /* !! */ );
                            }
                            var16_17 = var4_4;
                            var14_13 = var12_15;
                            var22_21 /* !! */  = var6_6 /* !! */ ;
                            var13_12 = var15_16;
                            var22_21 /* !! */  = var1_1 /* !! */ ;
                            var12_15 = var8_11;
                            var10_9 = var3_3;
                            var8_11 = var14_13;
                            var14_13 = var11_8;
                            var3_3 = var12_15;
                            var11_8 = var16_17;
                        }
                        var5_5 = var10_9;
                        var1_1 /* !! */  = var22_21 /* !! */ ;
                        var2_2 = this;
                        var10_9 = var3_3;
                    }
                    var2_2 = this;
                    if (var9_14 != 1048575) {
                        var21_7.putInt(var1_1 /* !! */ , (long)var9_14, var10_9);
                    }
                    for (var3_3 = var2_2.zzk; var3_3 < var2_2.zzl; ++var3_3) {
                        var9_14 = var2_2.zzj[var3_3];
                        var10_9 = var2_2.zzc[var9_14];
                        var6_6 /* !! */  = zzkf.zzn(var1_1 /* !! */ , (long)(super.zzA(var9_14) & 1048575));
                        if (var6_6 /* !! */  == null || super.zzx(var9_14) == null) continue;
                        var1_1 /* !! */  = (zziq)var6_6 /* !! */ ;
                        var1_1 /* !! */  = (zzip)super.zzw(var9_14);
                        throw null;
                    }
                    if (var5_5 != 0) break block55;
                    if (var7_10 != var4_4) throw zzib.zze();
                    break block56;
                }
                if (var7_10 > var4_4 || var8_11 != var5_5) break block57;
            }
            return var7_10;
        }
        var1_1 /* !! */  = zzib.zze();
        throw var1_1 /* !! */ ;
    }

    public final void zzh(T t, byte[] byArray, int n, int n2, zzgf zzgf2) throws IOException {
        if (this.zzi) {
            this.zzy(t, byArray, n, n2, zzgf2);
            return;
        }
        this.zzg(t, byArray, n, n2, 0, zzgf2);
    }

    public final void zzi(T t) {
        int n;
        int n2;
        for (n2 = this.zzk; n2 < (n = this.zzl); ++n2) {
            long l = this.zzA(this.zzj[n2]) & 0xFFFFF;
            Object object = zzkf.zzn(t, (long)l);
            if (object == null) continue;
            ((zziq)object).zzd();
            zzkf.zzo(t, (long)l, (Object)object);
        }
        int n3 = this.zzj.length;
        n2 = n;
        while (true) {
            if (n2 >= n3) {
                this.zzn.zze(t);
                if (!this.zzh) return;
                this.zzo.zzc(t);
                return;
            }
            this.zzm.zza(t, (long)this.zzj[n2]);
            ++n2;
        }
    }

    public final boolean zzj(T object) {
        int n = 1048575;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            block13: {
                zzjh zzjh2;
                List list;
                int n4;
                block14: {
                    block9: {
                        int n5;
                        int n6;
                        int n7;
                        block10: {
                            block11: {
                                int n8;
                                block12: {
                                    if (n3 >= this.zzk) break block9;
                                    n7 = this.zzj[n3];
                                    n8 = this.zzc[n7];
                                    n6 = this.zzA(n7);
                                    n5 = this.zzc[n7 + 2];
                                    n4 = n5 & 0xFFFFF;
                                    n5 = 1 << (n5 >>> 20);
                                    if (n4 != n) {
                                        if (n4 != 1048575) {
                                            n2 = zzb.getInt(object, (long)n4);
                                        }
                                        n = n4;
                                    }
                                    if ((0x10000000 & n6) != 0) {
                                        if (!this.zzJ(object, n7, n, n2, n5)) return false;
                                    }
                                    if ((n4 = zziz.zzC(n6)) == 9 || n4 == 17) break block10;
                                    if (n4 == 27) break block11;
                                    if (n4 == 60 || n4 == 68) break block12;
                                    if (n4 == 49) break block11;
                                    if (n4 == 50 && !((zziq)zzkf.zzn(object, (long)(n6 & 0xFFFFF))).isEmpty()) {
                                        object = (zzip)this.zzw(n7);
                                        throw null;
                                    }
                                    break block13;
                                }
                                if (this.zzM(object, n8, n7) && !zziz.zzz(object, n6, this.zzv(n7))) {
                                    return false;
                                }
                                break block13;
                            }
                            if ((list = (List)zzkf.zzn(object, (long)(n6 & 0xFFFFF))).isEmpty()) break block13;
                            zzjh2 = this.zzv(n7);
                            break block14;
                        }
                        if (this.zzJ(object, n7, n, n2, n5) && !zziz.zzz(object, n6, this.zzv(n7))) {
                            return false;
                        }
                        break block13;
                    }
                    if (!this.zzh) {
                        return true;
                    }
                    this.zzo.zzb(object);
                    throw null;
                }
                for (n4 = 0; n4 < list.size(); ++n4) {
                    if (zzjh2.zzj(list.get(n4))) continue;
                    return false;
                }
            }
            ++n3;
        }
    }

    public final void zzm(T t, zzgz zzgz2) throws IOException {
        if (!this.zzi) {
            this.zzR(t, zzgz2);
            return;
        }
        if (this.zzh) {
            this.zzo.zzb(t);
            throw null;
        }
        int n = this.zzc.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                zzjv<?, ?> zzjv2 = this.zzn;
                zzjv2.zzi(zzjv2.zzd(t), zzgz2);
                return;
            }
            int n3 = this.zzA(n2);
            int n4 = this.zzc[n2];
            switch (zziz.zzC(n3)) {
                default: {
                    break;
                }
                case 68: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzs(n4, zzkf.zzn(t, (long)(n3 & 0xFFFFF)), this.zzv(n2));
                    break;
                }
                case 67: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzq(n4, zziz.zzG(t, n3 & 0xFFFFF));
                    break;
                }
                case 66: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzp(n4, zziz.zzF(t, n3 & 0xFFFFF));
                    break;
                }
                case 65: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzd(n4, zziz.zzG(t, n3 & 0xFFFFF));
                    break;
                }
                case 64: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzb(n4, zziz.zzF(t, n3 & 0xFFFFF));
                    break;
                }
                case 63: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzg(n4, zziz.zzF(t, n3 & 0xFFFFF));
                    break;
                }
                case 62: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzo(n4, zziz.zzF(t, n3 & 0xFFFFF));
                    break;
                }
                case 61: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzn(n4, (zzgr)zzkf.zzn(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 60: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzr(n4, zzkf.zzn(t, (long)(n3 & 0xFFFFF)), this.zzv(n2));
                    break;
                }
                case 59: {
                    if (!this.zzM(t, n4, n2)) break;
                    zziz.zzT(n4, zzkf.zzn(t, (long)(n3 & 0xFFFFF)), zzgz2);
                    break;
                }
                case 58: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzl(n4, zziz.zzH(t, n3 & 0xFFFFF));
                    break;
                }
                case 57: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzk(n4, zziz.zzF(t, n3 & 0xFFFFF));
                    break;
                }
                case 56: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzj(n4, zziz.zzG(t, n3 & 0xFFFFF));
                    break;
                }
                case 55: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzi(n4, zziz.zzF(t, n3 & 0xFFFFF));
                    break;
                }
                case 54: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzh(n4, zziz.zzG(t, n3 & 0xFFFFF));
                    break;
                }
                case 53: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzc(n4, zziz.zzG(t, n3 & 0xFFFFF));
                    break;
                }
                case 52: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zze(n4, zziz.zzE(t, n3 & 0xFFFFF));
                    break;
                }
                case 51: {
                    if (!this.zzM(t, n4, n2)) break;
                    zzgz2.zzf(n4, zziz.zzD(t, n3 & 0xFFFFF));
                    break;
                }
                case 50: {
                    this.zzS(zzgz2, n4, zzkf.zzn(t, (long)(n3 & 0xFFFFF)), n2);
                    break;
                }
                case 49: {
                    zzjj.zzaa((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (zzjh)this.zzv(n2));
                    break;
                }
                case 48: {
                    zzjj.zzN((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)true);
                    break;
                }
                case 47: {
                    zzjj.zzS((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)true);
                    break;
                }
                case 46: {
                    zzjj.zzP((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)true);
                    break;
                }
                case 45: {
                    zzjj.zzU((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)true);
                    break;
                }
                case 44: {
                    zzjj.zzV((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)true);
                    break;
                }
                case 43: {
                    zzjj.zzR((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)true);
                    break;
                }
                case 42: {
                    zzjj.zzW((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)true);
                    break;
                }
                case 41: {
                    zzjj.zzT((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)true);
                    break;
                }
                case 40: {
                    zzjj.zzO((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)true);
                    break;
                }
                case 39: {
                    zzjj.zzQ((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)true);
                    break;
                }
                case 38: {
                    zzjj.zzM((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)true);
                    break;
                }
                case 37: {
                    zzjj.zzL((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)true);
                    break;
                }
                case 36: {
                    zzjj.zzK((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)true);
                    break;
                }
                case 35: {
                    zzjj.zzJ((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)true);
                    break;
                }
                case 34: {
                    zzjj.zzN((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)false);
                    break;
                }
                case 33: {
                    zzjj.zzS((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)false);
                    break;
                }
                case 32: {
                    zzjj.zzP((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)false);
                    break;
                }
                case 31: {
                    zzjj.zzU((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)false);
                    break;
                }
                case 30: {
                    zzjj.zzV((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)false);
                    break;
                }
                case 29: {
                    zzjj.zzR((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)false);
                    break;
                }
                case 28: {
                    zzjj.zzY((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2);
                    break;
                }
                case 27: {
                    zzjj.zzZ((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (zzjh)this.zzv(n2));
                    break;
                }
                case 26: {
                    zzjj.zzX((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2);
                    break;
                }
                case 25: {
                    zzjj.zzW((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)false);
                    break;
                }
                case 24: {
                    zzjj.zzT((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)false);
                    break;
                }
                case 23: {
                    zzjj.zzO((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)false);
                    break;
                }
                case 22: {
                    zzjj.zzQ((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)false);
                    break;
                }
                case 21: {
                    zzjj.zzM((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)false);
                    break;
                }
                case 20: {
                    zzjj.zzL((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)false);
                    break;
                }
                case 19: {
                    zzjj.zzK((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)false);
                    break;
                }
                case 18: {
                    zzjj.zzJ((int)this.zzc[n2], (List)((List)zzkf.zzn(t, (long)(n3 & 0xFFFFF))), (zzgz)zzgz2, (boolean)false);
                    break;
                }
                case 17: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzs(n4, zzkf.zzn(t, (long)(n3 & 0xFFFFF)), this.zzv(n2));
                    break;
                }
                case 16: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzq(n4, zzkf.zzf(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 15: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzp(n4, zzkf.zzd(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 14: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzd(n4, zzkf.zzf(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 13: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzb(n4, zzkf.zzd(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 12: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzg(n4, zzkf.zzd(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 11: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzo(n4, zzkf.zzd(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 10: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzn(n4, (zzgr)zzkf.zzn(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 9: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzr(n4, zzkf.zzn(t, (long)(n3 & 0xFFFFF)), this.zzv(n2));
                    break;
                }
                case 8: {
                    if (!this.zzK(t, n2)) break;
                    zziz.zzT(n4, zzkf.zzn(t, (long)(n3 & 0xFFFFF)), zzgz2);
                    break;
                }
                case 7: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzl(n4, zzkf.zzh(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 6: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzk(n4, zzkf.zzd(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 5: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzj(n4, zzkf.zzf(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 4: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzi(n4, zzkf.zzd(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 3: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzh(n4, zzkf.zzf(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 2: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzc(n4, zzkf.zzf(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 1: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zze(n4, zzkf.zzj(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 0: {
                    if (!this.zzK(t, n2)) break;
                    zzgz2.zzf(n4, zzkf.zzl(t, (long)(n3 & 0xFFFFF)));
                }
            }
            n2 += 3;
        }
    }
}
