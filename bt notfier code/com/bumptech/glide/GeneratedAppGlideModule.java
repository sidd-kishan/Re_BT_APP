/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.manager.RequestManagerRetriever$RequestManagerFactory
 *  com.bumptech.glide.module.AppGlideModule
 */
package com.bumptech.glide;

import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import java.util.Set;

abstract class GeneratedAppGlideModule
extends AppGlideModule {
    GeneratedAppGlideModule() {
    }

    abstract Set<Class<?>> getExcludedModuleClasses();

    RequestManagerRetriever.RequestManagerFactory getRequestManagerFactory() {
        return null;
    }
}
