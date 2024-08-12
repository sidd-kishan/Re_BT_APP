/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgej
 *  com.google.android.gms.internal.ads.zzgek
 *  com.google.android.gms.internal.ads.zzgel
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfc
 *  com.google.android.gms.internal.ads.zzgfh
 *  com.google.android.gms.internal.ads.zzgfi
 *  com.google.android.gms.internal.ads.zzgfj
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgfn
 *  com.google.android.gms.internal.ads.zzgfs
 *  com.google.android.gms.internal.ads.zzgft
 *  com.google.android.gms.internal.ads.zzgfx
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggb
 *  com.google.android.gms.internal.ads.zzgge
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzggw
 *  com.google.android.gms.internal.ads.zzggx
 *  com.google.android.gms.internal.ads.zzghb
 *  com.google.android.gms.internal.ads.zzghc
 *  com.google.android.gms.internal.ads.zzghd
 *  com.google.android.gms.internal.ads.zzghf
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghn
 *  com.google.android.gms.internal.ads.zzghq
 *  com.google.android.gms.internal.ads.zzghs
 *  com.google.android.gms.internal.ads.zzght
 *  com.google.android.gms.internal.ads.zzghz
 *  com.google.android.gms.internal.ads.zzgib
 *  com.google.android.gms.internal.ads.zzgil
 *  com.google.android.gms.internal.ads.zzgio
 *  com.google.android.gms.internal.ads.zzgip
 *  com.google.android.gms.internal.ads.zzgiy
 *  com.google.android.gms.internal.ads.zzgjd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgej;
import com.google.android.gms.internal.ads.zzgek;
import com.google.android.gms.internal.ads.zzgel;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfc;
import com.google.android.gms.internal.ads.zzgfh;
import com.google.android.gms.internal.ads.zzgfi;
import com.google.android.gms.internal.ads.zzgfj;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgfn;
import com.google.android.gms.internal.ads.zzgfs;
import com.google.android.gms.internal.ads.zzgft;
import com.google.android.gms.internal.ads.zzgfx;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggb;
import com.google.android.gms.internal.ads.zzgge;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzggw;
import com.google.android.gms.internal.ads.zzggx;
import com.google.android.gms.internal.ads.zzghb;
import com.google.android.gms.internal.ads.zzghc;
import com.google.android.gms.internal.ads.zzghd;
import com.google.android.gms.internal.ads.zzghf;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghn;
import com.google.android.gms.internal.ads.zzghq;
import com.google.android.gms.internal.ads.zzghs;
import com.google.android.gms.internal.ads.zzght;
import com.google.android.gms.internal.ads.zzghz;
import com.google.android.gms.internal.ads.zzgib;
import com.google.android.gms.internal.ads.zzgil;
import com.google.android.gms.internal.ads.zzgio;
import com.google.android.gms.internal.ads.zzgip;
import com.google.android.gms.internal.ads.zzgiy;
import com.google.android.gms.internal.ads.zzgjd;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class zzghl<T>
implements zzghz<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgiy.zzt();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzghi zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzggw zzn;
    private final zzgio<?, ?> zzo;
    private final zzgfn<?> zzp;
    private final zzghn zzq;
    private final zzghd zzr;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private zzghl(int[] nArray, Object[] objectArray, int n, int n2, zzghi zzghi2, boolean bl, boolean bl2, int[] nArray2, int n3, int n4, zzghn zzghn2, zzggw zzggw2, zzgio zzgio2, zzgfn zzgfn2, zzghd zzghd2, byte[] byArray) {
        this.zzc = nArray;
        this.zzd = objectArray;
        this.zze = n;
        this.zzf = n2;
        this.zzi = zzghi2 instanceof zzgga;
        this.zzj = bl;
        bl = bl2 = false;
        if (zzgfn2 != null) {
            bl = bl2;
            if (zzgfn2.zza(zzghi2)) {
                bl = true;
            }
        }
        this.zzh = bl;
        this.zzk = nArray2;
        this.zzl = n3;
        this.zzm = n4;
        this.zzq = zzghn2;
        this.zzn = zzggw2;
        this.zzo = zzgio2;
        this.zzp = zzgfn2;
        this.zzg = zzghi2;
        this.zzr = zzghd2;
    }

    private final <UT, UB> UB zzA(Object object, int n, UB UB, zzgio<UT, UB> zzgio2) {
        int n2 = this.zzc[n];
        if ((object = zzgiy.zzn((Object)object, (long)(this.zzD(n) & 0xFFFFF))) == null) {
            return UB;
        }
        if (this.zzy(n) == null) {
            return UB;
        }
        object = (zzghc)object;
        object = (zzghb)this.zzx(n);
        throw null;
    }

    private static boolean zzB(Object object, int n, zzghz zzghz2) {
        return zzghz2.zzk(zzgiy.zzn((Object)object, (long)(n & 0xFFFFF)));
    }

    private final void zzC(Object object, int n, zzght zzght2) throws IOException {
        if (zzghl.zzG(n)) {
            zzgiy.zzo((Object)object, (long)(n & 0xFFFFF), (Object)zzght2.zzn());
            return;
        }
        if (this.zzi) {
            zzgiy.zzo((Object)object, (long)(n & 0xFFFFF), (Object)zzght2.zzm());
            return;
        }
        zzgiy.zzo((Object)object, (long)(n & 0xFFFFF), (Object)zzght2.zzq());
    }

    private final int zzD(int n) {
        return this.zzc[n + 1];
    }

    private final int zzE(int n) {
        return this.zzc[n + 2];
    }

    private static int zzF(int n) {
        return n >>> 20 & 0xFF;
    }

    private static boolean zzG(int n) {
        if ((n & 0x20000000) == 0) return false;
        return true;
    }

    private static <T> double zzH(T t, long l) {
        return (Double)zzgiy.zzn(t, (long)l);
    }

    private static <T> float zzI(T t, long l) {
        return ((Float)zzgiy.zzn(t, (long)l)).floatValue();
    }

    private static <T> int zzJ(T t, long l) {
        return (Integer)zzgiy.zzn(t, (long)l);
    }

    private static <T> long zzK(T t, long l) {
        return (Long)zzgiy.zzn(t, (long)l);
    }

    private static <T> boolean zzL(T t, long l) {
        return (Boolean)zzgiy.zzn(t, (long)l);
    }

    private final boolean zzM(T t, T t2, int n) {
        if (this.zzO(t, n) != this.zzO(t2, n)) return false;
        return true;
    }

    private final boolean zzN(T t, int n, int n2, int n3, int n4) {
        if (n2 == 1048575) {
            return this.zzO(t, n);
        }
        if ((n3 & n4) == 0) return false;
        return true;
    }

    private final boolean zzO(T object, int n) {
        int n2 = this.zzE(n);
        long l = n2 & 0xFFFFF;
        if (l != 1048575L) {
            if ((zzgiy.zzd(object, (long)l) & 1 << (n2 >>> 20)) == 0) return false;
            return true;
        }
        n = this.zzD(n);
        l = n & 0xFFFFF;
        switch (zzghl.zzF(n)) {
            default: {
                throw new IllegalArgumentException();
            }
            case 17: {
                if (zzgiy.zzn(object, (long)l) == null) return false;
                return true;
            }
            case 16: {
                if (zzgiy.zzf(object, (long)l) == 0L) return false;
                return true;
            }
            case 15: {
                if (zzgiy.zzd(object, (long)l) == 0) return false;
                return true;
            }
            case 14: {
                if (zzgiy.zzf(object, (long)l) == 0L) return false;
                return true;
            }
            case 13: {
                if (zzgiy.zzd(object, (long)l) == 0) return false;
                return true;
            }
            case 12: {
                if (zzgiy.zzd(object, (long)l) == 0) return false;
                return true;
            }
            case 11: {
                if (zzgiy.zzd(object, (long)l) == 0) return false;
                return true;
            }
            case 10: {
                if (zzgex.zzb.equals(zzgiy.zzn(object, (long)l))) return false;
                return true;
            }
            case 9: {
                if (zzgiy.zzn(object, (long)l) == null) return false;
                return true;
            }
            case 8: {
                object = zzgiy.zzn(object, (long)l);
                if (object instanceof String) {
                    if (((String)object).isEmpty()) return false;
                    return true;
                }
                if (!(object instanceof zzgex)) throw new IllegalArgumentException();
                if (zzgex.zzb.equals(object)) return false;
                return true;
            }
            case 7: {
                return zzgiy.zzh(object, (long)l);
            }
            case 6: {
                if (zzgiy.zzd(object, (long)l) == 0) return false;
                return true;
            }
            case 5: {
                if (zzgiy.zzf(object, (long)l) == 0L) return false;
                return true;
            }
            case 4: {
                if (zzgiy.zzd(object, (long)l) == 0) return false;
                return true;
            }
            case 3: {
                if (zzgiy.zzf(object, (long)l) == 0L) return false;
                return true;
            }
            case 2: {
                if (zzgiy.zzf(object, (long)l) == 0L) return false;
                return true;
            }
            case 1: {
                if (zzgiy.zzj(object, (long)l) == 0.0f) return false;
                return true;
            }
            case 0: 
        }
        if (zzgiy.zzl(object, (long)l) == 0.0) return false;
        return true;
    }

    private final void zzP(T t, int n) {
        long l = 0xFFFFF & (n = this.zzE(n));
        if (l == 1048575L) {
            return;
        }
        zzgiy.zze(t, (long)l, (int)(1 << (n >>> 20) | zzgiy.zzd(t, (long)l)));
    }

    private final boolean zzQ(T t, int n, int n2) {
        if (zzgiy.zzd(t, (long)(this.zzE(n2) & 0xFFFFF)) != n) return false;
        return true;
    }

    private final void zzR(T t, int n, int n2) {
        zzgiy.zze(t, (long)(this.zzE(n2) & 0xFFFFF), (int)n);
    }

    private final int zzS(int n) {
        if (n < this.zze) return -1;
        if (n > this.zzf) return -1;
        return this.zzU(n, 0);
    }

    private final int zzT(int n, int n2) {
        if (n < this.zze) return -1;
        if (n > this.zzf) return -1;
        return this.zzU(n, n2);
    }

    private final int zzU(int n, int n2) {
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
    private final void zzV(T var1_1, zzgfi var2_2) throws IOException {
        if (this.zzh) {
            this.zzp.zzb(var1_1);
            throw null;
        }
        var8_3 = this.zzc.length;
        var15_4 = zzghl.zzb;
        var6_5 = 0;
        var4_6 = 0;
        var3_7 = 1048575;
        while (true) {
            block95: {
                if (var6_5 >= var8_3) {
                    var15_4 = this.zzo;
                    var15_4.zzr(var15_4.zzj(var1_1), var2_2);
                    return;
                }
                var9_10 = this.zzD(var6_5);
                var10_11 = this.zzc[var6_5];
                var11_12 = zzghl.zzF(var9_10);
                if (var11_12 <= 17) {
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
                var13_14 = var9_10 & 1048575;
                switch (var11_12) {
                    case 68: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzs(var10_11, var15_4.getObject(var1_1, var13_14), this.zzw(var6_5));
                        break block95;
                    }
                    case 67: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzq(var10_11, zzghl.zzK(var1_1, var13_14));
                        break block95;
                    }
                    case 66: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzp(var10_11, zzghl.zzJ(var1_1, var13_14));
                        break block95;
                    }
                    case 65: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzd(var10_11, zzghl.zzK(var1_1, var13_14));
                        break block95;
                    }
                    case 64: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzb(var10_11, zzghl.zzJ(var1_1, var13_14));
                        break block95;
                    }
                    case 63: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzg(var10_11, zzghl.zzJ(var1_1, var13_14));
                        break block95;
                    }
                    case 62: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzo(var10_11, zzghl.zzJ(var1_1, var13_14));
                        break block95;
                    }
                    case 61: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzn(var10_11, (zzgex)var15_4.getObject(var1_1, var13_14));
                        break block95;
                    }
                    case 60: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzr(var10_11, var15_4.getObject(var1_1, var13_14), this.zzw(var6_5));
                        break block95;
                    }
                    case 59: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        zzghl.zzX(var10_11, var15_4.getObject(var1_1, var13_14), var2_2);
                        break block95;
                    }
                    case 58: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzl(var10_11, zzghl.zzL(var1_1, var13_14));
                        break block95;
                    }
                    case 57: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzk(var10_11, zzghl.zzJ(var1_1, var13_14));
                        break block95;
                    }
                    case 56: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzj(var10_11, zzghl.zzK(var1_1, var13_14));
                        break block95;
                    }
                    case 55: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzi(var10_11, zzghl.zzJ(var1_1, var13_14));
                        break block95;
                    }
                    case 54: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzh(var10_11, zzghl.zzK(var1_1, var13_14));
                        break block95;
                    }
                    case 53: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzc(var10_11, zzghl.zzK(var1_1, var13_14));
                        break block95;
                    }
                    case 52: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zze(var10_11, zzghl.zzI(var1_1, var13_14));
                        break block95;
                    }
                    case 51: {
                        if (!this.zzQ(var1_1, var10_11, var6_5)) ** GOTO lbl105
                        var2_2.zzf(var10_11, zzghl.zzH(var1_1, var13_14));
                        break block95;
                    }
