/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DecodeFormat
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.MultiTransformation
 *  com.bumptech.glide.load.Option
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  com.bumptech.glide.load.model.stream.HttpGlideUrlLoader
 *  com.bumptech.glide.load.resource.bitmap.BitmapEncoder
 *  com.bumptech.glide.load.resource.bitmap.CenterCrop
 *  com.bumptech.glide.load.resource.bitmap.CenterInside
 *  com.bumptech.glide.load.resource.bitmap.CircleCrop
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
 *  com.bumptech.glide.load.resource.bitmap.Downsampler
 *  com.bumptech.glide.load.resource.bitmap.DrawableTransformation
 *  com.bumptech.glide.load.resource.bitmap.FitCenter
 *  com.bumptech.glide.load.resource.bitmap.VideoDecoder
 *  com.bumptech.glide.load.resource.gif.GifDrawable
 *  com.bumptech.glide.load.resource.gif.GifDrawableTransformation
 *  com.bumptech.glide.load.resource.gif.GifOptions
 *  com.bumptech.glide.signature.EmptySignature
 *  com.bumptech.glide.util.Preconditions
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;

public class RequestOptions
implements Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 32;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 8192;
    private static final int FALLBACK_ID = 16384;
    private static final int IS_CACHEABLE = 256;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    private static final int OVERRIDE = 512;
    private static final int PLACEHOLDER = 64;
    private static final int PLACEHOLDER_ID = 128;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 4096;
    private static final int SIGNATURE = 1024;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 32768;
    private static final int TRANSFORMATION = 2048;
    private static final int TRANSFORMATION_ALLOWED = 65536;
    private static final int TRANSFORMATION_REQUIRED = 131072;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 0x100000;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;
    private static RequestOptions centerCropOptions;
    private static RequestOptions centerInsideOptions;
    private static RequestOptions circleCropOptions;
    private static RequestOptions fitCenterOptions;
    private static RequestOptions noAnimationOptions;
    private static RequestOptions noTransformOptions;
    private static RequestOptions skipMemoryCacheFalseOptions;
    private static RequestOptions skipMemoryCacheTrueOptions;
    private DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
    private int errorId;
    private Drawable errorPlaceholder;
    private Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isCacheable = true;
    private boolean isLocked;
    private boolean isScaleOnlyOrNoTransform = true;
    private boolean isTransformationAllowed = true;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;
    private Options options;
    private int overrideHeight = -1;
    private int overrideWidth = -1;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Priority priority = Priority.NORMAL;
    private Class<?> resourceClass = Object.class;
    private Key signature = EmptySignature.obtain();
    private float sizeMultiplier = 1.0f;
    private Resources.Theme theme;
    private Map<Class<?>, Transformation<?>> transformations;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;

    public RequestOptions() {
        this.options = new Options();
        this.transformations = new HashMap();
    }

    public static RequestOptions bitmapTransform(Transformation<Bitmap> transformation) {
        return new RequestOptions().transform(transformation);
    }

    public static RequestOptions centerCropTransform() {
        if (centerCropOptions != null) return centerCropOptions;
        centerCropOptions = new RequestOptions().centerCrop().autoClone();
        return centerCropOptions;
    }

    public static RequestOptions centerInsideTransform() {
        if (centerInsideOptions != null) return centerInsideOptions;
        centerInsideOptions = new RequestOptions().centerInside().autoClone();
        return centerInsideOptions;
    }

    public static RequestOptions circleCropTransform() {
        if (circleCropOptions != null) return circleCropOptions;
        circleCropOptions = new RequestOptions().circleCrop().autoClone();
        return circleCropOptions;
    }

    public static RequestOptions decodeTypeOf(Class<?> clazz) {
        return new RequestOptions().decode(clazz);
    }

    public static RequestOptions diskCacheStrategyOf(DiskCacheStrategy diskCacheStrategy) {
        return new RequestOptions().diskCacheStrategy(diskCacheStrategy);
    }

    public static RequestOptions downsampleOf(DownsampleStrategy downsampleStrategy) {
        return new RequestOptions().downsample(downsampleStrategy);
    }

    public static RequestOptions encodeFormatOf(Bitmap.CompressFormat compressFormat) {
        return new RequestOptions().encodeFormat(compressFormat);
    }

    public static RequestOptions encodeQualityOf(int n) {
        return new RequestOptions().encodeQuality(n);
    }

    public static RequestOptions errorOf(int n) {
        return new RequestOptions().error(n);
    }

    public static RequestOptions errorOf(Drawable drawable) {
        return new RequestOptions().error(drawable);
    }

    public static RequestOptions fitCenterTransform() {
        if (fitCenterOptions != null) return fitCenterOptions;
        fitCenterOptions = new RequestOptions().fitCenter().autoClone();
        return fitCenterOptions;
    }

    public static RequestOptions formatOf(DecodeFormat decodeFormat) {
        return new RequestOptions().format(decodeFormat);
    }

    public static RequestOptions frameOf(long l) {
        return new RequestOptions().frame(l);
    }

    private boolean isSet(int n) {
        return RequestOptions.isSet(this.fields, n);
    }

    private static boolean isSet(int n, int n2) {
        boolean bl = (n & n2) != 0;
        return bl;
    }

    public static RequestOptions noAnimation() {
        if (noAnimationOptions != null) return noAnimationOptions;
        noAnimationOptions = new RequestOptions().dontAnimate().autoClone();
        return noAnimationOptions;
    }

    public static RequestOptions noTransformation() {
        if (noTransformOptions != null) return noTransformOptions;
        noTransformOptions = new RequestOptions().dontTransform().autoClone();
        return noTransformOptions;
    }

    public static <T> RequestOptions option(Option<T> option, T t) {
        return new RequestOptions().set(option, t);
    }

    private RequestOptions optionalScaleOnlyTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        return this.scaleOnlyTransform(downsampleStrategy, transformation, false);
    }

    public static RequestOptions overrideOf(int n) {
        return RequestOptions.overrideOf(n, n);
    }

    public static RequestOptions overrideOf(int n, int n2) {
        return new RequestOptions().override(n, n2);
    }

    public static RequestOptions placeholderOf(int n) {
        return new RequestOptions().placeholder(n);
    }

    public static RequestOptions placeholderOf(Drawable drawable) {
        return new RequestOptions().placeholder(drawable);
    }

    public static RequestOptions priorityOf(Priority priority) {
        return new RequestOptions().priority(priority);
    }

    private RequestOptions scaleOnlyTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        return this.scaleOnlyTransform(downsampleStrategy, transformation, true);
    }

    private RequestOptions scaleOnlyTransform(DownsampleStrategy object, Transformation<Bitmap> transformation, boolean bl) {
        object = bl ? this.transform((DownsampleStrategy)object, transformation) : this.optionalTransform((DownsampleStrategy)object, transformation);
        object.isScaleOnlyOrNoTransform = true;
        return object;
    }

    private RequestOptions selfOrThrowIfLocked() {
        if (this.isLocked) throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
        return this;
    }

    public static RequestOptions signatureOf(Key key) {
        return new RequestOptions().signature(key);
    }

    public static RequestOptions sizeMultiplierOf(float f) {
        return new RequestOptions().sizeMultiplier(f);
    }

    public static RequestOptions skipMemoryCacheOf(boolean bl) {
        if (bl) {
            if (skipMemoryCacheTrueOptions != null) return skipMemoryCacheTrueOptions;
            skipMemoryCacheTrueOptions = new RequestOptions().skipMemoryCache(true).autoClone();
            return skipMemoryCacheTrueOptions;
        }
        if (skipMemoryCacheFalseOptions != null) return skipMemoryCacheFalseOptions;
        skipMemoryCacheFalseOptions = new RequestOptions().skipMemoryCache(false).autoClone();
        return skipMemoryCacheFalseOptions;
    }

    public static RequestOptions timeoutOf(int n) {
        return new RequestOptions().timeout(n);
    }

    private RequestOptions transform(Transformation<Bitmap> transformation, boolean bl) {
        if (this.isAutoCloneEnabled) {
            return this.clone().transform(transformation, bl);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, bl);
        this.transform(Bitmap.class, transformation, bl);
        this.transform((Class)Drawable.class, (Transformation)drawableTransformation, bl);
        this.transform(BitmapDrawable.class, drawableTransformation.asBitmapDrawable(), bl);
        this.transform((Class)GifDrawable.class, (Transformation)new GifDrawableTransformation(transformation), bl);
        return this.selfOrThrowIfLocked();
    }

    private <T> RequestOptions transform(Class<T> clazz, Transformation<T> transformation, boolean bl) {
        int n;
        if (this.isAutoCloneEnabled) {
            return this.clone().transform(clazz, transformation, bl);
        }
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(transformation);
        this.transformations.put(clazz, transformation);
        this.fields = n = this.fields | 0x800;
        this.isTransformationAllowed = true;
        this.fields = n |= 0x10000;
        this.isScaleOnlyOrNoTransform = false;
        if (!bl) return this.selfOrThrowIfLocked();
        this.fields = n | 0x20000;
        this.isTransformationRequired = true;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions apply(RequestOptions requestOptions) {
        if (this.isAutoCloneEnabled) {
            return this.clone().apply(requestOptions);
        }
        if (RequestOptions.isSet(requestOptions.fields, 2)) {
            this.sizeMultiplier = requestOptions.sizeMultiplier;
        }
        if (RequestOptions.isSet(requestOptions.fields, 262144)) {
            this.useUnlimitedSourceGeneratorsPool = requestOptions.useUnlimitedSourceGeneratorsPool;
        }
        if (RequestOptions.isSet(requestOptions.fields, 0x100000)) {
            this.useAnimationPool = requestOptions.useAnimationPool;
        }
        if (RequestOptions.isSet(requestOptions.fields, 4)) {
            this.diskCacheStrategy = requestOptions.diskCacheStrategy;
        }
        if (RequestOptions.isSet(requestOptions.fields, 8)) {
            this.priority = requestOptions.priority;
        }
        if (RequestOptions.isSet(requestOptions.fields, 16)) {
            this.errorPlaceholder = requestOptions.errorPlaceholder;
        }
        if (RequestOptions.isSet(requestOptions.fields, 32)) {
            this.errorId = requestOptions.errorId;
        }
        if (RequestOptions.isSet(requestOptions.fields, 64)) {
            this.placeholderDrawable = requestOptions.placeholderDrawable;
        }
        if (RequestOptions.isSet(requestOptions.fields, 128)) {
            this.placeholderId = requestOptions.placeholderId;
        }
        if (RequestOptions.isSet(requestOptions.fields, 256)) {
            this.isCacheable = requestOptions.isCacheable;
        }
        if (RequestOptions.isSet(requestOptions.fields, 512)) {
            this.overrideWidth = requestOptions.overrideWidth;
            this.overrideHeight = requestOptions.overrideHeight;
        }
        if (RequestOptions.isSet(requestOptions.fields, 1024)) {
            this.signature = requestOptions.signature;
        }
        if (RequestOptions.isSet(requestOptions.fields, 4096)) {
            this.resourceClass = requestOptions.resourceClass;
        }
        if (RequestOptions.isSet(requestOptions.fields, 8192)) {
            this.fallbackDrawable = requestOptions.fallbackDrawable;
        }
        if (RequestOptions.isSet(requestOptions.fields, 16384)) {
            this.fallbackId = requestOptions.fallbackId;
        }
        if (RequestOptions.isSet(requestOptions.fields, 32768)) {
            this.theme = requestOptions.theme;
        }
        if (RequestOptions.isSet(requestOptions.fields, 65536)) {
            this.isTransformationAllowed = requestOptions.isTransformationAllowed;
        }
        if (RequestOptions.isSet(requestOptions.fields, 131072)) {
            this.isTransformationRequired = requestOptions.isTransformationRequired;
        }
        if (RequestOptions.isSet(requestOptions.fields, 2048)) {
            this.transformations.putAll(requestOptions.transformations);
            this.isScaleOnlyOrNoTransform = requestOptions.isScaleOnlyOrNoTransform;
        }
        if (RequestOptions.isSet(requestOptions.fields, 524288)) {
            this.onlyRetrieveFromCache = requestOptions.onlyRetrieveFromCache;
        }
        if (!this.isTransformationAllowed) {
            int n;
            this.transformations.clear();
            this.fields = n = this.fields & 0xFFFFF7FF;
            this.isTransformationRequired = false;
            this.fields = n & 0xFFFDFFFF;
            this.isScaleOnlyOrNoTransform = true;
        }
        this.fields |= requestOptions.fields;
        this.options.putAll(requestOptions.options);
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions autoClone() {
        if (this.isLocked) {
            if (!this.isAutoCloneEnabled) throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.isAutoCloneEnabled = true;
        return this.lock();
    }

    public RequestOptions centerCrop() {
        return this.transform(DownsampleStrategy.CENTER_OUTSIDE, (Transformation<Bitmap>)new CenterCrop());
    }

    public RequestOptions centerInside() {
        return this.scaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, (Transformation<Bitmap>)new CenterInside());
    }

    public RequestOptions circleCrop() {
        return this.transform(DownsampleStrategy.CENTER_INSIDE, (Transformation<Bitmap>)new CircleCrop());
    }

    public RequestOptions clone() {
        try {
            RequestOptions requestOptions = (RequestOptions)super.clone();
            Object object = new Options();
            requestOptions.options = object;
            object.putAll(this.options);
            requestOptions.transformations = object = new HashMap();
            object.putAll(this.transformations);
            requestOptions.isLocked = false;
            requestOptions.isAutoCloneEnabled = false;
            return requestOptions;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public RequestOptions decode(Class<?> clazz) {
        if (this.isAutoCloneEnabled) {
            return this.clone().decode(clazz);
        }
        this.resourceClass = (Class)Preconditions.checkNotNull(clazz);
        this.fields |= 0x1000;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions disallowHardwareConfig() {
        return this.set(Downsampler.ALLOW_HARDWARE_CONFIG, false);
    }

    public RequestOptions diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        if (this.isAutoCloneEnabled) {
            return this.clone().diskCacheStrategy(diskCacheStrategy);
        }
        this.diskCacheStrategy = (DiskCacheStrategy)Preconditions.checkNotNull((Object)diskCacheStrategy);
        this.fields |= 4;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions dontAnimate() {
        return this.set(GifOptions.DISABLE_ANIMATION, true);
    }

    public RequestOptions dontTransform() {
        int n;
        if (this.isAutoCloneEnabled) {
            return this.clone().dontTransform();
        }
        this.transformations.clear();
        this.fields = n = this.fields & 0xFFFFF7FF;
        this.isTransformationRequired = false;
        this.fields = n &= 0xFFFDFFFF;
        this.isTransformationAllowed = false;
        this.fields = n | 0x10000;
        this.isScaleOnlyOrNoTransform = true;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions downsample(DownsampleStrategy downsampleStrategy) {
        return this.set(Downsampler.DOWNSAMPLE_STRATEGY, Preconditions.checkNotNull((Object)downsampleStrategy));
    }

    public RequestOptions encodeFormat(Bitmap.CompressFormat compressFormat) {
        return this.set(BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull((Object)compressFormat));
    }

    public RequestOptions encodeQuality(int n) {
        return this.set(BitmapEncoder.COMPRESSION_QUALITY, n);
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof RequestOptions;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (RequestOptions)object;
        bl3 = bl;
        if (Float.compare(((RequestOptions)object).sizeMultiplier, this.sizeMultiplier) != 0) return bl3;
        bl3 = bl;
        if (this.errorId != ((RequestOptions)object).errorId) return bl3;
        bl3 = bl;
        if (!Util.bothNullOrEqual((Object)this.errorPlaceholder, (Object)((RequestOptions)object).errorPlaceholder)) return bl3;
        bl3 = bl;
        if (this.placeholderId != ((RequestOptions)object).placeholderId) return bl3;
        bl3 = bl;
        if (!Util.bothNullOrEqual((Object)this.placeholderDrawable, (Object)((RequestOptions)object).placeholderDrawable)) return bl3;
        bl3 = bl;
        if (this.fallbackId != ((RequestOptions)object).fallbackId) return bl3;
        bl3 = bl;
        if (!Util.bothNullOrEqual((Object)this.fallbackDrawable, (Object)((RequestOptions)object).fallbackDrawable)) return bl3;
        bl3 = bl;
        if (this.isCacheable != ((RequestOptions)object).isCacheable) return bl3;
        bl3 = bl;
        if (this.overrideHeight != ((RequestOptions)object).overrideHeight) return bl3;
        bl3 = bl;
        if (this.overrideWidth != ((RequestOptions)object).overrideWidth) return bl3;
        bl3 = bl;
        if (this.isTransformationRequired != ((RequestOptions)object).isTransformationRequired) return bl3;
        bl3 = bl;
        if (this.isTransformationAllowed != ((RequestOptions)object).isTransformationAllowed) return bl3;
        bl3 = bl;
        if (this.useUnlimitedSourceGeneratorsPool != ((RequestOptions)object).useUnlimitedSourceGeneratorsPool) return bl3;
        bl3 = bl;
        if (this.onlyRetrieveFromCache != ((RequestOptions)object).onlyRetrieveFromCache) return bl3;
        bl3 = bl;
        if (!this.diskCacheStrategy.equals(((RequestOptions)object).diskCacheStrategy)) return bl3;
        bl3 = bl;
        if (this.priority != ((RequestOptions)object).priority) return bl3;
        bl3 = bl;
        if (!this.options.equals((Object)((RequestOptions)object).options)) return bl3;
        bl3 = bl;
        if (!this.transformations.equals(((RequestOptions)object).transformations)) return bl3;
        bl3 = bl;
        if (!this.resourceClass.equals(((RequestOptions)object).resourceClass)) return bl3;
        bl3 = bl;
        if (!Util.bothNullOrEqual((Object)this.signature, (Object)((RequestOptions)object).signature)) return bl3;
        bl3 = bl;
        if (!Util.bothNullOrEqual((Object)this.theme, (Object)((RequestOptions)object).theme)) return bl3;
        bl3 = true;
        return bl3;
    }

    public RequestOptions error(int n) {
        if (this.isAutoCloneEnabled) {
            return this.clone().error(n);
        }
        this.errorId = n;
        this.fields |= 0x20;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions error(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return this.clone().error(drawable);
        }
        this.errorPlaceholder = drawable;
        this.fields |= 0x10;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions fallback(int n) {
        if (this.isAutoCloneEnabled) {
            return this.clone().fallback(n);
        }
        this.fallbackId = n;
        this.fields |= 0x4000;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions fallback(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return this.clone().fallback(drawable);
        }
        this.fallbackDrawable = drawable;
        this.fields |= 0x2000;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions fitCenter() {
        return this.scaleOnlyTransform(DownsampleStrategy.FIT_CENTER, (Transformation<Bitmap>)new FitCenter());
    }

    public RequestOptions format(DecodeFormat decodeFormat) {
        Preconditions.checkNotNull((Object)decodeFormat);
        return this.set(Downsampler.DECODE_FORMAT, decodeFormat).set(GifOptions.DECODE_FORMAT, decodeFormat);
    }

    public RequestOptions frame(long l) {
        return this.set(VideoDecoder.TARGET_FRAME, l);
    }

    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    public final Options getOptions() {
        return this.options;
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    public final Priority getPriority() {
        return this.priority;
    }

    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    public final Key getSignature() {
        return this.signature;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    public final Resources.Theme getTheme() {
        return this.theme;
    }

    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public int hashCode() {
        int n = Util.hashCode((float)this.sizeMultiplier);
        n = Util.hashCode((int)this.errorId, (int)n);
        n = Util.hashCode((Object)this.errorPlaceholder, (int)n);
        n = Util.hashCode((int)this.placeholderId, (int)n);
        n = Util.hashCode((Object)this.placeholderDrawable, (int)n);
        n = Util.hashCode((int)this.fallbackId, (int)n);
        n = Util.hashCode((Object)this.fallbackDrawable, (int)n);
        n = Util.hashCode((boolean)this.isCacheable, (int)n);
        n = Util.hashCode((int)this.overrideHeight, (int)n);
        n = Util.hashCode((int)this.overrideWidth, (int)n);
        n = Util.hashCode((boolean)this.isTransformationRequired, (int)n);
        n = Util.hashCode((boolean)this.isTransformationAllowed, (int)n);
        n = Util.hashCode((boolean)this.useUnlimitedSourceGeneratorsPool, (int)n);
        n = Util.hashCode((boolean)this.onlyRetrieveFromCache, (int)n);
        n = Util.hashCode((Object)this.diskCacheStrategy, (int)n);
        n = Util.hashCode((Object)this.priority, (int)n);
        n = Util.hashCode((Object)this.options, (int)n);
        n = Util.hashCode(this.transformations, (int)n);
        n = Util.hashCode(this.resourceClass, (int)n);
        n = Util.hashCode((Object)this.signature, (int)n);
        return Util.hashCode((Object)this.theme, (int)n);
    }

    protected boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return this.isSet(4);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final boolean isPrioritySet() {
        return this.isSet(8);
    }

    boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public final boolean isSkipMemoryCacheSet() {
        return this.isSet(256);
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final boolean isTransformationSet() {
        return this.isSet(2048);
    }

    public final boolean isValidOverride() {
        return Util.isValidDimensions((int)this.overrideWidth, (int)this.overrideHeight);
    }

    public RequestOptions lock() {
        this.isLocked = true;
        return this;
    }

    public RequestOptions onlyRetrieveFromCache(boolean bl) {
        if (this.isAutoCloneEnabled) {
            return this.clone().onlyRetrieveFromCache(bl);
        }
        this.onlyRetrieveFromCache = bl;
        this.fields |= 0x80000;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions optionalCenterCrop() {
        return this.optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, (Transformation<Bitmap>)new CenterCrop());
    }

    public RequestOptions optionalCenterInside() {
        return this.optionalScaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, (Transformation<Bitmap>)new CenterInside());
    }

    public RequestOptions optionalCircleCrop() {
        return this.optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, (Transformation<Bitmap>)new CircleCrop());
    }

    public RequestOptions optionalFitCenter() {
        return this.optionalScaleOnlyTransform(DownsampleStrategy.FIT_CENTER, (Transformation<Bitmap>)new FitCenter());
    }

    public RequestOptions optionalTransform(Transformation<Bitmap> transformation) {
        return this.transform(transformation, false);
    }

    final RequestOptions optionalTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return this.clone().optionalTransform(downsampleStrategy, transformation);
        }
        this.downsample(downsampleStrategy);
        return this.transform(transformation, false);
    }

    public <T> RequestOptions optionalTransform(Class<T> clazz, Transformation<T> transformation) {
        return this.transform(clazz, transformation, false);
    }

    public RequestOptions override(int n) {
        return this.override(n, n);
    }

    public RequestOptions override(int n, int n2) {
        if (this.isAutoCloneEnabled) {
            return this.clone().override(n, n2);
        }
        this.overrideWidth = n;
        this.overrideHeight = n2;
        this.fields |= 0x200;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions placeholder(int n) {
        if (this.isAutoCloneEnabled) {
            return this.clone().placeholder(n);
        }
        this.placeholderId = n;
        this.fields |= 0x80;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions placeholder(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return this.clone().placeholder(drawable);
        }
        this.placeholderDrawable = drawable;
        this.fields |= 0x40;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions priority(Priority priority) {
        if (this.isAutoCloneEnabled) {
            return this.clone().priority(priority);
        }
        this.priority = (Priority)Preconditions.checkNotNull((Object)priority);
        this.fields |= 8;
        return this.selfOrThrowIfLocked();
    }

    public <T> RequestOptions set(Option<T> option, T t) {
        if (this.isAutoCloneEnabled) {
            return this.clone().set(option, t);
        }
        Preconditions.checkNotNull(option);
        Preconditions.checkNotNull(t);
        this.options.set(option, t);
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions signature(Key key) {
        if (this.isAutoCloneEnabled) {
            return this.clone().signature(key);
        }
        this.signature = (Key)Preconditions.checkNotNull((Object)key);
        this.fields |= 0x400;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions sizeMultiplier(float f) {
        if (this.isAutoCloneEnabled) {
            return this.clone().sizeMultiplier(f);
        }
        if (f < 0.0f) throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        if (f > 1.0f) throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        this.sizeMultiplier = f;
        this.fields |= 2;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions skipMemoryCache(boolean bl) {
        if (this.isAutoCloneEnabled) {
            return this.clone().skipMemoryCache(true);
        }
        this.isCacheable = bl ^ true;
        this.fields |= 0x100;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions theme(Resources.Theme theme) {
        if (this.isAutoCloneEnabled) {
            return this.clone().theme(theme);
        }
        this.theme = theme;
        this.fields |= 0x8000;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions timeout(int n) {
        return this.set(HttpGlideUrlLoader.TIMEOUT, n);
    }

    public RequestOptions transform(Transformation<Bitmap> transformation) {
        return this.transform(transformation, true);
    }

    final RequestOptions transform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return this.clone().transform(downsampleStrategy, transformation);
        }
        this.downsample(downsampleStrategy);
        return this.transform(transformation);
    }

    public <T> RequestOptions transform(Class<T> clazz, Transformation<T> transformation) {
        return this.transform(clazz, transformation, true);
    }

    public RequestOptions transforms(Transformation<Bitmap> ... transformationArray) {
        return this.transform((Transformation<Bitmap>)new MultiTransformation(transformationArray), true);
    }

    public RequestOptions useAnimationPool(boolean bl) {
        if (this.isAutoCloneEnabled) {
            return this.clone().useAnimationPool(bl);
        }
        this.useAnimationPool = bl;
        this.fields |= 0x100000;
        return this.selfOrThrowIfLocked();
    }

    public RequestOptions useUnlimitedSourceGeneratorsPool(boolean bl) {
        if (this.isAutoCloneEnabled) {
            return this.clone().useUnlimitedSourceGeneratorsPool(bl);
        }
        this.useUnlimitedSourceGeneratorsPool = bl;
        this.fields |= 0x40000;
        return this.selfOrThrowIfLocked();
    }
}
