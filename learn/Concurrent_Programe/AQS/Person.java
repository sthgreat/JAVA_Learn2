package Concurrent_Programe.AQS;

public class Person {
    public int age=55;
    //外部类想访问内部类的成员必须先实例化一个内部类，然后通过实例去访问

    public void  getHeart() {
        /*方法内部类
         *1、定义在方法内部，作用范围也在方法内
         *2、和方法内部成员使用规则一样，class前面不可以添加public、private、protected、static
         *3、类中不能包含静态成员
         * 4、类中可以包含final、abstract成员。但abstract一般不建议使用
         */
        class  Heart {
            //static  int age=367;//方法内部类不能有static
            public  void say() {
                System.out.println("人会说话");
            }
            public  void eat() {

            }
            public String beat() {
                //return age+"岁的人心脏跳动频率不同";
                new Person().eat();
                return new Person().age+"岁的人心脏跳动频率不同";
            }
        }
        new Heart().say();
    }

    public void eat() {
        System.out.println("人一饿就想吃东西");
    }

    public static void main(String[] args){
        Person lili = new Person();
        lili.getHeart();
    }
    /*成员内部类
     * 1、内部类在外部使用时，无法直接实例化，需要借由外部类信息才能完成实例化
     * 2、内部类的访问修饰符，可以任意，但是访问范围会有影响
     * 3、内部类可以直接访问外部类的成员；如果出现同名属性，优先访问内部类中定义的
     * 4、外部类.this.成员访问外部类同名信息
     */
//	 class  Heart {
//
//		 public void eat() {
//				System.out.println("人喜欢吃的东西不同");
//			}
//		public String beat() {
//			int age=367;
////			eat() ;
////			return age+"岁的人心脏跳动频率不同";
//			Person.this.eat();
//			return Person.this.age+"岁的人心脏跳动频率不同";
//		}
//	}
    /*静态内部类
     * 1、静态内部类中，只能直接访问外部类的静态方法，如果需要调用非静态成员需要实例化外部类再调用
     *2、静态内部类对象实例化时，可以不依赖于外部类对象
     *3、可以通过外部类.内部类.静态成员的方式访问内部类中的静态成员
     *4、当内部类需要访问外部类中的静态属性，则可以通过 外部类.属性 的方式;
     *如果需要访问外部类非静态属性，则可以通过 new 外部类().属性 的方式
     *5、当内部类属性与外部类属性同名时，默认直接调用内部类的成员
     *
     */
//	static class  Heart {
//		static  int age=367;
//		public static void say() {
//			System.out.println("人会说话");
//		}
//		public String beat() {
////			return age+"岁的人心脏跳动频率不同";
//			new Person().eat();
//			return new Person().age+"岁的人心脏跳动频率不同";
//		}
//	}
}