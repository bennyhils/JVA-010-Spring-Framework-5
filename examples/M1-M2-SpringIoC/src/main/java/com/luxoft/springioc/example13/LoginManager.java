package com.luxoft.springioc.example13;

public class LoginManager
{
    private UserDirectory userDirectory;

    public UserDirectory getUserDirectory()
    {
        return userDirectory;
    }

    public void setUserDirectory(UserDirectory userDirectory)
    {
        this.userDirectory = userDirectory;
    }
}
