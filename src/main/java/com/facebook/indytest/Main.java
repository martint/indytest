package com.facebook.indytest;

public class Main
{
    public static void main(String[] args)
    {
        Compiler compiler = new Compiler();
        System.out.println(compiler.compile().run());
    }
}
