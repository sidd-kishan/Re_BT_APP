/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle$Event
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

static class FullLifecycleObserverAdapter.1 {
    static final int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

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
            FullLifecycleObserverAdapter.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            FullLifecycleObserverAdapter.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            FullLifecycleObserverAdapter.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            FullLifecycleObserverAdapter.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_STOP.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            FullLifecycleObserverAdapter.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            FullLifecycleObserverAdapter.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
