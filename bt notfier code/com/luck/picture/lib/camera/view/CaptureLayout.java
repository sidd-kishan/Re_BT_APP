/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.graphics.ColorFilter
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  androidx.core.graphics.BlendModeColorFilterCompat
 *  androidx.core.graphics.BlendModeCompat
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.camera.listener.CaptureListener
 *  com.luck.picture.lib.camera.listener.ClickListener
 *  com.luck.picture.lib.camera.listener.TypeListener
 *  com.luck.picture.lib.camera.view.CaptureButton
 *  com.luck.picture.lib.camera.view.ReturnButton
 *  com.luck.picture.lib.camera.view.TypeButton
 *  com.luck.picture.lib.camera.view._$$Lambda$CaptureLayout$EIAJBQTp9uVZFtNpztk_ArhTwDU
 *  com.luck.picture.lib.camera.view._$$Lambda$CaptureLayout$P_OamMc0q4THvRB7H8rsKV2iVhM
 *  com.luck.picture.lib.camera.view._$$Lambda$CaptureLayout$kZ0kmRTcw2M6aC2hQJizU7pmIqE
 *  com.luck.picture.lib.camera.view._$$Lambda$CaptureLayout$qNcAAutElAntmysN7y5xr4DRD9E
 *  com.luck.picture.lib.camera.view._$$Lambda$CaptureLayout$sarZn45DlL91cEzsza6R3XJ9q5Q
 *  com.luck.picture.lib.tools.ScreenUtils
 */
package com.luck.picture.lib.camera.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.luck.picture.lib.R;
import com.luck.picture.lib.camera.listener.CaptureListener;
import com.luck.picture.lib.camera.listener.ClickListener;
import com.luck.picture.lib.camera.listener.TypeListener;
import com.luck.picture.lib.camera.view.CaptureButton;
import com.luck.picture.lib.camera.view.ReturnButton;
import com.luck.picture.lib.camera.view.TypeButton;
import com.luck.picture.lib.camera.view._$;
import com.luck.picture.lib.tools.ScreenUtils;

