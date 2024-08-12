/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.BroadcastReceiver$PendingResult
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.support.v4.media.MediaBrowserCompat
 *  android.support.v4.media.MediaBrowserCompat$ConnectionCallback
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.PlaybackStateCompat
 *  android.util.Log
 *  android.view.KeyEvent
 *  androidx.media.session.MediaButtonReceiver$MediaButtonConnectionCallback
 */
package androidx.media.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.media.session.MediaButtonReceiver;

public class MediaButtonReceiver
extends BroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    public static PendingIntent buildMediaButtonPendingIntent(Context context, long l) {
        ComponentName componentName = MediaButtonReceiver.getMediaButtonReceiverComponent(context);
        if (componentName != null) return MediaButtonReceiver.buildMediaButtonPendingIntent(context, componentName, l);
        Log.w((String)TAG, (String)"A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
        return null;
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context object, ComponentName componentName, long l) {
        if (componentName == null) {
            Log.w((String)TAG, (String)"The component name of media button receiver should be provided.");
            return null;
        }
        int n = PlaybackStateCompat.toKeyCode((long)l);
        if (n == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot build a media button pending intent with the given action: ");
            ((StringBuilder)object).append(l);
            Log.w((String)TAG, (String)((StringBuilder)object).toString());
            return null;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        intent.putExtra("android.intent.extra.KEY_EVENT", (Parcelable)new KeyEvent(0, n));
        return PendingIntent.getBroadcast((Context)object, (int)n, (Intent)intent, (int)0);
    }

    public static ComponentName getMediaButtonReceiverComponent(Context object) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(object.getPackageName());
        object = object.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (object.size() == 1) {
            object = (ResolveInfo)object.get(0);
            return new ComponentName(((ResolveInfo)object).activityInfo.packageName, ((ResolveInfo)object).activityInfo.name);
        }
        if (object.size() <= 1) return null;
        Log.w((String)TAG, (String)"More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        return null;
    }

    private static ComponentName getServiceComponentByAction(Context object, String string) {
        PackageManager packageManager = object.getPackageManager();
        Object object2 = new Intent(string);
        object2.setPackage(object.getPackageName());
        object2 = packageManager.queryIntentServices((Intent)object2, 0);
        if (object2.size() == 1) {
            object = (ResolveInfo)object2.get(0);
            return new ComponentName(((ResolveInfo)object).serviceInfo.packageName, ((ResolveInfo)object).serviceInfo.name);
        }
        if (object2.isEmpty()) {
            return null;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Expected 1 service that handles ");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(", found ");
        ((StringBuilder)object).append(object2.size());
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public static KeyEvent handleIntent(MediaSessionCompat mediaSessionCompat, Intent intent) {
        if (mediaSessionCompat == null) return null;
        if (intent == null) return null;
        if (!"android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) return null;
        if (!intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            return null;
        }
        intent = (KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        mediaSessionCompat.getController().dispatchMediaButtonEvent((KeyEvent)intent);
        return intent;
    }

    private static void startForegroundService(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public void onReceive(Context object, Intent intent) {
        if (intent != null && "android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) && intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            ComponentName componentName = MediaButtonReceiver.getServiceComponentByAction((Context)object, "android.intent.action.MEDIA_BUTTON");
            if (componentName != null) {
                intent.setComponent(componentName);
                MediaButtonReceiver.startForegroundService((Context)object, intent);
                return;
            }
            componentName = MediaButtonReceiver.getServiceComponentByAction((Context)object, "android.media.browse.MediaBrowserService");
            if (componentName == null) throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
            BroadcastReceiver.PendingResult pendingResult = this.goAsync();
            object = object.getApplicationContext();
            intent = new MediaButtonConnectionCallback((Context)object, intent, pendingResult);
            object = new MediaBrowserCompat((Context)object, componentName, (MediaBrowserCompat.ConnectionCallback)intent, null);
            intent.setMediaBrowser((MediaBrowserCompat)object);
            object.connect();
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Ignore unsupported intent: ");
        ((StringBuilder)object).append(intent);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
    }
}
