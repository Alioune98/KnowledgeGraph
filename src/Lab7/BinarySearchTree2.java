package Lab7;

/**
 * A class to represent a binary search tree.
 * @param <E> The element type
 * @author Alioune Diagne
 * add comparable later
 */
public class BinarySearchTree2<E extends Comparable<E>> extends BinaryTree2<E> implements SearchTree<E> {
    // Data Fields
    /**
     * Return value from the public add method.
     */
    protected boolean addReturn;
    /**
     * Return value from the public delete method.
     */
    protected E deleteReturn;

    //Methods
    /**
     * Starter method find.
     * @param target The Comparable object being sought
     * @return The object, if found, otherwise null
     */
    @Override
    public E find(E target) {
        return find(root, target);
    }

    /**
     * Recursive find method.
     *
     * @param localRoot The local subtrees root
     * @param target The object being sought
     * @return The object, if found, otherwise null
     */
    private E find(Node<E> localRoot, E target) {
    	// if the localRoot is null, or not found
        if(localRoot == null){
            return null;
        }

        // Compare the target with the data field at the root.
        int compResult = target.compareTo(localRoot.data);

    	//you cannot use < or > or = as the type if the data is E
        //think about what you can do?


    	//if target equal to localRoot.data then return localRoot.data
        if(compResult == 0){ //the result of compResult is 0 which means that the target is the same as the data in the root
            return localRoot.data; //returns the data in the root
        }

        //if target less than local root data, then find from left subtree    
        else if(compResult < 0){ //the result of compResult is less than 0 which means that the target is smaller than the data in the root
            return find(localRoot.left, target); //The result of the recursive search of the left subtree is returned
        }

        //if target greater than local root data, then find from right subtree
        else return find(localRoot.right, target); //The result of the recursive search of the right subtree is returned
    }

    /**
     * Starter method add.
     *
     * @param item The object being inserted
     * @return true if the object is inserted, false if the object already
     * exists in the tree
     */
    @Override
    public boolean add(E item) {
        root = add(root, item); //root becomes the new node with the added item (return of the recursive add method)
        return addReturn; //signifies whether the item was added
    }


    /**
     * Recursive add method.
     * @post The data field addReturn is set true if the item is added to the
     * tree, false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root that now contains the inserted item
     */
    private Node<E> add(Node<E> localRoot, E item) {
        // item is not in the tree, insert it. Return a new node
        if (localRoot == null) { //The current node that is being added to is empty
            addReturn = true; //Item was successfully added to the specified node/subtree
            return new Node<>(item); //The new tree with the added item; returned to the caller (starter add method)
        }

        // item is equal to localRoot.data
        else if(item.compareTo(localRoot.data) == 0){
            addReturn = false; //Item was not added because the item to be added matches an item already in the specified tree
            return localRoot; //The unmodified tree is returned
        }

        // item is less than localRoot.data add to the left subtree
        else if(item.compareTo(localRoot.data) < 0){ //The value of the item is lower than the value of the data in the local root
            localRoot.left = add(localRoot.left, item); //add method is called on the left tree of the specified node/tree
            return localRoot; //The new modified tree is returned
        }

        // item is greater than localRoot.data add to the right subtree
        else{
            localRoot.right = add(localRoot.right, item); //add method is called on the right tree of the specified node/tree
            return localRoot; //The new modified tree is returned
        }
    }

    /**
     * Starter method delete.
     *
     * @post The object is not in the tree.
     * @param target The object to be deleted
     * @return The object deleted from the tree or null if the object was not in
     * the tree
     */
    @Override
    public E delete(E target) {
        root = delete(root, target); //Recursive delete method is called on the root of this tree and becomes the new root
        return deleteReturn; //If the target was removed from the tree, returns the target; else returns null
    }

