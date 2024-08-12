/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityOptions
 *  android.app.PendingIntent
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  androidx.core.app.ActivityOptionsCompat
 */
package androidx.core.app;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.ActivityOptionsCompat;

private static class ActivityOptionsCompat.ActivityOptionsCompatImpl
extends ActivityOptionsCompat {
    private final ActivityOptions mActivityOptions;

    ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions activityOptions) {
        this.mActivityOptions = activityOptions;
    }

    public Rect getLaunchBounds() {
        if (Build.VERSION.SDK_INT >= 24) return this.mActivityOptions.getLaunchBounds();
        return null;
    }

    public void requestUsageTimeReport(PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT < 23) return;
        this.mActivityOptions.requestUsageTimeReport(pendingIntent);
    }

    public ActivityOptionsCompat setLaunchBounds(Rect rect) {
        if (Build.VERSION.SDK_INT >= 24) return new ActivityOptionsCompat.ActivityOptionsCompatImpl(this.mActivityOptions.setLaunchBounds(rect));
        return this;
    }

    public Bundle toBundle() {
        return this.mActivityOptions.toBundle();
    }

    public void update(ActivityOptionsCompat activityOptionsCompat) {
        if (!(activityOptionsCompat instanceof ActivityOptionsCompat.ActivityOptionsCompatImpl)) return;
        activityOptionsCompat = (ActivityOptionsCompat.ActivityOptionsCompatImpl)activityOptionsCompat;
        this.mActivityOptions.update(activityOptionsCompat.mActivityOptions);
    }
}
