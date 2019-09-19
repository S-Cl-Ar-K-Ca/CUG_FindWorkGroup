package MianShiKu;

import java.util.ArrayList;

public class MergeLinkedList {
    //非递归写法
    public LinkedNode mergeLinkedList(LinkedNode list1, LinkedNode list2){
        LinkedNode newHead = new LinkedNode();
        LinkedNode cur = newHead;// 只是引用拷贝

        while (list1 != null && list2 != null){
            if( list1.value < list2.value){
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        if(null == list1){
            cur.next = list2;
        }
        if(null == list2){
            cur.next = list1;
        }
        return newHead.next;
    }

    //来一个递归写法
    public LinkedNode mergeLinkedListRecursion(LinkedNode list01,LinkedNode list02){
        if(null == list01){
            return list02;
        }
        if(null == list02){
            return list01;
        }
        if(list01.value < list02.value){
            list01.next = mergeLinkedListRecursion(list01.next,list02);
            return list01;
        }else {
            list02.next = mergeLinkedListRecursion(list01,list02.next);
            return list02;
        }
    }

    //来一个合并多组有序数组
    public ArrayList<LinkedNode> lists;
    public LinkedNode megerAll01(int left,int right){
        if(left >= right){
            return lists.get(left);
        }
        int m =(left+right)/2;
        LinkedNode L = megerAll01(left,m);
        LinkedNode R = megerAll01(m+1,right);
        return mergeLinkedListRecursion(L,R);
    }
    public LinkedNode mergeAll02(ArrayList<LinkedNode> arrayList){
        LinkedNode newHead = null;
        for (int i = 0; i < arrayList.size(); i++) {
            newHead = mergeLinkedListRecursion(newHead,arrayList.get(i));
        }
        return newHead;
    }
}

class LinkedNode{
    int value;
    public LinkedNode next;
}