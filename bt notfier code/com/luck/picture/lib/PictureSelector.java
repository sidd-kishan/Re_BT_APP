/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  androidx.fragment.app.Fragment
 *  com.luck.picture.lib.PictureExternalPreviewActivity
 *  com.luck.picture.lib.PicturePlayAudioActivity
 *  com.luck.picture.lib.PictureSelectionModel
 *  com.luck.picture.lib.PictureVideoPlayActivity
 *  com.luck.picture.lib.R$anim
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.style.PictureParameterStyle
 *  com.luck.picture.lib.tools.DoubleUtils
 */
package com.luck.picture.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.luck.picture.lib.PictureExternalPreviewActivity;
import com.luck.picture.lib.PicturePlayAudioActivity;
import com.luck.picture.lib.PictureSelectionModel;
import com.luck.picture.lib.PictureVideoPlayActivity;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.tools.DoubleUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class PictureSelector {
    private final WeakReference<Activity> mActivity;
    private final WeakReference<Fragment> mFragment;

    private PictureSelector(Activity activity) {
        this(activity, null);
    }

    private PictureSelector(Activity activity, Fragment fragment) {
        this.mActivity = new WeakReference<Activity>(activity);
        this.mFragment = new WeakReference<Fragment>(fragment);
    }

    private PictureSelector(Fragment fragment) {
        this((Activity)fragment.getActivity(), fragment);
    }

    public static PictureSelector create(Activity activity) {
        return new PictureSelector(activity);
    }

    public static PictureSelector create(Fragment fragment) {
        return new PictureSelector(fragment);
    }

    public static List<LocalMedia> obtainMultipleResult(Intent object) {
        if (object == null) return new ArrayList<LocalMedia>();
        ArrayList arrayList = object.getParcelableArrayListExtra("extra_result_media");
        object = arrayList;
        if (arrayList != null) return object;
        object = new ArrayList();
        return object;
    }

    public static List<LocalMedia> obtainSelectorList(Bundle bundle) {
        if (bundle == null) return null;
        return bundle.getParcelableArrayList("selectList");
    }

    public static Intent putIntentResult(List<LocalMedia> list) {
        return new Intent().putParcelableArrayListExtra("extra_result_media", (ArrayList)list);
    }

    public static void saveSelectorList(Bundle bundle, List<LocalMedia> list) {
        bundle.putParcelableArrayList("selectList", (ArrayList)list);
    }

    public void externalPictureAudio(String string) {
        if (DoubleUtils.isFastDoubleClick()) return;
        if (this.getActivity() == null) throw new NullPointerException("Starting the PictureSelector Activity cannot be empty ");
        Intent intent = new Intent((Context)this.getActivity(), PicturePlayAudioActivity.class);
        intent.putExtra("audioPath", string);
        this.getActivity().startActivity(intent);
        this.getActivity().overridePendingTransition(R.anim.picture_anim_enter, 0);
    }

    public void externalPicturePreview(int n, String string, List<LocalMedia> list, int n2) {
        if (DoubleUtils.isFastDoubleClick()) return;
        if (this.getActivity() == null) throw new NullPointerException("Starting the PictureSelector Activity cannot be empty ");
        Intent intent = new Intent((Context)this.getActivity(), PictureExternalPreviewActivity.class);
        intent.putParcelableArrayListExtra("previewSelectList", (ArrayList)list);
        intent.putExtra("position", n);
        intent.putExtra("directory_path", string);
        this.getActivity().startActivity(intent);
        string = this.getActivity();
        if (n2 == 0) {
            n2 = R.anim.picture_anim_enter;
        }
        string.overridePendingTransition(n2, R.anim.picture_anim_fade_in);
    }

    public void externalPicturePreview(int n, List<LocalMedia> activity, int n2) {
        if (DoubleUtils.isFastDoubleClick()) return;
        if (this.getActivity() == null) throw new NullPointerException("Starting the PictureSelector Activity cannot be empty ");
        Intent intent = new Intent((Context)this.getActivity(), PictureExternalPreviewActivity.class);
        intent.putParcelableArrayListExtra("previewSelectList", (ArrayList)activity);
        intent.putExtra("position", n);
        this.getActivity().startActivity(intent);
        activity = this.getActivity();
        if (n2 == 0) {
            n2 = R.anim.picture_anim_enter;
        }
        activity.overridePendingTransition(n2, R.anim.picture_anim_fade_in);
    }

    public void externalPictureVideo(String string) {
        if (DoubleUtils.isFastDoubleClick()) return;
        if (this.getActivity() == null) throw new NullPointerException("Starting the PictureSelector Activity cannot be empty ");
        Intent intent = new Intent((Context)this.getActivity(), PictureVideoPlayActivity.class);
        intent.putExtra("videoPath", string);
        intent.putExtra("isExternalPreviewVideo", true);
        this.getActivity().startActivity(intent);
    }

    Activity getActivity() {
        return (Activity)this.mActivity.get();
    }

    Fragment getFragment() {
        Object object = this.mFragment;
        object = object != null ? (Fragment)object.get() : null;
        return object;
    }

    public PictureSelectionModel openCamera(int n) {
        return new PictureSelectionModel(this, n, true);
    }

    public PictureSelectionModel openGallery(int n) {
        return new PictureSelectionModel(this, n);
    }

    public PictureSelectionModel setPictureStyle(PictureParameterStyle pictureParameterStyle) {
        return new PictureSelectionModel(this, PictureMimeType.ofImage()).setPictureStyle(pictureParameterStyle);
    }

    public PictureSelectionModel themeStyle(int n) {
        return new PictureSelectionModel(this, PictureMimeType.ofImage()).theme(n);
    }
}
