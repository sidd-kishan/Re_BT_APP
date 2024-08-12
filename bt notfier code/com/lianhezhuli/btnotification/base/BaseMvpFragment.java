/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleOwner
 *  com.lianhezhuli.btnotification.base.BaseFragment
 *  com.lianhezhuli.btnotification.base.basepresenter.BasePresenter
 *  com.lianhezhuli.btnotification.base.baseview.BaseView
 *  com.uber.autodispose.AutoDispose
 *  com.uber.autodispose.AutoDisposeConverter
 *  com.uber.autodispose.ScopeProvider
 *  com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
 */
package com.lianhezhuli.btnotification.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.lianhezhuli.btnotification.base.BaseFragment;
import com.lianhezhuli.btnotification.base.basepresenter.BasePresenter;
import com.lianhezhuli.btnotification.base.baseview.BaseView;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.ScopeProvider;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

public abstract class BaseMvpFragment<P extends BasePresenter>
extends BaseFragment
implements BaseView {
    protected P mPresenter;

    public <T> AutoDisposeConverter<T> bindAutoDispose() {
        return AutoDispose.autoDisposable((ScopeProvider)AndroidLifecycleScopeProvider.from((LifecycleOwner)this, (Lifecycle.Event)Lifecycle.Event.ON_DESTROY));
    }

    public void onDestroyView() {
        P p = this.mPresenter;
        if (p != null) {
            p.detachView();
        }
        super.onDestroyView();
    }
}
