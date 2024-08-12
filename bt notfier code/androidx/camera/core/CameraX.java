/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.Resources$NotFoundException
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.SystemClock
 *  androidx.arch.core.util.Function
 *  androidx.camera.core.CameraExecutor
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.CameraX$2
 *  androidx.camera.core.CameraX$InternalInitState
 *  androidx.camera.core.CameraXConfig
 *  androidx.camera.core.CameraXConfig$Provider
 *  androidx.camera.core.InitializationException
 *  androidx.camera.core.Logger
 *  androidx.camera.core.R$string
 *  androidx.camera.core._$$Lambda$CameraX$1mx06IrInQqXqFxYm74hARcHc64
 *  androidx.camera.core._$$Lambda$CameraX$4dbkF7X2OvYAcnCqEbjT_6phEWo
 *  androidx.camera.core._$$Lambda$CameraX$I0yV_40rhyMeVUFgVxnImXbjM_0
 *  androidx.camera.core._$$Lambda$CameraX$PyTMqE8rSnFsLpsANtL2ojEI5QI
 *  androidx.camera.core._$$Lambda$CameraX$RpN6H_GOvlkTaYOxBF7oFPOEV_4
 *  androidx.camera.core._$$Lambda$CameraX$eVFX72Z7PVYg4hfNRBKl_qY_8Ac
 *  androidx.camera.core._$$Lambda$CameraX$gx_FMHXHe6pkO4f1cAAOy1ZMQGM
 *  androidx.camera.core._$$Lambda$CameraX$mXdNm3KAyXgwNmVtH7yoqr2IRbE
 *  androidx.camera.core._$$Lambda$CameraX$pfTQmIZkMo7eYt2wbNhnn4BBWWM
 *  androidx.camera.core._$$Lambda$CameraX$wMZjJsgpnlorhgxL81349SKdSDE
 *  androidx.camera.core._$$Lambda$CameraX$xay7br8oqZ6q4uQ5PYsgeR_j580
 *  androidx.camera.core._$$Lambda$CameraX$zGjevt7sTF6HDnDgHdMdO95T0_g
 *  androidx.camera.core.impl.CameraDeviceSurfaceManager
 *  androidx.camera.core.impl.CameraFactory
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.impl.CameraRepository
 *  androidx.camera.core.impl.CameraThreadConfig
 *  androidx.camera.core.impl.CameraValidator
 *  androidx.camera.core.impl.CameraValidator$CameraIdListIncorrectException
 *  androidx.camera.core.impl.UseCaseConfigFactory
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.AsyncFunction
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.FutureChain
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.camera.core.internal.compat.quirk.DeviceQuirks
 *  androidx.camera.core.internal.compat.quirk.IncompleteCameraListQuirk
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.core.os.HandlerCompat
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraExecutor;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.R;
import androidx.camera.core._$;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.CameraThreadConfig;
import androidx.camera.core.impl.CameraValidator;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.IncompleteCameraListQuirk;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.HandlerCompat;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class CameraX {
    static final Object INSTANCE_LOCK = new Object();
    private static final long RETRY_SLEEP_MILLIS = 500L;
    private static final String RETRY_TOKEN = "retry_token";
    private static final String TAG = "CameraX";
    private static final long WAIT_INITIALIZED_TIMEOUT_MILLIS = 3000L;
    private static CameraXConfig.Provider sConfigProvider;
    private static ListenableFuture<Void> sInitializeFuture;
    static CameraX sInstance;
    private static ListenableFuture<Void> sShutdownFuture;
    private Context mAppContext;
    private final Executor mCameraExecutor;
    private CameraFactory mCameraFactory;
    final CameraRepository mCameraRepository = new CameraRepository();
    private final CameraXConfig mCameraXConfig;
    private UseCaseConfigFactory mDefaultConfigFactory;
    private InternalInitState mInitState;
    private final Object mInitializeLock = new Object();
    private final Handler mSchedulerHandler;
    private final HandlerThread mSchedulerThread;
    private ListenableFuture<Void> mShutdownInternalFuture;
    private CameraDeviceSurfaceManager mSurfaceManager;

    static {
        sInstance = null;
        sConfigProvider = null;
        sInitializeFuture = Futures.immediateFailedFuture((Throwable)new IllegalStateException("CameraX is not initialized."));
        sShutdownFuture = Futures.immediateFuture(null);
    }

    CameraX(CameraXConfig object) {
        this.mInitState = InternalInitState.UNINITIALIZED;
        this.mShutdownInternalFuture = Futures.immediateFuture(null);
        this.mCameraXConfig = (CameraXConfig)Preconditions.checkNotNull((Object)object);
        Executor executor = object.getCameraExecutor(null);
        Handler handler = object.getSchedulerHandler(null);
        object = executor;
        if (executor == null) {
            object = new CameraExecutor();
        }
        this.mCameraExecutor = object;
        if (handler == null) {
            object = new HandlerThread("CameraX-scheduler", 10);
            this.mSchedulerThread = object;
            object.start();
            this.mSchedulerHandler = HandlerCompat.createAsync((Looper)this.mSchedulerThread.getLooper());
        } else {
            this.mSchedulerThread = null;
            this.mSchedulerHandler = handler;
        }
    }

    private static CameraX checkInitialized() {
        CameraX cameraX = CameraX.waitInitialized();
        Preconditions.checkState((boolean)cameraX.isInitializedInternal(), (String)"Must call CameraX.initialize() first");
        return cameraX;
    }

    public static void configureInstance(CameraXConfig cameraXConfig) {
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            _$.Lambda.CameraX.wMZjJsgpnlorhgxL81349SKdSDE wMZjJsgpnlorhgxL81349SKdSDE2 = new _$.Lambda.CameraX.wMZjJsgpnlorhgxL81349SKdSDE(cameraXConfig);
            CameraX.configureInstanceLocked((CameraXConfig.Provider)wMZjJsgpnlorhgxL81349SKdSDE2);
            return;
        }
    }

    private static void configureInstanceLocked(CameraXConfig.Provider object) {
        Preconditions.checkNotNull((Object)object);
        boolean bl = sConfigProvider == null;
        Preconditions.checkState((boolean)bl, (String)"CameraX has already been configured. To use a different configuration, shutdown() must be called.");
        sConfigProvider = object;
        object = (Integer)object.getCameraXConfig().retrieveOption(CameraXConfig.OPTION_MIN_LOGGING_LEVEL, null);
        if (object == null) return;
        Logger.setMinLogLevel((int)((Integer)object));
    }

    private static Application getApplicationFromContext(Context context) {
        block2: {
            context = context.getApplicationContext();
            while (context instanceof ContextWrapper) {
                if (context instanceof Application) {
                    context = (Application)context;
                    break block2;
                }
                context = ((ContextWrapper)context).getBaseContext();
            }
            context = null;
        }
        return context;
    }

    public static CameraInternal getCameraWithCameraSelector(CameraSelector cameraSelector) {
        return cameraSelector.select(CameraX.checkInitialized().getCameraRepository().getCameras());
    }

    private static CameraXConfig.Provider getConfigProvider(Context context) {
        block10: {
            Application application = CameraX.getApplicationFromContext(context);
            if (application instanceof CameraXConfig.Provider) {
                context = (CameraXConfig.Provider)application;
            } else {
                try {
                    context = (CameraXConfig.Provider)Class.forName(context.getApplicationContext().getResources().getString(R.string.androidx_camera_default_config_provider)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    break block10;
                }
                catch (NullPointerException nullPointerException) {
                }
                catch (IllegalAccessException illegalAccessException) {
                }
                catch (NoSuchMethodException noSuchMethodException) {
                }
                catch (InvocationTargetException invocationTargetException) {
                }
                catch (InstantiationException instantiationException) {
                }
                catch (ClassNotFoundException classNotFoundException) {
                }
                catch (Resources.NotFoundException notFoundException) {
                    // empty catch block
                }
                Logger.e((String)TAG, (String)"Failed to retrieve default CameraXConfig.Provider from resources", (Throwable)context);
                context = null;
            }
        }
        return context;
    }

    @Deprecated
    public static Context getContext() {
        return CameraX.checkInitialized().mAppContext;
    }

    private static ListenableFuture<CameraX> getInstance() {
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            ListenableFuture<CameraX> listenableFuture = CameraX.getInstanceLocked();
            return listenableFuture;
        }
    }

    private static ListenableFuture<CameraX> getInstanceLocked() {
        CameraX cameraX = sInstance;
        if (cameraX != null) return Futures.transform(sInitializeFuture, (Function)new _$.Lambda.CameraX.I0yV_40rhyMeVUFgVxnImXbjM_0(cameraX), (Executor)CameraXExecutors.directExecutor());
        return Futures.immediateFailedFuture((Throwable)new IllegalStateException("Must call CameraX.initialize() first"));
    }

    public static ListenableFuture<CameraX> getOrCreateInstance(Context object) {
        Preconditions.checkNotNull((Object)object, (Object)"Context must not be null.");
        Object object2 = INSTANCE_LOCK;
        synchronized (object2) {
            boolean bl = sConfigProvider != null;
            Object object3 = CameraX.getInstanceLocked();
            boolean bl2 = object3.isDone();
            CameraXConfig.Provider provider = object3;
            if (bl2) {
                try {
                    object3.get();
                    provider = object3;
                }
                catch (ExecutionException executionException) {
                    CameraX.shutdownLocked();
                    provider = null;
                }
                catch (InterruptedException interruptedException) {
                    provider = new RuntimeException("Unexpected thread interrupt. Should not be possible since future is already complete.", interruptedException);
                    throw provider;
                }
            }
            object3 = provider;
            if (provider != null) return object3;
            if (!bl) {
                provider = CameraX.getConfigProvider(object);
                if (provider == null) {
                    object = new IllegalStateException("CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
                    throw object;
                }
                CameraX.configureInstanceLocked(provider);
            }
            CameraX.initializeInstanceLocked(object);
            object3 = CameraX.getInstanceLocked();
            return object3;
        }
    }

    private void initAndRetryRecursively(Executor executor, long l, Context context, CallbackToFutureAdapter.Completer<Void> completer) {
        executor.execute((Runnable)new _$.Lambda.CameraX.PyTMqE8rSnFsLpsANtL2ojEI5QI(this, context, executor, completer, l));
    }

    private ListenableFuture<Void> initInternal(Context object) {
        Object object2 = this.mInitializeLock;
        synchronized (object2) {
            boolean bl = this.mInitState == InternalInitState.UNINITIALIZED;
            Preconditions.checkState((boolean)bl, (String)"CameraX.initInternal() should only be called once per instance");
            this.mInitState = InternalInitState.INITIALIZING;
            _$.Lambda.CameraX.eVFX72Z7PVYg4hfNRBKl_qY_8Ac eVFX72Z7PVYg4hfNRBKl_qY_8Ac2 = new _$.Lambda.CameraX.eVFX72Z7PVYg4hfNRBKl_qY_8Ac(this, object);
            object = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)eVFX72Z7PVYg4hfNRBKl_qY_8Ac2);
            return object;
        }
    }

    public static ListenableFuture<Void> initialize(Context object, CameraXConfig cameraXConfig) {
        Object object2 = INSTANCE_LOCK;
        synchronized (object2) {
            Preconditions.checkNotNull((Object)object);
            _$.Lambda.CameraX.1mx06IrInQqXqFxYm74hARcHc64 mx06IrInQqXqFxYm74hARcHc64 = new _$.Lambda.CameraX.1mx06IrInQqXqFxYm74hARcHc64(cameraXConfig);
            CameraX.configureInstanceLocked((CameraXConfig.Provider)mx06IrInQqXqFxYm74hARcHc64);
            CameraX.initializeInstanceLocked(object);
            object = sInitializeFuture;
            return object;
        }
    }

    private static void initializeInstanceLocked(Context context) {
        CameraX cameraX;
        Preconditions.checkNotNull((Object)context);
        boolean bl = sInstance == null;
        Preconditions.checkState((boolean)bl, (String)"CameraX already initialized.");
        Preconditions.checkNotNull((Object)sConfigProvider);
        sInstance = cameraX = new CameraX(sConfigProvider.getCameraXConfig());
        sInitializeFuture = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.CameraX.pfTQmIZkMo7eYt2wbNhnn4BBWWM(cameraX, context));
    }

    public static boolean isInitialized() {
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            boolean bl = sInstance != null && sInstance.isInitializedInternal();
            return bl;
        }
    }

    private boolean isInitializedInternal() {
        Object object = this.mInitializeLock;
        synchronized (object) {
            boolean bl = this.mInitState == InternalInitState.INITIALIZED;
            return bl;
        }
    }

    static /* synthetic */ CameraXConfig lambda$configureInstance$1(CameraXConfig cameraXConfig) {
        return cameraXConfig;
    }

    static /* synthetic */ CameraX lambda$getInstanceLocked$6(CameraX cameraX, Void void_) {
        return cameraX;
    }

    static /* synthetic */ CameraXConfig lambda$initialize$0(CameraXConfig cameraXConfig) {
        return cameraXConfig;
    }

    static /* synthetic */ ListenableFuture lambda$initializeInstanceLocked$2(CameraX cameraX, Context context, Void void_) throws Exception {
        return cameraX.initInternal(context);
    }

    static /* synthetic */ Object lambda$initializeInstanceLocked$3(CameraX cameraX, Context context, CallbackToFutureAdapter.Completer completer) throws Exception {
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            FutureChain futureChain = FutureChain.from(sShutdownFuture);
            _$.Lambda.CameraX.zGjevt7sTF6HDnDgHdMdO95T0_g zGjevt7sTF6HDnDgHdMdO95T0_g2 = new _$.Lambda.CameraX.zGjevt7sTF6HDnDgHdMdO95T0_g(cameraX, context);
            futureChain = futureChain.transformAsync((AsyncFunction)zGjevt7sTF6HDnDgHdMdO95T0_g2, CameraXExecutors.directExecutor());
            context = new /* Unavailable Anonymous Inner Class!! */;
            Futures.addCallback((ListenableFuture)futureChain, (FutureCallback)context, (Executor)CameraXExecutors.directExecutor());
            return "CameraX-initialize";
        }
    }

    static /* synthetic */ void lambda$shutdownLocked$4(CameraX cameraX, CallbackToFutureAdapter.Completer completer) {
        Futures.propagate(cameraX.shutdownInternal(), (CallbackToFutureAdapter.Completer)completer);
    }

    static /* synthetic */ Object lambda$shutdownLocked$5(CameraX cameraX, CallbackToFutureAdapter.Completer completer) throws Exception {
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            ListenableFuture<Void> listenableFuture = sInitializeFuture;
            _$.Lambda.CameraX.4dbkF7X2OvYAcnCqEbjT_6phEWo dbkF7X2OvYAcnCqEbjT_6phEWo = new _$.Lambda.CameraX.4dbkF7X2OvYAcnCqEbjT_6phEWo(cameraX, completer);
            listenableFuture.addListener((Runnable)dbkF7X2OvYAcnCqEbjT_6phEWo, CameraXExecutors.directExecutor());
            return "CameraX shutdown";
        }
    }

    private void setStateToInitialized() {
        Object object = this.mInitializeLock;
        synchronized (object) {
            this.mInitState = InternalInitState.INITIALIZED;
            return;
        }
    }

    public static ListenableFuture<Void> shutdown() {
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            sConfigProvider = null;
            Logger.resetMinLogLevel();
            ListenableFuture<Void> listenableFuture = CameraX.shutdownLocked();
            return listenableFuture;
        }
    }

    private ListenableFuture<Void> shutdownInternal() {
        Object object = this.mInitializeLock;
        synchronized (object) {
            _$.Lambda.CameraX.mXdNm3KAyXgwNmVtH7yoqr2IRbE mXdNm3KAyXgwNmVtH7yoqr2IRbE2;
            this.mSchedulerHandler.removeCallbacksAndMessages((Object)RETRY_TOKEN);
            int n = 2.$SwitchMap$androidx$camera$core$CameraX$InternalInitState[this.mInitState.ordinal()];
            if (n == 1) {
                this.mInitState = InternalInitState.SHUTDOWN;
                ListenableFuture listenableFuture = Futures.immediateFuture(null);
                return listenableFuture;
            }
            if (n == 2) {
                IllegalStateException illegalStateException = new IllegalStateException("CameraX could not be shutdown when it is initializing.");
                throw illegalStateException;
            }
            if (n == 3) {
                this.mInitState = InternalInitState.SHUTDOWN;
                mXdNm3KAyXgwNmVtH7yoqr2IRbE2 = new _$.Lambda.CameraX.mXdNm3KAyXgwNmVtH7yoqr2IRbE(this);
                this.mShutdownInternalFuture = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)mXdNm3KAyXgwNmVtH7yoqr2IRbE2);
            }
            mXdNm3KAyXgwNmVtH7yoqr2IRbE2 = this.mShutdownInternalFuture;
            return mXdNm3KAyXgwNmVtH7yoqr2IRbE2;
        }
    }

    static ListenableFuture<Void> shutdownLocked() {
        Object object = sInstance;
        if (object == null) {
            return sShutdownFuture;
        }
        sInstance = null;
        sShutdownFuture = object = Futures.nonCancellationPropagating((ListenableFuture)CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.CameraX.RpN6H_GOvlkTaYOxBF7oFPOEV_4((CameraX)object)));
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private static CameraX waitInitialized() {
        void var0_4;
        Object object = CameraX.getInstance();
        try {
            object = (CameraX)object.get(3000L, TimeUnit.MILLISECONDS);
            return object;
        }
        catch (TimeoutException timeoutException) {
        }
        catch (InterruptedException interruptedException) {
        }
        catch (ExecutionException executionException) {
            // empty catch block
        }
        throw new IllegalStateException((Throwable)var0_4);
    }

    public CameraDeviceSurfaceManager getCameraDeviceSurfaceManager() {
        CameraDeviceSurfaceManager cameraDeviceSurfaceManager = this.mSurfaceManager;
        if (cameraDeviceSurfaceManager == null) throw new IllegalStateException("CameraX not initialized yet.");
        return cameraDeviceSurfaceManager;
    }

    public CameraFactory getCameraFactory() {
        CameraFactory cameraFactory = this.mCameraFactory;
        if (cameraFactory == null) throw new IllegalStateException("CameraX not initialized yet.");
        return cameraFactory;
    }

    public CameraRepository getCameraRepository() {
        return this.mCameraRepository;
    }

    public UseCaseConfigFactory getDefaultConfigFactory() {
        UseCaseConfigFactory useCaseConfigFactory = this.mDefaultConfigFactory;
        if (useCaseConfigFactory == null) throw new IllegalStateException("CameraX not initialized yet.");
        return useCaseConfigFactory;
    }

    public /* synthetic */ void lambda$initAndRetryRecursively$8$CameraX(Executor executor, long l, CallbackToFutureAdapter.Completer completer) {
        this.initAndRetryRecursively(executor, l, this.mAppContext, (CallbackToFutureAdapter.Completer<Void>)completer);
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ void lambda$initAndRetryRecursively$9$CameraX(Context object, Executor executor, CallbackToFutureAdapter.Completer completer, long l) {
        block16: {
            void var1_5;
            try {
                Object object2 = CameraX.getApplicationFromContext(object);
                this.mAppContext = object2;
                if (object2 == null) {
                    this.mAppContext = object.getApplicationContext();
                }
                if ((object2 = this.mCameraXConfig.getCameraFactoryProvider(null)) == null) {
                    object2 = new IllegalArgumentException("Invalid app configuration provided. Missing CameraFactory.");
                    object = new InitializationException((Throwable)object2);
                    throw object;
                }
                CameraThreadConfig cameraThreadConfig = CameraThreadConfig.create((Executor)this.mCameraExecutor, (Handler)this.mSchedulerHandler);
                object = this.mCameraXConfig.getAvailableCamerasLimiter(null);
                this.mCameraFactory = object2.newInstance(this.mAppContext, cameraThreadConfig, (CameraSelector)object);
                object2 = this.mCameraXConfig.getDeviceSurfaceManagerProvider(null);
                if (object2 == null) {
                    object = new IllegalArgumentException("Invalid app configuration provided. Missing CameraDeviceSurfaceManager.");
                    object2 = new InitializationException((Throwable)object);
                    throw object2;
                }
                this.mSurfaceManager = object2.newInstance(this.mAppContext, this.mCameraFactory.getCameraManager(), this.mCameraFactory.getAvailableCameraIds());
                object2 = this.mCameraXConfig.getUseCaseConfigFactoryProvider(null);
                if (object2 == null) {
                    object2 = new IllegalArgumentException("Invalid app configuration provided. Missing UseCaseConfigFactory.");
                    object = new InitializationException((Throwable)object2);
                    throw object;
                }
                this.mDefaultConfigFactory = object2.newInstance(this.mAppContext);
                if (executor instanceof CameraExecutor) {
                    ((CameraExecutor)executor).init(this.mCameraFactory);
                }
                this.mCameraRepository.init(this.mCameraFactory);
                if (DeviceQuirks.get(IncompleteCameraListQuirk.class) != null) {
                    CameraValidator.validateCameras((Context)this.mAppContext, (CameraRepository)this.mCameraRepository, (CameraSelector)object);
                }
                this.setStateToInitialized();
                completer.set(null);
                break block16;
            }
            catch (RuntimeException runtimeException) {
            }
            catch (InitializationException initializationException) {
            }
            catch (CameraValidator.CameraIdListIncorrectException cameraIdListIncorrectException) {
                // empty catch block
            }
            if (SystemClock.elapsedRealtime() - l < 2500L) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Retry init. Start time ");
                stringBuilder.append(l);
                stringBuilder.append(" current time ");
                stringBuilder.append(SystemClock.elapsedRealtime());
                Logger.w((String)TAG, (String)stringBuilder.toString(), (Throwable)var1_5);
                HandlerCompat.postDelayed((Handler)this.mSchedulerHandler, (Runnable)new _$.Lambda.CameraX.xay7br8oqZ6q4uQ5PYsgeR_j580(this, executor, l, completer), (Object)RETRY_TOKEN, (long)500L);
            } else {
                this.setStateToInitialized();
                if (var1_5 instanceof CameraValidator.CameraIdListIncorrectException) {
                    Logger.e((String)TAG, (String)"The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.");
                    completer.set(null);
                } else if (var1_5 instanceof InitializationException) {
                    completer.setException((Throwable)var1_5);
                } else {
                    completer.setException((Throwable)new InitializationException((Throwable)var1_5));
                }
            }
        }
    }

    public /* synthetic */ Object lambda$initInternal$7$CameraX(Context context, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.initAndRetryRecursively(this.mCameraExecutor, SystemClock.elapsedRealtime(), context, (CallbackToFutureAdapter.Completer<Void>)completer);
        return "CameraX initInternal";
    }

    public /* synthetic */ void lambda$shutdownInternal$10$CameraX(CallbackToFutureAdapter.Completer completer) {
        if (this.mSchedulerThread == null) return;
        Executor executor = this.mCameraExecutor;
        if (executor instanceof CameraExecutor) {
            ((CameraExecutor)executor).deinit();
        }
        this.mSchedulerThread.quit();
        completer.set(null);
    }

    public /* synthetic */ Object lambda$shutdownInternal$11$CameraX(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCameraRepository.deinit().addListener((Runnable)new _$.Lambda.CameraX.gx_FMHXHe6pkO4f1cAAOy1ZMQGM(this, completer), this.mCameraExecutor);
        return "CameraX shutdownInternal";
    }
}
