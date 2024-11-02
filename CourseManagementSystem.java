public class CourseManagementSystem {
    public static void main(String[] args) {
        DoublyCircularLinkedList studentList = new DoublyCircularLinkedList();
        
        studentList.addStudent("John Doe", "S001", 10);
        studentList.addStudent("Jane Smith", "S002", 11);
        studentList.addStudent("Emily Johnson", "S003", 10);
        
        studentList.addCourse("S001", "Math");
        studentList.addCourse("S001", "Science");
        studentList.addCourse("S002", "History");
        
        int studentGrade = 11;

        System.out.println("Students in grade " + studentGrade + ":");
        studentList.displayStudentsByGradeLevel(studentGrade);

        studentList.removeStudent("S002");

        studentList.sortStudentsByGradeLevel();

        studentList.moveToTop("S003");
    }
}
