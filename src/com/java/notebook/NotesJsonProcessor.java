package com.java.notebook;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NotesJsonProcessor
{
    public NotesJsonProcessor()
    {
        //read the json
        m_jsonFile = new String();
        m_jsonFile = "notes.json";
        m_NotesJsonArray = new JSONArray();
        JSONParser jsonParser = new JSONParser();
        try
        {
            FileReader jsonFileReader = new FileReader(m_jsonFile);
            m_NotesJsonArray = (JSONArray) jsonParser.parse(jsonFileReader);
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Fresh DB");
        }
        catch (ParseException ex)
        {
            System.out.println("JSON Not available");
        }
        catch (IOException ex)
        {
            System.out.println("JSON Not available");
        }
    }
    public void create(String username, String date, String time, String notes)
    {
        //write the json
        int total = m_NotesJsonArray.size();
        JSONObject newNotes = new JSONObject();
        newNotes.put("username",username);
        newNotes.put("date",date);
        newNotes.put("time",time);
        newNotes.put("note",notes);

        while(!isValidIndex(total)){ total++; }

        newNotes.put("index",String.valueOf(total));  // Always saves a string
        m_NotesJsonArray.add(newNotes);

        writeToJsonFile();
    }
    public void delete (String index, String userName)
    {
        //write the json
        boolean ifFound = false;
        for(int i = 0; i < m_NotesJsonArray.size(); i++)
        {
            JSONObject noteObj = (JSONObject) m_NotesJsonArray.get(i);
            String user     = (String)noteObj.get("username");
            String  indStr  = (String)noteObj.get("index");
            if(user.equals(userName) && indStr.equals(index))
            {
                m_NotesJsonArray.remove(i);
                ifFound = true;
                break;
            }

        }
        if(ifFound)
            writeToJsonFile();
        else
            System.out.println("Unable to delete note");
    }

    private boolean isValidIndex (int index)
    {
        String indexStr = String.valueOf(index);
        boolean ifFound = false;
        for(int i = 0; i < m_NotesJsonArray.size(); i++)
        {
            JSONObject noteObj = (JSONObject) m_NotesJsonArray.get(i);
            String  indStr  = (String) noteObj.get("index");
            if(indStr.equals(indexStr))
            {
                ifFound = true;
                break;
            }
        }
        //if found in the DB then its invalid index
        return !ifFound;
    }

    public void deleteAll (String userName)
    {
        //write the json
        boolean ifFound = false;
        for(int i = 0; i < m_NotesJsonArray.size(); i++)
        {
            JSONObject noteObj = (JSONObject) m_NotesJsonArray.get(i);
            String user     = (String)noteObj.get("username");
            if(user.equals(userName))
            {
                m_NotesJsonArray.remove(i);
                ifFound = true;
            }
        }
        if(ifFound)
            writeToJsonFile();
        else
            System.out.println("Unable to delete note");
    }

    public ArrayList<Notes> getAllNotes()
    {
        ArrayList<Notes> noteList = new ArrayList<Notes>();
        for(int i = 0; i < m_NotesJsonArray.size();i++)
        {
            Notes nm = new Notes();
            JSONObject notes = (JSONObject) m_NotesJsonArray.get(i);
            nm.username =(String)notes.get("username");
            nm.date =(String)notes.get("date");
            nm.time =(String)notes.get("time");
            nm.content =(String)notes.get("note");
            nm.index   = (String)notes.get("index");
            noteList.add(nm);
        }
        return noteList;
    }


    private void writeToJsonFile()
    {
        try
        {
            FileWriter jsonFileWriter = new FileWriter(m_jsonFile);
            jsonFileWriter.write(m_NotesJsonArray.toJSONString());
            jsonFileWriter.flush();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private  JSONArray m_NotesJsonArray;
    private  String    m_jsonFile;
}
