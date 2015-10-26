/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muni.fi.dp.jz.batchchunkex;

import javax.batch.api.chunk.ItemProcessor;

/**
 *
 * @author Zorz
 */
public class StringProcessor implements ItemProcessor{
    StringBuffer buffer = new StringBuffer();
    String temp;

    @Override
    public Object processItem(Object o) throws Exception {
        if (o == null){
            return null;
        }
        buffer.setLength(0);
        buffer.append(o);
        return buffer.reverse().toString();
    }        
}
