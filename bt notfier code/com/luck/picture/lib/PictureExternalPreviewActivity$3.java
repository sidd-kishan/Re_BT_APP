/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  com.luck.picture.lib.PictureExternalPreviewActivity
 *  com.luck.picture.lib.thread.PictureThreadUtils
 *  com.luck.picture.lib.thread.PictureThreadUtils$SimpleTask
 *  com.luck.picture.lib.tools.PictureFileUtils
 *  okio.BufferedSource
 *  okio.Okio
 *  okio.Source
 */
package com.luck.picture.lib;

import android.content.Context;
import android.net.Uri;
import com.luck.picture.lib.PictureExternalPreviewActivity;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/*
 * Exception performing whole class analysis ignored.
 */
class PictureExternalPreviewActivity.3
extends PictureThreadUtils.SimpleTask<String> {
    final PictureExternalPreviewActivity this$0;
    final Uri val$inputUri;
    final Uri val$uri;

    PictureExternalPreviewActivity.3(PictureExternalPreviewActivity pictureExternalPreviewActivity, Uri uri, Uri uri2) {
        this.this$0 = pictureExternalPreviewActivity;
        this.val$inputUri = uri;
        this.val$uri = uri2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public String doInBackground() {
        Throwable throwable2222222;
        BufferedSource bufferedSource;
        block5: {
            BufferedSource bufferedSource2;
            block6: {
                BufferedSource bufferedSource3;
                block4: {
                    bufferedSource2 = null;
                    bufferedSource = null;
                    bufferedSource = bufferedSource3 = Okio.buffer((Source)Okio.source((InputStream)Objects.requireNonNull(this.this$0.getContentResolver().openInputStream(this.val$inputUri))));
                    bufferedSource2 = bufferedSource3;
                    if (!PictureFileUtils.bufferCopy((BufferedSource)bufferedSource3, (OutputStream)this.this$0.getContentResolver().openOutputStream(this.val$uri))) break block4;
                    bufferedSource = bufferedSource3;
                    bufferedSource2 = bufferedSource3;
                    String string = PictureFileUtils.getPath((Context)this.this$0.getContext(), (Uri)this.val$uri);
                    if (bufferedSource3 == null) return string;
                    {
                        catch (Throwable throwable2222222) {
                            break block5;
                        }
                        catch (Exception exception) {}
                        bufferedSource = bufferedSource2;
                        {
                            exception.printStackTrace();
                            if (bufferedSource2 == null) return "";
                        }
                        if (!bufferedSource2.isOpen()) return "";
                        break block6;
                    }
                    if (!bufferedSource3.isOpen()) return string;
                    PictureFileUtils.close((Closeable)bufferedSource3);
                    return string;
                }
                if (bufferedSource3 == null) return "";
                if (!bufferedSource3.isOpen()) return "";
                bufferedSource2 = bufferedSource3;
            }
            PictureFileUtils.close((Closeable)bufferedSource2);
            return "";
        }
        if (bufferedSource == null) throw throwable2222222;
        if (!bufferedSource.isOpen()) throw throwable2222222;
        PictureFileUtils.close(bufferedSource);
        throw throwable2222222;
    }

    public void onSuccess(String string) {
        PictureThreadUtils.cancel((ExecutorService)PictureThreadUtils.getSinglePool());
        PictureExternalPreviewActivity.access$800((PictureExternalPreviewActivity)this.this$0, (String)string);
    }
}
