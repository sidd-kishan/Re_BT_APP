/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraFilter
 *  androidx.camera.core.impl.CameraConfig
 *  androidx.camera.core.impl.CameraConfig$_CC
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.Config$OptionMatcher
 *  androidx.camera.core.impl.Config$OptionPriority
 *  androidx.camera.core.impl.OptionsBundle
 *  androidx.camera.core.impl.ReadableConfig
 *  androidx.camera.core.impl.ReadableConfig$_CC
 *  androidx.camera.core.impl.UseCaseConfigFactory
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.Set;

static final class CameraConfigs.EmptyCameraConfig
implements CameraConfig {
    private final UseCaseConfigFactory mUseCaseConfigFactory = new /* Unavailable Anonymous Inner Class!! */;

    CameraConfigs.EmptyCameraConfig() {
    }

    public /* synthetic */ boolean containsOption(Config.Option<?> option) {
        return ReadableConfig._CC.$default$containsOption((ReadableConfig)this, option);
    }

    public /* synthetic */ void findOptions(String string, Config.OptionMatcher optionMatcher) {
        ReadableConfig._CC.$default$findOptions((ReadableConfig)this, (String)string, (Config.OptionMatcher)optionMatcher);
    }

    public /* synthetic */ CameraFilter getCameraFilter() {
        return CameraConfig._CC.$default$getCameraFilter((CameraConfig)this);
    }

    public Config getConfig() {
        return OptionsBundle.emptyBundle();
    }

    public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option<?> option) {
        return ReadableConfig._CC.$default$getOptionPriority((ReadableConfig)this, option);
    }

    public /* synthetic */ Set<Config.OptionPriority> getPriorities(Config.Option<?> option) {
        return ReadableConfig._CC.$default$getPriorities((ReadableConfig)this, option);
    }

    public UseCaseConfigFactory getUseCaseConfigFactory() {
        return this.mUseCaseConfigFactory;
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
