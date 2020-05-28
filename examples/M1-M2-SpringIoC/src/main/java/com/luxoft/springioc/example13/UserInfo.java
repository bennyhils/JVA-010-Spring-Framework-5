package com.luxoft.springioc.example13;

public class UserInfo
{
    private LDAPUserDirectory ldapUserDirectory;

    public UserDirectory getLdapUserDirectory()
    {
        return ldapUserDirectory;
    }

    public void setLdapUserDirectory(LDAPUserDirectory ldapUserDirectory)
    {
        this.ldapUserDirectory = ldapUserDirectory;
    }
}
