package org.onelab.utils.xml;

import java.util.*;

/**
 * Created by chunliangh on 14-12-29.
 */
public class Node {
    public String name ;
    public String value ;
    public Node parent ;
    public List<Node> subs = new ArrayList<Node>(0);
    public Map<String,String> attributes = new HashMap<String, String>(0);
    public Node getSub(int index){
        return subs.get(index);
    }
    public Node getSub(String name){
        for (Node node:subs){
            if (node.name.equals(name)){
                return node;
            }
        }
        return null;
    }
    public Node getNode(int... index){
        return NodeSelector.selectNode(this, index);
    }
    public Node getNode(String... name){
        Node curr = this;
        if (name!=null && name.length>0){
            for (int i=0;i<name.length;i++){
                curr = NodeSelector.selectNode(curr,name[i],0);
                if (curr == null){
                    return null;
                }
            }
        }
        return curr;
    }
    public String getSubVal(int index){
        Node node = getSub(index);
        return node==null?null:node.value;
    }
    public String getSubVal(String name){
        Node node = getSub(name);
        return node==null?null:node.value;
    }
    public String getNodeVal(int... index){
        Node node = getNode(index);
        return node==null?null:node.value;
    }
    public String getNodeVal(String... name){
        Node node = getNode(name);
        return node==null?null:node.value;
    }
    public List<Node> getSubs(String name){
        List<Node> nodes = new ArrayList<Node>(subs.size());
        for (Node node:subs){
            if (node.name.equals(name)){
                nodes.add(node);
            }
        }
        return nodes;
    }
    public List<Node> getNodes(String... name){
        int len = name.length;
        if (name!=null && len>0){
            String[] arg = Arrays.copyOf(name, len - 1);
            Node curr = getNode(arg);
            return NodeSelector.selectNodes(curr,name[len-1]);
        }
        return null;
    }
}
