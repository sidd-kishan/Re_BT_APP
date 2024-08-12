/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Bundle
 *  androidx.browser.customtabs.CustomTabsIntent
 *  androidx.core.app.BundleCompat
 */
package androidx.browser.customtabs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.app.BundleCompat;

public class TrustedWebUtils {
    public static final String EXTRA_LAUNCH_AS_TRUSTED_WEB_ACTIVITY = "android.support.customtabs.extra.LAUNCH_AS_TRUSTED_WEB_ACTIVITY";

    private TrustedWebUtils() {
    }

    public static void launchAsTrustedWebActivity(Context context, CustomTabsIntent customTabsIntent, Uri uri) {
        if (BundleCompat.getBinder((Bundle)customTabsIntent.intent.getExtras(), (String)"android.support.customtabs.extra.SESSION") == null) throw new IllegalArgumentException("Given CustomTabsIntent should be associated with a valid CustomTabsSession");
        customTabsIntent.intent.putExtra(EXTRA_LAUNCH_AS_TRUSTED_WEB_ACTIVITY, true);
        customTabsIntent.launchUrl(context, uri);
    }
}
