/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Messenger
 *  android.os.RemoteException
 *  android.support.v4.media.MediaBrowserCompat
 *  android.support.v4.media.MediaBrowserCompat$CallbackHandler
 *  android.support.v4.media.MediaBrowserCompat$ConnectionCallback
 *  android.support.v4.media.MediaBrowserCompat$CustomActionCallback
 *  android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver
 *  android.support.v4.media.MediaBrowserCompat$ItemCallback
 *  android.support.v4.media.MediaBrowserCompat$ItemReceiver
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl
 *  android.support.v4.media.MediaBrowserCompat$SearchCallback
 *  android.support.v4.media.MediaBrowserCompat$SearchResultReceiver
 *  android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper
 *  android.support.v4.media.MediaBrowserCompat$Subscription
 *  android.support.v4.media.MediaBrowserCompat$SubscriptionCallback
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.support.v4.os.ResultReceiver
 *  android.text.TextUtils
 *  android.util.Log
 *  androidx.collection.ArrayMap
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.List;
import java.util.Map;

static class MediaBrowserCompat.MediaBrowserImplBase
implements MediaBrowserCompat.MediaBrowserImpl,
MediaBrowserCompat.MediaBrowserServiceCallbackImpl {
    static final int CONNECT_STATE_CONNECTED = 3;
    static final int CONNECT_STATE_CONNECTING = 2;
    static final int CONNECT_STATE_DISCONNECTED = 1;
    static final int CONNECT_STATE_DISCONNECTING = 0;
    static final int CONNECT_STATE_SUSPENDED = 4;
    final MediaBrowserCompat.ConnectionCallback mCallback;
    Messenger mCallbacksMessenger;
    final Context mContext;
    private Bundle mExtras;
    final MediaBrowserCompat.CallbackHandler mHandler = new MediaBrowserCompat.CallbackHandler((MediaBrowserCompat.MediaBrowserServiceCallbackImpl)this);
    private MediaSessionCompat.Token mMediaSessionToken;
    private Bundle mNotifyChildrenChangedOptions;
    final Bundle mRootHints;
    private String mRootId;
    MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
    final ComponentName mServiceComponent;
    MediaServiceConnection mServiceConnection;
    int mState = 1;
    private final ArrayMap<String, MediaBrowserCompat.Subscription> mSubscriptions = new ArrayMap();

    public MediaBrowserCompat.MediaBrowserImplBase(Context object, ComponentName componentName, MediaBrowserCompat.ConnectionCallback connectionCallback, Bundle bundle) {
        if (object == null) throw new IllegalArgumentException("context must not be null");
        if (componentName == null) throw new IllegalArgumentException("service component must not be null");
        if (connectionCallback == null) throw new IllegalArgumentException("connection callback must not be null");
        this.mContext = object;
        this.mServiceComponent = componentName;
        this.mCallback = connectionCallback;
        object = bundle == null ? null : new Bundle(bundle);
        this.mRootHints = object;
    }

    private static String getStateLabel(int n) {
        if (n == 0) return "CONNECT_STATE_DISCONNECTING";
        if (n == 1) return "CONNECT_STATE_DISCONNECTED";
        if (n == 2) return "CONNECT_STATE_CONNECTING";
        if (n == 3) return "CONNECT_STATE_CONNECTED";
        if (n == 4) return "CONNECT_STATE_SUSPENDED";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UNKNOWN/");
        stringBuilder.append(n);
        return stringBuilder.toString();
    }

    private boolean isCurrent(Messenger object, String string) {
        int n;
        if (this.mCallbacksMessenger == object && (n = this.mState) != 0) {
            if (n != 1) return true;
        }
        if ((n = this.mState) == 0) return false;
        if (n == 1) return false;
        object = new StringBuilder();
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(" for ");
        ((StringBuilder)object).append(this.mServiceComponent);
        ((StringBuilder)object).append(" with mCallbacksMessenger=");
        ((StringBuilder)object).append(this.mCallbacksMessenger);
        ((StringBuilder)object).append(" this=");
        ((StringBuilder)object).append(this);
        Log.i((String)"MediaBrowserCompat", (String)((StringBuilder)object).toString());
        return false;
    }

    public void connect() {
        int n = this.mState;
        if (n != 0 && n != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("connect() called while neigther disconnecting nor disconnected (state=");
            stringBuilder.append(MediaBrowserCompat.MediaBrowserImplBase.getStateLabel(this.mState));
            stringBuilder.append(")");
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.mState = 2;
        this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void disconnect() {
        this.mState = 0;
        this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    void dump() {
        Log.d((String)"MediaBrowserCompat", (String)"MediaBrowserCompat...");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  mServiceComponent=");
        stringBuilder.append(this.mServiceComponent);
        Log.d((String)"MediaBrowserCompat", (String)stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("  mCallback=");
        stringBuilder.append(this.mCallback);
        Log.d((String)"MediaBrowserCompat", (String)stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("  mRootHints=");
        stringBuilder.append(this.mRootHints);
        Log.d((String)"MediaBrowserCompat", (String)stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("  mState=");
        stringBuilder.append(MediaBrowserCompat.MediaBrowserImplBase.getStateLabel(this.mState));
        Log.d((String)"MediaBrowserCompat", (String)stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("  mServiceConnection=");
        stringBuilder.append(this.mServiceConnection);
        Log.d((String)"MediaBrowserCompat", (String)stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("  mServiceBinderWrapper=");
        stringBuilder.append(this.mServiceBinderWrapper);
        Log.d((String)"MediaBrowserCompat", (String)stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("  mCallbacksMessenger=");
        stringBuilder.append(this.mCallbacksMessenger);
        Log.d((String)"MediaBrowserCompat", (String)stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("  mRootId=");
        stringBuilder.append(this.mRootId);
        Log.d((String)"MediaBrowserCompat", (String)stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("  mMediaSessionToken=");
        stringBuilder.append(this.mMediaSessionToken);
        Log.d((String)"MediaBrowserCompat", (String)stringBuilder.toString());
    }

    void forceCloseConnection() {
        MediaServiceConnection mediaServiceConnection = this.mServiceConnection;
        if (mediaServiceConnection != null) {
            this.mContext.unbindService((ServiceConnection)mediaServiceConnection);
        }
        this.mState = 1;
        this.mServiceConnection = null;
        this.mServiceBinderWrapper = null;
        this.mCallbacksMessenger = null;
        this.mHandler.setCallbacksMessenger(null);
        this.mRootId = null;
        this.mMediaSessionToken = null;
    }

    public Bundle getExtras() {
        if (this.isConnected()) {
            return this.mExtras;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getExtras() called while not connected (state=");
        stringBuilder.append(MediaBrowserCompat.MediaBrowserImplBase.getStateLabel(this.mState));
        stringBuilder.append(")");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void getItem(String string, MediaBrowserCompat.ItemCallback itemCallback) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException("mediaId is empty");
        if (itemCallback == null) throw new IllegalArgumentException("cb is null");
        if (!this.isConnected()) {
            Log.i((String)"MediaBrowserCompat", (String)"Not connected, unable to retrieve the MediaItem.");
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
        if (this.isConnected()) {
            return this.mRootId;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getRoot() called while not connected(state=");
        stringBuilder.append(MediaBrowserCompat.MediaBrowserImplBase.getStateLabel(this.mState));
        stringBuilder.append(")");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public ComponentName getServiceComponent() {
        if (this.isConnected()) {
            return this.mServiceComponent;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getServiceComponent() called while not connected (state=");
        stringBuilder.append(this.mState);
        stringBuilder.append(")");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public MediaSessionCompat.Token getSessionToken() {
        if (this.isConnected()) {
            return this.mMediaSessionToken;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getSessionToken() called while not connected(state=");
        stringBuilder.append(this.mState);
        stringBuilder.append(")");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public boolean isConnected() {
        boolean bl = this.mState == 3;
        return bl;
    }

    public void onConnectionFailed(Messenger object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onConnectFailed for ");
        stringBuilder.append(this.mServiceComponent);
        Log.e((String)"MediaBrowserCompat", (String)stringBuilder.toString());
        if (!this.isCurrent((Messenger)object, "onConnectFailed")) {
            return;
        }
        if (this.mState != 2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("onConnect from service while mState=");
            ((StringBuilder)object).append(MediaBrowserCompat.MediaBrowserImplBase.getStateLabel(this.mState));
            ((StringBuilder)object).append("... ignoring");
            Log.w((String)"MediaBrowserCompat", (String)((StringBuilder)object).toString());
            return;
        }
        this.forceCloseConnection();
        this.mCallback.onConnectionFailed();
    }

    public void onLoadChildren(Messenger object, String string, List list, Bundle bundle, Bundle bundle2) {
        if (!this.isCurrent((Messenger)object, "onLoadChildren")) {
            return;
        }
        if (MediaBrowserCompat.DEBUG) {
            object = new StringBuilder();
            ((StringBuilder)object).append("onLoadChildren for ");
            ((StringBuilder)object).append(this.mServiceComponent);
            ((StringBuilder)object).append(" id=");
            ((StringBuilder)object).append(string);
            Log.d((String)"MediaBrowserCompat", (String)((StringBuilder)object).toString());
        }
        if ((object = (MediaBrowserCompat.Subscription)this.mSubscriptions.get((Object)string)) == null) {
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

    public void onServiceConnected(Messenger object, String object2, MediaSessionCompat.Token object3, Bundle object4) {
        if (!this.isCurrent((Messenger)object, "onConnect")) {
            return;
        }
        if (this.mState != 2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("onConnect from service while mState=");
            ((StringBuilder)object).append(MediaBrowserCompat.MediaBrowserImplBase.getStateLabel(this.mState));
            ((StringBuilder)object).append("... ignoring");
            Log.w((String)"MediaBrowserCompat", (String)((StringBuilder)object).toString());
            return;
        }
        this.mRootId = object2;
        this.mMediaSessionToken = object3;
        this.mExtras = object4;
        this.mState = 3;
        if (MediaBrowserCompat.DEBUG) {
            Log.d((String)"MediaBrowserCompat", (String)"ServiceCallbacks.onConnect...");
            this.dump();
        }
        this.mCallback.onConnected();
        try {
            object2 = this.mSubscriptions.entrySet().iterator();
            block2: while (true) {
                if (!object2.hasNext()) return;
                object3 = (Map.Entry)object2.next();
                object = (String)object3.getKey();
                object4 = (MediaBrowserCompat.Subscription)object3.getValue();
                object3 = object4.getCallbacks();
                object4 = object4.getOptionsList();
                int n = 0;
                while (true) {
                    if (n >= object3.size()) continue block2;
                    this.mServiceBinderWrapper.addSubscription((String)object, ((MediaBrowserCompat.SubscriptionCallback)object3.get((int)n)).mToken, (Bundle)object4.get(n), this.mCallbacksMessenger);
                    ++n;
                }
                break;
            }
        }
        catch (RemoteException remoteException) {
            Log.d((String)"MediaBrowserCompat", (String)"addSubscription failed with RemoteException.");
        }
    }

    public void search(String charSequence, Bundle bundle, MediaBrowserCompat.SearchCallback searchCallback) {
        if (!this.isConnected()) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("search() called while not connected (state=");
            ((StringBuilder)charSequence).append(MediaBrowserCompat.MediaBrowserImplBase.getStateLabel(this.mState));
            ((StringBuilder)charSequence).append(")");
            throw new IllegalStateException(((StringBuilder)charSequence).toString());
        }
        MediaBrowserCompat.SearchResultReceiver searchResultReceiver = new MediaBrowserCompat.SearchResultReceiver((String)charSequence, bundle, searchCallback, (Handler)this.mHandler);
        try {
            this.mServiceBinderWrapper.search((String)charSequence, bundle, (ResultReceiver)searchResultReceiver, this.mCallbacksMessenger);
        }
        catch (RemoteException remoteException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Remote error searching items with query: ");
            stringBuilder.append((String)charSequence);
            Log.i((String)"MediaBrowserCompat", (String)stringBuilder.toString(), (Throwable)remoteException);
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
        Object object2 = new MediaBrowserCompat.CustomActionResultReceiver(string, bundle, (MediaBrowserCompat.CustomActionCallback)object, (Handler)this.mHandler);
        try {
            this.mServiceBinderWrapper.sendCustomAction(string, bundle, (ResultReceiver)object2, this.mCallbacksMessenger);
        }
        catch (RemoteException remoteException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Remote error sending a custom action: action=");
            ((StringBuilder)object2).append(string);
            ((StringBuilder)object2).append(", extras=");
            ((StringBuilder)object2).append(bundle);
            Log.i((String)"MediaBrowserCompat", (String)((StringBuilder)object2).toString(), (Throwable)remoteException);
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
        object = object == null ? null : new Bundle(object);
        subscription2.putCallback(object, subscriptionCallback);
        if (!this.isConnected()) return;
        try {
            this.mServiceBinderWrapper.addSubscription(string, subscriptionCallback.mToken, object, this.mCallbacksMessenger);
        }
        catch (RemoteException remoteException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("addSubscription failed with RemoteException parentId=");
            stringBuilder.append(string);
            Log.d((String)"MediaBrowserCompat", (String)stringBuilder.toString());
        }
    }

    /*
     * Unable to fully structure code
     */
    public void unsubscribe(String var1_1, MediaBrowserCompat.SubscriptionCallback var2_2) {
        block7: {
            var4_3 = (MediaBrowserCompat.Subscription)this.mSubscriptions.get((Object)var1_1);
            if (var4_3 == null) {
                return;
            }
            if (var2_2 != null) ** GOTO lbl9
            try {
                if (this.isConnected()) {
                    this.mServiceBinderWrapper.removeSubscription(var1_1, null, this.mCallbacksMessenger);
                }
                break block7;
lbl9:
                // 1 sources

                var5_4 = var4_3.getCallbacks();
                var6_7 = var4_3.getOptionsList();
                for (var3_8 = var5_4.size() - 1; var3_8 >= 0; --var3_8) {
                    if (var5_4.get(var3_8) != var2_2) continue;
                    if (this.isConnected()) {
                        this.mServiceBinderWrapper.removeSubscription(var1_1, var2_2.mToken, this.mCallbacksMessenger);
                    }
                    var5_4.remove(var3_8);
                    var6_7.remove(var3_8);
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
