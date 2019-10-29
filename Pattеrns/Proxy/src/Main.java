// В рамках ООП проки подразумевает, что есть какой -то класс и мы вызываем на нем метод и
//  Можем добавить некую обертку, которая перед и после вызова метода выполит какие-то
// дополнительные действия
// интерфейс InvocationHandler - встроенный в Java прокси

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
      InvocationHandler invocationHandler = new ReaderInvocationHandler();
      Object proxyInstance =
              Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{Reader.class}, invocationHandler);
        ((Reader)proxyInstance).read("Hello");
    }
}
interface Reader {
    String read(String str);
}

class  MyReader implements Reader {
    @Override
    public String read(String str) {
        return str + " world";
    }
}

class  ReaderInvocationHandler implements InvocationHandler {
    @Override
    //объект, вызванный метод, аргументы, с которыми ыл вызван метод
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(args[0]);
        Object result = method.invoke(new MyReader(), args);
        System.out.println(result);
        return result;
    }
}

class  ProxyReader extends MyReader {
    @Override
    public String read(String str) {
        System.out.println(str);
        String read = super.read(str);
        System.out.println(read);
        return read;
    }
}