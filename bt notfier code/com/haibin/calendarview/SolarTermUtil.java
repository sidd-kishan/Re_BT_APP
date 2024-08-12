/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.haibin.calendarview.R$array
 *  com.haibin.calendarview.SolarTermUtil$Nutation
 *  com.haibin.calendarview.SolarTermUtil$Time
 */
package com.haibin.calendarview;

import android.content.Context;
import com.haibin.calendarview.R;
import com.haibin.calendarview.SolarTermUtil;

/*
 * Exception performing whole class analysis ignored.
 */
public final class SolarTermUtil {
    private static final double ANGLE_PER_RAD = 57.29577951308232;
    private static final double[] DTS;
    private static final double[] E10;
    private static final double[] E11;
    private static final double[] E12;
    private static final double[] E13;
    private static final double[] E14;
    private static final double[] E15;
    private static final double[] E20;
    private static final double[] E21;
    private static final double[] E30;
    private static final double[] E31;
    private static final double[] E32;
    private static final double[] E33;
    private static double EnnT = 0.0;
    private static final double[] GXC_E;
    private static final double GXC_K = 9.936508497454117E-5;
    private static final double[] GXC_L;
    private static final double[] GXC_P;
    private static final double[] H_C_ANGLE_TABLE;
    private static final double J2000 = 2451545.0;
    private static final double[] M10;
    private static final double[] M11;
    private static final double[] M12;
    private static final double[] M1n;
    private static final double[] M20;
    private static final double[] M21;
    private static final double[] M30;
    private static final double[] M31;
    private static double MnnT = 0.0;
    private static final double SECOND_PER_RAD = 206264.80624709636;
    private static String[] SOLAR_TERMS;
    private static final double[] nutB;

