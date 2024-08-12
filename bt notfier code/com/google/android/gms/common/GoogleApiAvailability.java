/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.app.FragmentManager
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.util.Log
 *  android.view.View
 *  android.widget.ProgressBar
 *  androidx.core.app.NotificationCompat$BigTextStyle
 *  androidx.core.app.NotificationCompat$Builder
 *  androidx.core.app.NotificationCompat$Style
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  com.google.android.gms.base.R$drawable
 *  com.google.android.gms.base.R$string
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.ErrorDialogFragment
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.GooglePlayServicesUtilLight
 *  com.google.android.gms.common.SupportErrorDialogFragment
 *  com.google.android.gms.common.api.GoogleApi
 *  com.google.android.gms.common.api.GoogleApiActivity
 *  com.google.android.gms.common.api.HasApiKey
 *  com.google.android.gms.common.api.internal.ApiKey
 *  com.google.android.gms.common.api.internal.GoogleApiManager
 *  com.google.android.gms.common.api.internal.LifecycleFragment
 *  com.google.android.gms.common.api.internal.zabq
 *  com.google.android.gms.common.api.internal.zabr
 *  com.google.android.gms.common.api.internal.zabw
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zac
 *  com.google.android.gms.common.internal.zag
 *  com.google.android.gms.common.util.DeviceProperties
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.common.zaa
 *  com.google.android.gms.common.zab
 *  com.google.android.gms.common.zac
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.Tasks
 */
