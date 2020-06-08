package NiukeReal;

import java.util.*;

public class test {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        Scanner scanner = null;
        ListNode ans = null;
        boolean first = true;
        try {
            scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
//                if(s.equals("")){
//                    break;
//                }
                if(first){
                    first = false;
                    continue;
                }else{
                    String[] ss =s.split(" ");
                    ans = mergeNodes(ans, ss);
                }
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        while(ans!=null){
            System.out.print(ans.val + " ");
        }
    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    private static ListNode mergeNodes(ListNode head, String[] s) {
        ListNode p = head;
        int[] arr = new int[s.length];
        for(int i = 0;i<s.length;i++){
            arr[i] = Integer.valueOf(s[i]);
        }
        int start = 0;
        if(p == null || p.val > arr[0]){
            head = new ListNode(arr[0]);
            start = 1;
        }else{
            p = p.next;
            head.next = null;
        }
        ListNode pre = head;
        while(p!=null && start < arr.length){
            if(p.val <= arr[start]){
                pre.next = p;
                p = p.next;
                pre = pre.next;
                pre.next = null;
            }else{
                pre.next = new ListNode(arr[start]);
                start ++;
                pre = pre.next;
            }
        }
        if(p!=null){
            pre.next = p;
        }
        if(start < s.length){
            for(int i = start;i<arr.length;i++){
                pre.next = new ListNode(arr[i]);
                pre = pre.next;
            }
        }
        return head;
    }


}