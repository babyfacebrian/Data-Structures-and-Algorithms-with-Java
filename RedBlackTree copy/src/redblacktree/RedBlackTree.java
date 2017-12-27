/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redblacktree;

/**
 *
 * @author briankalinowski
 */
import java.util.*;
import java.io.*;
import java.text.*;

public class RedBlackTree<Object> {
    
    private TreeMap <String, Object> tree;
    
    public RedBlackTree(){
        this.tree = new TreeMap<String, Object>();
    }
    
    public void insert(String key, Object node){
        tree.put(key, node);
    }
    
    public Object fetch(String key) throws Exception{
        if(tree.get(key) == null){
            throw new Exception("Node is not in the structure");
        }else{
            return tree.get(key);
        }
    }
    
    public void delete(String key) throws Exception{
       if(tree.get(key) == null){
           throw new Exception("Node is not in the structure");
       }else{
           tree.remove(key);
           System.out.println("Deleting key: " + key);
       }
    }
    
    public void update(String key, Object newNode) throws Exception{
        if(tree.get(key) == null){
            throw new Exception("Node is not in the structure");
        }else{
            tree.remove(key);
            tree.put(key, newNode);
        }
    }
    
    public void output(){
        Set<Map.Entry<String, Object>> data = tree.entrySet();
        for(Map.Entry<String, Object> node : data){
            System.out.println(node.getValue() + " ");
        }
    }
}

    
