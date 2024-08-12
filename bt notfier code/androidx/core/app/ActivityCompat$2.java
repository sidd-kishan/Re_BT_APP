/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  androidx.core.app.ActivityRecreator
 */
package androidx.core.app;

import android.app.Activity;
import androidx.core.app.ActivityRecreator;

class ActivityCompat.2
implements Runnable {
    final Activity val$activity;

    ActivityCompat.2(Activity activity) {
        this.val$activity = activity;
    }

    @Override
    public void run() {
        if (this.val$activity.isFinishing()) return;
        if (ActivityRecreator.recreate((Activity)this.val$activity)) return;
        this.val$activity.recreate();
    }
}
