package 算法包;
import 实例包.*;
import java.util.Collections;
import java.util.Random;
/**
 * @PACKAGE_NAME: 算法包
 * @NAME: mls
 * @USER: 暖心校草小玮
 * @DATE: 2020/3/22 0022
 * @TIME: 20:01
 * @MONTH_NAME_SHORT: 3月
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: mls
 **/
public class mls {
    private Random rLSRandom;                   //随机数
    private Instance iLSInstance;               //城市模型
    private Solution dLSGlobalBest;             //全局最优解
    private Solution currBest;                  //当前最优解
    private boolean tihuan=false;               //检测当前的ls是否成功
    private int step=0;                         //总计发生的不成功的次数
    private TSPCostCalculatorThreadSafe cLSCalculator;      //计算适应度
    private float probably=0.3f;                //整块交换的概率

    /**
     * 构造函数
     */
    public mls(){
        this.rLSRandom = new Random();
        this.cLSCalculator=new TSPCostCalculatorThreadSafe();
    }

    //设置距离矩阵
    public void setiLSInstance(Instance instance){
        this.iLSInstance=instance;

    }

    /**
     * 随机生成当前解
     */
    public void setsolution() {
        Solution solution = new Solution();
        //先依次加入到解中
        for(int i = 0; i < this.iLSInstance.getN(); ++i) {
            solution.getsolution().add(i);
        }

        solution.setOF(this.cLSCalculator.calc(this.iLSInstance, solution));

        //设置全局最优解和当前最优解
        this.dLSGlobalBest = solution.clone();
        this.currBest=solution.clone();
    }

    //local search操作
    /**
     * 包含swap和relocate
     * 让该解从  i~N~i-1  进行搜寻
     * @param ssolution
     * @param i
     * @return
     */
    public Solution ls(Solution ssolution,int i)  {
            Solution best = ssolution.clone();
        for (int j = i + 1; j < this.iLSInstance.getN() +i; j++) {
                Solution now=ssolution.clone();
                if(j<this.iLSInstance.getN()){
                now.swap(i, j);
                now.setOF(this.cLSCalculator.calc(this.iLSInstance, now));
                if (now.getOF() < best.getOF()) {
                    best = now.clone();
                    tihuan=true;
                }
                if(!tihuan){
                    now.swap(i,j);
                    now.relocate(i,j);
                    now.setOF(this.cLSCalculator.calc(this.iLSInstance, now));
                    if (now.getOF() < best.getOF()) {
                        best = now.clone();
                        tihuan=true;
                    }
                }
            }
                else if(j-this.iLSInstance.getN()<i){
                now.relocate(i,j-i);
                now.setOF(this.cLSCalculator.calc(this.iLSInstance, now));
                if (now.getOF() < best.getOF()) {
                    best = now.clone();
                    tihuan=true;
                    }
                }

        }
        return best;
    }

    /**
     * 开始迭代，即生成N的初始随机解，并对每个解进行ls
     */
    public void iter() {
        for(int c=0;c<this.iLSInstance.getN();c++)
        {
            Solution localsolution2 = this.currBest.clone();
            for (int j = c; j < this.iLSInstance.getN(); j++) {
                Solution now = ls(localsolution2.clone(), j);
                if (now.getOF() < this.dLSGlobalBest.getOF())
                    this.dLSGlobalBest = now.clone();
            }
        }
        for (int i = 0; i < this.iLSInstance.getN(); i++) {
            tihuan=false;
            Solution localsolution = this.currBest.clone();
            localsolution=restart(localsolution);
            for (int j = 0; j < this.iLSInstance.getN(); j++) {
                Solution now = ls(localsolution.clone(), j);
                if (now.getOF() < this.dLSGlobalBest.getOF())
                    this.dLSGlobalBest = now.clone();
            }
            for(int m=0;m<this.iLSInstance.getN()-1;m++)
                System.out.print(localsolution.getsolution().get(m)+"-->");
            System.out.println(localsolution.getsolution().get(this.iLSInstance.getN()-1));
            if(!tihuan)
                step++;
            if(step==50)
            {
                i--;
                step=0;
            }

        }
    }

    /**
     * 生成随机解
     * @param solution
     * @return
     */
    public Solution restart(Solution solution){
        int[]haveset=new int[iLSInstance.getN()];
        haveset[0]=0;
        for(int i=0;i<iLSInstance.getN();i++){
            int n=rLSRandom.nextInt(iLSInstance.getN());
            while (haveset[n]!=0)
                n=rLSRandom.nextInt(iLSInstance.getN());
            solution.getsolution().set(i,n);
            haveset[n]=1;
        }
        solution.setOF(this.cLSCalculator.calc(this.iLSInstance, solution));
        return solution;
    }

    /**
     * 返回一些私有量
     * @return
     */
    public Instance getiLSInstance(){
        return this.iLSInstance;
    }

    public Solution getdLSGlobalBest(){
        return this.dLSGlobalBest;
    }


    public void print_best(){
        for(int i=0;i<this.iLSInstance.getN()-1;i++)
            System.out.print(this.dLSGlobalBest.getsolution().get(i)+"--->");
        System.out.println(this.dLSGlobalBest.getsolution().get(this.iLSInstance.getN()-1));
    }

    public double print_of(){
        return this.dLSGlobalBest.getOF();
    }
}
