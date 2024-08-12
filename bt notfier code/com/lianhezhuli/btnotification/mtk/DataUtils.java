/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.schedulers.Schedulers
 */
package com.lianhezhuli.btnotification.mtk;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;

public class DataUtils {
    public static void handleGet1Data(String string) {
        if (string.equals("")) return;
        Observable.fromArray((Object[])string.split("\\,")).observeOn(Schedulers.io()).subscribe((Observer)new /* Unavailable Anonymous Inner Class!! */);
    }
}
