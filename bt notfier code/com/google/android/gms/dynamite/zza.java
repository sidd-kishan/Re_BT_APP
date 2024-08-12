/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dalvik.system.PathClassLoader
 */
package com.google.android.gms.dynamite;

import dalvik.system.PathClassLoader;

final class zza
extends PathClassLoader {
    zza(String string, ClassLoader classLoader) {
        super(string, classLoader);
    }

    protected final Class<?> loadClass(String string, boolean bl) throws ClassNotFoundException {
        if (string.startsWith("java.")) return super.loadClass(string, bl);
        if (string.startsWith("android.")) return super.loadClass(string, bl);
        try {
            Class clazz = this.findClass(string);
            return clazz;
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        return super.loadClass(string, bl);
    }
}
