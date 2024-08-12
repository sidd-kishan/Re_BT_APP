/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  com.bumptech.glide.request.Request
 *  com.bumptech.glide.request.target.BaseTarget
 *  com.bumptech.glide.request.target.SizeReadyCallback
 *  com.bumptech.glide.request.target.ViewTarget$SizeDeterminer
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.util.Preconditions;

public abstract class ViewTarget<T extends View, Z>
extends BaseTarget<Z> {
    private static final String TAG = "ViewTarget";
    private static boolean isTagUsedAtLeastOnce;
    private static Integer tagId;
    private View.OnAttachStateChangeListener attachStateListener;
    private boolean isAttachStateListenerAdded;
    private boolean isClearedByUs;
    private final SizeDeterminer sizeDeterminer;
    protected final T view;

    public ViewTarget(T t) {
        this.view = (View)Preconditions.checkNotNull(t);
        this.sizeDeterminer = new SizeDeterminer(t);
    }

    @Deprecated
    public ViewTarget(T t, boolean bl) {
        this(t);
        if (!bl) return;
        this.waitForLayout();
    }

    private Object getTag() {
        Integer n = tagId;
        if (n != null) return this.view.getTag(n.intValue());
        return this.view.getTag();
    }

    private void maybeAddAttachStateListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener == null) return;
        if (this.isAttachStateListenerAdded) return;
        this.view.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.isAttachStateListenerAdded = true;
    }

    private void maybeRemoveAttachStateListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener == null) return;
        if (!this.isAttachStateListenerAdded) return;
        this.view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.isAttachStateListenerAdded = false;
    }

    private void setTag(Object object) {
        Integer n = tagId;
        if (n == null) {
            isTagUsedAtLeastOnce = true;
            this.view.setTag(object);
        } else {
            this.view.setTag(n.intValue(), object);
        }
    }

    public static void setTagId(int n) {
        if (tagId != null) throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        if (isTagUsedAtLeastOnce) throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        tagId = n;
    }

    public final ViewTarget<T, Z> clearOnDetach() {
        if (this.attachStateListener != null) {
            return this;
        }
        this.attachStateListener = new /* Unavailable Anonymous Inner Class!! */;
        this.maybeAddAttachStateListener();
        return this;
    }

    public Request getRequest() {
        Object object = this.getTag();
        if (object != null) {
            if (!(object instanceof Request)) throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
            object = (Request)object;
        } else {
            object = null;
        }
        return object;
    }

    public void getSize(SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.getSize(sizeReadyCallback);
    }

    public T getView() {
        return this.view;
    }

    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        this.sizeDeterminer.clearCallbacksAndListener();
        if (this.isClearedByUs) return;
        this.maybeRemoveAttachStateListener();
    }

    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        this.maybeAddAttachStateListener();
    }

    void pauseMyRequest() {
        Request request = this.getRequest();
        if (request == null) return;
        if (request.isCancelled()) return;
        if (request.isPaused()) return;
        this.isClearedByUs = true;
        request.pause();
        this.isClearedByUs = false;
    }

    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.removeCallback(sizeReadyCallback);
    }

    void resumeMyRequest() {
        Request request = this.getRequest();
        if (request == null) return;
        if (!request.isPaused()) return;
        request.begin();
    }

    public void setRequest(Request request) {
        this.setTag(request);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Target for: ");
        stringBuilder.append(this.view);
        return stringBuilder.toString();
    }

    public final ViewTarget<T, Z> waitForLayout() {
        this.sizeDeterminer.waitForLayout = true;
        return this;
    }
}
