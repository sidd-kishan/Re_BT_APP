/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetFileDescriptor
 *  android.media.AudioManager
 *  android.media.MediaPlayer
 *  android.media.RingtoneManager
 *  android.net.Uri
 *  com.lianhezhuli.btnotification.MApplication
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import com.lianhezhuli.btnotification.MApplication;
import com.orhanobut.logger.Logger;
import java.io.IOException;

public class SoundPlayUtil {
    private static SoundPlayUtil lostPlayUtil = new SoundPlayUtil();
    private static Context mContext;
    private AssetFileDescriptor assetFileDescriptor = null;
    private boolean isNeedCloseSpeaker = false;
    private MediaPlayer player = null;

    private SoundPlayUtil() {
    }

    public static SoundPlayUtil getLostPlayUtil() {
        return lostPlayUtil;
    }

    private void init() {
        this.player = new MediaPlayer();
        try {
            this.assetFileDescriptor = mContext.getAssets().openFd("findPhone.mp3");
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static void init(Context context) {
        mContext = context;
    }

    public void play() {
        if (this.player == null) {
            this.init();
        }
        this.stop();
        AudioManager audioManager = (AudioManager)mContext.getSystemService("audio");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mode == ");
        stringBuilder.append(audioManager.getMode());
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        stringBuilder = new StringBuilder();
        stringBuilder.append("Speaker == ");
        stringBuilder.append(audioManager.isSpeakerphoneOn());
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        if (!audioManager.isSpeakerphoneOn()) {
            this.isNeedCloseSpeaker = true;
            audioManager.setSpeakerphoneOn(true);
            audioManager.setMode(3);
            stringBuilder = new StringBuilder();
            stringBuilder.append("mode == ");
            stringBuilder.append(audioManager.getMode());
            Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        }
        this.player.reset();
        try {
            this.player.setDataSource(this.assetFileDescriptor.getFileDescriptor(), this.assetFileDescriptor.getStartOffset(), this.assetFileDescriptor.getLength());
            this.player.prepare();
            this.player.setLooping(true);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        this.player.start();
    }

    public void playSysSound() {
        Uri uri = RingtoneManager.getDefaultUri((int)2);
        RingtoneManager.getRingtone((Context)MApplication.getInstance(), (Uri)uri).play();
    }

    public void stop() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) return;
        if (!mediaPlayer.isPlaying()) return;
        this.player.stop();
        this.player.reset();
        if (!this.isNeedCloseSpeaker) return;
        this.isNeedCloseSpeaker = false;
        mediaPlayer = (AudioManager)mContext.getSystemService("audio");
        mediaPlayer.setMode(0);
        mediaPlayer.setSpeakerphoneOn(false);
    }
}
