/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  androidx.camera.core.ForwardingImageProxy
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.ImageProxy$PlaneProxy
 *  androidx.camera.core.ImageProxyDownsampler$2
 *  androidx.camera.core.ImageProxyDownsampler$DownsamplingMethod
 *  androidx.camera.core.ImageProxyDownsampler$ForwardingImageProxyImpl
 */
package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageProxyDownsampler;
import java.nio.ByteBuffer;

final class ImageProxyDownsampler {
    private ImageProxyDownsampler() {
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(int n, int n2, byte[] byArray) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    static ForwardingImageProxy downsample(ImageProxy object, int n, int n2, DownsamplingMethod object2) {
        if (object.getFormat() != 35) {
            object = new UnsupportedOperationException("Only YUV_420_888 format is currently supported.");
            throw object;
        }
        if (object.getWidth() >= n && object.getHeight() >= n2) {
            if (object.getWidth() == n && object.getHeight() == n2) {
                return new ForwardingImageProxyImpl(object, object.getPlanes(), n, n2);
            }
        } else {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Downsampled dimension ");
            ((StringBuilder)object2).append(new Size(n, n2));
            ((StringBuilder)object2).append(" is not <= original dimension ");
            ((StringBuilder)object2).append(new Size(object.getWidth(), object.getHeight()));
            ((StringBuilder)object2).append(".");
            throw new IllegalArgumentException(((StringBuilder)object2).toString());
        }
        int[] nArray = new int[3];
        int n3 = object.getWidth();
        int n4 = 0;
        nArray[0] = n3;
        nArray[1] = object.getWidth() / 2;
        nArray[2] = object.getWidth() / 2;
        int[] nArray2 = new int[]{object.getHeight(), object.getHeight() / 2, object.getHeight() / 2};
        n3 = n / 2;
        int[] nArray3 = new int[]{n, n3, n3};
        n3 = n2 / 2;
        int[] nArray4 = new int[]{n2, n3, n3};
        ImageProxy.PlaneProxy[] planeProxyArray = new ImageProxy.PlaneProxy[3];
        while (n4 < 3) {
            ImageProxy.PlaneProxy planeProxy = object.getPlanes()[n4];
            ByteBuffer byteBuffer = planeProxy.getBuffer();
            byte[] byArray = new byte[nArray3[n4] * nArray4[n4]];
            n3 = 2.$SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod[object2.ordinal()];
            if (n3 != 1) {
                if (n3 == 2) {
                    ImageProxyDownsampler.resizeAveraging(byteBuffer, nArray[n4], planeProxy.getPixelStride(), planeProxy.getRowStride(), nArray2[n4], byArray, nArray3[n4], nArray4[n4]);
                }
            } else {
                ImageProxyDownsampler.resizeNearestNeighbor(byteBuffer, nArray[n4], planeProxy.getPixelStride(), planeProxy.getRowStride(), nArray2[n4], byArray, nArray3[n4], nArray4[n4]);
            }
            planeProxyArray[n4] = ImageProxyDownsampler.createPlaneProxy(nArray3[n4], 1, byArray);
            ++n4;
        }
        return new ForwardingImageProxyImpl(object, planeProxyArray, n, n2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    private static void resizeAveraging(ByteBuffer byteBuffer, int n, int n2, int n3, int n4, byte[] byArray, int n5, int n6) {
        float f = (float)n / (float)n5;
        float f2 = (float)n4 / (float)n6;
        byte[] byArray2 = new byte[n3];
        byte[] byArray3 = new byte[n3];
        int[] nArray = new int[n5];
        for (n = 0; n < n5; ++n) {
            nArray[n] = (int)((float)n * f) * n2;
        }
        synchronized (byteBuffer) {
            byteBuffer.rewind();
            n = 0;
            while (n < n6) {
                int n7 = (int)((float)n * f2);
                int n8 = n4 - 1;
                {
                    int n9 = Math.min(n7, n8);
                    n7 = Math.min(n7 + 1, n8);
                    byteBuffer.position(n9 * n3);
                    byteBuffer.get(byArray2, 0, Math.min(n3, byteBuffer.remaining()));
                    byteBuffer.position(n7 * n3);
                    byteBuffer.get(byArray3, 0, Math.min(n3, byteBuffer.remaining()));
                    for (n9 = 0; n9 < n5; ++n9) {
                        byArray[n * n5 + n9] = (byte)(((byArray2[nArray[n9]] & 0xFF) + (byArray2[nArray[n9] + n2] & 0xFF) + (byArray3[nArray[n9]] & 0xFF) + (byArray3[nArray[n9] + n2] & 0xFF)) / 4 & 0xFF);
                    }
                    ++n;
                }
            }
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    private static void resizeNearestNeighbor(ByteBuffer var0, int var1_1, int var2_2, int var3_3, int var4_4, byte[] var5_5, int var6_7, int var7_8) {
        var9_9 = (float)var1_1 / (float)var6_7;
        var8_10 = (float)var4_4 / (float)var7_8;
        var11_11 = new byte[var3_3];
        var10_12 = new int[var6_7];
        for (var1_1 = 0; var1_1 < var6_7; ++var1_1) {
            var10_12[var1_1] = (int)((float)var1_1 * var9_9) * var2_2;
        }
        synchronized (var0) {
            try {
                var0.rewind();
                var1_1 = 0;
lbl13:
                // 2 sources

                while (true) {
                    if (var1_1 >= var7_8) return;
                    var0.position(Math.min((int)((float)var1_1 * var8_10), var4_4 - 1) * var3_3);
                    var0.get(var11_11, 0, Math.min(var3_3, var0.remaining()));
                    ** GOTO lbl22
                    break;
                }
            }
            catch (Throwable var5_6) {
lbl22:
                // 2 sources

                for (var2_2 = 0; var2_2 < var6_7; ++var2_2) {
                    var5_5[var1_1 * var6_7 + var2_2] = var11_11[var10_12[var2_2]];
                }
                ++var1_1;
                ** continue;
                throw var5_6;
            }
        }
    }
}
