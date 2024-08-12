/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$ConfigBean
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$ConfigBean$AdvertLimitDTO$LimitDTO$LimitItemDTO
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$ConfigBean$AdvertLimitDTO$LimitDTO$LimitItemDTO$LimitTypeListDTO$TypeDTO
 *  com.lianhezhuli.btnotification.network.bean.AdvertReportBean
 *  com.lianhezhuli.btnotification.utils.SpUtils
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.advert;

import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.network.bean.AdvertConfigBean;
import com.lianhezhuli.btnotification.network.bean.AdvertReportBean;
import com.lianhezhuli.btnotification.utils.SpUtils;
import com.orhanobut.logger.Logger;
import java.util.Iterator;

public class AdHelper {
    private static final AdHelper AD_UTILS = new AdHelper();
    public static final int CLICK_CODE = 3;
    public static final int ERROR_CODE = 4;
    public static final int LOAD_CODE = 1;
    public static final String POSITION_INTERSTITIAL = "6";
    public static final int SHOW_CODE = 2;
    private int interstitialFast;
    private long interstitialFastCycle;
    private long interstitialHideTime = (Long)SpUtils.getData((String)"advert_interstitial_hide_time", (Object)-1L);
    private long interstitialNextTime;
    private int interstitialTotal;
    private long interstitialTotalCycle;

    private AdHelper() {
        Long l = 0L;
        this.interstitialNextTime = (Long)SpUtils.getData((String)"advert_interstitial_next_time", (Object)l);
        Integer n = 0;
        this.interstitialTotal = (Integer)SpUtils.getData((String)"interstitial_total_times", (Object)n);
        this.interstitialTotalCycle = (Long)SpUtils.getData((String)"interstitial_total_cycle", (Object)l);
        this.interstitialFast = (Integer)SpUtils.getData((String)"interstitial_fast_times", (Object)n);
        this.interstitialFastCycle = (Long)SpUtils.getData((String)"interstitial_fast_cycle", (Object)l);
    }

    private long getCurrentTimeSeconds() {
        return System.currentTimeMillis() / 1000L;
    }

    public static AdHelper getInstance() {
        return AD_UTILS;
    }

