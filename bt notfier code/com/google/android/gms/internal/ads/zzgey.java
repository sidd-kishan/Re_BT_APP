/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfa
 *  com.google.android.gms.internal.ads.zzgfc
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzgjd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfa;
import com.google.android.gms.internal.ads.zzgfc;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzgjd;
import java.io.IOException;
import java.util.Arrays;

final class zzgey
extends zzgfc {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final int zzi;
    private int zzj;
    private int zzk = Integer.MAX_VALUE;

    /* synthetic */ zzgey(byte[] byArray, int n, int n2, boolean bl, zzgfa zzgfa2) {
        super(null);
        this.zze = byArray;
        this.zzf = n2 + n;
        this.zzh = n;
        this.zzi = n;
    }

    private final void zzI() {
        int n;
        this.zzf = n = this.zzf + this.zzg;
        int n2 = n - this.zzi;
        int n3 = this.zzk;
        if (n2 > n3) {
            this.zzg = n2 -= n3;
            this.zzf = n - n2;
            return;
        }
        this.zzg = 0;
    }

    public final void zzA(int n) {
        this.zzk = n;
        this.zzI();
    }

    public final boolean zzB() throws IOException {
        if (this.zzh != this.zzf) return false;
        return true;
    }

    public final int zzC() {
        return this.zzh - this.zzi;
    }

    public final byte zzD() throws IOException {
        int n = this.zzh;
        if (n == this.zzf) throw zzggm.zzd();
        byte[] byArray = this.zze;
        this.zzh = n + 1;
        return byArray[n];
    }

    public final void zzE(int n) throws IOException {
        int n2;
        int n3;
        if (n >= 0 && n <= (n3 = this.zzf) - (n2 = this.zzh)) {
            this.zzh = n2 + n;
            return;
        }
        if (n >= 0) throw zzggm.zzd();
        throw zzggm.zze();
    }

    public final int zza() throws IOException {
        int n;
        if (this.zzB()) {
            this.zzj = 0;
            return 0;
        }
        this.zzj = n = this.zzu();
        if (n >>> 3 == 0) throw zzggm.zzg();
        return n;
    }

    public final void zzb(int n) throws zzggm {
        if (this.zzj != n) throw zzggm.zzh();
    }

    public final boolean zzc(int n) throws IOException {
        int n2 = n & 7;
        int n3 = 0;
        int n4 = 0;
        if (n2 != 0) {
            if (n2 == 1) {
                this.zzE(8);
                return true;
            }
            if (n2 == 2) {
                this.zzE(this.zzu());
                return true;
            }
            if (n2 != 3) {
                if (n2 == 4) return false;
                if (n2 != 5) throw zzggm.zzi();
                this.zzE(4);
                return true;
            }
            while ((n4 = this.zza()) != 0 && this.zzc(n4)) {
            }
            this.zzb(n >>> 3 << 3 | 4);
            return true;
        }
        n = n3;
        if (this.zzf - this.zzh < 10) {
            while (true) {
                if (n >= 10) {
                    zzggm zzggm2 = zzggm.zzf();
                    throw zzggm2;
                }
                if (this.zzD() >= 0) return true;
                ++n;
            }
        }
        n = n4;
        while (n < 10) {
            byte[] byArray = this.zze;
            n4 = this.zzh;
            this.zzh = n4 + 1;
            if (byArray[n4] >= 0) {
                return true;
            }
            ++n;
        }
        throw zzggm.zzf();
    }

    public final double zzd() throws IOException {
        return Double.longBitsToDouble(this.zzy());
    }

    public final float zze() throws IOException {
        return Float.intBitsToFloat(this.zzx());
    }

    public final long zzf() throws IOException {
        return this.zzv();
    }

    public final long zzg() throws IOException {
        return this.zzv();
    }

    public final int zzh() throws IOException {
        return this.zzu();
    }

    public final long zzi() throws IOException {
        return this.zzy();
    }

    public final int zzj() throws IOException {
        return this.zzx();
    }

    public final boolean zzk() throws IOException {
        if (this.zzv() == 0L) return false;
        return true;
    }

    public final String zzl() throws IOException {
        int n;
        int n2;
        int n3 = this.zzu();
        if (n3 > 0 && n3 <= (n2 = this.zzf) - (n = this.zzh)) {
            String string = new String(this.zze, n, n3, zzggk.zza);
            this.zzh += n3;
            return string;
        }
        if (n3 == 0) {
            return "";
        }
        if (n3 >= 0) throw zzggm.zzd();
        throw zzggm.zze();
    }

    public final String zzm() throws IOException {
        int n;
        int n2;
        int n3 = this.zzu();
        if (n3 > 0 && n3 <= (n2 = this.zzf) - (n = this.zzh)) {
            String string = zzgjd.zzj((byte[])this.zze, (int)n, (int)n3);
            this.zzh += n3;
            return string;
        }
        if (n3 == 0) {
            return "";
        }
        if (n3 > 0) throw zzggm.zzd();
        throw zzggm.zze();
    }

    public final zzgex zzn() throws IOException {
        int n;
        int n2;
        int n3 = this.zzu();
        if (n3 > 0 && n3 <= (n2 = this.zzf) - (n = this.zzh)) {
            zzgex zzgex2 = zzgex.zzs((byte[])this.zze, (int)n, (int)n3);
            this.zzh += n3;
            return zzgex2;
        }
        if (n3 == 0) return zzgex.zzb;
        if (n3 > 0 && n3 <= (n = this.zzf) - (n2 = this.zzh)) {
            this.zzh = n3 += n2;
            return zzgex.zzu((byte[])Arrays.copyOfRange(this.zze, n2, n3));
        }
        if (n3 > 0) throw zzggm.zzd();
        throw zzggm.zze();
    }

    public final int zzo() throws IOException {
        return this.zzu();
    }

    public final int zzp() throws IOException {
        return this.zzu();
    }

    public final int zzq() throws IOException {
        return this.zzx();
    }

    public final long zzr() throws IOException {
        return this.zzy();
    }

    public final int zzs() throws IOException {
        return zzgey.zzG((int)this.zzu());
    }

    public final long zzt() throws IOException {
        return zzgey.zzH((long)this.zzv());
    }

    public final int zzu() throws IOException {
        int n = this.zzf;
        int n2 = this.zzh;
        if (n == n2) {
            return (int)this.zzw();
        }
        byte[] byArray = this.zze;
        int n3 = n2 + 1;
        if ((n2 = byArray[n2]) >= 0) {
            this.zzh = n3;
            return n2;
        }
        if (n - n3 < 9) return (int)this.zzw();
        n = n3 + 1;
        if ((n2 ^= byArray[n3] << 7) < 0) {
            n3 = n2 ^ 0xFFFFFF80;
        } else {
            n3 = n + 1;
            if ((n2 ^= byArray[n] << 14) >= 0) {
                n = n3;
                n3 = n2 ^= 0x3F80;
            } else {
                n = n3 + 1;
                if ((n3 = n2 ^ byArray[n3] << 21) < 0) {
                    n3 ^= 0xFFE03F80;
                } else {
                    int n4 = n + 1;
                    int n5 = byArray[n];
                    n3 = n2 = n3 ^ n5 << 28 ^ 0xFE03F80;
                    n = n4;
                    if (n5 < 0) {
                        n5 = n4 + 1;
                        n3 = n2;
                        n = n5;
                        if (byArray[n4] < 0) {
                            n4 = n5 + 1;
                            n3 = n2;
                            n = n4;
                            if (byArray[n5] < 0) {
                                n5 = n4 + 1;
                                n3 = n2;
                                n = n5;
                                if (byArray[n4] < 0) {
                                    n4 = n5 + 1;
                                    n3 = n2;
                                    n = n4;
                                    if (byArray[n5] < 0) {
                                        n = n4 + 1;
                                        if (byArray[n4] < 0) return (int)this.zzw();
                                        n3 = n2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.zzh = n;
        return n3;
    }

    /*
     * Unable to fully structure code
     */
    public final long zzv() throws IOException {
        block10: {
            block13: {
                block12: {
                    block11: {
                        block8: {
                            block9: {
                                block7: {
                                    var1_2 = this.zzf;
                                    var3_1 = this.zzh;
                                    if (var1_2 == var3_1) {
                                        return this.zzw();
                                    }
                                    var8_3 = this.zze;
                                    var2_4 = var3_1 + 1;
                                    if ((var3_1 = var8_3[var3_1]) >= 0) {
                                        this.zzh = var2_4;
                                        return var3_1;
                                    }
                                    if (var1_2 - var2_4 < 9) return this.zzw();
                                    var1_2 = var2_4 + 1;
                                    if ((var3_1 ^= var8_3[var2_4] << 7) >= 0) break block7;
                                    var2_4 = var3_1 ^ -128;
                                    break block8;
                                }
                                var2_4 = var1_2 + 1;
                                if ((var3_1 ^= var8_3[var1_2] << 14) < 0) break block9;
                                var4_5 = var3_1 ^ 16256;
                                var1_2 = var2_4;
                                break block10;
                            }
                            var1_2 = var2_4 + 1;
                            if ((var3_1 ^= var8_3[var2_4] << 21) >= 0) break block11;
                            var2_4 = var3_1 ^ -2080896;
                        }
                        var4_5 = var2_4;
                        break block10;
                    }
                    var2_4 = var1_2 + 1;
                    var4_5 = var3_1;
                    var6_6 = (long)var8_3[var1_2] << 28 ^ var4_5;
                    if (var6_6 < 0L) break block12;
                    var4_5 = 266354560L;
                    var1_2 = var2_4;
                    ** GOTO lbl48
                }
                var1_2 = var2_4 + 1;
                var4_5 = var6_6 ^ (long)var8_3[var2_4] << 35;
                if (var4_5 >= 0L) break block13;
                var6_6 = -34093383808L;
                ** GOTO lbl54
            }
            var2_4 = var1_2 + 1;
            var6_6 = var4_5 ^ (long)var8_3[var1_2] << 42;
            if (var6_6 >= 0L) {
                var4_5 = 4363953127296L;
                var1_2 = var2_4;
lbl48:
                // 2 sources

                var4_5 = var6_6 ^ var4_5;
            } else {
                var1_2 = var2_4 + 1;
                var4_5 = var6_6 ^ (long)var8_3[var2_4] << 49;
                if (var4_5 < 0L) {
                    var6_6 = -558586000294016L;
lbl54:
                    // 2 sources

                    var4_5 = var6_6 ^ var4_5;
                } else {
                    var2_4 = var1_2 + 1;
                    var4_5 = var6_6 = var4_5 ^ (long)var8_3[var1_2] << 56 ^ 71499008037633920L;
                    var1_2 = var2_4;
                    if (var6_6 < 0L) {
                        var1_2 = var2_4 + 1;
                        if ((long)var8_3[var2_4] < 0L) return this.zzw();
                        var4_5 = var6_6;
                    }
                }
            }
        }
        this.zzh = var1_2;
        return var4_5;
    }

    final long zzw() throws IOException {
        long l = 0L;
        int n = 0;
        while (true) {
            if (n >= 64) {
                zzggm zzggm2 = zzggm.zzf();
                throw zzggm2;
            }
            byte by = this.zzD();
            l |= (long)(by & 0x7F) << n;
            if ((by & 0x80) == 0) {
                return l;
            }
            n += 7;
        }
    }

    public final int zzx() throws IOException {
        int n = this.zzh;
        if (this.zzf - n < 4) throw zzggm.zzd();
        byte[] byArray = this.zze;
        this.zzh = n + 4;
        byte by = byArray[n];
        byte by2 = byArray[n + 1];
        byte by3 = byArray[n + 2];
        return (byArray[n + 3] & 0xFF) << 24 | (by & 0xFF | (by2 & 0xFF) << 8 | (by3 & 0xFF) << 16);
    }

    public final long zzy() throws IOException {
        int n = this.zzh;
        if (this.zzf - n < 8) throw zzggm.zzd();
        byte[] byArray = this.zze;
        this.zzh = n + 8;
        long l = byArray[n];
        long l2 = byArray[n + 1];
        long l3 = byArray[n + 2];
        long l4 = byArray[n + 3];
        long l5 = byArray[n + 4];
        long l6 = byArray[n + 5];
        long l7 = byArray[n + 6];
        return ((long)byArray[n + 7] & 0xFFL) << 56 | (l & 0xFFL | (l2 & 0xFFL) << 8 | (l3 & 0xFFL) << 16 | (l4 & 0xFFL) << 24 | (l5 & 0xFFL) << 32 | (l6 & 0xFFL) << 40 | (l7 & 0xFFL) << 48);
    }

    public final int zzz(int n) throws zzggm {
        if (n < 0) throw zzggm.zze();
        if ((n += this.zzh - this.zzi) < 0) throw zzggm.zzk();
        int n2 = this.zzk;
        if (n > n2) throw zzggm.zzd();
        this.zzk = n;
        this.zzI();
        return n2;
    }
}
