package client;

import MyNumbersModule.*;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class MainClient
{

    static MyNumbers numbers;
    public static void main(String []args) throws InvalidName, org.omg.CosNaming.NamingContextPackage.InvalidName, CannotProceed, NotFound {
        ORB orb = ORB.init(args,null);
        org.omg.CORBA.Object objectRef=orb.resolve_initial_references("NameService");
        NamingContextExt ncRef= NamingContextExtHelper.narrow(objectRef);
        numbers = MyNumbersHelper.narrow(ncRef.resolve_str("Numbers"));
        Scanner scanner = new Scanner(System.in);
            System.out.print("Введите количество элементов: ");
            int count = scanner.nextInt();
                numbers.addRandomNumbers(count);
                System.out.println("Сгенерированный массив:");
                for (long number : numbers.getNumberSet()) {
                    System.out.println(number);
                }
                System.out.println("Отрицательные числа из массива:");
                for (long number : numbers.getNegativeNumbers()) {
                    System.out.println(number);
                }

    }
}
