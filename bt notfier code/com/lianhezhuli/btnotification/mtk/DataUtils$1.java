/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.event.SyncDataEvent
 *  com.lianhezhuli.btnotification.greendao.bean.SleepDataBean
 *  com.lianhezhuli.btnotification.greendao.bean.StepDataBean
 *  com.lianhezhuli.btnotification.greendao.manager.ManagerFactory
 *  com.lianhezhuli.btnotification.mtk.CommandUtil
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.lianhezhuli.btnotification.utils.SpUtils
 *  com.orhanobut.logger.Logger
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  org.greenrobot.eventbus.EventBus
 */
package com.lianhezhuli.btnotification.mtk;

import com.lianhezhuli.btnotification.event.SyncDataEvent;
import com.lianhezhuli.btnotification.greendao.bean.SleepDataBean;
import com.lianhezhuli.btnotification.greendao.bean.StepDataBean;
import com.lianhezhuli.btnotification.greendao.manager.ManagerFactory;
import com.lianhezhuli.btnotification.mtk.CommandUtil;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.lianhezhuli.btnotification.utils.SpUtils;
import com.orhanobut.logger.Logger;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.greenrobot.eventbus.EventBus;

class DataUtils.1
implements Observer<String> {
    DataUtils.1() {
    }

    public void onComplete() {
        EventBus.getDefault().post((Object)new SyncDataEvent(true));
    }

    public void onError(Throwable throwable) {
        EventBus.getDefault().post((Object)new SyncDataEvent(false));
    }

    public void onNext(String object) {
        String[] stringArray = ((String)object).split("\\|");
        if (stringArray.length >= 3) {
            if (SpUtils.getData((String)"is_device_new", (Object)"").equals("false")) {
                object = new StringBuilder();
                ((StringBuilder)object).append("device movementDatas[0] == ");
                ((StringBuilder)object).append(stringArray[0]);
                Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
                if (!stringArray[0].equals("0") && !stringArray[0].equals("3")) {
                    if (stringArray[0].equals("1")) {
                        object = new SleepDataBean();
                        object.setUserId((String)SpUtils.getData((String)"user_id", (Object)""));
                        object.setIsUpdate(false);
                        object.setBinTime(stringArray[1]);
                        object.setTotalSleep(Integer.parseInt(stringArray[2]));
                        object.setMac((String)SpUtils.getData((String)"device_id", (Object)""));
                        ManagerFactory.getInstance().getSleepManager().saveOrUpdate(object);
                    }
                } else {
                    object = new StepDataBean();
                    object.setUserId((String)SpUtils.getData((String)"user_id", (Object)""));
                    object.setIsUpdate(false);
                    object.setBinTime(stringArray[1]);
                    object.setActiveTime(Integer.parseInt(stringArray[2]));
                    object.setStep(Integer.parseInt(stringArray[3]));
                    object.setMac((String)SpUtils.getData((String)"device_id", (Object)""));
                    ManagerFactory.getInstance().getStepManager().saveOrUpdate(object);
                }
            } else {
                Logger.e((String)"new device true", (Object[])new Object[0]);
                if (!SpUtils.getData((String)"can_automatic", (Object)"").equals("true")) {
                    Logger.e((String)"automatic true", (Object[])new Object[0]);
                    if (stringArray[0].equals("0")) {
                        object = ManagerFactory.getInstance().getStepManager().queryByDate((String)SpUtils.getData((String)"user_id", (Object)""), stringArray[1].split(" ")[0]);
                        if (object != null && object.size() != 0) {
                            object = (StepDataBean)object.get(0);
                            object.setIsUpdate(false);
                            object.setBinTime(stringArray[1]);
                            object.setStep(Integer.parseInt(stringArray[2]));
                        } else {
                            object = new StepDataBean();
                            object.setUserId((String)SpUtils.getData((String)"user_id", (Object)""));
                            object.setIsUpdate(false);
                            object.setBinTime(stringArray[1]);
                            object.setStep(Integer.parseInt(stringArray[2]));
                            object.setMac((String)SpUtils.getData((String)"device_id", (Object)""));
                        }
                        ManagerFactory.getInstance().getStepManager().saveOrUpdate(object);
                    } else if (stringArray[0].equals("1")) {
                        object = ManagerFactory.getInstance().getSleepManager().queryByDate((String)SpUtils.getData((String)"user_id", (Object)""), stringArray[1].split(" ")[0]);
                        if (object != null && object.size() != 0) {
                            object = (SleepDataBean)object.get(0);
                            object.setTotalSleep(object.getTotalSleep() + Integer.parseInt(stringArray[2]));
                            object.setDeepSleep(object.getDeepSleep() + Integer.parseInt(stringArray[3]));
                            object.setLightSleep(object.getLightSleep() + Integer.parseInt(stringArray[4]));
                            object.setAwakeTime(object.getAwakeTime() + Integer.parseInt(stringArray[5]));
                        } else {
                            object = new SleepDataBean();
                            object.setUserId((String)SpUtils.getData((String)"user_id", (Object)""));
                            object.setIsUpdate(false);
                            object.setBinTime(stringArray[1]);
                            object.setTotalSleep(Integer.parseInt(stringArray[2]));
                            object.setDeepSleep(Integer.parseInt(stringArray[3]));
                            object.setLightSleep(Integer.parseInt(stringArray[4]));
                            object.setAwakeTime(Integer.parseInt(stringArray[5]));
                            object.setMac((String)SpUtils.getData((String)"device_id", (Object)""));
                        }
                        ManagerFactory.getInstance().getSleepManager().saveOrUpdate(object);
                    } else if (stringArray[0].equals("3")) {
                        object = ManagerFactory.getInstance().getStepManager().queryByDate((String)SpUtils.getData((String)"user_id", (Object)""), stringArray[1].split(" ")[0]);
                        if (object != null && object.size() != 0) {
                            object = (StepDataBean)object.get(0);
                            object.setIsUpdate(false);
                            object.setBinTime(stringArray[1]);
                            object.setStep(Integer.parseInt(stringArray[2]));
                        } else {
                            object = new StepDataBean();
                            object.setUserId((String)SpUtils.getData((String)"user_id", (Object)""));
                            object.setIsUpdate(false);
                            object.setBinTime(stringArray[1]);
                            object.setStep(Integer.parseInt(stringArray[2]));
                            object.setMac((String)SpUtils.getData((String)"device_id", (Object)""));
                        }
                        ManagerFactory.getInstance().getStepManager().saveOrUpdate(object);
                    }
                }
            }
            stringArray[0].equals("4");
        } else {
            MainService.getInstance().sendPhoneData(CommandUtil.SYNC_DATA);
        }
    }

    public void onSubscribe(Disposable disposable) {
    }
}
