/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.OutsideScopeException
 */
package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;

public class LifecycleEndedException
extends OutsideScopeException {
    public LifecycleEndedException() {
        this("Lifecycle has ended!");
    }

    public LifecycleEndedException(String string) {
        super(string);
    }
}
