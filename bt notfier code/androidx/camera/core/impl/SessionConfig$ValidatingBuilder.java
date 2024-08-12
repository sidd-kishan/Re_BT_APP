/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$BaseBuilder
 *  androidx.camera.core.impl.TagBundle
 */
package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.TagBundle;
import java.util.ArrayList;
import java.util.Collection;

public static final class SessionConfig.ValidatingBuilder
extends SessionConfig.BaseBuilder {
    private static final String TAG = "ValidatingBuilder";
    private boolean mTemplateSet = false;
    private boolean mValid = true;

    public void add(SessionConfig sessionConfig) {
        Object object;
        CaptureConfig captureConfig = sessionConfig.getRepeatingCaptureConfig();
        if (captureConfig.getTemplateType() != -1) {
            if (!this.mTemplateSet) {
                this.mCaptureConfigBuilder.setTemplateType(captureConfig.getTemplateType());
                this.mTemplateSet = true;
            } else if (this.mCaptureConfigBuilder.getTemplateType() != captureConfig.getTemplateType()) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Invalid configuration due to template type: ");
                ((StringBuilder)object).append(this.mCaptureConfigBuilder.getTemplateType());
                ((StringBuilder)object).append(" != ");
                ((StringBuilder)object).append(captureConfig.getTemplateType());
                Logger.d((String)TAG, (String)((StringBuilder)object).toString());
                this.mValid = false;
            }
        }
        object = sessionConfig.getRepeatingCaptureConfig().getTagBundle();
        this.mCaptureConfigBuilder.addAllTags((TagBundle)object);
        this.mDeviceStateCallbacks.addAll(sessionConfig.getDeviceStateCallbacks());
        this.mSessionStateCallbacks.addAll(sessionConfig.getSessionStateCallbacks());
        this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks((Collection)sessionConfig.getRepeatingCameraCaptureCallbacks());
        this.mSingleCameraCaptureCallbacks.addAll(sessionConfig.getSingleCameraCaptureCallbacks());
        this.mErrorListeners.addAll(sessionConfig.getErrorListeners());
        this.mSurfaces.addAll(sessionConfig.getSurfaces());
        this.mCaptureConfigBuilder.getSurfaces().addAll(captureConfig.getSurfaces());
        if (!this.mSurfaces.containsAll(this.mCaptureConfigBuilder.getSurfaces())) {
            Logger.d((String)TAG, (String)"Invalid configuration due to capture request surfaces are not a subset of surfaces");
            this.mValid = false;
        }
        this.mCaptureConfigBuilder.addImplementationOptions(captureConfig.getImplementationOptions());
    }

    public SessionConfig build() {
        if (!this.mValid) throw new IllegalArgumentException("Unsupported session configuration combination");
        return new SessionConfig(new ArrayList(this.mSurfaces), this.mDeviceStateCallbacks, this.mSessionStateCallbacks, this.mSingleCameraCaptureCallbacks, this.mErrorListeners, this.mCaptureConfigBuilder.build());
    }

    public boolean isValid() {
        boolean bl = this.mTemplateSet && this.mValid;
        return bl;
    }
}
