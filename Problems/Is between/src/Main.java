import java.util.Scanner;
class Main {
public static class TeamLead extends Programmer {

    private  final int numTeamLead;

    public  TeamLead(int numTeamLead) {
        super(numTeamLead);
        this.numTeamLead = numTeamLead;

        employ();
    }

    public void employ() {
        System.out.println(numTeamLead + " teamlead");
    }

}

public static class Programmer {

    private final int numProgrammer ;

    public Programmer(int numProgrammer) {
        this.numProgrammer = numProgrammer;
        employ();
    }

    private void employ() {
        System.out.println(numProgrammer + " programmer");
    }
}


    public static void main(String[] args) {
        new TeamLead(1);
    }

}