/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlin.reflect;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/reflect/KVariance;", "", "(Ljava/lang/String;I)V", "INVARIANT", "IN", "OUT", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class KVariance
extends Enum<KVariance> {
    private static final KVariance[] $VALUES;
    public static final /* enum */ KVariance IN;
    public static final /* enum */ KVariance INVARIANT;
    public static final /* enum */ KVariance OUT;

    static {
        KVariance kVariance;
        KVariance kVariance2;
        KVariance kVariance3;
        INVARIANT = kVariance3 = new KVariance();
        IN = kVariance2 = new KVariance();
        OUT = kVariance = new KVariance();
        $VALUES = new KVariance[]{kVariance3, kVariance2, kVariance};
    }

    public static KVariance valueOf(String string) {
        return Enum.valueOf(KVariance.class, string);
    }

    public static KVariance[] values() {
        return (KVariance[])$VALUES.clone();
    }
}
