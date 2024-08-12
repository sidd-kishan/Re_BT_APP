/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.random.Random
 *  kotlin.random.RandomKt
 *  kotlin.random.XorWowRandom$Companion
 */
package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.random.XorWowRandom;

@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u00122\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0012B\u0017\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007B7\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "seed1", "", "seed2", "(II)V", "x", "y", "z", "w", "v", "addend", "(IIIIII)V", "nextBits", "bitCount", "nextInt", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class XorWowRandom
extends Random
implements Serializable {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final long serialVersionUID = 0L;
    private int addend;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public XorWowRandom(int n, int n2) {
        this(n, n2, 0, 0, ~n, n << 10 ^ n2 >>> 4);
    }

    public XorWowRandom(int n, int n2, int n3, int n4, int n5, int n6) {
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.w = n4;
        this.v = n5;
        this.addend = n6;
        n6 = 0;
        n = (n | n2 | n3 | n4 | n5) != 0 ? 1 : 0;
        if (n == 0) {
            Throwable throwable = new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
            throw throwable;
        }
        n = n6;
        while (n < 64) {
            this.nextInt();
            ++n;
        }
    }

    public int nextBits(int n) {
        return RandomKt.takeUpperBits((int)this.nextInt(), (int)n);
    }

    public int nextInt() {
        int n = this.x;
        int n2 = n ^ n >>> 2;
        this.x = this.y;
        this.y = this.z;
        this.z = this.w;
        this.w = n = this.v;
        this.v = n = n2 ^ n2 << 1 ^ n ^ n << 4;
        this.addend = n2 = this.addend + 362437;
        return n + n2;
    }
}
