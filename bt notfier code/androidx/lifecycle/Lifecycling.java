/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ClassesInfoCache
 *  androidx.lifecycle.CompositeGeneratedAdaptersObserver
 *  androidx.lifecycle.FullLifecycleObserver
 *  androidx.lifecycle.FullLifecycleObserverAdapter
 *  androidx.lifecycle.GeneratedAdapter
 *  androidx.lifecycle.GenericLifecycleObserver
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.ReflectiveGenericLifecycleObserver
 *  androidx.lifecycle.SingleGeneratedAdapterObserver
 */
package androidx.lifecycle;

import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lifecycling {
    private static final int GENERATED_CALLBACK = 2;
    private static final int REFLECTIVE_CALLBACK = 1;
    private static Map<Class<?>, Integer> sCallbackCache = new HashMap();
    private static Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> sClassToAdapters = new HashMap();

    private Lifecycling() {
    }

    private static GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> generatedAdapter, Object object) {
        try {
            generatedAdapter = generatedAdapter.newInstance(object);
            return generatedAdapter;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(invocationTargetException);
        }
        catch (InstantiationException instantiationException) {
            throw new RuntimeException(instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    private static Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> genericDeclaration) {
        try {
            Object object = ((Class)genericDeclaration).getPackage();
            String string = ((Class)genericDeclaration).getCanonicalName();
            object = object != null ? ((Package)object).getName() : "";
            if (!((String)object).isEmpty()) {
                string = string.substring(((String)object).length() + 1);
            }
            string = Lifecycling.getAdapterName(string);
            if (((String)object).isEmpty()) {
                object = string;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)object);
                stringBuilder.append(".");
                stringBuilder.append(string);
                object = stringBuilder.toString();
            }
            genericDeclaration = Class.forName((String)object).getDeclaredConstructor(new Class[]{genericDeclaration});
            if (((AccessibleObject)((Object)genericDeclaration)).isAccessible()) return genericDeclaration;
            ((AccessibleObject)((Object)genericDeclaration)).setAccessible(true);
            return genericDeclaration;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException(noSuchMethodException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    public static String getAdapterName(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.replace(".", "_"));
        stringBuilder.append("_LifecycleAdapter");
        return stringBuilder.toString();
    }

    @Deprecated
    static GenericLifecycleObserver getCallback(Object object) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    private static int getObserverConstructorType(Class<?> clazz) {
        Integer n = sCallbackCache.get(clazz);
        if (n != null) {
            return n;
        }
        int n2 = Lifecycling.resolveObserverCallbackType(clazz);
        sCallbackCache.put(clazz, n2);
        return n2;
    }

    private static boolean isLifecycleParent(Class<?> clazz) {
        boolean bl = clazz != null && LifecycleObserver.class.isAssignableFrom(clazz);
        return bl;
    }

    static LifecycleEventObserver lifecycleEventObserver(Object object) {
        boolean bl = object instanceof LifecycleEventObserver;
        boolean bl2 = object instanceof FullLifecycleObserver;
        if (bl && bl2) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver)object, (LifecycleEventObserver)object);
        }
        if (bl2) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver)object, null);
        }
        if (bl) {
            return (LifecycleEventObserver)object;
        }
        GeneratedAdapter[] generatedAdapterArray = object.getClass();
        if (Lifecycling.getObserverConstructorType(generatedAdapterArray) != 2) return new ReflectiveGenericLifecycleObserver(object);
        List<Constructor<? extends GeneratedAdapter>> list = sClassToAdapters.get(generatedAdapterArray);
        int n = list.size();
        int n2 = 0;
        if (n == 1) {
            return new SingleGeneratedAdapterObserver(Lifecycling.createGeneratedAdapter(list.get(0), object));
        }
        generatedAdapterArray = new GeneratedAdapter[list.size()];
        while (n2 < list.size()) {
            generatedAdapterArray[n2] = Lifecycling.createGeneratedAdapter(list.get(n2), object);
            ++n2;
        }
        return new CompositeGeneratedAdaptersObserver(generatedAdapterArray);
    }

    private static int resolveObserverCallbackType(Class<?> clazz) {
        if (clazz.getCanonicalName() == null) {
            return 1;
        }
        Object object = Lifecycling.generatedConstructor(clazz);
        if (object != null) {
            sClassToAdapters.put(clazz, Collections.singletonList(object));
            return 2;
        }
        if (ClassesInfoCache.sInstance.hasLifecycleMethods(clazz)) {
            return 1;
        }
        ArrayList arrayList = clazz.getSuperclass();
        object = null;
        if (Lifecycling.isLifecycleParent(arrayList)) {
            if (Lifecycling.getObserverConstructorType(arrayList) == 1) {
                return 1;
            }
            object = new ArrayList(sClassToAdapters.get(arrayList));
        }
        Class<?>[] classArray = clazz.getInterfaces();
        int n = classArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                if (object == null) return 1;
                sClassToAdapters.put(clazz, (List<Constructor<? extends GeneratedAdapter>>)object);
                return 2;
            }
            Class<?> clazz2 = classArray[n2];
            if (Lifecycling.isLifecycleParent(clazz2)) {
                if (Lifecycling.getObserverConstructorType(clazz2) == 1) {
                    return 1;
                }
                arrayList = object;
                if (object == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(sClassToAdapters.get(clazz2));
                object = arrayList;
            }
            ++n2;
        }
    }
}
