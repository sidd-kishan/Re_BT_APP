/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.fragment.app.DialogFragment
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$style
 *  com.luck.picture.lib.listener.OnItemClickListener
 *  com.luck.picture.lib.tools.ScreenUtils
 */
package com.luck.picture.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.luck.picture.lib.R;
import com.luck.picture.lib.listener.OnItemClickListener;
import com.luck.picture.lib.tools.ScreenUtils;

public class PhotoItemSelectedDialog
extends DialogFragment
implements View.OnClickListener {
    public static final int IMAGE_CAMERA = 0;
    public static final int VIDEO_CAMERA = 1;
    private OnItemClickListener onItemClickListener;
    private TextView tvPictureCancel;
    private TextView tvPicturePhoto;
    private TextView tvPictureVideo;

    private void initDialogStyle() {
        Dialog dialog = this.getDialog();
        if (dialog == null) return;
        if ((dialog = dialog.getWindow()) == null) return;
        dialog.setLayout(ScreenUtils.getScreenWidth((Context)this.getContext()), -2);
        dialog.setGravity(80);
        dialog.setWindowAnimations(R.style.PictureThemeDialogFragmentAnim);
    }

    public static PhotoItemSelectedDialog newInstance() {
        return new PhotoItemSelectedDialog();
    }

    public void onClick(View view) {
        int n = view.getId();
        if (this.onItemClickListener != null) {
            if (n == R.id.picture_tv_photo) {
                this.onItemClickListener.onItemClick(view, 0);
            }
            if (n == R.id.picture_tv_video) {
                this.onItemClickListener.onItemClick(view, 1);
            }
        }
        this.dismissAllowingStateLoss();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.getDialog() == null) return layoutInflater.inflate(R.layout.picture_dialog_camera_selected, viewGroup);
        this.getDialog().requestWindowFeature(1);
        if (this.getDialog().getWindow() == null) return layoutInflater.inflate(R.layout.picture_dialog_camera_selected, viewGroup);
        this.getDialog().getWindow().setBackgroundDrawableResource(17170445);
        return layoutInflater.inflate(R.layout.picture_dialog_camera_selected, viewGroup);
    }

    public void onStart() {
        super.onStart();
        this.initDialogStyle();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.tvPicturePhoto = (TextView)view.findViewById(R.id.picture_tv_photo);
        this.tvPictureVideo = (TextView)view.findViewById(R.id.picture_tv_video);
        this.tvPictureCancel = (TextView)view.findViewById(R.id.picture_tv_cancel);
        this.tvPictureVideo.setOnClickListener((View.OnClickListener)this);
        this.tvPicturePhoto.setOnClickListener((View.OnClickListener)this);
        this.tvPictureCancel.setOnClickListener((View.OnClickListener)this);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void show(FragmentManager fragmentManager, String string) {
        fragmentManager = fragmentManager.beginTransaction();
        fragmentManager.add((Fragment)this, string);
        fragmentManager.commitAllowingStateLoss();
    }
}
