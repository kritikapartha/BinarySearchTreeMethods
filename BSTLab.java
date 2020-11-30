/*****************************************************************************************************************
 NAME: Kritika Partha
 DATE: 1/22/2020

 ****************************************************************************************************/
import java.util.Scanner;
public class BSTLab
{
    public static void main(String[] args)
    {
        BSTLab b = new BSTLab();

        // your code goes here
        Scanner console = new Scanner (System.in);
        System.out.print("Enter a string: ");
        String input = console.nextLine();
        TreeNode root = new TreeNode(input.substring(0,1));
        input = input.substring(1);
        for(int i = 0; i < input.length(); i++)
        {
            b.insert(root, input.substring(i, i + 1));
        }
        System.out.println("Binary Search Tree displayed sideways:");
        b.display(root,0);

        System.out.println("Enter a value to search in the tree for: ");
        String value = console.nextLine();

        System.out.println(value + " is in the tree: " + find(root, value));
        System.out.println("Minimum value: " + min(root));
        System.out.println("Maximum value: " + max(root));

        System.out.println("Displaying values in the tree small to large: ");
        b.smallToLarge(root);
    }

    /****************************************************************
     Recursive algorithm to build a BST:  if the node is null, insert the
     new node.  Else, if the item is less, set the left node and recur to
     the left.  Else, if the item is greater, set the right node and recur
     to the right.
     *****************************************************************/
    //pre: none
    //post: inserts s into the tree so that every node smaller than the root is to the left, and everyone larger is to the right for each subtree as well
    public static TreeNode insert(TreeNode t, String s)
    {
        if (t == null) {
            t = new TreeNode(s);
            return t;
        }
        else {
            if(s.compareTo((String)t.getValue()) <= 0)
                t.setLeft(insert(t.getLeft(), s));
            else
                t.setRight(insert(t.getRight(), s));
            return t;
        }
    }//insert

    //pre: none
    //post: displays the tree sideways
    public static void display(TreeNode t, int level)
    {
        if(t == null)
            return;

        display(t.getRight(), level + 1); //recurse right

        for(int k = 0; k < level; k++)
            System.out.print("\t");
        System.out.println(t.getValue());

        display(t.getLeft(), level + 1); //recurse left
    }//display

    /***************************************************************
     Iterative algorithm:  create a temporary pointer p at the root.
     While p is not null, if the p's value equals the target, return true.
     If the target is less than the p's value, go left, otherwise go right.
     If the target is not found, return false.

     Find the target. Recursive algorithm:  If the tree is empty,
     return false.  If the target is less than the current node
     value, return the left subtree.  If the target is greater, return
     the right subtree.  Otherwise, return true.
     . ****************************************************************/
    //pre: none
    //post: returns true if x is found in the tree, false otherwise
    public static boolean find(TreeNode t, Comparable x)
    {
        if(t == null)
            return false;
        if(x.compareTo(t.getValue()) <= 0)
            return find (t.getLeft(), x);
        if(x.compareTo(t.getValue()) > 0)
            return find(t.getRight(), x);
        return true;
    }//find

    /***************************************************************
     starting at the root, return the min value in the BST.
     Use iteration.   Hint:  look at several BSTs. Where are
     the min values always located?
     ***************************************************************/
    //pre: none
    //post: returns the minimum object in the tree
    public static Object min(TreeNode t)
    {
        if(t == null)
            return null;
        TreeNode p = t;
        while(p.getLeft() != null)
            p = p.getLeft();
        return t.getValue();
    }//min
    /*****************************************************************
     starting at the root, return the max value in the BST.
     Use recursion!
     *****************************************************************/
    //pre: none
    //post: returns the maximum object in the tree
    public static Object max(TreeNode t)
    {
        if(t == null)
            return null;
        if(t.getRight() == null)
            return t.getValue();
        return max(t.getRight());
    }//max

    //pre: none
    //post: displays the values in the tree from smallest to largest
    public static void smallToLarge(TreeNode t)
    {
        if(t == null)
            return;
        else
        {
            if(t.getLeft() != null) {
                smallToLarge(t.getLeft());
            }
            System.out.print(t.getValue());
            if(t.getRight() != null){
                smallToLarge(t.getRight());
            }
        }
        
       }//smallToLarge
       public boolean isBST2(TreeNode root, int min, int max) {
		if (root != null) {
			if (root.data > max || root.data < min) {
				return false;
			}
			return isBST2(root.left, min, root.data)
					&& isBST2(root.right, root.data, max);
		} else {
			return true;
		}
	}
    }//end of class
/*
 
  ----jGRASP exec: java BSTLab
 Enter a string: Computer Science
 Binary Search Tree displayed sideways:
 			u
 				t
 					r
 		p
 	o
 			n
 		m
 				i
 			e
 						e
 							e
 					c
 						c
 				S
 C
 	 
 Enter a value to search in the tree for: 
 p
 p is in the tree: false
 Minimum value: C
 Maximum value: u
 Displaying values in the tree small to large: 
  CScceeeimnoprtu
  ----jGRASP: operation complete.
 
*/
