/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.multidex.MultiDex
 *  androidx.multidex.MultiDex$V14$ElementConstructor
 *  androidx.multidex.MultiDex$V14$ICSElementConstructor
 *  androidx.multidex.MultiDex$V14$JBMR2ElementConstructor
 *  dalvik.system.DexFile
 */
package androidx.multidex;

import android.util.Log;
import androidx.multidex.MultiDex;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
private static final class MultiDex.V14 {
    private static final int EXTRACTED_SUFFIX_LENGTH = 4;
    private final ElementConstructor elementConstructor;

    private MultiDex.V14() throws ClassNotFoundException, SecurityException, NoSuchMethodException {
        ICSElementConstructor iCSElementConstructor;
        Class<?> clazz = Class.forName("dalvik.system.DexPathList$Element");
        try {
            iCSElementConstructor = new ICSElementConstructor(clazz);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            try {
                super(clazz);
            }
            catch (NoSuchMethodException noSuchMethodException2) {
                iCSElementConstructor = new JBMR2ElementConstructor(clazz);
            }
        }
        this.elementConstructor = iCSElementConstructor;
    }

    static void install(ClassLoader object, List<? extends File> objectArray) throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        object = MultiDex.access$000((Object)object, (String)"pathList").get(object);
        objectArray = new MultiDex.V14().makeDexElements((List<? extends File>)objectArray);
        try {
            MultiDex.access$100((Object)object, (String)"dexElements", (Object[])objectArray);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            Log.w((String)"MultiDex", (String)"Failed find field 'dexElements' attempting 'pathElements'", (Throwable)noSuchFieldException);
            MultiDex.access$100((Object)object, (String)"pathElements", (Object[])objectArray);
        }
    }

    private Object[] makeDexElements(List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        int n = list.size();
        Object[] objectArray = new Object[n];
        int n2 = 0;
        while (n2 < n) {
            File file = list.get(n2);
            objectArray[n2] = this.elementConstructor.newInstance(file, DexFile.loadDex((String)file.getPath(), (String)MultiDex.V14.optimizedPathFor(file), (int)0));
            ++n2;
        }
        return objectArray;
    }

    private static String optimizedPathFor(File object) {
        File file = ((File)object).getParentFile();
        object = ((File)object).getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((String)object).substring(0, ((String)object).length() - EXTRACTED_SUFFIX_LENGTH));
        stringBuilder.append(".dex");
        return new File(file, stringBuilder.toString()).getPath();
    }
}
