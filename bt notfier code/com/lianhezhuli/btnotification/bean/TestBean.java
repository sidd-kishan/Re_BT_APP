/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.bean.TestBean$Datas
 */
package com.lianhezhuli.btnotification.bean;

import com.lianhezhuli.btnotification.bean.TestBean;
import java.util.List;

public class TestBean {
    private int curPage;
    private List<Datas> datas;

    public int getCurPage() {
        return this.curPage;
    }

    public List<Datas> getDatas() {
        return this.datas;
    }

    public void setCurPage(int n) {
        this.curPage = n;
    }

    public void setDatas(List<Datas> list) {
        this.datas = list;
    }
}
