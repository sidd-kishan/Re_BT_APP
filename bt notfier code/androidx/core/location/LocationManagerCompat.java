/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.location.GnssStatus$Callback
 *  android.location.GpsStatus$Listener
 *  android.location.Location
 *  android.location.LocationListener
 *  android.location.LocationManager
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.SystemClock
 *  android.provider.Settings$Secure
 *  android.text.TextUtils
 *  androidx.collection.SimpleArrayMap
 *  androidx.core.location.GnssStatusCompat$Callback
 *  androidx.core.location.LocationCompat
 *  androidx.core.location.LocationManagerCompat$Api28Impl
 *  androidx.core.location.LocationManagerCompat$Api30Impl
 *  androidx.core.location.LocationManagerCompat$CancellableLocationListener
 *  androidx.core.location.LocationManagerCompat$GnssStatusTransport
 *  androidx.core.location.LocationManagerCompat$GpsStatusTransport
 *  androidx.core.location.LocationManagerCompat$InlineHandlerExecutor
 *  androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport
 *  androidx.core.os.CancellationSignal
 *  androidx.core.os.CancellationSignal$OnCancelListener
 *  androidx.core.os.ExecutorCompat
 *  androidx.core.util.Consumer
 */
package androidx.core.location;

import android.content.ContentResolver;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.location.LocationCompat;
import androidx.core.location.LocationManagerCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis ignored.
 */
public final class LocationManagerCompat {
    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000L;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000L;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5L;
    private static Field sContextField;
    private static final SimpleArrayMap<Object, Object> sGnssStatusListeners;

    static {
        sGnssStatusListeners = new SimpleArrayMap();
    }

    private LocationManagerCompat() {
    }

    public static void getCurrentLocation(LocationManager locationManager, String string, CancellationSignal cancellationSignal, Executor executor, Consumer<Location> consumer) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.getCurrentLocation((LocationManager)locationManager, (String)string, (CancellationSignal)cancellationSignal, (Executor)executor, consumer);
        } else {
            Location location;
            if (cancellationSignal != null) {
                cancellationSignal.throwIfCanceled();
            }
            if ((location = locationManager.getLastKnownLocation(string)) != null && SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis((Location)location) < 10000L) {
                executor.execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
                return;
            }
            executor = new CancellableLocationListener(locationManager, executor, consumer);
            locationManager.requestLocationUpdates(string, 0L, 0.0f, (LocationListener)executor, Looper.getMainLooper());
            if (cancellationSignal != null) {
                cancellationSignal.setOnCancelListener((CancellationSignal.OnCancelListener)new /* Unavailable Anonymous Inner Class!! */);
            }
            executor.startTimeout(30000L);
        }
    }

    public static String getGnssHardwareModelName(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT < 28) return null;
        return Api28Impl.getGnssHardwareModelName((LocationManager)locationManager);
    }

    public static int getGnssYearOfHardware(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT < 28) return 0;
        return Api28Impl.getGnssYearOfHardware((LocationManager)locationManager);
    }

    public static boolean isLocationEnabled(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.isLocationEnabled((LocationManager)locationManager);
        }
        int n = Build.VERSION.SDK_INT;
        boolean bl = false;
        boolean bl2 = false;
        if (n <= 19) {
            try {
                Field field;
                if (sContextField == null) {
                    sContextField = field = LocationManager.class.getDeclaredField("mContext");
                    field.setAccessible(true);
                }
                if ((field = (Context)sContextField.get(locationManager)) != null) {
                    if (Build.VERSION.SDK_INT == 19) {
                        if (Settings.Secure.getInt((ContentResolver)field.getContentResolver(), (String)"location_mode", (int)0) == 0) return bl2;
                        bl2 = true;
                        return bl2;
                    }
                    bl2 = TextUtils.isEmpty((CharSequence)Settings.Secure.getString((ContentResolver)field.getContentResolver(), (String)"location_providers_allowed"));
                    return bl2 ^ true;
                }
            }
            catch (ClassCastException | IllegalAccessException | NoSuchFieldException | SecurityException exception) {
                // empty catch block
            }
        }
        if (!locationManager.isProviderEnabled("network")) {
            bl2 = bl;
            if (!locationManager.isProviderEnabled("gps")) return bl2;
        }
        bl2 = true;
        return bl2;
    }

    /*
     * Exception decompiling
     */
    private static boolean registerGnssStatusCallback(LocationManager var0, Handler var1_16, Executor var2_17, GnssStatusCompat.Callback var3_18) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[TRYBLOCK]], but top level block is 5[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static boolean registerGnssStatusCallback(LocationManager locationManager, GnssStatusCompat.Callback callback, Handler handler) {
        if (Build.VERSION.SDK_INT < 30) return LocationManagerCompat.registerGnssStatusCallback(locationManager, (Executor)new InlineHandlerExecutor(handler), callback);
        return LocationManagerCompat.registerGnssStatusCallback(locationManager, ExecutorCompat.create((Handler)handler), callback);
    }

    public static boolean registerGnssStatusCallback(LocationManager locationManager, Executor executor, GnssStatusCompat.Callback callback) {
        Looper looper;
        if (Build.VERSION.SDK_INT >= 30) {
            return LocationManagerCompat.registerGnssStatusCallback(locationManager, null, executor, callback);
        }
        Looper looper2 = looper = Looper.myLooper();
        if (looper != null) return LocationManagerCompat.registerGnssStatusCallback(locationManager, new Handler(looper2), executor, callback);
        looper2 = Looper.getMainLooper();
        return LocationManagerCompat.registerGnssStatusCallback(locationManager, new Handler(looper2), executor, callback);
    }

    /*
     * Enabled force condition propagation
     */
    public static void unregisterGnssStatusCallback(LocationManager locationManager, GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            SimpleArrayMap<Object, Object> simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                callback = (GnssStatusTransport)sGnssStatusListeners.remove((Object)callback);
                if (callback == null) return;
                locationManager.unregisterGnssStatusCallback((GnssStatus.Callback)callback);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            SimpleArrayMap<Object, Object> simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                callback = (PreRGnssStatusTransport)sGnssStatusListeners.remove((Object)callback);
                if (callback == null) return;
                callback.unregister();
                locationManager.unregisterGnssStatusCallback((GnssStatus.Callback)callback);
                return;
            }
        }
        SimpleArrayMap<Object, Object> simpleArrayMap = sGnssStatusListeners;
        synchronized (simpleArrayMap) {
            callback = (GpsStatusTransport)sGnssStatusListeners.remove((Object)callback);
            if (callback == null) return;
            callback.unregister();
            locationManager.removeGpsStatusListener((GpsStatus.Listener)callback);
            return;
        }
    }
}
