/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$ConfigBean
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$ConfigItemBean
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$UnionBean
 */
package com.lianhezhuli.btnotification.network.bean;

import com.lianhezhuli.btnotification.network.bean.AdvertConfigBean;

public class AdvertConfigBean {
    private ConfigBean config;
    private ConfigItemBean config_item;
    private UnionBean union;

    public ConfigBean getConfig() {
        return this.config;
    }

    public ConfigItemBean getConfig_item() {
        return this.config_item;
    }

    public UnionBean getUnion() {
        return this.union;
    }

    public void setConfig(ConfigBean configBean) {
        this.config = configBean;
    }

    public void setConfig_item(ConfigItemBean configItemBean) {
        this.config_item = configItemBean;
    }

    public void setUnion(UnionBean unionBean) {
        this.union = unionBean;
    }
}
