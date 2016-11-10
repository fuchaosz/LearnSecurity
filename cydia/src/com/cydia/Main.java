package com.cydia;

import java.lang.reflect.Method;

import android.content.res.Resources;

import com.saurik.substrate.MS;

//hook方法
public class Main {

	public static void initialize() {
		// 设置需要hook的类
		MS.hookClassLoad("android.content.res.Resoureces", new MS.ClassLoadHook() {

			@Override
			public void classLoaded(Class<?> resources) {
				// 定义方法
				Method getColor = null;
				// hook的方法为获取颜色的方法
				try {
					getColor = resources.getMethod("getColor", Integer.TYPE);
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (getColor != null) {
					// 新建一个MethodPointer对象
					MS.MethodPointer old = new MS.MethodPointer();
					// 开始hook方法，写入自己想改变的数据
					MS.hookMethod(resources, getColor, new MS.MethodHook() {
					});
				}

			}
		});
	}

}
