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
 *  androidx.core.app.CoreComponentFactory$CompatWrapped
 */
package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import androidx.core.app.CoreComponentFactory;

public class CoreComponentFactory
extends AppComponentFactory {
    static <T> T checkCompatWrapper(T t) {
        if (!(t instanceof CompatWrapped)) return t;
        Object object = ((CompatWrapped)t).getWrapper();
        if (object == null) return t;
        return (T)object;
    }

    public Activity instantiateActivity(ClassLoader classLoader, String string, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(super.instantiateActivity(classLoader, string, intent));
    }

    public Application instantiateApplication(ClassLoader classLoader, String string) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(super.instantiateApplication(classLoader, string));
    }

    public ContentProvider instantiateProvider(ClassLoader classLoader, String string) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(super.instantiateProvider(classLoader, string));
    }

    public BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String string, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(super.instantiateReceiver(classLoader, string, intent));
    }

    public Service instantiateService(ClassLoader classLoader, String string, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(super.instantiateService(classLoader, string, intent));
    }
}
