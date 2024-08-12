/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.view.KeyEvent
 *  android.view.View
 *  android.widget.RadioGroup
 *  androidx.core.app.ActivityCompat
 *  androidx.core.content.ContextCompat
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentTransaction
 *  butterknife.BindView
 *  butterknife.OnClick
 *  com.lianhezhuli.btnotification.Constants
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.base.BaseMvpActivity
 *  com.lianhezhuli.btnotification.bean.UserInfoBean
 *  com.lianhezhuli.btnotification.event.DeviceFirstConnectEvent
 *  com.lianhezhuli.btnotification.event.FindPhoneEvent
 *  com.lianhezhuli.btnotification.function.device.remotecamera.RemoteCamera
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$2OawYmpGLATDGcZutwLU8Bn_H9M
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$49y51iKF90yKKpc_nIV6QSQ3X_c
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$6HYASvQnOs6TFCk27J_kZlZWx3s
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$CmYX62_QG1_DDXVWGZm1_qMdlP8
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$LxLPzJdQEFJGS1u_Y7FGdRrgdHI
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$MwlseDe2xXbBOy9xffmhCH_nLec
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$NhgtUIs6a4fg40PrsOIY0OI4Atc
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$QPXOqk7FDmE2YgZkxNxiJLDx9P0
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$V2ldtsOEUWK8VVwbyuXyNWGkbRw
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$W5wKf3lCnVLkjrZpCWAkyd3z7n0
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$WxXInOXBnpxb1HskZqgdH5CAgcQ
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$_TYb0Q_VV_jjZNEwI4WC8WhC1Z0
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$g5bfuEMHWMZawM3sCKPXJeRjJ3Y
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$guRbjlfln9BWqfhemXL4qcOLeB8
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$jL2zNzgCyO4KJOLMZylofDQ5mIs
 *  com.lianhezhuli.btnotification.function.home.activity._$$Lambda$MainActivity$krgyF4AIPeQ27qq7l4dib0wyMcc
 *  com.lianhezhuli.btnotification.function.home.activity.mvp.MainContract$View
 *  com.lianhezhuli.btnotification.function.home.activity.mvp.main.MainPresenter
 *  com.lianhezhuli.btnotification.function.home.fragment.DataFragment
 *  com.lianhezhuli.btnotification.function.home.fragment.MineFragment
 *  com.lianhezhuli.btnotification.function.home.fragment.SportFragment
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.lianhezhuli.btnotification.mtk.service.NPNotificationService
 *  com.lianhezhuli.btnotification.mtk.service.PushAiderHelper
 *  com.lianhezhuli.btnotification.network.NetWorkManager
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean
 *  com.lianhezhuli.btnotification.network.bean.AnonymousLoginBean
 *  com.lianhezhuli.btnotification.network.bean.LoginBean
 *  com.lianhezhuli.btnotification.network.exception.ApiException
 *  com.lianhezhuli.btnotification.utils.NotificationMsgUtil
 *  com.lianhezhuli.btnotification.utils.SignUtils
 *  com.lianhezhuli.btnotification.utils.SoundPlayUtil
 *  com.lianhezhuli.btnotification.utils.SpUtils
 *  com.lianhezhuli.btnotification.utils.StringUtils
 *  com.lianhezhuli.btnotification.utils.ToastUtils
 *  com.orhanobut.logger.Logger
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MessageDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogAction$ActionListener
 *  io.reactivex.Observable
 *  io.reactivex.functions.Consumer
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package com.lianhezhuli.btnotification.function.home.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioGroup;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.OnClick;
import com.lianhezhuli.btnotification.Constants;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.base.BaseMvpActivity;
import com.lianhezhuli.btnotification.bean.UserInfoBean;
import com.lianhezhuli.btnotification.event.DeviceFirstConnectEvent;
import com.lianhezhuli.btnotification.event.FindPhoneEvent;
import com.lianhezhuli.btnotification.function.device.remotecamera.RemoteCamera;
import com.lianhezhuli.btnotification.function.home.activity._$;
import com.lianhezhuli.btnotification.function.home.activity.mvp.MainContract;
import com.lianhezhuli.btnotification.function.home.activity.mvp.main.MainPresenter;
import com.lianhezhuli.btnotification.function.home.fragment.DataFragment;
import com.lianhezhuli.btnotification.function.home.fragment.MineFragment;
import com.lianhezhuli.btnotification.function.home.fragment.SportFragment;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.lianhezhuli.btnotification.mtk.service.NPNotificationService;
import com.lianhezhuli.btnotification.mtk.service.PushAiderHelper;
import com.lianhezhuli.btnotification.network.NetWorkManager;
import com.lianhezhuli.btnotification.network.bean.AdvertConfigBean;
import com.lianhezhuli.btnotification.network.bean.AnonymousLoginBean;
import com.lianhezhuli.btnotification.network.bean.LoginBean;
import com.lianhezhuli.btnotification.network.exception.ApiException;
import com.lianhezhuli.btnotification.utils.NotificationMsgUtil;
import com.lianhezhuli.btnotification.utils.SignUtils;
import com.lianhezhuli.btnotification.utils.SoundPlayUtil;
import com.lianhezhuli.btnotification.utils.SpUtils;
import com.lianhezhuli.btnotification.utils.StringUtils;
import com.lianhezhuli.btnotification.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity
extends BaseMvpActivity<MainPresenter>
implements MainContract.View {
    public static final String ACTION_OPEN_CAMERA = "action_open_camera";
    private DataFragment dataFragment;
    private QMUIDialog mFindPhoneDialog;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private MineFragment mineFragment;
    @BindView(value=2131296583)
    RadioGroup navigatorRg;
    private SportFragment sportFragment;
    private FragmentTransaction transaction;

    private void getAdvertConfig() {
        Map map = Constants.getPubQueryMap();
        map.put("config_id", "0");
        map.put("bundle_id", "6");
        map.put("sign", SignUtils.getSign((Map)map, (boolean)true));
        NetWorkManager.toSubscribe((Observable)NetWorkManager.getRequest().getAdvertConfig(map), (Consumer)_$.Lambda.MainActivity._TYb0Q_VV_jjZNEwI4WC8WhC1Z0.INSTANCE, (Consumer)_$.Lambda.MainActivity.krgyF4AIPeQ27qq7l4dib0wyMcc.INSTANCE);
    }

    private void hideAll() {
        this.transaction.hide((Fragment)this.sportFragment);
        this.transaction.hide((Fragment)this.dataFragment);
        this.transaction.hide((Fragment)this.mineFragment);
    }

    static /* synthetic */ void lambda$deviceFirstConnect$6(String string) throws Exception {
    }

    static /* synthetic */ void lambda$deviceFirstConnect$7(Throwable throwable) throws Exception {
    }

    static /* synthetic */ void lambda$getAdvertConfig$14(AdvertConfigBean advertConfigBean) throws Exception {
        MApplication.getInstance().setAdvertConfigBean(advertConfigBean);
        if (advertConfigBean == null) return;
        if (advertConfigBean.getConfig_item() == null) return;
        MApplication.getInstance().setShowAd(true);
    }

    static /* synthetic */ void lambda$getAdvertConfig$15(Throwable serializable) throws Exception {
        ApiException apiException = (ApiException)serializable;
        if ("no_login".equalsIgnoreCase(apiException.getCode())) {
            SpUtils.saveData((String)"anonymous_last_login_time", (Object)0L);
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("exception: ");
        ((StringBuilder)serializable).append(apiException.getCode());
        Logger.w((String)((StringBuilder)serializable).toString(), (Object[])new Object[0]);
    }

    static /* synthetic */ void lambda$initView$0(QMUIDialog qMUIDialog, int n) {
        qMUIDialog.dismiss();
    }

    static /* synthetic */ void lambda$initView$1(QMUIDialog qMUIDialog, int n) {
        PushAiderHelper.getAiderHelper().goToSettingNotificationAccess((Context)MApplication.getInstance());
        qMUIDialog.dismiss();
    }

    static /* synthetic */ void lambda$initView$2(QMUIDialog qMUIDialog, int n) {
        qMUIDialog.dismiss();
    }

    static /* synthetic */ void lambda$initView$3(QMUIDialog qMUIDialog, int n) {
        PushAiderHelper.getAiderHelper().goToSettingNotificationAccess((Context)MApplication.getInstance());
        qMUIDialog.dismiss();
    }

    static /* synthetic */ void lambda$initView$5(QMUIDialog qMUIDialog, int n) {
        qMUIDialog.dismiss();
        SoundPlayUtil.getLostPlayUtil().stop();
    }

    static /* synthetic */ void lambda$login$11(Throwable throwable) throws Exception {
    }

    static /* synthetic */ void lambda$login$13(Throwable throwable) throws Exception {
    }

    static /* synthetic */ void lambda$login$9(Throwable throwable) throws Exception {
    }

    private void login() {
        String string = (String)SpUtils.getData((String)"anonymous_account", (Object)"");
        String string2 = (String)SpUtils.getData((String)"anonymous_password", (Object)"");
        if (!TextUtils.isEmpty((CharSequence)string) && !TextUtils.isEmpty((CharSequence)string2)) {
            long l = (Long)SpUtils.getData((String)"anonymous_last_login_time", (Object)0L);
            int n = (Integer)SpUtils.getData((String)"anonymous_login_expire_time", (Object)0);
            if (l == 0L) {
                Map map = Constants.getPubQueryMap();
                map.put("account", string);
                map.put("password", StringUtils.md5Encode32((String)string2));
                map.put("sign", SignUtils.getSign((Map)map, (boolean)false));
                NetWorkManager.toSubscribe((Observable)NetWorkManager.getRequest().postLogin(map), (Consumer)new _$.Lambda.MainActivity.W5wKf3lCnVLkjrZpCWAkyd3z7n0(this), (Consumer)_$.Lambda.MainActivity.49y51iKF90yKKpc_nIV6QSQ3X_c.INSTANCE);
            } else if (System.currentTimeMillis() / 1000L > l / 1000L + (long)(n / 2)) {
                Map map = Constants.getPubQueryMap();
                map.put("sign", SignUtils.getSign((Map)map, (boolean)true));
                NetWorkManager.toSubscribe((Observable)NetWorkManager.getRequest().postLoginRenew(map), (Consumer)new _$.Lambda.MainActivity.guRbjlfln9BWqfhemXL4qcOLeB8(this), (Consumer)_$.Lambda.MainActivity.LxLPzJdQEFJGS1u_Y7FGdRrgdHI.INSTANCE);
            } else {
                this.getAdvertConfig();
            }
        } else {
            Map map = Constants.getPubQueryMap();
            map.put("pid", "");
            map.put("sign", SignUtils.getSign((Map)map, (boolean)false));
            NetWorkManager.toSubscribe((Observable)NetWorkManager.getRequest().postAnonymousLogin(map), (Consumer)new _$.Lambda.MainActivity.WxXInOXBnpxb1HskZqgdH5CAgcQ(this), (Consumer)_$.Lambda.MainActivity.g5bfuEMHWMZawM3sCKPXJeRjJ3Y.INSTANCE);
        }
    }

    private void openCameraActivity() {
        Intent intent = new Intent();
        intent.setFlags(0x10000000);
        intent.setClass((Context)this, RemoteCamera.class);
        this.startActivity(intent);
    }

    @OnClick(value={2131296586, 2131296585, 2131296587})
    public void click(View view) {
        this.transaction = this.getSupportFragmentManager().beginTransaction();
        this.hideAll();
        switch (view.getId()) {
            default: {
                break;
            }
            case 2131296587: {
                this.navigatorRg.check(2131296587);
                this.transaction.show((Fragment)this.mineFragment);
                break;
            }
            case 2131296586: {
                this.navigatorRg.check(2131296586);
                this.transaction.show((Fragment)this.sportFragment);
                break;
            }
            case 2131296585: {
                this.navigatorRg.check(2131296585);
                this.transaction.show((Fragment)this.dataFragment);
            }
        }
        this.transaction.commitAllowingStateLoss();
    }

    @Subscribe
    public void deviceFirstConnect(DeviceFirstConnectEvent deviceFirstConnectEvent) {
        Map map = Constants.getPubQueryMap();
        map.put("mac", deviceFirstConnectEvent.getMac());
        map.put("model", deviceFirstConnectEvent.getName());
        map.put("name", deviceFirstConnectEvent.getName());
        map.put("sign", SignUtils.getSign((Map)map, (boolean)true));
        NetWorkManager.toSubscribe((Observable)NetWorkManager.getRequest().postBindMac(map), (Consumer)_$.Lambda.MainActivity.jL2zNzgCyO4KJOLMZylofDQ5mIs.INSTANCE, (Consumer)_$.Lambda.MainActivity.6HYASvQnOs6TFCk27J_kZlZWx3s.INSTANCE);
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void findPhoneSuccess(FindPhoneEvent findPhoneEvent) {
        if ("stop".equals(findPhoneEvent.getCommand())) {
            SoundPlayUtil.getLostPlayUtil().stop();
            if (this.mFindPhoneDialog.isShowing()) {
                this.mFindPhoneDialog.dismiss();
            }
        }
        if (!"look".equals(findPhoneEvent.getCommand())) return;
        SoundPlayUtil.getLostPlayUtil().play();
        if (!this.mFindPhoneDialog.isShowing()) {
            this.mFindPhoneDialog.show();
        }
        MainService.getInstance().sendPhoneData("0006success");
    }

    public void hideLoading() {
    }

    protected void initView() {
        UserInfoBean userInfoBean;
        this.mPresenter = new MainPresenter((MainContract.View)this);
        EventBus.getDefault().register((Object)this);
        if ((UserInfoBean)SpUtils.getShareData((String)"user_info", UserInfoBean.class) == null) {
            userInfoBean = new UserInfoBean();
            userInfoBean.setBirth("");
            userInfoBean.setSex(1);
            userInfoBean.setHeight("170");
            userInfoBean.setWeight("50");
            SpUtils.saveJsonData((String)"user_info", (Object)userInfoBean);
        }
        if (!PushAiderHelper.getAiderHelper().isNotifyEnable((Context)MApplication.getInstance())) {
            userInfoBean = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder((Context)this).setTitle(2131755083)).setMessage(2131755117).addAction(2131755050, (QMUIDialogAction.ActionListener)_$.Lambda.MainActivity.NhgtUIs6a4fg40PrsOIY0OI4Atc.INSTANCE)).addAction(2131755116, (QMUIDialogAction.ActionListener)_$.Lambda.MainActivity.V2ldtsOEUWK8VVwbyuXyNWGkbRw.INSTANCE)).create();
            userInfoBean.setCancelable(false);
            userInfoBean.show();
        } else {
            this.mHandler.postDelayed((Runnable)new _$.Lambda.MainActivity.MwlseDe2xXbBOy9xffmhCH_nLec(this), 100000L);
        }
        userInfoBean = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder((Context)this).setTitle(this.getString(2131755051))).addAction((CharSequence)this.getString(2131755116), (QMUIDialogAction.ActionListener)_$.Lambda.MainActivity.2OawYmpGLATDGcZutwLU8Bn_H9M.INSTANCE)).create();
        this.mFindPhoneDialog = userInfoBean;
        userInfoBean.setCancelable(false);
        this.login();
    }

    public /* synthetic */ void lambda$initView$4$MainActivity() {
        if (NotificationMsgUtil.isServiceExisted((Context)this, NPNotificationService.class)) return;
        QMUIDialog qMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder((Context)this).setTitle(2131755083)).setMessage(2131755118).addAction(2131755050, (QMUIDialogAction.ActionListener)_$.Lambda.MainActivity.CmYX62_QG1_DDXVWGZm1_qMdlP8.INSTANCE)).addAction(2131755116, (QMUIDialogAction.ActionListener)_$.Lambda.MainActivity.QPXOqk7FDmE2YgZkxNxiJLDx9P0.INSTANCE)).create();
        qMUIDialog.setCancelable(false);
        qMUIDialog.show();
    }

    public /* synthetic */ void lambda$login$10$MainActivity(AnonymousLoginBean anonymousLoginBean) throws Exception {
        SpUtils.saveData((String)"anonymous_auth_code", (Object)anonymousLoginBean.getAuthcode());
        SpUtils.saveData((String)"anonymous_user_id", (Object)anonymousLoginBean.getUid());
        SpUtils.saveData((String)"anonymous_last_login_time", (Object)System.currentTimeMillis());
        SpUtils.saveData((String)"anonymous_login_expire_time", (Object)anonymousLoginBean.getExpires_in());
        this.getAdvertConfig();
    }

    public /* synthetic */ void lambda$login$12$MainActivity(LoginBean loginBean) throws Exception {
        SpUtils.saveData((String)"anonymous_auth_code", (Object)loginBean.getAuthcode());
        SpUtils.saveData((String)"anonymous_user_id", (Object)loginBean.getUid());
        SpUtils.saveData((String)"anonymous_last_login_time", (Object)System.currentTimeMillis());
        SpUtils.saveData((String)"anonymous_login_expire_time", (Object)loginBean.getExpires_in());
        this.getAdvertConfig();
    }

    public /* synthetic */ void lambda$login$8$MainActivity(AnonymousLoginBean anonymousLoginBean) throws Exception {
        SpUtils.saveData((String)"anonymous_account", (Object)anonymousLoginBean.getAccount());
        SpUtils.saveData((String)"anonymous_password", (Object)anonymousLoginBean.getPassword());
        SpUtils.saveData((String)"anonymous_auth_code", (Object)anonymousLoginBean.getAuthcode());
        SpUtils.saveData((String)"anonymous_user_id", (Object)anonymousLoginBean.getUid());
        SpUtils.saveData((String)"anonymous_last_login_time", (Object)System.currentTimeMillis());
        SpUtils.saveData((String)"anonymous_login_expire_time", (Object)anonymousLoginBean.getExpires_in());
        this.getAdvertConfig();
    }

    protected void onCreateMap(Bundle bundle) {
        super.onCreateMap(bundle);
        this.transaction = this.getSupportFragmentManager().beginTransaction();
        if (bundle == null) {
            this.sportFragment = new SportFragment();
            this.dataFragment = new DataFragment();
            this.mineFragment = new MineFragment();
        } else {
            if (this.sportFragment == null) {
                this.sportFragment = new SportFragment();
            }
            if (this.dataFragment == null) {
                this.dataFragment = new DataFragment();
            }
            if (this.mineFragment == null) {
                this.mineFragment = new MineFragment();
            }
        }
        this.transaction.add(2131296584, (Fragment)this.sportFragment, "sportFragment");
        this.transaction.add(2131296584, (Fragment)this.dataFragment, "dataFragment");
        this.transaction.add(2131296584, (Fragment)this.mineFragment, "mineFragment");
        this.hideAll();
        this.transaction.show((Fragment)this.sportFragment);
        this.transaction.commitAllowingStateLoss();
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister((Object)this);
    }

    public void onError(Throwable throwable) {
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        boolean bl = this.isExit(n) || super.onKeyDown(n, keyEvent);
        return bl;
    }

    public void onRequestPermissionsResult(int n, String[] stringArray, int[] nArray) {
        super.onRequestPermissionsResult(n, stringArray, nArray);
        if (n != 101) return;
        n = 0;
        while (n < stringArray.length) {
            if (nArray[n] != 0) {
                ToastUtils.showLong((Context)MApplication.getInstance(), (int)2131755124);
            } else {
                this.openCameraActivity();
            }
            ++n;
        }
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void openCamera(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return;
        }
        if (!string.equals(ACTION_OPEN_CAMERA)) return;
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission((Context)this, (String)"android.permission.CAMERA") != 0) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity)this, (String)"android.permission.CAMERA")) {
                    ToastUtils.showLong((Context)MApplication.getInstance(), (int)2131755124);
                } else {
                    ActivityCompat.requestPermissions((Activity)this, (String[])new String[]{"android.permission.CAMERA"}, (int)101);
                }
            } else {
                this.openCameraActivity();
            }
        } else {
            this.openCameraActivity();
        }
    }

    protected int setLayoutId() {
        return 2131492894;
    }

    public void showLoading() {
    }
}
