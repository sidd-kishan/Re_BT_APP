/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.media.MediaSessionManager$RemoteUserInfoImpl
 */
package androidx.media;

import android.content.Context;
import androidx.media.MediaSessionManager;

static interface MediaSessionManager.MediaSessionManagerImpl {
    public Context getContext();

    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl var1);
}
