/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.base.baseview.BaseView
 */
package com.lianhezhuli.btnotification.base.basepresenter;

import com.lianhezhuli.btnotification.base.baseview.BaseView;

public class BasePresenter<V extends BaseView> {
    protected V mView;

    public void attachView(V v) {
        this.mView = v;
    }

    public void detachView() {
        this.mView = null;
    }

    public boolean isViewAttached() {
        boolean bl = this.mView != null;
        return bl;
    }
}