public class CaptureLayout
extends FrameLayout {
    private TypeButton btn_cancel;
    private CaptureButton btn_capture;
    private TypeButton btn_confirm;
    private ReturnButton btn_return;
    private final int button_size;
    private CaptureListener captureListener;
    private int iconLeft = 0;
    private int iconRight = 0;
    private ImageView iv_custom_left;
    private ImageView iv_custom_right;
    private final int layout_height;
    private final int layout_width;
    private ClickListener leftClickListener;
    private ProgressBar progress_bar;
    private ClickListener rightClickListener;
    private TextView txt_tip;
    private TypeListener typeListener;

    public CaptureLayout(Context context) {
        this(context, null);
    }

    public CaptureLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptureLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        n = ScreenUtils.getScreenWidth((Context)this.getContext());
        this.layout_width = this.getResources().getConfiguration().orientation == 1 ? n : n / 2;
        this.button_size = n = (int)((float)this.layout_width / 4.5f);
        this.layout_height = n + n / 5 * 2 + 100;
        this.initView();
        this.initEvent();
    }

    static /* synthetic */ TypeButton access$000(CaptureLayout captureLayout) {
        return captureLayout.btn_cancel;
    }

    static /* synthetic */ TypeButton access$100(CaptureLayout captureLayout) {
        return captureLayout.btn_confirm;
    }

    static /* synthetic */ CaptureListener access$200(CaptureLayout captureLayout) {
        return captureLayout.captureListener;
    }

    static /* synthetic */ String access$300(CaptureLayout captureLayout) {
        return captureLayout.getCaptureTip();
    }

    static /* synthetic */ TextView access$400(CaptureLayout captureLayout) {
        return captureLayout.txt_tip;
    }

    private String getCaptureTip() {
        int n = this.btn_capture.getButtonFeatures();
        if (n == 257) return this.getContext().getString(R.string.picture_photo_pictures);
        if (n == 258) return this.getContext().getString(R.string.picture_photo_recording);
        return this.getContext().getString(R.string.picture_photo_camera);
    }

    private void initView() {
        this.setWillNotDraw(false);
        this.progress_bar = new ProgressBar(this.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.progress_bar.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.progress_bar.setVisibility(8);
        this.btn_capture = new CaptureButton(this.getContext(), this.button_size);
        layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.btn_capture.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.btn_capture.setCaptureListener((CaptureListener)new /* Unavailable Anonymous Inner Class!! */);
        this.btn_cancel = new TypeButton(this.getContext(), 1, this.button_size);
        layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 16;
        layoutParams.setMargins(this.layout_width / 4 - this.button_size / 2, 0, 0, 0);
        this.btn_cancel.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.btn_cancel.setOnClickListener((View.OnClickListener)new _$.Lambda.CaptureLayout.kZ0kmRTcw2M6aC2hQJizU7pmIqE(this));
        this.btn_confirm = new TypeButton(this.getContext(), 2, this.button_size);
        layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 21;
        layoutParams.setMargins(0, 0, this.layout_width / 4 - this.button_size / 2, 0);
        this.btn_confirm.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.btn_confirm.setOnClickListener((View.OnClickListener)new _$.Lambda.CaptureLayout.EIAJBQTp9uVZFtNpztk_ArhTwDU(this));
        this.btn_return = new ReturnButton(this.getContext(), (int)((float)this.button_size / 2.5f));
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.setMargins(this.layout_width / 6, 0, 0, 0);
        this.btn_return.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.btn_return.setOnClickListener((View.OnClickListener)new _$.Lambda.CaptureLayout.P_OamMc0q4THvRB7H8rsKV2iVhM(this));
        this.iv_custom_left = new ImageView(this.getContext());
        int n = this.button_size;
        layoutParams = new FrameLayout.LayoutParams((int)((float)n / 2.5f), (int)((float)n / 2.5f));
        layoutParams.gravity = 16;
        layoutParams.setMargins(this.layout_width / 6, 0, 0, 0);
        this.iv_custom_left.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.iv_custom_left.setOnClickListener((View.OnClickListener)new _$.Lambda.CaptureLayout.qNcAAutElAntmysN7y5xr4DRD9E(this));
        this.iv_custom_right = new ImageView(this.getContext());
        n = this.button_size;
        layoutParams = new FrameLayout.LayoutParams((int)((float)n / 2.5f), (int)((float)n / 2.5f));
        layoutParams.gravity = 21;
        layoutParams.setMargins(0, 0, this.layout_width / 6, 0);
        this.iv_custom_right.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.iv_custom_right.setOnClickListener((View.OnClickListener)new _$.Lambda.CaptureLayout.sarZn45DlL91cEzsza6R3XJ9q5Q(this));
        this.txt_tip = new TextView(this.getContext());
        layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        layoutParams.setMargins(0, 0, 0, 0);
        this.txt_tip.setText((CharSequence)this.getCaptureTip());
        this.txt_tip.setTextColor(-1);
        this.txt_tip.setGravity(17);
        this.txt_tip.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.addView((View)this.btn_capture);
        this.addView((View)this.progress_bar);
        this.addView((View)this.btn_cancel);
        this.addView((View)this.btn_confirm);
        this.addView((View)this.btn_return);
        this.addView((View)this.iv_custom_left);
        this.addView((View)this.iv_custom_right);
        this.addView((View)this.txt_tip);
    }

    public void initEvent() {
        this.iv_custom_right.setVisibility(8);
        this.btn_cancel.setVisibility(8);
        this.btn_confirm.setVisibility(8);
    }

    public /* synthetic */ void lambda$initView$0$CaptureLayout(View view) {
        view = this.typeListener;
        if (view == null) return;
        view.cancel();
    }

    public /* synthetic */ void lambda$initView$1$CaptureLayout(View view) {
        view = this.typeListener;
        if (view == null) return;
        view.confirm();
    }

    public /* synthetic */ void lambda$initView$2$CaptureLayout(View view) {
        view = this.leftClickListener;
        if (view == null) return;
        view.onClick();
    }

    public /* synthetic */ void lambda$initView$3$CaptureLayout(View view) {
        view = this.leftClickListener;
        if (view == null) return;
        view.onClick();
    }

    public /* synthetic */ void lambda$initView$4$CaptureLayout(View view) {
        view = this.rightClickListener;
        if (view == null) return;
        view.onClick();
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        this.setMeasuredDimension(this.layout_width, this.layout_height);
    }

    public void resetCaptureLayout() {
        this.btn_capture.resetState();
        this.btn_cancel.setVisibility(8);
        this.btn_confirm.setVisibility(8);
        this.btn_capture.setVisibility(0);
        this.txt_tip.setText((CharSequence)this.getCaptureTip());
        this.txt_tip.setVisibility(0);
        if (this.iconLeft != 0) {
            this.iv_custom_left.setVisibility(0);
        } else {
            this.btn_return.setVisibility(0);
        }
        if (this.iconRight == 0) return;
        this.iv_custom_right.setVisibility(0);
    }

    public void setButtonCaptureEnabled(boolean bl) {
        ProgressBar progressBar = this.progress_bar;
        int n = bl ? 8 : 0;
        progressBar.setVisibility(n);
        this.btn_capture.setButtonCaptureEnabled(bl);
    }

    public void setButtonFeatures(int n) {
        this.btn_capture.setButtonFeatures(n);
        this.txt_tip.setText((CharSequence)this.getCaptureTip());
    }

    public void setCaptureListener(CaptureListener captureListener) {
        this.captureListener = captureListener;
    }

    public void setCaptureLoadingColor(int n) {
        ColorFilter colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat((int)n, (BlendModeCompat)BlendModeCompat.SRC_IN);
        this.progress_bar.getIndeterminateDrawable().setColorFilter(colorFilter);
    }

    public void setDuration(int n) {
        this.btn_capture.setDuration(n);
    }

    public void setIconSrc(int n, int n2) {
        this.iconLeft = n;
        this.iconRight = n2;
        if (n != 0) {
            this.iv_custom_left.setImageResource(n);
            this.iv_custom_left.setVisibility(0);
            this.btn_return.setVisibility(8);
        } else {
            this.iv_custom_left.setVisibility(8);
            this.btn_return.setVisibility(0);
        }
        if (this.iconRight != 0) {
            this.iv_custom_right.setImageResource(n2);
            this.iv_custom_right.setVisibility(0);
        } else {
            this.iv_custom_right.setVisibility(8);
        }
    }

    public void setLeftClickListener(ClickListener clickListener) {
        this.leftClickListener = clickListener;
    }

    public void setMinDuration(int n) {
        this.btn_capture.setMinDuration(n);
    }

    public void setRightClickListener(ClickListener clickListener) {
        this.rightClickListener = clickListener;
    }

    public void setTextWithAnimation(String string2) {
        this.txt_tip.setText((CharSequence)string2);
        string2 = ObjectAnimator.ofFloat((Object)this.txt_tip, (String)"alpha", (float[])new float[]{0.0f, 1.0f, 1.0f, 0.0f});
        string2.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        string2.setDuration(2500L);
        string2.start();
    }

    public void setTip(String string2) {
        this.txt_tip.setText((CharSequence)string2);
    }

    public void setTypeListener(TypeListener typeListener) {
        this.typeListener = typeListener;
    }

    public void showTip() {
        this.txt_tip.setVisibility(0);
    }

    public void startAlphaAnimation() {
        this.txt_tip.setVisibility(4);
    }

    public void startTypeBtnAnimator() {
        if (this.iconLeft != 0) {
            this.iv_custom_left.setVisibility(8);
        } else {
            this.btn_return.setVisibility(8);
        }
        if (this.iconRight != 0) {
            this.iv_custom_right.setVisibility(8);
        }
        this.btn_capture.setVisibility(8);
        this.btn_cancel.setVisibility(0);
        this.btn_confirm.setVisibility(0);
        this.btn_cancel.setClickable(false);
        this.btn_confirm.setClickable(false);
        this.iv_custom_left.setVisibility(8);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)this.btn_cancel, (String)"translationX", (float[])new float[]{this.layout_width / 4, 0.0f});
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat((Object)this.btn_confirm, (String)"translationX", (float[])new float[]{-this.layout_width / 4, 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{objectAnimator, objectAnimator2});
        animatorSet.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        animatorSet.setDuration(500L);
        animatorSet.start();
    }
}