    static {
        H_C_ANGLE_TABLE = new double[]{0.0, 50287.92262, 111.24406, 0.07699, -0.23479, -0.00178, 1.8E-4, 1.0E-5};
        DTS = new double[]{-4000.0, 108371.7, -13036.8, 392.0, 0.0, -500.0, 17201.0, -627.82, 16.17, -0.3413, -150.0, 12200.6, -346.41, 5.403, -0.1593, 150.0, 9113.8, -328.13, -1.647, 0.0377, 500.0, 5707.5, -391.41, 0.915, 0.3145, 900.0, 2203.4, -283.45, 13.034, -0.1778, 1300.0, 490.1, -57.35, 2.085, -0.0072, 1600.0, 120.0, -9.81, -1.532, 0.1403, 1700.0, 10.2, -0.91, 0.51, -0.037, 1800.0, 13.4, -0.72, 0.202, -0.0193, 1830.0, 7.8, -1.81, 0.416, -0.0247, 1860.0, 8.3, -0.13, -0.406, 0.0292, 1880.0, -5.4, 0.32, -0.183, 0.0173, 1900.0, -2.3, 2.06, 0.169, -0.0135, 1920.0, 21.2, 1.69, -0.304, 0.0167, 1940.0, 24.2, 1.22, -0.064, 0.0031, 1960.0, 33.2, 0.51, 0.231, -0.0109, 1980.0, 51.0, 1.29, -0.026, 0.0032, 2000.0, 64.7, -1.66, 5.224, -0.2905, 2150.0, 279.4, 732.95, 429.579, 0.0158, 6000.0};
        GXC_E = new double[]{0.016708634, -4.2037E-5, -1.267E-7};
        GXC_P = new double[]{1.796595680777785, 0.030010238356341697, 8.028514559173916E-6};
        GXC_L = new double[]{4.89506311081711, 628.3319667475674, 5.291887161265863E-6, 0.0, 0.0};
        nutB = new double[]{2.1824391966, -33.757045954, 3.62262E-5, 3.734E-8, -2.8793E-10, -171996.0, -1742.0, 92025.0, 89.0, 3.5069406862, 1256.663930738, 1.05845E-5, 6.9813E-10, -2.2815E-10, -13187.0, -16.0, 5736.0, -31.0, 1.3375032491, 16799.418221925, -5.11866E-5, 6.4626E-8, -5.3543E-10, -2274.0, -2.0, 977.0, -5.0, 4.3648783932, -67.514091907, 7.24525E-5, 7.4681E-8, -5.7586E-10, 2062.0, 2.0, -895.0, 5.0, 0.0431251803, -628.301955171, 2.682E-6, 6.5935E-10, 5.5705E-11, -1426.0, 34.0, 54.0, -1.0, 2.3555557435, 8328.691425719, 1.545547E-4, 2.5033E-7, -1.1863E-9, 712.0, 1.0, -7.0, 0.0, 3.4638155059, 1884.965885909, 7.9025E-6, 3.8785E-11, -2.8386E-10, -517.0, 12.0, 224.0, -6.0, 5.4382493597, 16833.175267879, -8.74129E-5, 2.7285E-8, -2.475E-10, -386.0, -4.0, 200.0, 0.0, 3.6930589926, 25128.109647645, 1.033681E-4, 3.1496E-7, -1.7218E-9, -301.0, 0.0, 129.0, -1.0, 3.5500658664, 628.361975567, 1.32664E-5, 1.3575E-9, -1.7245E-10, 217.0, -5.0, -95.0, 3.0};
        E10 = new double[]{1.75347045673, 0.0, 0.0, 0.03341656456, 4.66925680417, 6283.0758499914, 3.4894275E-4, 4.62610241759, 12566.1516999828, 3.417571E-5, 2.82886579606, 3.523118349, 3.497056E-5, 2.74411800971, 5753.3848848968, 3.135896E-5, 3.62767041758, 77713.7714681205, 2.676218E-5, 4.41808351397, 7860.4193924392, 2.342687E-5, 6.13516237631, 3930.2096962196, 1.273166E-5, 2.03709655772, 529.6909650946, 1.324292E-5, 0.74246356352, 11506.7697697936, 9.01855E-6, 2.04505443513, 26.2983197998, 1.199167E-5, 1.10962944315, 1577.3435424478, 8.57223E-6, 3.50849156957, 398.1490034082, 7.79786E-6, 1.17882652114, 5223.6939198022, 9.9025E-6, 5.23268129594, 5884.9268465832, 7.53141E-6, 2.53339053818, 5507.5532386674, 5.05264E-6, 4.58292563052, 18849.2275499742, 4.92379E-6, 4.20506639861, 775.522611324, 3.56655E-6, 2.91954116867, 0.0673103028, 2.84125E-6, 1.89869034186, 796.2980068164, 2.4281E-6, 0.34481140906, 5486.777843175, 3.17087E-6, 5.84901952218, 11790.6290886588, 2.71039E-6, 0.31488607649, 10977.078804699, 2.0616E-6, 4.80646606059, 2544.3144198834, 2.05385E-6, 1.86947813692, 5573.1428014331, 2.02261E-6, 2.45767795458, 6069.7767545534, 1.26184E-6, 1.0830263021, 20.7753954924, 1.55516E-6, 0.83306073807, 213.299095438, 1.15132E-6, 0.64544911683, 0.9803210682, 1.02851E-6, 0.63599846727, 4694.0029547076, 1.01724E-6, 4.26679821365, 7.1135470008, 9.9206E-7, 6.20992940258, 2146.1654164752, 1.32212E-6, 3.41118275555, 2942.4634232916, 9.7607E-7, 0.6810127227, 155.4203994342, 8.5128E-7, 1.29870743025, 6275.9623029906, 7.4651E-7, 1.75508916159, 5088.6288397668, 1.01895E-6, 0.97569221824, 15720.8387848784, 8.4711E-7, 3.67080093025, 71430.6956181291, 7.3547E-7, 4.67926565481, 801.8209311238, 7.3874E-7, 3.50319443167, 3154.6870848956, 7.8756E-7, 3.03698313141, 12036.4607348882, 7.9637E-7, 1.807913307, 17260.1546546904, 8.5803E-7, 5.98322631256, 161000.6857376741, 5.6963E-7, 2.78430398043, 6286.5989683404, 6.1148E-7, 1.81839811024, 7084.8967811152, 6.9627E-7, 0.83297596966, 9437.762934887, 5.6116E-7, 4.38694880779, 14143.4952424306, 6.2449E-7, 3.97763880587, 8827.3902698748, 5.1145E-7, 0.28306864501, 5856.4776591154, 5.5577E-7, 3.47006009062, 6279.5527316424, 4.1036E-7, 5.36817351402, 8429.2412664666, 5.1605E-7, 1.33282746983, 1748.016413067, 5.1992E-7, 0.18914945834, 12139.5535091068, 4.9E-7, 0.48735065033, 1194.4470102246, 3.92E-7, 6.16832995016, 10447.3878396044, 3.5566E-7, 1.77597314691, 6812.766815086, 3.677E-7, 6.04133859347, 10213.285546211, 3.6596E-7, 2.56955238628, 1059.3819301892, 3.3291E-7, 0.59309499459, 17789.845619785, 3.5954E-7, 1.70876111898, 2352.8661537718};
        E11 = new double[]{6283.31966747491, 0.0, 0.0, 0.00206058863, 2.67823455584, 6283.0758499914, 4.30343E-5, 2.63512650414, 12566.1516999828, 4.25264E-6, 1.59046980729, 3.523118349, 1.08977E-6, 2.96618001993, 1577.3435424478, 9.3478E-7, 2.59212835365, 18849.2275499742, 1.19261E-6, 5.79557487799, 26.2983197998, 7.2122E-7, 1.13846158196, 529.6909650946, 6.7768E-7, 1.87472304791, 398.1490034082, 6.7327E-7, 4.40918235168, 5507.5532386674, 5.9027E-7, 2.8879703846, 5223.6939198022, 5.5976E-7, 2.17471680261, 155.4203994342, 4.5407E-7, 0.39803079805, 796.2980068164, 3.6369E-7, 0.46624739835, 775.522611324, 2.8958E-7, 2.64707383882, 7.1135470008, 1.9097E-7, 1.84628332577, 5486.777843175, 2.0844E-7, 5.34138275149, 0.9803210682, 1.8508E-7, 4.96855124577, 213.299095438, 1.6233E-7, 0.03216483047, 2544.3144198834, 1.7293E-7, 2.99116864949, 6275.9623029906};
        E12 = new double[]{5.291887E-4, 0.0, 0.0, 8.719837E-5, 1.07209665242, 6283.0758499914, 3.09125E-6, 0.86728818832, 12566.1516999828, 2.7339E-7, 0.05297871691, 3.523118349, 1.6334E-7, 5.18826691036, 26.2983197998, 1.5752E-7, 3.6845788943, 155.4203994342, 9.541E-8, 0.75742297675, 18849.2275499742, 8.937E-8, 2.05705419118, 77713.7714681205, 6.952E-8, 0.8267330541, 775.522611324, 5.064E-8, 4.66284525271, 1577.3435424478};
        E13 = new double[]{2.89226E-6, 5.84384198723, 6283.0758499914, 3.4955E-7, 0.0, 0.0, 1.6819E-7, 5.48766912348, 12566.1516999828};
        E14 = new double[]{1.14084E-6, 3.14159265359, 0.0, 7.717E-8, 4.13446589358, 6283.0758499914, 7.65E-9, 3.83803776214, 12566.1516999828};
        E15 = new double[]{8.78E-9, 3.14159265359, 0.0};
        E20 = new double[]{2.7962E-6, 3.19870156017, 84334.6615813083, 1.01643E-6, 5.42248619256, 5507.5532386674, 8.0445E-7, 3.88013204458, 5223.6939198022, 4.3806E-7, 3.70444689758, 2352.8661537718, 3.1933E-7, 4.00026369781, 1577.3435424478, 2.2724E-7, 3.9847383156, 1047.7473117547, 1.6392E-7, 3.56456119782, 5856.4776591154, 1.8141E-7, 4.98367470263, 6283.0758499914, 1.4443E-7, 3.70275614914, 9437.762934887, 1.4304E-7, 3.41117857525, 10213.285546211};
        E21 = new double[]{9.03E-8, 3.8972906189, 5507.5532386674, 6.177E-8, 1.73038850355, 5223.6939198022};
        E30 = new double[]{1.00013988799, 0.0, 0.0, 0.01670699626, 3.09846350771, 6283.0758499914, 1.3956023E-4, 3.0552460962, 12566.1516999828, 3.08372E-5, 5.19846674381, 77713.7714681205, 1.628461E-5, 1.17387749012, 5753.3848848968, 1.575568E-5, 2.84685245825, 7860.4193924392, 9.24799E-6, 5.45292234084, 11506.7697697936, 5.42444E-6, 4.56409149777, 3930.2096962196};
        E31 = new double[]{0.00103018608, 1.10748969588, 6283.0758499914, 1.721238E-5, 1.06442301418, 12566.1516999828, 7.02215E-6, 3.14159265359, 0.0};
        E32 = new double[]{4.359385E-5, 5.78455133738, 6283.0758499914};
        E33 = new double[]{1.44595E-6, 4.27319435148, 6283.0758499914};
        M10 = new double[]{22639.58588, 2.3555545723, 8328.6914247251, 1.5231275E-4, 2.5041111E-7, -1.1863391E-9, 4586.4383203, 8.0413790709, 7214.0628654588, -2.1850087E-4, -1.8646419E-7, 8.7760973E-10, 2369.9139357, 10.3969336431, 15542.754290184, -6.6188121E-5, 6.3946925E-8, -3.0872935E-10, 769.0257187, 4.7111091445, 16657.3828494503, 3.046255E-4, 5.0082223E-7, -2.3726782E-9, -666.4175399, -0.0431256817, 628.3019552485, -2.6638815E-6, 6.1639211E-10, -5.4439728E-11, -411.5957339, 3.2558104895, 16866.932315281, -1.2804259E-4, -9.8998954E-9, 4.0433461E-11, 211.6555524, 5.6858244986, -1114.6285592663, -3.7081362E-4, -4.368753E-7, 2.0639488E-9, 205.435953, 8.0845047526, 6585.7609102104, -2.1583699E-4, -1.8708058E-7, 9.3204945E-10, 191.9561973, 12.7524882154, 23871.4457149091, 8.6124629E-5, 3.1435804E-7, -1.4950684E-9, 164.7286185, 10.4400593249, 14914.4523349355, -6.352424E-5, 6.3330532E-8, -2.5428962E-10, -147.3213842, -2.398680254, -7700.3894694766, -1.5497663E-4, -2.4979472E-7, 1.1318993E-9, -124.9881185, 5.1984668216, 7771.377145092, -3.3094061E-5, 3.1973462E-8, -1.5436468E-10, -109.3803637, 2.3124288905, 8956.9933799736, 1.4964887E-4, 2.5102751E-7, -1.2407788E-9, 55.1770578, 7.1411231536, -1324.178025097, 6.1854469E-5, 7.384682E-8, -3.4916281E-10, -45.0996092, 5.6113650618, 25195.6237400061, 2.4270161E-5, 2.4051122E-7, -1.1459056E-9, 39.533301, -0.9002559173, -8538.2408905558, 2.8035534E-4, 2.6031101E-7, -1.2267725E-9, 38.4298346, 18.438312714, 22756.8171556428, -2.8468899E-4, -1.2251727E-7, 5.6888037E-10, 36.1238141, 7.0666637168, 24986.0742741754, 4.5693825E-4, 7.5123334E-7, -3.5590172E-9, 30.7725751, 16.0827581417, 14428.1257309177, -4.3700174E-4, -3.7292838E-7, 1.7552195E-9, -28.3971008, 7.9982533891, 7842.3648207073, -2.2116475E-4, -1.858478E-7, 8.2317E-10, -24.3582283, 10.3538079614, 16171.0562454324, -6.8852003E-5, 6.4563317E-8, -3.6316908E-10, -18.5847068, 2.8429122493, -557.3142796331, -1.8540681E-4, -2.1843765E-7, 1.0319744E-9, 17.9544674, 5.1553411398, 8399.6791003405, -3.5757942E-5, 3.2589854E-8, -2.088044E-10, 14.5302779, 12.7956138971, 23243.1437596606, 8.8788511E-5, 3.1374165E-7, -1.4406287E-9, 14.3796974, 15.1080427876, 32200.1371396342, 2.3843738E-4, 5.6476915E-7, -2.6814075E-9, 14.2514576, -24.081036632, -2.3011998397, 1.5231275E-4, 2.5041111E-7, -1.1863391E-9, 13.8990596, 20.7938672862, 31085.5085803679, -1.3237624E-4, 1.2789385E-7, -6.174587E-10, 13.1940636, 3.3302699264, -9443.3199839914, -5.2312637E-4, -6.8728642E-7, 3.2502879E-9, -9.6790568, -4.7542348263, -16029.0808942018, -3.0728938E-4, -5.0020584E-7, 2.3182384E-9, -9.3658635, 11.2971895604, 24080.9951807398, -3.4654346E-4, -1.9636409E-7, 9.1804319E-10, 8.6055318, 5.7289501804, -1742.9305145148, -3.6814974E-4, -4.374917E-7, 2.1183885E-9, -8.4530982, 7.5540213938, 16100.0685698171, 1.1921869E-4, 2.8238458E-7, -1.3407038E-9, 8.0501724, 10.4831850066, 14286.150379687, -6.0860358E-5, 6.271414E-8, -1.998499E-10, -7.6301553, 4.6679834628, 17285.6848046987, 3.0196162E-4, 5.0143862E-7, -2.4271179E-9, -7.4474952, -0.0862513635, 1256.603910497, -5.327763E-6, 1.2327842E-9, -1.0887946E-10, 7.3712011, 8.1276304344, 5957.4589549619, -2.1317311E-4, -1.8769697E-7, 9.8648918E-10, 7.06299, 0.9591375719, 33.7570471374, -3.0829302E-5, -3.6967043E-8, 1.7385419E-10, -6.3831491, 9.4966777258, 7004.5133996281, 2.1416722E-4, 3.2425793E-7, -1.5355019E-9, -5.7416071, 13.6527441326, 32409.6866054649, -1.9423071E-4, 5.4047029E-8, -2.6829589E-10, 4.3740095, 18.4814383957, 22128.5152003943, -2.8202511E-4, -1.2313366E-7, 6.233201E-10, -3.9976134, 7.966919634, 33524.3151647312, 1.7658291E-4, 4.9092233E-7, -2.3322447E-9, -3.2096876, 13.2398458924, 14985.4400105508, -2.5159493E-4, -1.5449073E-7, 7.2324505E-10, -2.9145404, 12.7093625336, 24499.7476701576, 8.3460748E-5, 3.1497443E-7, -1.5495082E-9, 2.731889, 16.1258838235, 13799.8237756692, -4.3433786E-4, -3.7354477E-7, 1.8096592E-9, -2.5679459, -2.4418059357, -7072.0875142282, -1.5764051E-4, -2.4917833E-7, 1.0774596E-9, -2.521199, 7.9551277074, 8470.6667759558, -2.2382863E-4, -1.8523141E-7, 7.6873027E-10, 2.4888871, 5.6426988169, -486.3266040178, -3.734775E-4, -4.3625891E-7, 2.0095091E-9, 2.1460741, 7.1842488353, -1952.4799803455, 6.451835E-5, 7.3230428E-8, -2.9472308E-10, 1.977727, 23.1494218585, 39414.200005093, 1.9936508E-5, 3.7830496E-7, -1.8037978E-9, 1.9336825, 9.422218289, 33314.7656989005, 6.09251E-4, 1.0016445E-6, -4.7453563E-9, 1.8707647, 20.836992968, 30457.2066251194, -1.2971236E-4, 1.2727746E-7, -5.6301898E-10, -1.7529659, 0.4873576771, -8886.0057043583, -3.3771956E-4, -4.6884877E-7, 2.2183135E-9, -1.4371624, 7.0979974718, -695.8760698485, 5.9190587E-5, 7.4463212E-8, -4.0360254E-10, -1.3725701, 1.455298655, -209.5494658307, 4.3266809E-4, 5.1072212E-7, -2.4131116E-9, 1.2618162, 7.5108957121, 16728.3705250656, 1.1655481E-4, 2.8300097E-7, -1.3951435E-9};
        M11 = new double[]{1.6768, -0.0431256817, 628.3019552485, -2.6638815E-6, 6.1639211E-10, -5.4439728E-11, 0.51642, 11.2260974062, 6585.7609102104, -2.1583699E-4, -1.8708058E-7, 9.3204945E-10, 0.41383, 13.5816519784, 14914.4523349355, -6.352424E-5, 6.3330532E-8, -2.5428962E-10, 0.37115, 5.5402729076, 7700.3894694766, 1.5497663E-4, 2.4979472E-7, -1.1318993E-9, 0.2756, 2.3124288905, 8956.9933799736, 1.4964887E-4, 2.5102751E-7, -1.2407788E-9, 0.2459863, -25.6198212459, -2.3011998397, 1.5231275E-4, 2.5041111E-7, -1.1863391E-9, 0.07118, 7.9982533891, 7842.3648207073, -2.2116475E-4, -1.858478E-7, 8.2317E-10, 0.06128, 10.3538079614, 16171.0562454324, -6.8852003E-5, 6.4563317E-8, -3.6316908E-10};
        M12 = new double[]{0.00487, -0.0431256817, 628.3019552485, -2.6638815E-6, 6.1639211E-10, -5.4439728E-11, 0.00228, -27.1705318325, -2.3011998397, 1.5231275E-4, 2.5041111E-7, -1.1863391E-9, 0.0015, 11.2260974062, 6585.7609102104, -2.1583699E-4, -1.8708058E-7, 9.3204945E-10};
        M20 = new double[]{18461.24006, 1.6279052448, 8433.4661576405, -6.4021295E-5, -4.9499477E-9, 2.0216731E-11, 1010.1671484, 3.983459817, 16762.1575823656, 8.8291456E-5, 2.4546117E-7, -1.1661223E-9, 999.6936555, 0.7276493275, -104.7747329154, 2.1633405E-4, 2.5536106E-7, -1.2065558E-9, 623.6524746, 8.7690283983, 7109.2881325435, -2.1668263E-6, 6.8896872E-8, -3.2894608E-10, 199.4837596, 9.6692843156, 15647.5290230993, -2.8252217E-4, -1.9141414E-7, 8.9782646E-10, 166.5741153, 6.4134738261, -1219.4032921817, -1.5447958E-4, -1.8151424E-7, 8.57393E-10, 117.2606951, 12.0248388879, 23976.2204478244, -1.3020942E-4, 5.8996977E-8, -2.8851262E-10, 61.9119504, 6.3390143893, 25090.8490070907, 2.4060421E-4, 4.9587228E-7, -2.3524614E-9, 33.3572027, 11.1245829706, 15437.9795572686, 1.5014592E-4, 3.1930799E-7, -1.5152852E-9, 31.7596709, 3.0832038997, 8223.9166918098, 3.686468E-4, 5.0577218E-7, -2.3928949E-9, 29.5766003, 8.8121540801, 6480.986177295, 4.9705523E-7, 6.828048E-8, -2.7450635E-10, 15.5662654, 4.0579192538, -9548.0947169068, -3.0679233E-4, -4.3192536E-7, 2.0437321E-9, 15.1215543, 14.3803934601, 32304.9118725496, 2.2103334E-5, 3.0940809E-7, -1.4748517E-9, -12.0941511, 8.7259027166, 7737.590087792, -4.8307078E-6, 6.9513264E-8, -3.8338581E-10, 8.8681426, 9.7124099974, 15019.2270678508, -2.7985829E-4, -1.9203053E-7, 9.5226618E-10, 8.04504, 0.6687636586, 8399.709110503, -3.3191993E-5, 3.2017096E-8, -1.5363746E-10, 7.9585542, 12.0679645696, 23347.918492576, -1.2754553E-4, 5.8380585E-8, -2.3407289E-10, 7.434555, 6.4565995078, -1847.7052474301, -1.518157E-4, -1.8213063E-7, 9.1183272E-10, -6.7314363, -4.0265854988, -16133.8556271171, -9.0955337E-5, -2.4484477E-7, 1.1116826E-9, 6.579575, 16.8104074692, 14323.3509980023, -2.206677E-4, -1.1756732E-7, 5.4866364E-10, -6.4600721, 1.584779563, 9061.768112889, -6.6685176E-5, -4.3335556E-9, -3.4222998E-11, -6.2964773, 4.8837157343, 25300.3984729215, -1.9206388E-4, -1.4849843E-8, 6.0650192E-11, -5.6323538, -0.7707750092, 733.0766881638, -2.1899793E-4, -2.5474467E-7, 1.1521161E-9, -5.3683961, 6.8263720663, 16204.8433027325, -9.7115356E-5, 2.7023515E-8, -1.3414795E-10, -5.3112784, 3.9403341353, 17390.4595376141, 8.5627574E-5, 2.4607756E-7, -1.2205621E-9, -5.0759179, 0.6845236457, 523.5272223331, 2.1367016E-4, 2.5597745E-7, -1.2609955E-9, -4.8396143, -1.6710309265, -7805.164202392, 6.1357413E-5, 5.5663398E-9, -7.4656459E-11, -4.8057401, 3.5705615768, -662.0890125485, 3.0927234E-5, 3.692341E-8, -1.7458141E-10, 3.9840545, 8.6945689615, 33419.5404318159, 3.9291696E-4, 7.462834E-7, -3.5388005E-9, 3.6744619, 19.1659620415, 22652.0424227274, -6.8354947E-5, 1.328438E-7, -6.3767543E-10, 2.9984815, 20.0662179587, 31190.2833132833, -3.4871029E-4, -1.2746721E-7, 5.890971E-10, 2.7986413, -2.528161162, -16971.7070481963, 3.4437664E-4, 2.6526096E-7, -1.2469893E-9, 2.4138774, 17.7106633865, 22861.5918885581, -5.0102304E-4, -3.7787833E-7, 1.7754362E-9, 2.1863132, 5.5132179088, -9757.6441827375, 1.2587576E-4, 7.8796768E-8, -3.6937954E-10, 2.1461692, 13.4801375428, 23766.6709819937, 3.0245868E-4, 5.697191E-7, -2.7016242E-9, 1.7659832, 11.1677086523, 14809.6776020201, 1.5280981E-4, 3.1869159E-7, -1.4608454E-9, -1.6244212, 7.3137297434, 7318.8375983742, -4.3483492E-4, -4.4182525E-7, 2.0841655E-9, 1.5813036, 5.438758472, 16552.6081165349, 5.2095955E-4, 7.5618329E-7, -3.579234E-9, 1.5197528, 16.7359480324, 40633.6032972747, 1.7441609E-4, 5.5981921E-7, -2.6611908E-9, 1.5156341, 1.7023646816, -17876.7861416319, -4.5910508E-4, -6.8233647E-7, 3.2300712E-9, 1.5102092, 5.497729645, 8399.6847301375, -3.3094061E-5, 3.1973462E-8, -1.5436468E-10, -1.3178223, 9.6261586339, 16275.8309783478, -2.8518605E-4, -1.9079775E-7, 8.4338673E-10, -1.2642739, 11.9817132061, 24604.5224030729, -1.328733E-4, 5.9613369E-8, -3.4295235E-10, 1.1918723, 22.421772531, 39518.9747380084, -1.9639754E-4, 1.229439E-7, -5.9724197E-10, 1.134611, 14.4235191419, 31676.6099173011, 2.4767216E-5, 3.087917E-7, -1.420412E-9, 1.085781, 8.8552797618, 5852.6842220465, 3.1609367E-6, 6.7664088E-8, -2.2006663E-10, -1.0193852, 7.2392703065, 33629.0898976466, -3.9751134E-5, 2.3556127E-7, -1.1256889E-9, -0.8227141, 11.0814572888, 16066.2815125171, 1.4748204E-4, 3.1992438E-7, -1.5697249E-9, 0.8042238, 3.527435895, -33.7870573, 2.8263353E-5, 3.7539802E-8, -2.2902113E-10, 0.8025939, 6.7832463846, 16833.1452579809, -9.9779237E-5, 2.7639907E-8, -1.8858767E-10, -0.7931866, -6.382140071, -24462.5470518423, -2.4326809E-4, -4.9525589E-7, 2.2980217E-9, -0.7910153, 6.3703481443, -591.1013369332, -1.5714346E-4, -1.8089785E-7, 8.0295327E-10, -0.6674056, 9.1819266386, 24533.5347274576, 5.5197395E-5, 2.7743463E-7, -1.320487E-9, 0.6502226, 4.1010449356, -10176.3966721553, -3.0412845E-4, -4.3254175E-7, 2.0981718E-9, -0.6388131, 6.2958887075, 25719.1509623392, 2.3794032E-4, 4.9648867E-7, -2.4069012E-9};
        M21 = new double[]{0.0743, 11.9537467337, 6480.986177295, 4.9705523E-7, 6.828048E-8, -2.7450635E-10, 0.03043, 8.7259027166, 7737.590087792, -4.8307078E-6, 6.9513264E-8, -3.8338581E-10, 0.02229, 12.854002651, 15019.2270678508, -2.7985829E-4, -1.9203053E-7, 9.5226618E-10, 0.01999, 15.2095572232, 23347.918492576, -1.2754553E-4, 5.8380585E-8, -2.3407289E-10, 0.01869, 9.5981921614, -1847.7052474301, -1.518157E-4, -1.8213063E-7, 9.1183272E-10, 0.01696, 7.1681781524, 16133.8556271171, 9.0955337E-5, 2.4484477E-7, -1.1116826E-9, 0.01623, 1.584779563, 9061.768112889, -6.6685176E-5, -4.3335556E-9, -3.4222998E-11, 0.01419, -0.7707750092, 733.0766881638, -2.1899793E-4, -2.5474467E-7, 1.1521161E-9};
        M30 = new double[]{385000.5290396, 1.5707963268, 0.0, 0.0, 0.0, 0.0, -20905.3551378, 3.926350899, 8328.6914247251, 1.5231275E-4, 2.5041111E-7, -1.1863391E-9, -3699.110933, 9.6121753977, 7214.0628654588, -2.1850087E-4, -1.8646419E-7, 8.7760973E-10, -2955.9675626, 11.9677299699, 15542.754290184, -6.6188121E-5, 6.3946925E-8, -3.0872935E-10, -569.9251264, 6.2819054713, 16657.3828494503, 3.046255E-4, 5.0082223E-7, -2.3726782E-9, 246.1584797, 7.2566208254, -1114.6285592663, -3.7081362E-4, -4.368753E-7, 2.0639488E-9, -204.5861179, 12.0108556517, 14914.4523349355, -6.352424E-5, 6.3330532E-8, -2.5428962E-10, -170.7330791, 14.3232845422, 23871.4457149091, 8.6124629E-5, 3.1435804E-7, -1.4950684E-9, -152.1378118, 9.6553010794, 6585.7609102104, -2.1583699E-4, -1.8708058E-7, 9.3204945E-10, -129.6202242, -0.8278839272, -7700.3894694766, -1.5497663E-4, -2.4979472E-7, 1.1318993E-9, 108.7427014, 6.7692631483, 7771.377145092, -3.3094061E-5, 3.1973462E-8, -1.5436468E-10, 104.7552944, 3.8832252173, 8956.9933799736, 1.4964887E-4, 2.5102751E-7, -1.2407788E-9, 79.6605685, 0.6705404095, -8538.2408905558, 2.8035534E-4, 2.6031101E-7, -1.2267725E-9, 48.8883284, 1.527670645, 628.3019552485, -2.6638815E-6, 6.1639211E-10, -5.4439728E-11, -34.7825237, 20.0091090408, 22756.8171556428, -2.8468899E-4, -1.2251727E-7, 5.6888037E-10, 30.8238599, 11.9246042882, 16171.0562454324, -6.8852003E-5, 6.4563317E-8, -3.6316908E-10, 24.2084985, 9.5690497159, 7842.3648207073, -2.2116475E-4, -1.858478E-7, 8.2317E-10, -23.2104305, 8.6374600436, 24986.0742741754, 4.5693825E-4, 7.5123334E-7, -3.5590172E-9, -21.6363439, 17.6535544685, 14428.1257309177, -4.3700174E-4, -3.7292838E-7, 1.7552195E-9, -16.6747239, 6.7261374666, 8399.6791003405, -3.5757942E-5, 3.2589854E-8, -2.088044E-10, 14.402689, 4.9010662531, -9443.3199839914, -5.2312637E-4, -6.8728642E-7, 3.2502879E-9, -12.8314035, 14.3664102239, 23243.1437596606, 8.8788511E-5, 3.1374165E-7, -1.4406287E-9, -11.6499478, 22.364663613, 31085.5085803679, -1.3237624E-4, 1.2789385E-7, -6.174587E-10, -10.4447578, 16.6788391144, 32200.1371396342, 2.3843738E-4, 5.6476915E-7, -2.6814075E-9, 10.3211071, 8.7119194804, -1324.178025097, 6.1854469E-5, 7.384682E-8, -3.4916281E-10, 10.0562033, 7.2997465071, -1742.9305145148, -3.6814974E-4, -4.374917E-7, 2.1183885E-9, -9.8844667, 12.0539813334, 14286.150379687, -6.0860358E-5, 6.271414E-8, -1.998499E-10, 8.7515625, 6.3563649081, -9652.8694498221, -9.0458282E-5, -1.7656429E-7, 8.3717626E-10, -8.3791067, 4.4137085761, -557.3142796331, -1.8540681E-4, -2.1843765E-7, 1.0319744E-9, -7.0026961, -3.1834384995, -16029.0808942018, -3.0728938E-4, -5.0020584E-7, 2.3182384E-9, 6.3220032, 9.1248177206, 16100.0685698171, 1.1921869E-4, 2.8238458E-7, -1.3407038E-9, 5.7508579, 6.2387797896, 17285.6848046987, 3.0196162E-4, 5.0143862E-7, -2.4271179E-9, -4.9501349, 9.6984267611, 5957.4589549619, -2.1317311E-4, -1.8769697E-7, 9.8648918E-10, -4.421177, 3.0260949818, -209.5494658307, 4.3266809E-4, 5.1072212E-7, -2.4131116E-9, 4.1311145, 11.0674740526, 7004.5133996281, 2.1416722E-4, 3.2425793E-7, -1.5355019E-9, -3.9579827, 20.0522347225, 22128.5152003943, -2.8202511E-4, -1.2313366E-7, 6.233201E-10, 3.2582371, 14.8106422192, 14985.4400105508, -2.5159493E-4, -1.5449073E-7, 7.2324505E-10, -3.148302, 4.8266068163, 16866.932315281, -1.2804259E-4, -9.8998954E-9, 4.0433461E-11, 2.6164092, 14.2801588604, 24499.7476701576, 8.3460748E-5, 3.1497443E-7, -1.5495082E-9, 2.353631, 9.5259240342, 8470.6667759558, -2.2382863E-4, -1.8523141E-7, 7.6873027E-10, -2.1171283, -0.871009609, -7072.0875142282, -1.5764051E-4, -2.4917833E-7, 1.0774596E-9, -1.8970368, 17.6966801503, 13799.8237756692, -4.3433786E-4, -3.7354477E-7, 1.8096592E-9, -1.7385258, 2.0581540038, -8886.0057043583, -3.3771956E-4, -4.6884877E-7, 2.2183135E-9, -1.5713944, 22.4077892948, 30457.2066251194, -1.2971236E-4, 1.2727746E-7, -5.6301898E-10, -1.4225541, 24.7202181853, 39414.200005093, 1.9936508E-5, 3.7830496E-7, -1.8037978E-9, -1.4189284, 17.1661967915, 23314.1314352759, -9.9282182E-5, 9.5920387E-8, -4.6309403E-10, 1.1655364, 3.8400995356, 9585.2953352221, 1.4698499E-4, 2.516439E-7, -1.2952185E-9, -1.1169371, 10.9930146158, 33314.7656989005, 6.09251E-4, 1.0016445E-6, -4.7453563E-9, 1.0656723, 1.4845449633, 1256.603910497, -5.327763E-6, 1.2327842E-9, -1.0887946E-10, 1.058619, 11.9220903668, 8364.7398411275, -2.1850087E-4, -1.8646419E-7, 8.7760973E-10, -0.9333176, 9.0816920389, 16728.3705250656, 1.1655481E-4, 2.8300097E-7, -1.3951435E-9, 0.8624328, 12.455087647, 6656.7485858257, -4.0390768E-4, -4.0490184E-7, 1.9095841E-9, 0.8512404, 4.3705828944, 70.9876756153, -1.8807069E-4, -2.1782126E-7, 9.7753467E-10, -0.8488018, 16.7219647962, 31571.8351843857, 2.4110126E-4, 5.6415276E-7, -2.6269678E-9, -0.7956264, 3.5134526588, -9095.555170189, 9.4948529E-5, 4.1873358E-8, -1.9479814E-10};
        M31 = new double[]{0.51395, 12.0108556517, 14914.4523349355, -6.352424E-5, 6.3330532E-8, -2.5428962E-10, 0.38245, 9.6553010794, 6585.7609102104, -2.1583699E-4, -1.8708058E-7, 9.3204945E-10, 0.32654, 3.9694765808, 7700.3894694766, 1.5497663E-4, 2.4979472E-7, -1.1318993E-9, 0.26396, 0.7416325637, 8956.9933799736, 1.4964887E-4, 2.5102751E-7, -1.2407788E-9, 0.12302, -1.6139220085, 628.3019552485, -2.6638815E-6, 6.1639211E-10, -5.4439728E-11, 0.07754, 8.7830116346, 16171.0562454324, -6.8852003E-5, 6.4563317E-8, -3.6316908E-10, 0.06068, 6.4274570623, 7842.3648207073, -2.2116475E-4, -1.858478E-7, 8.2317E-10, 0.0497, 12.0539813334, 14286.150379687, -6.0860358E-5, 6.271414E-8, -1.998499E-10};
        M1n = new double[]{3.81034392032, 8399.68473021, -3.31919929753E-5, 3.20170955005E-8, -1.53637455544E-10};
        EnnT = 0.0;
        MnnT = 0.0;
    }

