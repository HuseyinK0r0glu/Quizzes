/**
 * Director class is responsible for decorating of the classes. It calls the proper builder class to decorate classes.
 */
public class Director {

    /**
     * Designs the walls and floor of the classroom by calling the builder classes.
     * @param builder       The builder class that is responsible for decorating the class.
     * @param classroom     Information about the classroom.
     * @param wallDecorate  Information about the wall decorate.
     * @param floorDecorate Information about the floor decorate.
     * @param outputFile    The path of the output file.
     */
    public void designClassroom(Builder builder,String classroom,String wallDecorate,String floorDecorate,String outputFile){
        builder.designWalls(classroom,wallDecorate,outputFile);
        builder.designFloors(classroom,floorDecorate,outputFile);
    }
}
