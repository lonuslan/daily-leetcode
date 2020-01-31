package com.lonuslan.dailyleetcode.entity;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/1/29 12:49
 * @description： list node
 * @modified By：
 */
public class ListNode<T> {

    public T val;
    public ListNode front;
    public ListNode next;
    public ListNode(T val){
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("[");
        for(ListNode cur = this;;cur=cur.next){
            if(cur==null){
                ret.deleteCharAt(ret.lastIndexOf(" "));
                ret.deleteCharAt(ret.lastIndexOf(","));
                break;
            }
            ret.append(cur.val);
            ret.append(", ");
        }
        ret.append("]");
        return ret.toString();
    }
}
