package com.java.notebook;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu
{
    public Menu(ArrayList<String> menuOptions)
    {
        m_menuOptions = menuOptions;
    }

    public String getAskMenuToTheUser()
    {
        System.out.println("Please select one Option from the menu");
        int index = 0;
        for(String options: m_menuOptions)
        {
            System.out.println(">> "+ index++ + " :" + options);
        }
        System.out.println(">>");
        Scanner si = new Scanner(System.in);
        String optionGiven = si.nextLine();
        int menuSelected;
        try
        {
            menuSelected = Integer.parseInt(optionGiven);
        }
        catch (NumberFormatException ex)
        {
            menuSelected = -1;
        }
        if(menuSelected >= 0 && menuSelected < m_menuOptions.size())
        {
            return  m_menuOptions.get(menuSelected);
        }
        else
        {
            return "";
        }
    }
    public ArrayList<String> m_menuOptions;
}
