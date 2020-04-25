package com.java.notebook;
import java.io.*;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;

public class UserManager
{
    public UserManager()
    {
        //read the json
        m_jsonFile = new String();
        m_jsonFile = "users.json";
        m_userJsonArray = new JSONArray();
        JSONParser jsonParser = new JSONParser();
        try
        {
            FileReader jsonFileReader = new FileReader(m_jsonFile);
            m_userJsonArray = (JSONArray) jsonParser.parse(jsonFileReader);
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
    public void create(String username, String password)
    {
        //write the json
        JSONObject newUser = new JSONObject();
        newUser.put("username",username);
        newUser.put("password",password);
        m_userJsonArray.add(newUser);

        writeToJsonFile();
    }
    public void delete (String username)
    {
        //write the json
        for(int i = 0; i < m_userJsonArray.size(); i++)
        {
            JSONObject obj = (JSONObject) m_userJsonArray.get(i);

            if(obj.get("username").equals(username))
            {
                m_userJsonArray.remove(i);
                System.out.println("Removed ");
                break;
            }
        }
        writeToJsonFile();

    }
    public boolean validate(String username,String password)
    {
        boolean retValue = false;
        for(int i = 0; i < m_userJsonArray.size(); i++)
        {
            JSONObject obj = (JSONObject) m_userJsonArray.get(i);
            if(obj.get("username").equals(username) && obj.get("password").equals(password))
            {
                retValue = true;
                break;
            }
        }
        return  retValue;
    }

    private void writeToJsonFile()
    {
        try
        {
            FileWriter jsonFileWriter = new FileWriter(m_jsonFile);
            jsonFileWriter.write(m_userJsonArray.toJSONString());
            jsonFileWriter.flush();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private  JSONArray m_userJsonArray;
    private  String    m_jsonFile;
}
