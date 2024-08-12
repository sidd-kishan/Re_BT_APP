/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.utils.AlarmRepeatUtils
 */
package com.lianhezhuli.btnotification.bean;

import com.lianhezhuli.btnotification.utils.AlarmRepeatUtils;
import java.io.Serializable;

public class RemoteAlarmBean
implements Serializable {
    private String on;
    private int repeat;
    private String time;

    public String getOn() {
        return this.on;
    }

    public int getRepeat() {
        return this.repeat;
    }

    public String getTime() {
        return this.time;
    }

    public void setOn(String string) {
        this.on = string;
    }

    public void setRepeat(int n) {
        this.repeat = n;
    }

    public void setTime(String string) {
        this.time = string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.time);
        stringBuilder.append("|");
        stringBuilder.append(AlarmRepeatUtils.getRepeatStr((int)this.repeat));
        stringBuilder.append("|");
        stringBuilder.append(this.on);
        return stringBuilder.toString();
    }
}