lbl105:
                    // 19 sources

                    default: {
                        break block95;
                    }
                    case 50: {
                        this.zzW(var2_2, var10_11, var15_4.getObject(var1_1, var13_14), var6_5);
                        break block95;
                    }
                    case 49: {
                        zzgib.zzaa((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (zzghz)this.zzw(var6_5));
                        break block95;
                    }
                    case 48: {
                        zzgib.zzN((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)true);
                        break block95;
                    }
                    case 47: {
                        zzgib.zzS((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)true);
                        break block95;
                    }
                    case 46: {
                        zzgib.zzP((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)true);
                        break block95;
                    }
                    case 45: {
                        zzgib.zzU((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)true);
                        break block95;
                    }
                    case 44: {
                        zzgib.zzV((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)true);
                        break block95;
                    }
                    case 43: {
                        zzgib.zzR((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)true);
                        break block95;
                    }
                    case 42: {
                        zzgib.zzW((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)true);
                        break block95;
                    }
                    case 41: {
                        zzgib.zzT((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)true);
                        break block95;
                    }
                    case 40: {
                        zzgib.zzO((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)true);
                        break block95;
                    }
                    case 39: {
                        zzgib.zzQ((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)true);
                        break block95;
                    }
                    case 38: {
                        zzgib.zzM((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)true);
                        break block95;
                    }
                    case 37: {
                        zzgib.zzL((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)true);
                        break block95;
                    }
                    case 36: {
                        zzgib.zzK((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)true);
                        break block95;
                    }
                    case 35: {
                        zzgib.zzJ((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)true);
                        break block95;
                    }
                    case 34: {
                        zzgib.zzN((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)false);
                        break block95;
                    }
                    case 33: {
                        zzgib.zzS((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)false);
                        break block95;
                    }
                    case 32: {
                        zzgib.zzP((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)false);
                        break block95;
                    }
                    case 31: {
                        zzgib.zzU((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)false);
                        break block95;
                    }
                    case 30: {
                        zzgib.zzV((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)false);
                        break block95;
                    }
                    case 29: {
                        zzgib.zzR((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)false);
                        break block95;
                    }
                    case 28: {
                        zzgib.zzY((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2);
                        break block95;
                    }
                    case 27: {
                        zzgib.zzZ((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (zzghz)this.zzw(var6_5));
                        break block95;
                    }
                    case 26: {
                        zzgib.zzX((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2);
                        break block95;
                    }
                    case 25: {
                        zzgib.zzW((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)false);
                        break block95;
                    }
                    case 24: {
                        zzgib.zzT((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)false);
                        break block95;
                    }
                    case 23: {
                        zzgib.zzO((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)false);
                        break block95;
                    }
                    case 22: {
                        zzgib.zzQ((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)false);
                        break block95;
                    }
                    case 21: {
                        zzgib.zzM((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)false);
                        break block95;
                    }
                    case 20: {
                        zzgib.zzL((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)false);
                        break block95;
                    }
                    case 19: {
                        zzgib.zzK((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)false);
                        break block95;
                    }
                    case 18: {
                        zzgib.zzJ((int)this.zzc[var6_5], (List)((List)var15_4.getObject(var1_1, var13_14)), (zzgfi)var2_2, (boolean)false);
                        break block95;
                    }
                    case 17: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzs(var10_11, var15_4.getObject(var1_1, var13_14), this.zzw(var6_5));
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
                            var2_2.zzn(var10_11, (zzgex)var15_4.getObject(var1_1, var13_14));
                        }
                        break block95;
                    }
                    case 9: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzr(var10_11, var15_4.getObject(var1_1, var13_14), this.zzw(var6_5));
                        }
                        break block95;
                    }
                    case 8: {
                        if ((var5_8 & var7_9) != 0) {
                            zzghl.zzX(var10_11, var15_4.getObject(var1_1, var13_14), var2_2);
                        }
                        break block95;
                    }
                    case 7: {
                        if ((var5_8 & var7_9) != 0) {
                            var2_2.zzl(var10_11, zzgiy.zzh(var1_1, (long)var13_14));
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
                            var2_2.zze(var10_11, zzgiy.zzj(var1_1, (long)var13_14));
                        }
                        break block95;
                    }
                    case 0: 
                }
                if ((var5_8 & var7_9) != 0) {
                    var2_2.zzf(var10_11, zzgiy.zzl(var1_1, (long)var13_14));
                }
            }
            var6_5 += 3;
            var4_6 = var5_8;
        }
    }

    private final <K, V> void zzW(zzgfi zzgfi2, int n, Object object, int n2) throws IOException {
        if (object == null) {
            return;
        }
        zzgfi2 = (zzghb)this.zzx(n2);
        throw null;
    }

    private static final void zzX(int n, Object object, zzgfi zzgfi2) throws IOException {
        if (object instanceof String) {
            zzgfi2.zzm(n, (String)object);
            return;
        }
        zzgfi2.zzn(n, (zzgex)object);
    }

    static zzgip zzg(Object object) {
        zzgga zzgga2 = (zzgga)object;
        zzgip zzgip2 = zzgga2.zzc;
        object = zzgip2;
        if (zzgip2 != zzgip.zza()) return object;
        object = zzgip.zzb();
        zzgga2.zzc = object;
        return object;
    }

    static <T> zzghl<T> zzl(Class<T> zzgil2, zzghf zzghf2, zzghn zzghn2, zzggw zzggw2, zzgio<?, ?> zzgio2, zzgfn<?> zzgfn2, zzghd zzghd2) {
        if (zzghf2 instanceof zzghs) {
            return zzghl.zzm((zzghs)zzghf2, zzghn2, zzggw2, zzgio2, zzgfn2, zzghd2);
        }
        zzgil2 = (zzgil)zzghf2;
        throw null;
    }

    static <T> zzghl<T> zzm(zzghs zzghs2, zzghn zzghn2, zzggw zzggw2, zzgio<?, ?> zzgio2, zzgfn<?> zzgfn2, zzghd zzghd2) {
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
        boolean bl = zzghs2.zzc() == 2;
        String string = zzghs2.zzd();
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
            n12 = n8 + 1;
            n8 = n3 = (int)string.charAt(n8);
            n6 = n12;
            if (n3 >= 55296) {
                n3 &= 0x1FFF;
                n8 = 13;
                n6 = n12;
                while (true) {
                    n12 = n6 + 1;
                    if ((n6 = (int)string.charAt(n6)) < 55296) break;
                    n3 |= (n6 & 0x1FFF) << n8;
                    n8 += 13;
                    n6 = n12;
                }
                n8 = n3 | n6 << n8;
                n6 = n12;
            }
            n3 = n6 + 1;
            n12 = n6 = (int)string.charAt(n6);
            n4 = n3;
            if (n6 >= 55296) {
                n6 &= 0x1FFF;
                n12 = 13;
                n4 = n3;
                while (true) {
                    n3 = n4 + 1;
                    if ((n4 = (int)string.charAt(n4)) < 55296) break;
                    n6 |= (n4 & 0x1FFF) << n12;
                    n12 += 13;
                    n4 = n3;
                }
                n12 = n6 | n4 << n12;
                n4 = n3;
            }
            n6 = n4 + 1;
            n3 = n4 = (int)string.charAt(n4);
            n7 = n6;
            if (n4 >= 55296) {
                n4 &= 0x1FFF;
                n3 = 13;
                n7 = n6;
                while (true) {
                    n6 = n7 + 1;
                    if ((n7 = (int)string.charAt(n7)) < 55296) break;
                    n4 |= (n7 & 0x1FFF) << n3;
                    n3 += 13;
                    n7 = n6;
                }
                n3 = n4 | n7 << n3;
                n7 = n6;
            }
            n4 = n7 + 1;
            n7 = n2 = (int)string.charAt(n7);
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
                n6 = n & 0x1FFF;
                n4 = 13;
                n = n2;
                n2 = n6;
                while (true) {
                    n6 = n + 1;
                    if ((n = (int)string.charAt(n)) < 55296) break;
                    n2 |= (n & 0x1FFF) << n4;
                    n4 += 13;
                    n = n6;
                }
                n2 |= n << n4;
                n4 = n6;
                n6 = n2;
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
        Object[] objectArray = zzghs2.zze();
        Class<?> clazz = zzghs2.zzb().getClass();
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
                                                                n4 = 13;
                                                                while (true) {
                                                                    n6 = n20 + 1;
                                                                    if ((n20 = (int)string.charAt(n20)) < 55296) break;
                                                                    n11 |= (n20 & 0x1FFF) << n4;
                                                                    n4 += 13;
                                                                    n20 = n6;
                                                                }
                                                                n11 |= n20 << n4;
                                                                n4 = n6;
                                                            } else {
                                                                n4 = n20;
                                                            }
                                                            n6 = n4 + 1;
                                                            n19 = string.charAt(n4);
                                                            if (n19 >= 55296) {
                                                                n4 = n19 & 0x1FFF;
                                                                n19 = n6;
                                                                n6 = 13;
                                                                while (true) {
                                                                    n20 = n19 + 1;
                                                                    if ((n19 = (int)string.charAt(n19)) < 55296) break;
                                                                    n4 |= (n19 & 0x1FFF) << n6;
                                                                    n6 += 13;
                                                                    n19 = n20;
                                                                }
                                                                n19 = n4 | n19 << n6;
                                                                n6 = n20;
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
                                                    objectArray[n3] = object = zzghl.zzo(clazz, (String)object);
                                                }
                                                n16 = (int)unsafe.objectFieldOffset((Field)object);
                                                object = objectArray[++n3];
                                                if (object instanceof Field) {
                                                    object = (Field)object;
                                                } else {
                                                    objectArray[n3] = object = zzghl.zzo(clazz, (String)object);
                                                }
                                                n15 = (int)unsafe.objectFieldOffset((Field)object);
                                                n5 = 0;
                                                n3 = n6;
                                                n17 = n12;
                                                n12 = n4;
                                                break block50;
                                            }
                                            n17 = n8;
                                            n4 = n3 + 1;
                                            object = zzghl.zzo(clazz, (String)objectArray[n3]);
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
                        objectArray[n4] = object = zzghl.zzo(clazz, (String)object);
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
                n5 = n4;
                n15 = n6;
            }
            int n21 = n14 + 1;
            nArray2[n14] = n11;
            n11 = n21 + 1;
            n6 = (n19 & 0x200) != 0 ? 0x20000000 : 0;
            n4 = (n19 & 0x100) != 0 ? 0x10000000 : 0;
            nArray2[n21] = n4 | n6 | n18 << 20 | n16;
            n14 = n11 + 1;
            nArray2[n11] = n5 << 20 | n15;
            n6 = n12;
            n5 = n20;
            n12 = n17;
        }
        return new zzghl<T>(nArray2, objectArray2, n, n8, zzghs2.zzb(), bl, false, nArray, n2, n13, zzghn2, zzggw2, zzgio2, zzgfn2, zzghd2, null);
    }

    private static Field zzo(Class<?> object, String string) {
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

    private final void zzp(T t, T object, int n) {
        long l = this.zzD(n) & 0xFFFFF;
        if (!this.zzO(object, n)) {
            return;
        }
        Object object2 = zzgiy.zzn(t, (long)l);
        object = zzgiy.zzn(object, (long)l);
        if (object2 != null && object != null) {
            zzgiy.zzo(t, (long)l, (Object)zzggk.zzi((Object)object2, object));
            this.zzP(t, n);
            return;
        }
        if (object == null) return;
        zzgiy.zzo(t, (long)l, object);
        this.zzP(t, n);
    }

    private final void zzq(T t, T object, int n) {
        int n2 = this.zzD(n);
        int n3 = this.zzc[n];
        long l = n2 & 0xFFFFF;
        if (!this.zzQ(object, n3, n)) {
            return;
        }
        Object object2 = this.zzQ(t, n3, n) ? zzgiy.zzn(t, (long)l) : null;
        object = zzgiy.zzn(object, (long)l);
        if (object2 != null && object != null) {
            zzgiy.zzo(t, (long)l, (Object)zzggk.zzi((Object)object2, object));
            this.zzR(t, n3, n);
            return;
        }
        if (object == null) return;
        zzgiy.zzo(t, (long)l, object);
        this.zzR(t, n3, n);
    }

    /*
     * Unable to fully structure code
     */
    private final int zzr(T var1_1) {
        var15_2 = zzghl.zzb;
        var5_4 = 0;
        var7_5 = 0;
        var2_6 = 1048575;
        for (var6_3 = 0; var6_3 < this.zzc.length; var6_3 += 3) {
            block83: {
                block84: {
                    block85: {
                        var12_13 = this.zzD(var6_3);
                        var10_11 = this.zzc[var6_3];
                        var11_12 = zzghl.zzF(var12_13);
                        if (var11_12 <= 17) {
                            var3_7 = this.zzc[var6_3 + 2];
                            var9_10 = var3_7 & 1048575;
                            var4_8 = 1 << (var3_7 >>> 20);
                            var8_9 = var2_6;
                            var3_7 = var4_8;
                            if (var9_10 != var2_6) {
                                var7_5 = var15_2.getInt(var1_1, (long)var9_10);
                                var8_9 = var9_10;
                                var3_7 = var4_8;
                            }
                        } else {
                            var3_7 = 0;
                            var8_9 = var2_6;
                        }
                        var13_14 = var12_13 & 1048575;
                        switch (var11_12) {
                            default: {
                                var2_6 = var5_4;
                                break block83;
                            }
                            case 68: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var2_6 = zzgfh.zzF((int)var10_11, (zzghi)((zzghi)var15_2.getObject(var1_1, var13_14)), (zzghz)this.zzw(var6_3));
                                break block84;
                            }
                            case 67: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var13_14 = zzghl.zzK(var1_1, var13_14);
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = zzgfh.zzy((long)(var13_14 >> 63 ^ var13_14 + var13_14));
                                ** GOTO lbl421
                            }
                            case 66: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var2_6 = zzghl.zzJ(var1_1, var13_14);
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = zzgfh.zzx((int)(var2_6 >> 31 ^ var2_6 + var2_6));
                                ** GOTO lbl421
                            }
                            case 65: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                break block85;
                            }
                            case 64: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                ** GOTO lbl444
                            }
                            case 63: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var2_6 = zzghl.zzJ(var1_1, var13_14);
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = zzgfh.zzw((int)var2_6);
                                ** GOTO lbl421
                            }
                            case 62: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var2_6 = zzghl.zzJ(var1_1, var13_14);
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = zzgfh.zzx((int)var2_6);
                                ** GOTO lbl421
                            }
                            case 61: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var16_15 = (zzgex)var15_2.getObject(var1_1, var13_14);
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = var16_15.zzc();
                                var4_8 = zzgfh.zzx((int)var2_6);
                                ** GOTO lbl393
                            }
                            case 60: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var2_6 = zzgib.zzw((int)var10_11, (Object)var15_2.getObject(var1_1, var13_14), (zzghz)this.zzw(var6_3));
                                break block84;
                            }
                            case 59: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var16_15 = var15_2.getObject(var1_1, var13_14);
                                if (!(var16_15 instanceof zzgex)) ** GOTO lbl93
                                var16_15 = (zzgex)var16_15;
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = var16_15.zzc();
                                var4_8 = zzgfh.zzx((int)var2_6);
                                ** GOTO lbl393
