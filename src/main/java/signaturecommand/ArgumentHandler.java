package signaturecommand;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ArgumentHandler {
	
	private Options options;
	
	private final boolean calculateSymmetryClasses;
	
	private final boolean calculateCanonicalSignature;
	
	private final int height;
	
	private final String graphString;
	
	public ArgumentHandler(String[] args) throws ParseException {
		options = new Options();
		options.addOption(Option.builder().option("s").desc("Output the symmetry classes").build());
		options.addOption(Option.builder().option("c").desc("Output the canonical signature").build());
		options.addOption(Option.builder().option("h").desc("Height of the signature").hasArg().build());
		
		CommandLine commandLine = new DefaultParser().parse(options, args);
		if (commandLine.hasOption('s')) {
			calculateSymmetryClasses = true;
		} else {
			calculateSymmetryClasses = false;
		}
		
		if (commandLine.hasOption('c')) {
			calculateCanonicalSignature = true;
		} else {
			calculateCanonicalSignature = false;
		}
		
		if (commandLine.hasOption('h')) {
			height = Integer.parseInt(commandLine.getOptionValue('h'));
		} else {
			height = -1;
		}
		
		List<String> remainingArgs = commandLine.getArgList();
		if (remainingArgs.size() == 1) {
			graphString = remainingArgs.get(0);
		} else {
			throw new ParseException("Should only have one main argument");
		}
	}

	public boolean isCalculateCanonicalSignature() {
		return calculateCanonicalSignature;
	}

	public int getHeight() {
		return height;
	}

	public String getGraphString() {
		return graphString;
	}

	public boolean isCalculateSymmetryClasses() {
		return calculateSymmetryClasses;
	}

}
