/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.SystemClock
 *  com.google.android.gms.internal.base.zag
 *  com.google.android.gms.internal.base.zah
 */
package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.google.android.gms.internal.base.zag;
import com.google.android.gms.internal.base.zah;

public final class zai
extends Drawable
implements Drawable.Callback {
    private int zaa = 0;
    private long zab;
    private int zac;
    private int zad = 255;
    private int zae;
    private int zaf = 0;
    private boolean zag = true;
    private boolean zah;
    private zah zai;
    private Drawable zaj;
    private Drawable zak;
    private boolean zal;
    private boolean zam;
    private boolean zan;
    private int zao;

    public zai(Drawable drawable, Drawable drawable2) {
        this(null);
        Drawable drawable3 = drawable;
        if (drawable == null) {
            drawable3 = com.google.android.gms.internal.base.zag.zaa();
        }
        this.zaj = drawable3;
        drawable3.setCallback((Drawable.Callback)this);
        drawable = this.zai;
        int n = drawable.zab;
        drawable.zab = drawable3.getChangingConfigurations() | n;
        drawable = drawable2;
        if (drawable2 == null) {
            drawable = com.google.android.gms.internal.base.zag.zaa();
        }
        this.zak = drawable;
        drawable.setCallback((Drawable.Callback)this);
        drawable2 = this.zai;
        n = drawable2.zab;
        drawable2.zab = drawable.getChangingConfigurations() | n;
    }

    zai(zah zah2) {
        this.zai = new zah(zah2);
    }

    public final void draw(Canvas canvas) {
        Drawable drawable;
        Drawable drawable2;
        boolean bl;
        int n;
        block7: {
            int n2;
            block9: {
                block10: {
                    block8: {
                        int n3 = this.zaa;
                        int n4 = 0;
                        n2 = 1;
                        n = 1;
                        if (n3 != 1) {
                            if (n3 == 2 && this.zab >= 0L) {
                                float f = (float)(SystemClock.uptimeMillis() - this.zab) / (float)this.zae;
                                n2 = f >= 1.0f ? n : 0;
                                if (n2 != 0) {
                                    this.zaa = 0;
                                }
                                f = Math.min(f, 1.0f);
                                this.zaf = (int)((float)this.zac * f + 0.0f);
                            }
                        } else {
                            this.zab = SystemClock.uptimeMillis();
                            this.zaa = 2;
                            n2 = 0;
                        }
                        n = this.zaf;
                        bl = this.zag;
                        drawable2 = this.zaj;
                        drawable = this.zak;
                        if (n2 == 0) break block7;
                        if (!bl) break block8;
                        n2 = n;
                        if (n != 0) break block9;
                        n2 = n4;
                        break block10;
                    }
                    n2 = n;
                }
                drawable2.draw(canvas);
            }
            if (n2 != (n = this.zad)) return;
            drawable.setAlpha(n);
            drawable.draw(canvas);
            return;
        }
        if (bl) {
            drawable2.setAlpha(this.zad - n);
        }
        drawable2.draw(canvas);
        if (bl) {
            drawable2.setAlpha(this.zad);
        }
        if (n > 0) {
            drawable.setAlpha(n);
            drawable.draw(canvas);
            drawable.setAlpha(this.zad);
        }
        this.invalidateSelf();
    }

    public final int getChangingConfigurations() {
        int n = super.getChangingConfigurations();
        zah zah2 = this.zai;
        return n | zah2.zaa | zah2.zab;
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.zaa()) return null;
        this.zai.zaa = this.getChangingConfigurations();
        return this.zai;
    }

    public final int getIntrinsicHeight() {
        return Math.max(this.zaj.getIntrinsicHeight(), this.zak.getIntrinsicHeight());
    }

    public final int getIntrinsicWidth() {
        return Math.max(this.zaj.getIntrinsicWidth(), this.zak.getIntrinsicWidth());
    }

    public final int getOpacity() {
        if (this.zan) return this.zao;
        this.zao = Drawable.resolveOpacity((int)this.zaj.getOpacity(), (int)this.zak.getOpacity());
        this.zan = true;
        return this.zao;
    }

    public final void invalidateDrawable(Drawable drawable) {
        drawable = this.getCallback();
        if (drawable == null) return;
        drawable.invalidateDrawable((Drawable)this);
    }

    public final Drawable mutate() {
        if (this.zah) return this;
        if (super.mutate() != this) return this;
        if (!this.zaa()) throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
        this.zaj.mutate();
        this.zak.mutate();
        this.zah = true;
        return this;
    }

    protected final void onBoundsChange(Rect rect) {
        this.zaj.setBounds(rect);
        this.zak.setBounds(rect);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        drawable = this.getCallback();
        if (drawable == null) return;
        drawable.scheduleDrawable((Drawable)this, runnable, l);
    }

    public final void setAlpha(int n) {
        if (this.zaf == this.zad) {
            this.zaf = n;
        }
        this.zad = n;
        this.invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.zaj.setColorFilter(colorFilter);
        this.zak.setColorFilter(colorFilter);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        drawable = this.getCallback();
        if (drawable == null) return;
        drawable.unscheduleDrawable((Drawable)this, runnable);
    }

    public final boolean zaa() {
        boolean bl;
        if (this.zal) return this.zam;
        Drawable.ConstantState constantState = this.zaj.getConstantState();
        boolean bl2 = bl = false;
        if (constantState != null) {
            bl2 = bl;
            if (this.zak.getConstantState() != null) {
                bl2 = true;
            }
        }
        this.zam = bl2;
        this.zal = true;
        return this.zam;
    }

    public final Drawable zab() {
        return this.zak;
    }

    public final void zac(int n) {
        this.zac = this.zad;
        this.zaf = 0;
        this.zae = 250;
        this.zaa = 1;
        this.invalidateSelf();
    }
}
