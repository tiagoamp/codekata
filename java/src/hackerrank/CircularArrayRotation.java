package hackerrank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CircularArrayRotation {

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int nrOfRotations = (k > a.length) ? k % a.length : k;
        int  rotationIndex = a.length - nrOfRotations;
        int[] result = Arrays.stream(queries).map(q -> (q < nrOfRotations) ? a[rotationIndex + q] : a[q - nrOfRotations]).toArray();
        return result;
    }


    @Test
    @DisplayName("Test sample input 0")
    void test0() {
        int[] a = {1,2,3},  queries = {0,1,2}, expected = {2,3,1};
        int k = 2;
        int [] result = circularArrayRotation(a,k,queries);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test sample input 3")
    void test3() {
        int[] a = {10160, 27429, 61174, 92314, 90626, 66576, 13013, 3055, 28071, 13366, 48292, 83192, 376, 63276, 35825, 39497, 39701, 46967,
                95656, 92257, 31122, 91431, 72587, 78900, 77935, 27666, 52875, 56477, 89913, 43214, 32042, 16424, 70643, 9567, 25090, 61268, 76142,
                38102, 80674, 4212, 67819, 45317, 3756, 68194, 8592, 39580, 24042, 64644, 2898, 36050, 73252, 34020, 27480, 62191, 12919, 5415, 6208,
                82146, 78243, 12472, 25359, 10284, 28896, 12353, 36202, 53985, 89973, 12343, 8438, 86998, 32907, 76257, 32315, 36662, 60802, 57258,
                92593, 84844, 38254, 95490, 37245, 11505, 45861, 81076, 73695, 58780, 86490, 96254, 57277, 81085, 8726, 98987, 7720, 53973, 11340,
                43922, 24309, 17664, 56264, 32746, 4661, 89170, 25354, 53327, 42183, 86156, 10585, 34775, 87351, 48838, 30265, 24595, 76694, 76125,
                5670, 66741, 51256, 8512, 62994, 8532, 5948, 88071, 23871, 13667, 42043, 51562, 73940, 66351, 69225, 46556, 15449, 73885, 35725, 40802,
                43564, 94260, 43309, 54148, 29034, 30659, 19337, 59298, 71605, 96030, 51775, 93627, 79122, 3030, 18490, 42116, 27914, 40789, 30186,
                51784, 54455, 88581, 3345, 44747, 54931, 88921, 91302, 86731, 79157, 43378, 43885, 22720, 37637, 87193, 93219, 66671, 17852, 12555,
                42320, 5808, 24937, 94094, 15786, 4058, 13476, 34275, 62525, 57741, 75063, 9063, 9524, 45870, 97643, 29220, 6968, 68925, 34492, 98269,
                55656, 13648, 57998, 99540, 52720, 95635, 86732, 45938, 78657, 20935, 74845, 37328, 43095, 99781, 47774, 58880, 20190, 61249, 9507,
                99067, 35341, 84569};
        int k = 1;
        int[] queries = {76, 39, 57, 212, 202, 210, 14, 47, 188, 183, 178, 78, 148, 19, 118, 74, 103, 52, 72, 97, 155, 52, 75, 48, 202, 202, 14, 112, 210, 34,
                104, 4, 5, 94, 148, 207, 90, 163, 186, 211, 132, 83, 75, 67, 102, 193, 73, 205, 177, 77, 88, 50, 62, 163, 99, 50, 84, 113, 162, 12, 148, 198, 17,
                153, 78, 165, 79, 101, 46, 197, 98, 179, 66, 105, 178, 101, 16, 183, 92, 193, 46, 113, 29, 108, 208, 60, 158, 78, 174, 38, 23, 40, 23, 186, 125,
                33, 69, 136, 66, 116, 120, 96, 81, 118, 201, 191, 5, 3, 92, 98, 196, 138, 143, 158, 179, 137, 4, 55, 148, 110, 94, 103, 150, 49, 75, 208, 14, 144,
                130, 13, 46, 182, 109, 59, 87, 97, 182, 92, 32, 60, 122, 161, 199, 51, 105, 96, 121, 41, 151, 201, 152, 177, 90, 20, 158, 165, 14, 173, 95, 77, 186,
                74, 45, 13, 133, 64, 110, 102, 157, 143, 162, 65, 90, 79, 49, 127, 175, 170, 168, 45, 157, 38, 154, 33, 59, 99, 130, 5, 204, 157, 14, 108, 17, 60,
                121, 83, 124, 18, 185, 213, 93, 65, 211, 183, 77, 46, 28, 184, 2, 196, 15, 91, 21, 170, 124, 12, 201, 40, 17, 191, 197, 32, 85, 147, 24, 206, 16, 80,
                156, 133, 12, 35, 130, 9, 150, 207, 55, 178, 110, 203, 161, 125, 80, 114, 13, 204, 126, 0, 176, 75, 123, 91, 39, 208, 170, 63, 133, 186, 76, 75, 37,
                88, 111, 168, 97, 47, 161, 84, 158, 57, 73, 37, 115, 153, 151, 60, 75, 209, 207, 183, 70, 116, 206, 42, 43, 163, 105, 176, 135, 113, 37, 173, 201,
                80, 59, 16, 60, 152, 100, 4, 142, 105, 41, 43, 44, 124, 35, 51, 119, 28, 20, 121, 77, 13, 163, 120, 108, 201, 82, 175, 100, 51, 134, 20, 132, 193,
                182, 124, 64, 1, 128, 206, 106, 101, 181, 83, 11, 2, 134, 130, 177, 87, 37, 40, 32, 201, 92, 140, 120, 106, 101, 6, 157, 168, 172, 7, 79, 141, 131,
                143, 74, 191, 135, 180, 78, 102, 49, 89, 37, 116, 151, 0, 203, 189, 186, 167, 108, 210, 93, 14, 102, 126, 166, 191, 80, 57, 131, 160, 130, 194, 21,
                204, 172, 89, 170, 182, 191, 152, 204, 160, 200, 141, 92, 189, 48, 64, 142, 88, 206, 167, 34, 94, 79, 201, 4, 160, 190, 135, 38, 106, 115, 205, 96,
                5, 80, 198, 120, 58, 68, 110, 150, 54, 37, 29, 175, 18, 25, 103, 106, 18, 202, 141, 44, 68, 60, 48, 160, 36, 183, 198, 142, 17, 189, 170, 168, 202,
                86, 74, 192, 155, 184, 128, 141, 154, 157, 103, 172, 183, 206, 210, 133, 127, 137, 177, 195, 197, 12, 141, 19, 127, 57, 93, 76, 178, 195, 31, 166,
                68, 37, 144, 155, 8, 59, 82, 94, 148, 185, 198, 49, 110};
        int[] expected = {57258, 80674, 6208, 99067, 20935, 61249, 63276, 24042, 29220, 75063, 4058, 84844, 3030, 95656, 8512, 36662, 25354,
                34020, 76257, 24309, 54455, 34020, 60802, 64644, 20935, 20935, 63276, 24595, 61249, 9567, 53327, 92314, 90626, 53973, 3030, 47774,
                81085, 79157, 45870, 9507, 73885, 45861, 60802, 89973, 89170, 55656, 32315, 43095, 15786, 92593, 96254, 36050, 10284, 79157, 56264,
                36050, 81076, 76694, 86731, 83192, 3030, 95635, 39701, 30186, 84844, 43885, 38254, 4661, 39580, 52720, 17664, 13476, 53985, 42183,
                4058, 4661, 39497, 75063, 98987, 55656, 39580, 76694, 89913, 34775, 58880, 12472, 44747, 84844, 5808, 38102, 72587, 4212, 72587,
                45870, 42043, 70643, 8438, 94260, 53985, 66741, 8532, 43922, 37245, 8512, 78657, 34492, 90626, 61174, 98987, 17664, 99540, 54148,
                71605, 44747, 13476, 43309, 92314, 12919, 3030, 48838, 53973, 25354, 42116, 2898, 60802, 58880, 63276, 96030, 46556, 376, 39580,
                57741, 87351, 78243, 86490, 24309, 57741, 98987, 16424, 12472, 88071, 91302, 86732, 73252, 42183, 43922, 5948, 67819, 27914, 78657,
                40789, 15786, 81085, 92257, 44747, 43885, 63276, 42320, 11340, 92593, 45870, 36662, 8592, 376, 35725, 12353, 48838, 89170, 3345,
                71605, 86731, 36202, 81085, 38254, 2898, 73940, 24937, 66671, 87193, 8592, 3345, 38102, 51784, 70643, 78243, 56264, 46556, 90626,
                37328, 3345, 63276, 34775, 39701, 12472, 5948, 45861, 13667, 46967, 9524, 35341, 7720, 36202, 9507, 75063, 92593, 39580, 56477, 9063,
                27429, 99540, 35825, 8726, 31122, 66671, 13667, 83192, 78657, 4212, 39701, 34492, 52720, 16424, 73695, 79122, 78900, 99781, 39497,
                95490, 88581, 35725, 83192, 25090, 46556, 28071, 42116, 47774, 12919, 4058, 48838, 74845, 91302, 42043, 95490, 76125, 376, 37328,
                51562, 84569, 94094, 60802, 23871, 8726, 80674, 58880, 66671, 28896, 35725, 45870, 57258, 60802, 76142, 96254, 30265, 87193, 24309,
                24042, 91302, 81076, 44747, 6208, 32315, 76142, 5670, 30186, 27914, 12472, 60802, 20190, 47774, 75063, 86998, 66741, 99781, 45317,
                3756, 79157, 42183, 94094, 43564, 76694, 76142, 42320, 78657, 95490, 78243, 39497, 12472, 40789, 32746, 92314, 59298, 42183, 67819,
                3756, 68194, 13667, 25090, 73252, 62994, 56477, 92257, 5948, 92593, 376, 79157, 8532, 34775, 78657, 11505, 24937, 32746, 73252, 40802,
                92257, 73885, 55656, 57741, 13667, 12353, 10160, 66351, 99781, 86156, 4661, 62525, 45861, 48292, 27429, 40802, 46556, 15786, 86490,
                76142, 4212, 16424, 78657, 98987, 30659, 8532, 86156, 4661, 66576, 3345, 87193, 12555, 13013, 38254, 19337, 15449, 71605, 36662, 34492,
                43564, 34275, 84844, 89170, 2898, 57277, 76142, 66741, 27914, 84569, 74845, 6968, 45870, 37637, 34775, 61249, 7720, 63276, 89170,
                51562, 22720, 34492, 95490, 6208, 15449, 88921, 46556, 13648, 31122, 37328, 12555, 57277, 66671, 57741, 34492, 40789, 37328, 88921,
                45938, 19337, 98987, 6968, 64644, 12353, 59298, 96254, 99781, 37637, 9567, 53973, 38254, 78657, 92314, 88921, 68925, 43564, 38102,
                86156, 5670, 43095, 43922, 90626, 95490, 95635, 8532, 82146, 12343, 48838, 42116, 62191, 76142, 89913, 24937, 46967, 77935, 25354,
                86156, 46967, 20935, 19337, 68194, 12343, 12472, 64644, 88921, 61268, 75063, 95635, 59298, 39701, 6968, 66671, 87193, 20935, 58780,
                36662, 98269, 54455, 9063, 66351, 19337, 51784, 3345, 25354, 12555, 75063, 99781, 61249, 35725, 73940, 43309, 15786, 57998, 52720,
                83192, 19337, 95656, 73940, 6208, 7720, 57258, 4058, 57998, 32042, 22720, 12343, 76142, 96030, 54455, 3055, 78243, 11505, 53973, 3030,
                9524, 95635, 2898, 48838};
        int[] result = circularArrayRotation(a, k, queries);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test sample input 4")
    void test4() {
        int[] a = {29261, 80254, 86934, 3704, 76338, 96698, 47885, 88475, 65211, 65976, 75238, 58566, 28684, 20348, 45383, 58620, 48360, 99801, 51885, 82661, 83066, 14311, 24803, 99267, 21541, 93195, 21194, 20775, 64817, 42323, 7640, 10429, 38928, 94573, 30484, 15265, 7622, 78368, 3739, 72833, 60696, 95328, 31398, 5731, 15676, 93132, 64351, 64035, 9284, 32587, 46695, 92349, 46897, 87850, 7968, 84789, 81044, 45513, 5563, 62212, 87836, 13202, 88993, 26763, 24127, 19476, 42028, 31748, 14196, 62118, 4580, 91243, 73798, 52329, 96973, 89473, 61812, 77675, 69859, 71095, 10261, 32905, 79796, 57157, 20754, 87763, 41945, 1798, 33275, 63859, 80361, 37462, 93413, 69353, 64225, 17539, 5181, 22604, 49286, 19376, 1073, 70218, 26970, 74870, 38898, 23942, 80694, 710, 1617, 50552, 88156, 11877, 83457, 67951, 85386, 4210, 55713, 43682, 22359, 5340, 23893, 2720, 59153, 17305, 88424, 23377, 51195, 93604, 62332, 480, 29331, 79757, 87049, 56300, 54626, 25947, 96594, 35320, 26656, 98210, 2223, 31163, 26438, 85679, 99114, 28175, 89889, 71178, 88209, 12247, 76517, 12101, 31318, 35670, 45757, 19742, 75398, 96951, 29697, 54082, 13782, 75380, 33838, 831, 31679, 4815, 26777, 28272, 56486, 69784, 42833, 58709, 946, 85623, 44387, 59, 13797, 50627, 87589, 2005, 62874, 80457, 14105, 94191, 32478, 59861, 30284, 7876, 73163, 59981, 78309, 86945, 35360, 28498, 87775, 83390, 49664, 30903, 28014, 6150, 686, 70846, 81210, 17983, 56468, 41948, 34394, 86617, 92575, 21982, 88621, 71800, 2438, 19078, 82342, 34916, 95290, 12626, 59143, 68453, 88958, 37451, 71749, 24317, 82300, 59523, 24058, 31963, 90425, 52071, 54464, 7462, 39269, 35673, 25444, 12088, 93973, 76189, 98704, 86547, 98170, 3677, 74698, 16960, 22754, 57039, 51875, 34395, 86016, 11017, 19199, 74973, 64819, 90947, 15641, 63470, 66821, 39699, 95432, 73597, 91769, 49896, 81058, 31037, 1920, 22854, 43125, 12244, 99042, 58180, 15142, 13564, 61856, 89839, 30523, 961, 63230, 98749, 51708, 49245, 26117, 70906, 24218, 90935, 78205, 39858, 54404, 45025, 95908, 66187, 34974, 87677, 32434, 32383, 35065, 50706, 55236, 78189, 62949, 70630, 36369, 78091, 545, 14576, 67929, 47419, 15537, 31158, 46167, 67244, 96755, 72283, 54501, 37324, 79569, 32705, 77181, 50324, 94082, 73089, 16510, 45407, 77117, 65296, 77789, 12181, 16001, 49377, 6722, 78949, 36358, 59442, 73391, 36902, 74017, 41320, 84320, 5905, 88829, 46838, 89500, 1935, 19120, 44001, 39258, 98688, 93057, 32791, 49011, 3490, 22231, 81872, 48896, 99347, 47167, 26685, 27879, 79519, 92413, 34600, 74820, 28770, 94041, 48210, 65671, 84410, 5881, 66342, 90314, 11062, 13179, 96166, 12996, 32298, 40166, 52254, 47337, 49574, 85044, 12699, 53064, 7274, 94570, 18311, 22972, 58089, 61347, 50850, 37607, 53759, 1802, 12426, 82528, 12194, 60636, 64550, 96603, 66516, 30891, 3269, 93929, 60421, 99434, 6925, 9070, 55951, 59178, 56406, 5524, 60573, 69104, 74939, 84198, 80026, 93250, 7169, 38114, 54596, 74370, 92072, 24707, 76171, 4498, 7234, 88365, 81485, 71784, 84967, 64352, 19026, 4587, 58281, 79447, 20372, 65205, 88516, 92674, 40734, 44922, 98198, 17658, 30377, 89488, 1855, 10402, 99089, 25375, 64867, 70037, 99744, 56939, 94743, 75915, 77788, 1976, 64279, 75624, 90111, 65597, 39975, 9137, 70184, 98255, 88583, 6907, 79811, 93450, 99581, 36896, 38371, 14130, 54553, 85100, 3617, 72759, 11853, 19058, 98133, 76720, 89094, 97877, 50010, 188, 73791, 44149, 18515, 54421, 19772, 8626, 20017, 59746, 17762, 6552, 74353, 22696, 13459, 70515, 16145, 29391, 7411, 70868, 43520, 78315, 55967, 63488, 51074, 84171, 82545, 49206, 60890, 87990, 63434, 27251, 4529, 53576};
        int k = 100000;
        int[] queries = {8, 323, 475, 409, 330, 282, 387, 133, 120, 424, 193, 425, 380, 99, 435, 107, 396, 506, 467, 64, 189, 242, 315, 110, 504, 396, 2, 143, 44, 425, 138, 52, 150, 16, 379, 480, 298, 251, 98, 335, 77, 208, 246, 457, 308, 83, 50, 106, 75, 434, 88, 264, 161, 320, 291, 150, 118, 293, 210, 162, 121, 266, 132, 271, 282, 511, 237, 497, 164, 252, 317, 241, 461, 480, 100, 254, 49, 67, 277, 124, 501, 365, 305, 147, 170, 81, 215, 206, 292, 425, 368, 413, 93, 417, 169, 375, 413, 323, 357, 494, 61, 160, 137, 7, 42, 155, 178, 91, 222, 455, 132, 209, 223, 437, 273, 310, 436, 405, 1, 130, 233, 287, 28, 326, 189, 114, 187, 5, 438, 29, 416, 416, 106, 39, 423, 149, 194, 3, 157, 416, 375, 290, 27, 83, 129, 218, 311, 482, 108, 229, 97, 341, 1, 125, 70, 108, 157, 257, 113, 80, 203, 14, 413, 310, 485, 238, 376, 164, 241, 18, 498, 101, 225, 442, 102, 355, 62, 330, 322, 171, 44, 337, 429, 46, 462, 499, 154, 21, 158, 184, 18, 362, 115, 431, 74, 86, 154, 450, 167, 312, 468, 67, 331, 96, 427, 433, 451, 489, 165, 175, 62, 209, 512, 492, 172, 377, 393, 243, 398, 37, 427, 417, 316, 460, 250, 390, 463, 405, 325, 115, 202, 195, 100, 18, 291, 12, 368, 144, 501, 450, 237, 481, 145, 234, 375, 317, 13, 253, 46, 329, 207, 390, 148, 8, 252, 398, 315, 200, 288, 125, 316, 408, 238, 333, 343, 446, 345, 114, 76, 248, 49, 230, 214, 194, 381, 74, 429, 395, 245, 392, 209, 369, 184, 357, 295, 437, 240, 95, 122, 446, 138, 355, 256, 293, 173, 84, 224, 435, 198, 217, 169, 165, 447, 300, 276, 314, 292, 190, 194, 22, 499, 320, 308, 169, 79, 88, 91, 236, 101, 130, 84, 239, 486, 340, 17, 144, 425, 158, 497, 25, 376, 151, 107, 308, 451, 384, 107, 228, 59, 218, 167, 476, 455, 476, 130, 19, 481, 221, 173, 67, 268, 257, 223, 239, 83, 157, 301, 508, 316, 283, 450, 177, 351, 43, 402, 287, 427, 427, 433, 403, 130, 2, 364, 71, 395, 411, 7, 362, 34, 180, 346, 303, 438, 55, 27, 6, 212, 245, 431, 445, 13, 283, 107, 281, 243, 427, 54, 155, 339, 404, 476, 469, 323, 242, 457, 204, 139, 465, 483, 90, 47, 314, 393, 402, 286, 338, 325, 416, 68, 241, 346, 514, 442, 371, 280, 170, 283, 251, 243, 107, 57, 121, 61, 381, 363, 436, 502, 419, 303, 387, 427, 350, 186, 305, 155, 390, 45, 480, 291, 114, 124, 122, 30, 51, 493, 310, 221, 261, 479, 381, 368, 21, 502, 347, 319, 268, 268, 223, 89, 56, 95, 1, 323, 199, 224, 478, 74, 269, 444, 365, 383, 53, 487, 330, 21, 383, 43, 242, 129, 7, 109, 415, 460, 13, 247, 182, 281, 0, 405, 371};
        int[] expected = {20372, 35673, 58089, 73089, 98170, 35360, 78189, 5731, 7640, 74017, 74870, 41320, 34974, 65976, 98688, 99801, 15537, 38114, 49574, 20017, 19376, 31318, 59523, 83066, 93250, 15537, 84967, 87850, 38371, 41320, 9284, 98133, 87836, 30377, 66187, 1802, 92575, 75380, 65211, 57039, 78315, 22359, 75398, 66342, 59143, 49206, 11853, 48360, 70868, 39258, 4529, 44387, 91243, 54464, 70846, 87836, 64817, 17983, 23893, 73798, 10429, 13797, 31398, 80457, 35360, 76171, 71178, 56406, 96973, 33838, 31963, 12101, 96166, 1802, 75238, 31679, 72759, 6552, 7876, 30484, 74939, 961, 34916, 45513, 10261, 84171, 23377, 55713, 81210, 41320, 51708, 65296, 3704, 49377, 71095, 39858, 65296, 35673, 12244, 9070, 54421, 4580, 64035, 79447, 99581, 19476, 33275, 80254, 87049, 84410, 31398, 5340, 56300, 32791, 94191, 88958, 93057, 32705, 71784, 60696, 85679, 30903, 77788, 93973, 19376, 21541, 22604, 4587, 49011, 1976, 16001, 16001, 48360, 6907, 36902, 62212, 38898, 64352, 31748, 16001, 39858, 686, 75915, 49206, 72833, 62332, 37451, 82528, 51885, 98210, 88475, 74973, 71784, 15265, 13459, 51885, 31748, 28272, 99267, 51074, 67951, 98198, 65296, 88958, 64550, 88209, 54404, 96973, 12101, 1855, 5524, 58566, 25947, 48896, 28684, 22854, 19772, 98170, 39269, 32905, 38371, 34395, 46838, 54553, 12996, 60573, 24127, 25375, 14196, 64225, 1855, 61856, 93195, 1935, 7411, 63434, 24127, 74820, 77675, 71749, 85044, 6552, 3677, 47885, 5905, 44001, 28770, 3269, 89473, 87763, 19772, 5340, 4498, 99434, 79796, 45025, 14576, 35670, 46167, 98255, 5905, 49377, 24058, 13179, 13782, 36369, 32298, 32705, 12088, 93195, 83457, 23942, 75238, 1855, 70846, 40734, 51708, 7968, 74939, 74820, 71178, 12426, 84789, 99114, 39858, 31963, 44922, 831, 54553, 86547, 43682, 36369, 5563, 20372, 33838, 46167, 59523, 88156, 28014, 15265, 24058, 94082, 88209, 16960, 90947, 27879, 63470, 21541, 43520, 29697, 72759, 2223, 88424, 38898, 87677, 7411, 46838, 47419, 19742, 545, 5340, 49245, 64225, 12244, 41948, 32791, 76517, 96698, 38928, 27879, 9284, 22854, 26777, 17983, 57157, 60890, 54626, 98688, 1617, 93604, 71095, 89473, 79519, 88621, 30284, 82300, 81210, 1073, 38898, 64867, 60573, 54464, 59143, 71095, 63488, 4529, 80254, 89889, 58566, 60696, 60890, 12247, 96603, 19199, 89488, 7968, 41320, 14196, 56406, 56939, 54404, 13202, 99801, 59143, 28770, 35065, 99801, 26656, 44149, 62332, 77675, 61347, 84410, 61347, 60696, 10402, 12426, 79757, 57157, 6552, 87589, 28272, 56300, 12247, 49206, 31748, 71800, 74370, 24058, 28498, 74820, 1798, 49896, 36896, 54501, 30903, 5905, 5905, 44001, 37324, 60696, 84967, 30523, 70515, 47419, 45407, 79447, 61856, 39975, 80361, 66821, 19078, 49011, 97877, 75915, 58281, 59153, 19742, 1935, 26685, 44922, 28498, 99801, 86945, 35670, 5905, 89094, 19476, 11017, 79569, 61347, 12699, 35673, 31318, 66342, 85386, 32587, 52254, 12194, 29261, 85100, 82300, 14576, 54501, 49664, 86016, 12088, 16001, 74353, 12101, 66821, 88365, 48896, 70906, 78309, 10261, 28498, 75380, 35670, 99801, 188, 10429, 54421, 87677, 89839, 93057, 84198, 78949, 19078, 78189, 5905, 91769, 5181, 34916, 19476, 36369, 14130, 1802, 70846, 21541, 30484, 38928, 64279, 19058, 6925, 88958, 79757, 58709, 53759, 87677, 51708, 25375, 84198, 39699, 52071, 87589, 87589, 56300, 53576, 50010, 96698, 71784, 35673, 50552, 54626, 37607, 7411, 2005, 47167, 961, 32383, 76720, 66516, 98170, 25375, 32383, 36896, 31318, 72833, 79447, 82661, 12181, 13179, 44922, 96951, 93413, 86945, 81485, 32705, 70906};
        int[] result = circularArrayRotation(a, k, queries);
        assertArrayEquals(expected, result);
    }

}
