/*
 * Decompiled with CFR 0.152.
 */
package com.uber.autodispose.lifecycle;

public static final class TestLifecycleScopeProvider.TestLifecycle
extends Enum<TestLifecycleScopeProvider.TestLifecycle> {
    private static final TestLifecycleScopeProvider.TestLifecycle[] $VALUES;
    public static final /* enum */ TestLifecycleScopeProvider.TestLifecycle STARTED;
    public static final /* enum */ TestLifecycleScopeProvider.TestLifecycle STOPPED;

    static {
        TestLifecycleScopeProvider.TestLifecycle testLifecycle;
        STARTED = new TestLifecycleScopeProvider.TestLifecycle();
        STOPPED = testLifecycle = new TestLifecycleScopeProvider.TestLifecycle();
        $VALUES = new TestLifecycleScopeProvider.TestLifecycle[]{STARTED, testLifecycle};
    }

    public static TestLifecycleScopeProvider.TestLifecycle valueOf(String string) {
        return Enum.valueOf(TestLifecycleScopeProvider.TestLifecycle.class, string);
    }

    public static TestLifecycleScopeProvider.TestLifecycle[] values() {
        return (TestLifecycleScopeProvider.TestLifecycle[])$VALUES.clone();
    }
}
