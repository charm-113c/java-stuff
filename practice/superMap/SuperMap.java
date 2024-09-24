package superMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.Iterator;

/**
 * A super map is a map whose values are, instead of singular values, a list of values.
 * Create a class SuperMap whose keys and values are a generic type; its methods will be:
 * -put(k, v) which associates a value to a given key
 * -putAll(SuperMap) which adds all elements of a super map to the current super map
 * -removeAll(SuperMap) which does the opposite
 * -get(k) which outputs the key's values
 * -values() which outputs all the super map's values
 * -valueSet() which outputs all the super map's values (without duplicates)
 * -get(k, p) which outputs k's values that satisfy the predicate p
 * -transformToSuperMap which outputs a super map whose pairs (k, v) are transformed to 
 * (k, z) according to a function (k, v) -> z (z can be a different type from v)
 * -mapEach which replaces all values of v with values v' of the same type as v according 
 * to a function (k, v) -> v'
 * -the class will be iterable over its pairs (k, v) through an inner class Element 
 */
public class SuperMap<K, V> implements Iterable<superMap.SuperMap.Element<K, V>>{
    private Map<K, Element<K, V>> map;

    public SuperMap() {
        map = new HashMap<K, Element<K, V>>();
    }

    public static class Element<K, V>{
        private K key;
        private Collection<V> values;
        public Element(K key, Collection<V> values) {
            this.key = key;
            this.values = values;
        }
        public K getKey() { return key; }
        public Collection<V> getValues() { return values; }
    }

    @Override
    public Iterator<Element<K, V>> iterator() {
        return new Iterator<Element<K, V>>() {
            private Iterator<K> iter = map.keySet().iterator();
            @Override
            public boolean hasNext() { return iter.hasNext(); }
            @Override
            public Element<K, V> next() { return map.get(iter.next()); }
        };
    }

    public void put(K key, V v) {
        Element<K, V> elem = null;
        if (map.containsKey(key)) {
            elem = map.get(key);
        } else {
            elem = new Element<K, V>(key, new HashSet<V>());
        }
        elem.getValues().add(v);
        map.put(key, elem);
    }

    public <Z> SuperMap<K, Z> transformToSuperMap(BiFunction<K, V, Z> f) {
        SuperMap<K, Z> ret = new SuperMap<K, Z>();

        Iterator<Element<K, V>> iter = this.iterator();
        while (iter.hasNext()) {
            Element<K, V> elem = iter.next();
            K key = elem.getKey();
            Collection<V> vals = elem.getValues();
            for (V val : vals) {
                Z z = f.apply(key, val);
                ret.put(key, z);
            }
        }

        return ret;
    }
}
