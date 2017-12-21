package outfrost.algorithmdesign;

import java.io.FileInputStream;
import java.io.IOException;

public class TabuSearchLive40Test extends Test {
	
	@Override
	public void run() {
		System.out.println("Running live data test with tabu search...");
		System.out.println("40-job instance # " + (DynamicSearchLive40Test.instanceIndex + 1));
		
		JobOrder jobs = null;
		try {
			jobs = JobOrderLoader.load(new FileInputStream("wt40.txt"), 125, DynamicSearchLive40Test.instanceIndex);
			
			TabuSearch tabuSearch = new TabuSearch(jobs);
			
			System.out.println("Initial sequence:");
			System.out.println(jobs.toString());
			
			tabuSearch.sort();
			
			System.out.println("After initial heuristic sort:");
			System.out.println(jobs.toString());
			
			tabuSearch.findSolution();
			
			System.out.println("Solution:");
			System.out.println(jobs.toString());
		} catch (IOException e) {
			System.err.println("Error loading problem instance: " + e.getMessage());
		} finally {
			System.out.println();
		}
	}
	
}
