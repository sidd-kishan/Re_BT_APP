/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.os.Handler
 *  android.os.Looper
 *  android.widget.ImageView
 *  com.bumptech.glide.GenericTransitionOptions
 *  com.bumptech.glide.Registry
 *  com.bumptech.glide.TransitionOptions
 *  com.bumptech.glide.load.engine.Engine
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 *  com.bumptech.glide.request.RequestOptions
 *  com.bumptech.glide.request.target.ImageViewTargetFactory
 *  com.bumptech.glide.request.target.ViewTarget
 */
package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Registry;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.Iterator;
import java.util.Map;

public class GlideContext
extends ContextWrapper {
    static final TransitionOptions<?, ?> DEFAULT_TRANSITION_OPTIONS = new GenericTransitionOptions();
    private final ArrayPool arrayPool;
    private final RequestOptions defaultRequestOptions;
    private final Map<Class<?>, TransitionOptions<?, ?>> defaultTransitionOptions;
    private final Engine engine;
    private final ImageViewTargetFactory imageViewTargetFactory;
    private final int logLevel;
    private final Handler mainHandler;
    private final Registry registry;

    public GlideContext(Context context, ArrayPool arrayPool, Registry registry, ImageViewTargetFactory imageViewTargetFactory, RequestOptions requestOptions, Map<Class<?>, TransitionOptions<?, ?>> map, Engine engine, int n) {
        super(context.getApplicationContext());
        this.arrayPool = arrayPool;
        this.registry = registry;
        this.imageViewTargetFactory = imageViewTargetFactory;
        this.defaultRequestOptions = requestOptions;
        this.defaultTransitionOptions = map;
        this.engine = engine;
        this.logLevel = n;
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    public <X> ViewTarget<ImageView, X> buildImageViewTarget(ImageView imageView, Class<X> clazz) {
        return this.imageViewTargetFactory.buildTarget(imageView, clazz);
    }

    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    public RequestOptions getDefaultRequestOptions() {
        return this.defaultRequestOptions;
    }

    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> clazz) {
        TransitionOptions transitionOptions = this.defaultTransitionOptions.get(clazz);
        Object object = transitionOptions;
        if (transitionOptions == null) {
            Iterator<Map.Entry<Class<?>, TransitionOptions<?, ?>>> iterator = this.defaultTransitionOptions.entrySet().iterator();
            while (true) {
                object = transitionOptions;
                if (!iterator.hasNext()) break;
                object = iterator.next();
                if (!((Class)object.getKey()).isAssignableFrom(clazz)) continue;
                transitionOptions = (TransitionOptions)object.getValue();
            }
        }
        clazz = object;
        if (object != null) return clazz;
        clazz = DEFAULT_TRANSITION_OPTIONS;
        return clazz;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public Handler getMainHandler() {
        return this.mainHandler;
    }

    public Registry getRegistry() {
        return this.registry;
    }
}
