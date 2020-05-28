package com.luxoft.springdb.test;

/**
 * Created by oyushche on 11/20/17.
 */
public class TR implements I
{
    private I i;
    private Boolean isTransEnabled = true;

    public TR(I i)
    {
        this.i = i;
    }

    @Override
    public void test()
    {
        if (isTransEnabled)
        {
            // open trans
        }

        i.test();

        if (isTransEnabled)
        {
            //close trans
        }


    }

    public void setTransEnabled(Boolean transEnabled)
    {
        isTransEnabled = transEnabled;
    }
}
