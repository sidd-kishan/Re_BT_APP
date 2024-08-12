/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.media.RemoteControlClient$MetadataEditor
 *  android.media.RemoteControlClient$OnMetadataUpdateListener
 *  android.os.Bundle
 *  android.os.Handler
 *  android.support.v4.media.session.MediaSessionCompat$Callback
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.media.RemoteControlClient;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.session.MediaSessionCompat;

static class MediaSessionCompat.MediaSessionImplApi19
extends MediaSessionCompat.MediaSessionImplApi18 {
    MediaSessionCompat.MediaSessionImplApi19(Context context, String string, ComponentName componentName, PendingIntent pendingIntent) {
        super(context, string, componentName, pendingIntent);
    }

    RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle) {
        RemoteControlClient.MetadataEditor metadataEditor = super.buildRccMetadata(bundle);
        long l = this.mState == null ? 0L : this.mState.getActions();
        if ((l & 0x80L) != 0L) {
            metadataEditor.addEditableKey(0x10000001);
        }
        if (bundle == null) {
            return metadataEditor;
        }
        if (bundle.containsKey("android.media.metadata.YEAR")) {
            metadataEditor.putLong(8, bundle.getLong("android.media.metadata.YEAR"));
        }
        if (bundle.containsKey("android.media.metadata.RATING")) {
            metadataEditor.putObject(101, (Object)bundle.getParcelable("android.media.metadata.RATING"));
        }
        if (!bundle.containsKey("android.media.metadata.USER_RATING")) return metadataEditor;
        metadataEditor.putObject(0x10000001, (Object)bundle.getParcelable("android.media.metadata.USER_RATING"));
        return metadataEditor;
    }

    int getRccTransportControlFlagsFromActions(long l) {
        int n;
        int n2 = n = super.getRccTransportControlFlagsFromActions(l);
        if ((l & 0x80L) == 0L) return n2;
        n2 = n | 0x200;
        return n2;
    }

    public void setCallback(MediaSessionCompat.Callback callback, Handler handler) {
        super.setCallback(callback, handler);
        if (callback == null) {
            this.mRcc.setMetadataUpdateListener(null);
        } else {
            callback = new /* Unavailable Anonymous Inner Class!! */;
            this.mRcc.setMetadataUpdateListener((RemoteControlClient.OnMetadataUpdateListener)callback);
        }
    }
}
