/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  androidx.core.os.CancellationSignal$OnCancelListener
 *  androidx.core.os.OperationCanceledException
 */
package androidx.core.os;

import android.os.Build;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;

public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    private void waitForCancelFinishedLocked() {
        while (this.mCancelInProgress) {
            try {
                this.wait();
            }
            catch (InterruptedException interruptedException) {}
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public void cancel() {
        block12: {
            synchronized (this) {
                if (this.mIsCanceled) {
                    return;
                }
                this.mIsCanceled = true;
                this.mCancelInProgress = true;
                var2_1 = this.mOnCancelListener;
                var1_2 = this.mCancellationSignalObj;
                if (var2_1 == null) ** GOTO lbl11
            }
            try {
                var2_1.onCancel();
lbl11:
                // 2 sources

                if (var1_2 != null && Build.VERSION.SDK_INT >= 16) {
                    ((android.os.CancellationSignal)var1_2).cancel();
                }
                break block12;
            }
            catch (Throwable var1_3) {}
            synchronized (this) {
                this.mCancelInProgress = false;
                this.notifyAll();
                throw var1_3;
            }
        }
        synchronized (this) {
            this.mCancelInProgress = false;
            this.notifyAll();
            return;
        }
    }

    public Object getCancellationSignalObject() {
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            Object object;
            if (this.mCancellationSignalObj == null) {
                object = new android.os.CancellationSignal();
                this.mCancellationSignalObj = object;
                if (this.mIsCanceled) {
                    object.cancel();
                }
            }
            object = this.mCancellationSignalObj;
            return object;
        }
    }

    public boolean isCanceled() {
        synchronized (this) {
            boolean bl = this.mIsCanceled;
            return bl;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void setOnCancelListener(OnCancelListener onCancelListener) {
        synchronized (this) {
            this.waitForCancelFinishedLocked();
            if (this.mOnCancelListener == onCancelListener) {
                return;
            }
            this.mOnCancelListener = onCancelListener;
            if (!this.mIsCanceled) return;
            if (onCancelListener == null) {
                return;
            }
        }
        onCancelListener.onCancel();
    }

    public void throwIfCanceled() {
        if (this.isCanceled()) throw new OperationCanceledException();
    }
}
