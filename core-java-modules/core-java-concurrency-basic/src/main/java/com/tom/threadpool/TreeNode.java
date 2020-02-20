package com.tom.threadpool;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/13
 */
public  class TreeNode {

    int value;

    Set<TreeNode> children;

    TreeNode(int value, TreeNode... children) {
        this.value = value;
        this.children = Sets.newHashSet(children);
    }
}