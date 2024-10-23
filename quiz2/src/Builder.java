/**
 * Builder interface to define design methods for designing classes.
 */
public interface Builder {
    /**
     * Designs the walls of classroom and writes the results to output file.
     * @param classroom    Information about the classroom.
     * @param wallDecorate Information about the decoration of walls.
     * @param outputFile   Path of the output file.
     */
    void designWalls(String classroom,String wallDecorate,String outputFile);

    /**
     * Designs the floor of the classroom and writes the results to output file.
     * @param classroom     Information about the classroom.
     * @param floorDecorate Information about the decoration of floor.
     * @param outputFile    Path of the output file.
     */
    void designFloors(String classroom,String floorDecorate,String outputFile);

    /**
     * Calculates the area of the walls of the classroom.
     * @param classroom Information about the classroom.
     * @return          The area of the walls.
     */
    double getAreaForWall(String classroom);

    /**
     * Calculates the area of the floor of the classroom.
     * @param classroom Information about the classroom.
     * @return          The area of the floor.
     */
    double getAreaForFloor(String classroom);
}
