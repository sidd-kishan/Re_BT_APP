/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.base.basepresenter.BasePresenter
 *  com.lianhezhuli.btnotification.base.baseview.BaseView
 *  com.lianhezhuli.btnotification.function.setting.mvp.SettingContract$Model
 *  com.lianhezhuli.btnotification.function.setting.mvp.SettingContract$Presenter
 *  com.lianhezhuli.btnotification.function.setting.mvp.SettingContract$View
 *  com.lianhezhuli.btnotification.function.setting.mvp.setting.SettingModel
 */
package com.lianhezhuli.btnotification.function.setting.mvp.setting;

import com.lianhezhuli.btnotification.base.basepresenter.BasePresenter;
import com.lianhezhuli.btnotification.base.baseview.BaseView;
import com.lianhezhuli.btnotification.function.setting.mvp.SettingContract;
import com.lianhezhuli.btnotification.function.setting.mvp.setting.SettingModel;

public class SettingPresenter
extends BasePresenter<SettingContract.View>
implements SettingContract.Presenter {
    private SettingContract.Model model;

    public SettingPresenter(SettingContract.View view) {
        this.attachView((BaseView)view);
        this.model = new SettingModel();
    }
}
