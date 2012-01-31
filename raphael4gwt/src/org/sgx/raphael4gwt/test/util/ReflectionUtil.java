//package org.sgx.raphael4gwt.test.util;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Type;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//
//import com.gwtent.reflection.client.ClassType;
//import com.gwtent.reflection.client.Constructor;
//import com.gwtent.reflection.client.Field;
//import com.gwtent.reflection.client.Method;
//import com.gwtent.reflection.client.ReflectionUtils;
//import com.gwtent.reflection.client.TypeOracle;
//
///**
// * reflection utils and bean accessor utils based on gwtent reflection utilities. 
// * @author sg
// *
// */
//public class ReflectionUtil {
//
//public static <T> List<String> getBeanClassPropertyNames(Class<T> c) {
//		
//		ClassType<? extends Object> classType = TypeOracle.Instance.getClassType(c);	
//		
//		Method[] methods_ = classType.getMethods();
//		Set<String> attrsWithSetters  = new HashSet<String>(), 
//			attrsWithGetters = new HashSet<String>();
//		for (int i = 0; i < methods_.length; i++) {
//			String name = methods_[i].getName();
//			
//			if(name.startsWith("get")) {
//				attrsWithGetters.add(getPropertyName("get", name));
//			}
//			else if(name.startsWith("is")){
//				attrsWithGetters.add(getPropertyName("is", name));
//			}
//			if(name.startsWith("set")) {
//				attrsWithSetters.add(getPropertyName("set", name));
//			}
//		}
//		
//		List<String> propNames = new LinkedList<String>();
//		for(String attr : attrsWithSetters) {
//			if(attrsWithGetters.contains(attr))
//				propNames.add(attr);
//		}
//		return propNames;
//	}
//
//	public static List<String> getBeanPropertyNames(Object o) {
//		return getBeanClassPropertyNames(o.getClass());
//	}
//	public static Map<String, Object> getBeanProperties(Object o) {
//		List<String> propNames = getBeanPropertyNames(o);		
//		Map<String, Object> props = new HashMap<String, Object>();
//		ClassType<? extends Object> classType = TypeOracle.Instance.getClassType(o.getClass());	
//		
//		for(String name : propNames) {
//			Object val = null;
//			String getter1 = ReflectionUtil.getAccessorName("get", name),
//					getter2 = ReflectionUtil.getAccessorName("is", name);
//			try {
//				val = classType.invoke(o, getter1, new Object[]{});
//			} catch (Exception e) {
//				try {
//					val = classType.invoke(o, getter2, new Object[]{});
//				} catch (Exception e2) {					
//				}
//			}
//			if(val!=null)
//				props.put(name, val);			
//			}
//		
//		return props;
//	}
//	
//	public static void setBeanProperties(Object o, Map<String, Object> props) {
//		ClassType<? extends Object> classType = TypeOracle.Instance.getClassType(o.getClass());	
//		
//		for(String p : props.keySet()) {
//			try {
//				String setterName = ReflectionUtil.getAccessorName("set", p);
//				classType.invoke(o, setterName, new Object[]{props.get(p)});
//			} catch (Exception e) {
//			}
//		}	
//	}
//
//	public static String getAccessorName(String prefix, String propName) {
//		String pn = propName.substring(0,1).toUpperCase() + propName.substring(1, propName.length());
//		return prefix+pn;
//	}
//	
//	public static String getPropertyName(String prefix, String methodName) {
//		String pName = methodName.substring(prefix.length(), methodName.length());
//		return pName.substring(0,1).toLowerCase()+pName.substring(1, pName.length());
//	}
//	
//	public static Object tryToInvokeStaticMethod(Object o, String methodName, Object[]args) {
//		try {		
//			ClassType<? extends Object> classType = TypeOracle.Instance.getClassType(o.getClass());
//			Method method = ReflectionUtils.findMethodByName(classType, methodName);
//			return method.invoke(o, args);		
//		} catch (Exception e) {
//			return null;
//		}
//	}
//	
//	public static Object getBeanProperty(Object o, String propName) {
//		try {
//			ClassType<? extends Object> classType = TypeOracle.Instance.getClassType(o.getClass());
//			Method getter = ReflectionUtils.getGetter(classType, propName);
//			return getter.invoke(o, new Object[]{});
//		}catch (Exception e) {
//			return null;
//		}
//	}
//	
//	public static void setBeanProperty(Object o, String propName, Object val) {
//		try {
//			ClassType<? extends Object> classType = TypeOracle.Instance.getClassType(o.getClass());
//			Method setter = ReflectionUtils.getSetter(classType, propName);
//			setter.invoke(o, new Object[]{val});
//		}catch (Exception e) {
//		}
//	}
//	
//	public static <T> T instantiate(Class<T> c) {
//		ClassType<T> classType = TypeOracle.Instance.getClassType(c);
//		Constructor<T> defConstructor = classType.findConstructor();
//		return defConstructor.newInstance();
//	}
//
//	public static String dumpBean(Object b) {
//		Map<String, Object> props = getBeanProperties(b);
//		String s = ""+getClassName(b.getClass())+" {";
//		for(String p: props.keySet()) {
//			s+=p+": "+props.get(p)+", ";
//		}
//		return s+"}";
//	}
//	public static String getClassName(Class c) {
//		ClassType classType = TypeOracle.Instance.getClassType(c);
//		return classType.getName();
//	}
//	public static <T extends Annotation> T getMethodAnnotation(Method method, Class<T> annotationClass) {
////		ClassType classType = TypeOracle.Instance.getClassType(c);
////		Method m = classType.getMethod(methodName, methodParamTypes);
//		return method.getAnnotation(annotationClass);
//	}
//	public static <T extends Annotation> T getMethodAnnotation(Class<?> c, 
//			String methodName, com.gwtent.reflection.client.Type[] methodParamTypes,  
//			Class<T> annotationClass) {
//		ClassType classType = TypeOracle.Instance.getClassType(c);
//		Method m = classType.getMethod(methodName, methodParamTypes);
//		return getMethodAnnotation(m, annotationClass);
////		return m.getAnnotation(annotationClass);
//	}
//	/**
//	 * return a map fieldName->anotation with the annotations in getters and setters of given field.
//	 */
//	public static <T> Map<String, T> getAccessorAnnotations(Class<?> c, 
//			String fieldName, Class<T> annotationClass) {
//		ClassType classType = TypeOracle.Instance.getClassType(c);
//		Map<String, T> m = new HashMap<String, T>();
//		List<String> fields = getBeanClassPropertyNames(c);
//		for(String f : fields) {
//			Method getter = ReflectionUtils.getGetter(classType, f), 
//				setter = ReflectionUtils.getSetter(classType, f);
//			if(getter!=null&setter!=null) {
//				
//			}
//		}
//		return m;
//	}
//
////	public static Map<String, Object> getBeanProperties(Object o) {
////		Map<String, Object> props = new HashMap<String, Object>();
////		ClassType<? extends Object> classType = TypeOracle.Instance.getClassType(o.getClass());	
////		
////		Method[] methods = classType.getMethods();
////		Set<String> methodNames = new HashSet<String>();
////		for (int i = 0; i < methods.length; i++) {
////			methodNames.add(methods[i].getName());
////			System.out.println("method: "+methods[i].getName());
////		}
////		Field[] fields = classType.getFields();
////		for (int i = 0; i < fields.length; i++) {
////			Field field = fields[i];
////			String getterName = ReflectionUtil.getAccessorName("get", field.getName()),
////					getterName2 = ReflectionUtil.getAccessorName("is", field.getName()),
////					setterName = ReflectionUtil.getAccessorName("set", field.getName());
////			System.out.println(getterName+" - "+getterName2+" - "+setterName);
////			if( (methodNames.contains(getterName) && methodNames.contains(setterName)) ||
////				(methodNames.contains(getterName2) && methodNames.contains(setterName)) ) {
////				
////				Object val = null;
////				try {
////					val = classType.invoke(o, getterName, new Object[]{});
////				} catch (Exception e) {
////					try {val = classType.invoke(o, getterName2, new Object[]{});}catch (Exception e2) {}
////				}
////				if(val!=null)
////					props.put(field.getName(), val);
////			}
////		}
////		return props;
////	}
//}
