/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.os.Build$VERSION
 *  android.util.Log
 *  androidx.multidex.MultiDex$V14
 *  androidx.multidex.MultiDex$V19
 *  androidx.multidex.MultiDex$V4
 *  androidx.multidex.MultiDexExtractor
 */
package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexExtractor;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Exception performing whole class analysis ignored.
 */
public final class MultiDex {
    private static final String CODE_CACHE_NAME = "code_cache";
    private static final String CODE_CACHE_SECONDARY_FOLDER_NAME = "secondary-dexes";
    private static final boolean IS_VM_MULTIDEX_CAPABLE;
    private static final int MAX_SUPPORTED_SDK_VERSION = 20;
    private static final int MIN_SDK_VERSION = 4;
    private static final String NO_KEY_PREFIX = "";
    private static final String OLD_SECONDARY_FOLDER_NAME = "secondary-dexes";
    static final String TAG = "MultiDex";
    private static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
    private static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;
    private static final Set<File> installedApk;

    static {
        installedApk = new HashSet<File>();
        IS_VM_MULTIDEX_CAPABLE = MultiDex.isVMMultidexCapable(System.getProperty("java.vm.version"));
    }

    private MultiDex() {
    }

    static /* synthetic */ Field access$000(Object object, String string) throws NoSuchFieldException {
        return MultiDex.findField(object, string);
    }

