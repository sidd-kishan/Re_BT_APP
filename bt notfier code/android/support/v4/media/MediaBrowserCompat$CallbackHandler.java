/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.BadParcelableException
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Message
 *  android.os.Messenger
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.util.Log
 */
package android.support.v4.media;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.List;

private static class MediaBrowserCompat.CallbackHandler
extends Handler {
    private final WeakReference<MediaBrowserCompat.MediaBrowserServiceCallbackImpl> mCallbackImplRef;
    private WeakReference<Messenger> mCallbacksMessengerRef;

    MediaBrowserCompat.CallbackHandler(MediaBrowserCompat.MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
        this.mCallbackImplRef = new WeakReference<MediaBrowserCompat.MediaBrowserServiceCallbackImpl>(mediaBrowserServiceCallbackImpl);
    }

    public void handleMessage(Message message) {
        MediaBrowserCompat.MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = this.mCallbacksMessengerRef;
        if (mediaBrowserServiceCallbackImpl == null) return;
        if (mediaBrowserServiceCallbackImpl.get() == null) return;
        if (this.mCallbackImplRef.get() == null) return;
        Object object = message.getData();
        MediaSessionCompat.ensureClassLoader((Bundle)object);
        mediaBrowserServiceCallbackImpl = (MediaBrowserCompat.MediaBrowserServiceCallbackImpl)this.mCallbackImplRef.get();
        Messenger messenger = (Messenger)this.mCallbacksMessengerRef.get();
        try {
            int n = message.what;
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Unhandled message: ");
                        ((StringBuilder)object).append(message);
                        ((StringBuilder)object).append("\n  Client version: ");
                        ((StringBuilder)object).append(1);
                        ((StringBuilder)object).append("\n  Service version: ");
                        ((StringBuilder)object).append(message.arg1);
                        Log.w((String)"MediaBrowserCompat", (String)((StringBuilder)object).toString());
                    } else {
                        Bundle bundle = object.getBundle("data_options");
                        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
                        Bundle bundle2 = object.getBundle("data_notify_children_changed_options");
                        MediaSessionCompat.ensureClassLoader((Bundle)bundle2);
                        mediaBrowserServiceCallbackImpl.onLoadChildren(messenger, object.getString("data_media_item_id"), (List)object.getParcelableArrayList("data_media_item_list"), bundle, bundle2);
                    }
                } else {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                }
            } else {
                Bundle bundle = object.getBundle("data_root_hints");
                MediaSessionCompat.ensureClassLoader((Bundle)bundle);
                mediaBrowserServiceCallbackImpl.onServiceConnected(messenger, object.getString("data_media_item_id"), (MediaSessionCompat.Token)object.getParcelable("data_media_session_token"), bundle);
            }
        }
        catch (BadParcelableException badParcelableException) {
            Log.e((String)"MediaBrowserCompat", (String)"Could not unparcel the data.");
            if (message.what != 1) return;
            mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
        }
    }

    void setCallbacksMessenger(Messenger messenger) {
        this.mCallbacksMessengerRef = new WeakReference<Messenger>(messenger);
    }
}
