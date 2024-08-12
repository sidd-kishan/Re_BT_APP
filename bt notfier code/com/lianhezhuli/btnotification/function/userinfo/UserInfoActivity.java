/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.fragment.app.FragmentActivity
 *  butterknife.BindView
 *  butterknife.OnClick
 *  com.bigkoo.pickerview.listener.OnOptionsSelectListener
 *  com.bigkoo.pickerview.listener.OnTimeSelectListener
 *  com.bumptech.glide.Glide
 *  com.lianhezhuli.btnotification.base.BasePictureActivity
 *  com.lianhezhuli.btnotification.bean.UserInfoBean
 *  com.lianhezhuli.btnotification.function.userinfo._$$Lambda$UserInfoActivity$71fntf04mJQUmUYp0WRoxFYjJL8
 *  com.lianhezhuli.btnotification.function.userinfo._$$Lambda$UserInfoActivity$FOwlrymbL8DQ8rvMsILoFRVUe3A
 *  com.lianhezhuli.btnotification.function.userinfo._$$Lambda$UserInfoActivity$H_8Ea3mgAWUqDKFxeZK0MB7O_VY
 *  com.lianhezhuli.btnotification.function.userinfo._$$Lambda$UserInfoActivity$KKdt7XLQiww5U1EDyWUuA9HQA_k
 *  com.lianhezhuli.btnotification.function.userinfo._$$Lambda$UserInfoActivity$MjRnKxi0omUT3umib_jjYzwmvDw
 *  com.lianhezhuli.btnotification.function.userinfo._$$Lambda$UserInfoActivity$VIpviF95mVF3mXYovZODPVE1m7w
 *  com.lianhezhuli.btnotification.function.userinfo._$$Lambda$UserInfoActivity$_1kpPb1qXHH3F8bXrnz_FjHr1S4
 *  com.lianhezhuli.btnotification.function.userinfo._$$Lambda$UserInfoActivity$eGg_pZ_a2hvdn_GXDISkFJcPt_4
 *  com.lianhezhuli.btnotification.function.userinfo._$$Lambda$UserInfoActivity$w0biHOjN_Ik_7w5oIpwpIdi9qGg
 *  com.lianhezhuli.btnotification.utils.PermissionCheckUtils
 *  com.lianhezhuli.btnotification.utils.SpUtils
 *  com.lianhezhuli.btnotification.utils.StringUtils
 *  com.lianhezhuli.btnotification.utils.ToastUtils
 *  com.lianhezhuli.btnotification.view.pickerview.PickerViewHelper
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.orhanobut.logger.Logger
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 *  com.qmuiteam.qmui.widget.QMUIRadiusImageView
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$EditTextDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogAction$ActionListener
 *  org.greenrobot.eventbus.EventBus
 */
