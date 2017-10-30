package com.cosc1578;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import org.apache.commons.cli.*;


public class Main implements Comparable {
   
public static void main(String[] args)

{
        MyList main = new MyList();
        //System.out.println("\n test 1");
        Options options = new Options();
        Option typeOpt1 = Option.builder("t")
                           .longOpt("type")
                           .hasArg()
                           .numberOfArgs(1)
                           .required(true)
                           .build();
        
         options.addOption(typeOpt1);

         Option keyOpt2 = Option.builder("k")
                            .longOpt("key")
                            .hasArg()
                            .numberOfArgs(1)
                            .required(true)
                            .build();
       
          options.addOption(keyOpt2);

        Option listOpt3 = Option.builder("l")
                            .longOpt("list")
                            .hasArgs()
                            .valueSeparator(' ')
                            .required(true)
                            .build();
        
          options.addOption(listOpt3);

        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine cmd;
        //System.out.println("\n test 2");
    try{
            cmd = commandLineParser.parse(options, args);
            //System.out.println("\n test 3");
  } 
        catch (ParseException e) 
        {
            e.printStackTrace();
            System.exit(1);
            return;
        }

        String t = cmd.getOptionValue("type");
        String[] stringElements = cmd.getOptionValues("list");
        
        if(t.equals("i"))
         { //System.out.println("\n test 4");
            int K = Integer.parseInt(cmd.getOptionValue("key"));
            Integer[] integerElements = new Integer[stringElements.length];
            
             for(int i = 0; i < stringElements.length; i++)
              { 
               integerElements[i] = Integer.parseInt(stringElements[i]);
              } 
               
          BinSearch(integerElements, K);
       
           }
        
      else if(t.equals("s"))
        { 
            String K = cmd.getOptionValue("key");
            BinSearch(stringElements, K);
        }
        
      else
        {
            System.out.println("wrong type value entered");
            System.exit(1);
        }

 }

 public int compareTo(Object o) {
        return 0;
    }

public static void BinSearch(Comparable[] aList,Comparable key)
   {
        //System.out.println("\n test 5");
       
        int len=aList.length; int d;int result=-1;
        
        int s=0; int e=len-1;
       
        
     
   while (s<=e) {
			
			int middle = (s + e)/2;
                         
                                                
                         if(aList[middle].compareTo(key) > 0)
                        {   e = middle - 1;
                             
                        }				
 

			else if (aList[middle].compareTo(key) < 0) {
				s = middle + 1;
			}

			 else {
				result=middle;
                                break;
			}
			
			//System.out.println("\n test 6"); 
                            
		}
                           

            
            if(result>=0)
          {   //System.out.println("\n test 7");  
             System.out.println("\n"+1);
          }
            
           else
             System.out.println("\n"+0);
		
 
    }
}
