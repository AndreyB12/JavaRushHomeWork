package com.javarush.test.level33.lesson15.big01.strategies;

/**
 * Created by butkoav on 16.01.2017.
 */
public class OurHashMapStorageStrategy implements StorageStrategy
{
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    int hash(Long k)
    {
        return k.hashCode();
    }

    int indexFor(int hash, int lenth)
    {
        return hash & (lenth - 1);
    }

    Entry getEntry(Long key)
    {
        if(size==0) return null;
        int i = indexFor(hash(key), table.length);
        if (table[i] != null)
        {
            for (Entry e = table[i]; e != null; e = e.next)
            {
                if (e.key == key) return e;
            }
        }
        return null;
    }

    void resize(int newCapacity)
    {
      /*  Entry[] newEntrs = new Entry[newCapacity];
        transfer(newEntrs);
        table = newEntrs;
        threshold = (int) (newCapacity * loadFactor);
*/
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == Integer.MAX_VALUE)
        {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int) Math.min(newCapacity * loadFactor, Integer.MAX_VALUE );
    }

    void transfer(Entry[] newTable)
    {
      /*  for (int i = 0; i < table.length; i++)
        {
            for (Entry e = table[i]; e != null; e = e.next)
            {
                int k = indexFor(e.hashCode(), newTable.length);
                Entry en = newTable[k];
                newTable[k] = e;
                e.next = en;
            }
        }*/
        int newCapacity = newTable.length;
        for (Entry e : table)
        {
            while (null != e)
            {
                Entry next = e.next;

                e.hash = null == e.key ? 0 : hash(e.key);

                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex)
    {
        if ((size >= threshold) && (null != table[bucketIndex])) {
            resize(2 * table.length);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }

        createEntry(hash, key, value, bucketIndex);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex)
    {
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        size++;
    }


    @Override
    public boolean containsKey(Long key)
    {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value)
    {
        for (int i = 0; i < table.length; i++)
        {
            for (Entry e = table[i]; e != null; e = e.next)
            {
                if (e.getValue().equals(value)) return true;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value)
    {
        if (containsKey(key)) getEntry(key).value = value;
        else
        {
            int h = hash(key);
            addEntry(h, key, value, indexFor(h, table.length));
        }
    }

    @Override
    public Long getKey(String value)
    {
        for (int i = 0; i < table.length; i++)
        {
            for (Entry e = table[i]; e != null; e = e.next)
            {
                if (e.getValue().equals(value)) return e.getKey();
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key)
    {
        return getEntry(key).getValue();
    }
}
