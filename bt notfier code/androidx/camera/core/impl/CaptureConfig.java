/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CaptureConfig$Builder
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.DeferrableSurface
 *  androidx.camera.core.impl.TagBundle
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.TagBundle;
import java.util.Collections;
import java.util.List;

public final class CaptureConfig {
    public static final Config.Option<Integer> OPTION_JPEG_QUALITY;
    public static final Config.Option<Integer> OPTION_ROTATION;
    final List<CameraCaptureCallback> mCameraCaptureCallbacks;
    final Config mImplementationOptions;
    final List<DeferrableSurface> mSurfaces;
    private final TagBundle mTagBundle;
    final int mTemplateType;
    private final boolean mUseRepeatingSurface;

    static {
        OPTION_ROTATION = Config.Option.create((String)"camerax.core.captureConfig.rotation", Integer.TYPE);
        OPTION_JPEG_QUALITY = Config.Option.create((String)"camerax.core.captureConfig.jpegQuality", Integer.class);
    }

    CaptureConfig(List<DeferrableSurface> list, Config config, int n, List<CameraCaptureCallback> list2, boolean bl, TagBundle tagBundle) {
        this.mSurfaces = list;
        this.mImplementationOptions = config;
        this.mTemplateType = n;
        this.mCameraCaptureCallbacks = Collections.unmodifiableList(list2);
        this.mUseRepeatingSurface = bl;
        this.mTagBundle = tagBundle;
    }

    public static CaptureConfig defaultEmptyCaptureConfig() {
        return new Builder().build();
    }

    public List<CameraCaptureCallback> getCameraCaptureCallbacks() {
        return this.mCameraCaptureCallbacks;
    }

    public Config getImplementationOptions() {
        return this.mImplementationOptions;
    }

    public List<DeferrableSurface> getSurfaces() {
        return Collections.unmodifiableList(this.mSurfaces);
    }

    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    public int getTemplateType() {
        return this.mTemplateType;
    }

    public boolean isUseRepeatingSurface() {
        return this.mUseRepeatingSurface;
    }
}
