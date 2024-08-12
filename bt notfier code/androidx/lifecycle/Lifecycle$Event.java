/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle$1
 *  androidx.lifecycle.Lifecycle$State
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

public static final class Lifecycle.Event
extends Enum<Lifecycle.Event> {
    private static final Lifecycle.Event[] $VALUES;
    public static final /* enum */ Lifecycle.Event ON_ANY;
    public static final /* enum */ Lifecycle.Event ON_CREATE;
    public static final /* enum */ Lifecycle.Event ON_DESTROY;
    public static final /* enum */ Lifecycle.Event ON_PAUSE;
    public static final /* enum */ Lifecycle.Event ON_RESUME;
    public static final /* enum */ Lifecycle.Event ON_START;
    public static final /* enum */ Lifecycle.Event ON_STOP;

    static {
        Lifecycle.Event event;
        ON_CREATE = new Lifecycle.Event();
        ON_START = new Lifecycle.Event();
        ON_RESUME = new Lifecycle.Event();
        ON_PAUSE = new Lifecycle.Event();
        ON_STOP = new Lifecycle.Event();
        ON_DESTROY = new Lifecycle.Event();
        ON_ANY = event = new Lifecycle.Event();
        $VALUES = new Lifecycle.Event[]{ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, event};
    }

    public static Lifecycle.Event downFrom(Lifecycle.State state) {
        int n = Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$State[state.ordinal()];
        if (n == 1) return ON_DESTROY;
        if (n == 2) return ON_STOP;
        if (n == 3) return ON_PAUSE;
        return null;
    }

    public static Lifecycle.Event downTo(Lifecycle.State state) {
        int n = Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$State[state.ordinal()];
        if (n == 1) return ON_STOP;
        if (n == 2) return ON_PAUSE;
        if (n == 4) return ON_DESTROY;
        return null;
    }

    public static Lifecycle.Event upFrom(Lifecycle.State state) {
        int n = Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$State[state.ordinal()];
        if (n == 1) return ON_START;
        if (n == 2) return ON_RESUME;
        if (n == 5) return ON_CREATE;
        return null;
    }

    public static Lifecycle.Event upTo(Lifecycle.State state) {
        int n = Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$State[state.ordinal()];
        if (n == 1) return ON_CREATE;
        if (n == 2) return ON_START;
        if (n == 3) return ON_RESUME;
        return null;
    }

    public static Lifecycle.Event valueOf(String string) {
        return Enum.valueOf(Lifecycle.Event.class, string);
    }

    public static Lifecycle.Event[] values() {
        return (Lifecycle.Event[])$VALUES.clone();
    }

    public Lifecycle.State getTargetState() {
        switch (Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[this.ordinal()]) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this);
                stringBuilder.append(" has no target state");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 6: {
                return Lifecycle.State.DESTROYED;
            }
            case 5: {
                return Lifecycle.State.RESUMED;
            }
            case 3: 
            case 4: {
                return Lifecycle.State.STARTED;
            }
            case 1: 
            case 2: 
        }
        return Lifecycle.State.CREATED;
    }
}
