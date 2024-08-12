/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.Lifecycle$State
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/*
 * Exception performing whole class analysis ignored.
 */
static class Lifecycle.1 {
    static final int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;
    static final int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[Lifecycle.Event.values().length];
        $SwitchMap$androidx$lifecycle$Lifecycle$Event = nArray;
        try {
            nArray[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_STOP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_RESUME.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_ANY.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        nArray = new int[Lifecycle.State.values().length];
        $SwitchMap$androidx$lifecycle$Lifecycle$State = nArray;
        try {
            nArray[Lifecycle.State.CREATED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.STARTED.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.RESUMED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.DESTROYED.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.INITIALIZED.ordinal()] = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
