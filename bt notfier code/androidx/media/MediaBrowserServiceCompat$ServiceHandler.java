/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Message
 *  android.support.v4.media.MediaBrowserCompat
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.os.ResultReceiver
 *  android.util.Log
 *  androidx.core.app.BundleCompat
 *  androidx.media.MediaBrowserServiceCompat
 *  androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl
 *  androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
 *  androidx.media.MediaBrowserServiceCompat$ServiceCallbacksCompat
 */
package androidx.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserServiceCompat;

private final class MediaBrowserServiceCompat.ServiceHandler
extends Handler {
    private final MediaBrowserServiceCompat.ServiceBinderImpl mServiceBinderImpl;
    final MediaBrowserServiceCompat this$0;

    MediaBrowserServiceCompat.ServiceHandler(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
        this.mServiceBinderImpl = new MediaBrowserServiceCompat.ServiceBinderImpl(this.this$0);
    }

    public void handleMessage(Message message) {
        Object object = message.getData();
        switch (message.what) {
            default: {
                object = new StringBuilder();
                ((StringBuilder)object).append("Unhandled message: ");
                ((StringBuilder)object).append(message);
                ((StringBuilder)object).append("\n  Service version: ");
                ((StringBuilder)object).append(2);
                ((StringBuilder)object).append("\n  Client version: ");
                ((StringBuilder)object).append(message.arg1);
                Log.w((String)"MBServiceCompat", (String)((StringBuilder)object).toString());
                break;
            }
            case 9: {
                Bundle bundle = object.getBundle("data_custom_action_extras");
                MediaSessionCompat.ensureClassLoader((Bundle)bundle);
                this.mServiceBinderImpl.sendCustomAction(object.getString("data_custom_action"), bundle, (ResultReceiver)object.getParcelable("data_result_receiver"), (MediaBrowserServiceCompat.ServiceCallbacks)new MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                break;
            }
            case 8: {
                Bundle bundle = object.getBundle("data_search_extras");
                MediaSessionCompat.ensureClassLoader((Bundle)bundle);
                this.mServiceBinderImpl.search(object.getString("data_search_query"), bundle, (ResultReceiver)object.getParcelable("data_result_receiver"), (MediaBrowserServiceCompat.ServiceCallbacks)new MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                break;
            }
            case 7: {
                this.mServiceBinderImpl.unregisterCallbacks((MediaBrowserServiceCompat.ServiceCallbacks)new MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                break;
            }
            case 6: {
                Bundle bundle = object.getBundle("data_root_hints");
                MediaSessionCompat.ensureClassLoader((Bundle)bundle);
                this.mServiceBinderImpl.registerCallbacks((MediaBrowserServiceCompat.ServiceCallbacks)new MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo), object.getString("data_package_name"), object.getInt("data_calling_pid"), object.getInt("data_calling_uid"), bundle);
                break;
            }
            case 5: {
                this.mServiceBinderImpl.getMediaItem(object.getString("data_media_item_id"), (ResultReceiver)object.getParcelable("data_result_receiver"), (MediaBrowserServiceCompat.ServiceCallbacks)new MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                break;
            }
            case 4: {
                this.mServiceBinderImpl.removeSubscription(object.getString("data_media_item_id"), BundleCompat.getBinder((Bundle)object, (String)"data_callback_token"), (MediaBrowserServiceCompat.ServiceCallbacks)new MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                break;
            }
            case 3: {
                Bundle bundle = object.getBundle("data_options");
                MediaSessionCompat.ensureClassLoader((Bundle)bundle);
                this.mServiceBinderImpl.addSubscription(object.getString("data_media_item_id"), BundleCompat.getBinder((Bundle)object, (String)"data_callback_token"), bundle, (MediaBrowserServiceCompat.ServiceCallbacks)new MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                break;
            }
            case 2: {
                this.mServiceBinderImpl.disconnect((MediaBrowserServiceCompat.ServiceCallbacks)new MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                break;
            }
            case 1: {
                Bundle bundle = object.getBundle("data_root_hints");
                MediaSessionCompat.ensureClassLoader((Bundle)bundle);
                this.mServiceBinderImpl.connect(object.getString("data_package_name"), object.getInt("data_calling_pid"), object.getInt("data_calling_uid"), bundle, (MediaBrowserServiceCompat.ServiceCallbacks)new MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
            }
        }
    }

    public void postOrRun(Runnable runnable) {
        if (Thread.currentThread() == this.getLooper().getThread()) {
            runnable.run();
        } else {
            this.post(runnable);
        }
    }

    public boolean sendMessageAtTime(Message message, long l) {
        Bundle bundle = message.getData();
        bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
        bundle.putInt("data_calling_uid", Binder.getCallingUid());
        bundle.putInt("data_calling_pid", Binder.getCallingPid());
        return super.sendMessageAtTime(message, l);
    }
}
