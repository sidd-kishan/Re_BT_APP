/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.request.Request
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.manager;

import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker {
    private boolean isPaused;
    private final List<Request> pendingRequests;
    private final Set<Request> requests = Collections.newSetFromMap(new WeakHashMap());

    public RequestTracker() {
        this.pendingRequests = new ArrayList<Request>();
    }

    private boolean clearRemoveAndMaybeRecycle(Request request, boolean bl) {
        boolean bl2 = true;
        if (request == null) {
            return true;
        }
        boolean bl3 = this.requests.remove(request);
        boolean bl4 = bl2;
        if (!this.pendingRequests.remove(request)) {
            bl4 = bl3 ? bl2 : false;
        }
        if (!bl4) return bl4;
        request.clear();
        if (!bl) return bl4;
        request.recycle();
        return bl4;
    }

    void addRequest(Request request) {
        this.requests.add(request);
    }

    public boolean clearRemoveAndRecycle(Request request) {
        return this.clearRemoveAndMaybeRecycle(request, true);
    }

    public void clearRequests() {
        Iterator iterator = Util.getSnapshot(this.requests).iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.pendingRequests.clear();
                return;
            }
            this.clearRemoveAndMaybeRecycle((Request)iterator.next(), false);
        }
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void pauseAllRequests() {
        this.isPaused = true;
        Iterator iterator = Util.getSnapshot(this.requests).iterator();
        while (iterator.hasNext()) {
            Request request = (Request)iterator.next();
            if (!request.isRunning() && !request.isComplete()) continue;
            request.pause();
            this.pendingRequests.add(request);
        }
    }

    public void pauseRequests() {
        this.isPaused = true;
        Iterator iterator = Util.getSnapshot(this.requests).iterator();
        while (iterator.hasNext()) {
            Request request = (Request)iterator.next();
            if (!request.isRunning()) continue;
            request.pause();
            this.pendingRequests.add(request);
        }
    }

    public void restartRequests() {
        Iterator iterator = Util.getSnapshot(this.requests).iterator();
        while (iterator.hasNext()) {
            Request request = (Request)iterator.next();
            if (request.isComplete() || request.isCancelled()) continue;
            request.pause();
            if (!this.isPaused) {
                request.begin();
                continue;
            }
            this.pendingRequests.add(request);
        }
    }

    public void resumeRequests() {
        this.isPaused = false;
        Iterator iterator = Util.getSnapshot(this.requests).iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.pendingRequests.clear();
                return;
            }
            Request request = (Request)iterator.next();
            if (request.isComplete() || request.isCancelled() || request.isRunning()) continue;
            request.begin();
        }
    }

    public void runRequest(Request request) {
        this.requests.add(request);
        if (!this.isPaused) {
            request.begin();
        } else {
            this.pendingRequests.add(request);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("{numRequests=");
        stringBuilder.append(this.requests.size());
        stringBuilder.append(", isPaused=");
        stringBuilder.append(this.isPaused);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
