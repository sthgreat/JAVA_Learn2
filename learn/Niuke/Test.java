package Niuke;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 添加和显示宠物猫
 * @author 86132
 *
 */
public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //创建猫
        Cat one=new Cat("花花", 2, "短腿猫");
        Cat two=new Cat("帆帆", 1, "中华田园猫");
        //创建HashSet
        //Set set_1=new HashSet();
        Set<Cat> set_1=new HashSet<Cat>();//泛型创建
        set_1.add(one);
        set_1.add(two);
        //显示宠物猫信息
        //Iterator iter=set_1.iterator();
        Iterator<Cat> iter=set_1.iterator();//泛型限制
        while(iter.hasNext()) {
            System.out.println(iter.next());//这样输出的是元素对象的地址信息
        }
        System.out.println();
        System.out.println("=========================================");
        //插入重复数据,这里自定义的对象类，当没有作处理时，是会插入重复数据的。
        //但是HashSet是不允许插入重复数据的，所以需要作处理
        //在Cat类当中需要重写HashCode和equals方法
        Cat three=new Cat("花花", 2, "短腿猫");
        set_1.add(three);
        //显示宠物猫信息
        Iterator<Cat> iter_1=set_1.iterator();
        while(iter_1.hasNext()) {
            System.out.println(iter_1.next());//这样输出的是元素对象的地址信息
        }
        System.out.println();
        System.out.println("=========================================");

        //重新插入一个新宠物猫
        Cat four=new Cat("花花", 2, "英国短毛猫");
        set_1.add(four);
        //显示宠物猫信息
        Iterator<Cat> iter_2=set_1.iterator();
        while(iter_2.hasNext()) {
            System.out.println(iter_2.next());
        }
        System.out.println();
        System.out.println("=========================================");

        //查找花花的信息并输出
        if(set_1.contains(four)) {
            System.out.println("花花找到了！"+four);
        }else System.out.println("花花没找到");
        System.out.println();
        System.out.println("=========================================");

        //在集合中利用名字查找
        iter_2=set_1.iterator();
        boolean flag=false;
        while(iter_2.hasNext()) {
            //因为iter_3.next()返回的是Object类，这就存在安全隐患。当需要什么类型就需要给他强制转换
            //当强制转换的类型不是对象所属类型时编译时不会报错但运行时会报错。在加入泛型以后就不需要强制转换了
            //Set<Cat> set_1=new HashSet<Cat>   见21 和26行。这样就没有警告了
            //if(((Cat)iter.next()).getName().equals("花花"))//此时就不需要强制转换为Cat型了
            if((iter_2.next()).getName().equals("花花"))
            {
                System.out.println("通过名字找到了花花！"+iter_2.next());
                System.out.println("*****************************************");
                flag=true;
            }
        }
        if(flag==false)
            System.out.println("花花没找到");
        System.out.println();
        System.out.println("=========================================");


        //删除花花二代的信息并重新输出
        //使用增强型for循环
//        for(Cat cat:set_1) {
//            if(cat.getName().equals("花花")) {
//                set_1.remove(cat);
//            }
//        }
//        System.out.println("删除花花后的集合为");
//        for(Cat cat:set_1) {
//            System.out.println(cat);
//        }

    }

}

class Cat {
    //属性
    private String name;//名字
    private int month;//年龄
    private String species;//品种
    //构造方法
    public Cat(String name, int month, String species) {
        super();
        setName(name);
        setMonth(month);
        setSpecies(species);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    @Override
    public String toString() {
        return "Cat [name=" + name + ", month=" + month + ", species=" + species + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + month;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((species == null) ? 0 : species.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cat other = (Cat) obj;
        if (month != other.month)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (species == null) {
            if (other.species != null)
                return false;
        } else if (!species.equals(other.species))
            return false;
        return true;
    }



}
