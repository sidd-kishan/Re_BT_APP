/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.SoundPool
 *  com.luck.picture.lib.R$raw
 */
package com.luck.picture.lib.tools;

import android.content.Context;
import android.media.SoundPool;
import com.luck.picture.lib.R;

public class VoiceUtils {
    private static VoiceUtils instance;
    private int soundID;
    private SoundPool soundPool;

    public static VoiceUtils getInstance() {
        if (instance != null) return instance;
        synchronized (VoiceUtils.class) {
            VoiceUtils voiceUtils;
            if (instance != null) return instance;
            instance = voiceUtils = new VoiceUtils();
        }
        return instance;
    }

    private void initPool(Context context) {
        SoundPool soundPool;
        if (this.soundPool != null) return;
        this.soundPool = soundPool = new SoundPool(1, 4, 0);
        this.soundID = soundPool.load(context.getApplicationContext(), R.raw.picture_music, 1);
    }

    public void init(Context context) {
        this.initPool(context);
    }

    public void play() {
        SoundPool soundPool = this.soundPool;
        if (soundPool == null) return;
        soundPool.play(this.soundID, 0.1f, 0.5f, 0, 1, 1.0f);
    }

    public void releaseSoundPool() {
        try {
            if (this.soundPool != null) {
                this.soundPool.release();
                this.soundPool = null;
            }
            instance = null;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