    private static double Enn(double[] dArray) {
        double d = 0.0;
        int n = 0;
        while (n < dArray.length) {
            d += dArray[n] * Math.cos(dArray[n + 1] + EnnT * dArray[n + 2]);
            n += 3;
        }
        return d;
    }

    private static double Mnn(double[] dArray) {
        double d = MnnT;
        double d2 = d * d;
        double d3 = d2 * d;
        double d4 = 0.0;
        int n = 0;
        while (n < dArray.length) {
            d4 += dArray[n] * Math.sin(dArray[n + 1] + dArray[n + 2] * d + dArray[n + 3] * d2 + dArray[n + 4] * d3 + dArray[n + 5] * (d3 * d));
            n += 6;
        }
        return d4;
    }

    static /* synthetic */ String access$1000(double d) {
        return SolarTermUtil.doubleToString(d);
    }

    private static void addGxc(double d, double[] dArray) {
        double d2 = d / 36525.0;
        double d3 = d2 * d2;
        double d4 = d3 * d2;
        double[] dArray2 = GXC_L;
        double d5 = dArray2[0];
        double d6 = dArray2[1];
        double d7 = dArray2[2];
        double d8 = dArray2[3];
        double d9 = dArray2[4];
        dArray2 = GXC_P;
        double d10 = dArray2[0];
        double d11 = dArray2[1];
        double d12 = dArray2[2];
        dArray2 = GXC_E;
        d = dArray2[0] + dArray2[1] * d2 + dArray2[2] * d3;
        d4 = d5 + d6 * d2 + d7 * d3 + d8 * d4 + d9 * (d4 * d2) - dArray[0];
        d11 = d10 + d11 * d2 + d12 * d3 - dArray[0];
        dArray[0] = dArray[0] - (Math.cos(d4) - Math.cos(d11) * d) * 9.936508497454117E-5 / Math.cos(dArray[1]);
        dArray[1] = dArray[1] - Math.sin(dArray[1]) * 9.936508497454117E-5 * (Math.sin(d4) - d * Math.sin(d11));
        dArray[0] = SolarTermUtil.rad2mrad(dArray[0]);
    }

