package org.polarbear.experiments

import org.apache.spark._
import org.apache.spark.graphx._
import com.amd.aparapi.Kernel

object Pagerank {

  private val graphFilesPath: String = "src/main/resources/graphfiles/"
  def main(args: Array[String]) = {
    
    val conf = new SparkConf().setAppName("PagerankTest").setMaster("local")
    val sc = new SparkContext(conf)

    val graph = GraphLoader.edgeListFile(sc, graphFilesPath + "polbooks.net")
    val start = System.nanoTime()
    val ranks = graph.pageRank(0.0001).vertices
    val stop = System.nanoTime()
    val totalTime = (stop - start)/1000000000.0
    ranks.saveAsTextFile(graphFilesPath + "Ranks")
    System.out.println("Time taken by pagerank = " + totalTime + "secs")
  }
}