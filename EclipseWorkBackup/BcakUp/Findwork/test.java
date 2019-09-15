package Findwork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    List<String> userNames = new ArrayList<String>() {/**
             * 
             */
            private static final long serialVersionUID = 1L;

        {
	        add("Hollis");
	        add("hollis");
	        add("HollisChuang");
	        add("H");
	    }};
	    for (int i=0;i<userNames.size(); i++) {
	        if (userNames.get(i).equals("Hollis")) {
                userNames.remove(i);
            }
	    }
	    System.out.println(userNames);
	    
	    //Foreach循环里面不能够进行元素的remove和add，Foreach的实现原理还是Iterator
/*	    for (String userName : userNames) {
	        if (userName.equals("H")) {
	            userNames.remove(userName);
	        }
	    }

	    System.out.println(userNames);*/
	    
	    //可以使用iterator自带的remove来做
	    Iterator<String> it = userNames.iterator();
	    while(it.hasNext()) {
	        if (it.next().equals("H")) {
	            it.remove();
	        }
	    }
	    System.out.println(userNames);
	    
	    
	  //Java 8中可以把集合转换成流，对于流有一种filter操作， 可以对原始 Stream 进行某项测试，通过测试的元素被留下来生成一个新 Stream。
	    userNames = userNames.stream().filter(userName -> !userName.equals("hollis")).collect(Collectors.toList());
	    System.out.println(userNames);
	}
}
