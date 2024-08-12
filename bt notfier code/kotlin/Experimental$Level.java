/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlin;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/Experimental$Level;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class Experimental.Level
extends Enum<Experimental.Level> {
    private static final Experimental.Level[] $VALUES;
    public static final /* enum */ Experimental.Level ERROR;
    public static final /* enum */ Experimental.Level WARNING;

    static {
        Experimental.Level level;
        Experimental.Level level2;
        WARNING = level2 = new Experimental.Level();
        ERROR = level = new Experimental.Level();
        $VALUES = new Experimental.Level[]{level2, level};
    }

    public static Experimental.Level valueOf(String string) {
        return Enum.valueOf(Experimental.Level.class, string);
    }

    public static Experimental.Level[] values() {
        return (Experimental.Level[])$VALUES.clone();
    }
}
