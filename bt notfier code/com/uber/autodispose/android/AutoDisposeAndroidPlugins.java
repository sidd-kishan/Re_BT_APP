/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BooleanSupplier
 */
package com.uber.autodispose.android;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;

public final class AutoDisposeAndroidPlugins {
    static volatile boolean lockdown;
    private static volatile BooleanSupplier onCheckMainThread;

    private AutoDisposeAndroidPlugins() {
    }

    public static boolean isLockdown() {
        return lockdown;
    }

    public static void lockdown() {
        lockdown = true;
    }

    /*
     * Enabled force condition propagation
     */
    public static boolean onCheckMainThread(BooleanSupplier booleanSupplier) {
        if (booleanSupplier == null) throw new NullPointerException("defaultChecker == null");
        BooleanSupplier booleanSupplier2 = onCheckMainThread;
        if (booleanSupplier2 != null) return booleanSupplier2.getAsBoolean();
        try {
            return booleanSupplier.getAsBoolean();
        }
        catch (Exception exception) {
            throw Exceptions.propagate((Throwable)exception);
        }
    }

    public static void reset() {
        AutoDisposeAndroidPlugins.setOnCheckMainThread(null);
    }

    public static void setOnCheckMainThread(BooleanSupplier booleanSupplier) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onCheckMainThread = booleanSupplier;
    }
}
