/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.graphics.YuvImage
 *  android.media.Image
 *  android.media.ImageWriter
 *  android.util.Size
 *  android.view.Surface
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.CaptureProcessor
 *  androidx.camera.core.impl.ImageProxyBundle
 *  androidx.camera.core.impl.utils.ExifData
 *  androidx.camera.core.impl.utils.ExifData$Builder
 *  androidx.camera.core.impl.utils.ExifOutputStream
 *  androidx.camera.core.internal.YuvToJpegProcessor$ByteBufferOutputStream
 *  androidx.camera.core.internal.compat.ImageWriterCompat
 *  androidx.camera.core.internal.utils.ImageUtil
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.internal;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.media.ImageWriter;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifOutputStream;
import androidx.camera.core.internal.YuvToJpegProcessor;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutionException;

public class YuvToJpegProcessor
implements CaptureProcessor {
    private static final String TAG = "YuvToJpegProcessor";
    private static final Rect UNINITIALIZED_RECT = new Rect(0, 0, 0, 0);
    private boolean mClosed = false;
    private Rect mImageRect;
    private ImageWriter mImageWriter;
    private final Object mLock = new Object();
    private final int mMaxImages;
    private int mProcessingImages = 0;
    private final int mQuality;

    public YuvToJpegProcessor(int n, int n2) {
        this.mImageRect = UNINITIALIZED_RECT;
        this.mQuality = n;
        this.mMaxImages = n2;
    }

    private static ExifData getExifData(ImageProxy imageProxy) {
        ExifData.Builder builder = ExifData.builderForDevice();
        imageProxy.getImageInfo().populateExifData(builder);
        return builder.setImageWidth(imageProxy.getWidth()).setImageHeight(imageProxy.getHeight()).build();
    }

    public void close() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mClosed) return;
            this.mClosed = true;
            if (this.mProcessingImages == 0 && this.mImageWriter != null) {
                Logger.d((String)TAG, (String)"No processing in progress. Closing immediately.");
                this.mImageWriter.close();
            } else {
                Logger.d((String)TAG, (String)"close() called while processing. Will close after completion.");
            }
            return;
        }
    }

    public void onOutputSurface(Surface object, int n) {
        boolean bl = n == 256;
        Preconditions.checkState((boolean)bl, (String)"YuvToJpegProcessor only supports JPEG output format.");
        Object object2 = this.mLock;
        synchronized (object2) {
            if (!this.mClosed) {
                if (this.mImageWriter != null) {
                    object = new IllegalStateException("Output surface already set.");
                    throw object;
                }
                this.mImageWriter = ImageWriterCompat.newInstance((Surface)object, (int)this.mMaxImages, (int)n);
            } else {
                Logger.w((String)TAG, (String)"Cannot set output surface. Processor is closed.");
            }
            return;
        }
    }

    public void onResolutionUpdate(Size size) {
        Object object = this.mLock;
        synchronized (object) {
            Rect rect;
            this.mImageRect = rect = new Rect(0, 0, size.getWidth(), size.getHeight());
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void process(ImageProxyBundle object) {
        ImageWriter imageWriter;
        block67: {
            int n;
            Object object2;
            Object object3;
            int n2;
            int n3;
            block66: {
                void var10_13;
                int n4;
                block64: {
                    Rect rect;
                    Object object4;
                    block63: {
                        Object var13_35;
                        block65: {
                            boolean bl;
                            int n5;
                            block62: {
                                object4 = object.getCaptureIds();
                                n3 = object4.size();
                                n5 = 0;
                                n4 = 0;
                                n2 = 0;
                                boolean bl2 = false;
                                bl = n3 == 1;
                                object3 = new StringBuilder();
                                ((StringBuilder)object3).append("Processing image bundle have single capture id, but found ");
                                ((StringBuilder)object3).append(object4.size());
                                Preconditions.checkArgument((boolean)bl, (Object)((StringBuilder)object3).toString());
                                object2 = object.getImageProxy(((Integer)object4.get(0)).intValue());
                                Preconditions.checkArgument((boolean)object2.isDone());
                                object = this.mLock;
                                // MONITORENTER : object
                                imageWriter = this.mImageWriter;
                                n3 = !this.mClosed ? 1 : 0;
                                rect = this.mImageRect;
                                if (n3 != 0) {
                                    ++this.mProcessingImages;
                                }
                                // MONITOREXIT : object
                                object4 = null;
                                object = null;
                                var13_35 = null;
                                {
                                    catch (Throwable throwable) {}
                                    {
                                        // MONITOREXIT : object
                                        throw throwable;
                                    }
                                }
                                object3 = (ImageProxy)object2.get();
                                if (n3 != 0) break block62;
                                Logger.w((String)TAG, (String)"Image enqueued for processing on closed processor.");
                                object3.close();
                                object = this.mLock;
                                // MONITORENTER : object
                                boolean bl3 = bl2;
                                if (n3 != 0) {
                                    n3 = this.mProcessingImages;
                                    this.mProcessingImages = n3 - 1;
                                    bl3 = bl2;
                                    if (n3 == 0) {
                                        bl3 = bl2;
                                        if (this.mClosed) {
                                            bl3 = true;
                                        }
                                    }
                                    // MONITOREXIT : object
                                }
                                if (!bl3) return;
                                imageWriter.close();
                                Logger.d((String)TAG, (String)"Closed after completion of last image processed.");
                                return;
                            }
                            object = imageWriter.dequeueInputImage();
                            object2 = (ImageProxy)object2.get();
                            bl = object2.getFormat() == 35;
                            Preconditions.checkState((boolean)bl, (String)"Input image is not expected YUV_420_888 image format");
                            object3 = ImageUtil.yuv_420_888toNv21((ImageProxy)object2);
                            YuvImage yuvImage = new YuvImage((byte[])object3, 17, object2.getWidth(), object2.getHeight(), null);
                            object3 = object.getPlanes()[0].getBuffer();
                            n = ((Buffer)object3).position();
                            ByteBufferOutputStream byteBufferOutputStream = new ByteBufferOutputStream((ByteBuffer)object3);
                            ExifOutputStream exifOutputStream = new ExifOutputStream((OutputStream)byteBufferOutputStream, YuvToJpegProcessor.getExifData((ImageProxy)object2));
                            yuvImage.compressToJpeg(rect, this.mQuality, (OutputStream)exifOutputStream);
                            object2.close();
                            object2 = object4;
                            rect = object;
                            try {
                                ((Buffer)object3).limit(((Buffer)object3).position());
                                object2 = object4;
                                rect = object;
                                ((Buffer)object3).position(n);
                                object2 = object4;
                                rect = object;
                                imageWriter.queueInputImage((Image)object);
                                object = this.mLock;
                            }
                            catch (ExecutionException executionException) {
                                object3 = var13_35;
                                break block63;
                            }
                            catch (InterruptedException interruptedException) {
                                object3 = var13_35;
                                break block63;
                            }
                            // MONITORENTER : object
                            n = n5;
                            if (n3 != 0) {
                                n3 = this.mProcessingImages;
                                this.mProcessingImages = n3 - 1;
                                n = n5;
                                if (n3 == 0) {
                                    n = n5;
                                    if (this.mClosed) {
                                        n = 1;
                                    }
                                }
                                // MONITOREXIT : object
                            }
                            if (n == 0) return;
                            break block67;
                            catch (Throwable throwable) {
                                object3 = object2;
                                break block64;
                            }
                            catch (ExecutionException executionException) {
                            }
                            catch (InterruptedException interruptedException) {
                                // empty catch block
                            }
                            object3 = object2;
                            break block63;
                            catch (Throwable throwable) {
                                break block64;
                            }
                            catch (ExecutionException executionException) {
                                break block63;
                            }
                            catch (InterruptedException interruptedException) {
                                break block63;
                            }
                            catch (Throwable throwable) {
                                object = null;
                                break block64;
                            }
                            catch (ExecutionException executionException) {
                                break block65;
                            }
                            catch (InterruptedException interruptedException) {
                                // empty catch block
                            }
                        }
                        object = null;
                        break block63;
                        catch (Throwable throwable) {
                            object2 = null;
                            object3 = object;
                            object = object2;
                            break block64;
                        }
                        catch (ExecutionException executionException) {
                        }
                        catch (InterruptedException interruptedException) {
                            // empty catch block
                        }
                        object = null;
                        object3 = var13_35;
                    }
                    object2 = object;
                    if (n3 != 0) {
                        object2 = object3;
                        rect = object;
                        Logger.e((String)TAG, (String)"Failed to process YUV -> JPEG", (Throwable)object4);
                        object2 = object3;
                        rect = object;
                        object = imageWriter.dequeueInputImage();
                        try {
                            object4 = object.getPlanes()[0].getBuffer();
                            ((Buffer)object4).rewind();
                            ((Buffer)object4).limit(0);
                            imageWriter.queueInputImage((Image)object);
                            object2 = object;
                            break block66;
                        }
                        catch (Throwable throwable) {
                            break block64;
                        }
                    }
                    break block66;
                    catch (Throwable throwable) {
                        object = rect;
                        object3 = object2;
                    }
                }
                object2 = this.mLock;
                // MONITORENTER : object2
                n = n4;
                if (n3 != 0) {
                    n3 = this.mProcessingImages;
                    this.mProcessingImages = n3 - 1;
                    n = n4;
                    if (n3 == 0) {
                        n = n4;
                        if (this.mClosed) {
                            n = 1;
                        }
                    }
                    // MONITOREXIT : object2
                }
                if (object != null) {
                    object.close();
                }
                if (object3 != null) {
                    object3.close();
                }
                if (n == 0) throw var10_13;
                imageWriter.close();
                Logger.d((String)TAG, (String)"Closed after completion of last image processed.");
                throw var10_13;
            }
            object = this.mLock;
            // MONITORENTER : object
            n = n2;
            if (n3 != 0) {
                n3 = this.mProcessingImages;
                this.mProcessingImages = n3 - 1;
                n = n2;
                if (n3 == 0) {
                    n = n2;
                    if (this.mClosed) {
                        n = 1;
                    }
                }
                // MONITOREXIT : object
            }
            if (object2 != null) {
                object2.close();
            }
            if (object3 != null) {
                object3.close();
            }
            if (n == 0) return;
        }
        imageWriter.close();
        Logger.d((String)TAG, (String)"Closed after completion of last image processed.");
    }
}
