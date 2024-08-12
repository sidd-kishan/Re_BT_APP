/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.SharedElementCallback
 *  android.app.SharedElementCallback$OnSharedElementsReadyListener
 *  android.content.Context
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.os.Parcelable
 *  android.view.View
 *  androidx.core.app.SharedElementCallback
 *  androidx.core.app.SharedElementCallback$OnSharedElementsReadyListener
 */
package androidx.core.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import androidx.core.app.SharedElementCallback;
import java.util.List;
import java.util.Map;

private static class ActivityCompat.SharedElementCallback21Impl
extends android.app.SharedElementCallback {
    private final SharedElementCallback mCallback;

    ActivityCompat.SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
        this.mCallback = sharedElementCallback;
    }

    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        return this.mCallback.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    public View onCreateSnapshotView(Context context, Parcelable parcelable) {
        return this.mCallback.onCreateSnapshotView(context, parcelable);
    }

    public void onMapSharedElements(List<String> list, Map<String, View> map) {
        this.mCallback.onMapSharedElements(list, map);
    }

    public void onRejectSharedElements(List<View> list) {
        this.mCallback.onRejectSharedElements(list);
    }

    public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        this.mCallback.onSharedElementEnd(list, list2, list3);
    }

    public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        this.mCallback.onSharedElementStart(list, list2, list3);
    }

    public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.mCallback.onSharedElementsArrived(list, list2, (SharedElementCallback.OnSharedElementsReadyListener)new /* Unavailable Anonymous Inner Class!! */);
    }
}
