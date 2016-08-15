package com.example.katsu.aspect;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by katsu on 16/08/07.
 */
@Aspect
public class ActivityAspect {
    @After("execution(* android.app.Activity.on**(..))")
    public void onResumeMethod(JoinPoint joinPoint) throws Throwable {
//        Log.i("helloAOP", "aspect:::" + joinPoint.getSignature());
    }


    @Pointcut("execution(@com.example.katsu.aspect.NeedLogin * *(..))")
    public void pointcutOnNeedLoginMethod() {
    }

    @Around("pointcutOnNeedLoginMethod()")
    public void adviceOnNeedPermissionMethod(final ProceedingJoinPoint joinPoint) throws Throwable {
        if (MainActivity.isLogin == false) {
            Object target = joinPoint.getTarget();
            Activity activity = (Activity)target;
            BridgeActivity.setActivityResultListner(new BridgeActivity.ActivityResultListner() {
                @Override
                public void onActivityResult(Activity activity) {
                    try {
                        activity.finish();
                        joinPoint.proceed();
                    } catch(Throwable t) {
                    }
                }
            });
            Intent intent = new Intent(activity, BridgeActivity.class);
            intent.putExtra("request", 1);
            activity.startActivityForResult(intent,12345);
            return;
        }
        joinPoint.proceed();
    }

    @Pointcut("execution(@com.example.katsu.aspect.NeedProfile * *(..))")
    public void pointcutOnNeedProfileMethod() {
    }

    @Around("pointcutOnNeedProfileMethod()")
    public void adviceOnNeedProfileMethod(final ProceedingJoinPoint joinPoint) throws Throwable {
        Log.d("AOP","NeedProfile");
        if (MainActivity.hasParam == false) {
            Object target = joinPoint.getTarget();
            Activity activity = (Activity) target;
            BridgeActivity.setActivityResultListner(new BridgeActivity.ActivityResultListner() {
                @Override
                public void onActivityResult(Activity activity) {
                    try {
                        activity.finish();
                        joinPoint.proceed();
                    } catch (Throwable t) {
                    }
                }
            });
            Intent intent = new Intent(activity, BridgeActivity.class);
            intent.putExtra("request", 2);
            activity.startActivityForResult(intent, 12345);
            return;
        }
        joinPoint.proceed();
    }
}