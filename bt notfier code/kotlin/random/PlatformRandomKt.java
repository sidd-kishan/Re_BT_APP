/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.internal.PlatformImplementationsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.AbstractPlatformRandom
 *  kotlin.random.KotlinRandom
 *  kotlin.random.PlatformRandom
 *  kotlin.random.Random
 */
package kotlin.random;

import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.KotlinRandom;
import kotlin.random.PlatformRandom;
import kotlin.random.Random;

@Metadata(d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\u0081\b\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0007\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0007\u00a8\u0006\n"}, d2={"defaultPlatformRandom", "Lkotlin/random/Random;", "doubleFromParts", "", "hi26", "", "low27", "asJavaRandom", "Ljava/util/Random;", "asKotlinRandom", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class PlatformRandomKt {
    public static final java.util.Random asJavaRandom(Random object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$asJavaRandom");
        Object object2 = !(object instanceof AbstractPlatformRandom) ? null : object;
        object2 = (AbstractPlatformRandom)object2;
        object = object2 != null && (object2 = object2.getImpl()) != null ? object2 : (java.util.Random)new KotlinRandom(object);
        return object;
    }

    public static final Random asKotlinRandom(java.util.Random random) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"$this$asKotlinRandom");
        java.util.Random random2 = !(random instanceof KotlinRandom) ? null : random;
        random2 = (KotlinRandom)random2;
        random = random2 != null && (random2 = random2.getImpl()) != null ? random2 : (Random)new PlatformRandom(random);
        return random;
    }

    private static final Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public static final double doubleFromParts(int n, int n2) {
        double d = ((long)n << 27) + (long)n2;
        double d2 = 0x20000000000000L;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }
}
