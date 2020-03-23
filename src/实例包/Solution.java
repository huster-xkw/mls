package 实例包;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @PACKAGE_NAME: 实例包
 * @NAME: Solution
 * @USER: 暖心校草小玮
 * @DATE: 2020/3/22 0022
 * @TIME: 20:00
 * @MONTH_NAME_SHORT: 3月
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: mls
 **/

/**
 * 每个解的构造
 */
public class Solution  {
    private ArrayList<Integer>solution=new ArrayList<Integer>();
    protected double of = 0.0D / 0.0;

    public Solution() {
    }

    public Solution clone() {
        Solution clone = new Solution();
        clone.of = this.of;
        for(int i=0;i<this.solution.size();i++)
            clone.solution.add(this.solution.get(i));

        return clone;
    }

    public double getOF() {
        return this.of;
    }

    public void setOF(double of) {
        this.of = of;
    }

    public String toString() {
        String str = super.toString();
        str = str.concat("\t OF=" + this.of);
        return str;
    }

    public ArrayList<Integer> getsolution(){
        return solution;
    }

    public void add(int index, Integer element) {
        if (index == this.solution.size()) {
            this.solution.add(element);
        } else {
            this.solution.add(index, element);
        }

    }

    public void relocate(int i, int j) {
        if (i < j) {
            this.add(j, (Integer)this.solution.get(i));
            this.solution.remove(i);
        } else {
            this.add(j, (Integer)this.solution.remove(i));
        }

    }

    public void swap(int i, int j) {
        int temp = (Integer)this.solution.get(i);
        this.solution.set(i, (Integer)this.solution.get(j));
        this.solution.set(j, temp);
    }
}