lbl93:
                                // 1 sources

                                var16_15 = (String)var16_15;
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = zzgfh.zzz((String)var16_15);
                                ** GOTO lbl421
                            }
                            case 58: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                ** GOTO lbl403
                            }
                            case 57: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                ** GOTO lbl444
                            }
                            case 56: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                break block85;
                            }
                            case 55: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var2_6 = zzghl.zzJ(var1_1, var13_14);
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = zzgfh.zzw((int)var2_6);
                                ** GOTO lbl421
                            }
                            case 54: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var13_14 = zzghl.zzK(var1_1, var13_14);
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                var3_7 = zzgfh.zzy((long)var13_14);
                                ** GOTO lbl438
                            }
                            case 53: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var13_14 = zzghl.zzK(var1_1, var13_14);
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                var3_7 = zzgfh.zzy((long)var13_14);
                                ** GOTO lbl438
                            }
                            case 52: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                ** GOTO lbl444
                            }
                            case 51: {
                                var2_6 = var5_4;
                                if (!this.zzQ(var1_1, var10_11, var6_3)) break block83;
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                break block85;
                            }
                            case 50: {
                                zzghd.zza((int)var10_11, (Object)var15_2.getObject(var1_1, var13_14), (Object)this.zzx(var6_3));
                                var2_6 = var5_4;
                                break block83;
                            }
                            case 49: {
                                var2_6 = zzgib.zzz((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (zzghz)this.zzw(var6_3));
                                break block84;
                            }
                            case 48: {
                                var3_7 = zzgib.zzf((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var5_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgfh.zzv((int)var10_11);
                                var4_8 = zzgfh.zzx((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 47: {
                                var3_7 = zzgib.zzn((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var5_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgfh.zzv((int)var10_11);
                                var4_8 = zzgfh.zzx((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 46: {
                                var3_7 = zzgib.zzr((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var5_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgfh.zzv((int)var10_11);
                                var4_8 = zzgfh.zzx((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 45: {
                                var3_7 = zzgib.zzp((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var5_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgfh.zzv((int)var10_11);
                                var4_8 = zzgfh.zzx((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 44: {
                                var3_7 = zzgib.zzh((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var5_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgfh.zzv((int)var10_11);
                                var4_8 = zzgfh.zzx((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 43: {
                                var3_7 = zzgib.zzl((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var5_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgfh.zzv((int)var10_11);
                                var4_8 = zzgfh.zzx((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 42: {
                                var3_7 = zzgib.zzt((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var5_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgfh.zzv((int)var10_11);
                                var4_8 = zzgfh.zzx((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 41: {
                                var3_7 = zzgib.zzp((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var5_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgfh.zzv((int)var10_11);
                                var4_8 = zzgfh.zzx((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 40: {
                                var3_7 = zzgib.zzr((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var5_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgfh.zzv((int)var10_11);
                                var4_8 = zzgfh.zzx((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 39: {
                                var3_7 = zzgib.zzj((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var5_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgfh.zzv((int)var10_11);
                                var4_8 = zzgfh.zzx((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 38: {
                                var3_7 = zzgib.zzd((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var5_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgfh.zzv((int)var10_11);
                                var4_8 = zzgfh.zzx((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 37: {
                                var3_7 = zzgib.zzb((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var5_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgfh.zzv((int)var10_11);
                                var4_8 = zzgfh.zzx((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 36: {
                                var3_7 = zzgib.zzp((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var5_4;
                                if (var3_7 <= 0) break block83;
                                var9_10 = zzgfh.zzv((int)var10_11);
                                var4_8 = zzgfh.zzx((int)var3_7);
                                var2_6 = var3_7;
                                var3_7 = var9_10;
                                ** GOTO lbl275
                            }
                            case 35: {
                                var9_10 = zzgib.zzr((List)((List)var15_2.getObject(var1_1, var13_14)));
                                var2_6 = var5_4;
                                if (var9_10 <= 0) break block83;
                                var3_7 = zzgfh.zzv((int)var10_11);
                                var4_8 = zzgfh.zzx((int)var9_10);
                                var2_6 = var9_10;
lbl275:
                                // 14 sources

                                var3_7 += var4_8;
                                ** GOTO lbl421
                            }
                            case 34: {
                                var2_6 = zzgib.zzg((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 33: {
                                var2_6 = zzgib.zzo((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 32: {
                                var2_6 = zzgib.zzs((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 31: {
                                var2_6 = zzgib.zzq((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 30: {
                                var2_6 = zzgib.zzi((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 29: {
                                var2_6 = zzgib.zzm((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 28: {
                                var2_6 = zzgib.zzy((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)));
                                break block84;
                            }
                            case 27: {
                                var2_6 = zzgib.zzx((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (zzghz)this.zzw(var6_3));
                                break block84;
                            }
                            case 26: {
                                var2_6 = zzgib.zzv((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)));
                                break block84;
                            }
                            case 25: {
                                var2_6 = zzgib.zzu((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 24: {
                                var2_6 = zzgib.zzq((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 23: {
                                var2_6 = zzgib.zzs((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 22: {
                                var2_6 = zzgib.zzk((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 21: {
                                var2_6 = zzgib.zze((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 20: {
                                var2_6 = zzgib.zzc((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 19: {
                                var2_6 = zzgib.zzq((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 18: {
                                var2_6 = zzgib.zzs((int)var10_11, (List)((List)var15_2.getObject(var1_1, var13_14)), (boolean)false);
                                break block84;
                            }
                            case 17: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgfh.zzF((int)var10_11, (zzghi)((zzghi)var15_2.getObject(var1_1, var13_14)), (zzghz)this.zzw(var6_3));
                                break block84;
                            }
                            case 16: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var13_14 = var15_2.getLong(var1_1, var13_14);
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = zzgfh.zzy((long)(var13_14 >> 63 ^ var13_14 + var13_14));
                                ** GOTO lbl421
                            }
                            case 15: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = var15_2.getInt(var1_1, var13_14);
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = zzgfh.zzx((int)(var2_6 >> 31 ^ var2_6 + var2_6));
                                ** GOTO lbl421
                            }
                            case 14: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                break block85;
                            }
                            case 13: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                ** GOTO lbl444
                            }
                            case 12: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = var15_2.getInt(var1_1, var13_14);
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = zzgfh.zzw((int)var2_6);
                                ** GOTO lbl421
                            }
                            case 11: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = var15_2.getInt(var1_1, var13_14);
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = zzgfh.zzx((int)var2_6);
                                ** GOTO lbl421
                            }
                            case 10: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var16_15 = (zzgex)var15_2.getObject(var1_1, var13_14);
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = var16_15.zzc();
                                var4_8 = zzgfh.zzx((int)var2_6);
                                ** GOTO lbl393
                            }
                            case 9: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgib.zzw((int)var10_11, (Object)var15_2.getObject(var1_1, var13_14), (zzghz)this.zzw(var6_3));
                                break block84;
                            }
                            case 8: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var16_15 = var15_2.getObject(var1_1, var13_14);
                                if (!(var16_15 instanceof zzgex)) ** GOTO lbl395
                                var16_15 = (zzgex)var16_15;
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = var16_15.zzc();
                                var4_8 = zzgfh.zzx((int)var2_6);
lbl393:
                                // 4 sources

                                var2_6 = var3_7 + (var4_8 + var2_6);
                                ** GOTO lbl422
lbl395:
                                // 1 sources

                                var16_15 = (String)var16_15;
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = zzgfh.zzz((String)var16_15);
                                ** GOTO lbl421
                            }
                            case 7: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
lbl403:
                                // 2 sources

                                ++var2_6;
                                break block84;
                            }
                            case 6: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                ** GOTO lbl444
                            }
                            case 5: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                break block85;
                            }
                            case 4: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = var15_2.getInt(var1_1, var13_14);
                                var3_7 = zzgfh.zzx((int)(var10_11 << 3));
                                var2_6 = zzgfh.zzw((int)var2_6);
lbl421:
                                // 13 sources

                                var2_6 = var3_7 + var2_6;
lbl422:
                                // 2 sources

                                var2_6 = var5_4 + var2_6;
                                break block83;
                            }
                            case 3: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var13_14 = var15_2.getLong(var1_1, var13_14);
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                var3_7 = zzgfh.zzy((long)var13_14);
                                ** GOTO lbl438
                            }
                            case 2: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var13_14 = var15_2.getLong(var1_1, var13_14);
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                                var3_7 = zzgfh.zzy((long)var13_14);
lbl438:
                                // 4 sources

                                var2_6 += var3_7;
                                break block84;
                            }
                            case 1: {
                                var2_6 = var5_4;
                                if ((var7_5 & var3_7) == 0) break block83;
                                var2_6 = zzgfh.zzx((int)(var10_11 << 3));
lbl444:
                                // 6 sources

                                var2_6 += 4;
                                break block84;
                            }
                            case 0: 
                        }
                        var2_6 = var5_4;
                        if ((var7_5 & var3_7) == 0) break block83;
                        var2_6 = zzgfh.zzx((int)(var10_11 << 3));
                    }
                    var2_6 += 8;
                }
                var2_6 = var5_4 + var2_6;
            }
            var5_4 = var2_6;
            var2_6 = var8_9;
        }
        var15_2 = this.zzo;
        var2_6 = var15_2.zzq(var15_2.zzj(var1_1));
        if (!this.zzh) {
            return var5_4 + var2_6;
        }
        this.zzp.zzb(var1_1);
        throw null;
    }

    /*
     * Unable to fully structure code
     */
    private final int zzs(T var1_1) {
        var10_2 = zzghl.zzb;
        var5_3 = 0;
        var6_4 = 0;
        while (true) {
            block82: {
                block83: {
                    block84: {
                        if (var5_3 >= this.zzc.length) {
                            var10_2 = this.zzo;
                            return var6_4 + var10_2.zzq(var10_2.zzj(var1_1));
                        }
                        var3_6 = this.zzD(var5_3);
                        var2_5 = zzghl.zzF(var3_6);
                        var4_7 = this.zzc[var5_3];
                        var8_9 = var3_6 & 1048575;
                        if (var2_5 >= zzgfs.zzJ.zza() && var2_5 <= zzgfs.zzW.zza()) {
                            var3_6 = this.zzc[var5_3 + 2];
                        }
                        switch (var2_5) {
                            default: {
                                var2_5 = var6_4;
                                break block82;
                            }
                            case 68: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgfh.zzF((int)var4_7, (zzghi)((zzghi)zzgiy.zzn(var1_1, (long)var8_9)), (zzghz)this.zzw(var5_3));
                                break block83;
                            }
                            case 67: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var8_9 = zzghl.zzK(var1_1, var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzy((long)(var8_9 >> 63 ^ var8_9 + var8_9));
                                ** GOTO lbl412
                            }
                            case 66: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzghl.zzJ(var1_1, var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzx((int)(var2_5 >> 31 ^ var2_5 + var2_5));
                                ** GOTO lbl412
                            }
                            case 65: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgfh.zzx((int)(var4_7 << 3));
                                break block84;
                            }
                            case 64: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgfh.zzx((int)(var4_7 << 3));
                                ** GOTO lbl436
                            }
                            case 63: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzghl.zzJ(var1_1, var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzw((int)var2_5);
                                ** GOTO lbl412
                            }
                            case 62: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzghl.zzJ(var1_1, var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzx((int)var2_5);
                                ** GOTO lbl412
                            }
                            case 61: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var11_10 = (zzgex)zzgiy.zzn(var1_1, (long)var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = var11_10.zzc();
                                var4_7 = zzgfh.zzx((int)var2_5);
                                ** GOTO lbl384
                            }
                            case 60: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgib.zzw((int)var4_7, (Object)zzgiy.zzn(var1_1, (long)var8_9), (zzghz)this.zzw(var5_3));
                                break block83;
                            }
                            case 59: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var11_10 = zzgiy.zzn(var1_1, (long)var8_9);
                                if (!(var11_10 instanceof zzgex)) ** GOTO lbl84
                                var11_10 = (zzgex)var11_10;
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = var11_10.zzc();
                                var4_7 = zzgfh.zzx((int)var2_5);
                                ** GOTO lbl384
lbl84:
                                // 1 sources

                                var11_10 = (String)var11_10;
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzz((String)var11_10);
                                ** GOTO lbl412
                            }
                            case 58: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgfh.zzx((int)(var4_7 << 3));
                                ** GOTO lbl394
                            }
                            case 57: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgfh.zzx((int)(var4_7 << 3));
                                ** GOTO lbl436
                            }
                            case 56: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgfh.zzx((int)(var4_7 << 3));
                                break block84;
                            }
                            case 55: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzghl.zzJ(var1_1, var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzw((int)var2_5);
                                ** GOTO lbl412
                            }
                            case 54: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var8_9 = zzghl.zzK(var1_1, var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzy((long)var8_9);
                                ** GOTO lbl429
                            }
                            case 53: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var8_9 = zzghl.zzK(var1_1, var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzy((long)var8_9);
                                ** GOTO lbl429
                            }
                            case 52: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgfh.zzx((int)(var4_7 << 3));
                                ** GOTO lbl436
                            }
                            case 51: {
                                var2_5 = var6_4;
                                if (!this.zzQ(var1_1, var4_7, var5_3)) break block82;
                                var2_5 = zzgfh.zzx((int)(var4_7 << 3));
                                break block84;
                            }
                            case 50: {
                                zzghd.zza((int)var4_7, (Object)zzgiy.zzn(var1_1, (long)var8_9), (Object)this.zzx(var5_3));
                                var2_5 = var6_4;
                                break block82;
                            }
                            case 49: {
                                var2_5 = zzgib.zzz((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (zzghz)this.zzw(var5_3));
                                break block83;
                            }
                            case 48: {
                                var3_6 = zzgib.zzf((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgfh.zzv((int)var4_7);
                                var4_7 = zzgfh.zzx((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 47: {
                                var3_6 = zzgib.zzn((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgfh.zzv((int)var4_7);
                                var4_7 = zzgfh.zzx((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 46: {
                                var3_6 = zzgib.zzr((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgfh.zzv((int)var4_7);
                                var4_7 = zzgfh.zzx((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 45: {
                                var3_6 = zzgib.zzp((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgfh.zzv((int)var4_7);
                                var4_7 = zzgfh.zzx((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 44: {
                                var3_6 = zzgib.zzh((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgfh.zzv((int)var4_7);
                                var4_7 = zzgfh.zzx((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 43: {
                                var3_6 = zzgib.zzl((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgfh.zzv((int)var4_7);
                                var4_7 = zzgfh.zzx((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 42: {
                                var3_6 = zzgib.zzt((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgfh.zzv((int)var4_7);
                                var4_7 = zzgfh.zzx((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 41: {
                                var3_6 = zzgib.zzp((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgfh.zzv((int)var4_7);
                                var4_7 = zzgfh.zzx((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 40: {
                                var3_6 = zzgib.zzr((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgfh.zzv((int)var4_7);
                                var4_7 = zzgfh.zzx((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 39: {
                                var3_6 = zzgib.zzj((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgfh.zzv((int)var4_7);
                                var4_7 = zzgfh.zzx((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 38: {
                                var3_6 = zzgib.zzd((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgfh.zzv((int)var4_7);
                                var4_7 = zzgfh.zzx((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 37: {
                                var3_6 = zzgib.zzb((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgfh.zzv((int)var4_7);
                                var4_7 = zzgfh.zzx((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 36: {
                                var3_6 = zzgib.zzp((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var3_6 <= 0) break block82;
                                var7_8 = zzgfh.zzv((int)var4_7);
                                var4_7 = zzgfh.zzx((int)var3_6);
                                var2_5 = var3_6;
                                var3_6 = var7_8;
                                ** GOTO lbl266
                            }
                            case 35: {
                                var7_8 = zzgib.zzr((List)((List)var10_2.getObject(var1_1, var8_9)));
                                var2_5 = var6_4;
                                if (var7_8 <= 0) break block82;
                                var3_6 = zzgfh.zzv((int)var4_7);
                                var4_7 = zzgfh.zzx((int)var7_8);
                                var2_5 = var7_8;
lbl266:
                                // 14 sources

                                var3_6 += var4_7;
                                ** GOTO lbl412
                            }
                            case 34: {
                                var2_5 = zzgib.zzg((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 33: {
                                var2_5 = zzgib.zzo((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 32: {
                                var2_5 = zzgib.zzs((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 31: {
                                var2_5 = zzgib.zzq((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 30: {
                                var2_5 = zzgib.zzi((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 29: {
                                var2_5 = zzgib.zzm((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 28: {
                                var2_5 = zzgib.zzy((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)));
                                break block83;
                            }
                            case 27: {
                                var2_5 = zzgib.zzx((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (zzghz)this.zzw(var5_3));
                                break block83;
                            }
                            case 26: {
                                var2_5 = zzgib.zzv((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)));
                                break block83;
                            }
                            case 25: {
                                var2_5 = zzgib.zzu((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 24: {
                                var2_5 = zzgib.zzq((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 23: {
                                var2_5 = zzgib.zzs((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 22: {
                                var2_5 = zzgib.zzk((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 21: {
                                var2_5 = zzgib.zze((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 20: {
                                var2_5 = zzgib.zzc((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 19: {
                                var2_5 = zzgib.zzq((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 18: {
                                var2_5 = zzgib.zzs((int)var4_7, (List)((List)zzgiy.zzn(var1_1, (long)var8_9)), (boolean)false);
                                break block83;
                            }
                            case 17: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var2_5 = zzgfh.zzF((int)var4_7, (zzghi)((zzghi)zzgiy.zzn(var1_1, (long)var8_9)), (zzghz)this.zzw(var5_3));
                                break block83;
                            }
                            case 16: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var8_9 = zzgiy.zzf(var1_1, (long)var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzy((long)(var8_9 >> 63 ^ var8_9 + var8_9));
                                ** GOTO lbl412
                            }
                            case 15: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var2_5 = zzgiy.zzd(var1_1, (long)var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzx((int)(var2_5 >> 31 ^ var2_5 + var2_5));
                                ** GOTO lbl412
                            }
                            case 14: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var2_5 = zzgfh.zzx((int)(var4_7 << 3));
                                break block84;
                            }
                            case 13: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var2_5 = zzgfh.zzx((int)(var4_7 << 3));
                                ** GOTO lbl436
                            }
                            case 12: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var2_5 = zzgiy.zzd(var1_1, (long)var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzw((int)var2_5);
                                ** GOTO lbl412
                            }
                            case 11: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var2_5 = zzgiy.zzd(var1_1, (long)var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzx((int)var2_5);
                                ** GOTO lbl412
                            }
                            case 10: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var11_10 = (zzgex)zzgiy.zzn(var1_1, (long)var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = var11_10.zzc();
                                var4_7 = zzgfh.zzx((int)var2_5);
                                ** GOTO lbl384
                            }
                            case 9: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var2_5 = zzgib.zzw((int)var4_7, (Object)zzgiy.zzn(var1_1, (long)var8_9), (zzghz)this.zzw(var5_3));
                                break block83;
                            }
                            case 8: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var11_10 = zzgiy.zzn(var1_1, (long)var8_9);
                                if (!(var11_10 instanceof zzgex)) ** GOTO lbl386
                                var11_10 = (zzgex)var11_10;
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = var11_10.zzc();
                                var4_7 = zzgfh.zzx((int)var2_5);
lbl384:
                                // 4 sources

                                var2_5 = var3_6 + (var4_7 + var2_5);
                                ** GOTO lbl413
lbl386:
                                // 1 sources

                                var11_10 = (String)var11_10;
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzz((String)var11_10);
                                ** GOTO lbl412
                            }
                            case 7: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var2_5 = zzgfh.zzx((int)(var4_7 << 3));
lbl394:
                                // 2 sources

                                ++var2_5;
                                break block83;
                            }
                            case 6: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var2_5 = zzgfh.zzx((int)(var4_7 << 3));
                                ** GOTO lbl436
                            }
                            case 5: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var2_5 = zzgfh.zzx((int)(var4_7 << 3));
                                break block84;
                            }
                            case 4: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var2_5 = zzgiy.zzd(var1_1, (long)var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzw((int)var2_5);
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
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var8_9 = zzgiy.zzf(var1_1, (long)var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzy((long)var8_9);
                                ** GOTO lbl429
                            }
                            case 2: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var8_9 = zzgiy.zzf(var1_1, (long)var8_9);
                                var3_6 = zzgfh.zzx((int)(var4_7 << 3));
                                var2_5 = zzgfh.zzy((long)var8_9);
lbl429:
                                // 4 sources

                                var2_5 = var6_4 + (var3_6 + var2_5);
                                break block82;
                            }
                            case 1: {
                                var2_5 = var6_4;
                                if (!this.zzO(var1_1, var5_3)) break block82;
                                var2_5 = zzgfh.zzx((int)(var4_7 << 3));
lbl436:
                                // 6 sources

                                var2_5 += 4;
                                break block83;
                            }
                            case 0: 
                        }
                        var2_5 = var6_4;
                        if (!this.zzO(var1_1, var5_3)) break block82;
                        var2_5 = zzgfh.zzx((int)(var4_7 << 3));
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
    private final int zzt(T var1_1, byte[] var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7, int var8_8, long var9_9, int var11_10, long var12_11, zzgej var14_12) throws IOException {
        block67: {
            block70: {
                block68: {
                    block69: {
                        block66: {
                            var15_13 = var3_3;
                            var18_15 = var19_14 = (zzggj)zzghl.zzb.getObject(var1_1 /* !! */ , var12_11);
                            if (!var19_14.zza()) {
                                var16_16 = var19_14.size();
                                var16_16 = var16_16 == 0 ? 10 : (var16_16 += var16_16);
                                var18_15 = var19_14.zze(var16_16);
                                zzghl.zzb.putObject(var1_1 /* !! */ , var12_11, (Object)var18_15);
                            }
                            switch (var11_10) {
                                default: {
                                    var11_10 = var15_13;
                                    if (var7_7 != 3) break block66;
                                    var1_1 /* !! */  = this.zzw(var8_8);
                                    var6_6 = var5_5 & -8 | 4;
                                    var3_3 = zzgek.zzj(var1_1 /* !! */ , (byte[])var2_2 /* !! */ , (int)var3_3, (int)var4_4, (int)var6_6, (zzgej)var14_12);
                                    var18_15.add(var14_12.zzc);
                                    break block67;
                                }
                                case 34: 
                                case 48: {
                                    if (var7_7 != 2) ** GOTO lbl29
                                    var1_1 /* !! */  = (zzggx)var18_15;
                                    var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12);
                                    var4_4 = var14_12.zza + var3_3;
                                    while (var3_3 < var4_4) {
                                        var3_3 = zzgek.zzc((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                                        var1_1 /* !! */ .zzg(zzgfc.zzH((long)var14_12.zzb));
                                    }
                                    if (var3_3 != var4_4) throw zzggm.zzd();
                                    break block68;
lbl29:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 == 0) {
                                        var1_1 /* !! */  = (zzggx)var18_15;
                                        var3_3 = zzgek.zzc((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12);
                                        var1_1 /* !! */ .zzg(zzgfc.zzH((long)var14_12.zzb));
                                        while (var3_3 < var4_4) {
                                            var6_6 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var3_3 = zzgek.zzc((byte[])var2_2 /* !! */ , (int)var6_6, (zzgej)var14_12);
                                            var1_1 /* !! */ .zzg(zzgfc.zzH((long)var14_12.zzb));
                                        }
                                        return var3_3;
                                    }
                                    break block66;
                                }
                                case 33: 
                                case 47: {
                                    if (var7_7 != 2) ** GOTO lbl54
                                    var1_1 /* !! */  = (zzggb)var18_15;
                                    var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12);
                                    var4_4 = var14_12.zza + var3_3;
                                    while (var3_3 < var4_4) {
                                        var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                                        var1_1 /* !! */ .zzh(zzgfc.zzG((int)var14_12.zza));
                                    }
                                    if (var3_3 != var4_4) throw zzggm.zzd();
                                    break block68;
lbl54:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 == 0) {
                                        var1_1 /* !! */  = (zzggb)var18_15;
                                        var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12);
                                        var1_1 /* !! */ .zzh(zzgfc.zzG((int)var14_12.zza));
                                        while (var3_3 < var4_4) {
                                            var6_6 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var6_6, (zzgej)var14_12);
                                            var1_1 /* !! */ .zzh(zzgfc.zzG((int)var14_12.zza));
                                        }
                                        return var3_3;
                                    }
                                    break block66;
                                }
                                case 30: 
                                case 44: {
                                    if (var7_7 != 2) ** GOTO lbl72
                                    var3_3 = zzgek.zzl((byte[])var2_2 /* !! */ , (int)var15_13, (zzggj)var18_15, (zzgej)var14_12);
                                    ** GOTO lbl75
lbl72:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 != 0) break block66;
                                    var3_3 = zzgek.zzk((int)var5_5, (byte[])var2_2 /* !! */ , (int)var3_3, (int)var4_4, (zzggj)var18_15, (zzgej)var14_12);
lbl75:
                                    // 2 sources

                                    var14_12 = (zzgga)var1_1 /* !! */ ;
                                    var2_2 /* !! */  = (byte[])var14_12.zzc;
                                    var1_1 /* !! */  = (T)var2_2 /* !! */ ;
                                    if (var2_2 /* !! */  == zzgip.zza()) {
                                        var1_1 /* !! */  = null;
                                    }
                                    if ((var1_1 /* !! */  = zzgib.zzG((int)var6_6, (List)var18_15, (zzgge)this.zzy(var8_8), var1_1 /* !! */ , this.zzo)) == null) return var3_3;
                                    var14_12.zzc = (zzgip)var1_1 /* !! */ ;
                                    return var3_3;
                                }
                                case 28: {
                                    var11_10 = var15_13;
                                    if (var7_7 != 2) break block66;
                                    var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12);
                                    var6_6 = var14_12.zza;
                                    if (var6_6 < 0) throw zzggm.zze();
                                    if (var6_6 > var2_2 /* !! */ .length - var3_3) throw zzggm.zzd();
                                    if (var6_6 != 0) ** GOTO lbl95
                                    var18_15.add((Object)zzgex.zzb);
                                    ** GOTO lbl99
lbl95:
                                    // 1 sources

                                    var18_15.add((Object)zzgex.zzs((byte[])var2_2 /* !! */ , (int)var3_3, (int)var6_6));
                                    while (true) {
                                        var3_3 += var6_6;
lbl99:
                                        // 3 sources

                                        while (var3_3 < var4_4) {
                                            var6_6 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var6_6, (zzgej)var14_12);
                                            var6_6 = var14_12.zza;
                                            if (var6_6 < 0) throw zzggm.zze();
                                            if (var6_6 > var2_2 /* !! */ .length - var3_3) throw zzggm.zzd();
                                            if (var6_6 == 0) {
                                                var18_15.add((Object)zzgex.zzb);
                                                continue;
                                            }
                                            ** GOTO lbl113
                                        }
                                        return var3_3;
lbl113:
                                        // 1 sources

                                        var18_15.add((Object)zzgex.zzs((byte[])var2_2 /* !! */ , (int)var3_3, (int)var6_6));
                                    }
                                }
                                case 27: {
                                    if (var7_7 == 2) return zzgek.zzm((zzghz)this.zzw(var8_8), (int)var5_5, (byte[])var2_2 /* !! */ , (int)var3_3, (int)var4_4, (zzggj)var18_15, (zzgej)var14_12);
                                    var11_10 = var15_13;
                                    break block66;
                                }
                                case 26: {
                                    var11_10 = var15_13;
                                    if (var7_7 != 2) break block66;
                                    if ((var9_9 & 0x20000000L) != 0L) ** GOTO lbl134
                                    var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12);
                                    var6_6 = var14_12.zza;
                                    if (var6_6 < 0) throw zzggm.zze();
                                    if (var6_6 != 0) ** GOTO lbl131
                                    var18_15.add((Object)"");
                                    ** GOTO lbl299
lbl131:
                                    // 1 sources

                                    var18_15.add((Object)new String(var2_2 /* !! */ , var3_3, var6_6, zzggk.zza));
                                    break;
lbl134:
                                    // 1 sources

                                    var6_6 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12);
                                    var7_7 = var14_12.zza;
                                    if (var7_7 < 0) throw zzggm.zze();
                                    if (var7_7 == 0) {
                                        var18_15.add((Object)"");
                                        var3_3 = var6_6;
                                    } else {
                                        var3_3 = var6_6 + var7_7;
                                        if (zzgjd.zzb((byte[])var2_2 /* !! */ , (int)var6_6, (int)var3_3) == false) throw zzggm.zzl();
                                        var18_15.add((Object)new String(var2_2 /* !! */ , var6_6, var7_7, zzggk.zza));
                                    }
                                    while (true) {
                                        var11_10 = var3_3;
                                        if (var3_3 < var4_4) {
                                            var6_6 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                                            var11_10 = var3_3;
                                            if (var5_5 == var14_12.zza) {
                                                var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var6_6, (zzgej)var14_12);
                                                var7_7 = var14_12.zza;
                                                if (var7_7 < 0) throw zzggm.zze();
                                                if (var7_7 == 0) {
                                                    var18_15.add((Object)"");
                                                    continue;
                                                }
                                                var6_6 = var3_3 + var7_7;
                                                if (zzgjd.zzb((byte[])var2_2 /* !! */ , (int)var3_3, (int)var6_6) == false) throw zzggm.zzl();
                                                var18_15.add((Object)new String(var2_2 /* !! */ , var3_3, var7_7, zzggk.zza));
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
                                    var1_1 /* !! */  = (zzgel)var18_15;
                                    var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12);
                                    var4_4 = var14_12.zza + var3_3;
                                    break block69;
lbl172:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 == 0) {
                                        var1_1 /* !! */  = (zzgel)var18_15;
                                        var3_3 = zzgek.zzc((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12);
                                        var17_18 = var14_12.zzb != 0L;
                                        var1_1 /* !! */ .zzd(var17_18);
                                        while (var3_3 < var4_4) {
                                            var6_6 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var3_3 = zzgek.zzc((byte[])var2_2 /* !! */ , (int)var6_6, (zzgej)var14_12);
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
                                    var1_1 /* !! */  = (zzggb)var18_15;
                                    var4_4 = var14_12.zza + var3_3;
                                    for (var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12); var3_3 < var4_4; var3_3 += 4) {
                                        var1_1 /* !! */ .zzh(zzgek.zzd((byte[])var2_2 /* !! */ , (int)var3_3));
                                    }
                                    if (var3_3 != var4_4) throw zzggm.zzd();
                                    break block68;
lbl197:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 == 5) {
                                        var1_1 /* !! */  = (zzggb)var18_15;
                                        var1_1 /* !! */ .zzh(zzgek.zzd((byte[])var2_2 /* !! */ , (int)var3_3));
                                        while ((var3_3 = var15_13 + 4) < var4_4) {
                                            var15_13 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var1_1 /* !! */ .zzh(zzgek.zzd((byte[])var2_2 /* !! */ , (int)var15_13));
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
                                    var1_1 /* !! */  = (zzggx)var18_15;
                                    var4_4 = var14_12.zza + var3_3;
                                    for (var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12); var3_3 < var4_4; var3_3 += 8) {
                                        var1_1 /* !! */ .zzg(zzgek.zze((byte[])var2_2 /* !! */ , (int)var3_3));
                                    }
                                    if (var3_3 != var4_4) throw zzggm.zzd();
                                    break block68;
lbl218:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 == 1) {
                                        var1_1 /* !! */  = (zzggx)var18_15;
                                        var1_1 /* !! */ .zzg(zzgek.zze((byte[])var2_2 /* !! */ , (int)var3_3));
                                        while ((var3_3 = var15_13 + 8) < var4_4) {
                                            var15_13 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var1_1 /* !! */ .zzg(zzgek.zze((byte[])var2_2 /* !! */ , (int)var15_13));
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
                                    var3_3 = zzgek.zzl((byte[])var2_2 /* !! */ , (int)var15_13, (zzggj)var18_15, (zzgej)var14_12);
                                    break block68;
lbl234:
                                    // 1 sources

                                    if (var7_7 == 0) return zzgek.zzk((int)var5_5, (byte[])var2_2 /* !! */ , (int)var3_3, (int)var4_4, (zzggj)var18_15, (zzgej)var14_12);
                                    var11_10 = var15_13;
                                    break block66;
                                }
                                case 20: 
                                case 21: 
                                case 37: 
                                case 38: {
                                    if (var7_7 != 2) ** GOTO lbl248
                                    var1_1 /* !! */  = (zzggx)var18_15;
                                    var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12);
                                    var4_4 = var14_12.zza + var3_3;
                                    while (var3_3 < var4_4) {
                                        var3_3 = zzgek.zzc((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                                        var1_1 /* !! */ .zzg(var14_12.zzb);
                                    }
                                    if (var3_3 != var4_4) throw zzggm.zzd();
                                    break block68;
lbl248:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 == 0) {
                                        var1_1 /* !! */  = (zzggx)var18_15;
                                        var3_3 = zzgek.zzc((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12);
                                        var1_1 /* !! */ .zzg(var14_12.zzb);
                                        while (var3_3 < var4_4) {
                                            var6_6 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var3_3 = zzgek.zzc((byte[])var2_2 /* !! */ , (int)var6_6, (zzgej)var14_12);
                                            var1_1 /* !! */ .zzg(var14_12.zzb);
                                        }
                                        return var3_3;
                                    }
                                    break block66;
                                }
                                case 19: 
                                case 36: {
                                    if (var7_7 != 2) ** GOTO lbl271
                                    var1_1 /* !! */  = (zzgft)var18_15;
                                    var4_4 = var14_12.zza + var3_3;
                                    for (var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12); var3_3 < var4_4; var3_3 += 4) {
                                        var1_1 /* !! */ .zzd(Float.intBitsToFloat(zzgek.zzd((byte[])var2_2 /* !! */ , (int)var3_3)));
                                    }
                                    if (var3_3 != var4_4) throw zzggm.zzd();
                                    break block68;
lbl271:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 == 5) {
                                        var1_1 /* !! */  = (zzgft)var18_15;
                                        var1_1 /* !! */ .zzd(Float.intBitsToFloat(zzgek.zzd((byte[])var2_2 /* !! */ , (int)var3_3)));
                                        while ((var3_3 = var15_13 + 4) < var4_4) {
                                            var15_13 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                                            if (var5_5 != var14_12.zza) {
                                                return var3_3;
                                            }
                                            var1_1 /* !! */ .zzd(Float.intBitsToFloat(zzgek.zzd((byte[])var2_2 /* !! */ , (int)var15_13)));
                                        }
                                        return var3_3;
                                    }
                                    break block66;
                                }
                                case 18: 
                                case 35: {
                                    if (var7_7 != 2) ** GOTO lbl292
                                    var1_1 /* !! */  = (zzgfj)var18_15;
                                    var4_4 = var14_12.zza + var3_3;
                                    for (var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var15_13, (zzgej)var14_12); var3_3 < var4_4; var3_3 += 8) {
                                        var1_1 /* !! */ .zzd(Double.longBitsToDouble(zzgek.zze((byte[])var2_2 /* !! */ , (int)var3_3)));
                                    }
                                    if (var3_3 != var4_4) throw zzggm.zzd();
                                    break block68;
lbl292:
                                    // 1 sources

                                    var11_10 = var15_13;
                                    if (var7_7 != 1) break block66;
                                    var1_1 /* !! */  = (zzgfj)var18_15;
                                    var1_1 /* !! */ .zzd(Double.longBitsToDouble(zzgek.zze((byte[])var2_2 /* !! */ , (int)var3_3)));
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
                                    var6_6 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                                    var11_10 = var3_3;
                                    if (var5_5 != var14_12.zza) break block32;
                                    var3_3 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var6_6, (zzgej)var14_12);
                                    var6_6 = var14_12.zza;
                                    if (var6_6 < 0) throw zzggm.zze();
                                    if (var6_6 != 0) break;
                                    var18_15.add((Object)"");
                                }
                                var18_15.add((Object)new String(var2_2 /* !! */ , var3_3, var6_6, zzggk.zza));
                            }
                        }
                        var3_3 = var11_10;
                        break block68;
                    }
                    while (var3_3 < var4_4) {
                        var3_3 = zzgek.zzc((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                        var17_17 = var14_12.zzb != 0L;
                        var1_1 /* !! */ .zzd(var17_17);
                    }
                    if (var3_3 != var4_4) throw zzggm.zzd();
                }
                return var3_3;
            }
            while ((var3_3 = var15_13 + 8) < var4_4) {
                var15_13 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
                if (var5_5 != var14_12.zza) {
                    return var3_3;
                }
                var1_1 /* !! */ .zzd(Double.longBitsToDouble(zzgek.zze((byte[])var2_2 /* !! */ , (int)var15_13)));
            }
            return var3_3;
        }
        while (var3_3 < var4_4) {
            var7_7 = zzgek.zza((byte[])var2_2 /* !! */ , (int)var3_3, (zzgej)var14_12);
            if (var5_5 != var14_12.zza) {
                return var3_3;
            }
            var3_3 = zzgek.zzj(var1_1 /* !! */ , (byte[])var2_2 /* !! */ , (int)var7_7, (int)var4_4, (int)var6_6, (zzgej)var14_12);
            var18_15.add(var14_12.zzc);
        }
        return var3_3;
    }

    private final <K, V> int zzu(T object, byte[] object2, int n, int n2, int n3, long l, zzgej object3) throws IOException {
        object2 = zzb;
        Object object4 = this.zzx(n3);
        object3 = ((Unsafe)object2).getObject(object, l);
        if (zzghd.zzb((Object)object3)) {
            zzghc zzghc2 = zzghc.zza().zzc();
            zzghd.zzc((Object)zzghc2, (Object)object3);
            ((Unsafe)object2).putObject(object, l, (Object)zzghc2);
        }
        object = (zzghb)object4;
        throw null;
    }

    private final int zzv(T t, byte[] object, int n, int n2, int n3, int n4, int n5, int n6, int n7, long l, int n8, zzgej zzgej2) throws IOException {
        Unsafe unsafe = zzb;
        long l2 = this.zzc[n8 + 2] & 0xFFFFF;
        switch (n7) {
            default: {
                break;
            }
            case 68: {
                if (n5 != 3) return n;
                n = zzgek.zzj((zzghz)this.zzw(n8), (byte[])object, (int)n, (int)n2, (int)(n3 & 0xFFFFFFF8 | 4), (zzgej)zzgej2);
                object = unsafe.getInt(t, l2) == n4 ? (Object)unsafe.getObject(t, l) : null;
                if (object == null) {
                    unsafe.putObject(t, l, zzgej2.zzc);
                } else {
                    unsafe.putObject(t, l, zzggk.zzi((Object)object, (Object)zzgej2.zzc));
                }
                unsafe.putInt(t, l2, n4);
                break;
            }
            case 67: {
                if (n5 != 0) return n;
                n = zzgek.zzc((byte[])object, (int)n, (zzgej)zzgej2);
                unsafe.putObject(t, l, (Object)zzgfc.zzH((long)zzgej2.zzb));
                unsafe.putInt(t, l2, n4);
                return n;
            }
            case 66: {
                if (n5 != 0) return n;
                n = zzgek.zza((byte[])object, (int)n, (zzgej)zzgej2);
                unsafe.putObject(t, l, (Object)zzgfc.zzG((int)zzgej2.zza));
                unsafe.putInt(t, l2, n4);
                return n;
            }
            case 63: {
                if (n5 != 0) return n;
                n = zzgek.zza((byte[])object, (int)n, (zzgej)zzgej2);
                n2 = zzgej2.zza;
                object = this.zzy(n8);
                if (object != null && !object.zza(n2)) {
                    zzghl.zzg(t).zzh(n3, (Object)n2);
                    break;
                }
                unsafe.putObject(t, l, (Object)n2);
                unsafe.putInt(t, l2, n4);
                break;
            }
            case 61: {
                if (n5 != 2) return n;
                n = zzgek.zzh((byte[])object, (int)n, (zzgej)zzgej2);
                unsafe.putObject(t, l, zzgej2.zzc);
                unsafe.putInt(t, l2, n4);
                return n;
            }
            case 60: {
                if (n5 != 2) return n;
                n = zzgek.zzi((zzghz)this.zzw(n8), (byte[])object, (int)n, (int)n2, (zzgej)zzgej2);
                object = unsafe.getInt(t, l2) == n4 ? (Object)unsafe.getObject(t, l) : null;
                if (object == null) {
                    unsafe.putObject(t, l, zzgej2.zzc);
                } else {
                    unsafe.putObject(t, l, zzggk.zzi((Object)object, (Object)zzgej2.zzc));
                }
                unsafe.putInt(t, l2, n4);
                break;
            }
            case 59: {
                if (n5 != 2) return n;
                n = zzgek.zza((byte[])object, (int)n, (zzgej)zzgej2);
                n2 = zzgej2.zza;
                if (n2 == 0) {
                    unsafe.putObject(t, l, (Object)"");
                } else {
                    if ((n6 & 0x20000000) != 0) {
                        if (!zzgjd.zzb((byte[])object, (int)n, (int)(n + n2))) throw zzggm.zzl();
                    }
                    unsafe.putObject(t, l, (Object)new String((byte[])object, n, n2, zzggk.zza));
                    n += n2;
                }
                unsafe.putInt(t, l2, n4);
                break;
            }
            case 58: {
                if (n5 != 0) return n;
                n = zzgek.zzc((byte[])object, (int)n, (zzgej)zzgej2);
                boolean bl = zzgej2.zzb != 0L;
                unsafe.putObject(t, l, (Object)bl);
                unsafe.putInt(t, l2, n4);
                return n;
            }
            case 57: 
            case 64: {
                if (n5 != 5) return n;
                unsafe.putObject(t, l, (Object)zzgek.zzd((byte[])object, (int)n));
                unsafe.putInt(t, l2, n4);
                return n + 4;
            }
            case 56: 
            case 65: {
                if (n5 != 1) return n;
                unsafe.putObject(t, l, (Object)zzgek.zze((byte[])object, (int)n));
                unsafe.putInt(t, l2, n4);
                return n + 8;
            }
            case 55: 
            case 62: {
                if (n5 != 0) return n;
                n = zzgek.zza((byte[])object, (int)n, (zzgej)zzgej2);
                unsafe.putObject(t, l, (Object)zzgej2.zza);
                unsafe.putInt(t, l2, n4);
                return n;
            }
            case 53: 
            case 54: {
                if (n5 != 0) return n;
                n = zzgek.zzc((byte[])object, (int)n, (zzgej)zzgej2);
                unsafe.putObject(t, l, (Object)zzgej2.zzb);
                unsafe.putInt(t, l2, n4);
                return n;
            }
            case 52: {
                if (n5 != 5) return n;
                unsafe.putObject(t, l, (Object)Float.valueOf(Float.intBitsToFloat(zzgek.zzd((byte[])object, (int)n))));
                unsafe.putInt(t, l2, n4);
                return n + 4;
            }
            case 51: {
                if (n5 != 1) return n;
                unsafe.putObject(t, l, (Object)Double.longBitsToDouble(zzgek.zze((byte[])object, (int)n)));
                unsafe.putInt(t, l2, n4);
                return n + 8;
            }
        }
        return n;
    }

    private final zzghz zzw(int n) {
        zzghz zzghz2;
        n /= 3;
        if ((zzghz2 = (zzghz)this.zzd[n += n]) != null) {
            return zzghz2;
        }
        zzghz2 = zzghq.zza().zzb((Class)this.zzd[n + 1]);
        this.zzd[n] = zzghz2;
        return zzghz2;
    }

    private final Object zzx(int n) {
        return this.zzd[(n /= 3) + n];
    }

    private final zzgge zzy(int n) {
        return (zzgge)this.zzd[(n /= 3) + n + 1];
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final int zzz(T var1_1, byte[] var2_2, int var3_3, int var4_4, zzgej var5_5) throws IOException {
        var6_6 = var4_4;
        var19_7 = zzghl.zzb;
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
                                                    var9_11 = zzgek.zzb((int)var11_12, (byte[])var2_2, (int)var9_11, (zzgej)var5_5);
                                                    var11_12 = var5_5.zza;
                                                }
                                                var8_8 = var11_12 >>> 3;
                                                var13_14 = var11_12 & 7;
                                                if ((var3_3 = var8_8 > var3_3 ? this.zzT(var8_8, var10_9 / 3) : this.zzS(var8_8)) != -1) break block33;
                                                var3_3 = 0;
                                                ** GOTO lbl177
                                            }
                                            var15_16 = this.zzc[var3_3 + 1];
                                            var14_15 = zzghl.zzF(var15_16);
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
                                                    var6_6 = zzgek.zzc((byte[])var2_2, (int)var9_11, (zzgej)var5_5);
                                                    var20_19.putLong(var1_1 /* !! */ , var17_18, zzgfc.zzH((long)var5_5.zzb));
                                                    ** GOTO lbl111
                                                }
                                                case 15: {
                                                    if (var13_14 != 0) break block35;
                                                    var6_6 = zzgek.zza((byte[])var2_2, (int)var9_11, (zzgej)var5_5);
                                                    var20_19.putInt(var1_1 /* !! */ , var17_18, zzgfc.zzG((int)var5_5.zza));
                                                    break block36;
                                                }
                                                case 12: {
                                                    if (var13_14 != 0) break block35;
                                                    var6_6 = zzgek.zza((byte[])var2_2, (int)var9_11, (zzgej)var5_5);
                                                    var20_19.putInt(var1_1 /* !! */ , var17_18, var5_5.zza);
                                                    break block36;
                                                }
                                                case 10: {
                                                    if (var13_14 != 2) break block35;
                                                    var6_6 = zzgek.zzh((byte[])var2_2, (int)var9_11, (zzgej)var5_5);
                                                    var20_19.putObject(var1_1 /* !! */ , var17_18, var5_5.zzc);
                                                    break block36;
                                                }
                                                case 9: {
                                                    if (var13_14 != 2) break block35;
                                                    var6_6 = zzgek.zzi((zzghz)this.zzw(var3_3), (byte[])var2_2, (int)var9_11, (int)var4_4, (zzgej)var5_5);
                                                    var19_7 = var20_19.getObject(var1_1 /* !! */ , var17_18);
                                                    if (var19_7 == null) {
                                                        var20_19.putObject(var1_1 /* !! */ , var17_18, var5_5.zzc);
                                                    } else {
                                                        var20_19.putObject(var1_1 /* !! */ , var17_18, zzggk.zzi((Object)var19_7, (Object)var5_5.zzc));
                                                    }
                                                    ** GOTO lbl87
                                                }
                                                case 8: {
                                                    if (var13_14 != 2) break block35;
                                                    var6_6 = (var15_16 & 0x20000000) == 0 ? zzgek.zzf((byte[])var2_2, (int)var9_11, (zzgej)var5_5) : zzgek.zzg((byte[])var2_2, (int)var9_11, (zzgej)var5_5);
                                                    var20_19.putObject(var1_1 /* !! */ , var17_18, var5_5.zzc);
                                                    ** GOTO lbl87
                                                }
                                                case 7: {
                                                    if (var13_14 != 0) break block35;
                                                    var6_6 = zzgek.zzc((byte[])var2_2, (int)var9_11, (zzgej)var5_5);
                                                    if (var5_5.zzb == 0L) {
                                                        var16_17 = false;
                                                    }
                                                    zzgiy.zzi(var1_1 /* !! */ , (long)var17_18, (boolean)var16_17);
                                                    ** GOTO lbl87
                                                }
                                                case 6: 
                                                case 13: {
                                                    if (var13_14 != 5) break block35;
                                                    var20_19.putInt(var1_1 /* !! */ , var17_18, zzgek.zzd((byte[])var2_2, (int)var9_11));
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
                                                    var20_19.putLong(var1_1 /* !! */ , var17_18, zzgek.zze((byte[])var2_2, (int)var9_11));
                                                    var6_6 = var9_11 + 8;
                                                    break block36;
                                                }
                                                case 4: 
                                                case 11: {
                                                    if (var13_14 != 0) break block35;
                                                    var6_6 = zzgek.zza((byte[])var2_2, (int)var9_11, (zzgej)var5_5);
                                                    var20_19.putInt(var1_1 /* !! */ , var17_18, var5_5.zza);
                                                    break block36;
                                                }
                                                case 2: 
                                                case 3: {
                                                    if (var13_14 != 0) break block35;
                                                    var6_6 = zzgek.zzc((byte[])var2_2, (int)var9_11, (zzgej)var5_5);
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
                                                    zzgiy.zzk(var1_1 /* !! */ , (long)var17_18, (float)Float.intBitsToFloat(zzgek.zzd((byte[])var2_2, (int)var9_11)));
                                                    var6_6 = var9_11 + 4;
                                                    break block36;
                                                }
                                                case 0: 
                                            }
                                            if (var13_14 != 1) break block35;
                                            zzgiy.zzm(var1_1 /* !! */ , (long)var17_18, (double)Double.longBitsToDouble(zzgek.zze((byte[])var2_2, (int)var9_11)));
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
                                var22_21 = (zzggj)var21_20.getObject(var1_1 /* !! */ , var17_18);
                                var20_19 = var22_21;
                                if (!var22_21.zza()) {
                                    var10_9 = var22_21.size();
                                    var10_9 = var10_9 == 0 ? 10 : (var10_9 += var10_9);
                                    var20_19 = var22_21.zze(var10_9);
                                    var21_20.putObject(var1_1 /* !! */ , var17_18, var20_19);
                                }
                                var9_11 = zzgek.zzm((zzghz)this.zzw(var12_13), (int)var11_12, (byte[])var2_2, (int)var9_11, (int)var4_4, (zzggj)var20_19, (zzgej)var5_5);
                            }
                            var10_9 = var3_3;
                        }
                        var3_3 = var8_8;
                        var8_8 = var4_4;
                        var8_8 = var9_11;
                        continue;
                    }
                    if (var14_15 > 49) break block40;
                    var10_9 = var12_13 = this.zzt(var1_1 /* !! */ , var2_2, var9_11, var4_4, var11_12, var8_8, var13_14, var12_13, var15_16, var14_15, var17_18, var5_5);
                    if (var12_13 == var9_11) ** GOTO lbl-1000
                    var9_11 = var12_13;
                    ** GOTO lbl173
                }
                if (var14_15 != 50) break block41;
                if (var13_14 != 2) ** GOTO lbl177
                var10_9 = var12_13 = this.zzu(var1_1 /* !! */ , var2_2, var9_11, var4_4, var12_13, var17_18, var5_5);
                if (var12_13 == var9_11) ** GOTO lbl-1000
                var9_11 = var12_13;
                ** GOTO lbl173
            }
            var10_9 = var12_13 = this.zzv(var1_1 /* !! */ , var2_2, var9_11, var4_4, var11_12, var8_8, var13_14, var15_16, var14_15, var17_18, var12_13, var5_5);
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

                var9_11 = zzgek.zzn((int)var11_12, (byte[])var2_2, (int)var9_11, (int)var4_4, (zzgip)zzghl.zzg(var1_1 /* !! */ ), (zzgej)var5_5);
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
        var1_1 /* !! */  = zzggm.zzk();
        throw var1_1 /* !! */ ;
    }

    public final T zza() {
        return (T)((zzgga)this.zzg).zzb(4, null, null);
    }

    /*
     * Unable to fully structure code
     */
    public final boolean zzb(T var1_1, T var2_2) {
        var4_3 = this.zzc.length;
        block23: for (var3_4 = 0; var3_4 < var4_3; var3_4 += 3) {
            block26: {
                var5_5 = this.zzD(var3_4);
                var8_7 = var5_5 & 1048575;
                switch (zzghl.zzF(var5_5)) {
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
                        var6_6 = this.zzE(var3_4) & 1048575;
                        if (zzgiy.zzd(var1_1, (long)var6_6) != zzgiy.zzd(var2_2, (long)var6_6)) return false;
                        if (zzgib.zzD((Object)zzgiy.zzn(var1_1, (long)var8_7), (Object)zzgiy.zzn(var2_2, (long)var8_7))) continue block23;
                        break block26;
                    }
                    case 50: {
                        var10_8 = zzgib.zzD((Object)zzgiy.zzn(var1_1, (long)var8_7), (Object)zzgiy.zzn(var2_2, (long)var8_7));
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
                        var10_8 = zzgib.zzD((Object)zzgiy.zzn(var1_1, (long)var8_7), (Object)zzgiy.zzn(var2_2, (long)var8_7));
lbl18:
                        // 2 sources

                        if (var10_8) continue block23;
                        break block26;
                    }
                    case 17: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgib.zzD((Object)zzgiy.zzn(var1_1, (long)var8_7), (Object)zzgiy.zzn(var2_2, (long)var8_7)) == false) return false;
                        continue block23;
                    }
                    case 16: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgiy.zzf(var1_1, (long)var8_7) != zzgiy.zzf(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 15: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgiy.zzd(var1_1, (long)var8_7) != zzgiy.zzd(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 14: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgiy.zzf(var1_1, (long)var8_7) != zzgiy.zzf(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 13: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgiy.zzd(var1_1, (long)var8_7) != zzgiy.zzd(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 12: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgiy.zzd(var1_1, (long)var8_7) != zzgiy.zzd(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 11: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgiy.zzd(var1_1, (long)var8_7) != zzgiy.zzd(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 10: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgib.zzD((Object)zzgiy.zzn(var1_1, (long)var8_7), (Object)zzgiy.zzn(var2_2, (long)var8_7)) == false) return false;
                        continue block23;
                    }
                    case 9: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgib.zzD((Object)zzgiy.zzn(var1_1, (long)var8_7), (Object)zzgiy.zzn(var2_2, (long)var8_7)) == false) return false;
                        continue block23;
                    }
                    case 8: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgib.zzD((Object)zzgiy.zzn(var1_1, (long)var8_7), (Object)zzgiy.zzn(var2_2, (long)var8_7)) == false) return false;
                        continue block23;
                    }
                    case 7: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgiy.zzh(var1_1, (long)var8_7) != zzgiy.zzh(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 6: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgiy.zzd(var1_1, (long)var8_7) != zzgiy.zzd(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 5: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgiy.zzf(var1_1, (long)var8_7) != zzgiy.zzf(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 4: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgiy.zzd(var1_1, (long)var8_7) != zzgiy.zzd(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 3: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgiy.zzf(var1_1, (long)var8_7) != zzgiy.zzf(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 2: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (zzgiy.zzf(var1_1, (long)var8_7) != zzgiy.zzf(var2_2, (long)var8_7)) return false;
                        continue block23;
                    }
                    case 1: {
                        if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                        if (Float.floatToIntBits(zzgiy.zzj(var1_1, (long)var8_7)) != Float.floatToIntBits(zzgiy.zzj(var2_2, (long)var8_7))) return false;
                        continue block23;
                    }
                    case 0: 
                }
                if (this.zzM(var1_1, var2_2, var3_4) == false) return false;
                if (Double.doubleToLongBits(zzgiy.zzl(var1_1, (long)var8_7)) != Double.doubleToLongBits(zzgiy.zzl(var2_2, (long)var8_7))) return false;
                continue;
            }
            return false;
        }
        if (!this.zzo.zzj(var1_1).equals(this.zzo.zzj(var2_2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zzb(var1_1);
        this.zzp.zzb(var2_2);
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
                    var2_5 = this.zzD(var4_3);
                    var6_6 = this.zzc[var4_3];
                    var8_8 = 1048575 & var2_5;
                    var7_7 = zzghl.zzF(var2_5);
                    var2_5 = 37;
                    switch (var7_7) {
                        default: {
                            var2_5 = var3_4;
                            break block44;
                        }
                        case 68: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzgiy.zzn(var1_1, (long)var8_8).hashCode();
                            break block45;
                        }
                        case 67: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzggk.zze((long)zzghl.zzK(var1_1, var8_8));
                            break block45;
                        }
                        case 66: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzghl.zzJ(var1_1, var8_8);
                            break block45;
                        }
                        case 65: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzggk.zze((long)zzghl.zzK(var1_1, var8_8));
                            break block45;
                        }
                        case 64: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzghl.zzJ(var1_1, var8_8);
                            break block45;
                        }
                        case 63: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzghl.zzJ(var1_1, var8_8);
                            break block45;
                        }
                        case 62: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzghl.zzJ(var1_1, var8_8);
                            break block45;
                        }
                        case 61: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzgiy.zzn(var1_1, (long)var8_8).hashCode();
                            break block45;
                        }
                        case 60: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzgiy.zzn(var1_1, (long)var8_8).hashCode();
                            break block45;
                        }
                        case 59: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = ((String)zzgiy.zzn(var1_1, (long)var8_8)).hashCode();
                            break block45;
                        }
                        case 58: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzggk.zzf((boolean)zzghl.zzL(var1_1, var8_8));
                            break block45;
                        }
                        case 57: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzghl.zzJ(var1_1, var8_8);
                            break block45;
                        }
                        case 56: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzggk.zze((long)zzghl.zzK(var1_1, var8_8));
                            break block45;
                        }
                        case 55: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzghl.zzJ(var1_1, var8_8);
                            break block45;
                        }
                        case 54: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzggk.zze((long)zzghl.zzK(var1_1, var8_8));
                            break block45;
                        }
                        case 53: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzggk.zze((long)zzghl.zzK(var1_1, var8_8));
                            break block45;
                        }
                        case 52: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = Float.floatToIntBits(zzghl.zzI(var1_1, var8_8));
                            break block45;
                        }
                        case 51: {
                            var2_5 = var3_4;
                            if (!this.zzQ(var1_1, var6_6, var4_3)) break block44;
                            var2_5 = var3_4 * 53;
                            var3_4 = zzggk.zze((long)Double.doubleToLongBits(zzghl.zzH(var1_1, var8_8)));
                            break block45;
                        }
                        case 50: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzgiy.zzn(var1_1, (long)var8_8).hashCode();
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
                            var3_4 = zzgiy.zzn(var1_1, (long)var8_8).hashCode();
                            break block45;
                        }
                        case 17: {
                            var10_9 = zzgiy.zzn(var1_1, (long)var8_8);
                            if (var10_9 != null) {
                                var2_5 = var10_9.hashCode();
                            }
                            ** GOTO lbl166
                        }
                        case 16: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzggk.zze((long)zzgiy.zzf(var1_1, (long)var8_8));
                            break block45;
                        }
                        case 15: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzgiy.zzd(var1_1, (long)var8_8);
                            break block45;
                        }
                        case 14: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzggk.zze((long)zzgiy.zzf(var1_1, (long)var8_8));
                            break block45;
                        }
                        case 13: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzgiy.zzd(var1_1, (long)var8_8);
                            break block45;
                        }
                        case 12: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzgiy.zzd(var1_1, (long)var8_8);
                            break block45;
                        }
                        case 11: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzgiy.zzd(var1_1, (long)var8_8);
                            break block45;
                        }
                        case 10: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzgiy.zzn(var1_1, (long)var8_8).hashCode();
                            break block45;
                        }
                        case 9: {
                            var10_9 = zzgiy.zzn(var1_1, (long)var8_8);
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
                            var3_4 = ((String)zzgiy.zzn(var1_1, (long)var8_8)).hashCode();
                            break block45;
                        }
                        case 7: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzggk.zzf((boolean)zzgiy.zzh(var1_1, (long)var8_8));
                            break block45;
                        }
                        case 6: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzgiy.zzd(var1_1, (long)var8_8);
                            break block45;
                        }
                        case 5: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzggk.zze((long)zzgiy.zzf(var1_1, (long)var8_8));
                            break block45;
                        }
                        case 4: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzgiy.zzd(var1_1, (long)var8_8);
                            break block45;
                        }
                        case 3: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzggk.zze((long)zzgiy.zzf(var1_1, (long)var8_8));
                            break block45;
                        }
                        case 2: {
                            var2_5 = var3_4 * 53;
                            var3_4 = zzggk.zze((long)zzgiy.zzf(var1_1, (long)var8_8));
                            break block45;
                        }
                        case 1: {
                            var2_5 = var3_4 * 53;
                            var3_4 = Float.floatToIntBits(zzgiy.zzj(var1_1, (long)var8_8));
                            break block45;
                        }
                        case 0: 
                    }
                    var2_5 = var3_4 * 53;
                    var3_4 = zzggk.zze((long)Double.doubleToLongBits(zzgiy.zzl(var1_1, (long)var8_8)));
                }
                var2_5 += var3_4;
            }
            var3_4 = var2_5;
        }
        var2_5 = this.zzo.zzj(var1_1).hashCode();
        if (!this.zzh) {
            return var3_4 * 53 + var2_5;
        }
        this.zzp.zzb(var1_1);
        throw null;
    }

    public final void zzd(T t, T t2) {
        if (t2 == null) throw null;
        int n = 0;
        while (true) {
            if (n >= this.zzc.length) {
                zzgib.zzF(this.zzo, t, t2);
                if (!this.zzh) return;
                zzgib.zzE(this.zzp, t, t2);
                return;
            }
            int n2 = this.zzD(n);
            long l = 0xFFFFF & n2;
            int n3 = this.zzc[n];
            switch (zzghl.zzF(n2)) {
                default: {
                    break;
                }
                case 68: {
                    this.zzq(t, t2, n);
                    break;
                }
                case 61: 
                case 62: 
                case 63: 
                case 64: 
                case 65: 
                case 66: 
                case 67: {
                    if (!this.zzQ(t2, n3, n)) break;
                    zzgiy.zzo(t, (long)l, (Object)zzgiy.zzn(t2, (long)l));
                    this.zzR(t, n3, n);
                    break;
                }
                case 60: {
                    this.zzq(t, t2, n);
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
                    if (!this.zzQ(t2, n3, n)) break;
                    zzgiy.zzo(t, (long)l, (Object)zzgiy.zzn(t2, (long)l));
                    this.zzR(t, n3, n);
                    break;
                }
                case 50: {
                    zzgib.zzI((zzghd)this.zzr, t, t2, (long)l);
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
                    this.zzn.zzc(t, t2, l);
                    break;
                }
                case 17: {
                    this.zzp(t, t2, n);
                    break;
                }
                case 16: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zzg(t, (long)l, (long)zzgiy.zzf(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 15: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zze(t, (long)l, (int)zzgiy.zzd(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 14: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zzg(t, (long)l, (long)zzgiy.zzf(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 13: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zze(t, (long)l, (int)zzgiy.zzd(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 12: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zze(t, (long)l, (int)zzgiy.zzd(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 11: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zze(t, (long)l, (int)zzgiy.zzd(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 10: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zzo(t, (long)l, (Object)zzgiy.zzn(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 9: {
                    this.zzp(t, t2, n);
                    break;
                }
                case 8: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zzo(t, (long)l, (Object)zzgiy.zzn(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 7: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zzi(t, (long)l, (boolean)zzgiy.zzh(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 6: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zze(t, (long)l, (int)zzgiy.zzd(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 5: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zzg(t, (long)l, (long)zzgiy.zzf(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 4: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zze(t, (long)l, (int)zzgiy.zzd(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 3: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zzg(t, (long)l, (long)zzgiy.zzf(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 2: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zzg(t, (long)l, (long)zzgiy.zzf(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 1: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zzk(t, (long)l, (float)zzgiy.zzj(t2, (long)l));
                    this.zzP(t, n);
                    break;
                }
                case 0: {
                    if (!this.zzO(t2, n)) break;
                    zzgiy.zzm(t, (long)l, (double)zzgiy.zzl(t2, (long)l));
                    this.zzP(t, n);
                }
            }
            n += 3;
        }
    }

    public final int zze(T t) {
        int n = this.zzj ? this.zzs(t) : this.zzr(t);
        return n;
    }

    /*
     * Exception decompiling
     */
    public final void zzf(T var1_1, zzght var2_2, zzgfm var3_4) throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [9 : 317->4038)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    final int zzh(T var1_1, byte[] var2_2, int var3_3, int var4_4, int var5_5, zzgej var6_6) throws IOException {
        block58: {
            block57: {
                block56: {
                    block39: {
                        var21_7 /* !! */  = var1_1 /* !! */ ;
                        var21_7 /* !! */  = (T)var2_2;
                        var12_8 = var4_4;
                        var13_9 = var5_5;
                        var22_10 = var6_6;
                        var22_10 = zzghl.zzb;
                        var7_11 = false;
                        var8_12 = -1;
                        var14_13 = 0;
                        var9_14 = 0;
                        var10_15 = 1048575;
                        while (true) {
                            block41: {
                                block51: {
                                    block53: {
                                        block54: {
                                            block55: {
                                                block52: {
                                                    block50: {
                                                        block49: {
                                                            block42: {
                                                                block43: {
                                                                    block48: {
                                                                        block47: {
                                                                            block45: {
                                                                                block44: {
                                                                                    block46: {
                                                                                        block40: {
                                                                                            var23_22 /* !! */  = var1_1 /* !! */ ;
                                                                                            var24_23 = var6_6;
                                                                                            if (var3_3 >= var12_8) break;
                                                                                            var11_16 = var3_3 + 1;
                                                                                            var7_11 = var21_7 /* !! */ [var3_3];
                                                                                            if (var7_11 < 0) {
                                                                                                var3_3 = zzgek.zzb((int)var7_11, var21_7 /* !! */ , (int)var11_16, (zzgej)var24_23);
                                                                                                var7_11 = var24_23.zza;
                                                                                            } else {
                                                                                                var3_3 = var11_16;
                                                                                            }
                                                                                            var11_16 = var7_11 >>> 3;
                                                                                            var15_17 = var7_11 & 7;
                                                                                            var8_12 = var11_16 > var8_12 ? this.zzT(var11_16, var14_13 / 3) : this.zzS(var11_16);
                                                                                            if (var8_12 != -1) break block40;
                                                                                            var8_12 = var7_11;
                                                                                            var8_12 = var9_14;
                                                                                            var9_14 = var11_16;
                                                                                            var12_8 = 0;
                                                                                            var9_14 = var3_3;
                                                                                            var3_3 = var13_9;
                                                                                            break block41;
                                                                                        }
                                                                                        var17_19 = this.zzc[var8_12 + 1];
                                                                                        var16_18 = zzghl.zzF(var17_19);
                                                                                        var19_21 = var17_19 & 1048575;
                                                                                        if (var16_18 > 17) break block42;
                                                                                        var13_9 = this.zzc[var8_12 + 2];
                                                                                        var14_13 = 1 << (var13_9 >>> 20);
                                                                                        if ((var13_9 &= 1048575) != var10_15) {
                                                                                            if (var10_15 != 1048575) {
                                                                                                var22_10.putInt(var23_22 /* !! */ , (long)var10_15, var9_14);
                                                                                            }
                                                                                            var9_14 = var22_10.getInt(var23_22 /* !! */ , (long)var13_9);
                                                                                            var10_15 = var13_9;
                                                                                        }
                                                                                        switch (var16_18) {
                                                                                            default: {
                                                                                                var12_8 = var3_3;
                                                                                                if (var15_17 != 3) break block43;
                                                                                                var3_3 = zzgek.zzj((zzghz)this.zzw(var8_12), (byte[])var2_2, (int)var12_8, (int)var4_4, (int)(var11_16 << 3 | 4), (zzgej)var6_6);
                                                                                                if ((var9_14 & var14_13) != 0) break block44;
                                                                                                var22_10.putObject(var23_22 /* !! */ , var19_21, var24_23.zzc);
                                                                                                break block45;
                                                                                            }
                                                                                            case 16: {
                                                                                                if (var15_17 != 0) ** GOTO lbl59
                                                                                                var3_3 = zzgek.zzc(var21_7 /* !! */ , (int)var3_3, (zzgej)var24_23);
                                                                                                var22_10.putLong(var1_1 /* !! */ , var19_21, zzgfc.zzH((long)var24_23.zzb));
                                                                                                ** GOTO lbl123
lbl59:
                                                                                                // 1 sources

                                                                                                var12_8 = var3_3;
                                                                                                break block43;
                                                                                            }
                                                                                            case 15: {
                                                                                                if (var15_17 != 0) ** GOTO lbl110
                                                                                                var3_3 = zzgek.zza(var21_7 /* !! */ , (int)var3_3, (zzgej)var24_23);
                                                                                                var22_10.putInt(var23_22 /* !! */ , var19_21, zzgfc.zzG((int)var24_23.zza));
                                                                                                break block46;
                                                                                            }
                                                                                            case 12: {
                                                                                                if (var15_17 != 0) ** GOTO lbl110
                                                                                                var3_3 = zzgek.zza(var21_7 /* !! */ , (int)var3_3, (zzgej)var24_23);
                                                                                                var13_9 = var24_23.zza;
                                                                                                var24_23 = this.zzy(var8_12);
                                                                                                if (var24_23 == null || var24_23.zza(var13_9)) ** GOTO lbl74
                                                                                                zzghl.zzg(var1_1 /* !! */ ).zzh(var7_11, (Object)((long)var13_9));
                                                                                                break block47;
lbl74:
                                                                                                // 1 sources

                                                                                                var22_10.putInt(var23_22 /* !! */ , var19_21, var13_9);
                                                                                                break block46;
                                                                                            }
                                                                                            case 10: {
                                                                                                if (var15_17 != 2) ** GOTO lbl110
                                                                                                var3_3 = zzgek.zzh(var21_7 /* !! */ , (int)var3_3, (zzgej)var24_23);
                                                                                                var22_10.putObject(var23_22 /* !! */ , var19_21, var24_23.zzc);
                                                                                                break block46;
                                                                                            }
                                                                                            case 9: {
                                                                                                if (var15_17 != 2) ** GOTO lbl110
                                                                                                var3_3 = zzgek.zzi((zzghz)this.zzw(var8_12), var21_7 /* !! */ , (int)var3_3, (int)var12_8, (zzgej)var24_23);
                                                                                                if ((var9_14 & var14_13) == 0) {
                                                                                                    var22_10.putObject(var23_22 /* !! */ , var19_21, var24_23.zzc);
                                                                                                } else {
                                                                                                    var22_10.putObject(var23_22 /* !! */ , var19_21, zzggk.zzi((Object)var22_10.getObject(var23_22 /* !! */ , var19_21), (Object)var24_23.zzc));
                                                                                                }
                                                                                                break block46;
                                                                                            }
                                                                                            case 8: {
                                                                                                if (var15_17 != 2) ** GOTO lbl110
                                                                                                var3_3 = (0x20000000 & var17_19) == 0 ? zzgek.zzf(var21_7 /* !! */ , (int)var3_3, (zzgej)var24_23) : zzgek.zzg(var21_7 /* !! */ , (int)var3_3, (zzgej)var24_23);
                                                                                                var22_10.putObject(var23_22 /* !! */ , var19_21, var24_23.zzc);
                                                                                                break block46;
                                                                                            }
                                                                                            case 7: {
                                                                                                if (var15_17 != 0) ** GOTO lbl110
                                                                                                var3_3 = zzgek.zzc(var21_7 /* !! */ , (int)var3_3, (zzgej)var24_23);
                                                                                                var18_20 = var24_23.zzb != 0L;
                                                                                                zzgiy.zzi(var23_22 /* !! */ , (long)var19_21, (boolean)var18_20);
                                                                                                break block46;
                                                                                            }
                                                                                            case 6: 
                                                                                            case 13: {
                                                                                                if (var15_17 != 5) ** GOTO lbl110
                                                                                                var22_10.putInt(var23_22 /* !! */ , var19_21, zzgek.zzd(var21_7 /* !! */ , (int)var3_3));
                                                                                                var3_3 += 4;
                                                                                                break block46;
                                                                                            }
                                                                                            case 5: 
                                                                                            case 14: {
                                                                                                if (var15_17 != 1) ** GOTO lbl110
                                                                                                var22_10.putLong(var1_1 /* !! */ , var19_21, zzgek.zze(var21_7 /* !! */ , (int)var3_3));
                                                                                                var3_3 += 8;
                                                                                                break block46;
lbl110:
                                                                                                // 8 sources

                                                                                                var12_8 = var3_3;
                                                                                                break block43;
                                                                                            }
                                                                                            case 4: 
                                                                                            case 11: {
                                                                                                var13_9 = var3_3;
                                                                                                if (var15_17 != 0) break block43;
                                                                                                var3_3 = zzgek.zza(var21_7 /* !! */ , (int)var13_9, (zzgej)var24_23);
                                                                                                var22_10.putInt(var23_22 /* !! */ , var19_21, var24_23.zza);
                                                                                                break block46;
                                                                                            }
                                                                                            case 2: 
                                                                                            case 3: {
                                                                                                var13_9 = var3_3;
                                                                                                if (var15_17 != 0) break block43;
                                                                                                var3_3 = zzgek.zzc(var21_7 /* !! */ , (int)var13_9, (zzgej)var24_23);
                                                                                                var22_10.putLong(var1_1 /* !! */ , var19_21, var24_23.zzb);
lbl123:
                                                                                                // 2 sources

                                                                                                var9_14 |= var14_13;
                                                                                                var13_9 = var8_12;
                                                                                                break block48;
                                                                                            }
                                                                                            case 1: {
                                                                                                var13_9 = var3_3;
                                                                                                if (var15_17 != 5) break block43;
                                                                                                zzgiy.zzk(var23_22 /* !! */ , (long)var19_21, (float)Float.intBitsToFloat(zzgek.zzd(var21_7 /* !! */ , (int)var13_9)));
                                                                                                var3_3 = var13_9 + 4;
                                                                                                break block46;
                                                                                            }
                                                                                            case 0: 
                                                                                        }
                                                                                        var13_9 = var3_3;
                                                                                        if (var15_17 != 1) break block43;
                                                                                        zzgiy.zzm(var23_22 /* !! */ , (long)var19_21, (double)Double.longBitsToDouble(zzgek.zze(var21_7 /* !! */ , (int)var13_9)));
                                                                                        var3_3 = var13_9 + 8;
                                                                                    }
                                                                                    var9_14 |= var14_13;
                                                                                    break block47;
                                                                                }
                                                                                var22_10.putObject(var23_22 /* !! */ , var19_21, zzggk.zzi((Object)var22_10.getObject(var23_22 /* !! */ , var19_21), (Object)var24_23.zzc));
                                                                            }
                                                                            var9_14 |= var14_13;
                                                                            var21_7 /* !! */  = var2_2;
                                                                            var12_8 = var4_4;
                                                                        }
                                                                        var13_9 = var8_12;
                                                                    }
                                                                    var13_9 = var8_12;
                                                                    var13_9 = var7_11;
                                                                    break block49;
                                                                }
                                                                var13_9 = var9_14;
                                                                var12_8 = var8_12;
                                                                var8_12 = var7_11;
                                                                var8_12 = var11_16;
                                                                var8_12 = var5_5;
                                                                var9_14 = var3_3;
                                                                var3_3 = var8_12;
                                                                var8_12 = var13_9;
                                                                break block41;
                                                            }
                                                            if (var16_18 != 27) break block50;
                                                            if (var15_17 != 2) break block51;
                                                            var24_23 = (zzggj)var22_10.getObject(var23_22 /* !! */ , var19_21);
                                                            var21_7 /* !! */  = var24_23;
                                                            if (!var24_23.zza()) {
                                                                var12_8 = var24_23.size();
                                                                var12_8 = var12_8 == 0 ? 10 : (var12_8 += var12_8);
                                                                var21_7 /* !! */  = var24_23.zze(var12_8);
                                                                var22_10.putObject(var23_22 /* !! */ , var19_21, var21_7 /* !! */ );
                                                            }
                                                            var23_22 /* !! */  = this.zzw(var8_12);
                                                            var12_8 = var7_11;
                                                            var3_3 = zzgek.zzm(var23_22 /* !! */ , (int)var12_8, (byte[])var2_2, (int)var3_3, (int)var4_4, var21_7 /* !! */ , (zzgej)var6_6);
                                                            var21_7 /* !! */  = var2_2;
                                                            var12_8 = var4_4;
                                                            var13_9 = var8_12;
                                                        }
                                                        var14_13 = var8_12;
                                                        var8_12 = var11_16;
                                                        var13_9 = var5_5;
                                                        continue;
                                                    }
                                                    if (var16_18 > 49) break block52;
                                                    var12_8 = var13_9 = this.zzt(var1_1 /* !! */ , (byte[])var2_2, var3_3, var4_4, var7_11, var11_16, var15_17, var8_12, var17_19, var16_18, var19_21, var6_6);
                                                    if (var13_9 == var3_3) break block53;
                                                    var3_3 = var13_9;
                                                    break block54;
                                                }
                                                if (var16_18 != 50) break block55;
                                                if (var15_17 != 2) break block51;
                                                var12_8 = var13_9 = this.zzu(var1_1 /* !! */ , (byte[])var2_2, var3_3, var4_4, var8_12, var19_21, var6_6);
                                                if (var13_9 == var3_3) break block53;
                                                var3_3 = var13_9;
                                                break block54;
                                            }
                                            var12_8 = var13_9 = this.zzv(var1_1 /* !! */ , (byte[])var2_2, var3_3, var4_4, var7_11, var11_16, var15_17, var17_19, var16_18, var19_21, var8_12, var6_6);
                                            if (var13_9 == var3_3) break block53;
                                            var3_3 = var13_9;
                                        }
                                        var21_7 /* !! */  = var1_1 /* !! */ ;
                                        var21_7 /* !! */  = var2_2;
                                        var12_8 = var4_4;
                                        var13_9 = var5_5;
                                        var23_22 /* !! */  = var6_6;
                                        var14_13 = var8_12;
                                        var8_12 = var11_16;
                                        continue;
                                    }
                                    var3_3 = var12_8;
                                }
                                var12_8 = var11_16;
                                var12_8 = var8_12;
                                var8_12 = var9_14;
                                var13_9 = var5_5;
                                var9_14 = var7_11;
                                var9_14 = var3_3;
                                var3_3 = var13_9;
                            }
                            var14_13 = var11_16;
                            var11_16 = var7_11;
                            if (var11_16 == var3_3 && var3_3 != 0) {
                                var2_2 = this;
                                var5_5 = var9_14;
                                var7_11 = var11_16;
                                var9_14 = var8_12;
                                var8_12 = var3_3;
                                break block39;
                            }
                            if (this.zzh && var6_6.zzd != zzgfm.zza()) {
                                var21_7 /* !! */  = this.zzg;
                                if (var6_6.zzd.zzc(var21_7 /* !! */ , var14_13) != null) {
                                    var1_1 /* !! */  = (zzgfx)var1_1 /* !! */ ;
                                    throw null;
                                }
                                var7_11 = zzgek.zzn((int)var11_16, (byte[])var2_2, (int)var9_14, (int)var4_4, (zzgip)zzghl.zzg(var1_1 /* !! */ ), (zzgej)var6_6);
                            } else {
                                var7_11 = zzgek.zzn((int)var11_16, (byte[])var2_2, (int)var9_14, (int)var4_4, (zzgip)zzghl.zzg(var1_1 /* !! */ ), (zzgej)var6_6);
                            }
                            var15_17 = var4_4;
                            var21_7 /* !! */  = var6_6;
                            var21_7 /* !! */  = var1_1 /* !! */ ;
                            var9_14 = var8_12;
                            var21_7 /* !! */  = var2_2;
                            var13_9 = var3_3;
                            var3_3 = var7_11;
                            var7_11 = var11_16;
                            var8_12 = var14_13;
                            var14_13 = var12_8;
                            var12_8 = var15_17;
                        }
                        var8_12 = var13_9;
                        var1_1 /* !! */  = var23_22 /* !! */ ;
                        var2_2 = this;
                        var5_5 = var3_3;
                    }
                    var2_2 = this;
                    if (var10_15 != 1048575) {
                        var22_10.putInt(var1_1 /* !! */ , (long)var10_15, var9_14);
                    }
                    for (var3_3 = var2_2.zzl; var3_3 < var2_2.zzm; ++var3_3) {
                        super.zzA(var1_1 /* !! */ , var2_2.zzk[var3_3], null, var2_2.zzo);
                    }
                    if (var8_12 != 0) break block56;
                    if (var5_5 != var4_4) throw zzggm.zzk();
                    break block57;
                }
                if (var5_5 > var4_4 || var7_11 != var8_12) break block58;
            }
            return var5_5;
        }
        var1_1 /* !! */  = zzggm.zzk();
        throw var1_1 /* !! */ ;
    }

    public final void zzi(T t, byte[] byArray, int n, int n2, zzgej zzgej2) throws IOException {
        if (this.zzj) {
            this.zzz(t, byArray, n, n2, zzgej2);
            return;
        }
        this.zzh(t, byArray, n, n2, 0, zzgej2);
    }

    public final void zzj(T t) {
        int n;
        int n2;
        for (n2 = this.zzl; n2 < (n = this.zzm); ++n2) {
            long l = this.zzD(this.zzk[n2]) & 0xFFFFF;
            Object object = zzgiy.zzn(t, (long)l);
            if (object == null) continue;
            ((zzghc)object).zzd();
            zzgiy.zzo(t, (long)l, (Object)object);
        }
        int n3 = this.zzk.length;
        n2 = n;
        while (true) {
            if (n2 >= n3) {
                this.zzo.zzm(t);
                if (!this.zzh) return;
                this.zzp.zzd(t);
                return;
            }
            this.zzn.zzb(t, (long)this.zzk[n2]);
            ++n2;
        }
    }

    public final boolean zzk(T object) {
        int n = 1048575;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            block13: {
                zzghz zzghz2;
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
                                    if (n3 >= this.zzl) break block9;
                                    n7 = this.zzk[n3];
                                    n8 = this.zzc[n7];
                                    n6 = this.zzD(n7);
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
                                        if (!this.zzN(object, n7, n, n2, n5)) return false;
                                    }
                                    if ((n4 = zzghl.zzF(n6)) == 9 || n4 == 17) break block10;
                                    if (n4 == 27) break block11;
                                    if (n4 == 60 || n4 == 68) break block12;
                                    if (n4 == 49) break block11;
                                    if (n4 == 50 && !((zzghc)zzgiy.zzn(object, (long)(n6 & 0xFFFFF))).isEmpty()) {
                                        object = (zzghb)this.zzx(n7);
                                        throw null;
                                    }
                                    break block13;
                                }
                                if (this.zzQ(object, n8, n7) && !zzghl.zzB(object, n6, this.zzw(n7))) {
                                    return false;
                                }
                                break block13;
                            }
                            if ((list = (List)zzgiy.zzn(object, (long)(n6 & 0xFFFFF))).isEmpty()) break block13;
                            zzghz2 = this.zzw(n7);
                            break block14;
                        }
                        if (this.zzN(object, n7, n, n2, n5) && !zzghl.zzB(object, n6, this.zzw(n7))) {
                            return false;
                        }
                        break block13;
                    }
                    if (!this.zzh) {
                        return true;
                    }
                    this.zzp.zzb(object);
                    throw null;
                }
                for (n4 = 0; n4 < list.size(); ++n4) {
                    if (zzghz2.zzk(list.get(n4))) continue;
                    return false;
                }
            }
            ++n3;
        }
    }

    public final void zzn(T t, zzgfi zzgfi2) throws IOException {
        if (!this.zzj) {
            this.zzV(t, zzgfi2);
            return;
        }
        if (this.zzh) {
            this.zzp.zzb(t);
            throw null;
        }
        int n = this.zzc.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                zzgio<?, ?> zzgio2 = this.zzo;
                zzgio2.zzr(zzgio2.zzj(t), zzgfi2);
                return;
            }
            int n3 = this.zzD(n2);
            int n4 = this.zzc[n2];
            switch (zzghl.zzF(n3)) {
                default: {
                    break;
                }
                case 68: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzs(n4, zzgiy.zzn(t, (long)(n3 & 0xFFFFF)), this.zzw(n2));
                    break;
                }
                case 67: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzq(n4, zzghl.zzK(t, n3 & 0xFFFFF));
                    break;
                }
                case 66: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzp(n4, zzghl.zzJ(t, n3 & 0xFFFFF));
                    break;
                }
                case 65: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzd(n4, zzghl.zzK(t, n3 & 0xFFFFF));
                    break;
                }
                case 64: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzb(n4, zzghl.zzJ(t, n3 & 0xFFFFF));
                    break;
                }
                case 63: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzg(n4, zzghl.zzJ(t, n3 & 0xFFFFF));
                    break;
                }
                case 62: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzo(n4, zzghl.zzJ(t, n3 & 0xFFFFF));
                    break;
                }
                case 61: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzn(n4, (zzgex)zzgiy.zzn(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 60: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzr(n4, zzgiy.zzn(t, (long)(n3 & 0xFFFFF)), this.zzw(n2));
                    break;
                }
                case 59: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzghl.zzX(n4, zzgiy.zzn(t, (long)(n3 & 0xFFFFF)), zzgfi2);
                    break;
                }
                case 58: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzl(n4, zzghl.zzL(t, n3 & 0xFFFFF));
                    break;
                }
                case 57: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzk(n4, zzghl.zzJ(t, n3 & 0xFFFFF));
                    break;
                }
                case 56: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzj(n4, zzghl.zzK(t, n3 & 0xFFFFF));
                    break;
                }
                case 55: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzi(n4, zzghl.zzJ(t, n3 & 0xFFFFF));
                    break;
                }
                case 54: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzh(n4, zzghl.zzK(t, n3 & 0xFFFFF));
                    break;
                }
                case 53: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzc(n4, zzghl.zzK(t, n3 & 0xFFFFF));
                    break;
                }
                case 52: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zze(n4, zzghl.zzI(t, n3 & 0xFFFFF));
                    break;
                }
                case 51: {
                    if (!this.zzQ(t, n4, n2)) break;
                    zzgfi2.zzf(n4, zzghl.zzH(t, n3 & 0xFFFFF));
                    break;
                }
                case 50: {
                    this.zzW(zzgfi2, n4, zzgiy.zzn(t, (long)(n3 & 0xFFFFF)), n2);
                    break;
                }
                case 49: {
                    zzgib.zzaa((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (zzghz)this.zzw(n2));
                    break;
                }
                case 48: {
                    zzgib.zzN((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)true);
                    break;
                }
                case 47: {
                    zzgib.zzS((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)true);
                    break;
                }
                case 46: {
                    zzgib.zzP((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)true);
                    break;
                }
                case 45: {
                    zzgib.zzU((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)true);
                    break;
                }
                case 44: {
                    zzgib.zzV((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)true);
                    break;
                }
                case 43: {
                    zzgib.zzR((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)true);
                    break;
                }
                case 42: {
                    zzgib.zzW((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)true);
                    break;
                }
                case 41: {
                    zzgib.zzT((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)true);
                    break;
                }
                case 40: {
                    zzgib.zzO((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)true);
                    break;
                }
                case 39: {
                    zzgib.zzQ((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)true);
                    break;
                }
                case 38: {
                    zzgib.zzM((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)true);
                    break;
                }
                case 37: {
                    zzgib.zzL((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)true);
                    break;
                }
                case 36: {
                    zzgib.zzK((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)true);
                    break;
                }
                case 35: {
                    zzgib.zzJ((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)true);
                    break;
                }
                case 34: {
                    zzgib.zzN((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)false);
                    break;
                }
                case 33: {
                    zzgib.zzS((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)false);
                    break;
                }
                case 32: {
                    zzgib.zzP((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)false);
                    break;
                }
                case 31: {
                    zzgib.zzU((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)false);
                    break;
                }
                case 30: {
                    zzgib.zzV((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)false);
                    break;
                }
                case 29: {
                    zzgib.zzR((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)false);
                    break;
                }
                case 28: {
                    zzgib.zzY((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2);
                    break;
                }
                case 27: {
                    zzgib.zzZ((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (zzghz)this.zzw(n2));
                    break;
                }
                case 26: {
                    zzgib.zzX((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2);
                    break;
                }
                case 25: {
                    zzgib.zzW((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)false);
                    break;
                }
                case 24: {
                    zzgib.zzT((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)false);
                    break;
                }
                case 23: {
                    zzgib.zzO((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)false);
                    break;
                }
                case 22: {
                    zzgib.zzQ((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)false);
                    break;
                }
                case 21: {
                    zzgib.zzM((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)false);
                    break;
                }
                case 20: {
                    zzgib.zzL((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)false);
                    break;
                }
                case 19: {
                    zzgib.zzK((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)false);
                    break;
                }
                case 18: {
                    zzgib.zzJ((int)this.zzc[n2], (List)((List)zzgiy.zzn(t, (long)(n3 & 0xFFFFF))), (zzgfi)zzgfi2, (boolean)false);
                    break;
                }
                case 17: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzs(n4, zzgiy.zzn(t, (long)(n3 & 0xFFFFF)), this.zzw(n2));
                    break;
                }
                case 16: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzq(n4, zzgiy.zzf(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 15: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzp(n4, zzgiy.zzd(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 14: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzd(n4, zzgiy.zzf(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 13: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzb(n4, zzgiy.zzd(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 12: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzg(n4, zzgiy.zzd(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 11: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzo(n4, zzgiy.zzd(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 10: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzn(n4, (zzgex)zzgiy.zzn(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 9: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzr(n4, zzgiy.zzn(t, (long)(n3 & 0xFFFFF)), this.zzw(n2));
                    break;
                }
                case 8: {
                    if (!this.zzO(t, n2)) break;
                    zzghl.zzX(n4, zzgiy.zzn(t, (long)(n3 & 0xFFFFF)), zzgfi2);
                    break;
                }
                case 7: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzl(n4, zzgiy.zzh(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 6: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzk(n4, zzgiy.zzd(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 5: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzj(n4, zzgiy.zzf(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 4: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzi(n4, zzgiy.zzd(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 3: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzh(n4, zzgiy.zzf(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 2: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzc(n4, zzgiy.zzf(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 1: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zze(n4, zzgiy.zzj(t, (long)(n3 & 0xFFFFF)));
                    break;
                }
                case 0: {
                    if (!this.zzO(t, n2)) break;
                    zzgfi2.zzf(n4, zzgiy.zzl(t, (long)(n3 & 0xFFFFF)));
                }
            }
            n2 += 3;
        }
    }
}
