package com.luxoft.jva010.mvc.model;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

public class UserForm
{
    @Size(min = 3, max = 20, message = "Should be at least 3 symbols.")
    private String name;

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Min(18) @Max(100)
    private int age;

    @Size(min = 3, max = 20, message = "Should be at least 3 symbols.")
    private String password;

    public UserForm()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
