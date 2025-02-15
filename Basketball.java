
public class Basketball implements Athlete {
    private String coachName = "Osangiri";
    private String trainingSchedule = "three times a week";

    public void train() {
        System.out.println("Training sessions are " + trainingSchedule + ".");
    }

    public GAMES getGamePlayed() {
        return GAMES.BASKETBALL;
    }

    public String getCoachName() {
        return coachName;
    }
}
