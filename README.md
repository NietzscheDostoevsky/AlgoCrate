
# **AlgoCrate**

**AlgoCrate** is a collection of common algorithms and data structures, inspired by *Algorithms* by Robert Sedgewick and Kevin Wayne. This project provides implementations in Java, Python, and will eventually include C/C++.

## **Features**
- Implementations of fundamental algorithms (sorting, searching, etc.)
- Data structures such as linked lists, stacks, queues, trees, and more
- Easy-to-understand code with detailed explanations and comments
- Cross-language support: Java and Python (with future plans for C/C++)

## **Languages Supported**
- **Java**: All algorithms and data structures are implemented in Java.
- **Python**: Parallel implementations of the same algorithms and data structures in Python.

## **Getting Started**

### **Clone the repository**
```bash
git clone https://github.com/NietzscheDostoevsky/AlgoCrate.git
```

### **Directory Structure**
The project is organized into language-specific directories:

```
AlgoCrate/
│
├── java/           # Java implementations of algorithms and data structures
├── python/         # Python implementations of algorithms and data structures
└── cpp/            # Future C/C++ implementations
```

### **Java Setup**

1. Navigate to the `java/` directory.
2. Use your favorite Java IDE or build tool (e.g., Maven or Gradle) to compile and run the Java files.

### **Python Setup**

1. Navigate to the `python/` directory.
2. Install any dependencies (if needed):
    ```bash
    pip install -r requirements.txt
    ```
3. Run the Python scripts directly.

## **Usage**

### **Java Example**

To use a sorting algorithm (like QuickSort) in Java:

```java
import algocrate.java.sorting.QuickSort;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        QuickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
```

### **Python Example**

To use the same sorting algorithm in Python:

```python
from algocrate.py.sorting import quicksort

array = [5, 2, 9, 1, 5, 6]
quicksort(array)
print(array)
```

## **Contributing**

We welcome contributions! If you'd like to add new algorithms, fix bugs, or improve documentation, feel free to submit a pull request.

### **Steps to contribute:**

1. Fork the repository.
2. Clone your fork to your local machine.
3. Create a new branch (`git checkout -b new-feature`).
4. Make your changes and commit them (`git commit -am 'Add new feature'`).
5. Push to your fork (`git push origin new-feature`).
6. Open a pull request from your fork to the main repository.

## **License**

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
