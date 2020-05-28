package com.luxoft.springioc.example01;

import com.luxoft.springioc.movies.MovieLister;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main(String args[])
    {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "example01/application-context.xml");

        System.out.println();
        System.out.println("--> application-context created");
        System.out.println();

        MovieLister lister = (MovieLister) context.getBean("movieLister");
        System.out.println(lister);

        System.out.println();
        Ex1TestBean bean = context.getBean(Ex1TestBean.class);
        System.out.println(bean.getName());
    }
}
