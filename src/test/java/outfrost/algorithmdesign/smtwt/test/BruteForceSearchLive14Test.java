package outfrost.algorithmdesign.smtwt.test;

import outfrost.algorithmdesign.smtwt.Job;
import outfrost.algorithmdesign.smtwt.JobOrder;
import outfrost.algorithmdesign.smtwt.bruteforce.BruteForceSearch;
import outfrost.algorithmdesign.smtwt.util.SmallwstLoader;

import java.io.IOException;
import java.util.Arrays;

public class BruteForceSearchLive14Test extends Test {
	
	@Override
	public void run() {
		System.out.println("Running live data test with brute force search...");
		System.out.println("14-job smallWST instance");
		
		try {
			JobOrder jobs = SmallwstLoader.load("data/smallwst/data14.txt");
			
			JobOrder expectedOrder = new JobOrder(Arrays.asList(
				jobs.get(5),
				jobs.get(0),
				jobs.get(1),
				jobs.get(3),
				jobs.get(11),
				jobs.get(4),
				jobs.get(7),
				jobs.get(8),
				jobs.get(2),
				jobs.get(10),
				jobs.get(13),
				jobs.get(9),
				jobs.get(6),
				jobs.get(12)
			));
			// TODO
			System.out.println("Initial sequence:");
			System.out.println(jobs.toString());
			System.out.println("Expected result:");
			System.out.println(expectedOrder.toString());
			
			jobs = BruteForceSearch.findSolution(jobs);
			
			System.out.println("Solution:");
			System.out.println(jobs.toString());
			
			if (!jobs.equals(expectedOrder)) {
				System.err.println("BruteForceSearch4JobTest: The result did not match the expected sequence");
			}
		} catch (IOException e) {
			System.err.println("Error loading problem instance: " + e.getMessage());
		} finally {
			System.out.println();
		}
	}
	
}
