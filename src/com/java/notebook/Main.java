package com.java.notebook;

public class Main
{

    /*
    Main method
     */
    public static void main(String args[])
    {
        Main obj = new Main();
        final String masterUser = "master";
        final String masterPassword = "1234";

        if(obj.ValidateArguments(args))
        {
            if(args[1].equals(masterUser) && args[3].equals(masterPassword))
            {
                    obj.proceedToMasterUserLogin();
            }
            else
            {
                UserMenu userMenu = new UserMenu();
                if(userMenu.validate(args[1],args[3]))
                {
                    while(userMenu.askUser()){}
                    System.out.println("Bye..");
                }
                else
                {
                    System.out.println("Incorrect Password and username ");
                }
            }
        }
        else
        {
            System.out.println("Correct System Usage ");
            System.out.println("-u <username> -p <password>");
        }
    }

    void proceedToMasterUserLogin()
    {
        System.out.println("Proceed to master User Login");
        MasterMenu master = new MasterMenu();
        while(master.askUser()){}
        System.out.println("Bye..");
    }

    boolean ValidateArguments(String args[])
    {
        boolean retValue = true;
        if(args.length != 4)
        {
            retValue = false;
        }
        if(retValue && args[0].equals("-u") == false)
        {
            retValue = false;
        }
        if(retValue && args[2].equals("-p") == false) {
            retValue = false;
        }
        return retValue;
    }
}
