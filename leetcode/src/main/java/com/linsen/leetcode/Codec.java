package com.linsen.leetcode;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lane.lin
 * @Description 二叉树的序列化和反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @since 2020/6/16
 */
public class Codec {

    /**
     * 序列化
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        return serializeDFSFirst(root, "");

//        return serializeDFSMiddle(root, "");
    }

    /**
     * 反序列化
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return deserializeDFSFirst(data_list);
    }

    /**
     * DFS遍历中的先序遍历
     * 根-->左子树-->右子树
     * 利用递归进行回溯
     * @param root
     * @return
     */
    public String serializeDFSFirst(TreeNode root, String str){
        if(null == root){
            return str + "NULL,";
        }else{
            str = str + root.val + ",";
            str = serializeDFSFirst(root.left, str);
            str = serializeDFSFirst(root.right, str);
        }
        return str;
    }

    public TreeNode deserializeDFSFirst(List<String> stringList){
        if (stringList.get(0).equals("None")) {
            stringList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(stringList.get(0)));
        stringList.remove(0);
        root.left = deserializeDFSFirst(stringList);
        root.right = deserializeDFSFirst(stringList);

        return root;
    }

    /**
     * DFS遍历中的中序遍历
     * 左子树-->根-->右子树
     * @param root
     * @param str
     * @return
     */
    public String serializeDFSMiddle(TreeNode root, String str){
        if(null == root){
            return str + "NULL,";
        }else{
            str = serializeDFSMiddle(root.left, str);
            str = str + root.val + ",";
            str = serializeDFSMiddle(root.right, str);
        }
        return str;
    }

    /**
     * DFS遍历中的后序遍历
     * 左子树-->右子树-->根
     * @param root
     * @param str
     * @return
     */
    public String serializeDFSLast(TreeNode root, String str){
        if(null == root){
            return str + "NULL,";
        }else{
            str = serializeDFSLast(root.left, str);
            str = serializeDFSLast(root.right, str);
            str = str + root.val + ",";
        }
        return str;
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
