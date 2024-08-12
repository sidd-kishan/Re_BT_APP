/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IBinder$DeathRecipient
 *  android.support.customtabs.ICustomTabsService$Stub
 *  androidx.browser.customtabs.CustomTabsSessionToken
 *  androidx.collection.ArrayMap
 */
package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService;
import androidx.browser.customtabs.CustomTabsSessionToken;
import androidx.collection.ArrayMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class CustomTabsService
extends Service {
    public static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
    public static final String KEY_URL = "android.support.customtabs.otherurls.URL";
    public static final int RELATION_HANDLE_ALL_URLS = 2;
    public static final int RELATION_USE_AS_ORIGIN = 1;
    public static final int RESULT_FAILURE_DISALLOWED = -1;
    public static final int RESULT_FAILURE_MESSAGING_ERROR = -3;
    public static final int RESULT_FAILURE_REMOTE_ERROR = -2;
    public static final int RESULT_SUCCESS = 0;
    private ICustomTabsService.Stub mBinder;
    final Map<IBinder, IBinder.DeathRecipient> mDeathRecipientMap = new ArrayMap();

    public CustomTabsService() {
        this.mBinder = new /* Unavailable Anonymous Inner Class!! */;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected boolean cleanUpSession(CustomTabsSessionToken customTabsSessionToken) {
        try {
            Map<IBinder, IBinder.DeathRecipient> map = this.mDeathRecipientMap;
            synchronized (map) {
            }
        }
        catch (NoSuchElementException throwable) {
            return false;
        }
        {
            customTabsSessionToken = customTabsSessionToken.getCallbackBinder();
            customTabsSessionToken.unlinkToDeath(this.mDeathRecipientMap.get(customTabsSessionToken), 0);
            this.mDeathRecipientMap.remove(customTabsSessionToken);
            return true;
        }
    }

    protected abstract Bundle extraCommand(String var1, Bundle var2);

    protected abstract boolean mayLaunchUrl(CustomTabsSessionToken var1, Uri var2, Bundle var3, List<Bundle> var4);

    protected abstract boolean newSession(CustomTabsSessionToken var1);

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    protected abstract int postMessage(CustomTabsSessionToken var1, String var2, Bundle var3);

    protected abstract boolean requestPostMessageChannel(CustomTabsSessionToken var1, Uri var2);

    protected abstract boolean updateVisuals(CustomTabsSessionToken var1, Bundle var2);

    protected abstract boolean validateRelationship(CustomTabsSessionToken var1, int var2, Uri var3, Bundle var4);

    protected abstract boolean warmup(long var1);
}
