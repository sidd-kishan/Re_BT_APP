/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.request.Request
 *  com.bumptech.glide.request.RequestCoordinator
 */
package com.bumptech.glide.request;

import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;

public class ThumbnailRequestCoordinator
implements RequestCoordinator,
Request {
    private Request full;
    private boolean isRunning;
    private final RequestCoordinator parent;
    private Request thumb;

    ThumbnailRequestCoordinator() {
        this(null);
    }

    public ThumbnailRequestCoordinator(RequestCoordinator requestCoordinator) {
        this.parent = requestCoordinator;
    }

    private boolean parentCanNotifyCleared() {
        RequestCoordinator requestCoordinator = this.parent;
        boolean bl = requestCoordinator == null || requestCoordinator.canNotifyCleared((Request)this);
        return bl;
    }

    private boolean parentCanNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.parent;
        boolean bl = requestCoordinator == null || requestCoordinator.canNotifyStatusChanged((Request)this);
        return bl;
    }

    private boolean parentCanSetImage() {
        RequestCoordinator requestCoordinator = this.parent;
        boolean bl = requestCoordinator == null || requestCoordinator.canSetImage((Request)this);
        return bl;
    }

    private boolean parentIsAnyResourceSet() {
        RequestCoordinator requestCoordinator = this.parent;
        boolean bl = requestCoordinator != null && requestCoordinator.isAnyResourceSet();
        return bl;
    }

    public void begin() {
        this.isRunning = true;
        if (!this.full.isComplete() && !this.thumb.isRunning()) {
            this.thumb.begin();
        }
        if (!this.isRunning) return;
        if (this.full.isRunning()) return;
        this.full.begin();
    }

    public boolean canNotifyCleared(Request request) {
        boolean bl = this.parentCanNotifyCleared() && request.equals(this.full);
        return bl;
    }

    public boolean canNotifyStatusChanged(Request request) {
        boolean bl = this.parentCanNotifyStatusChanged() && request.equals(this.full) && !this.isAnyResourceSet();
        return bl;
    }

    public boolean canSetImage(Request request) {
        boolean bl = this.parentCanSetImage() && (request.equals(this.full) || !this.full.isResourceSet());
        return bl;
    }

    public void clear() {
        this.isRunning = false;
        this.thumb.clear();
        this.full.clear();
    }

    public boolean isAnyResourceSet() {
        boolean bl = this.parentIsAnyResourceSet() || this.isResourceSet();
        return bl;
    }

    public boolean isCancelled() {
        return this.full.isCancelled();
    }

    public boolean isComplete() {
        boolean bl = this.full.isComplete() || this.thumb.isComplete();
        return bl;
    }

    public boolean isEquivalentTo(Request request) {
        boolean bl;
        boolean bl2 = request instanceof ThumbnailRequestCoordinator;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator)request;
        request = this.full;
        if (request == null) {
            bl3 = bl;
            if (thumbnailRequestCoordinator.full != null) return bl3;
        } else {
            bl3 = bl;
            if (!request.isEquivalentTo(thumbnailRequestCoordinator.full)) return bl3;
        }
        request = this.thumb;
        thumbnailRequestCoordinator = thumbnailRequestCoordinator.thumb;
        if (request == null) {
            bl3 = bl;
            if (thumbnailRequestCoordinator != null) return bl3;
        } else {
            bl3 = bl;
            if (!request.isEquivalentTo((Request)thumbnailRequestCoordinator)) return bl3;
        }
        bl3 = true;
        return bl3;
    }

    public boolean isFailed() {
        return this.full.isFailed();
    }

    public boolean isPaused() {
        return this.full.isPaused();
    }

    public boolean isResourceSet() {
        boolean bl = this.full.isResourceSet() || this.thumb.isResourceSet();
        return bl;
    }

    public boolean isRunning() {
        return this.full.isRunning();
    }

    public void onRequestFailed(Request request) {
        if (!request.equals(this.full)) {
            return;
        }
        request = this.parent;
        if (request == null) return;
        request.onRequestFailed((Request)this);
    }

    public void onRequestSuccess(Request request) {
        if (request.equals(this.thumb)) {
            return;
        }
        request = this.parent;
        if (request != null) {
            request.onRequestSuccess((Request)this);
        }
        if (this.thumb.isComplete()) return;
        this.thumb.clear();
    }

    public void pause() {
        this.isRunning = false;
        this.full.pause();
        this.thumb.pause();
    }

    public void recycle() {
        this.full.recycle();
        this.thumb.recycle();
    }

    public void setRequests(Request request, Request request2) {
        this.full = request;
        this.thumb = request2;
    }
}