    /**
     * Recursive delete method.
     *
     * @post The item is no longer in the tree;
     * deleteReturn is equal to the deleted item
     * as it was stored in the tree or null if the
     * item was not found.
     * @param localRoot The root of the current subtree
     * @param item The item to be deleted
     * @return The modified local root that does not contain the item
     */
    private Node<E> delete(Node<E> localRoot, E item) { //starts at the local root and goes down until the item is found or the entire tree is searched
        //1. First we check to see if the specified localRoot is null,
        // if it is then deleteReturn is set to null and null is returned to the caller.

       //1. item is not in the tree.
        if(localRoot == null){ //If the value of the specified localRoot is null
            deleteReturn = null; //Item was not removed from the tree
            return null; //Returns null because the target was not found in the specified tree or does not exist
        }


//        2. Then we compare the item to be deleted with the item stored in the roots' data value
        //2.  Search for item to delete.
        int compResult = item.compareTo(localRoot.data); //compares the item to the data in the root; 0 if same, 1 if item is larger, -1 if the item is smaller

//      a. If the item to be deleted has a value less than the roots' data value,
//         then the search for the item continues in the left subtree.
        // 2.1 item is smaller than localRoot.data.
        if(compResult < 0){ //The item to be deleted is less than the data value in the localRoot
            localRoot.left = delete(localRoot.left, item); //recursive delete method is called on the left tree of the specified node/tree
            return localRoot; //returns the modified tree with the target deleted
        }

        /*b. If the item to be deleted has a value greater than the root's data value,
          then the search for the item continues in the right subtree.*/
        // 2.2 item is larger than localRoot.data.
        else if (compResult > 0){ //The item to be deleted is greater than the data value in the localRoot
            localRoot.right = delete(localRoot.right, item); //recursive delete method is called on the right tree of the specified node/tree
            return localRoot; //returns the modified tree with the target deleted
        }


// c. If the item to be deleted has a value that is the same as the root's data value,
//    deleteReturn is set equal to the roots' data value. (This is because localRoot will be deleted and the
        // largest value in the smallest tree of the localRoot must replace it)
        // 2.3 item is at local root.
        else{
            deleteReturn = localRoot.data; //deleteReturn is set equal to root
                // 2.3.1 localRoot has one child

            // 2.3.1.1 If there is no left child, return right child which can also be null.
            if(localRoot.left == null){
                return localRoot.right;
            }

            // 2.3.1.2 If there is no right child, return left child.
            else if (localRoot.right == null){
                return localRoot.left;
            }

            // 2.3.2 Node being deleted has 2 children, replace the data with inorder predecessor.
            else{
                // 2.3.2.1 The left child has no right child.
                if(localRoot.left.right == null){ //If the left subtree's right most child is null
                        // Replace the localRoot data with the data in the left child.
                    localRoot.data = localRoot.left.data; //If the subtree does not have a right branch,
                    // then the local root is set equal to the subtrees left branch Replace the left child with its left child.
                    localRoot.left = localRoot.left.left; //The left node of the local root will now point to the local roots left nodes left node
                    return localRoot; //return the new tree with the removed item
                }
                    //2.3.2.2 Search for the inorder predecessor (ip) and
                    // replace deleted node's data with inorder predecessor.
                else{
                    localRoot.data = findLargestChild(localRoot.left); //The data of the local root is set to the largest child in the left
                    return localRoot;
                }
            }
        }
    }

    /**
     * Removes target from tree.
     *
     * @param target Item to be removed
     * @return true if the object was in the tree, false otherwise
     * @post target is not in the tree
     */
    @Override
    public boolean remove(E target) {
        return delete(target) != null;
    }

    /**
     * Determine if an item is in the tree
     *
     * @param target Item being sought in tree
     * @return true If the item is in the tree, false otherwise
     * @throws ClassCastException if target is not Comparable
     */
    @Override
    public boolean contains(E target) {
        return find(target) != null;
    }

    /**
     * Find the node that is the in-order predecessor and replace it with its
     * left child (if any).
     *
     * @post The in-order predecessor is removed from the tree.
     * @param parent The parent of possible in-order predecessor (ip)
     * @return The data in the ip
     */
    private E findLargestChild(Node<E> parent) {
        // If the right child has no right child, it is the inorder predecessor.
        if (parent.right.right == null) { //The right child of the parent is a leaf node
            E returnValue = parent.right.data; //The largest value will be the only node in the parents right tree
            parent.right = parent.right.left; //The right node of the new parent node will be set equal
            return returnValue;
        } else {
            return findLargestChild(parent.right);
        }
    }
    
    /**
     * Please write another delete method, called deletePrime.
     * Starter method deletePrime is as follows.
     * deletePrime is the same as delete except that
     * when a value is deleted that has two children the
     * in-order successor replaces it in the tree.
     *
     * @post The object is not in the tree.
     * @param target The object to be deleted
     * @return The object deleted from the tree or null if the object was not in the tree
     * @throws ClassCastException if target does not implement Comparable
     */
    public E deletePrime(E target) {
        root = deletePrime(root, target);
        return deleteReturn;
    }

    /**
     * Recursive deletePrime method.
     *
     * @post The item is not in the tree; deleteReturn is equal to the deleted
     * item as it was stored in the tree or null if the item was not found.
     * @param localRoot The root of the current subtree
     * @param item The item to be deleted
     * @return The modified local root that does not contain the item
     */
    private Node<E> deletePrime(Node<E> localRoot, E item) {
        return localRoot;
    }

    /**
     * Find the node that is the in-order successor and replace it with its
     * right child (if any).
     *
     * @post The in-order successor is removed from the tree.
     * @param parent The parent of possible in-order successor (is)
     * @return The data in the is
     */
    private E findSmallestChild(Node<E> parent) {
        // If the left child has no left child, it is
        // the inorder predecessor.
        if (parent.left.left == null) { //The right child of the parent is a leaf node
            E returnValue = parent.left.data;//The largest value will be the only node in the parents right tree
            parent.left = parent.left.right; //The right node of the new parent node will be set equal
            return returnValue;
        } else {
            return findSmallestChild(parent.left);
        }
    }
    /*</exercise>*/
}