/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory
 *  android.view.LayoutInflater$Factory2
 *  androidx.core.view.LayoutInflaterCompat$Factory2Wrapper
 *  androidx.core.view.LayoutInflaterFactory
 */
package androidx.core.view;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.LayoutInflaterFactory;
import java.lang.reflect.Field;

public final class LayoutInflaterCompat {
    private static final String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;

    private LayoutInflaterCompat() {
    }

    private static void forceSetFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 object) {
        Field field;
        if (!sCheckedField) {
            try {
                sLayoutInflaterFactory2Field = field = LayoutInflater.class.getDeclaredField("mFactory2");
                field.setAccessible(true);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
                stringBuilder.append(LayoutInflater.class.getName());
                stringBuilder.append("; inflation may have unexpected results.");
                Log.e((String)TAG, (String)stringBuilder.toString(), (Throwable)noSuchFieldException);
            }
            sCheckedField = true;
        }
        if ((field = sLayoutInflaterFactory2Field) == null) return;
        try {
            field.set(layoutInflater, object);
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
            ((StringBuilder)object).append(layoutInflater);
            ((StringBuilder)object).append("; inflation may have unexpected results.");
            Log.e((String)TAG, (String)((StringBuilder)object).toString(), (Throwable)illegalAccessException);
        }
    }

    @Deprecated
    public static LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
        if (!((layoutInflater = layoutInflater.getFactory()) instanceof Factory2Wrapper)) return null;
        return ((Factory2Wrapper)layoutInflater).mDelegateFactory;
    }

    @Deprecated
    public static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        int n = Build.VERSION.SDK_INT;
        Factory2Wrapper factory2Wrapper = null;
        Factory2Wrapper factory2Wrapper2 = null;
        if (n >= 21) {
            if (layoutInflaterFactory != null) {
                factory2Wrapper2 = new Factory2Wrapper(layoutInflaterFactory);
            }
            layoutInflater.setFactory2(factory2Wrapper2);
        } else {
            factory2Wrapper2 = factory2Wrapper;
            if (layoutInflaterFactory != null) {
                factory2Wrapper2 = new Factory2Wrapper(layoutInflaterFactory);
            }
            layoutInflater.setFactory2((LayoutInflater.Factory2)factory2Wrapper2);
            layoutInflaterFactory = layoutInflater.getFactory();
            if (layoutInflaterFactory instanceof LayoutInflater.Factory2) {
                LayoutInflaterCompat.forceSetFactory2(layoutInflater, (LayoutInflater.Factory2)layoutInflaterFactory);
            } else {
                LayoutInflaterCompat.forceSetFactory2(layoutInflater, (LayoutInflater.Factory2)factory2Wrapper2);
            }
        }
    }

    public static void setFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT >= 21) return;
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflater.Factory2) {
            LayoutInflaterCompat.forceSetFactory2(layoutInflater, (LayoutInflater.Factory2)factory);
        } else {
            LayoutInflaterCompat.forceSetFactory2(layoutInflater, factory2);
        }
    }
}
