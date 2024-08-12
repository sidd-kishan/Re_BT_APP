/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dalvik.system.DexFile
 */
package androidx.multidex;

import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

private static interface MultiDex.V14.ElementConstructor {
    public Object newInstance(File var1, DexFile var2) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
}
