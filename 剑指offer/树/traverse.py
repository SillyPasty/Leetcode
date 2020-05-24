

class tree:
    def __init__(self, x):
        self.val = x
        self.lc = None
        self.rc = None
    def __str__(self):
        return self.val

def preOrderTraverse(root):
    if root == None:
        return
    print(root.val)
    preOrderTraverse(root.lc)
    preOrderTraverse(root.rc)

def inOrderTraverse(root):
    if root == None:
        return
    inOrderTraverse(root.lc)
    print(root.val)
    inOrderTraverse(root.rc)

def postOrderTraverse(root):
    if root == None:
        return
    postOrderTraverse(root.lc)
    postOrderTraverse(root.rc)
    print(root.val)

def levelOrderTraverse(root):
    queue = []
    queue.append(root)
    while len(queue):
        node = queue.pop()
        print(node.val)
        if node.lc != None:
            queue.append(node.lc)
        if node.rc != None:
            queue.append(node.rc)


def buildTree(root, x):
    queue = []
    queue.append(root)
    for x in range(0, x, 2):
        node = queue.pop(0)
        lc = tree(x)
        rc = tree(x + 1)
        node.lc = lc 
        node.rc = rc
        queue.append(lc)
        queue.append(rc)


def main():
    root = tree(531)
    buildTree(root, 10)
        
    preOrderTraverse(root)
    # inOrderTraverse(root)
    # levelOrderTraverse(root)
    # postOrderTraverse(root)

main()  
