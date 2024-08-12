/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.uber.autodispose.ScopeProvider
 *  com.uber.autodispose.android.DetachEventCompletable
 *  io.reactivex.CompletableSource
 */
package com.uber.autodispose.android;

import android.view.View;
import com.uber.autodispose.ScopeProvider;
import com.uber.autodispose.android.DetachEventCompletable;
import io.reactivex.CompletableSource;

public final class ViewScopeProvider
implements ScopeProvider {
    private final View view;

    private ViewScopeProvider(View view) {
        this.view = view;
    }

    public static ScopeProvider from(View view) {
        if (view == null) throw new NullPointerException("view == null");
        return new ViewScopeProvider(view);
    }

    public CompletableSource requestScope() {
        return new DetachEventCompletable(this.view);
    }
}
