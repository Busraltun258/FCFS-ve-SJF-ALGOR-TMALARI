package com.mycompany.grup_32_sjf;

import java.util.Scanner;

public class Grup_32_sjf {

    public static void main(String[] args) {
        int burst_time[],proses[],waiting_time[],turntime[],i,j,n,total=0,pos,temp;
float wait_avg,turntime_avg;
Scanner s = new Scanner(System.in);
 
System.out.print("Proses sayisi giriniz: ");
n = s.nextInt();
 
proses = new int[n];
burst_time = new int[n];
waiting_time = new int[n];
turntime= new int[n];
 
System.out.println("\nProses calisma suresini giriniz:");
for(i=0;i<n;i++)
{
System.out.print("\nProses["+(i+1)+"]: ");
burst_time[i] = s.nextInt();
proses[i]=i+1; 
}
 

for(i=0;i<n;i++)
{
pos=i;
for(j=i+1;j<n;j++)
{
if(burst_time[j]<burst_time[pos])
pos=j;
}
 
temp=burst_time[i];
burst_time[i]=burst_time[pos];
burst_time[pos]=temp;
 
temp=proses[i];
proses[i]=proses[pos];
proses[pos]=temp;
}

waiting_time[0]=0;

for(i=1;i<n;i++)
{
waiting_time[i]=0;
for(j=0;j<i;j++)
waiting_time[i]+=burst_time[j];
total+=waiting_time[i];
}
 

wait_avg=(float)total/n;
total=0;
 
System.out.println("\nProses\t Burst Time \tWaiting Time\tTurnaround Time");
for(i=0;i<n;i++)
{
turntime[i]=burst_time[i]+waiting_time[i]; 
total+=turntime[i];
System.out.println("\n p"+proses[i]+"\t\t "+burst_time[i]+"\t\t "+waiting_time[i]+"\t\t "+turntime[i]);
}
 

turntime_avg=(float)total/n;
System.out.println("\n\nOrtalama bekleme zamani: "+wait_avg);
System.out.println("\nOrtalama donus süresi: "+turntime_avg);
 
}
    }

