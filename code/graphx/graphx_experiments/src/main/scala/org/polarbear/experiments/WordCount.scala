package org.polarbear.experiments

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordCount {

  private val path: String = "src/test/resources/"
  
  def main(args: Array[String]) = {
    val conf = new SparkConf().setAppName("WordCount").setMaster("local")
    val sc = new SparkContext(conf)

    val test = sc.textFile(path + "WordCountInput.txt")
    test.flatMap{line =>line.split(" ")}.map { word => (word, 1)}.reduceByKey(_ + _).saveAsTextFile(path + "WordCountOutput.txt")
    sc.stop
  }
}