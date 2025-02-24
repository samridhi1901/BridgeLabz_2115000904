import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Interface with a method to be intercepted
interface Greeting {
    void sayHello(String name);
}

// Implementation of Greeting interface
class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// Invocation Handler for Logging Proxy
class LoggingProxyHandler implements InvocationHandler {
    private final Object target;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Executing method: " + method.getName());
        return method.invoke(target, args);
    }
}

// Factory to create proxy instance
class ProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
            interfaceType.getClassLoader(),
            new Class<?>[]{interfaceType},
            new LoggingProxyHandler(target)
        );
    }
}

public class DynamicProxyTest {
    public static void main(String[] args) {
        Greeting greetingProxy = ProxyFactory.createProxy(new GreetingImpl(), Greeting.class);
        greetingProxy.sayHello("Alice");
    }
}
