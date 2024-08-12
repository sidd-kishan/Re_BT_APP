/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.engine;

private static class DecodeJob.ReleaseManager {
    private boolean isEncodeComplete;
    private boolean isFailed;
    private boolean isReleased;

    DecodeJob.ReleaseManager() {
    }

    private boolean isComplete(boolean bl) {
        bl = (this.isFailed || bl || this.isEncodeComplete) && this.isReleased;
        return bl;
    }

    boolean onEncodeComplete() {
        synchronized (this) {
            this.isEncodeComplete = true;
            boolean bl = this.isComplete(false);
            return bl;
        }
    }

    boolean onFailed() {
        synchronized (this) {
            this.isFailed = true;
            boolean bl = this.isComplete(false);
            return bl;
        }
    }

    boolean release(boolean bl) {
        synchronized (this) {
            this.isReleased = true;
            bl = this.isComplete(bl);
            return bl;
        }
    }

    void reset() {
        synchronized (this) {
            this.isEncodeComplete = false;
            this.isReleased = false;
            this.isFailed = false;
            return;
        }
    }
}
