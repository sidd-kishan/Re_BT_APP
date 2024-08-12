/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.widget.ImageView
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.GlideContext
 *  com.bumptech.glide.ModelTypes
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.RequestBuilder$2
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.TransitionOptions
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  com.bumptech.glide.load.engine.Engine
 *  com.bumptech.glide.request.ErrorRequestCoordinator
 *  com.bumptech.glide.request.FutureTarget
 *  com.bumptech.glide.request.Request
 *  com.bumptech.glide.request.RequestCoordinator
 *  com.bumptech.glide.request.RequestFutureTarget
 *  com.bumptech.glide.request.RequestListener
 *  com.bumptech.glide.request.RequestOptions
 *  com.bumptech.glide.request.SingleRequest
 *  com.bumptech.glide.request.ThumbnailRequestCoordinator
 *  com.bumptech.glide.request.target.PreloadTarget
 *  com.bumptech.glide.request.target.Target
 *  com.bumptech.glide.request.target.ViewTarget
 *  com.bumptech.glide.request.transition.TransitionFactory
 *  com.bumptech.glide.signature.ApplicationVersionSignature
 *  com.bumptech.glide.util.Preconditions
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.ModelTypes;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;

public class RequestBuilder<TranscodeType>
implements Cloneable,
ModelTypes<RequestBuilder<TranscodeType>> {
    protected static final RequestOptions DOWNLOAD_ONLY_OPTIONS = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    private final Context context;
    private final RequestOptions defaultRequestOptions;
    private RequestBuilder<TranscodeType> errorBuilder;
    private final Glide glide;
    private final GlideContext glideContext;
    private boolean isDefaultTransitionOptionsSet = true;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;
    private Object model;
    private RequestListener<TranscodeType> requestListener;
    private final RequestManager requestManager;
    protected RequestOptions requestOptions;
    private Float thumbSizeMultiplier;
    private RequestBuilder<TranscodeType> thumbnailBuilder;
    private final Class<TranscodeType> transcodeClass;
    private TransitionOptions<?, ? super TranscodeType> transitionOptions;

    protected RequestBuilder(Glide glide, RequestManager requestManager, Class<TranscodeType> clazz, Context context) {
        this.glide = glide;
        this.requestManager = requestManager;
        this.transcodeClass = clazz;
        this.defaultRequestOptions = requestManager.getDefaultRequestOptions();
        this.context = context;
        this.transitionOptions = requestManager.getDefaultTransitionOptions(clazz);
        this.requestOptions = this.defaultRequestOptions;
        this.glideContext = glide.getGlideContext();
    }

    protected RequestBuilder(Class<TranscodeType> clazz, RequestBuilder<?> requestBuilder) {
        this(requestBuilder.glide, requestBuilder.requestManager, clazz, requestBuilder.context);
        this.model = requestBuilder.model;
        this.isModelSet = requestBuilder.isModelSet;
        this.requestOptions = requestBuilder.requestOptions;
    }

    private Request buildRequest(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestOptions requestOptions) {
        return this.buildRequestRecursive(target, requestListener, null, this.transitionOptions, requestOptions.getPriority(), requestOptions.getOverrideWidth(), requestOptions.getOverrideHeight(), requestOptions);
    }

    private Request buildRequestRecursive(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> request, Priority object, int n, int n2, RequestOptions requestOptions) {
        RequestCoordinator requestCoordinator2;
        if (this.errorBuilder != null) {
            requestCoordinator = requestCoordinator2 = new ErrorRequestCoordinator(requestCoordinator);
        } else {
            Object var14_10 = null;
            requestCoordinator2 = requestCoordinator;
            requestCoordinator = var14_10;
        }
        request = this.buildThumbnailRequestRecursive(target, requestListener, requestCoordinator2, (TransitionOptions<?, ? super TranscodeType>)request, (Priority)object, n, n2, requestOptions);
        if (requestCoordinator == null) {
            return request;
        }
        int n3 = this.errorBuilder.requestOptions.getOverrideWidth();
        int n4 = this.errorBuilder.requestOptions.getOverrideHeight();
        int n5 = n3;
        int n6 = n4;
        if (Util.isValidDimensions((int)n, (int)n2)) {
            n5 = n3;
            n6 = n4;
            if (!this.errorBuilder.requestOptions.isValidOverride()) {
                n5 = requestOptions.getOverrideWidth();
                n6 = requestOptions.getOverrideHeight();
            }
        }
        object = this.errorBuilder;
        requestCoordinator.setRequests(request, super.buildRequestRecursive(target, requestListener, requestCoordinator, ((RequestBuilder)object).transitionOptions, ((RequestBuilder)object).requestOptions.getPriority(), n5, n6, this.errorBuilder.requestOptions));
        return requestCoordinator;
    }

    private Request buildThumbnailRequestRecursive(Target<TranscodeType> request, RequestListener<TranscodeType> requestListener, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> request2, Priority object, int n, int n2, RequestOptions requestOptions) {
        Priority priority = this.thumbnailBuilder;
        if (priority == null) {
            if (this.thumbSizeMultiplier == null) return this.obtainRequest((Target<TranscodeType>)request, requestListener, requestOptions, requestCoordinator, (TransitionOptions<?, ? super TranscodeType>)request2, (Priority)object, n, n2);
            requestCoordinator = new ThumbnailRequestCoordinator(requestCoordinator);
            requestCoordinator.setRequests(this.obtainRequest((Target<TranscodeType>)request, requestListener, requestOptions, requestCoordinator, (TransitionOptions<?, ? super TranscodeType>)request2, (Priority)object, n, n2), this.obtainRequest((Target<TranscodeType>)request, requestListener, requestOptions.clone().sizeMultiplier(this.thumbSizeMultiplier.floatValue()), requestCoordinator, (TransitionOptions<?, ? super TranscodeType>)request2, this.getThumbnailPriority((Priority)object), n, n2));
            return requestCoordinator;
        }
        if (this.isThumbnailBuilt) throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        TransitionOptions<?, ? super TranscodeType> transitionOptions = priority.transitionOptions;
        if (priority.isDefaultTransitionOptionsSet) {
            transitionOptions = request2;
        }
        priority = this.thumbnailBuilder.requestOptions.isPrioritySet() ? this.thumbnailBuilder.requestOptions.getPriority() : this.getThumbnailPriority((Priority)object);
        int n3 = this.thumbnailBuilder.requestOptions.getOverrideWidth();
        int n4 = this.thumbnailBuilder.requestOptions.getOverrideHeight();
        int n5 = n3;
        int n6 = n4;
        if (Util.isValidDimensions((int)n, (int)n2)) {
            n5 = n3;
            n6 = n4;
            if (!this.thumbnailBuilder.requestOptions.isValidOverride()) {
                n5 = requestOptions.getOverrideWidth();
                n6 = requestOptions.getOverrideHeight();
            }
        }
        requestCoordinator = new ThumbnailRequestCoordinator(requestCoordinator);
        request2 = this.obtainRequest((Target<TranscodeType>)request, requestListener, requestOptions, requestCoordinator, (TransitionOptions<?, ? super TranscodeType>)request2, (Priority)object, n, n2);
        this.isThumbnailBuilt = true;
        object = this.thumbnailBuilder;
        request = super.buildRequestRecursive((Target<TranscodeType>)request, requestListener, requestCoordinator, transitionOptions, priority, n5, n6, ((RequestBuilder)object).requestOptions);
        this.isThumbnailBuilt = false;
        requestCoordinator.setRequests(request2, request);
        return requestCoordinator;
    }

    private Priority getThumbnailPriority(Priority object) {
        int n = 2.$SwitchMap$com$bumptech$glide$Priority[object.ordinal()];
        if (n == 1) return Priority.NORMAL;
        if (n == 2) return Priority.HIGH;
        if (n == 3) return Priority.IMMEDIATE;
        if (n == 4) {
            return Priority.IMMEDIATE;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("unknown priority: ");
        ((StringBuilder)object).append(this.requestOptions.getPriority());
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    private <Y extends Target<TranscodeType>> Y into(Y y, RequestListener<TranscodeType> request, RequestOptions requestOptions) {
        Util.assertMainThread();
        Preconditions.checkNotNull(y);
        if (!this.isModelSet) throw new IllegalArgumentException("You must call #load() before calling #into()");
        Request request2 = this.buildRequest(y, (RequestListener<TranscodeType>)request, requestOptions = requestOptions.autoClone());
        if (request2.isEquivalentTo(request = y.getRequest()) && !this.isSkipMemoryCacheWithCompletePreviousRequest(requestOptions, request)) {
            request2.recycle();
            if (((Request)Preconditions.checkNotNull((Object)request)).isRunning()) return y;
            request.begin();
            return y;
        }
        this.requestManager.clear(y);
        y.setRequest(request2);
        this.requestManager.track(y, request2);
        return y;
    }

    private boolean isSkipMemoryCacheWithCompletePreviousRequest(RequestOptions requestOptions, Request request) {
        boolean bl = !requestOptions.isMemoryCacheable() && request.isComplete();
        return bl;
    }

    private RequestBuilder<TranscodeType> loadGeneric(Object object) {
        this.model = object;
        this.isModelSet = true;
        return this;
    }

    private Request obtainRequest(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestOptions requestOptions, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int n, int n2) {
        Context context = this.context;
        GlideContext glideContext = this.glideContext;
        return SingleRequest.obtain((Context)context, (GlideContext)glideContext, (Object)this.model, this.transcodeClass, (RequestOptions)requestOptions, (int)n, (int)n2, (Priority)priority, target, requestListener, this.requestListener, (RequestCoordinator)requestCoordinator, (Engine)glideContext.getEngine(), (TransitionFactory)transitionOptions.getTransitionFactory());
    }

    public RequestBuilder<TranscodeType> apply(RequestOptions requestOptions) {
        Preconditions.checkNotNull((Object)requestOptions);
        this.requestOptions = this.getMutableOptions().apply(requestOptions);
        return this;
    }

    public RequestBuilder<TranscodeType> clone() {
        try {
            RequestBuilder requestBuilder = (RequestBuilder)super.clone();
            requestBuilder.requestOptions = requestBuilder.requestOptions.clone();
            requestBuilder.transitionOptions = requestBuilder.transitionOptions.clone();
            return requestBuilder;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    @Deprecated
    public FutureTarget<File> downloadOnly(int n, int n2) {
        return this.getDownloadOnlyRequest().submit(n, n2);
    }

    @Deprecated
    public <Y extends Target<File>> Y downloadOnly(Y y) {
        return this.getDownloadOnlyRequest().into(y);
    }

    public RequestBuilder<TranscodeType> error(RequestBuilder<TranscodeType> requestBuilder) {
        this.errorBuilder = requestBuilder;
        return this;
    }

    protected RequestBuilder<File> getDownloadOnlyRequest() {
        return new RequestBuilder<File>(File.class, this).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    protected RequestOptions getMutableOptions() {
        RequestOptions requestOptions;
        RequestOptions requestOptions2 = this.defaultRequestOptions;
        RequestOptions requestOptions3 = requestOptions = this.requestOptions;
        if (requestOptions2 != requestOptions) return requestOptions3;
        requestOptions3 = requestOptions.clone();
        return requestOptions3;
    }

    @Deprecated
    public FutureTarget<TranscodeType> into(int n, int n2) {
        return this.submit(n, n2);
    }

    public <Y extends Target<TranscodeType>> Y into(Y y) {
        return this.into(y, null);
    }

    <Y extends Target<TranscodeType>> Y into(Y y, RequestListener<TranscodeType> requestListener) {
        return this.into(y, requestListener, this.getMutableOptions());
    }

    public ViewTarget<ImageView, TranscodeType> into(ImageView imageView) {
        RequestOptions requestOptions;
        Util.assertMainThread();
        Preconditions.checkNotNull((Object)imageView);
        RequestOptions requestOptions2 = requestOptions = this.requestOptions;
        if (requestOptions.isTransformationSet()) return this.into(this.glideContext.buildImageViewTarget(imageView, this.transcodeClass), null, requestOptions2);
        requestOptions2 = requestOptions;
        if (!requestOptions.isTransformationAllowed()) return this.into(this.glideContext.buildImageViewTarget(imageView, this.transcodeClass), null, requestOptions2);
        requestOptions2 = requestOptions;
        if (imageView.getScaleType() == null) return this.into(this.glideContext.buildImageViewTarget(imageView, this.transcodeClass), null, requestOptions2);
        switch (2.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()]) {
            default: {
                requestOptions2 = requestOptions;
                break;
            }
            case 6: {
                requestOptions2 = requestOptions.clone().optionalCenterInside();
                break;
            }
            case 3: 
            case 4: 
            case 5: {
                requestOptions2 = requestOptions.clone().optionalFitCenter();
                break;
            }
            case 2: {
                requestOptions2 = requestOptions.clone().optionalCenterInside();
                break;
            }
            case 1: {
                requestOptions2 = requestOptions.clone().optionalCenterCrop();
            }
        }
        return this.into(this.glideContext.buildImageViewTarget(imageView, this.transcodeClass), null, requestOptions2);
    }

    public RequestBuilder<TranscodeType> listener(RequestListener<TranscodeType> requestListener) {
        this.requestListener = requestListener;
        return this;
    }

    public RequestBuilder<TranscodeType> load(Bitmap bitmap) {
        return this.loadGeneric(bitmap).apply(RequestOptions.diskCacheStrategyOf((DiskCacheStrategy)DiskCacheStrategy.NONE));
    }

    public RequestBuilder<TranscodeType> load(Drawable drawable) {
        return this.loadGeneric(drawable).apply(RequestOptions.diskCacheStrategyOf((DiskCacheStrategy)DiskCacheStrategy.NONE));
    }

    public RequestBuilder<TranscodeType> load(Uri uri) {
        return this.loadGeneric(uri);
    }

    public RequestBuilder<TranscodeType> load(File file) {
        return this.loadGeneric(file);
    }

    public RequestBuilder<TranscodeType> load(Integer n) {
        return this.loadGeneric(n).apply(RequestOptions.signatureOf((Key)ApplicationVersionSignature.obtain((Context)this.context)));
    }

    public RequestBuilder<TranscodeType> load(Object object) {
        return this.loadGeneric(object);
    }

    public RequestBuilder<TranscodeType> load(String string) {
        return this.loadGeneric(string);
    }

    @Deprecated
    public RequestBuilder<TranscodeType> load(URL uRL) {
        return this.loadGeneric(uRL);
    }

    public RequestBuilder<TranscodeType> load(byte[] object) {
        RequestBuilder<TranscodeType> requestBuilder = this.loadGeneric(object);
        object = requestBuilder;
        if (!requestBuilder.requestOptions.isDiskCacheStrategySet()) {
            object = requestBuilder.apply(RequestOptions.diskCacheStrategyOf((DiskCacheStrategy)DiskCacheStrategy.NONE));
        }
        requestBuilder = (RequestBuilder<TranscodeType>)object;
        if (((RequestBuilder)object).requestOptions.isSkipMemoryCacheSet()) return requestBuilder;
        requestBuilder = ((RequestBuilder)object).apply(RequestOptions.skipMemoryCacheOf((boolean)true));
        return requestBuilder;
    }

    public Target<TranscodeType> preload() {
        return this.preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public Target<TranscodeType> preload(int n, int n2) {
        return this.into(PreloadTarget.obtain((RequestManager)this.requestManager, (int)n, (int)n2));
    }

    public FutureTarget<TranscodeType> submit() {
        return this.submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public FutureTarget<TranscodeType> submit(int n, int n2) {
        RequestFutureTarget requestFutureTarget = new RequestFutureTarget(this.glideContext.getMainHandler(), n, n2);
        if (Util.isOnBackgroundThread()) {
            this.glideContext.getMainHandler().post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            this.into((Target)requestFutureTarget, (RequestListener<TranscodeType>)requestFutureTarget);
        }
        return requestFutureTarget;
    }

    public RequestBuilder<TranscodeType> thumbnail(float f) {
        if (f < 0.0f) throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        if (f > 1.0f) throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        this.thumbSizeMultiplier = Float.valueOf(f);
        return this;
    }

    public RequestBuilder<TranscodeType> thumbnail(RequestBuilder<TranscodeType> requestBuilder) {
        this.thumbnailBuilder = requestBuilder;
        return this;
    }

    public RequestBuilder<TranscodeType> thumbnail(RequestBuilder<TranscodeType> ... requestBuilderArray) {
        RequestBuilder<TranscodeType> requestBuilder = null;
        if (requestBuilderArray == null) return this.thumbnail((RequestBuilder<TranscodeType>)null);
        if (requestBuilderArray.length == 0) {
            return this.thumbnail((RequestBuilder<TranscodeType>)null);
        }
        int n = requestBuilderArray.length - 1;
        while (n >= 0) {
            RequestBuilder<TranscodeType> requestBuilder2 = requestBuilderArray[n];
            if (requestBuilder2 != null) {
                requestBuilder = requestBuilder == null ? requestBuilder2 : requestBuilder2.thumbnail(requestBuilder);
            }
            --n;
        }
        return this.thumbnail(requestBuilder);
    }

    public RequestBuilder<TranscodeType> transition(TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        this.transitionOptions = (TransitionOptions)Preconditions.checkNotNull(transitionOptions);
        this.isDefaultTransitionOptionsSet = false;
        return this;
    }
}
