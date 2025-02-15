public class Soccer implements Athlete{
    private String coachName = "Stacy";
    private String trainingSchedule = "five times a week";

    
    public void train() {
        System.out.println("Training sessions are " + trainingSchedule + ".");
    }
   
    public GAMES getGamePlayed() {
        return GAMES.SOCCER;
    }   
    public String getCoachName() {
        return coachName;
    }
}
