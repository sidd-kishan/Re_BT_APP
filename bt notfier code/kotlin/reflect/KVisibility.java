/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlin.reflect;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/reflect/KVisibility;", "", "(Ljava/lang/String;I)V", "PUBLIC", "PROTECTED", "INTERNAL", "PRIVATE", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class KVisibility
extends Enum<KVisibility> {
    private static final KVisibility[] $VALUES;
    public static final /* enum */ KVisibility INTERNAL;
    public static final /* enum */ KVisibility PRIVATE;
    public static final /* enum */ KVisibility PROTECTED;
    public static final /* enum */ KVisibility PUBLIC;

    static {
        KVisibility kVisibility;
        KVisibility kVisibility2;
        KVisibility kVisibility3;
        KVisibility kVisibility4;
        PUBLIC = kVisibility4 = new KVisibility();
        PROTECTED = kVisibility3 = new KVisibility();
        INTERNAL = kVisibility2 = new KVisibility();
        PRIVATE = kVisibility = new KVisibility();
        $VALUES = new KVisibility[]{kVisibility4, kVisibility3, kVisibility2, kVisibility};
    }

    public static KVisibility valueOf(String string) {
        return Enum.valueOf(KVisibility.class, string);
    }

    public static KVisibility[] values() {
        return (KVisibility[])$VALUES.clone();
    }
}
