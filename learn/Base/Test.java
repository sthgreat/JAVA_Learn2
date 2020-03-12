package Base;

public class Test {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void say(){
        final String name = "123";

    }

    class inner{
        public int a = 1;
        private int b = 2;

        public inner(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public void testA(){
            System.out.println("A");
        }

        private void testB(){
            System.out.println("B");
        }
    }
}
