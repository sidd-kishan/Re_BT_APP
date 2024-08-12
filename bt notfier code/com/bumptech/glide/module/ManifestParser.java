/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 *  com.bumptech.glide.module.GlideModule
 */
package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bumptech.glide.module.GlideModule;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private static final String TAG = "ManifestParser";
    private final Context context;

    public ManifestParser(Context context) {
        this.context = context;
    }

    private static GlideModule parseModule(String string) {
        Object object;
        Class<?> clazz;
        try {
            clazz = Class.forName(string);
            string = null;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", classNotFoundException);
        }
        try {
            object = clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            string = object;
        }
        catch (InvocationTargetException invocationTargetException) {
            ManifestParser.throwInstantiateGlideModuleException(clazz, invocationTargetException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            ManifestParser.throwInstantiateGlideModuleException(clazz, noSuchMethodException);
        }
        catch (IllegalAccessException illegalAccessException) {
            ManifestParser.throwInstantiateGlideModuleException(clazz, illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            ManifestParser.throwInstantiateGlideModuleException(clazz, instantiationException);
        }
        if (string instanceof GlideModule) {
            return (GlideModule)string;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Expected instanceof GlideModule, but found: ");
        ((StringBuilder)object).append((Object)string);
        throw new RuntimeException(((StringBuilder)object).toString());
    }

    private static void throwInstantiateGlideModuleException(Class<?> clazz, Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to instantiate GlideModule implementation for ");
        stringBuilder.append(clazz);
        throw new RuntimeException(stringBuilder.toString(), exception);
    }

    public List<GlideModule> parse() {
        if (Log.isLoggable((String)TAG, (int)3)) {
            Log.d((String)TAG, (String)"Loading Glide modules");
        }
        ArrayList<GlideModule> arrayList = new ArrayList<GlideModule>();
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (!Log.isLoggable((String)TAG, (int)3)) return arrayList;
                Log.d((String)TAG, (String)"Got null app info metadata");
                return arrayList;
            }
            if (Log.isLoggable((String)TAG, (int)2)) {
                CharSequence charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Got app info metadata: ");
                ((StringBuilder)charSequence).append(applicationInfo.metaData);
                Log.v((String)TAG, (String)((StringBuilder)charSequence).toString());
            }
            for (CharSequence charSequence : applicationInfo.metaData.keySet()) {
                if (!GLIDE_MODULE_VALUE.equals(applicationInfo.metaData.get((String)charSequence))) continue;
                arrayList.add(ManifestParser.parseModule((String)charSequence));
                if (!Log.isLoggable((String)TAG, (int)3)) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Loaded Glide module: ");
                stringBuilder.append((String)charSequence);
                Log.d((String)TAG, (String)stringBuilder.toString());
            }
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            RuntimeException runtimeException = new RuntimeException("Unable to find metadata to parse GlideModules", nameNotFoundException);
            throw runtimeException;
        }
        if (!Log.isLoggable((String)TAG, (int)3)) return arrayList;
        Log.d((String)TAG, (String)"Finished loading Glide modules");
        return arrayList;
    }
}
