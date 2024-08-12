/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.support.v4.media.session.MediaSessionCompatApi21$Callback
 */
package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompatApi21;

public static interface MediaSessionCompatApi23.Callback
extends MediaSessionCompatApi21.Callback {
    public void onPlayFromUri(Uri var1, Bundle var2);
}
