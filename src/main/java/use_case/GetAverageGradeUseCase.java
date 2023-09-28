package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // Get average grade for all students in your team.
        // Initialization
        int totalGrade = 0;
        float avgGrade = 0;
        int num = 0;

        // Get myTeam using gradeDB function getMyTeam()
        Team myTeam = gradeDB.getMyTeam();
        // This is a local String[] for members, and then find the length
        String[] people = myTeam.getMembers();
        int peoplenum = people.length;

        // Find totalGrade
        while (num < peoplenum) {
            totalGrade += gradeDB.getGrade(people[num], course).getGrade();
            num++;
        }
        // Calculate for avgGrade
        avgGrade = totalGrade / num;
        return avgGrade;
    }
}
