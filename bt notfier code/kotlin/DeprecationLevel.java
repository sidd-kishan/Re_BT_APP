/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlin;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/DeprecationLevel;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "HIDDEN", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class DeprecationLevel
extends Enum<DeprecationLevel> {
    private static final DeprecationLevel[] $VALUES;
    public static final /* enum */ DeprecationLevel ERROR;
    public static final /* enum */ DeprecationLevel HIDDEN;
    public static final /* enum */ DeprecationLevel WARNING;

    static {
        DeprecationLevel deprecationLevel;
        DeprecationLevel deprecationLevel2;
        DeprecationLevel deprecationLevel3;
        WARNING = deprecationLevel3 = new DeprecationLevel();
        ERROR = deprecationLevel2 = new DeprecationLevel();
        HIDDEN = deprecationLevel = new DeprecationLevel();
        $VALUES = new DeprecationLevel[]{deprecationLevel3, deprecationLevel2, deprecationLevel};
    }

    public static DeprecationLevel valueOf(String string) {
        return Enum.valueOf(DeprecationLevel.class, string);
    }

    public static DeprecationLevel[] values() {
        return (DeprecationLevel[])$VALUES.clone();
    }
}
