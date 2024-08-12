/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgfh
 *  com.google.android.gms.internal.ads.zzgfm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgfh;
import com.google.android.gms.internal.ads.zzgfm;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzgfu<T extends zzgfm> {
    private static final Logger zza = Logger.getLogger(zzgfh.class.getName());
    private static final String zzb = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzgfu() {
    }

    static <T extends zzgfm> T zzb(Class<T> serializable) {
        Object object;
        Object object2 = zzgfu.class.getClassLoader();
        if (serializable.equals(zzgfm.class)) {
            object = zzb;
        } else {
            if (!((Class)serializable).getPackage().equals(zzgfu.class.getPackage())) {
                serializable = new IllegalArgumentException(((Class)serializable).getName());
                throw serializable;
            }
            object = String.format("%s.BlazeGenerated%sLoader", ((Class)serializable).getPackage().getName(), ((Class)serializable).getSimpleName());
        }
        try {
            object = Class.forName((String)object, true, (ClassLoader)object2);
            try {
                object = (zzgfu)((Class)object).getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            catch (InvocationTargetException invocationTargetException) {
                IllegalStateException illegalStateException = new IllegalStateException(invocationTargetException);
                throw illegalStateException;
            }
            catch (IllegalAccessException illegalAccessException) {
                object = new IllegalStateException(illegalAccessException);
                throw object;
            }
            catch (InstantiationException instantiationException) {
                IllegalStateException illegalStateException = new IllegalStateException(instantiationException);
                throw illegalStateException;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                IllegalStateException illegalStateException = new IllegalStateException(noSuchMethodException);
                throw illegalStateException;
            }
            return (T)((zzgfm)((Class)serializable).cast(((zzgfu)object).zza()));
        }
        catch (ClassNotFoundException classNotFoundException) {
            object2 = ServiceLoader.load(zzgfu.class, (ClassLoader)object2).iterator();
            ArrayList arrayList = new ArrayList();
            while (object2.hasNext()) {
                try {
                    arrayList.add(((Class)serializable).cast(((zzgfu)object2.next()).zza()));
                }
                catch (ServiceConfigurationError serviceConfigurationError) {
                    Logger logger = zza;
                    Level level = Level.SEVERE;
                    String string = String.valueOf(((Class)serializable).getSimpleName());
                    string = string.length() != 0 ? "Unable to load ".concat(string) : new String("Unable to load ");
                    logger.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", string, serviceConfigurationError);
                }
            }
            if (arrayList.size() == 1) {
                return (T)((zzgfm)arrayList.get(0));
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                serializable = (zzgfm)((Class)serializable).getMethod("combine", Collection.class).invoke(null, arrayList);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new IllegalStateException(invocationTargetException);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new IllegalStateException(illegalAccessException);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new IllegalStateException(noSuchMethodException);
            }
            return (T)serializable;
        }
    }

    protected abstract T zza();
}
