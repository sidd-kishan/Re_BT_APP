/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.UseCase$EventCallback
 *  androidx.camera.core.internal.UseCaseEventConfig
 */
package androidx.camera.core.internal;

import androidx.camera.core.UseCase;
import androidx.camera.core.internal.UseCaseEventConfig;

public final class UseCaseEventConfig$_CC {
    public static UseCase.EventCallback $default$getUseCaseEventCallback(UseCaseEventConfig useCaseEventConfig) {
        return (UseCase.EventCallback)useCaseEventConfig.retrieveOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK);
    }

    public static UseCase.EventCallback $default$getUseCaseEventCallback(UseCaseEventConfig useCaseEventConfig, UseCase.EventCallback eventCallback) {
        return (UseCase.EventCallback)useCaseEventConfig.retrieveOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, (Object)eventCallback);
    }
}
