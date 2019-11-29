### 1.复杂度分析
时间复杂度：  
- 只关注循环执行次数最多的一段代码
- 加法法则：总复杂度等于量级最大的那段代码的复杂度
- 乘法法则：嵌套代码的复杂度等于嵌套内外代码复杂度的乘积

常见的复杂度：  
O(1)、O(logn)、O(n)、O(nlogn)、O(n2)  

空间复杂度  

最好情况时间复杂度（best case time complexity）、  
最坏情况时间复杂度（worst case time complexity）、  
平均情况时间复杂度（average case time complexity）、  
均摊时间复杂度（amortized time complexity）

### 2.数组
数组（Array）是一种**线性表**数据结构。它用一组连续的内存空间，来存储一组具有相同类型的数据。  
ps:  
为什么大多数编程语言中，数组要从 0 开始编号，而不是从 1 开始呢？
“下标”最确切的定义应该是“偏移（offset）”。a[k]_address = base_address + k * type_size。

### 3.链表

