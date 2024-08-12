/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.CameraX
 *  androidx.camera.core.impl.CameraDeviceSurfaceManager$Provider
 *  androidx.camera.core.impl.CameraFactory$Provider
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.Config$OptionMatcher
 *  androidx.camera.core.impl.Config$OptionPriority
 *  androidx.camera.core.impl.OptionsBundle
 *  androidx.camera.core.impl.ReadableConfig
 *  androidx.camera.core.impl.ReadableConfig$_CC
 *  androidx.camera.core.impl.UseCaseConfigFactory$Provider
 *  androidx.camera.core.internal.TargetConfig
 *  androidx.camera.core.internal.TargetConfig$_CC
 */
package androidx.camera.core;

import android.os.Handler;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import java.util.Set;
import java.util.concurrent.Executor;

public final class CameraXConfig
implements TargetConfig<CameraX> {
    static final Config.Option<CameraSelector> OPTION_AVAILABLE_CAMERAS_LIMITER;
    static final Config.Option<Executor> OPTION_CAMERA_EXECUTOR;
    static final Config.Option<CameraFactory.Provider> OPTION_CAMERA_FACTORY_PROVIDER;
    static final Config.Option<CameraDeviceSurfaceManager.Provider> OPTION_DEVICE_SURFACE_MANAGER_PROVIDER;
    static final Config.Option<Integer> OPTION_MIN_LOGGING_LEVEL;
    static final Config.Option<Handler> OPTION_SCHEDULER_HANDLER;
    static final Config.Option<UseCaseConfigFactory.Provider> OPTION_USECASE_CONFIG_FACTORY_PROVIDER;
    private final OptionsBundle mConfig;

    static {
        OPTION_CAMERA_FACTORY_PROVIDER = Config.Option.create((String)"camerax.core.appConfig.cameraFactoryProvider", CameraFactory.Provider.class);
        OPTION_DEVICE_SURFACE_MANAGER_PROVIDER = Config.Option.create((String)"camerax.core.appConfig.deviceSurfaceManagerProvider", CameraDeviceSurfaceManager.Provider.class);
        OPTION_USECASE_CONFIG_FACTORY_PROVIDER = Config.Option.create((String)"camerax.core.appConfig.useCaseConfigFactoryProvider", UseCaseConfigFactory.Provider.class);
        OPTION_CAMERA_EXECUTOR = Config.Option.create((String)"camerax.core.appConfig.cameraExecutor", Executor.class);
        OPTION_SCHEDULER_HANDLER = Config.Option.create((String)"camerax.core.appConfig.schedulerHandler", Handler.class);
        OPTION_MIN_LOGGING_LEVEL = Config.Option.create((String)"camerax.core.appConfig.minimumLoggingLevel", Integer.TYPE);
        OPTION_AVAILABLE_CAMERAS_LIMITER = Config.Option.create((String)"camerax.core.appConfig.availableCamerasLimiter", CameraSelector.class);
    }

    CameraXConfig(OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    public /* synthetic */ boolean containsOption(Config.Option<?> option) {
        return ReadableConfig._CC.$default$containsOption((ReadableConfig)this, option);
    }

    public /* synthetic */ void findOptions(String string, Config.OptionMatcher optionMatcher) {
        ReadableConfig._CC.$default$findOptions((ReadableConfig)this, (String)string, (Config.OptionMatcher)optionMatcher);
    }

    public CameraSelector getAvailableCamerasLimiter(CameraSelector cameraSelector) {
        return (CameraSelector)this.mConfig.retrieveOption(OPTION_AVAILABLE_CAMERAS_LIMITER, (Object)cameraSelector);
    }

    public Executor getCameraExecutor(Executor executor) {
        return (Executor)this.mConfig.retrieveOption(OPTION_CAMERA_EXECUTOR, (Object)executor);
    }

    public CameraFactory.Provider getCameraFactoryProvider(CameraFactory.Provider provider) {
        return (CameraFactory.Provider)this.mConfig.retrieveOption(OPTION_CAMERA_FACTORY_PROVIDER, (Object)provider);
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public CameraDeviceSurfaceManager.Provider getDeviceSurfaceManagerProvider(CameraDeviceSurfaceManager.Provider provider) {
        return (CameraDeviceSurfaceManager.Provider)this.mConfig.retrieveOption(OPTION_DEVICE_SURFACE_MANAGER_PROVIDER, (Object)provider);
    }

    public int getMinimumLoggingLevel() {
        return (Integer)this.mConfig.retrieveOption(OPTION_MIN_LOGGING_LEVEL, (Object)3);
    }

    public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option<?> option) {
        return ReadableConfig._CC.$default$getOptionPriority((ReadableConfig)this, option);
    }

    public /* synthetic */ Set<Config.OptionPriority> getPriorities(Config.Option<?> option) {
        return ReadableConfig._CC.$default$getPriorities((ReadableConfig)this, option);
    }

    public Handler getSchedulerHandler(Handler handler) {
        return (Handler)this.mConfig.retrieveOption(OPTION_SCHEDULER_HANDLER, (Object)handler);
    }

    public /* synthetic */ Class<T> getTargetClass() {
        return TargetConfig._CC.$default$getTargetClass((TargetConfig)this);
    }

    public /* synthetic */ Class<T> getTargetClass(Class<T> clazz) {
        return TargetConfig._CC.$default$getTargetClass((TargetConfig)this, clazz);
    }

    public /* synthetic */ String getTargetName() {
        return TargetConfig._CC.$default$getTargetName((TargetConfig)this);
    }

    public /* synthetic */ String getTargetName(String string) {
        return TargetConfig._CC.$default$getTargetName((TargetConfig)this, (String)string);
    }

    public UseCaseConfigFactory.Provider getUseCaseConfigFactoryProvider(UseCaseConfigFactory.Provider provider) {
        return (UseCaseConfigFactory.Provider)this.mConfig.retrieveOption(OPTION_USECASE_CONFIG_FACTORY_PROVIDER, (Object)provider);
    }

    public /* synthetic */ Set<Config.Option<?>> listOptions() {
        return ReadableConfig._CC.$default$listOptions((ReadableConfig)this);
    }

    public /* synthetic */ <ValueT> ValueT retrieveOption(Config.Option<ValueT> option) {
        return (ValueT)ReadableConfig._CC.$default$retrieveOption((ReadableConfig)this, option);
    }

    public /* synthetic */ <ValueT> ValueT retrieveOption(Config.Option<ValueT> option, ValueT ValueT) {
        return (ValueT)ReadableConfig._CC.$default$retrieveOption((ReadableConfig)this, option, ValueT);
    }

    public /* synthetic */ <ValueT> ValueT retrieveOptionWithPriority(Config.Option<ValueT> option, Config.OptionPriority optionPriority) {
        return (ValueT)ReadableConfig._CC.$default$retrieveOptionWithPriority((ReadableConfig)this, option, (Config.OptionPriority)optionPriority);
    }
}
