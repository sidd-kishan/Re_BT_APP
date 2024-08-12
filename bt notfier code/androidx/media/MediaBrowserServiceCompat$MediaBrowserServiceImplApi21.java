/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Messenger
 *  android.os.Parcel
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  androidx.core.app.BundleCompat
 *  androidx.core.util.Pair
 *  androidx.media.MediaBrowserCompatUtils
 *  androidx.media.MediaBrowserServiceCompat
 *  androidx.media.MediaBrowserServiceCompat$ConnectionRecord
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
 *  androidx.media.MediaBrowserServiceCompat$Result
 *  androidx.media.MediaBrowserServiceCompatApi21
 *  androidx.media.MediaBrowserServiceCompatApi21$BrowserRoot
 *  androidx.media.MediaBrowserServiceCompatApi21$ResultWrapper
 *  androidx.media.MediaBrowserServiceCompatApi21$ServiceCompatProxy
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 */
package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompatApi21;
import androidx.media.MediaSessionManager;
import java.util.ArrayList;
import java.util.List;

class MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
implements MediaBrowserServiceCompat.MediaBrowserServiceImpl,
MediaBrowserServiceCompatApi21.ServiceCompatProxy {
    Messenger mMessenger;
    final List<Bundle> mRootExtrasList;
    Object mServiceObj;
    final MediaBrowserServiceCompat this$0;

    MediaBrowserServiceCompat.MediaBrowserServiceImplApi21(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
        this.mRootExtrasList = new ArrayList<Bundle>();
    }

    public Bundle getBrowserRootHints() {
        Messenger messenger = this.mMessenger;
        Bundle bundle = null;
        if (messenger == null) {
            return null;
        }
        if (this.this$0.mCurConnection == null) throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        if (this.this$0.mCurConnection.rootHints == null) return bundle;
        bundle = new Bundle(this.this$0.mCurConnection.rootHints);
        return bundle;
    }

    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        if (this.this$0.mCurConnection == null) throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        return this.this$0.mCurConnection.browserInfo;
    }

    public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String string, Bundle bundle) {
        this.notifyChildrenChangedForCompat(remoteUserInfo, string, bundle);
    }

    public void notifyChildrenChanged(String string, Bundle bundle) {
        this.notifyChildrenChangedForFramework(string, bundle);
        this.notifyChildrenChangedForCompat(string, bundle);
    }

    void notifyChildrenChangedForCompat(MediaSessionManager.RemoteUserInfo remoteUserInfo, String string, Bundle bundle) {
        this.this$0.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    void notifyChildrenChangedForCompat(String string, Bundle bundle) {
        this.this$0.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    void notifyChildrenChangedForCompatOnHandler(MediaBrowserServiceCompat.ConnectionRecord connectionRecord, String string, Bundle bundle) {
        Object object = (List)connectionRecord.subscriptions.get(string);
        if (object == null) return;
        object = object.iterator();
        while (object.hasNext()) {
            Pair pair = (Pair)object.next();
            if (!MediaBrowserCompatUtils.hasDuplicatedItems((Bundle)bundle, (Bundle)((Bundle)pair.second))) continue;
            this.this$0.performLoadChildren(string, connectionRecord, (Bundle)pair.second, bundle);
        }
    }

    void notifyChildrenChangedForFramework(String string, Bundle bundle) {
        MediaBrowserServiceCompatApi21.notifyChildrenChanged((Object)this.mServiceObj, (String)string);
    }

    public IBinder onBind(Intent intent) {
        return MediaBrowserServiceCompatApi21.onBind((Object)this.mServiceObj, (Intent)intent);
    }

    public void onCreate() {
        Object object;
        this.mServiceObj = object = MediaBrowserServiceCompatApi21.createService((Context)this.this$0, (MediaBrowserServiceCompatApi21.ServiceCompatProxy)this);
        MediaBrowserServiceCompatApi21.onCreate((Object)object);
    }

    public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String string, int n, Bundle bundle) {
        Object object;
        MediaBrowserServiceCompat mediaBrowserServiceCompat;
        if (bundle != null && bundle.getInt("extra_client_version", 0) != 0) {
            bundle.remove("extra_client_version");
            this.mMessenger = new Messenger((Handler)this.this$0.mHandler);
            mediaBrowserServiceCompat = new Bundle();
            mediaBrowserServiceCompat.putInt("extra_service_version", 2);
            BundleCompat.putBinder((Bundle)mediaBrowserServiceCompat, (String)"extra_messenger", (IBinder)this.mMessenger.getBinder());
            if (this.this$0.mSession != null) {
                object = this.this$0.mSession.getExtraBinder();
                object = object == null ? null : object.asBinder();
                BundleCompat.putBinder((Bundle)mediaBrowserServiceCompat, (String)"extra_session_binder", (IBinder)object);
                object = mediaBrowserServiceCompat;
            } else {
                this.mRootExtrasList.add((Bundle)mediaBrowserServiceCompat);
                object = mediaBrowserServiceCompat;
            }
        } else {
            object = null;
        }
        mediaBrowserServiceCompat = this.this$0;
        mediaBrowserServiceCompat.mCurConnection = new MediaBrowserServiceCompat.ConnectionRecord(mediaBrowserServiceCompat, string, -1, n, bundle, null);
        bundle = this.this$0.onGetRoot(string, n, bundle);
        this.this$0.mCurConnection = null;
        if (bundle == null) {
            return null;
        }
        if (object == null) {
            string = bundle.getExtras();
        } else {
            string = object;
            if (bundle.getExtras() == null) return new MediaBrowserServiceCompatApi21.BrowserRoot(bundle.getRootId(), (Bundle)string);
            object.putAll(bundle.getExtras());
            string = object;
        }
        return new MediaBrowserServiceCompatApi21.BrowserRoot(bundle.getRootId(), (Bundle)string);
    }

    public void onLoadChildren(String string, MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> var2_2) {
        var2_2 = new /* Unavailable Anonymous Inner Class!! */;
        this.this$0.onLoadChildren(string, (MediaBrowserServiceCompat.Result)var2_2);
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        this.this$0.mHandler.postOrRun((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
