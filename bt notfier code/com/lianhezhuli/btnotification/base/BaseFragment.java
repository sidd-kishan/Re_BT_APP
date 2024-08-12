/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.fragment.app.Fragment
 *  butterknife.ButterKnife
 *  com.lianhezhuli.btnotification.base.BaseActivity
 */
package com.lianhezhuli.btnotification.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import com.lianhezhuli.btnotification.base.BaseActivity;

public abstract class BaseFragment
extends Fragment {
    protected final String TAG = ((Object)((Object)this)).getClass().getSimpleName();
    private boolean hasLoaded = false;
    private boolean isCreated = false;
    private boolean isVisibleToUser = false;
    protected BaseActivity mActivity;
    private View rootView;

    private void lazyLoad() {
        if (!this.isVisibleToUser) return;
        if (this.hasLoaded) return;
        if (!this.isCreated) return;
        this.hasLoaded = true;
        this.loadData();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected void loadData() {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (BaseActivity)context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.rootView != null) return this.rootView;
        layoutInflater = layoutInflater.inflate(this.getLayoutId(), viewGroup, false);
        this.rootView = layoutInflater;
        ButterKnife.bind((Object)((Object)this), (View)layoutInflater);
        this.initView();
        this.isCreated = true;
        this.lazyLoad();
        return this.rootView;
    }

    public void onDestroyView() {
        this.isCreated = false;
        this.hasLoaded = false;
        super.onDestroyView();
    }

    public void setUserVisibleHint(boolean bl) {
        this.isVisibleToUser = bl;
        this.lazyLoad();
    }
}
