/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.shapes.RoundRectShape
 *  android.graphics.drawable.shapes.Shape
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzblo
 *  com.google.android.gms.internal.ads.zzblr
 *  com.google.android.gms.internal.ads.zzcgm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzblo;
import com.google.android.gms.internal.ads.zzblr;
import com.google.android.gms.internal.ads.zzcgm;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzblp
extends RelativeLayout {
    private static final float[] zza = new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private AnimationDrawable zzb;

    public zzblp(Context context, zzblo zzblo2, RelativeLayout.LayoutParams object) {
        super(context);
        Preconditions.checkNotNull((Object)zzblo2);
        ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)new RoundRectShape(zza, null, null));
        shapeDrawable.getPaint().setColor(zzblo2.zze());
        this.setLayoutParams((ViewGroup.LayoutParams)object);
        zzt.zze();
        this.setBackground((Drawable)shapeDrawable);
        object = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty((CharSequence)zzblo2.zzb())) {
            shapeDrawable = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams((ViewGroup.LayoutParams)shapeDrawable);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText((CharSequence)zzblo2.zzb());
            textView.setTextColor(zzblo2.zzf());
            textView.setTextSize((float)zzblo2.zzg());
            zzber.zza();
            int n = zzcgm.zzs((Context)context, (int)4);
            zzber.zza();
            textView.setPadding(n, 0, zzcgm.zzs((Context)context, (int)4), 0);
            this.addView((View)textView);
            object.addRule(1, textView.getId());
        }
        context = new ImageView(context);
        context.setLayoutParams((ViewGroup.LayoutParams)object);
        context.setId(1195835394);
        object = zzblo2.zzd();
        if (object == null || object.size() <= 1) {
            if (object.size() == 1) {
                try {
                    context.setImageDrawable((Drawable)ObjectWrapper.unwrap((IObjectWrapper)((zzblr)object.get(0)).zzb()));
                }
                catch (Exception exception) {
                    zze.zzg((String)"Error while getting drawable.", (Throwable)exception);
                }
            }
        } else {
            this.zzb = new AnimationDrawable();
            object = object.iterator();
            while (object.hasNext()) {
                shapeDrawable = (zzblr)object.next();
                try {
                    shapeDrawable = (Drawable)ObjectWrapper.unwrap((IObjectWrapper)shapeDrawable.zzb());
                    this.zzb.addFrame((Drawable)shapeDrawable, zzblo2.zzh());
                }
                catch (Exception exception) {
                    zze.zzg((String)"Error while getting drawable.", (Throwable)exception);
                }
            }
            zzt.zze();
            context.setBackground((Drawable)this.zzb);
        }
        this.addView((View)context);
    }

    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.zzb;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
