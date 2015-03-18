/*******************************************************************************
 * Copyright (c) 2010 Haifeng Li
 *   
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package smile.mds;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smile.math.Math;

/**
 *
 * @author Haifeng Li
 */
public class MDSTest {

    double[][] eurodist = {
        {0, 3313, 2963, 3175, 3339, 2762, 3276, 2610, 4485, 2977, 3030, 4532, 2753, 3949, 2865, 2282, 2179, 3000, 817, 3927, 1991},
        {3313, 0, 1318, 1326, 1294, 1498, 2218, 803, 1172, 2018, 1490, 1305, 645, 636, 521, 1014, 1365, 1033, 1460, 2868, 1802},
        {2963, 1318, 0, 204, 583, 206, 966, 677, 2256, 597, 172, 2084, 690, 1558, 1011, 925, 747, 285, 1511, 1616, 1175},
        {3175, 1326, 204, 0, 460, 409, 1136, 747, 2224, 714, 330, 2052, 739, 1550, 1059, 1077, 977, 280, 1662, 1786, 1381},
        {3339, 1294, 583, 460, 0, 785, 1545, 853, 2047, 1115, 731, 1827, 789, 1347, 1101, 1209, 1160, 340, 1794, 2196, 1588},
        {2762, 1498, 206, 409, 785, 0, 760, 1662, 2436, 460, 269, 2290, 714, 1764, 1035, 911, 583, 465, 1497, 1403, 937},
        {3276, 2218, 966, 1136, 1545, 760, 0, 1418, 3196, 460, 269, 2971, 1458, 2498, 1778, 1537, 1104, 1176, 2050, 650, 1455},
        {2610, 803, 677, 747, 853, 1662, 1418, 0, 1975, 1118, 895, 1936, 158, 1439, 425, 328, 591, 513, 995, 2068, 1019},
        {4485, 1172, 2256, 2224, 2047, 2436, 3196, 1975, 0, 2897, 2428, 676, 1817, 698, 1693, 2185, 2565, 1971, 2631, 3886, 2974},
        {2977, 2018, 597, 714, 1115, 460, 460, 1118, 2897, 0, 550, 2671, 1159, 2198, 1479, 1238, 805, 877, 1751, 949, 1155},
        {3030, 1490, 172, 330, 731, 269, 269, 895, 2428, 550, 0, 2280, 863, 1730, 1183, 1098, 851, 457, 1683, 1500, 1205},
        {4532, 1305, 2084, 2052, 1827, 2290, 2971, 1936, 676, 2671, 2280, 0, 1178, 668, 1762, 2250, 2507, 1799, 2700, 3231, 2937},
        {2753, 645, 690, 739, 789, 714, 1458, 158, 1817, 1159, 863, 1178, 0, 1281, 320, 328, 724, 471, 1048, 2108, 1157},
        {3949, 636, 1558, 1550, 1347, 1764, 2498, 1439, 698, 2198, 1730, 668, 1281, 0, 1157, 1724, 2010, 1273, 2097, 3188, 2409},
        {2865, 521, 1011, 1059, 1101, 1035, 1778, 425, 1693, 1479, 1183, 1762, 320, 1157, 0, 618, 1109, 792, 1011, 2428, 1363},
        {2282, 1014, 925, 1077, 1209, 911, 1537, 328, 2185, 1238, 1098, 2250, 328, 1724, 618, 0, 331, 856, 586, 2187, 898},
        {2179, 1365, 747, 977, 1160, 583, 1104, 591, 2565, 805, 851, 2507, 724, 2010, 1109, 331, 0, 821, 946, 1754, 428},
        {3000, 1033, 285, 280, 340, 465, 1176, 513, 1971, 877, 457, 1799, 471, 1273, 792, 856, 821, 0, 1476, 1827, 1249},
        {817, 1460, 1511, 1662, 1794, 1497, 2050, 995, 2631, 1751, 1683, 2700, 1048, 2097, 1011, 586, 946, 1476, 0, 2707, 1209},
        {3927, 2868, 1616, 1786, 2196, 1403, 650, 2068, 3886, 949, 1500, 3231, 2108, 3188, 2428, 2187, 1754, 1827, 2707, 0, 2105},
        {1991, 1802, 1175, 1381, 1588, 937, 1455, 1019, 2974, 1155, 1205, 2937, 1157, 2409, 1363, 898, 428, 1249, 1209, 2105, 0}
    };

    public MDSTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of learn method, of class MDS.
     */
    @Test
    public void testLearn_doubleArrArr() {
        System.out.println("learn");

        double[] eigs = {19538377.0895, 11856555.3340};
        double[][] points = {
            { 2290.274680,  1798.80293},
            { -825.382790,   546.81148},
            {   59.183341,  -367.08135},
            {  -82.845973,  -429.91466},
            { -352.499435,  -290.90843},
            {  293.689633,  -405.31194},
            {  681.931545, -1108.64478},
            {   -9.423364,   240.40600},
            {-2048.449113,   642.45854},
            {  561.108970,  -773.36929},
            { 164.921799,   -549.36704},
            {-1935.040811,    49.12514},
            { -226.423236,   187.08779},
            {-1423.353697,   305.87513},
            { -299.498710,   388.80726},
            {  260.878046,   416.67381},
            {  587.675679,    81.18224},
            { -156.836257,  -211.13911},
            {  709.413282,  1109.36665},
            {  839.445911, -1836.79055},
            {  911.230500,   205.93020}
        };

        MDS mds = new MDS(eurodist);
        assertTrue(Math.equals(eigs, mds.getEigenValues(), 1E-4));

        double[][] coords = mds.getCoordinates();
        for (int j = 0; j < coords[0].length; j++) {
            double sign = coords[0][j] * points[0][j];
            if (sign >= 0) {
                sign = 1;
            } else {
                sign = -1;
            }

            for (int i = 0; i < coords.length; i++) {
                assertEquals(points[i][j], sign*coords[i][j], 1E-4);
            }
        }
    }

    /**
     * Test of learn method, of class MDS.
     */
    @Test
    public void testLearn_doubleArrArr_double() {
        System.out.println("learn");

        double[] eigs = {42274973.8, 31666186.4};
        double[][] points = {
            { 2716.561820,  3549.216493},
            {-1453.753109,   455.895291},
            {  217.426476, -1073.442137},
            {    1.682974, -1135.742982},
            { -461.875781,  -871.913389},
            {  594.256798, -1029.818247},
            { 1271.216005, -1622.039302},
            {  -88.721376,     4.068005},
            {-3059.180990,   836.535103},
            { 1056.316198, -1350.037932},
            {  445.663432, -1304.392098},
            {-2866.160085,   211.043554},
            { -436.147722,  -140.147837},
            {-2300.753691,   234.863677},
            { -586.877042,   217.428075},
            {  336.906562,   350.948939},
            {  928.407679,  -112.132182},
            { -193.653844,  -847.157498},
            {  908.682100,  1742.395923},
            { 1499.140467, -1897.522865},
            { 1319.918808,   295.010834}
        };

        MDS mds = new MDS(eurodist, 2, true);
        assertTrue(Math.equals(eigs, mds.getEigenValues(), 1E-1));

        double[][] coords = mds.getCoordinates();
        for (int j = 0; j < coords[0].length; j++) {
            double sign = coords[0][j] * points[0][j];
            if (sign >= 0) {
                sign = 1;
            } else {
                sign = -1;
            }

            for (int i = 0; i < coords.length; i++) {
                assertEquals(points[i][j], sign*coords[i][j], 1E-4);
            }
        }
    }
}