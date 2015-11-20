package com.tricy.model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tricy.util.RestUtil;

public class ChanceReader {
	protected String encode = "GB2312";
	//public Integer[] se = {2006001,2006154, 2007001, 2007153, 2008001, 2008154, 2009001, 2009154
	//	       , 2010001, 2010153, 2011001, 2011153, 2012001, 2012154, 2013001, 2013097};
	public Integer[] se = {2014001,2014004};
	public static List<Chance> chances = new ArrayList<Chance>();
	public Chance getChance(String issue)
	{
		String content = null;
		try {
			content = RestUtil.getHTML(
					"http://www.17500.cn/ssq/details.php?issue="+issue, 
							 encode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int add = 7;
		int rs = content.indexOf("红球出球顺序为");
		if(rs == -1)
		{
			rs = content.indexOf("红球出球顺序 ");
		}
		if(rs == -1)
		{
			rs = content.indexOf("红球出球顺序");
			add = 6;
		}
		if(rs == -1)
		{
			rs = content.indexOf("出球顺序： ");
			add = 6;
		}
		if(rs == -1)
		{
			rs = content.indexOf("出球顺序：");
			add = 5;
		}
		String rstring = content.substring(rs+add, rs+add+17);
		int bs = content.indexOf("color=blue>");
		String bstring = content.substring(bs + 11, bs + 13);
		String result = issue + " " + rstring + " " + bstring;
		String[] keys = result.split(" ");
		Chance chance = new Chance(keys[0]
								   ,keys[1]
								   ,keys[2]
				                   ,keys[3]
								   ,keys[4]
								   ,keys[5]
								   ,keys[6]
								   ,keys[7]);
		System.out.println(chance);
		return chance;
	}
	
	public void readAll() throws IOException
	{
		String filePath = "C:\\eclipse-cismon\\ws-cismon\\TricyMath\\src\\com\\tricy\\data\\chance.data";
        File output = new File(filePath);
        BufferedOutputStream out = 
                new BufferedOutputStream(new FileOutputStream(output));
		for(int i=0;i<se.length;i+=2)
		{
			for(int j = se[i];j<=se[i+1];j++)
			{
				Chance c = null;
				try{
					c = getChance(j+"");
				}
				catch(Exception e)
				{
					c = new Chance(j+"");
					System.out.println("missing " + j);
				}
				chances.add(c);
				
				out.write((c.toString()+ "\n").getBytes());
				out.flush();
			}
		}
        out.close();
	}
	
	public static void main(String[] args) throws Exception
	{
		ChanceReader cr = new ChanceReader();
		cr.readAll();
	}
}
