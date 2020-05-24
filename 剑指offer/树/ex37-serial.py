# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        ser = []
        def preTra(node):
            if not node:
                ser.append(node)
                return
            ser.append(node.val)
            preTra(node.left)
            preTra(node.right)
        preTra(root)
        return ser
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        self.idx = 0
        if data[0] == None:
            return []
        root = TreeNode(data[self.idx])
        self.idx += 1

        def buildByPreTra(node):
            if not node:
                return
            val = data[self.idx]
            self.idx += 1
            if val == None:
                node.left = None
            else:
                node.left = TreeNode(val)
            buildByPreTra(node.left)
            val = data[self.idx]
            self.idx += 1
            if val == None:
                node.right = None
            else:
                node.right = TreeNode(val)
            buildByPreTra(node.right)
        buildByPreTra(root)
        return root
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))