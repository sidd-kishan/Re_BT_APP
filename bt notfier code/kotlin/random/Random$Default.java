/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  kotlin.random.Random$Default$Serialized
 */
package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001cB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "writeReplace", "", "Serialized", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class Random.Default
extends Random
implements Serializable {
    private Random.Default() {
    }

    public /* synthetic */ Random.Default(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final Object writeReplace() {
        return Serialized.INSTANCE;
    }

    public int nextBits(int n) {
        return Random.access$getDefaultRandom$cp().nextBits(n);
    }

    public boolean nextBoolean() {
        return Random.access$getDefaultRandom$cp().nextBoolean();
    }

    public byte[] nextBytes(int n) {
        return Random.access$getDefaultRandom$cp().nextBytes(n);
    }

    public byte[] nextBytes(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"array");
        return Random.access$getDefaultRandom$cp().nextBytes(byArray);
    }

    public byte[] nextBytes(byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"array");
        return Random.access$getDefaultRandom$cp().nextBytes(byArray, n, n2);
    }

    public double nextDouble() {
        return Random.access$getDefaultRandom$cp().nextDouble();
    }

    public double nextDouble(double d) {
        return Random.access$getDefaultRandom$cp().nextDouble(d);
    }

    public double nextDouble(double d, double d2) {
        return Random.access$getDefaultRandom$cp().nextDouble(d, d2);
    }

    public float nextFloat() {
        return Random.access$getDefaultRandom$cp().nextFloat();
    }

    public int nextInt() {
        return Random.access$getDefaultRandom$cp().nextInt();
    }

    public int nextInt(int n) {
        return Random.access$getDefaultRandom$cp().nextInt(n);
    }

    public int nextInt(int n, int n2) {
        return Random.access$getDefaultRandom$cp().nextInt(n, n2);
    }

    public long nextLong() {
        return Random.access$getDefaultRandom$cp().nextLong();
    }

    public long nextLong(long l) {
        return Random.access$getDefaultRandom$cp().nextLong(l);
    }

    public long nextLong(long l, long l2) {
        return Random.access$getDefaultRandom$cp().nextLong(l, l2);
    }
}
