package MyNumbersModule;


/**
* MyNumbersModule/MyNumbersPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Numbers.idl
* 23 ������� 2023 �. 22:55:03 MSK
*/

public abstract class MyNumbersPOA extends org.omg.PortableServer.Servant
 implements MyNumbersModule.MyNumbersOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getNegativeNumbers", new java.lang.Integer (0));
    _methods.put ("addRandomNumbers", new java.lang.Integer (1));
    _methods.put ("getNumberSet", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // MyNumbersModule/MyNumbers/getNegativeNumbers
       {
         int $result[] = null;
         $result = this.getNegativeNumbers ();
         out = $rh.createReply();
         MyNumbersModule.LongSequenceHelper.write (out, $result);
         break;
       }

       case 1:  // MyNumbersModule/MyNumbers/addRandomNumbers
       {
         int number = in.read_long ();
         this.addRandomNumbers (number);
         out = $rh.createReply();
         break;
       }

       case 2:  // MyNumbersModule/MyNumbers/getNumberSet
       {
         int $result[] = null;
         $result = this.getNumberSet ();
         out = $rh.createReply();
         MyNumbersModule.LongSequenceHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:MyNumbersModule/MyNumbers:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public MyNumbers _this() 
  {
    return MyNumbersHelper.narrow(
    super._this_object());
  }

  public MyNumbers _this(org.omg.CORBA.ORB orb) 
  {
    return MyNumbersHelper.narrow(
    super._this_object(orb));
  }


} // class MyNumbersPOA
