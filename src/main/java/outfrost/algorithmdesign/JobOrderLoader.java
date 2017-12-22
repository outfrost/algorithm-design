package outfrost.algorithmdesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class JobOrderLoader {
	
	public static JobOrder load(int instances, int instanceIndex) throws IOException, NumberFormatException {
		return load(System.in, instances, instanceIndex);
	}
	
	public static JobOrder load(InputStream stream, int instances, int instanceIndex) throws IOException, NumberFormatException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		
		ArrayList<String> lines = new ArrayList<>();
		while (reader.ready()) {
			lines.add(reader.readLine());
		}
		
		reader.close();
		
		ArrayList<String> processingTimes = new ArrayList<>();
		ArrayList<String> weights = new ArrayList<>();
		ArrayList<String> dueTimes = new ArrayList<>();
		
		int instanceLineCount = lines.size() / instances;
		
		for (int i = instanceLineCount * instanceIndex; i < (instanceLineCount * instanceIndex) + (instanceLineCount / 3); i++) {
			processingTimes.addAll(Arrays.asList(lines.get(i).split("( )+")));
			weights.addAll(Arrays.asList(lines.get(i + (instanceLineCount / 3)).split("( )+")));
			dueTimes.addAll(Arrays.asList(lines.get(i + (instanceLineCount / 3) * 2).split("( )+")));
		}
		
		for (int i = 0; i < processingTimes.size(); i++) {
			if (processingTimes.get(i).equals("")) {
				processingTimes.remove(i);
			}
		}
		
		for (int i = 0; i < weights.size(); i++) {
			if (weights.get(i).equals("")) {
				weights.remove(i);
			}
		}
		
		for (int i = 0; i < dueTimes.size(); i++) {
			if (dueTimes.get(i).equals("")) {
				dueTimes.remove(i);
			}
		}
		
		if (processingTimes.size() != weights.size() || processingTimes.size() != dueTimes.size()) {
			throw new IOException("The numbers of entries for processing times, weights and/or due times did not match up.");
		}
		
		JobOrder result = new JobOrder();
		
		for (int i = 0; i < processingTimes.size(); i++) {
			Job job = new Job();
			job.setId(i + 1);
			job.setProcessingTime(Integer.parseInt(processingTimes.get(i)));
			job.setWeight(Integer.parseInt(weights.get(i)));
			job.setDueTime(Integer.parseInt(dueTimes.get(i)));
			result.add(job);
		}
		
		return result;
	}
	
}
