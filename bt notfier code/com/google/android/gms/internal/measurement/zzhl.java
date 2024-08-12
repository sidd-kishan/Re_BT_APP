/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgy
 *  com.google.android.gms.internal.measurement.zzhd
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgy;
import com.google.android.gms.internal.measurement.zzhd;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzhl<T extends zzhd> {
    private static final Logger zza = Logger.getLogger(zzgy.class.getName());
    private static final String zzb = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzhl() {
    }

    static <T extends zzhd> T zzb(Class<T> serializable) {
        Object object;
        Object object2 = zzhl.class.getClassLoader();
        if (serializable.equals(zzhd.class)) {
            object = zzb;
        } else {
            if (!((Class)serializable).getPackage().equals(zzhl.class.getPackage())) {
                serializable = new IllegalArgumentException(((Class)serializable).getName());
                throw serializable;
            }
            object = String.format("%s.BlazeGenerated%sLoader", ((Class)serializable).getPackage().getName(), ((Class)serializable).getSimpleName());
        }
        try {
            object = Class.forName((String)object, true, (ClassLoader)object2);
            try {
                object = (zzhl)((Class)object).getConstructor(new Class[0]).newInstance(new Object[0]);
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
            return (T)((zzhd)((Class)serializable).cast(((zzhl)object).zza()));
        }
        catch (ClassNotFoundException classNotFoundException) {
            Iterator<zzhl> iterator = ServiceLoader.load(zzhl.class, (ClassLoader)object2).iterator();
            ArrayList arrayList = new ArrayList();
            while (iterator.hasNext()) {
                try {
                    arrayList.add(((Class)serializable).cast(iterator.next().zza()));
                }
                catch (ServiceConfigurationError serviceConfigurationError) {
                    Logger logger = zza;
                    object2 = Level.SEVERE;
                    String string = String.valueOf(((Class)serializable).getSimpleName());
                    string = string.length() != 0 ? "Unable to load ".concat(string) : new String("Unable to load ");
                    logger.logp((Level)object2, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", string, serviceConfigurationError);
                }
            }
            if (arrayList.size() == 1) {
                return (T)((zzhd)arrayList.get(0));
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                serializable = (zzhd)((Class)serializable).getMethod("combine", Collection.class).invoke(null, arrayList);
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
