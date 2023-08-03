package solutions.top100liked;

import org.junit.Test;
import structure.ListNode;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class SortList148Test {

    @Test
    public void sortList() {
        ListNode head = ListNode.generateList("4->2->5->3->7->9->0->1->null");

        ListNode p = SortList148.sortListQuick(head);
        System.out.println(p);

    }

    @Test
    public void testAllDigits(){
        System.out.println("'202207221040".matches("^\\d+$"));
    }


    @Test
    public void testDateFormat(){
        SimpleDateFormat s = new SimpleDateFormat("yyyy年M月d日H时");
        Date now = new Date();
        long timestamp = now.getTime();
        Date morning = new Date(timestamp+24*60*60*1000*3);

        System.out.println(s.format(morning));
    }

}