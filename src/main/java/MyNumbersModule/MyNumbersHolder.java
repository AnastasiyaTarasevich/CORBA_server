package MyNumbersModule;

/**
* MyNumbersModule/MyNumbersHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Numbers.idl
* 23 ������� 2023 �. 22:55:03 MSK
*/

public final class MyNumbersHolder implements org.omg.CORBA.portable.Streamable
{
  public MyNumbersModule.MyNumbers value = null;

  public MyNumbersHolder ()
  {
  }

  public MyNumbersHolder (MyNumbersModule.MyNumbers initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = MyNumbersModule.MyNumbersHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    MyNumbersModule.MyNumbersHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return MyNumbersModule.MyNumbersHelper.type ();
  }

}
