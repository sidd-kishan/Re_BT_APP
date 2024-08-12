/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.CaptureConfig$OptionUnpacker
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.DeferrableSurface
 *  androidx.camera.core.impl.MultiValueSet
 *  androidx.camera.core.impl.MutableConfig
 *  androidx.camera.core.impl.MutableOptionsBundle
 *  androidx.camera.core.impl.MutableTagBundle
 *  androidx.camera.core.impl.OptionsBundle
 *  androidx.camera.core.impl.TagBundle
 *  androidx.camera.core.impl.UseCaseConfig
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.MultiValueSet;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.MutableTagBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public static final class CaptureConfig.Builder {
    private List<CameraCaptureCallback> mCameraCaptureCallbacks;
    private MutableConfig mImplementationOptions;
    private MutableTagBundle mMutableTagBundle;
    private final Set<DeferrableSurface> mSurfaces = new HashSet<DeferrableSurface>();
    private int mTemplateType = -1;
    private boolean mUseRepeatingSurface = false;

    public CaptureConfig.Builder() {
        this.mImplementationOptions = MutableOptionsBundle.create();
        this.mCameraCaptureCallbacks = new ArrayList<CameraCaptureCallback>();
        this.mMutableTagBundle = MutableTagBundle.create();
    }

    private CaptureConfig.Builder(CaptureConfig captureConfig) {
        this.mImplementationOptions = MutableOptionsBundle.create();
        this.mCameraCaptureCallbacks = new ArrayList<CameraCaptureCallback>();
        this.mMutableTagBundle = MutableTagBundle.create();
        this.mSurfaces.addAll(captureConfig.mSurfaces);
        this.mImplementationOptions = MutableOptionsBundle.from((Config)captureConfig.mImplementationOptions);
        this.mTemplateType = captureConfig.mTemplateType;
        this.mCameraCaptureCallbacks.addAll(captureConfig.getCameraCaptureCallbacks());
        this.mUseRepeatingSurface = captureConfig.isUseRepeatingSurface();
        this.mMutableTagBundle = MutableTagBundle.from((TagBundle)captureConfig.getTagBundle());
    }

    public static CaptureConfig.Builder createFrom(UseCaseConfig<?> useCaseConfig) {
        CaptureConfig.OptionUnpacker optionUnpacker = useCaseConfig.getCaptureOptionUnpacker(null);
        if (optionUnpacker != null) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            optionUnpacker.unpack(useCaseConfig, builder);
            return builder;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Implementation is missing option unpacker for ");
        stringBuilder.append(useCaseConfig.getTargetName(useCaseConfig.toString()));
        throw new IllegalStateException(stringBuilder.toString());
    }

    public static CaptureConfig.Builder from(CaptureConfig captureConfig) {
        return new CaptureConfig.Builder(captureConfig);
    }

    public void addAllCameraCaptureCallbacks(Collection<CameraCaptureCallback> object) {
        object = object.iterator();
        while (object.hasNext()) {
            this.addCameraCaptureCallback((CameraCaptureCallback)object.next());
        }
    }

    public void addAllTags(TagBundle tagBundle) {
        this.mMutableTagBundle.addTagBundle(tagBundle);
    }

    public void addCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        if (this.mCameraCaptureCallbacks.contains(cameraCaptureCallback)) throw new IllegalArgumentException("duplicate camera capture callback");
        this.mCameraCaptureCallbacks.add(cameraCaptureCallback);
    }

    public <T> void addImplementationOption(Config.Option<T> option, T t) {
        this.mImplementationOptions.insertOption(option, t);
    }

    public void addImplementationOptions(Config config) {
        Iterator iterator = config.listOptions().iterator();
        while (iterator.hasNext()) {
            Config.Option option = (Config.Option)iterator.next();
            Object object = this.mImplementationOptions.retrieveOption(option, null);
            Object object2 = config.retrieveOption(option);
            if (object instanceof MultiValueSet) {
                ((MultiValueSet)object).addAll(((MultiValueSet)object2).getAllItems());
                continue;
            }
            object = object2;
            if (object2 instanceof MultiValueSet) {
                object = ((MultiValueSet)object2).clone();
            }
            this.mImplementationOptions.insertOption(option, config.getOptionPriority(option), object);
        }
    }

    public void addSurface(DeferrableSurface deferrableSurface) {
        this.mSurfaces.add(deferrableSurface);
    }

    public void addTag(String string, Integer n) {
        this.mMutableTagBundle.putTag(string, n);
    }

    public CaptureConfig build() {
        return new CaptureConfig(new ArrayList<DeferrableSurface>(this.mSurfaces), (Config)OptionsBundle.from((Config)this.mImplementationOptions), this.mTemplateType, this.mCameraCaptureCallbacks, this.mUseRepeatingSurface, TagBundle.from((TagBundle)this.mMutableTagBundle));
    }

    public void clearSurfaces() {
        this.mSurfaces.clear();
    }

    public Config getImplementationOptions() {
        return this.mImplementationOptions;
    }

    public Set<DeferrableSurface> getSurfaces() {
        return this.mSurfaces;
    }

    public Integer getTag(String string) {
        return this.mMutableTagBundle.getTag(string);
    }

    public int getTemplateType() {
        return this.mTemplateType;
    }

    boolean isUseRepeatingSurface() {
        return this.mUseRepeatingSurface;
    }

    public void removeSurface(DeferrableSurface deferrableSurface) {
        this.mSurfaces.remove(deferrableSurface);
    }

    public void setImplementationOptions(Config config) {
        this.mImplementationOptions = MutableOptionsBundle.from((Config)config);
    }

    public void setTemplateType(int n) {
        this.mTemplateType = n;
    }

    public void setUseRepeatingSurface(boolean bl) {
        this.mUseRepeatingSurface = bl;
    }
}
