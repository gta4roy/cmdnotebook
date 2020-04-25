package com.java.notebook;
import java.util.ArrayList;
public class MasterMenu
{
    public  MasterMenu()
    {
        menuList = new ArrayList<String>();
        menuList.add("Add Note");
        menuList.add("Display All Notes");
        menuList.add("Display Today's Notes");
        menuList.add("Delete Notes");
        menuList.add("Clear Notes");
        menuList.add("Create User");
        menuList.add("Delete User");
        menuList.add("close");

        m_masterUserTask = new MasterUserTask();
    }

    public boolean askUser()
    {
        boolean retValue = true;
        Menu mn = new Menu(menuList);
        String chosenMenu = mn.getAskMenuToTheUser();
        if(chosenMenu.equals(menuList.get(0)))
        {
            System.out.println("Chosen "+ menuList.get(0));
            m_masterUserTask.addNotes();
        }
        else if (chosenMenu.equals(menuList.get(1)))
        {
            System.out.println("Chosen "+ menuList.get(1));
            m_masterUserTask.displayAllNotes();
        }
        else if (chosenMenu.equals(menuList.get(2)))
        {
            System.out.println("Chosen "+ menuList.get(2));
            m_masterUserTask.displayTodaysNotes();
        }
        else if (chosenMenu.equals(menuList.get(3)))
        {
            System.out.println("Chosen "+ menuList.get(3));
            m_masterUserTask.deleteNote();
        }
        else if (chosenMenu.equals(menuList.get(4)))
        {
            System.out.println("Chosen "+ menuList.get(4));
            m_masterUserTask.clearNotes();
        }
        else if (chosenMenu.equals(menuList.get(5)))
        {
            System.out.println("Chosen "+ menuList.get(5));
            //User creation
            m_masterUserTask.createUser();
        }
        else if (chosenMenu.equals(menuList.get(6)))
        {
            System.out.println("Chosen "+ menuList.get(6));
            m_masterUserTask.deletUser();
        }
        else
        {
            retValue = false;
        }
        return retValue;
    }
    private MasterUserTask  m_masterUserTask;
    private ArrayList<String>  menuList;
}
