/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnInfoListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.MediaController
 *  android.widget.TextView
 *  android.widget.VideoView
 *  com.luck.picture.lib.PictureBaseActivity
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib._$$Lambda$PictureVideoPlayActivity$DNFN5pLYR9l_TVTxpNZuBqNp9Gg
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.tools.SdkVersionUtils
 */
package com.luck.picture.lib;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import com.luck.picture.lib.PictureBaseActivity;
import com.luck.picture.lib.R;
import com.luck.picture.lib._$;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.SdkVersionUtils;
import java.util.ArrayList;

public class PictureVideoPlayActivity
extends PictureBaseActivity
implements MediaPlayer.OnErrorListener,
MediaPlayer.OnPreparedListener,
MediaPlayer.OnCompletionListener,
View.OnClickListener {
    private ImageButton ibLeftBack;
    private ImageView iv_play;
    private MediaController mMediaController;
    private int mPositionWhenPaused = -1;
    private VideoView mVideoView;
    private String videoPath;

    protected void attachBaseContext(Context context) {
        super.attachBaseContext((Context)new /* Unavailable Anonymous Inner Class!! */);
    }

    public int getResourceId() {
        return R.layout.picture_activity_video_play;
    }

    protected void initPictureSelectorStyle() {
        if (PictureSelectionConfig.style == null) return;
        if (PictureSelectionConfig.style.pictureLeftBackIcon == 0) return;
        this.ibLeftBack.setImageResource(PictureSelectionConfig.style.pictureLeftBackIcon);
    }

    protected void initWidgets() {
        super.initWidgets();
        this.videoPath = this.getIntent().getStringExtra("videoPath");
        Intent intent = this.getIntent();
        int n = 0;
        boolean bl = intent.getBooleanExtra("isExternalPreviewVideo", false);
        if (TextUtils.isEmpty((CharSequence)this.videoPath)) {
            intent = (LocalMedia)this.getIntent().getParcelableExtra("mediaKey");
            if (intent != null && !TextUtils.isEmpty((CharSequence)intent.getPath())) {
                this.videoPath = intent.getPath();
            } else {
                this.finish();
                return;
            }
        }
        if (TextUtils.isEmpty((CharSequence)this.videoPath)) {
            this.exit();
            return;
        }
        this.ibLeftBack = (ImageButton)this.findViewById(R.id.pictureLeftBack);
        this.mVideoView = (VideoView)this.findViewById(R.id.video_view);
        intent = (TextView)this.findViewById(R.id.tv_confirm);
        this.mVideoView.setBackgroundColor(-16777216);
        this.iv_play = (ImageView)this.findViewById(R.id.iv_play);
        this.mMediaController = new MediaController((Context)this);
        this.mVideoView.setOnCompletionListener((MediaPlayer.OnCompletionListener)this);
        this.mVideoView.setOnPreparedListener((MediaPlayer.OnPreparedListener)this);
        this.mVideoView.setMediaController(this.mMediaController);
        this.ibLeftBack.setOnClickListener((View.OnClickListener)this);
        this.iv_play.setOnClickListener((View.OnClickListener)this);
        intent.setOnClickListener((View.OnClickListener)this);
        if (this.config.selectionMode != 1 || !this.config.enPreviewVideo || bl) {
            n = 8;
        }
        intent.setVisibility(n);
    }

    public boolean isImmersive() {
        return false;
    }

    public boolean isRequestedOrientation() {
        return false;
    }

    public /* synthetic */ boolean lambda$onPrepared$0$PictureVideoPlayActivity(MediaPlayer mediaPlayer, int n, int n2) {
        boolean bl = false;
        if (n != 3) return bl;
        this.mVideoView.setBackgroundColor(0);
        bl = true;
        return bl;
    }

    public void onBackPressed() {
        if (PictureSelectionConfig.windowAnimationStyle != null && PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation != 0) {
            this.finish();
            this.overridePendingTransition(0, PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation);
        } else {
            this.exit();
        }
    }

    public void onClick(View object) {
        int n = object.getId();
        if (n == R.id.pictureLeftBack) {
            this.onBackPressed();
        } else if (n == R.id.iv_play) {
            this.mVideoView.start();
            this.iv_play.setVisibility(4);
        } else {
            if (n != R.id.tv_confirm) return;
            object = new ArrayList();
            object.add(this.getIntent().getParcelableExtra("mediaKey"));
            this.setResult(-1, new Intent().putParcelableArrayListExtra("selectList", (ArrayList)object));
            this.onBackPressed();
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer = this.iv_play;
        if (mediaPlayer == null) return;
        mediaPlayer.setVisibility(0);
    }

    protected void onCreate(Bundle bundle) {
        this.getWindow().addFlags(0x4000000);
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        this.mMediaController = null;
        this.mVideoView = null;
        this.iv_play = null;
        super.onDestroy();
    }

    public boolean onError(MediaPlayer mediaPlayer, int n, int n2) {
        return false;
    }

    public void onPause() {
        this.mPositionWhenPaused = this.mVideoView.getCurrentPosition();
        this.mVideoView.stopPlayback();
        super.onPause();
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.setOnInfoListener((MediaPlayer.OnInfoListener)new _$.Lambda.PictureVideoPlayActivity.DNFN5pLYR9l_TVTxpNZuBqNp9Gg(this));
    }

    public void onResume() {
        int n = this.mPositionWhenPaused;
        if (n >= 0) {
            this.mVideoView.seekTo(n);
            this.mPositionWhenPaused = -1;
        }
        super.onResume();
    }

    public void onStart() {
        if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent((String)this.videoPath)) {
            this.mVideoView.setVideoURI(Uri.parse((String)this.videoPath));
        } else {
            this.mVideoView.setVideoPath(this.videoPath);
        }
        this.mVideoView.start();
        super.onStart();
    }
}
