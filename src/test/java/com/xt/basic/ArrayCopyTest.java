package com.xt.basic;

import org.junit.Test;

public class ArrayCopyTest {

	
	@Test
	public void testArrayCopy() {
		//静态初始化两个长度不同的数组 
        int src[] = {1,2,3,4}; 
        int dest[] = {5,5,5,5,5}; 
        
        //将数组src的4个元素copy到数组dest中 
        System.arraycopy(src,1,dest,1,3); 
        
        //输出数组dest 
        for(int i=0;i<dest.length;i++) { 
            System.out.println(dest[i]); 
        } 
	}
	
	
}
