package com.javalec.spring_ex8_1;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EmpConnection implements InitializingBean, EnvironmentAware {
    private Environment env;
    private String empId;
    private String empPw;


    public Environment getEnv() {
        return env;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpPw() {
        return empPw;
    }

    public void setEmpPw(String empPw) {
        this.empPw = empPw;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setEmpId(env.getProperty("emp.id"));
        setEmpId(env.getProperty("emp.pw"));
    }

    @Override
    public void setEnvironment(Environment environment) {
        setEnv(environment);
    }
}
