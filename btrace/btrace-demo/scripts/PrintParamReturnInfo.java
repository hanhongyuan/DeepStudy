/* BTrace Script Template */
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class TracingScript {
    /* put your code here */
/*ָ��Ҫ�鿴�ķ�������*/
  @OnMethod(
     clazz="baby.btrace.CaseObject",
     method="execute",
     location=@Location(Kind.RETURN)
  )
/*��Ҫ���������Ƕ����Լ������� �� ����ֵ�������������Ƿ�������ʱ����Ĳ���*/
   public static void traceExecute(@Self baby.btrace.CaseObject object,int sleepTime, @Return boolean result){
      println("���ö�ջ����");
       println(strcat("���ؽ���ǣ�",str(result)));
      jstack();
      println(strcat("ʱ���ǣ�",str(sleepTime)));
   }

}