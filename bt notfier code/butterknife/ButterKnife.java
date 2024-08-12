/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.util.Log
 *  android.view.View
 *  butterknife.Unbinder
 */
package butterknife;

import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.view.View;
import butterknife.Unbinder;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ButterKnife {
    static final Map<Class<?>, Constructor<? extends Unbinder>> BINDINGS = new LinkedHashMap();
    private static final String TAG = "ButterKnife";
    private static boolean debug;

    private ButterKnife() {
        throw new AssertionError((Object)"No instances.");
    }

    public static Unbinder bind(Activity activity) {
        return ButterKnife.bind((Object)activity, activity.getWindow().getDecorView());
    }

    public static Unbinder bind(Dialog dialog) {
        return ButterKnife.bind((Object)dialog, dialog.getWindow().getDecorView());
    }

    public static Unbinder bind(View view) {
        return ButterKnife.bind((Object)view, view);
    }

    public static Unbinder bind(Object object, Activity activity) {
        return ButterKnife.bind(object, activity.getWindow().getDecorView());
    }

    public static Unbinder bind(Object object, Dialog dialog) {
        return ButterKnife.bind(object, dialog.getWindow().getDecorView());
    }

    public static Unbinder bind(Object object, View object2) {
        GenericDeclaration genericDeclaration = object.getClass();
        if (debug) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Looking up binding for ");
            stringBuilder.append(((Class)genericDeclaration).getName());
            Log.d((String)TAG, (String)stringBuilder.toString());
        }
        if ((genericDeclaration = ButterKnife.findBindingConstructorForClass(genericDeclaration)) == null) {
            return Unbinder.EMPTY;
        }
        try {
            object = (Unbinder)((Constructor)genericDeclaration).newInstance(object, object2);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getCause();
            if (throwable instanceof RuntimeException) throw (RuntimeException)throwable;
            if (!(throwable instanceof Error)) throw new RuntimeException("Unable to create binding instance.", throwable);
            throw (Error)throwable;
        }
        catch (InstantiationException instantiationException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to invoke ");
            ((StringBuilder)object2).append(genericDeclaration);
            throw new RuntimeException(((StringBuilder)object2).toString(), instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to invoke ");
            ((StringBuilder)object2).append(genericDeclaration);
            throw new RuntimeException(((StringBuilder)object2).toString(), illegalAccessException);
        }
    }

    private static Constructor<? extends Unbinder> findBindingConstructorForClass(Class<?> serializable) {
        Constructor<? extends Unbinder> constructor = BINDINGS.get(serializable);
        if (constructor == null && !BINDINGS.containsKey(serializable)) {
            String string = ((Class)serializable).getName();
            if (!(string.startsWith("android.") || string.startsWith("java.") || string.startsWith("androidx."))) {
                try {
                    constructor = ((Class)serializable).getClassLoader();
                    Object object = new StringBuilder();
                    ((StringBuilder)object).append(string);
                    ((StringBuilder)object).append("_ViewBinding");
                    constructor = object = ((ClassLoader)((Object)constructor)).loadClass(((StringBuilder)object).toString()).getConstructor(new Class[]{serializable, View.class});
                    if (debug) {
                        Log.d((String)TAG, (String)"HIT: Loaded binding class and constructor.");
                        constructor = object;
                    }
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append("Unable to find binding constructor for ");
                    ((StringBuilder)serializable).append(string);
                    throw new RuntimeException(((StringBuilder)serializable).toString(), noSuchMethodException);
                }
                catch (ClassNotFoundException classNotFoundException) {
                    if (debug) {
                        constructor = new StringBuilder();
                        ((StringBuilder)((Object)constructor)).append("Not found. Trying superclass ");
                        ((StringBuilder)((Object)constructor)).append(((Class)serializable).getSuperclass().getName());
                        Log.d((String)TAG, (String)((StringBuilder)((Object)constructor)).toString());
                    }
                    constructor = ButterKnife.findBindingConstructorForClass(((Class)serializable).getSuperclass());
                }
                BINDINGS.put((Class<?>)serializable, (Constructor<Unbinder>)constructor);
                return constructor;
            }
            if (!debug) return null;
            Log.d((String)TAG, (String)"MISS: Reached framework class. Abandoning search.");
            return null;
        }
        if (!debug) return constructor;
        Log.d((String)TAG, (String)"HIT: Cached in binding map.");
        return constructor;
    }

    public static void setDebug(boolean bl) {
        debug = bl;
    }
}
