/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModel
 */
package androidx.lifecycle;

import androidx.lifecycle.ViewModel;

public static interface ViewModelProvider.Factory {
    public <T extends ViewModel> T create(Class<T> var1);
}
