package com.xt.basic;

import java.util.Arrays;

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
        System.out.println(Arrays.toString(dest));
      //arraycopy(Object src, int srcStartIndex, Object dest, int destStartIndex, int length) 
      //从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。 
      //srcStartIndex：原数组中要开始复制的第一个元素的位置 
      //destStartIndex: 目标数组中要开始替换的第一个元素的位置 
      //length: 要复制的元素的个数
	}
	
	
}
