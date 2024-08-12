/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 */
package androidx.media;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaSessionManager;

static interface MediaBrowserServiceCompat.MediaBrowserServiceImpl {
    public Bundle getBrowserRootHints();

    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();

    public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo var1, String var2, Bundle var3);

    public void notifyChildrenChanged(String var1, Bundle var2);

    public IBinder onBind(Intent var1);

    public void onCreate();

    public void setSessionToken(MediaSessionCompat.Token var1);
}
