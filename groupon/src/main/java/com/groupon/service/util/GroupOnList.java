package com.groupon.service.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

public class GroupOnList<E> implements RandomAccess, Cloneable, java.io.Serializable{
	
	private String[] listData;
    private int listSize = 0;
     
    public GroupOnList(){
    	listData = new String[10];
    }
     
    public Object get(int index){
        if(index < listSize){
            return listData[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public String[] getAll(){  
    	//if(listSize > 0)
    		//Arrays.sort(listData);
            return Arrays.stream(listData)
                    .filter(s -> (s != null && s.length() > 0))
                    .toArray(String[]::new);        
    }
     
    public void add(String obj){
        if(listData.length-listSize <= 5){
            increaseListSize();
        }
        listData[listSize++] = obj;
    }
     
    public String remove(int index){
        if(index < listSize){
        	String obj = listData[index];
            listData[index] = null;
            int tmp = index;
            while(tmp < listSize){
                listData[tmp] = listData[tmp+1];
                listData[tmp+1] = null;
                tmp++;
            }
            listSize--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
         
    }
    
    public void updateByName(String oldName, String newName){
    	for (int i=0; i < listSize; i++) {
    		if(oldName.equalsIgnoreCase(listData[i])){
    			listData[i] = newName;
    		}
    	}         
    }
    
    public void removeByName(String name){
    	for (int i=0; i < listSize; i++) {
    		if(name.equalsIgnoreCase(listData[i])){
    			remove(i);
    		}
    	}         
    }
     
    public int size(){
        return listSize;
    }
     
    private void increaseListSize(){
        listData = Arrays.copyOf(listData, listData.length*2);        
    }     
    
    
   
}



