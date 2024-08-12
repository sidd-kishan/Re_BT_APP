/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfa
 *  com.google.android.gms.internal.ads.zzgfc
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzgiy
 *  com.google.android.gms.internal.ads.zzgjd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfa;
import com.google.android.gms.internal.ads.zzgfc;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzgiy;
import com.google.android.gms.internal.ads.zzgjd;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

final class zzgez
extends zzgfc {
    private final Iterable<ByteBuffer> zze;
    private final Iterator<ByteBuffer> zzf;
    private ByteBuffer zzg;
    private int zzh;
    private int zzi;
    private int zzj = Integer.MAX_VALUE;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzgez(Iterable iterable, int n, boolean bl, zzgfa zzgfa2) {
        super(null);
        this.zzh = n;
        this.zze = iterable;
        this.zzf = iterable.iterator();
        this.zzl = 0;
        if (n == 0) {
            this.zzg = zzggk.zzd;
            this.zzm = 0L;
            this.zzn = 0L;
            this.zzo = 0L;
            return;
        }
        this.zzJ();
    }

    private final void zzI() throws zzggm {
        if (!this.zzf.hasNext()) throw zzggm.zzd();
        this.zzJ();
    }

    private final void zzJ() {
        long l;
        ByteBuffer byteBuffer;
        this.zzg = byteBuffer = this.zzf.next();
        this.zzl += (int)(this.zzm - this.zzn);
        this.zzm = l = (long)byteBuffer.position();
        this.zzn = l;
        this.zzo = this.zzg.limit();
        l = zzgiy.zzs((ByteBuffer)this.zzg);
        this.zzm += l;
        this.zzn += l;
        this.zzo += l;
    }

    private final void zzK() {
        int n;
        this.zzh = n = this.zzh + this.zzi;
        int n2 = this.zzj;
        if (n > n2) {
            this.zzi = n2 = n - n2;
            this.zzh = n - n2;
            return;
        }
        this.zzi = 0;
    }

    private final void zzL(byte[] object, int n, int n2) throws IOException {
        if (n2 <= this.zzM()) {
            n = n2;
            while (n > 0) {
                if (this.zzo - this.zzm == 0L) {
                    this.zzI();
                }
                int n3 = Math.min(n, (int)(this.zzo - this.zzm));
                long l = n3;
                zzgiy.zzq((long)this.zzm, (byte[])object, (long)(n2 - n), (long)l);
                n -= n3;
                this.zzm += l;
            }
            return;
        }
        if (n2 <= 0) {
            return;
        }
        object = zzggm.zzd();
        throw object;
    }

    private final int zzM() {
        return (int)((long)(this.zzh - this.zzl) - this.zzm + this.zzn);
    }

    public final void zzA(int n) {
        this.zzj = n;
        this.zzK();
    }

    public final boolean zzB() throws IOException {
        if ((long)this.zzl + this.zzm - this.zzn != (long)this.zzh) return false;
        return true;
    }

    public final int zzC() {
        return (int)((long)this.zzl + this.zzm - this.zzn);
    }

    public final byte zzD() throws IOException {
        if (this.zzo - this.zzm == 0L) {
            this.zzI();
        }
        long l = this.zzm;
        this.zzm = 1L + l;
        return zzgiy.zzr((long)l);
    }

    public final void zzE(int n) throws IOException {
        if (n >= 0 && (long)n <= (long)(this.zzh - this.zzl) - this.zzm + this.zzn) {
            while (n > 0) {
                if (this.zzo - this.zzm == 0L) {
                    this.zzI();
                }
                int n2 = Math.min(n, (int)(this.zzo - this.zzm));
                n -= n2;
                this.zzm += (long)n2;
            }
            return;
        }
        if (n < 0) {
            throw zzggm.zze();
        }
        zzggm zzggm2 = zzggm.zzd();
        throw zzggm2;
    }

    public final int zza() throws IOException {
        int n;
        if (this.zzB()) {
            this.zzk = 0;
            return 0;
        }
        this.zzk = n = this.zzu();
        if (n >>> 3 == 0) throw zzggm.zzg();
        return n;
    }

    public final void zzb(int n) throws zzggm {
        if (this.zzk != n) throw zzggm.zzh();
    }

    public final boolean zzc(int n) throws IOException {
        int n2 = n & 7;
        int n3 = 0;
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
            while ((n3 = this.zza()) != 0 && this.zzc(n3)) {
            }
            this.zzb(n >>> 3 << 3 | 4);
            return true;
        }
        while (true) {
            if (n3 >= 10) {
                zzggm zzggm2 = zzggm.zzf();
                throw zzggm2;
            }
            if (this.zzD() >= 0) {
                return true;
            }
            ++n3;
        }
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
        long l;
        long l2;
        long l3;
        int n = this.zzu();
        if (n > 0 && (l3 = (long)n) <= (l2 = this.zzo) - (l = this.zzm)) {
            Object object = new byte[n];
            zzgiy.zzq((long)l, (byte[])object, (long)0L, (long)l3);
            object = new String((byte[])object, zzggk.zza);
            this.zzm += l3;
            return object;
        }
        if (n > 0 && n <= this.zzM()) {
            byte[] byArray = new byte[n];
            this.zzL(byArray, 0, n);
            return new String(byArray, zzggk.zza);
        }
        if (n == 0) {
            return "";
        }
        if (n >= 0) throw zzggm.zzd();
        throw zzggm.zze();
    }

    public final String zzm() throws IOException {
        long l;
        long l2;
        long l3;
        int n = this.zzu();
        if (n > 0 && (l3 = (long)n) <= (l2 = this.zzo) - (l = this.zzm)) {
            l2 = this.zzn;
            String string = zzgjd.zzi((ByteBuffer)this.zzg, (int)((int)(l - l2)), (int)n);
            this.zzm += l3;
            return string;
        }
        if (n >= 0 && n <= this.zzM()) {
            byte[] byArray = new byte[n];
            this.zzL(byArray, 0, n);
            return zzgjd.zzj((byte[])byArray, (int)0, (int)n);
        }
        if (n == 0) {
            return "";
        }
        if (n > 0) throw zzggm.zzd();
        throw zzggm.zze();
    }

    public final zzgex zzn() throws IOException {
        long l;
        long l2;
        long l3;
        int n = this.zzu();
        if (n > 0 && (l3 = (long)n) <= (l2 = this.zzo) - (l = this.zzm)) {
            byte[] byArray = new byte[n];
            zzgiy.zzq((long)l, (byte[])byArray, (long)0L, (long)l3);
            this.zzm += l3;
            return zzgex.zzu((byte[])byArray);
        }
        if (n > 0 && n <= this.zzM()) {
            byte[] byArray = new byte[n];
            this.zzL(byArray, 0, n);
            return zzgex.zzu((byte[])byArray);
        }
        if (n == 0) {
            return zzgex.zzb;
        }
        if (n >= 0) throw zzggm.zzd();
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
        return zzgez.zzG((int)this.zzu());
    }

    public final long zzt() throws IOException {
        return zzgez.zzH((long)this.zzv());
    }

    public final int zzu() throws IOException {
        long l;
        if (this.zzo == (l = this.zzm++)) {
            return (int)this.zzw();
        }
        long l2 = l + 1L;
        int n = zzgiy.zzr((long)l);
        if (n >= 0) {
            return n;
        }
        if (this.zzo - this.zzm < 10L) return (int)this.zzw();
        l = l2 + 1L;
        if ((n ^= zzgiy.zzr((long)l2) << 7) < 0) {
            n ^= 0xFFFFFF80;
        } else {
            l2 = l + 1L;
            if ((n ^= zzgiy.zzr((long)l) << 14) >= 0) {
                n ^= 0x3F80;
                l = l2;
            } else {
                l = l2 + 1L;
                if ((n ^= zzgiy.zzr((long)l2) << 21) < 0) {
                    n ^= 0xFFE03F80;
                } else {
                    int n2;
                    l2 = l + 1L;
                    byte by = zzgiy.zzr((long)l);
                    n = n2 = n ^ by << 28 ^ 0xFE03F80;
                    l = l2;
                    if (by < 0) {
                        long l3 = l2 + 1L;
                        n = n2;
                        l = l3;
                        if (zzgiy.zzr((long)l2) < 0) {
                            l2 = l3 + 1L;
                            n = n2;
                            l = l2;
                            if (zzgiy.zzr((long)l3) < 0) {
                                l3 = l2 + 1L;
                                n = n2;
                                l = l3;
                                if (zzgiy.zzr((long)l2) < 0) {
                                    l2 = l3 + 1L;
                                    n = n2;
                                    l = l2;
                                    if (zzgiy.zzr((long)l3) < 0) {
                                        l = l2 + 1L;
                                        if (zzgiy.zzr((long)l2) < 0) return (int)this.zzw();
                                        n = n2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.zzm = l;
        return n;
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
                                    if (this.zzo == (var2_1 = this.zzm++)) {
                                        return this.zzw();
                                    }
                                    var4_2 = var2_1 + 1L;
                                    var1_3 = zzgiy.zzr((long)var2_1);
                                    if (var1_3 >= 0) {
                                        return var1_3;
                                    }
                                    if (this.zzo - this.zzm < 10L) return this.zzw();
                                    var2_1 = var4_2 + 1L;
                                    if ((var1_3 ^= zzgiy.zzr((long)var4_2) << 7) >= 0) break block7;
                                    var1_3 ^= -128;
                                    var4_2 = var2_1;
                                    break block8;
                                }
                                var4_2 = var2_1 + 1L;
                                if ((var1_3 ^= zzgiy.zzr((long)var2_1) << 14) < 0) break block9;
                                var2_1 = var1_3 ^ 16256;
                                break block10;
                            }
                            var2_1 = var4_2 + 1L;
                            if ((var1_3 ^= zzgiy.zzr((long)var4_2) << 21) >= 0) break block11;
                            var1_3 ^= -2080896;
                            var4_2 = var2_1;
                        }
                        var2_1 = var1_3;
                        break block10;
                    }
                    var4_2 = var2_1 + 1L;
                    var6_4 = (long)var1_3 ^ (long)zzgiy.zzr((long)var2_1) << 28;
                    if (var6_4 < 0L) break block12;
                    var2_1 = 266354560L;
                    ** GOTO lbl44
                }
                var2_1 = var4_2 + 1L;
                var8_5 = var6_4 ^ (long)zzgiy.zzr((long)var4_2) << 35;
                if (var8_5 >= 0L) break block13;
                var6_4 = -34093383808L;
                var4_2 = var8_5;
                ** GOTO lbl49
            }
            var4_2 = var2_1 + 1L;
            var6_4 = var8_5 ^ (long)zzgiy.zzr((long)var2_1) << 42;
            if (var6_4 >= 0L) {
                var2_1 = 4363953127296L;
lbl44:
                // 2 sources

                var2_1 = var6_4 ^ var2_1;
            } else {
                var2_1 = var4_2 + 1L;
                if ((var4_2 = var6_4 ^ (long)zzgiy.zzr((long)var4_2) << 49) < 0L) {
                    var6_4 = -558586000294016L;
lbl49:
                    // 2 sources

                    var6_4 = var4_2 ^ var6_4;
                    var4_2 = var2_1;
                    var2_1 = var6_4;
                } else {
                    var8_5 = var2_1 + 1L;
                    var2_1 = var6_4 = var4_2 ^ (long)zzgiy.zzr((long)var2_1) << 56 ^ 71499008037633920L;
                    var4_2 = var8_5;
                    if (var6_4 < 0L) {
                        if ((long)zzgiy.zzr((long)var8_5) < 0L) return this.zzw();
                        var4_2 = 1L + var8_5;
                        var2_1 = var6_4;
                    }
                }
            }
        }
        this.zzm = var4_2;
        return var2_1;
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
        byte by;
        int n;
        long l = this.zzo;
        long l2 = this.zzm;
        if (l - l2 >= 4L) {
            this.zzm = 4L + l2;
            n = zzgiy.zzr((long)l2) & 0xFF | (zzgiy.zzr((long)(1L + l2)) & 0xFF) << 8 | (zzgiy.zzr((long)(2L + l2)) & 0xFF) << 16;
            by = zzgiy.zzr((long)(l2 + 3L));
        } else {
            n = this.zzD() & 0xFF | (this.zzD() & 0xFF) << 8 | (this.zzD() & 0xFF) << 16;
            by = this.zzD();
        }
        return n | (by & 0xFF) << 24;
    }

    public final long zzy() throws IOException {
        byte by;
        long l = this.zzo;
        long l2 = this.zzm;
        if (l - l2 >= 8L) {
            this.zzm = 8L + l2;
            l = (long)zzgiy.zzr((long)l2) & 0xFFL | ((long)zzgiy.zzr((long)(1L + l2)) & 0xFFL) << 8 | ((long)zzgiy.zzr((long)(2L + l2)) & 0xFFL) << 16 | ((long)zzgiy.zzr((long)(3L + l2)) & 0xFFL) << 24 | ((long)zzgiy.zzr((long)(4L + l2)) & 0xFFL) << 32 | ((long)zzgiy.zzr((long)(5L + l2)) & 0xFFL) << 40 | ((long)zzgiy.zzr((long)(6L + l2)) & 0xFFL) << 48;
            by = zzgiy.zzr((long)(l2 + 7L));
        } else {
            l = (long)this.zzD() & 0xFFL | ((long)this.zzD() & 0xFFL) << 8 | ((long)this.zzD() & 0xFFL) << 16 | ((long)this.zzD() & 0xFFL) << 24 | ((long)this.zzD() & 0xFFL) << 32 | ((long)this.zzD() & 0xFFL) << 40 | ((long)this.zzD() & 0xFFL) << 48;
            by = this.zzD();
        }
        return l | ((long)by & 0xFFL) << 56;
    }

    public final int zzz(int n) throws zzggm {
        if (n < 0) throw zzggm.zze();
        int n2 = n + this.zzC();
        if (n2 > (n = this.zzj)) throw zzggm.zzd();
        this.zzj = n2;
        this.zzK();
        return n;
    }
}
