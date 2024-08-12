/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.UseCase$EventCallback
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.ReadableConfig
 */
package androidx.camera.core.internal;

import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;

public interface UseCaseEventConfig
extends ReadableConfig {
    public static final Config.Option<UseCase.EventCallback> OPTION_USE_CASE_EVENT_CALLBACK = Config.Option.create((String)"camerax.core.useCaseEventCallback", UseCase.EventCallback.class);

    public UseCase.EventCallback getUseCaseEventCallback();

    public UseCase.EventCallback getUseCaseEventCallback(UseCase.EventCallback var1);
}
