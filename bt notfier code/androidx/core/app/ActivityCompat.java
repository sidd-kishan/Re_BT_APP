/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.SharedElementCallback
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.view.DragEvent
 *  android.view.View
 *  androidx.core.app.ActivityCompat$Api30Impl
 *  androidx.core.app.ActivityCompat$OnRequestPermissionsResultCallback
 *  androidx.core.app.ActivityCompat$PermissionCompatDelegate
 *  androidx.core.app.ActivityCompat$RequestPermissionsRequestCodeValidator
 *  androidx.core.app.ActivityCompat$SharedElementCallback21Impl
 *  androidx.core.app.ActivityRecreator
 *  androidx.core.app.SharedElementCallback
 *  androidx.core.content.ContextCompat
 *  androidx.core.content.LocusIdCompat
 *  androidx.core.view.DragAndDropPermissionsCompat
 */
package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityRecreator;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.util.Arrays;

/*
 * Exception performing whole class analysis ignored.
 */
public class ActivityCompat
extends ContextCompat {
    private static PermissionCompatDelegate sDelegate;

    protected ActivityCompat() {
    }

    public static void finishAffinity(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void finishAfterTransition(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    public static Uri getReferrer(Activity object) {
        if (Build.VERSION.SDK_INT >= 22) {
            return object.getReferrer();
        }
        Uri uri = (Uri)(object = object.getIntent()).getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        if ((object = object.getStringExtra("android.intent.extra.REFERRER_NAME")) == null) return null;
        return Uri.parse((String)object);
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    public static void postponeEnterTransition(Activity activity) {
        if (Build.VERSION.SDK_INT < 21) return;
        activity.postponeEnterTransition();
    }

    public static void recreate(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else if (Build.VERSION.SDK_INT <= 23) {
            new Handler(activity.getMainLooper()).post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            if (ActivityRecreator.recreate((Activity)activity)) return;
            activity.recreate();
        }
    }

    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity activity, DragEvent dragEvent) {
        return DragAndDropPermissionsCompat.request((Activity)activity, (DragEvent)dragEvent);
    }

    public static void requestPermissions(Activity object, String[] stringArray, int n) {
        PermissionCompatDelegate permissionCompatDelegate = sDelegate;
        if (permissionCompatDelegate != null && permissionCompatDelegate.requestPermissions((Activity)object, stringArray, n)) {
            return;
        }
        int n2 = stringArray.length;
        for (int i = 0; i < n2; ++i) {
            if (!TextUtils.isEmpty((CharSequence)stringArray[i])) continue;
            object = new StringBuilder();
            ((StringBuilder)object).append("Permission request for permissions ");
            ((StringBuilder)object).append(Arrays.toString(stringArray));
            ((StringBuilder)object).append(" must not contain null or empty values");
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (object instanceof RequestPermissionsRequestCodeValidator) {
                ((RequestPermissionsRequestCodeValidator)object).validateRequestPermissionsRequestCode(n);
            }
            object.requestPermissions(stringArray, n);
        } else {
            if (!(object instanceof OnRequestPermissionsResultCallback)) return;
            new Handler(Looper.getMainLooper()).post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    public static <T extends View> T requireViewById(Activity activity, int n) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T)activity.requireViewById(n);
        }
        if ((activity = activity.findViewById(n)) == null) throw new IllegalArgumentException("ID does not reference a View inside this Activity");
        return (T)activity;
    }

    public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback object) {
        if (Build.VERSION.SDK_INT < 21) return;
        object = object != null ? new SharedElementCallback21Impl(object) : null;
        activity.setEnterSharedElementCallback((android.app.SharedElementCallback)object);
    }

    public static void setExitSharedElementCallback(Activity activity, SharedElementCallback object) {
        if (Build.VERSION.SDK_INT < 21) return;
        object = object != null ? new SharedElementCallback21Impl(object) : null;
        activity.setExitSharedElementCallback((android.app.SharedElementCallback)object);
    }

    public static void setLocusContext(Activity activity, LocusIdCompat locusIdCompat, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 30) return;
        Api30Impl.setLocusContext((Activity)activity, (LocusIdCompat)locusIdCompat, (Bundle)bundle);
    }

    public static void setPermissionCompatDelegate(PermissionCompatDelegate permissionCompatDelegate) {
        sDelegate = permissionCompatDelegate;
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String string) {
        if (Build.VERSION.SDK_INT < 23) return false;
        return activity.shouldShowRequestPermissionRationale(string);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int n, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, n, bundle);
        } else {
            activity.startActivityForResult(intent, n);
        }
    }

    public static void startIntentSenderForResult(Activity activity, IntentSender intentSender, int n, Intent intent, int n2, int n3, int n4, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4);
        }
    }

    public static void startPostponedEnterTransition(Activity activity) {
        if (Build.VERSION.SDK_INT < 21) return;
        activity.startPostponedEnterTransition();
    }
}
