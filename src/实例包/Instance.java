package 实例包;

import java.text.DecimalFormat;

/**
 * @PACKAGE_NAME: 实例包
 * @NAME: Instance
 * @USER: 暖心校草小玮
 * @DATE: 2020/3/22 0022
 * @TIME: 19:57
 * @MONTH_NAME_SHORT: 3月
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: mls
 **/

/**
 * 城市矩阵
 */
public class Instance {
    private final double[][] matrix;

    public Instance(double[][] matrix) {
        this.matrix = (double[][])matrix.clone();
    }

    public double getDistance(int i, int j) {
        return this.matrix[i][j];
    }

    public int getN() {
        return this.matrix.length;
    }

    public double[][] getDistanceMatrix() {
        return (double[][])this.matrix.clone();
    }

    public void printDistanceMatrix(String format) {
        DecimalFormat df = new DecimalFormat(format);

        for(int i = 0; i < this.matrix.length; ++i) {
            for(int j = 0; j < this.matrix[0].length; ++j) {
                System.out.print(df.format(this.matrix[i][j]) + "\t");
            }

            System.out.print("\n");
        }

        System.out.print("\n");
    }
}
