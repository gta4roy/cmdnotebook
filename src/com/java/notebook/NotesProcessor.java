package com.java.notebook;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class NotesProcessor
{
    public NotesProcessor(String loginUser)
    {
        m_noteManager = new NotesJsonProcessor();
        m_currentUser = loginUser;
    }
    public void writeNote()
    {
        //tobe done
        System.out.println("Enter x: to stop typing");
        System.out.println(">>");
        Scanner si = new Scanner(System.in);
        ArrayList<String> linesGiven = new ArrayList<String>();
        while(si.hasNext())
        {
            String line = si.nextLine();
            if(line.equals("x:"))
            {
                break;
            }
            linesGiven.add(line);
        }

        String noteString = new String();
        for(String nt : linesGiven) {
            noteString += nt;
            noteString += "\n";
        }

        Date todayDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
        String dateString = sdf.format(todayDate);
        String timeString = timeFormat.format(todayDate);

        m_noteManager.create(m_currentUser,dateString,timeString,noteString);
    }
    public void deleteNote()
    {
        //tobe done
        System.out.println("Enter Note Index to be deleted");
        System.out.println(">>");
        Scanner si = new Scanner(System.in);
        String indexTobeDelete = si.nextLine();
        m_noteManager.delete(indexTobeDelete,m_currentUser);
    }

    public void clearAllNotes()
    {
        m_noteManager.deleteAll(m_currentUser);
    }

    public void displayAllNotes()
    {
        ArrayList<Notes> allNotes = m_noteManager.getAllNotes();
        for(Notes nt : allNotes)
        {
            if(nt.username.equals(m_currentUser))
            {
                System.out.println("Index: "+nt.index+" Date:"+ nt.date +" Time:"+nt.time);
                System.out.println("Notes:"+nt.content);
                System.out.println("--------------------------------");
            }
        }
    }
    public void displayTodayNotes()
    {
        ArrayList<Notes> allNotes = m_noteManager.getAllNotes();
        Date todayDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(todayDate);

        for(Notes nt : allNotes)
        {
            if(nt.username.equals(m_currentUser) && nt.date.equals(dateString))
            {
                System.out.println("Index: "+nt.index+" Date:"+ nt.date +" Time:"+nt.time);
                System.out.println("Notes:"+nt.content);
                System.out.println("--------------------------------");
            }
        }
    }
    private NotesJsonProcessor m_noteManager;
    private String m_currentUser;
}
