/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.support.v4.os.ResultReceiver
 *  android.util.Log
 *  androidx.collection.ArrayMap
 *  androidx.core.util.Pair
 *  androidx.media.MediaBrowserCompatUtils
 *  androidx.media.MediaBrowserServiceCompat$BrowserRoot
 *  androidx.media.MediaBrowserServiceCompat$ConnectionRecord
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi28
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase
 *  androidx.media.MediaBrowserServiceCompat$Result
 *  androidx.media.MediaBrowserServiceCompat$ServiceHandler
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 */
package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat
extends Service {
    static final boolean DEBUG = Log.isLoggable((String)"MBServiceCompat", (int)3);
    private static final float EPSILON = 1.0E-5f;
    public static final String KEY_MEDIA_ITEM = "media_item";
    public static final String KEY_SEARCH_RESULTS = "search_results";
    public static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    public static final int RESULT_OK = 0;
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    static final String TAG = "MBServiceCompat";
    final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap();
    ConnectionRecord mCurConnection;
    final ServiceHandler mHandler = new ServiceHandler(this);
    private MediaBrowserServiceImpl mImpl;
    MediaSessionCompat.Token mSession;

    void addSubscription(String string, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        Pair pair;
        Pair pair2 = pair = (Pair)connectionRecord.subscriptions.get(string);
        if (pair == null) {
            pair2 = new ArrayList();
        }
        Iterator iterator = pair2.iterator();
        do {
            if (!iterator.hasNext()) {
                pair2.add(new Pair((Object)iBinder, (Object)bundle));
                connectionRecord.subscriptions.put(string, pair2);
                this.performLoadChildren(string, connectionRecord, bundle, null);
                this.mCurConnection = connectionRecord;
                this.onSubscribe(string, bundle);
                this.mCurConnection = null;
                return;
            }
            pair = (Pair)iterator.next();
        } while (iBinder != pair.first || !MediaBrowserCompatUtils.areSameOptions((Bundle)bundle, (Bundle)((Bundle)pair.second)));
    }

    List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int n = bundle.getInt("android.media.browse.extra.PAGE", -1);
        int n2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (n == -1 && n2 == -1) {
            return list;
        }
        int n3 = n2 * n;
        int n4 = n3 + n2;
        if (n < 0) return Collections.emptyList();
        if (n2 < 1) return Collections.emptyList();
        if (n3 >= list.size()) {
            return Collections.emptyList();
        }
        n2 = n4;
        if (n4 <= list.size()) return list.subList(n3, n2);
        n2 = list.size();
        return list.subList(n3, n2);
    }

    public void attachToBaseContext(Context context) {
        this.attachBaseContext(context);
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.mImpl.getCurrentBrowserInfo();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mSession;
    }

    boolean isValidPackage(String string, int n) {
        if (string == null) {
            return false;
        }
        String[] stringArray = this.getPackageManager().getPackagesForUid(n);
        int n2 = stringArray.length;
        n = 0;
        while (n < n2) {
            if (stringArray[n].equals(string)) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String string, Bundle bundle) {
        if (remoteUserInfo == null) throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        if (string == null) throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        if (bundle == null) throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        this.mImpl.notifyChildrenChanged(remoteUserInfo, string, bundle);
    }

    public void notifyChildrenChanged(String string) {
        if (string == null) throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        this.mImpl.notifyChildrenChanged(string, null);
    }

    public void notifyChildrenChanged(String string, Bundle bundle) {
        if (string == null) throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        if (bundle == null) throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        this.mImpl.notifyChildrenChanged(string, bundle);
    }

    public IBinder onBind(Intent intent) {
        return this.mImpl.onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        this.mImpl = Build.VERSION.SDK_INT >= 28 ? new MediaBrowserServiceImplApi28(this) : (Build.VERSION.SDK_INT >= 26 ? new MediaBrowserServiceImplApi26(this) : (Build.VERSION.SDK_INT >= 23 ? new MediaBrowserServiceImplApi23(this) : (Build.VERSION.SDK_INT >= 21 ? new MediaBrowserServiceImplApi21(this) : new MediaBrowserServiceImplBase(this))));
        this.mImpl.onCreate();
    }

    public void onCustomAction(String string, Bundle bundle, Result<Bundle> result) {
        result.sendError(null);
    }

    public abstract BrowserRoot onGetRoot(String var1, int var2, Bundle var3);

    public abstract void onLoadChildren(String var1, Result<List<MediaBrowserCompat.MediaItem>> var2);

    public void onLoadChildren(String string, Result<List<MediaBrowserCompat.MediaItem>> result, Bundle bundle) {
        result.setFlags(1);
        this.onLoadChildren(string, result);
    }

    public void onLoadItem(String string, Result<MediaBrowserCompat.MediaItem> result) {
        result.setFlags(2);
        result.sendResult(null);
    }

    public void onSearch(String string, Bundle bundle, Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.setFlags(4);
        result.sendResult(null);
    }

    public void onSubscribe(String string, Bundle bundle) {
    }

    public void onUnsubscribe(String string) {
    }

    void performCustomAction(String string, Bundle bundle, ConnectionRecord object, ResultReceiver resultReceiver) {
        resultReceiver = new /* Unavailable Anonymous Inner Class!! */;
        this.mCurConnection = object;
        this.onCustomAction(string, bundle, (Result<Bundle>)resultReceiver);
        this.mCurConnection = null;
        if (resultReceiver.isDone()) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("onCustomAction must call detach() or sendResult() or sendError() before returning for action=");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(" extras=");
        ((StringBuilder)object).append(bundle);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    void performLoadChildren(String string, ConnectionRecord connectionRecord, Bundle object, Bundle bundle) {
        bundle = new /* Unavailable Anonymous Inner Class!! */;
        this.mCurConnection = connectionRecord;
        if (object == null) {
            this.onLoadChildren(string, (Result<List<MediaBrowserCompat.MediaItem>>)bundle);
        } else {
            this.onLoadChildren(string, (Result<List<MediaBrowserCompat.MediaItem>>)bundle, (Bundle)object);
        }
        this.mCurConnection = null;
        if (bundle.isDone()) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("onLoadChildren must call detach() or sendResult() before returning for package=");
        ((StringBuilder)object).append(connectionRecord.pkg);
        ((StringBuilder)object).append(" id=");
        ((StringBuilder)object).append(string);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    void performLoadItem(String string, ConnectionRecord object, ResultReceiver resultReceiver) {
        resultReceiver = new /* Unavailable Anonymous Inner Class!! */;
        this.mCurConnection = object;
        this.onLoadItem(string, (Result<MediaBrowserCompat.MediaItem>)resultReceiver);
        this.mCurConnection = null;
        if (resultReceiver.isDone()) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("onLoadItem must call detach() or sendResult() before returning for id=");
        ((StringBuilder)object).append(string);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    void performSearch(String string, Bundle object, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        resultReceiver = new /* Unavailable Anonymous Inner Class!! */;
        this.mCurConnection = connectionRecord;
        this.onSearch(string, (Bundle)object, (Result<List<MediaBrowserCompat.MediaItem>>)resultReceiver);
        this.mCurConnection = null;
        if (resultReceiver.isDone()) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("onSearch must call detach() or sendResult() before returning for query=");
        ((StringBuilder)object).append(string);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    boolean removeSubscription(String var1_1, ConnectionRecord var2_2, IBinder var3_3) {
        var5_5 = true;
        var6_6 = false;
        var4_7 = false;
        if (var3_3 /* !! */  != null) ** GOTO lbl-1000
        try {
            var3_3 /* !! */  = var2_2.subscriptions.remove(var1_1);
            var4_7 = var3_3 /* !! */  != null ? var5_5 : false;
            this.mCurConnection = var2_2;
            this.onUnsubscribe(var1_1);
            this.mCurConnection = null;
            return var4_7;
        }
        catch (Throwable var3_4) {
            this.mCurConnection = var2_2;
            this.onUnsubscribe(var1_1);
            this.mCurConnection = null;
            throw var3_4;
        }
lbl-1000:
        // 1 sources

        {
            var7_8 = (List)var2_2.subscriptions.get(var1_1);
            var5_5 = var6_6;
            if (var7_8 != null) {
                var8_9 = var7_8.iterator();
                while (var8_9.hasNext()) {
                    if (var3_3 /* !! */  != ((Pair)var8_9.next()).first) continue;
                    var8_9.remove();
                    var4_7 = true;
                }
                var5_5 = var4_7;
                if (var7_8.size() == 0) {
                    var2_2.subscriptions.remove(var1_1);
                    var5_5 = var4_7;
                }
            }
            this.mCurConnection = var2_2;
            this.onUnsubscribe(var1_1);
            this.mCurConnection = null;
            return var5_5;
        }
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        if (token == null) throw new IllegalArgumentException("Session token may not be null.");
        if (this.mSession != null) throw new IllegalStateException("The session token has already been set.");
        this.mSession = token;
        this.mImpl.setSessionToken(token);
    }
}
