/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.camera.core.InitializationException
 *  androidx.camera.core.impl.UseCaseConfigFactory
 */
package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.UseCaseConfigFactory;

public static interface UseCaseConfigFactory.Provider {
    public UseCaseConfigFactory newInstance(Context var1) throws InitializationException;
}