package com.lianhezhuli.btnotification.function.userinfo;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.OnClick;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bumptech.glide.Glide;
import com.lianhezhuli.btnotification.base.BasePictureActivity;
import com.lianhezhuli.btnotification.bean.UserInfoBean;
import com.lianhezhuli.btnotification.function.userinfo._$;
import com.lianhezhuli.btnotification.utils.PermissionCheckUtils;
import com.lianhezhuli.btnotification.utils.SpUtils;
import com.lianhezhuli.btnotification.utils.StringUtils;
import com.lianhezhuli.btnotification.utils.ToastUtils;
import com.lianhezhuli.btnotification.view.pickerview.PickerViewHelper;
import com.luck.picture.lib.entity.LocalMedia;
import com.orhanobut.logger.Logger;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public class UserInfoActivity
extends BasePictureActivity {
    @BindView(value=2131296890)
    TextView mBirthTv;
    @BindView(value=2131296891)
    QMUIRadiusImageView mHeadImg;
    private List<String> mHeightList;
    @BindView(value=2131296894)
    TextView mHeightTv;
    @BindView(value=2131296896)
    TextView mNicknameTv;
    private List<String> mSexList = new ArrayList<String>();
    @BindView(value=2131296898)
    TextView mSexTv;
    @BindView(value=2131296899)
    QMUITopBarLayout mTopBar;
    private UserInfoBean mUserInfo;
    private List<String> mWeightList;
    @BindView(value=2131296882)
    TextView mWeightTv;

    public UserInfoActivity() {
        this.mHeightList = new ArrayList<String>();
        this.mWeightList = new ArrayList<String>();
    }

    static /* synthetic */ void lambda$click$3(QMUIDialog qMUIDialog, int n) {
        qMUIDialog.dismiss();
    }

    @OnClick(value={2131296892, 2131296895, 2131296897, 2131296889, 2131296893, 2131296881})
    public void click(View object) {
        switch (object.getId()) {
            default: {
                break;
            }
            case 2131296897: {
                PickerViewHelper.getInstance();
                object = this.getString(2131755295);
                List<String> list = this.mSexList;
                PickerViewHelper.showSingleDialog((Context)this, (String)object, list, (int)list.indexOf(this.mSexTv.getText().toString()), (OnOptionsSelectListener)new _$.Lambda.UserInfoActivity.KKdt7XLQiww5U1EDyWUuA9HQA_k(this));
                break;
            }
            case 2131296895: {
                object = new QMUIDialog.EditTextDialogBuilder((Context)this);
                ((QMUIDialog.EditTextDialogBuilder)((QMUIDialog.EditTextDialogBuilder)((QMUIDialog.EditTextDialogBuilder)object.setTitle(this.getString(2131755289))).setPlaceholder(this.getString(2131755291)).setInputType(1).addAction(2131755050, (QMUIDialogAction.ActionListener)_$.Lambda.UserInfoActivity.71fntf04mJQUmUYp0WRoxFYjJL8.INSTANCE)).addAction(2131755116, (QMUIDialogAction.ActionListener)new _$.Lambda.UserInfoActivity.eGg_pZ_a2hvdn_GXDISkFJcPt_4(this, (QMUIDialog.EditTextDialogBuilder)object))).create().show();
                break;
            }
            case 2131296893: {
                PickerViewHelper.getInstance();
                object = this.getString(2131755294);
                List<String> list = this.mHeightList;
                PickerViewHelper.showSingleDialog((Context)this, (String)object, list, (int)list.indexOf(this.mUserInfo.getHeight()), (OnOptionsSelectListener)new _$.Lambda.UserInfoActivity.FOwlrymbL8DQ8rvMsILoFRVUe3A(this));
                break;
            }
            case 2131296892: {
                QMUIDialog.MenuDialogBuilder menuDialogBuilder = new QMUIDialog.MenuDialogBuilder((Context)this);
                String string = this.getString(2131755265);
                String string2 = this.getString(2131755258);
                object = new _$.Lambda.UserInfoActivity._1kpPb1qXHH3F8bXrnz_FjHr1S4(this);
                menuDialogBuilder.addItems((CharSequence[])new String[]{string, string2}, (DialogInterface.OnClickListener)object).create().show();
                break;
            }
            case 2131296889: {
                PickerViewHelper.getInstance();
                PickerViewHelper.showDateDialog((Context)this, (OnTimeSelectListener)new _$.Lambda.UserInfoActivity.MjRnKxi0omUT3umib_jjYzwmvDw(this));
                break;
            }
            case 2131296881: {
                PickerViewHelper.getInstance();
                object = this.getString(2131755296);
                List<String> list = this.mWeightList;
                PickerViewHelper.showSingleDialog((Context)this, (String)object, list, (int)list.indexOf(this.mUserInfo.getWeight()), (OnOptionsSelectListener)new _$.Lambda.UserInfoActivity.H_8Ea3mgAWUqDKFxeZK0MB7O_VY(this));
            }
        }
    }

    protected void initView() {
        int n;
        this.mTopBar.setTitle(2131755088);
        this.mTopBar.addLeftBackImageButton().setOnClickListener((View.OnClickListener)new _$.Lambda.UserInfoActivity.VIpviF95mVF3mXYovZODPVE1m7w(this));
        Object object = this.mTopBar.addRightTextButton(2131755257, QMUIViewHelper.generateViewId());
        object.setTextColor(-1);
        object.setTextSize(12.0f);
        object.setOnClickListener((View.OnClickListener)new _$.Lambda.UserInfoActivity.w0biHOjN_Ik_7w5oIpwpIdi9qGg(this));
        this.mSexList.add(this.getString(2131755275));
        this.mSexList.add(this.getString(2131755249));
        for (n = 100; n < 200; ++n) {
            this.mHeightList.add(String.valueOf(n));
        }
        for (n = 30; n < 151; ++n) {
            this.mWeightList.add(String.valueOf(n));
        }
        object = (UserInfoBean)SpUtils.getShareData((String)"user_info", UserInfoBean.class);
        this.mUserInfo = object;
        if (object == null) {
            object = new UserInfoBean();
            this.mUserInfo = object;
            object.setBirth("");
            this.mUserInfo.setSex(1);
            this.mUserInfo.setHeight("170");
            this.mUserInfo.setWeight("50");
        }
        if (!TextUtils.isEmpty((CharSequence)this.mUserInfo.getHeadImgPath())) {
            Glide.with((FragmentActivity)this).load(this.mUserInfo.getHeadImgPath()).into((ImageView)this.mHeadImg);
        }
        TextView textView = this.mNicknameTv;
        object = TextUtils.isEmpty((CharSequence)this.mUserInfo.getNickname()) ? this.getString(2131755096) : this.mUserInfo.getNickname();
        textView.setText((CharSequence)object);
        textView = this.mSexTv;
        object = this.mUserInfo.getSex() == 0 ? this.getString(2131755275) : this.getString(2131755249);
        textView.setText((CharSequence)object);
        this.mBirthTv.setText((CharSequence)this.mUserInfo.getBirth());
        this.mHeightTv.setText((CharSequence)String.format("%s%s", this.mUserInfo.getHeight(), this.getString(2131755286)));
        this.mWeightTv.setText((CharSequence)String.format("%s%s", this.mUserInfo.getWeight(), this.getString(2131755287)));
    }

    public /* synthetic */ void lambda$click$2$UserInfoActivity(DialogInterface dialogInterface, int n) {
        if (n == 0) {
            this.takePic();
        } else {
            this.selectPic();
        }
        dialogInterface.dismiss();
    }

    public /* synthetic */ void lambda$click$4$UserInfoActivity(QMUIDialog.EditTextDialogBuilder editTextDialogBuilder, QMUIDialog qMUIDialog, int n) {
        if ((editTextDialogBuilder = editTextDialogBuilder.getEditText().getText()) != null && editTextDialogBuilder.length() > 0) {
            qMUIDialog.dismiss();
            this.mUserInfo.setNickname(editTextDialogBuilder.toString());
            this.mNicknameTv.setText((CharSequence)editTextDialogBuilder.toString());
        } else {
            ToastUtils.showShort((Context)this, (String)this.getString(2131755292));
        }
    }

    public /* synthetic */ void lambda$click$5$UserInfoActivity(int n, int n2, int n3, View view) {
        this.mSexTv.setText((CharSequence)this.mSexList.get(n));
        this.mUserInfo.setSex(n);
    }

    public /* synthetic */ void lambda$click$6$UserInfoActivity(Date object, View view) {
        object = StringUtils.yyyy_MM_dd.format((Date)object);
        this.mBirthTv.setText((CharSequence)object);
        this.mUserInfo.setBirth((String)object);
    }

    public /* synthetic */ void lambda$click$7$UserInfoActivity(int n, int n2, int n3, View view) {
        this.mHeightTv.setText((CharSequence)String.format("%s%s", this.mHeightList.get(n), this.getString(2131755286)));
        this.mUserInfo.setHeight(this.mHeightList.get(n));
    }

    public /* synthetic */ void lambda$click$8$UserInfoActivity(int n, int n2, int n3, View view) {
        this.mWeightTv.setText((CharSequence)String.format("%s%s", this.mWeightList.get(n), this.getString(2131755287)));
        this.mUserInfo.setWeight(this.mWeightList.get(n));
    }

    public /* synthetic */ void lambda$initView$0$UserInfoActivity(View view) {
        this.finish();
    }

    public /* synthetic */ void lambda$initView$1$UserInfoActivity(View view) {
        SpUtils.saveJsonData((String)"user_info", (Object)this.mUserInfo);
        EventBus.getDefault().post((Object)this.mUserInfo);
        ToastUtils.showShort((Context)this, (int)2131755293);
    }

    protected void notPermissions(String[] stringArray) {
        super.notPermissions(stringArray);
        ToastUtils.showShort((Context)this, (int)2131755124);
    }

    protected void okPermissions() {
        super.okPermissions();
        this.camera();
    }

    protected void onImageSelect(List<LocalMedia> object) {
        LocalMedia localMedia = object.get(0);
        object = new StringBuilder();
        ((StringBuilder)object).append("backPics == ");
        ((StringBuilder)object).append(localMedia.getPath());
        Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        Glide.with((FragmentActivity)this).load(localMedia.getPath()).into((ImageView)this.mHeadImg);
        this.mUserInfo.setHeadImgPath(localMedia.getPath());
    }

    public void selectPic() {
        if (!PermissionCheckUtils.check((String[])new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"})) {
            this.requestPermission(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"});
        } else {
            this.gallery();
        }
    }

    protected int setLayoutId() {
        return 2131492900;
    }

    public void takePic() {
        if (!PermissionCheckUtils.check((String[])new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"})) {
            this.requestPermission(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"});
        } else {
            this.camera();
        }
    }
}
