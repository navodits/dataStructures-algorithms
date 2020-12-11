package Trie;

import java.util.NoSuchElementException;

public class Trie {

    private Node root = new Node(' ');


  private class Node {
        char value;
        Node[] children = new Node[26];
        boolean isEndOfWord;

        public Node(char value){
            this.value = value;
        }
  }

  public void insert(String word){
      Node current = root;
      word = word.toLowerCase();

      char[] arrayOfChars = word.toCharArray();
      for(char chr : arrayOfChars) {
          int index = chr - 'a';
          if(current.children[index] == null ||  current.children[index].value != chr ){
              current.children[index] = new Node(chr);
          }
          current = current.children[index];
      }
      current.isEndOfWord = true;
  }

  public boolean contains(String word){
      Node current = root;
      if(word == null){
          return false;
      }

      char[] chars = word.toCharArray();
      for(char chr : chars){
        int index = chr - 'a';
        if(current.children[index] == null){
            return false;
        }
        if(current.children[index].value == chr){
              current = current.children[index];
        }
        else return false;
      }
      if(current.isEndOfWord == true){
          return true;
      }
      return false;
  }

  public void traverse(){
    traverse(root);
  }

  private void traverse(Node root){

      for(Node child: root.children){
          if(child == null){
              return;
          }
          traverse(child);
      }

  }

  public void remove(String word){
      Node current = root;
      if(contains(word)){
          traverse(current);

          if(current.isEndOfWord == true ){

              if(current.children != null){
                  current.isEndOfWord = false;
              }
              else {
                  current = null;
              }
          }

          else{
              throw new NoSuchElementException();
          }
      }

  }
}
