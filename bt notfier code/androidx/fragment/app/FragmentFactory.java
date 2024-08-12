/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.SimpleArrayMap
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.Fragment$InstantiationException
 */
package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;

public class FragmentFactory {
    private static final SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> sClassCacheMap = new SimpleArrayMap();

    static boolean isFragmentClass(ClassLoader classLoader, String string) {
        try {
            boolean bl = Fragment.class.isAssignableFrom(FragmentFactory.loadClass(classLoader, string));
            return bl;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
    }

    private static Class<?> loadClass(ClassLoader classLoader, String string) throws ClassNotFoundException {
        Object object;
        SimpleArrayMap simpleArrayMap = object = (SimpleArrayMap)sClassCacheMap.get((Object)classLoader);
        if (object == null) {
            simpleArrayMap = new SimpleArrayMap();
            sClassCacheMap.put((Object)classLoader, (Object)simpleArrayMap);
        }
        Class clazz = (Class)simpleArrayMap.get((Object)string);
        object = clazz;
        if (clazz != null) return object;
        object = Class.forName(string, false, classLoader);
        simpleArrayMap.put((Object)string, object);
        return object;
    }

    public static Class<? extends Fragment> loadFragmentClass(ClassLoader object, String string) {
        try {
            object = FragmentFactory.loadClass((ClassLoader)object, string);
            return object;
        }
        catch (ClassCastException classCastException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to instantiate fragment ");
            stringBuilder.append(string);
            stringBuilder.append(": make sure class is a valid subclass of Fragment");
            throw new Fragment.InstantiationException(stringBuilder.toString(), (Exception)classCastException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Unable to instantiate fragment ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(": make sure class name exists");
            throw new Fragment.InstantiationException(((StringBuilder)object).toString(), (Exception)classNotFoundException);
        }
    }

    public Fragment instantiate(ClassLoader object, String string) {
        try {
            object = FragmentFactory.loadFragmentClass((ClassLoader)object, string).getConstructor(new Class[0]).newInstance(new Object[0]);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Unable to instantiate fragment ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(": calling Fragment constructor caused an exception");
            throw new Fragment.InstantiationException(((StringBuilder)object).toString(), (Exception)invocationTargetException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Unable to instantiate fragment ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(": could not find Fragment constructor");
            throw new Fragment.InstantiationException(((StringBuilder)object).toString(), (Exception)noSuchMethodException);
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to instantiate fragment ");
            stringBuilder.append(string);
            stringBuilder.append(": make sure class name exists, is public, and has an empty constructor that is public");
            throw new Fragment.InstantiationException(stringBuilder.toString(), (Exception)illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to instantiate fragment ");
            stringBuilder.append(string);
            stringBuilder.append(": make sure class name exists, is public, and has an empty constructor that is public");
            throw new Fragment.InstantiationException(stringBuilder.toString(), (Exception)instantiationException);
        }
    }
}
