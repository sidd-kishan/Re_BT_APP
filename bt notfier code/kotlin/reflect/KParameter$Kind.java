/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlin.reflect;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/reflect/KParameter$Kind;", "", "(Ljava/lang/String;I)V", "INSTANCE", "EXTENSION_RECEIVER", "VALUE", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class KParameter.Kind
extends Enum<KParameter.Kind> {
    private static final KParameter.Kind[] $VALUES;
    public static final /* enum */ KParameter.Kind EXTENSION_RECEIVER;
    public static final /* enum */ KParameter.Kind INSTANCE;
    public static final /* enum */ KParameter.Kind VALUE;

    static {
        KParameter.Kind kind;
        KParameter.Kind kind2;
        KParameter.Kind kind3;
        INSTANCE = kind3 = new KParameter.Kind();
        EXTENSION_RECEIVER = kind2 = new KParameter.Kind();
        VALUE = kind = new KParameter.Kind();
        $VALUES = new KParameter.Kind[]{kind3, kind2, kind};
    }

    public static KParameter.Kind valueOf(String string) {
        return Enum.valueOf(KParameter.Kind.class, string);
    }

    public static KParameter.Kind[] values() {
        return (KParameter.Kind[])$VALUES.clone();
    }
}
