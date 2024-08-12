/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.random.Random
 */
package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.random.Random;

@Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u00c2\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "readResolve", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
private static final class Random.Default.Serialized
implements Serializable {
    public static final Random.Default.Serialized INSTANCE = new Random.Default.Serialized();
    private static final long serialVersionUID = 0L;

    private Random.Default.Serialized() {
    }

    private final Object readResolve() {
        return Random.Default;
    }
}
