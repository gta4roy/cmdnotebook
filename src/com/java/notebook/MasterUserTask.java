package com.java.notebook;
import java.util.Scanner;
public class MasterUserTask
{
    public MasterUserTask()
    {
        m_userManager = new UserManager();
        m_notesProcessor = new NotesProcessor("master");
    }
    public void createUser()
    {
        System.out.println("Please provide UserName and Password ");
        String username,password;
        Scanner si = new Scanner(System.in);
        System.out.println("Username: >>");
        username = si.nextLine();
        System.out.println("Password: >>");
        password = si.nextLine();
        m_userManager.create(username,password);
        System.out.println("User Created Succesfully");
    }
    public void deletUser()
    {
        System.out.println("Please provide UserName and Password ");
        String username;
        Scanner si = new Scanner(System.in);
        System.out.println("Username: >>");
        username = si.nextLine();
        m_userManager.delete(username);
        System.out.println("User Deleted Succesfully");
    }
    public void addNotes()
    {
        //tobe done
        m_notesProcessor.writeNote();
    }
    public void deleteNote()
    {
        //tobe done
        m_notesProcessor.deleteNote();
    }
    public void displayTodaysNotes()
    {
        m_notesProcessor.displayTodayNotes();
    }
    public void clearNotes()
    {
        m_notesProcessor.clearAllNotes();
    }
    public void displayAllNotes()
    {
        m_notesProcessor.displayAllNotes();
    }
    private NotesProcessor  m_notesProcessor;
    private UserManager m_userManager;
}
