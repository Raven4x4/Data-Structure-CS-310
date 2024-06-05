public class Lab5 {

    public static void main(String[] args) {
        CircularDoubleLinkedList list = new CircularDoubleLinkedList();

        // addfirst
        list.addFirst(1, "Java", 3, "Ali"); // 1
        list.addFirst(2, "C++", 3, "Ahmed"); // 21
        list.addFirst(3, "C#", 3, "Mohammed"); // 321
        System.out.println("nodes after using addFirst:");
        list.forwardDisplay();
        System.out.println("-----------------------");

        // addlast
        list.addLast(2, "PHP", 3, "Sadiq"); // 3212
        list.addLast(4, "Ruby", 3, "Mahdi"); // 32124
        list.addLast(5, "Python", 3, "Abdullah"); // 321245
        System.out.println("nodes after using addLast:");
        list.forwardDisplay();
        System.out.println("-----------------------");

        // addatposition
        System.out.println("nodes after using addAtPosition:");
        list.addAtPosition(3, 4, "JavaScript", 3, "Faris"); // 3241245
        list.addAtPosition(5, 2, "Swift", 3, "Nasser"); // 32412245
        list.forwardDisplay();
        System.out.println("-----------------------");

        // removefirst
        list.removeFirst();
        System.out.println("nodes after using removeFirst:"); // 2412245
        list.forwardDisplay();
        System.out.println("-----------------------");

        // removelast
        list.removeLast();
        System.out.println("nodes after using removeLast:"); // 241224
        list.forwardDisplay();
        System.out.println("-----------------------");

        // removenode
        list.removeNode(4);
        System.out.println("nodes after using removeNode:"); // 21224
        list.forwardDisplay();
        System.out.println("-----------------------");

        // forwardDisplay
        System.out.println("nodes after using forwardDisplay:"); // 21224
        list.forwardDisplay();
        System.out.println("||||||||||||||||||||||||||||||||||||||");

        // backwardDisplay
        System.out.println("nodes after using backwardDisplay:"); // 42212
        list.backwardDisplay();
        System.out.println("-----------------------");

        // rotate the nodes
        list.rotate();
        System.out.println("nodes after using rotate:"); // 12242
        list.forwardDisplay();
        System.out.println("-----------------------");

        // findNode
        System.out.println("node with specific ID:"); // 4
        list.findNode(4);
        System.out.println("-----------------------");

        // findDublicate
        System.out.println("dublicate nodes after using findDublicates");
        list.findDublicates();
        System.out.println("-----------------------");

        // findDublicate(ID)
        System.out.println("dublicate nodes with specific ID:");
        list.findDublicateID(1);
        list.findDublicateID(2);

        
        System.out.println("*************************");

    }

}

class CircularDoubleLinkedList {

    private class Course {

        private int courseID;
        private String courseName;
        private int courseCredit;
        private String instructor;
        private Course next;
        private Course prev;

