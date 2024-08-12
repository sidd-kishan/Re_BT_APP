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

public final class ErrorRequestCoordinator
implements RequestCoordinator,
Request {
    private Request error;
    private final RequestCoordinator parent;
    private Request primary;

    public ErrorRequestCoordinator(RequestCoordinator requestCoordinator) {
        this.parent = requestCoordinator;
    }

    private boolean isValidRequest(Request request) {
        boolean bl = request.equals(this.primary) || this.primary.isFailed() && request.equals(this.error);
        return bl;
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
        if (this.primary.isRunning()) return;
        this.primary.begin();
    }

    public boolean canNotifyCleared(Request request) {
        boolean bl = this.parentCanNotifyCleared() && this.isValidRequest(request);
        return bl;
    }

    public boolean canNotifyStatusChanged(Request request) {
        boolean bl = this.parentCanNotifyStatusChanged() && this.isValidRequest(request);
        return bl;
    }

    public boolean canSetImage(Request request) {
        boolean bl = this.parentCanSetImage() && this.isValidRequest(request);
        return bl;
    }

    public void clear() {
        this.primary.clear();
        if (!this.error.isRunning()) return;
        this.error.clear();
    }

    public boolean isAnyResourceSet() {
        boolean bl = this.parentIsAnyResourceSet() || this.isResourceSet();
        return bl;
    }

    public boolean isCancelled() {
        Request request = this.primary.isFailed() ? this.error : this.primary;
        return request.isCancelled();
    }

    public boolean isComplete() {
        Request request = this.primary.isFailed() ? this.error : this.primary;
        return request.isComplete();
    }

    public boolean isEquivalentTo(Request request) {
        boolean bl;
        boolean bl2 = request instanceof ErrorRequestCoordinator;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        request = (ErrorRequestCoordinator)request;
        bl3 = bl;
        if (!this.primary.isEquivalentTo(request.primary)) return bl3;
        bl3 = bl;
        if (!this.error.isEquivalentTo(request.error)) return bl3;
        bl3 = true;
        return bl3;
    }

    public boolean isFailed() {
        boolean bl = this.primary.isFailed() && this.error.isFailed();
        return bl;
    }

    public boolean isPaused() {
        Request request = this.primary.isFailed() ? this.error : this.primary;
        return request.isPaused();
    }

    public boolean isResourceSet() {
        Request request = this.primary.isFailed() ? this.error : this.primary;
        return request.isResourceSet();
    }

    public boolean isRunning() {
        Request request = this.primary.isFailed() ? this.error : this.primary;
        return request.isRunning();
    }

    public void onRequestFailed(Request request) {
        if (!request.equals(this.error)) {
            if (this.error.isRunning()) return;
            this.error.begin();
            return;
        }
        request = this.parent;
        if (request == null) return;
        request.onRequestFailed((Request)this);
    }

    public void onRequestSuccess(Request request) {
        request = this.parent;
        if (request == null) return;
        request.onRequestSuccess((Request)this);
    }

    public void pause() {
        if (!this.primary.isFailed()) {
            this.primary.pause();
        }
        if (!this.error.isRunning()) return;
        this.error.pause();
    }

    public void recycle() {
        this.primary.recycle();
        this.error.recycle();
    }

    public void setRequests(Request request, Request request2) {
        this.primary = request;
        this.error = request2;
    }
}
