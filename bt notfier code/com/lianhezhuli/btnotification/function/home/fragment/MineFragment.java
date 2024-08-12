/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.fragment.app.FragmentActivity
 *  butterknife.BindView
 *  butterknife.OnClick
 *  com.bumptech.glide.Glide
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.AdRequest$Builder
 *  com.google.android.gms.ads.FullScreenContentCallback
 *  com.google.android.gms.ads.interstitial.InterstitialAd
 *  com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.advert.AdHelper
 *  com.lianhezhuli.btnotification.appstatus.AppStatusHelper
 *  com.lianhezhuli.btnotification.appstatus.AppStatusHelper$AppStatusListener
 *  com.lianhezhuli.btnotification.base.BaseActivity
 *  com.lianhezhuli.btnotification.base.BaseFragment
 *  com.lianhezhuli.btnotification.bean.UserInfoBean
 *  com.lianhezhuli.btnotification.function.device.FindDeviceActivity
 *  com.lianhezhuli.btnotification.function.device.remotealarm.RemoteAlarmActivity
 *  com.lianhezhuli.btnotification.function.setting.BluetoothSettingActivity
 *  com.lianhezhuli.btnotification.function.setting.MessageSettingActivity
 *  com.lianhezhuli.btnotification.function.setting.SettingActivity
 *  com.lianhezhuli.btnotification.function.userinfo.UserInfoActivity
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$ConfigBean$AdvertLimitDTO$LimitDTO$LimitItemDTO
 *  com.lianhezhuli.btnotification.network.request.RequestUtils
 *  com.lianhezhuli.btnotification.utils.DialogUtils
 *  com.lianhezhuli.btnotification.utils.SpUtils
 *  com.lianhezhuli.btnotification.utils.ToastUtils
 *  com.lianhezhuli.btnotification.utils.Utils
 *  com.orhanobut.logger.Logger
 *  com.qmuiteam.qmui.widget.QMUIRadiusImageView
 *  com.qmuiteam.qmui.widget.dialog.QMUITipDialog
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package com.lianhezhuli.btnotification.function.home.fragment;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.advert.AdHelper;
import com.lianhezhuli.btnotification.appstatus.AppStatusHelper;
import com.lianhezhuli.btnotification.base.BaseActivity;
import com.lianhezhuli.btnotification.base.BaseFragment;
import com.lianhezhuli.btnotification.bean.UserInfoBean;
import com.lianhezhuli.btnotification.function.device.FindDeviceActivity;
import com.lianhezhuli.btnotification.function.device.remotealarm.RemoteAlarmActivity;
import com.lianhezhuli.btnotification.function.setting.BluetoothSettingActivity;
import com.lianhezhuli.btnotification.function.setting.MessageSettingActivity;
import com.lianhezhuli.btnotification.function.setting.SettingActivity;
import com.lianhezhuli.btnotification.function.userinfo.UserInfoActivity;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.lianhezhuli.btnotification.network.bean.AdvertConfigBean;
import com.lianhezhuli.btnotification.network.request.RequestUtils;
import com.lianhezhuli.btnotification.utils.DialogUtils;
import com.lianhezhuli.btnotification.utils.SpUtils;
import com.lianhezhuli.btnotification.utils.ToastUtils;
import com.lianhezhuli.btnotification.utils.Utils;
import com.orhanobut.logger.Logger;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MineFragment
extends BaseFragment
implements AppStatusHelper.AppStatusListener {
    private Class<?> cls;
    private final FullScreenContentCallback fullScreenContentCallback = new /* Unavailable Anonymous Inner Class!! */;
    private boolean isNeedLoadAd = true;
    @BindView(value=2131296600)
    QMUIRadiusImageView mHeadImg;
    @BindView(value=2131296601)
    View mHeadView;
    @BindView(value=2131296603)
    TextView mHeightTv;
    private InterstitialAd mInterstitialAd;
    @BindView(value=2131296605)
    TextView mNicknameTv;
    private QMUITipDialog mTipDialog;
    private UserInfoBean mUserInfo;
    @BindView(value=2131296617)
    TextView mWeightTv;
    private String posId;
    private int settingCodeId;
    private int settingItemId;

    static /* synthetic */ InterstitialAd access$000(MineFragment mineFragment) {
        return mineFragment.mInterstitialAd;
    }

    static /* synthetic */ InterstitialAd access$002(MineFragment mineFragment, InterstitialAd interstitialAd) {
        mineFragment.mInterstitialAd = interstitialAd;
        return interstitialAd;
    }

    static /* synthetic */ FullScreenContentCallback access$100(MineFragment mineFragment) {
        return mineFragment.fullScreenContentCallback;
    }

    static /* synthetic */ BaseActivity access$1000(MineFragment mineFragment) {
        return mineFragment.mActivity;
    }

    static /* synthetic */ BaseActivity access$200(MineFragment mineFragment) {
        return mineFragment.mActivity;
    }

    static /* synthetic */ QMUITipDialog access$300(MineFragment mineFragment) {
        return mineFragment.mTipDialog;
    }

    static /* synthetic */ BaseActivity access$400(MineFragment mineFragment) {
        return mineFragment.mActivity;
    }

    static /* synthetic */ Class access$500(MineFragment mineFragment) {
        return mineFragment.cls;
    }

    static /* synthetic */ int access$600(MineFragment mineFragment) {
        return mineFragment.settingItemId;
    }

    static /* synthetic */ int access$700(MineFragment mineFragment) {
        return mineFragment.settingCodeId;
    }

    static /* synthetic */ String access$800(MineFragment mineFragment) {
        return mineFragment.posId;
    }

    static /* synthetic */ BaseActivity access$900(MineFragment mineFragment) {
        return mineFragment.mActivity;
    }

    private void loadAd() {
        if (this.isNeedLoadAd) {
            Object object = MApplication.getInstance().getAdvertConfigBean();
            if (object.getConfig_item().get_$6() != null && object.getConfig_item().get_$6().getStatus() == 1) {
                this.settingCodeId = object.getConfig_item().get_$6().getCode_id();
                this.settingItemId = object.getConfig_item().get_$6().getItem_id();
                this.posId = object.getConfig_item().get_$6().getPosid();
                object = new StringBuilder();
                ((StringBuilder)object).append("settingCodeId: ");
                ((StringBuilder)object).append(this.settingCodeId);
                ((StringBuilder)object).append("\nsettingItemId: ");
                ((StringBuilder)object).append(this.settingItemId);
                ((StringBuilder)object).append("\nposId: ");
                ((StringBuilder)object).append(this.posId);
                Logger.i((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
                this.loadInterstitialAd();
            } else {
                this.mTipDialog.dismiss();
                this.startActivity(new Intent((Context)this.mActivity, this.cls));
            }
        } else {
            this.mTipDialog.dismiss();
            this.startActivity(new Intent((Context)this.mActivity, this.cls));
        }
    }

    private void loadInterstitialAd() {
        this.isNeedLoadAd = false;
        RequestUtils.postAdvertLoad((int)this.settingItemId, (int)this.settingCodeId, (String)"6", (String)"3", (String)this.posId);
        AdvertConfigBean.ConfigBean.AdvertLimitDTO.LimitDTO.LimitItemDTO limitItemDTO = AdHelper.getInstance().getAdvertLimit(1, "6");
        if (limitItemDTO != null && limitItemDTO.getAffectPosition() != null) {
            AdHelper.getInstance().setNextLimit(limitItemDTO);
        }
        InterstitialAd.load((Context)this.mActivity, (String)this.posId, (AdRequest)new AdRequest.Builder().setHttpTimeoutMillis(5000).build(), (InterstitialAdLoadCallback)new /* Unavailable Anonymous Inner Class!! */);
    }

    private void setUserInfo() {
        if (!TextUtils.isEmpty((CharSequence)this.mUserInfo.getHeadImgPath())) {
            Glide.with((FragmentActivity)this.mActivity).load(this.mUserInfo.getHeadImgPath()).into((ImageView)this.mHeadImg);
        }
        TextView textView = this.mNicknameTv;
        String string = TextUtils.isEmpty((CharSequence)this.mUserInfo.getNickname()) ? this.getString(2131755096) : this.mUserInfo.getNickname();
        textView.setText((CharSequence)string);
        this.mHeightTv.setText((CharSequence)this.mUserInfo.getHeight());
        this.mWeightTv.setText((CharSequence)this.mUserInfo.getWeight());
    }

    @OnClick(value={2131296599, 2131296606, 2131296598, 2131296596, 2131296616, 2131296604})
    public void click(View view) {
        switch (view.getId()) {
            default: {
                break;
            }
            case 2131296616: {
                this.startActivity(new Intent((Context)this.mActivity, UserInfoActivity.class));
                break;
            }
            case 2131296606: {
                if (MainService.getInstance().isBtConnect()) {
                    if (MApplication.getInstance().isShowAd() && AdHelper.getInstance().isShowAd()) {
                        this.mTipDialog.show();
                        this.cls = RemoteAlarmActivity.class;
                        this.loadAd();
                        break;
                    }
                    this.startActivity(new Intent((Context)this.mActivity, RemoteAlarmActivity.class));
                    break;
                }
                ToastUtils.showShort((Context)this.mActivity, (int)2131755043);
                break;
            }
            case 2131296604: {
                if (MApplication.getInstance().isShowAd() && AdHelper.getInstance().isShowAd()) {
                    this.mTipDialog.show();
                    this.cls = MessageSettingActivity.class;
                    this.loadAd();
                    break;
                }
                this.startActivity(new Intent((Context)this.mActivity, MessageSettingActivity.class));
                break;
            }
            case 2131296599: {
                if (MApplication.getInstance().isShowAd() && AdHelper.getInstance().isShowAd()) {
                    this.mTipDialog.show();
                    this.cls = FindDeviceActivity.class;
                    this.loadAd();
                    break;
                }
                this.startActivity(new Intent((Context)this.mActivity, FindDeviceActivity.class));
                break;
            }
            case 2131296598: {
                if (MApplication.getInstance().isShowAd() && AdHelper.getInstance().isShowAd()) {
                    this.mTipDialog.show();
                    this.cls = BluetoothSettingActivity.class;
                    this.loadAd();
                    break;
                }
                this.startActivity(new Intent((Context)this.mActivity, BluetoothSettingActivity.class));
                break;
            }
            case 2131296596: {
                this.startActivity(new Intent((Context)this.mActivity, SettingActivity.class));
            }
        }
    }

    protected int getLayoutId() {
        return 2131492927;
    }

    protected void initView() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, Utils.getStatusBarHeight((Context)this.mActivity));
        this.mHeadView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        EventBus.getDefault().register((Object)this);
        AppStatusHelper.getInstance().registerAppStatusListener((AppStatusHelper.AppStatusListener)this);
        this.mTipDialog = DialogUtils.getTipDialog((Context)this.mActivity, (int)1, null);
        layoutParams = (UserInfoBean)SpUtils.getShareData((String)"user_info", UserInfoBean.class);
        this.mUserInfo = layoutParams;
        if (layoutParams == null) {
            layoutParams = new UserInfoBean();
            this.mUserInfo = layoutParams;
            layoutParams.setBirth("");
            this.mUserInfo.setSex(1);
            this.mUserInfo.setHeight("170");
            this.mUserInfo.setWeight("50");
            SpUtils.saveJsonData((String)"user_info", (Object)this.mUserInfo);
        }
        this.setUserInfo();
    }

    public void onDestroy() {
        EventBus.getDefault().unregister((Object)this);
        super.onDestroy();
    }

    public void onStatusChange(boolean bl) {
        if (!bl) return;
        this.isNeedLoadAd = true;
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void syncSuccess(UserInfoBean userInfoBean) {
        this.mUserInfo = userInfoBean;
        this.setUserInfo();
    }
}
