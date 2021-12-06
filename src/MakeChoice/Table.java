package MakeChoice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Table {

    public static HashMap<Integer, HashMap<Positions, String>> combinaitionsNoAnte =
            new HashMap<Integer, HashMap<Positions, String>>();

    public static Positions[] positionsByNumber = new Positions[] { Positions.SMALL_BLIND, Positions.BUTTON, Positions.CUTOFF,
       Positions.HJ, Positions.MP_PLUS_1, Positions.MP, Positions.UTG_PLUS_1, Positions.UTG };

    public static HashMap<Integer, HashMap<Positions, String>> getTable(){

        HashMap<Positions, String> combinationsPerPositions = new HashMap<Positions, String>();
        int i = 0;
        int currentBlind = 0;
        try {
            String line;
            BufferedReader fichier = new BufferedReader(new FileReader("External/PushOrFold/NoAnte.txt"));
            StringBuilder tempRes = new StringBuilder();
            while ((line = fichier.readLine()) != null) {
                if(line.length() == 0){
                    combinationsPerPositions.put(positionsByNumber[i], tempRes.toString());
                    i++;
                    tempRes = new StringBuilder();
                }
                else if(line.contains("---")){
                    currentBlind++;
                    combinaitionsNoAnte.put(currentBlind, combinationsPerPositions);
                    combinationsPerPositions = new HashMap<Positions,String>();
                    i = 0;
                }
                else {
                    tempRes.append(line).append("\n");
                }
           // System.out.println(line);
            }
            fichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return combinaitionsNoAnte;
    }

}
