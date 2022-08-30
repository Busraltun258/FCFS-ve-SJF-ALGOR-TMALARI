package com.mycompany.grup_32_fcfs;

import java.util.Scanner;

public class Grup_32_fcfs {

    public static void main(String[] args) {
        int i,proses_no, burst_time[], turn_around_time[],waiting_time[];
        float avg_wait=0,avg_turn_around_time=0;
        burst_time=new int[50];
        turn_around_time=new int[50];
        waiting_time=new int[50];
        waiting_time[0]=0;
        Scanner s=new Scanner(System.in);
        System.out.println("Proses sayisi giriniz:");
        proses_no=s.nextInt();
        System.out.println("\nProsesler icin calisma suresi giriniz:");
        
        for(i=0;i<proses_no;i++)
        {
            System.out.println("\tP"+(i+1)+":");
            burst_time[i]=s.nextInt();
        }
        
        for(i=1;i<proses_no;i++)
        {
            waiting_time[i]=waiting_time[i-1]+burst_time[i-1];
            avg_wait+=waiting_time[i];
        }
         avg_wait/=proses_no;
         
        for(i=0;i<proses_no;i++)
        {
            turn_around_time[i]=waiting_time[i]+burst_time[i];
            avg_turn_around_time+=turn_around_time[i];
        }
        avg_turn_around_time/=proses_no;
    System.out.println("\n----------------------------------------------------------");
        System.out.println("\tProses:");
    System.out.println("\n----------------------------------------------------------");
        System.out.println(" Proses\tBurst Time\tWaiting Time\tTurn Around Time");
        
        for(i=0;i<proses_no;i++)
        {
            System.out.println("\tP"+(i+1)+"\t  "+burst_time[i]+"\t\t  "+waiting_time[i]+"\t\t "+turn_around_time[i]);
        }
       System.out.println("\n--------------------------------");
       System.out.println("\nOrtalama beklme zamanı: "+avg_wait);
       System.out.println("\nOrtalama donus zamanı:"+avg_turn_around_time+"\n");
    }
    
    }

