/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$ConfigBean$AdvertLimitDTO$LimitDTO$LimitItemDTO$LimitTypeListDTO
 */
package com.lianhezhuli.btnotification.network.bean;

import com.google.gson.annotations.SerializedName;
import com.lianhezhuli.btnotification.network.bean.AdvertConfigBean;
import java.util.List;

public static class AdvertConfigBean.ConfigBean.AdvertLimitDTO.LimitDTO.LimitItemDTO {
    @SerializedName(value="affect_position")
    private List<String> affectPosition;
    @SerializedName(value="config_id")
    private int configId;
    @SerializedName(value="id")
    private int id;
    @SerializedName(value="limit_type_list")
    private LimitTypeListDTO limitTypeList;
    @SerializedName(value="next_time")
    private int nextTime;
    @SerializedName(value="position_id")
    private int positionId;
    @SerializedName(value="stage_id")
    private int stageId;

    public List<String> getAffectPosition() {
        return this.affectPosition;
    }

    public int getConfigId() {
        return this.configId;
    }

    public int getId() {
        return this.id;
    }

    public LimitTypeListDTO getLimitTypeList() {
        return this.limitTypeList;
    }

    public int getNextTime() {
        return this.nextTime;
    }

    public int getPositionId() {
        return this.positionId;
    }

    public int getStageId() {
        return this.stageId;
    }

    public void setAffectPosition(List<String> list) {
        this.affectPosition = list;
    }

    public void setConfigId(int n) {
        this.configId = n;
    }

    public void setId(int n) {
        this.id = n;
    }

    public void setLimitTypeList(LimitTypeListDTO limitTypeListDTO) {
        this.limitTypeList = limitTypeListDTO;
    }

    public void setNextTime(int n) {
        this.nextTime = n;
    }

    public void setPositionId(int n) {
        this.positionId = n;
    }

    public void setStageId(int n) {
        this.stageId = n;
    }
}
