
public class Lab3 {
    public static void main(String[] args) {

        SinglyLinkedList singleList = new SinglyLinkedList();
        singleList.addFirst(1, "CS 110", 3, "Mohammed");// 1
        singleList.addFirst(2, "CYS 111", 3, "Ali");// 21
        singleList.addLast(3, "CIS 112", 3, "Sami");// 213
        singleList.addAtPosition(2, 5, "AI 113", 3, "Nasser");// 2513
        singleList.addAtPosition(3, 4, "CS 220", 4, "Abdullah");// 25413
        singleList.display();
        System.out.println("----------------");
        singleList.removeNode(3);// 2513
        singleList.display();
        System.out.println("----------------");
        singleList.removeFirst();// 513
        singleList.display();
        System.out.println("----------------");
        System.out.println("Node Number of ID 5: " + singleList.findNode(5));        
        System.out.println("*****************************");
        

    }
}

class SinglyLinkedList {

    private class Course {
        private int courseID;
        private String courseName;
        private int courseCredit;
        private String instructor;
        private Course next;

        public Course(int courseID, String courseName, int courseCredit, String instructor, Course next) {
            this.courseID = courseID;
            this.courseName = courseName;
            this.courseCredit = courseCredit;
            this.instructor = instructor;
            this.next = next;
        }

        public int getCourseID() {
            return courseID;
        }

        public String getCourseName() {
            return courseName;
        }

        public int getCourseCredit() {
            return courseCredit;
        }

        public String getInstructor() {
            return instructor;
        }

        public Course getNext() {
            return next;
        }

        public void setCourseID(int courseID) {
            this.courseID = courseID;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public void setCourseCredit(int courseCredit) {
            this.courseCredit = courseCredit;
        }

        public void setInstructor(String instructor) {
            this.instructor = instructor;
        }

        public void setNext(Course next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Course{" + "courseID=" + courseID + ", courseName=" + courseName + ", courseCredit=" + courseCredit
                    + ", instructor=" + instructor + '}';
        }
    }

    private Course head;
    private Course tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public void addFirst(int courseID, String courseName, int courseCredit, String instructor) {
        Course newCourse = new Course(courseID, courseName, courseCredit, instructor, null);
        if (head == null) {
            head = newCourse;
            tail = newCourse;
        } else {
            newCourse.setNext(head);
            head = newCourse;
        }
        size++;
    }

    public void addLast(int courseID, String courseName, int courseCredit, String instructor) {
        Course newCourse = new Course(courseID, courseName, courseCredit, instructor, null);
        if (head == null) {
            head = newCourse;
            tail = newCourse;
        } else {
            tail.setNext(newCourse);
            tail = newCourse;
        }
        size++;
        
    }

    public void addAtPosition(int nodeNum, int courseID, String courseName, int courseCredit, String instructor) {
        if (nodeNum == 1) {
            addFirst(courseID, courseName, courseCredit, instructor);
        } else {
            Course current = head;
            Course prev = null;
            int counter = 1;
            while (counter < nodeNum) {
                prev = current;
                current = current.getNext();
                counter++;
            }
            Course newCourse = new Course(courseID, courseName, courseCredit, instructor, null);
            prev.setNext(newCourse);
            newCourse.setNext(current);
            size++;
        }        
    }

    public void removeFirst() {        
        head = head.getNext();
        size--;
    }

    public void removeNode(int nodeNum) {
        if (nodeNum == 1) {
            removeFirst();
        } else {
            Course current = head;
            Course prev = null;
            int counter = 1;
            while (counter < nodeNum) {
                prev = current;
                current = current.getNext();
                counter++;
            }
            prev.setNext(current.getNext());
            size--;
        }        
    }

    public void display() {
        Course current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }    

    public int findNode(int courseID) {
        Course current = head;
        int counter = 1;
        while (current != null) {
            if (current.getCourseID() == courseID) {
                return counter;
            }
            current = current.getNext();
            counter++;
        }
        return -1;
    }
}