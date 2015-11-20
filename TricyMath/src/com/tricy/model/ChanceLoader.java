package com.tricy.model;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class ChanceLoader {
	public void loadFile(String fileName) throws Exception
	{
         File file=new File(fileName);
         if(file.isFile() && file.exists()){ 
             InputStreamReader read = new InputStreamReader(
             new FileInputStream(file));
             BufferedReader bufferedReader = new BufferedReader(read);
             String lineTxt = null;
             while((lineTxt = bufferedReader.readLine()) != null){
            	 String[] keys = lineTxt.split(" ");
                 String issue = keys[0];
                 String r1 = keys[1];
                 String r2 = keys[2];
                 String r3 = keys[3];
                 String r4 = keys[4];
                 String r5 = keys[5];
                 String r6 = keys[6];
                 String b = keys[7];
                 Chance c = new Chance(issue, r1, r2, r3, r4, r5, r6, b);
                 System.out.println(c);
                 ChanceReader.chances.add(c);
             }
             read.close();
         }	
	}
	public static void main(String[] args) throws Exception
	{
		Integer[] redlist = new Integer[34]; 
		for(int i=0;i<=33;i++)
		{
			redlist[i] = 0;
		}
		Integer[] bluelist = new Integer[17]; 
		for(int i=0;i<=16;i++)
		{
			bluelist[i] = 0;
		}
		ChanceLoader cl = new ChanceLoader();
		for(int i = 2003;i<=2014;i++)
		{
			cl.loadFile("C:\\eclipse-cismon\\ws-cismon\\TricyMath\\src\\com\\tricy\\data\\chance-"+i+".data");
		}
		//red ball from 1~33, blue ball from 1~16
		for(Chance c: ChanceReader.chances)
		{
			redlist[c.redBall1]++;
			redlist[c.redBall2]++;
			redlist[c.redBall3]++;
			redlist[c.redBall4]++;
			redlist[c.redBall5]++;
			redlist[c.redBall6]++;
			bluelist[c.blueBall]++;
		}
		System.out.println("red ball:");
		System.out.println("1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t14\t15\t16\t17\t18\t19\t20\t21\t22\t23\t24\t25\t26\t27\t28\t29\t30\t31\t32\t33");
		for(int i=1;i<=33;i++)
		{
			System.out.print(redlist[i]+"\t");
		}
		
		System.out.println("\nblue ball:");
		System.out.println("1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t14\t15\t16");
		for(int i=1;i<=16;i++)
		{
			System.out.print(bluelist[i]+"\t");
		}
		
		Integer[] redRanklist = new Integer[34]; 
		for(int i=0;i<=33;i++)
		{
			redRanklist[i] = 0;
		}
		for(int j=1;j<=33;j++)
		{
			for(int i=1;i<=33;i++)
			{
				if(redlist[i] > redlist[redRanklist[j]])
				{
					boolean isFound = true;
					for(int k=1;k<j;k++)
					{
						if(redRanklist[k]==i)
						{
							isFound = false;
							break;
						}
					}
					if(isFound)
					{
						redRanklist[j] = i;
					}
				}
			}
		}
		
		
		System.out.println("red ball rank:");
		System.out.println("1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t14\t15\t16\t17\t18\t19\t20\t21\t22\t23\t24\t25\t26\t27\t28\t29\t30\t31\t32\t33");
		for(int i=1;i<=33;i++)
		{
			System.out.print(redRanklist[i]+":"+redlist[redRanklist[i]]+"\t");
		}
	}
	
	
}
