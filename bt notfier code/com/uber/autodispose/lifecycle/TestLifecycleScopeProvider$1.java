/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.lifecycle.TestLifecycleScopeProvider$TestLifecycle
 */
package com.uber.autodispose.lifecycle;

import com.uber.autodispose.lifecycle.TestLifecycleScopeProvider;

/*
 * Exception performing whole class analysis ignored.
 */
static class TestLifecycleScopeProvider.1 {
    static final int[] $SwitchMap$com$uber$autodispose$lifecycle$TestLifecycleScopeProvider$TestLifecycle;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[TestLifecycleScopeProvider.TestLifecycle.values().length];
        $SwitchMap$com$uber$autodispose$lifecycle$TestLifecycleScopeProvider$TestLifecycle = nArray;
        try {
            nArray[TestLifecycleScopeProvider.TestLifecycle.STARTED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            TestLifecycleScopeProvider.1.$SwitchMap$com$uber$autodispose$lifecycle$TestLifecycleScopeProvider$TestLifecycle[TestLifecycleScopeProvider.TestLifecycle.STOPPED.ordinal()] = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
