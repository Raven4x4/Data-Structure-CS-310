public class Lab4 {

    public static void main(String[] args) {

        CircularLinkedList cirularList = new CircularLinkedList();
        cirularList.addFirst(1, "CIS 110", 3, "Abdullah");// 1
        cirularList.addFirst(2, "CYS 111", 3, "Ahmed");// 21
        cirularList.addLast(3, "AI 112", 3, "Hassan");// 213
        cirularList.addAtPosition(2, 4, "CS 220", 4, "Ali");// 2413
        cirularList.addAtPosition(3, 5, "CS 221", 4, "Sami");// 24513
        System.out.println("Nodes:");
        cirularList.display();// 24513    
        System.out.println("----------------");

        //rotate method: rotates the first node to be the last node     
        System.out.println("First rotate:");    
        cirularList.rotate();// 45132
        cirularList.display();
        System.out.println("----------------");
        System.out.println("Second rotate:");
        cirularList.rotate();// 51324
        cirularList.display();
        System.out.println("----------------");
        
        System.out.println("Remove Node with CourseID 3:");
        cirularList.removeNode(3);// 5124
        cirularList.display();
        System.out.println("----------------");
        System.out.println("Remove First Node:");
        cirularList.removeFirst();// 124
        cirularList.display();
        System.out.println("----------------");

        System.out.println("node of ID 4: " + cirularList.findNode(4));       
        System.out.println("*******************");
    }

}

class CircularLinkedList {

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

    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(int courseID, String courseName, int courseCredit, String instructor) {
        Course newCourse = new Course(courseID, courseName, courseCredit, instructor, null);
        if (head == null) {
            head = newCourse;
            tail = newCourse;
            tail.setNext(head);
        } else {
            newCourse.setNext(head);
            head = newCourse;
            tail.setNext(head);
        }
        size++;
    }

    public void addLast(int courseID, String courseName, int courseCredit, String instructor) {
        Course newCourse = new Course(courseID, courseName, courseCredit, instructor, null);
        if (head == null) {
            head = newCourse;
            tail = newCourse;
            tail.setNext(head);
        } else {
            tail.setNext(newCourse);
            tail = newCourse;
            tail.setNext(head);
        }
        size++;
    }

    public void addAtPosition(int nodeNum, int courseID, String courseName, int courseCredit, String instructor) {
        if (nodeNum == 1) {
            addFirst(courseID, courseName, courseCredit, instructor);
        } else if (nodeNum == size) {
            addLast(courseID, courseName, courseCredit, instructor);
        } else {
            Course newCourse = new Course(courseID, courseName, courseCredit, instructor, null);
            Course current = head;
            int counter = 1;
            while (counter < nodeNum - 1) {
                current = current.getNext();
                counter++;
            }
            newCourse.setNext(current.getNext());
            current.setNext(newCourse);
            size++;
        }
    }

    public void removeFirst() {
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            tail.setNext(head);            
        }
        size--;
    }
    

    public void removeNode(int courseID) {
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Course current = head;
            Course previous = null;
            while (current != null) {
                if (current.getCourseID() == courseID) {
                    if (current == head) {
                        head = head.getNext();
                        tail.setNext(head);
                    } else if (current == tail) {
                        tail = previous;
                        tail.setNext(head);
                    } else {
                        previous.setNext(current.getNext());
                    }
                    size--;
                    break;
                }
                previous = current;
                current = current.getNext();
            }
        }        
    }

    public void display() {
        Course current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
            if (current == head) {
                break;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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

    // rotate method: rotates the first node to be the last node
    public void rotate() {
        
        if (!isEmpty()) {
            head = head.getNext();
            tail = tail.getNext();
        }            
        
    }
}
