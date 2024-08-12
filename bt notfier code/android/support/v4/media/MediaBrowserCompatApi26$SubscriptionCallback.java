/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallback
 */
package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompatApi21;
import java.util.List;

static interface MediaBrowserCompatApi26.SubscriptionCallback
extends MediaBrowserCompatApi21.SubscriptionCallback {
    public void onChildrenLoaded(String var1, List<?> var2, Bundle var3);

    public void onError(String var1, Bundle var2);
}
