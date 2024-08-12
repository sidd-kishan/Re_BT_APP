/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  com.lianhezhuli.btnotification.bean.RemoteAlarmBean
 *  com.lianhezhuli.btnotification.function.device.remotealarm.RemoteAlarmActivity
 *  com.lianhezhuli.btnotification.function.device.remotealarm.RemoteAlarmTimeSettingActivity
 *  com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter$OnButtonClickListener
 *  com.lianhezhuli.btnotification.mtk.CommandUtil
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.lianhezhuli.btnotification.utils.SpUtils
 */
package com.lianhezhuli.btnotification.function.device.remotealarm;

import android.content.Context;
import android.content.Intent;
import com.lianhezhuli.btnotification.bean.RemoteAlarmBean;
import com.lianhezhuli.btnotification.function.device.remotealarm.RemoteAlarmActivity;
import com.lianhezhuli.btnotification.function.device.remotealarm.RemoteAlarmTimeSettingActivity;
import com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter;
import com.lianhezhuli.btnotification.mtk.CommandUtil;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.lianhezhuli.btnotification.utils.SpUtils;
import java.io.Serializable;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
class RemoteAlarmActivity.2
implements RemoteAlarmAdapter.OnButtonClickListener {
    final RemoteAlarmActivity this$0;

    RemoteAlarmActivity.2(RemoteAlarmActivity remoteAlarmActivity) {
        this.this$0 = remoteAlarmActivity;
    }

    public void edit(int n) {
        this.this$0.mRecycler.closeEx();
        Intent intent = new Intent((Context)this.this$0, RemoteAlarmTimeSettingActivity.class);
        intent.putExtra("alarm_data", (Serializable)((Object)RemoteAlarmActivity.access$100((RemoteAlarmActivity)this.this$0)));
        intent.putExtra("alarm_index", n);
        this.this$0.startActivityForResult(intent, 1000);
    }

    public void switchCheckChange(int n, boolean bl) {
        this.this$0.mRecycler.closeEx();
        RemoteAlarmActivity.access$000((RemoteAlarmActivity)this.this$0).show();
        RemoteAlarmBean remoteAlarmBean = (RemoteAlarmBean)RemoteAlarmActivity.access$100((RemoteAlarmActivity)this.this$0).get(n);
        String string = "1";
        String string2 = bl ? "1" : "0";
        remoteAlarmBean.setOn(string2);
        if (!MainService.getInstance().sendPhoneData(CommandUtil.generateAlarmCommand((List)RemoteAlarmActivity.access$100((RemoteAlarmActivity)this.this$0)))) {
            remoteAlarmBean = (RemoteAlarmBean)RemoteAlarmActivity.access$100((RemoteAlarmActivity)this.this$0).get(n);
            string2 = string;
            if (bl) {
                string2 = "0";
            }
            remoteAlarmBean.setOn(string2);
            RemoteAlarmActivity.access$000((RemoteAlarmActivity)this.this$0).dismiss();
        } else {
            SpUtils.saveJsonData((String)"remote_alarm_data", (Object)RemoteAlarmActivity.access$100((RemoteAlarmActivity)this.this$0));
            RemoteAlarmActivity.access$200((RemoteAlarmActivity)this.this$0).setList(RemoteAlarmActivity.access$100((RemoteAlarmActivity)this.this$0));
        }
    }
}
