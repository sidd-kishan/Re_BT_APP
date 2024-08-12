/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Picture
 *  android.graphics.RectF
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.ViewUtils;

class TransitionUtils {
    private static final boolean HAS_IS_ATTACHED_TO_WINDOW;
    private static final boolean HAS_OVERLAY;
    private static final boolean HAS_PICTURE_BITMAP;
    private static final int MAX_IMAGE_SIZE = 0x100000;

    static {
        int n = Build.VERSION.SDK_INT;
        boolean bl = true;
        boolean bl2 = n >= 19;
        HAS_IS_ATTACHED_TO_WINDOW = bl2;
        bl2 = Build.VERSION.SDK_INT >= 18;
        HAS_OVERLAY = bl2;
        bl2 = Build.VERSION.SDK_INT >= 28 ? bl : false;
        HAS_PICTURE_BITMAP = bl2;
    }

    private TransitionUtils() {
    }

    static View copyViewImage(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate((float)(-view2.getScrollX()), (float)(-view2.getScrollY()));
        ViewUtils.transformMatrixToGlobal((View)view, (Matrix)matrix);
        ViewUtils.transformMatrixToLocal((View)viewGroup, (Matrix)matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float)view.getWidth(), (float)view.getHeight());
        matrix.mapRect(rectF);
        int n = Math.round(rectF.left);
        int n2 = Math.round(rectF.top);
        int n3 = Math.round(rectF.right);
        int n4 = Math.round(rectF.bottom);
        view2 = new ImageView(view.getContext());
        view2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewGroup = TransitionUtils.createViewBitmap(view, matrix, rectF, viewGroup);
        if (viewGroup != null) {
            view2.setImageBitmap((Bitmap)viewGroup);
        }
        view2.measure(View.MeasureSpec.makeMeasureSpec((int)(n3 - n), (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)(n4 - n2), (int)0x40000000));
        view2.layout(n, n2, n3, n4);
        return view2;
    }

    private static Bitmap createViewBitmap(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        int n;
        ViewGroup viewGroup2;
        boolean bl;
        boolean bl2;
        block9: {
            block8: {
                block7: {
                    if (!HAS_IS_ATTACHED_TO_WINDOW) break block7;
                    bl2 = view.isAttachedToWindow() ^ true;
                    if (viewGroup == null) break block8;
                    bl = viewGroup.isAttachedToWindow();
                    break block9;
                }
                bl2 = false;
            }
            bl = false;
        }
        boolean bl3 = HAS_OVERLAY;
        Bitmap bitmap = null;
        if (bl3 && bl2) {
            if (!bl) {
                return null;
            }
            viewGroup2 = (ViewGroup)view.getParent();
            n = viewGroup2.indexOfChild(view);
            viewGroup.getOverlay().add(view);
        } else {
            viewGroup2 = null;
            n = 0;
        }
        int n2 = Math.round(rectF.width());
        int n3 = Math.round(rectF.height());
        Bitmap bitmap2 = bitmap;
        if (n2 > 0) {
            bitmap2 = bitmap;
            if (n3 > 0) {
                float f = Math.min(1.0f, 1048576.0f / (float)(n2 * n3));
                n2 = Math.round((float)n2 * f);
                n3 = Math.round((float)n3 * f);
                matrix.postTranslate(-rectF.left, -rectF.top);
                matrix.postScale(f, f);
                if (HAS_PICTURE_BITMAP) {
                    rectF = new Picture();
                    bitmap2 = rectF.beginRecording(n2, n3);
                    bitmap2.concat(matrix);
                    view.draw((Canvas)bitmap2);
                    rectF.endRecording();
                    bitmap2 = Bitmap.createBitmap((Picture)rectF);
                } else {
                    bitmap2 = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                    rectF = new Canvas(bitmap2);
                    rectF.concat(matrix);
                    view.draw((Canvas)rectF);
                }
            }
        }
        if (!HAS_OVERLAY) return bitmap2;
        if (!bl2) return bitmap2;
        viewGroup.getOverlay().remove(view);
        viewGroup2.addView(view, n);
        return bitmap2;
    }

    static Animator mergeAnimators(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator, animator2});
        return animatorSet;
    }
}
