package main.java.solutions;


public class NumberOffGame {
    /*
    n人围成一圈报数，报至m的人出圈，求最后剩下的那个人的id
     */
    public static final int M = 5;
    public static final int N = 100;


    private static class Person {
        public int id;
        public Person next;

        Person(int id) {
            this.id = id;
        }
    }

    private static Person formRound(){
        Person head = new Person(1);
        Person p = head;
        for (int i = 2; i <= N; i++) {
            Person temp = new Person(i);
            p.next = temp;
            p = temp;
        }
        p.next = head;
        return head;
    }

    private static int go(Person head) {
        Person cur = head, pre = head;
        int n = N, m;
        while (n > 1) {
            m = M;
            while (m > 1) {
                pre = cur;
                cur = cur.next;
                m--;
            }
            pre.next = cur.next;
            cur = cur.next;
            n--;
        }
        return cur.id;
    }

    public static void main(String[] args) {
        System.out.println(go(formRound()));
    }
}