package hu.bme.mit.train.controller;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Tachograph {
    Table<Integer, String, Integer> Tachodata = HashBasedTable.create();




    public void record(int time,int refspeed,int step){

        Tachodata.put(time,"speed",refspeed);
        Tachodata.put(time,"step",step);

    }
    public Table<Integer,String,Integer> data(){
        return Tachodata;
    }



}
