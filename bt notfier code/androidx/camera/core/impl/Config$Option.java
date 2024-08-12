/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.AutoValue_Config_Option
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.AutoValue_Config_Option;

public static abstract class Config.Option<T> {
    Config.Option() {
    }

    public static <T> Config.Option<T> create(String string, Class<?> clazz) {
        return Config.Option.create(string, clazz, null);
    }

    public static <T> Config.Option<T> create(String string, Class<?> clazz, Object object) {
        return new AutoValue_Config_Option(string, clazz, object);
    }

    public abstract String getId();

    public abstract Object getToken();

    public abstract Class<T> getValueClass();
}
