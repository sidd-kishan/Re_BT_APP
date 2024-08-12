/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.bean.RemoteAlarmBean
 *  com.lianhezhuli.btnotification.utils.AlarmRepeatUtils
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk;

import com.lianhezhuli.btnotification.bean.RemoteAlarmBean;
import com.lianhezhuli.btnotification.utils.AlarmRepeatUtils;
import com.orhanobut.logger.Logger;
import java.util.List;

public class CommandUtil {
    public static String FIND_WATCH = "0006look";
    public static String FIND_WATCH_STOP = "0006stop";
    public static String REMOTE_ALARM = "SET,0";
    public static String SYNC_DATA = "GET,0";
    public static String SYNC_SPORT_SLEEP_DATA = "GET,1";

    public static String generateAlarmCommand(List<RemoteAlarmBean> object) {
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(REMOTE_ALARM);
        ((StringBuilder)charSequence).append(",");
        int n = 0;
        while (true) {
            if (n >= object.size()) {
                charSequence = ((StringBuilder)charSequence).toString();
                object = new StringBuilder();
                ((StringBuilder)object).append("AlarmCommand == ");
                ((StringBuilder)object).append((String)charSequence);
                Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
                return charSequence;
            }
            ((StringBuilder)charSequence).append(object.get(n).getTime());
            ((StringBuilder)charSequence).append("|");
            ((StringBuilder)charSequence).append(AlarmRepeatUtils.getCommandRepeat((int)((RemoteAlarmBean)object.get(n)).getRepeat()));
            ((StringBuilder)charSequence).append("|");
            ((StringBuilder)charSequence).append(((RemoteAlarmBean)object.get(n)).getOn());
            if (n < object.size() - 1) {
                ((StringBuilder)charSequence).append(",");
            }
            ++n;
        }
    }

    public static String generateCommand(String string, String ... object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(",");
        int n = 0;
        while (true) {
            if (n >= ((String[])object).length) {
                string = stringBuilder.toString();
                object = new StringBuilder();
                ((StringBuilder)object).append("command == ");
                ((StringBuilder)object).append(string);
                Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
                return string;
            }
            stringBuilder.append(object[n]);
            if (n < ((String[])object).length - 1) {
                stringBuilder.append("|");
            }
            ++n;
        }
    }
}
