/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.util.SparseIntArray
 *  android.view.Window$OnFrameMetricsAvailableListener
 *  androidx.core.app.FrameMetricsAggregator$FrameMetricsBaseImpl
 */
package androidx.core.app;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.Window;
import androidx.core.app.FrameMetricsAggregator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

private static class FrameMetricsAggregator.FrameMetricsApi24Impl
extends FrameMetricsAggregator.FrameMetricsBaseImpl {
    private static final int NANOS_PER_MS = 1000000;
    private static final int NANOS_ROUNDING_VALUE = 500000;
    private static Handler sHandler;
    private static HandlerThread sHandlerThread;
    private ArrayList<WeakReference<Activity>> mActivities;
    Window.OnFrameMetricsAvailableListener mListener;
    SparseIntArray[] mMetrics = new SparseIntArray[9];
    int mTrackingFlags;

    FrameMetricsAggregator.FrameMetricsApi24Impl(int n) {
        this.mActivities = new ArrayList();
        this.mListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mTrackingFlags = n;
    }

    public void add(Activity activity) {
        SparseIntArray[] sparseIntArrayArray;
        if (sHandlerThread == null) {
            sparseIntArrayArray = new HandlerThread("FrameMetricsAggregator");
            sHandlerThread = sparseIntArrayArray;
            sparseIntArrayArray.start();
            sHandler = new Handler(sHandlerThread.getLooper());
        }
        int n = 0;
        while (true) {
            if (n > 8) {
                activity.getWindow().addOnFrameMetricsAvailableListener(this.mListener, sHandler);
                this.mActivities.add(new WeakReference<Activity>(activity));
                return;
            }
            sparseIntArrayArray = this.mMetrics;
            if (sparseIntArrayArray[n] == null && (this.mTrackingFlags & 1 << n) != 0) {
                sparseIntArrayArray[n] = new SparseIntArray();
            }
            ++n;
        }
    }

    void addDurationItem(SparseIntArray sparseIntArray, long l) {
        if (sparseIntArray == null) return;
        int n = (int)((500000L + l) / 1000000L);
        if (l < 0L) return;
        sparseIntArray.put(n, sparseIntArray.get(n) + 1);
    }

    public SparseIntArray[] getMetrics() {
        return this.mMetrics;
    }

    public SparseIntArray[] remove(Activity activity) {
        for (WeakReference<Activity> weakReference : this.mActivities) {
            if (weakReference.get() != activity) continue;
            this.mActivities.remove(weakReference);
            break;
        }
        activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
        return this.mMetrics;
    }

    public SparseIntArray[] reset() {
        SparseIntArray[] sparseIntArrayArray = this.mMetrics;
        this.mMetrics = new SparseIntArray[9];
        return sparseIntArrayArray;
    }

    public SparseIntArray[] stop() {
        int n = this.mActivities.size() - 1;
        while (n >= 0) {
            WeakReference<Activity> weakReference = this.mActivities.get(n);
            Activity activity = (Activity)weakReference.get();
            if (weakReference.get() != null) {
                activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
                this.mActivities.remove(n);
            }
            --n;
        }
        return this.mMetrics;
    }
}
