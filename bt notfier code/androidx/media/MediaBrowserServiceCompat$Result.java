/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.media;

import android.os.Bundle;

public static class MediaBrowserServiceCompat.Result<T> {
    private final Object mDebug;
    private boolean mDetachCalled;
    private int mFlags;
    private boolean mSendErrorCalled;
    private boolean mSendProgressUpdateCalled;
    private boolean mSendResultCalled;

    MediaBrowserServiceCompat.Result(Object object) {
        this.mDebug = object;
    }

    private void checkExtraFields(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (!bundle.containsKey("android.media.browse.extra.DOWNLOAD_PROGRESS")) return;
        float f = bundle.getFloat("android.media.browse.extra.DOWNLOAD_PROGRESS");
        if (f < -1.0E-5f) throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
        if (f > 1.00001f) throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
    }

    public void detach() {
        if (this.mDetachCalled) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("detach() called when detach() had already been called for: ");
            stringBuilder.append(this.mDebug);
            throw new IllegalStateException(stringBuilder.toString());
        }
        if (this.mSendResultCalled) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("detach() called when sendResult() had already been called for: ");
            stringBuilder.append(this.mDebug);
            throw new IllegalStateException(stringBuilder.toString());
        }
        if (!this.mSendErrorCalled) {
            this.mDetachCalled = true;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("detach() called when sendError() had already been called for: ");
        stringBuilder.append(this.mDebug);
        throw new IllegalStateException(stringBuilder.toString());
    }

    int getFlags() {
        return this.mFlags;
    }

    boolean isDone() {
        boolean bl = this.mDetachCalled || this.mSendResultCalled || this.mSendErrorCalled;
        return bl;
    }

    void onErrorSent(Bundle object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("It is not supported to send an error for ");
        ((StringBuilder)object).append(this.mDebug);
        throw new UnsupportedOperationException(((StringBuilder)object).toString());
    }

    void onProgressUpdateSent(Bundle object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("It is not supported to send an interim update for ");
        ((StringBuilder)object).append(this.mDebug);
        throw new UnsupportedOperationException(((StringBuilder)object).toString());
    }

    void onResultSent(T t) {
    }

    public void sendError(Bundle object) {
        if (!this.mSendResultCalled && !this.mSendErrorCalled) {
            this.mSendErrorCalled = true;
            this.onErrorSent((Bundle)object);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("sendError() called when either sendResult() or sendError() had already been called for: ");
        ((StringBuilder)object).append(this.mDebug);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public void sendProgressUpdate(Bundle object) {
        if (!this.mSendResultCalled && !this.mSendErrorCalled) {
            this.checkExtraFields((Bundle)object);
            this.mSendProgressUpdateCalled = true;
            this.onProgressUpdateSent((Bundle)object);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: ");
        ((StringBuilder)object).append(this.mDebug);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public void sendResult(T object) {
        if (!this.mSendResultCalled && !this.mSendErrorCalled) {
            this.mSendResultCalled = true;
            this.onResultSent(object);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("sendResult() called when either sendResult() or sendError() had already been called for: ");
        ((StringBuilder)object).append(this.mDebug);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    void setFlags(int n) {
        this.mFlags = n;
    }
}
