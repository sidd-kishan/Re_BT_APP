/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.CameraX
 *  androidx.camera.core.CameraXConfig
 *  androidx.camera.core.impl.CameraDeviceSurfaceManager$Provider
 *  androidx.camera.core.impl.CameraFactory$Provider
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.MutableConfig
 *  androidx.camera.core.impl.MutableOptionsBundle
 *  androidx.camera.core.impl.OptionsBundle
 *  androidx.camera.core.impl.UseCaseConfigFactory$Provider
 *  androidx.camera.core.internal.TargetConfig
 *  androidx.camera.core.internal.TargetConfig$Builder
 */
package androidx.camera.core;

import android.os.Handler;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import java.util.UUID;
import java.util.concurrent.Executor;

public static final class CameraXConfig.Builder
implements TargetConfig.Builder<CameraX, CameraXConfig.Builder> {
    private final MutableOptionsBundle mMutableConfig;

    public CameraXConfig.Builder() {
        this(MutableOptionsBundle.create());
    }

    private CameraXConfig.Builder(MutableOptionsBundle object) {
        this.mMutableConfig = object;
        object = (Class)object.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
        if (object != null && !object.equals(CameraX.class)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid target class configuration for ");
            stringBuilder.append(this);
            stringBuilder.append(": ");
            stringBuilder.append(object);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.setTargetClass((Class)CameraX.class);
    }

    public static CameraXConfig.Builder fromConfig(CameraXConfig cameraXConfig) {
        return new CameraXConfig.Builder(MutableOptionsBundle.from((Config)cameraXConfig));
    }

    private MutableConfig getMutableConfig() {
        return this.mMutableConfig;
    }

    public CameraXConfig build() {
        return new CameraXConfig(OptionsBundle.from((Config)this.mMutableConfig));
    }

    public CameraXConfig.Builder setAvailableCamerasLimiter(CameraSelector cameraSelector) {
        this.getMutableConfig().insertOption(CameraXConfig.OPTION_AVAILABLE_CAMERAS_LIMITER, (Object)cameraSelector);
        return this;
    }

    public CameraXConfig.Builder setCameraExecutor(Executor executor) {
        this.getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_EXECUTOR, (Object)executor);
        return this;
    }

    public CameraXConfig.Builder setCameraFactoryProvider(CameraFactory.Provider provider) {
        this.getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_FACTORY_PROVIDER, (Object)provider);
        return this;
    }

    public CameraXConfig.Builder setDeviceSurfaceManagerProvider(CameraDeviceSurfaceManager.Provider provider) {
        this.getMutableConfig().insertOption(CameraXConfig.OPTION_DEVICE_SURFACE_MANAGER_PROVIDER, (Object)provider);
        return this;
    }

    public CameraXConfig.Builder setMinimumLoggingLevel(int n) {
        this.getMutableConfig().insertOption(CameraXConfig.OPTION_MIN_LOGGING_LEVEL, (Object)n);
        return this;
    }

    public CameraXConfig.Builder setSchedulerHandler(Handler handler) {
        this.getMutableConfig().insertOption(CameraXConfig.OPTION_SCHEDULER_HANDLER, (Object)handler);
        return this;
    }

    public CameraXConfig.Builder setTargetClass(Class<CameraX> clazz) {
        this.getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, clazz);
        if (this.getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) != null) return this;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clazz.getCanonicalName());
        stringBuilder.append("-");
        stringBuilder.append(UUID.randomUUID());
        this.setTargetName(stringBuilder.toString());
        return this;
    }

    public CameraXConfig.Builder setTargetName(String string) {
        this.getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, (Object)string);
        return this;
    }

    public CameraXConfig.Builder setUseCaseConfigFactoryProvider(UseCaseConfigFactory.Provider provider) {
        this.getMutableConfig().insertOption(CameraXConfig.OPTION_USECASE_CONFIG_FACTORY_PROVIDER, (Object)provider);
        return this;
    }
}
