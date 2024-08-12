/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  androidx.startup.InitializationProvider
 *  androidx.startup.Initializer
 *  androidx.startup.R$string
 *  androidx.startup.StartupException
 *  androidx.tracing.Trace
 */
package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import androidx.startup.Initializer;
import androidx.startup.R;
import androidx.startup.StartupException;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class AppInitializer {
    private static final String SECTION_NAME = "Startup";
    private static volatile AppInitializer sInstance;
    private static final Object sLock;
    final Context mContext;
    final Set<Class<? extends Initializer<?>>> mDiscovered;
    final Map<Class<?>, Object> mInitialized;

    static {
        sLock = new Object();
    }

    AppInitializer(Context context) {
        this.mContext = context.getApplicationContext();
        this.mDiscovered = new HashSet();
        this.mInitialized = new HashMap();
    }

    public static AppInitializer getInstance(Context context) {
        if (sInstance != null) return sInstance;
        Object object = sLock;
        synchronized (object) {
            AppInitializer appInitializer;
            if (sInstance != null) return sInstance;
            sInstance = appInitializer = new AppInitializer(context);
        }
        return sInstance;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    void discoverAndInitialize() {
        Throwable throwable2;
        block7: {
            block6: {
                try {
                    Trace.beginSection((String)SECTION_NAME);
                    Object object = new ComponentName(this.mContext.getPackageName(), InitializationProvider.class.getName());
                    Bundle bundle = this.mContext.getPackageManager().getProviderInfo((ComponentName)object, (int)128).metaData;
                    String string2 = this.mContext.getString(R.string.androidx_startup);
                    if (bundle == null) break block6;
                    HashSet hashSet = new HashSet();
                    for (Object object2 : bundle.keySet()) {
                        if (!string2.equals(bundle.getString((String)object2, null)) || !Initializer.class.isAssignableFrom((Class<?>)(object2 = Class.forName((String)object2)))) continue;
                        this.mDiscovered.add((Class<Initializer<?>>)object2);
                        this.doInitialize((Class<? extends Initializer<?>>)object2, hashSet);
                    }
                }
                catch (Throwable throwable2) {
                    break block7;
                }
                catch (ClassNotFoundException classNotFoundException) {
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    // empty catch block
                }
            }
            Trace.endSection();
            return;
            {
                void var1_5;
                StartupException startupException = new StartupException((Throwable)var1_5);
                throw startupException;
            }
        }
        Trace.endSection();
        throw throwable2;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    <T> T doInitialize(Class<? extends Initializer<?>> var1_1, Set<Class<?>> var2_5) {
        var5_6 = AppInitializer.sLock;
        synchronized (var5_6) {
            var3_7 = Trace.isEnabled();
            if (!var3_7) ** GOTO lbl8
            Trace.beginSection((String)var1_1.getSimpleName());
lbl8:
            // 2 sources

            if (var2_5.contains(var1_1)) ** GOTO lbl40
            if (this.mInitialized.containsKey(var1_1)) ** GOTO lbl34
            var2_5.add(var1_1);
            try {
                var4_8 /* !! */  = (Initializer)var1_1.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                var6_9 = var4_8 /* !! */ .dependencies();
                if (!var6_9.isEmpty()) {
                    var7_10 = var6_9.iterator();
                    while (var7_10.hasNext()) {
                        var6_9 = (Class)var7_10.next();
                        if (this.mInitialized.containsKey(var6_9)) continue;
                        this.doInitialize((Class<? extends Initializer<?>>)var6_9, (Set<Class<?>>)var2_5);
                    }
                }
                var4_8 /* !! */  = var4_8 /* !! */ .create(this.mContext);
                var2_5.remove(var1_1);
                this.mInitialized.put((Class<?>)var1_1, var4_8 /* !! */ );
                var1_1 = var4_8 /* !! */ ;
                ** GOTO lbl36
            }
            catch (Throwable var1_2) {
                var2_5 = new StartupException(var1_2);
                throw var2_5;
lbl34:
                // 1 sources

                var1_1 = this.mInitialized.get(var1_1);
lbl36:
                // 3 sources

                Trace.endSection();
                {
                    catch (Throwable var1_4) {
                        throw var1_4;
                    }
                }
                return (T)var1_1;
lbl40:
                // 1 sources

                try {
                    var2_5 = String.format("Cannot initialize %s. Cycle detected.", new Object[]{var1_1.getName()});
                    var1_1 = new IllegalStateException((String)var2_5);
                    throw var1_1;
                }
                catch (Throwable var1_3) {
                    Trace.endSection();
                    throw var1_3;
                }
            }
        }
    }

    public <T> T initializeComponent(Class<? extends Initializer<T>> clazz) {
        return this.doInitialize(clazz, new HashSet());
    }

    public boolean isEagerlyInitialized(Class<? extends Initializer<?>> clazz) {
        return this.mDiscovered.contains(clazz);
    }
}
