/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  androidx.fragment.app.Fragment
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.common.GooglePlayServicesUtilLight
 *  com.google.android.gms.common.internal.zag
 */
package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.zag;

public final class GooglePlayServicesUtil
extends GooglePlayServicesUtilLight {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int n, Activity activity, int n2) {
        return GooglePlayServicesUtil.getErrorDialog(n, activity, n2, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int n, Activity activity, int n2, DialogInterface.OnCancelListener onCancelListener) {
        int n3 = n;
        if (true != GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating((Context)activity, (int)n)) return GoogleApiAvailability.getInstance().getErrorDialog(activity, n3, n2, onCancelListener);
        n3 = 18;
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, n3, n2, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int n, Context context, int n2) {
        return GooglePlayServicesUtilLight.getErrorPendingIntent((int)n, (Context)context, (int)n2);
    }

    @Deprecated
    public static String getErrorString(int n) {
        return GooglePlayServicesUtilLight.getErrorString((int)n);
    }

    public static Context getRemoteContext(Context context) {
        return GooglePlayServicesUtilLight.getRemoteContext((Context)context);
    }

    public static Resources getRemoteResource(Context context) {
        return GooglePlayServicesUtilLight.getRemoteResource((Context)context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable((Context)context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context, int n) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable((Context)context, (int)n);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int n) {
        return GooglePlayServicesUtilLight.isUserRecoverableError((int)n);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int n, Activity activity, int n2) {
        return GooglePlayServicesUtil.showErrorDialogFragment(n, activity, n2, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int n, Activity activity, int n2, DialogInterface.OnCancelListener onCancelListener) {
        return GooglePlayServicesUtil.showErrorDialogFragment(n, activity, null, n2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int n, Activity activity, Fragment fragment, int n2, DialogInterface.OnCancelListener onCancelListener) {
        int n3 = n;
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating((Context)activity, (int)n)) {
            n3 = 18;
        }
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            return googleApiAvailability.showErrorDialogFragment(activity, n3, n2, onCancelListener);
        }
        if ((fragment = googleApiAvailability.zaf((Context)activity, n3, zag.zac((Fragment)fragment, (Intent)GoogleApiAvailability.getInstance().getErrorResolutionIntent((Context)activity, n3, "d"), (int)n2), onCancelListener)) == null) {
            return false;
        }
        googleApiAvailability.zag(activity, (Dialog)fragment, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int n, Context context) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (!GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating((Context)context, (int)n) && !GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating((Context)context, (int)n)) {
            googleApiAvailability.showErrorNotification(context, n);
            return;
        }
        googleApiAvailability.zah(context);
    }
}
