package 算法包;

import 实例包.*;

/**
 * @PACKAGE_NAME: 算法包
 * @NAME: TSPCostCalculatorThreadSafe
 * @USER: 暖心校草小玮
 * @DATE: 2020/3/22 0022
 * @TIME: 20:47
 * @MONTH_NAME_SHORT: 3月
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: mls
 **/

/**
 * 计算适应度的函数
 */
public class TSPCostCalculatorThreadSafe {
    public double calc(Instance instance, Solution s){
        double cost=0;
        for(int i=1;i<s.getsolution().size();i++){
            cost=cost+instance.getDistance(s.getsolution().get(i-1),s.getsolution().get(i));
        }
        cost=cost+instance.getDistance(s.getsolution().get(s.getsolution().size()-1),s.getsolution().get(0));
        return cost;
    }
}