        public Course(int courseID, String courseName, int courseCredit, String instructor, Course next, Course prev) {
            this.courseID = courseID;
            this.courseName = courseName;
            this.courseCredit = courseCredit;
            this.instructor = instructor;
            this.next = next;
            this.prev = prev;
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

        public Course getPrev() {
            return prev;
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

        public void setPrev(Course prev) {
            this.prev = prev;
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

    public CircularDoubleLinkedList() {
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

    // adding new node at first position
    public void addFirst(int courseID, String courseName, int courseCredit, String instructor) {
        Course newCourse = new Course(courseID, courseName, courseCredit, instructor, null, null);
        if (isEmpty()) {
            head = newCourse;
            tail = head;
            newCourse.setNext(head);
            newCourse.setPrev(head);
        } else {
            newCourse.setNext(head);
            newCourse.setPrev(tail);
            head.setPrev(newCourse);
            tail.setNext(newCourse);
            head = newCourse;
        }
        size++;
    }

    // adding new node at last position
    public void addLast(int courseID, String courseName, int courseCredit, String instructor) {
        Course newCourse = new Course(courseID, courseName, courseCredit, instructor, null, null);
        if (isEmpty()) {
            head = newCourse;
            tail = head;
            newCourse.setNext(head);
            newCourse.setPrev(head);
        } else {
            newCourse.setPrev(tail);
            newCourse.setNext(head);
            tail.setNext(newCourse);
            head.setPrev(newCourse);
            tail = newCourse;
        }
        size++;
    }

    // adding new node at specific position
    public void addAtPosition(int nodeNum, int courseID, String courseName, int courseCredit, String instructor) {
        if (nodeNum == 1) {
            addFirst(courseID, courseName, courseCredit, instructor);
        } else if (nodeNum == size) {
            addLast(courseID, courseName, courseCredit, instructor);
        } else {
            Course newCourse = new Course(courseID, courseName, courseCredit, instructor, null, null);
            Course current = head;
            int counter = 1;
            while (counter < nodeNum - 1) {
                current = current.getNext();
                counter++;
            }
            newCourse.setPrev(current);
            newCourse.setNext(current.next);
            current.getNext().setPrev(newCourse);
            current.setNext(newCourse);
            size++;
        }
    }

    // removing the node at first position
    public void removeFirst() {
        if (head == tail) {
            head = null;
            tail = null;
        } else {

            head = head.next;
            tail.setNext(head);
            head.setPrev(tail);
        }
        size--;
    }

    // removing the node at last position
    public void removeLast() {
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.setNext(head);
            head.setPrev(tail);
        }
        size--;
    }

    // removing the node at specific position
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
                        current.getNext().setPrev(previous);
                    }
                    size--;
                    break;
                }
                previous = current;
                current = current.getNext();
            }
        }
    }

    // displaying nodes in forward direction
    public void forwardDisplay() {
        Course current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
            if (current == head) {
                break;
            }
        }
    }

    // displaying nodes in backward direction
    public void backwardDisplay() {
        Course current = tail;
        while (current != null) {
            System.out.println(current);
            current = current.getPrev();
            if (current == tail) {
                break;
            }
        }
    }

    // find a node with specific ID
    public void findNode(int courseID) {

        Course current = head;
        int counter = 1;
        while (current != null) {
            if (current.getCourseID() == courseID) {
                System.out.println("Node with courseID " + courseID + " is found at position " + counter);
                break;
            }
            current = current.getNext();
            counter++;
        }

    }

    // check all the nodes for specific ID and print how many dublicates are there
    public void findDublicateID(int courseID) {
        Course current = head;
        int dublicate = 0;
        do {
            if (current.getCourseID() == courseID) {
                dublicate++;
            }
            current = current.getNext();
        } while (current != head);
        if (dublicate > 1) {
            System.out.println("There is " + dublicate + " dublicates for ID " + courseID);
        } else {
            System.out.println("There is no dublicates for ID: " + courseID);
        }

    }

    // check all the nodes for dublicates
    public void findDublicates() {
        Course current = head;
        Course temp = head.getNext();
        int dublicate = 0;
        boolean anyDublicate = false;
        if (!isEmpty()) {
            do {
                do {
                    if (current.getCourseID() == temp.getCourseID()) {
                        dublicate++;
                    }
                    temp = temp.getNext();
                } while (temp != head);
                if (dublicate != 0) {
                    System.out.println("nodes with same ID is: " + current.toString());
                    anyDublicate = true;
                }
                current = current.getNext();
                temp = current.getNext();
                dublicate = 0;
                
            } while (current != head);
            if (!anyDublicate) {
                System.out.println("There is no dublicates");
            }
        } else {
            System.out.println("The list is empty");
        }
    }

    // rotates the first node to be the last node
    public void rotate() {

        if (!isEmpty()) {
            head = head.getNext();
            tail = tail.getNext();
        }
    }
}
