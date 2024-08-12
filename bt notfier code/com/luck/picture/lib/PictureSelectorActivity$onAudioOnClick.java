/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.luck.picture.lib.PictureSelectorActivity
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib._$$Lambda$PictureSelectorActivity$onAudioOnClick$LETNA84_4wIk6FAmdpkS0zEf_ro
 */
package com.luck.picture.lib;

import android.view.View;
import com.luck.picture.lib.PictureSelectorActivity;
import com.luck.picture.lib.R;
import com.luck.picture.lib._$;

/*
 * Exception performing whole class analysis ignored.
 */
public class PictureSelectorActivity.onAudioOnClick
implements View.OnClickListener {
    private String path;
    final PictureSelectorActivity this$0;

    public PictureSelectorActivity.onAudioOnClick(PictureSelectorActivity pictureSelectorActivity, String string) {
        this.this$0 = pictureSelectorActivity;
        this.path = string;
    }

    public /* synthetic */ void lambda$onClick$0$PictureSelectorActivity$onAudioOnClick() {
        this.this$0.stop(this.path);
    }

    public void onClick(View view) {
        int n = view.getId();
        if (n == R.id.tv_PlayPause) {
            PictureSelectorActivity.access$200((PictureSelectorActivity)this.this$0);
        }
        if (n == R.id.tv_Stop) {
            this.this$0.mTvMusicStatus.setText((CharSequence)this.this$0.getString(R.string.picture_stop_audio));
            this.this$0.mTvPlayPause.setText((CharSequence)this.this$0.getString(R.string.picture_play_audio));
            this.this$0.stop(this.path);
        }
        if (n != R.id.tv_Quit) return;
        this.this$0.mHandler.postDelayed((Runnable)new _$.Lambda.PictureSelectorActivity.onAudioOnClick.LETNA84_4wIk6FAmdpkS0zEf_ro(this), 30L);
        try {
            if (this.this$0.audioDialog != null && this.this$0.audioDialog.isShowing()) {
                this.this$0.audioDialog.dismiss();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.this$0.mHandler.removeCallbacks(this.this$0.mRunnable);
    }
}
