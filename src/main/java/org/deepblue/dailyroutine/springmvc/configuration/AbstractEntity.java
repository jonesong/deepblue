package org.deepblue.dailyroutine.springmvc.configuration;

import java.util.List;
import java.lang.reflect.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class AbstractEntity {
	
	private static Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/deepblue-test?useSSL=false&serverTimezone=UTC", "tim", "testtest");
	

	public void recordUpdate(String sql, Object object) {
		try (Connection con = sql2o.open()) {
			con.createQuery(sql).bind(object).executeUpdate();
		}
	} 	
	
	public static <T> List<T> queryListNoParameter(String sql, Class<T> klazz) {
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql).executeAndFetch(klazz);
		}
	}
	
	public static <T> List<T> queryListMultiParameter(String sql, Class<T> klazz, String[] values) {
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql).bind(instanceOfMyClass(values)).executeAndFetch(klazz);
		}
	}
	
	public static List<String> queryListNoParameter(String sql, String[] values) {
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql).bind(instanceOfMyClass(values)).executeScalarList(String.class);
		}
	}
	
	public static <T> Object queryClassMultiParameter(String sql, Class<T> klazz, String[] values) {
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql).bind(instanceOfMyClass(values)).executeAndFetchFirst(klazz);
		}
	}
	
	public static Integer queryIntegerMultiParameter(String sql, String[] values) {
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql).bind(instanceOfMyClass(values)).executeAndFetchFirst(Integer.class);
		}
	}
	
	public static String queryStringMultiParameter(String sql, String[] values) {
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql).bind(instanceOfMyClass(values)).executeAndFetchFirst(String.class);
		}
	}
	
	private static Object instanceOfMyClass(String[] values) {
		String className = "org.deepblue.dailyroutine.springmvc.configuration.MyClasses";
		Class clazz = null;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class[] parameters = new Class[values.length];
		Object[] value = new Object[values.length];
		for (int x = 0; x < parameters.length; x++) {
			parameters[x] = String.class;
			value[x] = values[x];
		}
		Constructor constructor = null;
		try {
			constructor = clazz.getConstructor(parameters);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object xyz = null;
		try {
			xyz = constructor.newInstance(value);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xyz;
	}
	
}