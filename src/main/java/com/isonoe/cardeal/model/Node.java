package com.isonoe.cardeal.model;

import com.isonoe.cardeal.model.common.BaseEntity;

import java.util.ArrayList;

public class Node extends BaseEntity {

    String lat;

    String lng;

    ArrayList<Node> links;
}
