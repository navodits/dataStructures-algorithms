package HashTable;


import java.util.LinkedList;

public class HashTable {
    LinkedList<KeyValue> [] linkedLists = new LinkedList[5];

    public void put(int key, String value){

        int index = getHash(key);
        if(linkedLists[index]==null){
            linkedLists[index] = new LinkedList<>();
        }
        for(var item : linkedLists[index]){
            if(item.key==key){
                item.value = value;
                return;
            }
        }
            linkedLists[index].addLast(new KeyValue(key, value));


    }

    public String get(int key){
        int hashCode = getHash(key);

        if(linkedLists[hashCode] != null) {
            for (var pairs : linkedLists[hashCode]) {
                if (pairs.key == key) {
                    return pairs.value;
                }
            }
        }
        return null;
    }

    public void remove(int key){

        int index = getHash(key);
        if(linkedLists[index] == null) throw new IllegalStateException();

        for (var item: linkedLists[index]){
            if(item.key == key){
                linkedLists[index].remove(item);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private int getHash(int key){
        return key % linkedLists.length;
    }
}
