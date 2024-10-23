/**
 * Main class where the program starts. It read input files and call process method from
 * Process class to process the input file and call necessary methods from there.
 */
public class Main {

    /**
     * main method to start the program.
     * @param args Command line arguments. First to arguments are input files and the last one is output file.
     */
    public static void main(String[] args) {

        // read input files and output file
        String[] items = FileIO.readFile(args[0],true,true);
        String[] decorate = FileIO.readFile(args[1],true,true);
        String outputFile = args[2];

        // process the input files
        Process process = new Process(items,decorate,outputFile);
        process.process();
        // writes the last information
        FileIO.writeToFile(outputFile,"Total price is: " + (int)Math.ceil(Process.totalMoney) + "TL.",true,false);
    }
}