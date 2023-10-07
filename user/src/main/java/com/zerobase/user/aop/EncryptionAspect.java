package com.zerobase.user.aop;

import com.zerobase.user.util.Aes256Util;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Optional;

@Aspect
@Component
public class EncryptionAspect {

    @Pointcut("execution(* com.zerobase.user.repository.UserInfoRepository.find*(..))")
    public void findMethods() {
    }

    @Pointcut("execution(* com.zerobase.user.repository.UserInfoRepository.save*(..))")
    public void saveMethods() {
    }

    @Around("saveMethods() || findMethods()")
    public Object encryptDecryptData(ProceedingJoinPoint pjp) throws Throwable {
        Object result = pjp.proceed();

        // 결과가 Optional인지 확인
        if (result instanceof Optional) {
            Optional<?> optionalResult = (Optional<?>) result;

            // Optional에 값이 존재하는지 확인
            if (optionalResult.isPresent()) {
                // Optional에서 값 추출
                Object value = optionalResult.get();

                // 값에 대한 암호화/복호화 수행
                for (Field field : value.getClass().getDeclaredFields()) {
                    if (field.isAnnotationPresent(Encrypt.class)) {
                        field.setAccessible(true);
                        Object fieldValue = field.get(value);

                        if (fieldValue != null) {
                            if (pjp.getSignature().getName().startsWith("find")) {
                                // find 메서드 호출 시 복호화
                                field.set(value, Aes256Util.decrypt(fieldValue.toString()));
                            } else if (pjp.getSignature().getName().startsWith("save")) {
                                // save 메서드 호출 시 암호화
                                field.set(value, Aes256Util.encrypt(fieldValue.toString()));
                            }
                        }
                    }
                }

                // Optional에 다시 담아서 반환
                return Optional.of(value);
            }
        }

        // 결과가 Optional이 아닌 경우에 대한 암호화/복호화 수행
        for (Field field : result.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Encrypt.class)) {
                field.setAccessible(true);
                Object fieldValue = field.get(result);

                if (fieldValue != null) {
                    if (pjp.getSignature().getName().startsWith("find")) {
                        // find 메서드 호출 시 복호화
                        field.set(result, Aes256Util.decrypt(fieldValue.toString()));
                    } else if (pjp.getSignature().getName().startsWith("save")) {
                        // save 메서드 호출 시 암호화
                        field.set(result, Aes256Util.encrypt(fieldValue.toString()));
                    }
                }
            }
        }

        return result;
    }
}
