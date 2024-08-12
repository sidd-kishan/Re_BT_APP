/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  com.google.android.material.snackbar.SnackbarManager$Callback
 *  com.google.android.material.snackbar.SnackbarManager$SnackbarRecord
 */
package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.material.snackbar.SnackbarManager;

class SnackbarManager {
    private static final int LONG_DURATION_MS = 2750;
    static final int MSG_TIMEOUT = 0;
    private static final int SHORT_DURATION_MS = 1500;
    private static SnackbarManager snackbarManager;
    private SnackbarRecord currentSnackbar;
    private final Handler handler;
    private final Object lock = new Object();
    private SnackbarRecord nextSnackbar;

    private SnackbarManager() {
        this.handler = new Handler(Looper.getMainLooper(), (Handler.Callback)new /* Unavailable Anonymous Inner Class!! */);
    }

    private boolean cancelSnackbarLocked(SnackbarRecord snackbarRecord, int n) {
        Callback callback = (Callback)snackbarRecord.callback.get();
        if (callback == null) return false;
        this.handler.removeCallbacksAndMessages((Object)snackbarRecord);
        callback.dismiss(n);
        return true;
    }

    static SnackbarManager getInstance() {
        if (snackbarManager != null) return snackbarManager;
        snackbarManager = new SnackbarManager();
        return snackbarManager;
    }

    private boolean isCurrentSnackbarLocked(Callback callback) {
        SnackbarRecord snackbarRecord = this.currentSnackbar;
        boolean bl = snackbarRecord != null && snackbarRecord.isSnackbar(callback);
        return bl;
    }

    private boolean isNextSnackbarLocked(Callback callback) {
        SnackbarRecord snackbarRecord = this.nextSnackbar;
        boolean bl = snackbarRecord != null && snackbarRecord.isSnackbar(callback);
        return bl;
    }

    private void scheduleTimeoutLocked(SnackbarRecord snackbarRecord) {
        if (snackbarRecord.duration == -2) {
            return;
        }
        int n = 2750;
        if (snackbarRecord.duration > 0) {
            n = snackbarRecord.duration;
        } else if (snackbarRecord.duration == -1) {
            n = 1500;
        }
        this.handler.removeCallbacksAndMessages((Object)snackbarRecord);
        Handler handler = this.handler;
        handler.sendMessageDelayed(Message.obtain((Handler)handler, (int)0, (Object)snackbarRecord), (long)n);
    }

    private void showNextSnackbarLocked() {
        SnackbarRecord snackbarRecord = this.nextSnackbar;
        if (snackbarRecord == null) return;
        this.currentSnackbar = snackbarRecord;
        this.nextSnackbar = null;
        snackbarRecord = (Callback)snackbarRecord.callback.get();
        if (snackbarRecord != null) {
            snackbarRecord.show();
        } else {
            this.currentSnackbar = null;
        }
    }

    public void dismiss(Callback callback, int n) {
        Object object = this.lock;
        synchronized (object) {
            if (this.isCurrentSnackbarLocked(callback)) {
                this.cancelSnackbarLocked(this.currentSnackbar, n);
            } else {
                if (!this.isNextSnackbarLocked(callback)) return;
                this.cancelSnackbarLocked(this.nextSnackbar, n);
            }
            return;
        }
    }

    void handleTimeout(SnackbarRecord snackbarRecord) {
        Object object = this.lock;
        synchronized (object) {
            if (this.currentSnackbar != snackbarRecord) {
                if (this.nextSnackbar != snackbarRecord) return;
            }
            this.cancelSnackbarLocked(snackbarRecord, 2);
            return;
        }
    }

    public boolean isCurrent(Callback callback) {
        Object object = this.lock;
        synchronized (object) {
            boolean bl = this.isCurrentSnackbarLocked(callback);
            return bl;
        }
    }

    public boolean isCurrentOrNext(Callback callback) {
        Object object = this.lock;
        synchronized (object) {
            boolean bl = this.isCurrentSnackbarLocked(callback) || this.isNextSnackbarLocked(callback);
            return bl;
        }
    }

    public void onDismissed(Callback callback) {
        Object object = this.lock;
        synchronized (object) {
            if (!this.isCurrentSnackbarLocked(callback)) return;
            this.currentSnackbar = null;
            if (this.nextSnackbar == null) return;
            this.showNextSnackbarLocked();
            return;
        }
    }

    public void onShown(Callback callback) {
        Object object = this.lock;
        synchronized (object) {
            if (!this.isCurrentSnackbarLocked(callback)) return;
            this.scheduleTimeoutLocked(this.currentSnackbar);
            return;
        }
    }

    public void pauseTimeout(Callback callback) {
        Object object = this.lock;
        synchronized (object) {
            if (!this.isCurrentSnackbarLocked(callback)) return;
            if (this.currentSnackbar.paused) return;
            this.currentSnackbar.paused = true;
            this.handler.removeCallbacksAndMessages((Object)this.currentSnackbar);
            return;
        }
    }

    public void restoreTimeoutIfPaused(Callback callback) {
        Object object = this.lock;
        synchronized (object) {
            if (!this.isCurrentSnackbarLocked(callback)) return;
            if (!this.currentSnackbar.paused) return;
            this.currentSnackbar.paused = false;
            this.scheduleTimeoutLocked(this.currentSnackbar);
            return;
        }
    }

    public void show(int n, Callback callback) {
        Object object = this.lock;
        synchronized (object) {
            if (this.isCurrentSnackbarLocked(callback)) {
                this.currentSnackbar.duration = n;
                this.handler.removeCallbacksAndMessages((Object)this.currentSnackbar);
                this.scheduleTimeoutLocked(this.currentSnackbar);
                return;
            }
            if (this.isNextSnackbarLocked(callback)) {
                this.nextSnackbar.duration = n;
            } else {
                SnackbarRecord snackbarRecord;
                this.nextSnackbar = snackbarRecord = new SnackbarRecord(n, callback);
            }
            if (this.currentSnackbar != null && this.cancelSnackbarLocked(this.currentSnackbar, 4)) {
                return;
            }
            this.currentSnackbar = null;
            this.showNextSnackbarLocked();
            return;
        }
    }
}
