/*
 * Assignment 7B
 * Brian Kalinowski
 * Question 30/31
 */
package collegebinarytree;

import java.util.*;
import java.io.*;
import java.text.*;

public class studentBinaryTree {
    
    private TreeNode rootNode;
    
    public studentBinaryTree(){
        this.rootNode = null;
    }
    
    boolean insert(){
        StudentWrapper parent = new StudentWrapper();
        StudentWrapper child = new StudentWrapper();
        Student newListing = Student.input();
        TreeNode newNode = new TreeNode(newListing);
        
        if(newNode == null){
            return false;
        }else{
            newNode.node = newListing.deepCopy();
            newNode.leftNode = null;
            newNode.rightNode = null;
            if(rootNode == null){
                rootNode = newNode;
            }else{
                findNode(newListing.getKey(),parent,child);
                if(newListing.getKey().compareTo(parent.get().node.getKey()) < 0){
                    parent.get().leftNode = newNode;
                }else{
                    parent.get().rightNode = newNode;
                }
            }
        }
        return true;
    }
    
    Student fetch(String key) throws Exception{
        StudentWrapper parent = new StudentWrapper();
        StudentWrapper child = new StudentWrapper();
        
        if(findNode(key, parent, child)== true){
            return child.get().node.deepCopy();
        }else{
            throw new Exception("Student not in the structure");
        }
    }
    
    boolean delete(String key){
        StudentWrapper parent = new StudentWrapper();
        StudentWrapper child = new StudentWrapper();
        TreeNode largest, next;
        boolean found = findNode(key, parent, child);
        
        if(found == false){
            return false;
        }
        int fam;
        if(child.get().leftNode == null && child.get().rightNode == null){
            fam = 0;
        }else if(child.get().leftNode == null || child.get().rightNode == null){
            fam = 1;
        }else{
            fam = 2;
        }
        switch(fam){
            case 0:
                if(child.get() == rootNode){
                    rootNode = null;
                }else if(parent.get().leftNode == child.get()){
                    parent.get().leftNode = null;
                }else{
                    parent.get().rightNode = null;
                }
                break;
            case 1:{
                if(child.get() == rootNode){
                    if(child.get().leftNode == null){
                        rootNode = child.get().rightNode;
                    }else{
                        rootNode = child.get().leftNode;
                    }
                }else if(parent.get().leftNode == child.get()){
                    if(child.get().leftNode != null){
                        parent.get().leftNode = child.get().leftNode;
                    }else{
                        parent.get().leftNode = child.get().rightNode;
                    }
                }else{
                    if(child.get().leftNode != null){
                       parent.get().rightNode = child.get().leftNode;
                    }else{
                        parent.get().rightNode = child.get().rightNode;
                    }
                    
                }
                break;
            }
            case 2:{
                next = child.get().leftNode;
                largest = next.rightNode;
                if(largest != null){
                    while(largest.rightNode != null){
                        next = largest;
                        largest = largest.rightNode;
                    }
                    child.get().node = largest.node;
                    next.rightNode = largest.leftNode;
                }else{
                    next.rightNode = child.get().rightNode;
                    if(child.get() == rootNode){
                        rootNode = next;
                    }else if(parent.get().leftNode == child.get()){
                        parent.get().leftNode = next;
                    }else{
                        parent.get().rightNode = next;
                    }
                }
            }
           
        }
        return true;
    }

    boolean update(String key){
        if(delete(key) == false){
            return false;
        }else{
            insert();
            return false;
        }
   }
    
    private boolean findNode(String Target, StudentWrapper parent, StudentWrapper child){
        parent.set(rootNode);
        child.set(rootNode);
        if(rootNode == null){
            return true;
        }
        while(child.get() != null){
            if(child.get().node.getKey().compareTo(Target) == 0){
                return true;
            }else{
                parent.set(child.get());
                if(Target.compareTo(child.get().node.getKey()) < 0){
                    child.set(child.get().leftNode);
                }else{
                    child.set(child.get().rightNode);
                }
            }
                
        }
        return false;
    }
    
    public class TreeNode{
    
        public Student node;
        public TreeNode leftNode;
        public TreeNode rightNode;
        
        public TreeNode(Student node){
            this.node = node;
            this.leftNode = null;
            this.rightNode = null;
        }
    }
    
    public class StudentWrapper{
        TreeNode ref = null;
        
        public StudentWrapper(){
            this.ref = null;
        }
        
        public TreeNode get(){
            return this.ref;
        }
        
        public void set(TreeNode r){
            this.ref = r;
        }
    }
    
    void search(TreeNode rootNode){
       if(rootNode.leftNode != null){
           search(rootNode.leftNode);
       }
       System.out.println(rootNode.node.toString());
       if(rootNode.rightNode != null){
           search(rootNode.rightNode);
       } 
    }
    
    void output(){
        if(rootNode == null){
            System.out.println("Structure is empty");
        }else{
            search(rootNode);
        }
    }
}
