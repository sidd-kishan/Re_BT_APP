/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle$State
 */
package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle;

static class LifecycleEventsObservable.1 {
    static final int[] $SwitchMap$android$arch$lifecycle$Lifecycle$State;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[Lifecycle.State.values().length];
        $SwitchMap$android$arch$lifecycle$Lifecycle$State = nArray;
        try {
            nArray[Lifecycle.State.INITIALIZED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            LifecycleEventsObservable.1.$SwitchMap$android$arch$lifecycle$Lifecycle$State[Lifecycle.State.CREATED.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            LifecycleEventsObservable.1.$SwitchMap$android$arch$lifecycle$Lifecycle$State[Lifecycle.State.STARTED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            LifecycleEventsObservable.1.$SwitchMap$android$arch$lifecycle$Lifecycle$State[Lifecycle.State.RESUMED.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            LifecycleEventsObservable.1.$SwitchMap$android$arch$lifecycle$Lifecycle$State[Lifecycle.State.DESTROYED.ordinal()] = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
