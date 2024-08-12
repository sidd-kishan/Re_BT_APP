/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.GpsSatellite
 *  android.location.GpsStatus
 *  android.os.Build$VERSION
 *  androidx.core.location.GnssStatusCompat
 *  androidx.core.util.Preconditions
 */
package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;
import java.util.Iterator;

class GpsStatusWrapper
extends GnssStatusCompat {
    private static final int BEIDOU_PRN_COUNT = 35;
    private static final int BEIDOU_PRN_OFFSET = 200;
    private static final int GLONASS_PRN_COUNT = 24;
    private static final int GLONASS_PRN_OFFSET = 64;
    private static final int GPS_PRN_COUNT = 32;
    private static final int GPS_PRN_OFFSET = 0;
    private static final int QZSS_SVID_MAX = 200;
    private static final int QZSS_SVID_MIN = 193;
    private static final int SBAS_PRN_MAX = 64;
    private static final int SBAS_PRN_MIN = 33;
    private static final int SBAS_PRN_OFFSET = -87;
    private Iterator<GpsSatellite> mCachedIterator;
    private int mCachedIteratorPosition;
    private GpsSatellite mCachedSatellite;
    private int mCachedSatelliteCount;
    private final GpsStatus mWrapped;

    GpsStatusWrapper(GpsStatus gpsStatus) {
        this.mWrapped = gpsStatus = (GpsStatus)Preconditions.checkNotNull((Object)gpsStatus);
        this.mCachedSatelliteCount = -1;
        this.mCachedIterator = gpsStatus.getSatellites().iterator();
        this.mCachedIteratorPosition = -1;
        this.mCachedSatellite = null;
    }

    private static int getConstellationFromPrn(int n) {
        if (n > 0 && n <= 32) {
            return 1;
        }
        if (n >= 33 && n <= 64) {
            return 2;
        }
        if (n > 64 && n <= 88) {
            return 3;
        }
        if (n > 200 && n <= 235) {
            return 5;
        }
        if (n < 193) return 0;
        if (n > 200) return 0;
        return 4;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private GpsSatellite getSatellite(int n) {
        GpsStatus gpsStatus = this.mWrapped;
        synchronized (gpsStatus) {
            if (n < this.mCachedIteratorPosition) {
                this.mCachedIterator = this.mWrapped.getSatellites().iterator();
                this.mCachedIteratorPosition = -1;
            }
            while (this.mCachedIteratorPosition < n) {
                ++this.mCachedIteratorPosition;
                if (!this.mCachedIterator.hasNext()) {
                    this.mCachedSatellite = null;
                    break;
                }
                this.mCachedSatellite = this.mCachedIterator.next();
            }
            GpsSatellite gpsSatellite = this.mCachedSatellite;
            return (GpsSatellite)Preconditions.checkNotNull((Object)gpsSatellite);
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
    }

    private static int getSvidFromPrn(int n) {
        int n2 = GpsStatusWrapper.getConstellationFromPrn(n);
        if (n2 != 2) {
            if (n2 != 3) {
                if (n2 != 5) return n;
                n -= 200;
            } else {
                n -= 64;
            }
        } else {
            n += 87;
        }
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof GpsStatusWrapper)) {
            return false;
        }
        object = (GpsStatusWrapper)((Object)object);
        return this.mWrapped.equals(((GpsStatusWrapper)((Object)object)).mWrapped);
    }

    public float getAzimuthDegrees(int n) {
        return this.getSatellite(n).getAzimuth();
    }

    public float getBasebandCn0DbHz(int n) {
        throw new UnsupportedOperationException();
    }

    public float getCarrierFrequencyHz(int n) {
        throw new UnsupportedOperationException();
    }

    public float getCn0DbHz(int n) {
        return this.getSatellite(n).getSnr();
    }

    public int getConstellationType(int n) {
        if (Build.VERSION.SDK_INT >= 24) return GpsStatusWrapper.getConstellationFromPrn(this.getSatellite(n).getPrn());
        return 1;
    }

    public float getElevationDegrees(int n) {
        return this.getSatellite(n).getElevation();
    }

    public int getSatelliteCount() {
        GpsStatus gpsStatus = this.mWrapped;
        synchronized (gpsStatus) {
            try {
                if (this.mCachedSatelliteCount == -1) {
                    for (GpsSatellite gpsSatellite : this.mWrapped.getSatellites()) {
                        ++this.mCachedSatelliteCount;
                    }
                    ++this.mCachedSatelliteCount;
                }
                int n = this.mCachedSatelliteCount;
                return n;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public int getSvid(int n) {
        if (Build.VERSION.SDK_INT >= 24) return GpsStatusWrapper.getSvidFromPrn(this.getSatellite(n).getPrn());
        return this.getSatellite(n).getPrn();
    }

    public boolean hasAlmanacData(int n) {
        return this.getSatellite(n).hasAlmanac();
    }

    public boolean hasBasebandCn0DbHz(int n) {
        return false;
    }

    public boolean hasCarrierFrequencyHz(int n) {
        return false;
    }

    public boolean hasEphemerisData(int n) {
        return this.getSatellite(n).hasEphemeris();
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    public boolean usedInFix(int n) {
        return this.getSatellite(n).usedInFix();
    }
}
