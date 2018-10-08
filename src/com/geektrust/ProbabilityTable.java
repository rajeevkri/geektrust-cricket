package com.geektrust;

import java.util.HashMap;
import java.util.Map;

public class ProbabilityTable {
	public static Map<String, double[]> table;
	
	static {
		table = new HashMap<String, double[]>();
        table.put("Kirat Boli", (new double[] { 0.05, 0.3, 0.25, 0.10, 0.15, 0.01, 0.09, 0.05 }));
        table.put("N.S  Nodhi", (new double[] { 0.10, 0.4, 0.2, 0.05, 0.10, 0.01, 0.04, 0.10 }));
        table.put("R Rumarah", (new double[] { 0.20, 0.3, 0.15, 0.05, 0.05, 0.01, 0.04, 0.20 }));
        table.put("Shashi Henra", (new double[] { 0.30, 0.25, 0.05, 0.0, 0.05, 0.01, 0.04, 0.30 }));
	}
    
    public ProbabilityTable()
    {
        
    }
}
