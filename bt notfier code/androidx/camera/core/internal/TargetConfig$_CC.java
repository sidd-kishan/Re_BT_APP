/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.internal.TargetConfig
 */
package androidx.camera.core.internal;

import androidx.camera.core.internal.TargetConfig;

public final class TargetConfig$_CC {
    public static Class<T> $default$getTargetClass(TargetConfig targetConfig) {
        return (Class)targetConfig.retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
    }

    public static Class<T> $default$getTargetClass(TargetConfig targetConfig, Class<T> clazz) {
        return (Class)targetConfig.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, clazz);
    }

    public static String $default$getTargetName(TargetConfig targetConfig) {
        return (String)targetConfig.retrieveOption(TargetConfig.OPTION_TARGET_NAME);
    }

    public static String $default$getTargetName(TargetConfig targetConfig, String string) {
        return (String)targetConfig.retrieveOption(TargetConfig.OPTION_TARGET_NAME, (Object)string);
    }
}
