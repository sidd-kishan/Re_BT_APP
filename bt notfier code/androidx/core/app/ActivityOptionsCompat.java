/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityOptions
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.Pair
 *  android.view.View
 *  androidx.core.app.ActivityOptionsCompat$ActivityOptionsCompatImpl
 *  androidx.core.util.Pair
 */
package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import androidx.core.app.ActivityOptionsCompat;

public class ActivityOptionsCompat {
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    protected ActivityOptionsCompat() {
    }

    public static ActivityOptionsCompat makeBasic() {
        if (Build.VERSION.SDK_INT < 23) return new ActivityOptionsCompat();
        return new ActivityOptionsCompatImpl(ActivityOptions.makeBasic());
    }

    public static ActivityOptionsCompat makeClipRevealAnimation(View view, int n, int n2, int n3, int n4) {
        if (Build.VERSION.SDK_INT < 23) return new ActivityOptionsCompat();
        return new ActivityOptionsCompatImpl(ActivityOptions.makeClipRevealAnimation((View)view, (int)n, (int)n2, (int)n3, (int)n4));
    }

    public static ActivityOptionsCompat makeCustomAnimation(Context context, int n, int n2) {
        if (Build.VERSION.SDK_INT < 16) return new ActivityOptionsCompat();
        return new ActivityOptionsCompatImpl(ActivityOptions.makeCustomAnimation((Context)context, (int)n, (int)n2));
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View view, int n, int n2, int n3, int n4) {
        if (Build.VERSION.SDK_INT < 16) return new ActivityOptionsCompat();
        return new ActivityOptionsCompatImpl(ActivityOptions.makeScaleUpAnimation((View)view, (int)n, (int)n2, (int)n3, (int)n4));
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, View view, String string) {
        if (Build.VERSION.SDK_INT < 21) return new ActivityOptionsCompat();
        return new ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation((Activity)activity, (View)view, (String)string));
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, androidx.core.util.Pair<View, String> ... pairArray) {
        if (Build.VERSION.SDK_INT < 21) return new ActivityOptionsCompat();
        Pair[] pairArray2 = null;
        if (pairArray == null) return new ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation((Activity)activity, pairArray2));
        Pair[] pairArray3 = new Pair[pairArray.length];
        int n = 0;
        while (true) {
            pairArray2 = pairArray3;
            if (n >= pairArray.length) return new ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation((Activity)activity, pairArray2));
            pairArray3[n] = Pair.create((Object)((View)pairArray[n].first), (Object)((String)pairArray[n].second));
            ++n;
        }
    }

    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        if (Build.VERSION.SDK_INT < 21) return new ActivityOptionsCompat();
        return new ActivityOptionsCompatImpl(ActivityOptions.makeTaskLaunchBehind());
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int n, int n2) {
        if (Build.VERSION.SDK_INT < 16) return new ActivityOptionsCompat();
        return new ActivityOptionsCompatImpl(ActivityOptions.makeThumbnailScaleUpAnimation((View)view, (Bitmap)bitmap, (int)n, (int)n2));
    }

    public Rect getLaunchBounds() {
        return null;
    }

    public void requestUsageTimeReport(PendingIntent pendingIntent) {
    }

    public ActivityOptionsCompat setLaunchBounds(Rect rect) {
        return this;
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat activityOptionsCompat) {
    }
}
