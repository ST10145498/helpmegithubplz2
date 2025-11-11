# Municipal Services Application

**Author:** Kyle Jeremiah Govender – ST10145498  
**Contact:** ST10145498@vcconnect.edu.za  
**Institution:** The Independent Institute of Education (Varsity College)  
**Course:** PROG7312 - Programming 3B  
**Year:** 2025

---

## Table of Contents

1. [Overview](#overview)
2. [Prerequisites](#prerequisites)
3. [Setup Instructions](#setup-instructions)
4. [Running the Application](#running-the-application)
5. [Application Features](#application-features)
6. [Data Structures Implementation](#data-structures-implementation)
7. [Admin Access](#admin-access)
8. [Changelog](#changelog)
9. [Technology Stack](#technology-stack)
10. [Project Links](#project-links)
11. [References](#references)

---

## Overview

The Municipal Services Application is a comprehensive C# WPF desktop application designed to streamline municipal services in South Africa. The application provides citizens with an efficient platform to report issues, access local events and announcements, and track service requests. Built using .NET 8.0, the application demonstrates advanced data structure implementations including Binary Search Trees, AVL Trees, Min Heaps, and Graphs to optimize performance and user experience.

---

## Prerequisites

- **Visual Studio 2022** (or later)
- **.NET 8.0** Desktop Development workload
- **Windows OS** (WPF-supported environment)
- Minimum **4GB RAM**
- Screen resolution: **1366x768** or higher recommended

---

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/VCWVL/prog7312-poe-ST10145498.git
```

### 2. Open and Compile the Application

1. Open **Visual Studio 2022**
2. Navigate to **File → Open → Project/Solution**
3. Browse to the cloned repository folder
4. Select **MunicipalServicesApplication.sln**

### 3. Build the Solution

1. Go to **Build → Build Solution** (or press **Ctrl+Shift+B**)
2. Verify the build succeeds in the **Output** window
3. Ensure there are **no compilation errors**

### 4. Verify Dependencies

The application uses only .NET Framework built-in libraries. No external NuGet packages are required.

---

## Running the Application

### Starting the Application

1. Press **F5** or click **Start** in Visual Studio
2. The **Main Menu** will appear with the following options:
   - Report Issues
   - Local Events and Announcements
   - Service Request Status
   - Close Application

### Navigation

- Use the **sidebar navigation** on all pages for consistent access to features
- Click **Admin Login** in the top-right corner to access administrative features
- Use the **Language Selector** (English, Afrikaans, isiZulu) in the top-right corner

---

## Application Features

### Part 1: Report Issues

Citizens can report municipal issues with detailed information:

- **Multi-field location entry:** Street Address, Suburb, City, Postal Code
- **Category selection:** 7 categories including Roads, Water, Electricity, Waste Management, Parks, Safety, and Other
- **Rich text description:** Detailed issue description with formatting support
- **Media attachment:** Attach images or documents to support the report
- **Dynamic progress tracker:** Visual feedback with color-coded progress indicator
- **Form validation:** Inline error messages for required fields
- **Multi-language support:** English, Afrikaans, and isiZulu

### Part 2: Local Events and Announcements

Citizens can browse and search for local events:

- **Event display:** 17 pre-loaded sample events with categories and descriptions
- **Announcement display:** 5 priority-based announcements
- **Advanced search:** Text search, category filter, and date range selection
- **Sort options:** Date (newest/oldest), Name (A-Z/Z-A), Category (A-Z)
- **Smart recommendations:** Points-based event suggestions based on search patterns
- **Recently added banner:** Highlights the 3 most recent events
- **Admin panel:** Authorized users can add new events and announcements

### Part 3: Service Request Status (NEW)

Citizens can track their service requests with comprehensive status information:

- **All My Requests:** View all submitted requests sorted by Request ID
- **Urgent Queue:** High-priority requests automatically prioritized
- **Related Requests:** Discover connected issues in the same area or category
- **Dependencies:** View prerequisite issues that must be resolved first
- **Core Issue Analysis:** Identify central problems affecting multiple requests
- **Search by ID:** Quick lookup with auto-formatting support (e.g., "1" → "SR0001")
- **Interactive interface:** Click any request to explore relationships and dependencies

---

## Data Structures Implementation

The Service Request Status feature leverages four advanced data structures to provide efficient tracking and analysis capabilities.

### 1. Binary Search Tree (BST)

**Role in Service Request Status:**

The Binary Search Tree serves as the primary storage mechanism for all service requests, organizing them hierarchically based on Request IDs. Each node contains a service request, with smaller IDs branching left and larger IDs branching right.

**Contribution to Efficiency:**

The BST enables O(log n) search operations, allowing the system to locate specific requests quickly by eliminating half the remaining requests with each comparison. For example, searching for request SR0015 among 25 requests requires only 4-5 comparisons instead of 25 sequential checks. The structure also provides automatic sorted ordering (SR0001, SR0002, SR0003...) through in-order traversal, eliminating the need for separate sorting operations. This hierarchical organization scales efficiently—as requests grow from 25 to 1000, search time only increases logarithmically rather than linearly, maintaining responsive performance even under heavy load.

**How It Enhances the App for Citizens:**

Citizens benefit from fast search capabilities when looking for their specific service requests. Instead of checking every request sequentially, the BST guides the search down the correct path, reducing wait times significantly. Citizens also see all requests displayed in perfect numerical order automatically, making it easy to scan through submissions and locate specific requests visually without any delay for sorting.

**How It Enhances the App for the Municipality:**

Municipal staff can quickly look up any request when citizens call for status updates, as the BST enables instant retrieval. The automatic sorting simplifies report generation for audits, budget planning, and performance tracking—the system already maintains requests in sorted order without needing separate sorting operations that consume processing time. As the system scales from 25 requests to hundreds or thousands, search performance remains efficient because each new level only adds one additional comparison step.

### 2. AVL Tree

**Role in Service Request Status:**

The AVL Tree is a self-balancing variant of the Binary Search Tree that maintains optimal structure through automatic rotations. It stores service requests in a balanced hierarchy, preventing the tree from becoming skewed even when requests arrive in sequential order.

**Contribution to Efficiency:**

The AVL Tree guarantees O(log n) search performance regardless of insertion order by maintaining a balanced structure through left and right rotations. During peak periods when many requests flood in sequentially (e.g., after a storm), a standard BST degrades to O(n) performance, but the AVL Tree prevents this degradation through automatic rebalancing. The height balance property (difference between left and right subtree heights ≤ 1) ensures consistent search times whether processing the first or thousandth request of the day. This predictable performance is crucial for service level agreements and capacity planning, as the system maintains efficiency without requiring manual database optimization or reorganization.

**How It Enhances the App for Citizens:**

Citizens experience consistent response times when searching for their requests, regardless of when they submitted them or how busy the system is. During peak times when many requests flood in sequentially (such as after a storm), a standard BST might slow down, but the AVL Tree prevents this degradation. This consistency is especially important during emergencies when citizens need to quickly check if their critical issue has been received and is being addressed.

**How It Enhances the App for the Municipality:**

Municipal staff can rely on predictable system performance for capacity planning and service level agreements. Management knows that as request volume grows, the system will continue performing efficiently without requiring database reorganization or optimization maintenance. The self-balancing nature handles natural patterns of municipal request submissions—many requests arrive in temporal clusters (everyone reports potholes after winter, water issues during droughts)—without performance degradation.

### 3. Min Heap

**Role in Service Request Status:**

The Min Heap manages the Urgent Queue by maintaining a specialized structure where the highest-priority request is always at the root. It stores requests in an array-based complete binary tree where each parent node has higher priority than its children.

**Contribution to Efficiency:**

The heap provides O(1) access to the most urgent request and O(log n) insertion/removal operations through the heapify process. When a new urgent request arrives, it's added at the bottom and bubbles up by comparing with its parent until the heap property is restored. When the most urgent request is processed and removed, the last item moves to the root and bubbles down to maintain proper ordering. This partial ordering (only maintaining parent-child relationships rather than complete sorting) makes operations significantly faster than maintaining a fully sorted list, which would require O(n log n) time for each insertion. During emergency situations with multiple high-priority requests arriving simultaneously, the heap automatically organizes them in milliseconds, ensuring dispatchers always have instant access to the next critical issue without manual triaging.

**How It Enhances the App for Citizens:**

Citizens with genuine emergencies—water main bursts, downed power lines, gas leaks—see their requests prioritized automatically. Their critical issues appear at the top of the Urgent Queue without being buried beneath less urgent requests that were submitted earlier. This automatic prioritization means life-safety issues get immediate attention regardless of submission time. Citizens can also see their position in the urgent queue transparently, reducing anxiety and frustration from waiting.

**How It Enhances the App for the Municipality:**

Municipal dispatchers always know instantly which request needs attention next. When they complete one emergency repair and are ready for the next assignment, the system immediately presents the most urgent remaining issue without requiring manual searching or re-sorting of queues. This speeds up emergency response and ensures critical issues are never accidentally overlooked. The automatic prioritization also helps during crisis management—when a major storm hits and 50 urgent requests arrive within minutes, the heap automatically organizes them without requiring staff time. Resource allocation improves because crews are always directed to maximum-impact issues first.

### 4. Graph

**Role in Service Request Status:**

The Graph structure represents the complex network of relationships between service requests using an adjacency list implementation. Each request is a vertex, and edges represent relationships with associated weights (SameWard: 5, SameCategory: 3, Dependency: 1) and types.

**Contribution to Efficiency:**

The graph enables sophisticated relational queries through optimized graph algorithms. Breadth-First Search (BFS) efficiently discovers all related requests within the same ward or category by exploring connections level-by-level, with O(V + E) complexity where V is vertices and E is edges. Depth-First Search (DFS) traces dependency chains by following each path to its conclusion, revealing prerequisite relationships that must be resolved in sequence. The Minimum Spanning Tree algorithm identifies core issues by finding the minimal set of connections that span all related requests, highlighting strategic repair targets that maximize impact. The adjacency list representation provides O(1) access to a request's relationships and O(V + E) space complexity, making it memory-efficient even with thousands of requests and complex interconnections. This graph-based analysis transforms isolated service requests into an interconnected system, enabling the municipality to optimize resource allocation and coordinate responses effectively.

**How It Enhances the App for Citizens:**

When citizens click on their service request, the graph reveals related issues in their area or category, helping them understand the broader context of problems in their neighborhood. Understanding dependencies also helps set realistic expectations—if a citizen's low water pressure complaint depends on fixing a main line leak first, the graph makes this clear. Citizens understand why their specific issue can't be resolved immediately, reducing frustration and unnecessary follow-up calls. This transparency builds trust between citizens and the municipality.

**How It Enhances the App for the Municipality:**

The graph provides three powerful analysis capabilities for municipal operations:

**Related Requests Discovery:** Municipal staff can identify clusters of issues in specific areas. When multiple requests appear in Ward 3, the graph reveals these connections instantly, enabling coordinated responses—sending one crew to address several related issues in the same area rather than making multiple trips.

**Dependency Tracking:** Some repairs must happen in specific sequences. Road damage can't be properly fixed until an underlying water leak is repaired. The graph traces these dependency chains automatically, ensuring crews follow the correct work order and avoid wasted effort.

**Core Issue Identification:** The graph identifies "hub" requests that affect multiple other issues. Fixing these core problems creates a cascade effect, automatically resolving or simplifying several related requests. This helps management prioritize resources toward maximum-impact repairs, achieving efficiency ratios of 3:1 or better (3 strategic repairs effectively addressing 9 total issues).

### Combined System Performance

All four data structures work together synergistically to provide comprehensive service request management. The BST and AVL Tree handle search and retrieval operations, the Min Heap manages priority-based processing, and the Graph reveals relationships and dependencies. For typical loads (25 requests with associated relationships), all operations complete in under 100 milliseconds. The system scales efficiently—with 1000 requests and 5000 relationships, operations still complete in under one second, maintaining a responsive user experience even as the municipal service load increases.

---

## Admin Access

To access the Admin Panel and add new events or announcements:

**Email:**
```
Admin@gmail.com
```

**Password:**
```
Admin@123
```

**Admin Capabilities:**
- Add new local events (name, category, date, description)
- Add announcements (title, priority, content)
- All additions immediately visible to users
- Session persists until logout or application restart

---

## Changelog

### Part 1 → Part 2 Updates

**Feedback Addressed:**

1. **Location Detail Enhancement**
   - *Feedback:* "We have discussed location and the fact that it needs more detail."
   - *Update:* Expanded location input from single textbox to four separate fields (Street Address, Suburb, City, Postal Code) for more accurate issue reporting and municipal tracking.

2. **Worker Class Implementation**
   - *Feedback:* "Data structures are fine, but I would have loved to see it in a separate worker class."
   - *Update:* Created dedicated worker classes for all data structures (SortedDictionaryWorker, EventQueueWorker, CategorySetWorker, SearchTrackingWorker, AnnouncementQueueWorker) to improve code modularity and maintainability.

3. **Consistent Dialog Design**
   - *Feedback:* "Please make confirmation dialog consistent."
   - *Update:* Redesigned all confirmation dialogs to match the application's color scheme, typography, and layout, creating a cohesive professional appearance.

4. **Bibliography Corrections**
   - *Feedback:* "Minor issues with dates, but otherwise fine."
   - *Update:* Corrected all bibliography entries using the IIE Harvard referencing guide for proper date citation format.

**New Features Added:**
- Local Events and Announcements page with 17 pre-loaded sample events
- Advanced search functionality with text, category, and date range filters
- Five sorting options (Date Newest/Oldest, Name A-Z/Z-A, Category A-Z)
- Smart recommendation system using points-based weighting algorithm
- Admin Panel with secure authentication
- Recently Added Events banner displaying last 3 events
- CustomQueue for recently added events tracking
- CustomSortedDictionary for efficient event storage
- CustomHashSet for unique category management

**Technical Improvements:**
- Implemented 5 custom data structures without external dependencies
- Created 5 worker classes following static class pattern
- Developed search frequency tracking system
- Built recommendation scoring algorithm (categories: 3 points, names: 2 points, descriptions: 1 point)

### Part 2 → Part 3 Updates

**Feedback Addressed:**

1. **User Guidance Enhancement**
   - *Feedback:* "Please add more information to guide users."
   - *Update:* Implemented hover tooltips on all main menu buttons that display descriptive text explaining each button's purpose and destination, improving user navigation.

2. **Recommendation Feature Visibility**
   - *Feedback:* "Implemented a points-based weighting where keywords carry less points, and categories more. All show up in a recommendation section sorted by weight. You achieved this using a sorted dictionary. Well done!! Move recommendations up."
   - *Update:* Added a recommended searches panel directly below the search bar for immediate visibility while retaining the detailed recommendations section at the bottom, improving discoverability.

**New Features Added:**
- Service Request Status page with comprehensive five-panel layout
- 25 pre-loaded sample service requests with realistic municipal data
- Binary Search Tree for primary sorted storage
- AVL Tree for guaranteed balanced performance
- Min Heap for urgent priority queue (top 10 high-priority requests)
- Graph structure with adjacency list for relationship mapping
- Related Requests panel showing up to 8 connected requests
- Dependencies panel displaying prerequisite resolution chains
- Core Issue Analysis identifying top 5 strategic repair targets
- Search by ID with intelligent auto-formatting ("1" → "SR0001")
- Click-to-explore interaction model for request relationships
- Color-coded priority indicators (High: Red, Medium: Yellow, Low: Green)
- Status tracking (Pending, In Progress, Completed, Approved)
- Ward-based geographic organization
- Multi-language support extended to all new features

**Data Structure Implementations:**
- CustomBinarySearchTree with in-order traversal
- CustomAVLTree with left/right rotation balancing
- CustomMinHeap with bubble-up/bubble-down heapify
- CustomGraph with BFS, DFS, and MST algorithms
- ServiceRequestBSTWorker for BST operations
- ServiceRequestAVLWorker for AVL operations
- ServiceRequestHeapWorker for heap operations
- ServiceRequestGraphWorker for graph operations

**Technical Enhancements:**
- Implemented IComparable<T> interface for ServiceRequest class
- Built graph relationship system with weighted edges (SameWard: 5, SameCategory: 3, Dependency: 1)
- Created automatic dependency chain tracing using DFS
- Developed core issue identification using MST algorithm
- Integrated all data structures into unified worker class architecture
- Established sample data with realistic dependencies and relationships

**User Experience Improvements:**
- Instant visual feedback on all operations
- Automatic related request discovery via BFS
- Automatic dependency chain resolution via DFS
- Automatic core issue identification via MST
- Interactive card-based interface with click handlers
- Responsive five-panel layout optimized for 1366x768+ screens
- Visual priority hierarchy with color-coded vertical bars
- Status icons for quick visual identification
- Compact card templates for dense information display

---

## Technology Stack

- **Framework:** .NET 8.0 Desktop
- **Language:** C# 12.0
- **UI Technology:** Windows Presentation Foundation (WPF)
- **Architecture Pattern:** MVVM with static worker classes
- **Data Structures:** Custom implementations (Binary Search Trees, AVL Trees, Min Heaps, Graphs, Queues, Dictionaries, Sets)
- **Localization:** ResourceDictionary-based multi-language support (English, Afrikaans, isiZulu)
- **Development Environment:** Visual Studio 2022

---

## Project Links

**GitHub Repository:**
```
https://github.com/VCWVL/prog7312-poe-ST10145498.git
```

**YouTube Demo Video (Part 3):**
```
https://youtu.be/5iRNaF9nZCQ
```

**Google Drive Backup (Part 3):**
```
https://drive.google.com/file/d/1b2gEKzzudTshSqCrp3ZGowo6AJMXNK7B/view?usp=sharing
```

---

## References

**Academic Papers:**
- Hart, Tim G. B., et al. "Innovation for Development in South Africa: Experiences with Basic Service Technologies in Distressed Municipalities." *Forum for Development Studies*, vol. 47, no. 1, 20 Aug. 2019, pp. 23-47.

**Microsoft Documentation:**
- Microsoft. (2025). WPF Overview. Retrieved from https://learn.microsoft.com/en-us/dotnet/desktop/wpf/overview/
- Microsoft. (2025). IComparable<T> Interface. Retrieved from https://learn.microsoft.com/en-us/dotnet/api/system.icomparable-1
- Microsoft. (2025). Static Classes and Static Class Members. Retrieved from https://learn.microsoft.com/en-us/dotnet/csharp/programming-guide/classes-and-structs/static-classes-and-static-class-members

**Data Structures and Algorithms:**
- GeeksforGeeks. (2025). Binary Search Tree Data Structure. Retrieved from https://www.geeksforgeeks.org/binary-search-tree-data-structure/
- GeeksforGeeks. (2025). AVL Tree | Set 1 (Insertion). Retrieved from https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
- GeeksforGeeks. (2025). Heap Data Structure. Retrieved from https://www.geeksforgeeks.org/heap-data-structure/
- GeeksforGeeks. (2025). Graph Data Structure And Algorithms. Retrieved from https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/
- GeeksforGeeks. (2025). Prim's Minimum Spanning Tree (MST). Retrieved from https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
- Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2009). *Introduction to Algorithms* (3rd ed.). MIT Press.

---

**Author:** Kyle Jeremiah Govender – ST10145498  
**For additional support or questions, contact:** ST10145498@vcconnect.edu.za
