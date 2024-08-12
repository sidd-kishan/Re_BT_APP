/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.multidex.MultiDex$V14$ElementConstructor
 *  dalvik.system.DexFile
 */
package androidx.multidex;

import androidx.multidex.MultiDex;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.zip.ZipFile;

private static class MultiDex.V14.ICSElementConstructor
implements MultiDex.V14.ElementConstructor {
    private final Constructor<?> elementConstructor;

    MultiDex.V14.ICSElementConstructor(Class<?> genericDeclaration) throws SecurityException, NoSuchMethodException {
        genericDeclaration = ((Class)genericDeclaration).getConstructor(File.class, ZipFile.class, DexFile.class);
        this.elementConstructor = genericDeclaration;
        ((AccessibleObject)((Object)genericDeclaration)).setAccessible(true);
    }

    public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
        return this.elementConstructor.newInstance(file, new ZipFile(file), dexFile);
    }
}
