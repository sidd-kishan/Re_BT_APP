/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.OnBackPressedDispatcher
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.activity;

import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.LifecycleOwner;

public interface OnBackPressedDispatcherOwner
extends LifecycleOwner {
    public OnBackPressedDispatcher getOnBackPressedDispatcher();
}
