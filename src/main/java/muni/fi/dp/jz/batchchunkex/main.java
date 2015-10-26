/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muni.fi.dp.jz.batchchunkex;

import java.util.Properties;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;

/**
 *
 * @author Zorz
 */
public class main {
    public final static void main(String[] args){
        JobOperator operator = BatchRuntime.getJobOperator();
        Properties jobPropertis = new Properties();
        long jobId = operator.start("sample",jobPropertis);
    }
}
