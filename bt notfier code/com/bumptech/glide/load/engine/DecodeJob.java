/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.Log
 *  androidx.core.os.TraceCompat
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.GlideContext
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.Registry$NoResultEncoderAvailableException
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.EncodeStrategy
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceEncoder
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.engine.DataCacheGenerator
 *  com.bumptech.glide.load.engine.DataCacheKey
 *  com.bumptech.glide.load.engine.DataFetcherGenerator
 *  com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
 *  com.bumptech.glide.load.engine.DecodeHelper
 *  com.bumptech.glide.load.engine.DecodeJob$1
 *  com.bumptech.glide.load.engine.DecodeJob$Callback
 *  com.bumptech.glide.load.engine.DecodeJob$DecodeCallback
 *  com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager
 *  com.bumptech.glide.load.engine.DecodeJob$DiskCacheProvider
 *  com.bumptech.glide.load.engine.DecodeJob$ReleaseManager
 *  com.bumptech.glide.load.engine.DecodeJob$RunReason
 *  com.bumptech.glide.load.engine.DecodeJob$Stage
 *  com.bumptech.glide.load.engine.DecodePath$DecodeCallback
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  com.bumptech.glide.load.engine.EngineKey
 *  com.bumptech.glide.load.engine.GlideException
 *  com.bumptech.glide.load.engine.Initializable
 *  com.bumptech.glide.load.engine.LoadPath
 *  com.bumptech.glide.load.engine.LockedResource
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.ResourceCacheGenerator
 *  com.bumptech.glide.load.engine.ResourceCacheKey
 *  com.bumptech.glide.load.engine.SourceGenerator
 *  com.bumptech.glide.load.resource.bitmap.Downsampler
 *  com.bumptech.glide.util.LogTime
 *  com.bumptech.glide.util.pool.FactoryPools$Poolable
 *  com.bumptech.glide.util.pool.StateVerifier
 */
