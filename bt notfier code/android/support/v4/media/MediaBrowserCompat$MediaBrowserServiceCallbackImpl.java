/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Messenger
 *  android.support.v4.media.session.MediaSessionCompat$Token
 */
package android.support.v4.media;

import android.os.Bundle;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

static interface MediaBrowserCompat.MediaBrowserServiceCallbackImpl {
    public void onConnectionFailed(Messenger var1);

    public void onLoadChildren(Messenger var1, String var2, List var3, Bundle var4, Bundle var5);

    public void onServiceConnected(Messenger var1, String var2, MediaSessionCompat.Token var3, Bundle var4);
}
