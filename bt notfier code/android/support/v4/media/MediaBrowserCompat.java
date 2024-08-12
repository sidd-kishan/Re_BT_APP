/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompat$ConnectionCallback
 *  android.support.v4.media.MediaBrowserCompat$CustomActionCallback
 *  android.support.v4.media.MediaBrowserCompat$ItemCallback
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi23
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi26
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase
 *  android.support.v4.media.MediaBrowserCompat$SearchCallback
 *  android.support.v4.media.MediaBrowserCompat$SubscriptionCallback
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.text.TextUtils
 *  android.util.Log
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;

public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    static final boolean DEBUG = Log.isLoggable((String)"MediaBrowserCompat", (int)3);
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    static final String TAG = "MediaBrowserCompat";
    private final MediaBrowserImpl mImpl;

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        this.mImpl = Build.VERSION.SDK_INT >= 26 ? new MediaBrowserImplApi26(context, componentName, connectionCallback, bundle) : (Build.VERSION.SDK_INT >= 23 ? new MediaBrowserImplApi23(context, componentName, connectionCallback, bundle) : (Build.VERSION.SDK_INT >= 21 ? new MediaBrowserImplApi21(context, componentName, connectionCallback, bundle) : new MediaBrowserImplBase(context, componentName, connectionCallback, bundle)));
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(String string, ItemCallback itemCallback) {
        this.mImpl.getItem(string, itemCallback);
    }

    public Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    public String getRoot() {
        return this.mImpl.getRoot();
    }

    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void search(String string, Bundle bundle, SearchCallback searchCallback) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException("query cannot be empty");
        if (searchCallback == null) throw new IllegalArgumentException("callback cannot be null");
        this.mImpl.search(string, bundle, searchCallback);
    }

    public void sendCustomAction(String string, Bundle bundle, CustomActionCallback customActionCallback) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException("action cannot be empty");
        this.mImpl.sendCustomAction(string, bundle, customActionCallback);
    }

    public void subscribe(String string, Bundle bundle, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException("parentId is empty");
        if (subscriptionCallback == null) throw new IllegalArgumentException("callback is null");
        if (bundle == null) throw new IllegalArgumentException("options are null");
        this.mImpl.subscribe(string, bundle, subscriptionCallback);
    }

    public void subscribe(String string, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException("parentId is empty");
        if (subscriptionCallback == null) throw new IllegalArgumentException("callback is null");
        this.mImpl.subscribe(string, null, subscriptionCallback);
    }

    public void unsubscribe(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException("parentId is empty");
        this.mImpl.unsubscribe(string, null);
    }

    public void unsubscribe(String string, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException("parentId is empty");
        if (subscriptionCallback == null) throw new IllegalArgumentException("callback is null");
        this.mImpl.unsubscribe(string, subscriptionCallback);
    }
}
