/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Size
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.UseCase$1
 *  androidx.camera.core.UseCase$State
 *  androidx.camera.core.UseCase$StateChangeCallback
 *  androidx.camera.core.impl.CameraControlInternal
 *  androidx.camera.core.impl.CameraInfoInternal
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.ImageOutputConfig
 *  androidx.camera.core.impl.MutableOptionsBundle
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.UseCaseConfig
 *  androidx.camera.core.impl.UseCaseConfig$Builder
 *  androidx.camera.core.impl.UseCaseConfigFactory
 *  androidx.camera.core.internal.TargetConfig
 *  androidx.camera.core.internal.utils.UseCaseConfigUtil
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.utils.UseCaseConfigUtil;
import androidx.core.util.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public abstract class UseCase {
    private Size mAttachedResolution;
    private SessionConfig mAttachedSessionConfig;
    private CameraInternal mCamera;
    private UseCaseConfig<?> mCameraConfig;
    private final Object mCameraLock;
    private UseCaseConfig<?> mCurrentConfig;
    private UseCaseConfig<?> mExtendedConfig;
    private State mState;
    private final Set<StateChangeCallback> mStateChangeCallbacks = new HashSet<StateChangeCallback>();
    private UseCaseConfig<?> mUseCaseConfig;
    private Rect mViewPortCropRect;

    protected UseCase(UseCaseConfig<?> useCaseConfig) {
        this.mCameraLock = new Object();
        this.mState = State.INACTIVE;
        this.mAttachedSessionConfig = SessionConfig.defaultEmptySessionConfig();
        this.mUseCaseConfig = useCaseConfig;
        this.mCurrentConfig = useCaseConfig;
    }

    private void addStateChangeCallback(StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.add(stateChangeCallback);
    }

    private void removeStateChangeCallback(StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.remove(stateChangeCallback);
    }

    public Size getAttachedSurfaceResolution() {
        return this.mAttachedResolution;
    }

    public CameraInternal getCamera() {
        Object object = this.mCameraLock;
        synchronized (object) {
            CameraInternal cameraInternal = this.mCamera;
            return cameraInternal;
        }
    }

    protected CameraControlInternal getCameraControl() {
        Object object = this.mCameraLock;
        synchronized (object) {
            if (this.mCamera == null) {
                CameraControlInternal cameraControlInternal = CameraControlInternal.DEFAULT_EMPTY_INSTANCE;
                return cameraControlInternal;
            }
            CameraControlInternal cameraControlInternal = this.mCamera.getCameraControlInternal();
            return cameraControlInternal;
        }
    }

    protected String getCameraId() {
        CameraInternal cameraInternal = this.getCamera();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No camera attached to use case: ");
        stringBuilder.append(this);
        return ((CameraInternal)Preconditions.checkNotNull((Object)cameraInternal, (Object)stringBuilder.toString())).getCameraInfoInternal().getCameraId();
    }

    public UseCaseConfig<?> getCurrentConfig() {
        return this.mCurrentConfig;
    }

    public abstract UseCaseConfig<?> getDefaultConfig(boolean var1, UseCaseConfigFactory var2);

    public int getImageFormat() {
        return this.mCurrentConfig.getInputFormat();
    }

    public String getName() {
        UseCaseConfig<?> useCaseConfig = this.mCurrentConfig;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<UnknownUseCase-");
        stringBuilder.append(this.hashCode());
        stringBuilder.append(">");
        return useCaseConfig.getTargetName(stringBuilder.toString());
    }

    protected int getRelativeRotation(CameraInternal cameraInternal) {
        return cameraInternal.getCameraInfoInternal().getSensorRotationDegrees(this.getTargetRotationInternal());
    }

    public SessionConfig getSessionConfig() {
        return this.mAttachedSessionConfig;
    }

    protected int getTargetRotationInternal() {
        return ((ImageOutputConfig)this.mCurrentConfig).getTargetRotation(0);
    }

    public abstract UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config var1);

    public Rect getViewPortCropRect() {
        return this.mViewPortCropRect;
    }

    protected boolean isCurrentCamera(String string) {
        if (this.getCamera() != null) return Objects.equals(string, this.getCameraId());
        return false;
    }

    public UseCaseConfig<?> mergeConfigs(CameraInfoInternal cameraInfoInternal, UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> mutableOptionsBundle) {
        if (mutableOptionsBundle != null) {
            mutableOptionsBundle = MutableOptionsBundle.from(mutableOptionsBundle);
            mutableOptionsBundle.removeOption(TargetConfig.OPTION_TARGET_NAME);
        } else {
            mutableOptionsBundle = MutableOptionsBundle.create();
        }
        for (Config.Option option : this.mUseCaseConfig.listOptions()) {
            mutableOptionsBundle.insertOption(option, this.mUseCaseConfig.getOptionPriority(option), this.mUseCaseConfig.retrieveOption(option));
        }
        if (useCaseConfig != null) {
            for (Config.Option option : useCaseConfig.listOptions()) {
                if (option.getId().equals(TargetConfig.OPTION_TARGET_NAME.getId())) continue;
                mutableOptionsBundle.insertOption(option, useCaseConfig.getOptionPriority(option), useCaseConfig.retrieveOption(option));
            }
        }
        if (!mutableOptionsBundle.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION)) return this.onMergeConfig(cameraInfoInternal, this.getUseCaseConfigBuilder((Config)mutableOptionsBundle));
        if (!mutableOptionsBundle.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO)) return this.onMergeConfig(cameraInfoInternal, this.getUseCaseConfigBuilder((Config)mutableOptionsBundle));
        mutableOptionsBundle.removeOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
        return this.onMergeConfig(cameraInfoInternal, this.getUseCaseConfigBuilder((Config)mutableOptionsBundle));
    }

    protected final void notifyActive() {
        this.mState = State.ACTIVE;
        this.notifyState();
    }

    protected final void notifyInactive() {
        this.mState = State.INACTIVE;
        this.notifyState();
    }

    protected final void notifyReset() {
        Iterator<StateChangeCallback> iterator = this.mStateChangeCallbacks.iterator();
        while (iterator.hasNext()) {
            iterator.next().onUseCaseReset(this);
        }
    }

    public final void notifyState() {
        int n = 1.$SwitchMap$androidx$camera$core$UseCase$State[this.mState.ordinal()];
        if (n != 1) {
            if (n != 2) {
                return;
            }
            Iterator<StateChangeCallback> iterator = this.mStateChangeCallbacks.iterator();
            while (iterator.hasNext()) {
                iterator.next().onUseCaseActive(this);
            }
            return;
        }
        Iterator<StateChangeCallback> iterator = this.mStateChangeCallbacks.iterator();
        while (iterator.hasNext()) {
            iterator.next().onUseCaseInactive(this);
        }
    }

    protected final void notifyUpdated() {
        Iterator<StateChangeCallback> iterator = this.mStateChangeCallbacks.iterator();
        while (iterator.hasNext()) {
            iterator.next().onUseCaseUpdated(this);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onAttach(CameraInternal cameraInternal, UseCaseConfig<?> eventCallback, UseCaseConfig<?> useCaseConfig) {
        Object object = this.mCameraLock;
        synchronized (object) {
            this.mCamera = cameraInternal;
            this.addStateChangeCallback((StateChangeCallback)cameraInternal);
        }
        this.mExtendedConfig = eventCallback;
        this.mCameraConfig = useCaseConfig;
        eventCallback = this.mergeConfigs(cameraInternal.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        this.mCurrentConfig = eventCallback;
        eventCallback = eventCallback.getUseCaseEventCallback(null);
        if (eventCallback != null) {
            eventCallback.onAttach((CameraInfo)cameraInternal.getCameraInfoInternal());
        }
        this.onAttached();
    }

    public void onAttached() {
    }

    protected void onCameraControlReady() {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onDetach(CameraInternal cameraInternal) {
        this.onDetached();
        Object object = this.mCurrentConfig.getUseCaseEventCallback(null);
        if (object != null) {
            object.onDetach();
        }
        object = this.mCameraLock;
        synchronized (object) {
            boolean bl = cameraInternal == this.mCamera;
            Preconditions.checkArgument((boolean)bl);
            this.removeStateChangeCallback((StateChangeCallback)this.mCamera);
            this.mCamera = null;
        }
        this.mAttachedResolution = null;
        this.mViewPortCropRect = null;
        this.mCurrentConfig = this.mUseCaseConfig;
        this.mExtendedConfig = null;
        this.mCameraConfig = null;
    }

    public void onDetached() {
    }

    protected UseCaseConfig<?> onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder<?, ?, ?> builder) {
        return builder.getUseCaseConfig();
    }

    public void onStateAttached() {
        this.onCameraControlReady();
    }

    public void onStateDetached() {
    }

    protected abstract Size onSuggestedResolutionUpdated(Size var1);

    protected boolean setTargetRotationInternal(int n) {
        int n2 = ((ImageOutputConfig)this.getCurrentConfig()).getTargetRotation(-1);
        if (n2 != -1) {
            if (n2 == n) return false;
        }
        CameraInternal cameraInternal = this.getUseCaseConfigBuilder((Config)this.mUseCaseConfig);
        UseCaseConfigUtil.updateTargetRotationAndRelatedConfigs(cameraInternal, (int)n);
        this.mUseCaseConfig = cameraInternal.getUseCaseConfig();
        cameraInternal = this.getCamera();
        this.mCurrentConfig = cameraInternal == null ? this.mUseCaseConfig : this.mergeConfigs(cameraInternal.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        return true;
    }

    public void setViewPortCropRect(Rect rect) {
        this.mViewPortCropRect = rect;
    }

    protected void updateSessionConfig(SessionConfig sessionConfig) {
        this.mAttachedSessionConfig = sessionConfig;
    }

    public void updateSuggestedResolution(Size size) {
        this.mAttachedResolution = this.onSuggestedResolutionUpdated(size);
    }
}
