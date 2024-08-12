/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  android.widget.TextView
 *  com.luck.picture.lib.PictureBaseActivity
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib._$$Lambda$PicturePlayAudioActivity$70_FOK03fPFKtmMgo6e04t31vk0
 *  com.luck.picture.lib._$$Lambda$PicturePlayAudioActivity$oyJ9TrUdEKdDxQsh55D_kq_sL_8
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.tools.SdkVersionUtils
 */
package com.luck.picture.lib;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.luck.picture.lib.PictureBaseActivity;
import com.luck.picture.lib.R;
import com.luck.picture.lib._$;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.tools.SdkVersionUtils;

@Deprecated
public class PicturePlayAudioActivity
extends PictureBaseActivity
implements View.OnClickListener {
    private String audio_path;
    public Handler handler = new Handler();
    private boolean isPlayAudio = false;
    private MediaPlayer mediaPlayer;
    private SeekBar musicSeekBar;
    public Runnable runnable = new /* Unavailable Anonymous Inner Class!! */;
    private TextView tv_PlayPause;
    private TextView tv_musicStatus;
    private TextView tv_musicTime;
    private TextView tv_musicTotal;

    static /* synthetic */ MediaPlayer access$000(PicturePlayAudioActivity picturePlayAudioActivity) {
        return picturePlayAudioActivity.mediaPlayer;
    }

    static /* synthetic */ TextView access$100(PicturePlayAudioActivity picturePlayAudioActivity) {
        return picturePlayAudioActivity.tv_musicTime;
    }

    static /* synthetic */ SeekBar access$200(PicturePlayAudioActivity picturePlayAudioActivity) {
        return picturePlayAudioActivity.musicSeekBar;
    }

    static /* synthetic */ TextView access$300(PicturePlayAudioActivity picturePlayAudioActivity) {
        return picturePlayAudioActivity.tv_musicTotal;
    }

    private void initPlayer(String string) {
        this.mediaPlayer = new MediaPlayer();
        try {
            if (PictureMimeType.isContent((String)string)) {
                this.mediaPlayer.setDataSource(this.getContext(), Uri.parse((String)string));
            } else {
                this.mediaPlayer.setDataSource(string);
            }
            this.mediaPlayer.prepare();
            this.mediaPlayer.setLooping(true);
            this.playAudio();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void playAudio() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            this.musicSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            this.musicSeekBar.setMax(this.mediaPlayer.getDuration());
        }
        if (this.tv_PlayPause.getText().toString().equals(this.getString(R.string.picture_play_audio))) {
            this.tv_PlayPause.setText((CharSequence)this.getString(R.string.picture_pause_audio));
            this.tv_musicStatus.setText((CharSequence)this.getString(R.string.picture_play_audio));
            this.playOrPause();
        } else {
            this.tv_PlayPause.setText((CharSequence)this.getString(R.string.picture_play_audio));
            this.tv_musicStatus.setText((CharSequence)this.getString(R.string.picture_pause_audio));
            this.playOrPause();
        }
        if (this.isPlayAudio) return;
        this.handler.post(this.runnable);
        this.isPlayAudio = true;
    }

    public int getResourceId() {
        return R.layout.picture_play_audio;
    }

    protected void initWidgets() {
        super.initWidgets();
        this.audio_path = this.getIntent().getStringExtra("audioPath");
        this.tv_musicStatus = (TextView)this.findViewById(R.id.tv_musicStatus);
        this.tv_musicTime = (TextView)this.findViewById(R.id.tv_musicTime);
        this.musicSeekBar = (SeekBar)this.findViewById(R.id.musicSeekBar);
        this.tv_musicTotal = (TextView)this.findViewById(R.id.tv_musicTotal);
        this.tv_PlayPause = (TextView)this.findViewById(R.id.tv_PlayPause);
        TextView textView = (TextView)this.findViewById(R.id.tv_Stop);
        TextView textView2 = (TextView)this.findViewById(R.id.tv_Quit);
        this.handler.postDelayed((Runnable)new _$.Lambda.PicturePlayAudioActivity.70_FOK03fPFKtmMgo6e04t31vk0(this), 30L);
        this.tv_PlayPause.setOnClickListener((View.OnClickListener)this);
        textView.setOnClickListener((View.OnClickListener)this);
        textView2.setOnClickListener((View.OnClickListener)this);
        this.musicSeekBar.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public /* synthetic */ void lambda$initWidgets$0$PicturePlayAudioActivity() {
        this.initPlayer(this.audio_path);
    }

    public /* synthetic */ void lambda$onClick$1$PicturePlayAudioActivity() {
        this.stop(this.audio_path);
    }

    public void onBackPressed() {
        if (SdkVersionUtils.checkedAndroid_Q()) {
            this.finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        this.exit();
    }

    public void onClick(View view) {
        int n = view.getId();
        if (n == R.id.tv_PlayPause) {
            this.playAudio();
        }
        if (n == R.id.tv_Stop) {
            this.tv_musicStatus.setText((CharSequence)this.getString(R.string.picture_stop_audio));
            this.tv_PlayPause.setText((CharSequence)this.getString(R.string.picture_play_audio));
            this.stop(this.audio_path);
        }
        if (n != R.id.tv_Quit) return;
        this.handler.removeCallbacks(this.runnable);
        new Handler().postDelayed((Runnable)new _$.Lambda.PicturePlayAudioActivity.oyJ9TrUdEKdDxQsh55D_kq_sL_8(this), 30L);
        try {
            this.exit();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    protected void onCreate(Bundle bundle) {
        this.getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mediaPlayer == null) return;
        Handler handler = this.handler;
        if (handler == null) return;
        handler.removeCallbacks(this.runnable);
        this.mediaPlayer.release();
        this.mediaPlayer = null;
    }

    public void playOrPause() {
        try {
            if (this.mediaPlayer == null) return;
            if (this.mediaPlayer.isPlaying()) {
                this.mediaPlayer.pause();
            } else {
                this.mediaPlayer.start();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void stop(String string2) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) return;
        try {
            mediaPlayer.stop();
            this.mediaPlayer.reset();
            if (PictureMimeType.isContent((String)string2)) {
                this.mediaPlayer.setDataSource(this.getContext(), Uri.parse((String)string2));
            } else {
                this.mediaPlayer.setDataSource(string2);
            }
            this.mediaPlayer.prepare();
            this.mediaPlayer.seekTo(0);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
