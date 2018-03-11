package com.itheima.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.itheima.aspect.MyAspect;

/**
 * IDK ������
 */
public class JdkProxy implements InvocationHandler {
	// ����Ŀ����ӿ�
	private UserDao userDao;

	// ����������
	public Object createProxy(UserDao userDao) {
		this.userDao = userDao;
		// 1.�������
		ClassLoader classLoader = JdkProxy.class.getClassLoader();
		// 2.���������ʵ�ֵ����нӿ�
		Class<?>[] clazz = userDao.getClass().getInterfaces();
		// 3.ʹ�ô����࣬������ǿ�����ص��Ǵ����Ķ���
		return Proxy.newProxyInstance(classLoader, clazz, this);
	}

	/*
	 * ���ж�̬������ķ������ã����ύ��invoke()�������� proxy �������Ķ��� method ��Ҫִ�еķ�����Ϣ(����)
	 * argsִ�з���ʱ��Ҫ�Ĳ���
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// ��������
		MyAspect myAspect = new MyAspect();
		// ǰ��ǿ
		myAspect.check_Permissions();
		// Ŀ�����ϵ��÷��������������
		Object obj = method.invoke(userDao, args);
		// ����ǿ
		myAspect.log();
		return obj;

	}

}
