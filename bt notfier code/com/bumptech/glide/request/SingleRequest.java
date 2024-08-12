/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.GlideContext
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.engine.Engine
 *  com.bumptech.glide.load.engine.Engine$LoadStatus
 *  com.bumptech.glide.load.engine.GlideException
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat
 *  com.bumptech.glide.request.Request
 *  com.bumptech.glide.request.RequestCoordinator
 *  com.bumptech.glide.request.RequestListener
 *  com.bumptech.glide.request.RequestOptions
 *  com.bumptech.glide.request.ResourceCallback
 *  com.bumptech.glide.request.SingleRequest$Status
 *  com.bumptech.glide.request.target.SizeReadyCallback
 *  com.bumptech.glide.request.target.Target
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.request.transition.TransitionFactory
 *  com.bumptech.glide.util.LogTime
 *  com.bumptech.glide.util.Util
 *  com.bumptech.glide.util.pool.FactoryPools
 *  com.bumptech.glide.util.pool.FactoryPools$Factory
 *  com.bumptech.glide.util.pool.FactoryPools$Poolable
 *  com.bumptech.glide.util.pool.StateVerifier
 */
package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

public final class SingleRequest<R>
implements Request,
SizeReadyCallback,
ResourceCallback,
FactoryPools.Poolable {
    private static final String GLIDE_TAG = "Glide";
    private static final boolean IS_VERBOSE_LOGGABLE;
    private static final Pools.Pool<SingleRequest<?>> POOL;
    private static final String TAG = "Request";
    private TransitionFactory<? super R> animationFactory;
    private Context context;
    private Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;
    private Object model;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private Priority priority;
    private RequestCoordinator requestCoordinator;
    private RequestListener<R> requestListener;
    private RequestOptions requestOptions;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;
    private final String tag;
    private Target<R> target;
    private RequestListener<R> targetListener;
    private Class<R> transcodeClass;
    private int width;

    static {
        POOL = FactoryPools.simple((int)150, (FactoryPools.Factory)new /* Unavailable Anonymous Inner Class!! */);
        IS_VERBOSE_LOGGABLE = Log.isLoggable((String)TAG, (int)2);
    }

    SingleRequest() {
        String string = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.tag = string;
        this.stateVerifier = StateVerifier.newInstance();
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }

    private boolean canNotifyCleared() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        boolean bl = requestCoordinator == null || requestCoordinator.canNotifyCleared((Request)this);
        return bl;
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        boolean bl = requestCoordinator == null || requestCoordinator.canNotifyStatusChanged((Request)this);
        return bl;
    }

    private boolean canSetResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        boolean bl = requestCoordinator == null || requestCoordinator.canSetImage((Request)this);
        return bl;
    }

    private Drawable getErrorDrawable() {
        Drawable drawable;
        if (this.errorDrawable != null) return this.errorDrawable;
        this.errorDrawable = drawable = this.requestOptions.getErrorPlaceholder();
        if (drawable != null) return this.errorDrawable;
        if (this.requestOptions.getErrorId() <= 0) return this.errorDrawable;
        this.errorDrawable = this.loadDrawable(this.requestOptions.getErrorId());
        return this.errorDrawable;
    }

    private Drawable getFallbackDrawable() {
        Drawable drawable;
        if (this.fallbackDrawable != null) return this.fallbackDrawable;
        this.fallbackDrawable = drawable = this.requestOptions.getFallbackDrawable();
        if (drawable != null) return this.fallbackDrawable;
        if (this.requestOptions.getFallbackId() <= 0) return this.fallbackDrawable;
        this.fallbackDrawable = this.loadDrawable(this.requestOptions.getFallbackId());
        return this.fallbackDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        Drawable drawable;
        if (this.placeholderDrawable != null) return this.placeholderDrawable;
        this.placeholderDrawable = drawable = this.requestOptions.getPlaceholderDrawable();
        if (drawable != null) return this.placeholderDrawable;
        if (this.requestOptions.getPlaceholderId() <= 0) return this.placeholderDrawable;
        this.placeholderDrawable = this.loadDrawable(this.requestOptions.getPlaceholderId());
        return this.placeholderDrawable;
    }

    private void init(Context context, GlideContext glideContext, Object object, Class<R> clazz, RequestOptions requestOptions, int n, int n2, Priority priority, Target<R> target, RequestListener<R> requestListener, RequestListener<R> requestListener2, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory) {
        this.context = context;
        this.glideContext = glideContext;
        this.model = object;
        this.transcodeClass = clazz;
        this.requestOptions = requestOptions;
        this.overrideWidth = n;
        this.overrideHeight = n2;
        this.priority = priority;
        this.target = target;
        this.targetListener = requestListener;
        this.requestListener = requestListener2;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.animationFactory = transitionFactory;
        this.status = Status.PENDING;
    }

    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        boolean bl = requestCoordinator == null || !requestCoordinator.isAnyResourceSet();
        return bl;
    }

    private Drawable loadDrawable(int n) {
        Resources.Theme theme = this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme();
        return DrawableDecoderCompat.getDrawable((Context)this.glideContext, (int)n, (Resources.Theme)theme);
    }

    private void logV(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" this: ");
        stringBuilder.append(this.tag);
        Log.v((String)TAG, (String)stringBuilder.toString());
    }

    private static int maybeApplySizeMultiplier(int n, float f) {
        if (n == Integer.MIN_VALUE) return n;
        n = Math.round(f * (float)n);
        return n;
    }

    private void notifyLoadFailed() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator == null) return;
        requestCoordinator.onRequestFailed((Request)this);
    }

    private void notifyLoadSuccess() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator == null) return;
        requestCoordinator.onRequestSuccess((Request)this);
    }

    public static <R> SingleRequest<R> obtain(Context context, GlideContext glideContext, Object object, Class<R> clazz, RequestOptions requestOptions, int n, int n2, Priority priority, Target<R> target, RequestListener<R> requestListener, RequestListener<R> requestListener2, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory) {
        SingleRequest<R> singleRequest;
        SingleRequest<R> singleRequest2 = singleRequest = (SingleRequest<R>)POOL.acquire();
        if (singleRequest == null) {
            singleRequest2 = new SingleRequest<R>();
        }
        super.init(context, glideContext, object, clazz, requestOptions, n, n2, priority, target, requestListener, requestListener2, requestCoordinator, engine, transitionFactory);
        return singleRequest2;
    }

    private void onLoadFailed(GlideException glideException, int n) {
        this.stateVerifier.throwIfRecycled();
        int n2 = this.glideContext.getLogLevel();
        if (n2 <= n) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Load failed for ");
            stringBuilder.append(this.model);
            stringBuilder.append(" with size [");
            stringBuilder.append(this.width);
            stringBuilder.append("x");
            stringBuilder.append(this.height);
            stringBuilder.append("]");
            Log.w((String)GLIDE_TAG, (String)stringBuilder.toString(), (Throwable)glideException);
            if (n2 <= 4) {
                glideException.logRootCauses(GLIDE_TAG);
            }
        }
        this.loadStatus = null;
        this.status = Status.FAILED;
        this.isCallingCallbacks = true;
        try {
            if (!(this.requestListener != null && this.requestListener.onLoadFailed(glideException, this.model, this.target, this.isFirstReadyResource()) || this.targetListener != null && this.targetListener.onLoadFailed(glideException, this.model, this.target, this.isFirstReadyResource()))) {
                this.setErrorPlaceholder();
            }
            this.notifyLoadFailed();
            return;
        }
        finally {
            this.isCallingCallbacks = false;
        }
    }

    private void onResourceReady(Resource<R> object, R r, DataSource dataSource) {
        boolean bl = this.isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = object;
        if (this.glideContext.getLogLevel() <= 3) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Finished loading ");
            ((StringBuilder)object).append(r.getClass().getSimpleName());
            ((StringBuilder)object).append(" from ");
            ((StringBuilder)object).append(dataSource);
            ((StringBuilder)object).append(" for ");
            ((StringBuilder)object).append(this.model);
            ((StringBuilder)object).append(" with size [");
            ((StringBuilder)object).append(this.width);
            ((StringBuilder)object).append("x");
            ((StringBuilder)object).append(this.height);
            ((StringBuilder)object).append("] in ");
            ((StringBuilder)object).append(LogTime.getElapsedMillis((long)this.startTime));
            ((StringBuilder)object).append(" ms");
            Log.d((String)GLIDE_TAG, (String)((StringBuilder)object).toString());
        }
        this.isCallingCallbacks = true;
        try {
            if (!(this.requestListener != null && this.requestListener.onResourceReady(r, this.model, this.target, dataSource, bl) || this.targetListener != null && this.targetListener.onResourceReady(r, this.model, this.target, dataSource, bl))) {
                object = this.animationFactory.build(dataSource, bl);
                this.target.onResourceReady(r, (Transition)object);
            }
            this.notifyLoadSuccess();
            return;
        }
        finally {
            this.isCallingCallbacks = false;
        }
    }

    private void releaseResource(Resource<?> resource) {
        this.engine.release(resource);
        this.resource = null;
    }

    private void setErrorPlaceholder() {
        if (!this.canNotifyStatusChanged()) {
            return;
        }
        Drawable drawable = null;
        if (this.model == null) {
            drawable = this.getFallbackDrawable();
        }
        Drawable drawable2 = drawable;
        if (drawable == null) {
            drawable2 = this.getErrorDrawable();
        }
        drawable = drawable2;
        if (drawable2 == null) {
            drawable = this.getPlaceholderDrawable();
        }
        this.target.onLoadFailed(drawable);
    }

    public void begin() {
        this.assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.startTime = LogTime.getLogTime();
        if (this.model == null) {
            if (Util.isValidDimensions((int)this.overrideWidth, (int)this.overrideHeight)) {
                this.width = this.overrideWidth;
                this.height = this.overrideHeight;
            }
            int n = this.getFallbackDrawable() == null ? 5 : 3;
            this.onLoadFailed(new GlideException("Received null model"), n);
            return;
        }
        if (this.status == Status.RUNNING) throw new IllegalArgumentException("Cannot restart a running request");
        if (this.status == Status.COMPLETE) {
            this.onResourceReady(this.resource, DataSource.MEMORY_CACHE);
            return;
        }
        this.status = Status.WAITING_FOR_SIZE;
        if (Util.isValidDimensions((int)this.overrideWidth, (int)this.overrideHeight)) {
            this.onSizeReady(this.overrideWidth, this.overrideHeight);
        } else {
            this.target.getSize((SizeReadyCallback)this);
        }
        if ((this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE) && this.canNotifyStatusChanged()) {
            this.target.onLoadStarted(this.getPlaceholderDrawable());
        }
        if (!IS_VERBOSE_LOGGABLE) return;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("finished run method in ");
        stringBuilder.append(LogTime.getElapsedMillis((long)this.startTime));
        this.logV(stringBuilder.toString());
    }

    void cancel() {
        this.assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback((SizeReadyCallback)this);
        this.status = Status.CANCELLED;
        Engine.LoadStatus loadStatus = this.loadStatus;
        if (loadStatus == null) return;
        loadStatus.cancel();
        this.loadStatus = null;
    }

    public void clear() {
        Util.assertMainThread();
        this.assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        if (this.status == Status.CLEARED) {
            return;
        }
        this.cancel();
        Resource<R> resource = this.resource;
        if (resource != null) {
            this.releaseResource(resource);
        }
        if (this.canNotifyCleared()) {
            this.target.onLoadCleared(this.getPlaceholderDrawable());
        }
        this.status = Status.CLEARED;
    }

    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public boolean isCancelled() {
        boolean bl = this.status == Status.CANCELLED || this.status == Status.CLEARED;
        return bl;
    }

    public boolean isComplete() {
        boolean bl = this.status == Status.COMPLETE;
        return bl;
    }

    public boolean isEquivalentTo(Request requestListener) {
        boolean bl;
        boolean bl2 = requestListener instanceof SingleRequest;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        RequestListener<R> requestListener2 = requestListener;
        bl3 = bl;
        if (this.overrideWidth != requestListener2.overrideWidth) return bl3;
        bl3 = bl;
        if (this.overrideHeight != requestListener2.overrideHeight) return bl3;
        bl3 = bl;
        if (!Util.bothModelsNullEquivalentOrEquals((Object)this.model, (Object)requestListener2.model)) return bl3;
        bl3 = bl;
        if (!this.transcodeClass.equals(requestListener2.transcodeClass)) return bl3;
        bl3 = bl;
        if (!this.requestOptions.equals((Object)requestListener2.requestOptions)) return bl3;
        bl3 = bl;
        if (this.priority != requestListener2.priority) return bl3;
        requestListener = this.requestListener;
        requestListener2 = requestListener2.requestListener;
        if (requestListener != null) {
            bl3 = bl;
            if (requestListener2 == null) return bl3;
        } else {
            bl3 = bl;
            if (requestListener2 != null) return bl3;
        }
        bl3 = true;
        return bl3;
    }

    public boolean isFailed() {
        boolean bl = this.status == Status.FAILED;
        return bl;
    }

    public boolean isPaused() {
        boolean bl = this.status == Status.PAUSED;
        return bl;
    }

    public boolean isResourceSet() {
        return this.isComplete();
    }

    public boolean isRunning() {
        boolean bl = this.status == Status.RUNNING || this.status == Status.WAITING_FOR_SIZE;
        return bl;
    }

    public void onLoadFailed(GlideException glideException) {
        this.onLoadFailed(glideException, 5);
    }

    public void onResourceReady(Resource<?> object, DataSource object2) {
        this.stateVerifier.throwIfRecycled();
        this.loadStatus = null;
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Expected to receive a Resource<R> with an object of ");
            ((StringBuilder)object).append(this.transcodeClass);
            ((StringBuilder)object).append(" inside, but instead got null.");
            this.onLoadFailed(new GlideException(((StringBuilder)object).toString()));
            return;
        }
        Object object3 = object.get();
        if (object3 != null && this.transcodeClass.isAssignableFrom(object3.getClass())) {
            if (!this.canSetResource()) {
                this.releaseResource((Resource<?>)object);
                this.status = Status.COMPLETE;
                return;
            }
            this.onResourceReady((Resource<R>)object, (R)object3, (DataSource)object2);
            return;
        }
        this.releaseResource((Resource<?>)object);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected to receive an object of ");
        stringBuilder.append(this.transcodeClass);
        stringBuilder.append(" but instead got ");
        String string = "";
        object2 = object3 != null ? object3.getClass() : "";
        stringBuilder.append(object2);
        stringBuilder.append("{");
        stringBuilder.append(object3);
        stringBuilder.append("} inside Resource{");
        stringBuilder.append(object);
        stringBuilder.append("}.");
        object = object3 != null ? string : " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
        stringBuilder.append((String)object);
        this.onLoadFailed(new GlideException(stringBuilder.toString()));
    }

    public void onSizeReady(int n, int n2) {
        StringBuilder stringBuilder;
        this.stateVerifier.throwIfRecycled();
        if (IS_VERBOSE_LOGGABLE) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Got onSizeReady in ");
            stringBuilder.append(LogTime.getElapsedMillis((long)this.startTime));
            this.logV(stringBuilder.toString());
        }
        if (this.status != Status.WAITING_FOR_SIZE) {
            return;
        }
        this.status = Status.RUNNING;
        float f = this.requestOptions.getSizeMultiplier();
        this.width = SingleRequest.maybeApplySizeMultiplier(n, f);
        this.height = SingleRequest.maybeApplySizeMultiplier(n2, f);
        if (IS_VERBOSE_LOGGABLE) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("finished setup for calling load in ");
            stringBuilder.append(LogTime.getElapsedMillis((long)this.startTime));
            this.logV(stringBuilder.toString());
        }
        this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), (ResourceCallback)this);
        if (this.status != Status.RUNNING) {
            this.loadStatus = null;
        }
        if (!IS_VERBOSE_LOGGABLE) return;
        stringBuilder = new StringBuilder();
        stringBuilder.append("finished onSizeReady in ");
        stringBuilder.append(LogTime.getElapsedMillis((long)this.startTime));
        this.logV(stringBuilder.toString());
    }

    public void pause() {
        this.clear();
        this.status = Status.PAUSED;
    }

    public void recycle() {
        this.assertNotCallingCallbacks();
        this.context = null;
        this.glideContext = null;
        this.model = null;
        this.transcodeClass = null;
        this.requestOptions = null;
        this.overrideWidth = -1;
        this.overrideHeight = -1;
        this.target = null;
        this.requestListener = null;
        this.targetListener = null;
        this.requestCoordinator = null;
        this.animationFactory = null;
        this.loadStatus = null;
        this.errorDrawable = null;
        this.placeholderDrawable = null;
        this.fallbackDrawable = null;
        this.width = -1;
        this.height = -1;
        POOL.release((Object)this);
    }
}
