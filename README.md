# ☕ Java Programming Mastery & Collection Framework

[![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)](LICENSE)
[![Status: Production Ready](https://img.shields.io/badge/Status-Public_Ready-brightgreen?style=for-the-badge)](#)

A comprehensive, clean, and beginner-to-advanced Java repository containing core Object-Oriented Programming (OOP) concepts, a complete master course on the **Java Collection Framework (JCF)**, academic practical programs, and real-world projects.

---

## 📂 Repository Structure

```
java/
│
├── CollectionFramework/       # 🚀 Master Course: Basic to Advanced Collections
│   ├── 01_ArrayList_DeepDive.java
│   ├── 02_LinkedList_ListAndDeque.java
│   ├── 03_Vector_And_Stack.java
│   ├── 04_HashSet_And_LinkedHashSet.java
│   ├── 05_TreeSet_And_NavigableSet.java
│   ├── 06_PriorityQueue_And_Heap.java
│   ├── 07_ArrayDeque_Modern_Queue_Stack.java
│   ├── 08_HashMap_Internals_And_Usage.java
│   ├── 09_LinkedHashMap_And_LRUCache.java
│   ├── 10_TreeMap_And_NavigableMap.java
│   ├── 11_Collections_Utility_Class.java
│   ├── 12_Iterators_And_FailFast.java
│   ├── 13_Concurrent_Collections.java
│   ├── 14_Streams_With_Collections.java
│   ├── 15_RealWorld_MiniProject.java
│   └── README.md              # 📖 Dedicated Collections Guide & Cheat Sheet
│
├── JavaAMS/                   # 📱 Full-Stack Java Attendance Management System
│   └── attendance-system/     # Lightweight HTTP Server + SQLite + QR Code Generator
│
├── MANUAL PR/                 # 📘 Core Lab & Manual Practical Programs
├── Practical exam/            # 📝 Exam Exercises & Package Architecture
│
├── ATM.java                   # 💳 Real-world ATM simulation console application
├── *.java                     # 🎯 Core Java & OOP Concepts (Inheritance, Overloading, etc.)
├── .gitignore                 # 🛡️ Clean ignore rules (classes, DBs, logs, IDE configs)
├── LICENSE                    # 📄 MIT Open-Source License
└── README.md                  # 📑 Repository Documentation
```

---

## 🚀 Java Collection Framework (Course Curriculum)

The `CollectionFramework/` folder is designed as a standalone, step-by-step masterclass:

| Module | Program | Key Topics |
| :--- | :--- | :--- |
| **01** | [`01_ArrayList_DeepDive.java`](CollectionFramework/01_ArrayList_DeepDive.java) | Resizing formula ($1.5\times$), CRUD, `Comparable` vs `Comparator`, `ensureCapacity()`, Array conversions |
| **02** | [`02_LinkedList_ListAndDeque.java`](CollectionFramework/02_LinkedList_ListAndDeque.java) | Node pointer internals, List & Deque double nature, head/tail benchmarks vs `ArrayList` |
| **03** | [`03_Vector_And_Stack.java`](CollectionFramework/03_Vector_And_Stack.java) | Legacy synchronized Vector, Stack LIFO operations, balanced parentheses algorithm |
| **04** | [`04_HashSet_And_LinkedHashSet.java`](CollectionFramework/04_HashSet_And_LinkedHashSet.java) | `hashCode()` & `equals()` contract, mathematical set operations (Union, Intersection, Diff), order preservation |
| **05** | [`05_TreeSet_And_NavigableSet.java`](CollectionFramework/05_TreeSet_And_NavigableSet.java) | Red-Black Tree self-balancing BST, closest matches (`ceiling`, `floor`, `higher`, `lower`), range queries |
| **06** | [`06_PriorityQueue_And_Heap.java`](CollectionFramework/06_PriorityQueue_And_Heap.java) | Min-Heap / Max-Heap, Emergency Room triage simulation, Top-K largest elements algorithm |
| **07** | [`07_ArrayDeque_Modern_Queue_Stack.java`](CollectionFramework/07_ArrayDeque_Modern_Queue_Stack.java) | Circular array buffer, modern replacement for `Stack` and `Queue`, sliding window algorithm |
| **08** | [`08_HashMap_Internals_And_Usage.java`](CollectionFramework/08_HashMap_Internals_And_Usage.java) | Buckets, hash collisions, load factor (0.75), Treeification, `computeIfAbsent`, `merge`, immutable key rules |
| **09** | [`09_LinkedHashMap_And_LRUCache.java`](CollectionFramework/09_LinkedHashMap_And_LRUCache.java) | Insertion-order vs Access-order modes, implementing a production-grade LRU (Least Recently Used) Cache |
| **10** | [`10_TreeMap_And_NavigableMap.java`](CollectionFramework/10_TreeMap_And_NavigableMap.java) | Sorted map lookups, tax bracket range query simulation, `subMap`, `headMap`, `tailMap` |
| **11** | [`11_Collections_Utility_Class.java`](CollectionFramework/11_Collections_Utility_Class.java) | Utility algorithms: `sort`, `binarySearch`, `rotate`, `frequency`, `unmodifiableList`, `synchronizedList` |
| **12** | [`12_Iterators_And_FailFast.java`](CollectionFramework/12_Iterators_And_FailFast.java) | `Iterator` vs `ListIterator`, `modCount` mechanics, solving `ConcurrentModificationException` |
| **13** | [`13_Concurrent_Collections.java`](CollectionFramework/13_Concurrent_Collections.java) | `ConcurrentHashMap` lock-striping, `CopyOnWriteArrayList`, `ArrayBlockingQueue` Producer-Consumer |
| **14** | [`14_Streams_With_Collections.java`](CollectionFramework/14_Streams_With_Collections.java) | Java 8+ Streams: `filter`, `map`, `groupingBy`, `partitioningBy`, `summarizingDouble` |
| **15** | [`15_RealWorld_MiniProject.java`](CollectionFramework/15_RealWorld_MiniProject.java) | End-to-End E-Commerce & Warehouse Inventory Hub integrating all Collections & Streams |

👉 **Read the full [Collection Framework Guide & Big-O Complexity Chart](CollectionFramework/README.md)**.

---

## 🎯 Core Java & OOP Topics

The root workspace contains dedicated standalone programs demonstrating core Java fundamentals:
- **Object-Oriented Programming (OOP)**:
  - Inheritance: `HierarchicalInheritance.java`, `hybridInheritance.java`
  - Polymorphism & Overloading: `overload.java`, `consoverload.java`
  - Method & Constructor Overriding: `override.java`, `consoverride.java`
  - Constructors: `defaultcons.java`, `copycons.java`
  - Abstract Classes & Methods: `abstract_class_method.java`
  - Static Members & Methods: `staticmethod.java`
- **Exception Handling**: Custom user-defined exceptions and validation in `tryp.java`.
- **String Handling**: `StringBufferExample.java`.
- **Flow Control & Loops**: `ContinueStatement.java`, `foreach.java`, `Table.java`.
- **Real-World Console Systems**: `ATM.java` (multi-user PIN verification, deposit, withdrawal, balance checking).

---

## 🛠️ How to Compile & Run

### Prerequisites
- [JDK 17 or higher](https://www.oracle.com/java/technologies/downloads/) installed.
- Verify installation: `javac -version` and `java -version`.

### Running Core Programs
```bash
# Compile and run any root program (e.g. ATM)
javac ATM.java
java ATM
```

### Running Collections Modules
```bash
# Navigate to CollectionFramework
cd CollectionFramework

# Compile and run Module 15 (Real-World Mini Project)
javac 15_RealWorld_MiniProject.java
java RealWorld_MiniProject
```

---

## 🛡️ Privacy & Security Audit

This repository has been fully audited for open-source publication:
- ✅ Zero API keys, passwords, or cloud credentials.
- ✅ All sample data, student records, and user names sanitized with generic placeholders.
- ✅ Database files, temporary runtime QR tokens, and `.class` binaries excluded via `.gitignore`.

---

## 📄 License

This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.
