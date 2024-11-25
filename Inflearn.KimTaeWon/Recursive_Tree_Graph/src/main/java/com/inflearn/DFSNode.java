package com.inflearn;

public class DFSNode {
    int data;
    DFSNode lt, rt;

    public DFSNode(int val) {
        data = val;
        lt = rt = null;
    }
}
