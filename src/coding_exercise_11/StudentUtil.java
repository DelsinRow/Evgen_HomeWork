package coding_exercise_11;

public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {

        for(char[] studentGrades : studentsGrades) {
            if (studentGrades == null) {
                throw new RuntimeException();
            }
        }

        if (studentIdList.length != studentsGrades.length){
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: " + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);
        }

        double[] gpaList = new double[studentIdList.length];

        for (int i = 0; i < studentsGrades.length; i++) {
            double gpa = 0.0;

            for (int j = 0; j < studentsGrades[i].length; j++) {
                if (studentsGrades[i][j] == 'A') {
                    gpa += 4.0;
                } else if (studentsGrades[i][j] == 'B') {
                    gpa += 3.0;
                } else if (studentsGrades[i][j] == 'C') {
                    gpa += 2.0;
                } else if (studentsGrades[i][j] == ' ') {
                    int studentIndexId = i;
                    int studentId = studentIdList[studentIndexId];
                    throw new MissingGradeException("Student " + studentId + " hasn't some grade");
                }
            }

            gpaList[i] = gpa/studentsGrades[i].length;
        }

        return gpaList;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList,
                                         char[][] studentsGrades) throws InvalidDataException {
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        double[] gpaList = new double[studentIdList.length];

        try {
            gpaList = calculateGPA(studentIdList, studentsGrades);
        } catch (MissingGradeException e) {
            throw new InvalidDataException(e);
        }


        int count = 0;
        for (double gpa : gpaList) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i <  gpaList.length; i++) {
            if (gpaList[i] >= lower && gpaList[i] <= higher) {
                result[index++] = studentIdList[i];
            }
        }

        return result;
    }


}