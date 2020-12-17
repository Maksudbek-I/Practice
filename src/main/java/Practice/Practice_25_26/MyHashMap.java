package Practice.Practice_25_26;

import java.util.ArrayList;
import java.util.Iterator;

public class MyHashMap<K,V> implements HashMapInterface<K,V>{

    private final ArrayList<ArrayList<Sample<K,V>>> mapList;
    private static final int size = 10;
    private Sample<K,V> temp = new Sample<>();

    public MyHashMap() {
        mapList=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mapList.add(new ArrayList<>());
        }
    }


    @Override
    public void add(K key, V value) {
        int index = key.hashCode() % mapList.size();
        if(mapList.get(index).size()==0){
            mapList.get(index).add(new Sample<>(key,value));
        }
        else {
            for(int i = 0; i < mapList.get(index).size(); i++)
            {
                Sample<K,V> sample = mapList.get(index).get(i);
                if((key.hashCode() == sample.getKey().hashCode())&&(value==sample.getValue()))
                {
                    break;
                }
               if (i == mapList.get(index).size() - 1){
                   mapList.get(index).add(new Sample<>(key,value));
               }
            }
        }

    }



    @Override
    public V get(K key) {
        if(getSample(key) != null)
            return getSample(key).getValue();
        else return null;
    }


    @Override
    public V remove(K key) {
        if (getSample(key) != null) {
            V value = get(key);
            mapList.get(key.hashCode() % mapList.size()).remove(getSample(key));
            return value;
        }
        return null;
    }


    private Sample<K,V> getSample (K key){
        int index = key.hashCode()%mapList.size();
        for (int i = 0; i < mapList.get(index).size(); i++) {
            if(key.hashCode()==mapList.get(index).get(i).getKey().hashCode())
                return mapList.get(index).get(i);
        }
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return new CustomIterator();
    }

    public class CustomIterator implements Iterator<V>{
        private int curIndArr = 0, curIndVal = 0;

        @Override
        public boolean hasNext() {
            if (curIndVal == mapList.get(curIndArr).size()) {
                curIndVal = 0;
                curIndArr++;
                while (curIndArr < mapList.size() && mapList.get(curIndArr).size() == 0) {
                    curIndArr++;
                }
            }
            return curIndArr < mapList.size();
        }

        @Override
        public V next() {
            return mapList.get(curIndArr).get(curIndVal++).getValue();
        }
    }
}
