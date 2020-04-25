package com.java.notebook;

import java.util.ArrayList;

public class UserMenu
{
    public  UserMenu()
    {
        menuList = new ArrayList<String>();
        menuList.add("Add Note");
        menuList.add("Display All Notes");
        menuList.add("Display Today's Notes");
        menuList.add("Delete Notes");
        menuList.add("Clear Notes");
        menuList.add("close");
        m_userManager = new UserManager();
    }
    public boolean validate(String userName, String password)
    {
        boolean retValue = false;
        if(m_userManager.validate(userName,password))
        {
            retValue = true;
            m_loginUser = userName;
            m_normalTaskUser = new NotesProcessor(m_loginUser);
        }
        return retValue;
    }

    public boolean askUser()
    {
        boolean retValue = true;
        Menu mn = new Menu(menuList);
        String chosenMenu = mn.getAskMenuToTheUser();
        if(chosenMenu.equals(menuList.get(0)))
        {
            System.out.println("Chosen "+ menuList.get(0));
            m_normalTaskUser.writeNote();
        }
        else if (chosenMenu.equals(menuList.get(1)))
        {
            System.out.println("Chosen "+ menuList.get(1));
            m_normalTaskUser.displayAllNotes();
        }
        else if (chosenMenu.equals(menuList.get(2)))
        {
            System.out.println("Chosen "+ menuList.get(2));
            m_normalTaskUser.displayTodayNotes();
        }
        else if (chosenMenu.equals(menuList.get(3)))
        {
            System.out.println("Chosen "+ menuList.get(3));
            m_normalTaskUser.deleteNote();
        }
        else if (chosenMenu.equals(menuList.get(4)))
        {
            System.out.println("Chosen "+ menuList.get(4));
            m_normalTaskUser.clearAllNotes();
        }
        else
        {
            retValue = false;
        }
        return retValue;
    }
   // MasterUserTask  m_masterUserTask;
    private ArrayList<String>  menuList;
    private String             m_loginUser;
    private UserManager        m_userManager;
    private NotesProcessor     m_normalTaskUser;
}
