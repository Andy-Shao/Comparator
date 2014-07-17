package andy.shao.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

/**
 * With a easy way to use java.lang.reflect.*; For this class could avoid some exception which is the subclass of
 * {@link Exception}.<br>
 * Convert the {@link Exception} or the subclass of {@link Exception} to {@link RuntimeException}. For example:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * try {
 * 	return (Class&lt;T&gt;) Class.forName(className);
 * } catch (ClassNotFoundException e) {
 * 	throw new RuntimeException(e);
 * }
 * </pre>
 * 
 * </blockquote>
 * <p>
 * Any necessary about take the original exception, you could use this way:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * try {
 * 	Class&lt;String&gt; clazz = Reflects.forName(&quot;java.lang.String&quot;);
 * } catch (RuntimeException e) {
 * 	Throwable throwable = e.getCause();
 * 	if (throwable instanceof ClassNotFoundException) {
 * 		// Do something
 * 	}
 * 	// For other things:
 * 	throw e;
 * }
 * </pre>
 * 
 * </blockquote>
 * <p>
 * <p style="color:orange;">
 * At least JDK1.5
 * </p>
 * 
 * @author ws83149
 * 
 */
public final class Reflects {
	private Reflects() {
		throw new AssertionError("No Reflects instances for you!");
	}

