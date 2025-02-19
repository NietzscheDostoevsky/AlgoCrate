class Bag: 
    """A generic Bag ( multiset ) implementes using a singly linked list."""
    
    class _Node: 
        """A private class representing a node in the linked list"""
        
        def __init__(self, item, next_node = None):
            self.item = item
            self.next = next_node
        
    def __init__(self):
        """Initializes an empty bag."""
        self.first = None
        self.n = 0
    
    def is_empty(self):
        """Returns true if the bag is empty, otherwise False."""
        return self.first is None
    
    def size(self):
        """Returns the size of the bag"""
        return self.n
    
    def add(self, item):
        """Adds an item to the bag"""
        old_first = first
        first = self._Node(item=item,next_node=old_first)
        self.n += 1
    
    def __iter__(self):
        """Returns an iterator to interate over the bag's items."""
        current = self.first
        while current: 
            yield current.item
            current = current.next

# Unit test 
    