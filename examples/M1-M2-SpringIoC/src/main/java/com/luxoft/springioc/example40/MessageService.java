package com.luxoft.springioc.example40;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("messageService")
@Configuration
@ComponentScan
public class MessageService
{

    @Autowired
    private List<Printer> printers;

    public void print(String text)
    {
        printers.forEach((printer) -> printer.print(text));
    }

    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MessageService.class);
        MessageService messageService =
                context.getBean("messageService", MessageService.class);
        messageService.print("Text");
        context.close();
    }

    @Component
    class SPrinter implements Printer
    {

        @Override
        public void print(String text)
        {
            System.out.println(SPrinter.class.getSimpleName());
        }
    }

}
