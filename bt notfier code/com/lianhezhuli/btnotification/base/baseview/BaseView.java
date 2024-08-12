/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposeConverter
 */
package com.lianhezhuli.btnotification.base.baseview;

import com.uber.autodispose.AutoDisposeConverter;

public interface BaseView {
    public <T> AutoDisposeConverter<T> bindAutoDispose();

    public void hideLoading();

    public void onError(Throwable var1);

    public void showLoading();
}
