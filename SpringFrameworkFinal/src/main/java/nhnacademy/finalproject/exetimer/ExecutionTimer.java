package nhnacademy.finalproject.exetimer;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Slf4j
@Component
public class ExecutionTimer {

  @Pointcut("@annotation(nhnacademy.finalproject.exetimer.ExeTimer)")
  private void timer(){};

  @Around("timer()")
  public Object AssumeExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
    StopWatch stopWatch = new StopWatch();

    stopWatch.start();
    Object proceed = joinPoint.proceed();// 조인포인트의 메서드 실행
    stopWatch.stop();

    long totalTimeMillis = stopWatch.getTotalTimeMillis();

    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    String methodName = signature.getMethod().getName();

    log.info("실행시간 ={} \t실행 메서드 = {}", totalTimeMillis,methodName);

    return proceed;
  }

}
