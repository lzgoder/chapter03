package com.itheima.aspect;
//切面类：可以存在多个通知Advice(即增强的方法)
public class MyAspect {

	public void check_Permissions() {
		// TODO Auto-generated method stub
        System.out.println("*D-616*权限检查");
	}
	public void log() {
		// TODO Auto-generated method stub
        System.out.println("*D-616*记录日志\n");
	}
	
	
}
