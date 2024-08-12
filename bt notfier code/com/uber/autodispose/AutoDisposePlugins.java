/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.OutsideScopeException
 *  io.reactivex.functions.Consumer
 */
package com.uber.autodispose;

import com.uber.autodispose.OutsideScopeException;
import io.reactivex.functions.Consumer;

public final class AutoDisposePlugins {
    private static volatile boolean fillInOutsideScopeExceptionStacktraces;
    static volatile boolean lockdown;
    private static volatile Consumer<? super OutsideScopeException> outsideScopeHandler;

    private AutoDisposePlugins() {
    }

    public static boolean getFillInOutsideScopeExceptionStacktraces() {
        return fillInOutsideScopeExceptionStacktraces;
    }

    public static Consumer<? super OutsideScopeException> getOutsideScopeHandler() {
        return outsideScopeHandler;
    }

    public static boolean isLockdown() {
        return lockdown;
    }

    public static void lockdown() {
        lockdown = true;
    }

    public static void reset() {
        AutoDisposePlugins.setOutsideScopeHandler(null);
    }

    public static void setFillInOutsideScopeExceptionStacktraces(boolean bl) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        fillInOutsideScopeExceptionStacktraces = bl;
    }

    public static void setOutsideScopeHandler(Consumer<? super OutsideScopeException> consumer) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        outsideScopeHandler = consumer;
    }
}
