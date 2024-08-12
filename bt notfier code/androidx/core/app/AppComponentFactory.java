/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AppComponentFactory
 *  android.app.Application
 *  android.app.Service
 *  android.content.BroadcastReceiver
 *  android.content.ContentProvider
 *  android.content.Intent
 *  androidx.core.app.CoreComponentFactory
 */
package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import androidx.core.app.CoreComponentFactory;
import java.lang.reflect.InvocationTargetException;

public class AppComponentFactory
extends android.app.AppComponentFactory {
    public final Activity instantiateActivity(ClassLoader classLoader, String string, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Activity)CoreComponentFactory.checkCompatWrapper((Object)this.instantiateActivityCompat(classLoader, string, intent));
    }

    /*
     * WARNING - void declaration
     */
    public Activity instantiateActivityCompat(ClassLoader classLoader, String string, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        void var1_4;
        try {
            classLoader = Class.forName(string, false, classLoader).asSubclass(Activity.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            return classLoader;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InvocationTargetException invocationTargetException) {
            // empty catch block
        }
        throw new RuntimeException("Couldn't call constructor", (Throwable)var1_4);
    }

    public final Application instantiateApplication(ClassLoader classLoader, String string) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Application)CoreComponentFactory.checkCompatWrapper((Object)this.instantiateApplicationCompat(classLoader, string));
    }

    /*
     * WARNING - void declaration
     */
    public Application instantiateApplicationCompat(ClassLoader classLoader, String string) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        void var1_4;
        try {
            classLoader = Class.forName(string, false, classLoader).asSubclass(Application.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            return classLoader;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InvocationTargetException invocationTargetException) {
            // empty catch block
        }
        throw new RuntimeException("Couldn't call constructor", (Throwable)var1_4);
    }

    public final ContentProvider instantiateProvider(ClassLoader classLoader, String string) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (ContentProvider)CoreComponentFactory.checkCompatWrapper((Object)this.instantiateProviderCompat(classLoader, string));
    }

    /*
     * WARNING - void declaration
     */
    public ContentProvider instantiateProviderCompat(ClassLoader classLoader, String string) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        void var1_4;
        try {
            classLoader = Class.forName(string, false, classLoader).asSubclass(ContentProvider.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            return classLoader;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InvocationTargetException invocationTargetException) {
            // empty catch block
        }
        throw new RuntimeException("Couldn't call constructor", (Throwable)var1_4);
    }

    public final BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String string, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (BroadcastReceiver)CoreComponentFactory.checkCompatWrapper((Object)this.instantiateReceiverCompat(classLoader, string, intent));
    }

    /*
     * WARNING - void declaration
     */
    public BroadcastReceiver instantiateReceiverCompat(ClassLoader classLoader, String string, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        void var1_4;
        try {
            classLoader = Class.forName(string, false, classLoader).asSubclass(BroadcastReceiver.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            return classLoader;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InvocationTargetException invocationTargetException) {
            // empty catch block
        }
        throw new RuntimeException("Couldn't call constructor", (Throwable)var1_4);
    }

    public final Service instantiateService(ClassLoader classLoader, String string, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Service)CoreComponentFactory.checkCompatWrapper((Object)this.instantiateServiceCompat(classLoader, string, intent));
    }

    /*
     * WARNING - void declaration
     */
    public Service instantiateServiceCompat(ClassLoader classLoader, String string, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        void var1_4;
        try {
            classLoader = Class.forName(string, false, classLoader).asSubclass(Service.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            return classLoader;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InvocationTargetException invocationTargetException) {
            // empty catch block
        }
        throw new RuntimeException("Couldn't call constructor", (Throwable)var1_4);
    }
}
