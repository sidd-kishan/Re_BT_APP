/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 */
package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;

public class CustomTabsCallback {
    public static final int NAVIGATION_ABORTED = 4;
    public static final int NAVIGATION_FAILED = 3;
    public static final int NAVIGATION_FINISHED = 2;
    public static final int NAVIGATION_STARTED = 1;
    public static final int TAB_HIDDEN = 6;
    public static final int TAB_SHOWN = 5;

    public void extraCallback(String string, Bundle bundle) {
    }

    public void onMessageChannelReady(Bundle bundle) {
    }

    public void onNavigationEvent(int n, Bundle bundle) {
    }

    public void onPostMessage(String string, Bundle bundle) {
    }

    public void onRelationshipValidationResult(int n, Uri uri, boolean bl, Bundle bundle) {
    }
}
