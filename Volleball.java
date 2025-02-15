
public class Volleyball implements Athlete{
    private String coachName = "Steven";
    private String trainingSchedule = "once a week";

    
    public void train() {
        System.out.println("Training sessions are " + trainingSchedule + ".");
    }
    public void playGame() {
        System.out.println("Playing a volleyball match!");
    }
    public GAMES getGame() {
        return GAMES.VOLLEYBALL;
    }   
    public String getCoachName() {
        return coachName;
    }
}

