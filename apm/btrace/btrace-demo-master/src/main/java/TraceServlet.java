

import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;

import java.lang.reflect.Field;


@BTrace
public class TraceServlet {
    @TLS
    private static long startTime = 0;

    //方法开始时监测cnt属性
    //Kind.ENTRY
    @OnMethod(clazz = "com.unei.servlet.HelloServlet", method = "doGet", location = @Location(Kind.ENTRY))
    public static void tracePropertyBefore(@Self Object self) {
        println(strcat("threadId:", str(threadId(currentThread()))));
        Field cntField = field("com.unei.servlet.HelloServlet", "cnt");
        Integer c = (Integer) get(cntField, self);
        println(strcat("start cnt:", str(c)));
    }

    /**
     * 方法结束时监测cnt属性
     *
     * @param @Self self this
     */
    @OnMethod(clazz = "com.unei.servlet.HelloServlet", method = "doGet", location = @Location(Kind.RETURN))
    public static void tracePropertyAfter(@Self Object self) {
        Field cntField = field("com.unei.servlet.HelloServlet", "cnt");
        Integer c = (Integer) get(cntField, self);
        println(strcat("end cnt:", str(c)));
        println("-----------------------");
    }

    /**
     * 打印方法参数
     *
     * @ProbeClassName 类名
     * @ProbeMethodName 方法名
     * args 目标方法参数
     */
    @OnMethod(clazz = "/com.unei.*/", method = "/check.*/")
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
        println(strcat("method:", strcat(strcat(pcn, "."), pmn)));
        print("args:");
        printArray(args);
    }
}
