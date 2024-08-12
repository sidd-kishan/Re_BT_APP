/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.internal.PlatformImplementationsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.PlatformRandomKt
 *  kotlin.random.Random$Default
 *  kotlin.random.RandomKt
 */
package kotlin.random;

import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.PlatformRandomKt;
import kotlin.random.Random;
import kotlin.random.RandomKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016\u00a8\u0006\u0018"}, d2={"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Default", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class Random {
    public static final Default Default = new Default(null);
    private static final Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();

    public static final /* synthetic */ Random access$getDefaultRandom$cp() {
        return defaultRandom;
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] byArray, int n, int n2, int n3, Object object) {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) == 0) return random.nextBytes(byArray, n, n2);
        n2 = byArray.length;
        return random.nextBytes(byArray, n, n2);
    }

    public abstract int nextBits(int var1);

    public boolean nextBoolean() {
        boolean bl = true;
        if (this.nextBits(1) != 0) return bl;
        bl = false;
        return bl;
    }

    public byte[] nextBytes(int n) {
        return this.nextBytes(new byte[n]);
    }

    public byte[] nextBytes(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"array");
        return this.nextBytes(byArray, 0, byArray.length);
    }

    /*
     * Unable to fully structure code
     */
    public byte[] nextBytes(byte[] var1_1, int var2_2, int var3_3) {
        Intrinsics.checkNotNullParameter((Object)var1_1, (String)"array");
        var4_4 = ((byte[])var1_1).length;
        var5_5 = 0;
        var6_6 = 1;
        if (var2_2 < 0 || var4_4 < var2_2) ** GOTO lbl-1000
        var4_4 = ((byte[])var1_1).length;
        if (var3_3 >= 0 && var4_4 >= var3_3) {
            var4_4 = 1;
        } else lbl-1000:
        // 2 sources

        {
            var4_4 = 0;
        }
        if (var4_4 == 0) {
            var8_8 = new StringBuilder();
            var8_8.append("fromIndex (");
            var8_8.append(var2_2);
            var8_8.append(") or toIndex (");
            var8_8.append(var3_3);
            var8_8.append(") are out of range: 0..");
            var8_8.append(((Object)var1_1).length);
            var8_8.append('.');
            var1_1 = new IllegalArgumentException(var8_8.toString().toString());
            throw var1_1;
        }
        var4_4 = var2_2 <= var3_3 ? var6_6 : 0;
        if (var4_4 == 0) {
            var1_1 = new StringBuilder();
            var1_1.append("fromIndex (");
            var1_1.append(var2_2);
            var1_1.append(") must be not greater than toIndex (");
            var1_1.append(var3_3);
            var1_1.append(").");
            throw (Throwable)new IllegalArgumentException(var1_1.toString().toString());
        }
        var6_6 = (var3_3 - var2_2) / 4;
        for (var4_4 = 0; var4_4 < var6_6; var2_2 += 4, ++var4_4) {
            var7_7 = this.nextInt();
            var1_1[var2_2] = (byte)var7_7;
            var1_1[var2_2 + 1] = (byte)(var7_7 >>> 8);
            var1_1[var2_2 + 2] = (byte)(var7_7 >>> 16);
            var1_1[var2_2 + 3] = (byte)(var7_7 >>> 24);
        }
        var4_4 = var3_3 - var2_2;
        var6_6 = this.nextBits(var4_4 * 8);
        var3_3 = var5_5;
        while (var3_3 < var4_4) {
            var1_1[var2_2 + var3_3] = (byte)(var6_6 >>> var3_3 * 8);
            ++var3_3;
        }
        return var1_1;
    }

    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts((int)this.nextBits(26), (int)this.nextBits(27));
    }

    public double nextDouble(double d) {
        return this.nextDouble(0.0, d);
    }

    /*
     * Unable to fully structure code
     */
    public double nextDouble(double var1_1, double var3_2) {
        RandomKt.checkRangeBounds((double)var1_1, (double)var3_2);
        var5_3 = var3_2 - var1_1;
        if (!Double.isInfinite(var5_3)) ** GOTO lbl-1000
        var13_4 = Double.isInfinite(var1_1);
        var12_5 = true;
        var11_6 = var13_4 == false && Double.isNaN(var1_1) == false;
        if (var11_6 && (var11_6 = Double.isInfinite(var3_2) == false && Double.isNaN(var3_2) == false ? var12_5 : false)) {
            var5_3 = this.nextDouble();
            var9_7 = 2;
            Double.isNaN(var9_7);
            var7_8 = var3_2 / var9_7;
            Double.isNaN(var9_7);
            var5_3 *= var7_8 - var1_1 / var9_7;
            var1_1 = var1_1 + var5_3 + var5_3;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 += this.nextDouble() * var5_3;
        }
        var5_3 = var1_1;
        if (!(var1_1 >= var3_2)) return var5_3;
        var5_3 = Math.nextAfter(var3_2, -Infinity);
        return var5_3;
    }

    public float nextFloat() {
        return (float)this.nextBits(24) / (float)0x1000000;
    }

    public int nextInt() {
        return this.nextBits(32);
    }

    public int nextInt(int n) {
        return this.nextInt(0, n);
    }

    public int nextInt(int n, int n2) {
        RandomKt.checkRangeBounds((int)n, (int)n2);
        int n3 = n2 - n;
        if (n3 > 0 || n3 == Integer.MIN_VALUE) {
            if ((-n3 & n3) == n3) {
                n2 = this.nextBits(RandomKt.fastLog2((int)n3));
            } else {
                int n4;
                while ((n4 = this.nextInt() >>> 1) - (n2 = n4 % n3) + (n3 - 1) < 0) {
                }
            }
            return n + n2;
        }
        while (n > (n3 = this.nextInt()) || n2 <= n3) {
        }
        return n3;
    }

    public long nextLong() {
        return ((long)this.nextInt() << 32) + (long)this.nextInt();
    }

    public long nextLong(long l) {
        return this.nextLong(0L, l);
    }

    /*
     * Enabled force condition propagation
     */
    public long nextLong(long l, long l2) {
        RandomKt.checkRangeBounds((long)l, (long)l2);
        long l3 = l2 - l;
        if (l3 > 0L) {
            long l4;
            if ((-l3 & l3) == l3) {
                int n = (int)l3;
                int n2 = (int)(l3 >>> 32);
                if (n != 0) {
                    n2 = this.nextBits(RandomKt.fastLog2((int)n));
                } else {
                    if (n2 != 1) {
                        l2 = ((long)this.nextBits(RandomKt.fastLog2((int)n2)) << 32) + (long)this.nextInt();
                        return l + l2;
                    }
                    n2 = this.nextInt();
                }
                l2 = (long)n2 & 0xFFFFFFFFL;
                return l + l2;
            }
            while ((l4 = this.nextLong() >>> 1) - (l2 = l4 % l3) + (l3 - 1L) < 0L) {
            }
            return l + l2;
        }
        while (l > (l3 = this.nextLong()) || l2 <= l3) {
        }
        return l3;
    }
}
