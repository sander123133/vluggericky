package com.control;

import com.model.Panster;
import com.model.Speler;
import com.model.Wapen;
import com.model.pantsers.DagelijkseKleding;
import com.model.pantsers.GoudenPantser;
import com.model.pantsers.LerenKleding;
import com.model.pantsers.RidderPantser;
import com.model.wapens.HeelendZwaard;
import com.model.wapens.Houtenzwaard;
import com.model.wapens.IJzerenZwaard;
import com.model.wapens.SterkerwordendZwaard;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SaveFileReader {

    public static Speler readSpeler()
    {
        Speler speler = null;
        File file = new File("C:\\Users\\Sander\\AndroidStudioProjects\\vluggericky\\app\\src\\main\\java\\com\\control\\Savefile.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));

        String inputline;
        StringBuilder data = new StringBuilder();
        while((inputline = reader.readLine()) != null)
        {
            data.append(inputline);
        }
        System.out.println(data.toString());
        JSONObject result = null;

            result = new JSONObject(data.toString());
            int geld = result.getInt("geld");
            String wapen_string = result.getString("wapen");
            Wapen wapen = null;
            switch (wapen_string) {
                case "houten zwaard" :
                    wapen = new Houtenzwaard();
                    break;
                case "ijzeren zwaard" :
                    wapen = new IJzerenZwaard();
                    break;
                case "sterkerwordend zwaard" :
                    wapen = new SterkerwordendZwaard();
                    break;
                case "heelend zwaard" :
                    wapen = new HeelendZwaard();
            }

            String pantser_string = result.getString("pantser");
            Panster panster = null;
            switch (pantser_string)
            {
                case "dagelijkse kleding" :
                    panster = new DagelijkseKleding();
                    break;
                case "leren kleding" :
                    panster = new LerenKleding();
                    break;
                case "Ridder pantser" :
                    panster = new RidderPantser();
                case "Gouden pantser" :
                    panster = new GoudenPantser();
            }
            speler = new Speler(100,"", wapen, panster, geld);

        }catch (Exception e) {
            e.printStackTrace();
        }


        return speler;
    }

}
