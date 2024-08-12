/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.Logger
 *  androidx.camera.core.VideoCapture$OnVideoSavedCallback
 *  androidx.camera.core.VideoCapture$OutputFileResults
 *  androidx.camera.core._$$Lambda$VideoCapture$VideoSavedListenerWrapper$KU2m9a3qs50ToqRVEWEd3NSIkBg
 *  androidx.camera.core._$$Lambda$VideoCapture$VideoSavedListenerWrapper$ZG5otqrkESy2VwQvd4RLRJQ1fFY
 */
package androidx.camera.core;

import androidx.camera.core.Logger;
import androidx.camera.core.VideoCapture;
import androidx.camera.core._$;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

private static final class VideoCapture.VideoSavedListenerWrapper
implements VideoCapture.OnVideoSavedCallback {
    Executor mExecutor;
    VideoCapture.OnVideoSavedCallback mOnVideoSavedCallback;

    VideoCapture.VideoSavedListenerWrapper(Executor executor, VideoCapture.OnVideoSavedCallback onVideoSavedCallback) {
        this.mExecutor = executor;
        this.mOnVideoSavedCallback = onVideoSavedCallback;
    }

    public /* synthetic */ void lambda$onError$1$VideoCapture$VideoSavedListenerWrapper(int n, String string, Throwable throwable) {
        this.mOnVideoSavedCallback.onError(n, string, throwable);
    }

    public /* synthetic */ void lambda$onVideoSaved$0$VideoCapture$VideoSavedListenerWrapper(VideoCapture.OutputFileResults outputFileResults) {
        this.mOnVideoSavedCallback.onVideoSaved(outputFileResults);
    }

    public void onError(int n, String string, Throwable throwable) {
        try {
            Executor executor = this.mExecutor;
            _$.Lambda.VideoCapture.VideoSavedListenerWrapper.ZG5otqrkESy2VwQvd4RLRJQ1fFY zG5otqrkESy2VwQvd4RLRJQ1fFY = new _$.Lambda.VideoCapture.VideoSavedListenerWrapper.ZG5otqrkESy2VwQvd4RLRJQ1fFY(this, n, string, throwable);
            executor.execute((Runnable)zG5otqrkESy2VwQvd4RLRJQ1fFY);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            Logger.e((String)"VideoCapture", (String)"Unable to post to the supplied executor.");
        }
    }

    public void onVideoSaved(VideoCapture.OutputFileResults outputFileResults) {
        try {
            Executor executor = this.mExecutor;
            _$.Lambda.VideoCapture.VideoSavedListenerWrapper.KU2m9a3qs50ToqRVEWEd3NSIkBg kU2m9a3qs50ToqRVEWEd3NSIkBg = new _$.Lambda.VideoCapture.VideoSavedListenerWrapper.KU2m9a3qs50ToqRVEWEd3NSIkBg(this, outputFileResults);
            executor.execute((Runnable)kU2m9a3qs50ToqRVEWEd3NSIkBg);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            Logger.e((String)"VideoCapture", (String)"Unable to post to the supplied executor.");
        }
    }
}
