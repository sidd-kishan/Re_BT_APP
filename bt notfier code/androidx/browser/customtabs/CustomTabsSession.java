/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.support.customtabs.ICustomTabsCallback
 *  android.support.customtabs.ICustomTabsService
 *  android.widget.RemoteViews
 *  androidx.browser.customtabs.CustomTabsSessionToken$MockCallback
 */
package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.widget.RemoteViews;
import androidx.browser.customtabs.CustomTabsSessionToken;
import java.util.List;

public final class CustomTabsSession {
    private static final String TAG = "CustomTabsSession";
    private final ICustomTabsCallback mCallback;
    private final ComponentName mComponentName;
    private final Object mLock = new Object();
    private final ICustomTabsService mService;

    CustomTabsSession(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName) {
        this.mService = iCustomTabsService;
        this.mCallback = iCustomTabsCallback;
        this.mComponentName = componentName;
    }

    public static CustomTabsSession createMockSessionForTesting(ComponentName componentName) {
        return new CustomTabsSession(null, (ICustomTabsCallback)new CustomTabsSessionToken.MockCallback(), componentName);
    }

    IBinder getBinder() {
        return this.mCallback.asBinder();
    }

    ComponentName getComponentName() {
        return this.mComponentName;
    }

    public boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        try {
            boolean bl = this.mService.mayLaunchUrl(this.mCallback, uri, bundle, list);
            return bl;
        }
        catch (RemoteException remoteException) {
            return false;
        }
    }

    public int postMessage(String string, Bundle bundle) {
        Object object = this.mLock;
        synchronized (object) {
            try {
                try {
                    int n = this.mService.postMessage(this.mCallback, string, bundle);
                    return n;
                }
                catch (RemoteException remoteException) {
                    return -2;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public boolean requestPostMessageChannel(Uri uri) {
        try {
            boolean bl = this.mService.requestPostMessageChannel(this.mCallback, uri);
            return bl;
        }
        catch (RemoteException remoteException) {
            return false;
        }
    }

    public boolean setActionButton(Bitmap bitmap, String string) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.customtabs.customaction.ICON", (Parcelable)bitmap);
        bundle.putString("android.support.customtabs.customaction.DESCRIPTION", string);
        bitmap = new Bundle();
        bitmap.putBundle("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE", bundle);
        try {
            boolean bl = this.mService.updateVisuals(this.mCallback, (Bundle)bitmap);
            return bl;
        }
        catch (RemoteException remoteException) {
            return false;
        }
    }

    public boolean setSecondaryToolbarViews(RemoteViews remoteViews, int[] nArray, PendingIntent pendingIntent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.customtabs.extra.EXTRA_REMOTEVIEWS", (Parcelable)remoteViews);
        bundle.putIntArray("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS", nArray);
        bundle.putParcelable("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT", (Parcelable)pendingIntent);
        try {
            boolean bl = this.mService.updateVisuals(this.mCallback, bundle);
            return bl;
        }
        catch (RemoteException remoteException) {
            return false;
        }
    }

    @Deprecated
    public boolean setToolbarItem(int n, Bitmap bitmap, String string) {
        Bundle bundle = new Bundle();
        bundle.putInt("android.support.customtabs.customaction.ID", n);
        bundle.putParcelable("android.support.customtabs.customaction.ICON", (Parcelable)bitmap);
        bundle.putString("android.support.customtabs.customaction.DESCRIPTION", string);
        bitmap = new Bundle();
        bitmap.putBundle("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE", bundle);
        try {
            boolean bl = this.mService.updateVisuals(this.mCallback, (Bundle)bitmap);
            return bl;
        }
        catch (RemoteException remoteException) {
            return false;
        }
    }

    public boolean validateRelationship(int n, Uri uri, Bundle bundle) {
        if (n < 1) return false;
        if (n > 2) return false;
        try {
            boolean bl = this.mService.validateRelationship(this.mCallback, n, uri, bundle);
            return bl;
        }
        catch (RemoteException remoteException) {
        }
        return false;
    }
}
