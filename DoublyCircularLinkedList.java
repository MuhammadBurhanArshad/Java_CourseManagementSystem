class DoublyCircularLinkedList {
    StudentNode head;
    StudentNode tail;

    public void addStudent(String name, String studentId, int gradeLevel) {
        StudentNode newStudent = new StudentNode(name, studentId, gradeLevel);
        if (head == null) {
            head = newStudent;
            tail = newStudent;
            head.next = head;
            head.prev = head;
        } else {
            tail.next = newStudent;
            newStudent.prev = tail;
            newStudent.next = head;
            head.prev = newStudent;
            tail = newStudent;
        }
    }

    public void removeStudent(String studentId) {
        StudentNode current = head;
        do {
            if (current.studentId.equals(studentId)) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                    head.prev = tail;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = head;
                    head.prev = tail;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                break;
            }
            current = current.next;
        } while (current != head);
    }

    public void addCourse(String studentId, String course) {
        StudentNode current = head;
        do {
            if (current.studentId.equals(studentId)) {
                current.courses.add(course);
                break;
            }
            current = current.next;
        } while (current != head);
    }

    public void removeCourse(String studentId, String course) {
        StudentNode current = head;
        do {
            if (current.studentId.equals(studentId)) {
                current.courses.remove(course);
                break;
            }
            current = current.next;
        } while (current != head);
    }

    public void displayStudentsByGradeLevel(int gradeLevel) {
        StudentNode current = head;
        do {
            if (current.gradeLevel == gradeLevel) {
                System.out.println("Name: " + current.name + ", ID: " + current.studentId);
            }
            current = current.next;
        } while (current != head);
    }

    public void sortStudentsByGradeLevel() {
        if (head == null) return;

        boolean swapped;
        do {
            swapped = false;
            StudentNode current = head;

            do {
                StudentNode nextNode = current.next;
                if (current.gradeLevel > nextNode.gradeLevel) {
                    // Swap gradeLevel, name, and studentId between nodes
                    int tempGrade = current.gradeLevel;
                    current.gradeLevel = nextNode.gradeLevel;
                    nextNode.gradeLevel = tempGrade;

                    String tempName = current.name;
                    current.name = nextNode.name;
                    nextNode.name = tempName;

                    String tempId = current.studentId;
                    current.studentId = nextNode.studentId;
                    nextNode.studentId = tempId;

                    swapped = true;
                }
                current = current.next;
            } while (current != head);
        } while (swapped);
    }

    public void moveToTop(String studentId) {
        StudentNode current = head;
        do {
            if (current.studentId.equals(studentId)) {
                if (current == head) return;

                // Adjust tail if needed
                if (current == tail) {
                    tail = current.prev;
                }

                // Remove current node from its place
                current.prev.next = current.next;
                current.next.prev = current.prev;

                // Insert current node at the head
                current.next = head;
                current.prev = tail;
                head.prev = current;
                tail.next = current;
                head = current;

                break;
            }
            current = current.next;
        } while (current != head);
    }
}
