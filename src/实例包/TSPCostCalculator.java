package 实例包;

import java.util.ArrayList;

/**
 * @PACKAGE_NAME: 实例包
 * @NAME: TSPCostCalculator
 * @USER: 暖心校草小玮
 * @DATE: 2020/3/22 0022
 * @TIME: 19:59
 * @MONTH_NAME_SHORT: 3月
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: mls
 **/

/**
 * 计算适应度
 */
public class TSPCostCalculator {
    private static ArrayList<Integer> s;
    private static double[][] distMatrix;

    public TSPCostCalculator() {
    }

    public static double calcOF(Instance instance, Solution s) {
        distMatrix = instance.getDistanceMatrix();
        TSPCostCalculator.s = s.getsolution();
        return calc();
    }

    public static double calcOF(double[][] matrix, ArrayList<Integer> s) {
        distMatrix = matrix;
        TSPCostCalculator.s = s;
        return calc();
    }

    private static double calc() {
        double cost = 0.0D;

        for(int i = 1; i < s.size(); ++i) {
            cost += distMatrix[(Integer)s.get(i - 1)][(Integer)s.get(i)];
        }

        cost += distMatrix[(Integer)s.get(s.size() - 1)][(Integer)s.get(0)];
        return cost;
    }
}
