package com.wkk.demo.algo.learn.hashtable;


/**
 * @Description 散列表实现
 * @Author Wangkunkun
 * @Date 2020/8/9 15:35
 */
public class HashTable<K, V> {

    /**
     * 散列表默认长度
     */
    private static final int DEFAULT_INIT_LENGTH = 8;

    /**
     * 散列表默认装载因子
     */
    private static final float DEFAULT_LOAD_FACTORY = 0.75f;

    /**
     * 装载因子
     */
    private float loadFactory;

    /**
     * 散列表数据数量
     */
    private int size = 0;

    /**
     * 散列表使用的数组位置数
     */
    private int use = 0;

    private Entry<K, V>[] table;


    public HashTable() {
        table = new Entry[DEFAULT_INIT_LENGTH];
        this.loadFactory = DEFAULT_LOAD_FACTORY;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        if(table[hash] == null) {
            // 创建哨兵节点
            table[hash] = new Entry<>(null, null, null);
        }
        Entry<K, V> entry = table[hash];
        if(entry.next == null) {
            entry.next = new Entry(key, value, null);
            size ++;
            use ++;
            // 检查是否需要扩容
            if(use > table.length * loadFactory) {
                resize();
            }
        }else {
            // 检查是否key已经存在，存在就替换value
            Entry<K, V> next = entry.next;
            while (next != null) {
                if(next.key.equals(key)) {
                    next.value = value;
                    return;
                }
                next = next.next;
            }
            Entry temp = entry.next;
            entry.next  = new Entry<>(key, value, temp);
            size ++;
        }
    }

    public V get(K key) {
        int hash = hash(key);
        Entry<K, V> kvEntry = table[hash];
        if(kvEntry == null || kvEntry.next == null) {
            return null;
        }
        while (kvEntry.next != null) {
            kvEntry = kvEntry.next;
            if(kvEntry.key.equals(key)) {
                return kvEntry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int hash = hash(key);
        Entry<K, V> headNode = table[hash];
        if(headNode == null || headNode.next == null) {
            return;
        }
        Entry pre = headNode;
        Entry kvEntry = headNode.next;
        while (kvEntry != null) {
            if(kvEntry.key.equals(key)) {
                pre.next = kvEntry.next;
                size --;
                if(headNode.next == null) {
                    use --;
                }
                return;
            }
            pre = kvEntry;
            kvEntry = kvEntry.next;
        }
    }

    private void resize() {
        Entry<K, V>[] oldTable = this.table;
        table = new Entry[2 * oldTable.length];
        use = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if(oldTable[i] == null || oldTable[i].next == null) {
                continue;
            }
            Entry<K, V> e = oldTable[i];
            while (e.next != null) {
                e = e.next;
                int hash = hash(e.key);
                if(table[hash] == null) {
                    table[hash] = new Entry<>(null,null, null);
                    use ++;
                }
                table[hash].next = new Entry<>(e.key, e.value, table[hash].next);
            }
        }
    }

    /**
     * 散列函数
     * <p>
     * 参考hashmap散列函数
     *
     * @param key
     * @return
     */
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) % table.length;
    }

    class Entry<K, V>{
        private K key;

        private V value;

        private Entry next;

        public Entry(K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.remove("1");
        hashTable.put("1", "1");
        hashTable.put("2", "2");
        hashTable.put("3", "4");
        hashTable.put("4", "4");
        hashTable.put("5", "5");
        hashTable.put("6", "6");
        hashTable.put("7", "7");
        hashTable.put("8", "8");
        System.out.println("get 1: " +hashTable.get("1"));
        hashTable.put("1", "100");
        System.out.println("get 1: " +hashTable.get("1"));
        hashTable.put("9", "100");
        hashTable.put("11", "100");
        hashTable.put("111", "100");
        hashTable.put("1111", "100");
        System.out.println("get 2: " + hashTable.get("2"));
        hashTable.remove("2");
        System.out.println("get 2: " + hashTable.get("2"));
        hashTable.remove("2");
    }
}
