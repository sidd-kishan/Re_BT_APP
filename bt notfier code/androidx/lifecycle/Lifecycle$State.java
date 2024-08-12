/*
 * Decompiled with CFR 0.152.
 */
package androidx.lifecycle;

public static final class Lifecycle.State
extends Enum<Lifecycle.State> {
    private static final Lifecycle.State[] $VALUES;
    public static final /* enum */ Lifecycle.State CREATED;
    public static final /* enum */ Lifecycle.State DESTROYED;
    public static final /* enum */ Lifecycle.State INITIALIZED;
    public static final /* enum */ Lifecycle.State RESUMED;
    public static final /* enum */ Lifecycle.State STARTED;

    static {
        Lifecycle.State state;
        DESTROYED = new Lifecycle.State();
        INITIALIZED = new Lifecycle.State();
        CREATED = new Lifecycle.State();
        STARTED = new Lifecycle.State();
        RESUMED = state = new Lifecycle.State();
        $VALUES = new Lifecycle.State[]{DESTROYED, INITIALIZED, CREATED, STARTED, state};
    }

    public static Lifecycle.State valueOf(String string) {
        return Enum.valueOf(Lifecycle.State.class, string);
    }

    public static Lifecycle.State[] values() {
        return (Lifecycle.State[])$VALUES.clone();
    }

    public boolean isAtLeast(Lifecycle.State state) {
        boolean bl = this.compareTo(state) >= 0;
        return bl;
    }
}
