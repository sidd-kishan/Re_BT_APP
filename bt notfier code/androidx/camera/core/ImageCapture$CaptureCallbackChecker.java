/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  androidx.camera.core.ImageCapture$CaptureCallbackChecker$CaptureResultChecker
 *  androidx.camera.core.ImageCapture$CaptureCallbackChecker$CaptureResultListener
 *  androidx.camera.core._$$Lambda$ImageCapture$CaptureCallbackChecker$RVxDy_zAdeqk9wi1C8KZybyVmF8
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core;

import android.os.SystemClock;
import androidx.camera.core.ImageCapture;
import androidx.camera.core._$;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

static final class ImageCapture.CaptureCallbackChecker
extends CameraCaptureCallback {
    private static final long NO_TIMEOUT = 0L;
    private final Set<CaptureResultListener> mCaptureResultListeners = new HashSet<CaptureResultListener>();

    ImageCapture.CaptureCallbackChecker() {
    }

    private void deliverCaptureResultToListeners(CameraCaptureResult cameraCaptureResult) {
        Set<CaptureResultListener> set = this.mCaptureResultListeners;
        synchronized (set) {
            HashSet<CaptureResultListener> hashSet = null;
            try {
                HashSet<CaptureResultListener> hashSet2 = new HashSet<CaptureResultListener>(this.mCaptureResultListeners);
                Iterator<CaptureResultListener> iterator = hashSet2.iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        if (hashSet == null) return;
                        this.mCaptureResultListeners.removeAll(hashSet);
                        return;
                    }
                    CaptureResultListener captureResultListener = iterator.next();
                    if (!captureResultListener.onCaptureResult(cameraCaptureResult)) continue;
                    hashSet2 = hashSet;
                    if (hashSet == null) {
                        hashSet2 = new HashSet<CaptureResultListener>();
                    }
                    hashSet2.add(captureResultListener);
                    hashSet = hashSet2;
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    void addListener(CaptureResultListener captureResultListener) {
        Set<CaptureResultListener> set = this.mCaptureResultListeners;
        synchronized (set) {
            this.mCaptureResultListeners.add(captureResultListener);
            return;
        }
    }

    <T> ListenableFuture<T> checkCaptureResult(CaptureResultChecker<T> captureResultChecker) {
        return this.checkCaptureResult(captureResultChecker, 0L, null);
    }

    <T> ListenableFuture<T> checkCaptureResult(CaptureResultChecker<T> object, long l, T t) {
        long l2 = 0L;
        if (l >= 0L) {
            if (l == 0L) return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.ImageCapture.CaptureCallbackChecker.RVxDy_zAdeqk9wi1C8KZybyVmF8(this, (CaptureResultChecker)object, l2, l, t));
            l2 = SystemClock.elapsedRealtime();
            return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.ImageCapture.CaptureCallbackChecker.RVxDy_zAdeqk9wi1C8KZybyVmF8(this, (CaptureResultChecker)object, l2, l, t));
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Invalid timeout value: ");
        ((StringBuilder)object).append(l);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public /* synthetic */ Object lambda$checkCaptureResult$0$ImageCapture$CaptureCallbackChecker(CaptureResultChecker captureResultChecker, long l, long l2, Object object, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.addListener((CaptureResultListener)new /* Unavailable Anonymous Inner Class!! */);
        return "checkCaptureResult";
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
        this.deliverCaptureResultToListeners(cameraCaptureResult);
    }
}
