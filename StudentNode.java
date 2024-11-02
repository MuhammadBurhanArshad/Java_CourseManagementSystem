class StudentNode {
    String name;
    String studentId;
    int gradeLevel;
    DynamicArray courses;
    StudentNode next;
    StudentNode prev;

    public StudentNode(String name, String studentId, int gradeLevel) {
        this.name = name;
        this.studentId = studentId;
        this.gradeLevel = gradeLevel;
        this.courses = new DynamicArray(5); 
    }
}


