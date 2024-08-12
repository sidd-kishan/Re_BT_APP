/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioRecord
 */
package com.luck.picture.lib.camera;

import android.media.AudioRecord;

public class CheckPermission {
    public static final int STATE_NO_PERMISSION = -2;
    public static final int STATE_RECORDING = -1;
    public static final int STATE_SUCCESS = 1;

    public static int getRecordState() {
        int n = AudioRecord.getMinBufferSize((int)44100, (int)16, (int)2);
        AudioRecord audioRecord = new AudioRecord(0, 44100, 16, 2, n * 100);
        short[] sArray = new short[n];
        try {
            audioRecord.startRecording();
        }
        catch (Exception exception) {
            audioRecord.release();
            return -2;
        }
        if (audioRecord.getRecordingState() != 3) {
            audioRecord.stop();
            audioRecord.release();
            return -1;
        }
        if (audioRecord.read(sArray, 0, n) <= 0) {
            audioRecord.stop();
            audioRecord.release();
            return -2;
        }
        audioRecord.stop();
        audioRecord.release();
        return 1;
    }
}
