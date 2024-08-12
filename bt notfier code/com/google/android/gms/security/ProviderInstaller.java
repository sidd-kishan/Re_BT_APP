/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  android.util.Log
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.GooglePlayServicesNotAvailableException
 *  com.google.android.gms.common.GooglePlayServicesRepairableException
 *  com.google.android.gms.common.GooglePlayServicesUtilLight
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamite.DynamiteModule
 *  com.google.android.gms.dynamite.DynamiteModule$LoadingException
 *  com.google.android.gms.dynamite.DynamiteModule$VersionPolicy
 *  com.google.android.gms.security.ProviderInstaller$ProviderInstallListener
 *  com.google.android.gms.security.zza
 */
package com.google.android.gms.security;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.security.ProviderInstaller;
import com.google.android.gms.security.zza;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final GoogleApiAvailabilityLight zza = GoogleApiAvailabilityLight.getInstance();
    private static final Object zzb = new Object();
    private static Method zzc = null;
    private static Method zzd = null;

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Preconditions.checkNotNull((Object)context, (Object)"Context must not be null");
        zza.verifyGooglePlayServicesIsAvailable(context, 11925000);
        Object object = zzb;
        synchronized (object) {
            Object object2;
            long l = SystemClock.elapsedRealtime();
            try {
                object2 = DynamiteModule.load((Context)context, (DynamiteModule.VersionPolicy)DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, (String)"com.google.android.gms.providerinstaller.dynamite").getModuleContext();
            }
            catch (DynamiteModule.LoadingException loadingException) {
                object2 = String.valueOf(loadingException.getMessage());
                object2 = ((String)object2).length() != 0 ? "Failed to load providerinstaller module: ".concat((String)object2) : new String("Failed to load providerinstaller module: ");
                Log.w((String)"ProviderInstaller", (String)object2);
                object2 = null;
            }
            if (object2 != null) {
                ProviderInstaller.zzb((Context)object2, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                return;
            }
            long l2 = SystemClock.elapsedRealtime();
            Context context2 = GooglePlayServicesUtilLight.getRemoteContext((Context)context);
            if (context2 != null) {
                try {
                    if (zzd == null) {
                        zzd = ProviderInstaller.zzc(context2, "com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats", new Class[]{Context.class, Long.TYPE, Long.TYPE});
                    }
                    zzd.invoke(null, context, l, l2);
                }
                catch (Exception exception) {
                    String string = String.valueOf(exception.getMessage());
                    string = string.length() != 0 ? "Failed to report request stats: ".concat(string) : new String("Failed to report request stats: ");
                    Log.w((String)"ProviderInstaller", (String)string);
                }
            }
            if (context2 != null) {
                ProviderInstaller.zzb(context2, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
                return;
            }
            Log.e((String)"ProviderInstaller", (String)"Failed to get remote context");
            context = new GooglePlayServicesNotAvailableException(8);
            throw context;
        }
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull((Object)context, (Object)"Context must not be null");
        Preconditions.checkNotNull((Object)providerInstallListener, (Object)"Listener must not be null");
        Preconditions.checkMainThread((String)"Must be called on the UI thread");
        new zza(context, providerInstallListener).execute((Object[])new Void[0]);
    }

    static /* synthetic */ GoogleApiAvailabilityLight zza() {
        return zza;
    }

    private static void zzb(Context context, Context object, String string) throws GooglePlayServicesNotAvailableException {
        try {
            if (zzc == null) {
                zzc = ProviderInstaller.zzc(context, string, "insertProvider", new Class[]{Context.class});
            }
            zzc.invoke(null, context);
            return;
        }
        catch (Exception exception) {
            object = exception.getCause();
            if (!Log.isLoggable((String)"ProviderInstaller", (int)6)) throw new GooglePlayServicesNotAvailableException(8);
            String string2 = object == null ? exception.getMessage() : ((Throwable)object).getMessage();
            string2 = String.valueOf(string2);
            string2 = string2.length() != 0 ? "Failed to install provider: ".concat(string2) : new String("Failed to install provider: ");
            Log.e((String)"ProviderInstaller", (String)string2);
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }

    private static Method zzc(Context context, String string, String string2, Class[] classArray) throws ClassNotFoundException, NoSuchMethodException {
        return context.getClassLoader().loadClass(string).getMethod(string2, classArray);
    }
}
