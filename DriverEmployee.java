package org.serial.Employee;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;



public class DriverEmployee {

    public static void main(String[] args)   {

        // Let's create a number of Employees
        Employee one   = new Employee(createDataSize(10485760),Integer.MAX_VALUE);
        Employee two   = new Employee(createDataSize(10485760),Integer.MAX_VALUE);
        Employee three = new Employee(createDataSize(10485760),Integer.MAX_VALUE);
        Employee four  = new Employee(createDataSize(10485760),Integer.MAX_VALUE);
        Employee five  = new Employee(createDataSize(10485760),Integer.MAX_VALUE);

        Employee[] mystaff = new Employee[5];

        // Populate the array with Employees
        mystaff[0] = one;
        mystaff[1] = two;
        mystaff[2] = three;
        mystaff[3] = four;
        mystaff[4] = five;


        for (int i = 0; i < 50; i++) {

            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("mystaff.data"));
                out.writeObject(mystaff);


            } catch (Exception ie) {

                System.out.println("Encountered an Exception writing to Disk: " + ie.getMessage());
            }

            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("mystaff.data"));
                Employee[] StaffFromDisk = (Employee[]) in.readObject();


            } catch (Exception ie) {

                System.out.println("Encountered an Exception Reading From Disk: " + ie.getMessage());
            }

        }
    }
     // Ref: https://stackoverflow.com/questions/2474486/create-a-java-variable-string-of-a-specific-size-mbs
    private static String createDataSize(int msgSize) {
        StringBuilder sb = new StringBuilder(msgSize);
        for (int i=0; i<msgSize; i++) {
            sb.append('a');
        }
        return sb.toString();
    }
}
