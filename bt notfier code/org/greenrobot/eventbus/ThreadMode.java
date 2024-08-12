/*
 * Decompiled with CFR 0.152.
 */
package org.greenrobot.eventbus;

public final class ThreadMode
extends Enum<ThreadMode> {
    private static final ThreadMode[] $VALUES;
    public static final /* enum */ ThreadMode ASYNC;
    public static final /* enum */ ThreadMode BACKGROUND;
    public static final /* enum */ ThreadMode MAIN;
    public static final /* enum */ ThreadMode MAIN_ORDERED;
    public static final /* enum */ ThreadMode POSTING;

    static {
        ThreadMode threadMode;
        POSTING = new ThreadMode();
        MAIN = new ThreadMode();
        MAIN_ORDERED = new ThreadMode();
        BACKGROUND = new ThreadMode();
        ASYNC = threadMode = new ThreadMode();
        $VALUES = new ThreadMode[]{POSTING, MAIN, MAIN_ORDERED, BACKGROUND, threadMode};
    }

    public static ThreadMode valueOf(String string) {
        return Enum.valueOf(ThreadMode.class, string);
    }

    public static ThreadMode[] values() {
        return (ThreadMode[])$VALUES.clone();
    }
}