    private void setFastLimit(AdvertConfigBean.ConfigBean.AdvertLimitDTO.LimitDTO.LimitItemDTO.LimitTypeListDTO.TypeDTO typeDTO) {
        long l = System.currentTimeMillis() / 1000L;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("interstitialFast ExpireTime: ");
        stringBuilder.append(typeDTO.getExpireTime());
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        if (this.interstitialFastCycle != 0L && l - (long)typeDTO.getExpireTime() <= this.interstitialFastCycle) {
            ++this.interstitialFast;
        } else {
            this.interstitialFastCycle = l;
            SpUtils.saveData((String)"interstitial_fast_cycle", (Object)l);
            this.interstitialFast = 1;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("interstitialFast: ");
        stringBuilder.append(this.interstitialFast);
        stringBuilder.append("  interstitialFastCycle: ");
        stringBuilder.append(this.interstitialFastCycle);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        SpUtils.saveData((String)"interstitial_fast_times", (Object)this.interstitialFast);
        if (this.interstitialFast < typeDTO.getLimitNum()) return;
        stringBuilder = new StringBuilder();
        stringBuilder.append("\u8fde\u7eed\u9650\u5236: ");
        stringBuilder.append(this.interstitialFast);
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        this.interstitialFast = 0;
        this.interstitialFastCycle = 0L;
        SpUtils.saveData((String)"interstitial_fast_cycle", (Object)0L);
        this.setInterstitialNextTime(l + (long)typeDTO.getHideTime());
    }

    private void setTotalLimit(AdvertConfigBean.ConfigBean.AdvertLimitDTO.LimitDTO.LimitItemDTO.LimitTypeListDTO.TypeDTO typeDTO) {
        long l = System.currentTimeMillis() / 1000L;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("interstitialTotal ExpireTime: ");
        stringBuilder.append(typeDTO.getExpireTime());
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        if (this.interstitialTotalCycle != 0L && l - (long)typeDTO.getExpireTime() <= this.interstitialTotalCycle) {
            ++this.interstitialTotal;
        } else {
            this.interstitialTotalCycle = l;
            SpUtils.saveData((String)"interstitial_total_cycle", (Object)l);
            this.interstitialTotal = 1;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("interstitialTotal: ");
        stringBuilder.append(this.interstitialTotal);
        stringBuilder.append("  interstitialTotalCycle: ");
        stringBuilder.append(this.interstitialTotalCycle);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        SpUtils.saveData((String)"interstitial_total_times", (Object)this.interstitialTotal);
        if (this.interstitialTotal < typeDTO.getLimitNum()) return;
        stringBuilder = new StringBuilder();
        stringBuilder.append("\u603b\u6570\u9650\u5236: ");
        stringBuilder.append(this.interstitialFast);
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        this.interstitialTotal = 0;
        this.interstitialTotalCycle = 0L;
        SpUtils.saveData((String)"interstitial_total_cycle", (Object)0L);
        this.setInterstitialNextTime(l + (long)typeDTO.getHideTime());
    }

    public AdvertConfigBean.ConfigBean.AdvertLimitDTO.LimitDTO.LimitItemDTO getAdvertLimit(int n, String string) {
        AdvertConfigBean.ConfigBean.AdvertLimitDTO.LimitDTO.LimitItemDTO limitItemDTO;
        Object object = MApplication.getInstance().getAdvertConfigBean();
        AdvertConfigBean.ConfigBean configBean = object.getConfig();
        AdvertConfigBean.ConfigBean.AdvertLimitDTO.LimitDTO.LimitItemDTO limitItemDTO2 = limitItemDTO = null;
        if (configBean == null) return limitItemDTO2;
        limitItemDTO2 = limitItemDTO;
        if (object.getConfig().getAdvertLimit() == null) return limitItemDTO2;
        object = n != 1 ? (n != 2 ? (n != 3 ? (n != 4 ? null : object.getConfig().getAdvertLimit().getOnError()) : object.getConfig().getAdvertLimit().getOnClick()) : object.getConfig().getAdvertLimit().getOnShow()) : object.getConfig().getAdvertLimit().getOnLoad();
        limitItemDTO2 = limitItemDTO;
        if (object == null) return limitItemDTO2;
        limitItemDTO2 = limitItemDTO;
        if (!POSITION_INTERSTITIAL.equals(string)) return limitItemDTO2;
        limitItemDTO2 = object.get$6();
        return limitItemDTO2;
    }

    public long getInterstitialNextTime() {
        return this.interstitialNextTime;
    }

    public boolean isShowAd() {
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("advert_census interstitialHideTime: ");
        ((StringBuilder)charSequence).append(this.interstitialHideTime);
        ((StringBuilder)charSequence).append("      ");
        ((StringBuilder)charSequence).append(this.interstitialHideTime - System.currentTimeMillis() / 1000L);
        charSequence = ((StringBuilder)charSequence).toString();
        boolean bl = false;
        Logger.w((String)charSequence, (Object[])new Object[0]);
        long l = this.interstitialHideTime;
        boolean bl2 = bl;
        if (l == 0L) return bl2;
        if (l - System.currentTimeMillis() / 1000L > 0L) {
            bl2 = bl;
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("advert_census interstitialNextTime: ");
            ((StringBuilder)charSequence).append(this.interstitialNextTime - System.currentTimeMillis() / 1000L);
            Logger.w((String)((StringBuilder)charSequence).toString(), (Object[])new Object[0]);
            bl2 = bl;
            if (this.interstitialNextTime - System.currentTimeMillis() / 1000L > 0L) return bl2;
            bl2 = true;
        }
        return bl2;
    }

    public void setAdvertLimit(AdvertReportBean advertReportBean) {
        if (advertReportBean.getAffectPosition() == null) return;
        if (advertReportBean.getAffectPosition().size() <= 0) return;
        if (!advertReportBean.getAffectPosition().contains(POSITION_INTERSTITIAL)) return;
        this.interstitialHideTime = advertReportBean.getHideTime() == 0 ? 0L : System.currentTimeMillis() / 1000L + (long)advertReportBean.getHideTime();
        SpUtils.saveData((String)"advert_interstitial_hide_time", (Object)this.interstitialHideTime);
        this.setInterstitialNextTime(System.currentTimeMillis() / 1000L + (long)advertReportBean.getNextTime());
    }

    public void setInterstitialNextTime(long l) {
        this.interstitialNextTime = l = Math.max(this.interstitialNextTime, l);
        SpUtils.saveData((String)"advert_interstitial_next_time", (Object)l);
    }

    public void setNextLimit(AdvertConfigBean.ConfigBean.AdvertLimitDTO.LimitDTO.LimitItemDTO limitItemDTO) {
        long l = this.getCurrentTimeSeconds();
        long l2 = limitItemDTO.getNextTime();
        Iterator iterator = limitItemDTO.getAffectPosition().iterator();
        while (iterator.hasNext()) {
            if (!POSITION_INTERSTITIAL.equals((String)iterator.next())) continue;
            this.setInterstitialNextTime(l + l2);
            if (limitItemDTO.getLimitTypeList().getTotal() != null) {
                this.setTotalLimit(limitItemDTO.getLimitTypeList().getTotal());
            }
            if (limitItemDTO.getLimitTypeList().getFast() == null) continue;
            this.setFastLimit(limitItemDTO.getLimitTypeList().getFast());
        }
    }
}
