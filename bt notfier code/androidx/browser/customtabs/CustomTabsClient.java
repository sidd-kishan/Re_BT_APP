/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.support.customtabs.ICustomTabsCallback
 *  android.support.customtabs.ICustomTabsService
 *  android.text.TextUtils
 *  androidx.browser.customtabs.CustomTabsCallback
 *  androidx.browser.customtabs.CustomTabsClient$1
 *  androidx.browser.customtabs.CustomTabsClient$2
 *  androidx.browser.customtabs.CustomTabsServiceConnection
 *  androidx.browser.customtabs.CustomTabsSession
 */
package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.ArrayList;
import java.util.List;

public class CustomTabsClient {
    private final ICustomTabsService mService;
    private final ComponentName mServiceComponentName;

    CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName) {
        this.mService = iCustomTabsService;
        this.mServiceComponentName = componentName;
    }

    public static boolean bindCustomTabsService(Context context, String string, CustomTabsServiceConnection customTabsServiceConnection) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (TextUtils.isEmpty((CharSequence)string)) return context.bindService(intent, (ServiceConnection)customTabsServiceConnection, 33);
        intent.setPackage(string);
        return context.bindService(intent, (ServiceConnection)customTabsServiceConnection, 33);
    }

    public static boolean connectAndInitialize(Context context, String string) {
        if (string == null) {
            return false;
        }
        context = context.getApplicationContext();
        1 var3_3 = new /* Unavailable Anonymous Inner Class!! */;
        try {
            boolean bl = CustomTabsClient.bindCustomTabsService(context, string, (CustomTabsServiceConnection)var3_3);
            return bl;
        }
        catch (SecurityException securityException) {
            return false;
        }
    }

    public static String getPackageName(Context context, List<String> list) {
        return CustomTabsClient.getPackageName(context, list, false);
    }

    public static String getPackageName(Context object, List<String> object2, boolean bl) {
        PackageManager packageManager = object.getPackageManager();
        object = object2 == null ? new ArrayList() : object2;
        Object object3 = new Intent("android.intent.action.VIEW", Uri.parse((String)"http://"));
        Object object4 = object;
        if (!bl) {
            object3 = packageManager.resolveActivity(object3, 0);
            object4 = object;
            if (object3 != null) {
                object3 = object3.activityInfo.packageName;
                object4 = new ArrayList(object.size() + 1);
                object4.add(object3);
                if (object2 != null) {
                    object4.addAll(object2);
                }
            }
        }
        object = new Intent("android.support.customtabs.action.CustomTabsService");
        object2 = object4.iterator();
        do {
            if (!object2.hasNext()) return null;
            object4 = (String)object2.next();
            object.setPackage((String)object4);
        } while (packageManager.resolveService((Intent)object, 0) == null);
        return object4;
    }

    public Bundle extraCommand(String string, Bundle bundle) {
        try {
            string = this.mService.extraCommand(string, bundle);
            return string;
        }
        catch (RemoteException remoteException) {
            return null;
        }
    }

    public CustomTabsSession newSession(CustomTabsCallback customTabsCallback) {
        block3: {
            2 var3_2 = new /* Unavailable Anonymous Inner Class!! */;
            customTabsCallback = null;
            try {
                boolean bl = this.mService.newSession((ICustomTabsCallback)var3_2);
                if (!bl) {
                    return null;
                }
            }
            catch (RemoteException remoteException) {
                break block3;
            }
            customTabsCallback = new CustomTabsSession(this.mService, (ICustomTabsCallback)var3_2, this.mServiceComponentName);
        }
        return customTabsCallback;
    }

    public boolean warmup(long l) {
        try {
            boolean bl = this.mService.warmup(l);
            return bl;
        }
        catch (RemoteException remoteException) {
            return false;
        }
    }
}
