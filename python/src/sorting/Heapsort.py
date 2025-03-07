class Heapsort : 
    def sort(self, pq):
        
        n = len(pq) 
        
        #Heapify
        for i in range(n//2, 0, -1 ): #integer division
            self.sink(pq, i, n)
        
        #sort down from the top node
        k = n;
        while k > 1:
            self.exch(pq, 1, k )
            k = k - 1
            self.sink(pq, 1, k)
            
    
    def sink(self, pq, k, n):
        while (2*k <= n):
            j = 2*k
            if j < n and self.less(pq, j, j+1):
                j = j + 1
            if not self.less(pq, k, j):
                break
            self.exch(pq, k, j)
            k = j
    
    def exch(self, pq, i, j):
        #indices to be made consistent with 1 based heap
        pq[i-1], pq[j-1] = pq[j-1], pq[i-1]
    
    def less(self,pq, i, j):
        #indices to be made consistent with 1 based heap
        return pq[i-1] < pq[j-1]
    
   



# Unit test

# Unit test 
if __name__ == "__main__":
    arr = [8,7,6,5,4,3,2,1,0]
    heapsort = Heapsort();
    arr2 = arr.copy();
    heapsort.sort(arr2)
    arr.sort()
    assert arr == arr2, f"Test failed: expected {arr}, got {arr2}"
    print("Test passed!")
    