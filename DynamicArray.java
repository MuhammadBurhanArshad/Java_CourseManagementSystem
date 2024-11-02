class DynamicArray {
    int capacity;
    int size;
    String[] data;

    public DynamicArray(int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = 0;
        this.data = new String[capacity];
    }

    public void add(String course) {
        if (size >= capacity) {
            resize();
        }
        data[size++] = course;
    }

    public void remove(String course) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(course)) {
                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j + 1];
                }
                size--;
                break;
            }
        }
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return data[index];
    }

    private void resize() {
        capacity += 5;
        String[] newData = new String[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
