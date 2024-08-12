/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.provider.Settings$Secure
 *  android.util.Log
 *  androidx.media.MediaSessionManager
 *  androidx.media.MediaSessionManager$MediaSessionManagerImpl
 *  androidx.media.MediaSessionManager$RemoteUserInfoImpl
 */
package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;
import androidx.media.MediaSessionManager;

class MediaSessionManagerImplBase
implements MediaSessionManager.MediaSessionManagerImpl {
    private static final boolean DEBUG = MediaSessionManager.DEBUG;
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final String PERMISSION_MEDIA_CONTENT_CONTROL = "android.permission.MEDIA_CONTENT_CONTROL";
    private static final String PERMISSION_STATUS_BAR_SERVICE = "android.permission.STATUS_BAR_SERVICE";
    private static final String TAG = "MediaSessionManager";
    ContentResolver mContentResolver;
    Context mContext;

    MediaSessionManagerImplBase(Context context) {
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
    }

    private boolean isPermissionGranted(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl, String string) {
        int n = remoteUserInfoImpl.getPid();
        boolean bl = true;
        boolean bl2 = true;
        if (n < 0) {
            if (this.mContext.getPackageManager().checkPermission(string, remoteUserInfoImpl.getPackageName()) == 0) return bl2;
            bl2 = false;
            return bl2;
        }
        bl2 = this.mContext.checkPermission(string, remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0 ? bl : false;
        return bl2;
    }

    public Context getContext() {
        return this.mContext;
    }

    boolean isEnabledNotificationListener(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        String[] stringArray = Settings.Secure.getString((ContentResolver)this.mContentResolver, (String)ENABLED_NOTIFICATION_LISTENERS);
        if (stringArray == null) return false;
        stringArray = stringArray.split(":");
        int n = 0;
        while (n < stringArray.length) {
            ComponentName componentName = ComponentName.unflattenFromString((String)stringArray[n]);
            if (componentName != null && componentName.getPackageName().equals(remoteUserInfoImpl.getPackageName())) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        Object object;
        boolean bl = false;
        try {
            object = this.mContext.getPackageManager().getApplicationInfo(remoteUserInfoImpl.getPackageName(), 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            if (!DEBUG) return false;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Package ");
            stringBuilder.append(remoteUserInfoImpl.getPackageName());
            stringBuilder.append(" doesn't exist");
            Log.d((String)TAG, (String)stringBuilder.toString());
            return false;
        }
        if (((ApplicationInfo)object).uid != remoteUserInfoImpl.getUid()) {
            if (!DEBUG) return false;
            object = new StringBuilder();
            ((StringBuilder)object).append("Package name ");
            ((StringBuilder)object).append(remoteUserInfoImpl.getPackageName());
            ((StringBuilder)object).append(" doesn't match with the uid ");
            ((StringBuilder)object).append(remoteUserInfoImpl.getUid());
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
            return false;
        }
        if (!this.isPermissionGranted(remoteUserInfoImpl, PERMISSION_STATUS_BAR_SERVICE) && !this.isPermissionGranted(remoteUserInfoImpl, PERMISSION_MEDIA_CONTENT_CONTROL) && remoteUserInfoImpl.getUid() != 1000) {
            if (!this.isEnabledNotificationListener(remoteUserInfoImpl)) return bl;
        }
        bl = true;
        return bl;
    }
}
