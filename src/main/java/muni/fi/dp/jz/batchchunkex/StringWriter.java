/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muni.fi.dp.jz.batchchunkex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.List;
import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemWriter;
import javax.inject.Inject;

/**
 *
 * @author Zorz
 */
public class StringWriter implements ItemWriter{
    private BufferedWriter writer;
    private int lineNumber;
    
    @Inject
    @BatchProperty
    private String filename;

    @Override
    public void open(Serializable srlzbl) throws Exception {
        writer = new BufferedWriter(new FileWriter(new File(filename)));
    }

    @Override
    public void close() throws Exception {
       writer.close();
    }

    @Override
    public void writeItems(List<Object> list) throws Exception {
        for (Object line : list){
            writer.write(line + "\n");
        }
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
       return lineNumber;
    }
    
}
