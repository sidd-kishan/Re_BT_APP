/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.media.RemoteControlClient$OnPlaybackPositionUpdateListener
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.support.v4.media.session.MediaSessionCompat$Callback
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
 *  android.support.v4.media.session.PlaybackStateCompat
 *  android.util.Log
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.media.RemoteControlClient;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;

static class MediaSessionCompat.MediaSessionImplApi18
extends MediaSessionCompat.MediaSessionImplBase {
    private static boolean sIsMbrPendingIntentSupported = true;

    MediaSessionCompat.MediaSessionImplApi18(Context context, String string, ComponentName componentName, PendingIntent pendingIntent) {
        super(context, string, componentName, pendingIntent);
    }

    int getRccTransportControlFlagsFromActions(long l) {
        int n;
        int n2 = n = super.getRccTransportControlFlagsFromActions(l);
        if ((l & 0x100L) == 0L) return n2;
        n2 = n | 0x100;
        return n2;
    }

    void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
        if (sIsMbrPendingIntentSupported) {
            try {
                this.mAudioManager.registerMediaButtonEventReceiver(pendingIntent);
            }
            catch (NullPointerException nullPointerException) {
                Log.w((String)"MediaSessionCompat", (String)"Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                sIsMbrPendingIntentSupported = false;
            }
        }
        if (sIsMbrPendingIntentSupported) return;
        super.registerMediaButtonEventReceiver(pendingIntent, componentName);
    }

    public void setCallback(MediaSessionCompat.Callback callback, Handler handler) {
        super.setCallback(callback, handler);
        if (callback == null) {
            this.mRcc.setPlaybackPositionUpdateListener(null);
        } else {
            callback = new /* Unavailable Anonymous Inner Class!! */;
            this.mRcc.setPlaybackPositionUpdateListener((RemoteControlClient.OnPlaybackPositionUpdateListener)callback);
        }
    }

    void setRccState(PlaybackStateCompat playbackStateCompat) {
        long l = playbackStateCompat.getPosition();
        float f = playbackStateCompat.getPlaybackSpeed();
        long l2 = playbackStateCompat.getLastPositionUpdateTime();
        long l3 = SystemClock.elapsedRealtime();
        long l4 = l;
        if (playbackStateCompat.getState() == 3) {
            long l5 = 0L;
            l4 = l;
            if (l > 0L) {
                l4 = l5;
                if (l2 > 0L) {
                    l4 = l5 = l3 - l2;
                    if (f > 0.0f) {
                        l4 = l5;
                        if (f != 1.0f) {
                            l4 = (long)((float)l5 * f);
                        }
                    }
                }
                l4 = l + l4;
            }
        }
        this.mRcc.setPlaybackState(this.getRccStateFromState(playbackStateCompat.getState()), l4, f);
    }

    void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
        if (sIsMbrPendingIntentSupported) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(pendingIntent);
        } else {
            super.unregisterMediaButtonEventReceiver(pendingIntent, componentName);
        }
    }
}
