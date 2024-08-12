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
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

private static class MultiDex.V14.JBMR2ElementConstructor
implements MultiDex.V14.ElementConstructor {
    private final Constructor<?> elementConstructor;

    MultiDex.V14.JBMR2ElementConstructor(Class<?> genericDeclaration) throws SecurityException, NoSuchMethodException {
        genericDeclaration = ((Class)genericDeclaration).getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
        this.elementConstructor = genericDeclaration;
        ((AccessibleObject)((Object)genericDeclaration)).setAccessible(true);
    }

    public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return this.elementConstructor.newInstance(file, Boolean.FALSE, file, dexFile);
    }
}
