/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.base.basepresenter.BasePresenter
 *  com.lianhezhuli.btnotification.base.baseview.BaseView
 *  com.lianhezhuli.btnotification.function.home.activity.mvp.MainContract$Model
 *  com.lianhezhuli.btnotification.function.home.activity.mvp.MainContract$Presenter
 *  com.lianhezhuli.btnotification.function.home.activity.mvp.MainContract$View
 *  com.lianhezhuli.btnotification.function.home.activity.mvp.main.MainModel
 */
package com.lianhezhuli.btnotification.function.home.activity.mvp.main;

import com.lianhezhuli.btnotification.base.basepresenter.BasePresenter;
import com.lianhezhuli.btnotification.base.baseview.BaseView;
import com.lianhezhuli.btnotification.function.home.activity.mvp.MainContract;
import com.lianhezhuli.btnotification.function.home.activity.mvp.main.MainModel;

public class MainPresenter
extends BasePresenter<MainContract.View>
implements MainContract.Presenter {
    private MainContract.Model model;

    public MainPresenter(MainContract.View view) {
        this.attachView((BaseView)view);
        this.model = new MainModel();
    }

    public void getData() {
    }
}
