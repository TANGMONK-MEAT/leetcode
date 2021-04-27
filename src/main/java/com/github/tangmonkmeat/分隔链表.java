package com.github.tangmonkmeat;

/**
 * Description:
 *
 * @author zwl
 * @version 1.0
 * @date 2021/2/2 13:09
 */
public class 分隔链表 {

    public static void main(String[] args) {

    }


    public ListNode partition(ListNode head, int x) {
        ListNode ls = new ListNode();
        ListNode lsHead = ls;
        ListNode lg = new ListNode();
        ListNode lgHead = lg;
        while (head != null){
            if (head.val < x){
                ls.next = head;
                ls = ls.next;
            }else{
                lg.next = head;
                lg = lg.next;
            }
            head = head.next;
        }
        lg.next = null;
        ls.next = lgHead.next;
        return lsHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
