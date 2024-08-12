/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.AbstractPlatformRandom
 *  kotlin.random.PlatformRandom$Companion
 */
package kotlin.random;

import java.io.Serializable;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.PlatformRandom;

@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \t2\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\tB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2={"Lkotlin/random/PlatformRandom;", "Lkotlin/random/AbstractPlatformRandom;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "impl", "Ljava/util/Random;", "(Ljava/util/Random;)V", "getImpl", "()Ljava/util/Random;", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class PlatformRandom
extends AbstractPlatformRandom
implements Serializable {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final long serialVersionUID = 0L;
    private final Random impl;

    public PlatformRandom(Random random) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"impl");
        this.impl = random;
    }

    public Random getImpl() {
        return this.impl;
    }
}
