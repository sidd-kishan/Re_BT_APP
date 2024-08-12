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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class zzgfb
extends zzgfc {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl = Integer.MAX_VALUE;

    /* synthetic */ zzgfb(InputStream inputStream, int n, zzgfa zzgfa2) {
        super(null);
        zzggk.zzb((Object)inputStream, (String)"input");
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final void zzI() {
        int n;
        this.zzg = n = this.zzg + this.zzh;
        int n2 = this.zzk + n;
        int n3 = this.zzl;
        if (n2 > n3) {
            this.zzh = n2 -= n3;
            this.zzg = n - n2;
            return;
        }
        this.zzh = 0;
    }

    private final void zzJ(int n) throws IOException {
        if (this.zzK(n)) return;
        if (n <= Integer.MAX_VALUE - this.zzk - this.zzi) throw zzggm.zzd();
        throw zzggm.zzj();
    }

    private final boolean zzK(int n) throws IOException {
        Object object;
        int n2 = this.zzi;
        int n3 = this.zzg;
        if (n2 + n <= n3) {
            StringBuilder stringBuilder = new StringBuilder(77);
            stringBuilder.append("refillBuffer() called when ");
            stringBuilder.append(n);
            stringBuilder.append(" bytes were already available in buffer");
            throw new IllegalStateException(stringBuilder.toString());
        }
        int n4 = this.zzk;
        if (n > Integer.MAX_VALUE - n4 - n2) {
            return false;
        }
        if (n4 + n2 + n > this.zzl) {
            return false;
        }
        int n5 = n3;
        if (n2 > 0) {
            if (n3 > n2) {
                object = this.zzf;
                System.arraycopy(object, n2, object, 0, n3 - n2);
            }
            this.zzk = n4 = this.zzk + n2;
            this.zzg = n5 = this.zzg - n2;
            this.zzi = 0;
        }
        object = this.zze;
        Object object2 = this.zzf;
        n4 = Math.min(4096 - n5, Integer.MAX_VALUE - n4 - n5);
        try {
            n5 = ((InputStream)object).read((byte[])object2, n5, n4);
            if (n5 != 0 && n5 >= -1 && n5 <= 4096) {
                if (n5 <= 0) return false;
                this.zzg += n5;
                this.zzI();
                if (this.zzg < n) return this.zzK(n);
                return true;
            }
        }
        catch (zzggm zzggm2) {
            zzggm2.zzb();
            throw zzggm2;
        }
        object2 = String.valueOf(this.zze.getClass());
        object = new StringBuilder(String.valueOf(object2).length() + 91);
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("#read(byte[]) returned invalid result: ");
        ((StringBuilder)object).append(n5);
        ((StringBuilder)object).append("\nThe InputStream implementation is buggy.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    private final byte[] zzL(int n, boolean bl) throws IOException {
        byte[] byArray = this.zzM(n);
        if (byArray != null) {
            return byArray;
        }
        int n2 = this.zzi;
        int n3 = this.zzg;
        int n4 = n3 - n2;
        this.zzk += n3;
        this.zzi = 0;
        this.zzg = 0;
        Object object = this.zzN(n - n4);
        byArray = new byte[n];
        System.arraycopy(this.zzf, n2, byArray, 0, n4);
        object = object.iterator();
        n = n4;
        while (object.hasNext()) {
            byte[] byArray2 = (byte[])object.next();
            n4 = byArray2.length;
            System.arraycopy(byArray2, 0, byArray, n, n4);
            n += n4;
        }
        return byArray;
    }

    private final byte[] zzM(int n) throws IOException {
        Object object;
        if (n == 0) {
            return zzggk.zzc;
        }
        if (n < 0) {
            zzggm zzggm2 = zzggm.zze();
            throw zzggm2;
        }
        int n2 = this.zzk;
        int n3 = this.zzi;
        int n4 = n2 + n3 + n;
        if (-2147483647 + n4 > 0) throw zzggm.zzj();
        int n5 = this.zzl;
        if (n4 > n5) {
            this.zzE(n5 - n2 - n3);
            throw zzggm.zzd();
        }
        n5 = this.zzg - n3;
        n2 = n - n5;
        if (n2 >= 4096) {
            object = this.zze;
            try {
                n4 = ((InputStream)object).available();
                if (n2 > n4) return null;
            }
            catch (zzggm zzggm3) {
                zzggm3.zzb();
                throw zzggm3;
            }
        }
        object = new byte[n];
        System.arraycopy(this.zzf, this.zzi, object, 0, n5);
        this.zzk += this.zzg;
        this.zzi = 0;
        this.zzg = 0;
        while (n5 < n) {
            InputStream inputStream = this.zze;
            try {
                n2 = inputStream.read((byte[])object, n5, n - n5);
                if (n2 == -1) throw zzggm.zzd();
                this.zzk += n2;
                n5 += n2;
            }
            catch (zzggm zzggm4) {
                zzggm4.zzb();
                throw zzggm4;
            }
        }
        return object;
    }

    private final List<byte[]> zzN(int n) throws IOException {
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        while (n > 0) {
            int n2;
            int n3 = Math.min(n, 4096);
            byte[] byArray = new byte[n3];
            for (int i = 0; i < n3; this.zzk += n2, i += n2) {
                n2 = this.zze.read(byArray, i, n3 - i);
                if (n2 == -1) throw zzggm.zzd();
            }
            n -= n3;
            arrayList.add(byArray);
        }
        return arrayList;
    }

    public final void zzA(int n) {
        this.zzl = n;
        this.zzI();
    }

    public final boolean zzB() throws IOException {
        if (this.zzi != this.zzg) return false;
        if (this.zzK(1)) return false;
        return true;
    }

    public final int zzC() {
        return this.zzk + this.zzi;
    }

    public final byte zzD() throws IOException {
        if (this.zzi == this.zzg) {
            this.zzJ(1);
        }
        byte[] byArray = this.zzf;
        int n = this.zzi;
        this.zzi = n + 1;
        return byArray[n];
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final void zzE(int n) throws IOException {
        int n2 = this.zzg;
        int n3 = this.zzi;
        if (n <= (n2 -= n3) && n >= 0) {
            this.zzi = n3 + n;
            return;
        }
        if (n < 0) {
            zzggm zzggm2 = zzggm.zze();
            throw zzggm2;
        }
        int n4 = this.zzk;
        int n5 = n4 + n3;
        int n6 = this.zzl;
        if (n5 + n > n6) {
            this.zzE(n6 - n4 - n3);
            throw zzggm.zzd();
        }
        this.zzk = n5;
        this.zzg = 0;
        this.zzi = 0;
        while (n2 < n) {
            Object object;
            try {
                object = this.zze;
            }
            catch (Throwable throwable) {
                this.zzk += n2;
                this.zzI();
                throw throwable;
            }
            long l = n - n2;
            {
                long l2;
                block12: {
                    try {
                        l2 = ((InputStream)object).skip(l);
                        if (l2 < 0L || l2 > l) break block12;
                        if (l2 == 0L) {
                            break;
                        }
                    }
                    catch (zzggm zzggm3) {
                        zzggm3.zzb();
                        throw zzggm3;
                    }
                    n2 += (int)l2;
                    continue;
                }
                object = String.valueOf(this.zze.getClass());
                n = String.valueOf(object).length();
                StringBuilder stringBuilder = new StringBuilder(n + 92);
                stringBuilder.append((String)object);
                stringBuilder.append("#skip returned invalid result: ");
                stringBuilder.append(l2);
                stringBuilder.append("\nThe InputStream implementation is buggy.");
                IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                throw illegalStateException;
            }
        }
        this.zzk += n2;
        this.zzI();
        if (n2 >= n) return;
        n3 = this.zzg;
        n2 = n3 - this.zzi;
        this.zzi = n3;
        this.zzJ(1);
        while (true) {
            if ((n4 = n - n2) <= (n3 = this.zzg)) {
                this.zzi = n4;
                return;
            }
            n2 += n3;
            this.zzi = n3;
            this.zzJ(1);
        }
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
        if (this.zzg - this.zzi < 10) {
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
            byte[] byArray = this.zzf;
            n4 = this.zzi;
            this.zzi = n4 + 1;
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
        if (n3 > 0 && n3 <= (n2 = this.zzg) - (n = this.zzi)) {
            String string = new String(this.zzf, n, n3, zzggk.zza);
            this.zzi += n3;
            return string;
        }
        if (n3 == 0) {
            return "";
        }
        if (n3 > this.zzg) return new String(this.zzL(n3, false), zzggk.zza);
        this.zzJ(n3);
        String string = new String(this.zzf, this.zzi, n3, zzggk.zza);
        this.zzi += n3;
        return string;
    }

    public final String zzm() throws IOException {
        byte[] byArray;
        int n;
        int n2;
        int n3 = this.zzu();
        if (n3 <= (n2 = this.zzg) - (n = this.zzi) && n3 > 0) {
            byArray = this.zzf;
            this.zzi = n + n3;
        } else {
            if (n3 == 0) {
                return "";
            }
            if (n3 <= n2) {
                this.zzJ(n3);
                byArray = this.zzf;
                this.zzi = n3;
            } else {
                byArray = this.zzL(n3, false);
            }
            n = 0;
        }
        return zzgjd.zzj((byte[])byArray, (int)n, (int)n3);
    }

    public final zzgex zzn() throws IOException {
        int n;
        int n2;
        int n3 = this.zzu();
        if (n3 <= (n2 = this.zzg) - (n = this.zzi) && n3 > 0) {
            zzgex zzgex2 = zzgex.zzs((byte[])this.zzf, (int)n, (int)n3);
            this.zzi += n3;
            return zzgex2;
        }
        if (n3 == 0) return zzgex.zzb;
        Object object = this.zzM(n3);
        if (object != null) {
            object = zzgex.zzt((byte[])object);
        } else {
            int n4 = this.zzi;
            n2 = this.zzg;
            n = n2 - n4;
            this.zzk += n2;
            this.zzi = 0;
            this.zzg = 0;
            Object object2 = this.zzN(n3 - n);
            object = new byte[n3];
            System.arraycopy(this.zzf, n4, object, 0, n);
            object2 = object2.iterator();
            while (object2.hasNext()) {
                byte[] byArray = (byte[])object2.next();
                n3 = byArray.length;
                System.arraycopy(byArray, 0, object, n, n3);
                n += n3;
            }
            object = zzgex.zzu((byte[])object);
        }
        return object;
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
        return zzgfb.zzG((int)this.zzu());
    }

    public final long zzt() throws IOException {
        return zzgfb.zzH((long)this.zzv());
    }

    public final int zzu() throws IOException {
        int n = this.zzg;
        int n2 = this.zzi;
        if (n == n2) {
            return (int)this.zzw();
        }
        byte[] byArray = this.zzf;
        int n3 = n2 + 1;
        if ((n2 = byArray[n2]) >= 0) {
            this.zzi = n3;
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
        this.zzi = n;
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
                                    var1_2 = this.zzg;
                                    var3_1 = this.zzi;
                                    if (var1_2 == var3_1) {
                                        return this.zzw();
                                    }
                                    var8_3 = this.zzf;
                                    var2_4 = var3_1 + 1;
                                    if ((var3_1 = var8_3[var3_1]) >= 0) {
                                        this.zzi = var2_4;
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
                    ** GOTO lbl46
                }
                var1_2 = var2_4 + 1;
                if ((var6_6 ^= (long)var8_3[var2_4] << 35) >= 0L) break block13;
                var4_5 = -34093383808L;
                ** GOTO lbl51
            }
            var2_4 = var1_2 + 1;
            if ((var6_6 ^= (long)var8_3[var1_2] << 42) >= 0L) {
                var4_5 = 4363953127296L;
                var1_2 = var2_4;
lbl46:
                // 2 sources

                var4_5 = var6_6 ^ var4_5;
            } else {
                var1_2 = var2_4 + 1;
                if ((var6_6 ^= (long)var8_3[var2_4] << 49) < 0L) {
                    var4_5 = -558586000294016L;
lbl51:
                    // 2 sources

                    var4_5 ^= var6_6;
                } else {
                    var2_4 = var1_2 + 1;
                    var4_5 = var6_6 = var6_6 ^ (long)var8_3[var1_2] << 56 ^ 71499008037633920L;
                    var1_2 = var2_4;
                    if (var6_6 < 0L) {
                        var1_2 = var2_4 + 1;
                        if ((long)var8_3[var2_4] < 0L) return this.zzw();
                        var4_5 = var6_6;
                    }
                }
            }
        }
        this.zzi = var1_2;
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
        int n;
        int n2 = n = this.zzi;
        if (this.zzg - n < 4) {
            this.zzJ(4);
            n2 = this.zzi;
        }
        byte[] byArray = this.zzf;
        this.zzi = n2 + 4;
        byte by = byArray[n2];
        byte by2 = byArray[n2 + 1];
        n = byArray[n2 + 2];
        return (byArray[n2 + 3] & 0xFF) << 24 | (by & 0xFF | (by2 & 0xFF) << 8 | (n & 0xFF) << 16);
    }

    public final long zzy() throws IOException {
        int n;
        int n2 = n = this.zzi;
        if (this.zzg - n < 8) {
            this.zzJ(8);
            n2 = this.zzi;
        }
        byte[] byArray = this.zzf;
        this.zzi = n2 + 8;
        long l = byArray[n2];
        long l2 = byArray[n2 + 1];
        long l3 = byArray[n2 + 2];
        long l4 = byArray[n2 + 3];
        long l5 = byArray[n2 + 4];
        long l6 = byArray[n2 + 5];
        long l7 = byArray[n2 + 6];
        return ((long)byArray[n2 + 7] & 0xFFL) << 56 | (l & 0xFFL | (l2 & 0xFFL) << 8 | (l3 & 0xFFL) << 16 | (l4 & 0xFFL) << 24 | (l5 & 0xFFL) << 32 | (l6 & 0xFFL) << 40 | (l7 & 0xFFL) << 48);
    }

    public final int zzz(int n) throws zzggm {
        if (n < 0) throw zzggm.zze();
        int n2 = n + (this.zzk + this.zzi);
        if (n2 > (n = this.zzl)) throw zzggm.zzd();
        this.zzl = n2;
        this.zzI();
        return n;
    }
}
