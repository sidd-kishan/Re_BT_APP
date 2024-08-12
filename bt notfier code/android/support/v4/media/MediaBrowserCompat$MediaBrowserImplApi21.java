/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Messenger
 *  android.os.RemoteException
 *  android.support.v4.media.MediaBrowserCompat
 *  android.support.v4.media.MediaBrowserCompat$CallbackHandler
 *  android.support.v4.media.MediaBrowserCompat$ConnectionCallback
 *  android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal
 *  android.support.v4.media.MediaBrowserCompat$CustomActionCallback
 *  android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver
 *  android.support.v4.media.MediaBrowserCompat$ItemCallback
 *  android.support.v4.media.MediaBrowserCompat$ItemReceiver
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl
 *  android.support.v4.media.MediaBrowserCompat$SearchCallback
 *  android.support.v4.media.MediaBrowserCompat$SearchResultReceiver
 *  android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper
 *  android.support.v4.media.MediaBrowserCompat$Subscription
 *  android.support.v4.media.MediaBrowserCompat$SubscriptionCallback
 *  android.support.v4.media.MediaBrowserCompatApi21
 *  android.support.v4.media.session.IMediaSession
 *  android.support.v4.media.session.IMediaSession$Stub
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.support.v4.os.ResultReceiver
 *  android.text.TextUtils
 *  android.util.Log
 *  androidx.collection.ArrayMap
 *  androidx.core.app.BundleCompat
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import java.util.List;

