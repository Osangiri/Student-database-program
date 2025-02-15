
public class StudentAthlete extends Student implements Athlete {
	private GAMES GamePlayed;
	private int GameYear;
	private Athlete sport;
	
	private static final String[] teamNames = {// a little addition for use of arrays 
        "Thunder Spikers", // Volleyball
        "Hoop Legends",    // Basketball
        "Golden Strikers"  // Soccer
    };
	public StudentAthlete(String admissionNumber, String name, String course, String grade, String GamePlayed, int GameYear){
		super(admissionNumber, name, course, grade);
		this.GamePlayed = GAMES.valueOf(GamePlayed.toUpperCase());
		this.GameYear = GameYear;
		switch (this.GamePlayed) {
            case VOLLEYBALL:
                this.sport = new Volleyball();
                break;
            case BASKETBALL:
                this.sport = new Basketball();
                break;
            case SOCCER:
				this.sport = new Soccer();
				break;
            default:
                throw new IllegalArgumentException("Sport not supported!");
        }
	}
	public void displayTeam() {
        String teamName = "";
        switch (GamePlayed) {
            case VOLLEYBALL:
                teamName = teamNames[0];
                break;
            case BASKETBALL:
                teamName = teamNames[1];
                break;
            case SOCCER:
                teamName = teamNames[2];
                break;
        }
        System.out.println("Team: " + teamName);
    }
	public GAMES getGamePlayed(){
		return GamePlayed;
	}
	public int getGameYear(){ 
		return GameYear; 
	}

    public void setGamePlayed(GAMES GamePlayed) { 
		this.GamePlayed = GamePlayed;
	}
    public void GameYear(int GameYear) { 
		this.GameYear = GameYear;
	}
	public void train() {
		System.out.println("Training schedule for " + GamePlayed + " is set.");
		sport.train();
    
}
	public String getCoachName() {
        return sport.getCoachName(); 
    }
	public String toString() {
        return super.toString() + "\nGame Played: " + GamePlayed + "\nYear: " + GameYear;
    }
    
}
	
//https:stackoverflow.com/questions/604424/how-to-get-an-enum-value-from-a-string-value-in-java
