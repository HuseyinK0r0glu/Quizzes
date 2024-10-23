import java.util.HashMap;
import java.util.Map;

/**
 * Process class that manages the input files and calls the director class to design classes.
 */
public class Process {
    String[] items;
    String[] decorate;
    String outputFile;

    // Total cost of decoration
    public static int totalMoney;
    Map<String,String> classrooms = new HashMap<>();
    Map<String,String> decorations = new HashMap<>();

    /**
     * Constructs a Process object with the given input items, decorations, and output file.
     * @param items       First input file that contains information about  the classes and decorations.
     * @param decorations Second input file that contains the decoration information.
     * @param outputFile  The path of the output file.
     */
    public Process(String[] items, String[] decorations, String outputFile) {
        this.items = items;
        this.decorate = decorations;
        this.outputFile = outputFile;
    }

    /**
     * Processes the input files and calls the necessary methods
     */
    public void process(){
        for(int i=0;i<items.length;i++){
            if(items[i].split("\t")[1].contains("C")){
                classrooms.put(items[i].split("\t")[1],items[i]);
            }else{
                decorations.put(items[i].split("\t")[1],items[i]);
            }
        }

        for(int j = 0; j< decorate.length; j++){
            String classId = decorate[j].split("\t")[0];
            String wallDecorate = decorate[j].split("\t")[1];
            String floorDecorate = decorate[j].split("\t")[2];
            if(classrooms.get(classId).split("\t")[2].equals("Circle")){
                Director director = new Director();
                director.designClassroom(new CircularBuilder(),classrooms.get(classId),decorations.get(wallDecorate),decorations.get(floorDecorate),outputFile);
            }else{
                Director director = new Director();
                director.designClassroom(new RectangularBuilder(),classrooms.get(classId),decorations.get(wallDecorate),decorations.get(floorDecorate),outputFile);
            }
        }
    }
}