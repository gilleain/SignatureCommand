package signaturecommand;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.ParseException;

import signature.SymmetryClass;
import signature.simple.SimpleGraph;
import signature.simple.SimpleGraphSignature;

public class App {
	
	public static void main(String[] args) {
		ArgumentHandler argumentHandler = parse(args);
		String graphString = argumentHandler.getGraphString();
		
		SimpleGraph graph = new SimpleGraph(graphString);
		SimpleGraphSignature signature = new SimpleGraphSignature(graph);
		
		if (argumentHandler.isCalculateSymmetryClasses()) {
			int height = argumentHandler.getHeight();
			for (SymmetryClass symmetryClass :  signature.getSymmetryClasses(height)) {
				List<Integer> elements = new ArrayList<>();
				for (int element : symmetryClass) { elements.add(element + 1); }
				System.out.println(elements + " " + symmetryClass.getSignatureString());
			}
		}
		
		if (argumentHandler.isCalculateCanonicalSignature()) {
			System.out.println("Canonical Signature:");
			System.out.println(signature.getMaximalSignature());
		}
	}
	
	private static ArgumentHandler parse(String[] args) {
		try {
			return new ArgumentHandler(args);
		} catch (ParseException pe) {
			System.err.println(pe.getMessage());
			System.exit(1);
			return null;
		}
	}

}
