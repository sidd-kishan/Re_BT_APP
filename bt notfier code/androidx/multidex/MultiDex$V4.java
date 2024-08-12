/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.multidex.MultiDex
 *  dalvik.system.DexFile
 */
package androidx.multidex;

import androidx.multidex.MultiDex;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipFile;

/*
 * Exception performing whole class analysis ignored.
 */
private static final class MultiDex.V4 {
    private MultiDex.V4() {
    }

    static void install(ClassLoader classLoader, List<? extends File> object) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
        int n = object.size();
        Field field = MultiDex.access$000((Object)classLoader, (String)"path");
        StringBuilder stringBuilder = new StringBuilder((String)field.get(classLoader));
        Object[] objectArray = new String[n];
        Object[] objectArray2 = new File[n];
        Object[] objectArray3 = new ZipFile[n];
        Object[] objectArray4 = new DexFile[n];
        ListIterator<? extends File> listIterator = object.listIterator();
        while (true) {
            if (!listIterator.hasNext()) {
                field.set(classLoader, stringBuilder.toString());
                MultiDex.access$100((Object)classLoader, (String)"mPaths", (Object[])objectArray);
                MultiDex.access$100((Object)classLoader, (String)"mFiles", (Object[])objectArray2);
                MultiDex.access$100((Object)classLoader, (String)"mZips", (Object[])objectArray3);
                MultiDex.access$100((Object)classLoader, (String)"mDexs", (Object[])objectArray4);
                return;
            }
            Serializable serializable = listIterator.next();
            object = ((File)serializable).getAbsolutePath();
            stringBuilder.append(':');
            stringBuilder.append((String)object);
            n = listIterator.previousIndex();
            objectArray[n] = object;
            objectArray2[n] = serializable;
            objectArray3[n] = new ZipFile((File)serializable);
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append((String)object);
            ((StringBuilder)serializable).append(".dex");
            objectArray4[n] = DexFile.loadDex((String)object, (String)((StringBuilder)serializable).toString(), (int)0);
        }
    }
}
