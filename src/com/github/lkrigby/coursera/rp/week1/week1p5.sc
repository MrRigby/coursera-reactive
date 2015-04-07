package com.github.lkrigby.coursera.rp.week1

import java.util.Random

object week1p5 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val integers = new Generator[Int] {
    val rand = new Random()
    def generate = rand.nextInt()
  }                                               //> integers  : com.github.lkrigby.coursera.rp.week1.Generator[Int]{val rand: ja
                                                  //| va.util.Random} = com.github.lkrigby.coursera.rp.week1.week1p5$$anonfun$main
                                                  //| $1$$anon$1@6e8dacdf
  
  val booleans = for (x <- integers) yield x > 0  //> booleans  : com.github.lkrigby.coursera.rp.week1.Generator[Boolean] = com.gi
                                                  //| thub.lkrigby.coursera.rp.week1.Generator$$anon$1@36d64342
  
  def single[T](x: T): Generator[T] = new Generator[T] {
    def generate = x
  }                                               //> single: [T](x: T)com.github.lkrigby.coursera.rp.week1.Generator[T]
  
  def choose(lo: Int, hi: Int): Generator[Int] =
    for (x <- integers) yield lo + x % (hi - lo)  //> choose: (lo: Int, hi: Int)com.github.lkrigby.coursera.rp.week1.Generator[Int
                                                  //| ]
    
  def oneOf[T](xs: T*): Generator[T] =
    for (idx <- choose(0, xs.length)) yield xs(idx)
                                                  //> oneOf: [T](xs: T*)com.github.lkrigby.coursera.rp.week1.Generator[T]
    
  // +--
  // Lists generator
    
  def lists: Generator[List[Int]] = for {
    isEmpty <- booleans
    list <- if (isEmpty) emptyLists else nonEmptyLists
  } yield list                                    //> lists: => com.github.lkrigby.coursera.rp.week1.Generator[List[Int]]
  
  def emptyLists = single(Nil)                    //> emptyLists: => com.github.lkrigby.coursera.rp.week1.Generator[scala.collecti
                                                  //| on.immutable.Nil.type]
  
  def nonEmptyLists = for {
    head <- integers
    tail <- lists
  } yield head :: tail                            //> nonEmptyLists: => com.github.lkrigby.coursera.rp.week1.Generator[List[Int]]
  
  // +--
  // Tree generator
  
  def leafs: Generator[Leaf] = for {
    x <- integers
  } yield Leaf(x)                                 //> leafs: => com.github.lkrigby.coursera.rp.week1.Generator[com.github.lkrigby.
                                                  //| coursera.rp.week1.Leaf]
  
  def inners: Generator[Inner] = for {
    l <- trees
    r <- trees
  } yield Inner(l, r)                             //> inners: => com.github.lkrigby.coursera.rp.week1.Generator[com.github.lkrigb
                                                  //| y.coursera.rp.week1.Inner]
  
  def trees: Generator[Tree] = for {
    isLeaf <- booleans
    tree <- if (isLeaf) leafs else inners
  } yield tree                                    //> trees: => com.github.lkrigby.coursera.rp.week1.Generator[com.github.lkrigby
                                                  //| .coursera.rp.week1.Tree]
  
  
}