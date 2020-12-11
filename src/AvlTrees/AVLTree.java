package AvlTrees;

public class AVLTree {

    private class AVLNode {
        int value;
        int height;
        AVLNode leftChild;
        AVLNode rightChild;

        public AVLNode(int value){
            this.value = value;
        }

    }

    AVLNode root;

    public void insert(int value){
      root =  insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value){
        if(root == null){
            return new AVLNode(value);
        }
       else if(value <= root.value){
            root.leftChild = insert(root.leftChild, value);

        }
        else {
          root.rightChild = insert(root.rightChild, value);
        }

        root.height = Math.max(height(root.rightChild), height(root.leftChild)) + 1;

       return balance(root);

    }

    private AVLNode balance(AVLNode root){
        if(isRightHeavy(root) ){
            if(balanceFactor(root.rightChild) > 0){
               root.rightChild = rightRotate(root.rightChild);
                return leftRotate(root);

            }
            else if(balanceFactor(root.rightChild) < 0){
                return leftRotate(root);
            }
            System.out.println(root.value + " is right heavy");
        }
        else if(isLeftHeavy(root)){
            if(balanceFactor(root.leftChild) < 0){
               root.leftChild = rightRotate(root.leftChild);
                leftRotate(root);

            }
            else if(balanceFactor(root.rightChild) > 0){
                return rightRotate(root);
            }
            System.out.println(root.value + " is left heavy");

        }
        return root;
    }

    private AVLNode leftRotate(AVLNode root){
        AVLNode newRoot = root.rightChild;
        if(newRoot.leftChild != null){
            root.rightChild = newRoot.leftChild;
        }
        newRoot.leftChild = root;
        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rightRotate(AVLNode root){
        AVLNode newRoot = root.leftChild;
        if(newRoot.rightChild != null){
            root.leftChild = newRoot.rightChild;
        }
        newRoot.rightChild = root;
        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node){
        node.height = Math.max(height(node.rightChild), height(node.leftChild)) + 1;
    }

    private boolean isLeftHeavy(AVLNode root){
         return balanceFactor(root) > 1;
    }

    private boolean isRightHeavy(AVLNode root){
        return balanceFactor(root) < -1;
    }

    private int balanceFactor(AVLNode root){
       return root == null ? 0 : height(root.leftChild ) - height(root.rightChild);
    }

    private int height(AVLNode node){
        return (node == null) ? -1  : node.height;
    }
}
