/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.ThreadMode
 */
package org.greenrobot.eventbus;

import org.greenrobot.eventbus.ThreadMode;

static class EventBus.2 {
    static final int[] $SwitchMap$org$greenrobot$eventbus$ThreadMode;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[ThreadMode.values().length];
        $SwitchMap$org$greenrobot$eventbus$ThreadMode = nArray;
        try {
            nArray[ThreadMode.POSTING.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            EventBus.2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.MAIN.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            EventBus.2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            EventBus.2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.BACKGROUND.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            EventBus.2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.ASYNC.ordinal()] = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
