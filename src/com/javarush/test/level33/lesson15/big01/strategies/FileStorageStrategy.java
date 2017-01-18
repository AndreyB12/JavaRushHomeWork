package com.javarush.test.level33.lesson15.big01.strategies;

/**
 * Created by butkoav on 16.01.2017.
 */
public class FileStorageStrategy implements StorageStrategy
{
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private long bucketSizeLimit = 1000;
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
        if (size == 0) return null;
        int i = indexFor(hash(key), table.length);
        if (table[i] != null)
        {
            FileBucket fb = table[i];
            for (Entry e = fb.getEntry(); e != null; e = e.next)
            {
                if (e.key.equals(key)) return e;
            }
        }
        return null;
    }

    void resize(int newCapacity)
    {
        FileBucket[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == Integer.MAX_VALUE)
        {
            threshold = Integer.MAX_VALUE;
            return;
        }

        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        for (FileBucket fb : table)
        {
            fb.remove();
        }
        table = newTable;
        threshold = (int) Math.min(newCapacity * loadFactor, Integer.MAX_VALUE);
    }

    void transfer(FileBucket[] newTable)
    {
        int newCapacity = newTable.length;
        for (FileBucket fb : table)
        {
            Entry e = fb.getEntry();
            while (null != e)
            {
                Entry next = e.next;

                e.hash = null == e.key ? 0 : hash(e.key);

                int i = indexFor(e.hash, newCapacity);
                if (newTable[i] == null) newTable[i] = new FileBucket();
                e.next = newTable[i].getEntry();
                newTable[i].putEntry(e);
                e = next;
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex)
    {
        if ((null != table[bucketIndex]) &&
                (table[bucketIndex].getFileSize() >= bucketSizeLimit))
        {
            resize(table.length << 1);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }

        createEntry(hash, key, value, bucketIndex);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex)
    {
        if (table[bucketIndex] == null) table[bucketIndex] = new FileBucket();
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        size++;
    }

    public long getBucketSizeLimit()
    {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit)
    {
        this.bucketSizeLimit = bucketSizeLimit;
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
            if (table[i] != null)
                for (Entry e = table[i].getEntry(); e != null; e = e.next)
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
            if (null != table[i])
                for (Entry e = table[i].getEntry(); e != null; e = e.next)
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
