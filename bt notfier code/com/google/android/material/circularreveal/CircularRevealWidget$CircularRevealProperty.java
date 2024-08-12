/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Property
 *  com.google.android.material.circularreveal.CircularRevealWidget
 *  com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo
 */
package com.google.android.material.circularreveal;

import android.util.Property;
import com.google.android.material.circularreveal.CircularRevealWidget;

public static class CircularRevealWidget.CircularRevealProperty
extends Property<CircularRevealWidget, CircularRevealWidget.RevealInfo> {
    public static final Property<CircularRevealWidget, CircularRevealWidget.RevealInfo> CIRCULAR_REVEAL = new CircularRevealWidget.CircularRevealProperty("circularReveal");

    private CircularRevealWidget.CircularRevealProperty(String string) {
        super(CircularRevealWidget.RevealInfo.class, string);
    }

    public CircularRevealWidget.RevealInfo get(CircularRevealWidget circularRevealWidget) {
        return circularRevealWidget.getRevealInfo();
    }

    public void set(CircularRevealWidget circularRevealWidget, CircularRevealWidget.RevealInfo revealInfo) {
        circularRevealWidget.setRevealInfo(revealInfo);
    }
}