    static /* synthetic */ void access$100(Object object, String string, Object[] objectArray) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        MultiDex.expandFieldArray(object, string, objectArray);
    }

    static /* synthetic */ Method access$200(Object object, String string, Class[] classArray) throws NoSuchMethodException {
        return MultiDex.findMethod(object, string, classArray);
    }

    private static void clearOldDexDir(Context object) throws Exception {
        if (!((File)(object = new File(object.getFilesDir(), "secondary-dexes"))).isDirectory()) return;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("Clearing old secondary dex dir (");
        ((StringBuilder)object2).append(((File)object).getPath());
        ((StringBuilder)object2).append(").");
        Log.i((String)"MultiDex", (String)((StringBuilder)object2).toString());
        object2 = ((File)object).listFiles();
        if (object2 == null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Failed to list secondary dex dir content (");
            ((StringBuilder)object2).append(((File)object).getPath());
            ((StringBuilder)object2).append(").");
            Log.w((String)"MultiDex", (String)((StringBuilder)object2).toString());
            return;
        }
        for (Object object3 : object2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trying to delete old file ");
            stringBuilder.append(((File)object3).getPath());
            stringBuilder.append(" of size ");
            stringBuilder.append(((File)object3).length());
            Log.i((String)"MultiDex", (String)stringBuilder.toString());
            if (!((File)object3).delete()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to delete old file ");
                stringBuilder.append(((File)object3).getPath());
                Log.w((String)"MultiDex", (String)stringBuilder.toString());
                continue;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Deleted old file ");
            stringBuilder.append(((File)object3).getPath());
            Log.i((String)"MultiDex", (String)stringBuilder.toString());
        }
        if (!((File)object).delete()) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Failed to delete secondary dex dir ");
            ((StringBuilder)object2).append(((File)object).getPath());
            Log.w((String)"MultiDex", (String)((StringBuilder)object2).toString());
        } else {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Deleted old secondary dex dir ");
            ((StringBuilder)object2).append(((File)object).getPath());
            Log.i((String)"MultiDex", (String)((StringBuilder)object2).toString());
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private static void doInstallation(Context object, File serializable, File file, String object2, String string, boolean bl) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
        Set<File> set = installedApk;
        synchronized (set) {
            void var4_8;
            File file2;
            MultiDexExtractor multiDexExtractor;
            Object object3;
            Object var1_4;
            block21: {
                if (installedApk.contains(var1_4)) {
                    return;
                }
                installedApk.add(var1_4);
                if (Build.VERSION.SDK_INT > 20) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("MultiDex is not guaranteed to work in SDK version ");
                    ((StringBuilder)object3).append(Build.VERSION.SDK_INT);
                    ((StringBuilder)object3).append(": SDK version higher than ");
                    ((StringBuilder)object3).append(20);
                    ((StringBuilder)object3).append(" should be backed by ");
                    ((StringBuilder)object3).append("runtime with built-in multidex capabilty but it's not the ");
                    ((StringBuilder)object3).append("case here: java.vm.version=\"");
                    ((StringBuilder)object3).append(System.getProperty("java.vm.version"));
                    ((StringBuilder)object3).append("\"");
                    Log.w((String)"MultiDex", (String)((StringBuilder)object3).toString());
                }
                try {
                    object3 = object.getClassLoader();
                    if (object3 != null) break block21;
                }
                catch (RuntimeException runtimeException) {
                    Log.w((String)"MultiDex", (String)"Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", (Throwable)runtimeException);
                    return;
                }
                Log.e((String)"MultiDex", (String)"Context class loader is null. Must be running in test mode. Skip patching.");
                return;
            }
            try {
                MultiDex.clearOldDexDir(object);
            }
            catch (Throwable throwable) {
                Log.w((String)"MultiDex", (String)"Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", (Throwable)throwable);
            }
            file2 = MultiDex.getDexDir(object, (File)multiDexExtractor, (String)((Object)file2));
            multiDexExtractor = new MultiDexExtractor((File)var1_4, file2);
            var1_4 = null;
            List list = multiDexExtractor.load(object, (String)var4_8, false);
            try {
                MultiDex.installSecondaryDexes((ClassLoader)object3, file2, list);
            }
            catch (IOException iOException) {
                void var5_9;
                if (var5_9 == false) throw iOException;
                Log.w((String)"MultiDex", (String)"Failed to install extracted secondary dex files, retrying with forced extraction", (Throwable)iOException);
                MultiDex.installSecondaryDexes((ClassLoader)object3, file2, multiDexExtractor.load(object, (String)var4_8, true));
            }
            object = var1_4;
            if (object != null) throw object;
            return;
            finally {
                multiDexExtractor.close();
            }
        }
    }

    private static void expandFieldArray(Object object, String object2, Object[] objectArray) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        object2 = MultiDex.findField(object, (String)object2);
        Object[] objectArray2 = (Object[])((Field)object2).get(object);
        Object[] objectArray3 = (Object[])Array.newInstance(objectArray2.getClass().getComponentType(), objectArray2.length + objectArray.length);
        System.arraycopy(objectArray2, 0, objectArray3, 0, objectArray2.length);
        System.arraycopy(objectArray, 0, objectArray3, objectArray2.length, objectArray.length);
        ((Field)object2).set(object, objectArray3);
    }

    private static Field findField(Object object, String string) throws NoSuchFieldException {
        Serializable serializable = object.getClass();
        while (true) {
            if (serializable == null) {
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append("Field ");
                ((StringBuilder)serializable).append(string);
                ((StringBuilder)serializable).append(" not found in ");
                ((StringBuilder)serializable).append(object.getClass());
                object = new NoSuchFieldException(((StringBuilder)serializable).toString());
                throw object;
            }
            try {
                Field field = ((Class)serializable).getDeclaredField(string);
                if (field.isAccessible()) return field;
                field.setAccessible(true);
                return field;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                serializable = ((Class)serializable).getSuperclass();
                continue;
            }
            break;
        }
    }

    private static Method findMethod(Object object, String string, Class<?> ... classArray) throws NoSuchMethodException {
        Serializable serializable = object.getClass();
        while (true) {
            if (serializable == null) {
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append("Method ");
                ((StringBuilder)serializable).append(string);
                ((StringBuilder)serializable).append(" with parameters ");
                ((StringBuilder)serializable).append(Arrays.asList(classArray));
                ((StringBuilder)serializable).append(" not found in ");
                ((StringBuilder)serializable).append(object.getClass());
                object = new NoSuchMethodException(((StringBuilder)serializable).toString());
                throw object;
            }
            try {
                Method method = ((Class)serializable).getDeclaredMethod(string, classArray);
                if (method.isAccessible()) return method;
                method.setAccessible(true);
                return method;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                serializable = ((Class)serializable).getSuperclass();
                continue;
            }
            break;
        }
    }

    private static ApplicationInfo getApplicationInfo(Context context) {
        try {
            context = context.getApplicationInfo();
            return context;
        }
        catch (RuntimeException runtimeException) {
            Log.w((String)"MultiDex", (String)"Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", (Throwable)runtimeException);
            return null;
        }
    }

    private static File getDexDir(Context object, File file, String string) throws IOException {
        file = new File(file, "code_cache");
        try {
            MultiDex.mkdirChecked(file);
            object = file;
        }
        catch (IOException iOException) {
            object = new File(object.getFilesDir(), "code_cache");
            MultiDex.mkdirChecked((File)object);
        }
        object = new File((File)object, string);
        MultiDex.mkdirChecked((File)object);
        return object;
    }

    public static void install(Context object) {
        Log.i((String)"MultiDex", (String)"Installing application");
        if (IS_VM_MULTIDEX_CAPABLE) {
            Log.i((String)"MultiDex", (String)"VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        if (Build.VERSION.SDK_INT < 4) {
            object = new StringBuilder();
            ((StringBuilder)object).append("MultiDex installation failed. SDK ");
            ((StringBuilder)object).append(Build.VERSION.SDK_INT);
            ((StringBuilder)object).append(" is unsupported. Min SDK version is ");
            ((StringBuilder)object).append(4);
            ((StringBuilder)object).append(".");
            throw new RuntimeException(((StringBuilder)object).toString());
        }
        try {
            ApplicationInfo applicationInfo = MultiDex.getApplicationInfo((Context)object);
            if (applicationInfo == null) {
                Log.i((String)"MultiDex", (String)"No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                return;
            }
            File file = new File(applicationInfo.sourceDir);
            File file2 = new File(applicationInfo.dataDir);
            MultiDex.doInstallation((Context)object, file, file2, "secondary-dexes", "", true);
        }
        catch (Exception exception) {
            Log.e((String)"MultiDex", (String)"MultiDex installation failure", (Throwable)exception);
            object = new StringBuilder();
            ((StringBuilder)object).append("MultiDex installation failed (");
            ((StringBuilder)object).append(exception.getMessage());
            ((StringBuilder)object).append(").");
            throw new RuntimeException(((StringBuilder)object).toString());
        }
        Log.i((String)"MultiDex", (String)"install done");
    }

    public static void installInstrumentation(Context object, Context context) {
        Log.i((String)"MultiDex", (String)"Installing instrumentation");
        if (IS_VM_MULTIDEX_CAPABLE) {
            Log.i((String)"MultiDex", (String)"VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        if (Build.VERSION.SDK_INT < 4) {
            object = new StringBuilder();
            ((StringBuilder)object).append("MultiDex installation failed. SDK ");
            ((StringBuilder)object).append(Build.VERSION.SDK_INT);
            ((StringBuilder)object).append(" is unsupported. Min SDK version is ");
            ((StringBuilder)object).append(4);
            ((StringBuilder)object).append(".");
            throw new RuntimeException(((StringBuilder)object).toString());
        }
        try {
            Object object2 = MultiDex.getApplicationInfo((Context)object);
            if (object2 == null) {
                Log.i((String)"MultiDex", (String)"No ApplicationInfo available for instrumentation, i.e. running on a test Context: MultiDex support library is disabled.");
                return;
            }
            ApplicationInfo applicationInfo = MultiDex.getApplicationInfo(context);
            if (applicationInfo == null) {
                Log.i((String)"MultiDex", (String)"No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                return;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append(object.getPackageName());
            charSequence.append(".");
            charSequence = charSequence.toString();
            object = new File(applicationInfo.dataDir);
            File file = new File(((ApplicationInfo)object2).sourceDir);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)charSequence);
            ((StringBuilder)object2).append("secondary-dexes");
            MultiDex.doInstallation(context, file, (File)object, ((StringBuilder)object2).toString(), (String)charSequence, false);
            object2 = new File(applicationInfo.sourceDir);
            MultiDex.doInstallation(context, (File)object2, (File)object, "secondary-dexes", "", false);
        }
        catch (Exception exception) {
            Log.e((String)"MultiDex", (String)"MultiDex installation failure", (Throwable)exception);
            object = new StringBuilder();
            ((StringBuilder)object).append("MultiDex installation failed (");
            ((StringBuilder)object).append(exception.getMessage());
            ((StringBuilder)object).append(").");
            throw new RuntimeException(((StringBuilder)object).toString());
        }
        Log.i((String)"MultiDex", (String)"Installation done");
    }

    private static void installSecondaryDexes(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        if (list.isEmpty()) return;
        if (Build.VERSION.SDK_INT >= 19) {
            V19.install((ClassLoader)classLoader, list, (File)file);
        } else if (Build.VERSION.SDK_INT >= 14) {
            V14.install((ClassLoader)classLoader, list);
        } else {
            V4.install((ClassLoader)classLoader, list);
        }
    }

    static boolean isVMMultidexCapable(String string) {
        Object object;
        boolean bl;
        block6: {
            boolean bl2;
            bl = bl2 = false;
            if (string != null) {
                object = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(string);
                bl = bl2;
                if (((Matcher)object).matches()) {
                    try {
                        int n = Integer.parseInt(((Matcher)object).group(1));
                        int n2 = Integer.parseInt(((Matcher)object).group(2));
                        if (n <= 2) {
                            bl = bl2;
                            if (n != 2) break block6;
                            bl = bl2;
                            if (n2 < 1) break block6;
                        }
                        bl = true;
                    }
                    catch (NumberFormatException numberFormatException) {
                        bl = bl2;
                    }
                }
            }
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("VM with version ");
        ((StringBuilder)object).append(string);
        string = bl ? " has multidex support" : " does not have multidex support";
        ((StringBuilder)object).append(string);
        Log.i((String)"MultiDex", (String)((StringBuilder)object).toString());
        return bl;
    }

    private static void mkdirChecked(File file) throws IOException {
        StringBuilder stringBuilder;
        file.mkdir();
        if (file.isDirectory()) return;
        File file2 = file.getParentFile();
        if (file2 == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to create dir ");
            stringBuilder.append(file.getPath());
            stringBuilder.append(". Parent file is null.");
            Log.e((String)"MultiDex", (String)stringBuilder.toString());
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to create dir ");
            stringBuilder.append(file.getPath());
            stringBuilder.append(". parent file is a dir ");
            stringBuilder.append(file2.isDirectory());
            stringBuilder.append(", a file ");
            stringBuilder.append(file2.isFile());
            stringBuilder.append(", exists ");
            stringBuilder.append(file2.exists());
            stringBuilder.append(", readable ");
            stringBuilder.append(file2.canRead());
            stringBuilder.append(", writable ");
            stringBuilder.append(file2.canWrite());
            Log.e((String)"MultiDex", (String)stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to create directory ");
        stringBuilder.append(file.getPath());
        throw new IOException(stringBuilder.toString());
    }
}
