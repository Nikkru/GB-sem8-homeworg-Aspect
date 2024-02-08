package com.example.sem6apiEx1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class RegistrationAspect {
    @After(value = "@annotation(TrackUserAction)")
    public void registrationMethod(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("At "
                +localDateTime
                +" was done the request with method: "
                + signature.getMethod().getName());

        System.out.println("Method args values:");
        Arrays.stream(joinPoint.getArgs())
                .forEach(o -> System.out.println("arg value: " + o.toString()));
    }
}
