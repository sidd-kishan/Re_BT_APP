/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlin;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/RequiresOptIn$Level;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class RequiresOptIn.Level
extends Enum<RequiresOptIn.Level> {
    private static final RequiresOptIn.Level[] $VALUES;
    public static final /* enum */ RequiresOptIn.Level ERROR;
    public static final /* enum */ RequiresOptIn.Level WARNING;

    static {
        RequiresOptIn.Level level;
        RequiresOptIn.Level level2;
        WARNING = level2 = new RequiresOptIn.Level();
        ERROR = level = new RequiresOptIn.Level();
        $VALUES = new RequiresOptIn.Level[]{level2, level};
    }

    public static RequiresOptIn.Level valueOf(String string) {
        return Enum.valueOf(RequiresOptIn.Level.class, string);
    }

    public static RequiresOptIn.Level[] values() {
        return (RequiresOptIn.Level[])$VALUES.clone();
    }
}
