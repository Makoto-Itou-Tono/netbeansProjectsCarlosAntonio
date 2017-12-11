/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apirequest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;//para los errores que puede haber en la conneccion
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 *
 * @author tonyc
 */
public class ApiRequest {

    String summary;
    String icon;

    /**
     * @param args the command line arguments
     */
    public void cargar(String latitude, String longitude) {
        
        try {
            URL url = new URL("https://api.darksky.net/forecast/3227da5b6733f2ba31aba9edcc632b77/"+latitude+",%20"+longitude);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed: HTTP error code:  " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));//se guarda el archivo que vamos a leer
            String output = "";
            String jsonData = "";
            JSONParser parser = new JSONParser();
            while ((output = br.readLine()) != null) {
//                System.out.println(output);
                jsonData += output;
            }
            Object object = parser.parse(jsonData);
            JSONObject jObject = (JSONObject) object;
//            Double latitude = (Double) jObject.get("latitude");
//            Double longitude = (Double) jObject.get("longitude");
//            String timeZone = jObject.get("timezone").toString();
//            System.out.println("latitude: " + latitude);
//            System.out.println("longitude: " + longitude);
//            System.out.println("timeZone: " + timeZone);
            /* Sub arreglo donde estan los datos de Currently */
            JSONObject jObject2 = (JSONObject) object;
            JSONObject currently = (JSONObject) jObject2.get("currently");
            this.summary = (String) currently.get("summary");
            this.icon = (String) currently.get("icon");
//            System.out.println("Currently: " + currently);
//            System.out.println("Summary: " + summary);
//            System.out.println("Icon: " + icon);
            System.out.println(icon);

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Error en MalformedURLException" + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error en IOException" + ex.getMessage());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error en ParseException" + ex.getMessage());
        }
    }
    public String summary(){
        return this.summary;
    }
    public String icon(){
        return this.icon;
    }

    public static void main(String[] args) {
        
    }

}
