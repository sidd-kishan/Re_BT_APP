/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.pm.PackageManager
 *  androidx.core.app.ActivityCompat$OnRequestPermissionsResultCallback
 */
package androidx.core.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;

class ActivityCompat.1
implements Runnable {
    final Activity val$activity;
    final String[] val$permissions;
    final int val$requestCode;

    ActivityCompat.1(String[] stringArray, Activity activity, int n) {
        this.val$permissions = stringArray;
        this.val$activity = activity;
        this.val$requestCode = n;
    }

    @Override
    public void run() {
        int[] nArray = new int[this.val$permissions.length];
        PackageManager packageManager = this.val$activity.getPackageManager();
        String string = this.val$activity.getPackageName();
        int n = this.val$permissions.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                ((ActivityCompat.OnRequestPermissionsResultCallback)this.val$activity).onRequestPermissionsResult(this.val$requestCode, this.val$permissions, nArray);
                return;
            }
            nArray[n2] = packageManager.checkPermission(this.val$permissions[n2], string);
            ++n2;
        }
    }
}
