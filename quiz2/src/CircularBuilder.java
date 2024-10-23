/**
 * CircularBuilder class that implements the Builder interface and designs the circular classrooms.
 */
public class CircularBuilder implements Builder{
    private double wallCost;
    private double floorCost;

    /**
     * Designs the walls of circular classrooms and the results to output file.
     * @param classroom    Information about the classroom.
     * @param wallDecorate Information about the decoration of walls.
     * @param outputFile   Path of the output file.
     */
    @Override
    public void designWalls(String classroom,String wallDecorate,String outputFile) {
        double area = getAreaForWall(classroom);
        int price = Integer.parseInt(wallDecorate.split("\t")[3]);
        if(wallDecorate.split("\t")[2].equals("Tile")){
            double numberOfTile = area / Integer.parseInt(wallDecorate.split("\t")[4]);
            numberOfTile = (int) Math.ceil(numberOfTile);
            wallCost = wallCost + (numberOfTile * price);
            FileIO.writeToFile(outputFile,"Classroom " + classroom.split("\t")[1] + " used " + (int)(numberOfTile)
                    + " Tiles for walls ",true,false);
        }else{
            wallCost = wallCost + (area * price);
            FileIO.writeToFile(outputFile,"Classroom " + classroom.split("\t")[1] + " used " + (int) Math.ceil(area) + "m2 of " +
                    wallDecorate.split("\t")[2] + " for walls ",true,false);
        }
        Process.totalMoney += Math.ceil(wallCost);
    }

    /**
     * Designs the floor of circular classrooms and writes the result to output file.
     * @param classroom     Information about the classroom.
     * @param floorDecorate Information about the decoration of floor.
     * @param outputFile    Path of the output file.
     */
    @Override
    public void designFloors(String classroom,String floorDecorate,String outputFile) {
        double area = getAreaForFloor(classroom);
        int price = Integer.parseInt(floorDecorate.split("\t")[3]);
        double numberOfTile = area / Integer.parseInt(floorDecorate.split("\t")[4]);
        numberOfTile = (int) Math.ceil(numberOfTile);
        floorCost = floorCost + (numberOfTile * price);
        FileIO.writeToFile(outputFile,"and used " + (int) numberOfTile + " Tiles for flooring, these costed " +
                (int)Math.ceil(wallCost + floorCost) + "TL.",true,true);
        Process.totalMoney += Math.ceil(floorCost);
    }

    /**
     * Calculates the area of the walls of the circular classroom.
     * @param classroom Information about the classroom.
     * @return          The area of the walls.
     */
    @Override
    public double getAreaForWall(String classroom) {
        String[] classInfo = classroom.split("\t");
        return 2 * Math.PI * Integer.parseInt(classInfo[3])/2 * Integer.parseInt(classInfo[5]);
    }

    /**
     * Calculates the area of the floor of the circular classroom.
     * @param classroom Information about the classroom.
     * @return          The area of the floor.
     */
    @Override
    public double getAreaForFloor(String classroom) {
        String[] classInfo = classroom.split("\t");
        return Math.PI * Integer.parseInt(classInfo[3])/2 * Integer.parseInt(classInfo[4])/2;
    }
}