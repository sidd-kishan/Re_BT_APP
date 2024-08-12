/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.animation.Interpolator
 *  android.widget.Scroller
 *  com.luck.picture.lib.widget._$$Lambda$MScroller$sVPNbk_Jzm79vbN6vF3uSPDLShw
 */
package com.luck.picture.lib.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.luck.picture.lib.widget._$;

public class MScroller
extends Scroller {
    private static final Interpolator sInterpolator = _$.Lambda.MScroller.sVPNbk_Jzm79vbN6vF3uSPDLShw.INSTANCE;
    public boolean noDuration;

    public MScroller(Context context) {
        this(context, sInterpolator);
    }

    public MScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    static /* synthetic */ float lambda$static$0(float f) {
        return (f -= 1.0f) * f * f * f * f + 1.0f;
    }

    public void setNoDuration(boolean bl) {
        this.noDuration = bl;
    }

    public void startScroll(int n, int n2, int n3, int n4, int n5) {
        if (this.noDuration) {
            super.startScroll(n, n2, n3, n4, 0);
        } else {
            super.startScroll(n, n2, n3, n4, n5);
        }
    }
}
