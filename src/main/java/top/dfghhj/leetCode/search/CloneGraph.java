package top.dfghhj.leetCode.search;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/25 22:12
 * @Description: 133.克隆图
 */
public class CloneGraph {

    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();
        String json = "{\"$id\":\"1\",\"neighbors\":[{\"$id\":\"2\",\"neighbors\":[{\"$ref\":\"1\"},{\"$id\":\"3\",\"neighbors\":[{\"$ref\":\"2\"},{\"$id\":\"4\",\"neighbors\":[{\"$ref\":\"3\"},{\"$ref\":\"1\"}],\"val\":4}],\"val\":3}],\"val\":2},{\"$ref\":\"4\"}],\"val\":1}";
        Node target = JSONObject.parseObject(json, Node.class);
        System.out.println(JSONObject.toJSONString(cloneGraph.cloneGraph(target)));
    }

    public Node cloneGraph(Node node) {
        Map<Integer, Node> createdNodeMap = new HashMap<>();
        Node root = new Node(node.val, null);
        createdNodeMap.put(root.val, root);
        root.neighbors = clone(node, createdNodeMap);
        return root;
    }

    private List<Node> clone(Node target, Map<Integer, Node> createdNodeMap) {
        List<Node> nodeList = new ArrayList<>();
        for (Node node : target.neighbors) {
            Node createdNode = createdNodeMap.get(node.val);
            if (createdNode == null) {
                createdNode = new Node(node.val, null);
                createdNodeMap.put(createdNode.val, createdNode);
                createdNode.neighbors = clone(node, createdNodeMap);
            }
            nodeList.add(createdNode);
        }
        return nodeList;
    }

}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