    private static double angleDiff(int n, double d, double d2) {
        double[] dArray = SolarTermUtil.earCal(d);
        dArray[0] = dArray[0] + Math.PI;
        dArray[1] = -dArray[1];
        SolarTermUtil.addGxc(d, dArray);
        if (n != 0) return SolarTermUtil.rad2mrad(d2 - (SolarTermUtil.moonCoord(d)[0] - dArray[0]));
        Nutation nutation = SolarTermUtil.nutation(d);
        dArray[0] = dArray[0] + Nutation.access$800((Nutation)nutation);
        return SolarTermUtil.rad2mrad(d2 - dArray[0]);
    }

    private static double atomTimeDiff(double d) {
        return SolarTermUtil.worldTimeDiff(d / 365.2425 + 2000.0) / 86400.0;
    }

    private static double doubleFloor(double d) {
        double d2;
        d = d2 = Math.floor(d);
        if (!(d2 < 0.0)) return d;
        d = d2 + 1.0;
        return d;
    }

    private static String doubleToString(double d) {
        CharSequence charSequence;
        int n = (int)d;
        if (d < 10.0) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("0");
            ((StringBuilder)charSequence).append(n);
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = String.valueOf(n);
        }
        return charSequence;
    }

    private static double[] earCal(double d) {
        double d2;
        EnnT = d2 = d / 365250.0;
        double[] dArray = new double[3];
        double d3 = d2 * d2;
        double d4 = d3 * d2;
        d = d4 * d2;
        dArray[0] = SolarTermUtil.Enn(E10) + SolarTermUtil.Enn(E11) * d2 + SolarTermUtil.Enn(E12) * d3 + SolarTermUtil.Enn(E13) * d4 + SolarTermUtil.Enn(E14) * d + SolarTermUtil.Enn(E15) * (d * d2);
        dArray[1] = SolarTermUtil.Enn(E20) + SolarTermUtil.Enn(E21) * d2;
        dArray[2] = SolarTermUtil.Enn(E30) + SolarTermUtil.Enn(E31) * d2 + SolarTermUtil.Enn(E32) * d3 + SolarTermUtil.Enn(E33) * d4;
        dArray[0] = SolarTermUtil.rad2mrad(dArray[0]);
        return dArray;
    }

    public static String[] getSolarTerms(int n) {
        String[] stringArray = new String[24];
        int n2 = n - 1;
        Time time = SolarTermUtil.getSolarTermsPreOffset(n2);
        Object object = SolarTermUtil.getSolarTermsNextOffset(n2);
        System.arraycopy(time, 0, stringArray, 0, ((String[])time).length);
        System.arraycopy(object, 0, stringArray, 22, ((String[])object).length);
        double d = n - 2000;
        Double.isNaN(d);
        n = 0;
        while (n < 19) {
            double d2 = n;
            Double.isNaN(d2);
            time = SolarTermUtil.setFromJulian(SolarTermUtil.getTimeFromAngle(d2 * 15.2 + d * 365.2422, n * 15, 0) + 2451545.0 + 0.3333333333333333, true);
            object = new StringBuilder();
            ((StringBuilder)object).append(time.toString());
            ((StringBuilder)object).append(SOLAR_TERMS[n]);
            stringArray[n + 3] = ((StringBuilder)object).toString();
            ++n;
        }
        return stringArray;
    }

    private static String[] getSolarTermsNextOffset(int n) {
        String[] stringArray = new String[2];
        double d = n - 2000;
        Double.isNaN(d);
        n = 19;
        while (n < 21) {
            double d2 = n;
            Double.isNaN(d2);
            Time time = SolarTermUtil.setFromJulian(SolarTermUtil.getTimeFromAngle(d2 * 15.2 + d * 365.2422, n * 15, 0) + 2451545.0 + 0.3333333333333333, true);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(time.toString());
            stringBuilder.append(SOLAR_TERMS[n]);
            stringArray[n - 19] = stringBuilder.toString();
            ++n;
        }
        return stringArray;
    }

    private static String[] getSolarTermsPreOffset(int n) {
        String[] stringArray = new String[3];
        double d = n - 2000;
        Double.isNaN(d);
        n = 21;
        while (n < 24) {
            double d2 = n;
            Double.isNaN(d2);
            Time time = SolarTermUtil.setFromJulian(SolarTermUtil.getTimeFromAngle(d2 * 15.2 + d * 365.2422, n * 15, 0) + 2451545.0 + 0.3333333333333333, true);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(time.toString());
            stringBuilder.append(SOLAR_TERMS[n]);
            stringArray[n - 21] = stringBuilder.toString();
            ++n;
        }
        return stringArray;
    }

    private static double getTimeFromAngle(double d, double d2, int n) {
        double d3 = d;
        d = n == 0 ? 360.0 : 25.0;
        double d4 = Math.PI / 180 * d2;
        double d5 = SolarTermUtil.angleDiff(n, d3, d4);
        double d6 = d2 = SolarTermUtil.angleDiff(n, d += d3, d4);
        if (d5 < d2) {
            d6 = d2 - Math.PI * 2;
        }
        int n2 = 0;
        d2 = 0.0;
        double d7 = 1.0;
        double d8 = d3;
        while (true) {
            double d9 = d5;
            d5 = d6;
            if (n2 >= 10) return d2;
            d2 = (d5 - d9) / (d - d8);
            d3 = d7;
            if (Math.abs(d2) > 1.0E-15) {
                d3 = d2;
            }
            if ((d6 = SolarTermUtil.angleDiff(n, d2 = d8 - d9 / d3, d4)) > 1.0) {
                d6 -= Math.PI * 2;
            }
            if (Math.abs(d6) < 1.0E-8) {
                return d2;
            }
            ++n2;
            d8 = d;
            d = d2;
            d7 = d3;
        }
    }

    static void init(Context context) {
        SOLAR_TERMS = context.getResources().getStringArray(R.array.solar_term);
    }

    private static double[] moonCoord(double d) {
        double d2;
        MnnT = d2 = d / 36525.0;
        double d3 = d2 * d2;
        double d4 = d3 * d2;
        double[] dArray = new double[]{(SolarTermUtil.Mnn(M10) + SolarTermUtil.Mnn(M11) * d2 + SolarTermUtil.Mnn(M12) * d3) / 206264.80624709636, (SolarTermUtil.Mnn(M20) + SolarTermUtil.Mnn(M21) * d2) / 206264.80624709636, (SolarTermUtil.Mnn(M30) + SolarTermUtil.Mnn(M31) * d2) * 0.999999949827};
        double d5 = dArray[0];
        double[] dArray2 = M1n;
        dArray[0] = d5 + dArray2[0] + dArray2[1] * d2 + dArray2[2] * d3 + dArray2[3] * d4 + dArray2[4] * (d4 * d2);
        dArray[0] = SolarTermUtil.rad2mrad(dArray[0]);
        SolarTermUtil.precession(d, dArray);
        return dArray;
    }

    private static Nutation nutation(double d) {
        Nutation nutation = new Nutation(null);
        Nutation.access$802((Nutation)nutation, (double)0.0);
        Nutation.access$902((Nutation)nutation, (double)0.0);
        double d2 = d / 36525.0;
        d = d2 * d2;
        double d3 = d * d2;
        int n = 0;
        while (true) {
            double[] dArray;
            if (n >= (dArray = nutB).length) {
                Nutation.access$802((Nutation)nutation, (double)(Nutation.access$800((Nutation)nutation) / 2.0626480624709637E9));
                Nutation.access$902((Nutation)nutation, (double)(Nutation.access$900((Nutation)nutation) / 2.0626480624709637E9));
                return nutation;
            }
            double d4 = dArray[n] + dArray[n + 1] * d2 + dArray[n + 2] * d + dArray[n + 3] * d3 + dArray[n + 4] * (d3 * d2);
            double d5 = Nutation.access$800((Nutation)nutation);
            dArray = nutB;
            Nutation.access$802((Nutation)nutation, (double)(d5 + (dArray[n + 5] + dArray[n + 6] * d2 / 10.0) * Math.sin(d4)));
            d5 = Nutation.access$900((Nutation)nutation);
            dArray = nutB;
            Nutation.access$902((Nutation)nutation, (double)(d5 + (dArray[n + 7] + dArray[n + 8] * d2 / 10.0) * Math.cos(d4)));
            n += 9;
        }
    }

    private static void precession(double d, double[] dArray) {
        double d2 = d / 365250.0;
        int n = 1;
        double d3 = 1.0;
        d = 0.0;
        while (true) {
            if (n >= 8) {
                dArray[0] = SolarTermUtil.rad2mrad(dArray[0] + (d + d2 * 2.9965) / 206264.80624709636);
                return;
            }
            d += H_C_ANGLE_TABLE[n] * (d3 *= d2);
            ++n;
        }
    }

    private static double rad2mrad(double d) {
        double d2;
        d = d2 = d % (Math.PI * 2);
        if (!(d2 < 0.0)) return d;
        d = d2 + Math.PI * 2;
        return d;
    }

    private static Time setFromJulian(double d, boolean bl) {
        Time time = new Time(null);
        double d2 = d;
        if (bl) {
            d2 = d - SolarTermUtil.atomTimeDiff(d - 2451545.0);
        }
        double d3 = d2 + 0.5;
        d = d2 = SolarTermUtil.doubleFloor(d3);
        if (d2 > 2299161.0) {
            d = SolarTermUtil.doubleFloor((d2 - 1867216.25) / 36524.25);
            d = d2 + (1.0 + d - SolarTermUtil.doubleFloor(d / 4.0));
        }
        Time.access$002((Time)time, (double)SolarTermUtil.doubleFloor(((d += 1524.0) - 122.1) / 365.25));
        Time.access$102((Time)time, (double)SolarTermUtil.doubleFloor((d -= SolarTermUtil.doubleFloor(Time.access$000((Time)time) * 365.25)) / 30.6001));
        Time.access$202((Time)time, (double)(d - SolarTermUtil.doubleFloor(Time.access$100((Time)time) * 30.6001)));
        Time.access$002((Time)time, (double)(Time.access$000((Time)time) - 4716.0));
        Time.access$110((Time)time);
        if (Time.access$100((Time)time) > 12.0) {
            Time.access$102((Time)time, (double)(Time.access$100((Time)time) - 12.0));
        }
        if (Time.access$100((Time)time) <= 2.0) {
            Time.access$008((Time)time);
        }
        d = (d3 - d2) * 24.0;
        Time.access$502((Time)time, (double)SolarTermUtil.doubleFloor(d));
        d = (d - Time.access$500((Time)time)) * 60.0;
        Time.access$402((Time)time, (double)SolarTermUtil.doubleFloor(d));
        Time.access$302((Time)time, (double)((d - Time.access$400((Time)time)) * 60.0));
        return time;
    }

    private static double toJulian(Time time, boolean bl) {
        double d = Time.access$000((Time)time);
        double d2 = Time.access$100((Time)time);
        double d3 = d;
        double d4 = d2;
        if (d2 <= 2.0) {
            d4 = d2 + 12.0;
            d3 = d - 1.0;
        }
        if (Time.access$000((Time)time) * 372.0 + Time.access$100((Time)time) * 31.0 + Time.access$200((Time)time) >= 588829.0) {
            d = SolarTermUtil.doubleFloor(d3 / 100.0);
            d = 2.0 - d + SolarTermUtil.doubleFloor(d / 4.0);
        } else {
            d = 0.0;
        }
        d4 = d3 = d + SolarTermUtil.doubleFloor((d3 + 4716.0) * 365.2500001) + (SolarTermUtil.doubleFloor((d4 + 1.0) * 30.6) + Time.access$200((Time)time)) + (((Time.access$300((Time)time) / 60.0 + Time.access$400((Time)time)) / 60.0 + Time.access$500((Time)time)) / 24.0 - 1524.5);
        if (!bl) return d4;
        d4 = d3 + SolarTermUtil.atomTimeDiff(d3 - 2451545.0);
        return d4;
    }

    private static double worldTimeDiff(double d) {
        int n;
        double[] dArray;
        int n2 = 0;
        while (n2 < 100 && !(d < (dArray = DTS)[n = n2 + 5]) && n2 != 95) {
            n2 = n;
        }
        dArray = DTS;
        double d2 = (d - dArray[n2]) / (dArray[n2 + 5] - dArray[n2]) * 10.0;
        d = d2 * d2;
        return dArray[n2 + 1] + dArray[n2 + 2] * d2 + dArray[n2 + 3] * d + dArray[n2 + 4] * (d * d2);
    }
}
