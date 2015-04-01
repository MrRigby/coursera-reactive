package com.github.lkrigby.coursera.rp.week1

trait Tree

case class Inner(left: Tree, right: Tree) extends Tree

case class Leaf(x: Int) extends Tree

