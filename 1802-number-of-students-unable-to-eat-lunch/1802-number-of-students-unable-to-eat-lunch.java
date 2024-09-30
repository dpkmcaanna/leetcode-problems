class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circularSandwiches = 0;
        int squareSandwiches = 0;
        int studentsForCircular = 0;
        int studentForSquare = 0;
        int totalStudent = students.length - 1;
        
        while(totalStudent >= 0) {
            if(students[totalStudent--] == 0) {
                studentsForCircular++;
            } else {
                studentForSquare ++;
            }
        }

        for(int i = 0; i < sandwiches.length; i++) {
            if(sandwiches[i] == 0 && studentsForCircular == 0) {
                return studentForSquare;
            }

            if(sandwiches[i] == 1 && studentForSquare == 0) {
                return studentsForCircular;
            }

            if(sandwiches[i] == 0) {
                studentsForCircular--;
            } else {
                studentForSquare--;
            }
        }

        return 0;
    }
}