static class MediaBrowserCompat.MediaBrowserImplApi21
implements MediaBrowserCompat.MediaBrowserImpl,
MediaBrowserCompat.MediaBrowserServiceCallbackImpl,
MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal {
    protected final Object mBrowserObj;
    protected Messenger mCallbacksMessenger;
    final Context mContext;
    protected final MediaBrowserCompat.CallbackHandler mHandler = new MediaBrowserCompat.CallbackHandler((MediaBrowserCompat.MediaBrowserServiceCallbackImpl)this);
    private MediaSessionCompat.Token mMediaSessionToken;
    private Bundle mNotifyChildrenChangedOptions;
    protected final Bundle mRootHints;
    protected MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
    protected int mServiceVersion;
    private final ArrayMap<String, MediaBrowserCompat.Subscription> mSubscriptions = new ArrayMap();

    MediaBrowserCompat.MediaBrowserImplApi21(Context context, ComponentName componentName, MediaBrowserCompat.ConnectionCallback connectionCallback, Bundle bundle) {
        this.mContext = context;
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        this.mRootHints = bundle2;
        bundle2.putInt("extra_client_version", 1);
        connectionCallback.setInternalConnectionCallback((MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal)this);
        this.mBrowserObj = MediaBrowserCompatApi21.createBrowser((Context)context, (ComponentName)componentName, (Object)connectionCallback.mConnectionCallbackObj, (Bundle)this.mRootHints);
    }

    public void connect() {
        MediaBrowserCompatApi21.connect((Object)this.mBrowserObj);
    }

    public void disconnect() {
        Messenger messenger;
        MediaBrowserCompat.ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
        if (serviceBinderWrapper != null && (messenger = this.mCallbacksMessenger) != null) {
            try {
                serviceBinderWrapper.unregisterCallbackMessenger(messenger);
            }
            catch (RemoteException remoteException) {
                Log.i((String)"MediaBrowserCompat", (String)"Remote error unregistering client messenger.");
            }
        }
        MediaBrowserCompatApi21.disconnect((Object)this.mBrowserObj);
    }

    public Bundle getExtras() {
        return MediaBrowserCompatApi21.getExtras((Object)this.mBrowserObj);
    }

    public void getItem(String string, MediaBrowserCompat.ItemCallback itemCallback) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException("mediaId is empty");
        if (itemCallback == null) throw new IllegalArgumentException("cb is null");
        if (!MediaBrowserCompatApi21.isConnected((Object)this.mBrowserObj)) {
            Log.i((String)"MediaBrowserCompat", (String)"Not connected, unable to retrieve the MediaItem.");
            this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
            return;
        }
        if (this.mServiceBinderWrapper == null) {
            this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
            return;
        }
        MediaBrowserCompat.ItemReceiver itemReceiver = new MediaBrowserCompat.ItemReceiver(string, itemCallback, (Handler)this.mHandler);
        try {
            this.mServiceBinderWrapper.getMediaItem(string, (ResultReceiver)itemReceiver, this.mCallbacksMessenger);
        }
        catch (RemoteException remoteException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Remote error getting media item: ");
            stringBuilder.append(string);
            Log.i((String)"MediaBrowserCompat", (String)stringBuilder.toString());
            this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    public Bundle getNotifyChildrenChangedOptions() {
        return this.mNotifyChildrenChangedOptions;
    }

    public String getRoot() {
        return MediaBrowserCompatApi21.getRoot((Object)this.mBrowserObj);
    }

    public ComponentName getServiceComponent() {
        return MediaBrowserCompatApi21.getServiceComponent((Object)this.mBrowserObj);
    }

    public MediaSessionCompat.Token getSessionToken() {
        if (this.mMediaSessionToken != null) return this.mMediaSessionToken;
        this.mMediaSessionToken = MediaSessionCompat.Token.fromToken((Object)MediaBrowserCompatApi21.getSessionToken((Object)this.mBrowserObj));
        return this.mMediaSessionToken;
    }

    public boolean isConnected() {
        return MediaBrowserCompatApi21.isConnected((Object)this.mBrowserObj);
    }

    public void onConnected() {
        Bundle bundle = MediaBrowserCompatApi21.getExtras((Object)this.mBrowserObj);
        if (bundle == null) {
            return;
        }
        this.mServiceVersion = bundle.getInt("extra_service_version", 0);
        IBinder iBinder = BundleCompat.getBinder((Bundle)bundle, (String)"extra_messenger");
        if (iBinder != null) {
            this.mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper(iBinder, this.mRootHints);
            iBinder = new Messenger((Handler)this.mHandler);
            this.mCallbacksMessenger = iBinder;
            this.mHandler.setCallbacksMessenger((Messenger)iBinder);
            try {
                this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);
            }
            catch (RemoteException remoteException) {
                Log.i((String)"MediaBrowserCompat", (String)"Remote error registering client messenger.");
            }
        }
        if ((bundle = IMediaSession.Stub.asInterface((IBinder)BundleCompat.getBinder((Bundle)bundle, (String)"extra_session_binder"))) == null) return;
        this.mMediaSessionToken = MediaSessionCompat.Token.fromToken((Object)MediaBrowserCompatApi21.getSessionToken((Object)this.mBrowserObj), (IMediaSession)bundle);
    }

    public void onConnectionFailed() {
    }

    public void onConnectionFailed(Messenger messenger) {
    }

    public void onConnectionSuspended() {
        this.mServiceBinderWrapper = null;
        this.mCallbacksMessenger = null;
        this.mMediaSessionToken = null;
        this.mHandler.setCallbacksMessenger(null);
    }

    public void onLoadChildren(Messenger object, String string, List list, Bundle bundle, Bundle bundle2) {
        if (this.mCallbacksMessenger != object) {
            return;
        }
        object = (MediaBrowserCompat.Subscription)this.mSubscriptions.get((Object)string);
        if (object == null) {
            if (!MediaBrowserCompat.DEBUG) return;
            object = new StringBuilder();
            ((StringBuilder)object).append("onLoadChildren for id that isn't subscribed id=");
            ((StringBuilder)object).append(string);
            Log.d((String)"MediaBrowserCompat", (String)((StringBuilder)object).toString());
            return;
        }
        if ((object = object.getCallback(bundle)) == null) return;
        if (bundle == null) {
            if (list == null) {
                object.onError(string);
            } else {
                this.mNotifyChildrenChangedOptions = bundle2;
                object.onChildrenLoaded(string, list);
                this.mNotifyChildrenChangedOptions = null;
            }
        } else if (list == null) {
            object.onError(string, bundle);
        } else {
            this.mNotifyChildrenChangedOptions = bundle2;
            object.onChildrenLoaded(string, list, bundle);
            this.mNotifyChildrenChangedOptions = null;
        }
    }

    public void onServiceConnected(Messenger messenger, String string, MediaSessionCompat.Token token, Bundle bundle) {
    }

    public void search(String string, Bundle bundle, MediaBrowserCompat.SearchCallback searchCallback) {
        if (!this.isConnected()) throw new IllegalStateException("search() called while not connected");
        if (this.mServiceBinderWrapper == null) {
            Log.i((String)"MediaBrowserCompat", (String)"The connected service doesn't support search.");
            this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
            return;
        }
        Object object = new MediaBrowserCompat.SearchResultReceiver(string, bundle, searchCallback, (Handler)this.mHandler);
        try {
            this.mServiceBinderWrapper.search(string, bundle, (ResultReceiver)object, this.mCallbacksMessenger);
        }
        catch (RemoteException remoteException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Remote error searching items with query: ");
            ((StringBuilder)object).append(string);
            Log.i((String)"MediaBrowserCompat", (String)((StringBuilder)object).toString(), (Throwable)remoteException);
            this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    public void sendCustomAction(String string, Bundle bundle, MediaBrowserCompat.CustomActionCallback object) {
        if (!this.isConnected()) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot send a custom action (");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(") with ");
            ((StringBuilder)object).append("extras ");
            ((StringBuilder)object).append(bundle);
            ((StringBuilder)object).append(" because the browser is not connected to the ");
            ((StringBuilder)object).append("service.");
            throw new IllegalStateException(((StringBuilder)object).toString());
        }
        if (this.mServiceBinderWrapper == null) {
            Log.i((String)"MediaBrowserCompat", (String)"The connected service doesn't support sendCustomAction.");
            if (object != null) {
                this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
            }
        }
        MediaBrowserCompat.CustomActionResultReceiver customActionResultReceiver = new MediaBrowserCompat.CustomActionResultReceiver(string, bundle, (MediaBrowserCompat.CustomActionCallback)object, (Handler)this.mHandler);
        try {
            this.mServiceBinderWrapper.sendCustomAction(string, bundle, (ResultReceiver)customActionResultReceiver, this.mCallbacksMessenger);
        }
        catch (RemoteException remoteException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Remote error sending a custom action: action=");
            stringBuilder.append(string);
            stringBuilder.append(", extras=");
            stringBuilder.append(bundle);
            Log.i((String)"MediaBrowserCompat", (String)stringBuilder.toString(), (Throwable)remoteException);
            if (object == null) return;
            this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    public void subscribe(String string, Bundle object, MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        MediaBrowserCompat.Subscription subscription;
        MediaBrowserCompat.Subscription subscription2 = subscription = (MediaBrowserCompat.Subscription)this.mSubscriptions.get((Object)string);
        if (subscription == null) {
            subscription2 = new MediaBrowserCompat.Subscription();
            this.mSubscriptions.put((Object)string, (Object)subscription2);
        }
        subscriptionCallback.setSubscription(subscription2);
        object = object == null ? null : new Bundle(object);
        subscription2.putCallback(object, subscriptionCallback);
        subscription2 = this.mServiceBinderWrapper;
        if (subscription2 == null) {
            MediaBrowserCompatApi21.subscribe((Object)this.mBrowserObj, (String)string, (Object)subscriptionCallback.mSubscriptionCallbackObj);
        } else {
            try {
                subscription2.addSubscription(string, subscriptionCallback.mToken, object, this.mCallbacksMessenger);
            }
            catch (RemoteException remoteException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Remote error subscribing media item: ");
                stringBuilder.append(string);
                Log.i((String)"MediaBrowserCompat", (String)stringBuilder.toString());
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public void unsubscribe(String var1_1, MediaBrowserCompat.SubscriptionCallback var2_2) {
        block9: {
            block10: {
                var4_3 = (MediaBrowserCompat.Subscription)this.mSubscriptions.get((Object)var1_1);
                if (var4_3 == null) {
                    return;
                }
                var5_4 = this.mServiceBinderWrapper;
                if (var5_4 != null) break block10;
                if (var2_2 == null) {
                    MediaBrowserCompatApi21.unsubscribe((Object)this.mBrowserObj, (String)var1_1);
                } else {
                    var6_7 = var4_3.getCallbacks();
                    var5_4 = var4_3.getOptionsList();
                    for (var3_9 = var6_7.size() - 1; var3_9 >= 0; --var3_9) {
                        if (var6_7.get(var3_9) != var2_2) continue;
                        var6_7.remove(var3_9);
                        var5_4.remove(var3_9);
                    }
                    if (var6_7.size() == 0) {
                        MediaBrowserCompatApi21.unsubscribe((Object)this.mBrowserObj, (String)var1_1);
                    }
                }
                break block9;
            }
            if (var2_2 != null) ** GOTO lbl26
            try {
                var5_4.removeSubscription(var1_1, null, this.mCallbacksMessenger);
                break block9;
lbl26:
                // 1 sources

                var6_8 = var4_3.getCallbacks();
                var5_4 = var4_3.getOptionsList();
                for (var3_10 = var6_8.size() - 1; var3_10 >= 0; --var3_10) {
                    if (var6_8.get(var3_10) != var2_2) continue;
                    this.mServiceBinderWrapper.removeSubscription(var1_1, var2_2.mToken, this.mCallbacksMessenger);
                    var6_8.remove(var3_10);
                    var5_4.remove(var3_10);
                }
            }
            catch (RemoteException var5_5) {
                var5_6 = new StringBuilder();
                var5_6.append("removeSubscription failed with RemoteException parentId=");
                var5_6.append(var1_1);
                Log.d((String)"MediaBrowserCompat", (String)var5_6.toString());
            }
        }
        if (!var4_3.isEmpty()) {
            if (var2_2 != null) return;
        }
        this.mSubscriptions.remove((Object)var1_1);
    }
}
