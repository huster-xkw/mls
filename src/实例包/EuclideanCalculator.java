package 实例包;

/**
 * @PACKAGE_NAME: 实例包
 * @NAME: EuclideanCalculator
 * @USER: 暖心校草小玮
 * @DATE: 2020/3/22 0022
 * @TIME: 19:58
 * @MONTH_NAME_SHORT: 3月
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: mls
 **/

/**
 * 计算出距离矩阵
 */
public class EuclideanCalculator {
    public EuclideanCalculator() {
    }

    public static double calc(double cx1, double cy1, double cx2, double cy2) {
        return Math.sqrt(Math.pow(cx1 - cx2, 2.0D) + Math.pow(cy1 - cy2, 2.0D));
    }

    public static double[][] calc(double[][] coordinates) {
        if (coordinates[0].length != 2) {
            throw new IllegalArgumentException("argument coordinates must be a matrix with 2 columns and an open number of files");
        } else {
            double[][] matrix = new double[coordinates.length][coordinates.length];

            for(int i = 0; i < coordinates.length; ++i) {
                for(int j = i + 1; j < coordinates.length; ++j) {
                    matrix[i][j] = calc(coordinates[i][0], coordinates[i][1], coordinates[j][0], coordinates[j][1]);
                    matrix[j][i] = matrix[i][j];
                }
            }

            return matrix;
        }
    }
}
