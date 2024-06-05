public class Lab11 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        tree.insert(40);
        tree.insert(22);
        tree.insert(23);
        tree.insert(24);
        tree.insert(25);

        System.out.println("-PreOrder Traversal:");
        tree.preOrder(tree.getRoot());
        System.out.println("\n-InOrder Traversal:");
        tree.inOrder(tree.getRoot());
        System.out.println("-PostOrder Traversal:");
        tree.postOrder(tree.getRoot());

        System.out.println("Size of Binary Search Tree:" + tree.getSize());

        System.out.println("\nMinimum Node Value: " + tree.findMin(tree.getRoot()));
        System.out.println("Maximum Node Value: " + tree.findMax(tree.getRoot()));

        if (tree.find(tree.getRoot(), 10) != null) {
            System.out.println("\nValue Found\n");
        } else {
            System.out.println("\nValue Not Found\n");
        }

        tree.delete(tree.getRoot(), 10);
        System.out.println("-PreOrder Traversal after Deleting:");
        tree.preOrder(tree.getRoot());
        System.out.println("Size of Binary Search Tree after Deleting:" + tree.getSize());

        System.out.println("\nDepth:" + tree.depth(25));        
    }
}

class BinarySearchTree {
    class BinaryTreeNode {
        private int value;
        private BinaryTreeNode leftChild;
        private BinaryTreeNode rightChild;
        private BinaryTreeNode parent;

        public BinaryTreeNode(int value, BinaryTreeNode leftChild, BinaryTreeNode rightChild, BinaryTreeNode parent) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.parent = parent;
        }

        public int getValue() {
            return value;
        }

        public BinaryTreeNode getLeftChild() {
            return leftChild;
        }

        public BinaryTreeNode getRightChild() {
            return rightChild;
        }

        public BinaryTreeNode getParent() {
            return parent;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setLeftChild(BinaryTreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(BinaryTreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public void setParent(BinaryTreeNode parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    private BinaryTreeNode root;
    private int size;

    BinarySearchTree() {
        root = null;
        size = 0;
    }

    BinaryTreeNode getRoot() {
        return root;
    }

    int getSize() {
        return size;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    void insert(int Value) {
        BinaryTreeNode newNode = new BinaryTreeNode(Value, null, null, null);
        if (isEmpty()) {
            root = newNode;
            size++;
            System.out.println(Value + " Added to Binary Search Tree");
            return;
        }
        BinaryTreeNode current = root;
        BinaryTreeNode parent;
        while (true) {
            parent = current;
            if (Value == current.value) {
                System.out.println("Duplicate Found");
                return;
            } else if (Value < current.value) {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = newNode;
                    break;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = newNode;
                    break;
                }
            }
        }
        newNode.parent = parent;
        size++;
        System.out.println(Value + " Added to Binary Search Tree");
    }

    BinaryTreeNode find(BinaryTreeNode node, int Value) {
        if (node == null) {
            System.out.println("Searching Fail");
            return null;
        }
        if (node.value == Value) {
            return node;
        }
        if (Value < node.value) {
            return find(node.leftChild, Value);
        } else {
            return find(node.rightChild, Value);
        }
    }

    BinaryTreeNode findMin(BinaryTreeNode node) {
        if (isEmpty()) {
            System.out.println("Empty Binary Search Tree");
            return null;
        }
    
        while (node.leftChild != null)
            node = node.leftChild;
    
        return node;
    }
    
    BinaryTreeNode findMax(BinaryTreeNode node) {
        if (isEmpty()) {
            System.out.println("Empty Binary Search Tree");
            return null;
        }
    
        while (node.rightChild != null)
            node = node.rightChild;
    
        return node;
    }

    void delete(BinaryTreeNode node, int Value) {
        BinaryTreeNode current, parent;
        current = find(node, Value);

        if (current == null) {
            System.out.println("Not found");
            return;
        }
        size--;

        if (current.leftChild == null && current.rightChild == null) {
            parent = current.parent;
            if (parent.value > current.value)
                parent.leftChild = null;
            else
                parent.rightChild = null;

        } else if (current.leftChild == null || current.rightChild == null) {
            parent = current.parent;
            if (parent.value > current.value) {
                if (current.leftChild != null)
                    parent.leftChild = current.leftChild;
                else
                    parent.leftChild = current.rightChild;
            } else {
                if (current.rightChild != null)
                    parent.rightChild = current.rightChild;
                else
                    parent.rightChild = current.leftChild;
            }
        } else {
            BinaryTreeNode minNode = findMin(current.rightChild);
            current.value = minNode.value;
            size++;
            delete(minNode, minNode.value);
        }

    }

    void inOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.leftChild);
        System.out.println(node.value);
        inOrder(node.rightChild);
    }

    void preOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }
    
    void postOrder(BinaryTreeNode node) {
            if (node == null) {
                return;
            }
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.println(node.value);
        }

    int depth(int value) {
        BinaryTreeNode node = root;
        int currentDepth = 0;
    
        while (node != null) {
            if (value == node.value) {
                return currentDepth;
            } else if (value < node.value) {
                node = node.leftChild;
            } else {
                node = node.rightChild;
            }
            currentDepth++;
        }    
        return -1; 
    }     

}