package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.base.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.ErrorDialogFragment;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.SupportErrorDialogFragment;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabr;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.zaa;
import com.google.android.gms.common.zab;
import com.google.android.gms.common.zac;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class GoogleApiAvailability
extends GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final Object zaa;
    private static final GoogleApiAvailability zab;
    private String zac;

    static {
        zaa = new Object();
        zab = new GoogleApiAvailability();
        GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public static GoogleApiAvailability getInstance() {
        return zab;
    }

    public static final Task<Map<ApiKey<?>, String>> zai(HasApiKey<?> hasApiKey, HasApiKey<?> ... hasApiKeyArray) {
        Preconditions.checkNotNull(hasApiKey, (Object)"Requested API must not be null.");
        int n = hasApiKeyArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                ArrayList arrayList = new ArrayList(hasApiKeyArray.length + 1);
                arrayList.add(hasApiKey);
                arrayList.addAll(Arrays.asList(hasApiKeyArray));
                return GoogleApiManager.zab().zah(arrayList);
            }
            Preconditions.checkNotNull(hasApiKeyArray[n2], (Object)"Requested API must not be null.");
            ++n2;
        }
    }

    public Task<Void> checkApiAvailability(GoogleApi<?> googleApi, GoogleApi<?> ... googleApiArray) {
        return GoogleApiAvailability.zai(googleApi, googleApiArray).onSuccessTask(com.google.android.gms.common.zab.zaa);
    }

    public Task<Void> checkApiAvailability(HasApiKey<?> hasApiKey, HasApiKey<?> ... hasApiKeyArray) {
        return GoogleApiAvailability.zai(hasApiKey, hasApiKeyArray).onSuccessTask(com.google.android.gms.common.zaa.zaa);
    }

    public int getClientVersion(Context context) {
        return super.getClientVersion(context);
    }

    public Dialog getErrorDialog(Activity activity, int n, int n2) {
        return this.getErrorDialog(activity, n, n2, null);
    }

    public Dialog getErrorDialog(Activity activity, int n, int n2, DialogInterface.OnCancelListener onCancelListener) {
        return this.zaf((Context)activity, n, zag.zab((Activity)activity, (Intent)this.getErrorResolutionIntent((Context)activity, n, "d"), (int)n2), onCancelListener);
    }

    public Dialog getErrorDialog(Fragment fragment, int n, int n2) {
        return this.getErrorDialog(fragment, n, n2, null);
    }

    public Dialog getErrorDialog(Fragment fragment, int n, int n2, DialogInterface.OnCancelListener onCancelListener) {
        Intent intent = this.getErrorResolutionIntent(fragment.requireContext(), n, "d");
        return this.zaf(fragment.requireContext(), n, zag.zac((Fragment)fragment, (Intent)intent, (int)n2), onCancelListener);
    }

    public Intent getErrorResolutionIntent(Context context, int n, String string) {
        return super.getErrorResolutionIntent(context, n, string);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int n, int n2) {
        return super.getErrorResolutionPendingIntent(context, n, n2);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, ConnectionResult connectionResult) {
        if (!connectionResult.hasResolution()) return this.getErrorResolutionPendingIntent(context, connectionResult.getErrorCode(), 0);
        return connectionResult.getResolution();
    }

    public final String getErrorString(int n) {
        return super.getErrorString(n);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    public int isGooglePlayServicesAvailable(Context context, int n) {
        return super.isGooglePlayServicesAvailable(context, n);
    }

    public final boolean isUserResolvableError(int n) {
        return super.isUserResolvableError(n);
    }

    public Task<Void> makeGooglePlayServicesAvailable(Activity activity) {
        int n = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Preconditions.checkMainThread((String)"makeGooglePlayServicesAvailable must be called from the main thread");
        n = this.isGooglePlayServicesAvailable((Context)activity, n);
        if (n == 0) {
            activity = Tasks.forResult(null);
        } else {
            activity = zabw.zaa((Activity)activity);
            activity.zaf(new ConnectionResult(n, null), 0);
            activity = activity.zab();
        }
        return activity;
    }

    public void setDefaultNotificationChannelId(Context object, String string) {
        if (PlatformVersion.isAtLeastO()) {
            Preconditions.checkNotNull((Object)((NotificationManager)Preconditions.checkNotNull((Object)object.getSystemService("notification"))).getNotificationChannel(string));
        }
        object = zaa;
        synchronized (object) {
            this.zac = string;
            return;
        }
    }

    public boolean showErrorDialogFragment(Activity activity, int n, int n2) {
        return this.showErrorDialogFragment(activity, n, n2, null);
    }

    public boolean showErrorDialogFragment(Activity activity, int n, int n2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialog = this.getErrorDialog(activity, n, n2, onCancelListener);
        if (dialog == null) {
            return false;
        }
        this.zag(activity, dialog, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void showErrorNotification(Context context, int n) {
        this.zab(context, n, null, this.getErrorResolutionPendingIntent(context, n, 0, "n"));
    }

    public void showErrorNotification(Context context, ConnectionResult connectionResult) {
        PendingIntent pendingIntent = this.getErrorResolutionPendingIntent(context, connectionResult);
        this.zab(context, connectionResult.getErrorCode(), null, pendingIntent);
    }

    public final boolean zaa(Activity activity, LifecycleFragment lifecycleFragment, int n, int n2, DialogInterface.OnCancelListener onCancelListener) {
        if ((lifecycleFragment = this.zaf((Context)activity, n, zag.zad((LifecycleFragment)lifecycleFragment, (Intent)this.getErrorResolutionIntent((Context)activity, n, "d"), (int)2), onCancelListener)) == null) {
            return false;
        }
        this.zag(activity, (Dialog)lifecycleFragment, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    final void zab(Context object, int n, String object2, PendingIntent object3) {
        Log.w((String)"GoogleApiAvailability", (String)String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", n, null), (Throwable)new IllegalArgumentException());
        if (n == 18) {
            this.zah((Context)object);
            return;
        }
        if (object3 == null) {
            if (n != 6) return;
            Log.w((String)"GoogleApiAvailability", (String)"Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            return;
        }
        String string2 = com.google.android.gms.common.internal.zac.zab((Context)object, (int)n);
        String string3 = com.google.android.gms.common.internal.zac.zad((Context)object, (int)n);
        object2 = object.getResources();
        NotificationManager notificationManager = (NotificationManager)Preconditions.checkNotNull((Object)object.getSystemService("notification"));
        string2 = new NotificationCompat.Builder((Context)object).setLocalOnly(true).setAutoCancel(true).setContentTitle((CharSequence)string2).setStyle((NotificationCompat.Style)new NotificationCompat.BigTextStyle().bigText((CharSequence)string3));
        if (DeviceProperties.isWearable((Context)object)) {
            Preconditions.checkState((boolean)PlatformVersion.isAtLeastKitKatWatch());
            string2.setSmallIcon(object.getApplicationInfo().icon).setPriority(2);
            if (DeviceProperties.isWearableWithoutPlayStore((Context)object)) {
                string2.addAction(R.drawable.common_full_open_on_phone, (CharSequence)object2.getString(R.string.common_open_on_phone), object3);
            } else {
                string2.setContentIntent(object3);
            }
        } else {
            string2.setSmallIcon(17301642).setTicker((CharSequence)object2.getString(R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(object3).setContentText((CharSequence)string3);
        }
        if (PlatformVersion.isAtLeastO()) {
            Preconditions.checkState((boolean)PlatformVersion.isAtLeastO());
            object2 = zaa;
            synchronized (object2) {
                object3 = this.zac;
            }
            object2 = object3;
            if (object3 == null) {
                object3 = "com.google.android.gms.availability";
                string3 = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                object = com.google.android.gms.common.internal.zac.zag((Context)object);
                if (string3 == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", (CharSequence)object, 4));
                    object2 = object3;
                } else {
                    object2 = object3;
                    if (!((String)object).contentEquals(string3.getName())) {
                        string3.setName((CharSequence)object);
                        notificationManager.createNotificationChannel((NotificationChannel)string3);
                        object2 = object3;
                    }
                }
            }
            string2.setChannelId((String)object2);
        }
        object = string2.build();
        if (n != 1 && n != 2 && n != 3) {
            n = 39789;
        } else {
            GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
            n = 10436;
        }
        notificationManager.notify(n, (Notification)object);
    }

    public final boolean zac(Context context, ConnectionResult connectionResult, int n) {
        PendingIntent pendingIntent = this.getErrorResolutionPendingIntent(context, connectionResult);
        if (pendingIntent == null) return false;
        this.zab(context, connectionResult.getErrorCode(), null, PendingIntent.getActivity((Context)context, (int)0, (Intent)GoogleApiActivity.zaa((Context)context, (PendingIntent)pendingIntent, (int)n, (boolean)true), (int)0x8000000));
        return true;
    }

    public final Dialog zad(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar((Context)activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity);
        builder.setView((View)progressBar);
        builder.setMessage((CharSequence)com.google.android.gms.common.internal.zac.zac((Context)activity, (int)18));
        builder.setPositiveButton((CharSequence)"", null);
        builder = builder.create();
        this.zag(activity, (Dialog)builder, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return builder;
    }

    public final zabr zae(Context context, zabq zabq2) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabr zabr2 = new zabr(zabq2);
        context.registerReceiver((BroadcastReceiver)zabr2, intentFilter);
        zabr2.zaa(context);
        if (this.isUninstalledAppPossiblyUpdating(context, GOOGLE_PLAY_SERVICES_PACKAGE)) return zabr2;
        zabq2.zaa();
        zabr2.zab();
        return null;
    }

    final Dialog zaf(Context object, int n, zag zag2, DialogInterface.OnCancelListener object2) {
        AlertDialog.Builder builder = null;
        if (n == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        object.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(object.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(object, 5);
        }
        typedValue = builder;
        if (builder == null) {
            typedValue = new AlertDialog.Builder(object);
        }
        typedValue.setMessage(com.google.android.gms.common.internal.zac.zac((Context)object, (int)n));
        if (object2 != null) {
            typedValue.setOnCancelListener((DialogInterface.OnCancelListener)object2);
        }
        if ((object2 = com.google.android.gms.common.internal.zac.zae((Context)object, (int)n)) != null) {
            typedValue.setPositiveButton((CharSequence)object2, (DialogInterface.OnClickListener)zag2);
        }
        if ((object = com.google.android.gms.common.internal.zac.zaa((Context)object, (int)n)) != null) {
            typedValue.setTitle((CharSequence)object);
        }
        Log.w((String)"GoogleApiAvailability", (String)String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", n), (Throwable)new IllegalArgumentException());
        return typedValue.create();
    }

    final void zag(Activity activity, Dialog dialog, String string2, DialogInterface.OnCancelListener onCancelListener) {
        block2: {
            try {
                boolean bl = activity instanceof FragmentActivity;
                if (!bl) break block2;
            }
            catch (NoClassDefFoundError noClassDefFoundError) {
                break block2;
            }
            activity = ((FragmentActivity)activity).getSupportFragmentManager();
            SupportErrorDialogFragment.newInstance((Dialog)dialog, (DialogInterface.OnCancelListener)onCancelListener).show((androidx.fragment.app.FragmentManager)activity, string2);
            return;
        }
        activity = activity.getFragmentManager();
        ErrorDialogFragment.newInstance((Dialog)dialog, (DialogInterface.OnCancelListener)onCancelListener).show((FragmentManager)activity, string2);
    }

    final void zah(Context context) {
        new zac(this, context).sendEmptyMessageDelayed(1, 120000L);
    }
}
