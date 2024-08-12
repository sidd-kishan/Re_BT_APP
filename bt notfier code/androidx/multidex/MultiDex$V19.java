/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.multidex.MultiDex
 */
package androidx.multidex;

import android.util.Log;
import androidx.multidex.MultiDex;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
private static final class MultiDex.V19 {
    private MultiDex.V19() {
    }

    static void install(ClassLoader object, List<? extends File> object2, File iOExceptionArray) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        Object object3 = MultiDex.access$000((Object)object, (String)"pathList").get(object);
        ArrayList<IOException> arrayList = new ArrayList<IOException>();
        MultiDex.access$100((Object)object3, (String)"dexElements", (Object[])MultiDex.V19.makeDexElements(object3, new ArrayList<File>((Collection<File>)object2), (File)iOExceptionArray, arrayList));
        if (arrayList.size() <= 0) return;
        object = arrayList.iterator();
        while (object.hasNext()) {
            Log.w((String)"MultiDex", (String)"Exception in makeDexElement", (Throwable)((IOException)object.next()));
        }
        object2 = MultiDex.access$000((Object)object3, (String)"dexElementsSuppressedExceptions");
        iOExceptionArray = (IOException[])((Field)object2).get(object3);
        if (iOExceptionArray == null) {
            object = arrayList.toArray(new IOException[arrayList.size()]);
        } else {
            object = new IOException[arrayList.size() + iOExceptionArray.length];
            arrayList.toArray((T[])object);
            System.arraycopy(iOExceptionArray, 0, object, arrayList.size(), iOExceptionArray.length);
        }
        ((Field)object2).set(object3, object);
        object = new IOException("I/O exception during makeDexElement");
        ((Throwable)object).initCause(arrayList.get(0));
        throw object;
    }

    private static Object[] makeDexElements(Object object, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return (Object[])MultiDex.access$200((Object)object, (String)"makeDexElements", (Class[])new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(object, arrayList, file, arrayList2);
    }
}
