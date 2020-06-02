package NiukeReal;

import java.util.*;

/***
 * 使用最大最小堆进行操作
 * 优先队列需要掌握
 */
public class 塔 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int totalCount = sc.nextInt();
        int maxOp = sc.nextInt();
        Queue<Tow> max = new PriorityQueue<>(new Comparator<Tow>() {
            public int compare(Tow o1, Tow o2) {
                return o2.high - o1.high;
            }
        });
        Queue<Tow> min = new PriorityQueue<>(new Comparator<Tow>() {
            public int compare(Tow o1, Tow o2) {
                return o1.high - o2.high;
            }
        });
        for(int i = 0;i<totalCount;i++){
            Tow t = new Tow(sc.nextInt(), i + 1);
            max.add(t);
            min.add(t);
        }
        int count = 0;
        LinkedList<record> Record = new LinkedList<>();
        for(int i = 0;i<maxOp;i++){
            Tow maxTow = max.poll();
            Tow minTow = min.poll();
            if(maxTow.high - 1 < minTow.high + 1){
                max.add(maxTow);
                min.add(minTow);
                break;
            }else{
                count ++;
                maxTow.high -= 1;
                minTow.high += 1;
                max.add(maxTow);
                min.add(minTow);
                Record.add(new record(maxTow.id, minTow.id));
            }
        }
        System.out.print(max.poll().high - min.poll().high + " ");
        System.out.println(count);
        for(int i = 0;i<count;i++){
            record r = Record.removeFirst();
            System.out.println(r.from + " " + r.to);
        }

    }
}

class Tow{
    int high;
    int id;
    public Tow(int high, int id){
        this.high = high;
        this.id = id;
    }
}
class record{
    int from;
    int to;
    public record(int f, int t){
        this.from = f;
        this.to = t;
    }
}