	/**
	 * Returns the Class object associated with the class or interface with the given string name.
	 * 
	 * @param className
	 *        the fully qualified name of the desired class.
	 * @return the Class object for the class with the specified name.
	 * @see {@link Class#forName(String)}
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> forName(String className) {
		try {
			return (Class<T>) Class.forName(className);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns the value of the field represented by this Field, on the specified object. The value is automatically
	 * wrapped in an object if it has a primitive type.
	 * 
	 * @param object
	 *        object from which the represented field's value is to be extracted
	 * @param field
	 * @return the value of the represented field in object obj; primitive values are wrapped in an appropriate object
	 *         before being returned
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getFieldValue(Object object, Field field) {
		try {
			return (T) field.get(object);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Sets the field represented by this Field object on the specified object argument to the specified new value. The
	 * new value is automatically unwrapped if the underlying field has a primitive type.
	 * 
	 * @param target
	 * @param field
	 *        the object whose field should be modified
	 * @param value
	 *        the new value for the field of obj being modified
	 */
	public static void setFieldValue(Object target, Field field, Object value) {
		try {
			field.set(target, value);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns a Constructor object that reflects the specified public constructor of the class represented by this
	 * Class object.
	 * 
	 * @param clazz
	 *        The class which be found {@link Constructor}
	 * @param parameterTypes
	 *        the parameter array
	 * @return the Constructor object of the public constructor that matches the specified parameterTypes
	 */
	public static <T> Constructor<T> getConstructor(Class<T> clazz, Class<?>... parameterTypes) {
		try {
			return clazz.getConstructor(parameterTypes);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns a Constructor object that reflects the specified constructor of the class or interface represented by
	 * this Class object. The parameterTypes parameter is an array of Class objects that identify the constructor's
	 * formal parameter types, in declared order. If this Class object represents an inner class declared in a
	 * non-static context, the formal parameter types include the explicit enclosing instance as the first parameter.
	 * 
	 * @param clazz
	 *        The class which be found {@link Constructor}
	 * @param parameterTypes
	 *        the parameter array
	 * @return the Constructor object of the public constructor that matches the specified parameterTypes
	 */
	public static <T> Constructor<T> getDeclaredConstructor(Class<T> clazz, Class<?>... parameterTypes) {
		try {
			return clazz.getDeclaredConstructor(parameterTypes);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns a Field object that reflects the specified declared field of the class or interface represented by this
	 * Class object. The name parameter is a String that specifies the simple name of the desired field. Note that this
	 * method will not reflect the length field of an array class.<br>
	 * <p style="color:red;">
	 * NOTE: Can find out some fields which is not public. But can't find out some fields which come from superClass.
	 * </p>
	 * 
	 * @param clazz
	 *        the class which be found out the {@link Field}
	 * @param fieldName
	 *        the name of the field
	 * @return the Field object for the specified field in this class
	 */
	public static Field getDeclaredField(Class<?> clazz, String fieldName) {
		try {
			return clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			if (clazz.getSuperclass() != null) return getDeclaredField(clazz.getSuperclass(), fieldName);
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns a Method object that reflects the specified declared method of the class or interface represented by this
	 * Class object.<br>
	 * <p style="color:red;">
	 * NOTE: Can find out some methods which is not public. But can't find out some methods which come from superClass.
	 * </p>
	 * 
	 * @param clazz
	 *        the class which be found out the {@link Method}
	 * @param methodName
	 *        the name of the method
	 * @param parameterTypes
	 *        the parameter array
	 * @return the Method object for the method of this class matching the specified name and parameters
	 */
	public static Method getDeclaredMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
		try {
			return clazz.getDeclaredMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException e) {
			if (clazz.getSuperclass() != null) return getDeclaredMethod(clazz.getSuperclass(), methodName, parameterTypes);
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns a Field object that reflects the specified public member field of the class or interface represented by
	 * this Class object.Could find out some fields which come from superClass.<br>
	 * <p style="color:red;">
	 * NOTE: just can find some fields which is public.
	 * </p>
	 * 
	 * @param clazz
	 *        the class which be found out the {@link Field}
	 * @param fieldName
	 *        the field name
	 * @return the Field object of this class specified by name
	 */
	public static Field getField(Class<?> clazz, String fieldName) {
		try {
			return clazz.getField(fieldName);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns a Method object that reflects the specified public member method of the class or interface represented by
	 * this Class object. Could find out some methods which come from superClass.<br>
	 * <p style="color:red;">
	 * NOTE: just can find some methods which is public.
	 * </p>
	 * 
	 * @param clazz
	 *        the class which be found out the {@link Method}
	 * @param methodName
	 *        the name of the method
	 * @param parameterTypes
	 *        the list of parameters
	 * @return the Method object that matches the specified name and parameterTypes
	 */
	public static Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
		try {
			return clazz.getMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Invokes the underlying method represented by this Method object, on the specified object with the specified
	 * parameters.
	 * 
	 * @param obj
	 *        the object the underlying method is invoked from
	 * @param method
	 *        the method which be executed
	 * @param args
	 *        the arguments used for the method call
	 * @return the result of dispatching the method represented by this object on obj with parameters args
	 */
	@SuppressWarnings("unchecked")
	public static <T> T invoke(Object obj, Method method, Object... args) {
		try {
			return (T) method.invoke(obj, args);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Creates a new instance of the class represented by this Class object. The class is instantiated as if by a new
	 * expression with an empty argument list.
	 * 
	 * @param clazz
	 *        the class which be instanced
	 * @return a newly allocated instance of the class represented by this object
	 */
	public static <T> T newInstance(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Uses the constructor represented by this Constructor object to create and initialize a new instance of the
	 * constructor's declaring class, with the specified initialization parameters.
	 * 
	 * @param constructor
	 *        the Constructor which be called
	 * @param initargs
	 *        array of objects to be passed as arguments to the constructor call; values of primitive types are wrapped
	 *        in a wrapper object of the appropriate type (e.g. a float in a {@link Float})
	 * @return a new object created by calling the constructor this object represents
	 */
	public static <T> T newInstance(Constructor<T> constructor, Object... initargs) {
		try {
			return constructor.newInstance(initargs);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Try to find all of the interfaces of the clazz.
	 * 
	 * @param clazz
	 * @param set
	 */
	public static void getInterfaces(Class<?> clazz, Set<Class<?>> set) {
		set.addAll(Arrays.asList(clazz.getInterfaces()));
		if (clazz.getSuperclass() != null) getInterfaces(clazz.getSuperclass(), set);
	}
}
