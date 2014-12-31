package org.onelab.utils.xml;

/**
 * Created by chunliangh on 14-12-29.
 */
public class Demo {
    public static void main(String[] args){
        Node node = XmlUtil.parseXml("/Users/daojian/git/one-lab/utils/src/main/resources/agent-config.xml");
        Node excludepattern = NodeSelector.selectNode(node,0,1,2,0);
        System.out.println(excludepattern.value);
        Node excludepattern1 = NodeSelector.selectNode(node,"excludepattern",0);
        System.out.println(excludepattern1.value);
    }
}
