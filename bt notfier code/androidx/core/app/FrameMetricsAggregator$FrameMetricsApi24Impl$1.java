/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.FrameMetrics
 *  android.view.Window
 *  android.view.Window$OnFrameMetricsAvailableListener
 *  androidx.core.app.FrameMetricsAggregator$FrameMetricsApi24Impl
 */
package androidx.core.app;

import android.view.FrameMetrics;
import android.view.Window;
import androidx.core.app.FrameMetricsAggregator;

class FrameMetricsAggregator.FrameMetricsApi24Impl.1
implements Window.OnFrameMetricsAvailableListener {
    final FrameMetricsAggregator.FrameMetricsApi24Impl this$0;

    FrameMetricsAggregator.FrameMetricsApi24Impl.1(FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl) {
        this.this$0 = frameMetricsApi24Impl;
    }

    public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int n) {
        if ((this.this$0.mTrackingFlags & 1) != 0) {
            window = this.this$0;
            window.addDurationItem(window.mMetrics[0], frameMetrics.getMetric(8));
        }
        if ((this.this$0.mTrackingFlags & 2) != 0) {
            window = this.this$0;
            window.addDurationItem(window.mMetrics[1], frameMetrics.getMetric(1));
        }
        if ((this.this$0.mTrackingFlags & 4) != 0) {
            window = this.this$0;
            window.addDurationItem(window.mMetrics[2], frameMetrics.getMetric(3));
        }
        if ((this.this$0.mTrackingFlags & 8) != 0) {
            window = this.this$0;
            window.addDurationItem(window.mMetrics[3], frameMetrics.getMetric(4));
        }
        if ((this.this$0.mTrackingFlags & 0x10) != 0) {
            window = this.this$0;
            window.addDurationItem(window.mMetrics[4], frameMetrics.getMetric(5));
        }
        if ((this.this$0.mTrackingFlags & 0x40) != 0) {
            window = this.this$0;
            window.addDurationItem(window.mMetrics[6], frameMetrics.getMetric(7));
        }
        if ((this.this$0.mTrackingFlags & 0x20) != 0) {
            window = this.this$0;
            window.addDurationItem(window.mMetrics[5], frameMetrics.getMetric(6));
        }
        if ((this.this$0.mTrackingFlags & 0x80) != 0) {
            window = this.this$0;
            window.addDurationItem(window.mMetrics[7], frameMetrics.getMetric(0));
        }
        if ((this.this$0.mTrackingFlags & 0x100) == 0) return;
        window = this.this$0;
        window.addDurationItem(window.mMetrics[8], frameMetrics.getMetric(2));
    }
}
