/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle$Event
 */
package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle;

static class AndroidLifecycleScopeProvider.1 {
    static final int[] $SwitchMap$android$arch$lifecycle$Lifecycle$Event;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[Lifecycle.Event.values().length];
        $SwitchMap$android$arch$lifecycle$Lifecycle$Event = nArray;
        try {
            nArray[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AndroidLifecycleScopeProvider.1.$SwitchMap$android$arch$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AndroidLifecycleScopeProvider.1.$SwitchMap$android$arch$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AndroidLifecycleScopeProvider.1.$SwitchMap$android$arch$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AndroidLifecycleScopeProvider.1.$SwitchMap$android$arch$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_STOP.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AndroidLifecycleScopeProvider.1.$SwitchMap$android$arch$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
