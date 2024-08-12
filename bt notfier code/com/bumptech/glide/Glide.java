/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.ComponentCallbacks
 *  android.content.ComponentCallbacks2
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.AssetFileDescriptor
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  android.util.Log
 *  android.view.View
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  com.bumptech.glide.GeneratedAppGlideModule
 *  com.bumptech.glide.GlideBuilder
 *  com.bumptech.glide.GlideContext
 *  com.bumptech.glide.MemoryCategory
 *  com.bumptech.glide.Registry
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.TransitionOptions
 *  com.bumptech.glide.gifdecoder.GifDecoder
 *  com.bumptech.glide.load.DecodeFormat
 *  com.bumptech.glide.load.Encoder
 *  com.bumptech.glide.load.ImageHeaderParser
 *  com.bumptech.glide.load.ResourceDecoder
 *  com.bumptech.glide.load.ResourceEncoder
 *  com.bumptech.glide.load.data.DataRewinder$Factory
 *  com.bumptech.glide.load.data.InputStreamRewinder$Factory
 *  com.bumptech.glide.load.engine.Engine
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.engine.cache.MemoryCache
 *  com.bumptech.glide.load.engine.prefill.BitmapPreFiller
 *  com.bumptech.glide.load.engine.prefill.PreFillType$Builder
 *  com.bumptech.glide.load.model.AssetUriLoader$FileDescriptorFactory
 *  com.bumptech.glide.load.model.AssetUriLoader$StreamFactory
 *  com.bumptech.glide.load.model.ByteArrayLoader$ByteBufferFactory
 *  com.bumptech.glide.load.model.ByteArrayLoader$StreamFactory
 *  com.bumptech.glide.load.model.ByteBufferEncoder
 *  com.bumptech.glide.load.model.ByteBufferFileLoader$Factory
 *  com.bumptech.glide.load.model.DataUrlLoader$StreamFactory
 *  com.bumptech.glide.load.model.FileLoader$FileDescriptorFactory
 *  com.bumptech.glide.load.model.FileLoader$StreamFactory
 *  com.bumptech.glide.load.model.GlideUrl
 *  com.bumptech.glide.load.model.MediaStoreFileLoader$Factory
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.ResourceLoader$AssetFileDescriptorFactory
 *  com.bumptech.glide.load.model.ResourceLoader$FileDescriptorFactory
 *  com.bumptech.glide.load.model.ResourceLoader$StreamFactory
 *  com.bumptech.glide.load.model.ResourceLoader$UriFactory
 *  com.bumptech.glide.load.model.StreamEncoder
 *  com.bumptech.glide.load.model.StringLoader$AssetFileDescriptorFactory
 *  com.bumptech.glide.load.model.StringLoader$FileDescriptorFactory
 *  com.bumptech.glide.load.model.StringLoader$StreamFactory
 *  com.bumptech.glide.load.model.UnitModelLoader$Factory
 *  com.bumptech.glide.load.model.UriLoader$AssetFileDescriptorFactory
 *  com.bumptech.glide.load.model.UriLoader$FileDescriptorFactory
 *  com.bumptech.glide.load.model.UriLoader$StreamFactory
 *  com.bumptech.glide.load.model.UrlUriLoader$StreamFactory
 *  com.bumptech.glide.load.model.stream.HttpGlideUrlLoader$Factory
 *  com.bumptech.glide.load.model.stream.HttpUriLoader$Factory
 *  com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader$Factory
 *  com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader$Factory
 *  com.bumptech.glide.load.model.stream.UrlLoader$StreamFactory
 *  com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder
 *  com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder
 *  com.bumptech.glide.load.resource.bitmap.BitmapEncoder
 *  com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder
 *  com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser
 *  com.bumptech.glide.load.resource.bitmap.Downsampler
 *  com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder
 *  com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder
 *  com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder
 *  com.bumptech.glide.load.resource.bitmap.VideoDecoder
 *  com.bumptech.glide.load.resource.bytes.ByteBufferRewinder$Factory
 *  com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder
 *  com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder
 *  com.bumptech.glide.load.resource.file.FileDecoder
 *  com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder
 *  com.bumptech.glide.load.resource.gif.GifDrawable
 *  com.bumptech.glide.load.resource.gif.GifDrawableEncoder
 *  com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder
 *  com.bumptech.glide.load.resource.gif.StreamGifDecoder
 *  com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder
 *  com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder
 *  com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder
 *  com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder
 *  com.bumptech.glide.load.resource.transcode.ResourceTranscoder
 *  com.bumptech.glide.manager.ConnectivityMonitorFactory
 *  com.bumptech.glide.manager.RequestManagerRetriever
 *  com.bumptech.glide.manager.RequestManagerRetriever$RequestManagerFactory
 *  com.bumptech.glide.module.GlideModule
 *  com.bumptech.glide.module.ManifestParser
 *  com.bumptech.glide.request.RequestOptions
 *  com.bumptech.glide.request.target.ImageViewTargetFactory
 *  com.bumptech.glide.request.target.Target
 *  com.bumptech.glide.util.Preconditions
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.GeneratedAppGlideModule;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.Registry;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Glide
implements ComponentCallbacks2 {
    private static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final String TAG = "Glide";
    private static volatile Glide glide;
    private static volatile boolean isInitializing;
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;
    private final BitmapPreFiller bitmapPreFiller;
    private final ConnectivityMonitorFactory connectivityMonitorFactory;
    private final Engine engine;
    private final GlideContext glideContext;
    private final List<RequestManager> managers = new ArrayList<RequestManager>();
    private final MemoryCache memoryCache;
    private MemoryCategory memoryCategory = MemoryCategory.NORMAL;
    private final Registry registry;
    private final RequestManagerRetriever requestManagerRetriever;

    Glide(Context context, Engine engine, MemoryCache memoryCache, BitmapPool bitmapPool, ArrayPool arrayPool, RequestManagerRetriever requestManagerRetriever, ConnectivityMonitorFactory connectivityMonitorFactory, int n, RequestOptions requestOptions, Map<Class<?>, TransitionOptions<?, ?>> map) {
        this.engine = engine;
        this.bitmapPool = bitmapPool;
        this.arrayPool = arrayPool;
        this.memoryCache = memoryCache;
        this.requestManagerRetriever = requestManagerRetriever;
        this.connectivityMonitorFactory = connectivityMonitorFactory;
        this.bitmapPreFiller = new BitmapPreFiller(memoryCache, bitmapPool, (DecodeFormat)requestOptions.getOptions().get(Downsampler.DECODE_FORMAT));
        memoryCache = context.getResources();
        requestManagerRetriever = new Registry();
        this.registry = requestManagerRetriever;
        requestManagerRetriever.register((ImageHeaderParser)new DefaultImageHeaderParser());
        Downsampler downsampler = new Downsampler(this.registry.getImageHeaderParsers(), memoryCache.getDisplayMetrics(), bitmapPool, arrayPool);
        connectivityMonitorFactory = new ByteBufferGifDecoder(context, this.registry.getImageHeaderParsers(), bitmapPool, arrayPool);
        requestManagerRetriever = VideoDecoder.parcel((BitmapPool)bitmapPool);
        ByteBufferBitmapDecoder byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(downsampler);
        StreamBitmapDecoder streamBitmapDecoder = new StreamBitmapDecoder(downsampler, arrayPool);
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory((Resources)memoryCache);
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory((Resources)memoryCache);
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new ResourceLoader.FileDescriptorFactory((Resources)memoryCache);
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory((Resources)memoryCache);
        BitmapEncoder bitmapEncoder = new BitmapEncoder();
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        downsampler = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        this.registry.append(ByteBuffer.class, (Encoder)new ByteBufferEncoder()).append(InputStream.class, (Encoder)new StreamEncoder(arrayPool)).append("Bitmap", ByteBuffer.class, Bitmap.class, (ResourceDecoder)byteBufferBitmapDecoder).append("Bitmap", InputStream.class, Bitmap.class, (ResourceDecoder)streamBitmapDecoder).append("Bitmap", ParcelFileDescriptor.class, Bitmap.class, (ResourceDecoder)requestManagerRetriever).append("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.asset((BitmapPool)bitmapPool)).append(Bitmap.class, Bitmap.class, (ModelLoaderFactory)UnitModelLoader.Factory.getInstance()).append("Bitmap", Bitmap.class, Bitmap.class, (ResourceDecoder)new UnitBitmapDecoder()).append(Bitmap.class, (ResourceEncoder)bitmapEncoder).append("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, (ResourceDecoder)new BitmapDrawableDecoder((Resources)memoryCache, (ResourceDecoder)byteBufferBitmapDecoder)).append("BitmapDrawable", InputStream.class, BitmapDrawable.class, (ResourceDecoder)new BitmapDrawableDecoder((Resources)memoryCache, (ResourceDecoder)streamBitmapDecoder)).append("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, (ResourceDecoder)new BitmapDrawableDecoder((Resources)memoryCache, (ResourceDecoder)requestManagerRetriever)).append(BitmapDrawable.class, (ResourceEncoder)new BitmapDrawableEncoder(bitmapPool, (ResourceEncoder)bitmapEncoder)).append("Gif", InputStream.class, GifDrawable.class, (ResourceDecoder)new StreamGifDecoder(this.registry.getImageHeaderParsers(), (ResourceDecoder)connectivityMonitorFactory, arrayPool)).append("Gif", ByteBuffer.class, GifDrawable.class, (ResourceDecoder)connectivityMonitorFactory).append(GifDrawable.class, (ResourceEncoder)new GifDrawableEncoder()).append(GifDecoder.class, GifDecoder.class, (ModelLoaderFactory)UnitModelLoader.Factory.getInstance()).append("Bitmap", GifDecoder.class, Bitmap.class, (ResourceDecoder)new GifFrameResourceDecoder(bitmapPool)).append(Uri.class, Drawable.class, (ResourceDecoder)resourceDrawableDecoder).append(Uri.class, Bitmap.class, (ResourceDecoder)new ResourceBitmapDecoder(resourceDrawableDecoder, bitmapPool)).register((DataRewinder.Factory)new ByteBufferRewinder.Factory()).append(File.class, ByteBuffer.class, (ModelLoaderFactory)new ByteBufferFileLoader.Factory()).append(File.class, InputStream.class, (ModelLoaderFactory)new FileLoader.StreamFactory()).append(File.class, File.class, (ResourceDecoder)new FileDecoder()).append(File.class, ParcelFileDescriptor.class, (ModelLoaderFactory)new FileLoader.FileDescriptorFactory()).append(File.class, File.class, (ModelLoaderFactory)UnitModelLoader.Factory.getInstance()).register((DataRewinder.Factory)new InputStreamRewinder.Factory(arrayPool)).append(Integer.TYPE, InputStream.class, (ModelLoaderFactory)streamFactory).append(Integer.TYPE, ParcelFileDescriptor.class, (ModelLoaderFactory)fileDescriptorFactory).append(Integer.class, InputStream.class, (ModelLoaderFactory)streamFactory).append(Integer.class, ParcelFileDescriptor.class, (ModelLoaderFactory)fileDescriptorFactory).append(Integer.class, Uri.class, (ModelLoaderFactory)uriFactory).append(Integer.TYPE, AssetFileDescriptor.class, (ModelLoaderFactory)assetFileDescriptorFactory).append(Integer.class, AssetFileDescriptor.class, (ModelLoaderFactory)assetFileDescriptorFactory).append(Integer.TYPE, Uri.class, (ModelLoaderFactory)uriFactory).append(String.class, InputStream.class, (ModelLoaderFactory)new DataUrlLoader.StreamFactory()).append(String.class, InputStream.class, (ModelLoaderFactory)new StringLoader.StreamFactory()).append(String.class, ParcelFileDescriptor.class, (ModelLoaderFactory)new StringLoader.FileDescriptorFactory()).append(String.class, AssetFileDescriptor.class, (ModelLoaderFactory)new StringLoader.AssetFileDescriptorFactory()).append(Uri.class, InputStream.class, (ModelLoaderFactory)new HttpUriLoader.Factory()).append(Uri.class, InputStream.class, (ModelLoaderFactory)new AssetUriLoader.StreamFactory(context.getAssets())).append(Uri.class, ParcelFileDescriptor.class, (ModelLoaderFactory)new AssetUriLoader.FileDescriptorFactory(context.getAssets())).append(Uri.class, InputStream.class, (ModelLoaderFactory)new MediaStoreImageThumbLoader.Factory(context)).append(Uri.class, InputStream.class, (ModelLoaderFactory)new MediaStoreVideoThumbLoader.Factory(context)).append(Uri.class, InputStream.class, (ModelLoaderFactory)new UriLoader.StreamFactory(contentResolver)).append(Uri.class, ParcelFileDescriptor.class, (ModelLoaderFactory)new UriLoader.FileDescriptorFactory(contentResolver)).append(Uri.class, AssetFileDescriptor.class, (ModelLoaderFactory)new UriLoader.AssetFileDescriptorFactory(contentResolver)).append(Uri.class, InputStream.class, (ModelLoaderFactory)new UrlUriLoader.StreamFactory()).append(URL.class, InputStream.class, (ModelLoaderFactory)new UrlLoader.StreamFactory()).append(Uri.class, File.class, (ModelLoaderFactory)new MediaStoreFileLoader.Factory(context)).append(GlideUrl.class, InputStream.class, (ModelLoaderFactory)new HttpGlideUrlLoader.Factory()).append(byte[].class, ByteBuffer.class, (ModelLoaderFactory)new ByteArrayLoader.ByteBufferFactory()).append(byte[].class, InputStream.class, (ModelLoaderFactory)new ByteArrayLoader.StreamFactory()).append(Uri.class, Uri.class, (ModelLoaderFactory)UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, (ModelLoaderFactory)UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, (ResourceDecoder)new UnitDrawableDecoder()).register(Bitmap.class, BitmapDrawable.class, (ResourceTranscoder)new BitmapDrawableTranscoder((Resources)memoryCache)).register(Bitmap.class, byte[].class, (ResourceTranscoder)bitmapBytesTranscoder).register(Drawable.class, byte[].class, (ResourceTranscoder)new DrawableBytesTranscoder(bitmapPool, (ResourceTranscoder)bitmapBytesTranscoder, (ResourceTranscoder)downsampler)).register(GifDrawable.class, byte[].class, (ResourceTranscoder)downsampler);
        memoryCache = new ImageViewTargetFactory();
        this.glideContext = new GlideContext(context, arrayPool, this.registry, (ImageViewTargetFactory)memoryCache, requestOptions, map, engine, n);
    }

    private static void checkAndInitializeGlide(Context context) {
        if (isInitializing) throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        isInitializing = true;
        Glide.initializeGlide(context);
        isInitializing = false;
    }

    public static Glide get(Context context) {
        if (glide != null) return glide;
        synchronized (Glide.class) {
            if (glide != null) return glide;
            Glide.checkAndInitializeGlide(context);
        }
        return glide;
    }

    private static GeneratedAppGlideModule getAnnotationGeneratedGlideModules() {
        GeneratedAppGlideModule generatedAppGlideModule;
        block6: {
            block7: {
                try {
                    generatedAppGlideModule = (GeneratedAppGlideModule)Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    break block6;
                }
                catch (InvocationTargetException invocationTargetException) {
                    Glide.throwIncorrectGlideModule(invocationTargetException);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    Glide.throwIncorrectGlideModule(noSuchMethodException);
                }
                catch (IllegalAccessException illegalAccessException) {
                    Glide.throwIncorrectGlideModule(illegalAccessException);
                }
                catch (InstantiationException instantiationException) {
                    Glide.throwIncorrectGlideModule(instantiationException);
                }
                catch (ClassNotFoundException classNotFoundException) {
                    if (!Log.isLoggable((String)TAG, (int)5)) break block7;
                    Log.w((String)TAG, (String)"Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
            }
            generatedAppGlideModule = null;
        }
        return generatedAppGlideModule;
    }

    public static File getPhotoCacheDir(Context context) {
        return Glide.getPhotoCacheDir(context, DEFAULT_DISK_CACHE_DIR);
    }

    public static File getPhotoCacheDir(Context object, String string) {
        if ((object = object.getCacheDir()) != null) {
            if (((File)(object = new File((File)object, string))).mkdirs()) return object;
            if (!((File)object).exists()) return null;
            if (((File)object).isDirectory()) return object;
            return null;
        }
        if (!Log.isLoggable((String)TAG, (int)6)) return null;
        Log.e((String)TAG, (String)"default disk cache dir is null");
        return null;
    }

    private static RequestManagerRetriever getRetriever(Context context) {
        Preconditions.checkNotNull((Object)context, (String)"You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return Glide.get(context).getRequestManagerRetriever();
    }

    public static void init(Context context, GlideBuilder glideBuilder) {
        synchronized (Glide.class) {
            if (glide != null) {
                Glide.tearDown();
            }
            Glide.initializeGlide(context, glideBuilder);
            return;
        }
    }

    @Deprecated
    public static void init(Glide glide) {
        synchronized (Glide.class) {
            if (Glide.glide != null) {
                Glide.tearDown();
            }
            Glide.glide = glide;
            return;
        }
    }

    private static void initializeGlide(Context context) {
        Glide.initializeGlide(context, new GlideBuilder());
    }

    private static void initializeGlide(Context object, GlideBuilder object2) {
        Object object3;
        Object object4;
        Iterator iterator;
        Context context = object.getApplicationContext();
        GeneratedAppGlideModule generatedAppGlideModule = Glide.getAnnotationGeneratedGlideModules();
        object = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.isManifestParsingEnabled()) {
            object = new ManifestParser(context).parse();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.getExcludedModuleClasses().isEmpty()) {
            iterator = generatedAppGlideModule.getExcludedModuleClasses();
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                object4 = (GlideModule)iterator2.next();
                if (!iterator.contains(object4.getClass())) continue;
                if (Log.isLoggable((String)TAG, (int)3)) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("AppGlideModule excludes manifest GlideModule: ");
                    ((StringBuilder)object3).append(object4);
                    Log.d((String)TAG, (String)((StringBuilder)object3).toString());
                }
                iterator2.remove();
            }
        }
        if (Log.isLoggable((String)TAG, (int)3)) {
            iterator = object.iterator();
            while (iterator.hasNext()) {
                object3 = (GlideModule)iterator.next();
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("Discovered GlideModule from manifest: ");
                ((StringBuilder)object4).append(object3.getClass());
                Log.d((String)TAG, (String)((StringBuilder)object4).toString());
            }
        }
        iterator = generatedAppGlideModule != null ? generatedAppGlideModule.getRequestManagerFactory() : null;
        object2.setRequestManagerFactory((RequestManagerRetriever.RequestManagerFactory)iterator);
        iterator = object.iterator();
        while (iterator.hasNext()) {
            ((GlideModule)iterator.next()).applyOptions(context, object2);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.applyOptions(context, object2);
        }
        object2 = object2.build(context);
        object = object.iterator();
        while (object.hasNext()) {
            ((GlideModule)object.next()).registerComponents(context, (Glide)object2, object2.registry);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.registerComponents(context, (Glide)object2, object2.registry);
        }
        context.registerComponentCallbacks((ComponentCallbacks)object2);
        glide = object2;
    }

    public static void tearDown() {
        synchronized (Glide.class) {
            if (glide != null) {
                glide.getContext().getApplicationContext().unregisterComponentCallbacks((ComponentCallbacks)glide);
                Glide.glide.engine.shutdown();
            }
            glide = null;
            return;
        }
    }

    private static void throwIncorrectGlideModule(Exception exception) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exception);
    }

    public static RequestManager with(Activity activity) {
        return Glide.getRetriever((Context)activity).get(activity);
    }

    public static RequestManager with(Fragment fragment) {
        return Glide.getRetriever((Context)fragment.getActivity()).get(fragment);
    }

    public static RequestManager with(Context context) {
        return Glide.getRetriever(context).get(context);
    }

    public static RequestManager with(View view) {
        return Glide.getRetriever(view.getContext()).get(view);
    }

    public static RequestManager with(androidx.fragment.app.Fragment fragment) {
        return Glide.getRetriever((Context)fragment.getActivity()).get(fragment);
    }

    public static RequestManager with(FragmentActivity fragmentActivity) {
        return Glide.getRetriever((Context)fragmentActivity).get(fragmentActivity);
    }

    public void clearDiskCache() {
        Util.assertBackgroundThread();
        this.engine.clearDiskCache();
    }

    public void clearMemory() {
        Util.assertMainThread();
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
        this.arrayPool.clearMemory();
    }

    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    ConnectivityMonitorFactory getConnectivityMonitorFactory() {
        return this.connectivityMonitorFactory;
    }

    public Context getContext() {
        return this.glideContext.getBaseContext();
    }

    GlideContext getGlideContext() {
        return this.glideContext;
    }

    public Registry getRegistry() {
        return this.registry;
    }

    public RequestManagerRetriever getRequestManagerRetriever() {
        return this.requestManagerRetriever;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        this.clearMemory();
    }

    public void onTrimMemory(int n) {
        this.trimMemory(n);
    }

    public void preFillBitmapPool(PreFillType.Builder ... builderArray) {
        this.bitmapPreFiller.preFill(builderArray);
    }

    void registerRequestManager(RequestManager object) {
        List<RequestManager> list = this.managers;
        synchronized (list) {
            if (!this.managers.contains(object)) {
                this.managers.add((RequestManager)object);
                return;
            }
            object = new IllegalStateException("Cannot register already registered manager");
            throw object;
        }
    }

    boolean removeFromManagers(Target<?> target) {
        List<RequestManager> list = this.managers;
        synchronized (list) {
            try {
                Iterator<RequestManager> iterator = this.managers.iterator();
                do {
                    if (!iterator.hasNext()) return false;
                } while (!iterator.next().untrack(target));
                return true;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public MemoryCategory setMemoryCategory(MemoryCategory memoryCategory) {
        Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(memoryCategory.getMultiplier());
        this.bitmapPool.setSizeMultiplier(memoryCategory.getMultiplier());
        MemoryCategory memoryCategory2 = this.memoryCategory;
        this.memoryCategory = memoryCategory;
        return memoryCategory2;
    }

    public void trimMemory(int n) {
        Util.assertMainThread();
        this.memoryCache.trimMemory(n);
        this.bitmapPool.trimMemory(n);
        this.arrayPool.trimMemory(n);
    }

    void unregisterRequestManager(RequestManager object) {
        List<RequestManager> list = this.managers;
        synchronized (list) {
            if (this.managers.contains(object)) {
                this.managers.remove(object);
                return;
            }
            object = new IllegalStateException("Cannot unregister not yet registered manager");
            throw object;
        }
    }
}
