import java.util.ArrayList;

public class BinarySearchTree {
    private class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    Node root;

    public void insert(int value){

        if(root == null){
            root = new Node(value);
            return;

        }
        Node current = root;

        while(current != null){
            if( value <= current.value && current.leftChild != null){
                current = current.leftChild;


            }
           else if(value <= current.value && current.leftChild == null){
                current.leftChild = new Node(value);
                return;
            }
           else if(value > current.value && current.rightChild != null){
               current = current.rightChild;
            }

            else if(value > current.value && current.rightChild == null){
                current.rightChild = new Node(value);
                return;
            }
        }

    }

    public boolean find(int value){
        Node current = root;

        while(current != null){
            if(value < current.value){
                current = current.leftChild;
            }
            else if( value > current.value){
                current = current.rightChild;
            }
            else if(value == current.value){
                return true;
            }
        }

        return false;
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root == null){
            return -1;
        }
        if (root.leftChild == null && root.rightChild == null){
            return 0;
        }

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min(){
        return minValue(root);
    }

    private int minValue(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if (root.leftChild == null && root.rightChild == null){
            return root.value;
        }
        return Math.min((Math.min(minValue(root.leftChild), minValue(root.rightChild))), root.value);
    }

    public void swap(){
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public boolean equals(BinarySearchTree tree){
        return equals(root, tree.root);

    }

    public boolean equals(Node f, Node s){
        if( f == null && s == null){
            return true;
        }

        else if (f != null && s != null){
            return (f.value == s.value && equals(f.leftChild, s.leftChild) && equals(f.rightChild, s.rightChild));
        }

        return false;
    }

    public boolean validateTree(){
        return validateTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean validateTree(Node root, int min, int max){
        if(root == null){return true ;}
        if( root.value <= min || root.value >= max){
            return false;
        }

        return validateTree(root.leftChild, min, root.value) && validateTree(root.rightChild, root.value, max);

    }

    public void kthNode(int distance){
        kthNode(root, distance);
    }

    private void kthNode(Node root, int dist) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return;
        }
        if (dist == 0) {
            System.out.println(root.value);
            return;
        }
        kthNode(root.leftChild, dist - 1);

        kthNode(root.rightChild, dist - 1);
    }


}
