package com.luxoft.springioc.example14;

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
