/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.os.Build$VERSION
 *  android.view.ViewOutlineProvider
 *  android.widget.ImageView
 *  androidx.appcompat.widget.AppCompatImageButton
 *  androidx.constraintlayout.utils.widget.ImageFilterButton$1
 *  androidx.constraintlayout.utils.widget.ImageFilterButton$2
 *  androidx.constraintlayout.utils.widget.ImageFilterView$ImageMatrix
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R;

public class ImageFilterButton
extends AppCompatImageButton {
    private float mCrossfade = 0.0f;
    private ImageFilterView.ImageMatrix mImageMatrix = new ImageFilterView.ImageMatrix();
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay = true;
    private Path mPath;
    RectF mRect;
    private float mRound = Float.NaN;
    private float mRoundPercent = 0.0f;
    ViewOutlineProvider mViewOutlineProvider;

    public ImageFilterButton(Context context) {
        super(context);
        this.init(context, null);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet);
    }

    static /* synthetic */ float access$000(ImageFilterButton imageFilterButton) {
        return imageFilterButton.mRoundPercent;
    }

    static /* synthetic */ float access$100(ImageFilterButton imageFilterButton) {
        return imageFilterButton.mRound;
    }

    private void init(Context context, AttributeSet drawableArray) {
        this.setPadding(0, 0, 0, 0);
        if (drawableArray == null) return;
        drawableArray = this.getContext().obtainStyledAttributes((AttributeSet)drawableArray, R.styleable.ImageFilterView);
        int n = drawableArray.getIndexCount();
        context = drawableArray.getDrawable(R.styleable.ImageFilterView_altSrc);
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                drawableArray.recycle();
                if (context == null) return;
                drawableArray = new Drawable[2];
                this.mLayers = drawableArray;
                drawableArray[0] = this.getDrawable();
                this.mLayers[1] = context;
                context = new LayerDrawable(this.mLayers);
                this.mLayer = context;
                context.getDrawable(1).setAlpha((int)(this.mCrossfade * 255.0f));
                super.setImageDrawable((Drawable)this.mLayer);
                return;
            }
            int n3 = drawableArray.getIndex(n2);
            if (n3 == R.styleable.ImageFilterView_crossfade) {
                this.mCrossfade = drawableArray.getFloat(n3, 0.0f);
            } else if (n3 == R.styleable.ImageFilterView_warmth) {
                this.setWarmth(drawableArray.getFloat(n3, 0.0f));
            } else if (n3 == R.styleable.ImageFilterView_saturation) {
                this.setSaturation(drawableArray.getFloat(n3, 0.0f));
            } else if (n3 == R.styleable.ImageFilterView_contrast) {
                this.setContrast(drawableArray.getFloat(n3, 0.0f));
            } else if (n3 == R.styleable.ImageFilterView_round) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.setRound(drawableArray.getDimension(n3, 0.0f));
                }
            } else if (n3 == R.styleable.ImageFilterView_roundPercent) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.setRoundPercent(drawableArray.getFloat(n3, 0.0f));
                }
            } else if (n3 == R.styleable.ImageFilterView_overlay) {
                this.setOverlay(drawableArray.getBoolean(n3, this.mOverlay));
            }
            ++n2;
        }
    }

    private void setOverlay(boolean bl) {
        this.mOverlay = bl;
    }

    public void draw(Canvas canvas) {
        boolean bl;
        if (Build.VERSION.SDK_INT < 21 && this.mRound != 0.0f && this.mPath != null) {
            bl = true;
            canvas.save();
            canvas.clipPath(this.mPath);
        } else {
            bl = false;
        }
        super.draw(canvas);
        if (!bl) return;
        canvas.restore();
    }

    public float getContrast() {
        return this.mImageMatrix.mContrast;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getSaturation() {
        return this.mImageMatrix.mSaturation;
    }

    public float getWarmth() {
        return this.mImageMatrix.mWarmth;
    }

    public void setBrightness(float f) {
        this.mImageMatrix.mBrightness = f;
        this.mImageMatrix.updateMatrix((ImageView)this);
    }

    public void setContrast(float f) {
        this.mImageMatrix.mContrast = f;
        this.mImageMatrix.updateMatrix((ImageView)this);
    }

    public void setCrossfade(float f) {
        this.mCrossfade = f;
        if (this.mLayers == null) return;
        if (!this.mOverlay) {
            this.mLayer.getDrawable(0).setAlpha((int)((1.0f - this.mCrossfade) * 255.0f));
        }
        this.mLayer.getDrawable(1).setAlpha((int)(this.mCrossfade * 255.0f));
        super.setImageDrawable((Drawable)this.mLayer);
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.mRound = f;
            f = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            this.setRoundPercent(f);
            return;
        }
        boolean bl = this.mRound != f;
        this.mRound = f;
        if (f != 0.0f) {
            2 var5_3;
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.mViewOutlineProvider == null) {
                    var5_3 = new /* Unavailable Anonymous Inner Class!! */;
                    this.mViewOutlineProvider = var5_3;
                    this.setOutlineProvider((ViewOutlineProvider)var5_3);
                }
                this.setClipToOutline(true);
            }
            int n = this.getWidth();
            int n2 = this.getHeight();
            this.mRect.set(0.0f, 0.0f, (float)n, (float)n2);
            this.mPath.reset();
            var5_3 = this.mPath;
            RectF rectF = this.mRect;
            f = this.mRound;
            var5_3.addRoundRect(rectF, f, f, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.setClipToOutline(false);
        }
        if (!bl) return;
        if (Build.VERSION.SDK_INT < 21) return;
        this.invalidateOutline();
    }

    public void setRoundPercent(float f) {
        boolean bl = this.mRoundPercent != f;
        this.mRoundPercent = f;
        if (f != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.mViewOutlineProvider == null) {
                    1 var5_3 = new /* Unavailable Anonymous Inner Class!! */;
                    this.mViewOutlineProvider = var5_3;
                    this.setOutlineProvider((ViewOutlineProvider)var5_3);
                }
                this.setClipToOutline(true);
            }
            int n = this.getWidth();
            int n2 = this.getHeight();
            f = (float)Math.min(n, n2) * this.mRoundPercent / 2.0f;
            this.mRect.set(0.0f, 0.0f, (float)n, (float)n2);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, f, f, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.setClipToOutline(false);
        }
        if (!bl) return;
        if (Build.VERSION.SDK_INT < 21) return;
        this.invalidateOutline();
    }

    public void setSaturation(float f) {
        this.mImageMatrix.mSaturation = f;
        this.mImageMatrix.updateMatrix((ImageView)this);
    }

    public void setWarmth(float f) {
        this.mImageMatrix.mWarmth = f;
        this.mImageMatrix.updateMatrix((ImageView)this);
    }
}
