/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muni.fi.dp.jz.batchchunkex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemReader;
import javax.inject.Inject;

/**
 *
 * @author Zorz
 */
public class StringReader implements ItemReader {
    private BufferedReader lineReader;
    private int lineNumber;
    
    @Inject
    @BatchProperty
    private String filename;

    @Override
    public void open(Serializable srlzbl) throws Exception {
        lineReader = new BufferedReader(new FileReader(new File(filename)));
        if (srlzbl != null) {
            lineNumber = (Integer) srlzbl;
            for (int i = 0; i<lineNumber;i++){
                lineReader.readLine();
            }
        }
    }

    @Override
    public void close() throws Exception {
        lineReader.close();
    }

    @Override
    public Object readItem() throws Exception {
       ++lineNumber;
       String line = lineReader.readLine();
       if (line == null) {
           System.out.println("Returning null");           
       }
       return line;
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return lineNumber;
    }
    
}
