/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingmodel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ****************************************************************************
 * Compilation: javac Wget.java Execution: java Wget url Dependencies: In.java
 * Out.java
 *
 * Reads in a URL specified on the command line and saves its contents in a file
 * with the given name.
 *
 * % java Wget http://introcs.cs.princeton.edu/java/data/codes.csv
 *
 *****************************************************************************
 */
class In {

    private String url;

    In(String url) {
        this.url = url;
    }

    public String readAll() throws MalformedURLException, IOException {
        URL oracle = new URL(this.url);

        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
        String resp = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            resp += inputLine;
            System.out.println(inputLine);
        }
        in.close();
        return resp;
    }
}

class Out {

    private String filename;

    Out(String name) {
        this.filename = name;
    }

    public void println(String data) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(this.filename), "utf-8"))) {
            writer.write(data);
        }
    }
    
    public void close(){
        
    }
}

public class Wget {

    public static void main(String[] args) throws IOException {

        // read in data from URL
        //String url = args[0];
        String url = "http://introcs.cs.princeton.edu/data/codes.csv";

        In in = new In(url);
        String data = in.readAll();

        System.out.println(data);

        // write data to a file
        String filename = url.substring(url.lastIndexOf('/') + 1);
        Out out = new Out(filename);
        out.println(data);
        out.close();
    }

}
