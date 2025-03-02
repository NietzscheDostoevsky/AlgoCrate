class MinPQ:
    def __init__(self, capacity=1):
        self.pq = []
        self.N = 0; # number of elements on PQ.
        
    def is_empty(self):
        return self.N == 0;
    
    def size(self):
        return self.N
    
    def insert(self, item):
        self.pq.append(item)
        self.N += 1
        self._swim(self.N -1)
    
    def del_min(self):
        if self._is_empty():
            raise IndexError("PQ Underflow")
        
        min_item = self.pq[0]
        self._exchange(0, self.N -1)
        self.pq.pop()
        self.N -= 1
        self._sink(0)
        
        return min_item
    
    def _swim(self, k):
        
        while k > 0 and self.pq[(k - 1) // 2] > self.pq[k]:
            self._exchange(k, (k - 1) // 2)
            k = (k - 1) // 2
    
    def _sink(self, k):
        
        while 2 * k + 1 < self.N: 
            j = 2 * k + 1
            if j + 1 < self.N and self.pq[j + 1]  < self.pq[j]:
                j += 1
            if self.pq[k] <= self.pq[j]:
                break
            self._exchange(k, j)
            k = j
    def _exchange(self, i , j):
        self.pq[i], self.pq[j] = self.pq[j], self.pq[i];
    
    def __iter__(self):
        return iter(sorted(self.pq))
    

