/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core;

static final class ImageProxyDownsampler.DownsamplingMethod
extends Enum<ImageProxyDownsampler.DownsamplingMethod> {
    private static final ImageProxyDownsampler.DownsamplingMethod[] $VALUES;
    public static final /* enum */ ImageProxyDownsampler.DownsamplingMethod AVERAGING;
    public static final /* enum */ ImageProxyDownsampler.DownsamplingMethod NEAREST_NEIGHBOR;

    static {
        ImageProxyDownsampler.DownsamplingMethod downsamplingMethod;
        NEAREST_NEIGHBOR = new ImageProxyDownsampler.DownsamplingMethod();
        AVERAGING = downsamplingMethod = new ImageProxyDownsampler.DownsamplingMethod();
        $VALUES = new ImageProxyDownsampler.DownsamplingMethod[]{NEAREST_NEIGHBOR, downsamplingMethod};
    }

    public static ImageProxyDownsampler.DownsamplingMethod valueOf(String string) {
        return Enum.valueOf(ImageProxyDownsampler.DownsamplingMethod.class, string);
    }

    public static ImageProxyDownsampler.DownsamplingMethod[] values() {
        return (ImageProxyDownsampler.DownsamplingMethod[])$VALUES.clone();
    }
}