package com.bumptech.glide.load.engine;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.core.os.TraceCompat;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataCacheGenerator;
import com.bumptech.glide.load.engine.DataCacheKey;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodeHelper;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.EngineKey;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.LockedResource;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.ResourceCacheGenerator;
import com.bumptech.glide.load.engine.ResourceCacheKey;
import com.bumptech.glide.load.engine.SourceGenerator;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DecodeJob<R>
implements DataFetcherGenerator.FetcherReadyCallback,
Runnable,
Comparable<DecodeJob<?>>,
FactoryPools.Poolable {
    private static final String TAG = "DecodeJob";
    private Callback<R> callback;
    private Key currentAttemptingKey;
    private Object currentData;
    private DataSource currentDataSource;
    private DataFetcher<?> currentFetcher;
    private volatile DataFetcherGenerator currentGenerator;
    private Key currentSourceKey;
    private Thread currentThread;
    private final DecodeHelper<R> decodeHelper = new DecodeHelper();
    private final DeferredEncodeManager<?> deferredEncodeManager;
    private final DiskCacheProvider diskCacheProvider;
    private DiskCacheStrategy diskCacheStrategy;
    private GlideContext glideContext;
    private int height;
    private volatile boolean isCallbackNotified;
    private volatile boolean isCancelled;
    private EngineKey loadKey;
    private boolean onlyRetrieveFromCache;
    private Options options;
    private int order;
    private final Pools.Pool<DecodeJob<?>> pool;
    private Priority priority;
    private final ReleaseManager releaseManager;
    private RunReason runReason;
    private Key signature;
    private Stage stage;
    private long startFetchTime;
    private final StateVerifier stateVerifier;
    private final List<Throwable> throwables = new ArrayList<Throwable>();
    private int width;

    DecodeJob(DiskCacheProvider diskCacheProvider, Pools.Pool<DecodeJob<?>> pool) {
        this.stateVerifier = StateVerifier.newInstance();
        this.deferredEncodeManager = new DeferredEncodeManager();
        this.releaseManager = new ReleaseManager();
        this.diskCacheProvider = diskCacheProvider;
        this.pool = pool;
    }

    private <Data> Resource<R> decodeFromData(DataFetcher<?> dataFetcher, Data object, DataSource resource) throws GlideException {
        if (object == null) {
            dataFetcher.cleanup();
            return null;
        }
        try {
            long l = LogTime.getLogTime();
            resource = this.decodeFromFetcher(object, (DataSource)resource);
            if (!Log.isLoggable((String)TAG, (int)2)) return resource;
            object = new StringBuilder();
            ((StringBuilder)object).append("Decoded result ");
            ((StringBuilder)object).append(resource);
            this.logWithTimeAndKey(((StringBuilder)object).toString(), l);
            return resource;
        }
        finally {
            dataFetcher.cleanup();
        }
    }

    private <Data> Resource<R> decodeFromFetcher(Data Data, DataSource dataSource) throws GlideException {
        return this.runLoadPath(Data, dataSource, this.decodeHelper.getLoadPath(Data.getClass()));
    }

    private void decodeFromRetrievedData() {
        Resource<R> resource;
        if (Log.isLoggable((String)TAG, (int)2)) {
            long l = this.startFetchTime;
            resource = new Resource<R>();
            resource.append("data: ");
            resource.append(this.currentData);
            resource.append(", cache key: ");
            resource.append((Object)this.currentSourceKey);
            resource.append(", fetcher: ");
            resource.append(this.currentFetcher);
            this.logWithTimeAndKey("Retrieved data", l, resource.toString());
        }
        resource = null;
        try {
            Resource<R> resource2;
            resource = resource2 = this.decodeFromData(this.currentFetcher, this.currentData, this.currentDataSource);
        }
        catch (GlideException glideException) {
            glideException.setLoggingDetails(this.currentAttemptingKey, this.currentDataSource);
            this.throwables.add(glideException);
        }
        if (resource != null) {
            this.notifyEncodeAndRelease(resource, this.currentDataSource);
        } else {
            this.runGenerators();
        }
    }

    private DataFetcherGenerator getNextGenerator() {
        int n = 1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[this.stage.ordinal()];
        if (n == 1) return new ResourceCacheGenerator(this.decodeHelper, (DataFetcherGenerator.FetcherReadyCallback)this);
        if (n == 2) return new DataCacheGenerator(this.decodeHelper, (DataFetcherGenerator.FetcherReadyCallback)this);
        if (n == 3) return new SourceGenerator(this.decodeHelper, (DataFetcherGenerator.FetcherReadyCallback)this);
        if (n == 4) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unrecognized stage: ");
        stringBuilder.append(this.stage);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private Stage getNextStage(Stage stage) {
        int n = 1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[stage.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n == 3) return Stage.FINISHED;
                if (n == 4) return Stage.FINISHED;
                if (n != 5) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unrecognized stage: ");
                    stringBuilder.append(stage);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                stage = this.diskCacheStrategy.decodeCachedResource() ? Stage.RESOURCE_CACHE : this.getNextStage(Stage.RESOURCE_CACHE);
                return stage;
            }
            stage = this.onlyRetrieveFromCache ? Stage.FINISHED : Stage.SOURCE;
            return stage;
        }
        stage = this.diskCacheStrategy.decodeCachedData() ? Stage.DATA_CACHE : this.getNextStage(Stage.DATA_CACHE);
        return stage;
    }

    private Options getOptionsWithHardwareConfig(DataSource dataSource) {
        Options options = this.options;
        if (Build.VERSION.SDK_INT < 26) {
            return options;
        }
        if (options.get(Downsampler.ALLOW_HARDWARE_CONFIG) != null) {
            return options;
        }
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            dataSource = options;
            if (!this.decodeHelper.isScaleOnlyOrNoTransform()) return dataSource;
        }
        dataSource = new Options();
        dataSource.putAll(this.options);
        dataSource.set(Downsampler.ALLOW_HARDWARE_CONFIG, (Object)true);
        return dataSource;
    }

    private int getPriority() {
        return this.priority.ordinal();
    }

    private void logWithTimeAndKey(String string, long l) {
        this.logWithTimeAndKey(string, l, null);
    }

    private void logWithTimeAndKey(String charSequence, long l, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence);
        stringBuilder.append(" in ");
        stringBuilder.append(LogTime.getElapsedMillis((long)l));
        stringBuilder.append(", load key: ");
        stringBuilder.append(this.loadKey);
        if (string != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(", ");
            ((StringBuilder)charSequence).append(string);
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = "";
        }
        stringBuilder.append((String)charSequence);
        stringBuilder.append(", thread: ");
        stringBuilder.append(Thread.currentThread().getName());
        Log.v((String)TAG, (String)stringBuilder.toString());
    }

    private void notifyComplete(Resource<R> resource, DataSource dataSource) {
        this.setNotifiedOrThrow();
        this.callback.onResourceReady(resource, dataSource);
    }

    private void notifyEncodeAndRelease(Resource<R> lockedResource, DataSource dataSource) {
        if (lockedResource instanceof Initializable) {
            ((Initializable)lockedResource).initialize();
        }
        LockedResource lockedResource2 = null;
        LockedResource lockedResource3 = lockedResource;
        if (this.deferredEncodeManager.hasResourceToEncode()) {
            lockedResource2 = lockedResource3 = LockedResource.obtain(lockedResource);
        }
        this.notifyComplete((Resource<R>)lockedResource3, dataSource);
        this.stage = Stage.ENCODE;
        try {
            if (this.deferredEncodeManager.hasResourceToEncode()) {
                this.deferredEncodeManager.encode(this.diskCacheProvider, this.options);
            }
            this.onEncodeComplete();
            return;
        }
        finally {
            if (lockedResource2 != null) {
                lockedResource2.unlock();
            }
        }
    }

    private void notifyFailed() {
        this.setNotifiedOrThrow();
        GlideException glideException = new GlideException("Failed to load resource", new ArrayList<Throwable>(this.throwables));
        this.callback.onLoadFailed(glideException);
        this.onLoadFailed();
    }

    private void onEncodeComplete() {
        if (!this.releaseManager.onEncodeComplete()) return;
        this.releaseInternal();
    }

    private void onLoadFailed() {
        if (!this.releaseManager.onFailed()) return;
        this.releaseInternal();
    }

    private void releaseInternal() {
        this.releaseManager.reset();
        this.deferredEncodeManager.clear();
        this.decodeHelper.clear();
        this.isCallbackNotified = false;
        this.glideContext = null;
        this.signature = null;
        this.options = null;
        this.priority = null;
        this.loadKey = null;
        this.callback = null;
        this.stage = null;
        this.currentGenerator = null;
        this.currentThread = null;
        this.currentSourceKey = null;
        this.currentData = null;
        this.currentDataSource = null;
        this.currentFetcher = null;
        this.startFetchTime = 0L;
        this.isCancelled = false;
        this.throwables.clear();
        this.pool.release((Object)this);
    }

    private void runGenerators() {
        boolean bl;
        block2: {
            this.currentThread = Thread.currentThread();
            this.startFetchTime = LogTime.getLogTime();
            boolean bl2 = false;
            do {
                bl = bl2;
                if (this.isCancelled) break block2;
                bl = bl2;
                if (this.currentGenerator == null) break block2;
                bl = bl2 = this.currentGenerator.startNext();
                if (bl2) break block2;
                this.stage = this.getNextStage(this.stage);
                this.currentGenerator = this.getNextGenerator();
            } while (this.stage != Stage.SOURCE);
            this.reschedule();
            return;
        }
        if (this.stage != Stage.FINISHED) {
            if (!this.isCancelled) return;
        }
        if (bl) return;
        this.notifyFailed();
    }

    private <Data, ResourceType> Resource<R> runLoadPath(Data object, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        Options options = this.getOptionsWithHardwareConfig(dataSource);
        object = this.glideContext.getRegistry().getRewinder(object);
        try {
            int n = this.width;
            int n2 = this.height;
            DecodeCallback decodeCallback = new DecodeCallback(this, dataSource);
            dataSource = loadPath.load(object, options, n, n2, (DecodePath.DecodeCallback)decodeCallback);
            return dataSource;
        }
        finally {
            object.cleanup();
        }
    }

    private void runWrapped() {
        int n = 1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[this.runReason.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unrecognized run reason: ");
                    stringBuilder.append(this.runReason);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                this.decodeFromRetrievedData();
            } else {
                this.runGenerators();
            }
        } else {
            this.stage = this.getNextStage(Stage.INITIALIZE);
            this.currentGenerator = this.getNextGenerator();
            this.runGenerators();
        }
    }

    private void setNotifiedOrThrow() {
        this.stateVerifier.throwIfRecycled();
        if (this.isCallbackNotified) throw new IllegalStateException("Already notified");
        this.isCallbackNotified = true;
    }

    public void cancel() {
        this.isCancelled = true;
        DataFetcherGenerator dataFetcherGenerator = this.currentGenerator;
        if (dataFetcherGenerator == null) return;
        dataFetcherGenerator.cancel();
    }

    @Override
    public int compareTo(DecodeJob<?> decodeJob) {
        int n;
        int n2 = n = this.getPriority() - super.getPriority();
        if (n != 0) return n2;
        n2 = this.order - decodeJob.order;
        return n2;
    }

    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    DecodeJob<R> init(GlideContext glideContext, Object object, EngineKey engineKey, Key key, int n, int n2, Class<?> clazz, Class<R> clazz2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean bl, boolean bl2, boolean bl3, Options options, Callback<R> callback, int n3) {
        this.decodeHelper.init(glideContext, object, key, n, n2, diskCacheStrategy, clazz, clazz2, priority, options, map, bl, bl2, this.diskCacheProvider);
        this.glideContext = glideContext;
        this.signature = key;
        this.priority = priority;
        this.loadKey = engineKey;
        this.width = n;
        this.height = n2;
        this.diskCacheStrategy = diskCacheStrategy;
        this.onlyRetrieveFromCache = bl3;
        this.options = options;
        this.callback = callback;
        this.order = n3;
        this.runReason = RunReason.INITIALIZE;
        return this;
    }

    public void onDataFetcherFailed(Key key, Exception throwable, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.cleanup();
        throwable = new GlideException("Fetching data failed", throwable);
        throwable.setLoggingDetails(key, dataSource, dataFetcher.getDataClass());
        this.throwables.add(throwable);
        if (Thread.currentThread() != this.currentThread) {
            this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.callback.reschedule(this);
        } else {
            this.runGenerators();
        }
    }

    public void onDataFetcherReady(Key key, Object object, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.currentSourceKey = key;
        this.currentData = object;
        this.currentFetcher = dataFetcher;
        this.currentDataSource = dataSource;
        this.currentAttemptingKey = key2;
        if (Thread.currentThread() != this.currentThread) {
            this.runReason = RunReason.DECODE_DATA;
            this.callback.reschedule(this);
        } else {
            TraceCompat.beginSection((String)"DecodeJob.decodeFromRetrievedData");
            this.decodeFromRetrievedData();
        }
        return;
        finally {
            TraceCompat.endSection();
        }
    }

    <Z> Resource<Z> onResourceDecoded(DataSource object, Resource<Z> resource) {
        EncodeStrategy encodeStrategy;
        Transformation transformation;
        Class<?> clazz = resource.get().getClass();
        Resource resource2 = DataSource.RESOURCE_DISK_CACHE;
        Resource resource3 = null;
        if (object != resource2) {
            transformation = this.decodeHelper.getTransformation(clazz);
            resource2 = transformation.transform((Context)this.glideContext, resource, this.width, this.height);
        } else {
            resource2 = resource;
            transformation = null;
        }
        if (!resource.equals(resource2)) {
            resource.recycle();
        }
        if (this.decodeHelper.isResourceEncoderAvailable(resource2)) {
            resource = this.decodeHelper.getResultEncoder(resource2);
            encodeStrategy = resource.getEncodeStrategy(this.options);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
            resource = resource3;
        }
        boolean bl = this.decodeHelper.isSourceKey(this.currentSourceKey);
        resource3 = resource2;
        if (!this.diskCacheStrategy.isResourceCacheable(bl ^ true, (DataSource)object, encodeStrategy)) return resource3;
        if (resource == null) throw new Registry.NoResultEncoderAvailableException(resource2.get().getClass());
        int n = 1.$SwitchMap$com$bumptech$glide$load$EncodeStrategy[encodeStrategy.ordinal()];
        if (n != 1) {
            if (n != 2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Unknown strategy: ");
                ((StringBuilder)object).append(encodeStrategy);
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            object = new ResourceCacheKey(this.decodeHelper.getArrayPool(), this.currentSourceKey, this.signature, this.width, this.height, transformation, clazz, this.options);
        } else {
            object = new DataCacheKey(this.currentSourceKey, this.signature);
        }
        resource3 = LockedResource.obtain((Resource)resource2);
        this.deferredEncodeManager.init((Key)object, (ResourceEncoder)resource, (LockedResource)resource3);
        return resource3;
    }

    void release(boolean bl) {
        if (!this.releaseManager.release(bl)) return;
        this.releaseInternal();
    }

    public void reschedule() {
        this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.callback.reschedule(this);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    @Override
    public void run() {
        block10: {
            block11: {
                block9: {
                    TraceCompat.beginSection((String)"DecodeJob#run");
                    var1_1 = this.currentFetcher;
                    try {
                        if (this.isCancelled) {
                            this.notifyFailed();
                            if (var1_1 == null) break block9;
                        }
                        ** GOTO lbl-1000
                    }
                    catch (Throwable var2_2) {
                        try {
                            if (Log.isLoggable((String)"DecodeJob", (int)3)) {
                                var3_4 = new StringBuilder();
                                var3_4.append("DecodeJob threw unexpectedly, isCancelled: ");
                                var3_4.append(this.isCancelled);
                                var3_4.append(", stage: ");
                                var3_4.append(this.stage);
                                Log.d((String)"DecodeJob", (String)var3_4.toString(), (Throwable)var2_2);
                            }
                            if (this.stage != Stage.ENCODE) {
                                this.throwables.add(var2_2);
                                this.notifyFailed();
                            }
                            if (this.isCancelled == false) throw var2_2;
                            if (var1_1 == null) break block10;
                            break block11;
                        }
                        catch (Throwable var2_3) {
                            if (var1_1 != null) {
                                var1_1.cleanup();
                            }
                            TraceCompat.endSection();
                            throw var2_3;
                        }
                    }
                    var1_1.cleanup();
                }
                TraceCompat.endSection();
                return;
lbl-1000:
                // 1 sources

                {
                    this.runWrapped();
                    if (var1_1 == null) break block10;
                }
            }
            var1_1.cleanup();
        }
        TraceCompat.endSection();
    }

    boolean willDecodeFromCache() {
        Stage stage = this.getNextStage(Stage.INITIALIZE);
        boolean bl = stage == Stage.RESOURCE_CACHE || stage == Stage.DATA_CACHE;
        return bl;
    }
}
