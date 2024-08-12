/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Property
 *  com.google.android.material.circularreveal.CircularRevealWidget
 */
package com.google.android.material.circularreveal;

import android.util.Property;
import com.google.android.material.circularreveal.CircularRevealWidget;

public static class CircularRevealWidget.CircularRevealScrimColorProperty
extends Property<CircularRevealWidget, Integer> {
    public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealWidget.CircularRevealScrimColorProperty("circularRevealScrimColor");

    private CircularRevealWidget.CircularRevealScrimColorProperty(String string) {
        super(Integer.class, string);
    }

    public Integer get(CircularRevealWidget circularRevealWidget) {
        return circularRevealWidget.getCircularRevealScrimColor();
    }

    public void set(CircularRevealWidget circularRevealWidget, Integer n) {
        circularRevealWidget.setCircularRevealScrimColor(n.intValue());
    }
}
