package 算法包;

import 实例包.*;

import java.util.Random;

/**
 * @PACKAGE_NAME: 算法包
 * @NAME: launch
 * @USER: 暖心校草小玮
 * @DATE: 2020/3/22 0022
 * @TIME: 21:05
 * @MONTH_NAME_SHORT: 3月
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: mls
 **/
public class launch {
    public static void main(String[] args) {
        mls my_solution=new mls();                                      //生成mls对象
        readfile my_file=new readfile();                                //读取文件
        my_file.buildInstance("F:\\mls\\data\\uy734.tsp.txt");   //读取文件
        my_solution.setiLSInstance(my_file.getInstance());              //设置好距离矩阵
        my_solution.setsolution();                                      //设置好初始解
        my_solution.iter();                                             //开始迭代
        my_solution.print_best();                                       //输出最优解
        System.out.println("最佳适应度为："+my_solution.print_of());       //输出最佳适应度

    }
}
