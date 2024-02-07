package org.example;

import MyNumbersModule.MyNumbers;
import MyNumbersModule.MyNumbersHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import java.util.HashSet;

public class Main  {
    public static void main(String args[]) {
        try {

            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            NumbersImpl numbersImpl = new NumbersImpl();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(numbersImpl);
            MyNumbers href = MyNumbersHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            String name="Numbers";
            NameComponent path[]=ncRef.to_name(name);
            ncRef.rebind(path,href);
            System.out.println("Сервер CORBA запущен...");
            orb.run();


        } catch (InvalidName e) {
            throw new RuntimeException(e);
        } catch (AdapterInactive e) {
            throw new RuntimeException(e);
        } catch (WrongPolicy e) {
            throw new RuntimeException(e);
        } catch (ServantNotActive e) {
            throw new RuntimeException(e);
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            throw new RuntimeException(e);
        } catch (CannotProceed e) {


        } catch (NotFound e) {
            throw new RuntimeException(e);
        }

    }
}