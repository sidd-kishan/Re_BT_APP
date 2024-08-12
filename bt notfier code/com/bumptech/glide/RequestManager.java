/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.ModelTypes
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.RequestBuilder
 *  com.bumptech.glide.RequestManager$ClearTarget
 *  com.bumptech.glide.RequestManager$RequestManagerConnectivityListener
 *  com.bumptech.glide.TransitionOptions
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  com.bumptech.glide.load.resource.gif.GifDrawable
 *  com.bumptech.glide.manager.ConnectivityMonitor
 *  com.bumptech.glide.manager.ConnectivityMonitor$ConnectivityListener
 *  com.bumptech.glide.manager.ConnectivityMonitorFactory
 *  com.bumptech.glide.manager.Lifecycle
 *  com.bumptech.glide.manager.LifecycleListener
 *  com.bumptech.glide.manager.RequestManagerTreeNode
 *  com.bumptech.glide.manager.RequestTracker
 *  com.bumptech.glide.manager.TargetTracker
 *  com.bumptech.glide.request.Request
 *  com.bumptech.glide.request.RequestOptions
 *  com.bumptech.glide.request.target.Target
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bumptech.glide.Glide;
import com.bumptech.glide.ModelTypes;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.Iterator;

public class RequestManager
implements LifecycleListener,
ModelTypes<RequestBuilder<Drawable>> {
    private static final RequestOptions DECODE_TYPE_BITMAP = RequestOptions.decodeTypeOf(Bitmap.class).lock();
    private static final RequestOptions DECODE_TYPE_GIF = RequestOptions.decodeTypeOf(GifDrawable.class).lock();
    private static final RequestOptions DOWNLOAD_ONLY_OPTIONS = RequestOptions.diskCacheStrategyOf((DiskCacheStrategy)DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    private final Runnable addSelfToLifecycle;
    private final ConnectivityMonitor connectivityMonitor;
    protected final Context context;
    protected final Glide glide;
    final Lifecycle lifecycle;
    private final Handler mainHandler;
    private RequestOptions requestOptions;
    private final RequestTracker requestTracker;
    private final TargetTracker targetTracker = new TargetTracker();
    private final RequestManagerTreeNode treeNode;

    public RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.getConnectivityMonitorFactory(), context);
    }

    RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.addSelfToLifecycle = new /* Unavailable Anonymous Inner Class!! */;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.glide = glide;
        this.lifecycle = lifecycle;
        this.treeNode = requestManagerTreeNode;
        this.requestTracker = requestTracker;
        this.context = context;
        this.connectivityMonitor = connectivityMonitorFactory.build(context.getApplicationContext(), (ConnectivityMonitor.ConnectivityListener)new RequestManagerConnectivityListener(requestTracker));
        if (Util.isOnBackgroundThread()) {
            this.mainHandler.post(this.addSelfToLifecycle);
        } else {
            lifecycle.addListener((LifecycleListener)this);
        }
        lifecycle.addListener((LifecycleListener)this.connectivityMonitor);
        this.setRequestOptions(glide.getGlideContext().getDefaultRequestOptions());
        glide.registerRequestManager(this);
    }

    private void untrackOrDelegate(Target<?> target) {
        if (this.untrack(target)) return;
        if (this.glide.removeFromManagers(target)) return;
        if (target.getRequest() == null) return;
        Request request = target.getRequest();
        target.setRequest(null);
        request.clear();
    }

    private void updateRequestOptions(RequestOptions requestOptions) {
        this.requestOptions = this.requestOptions.apply(requestOptions);
    }

    public RequestManager applyDefaultRequestOptions(RequestOptions requestOptions) {
        this.updateRequestOptions(requestOptions);
        return this;
    }

    public <ResourceType> RequestBuilder<ResourceType> as(Class<ResourceType> clazz) {
        return new RequestBuilder(this.glide, this, clazz, this.context);
    }

    public RequestBuilder<Bitmap> asBitmap() {
        return this.as(Bitmap.class).apply(DECODE_TYPE_BITMAP);
    }

    public RequestBuilder<Drawable> asDrawable() {
        return this.as(Drawable.class);
    }

    public RequestBuilder<File> asFile() {
        return this.as(File.class).apply(RequestOptions.skipMemoryCacheOf((boolean)true));
    }

    public RequestBuilder<GifDrawable> asGif() {
        return this.as(GifDrawable.class).apply(DECODE_TYPE_GIF);
    }

    public void clear(View view) {
        this.clear((Target<?>)new ClearTarget(view));
    }

    public void clear(Target<?> target) {
        if (target == null) {
            return;
        }
        if (Util.isOnMainThread()) {
            this.untrackOrDelegate(target);
        } else {
            this.mainHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    public RequestBuilder<File> download(Object object) {
        return this.downloadOnly().load(object);
    }

    public RequestBuilder<File> downloadOnly() {
        return this.as(File.class).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    RequestOptions getDefaultRequestOptions() {
        return this.requestOptions;
    }

    <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> clazz) {
        return this.glide.getGlideContext().getDefaultTransitionOptions(clazz);
    }

    public boolean isPaused() {
        Util.assertMainThread();
        return this.requestTracker.isPaused();
    }

    public RequestBuilder<Drawable> load(Bitmap bitmap) {
        return this.asDrawable().load(bitmap);
    }

    public RequestBuilder<Drawable> load(Drawable drawable) {
        return this.asDrawable().load(drawable);
    }

    public RequestBuilder<Drawable> load(Uri uri) {
        return this.asDrawable().load(uri);
    }

    public RequestBuilder<Drawable> load(File file) {
        return this.asDrawable().load(file);
    }

    public RequestBuilder<Drawable> load(Integer n) {
        return this.asDrawable().load(n);
    }

    public RequestBuilder<Drawable> load(Object object) {
        return this.asDrawable().load(object);
    }

    public RequestBuilder<Drawable> load(String string) {
        return this.asDrawable().load(string);
    }

    @Deprecated
    public RequestBuilder<Drawable> load(URL uRL) {
        return this.asDrawable().load(uRL);
    }

    public RequestBuilder<Drawable> load(byte[] byArray) {
        return this.asDrawable().load(byArray);
    }

    public void onDestroy() {
        this.targetTracker.onDestroy();
        Iterator iterator = this.targetTracker.getAll().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.targetTracker.clear();
                this.requestTracker.clearRequests();
                this.lifecycle.removeListener((LifecycleListener)this);
                this.lifecycle.removeListener((LifecycleListener)this.connectivityMonitor);
                this.mainHandler.removeCallbacks(this.addSelfToLifecycle);
                this.glide.unregisterRequestManager(this);
                return;
            }
            this.clear((Target)iterator.next());
        }
    }

    @Deprecated
    public void onLowMemory() {
        this.glide.onLowMemory();
    }

    public void onStart() {
        this.resumeRequests();
        this.targetTracker.onStart();
    }

    public void onStop() {
        this.pauseRequests();
        this.targetTracker.onStop();
    }

    @Deprecated
    public void onTrimMemory(int n) {
        this.glide.onTrimMemory(n);
    }

    public void pauseAllRequests() {
        Util.assertMainThread();
        this.requestTracker.pauseAllRequests();
    }

    public void pauseRequests() {
        Util.assertMainThread();
        this.requestTracker.pauseRequests();
    }

    public void pauseRequestsRecursive() {
        Util.assertMainThread();
        this.pauseRequests();
        Iterator iterator = this.treeNode.getDescendants().iterator();
        while (iterator.hasNext()) {
            ((RequestManager)iterator.next()).pauseRequests();
        }
    }

    public void resumeRequests() {
        Util.assertMainThread();
        this.requestTracker.resumeRequests();
    }

    public void resumeRequestsRecursive() {
        Util.assertMainThread();
        this.resumeRequests();
        Iterator iterator = this.treeNode.getDescendants().iterator();
        while (iterator.hasNext()) {
            ((RequestManager)iterator.next()).resumeRequests();
        }
    }

    public RequestManager setDefaultRequestOptions(RequestOptions requestOptions) {
        this.setRequestOptions(requestOptions);
        return this;
    }

    protected void setRequestOptions(RequestOptions requestOptions) {
        this.requestOptions = requestOptions.clone().autoClone();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("{tracker=");
        stringBuilder.append(this.requestTracker);
        stringBuilder.append(", treeNode=");
        stringBuilder.append(this.treeNode);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    void track(Target<?> target, Request request) {
        this.targetTracker.track(target);
        this.requestTracker.runRequest(request);
    }

    boolean untrack(Target<?> target) {
        Request request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.requestTracker.clearRemoveAndRecycle(request)) return false;
        this.targetTracker.untrack(target);
        target.setRequest(null);
        return true;
    }
}
