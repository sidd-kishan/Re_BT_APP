/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.OutsideScopeException
 */
package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;

public class LifecycleNotStartedException
extends OutsideScopeException {
    public LifecycleNotStartedException() {
        this("Lifecycle hasn't started!");
    }

    public LifecycleNotStartedException(String string) {
        super(string);
    }
}
