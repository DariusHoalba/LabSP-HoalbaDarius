package com.example.sabloanelab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.difexample.sabloanelab.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.sabloanelab", "com.difexample.sabloanelab"})
public class SabloaneLabApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SabloaneLabApplication.class, args);
        ApplicationContext context = SpringApplication.run(SabloaneLabApplication.class, args);
        TransientComponent transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        SingletonComponent singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();

        c = (ClientComponent)context.getBean("clientComponent");
        c.operation();


    }
}
