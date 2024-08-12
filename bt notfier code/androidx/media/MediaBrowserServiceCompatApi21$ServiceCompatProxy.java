/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  androidx.media.MediaBrowserServiceCompatApi21$BrowserRoot
 *  androidx.media.MediaBrowserServiceCompatApi21$ResultWrapper
 */
package androidx.media;

import android.os.Bundle;
import android.os.Parcel;
import androidx.media.MediaBrowserServiceCompatApi21;
import java.util.List;

public static interface MediaBrowserServiceCompatApi21.ServiceCompatProxy {
    public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String var1, int var2, Bundle var3);

    public void onLoadChildren(String var1, MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> var2);
}
