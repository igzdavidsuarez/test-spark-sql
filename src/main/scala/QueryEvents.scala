import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by davidsuarez on 2/03/16.
 */
object QueryEvents {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[2]").setAppName("TestSparkSql")
    val sc = new SparkContext(conf)

    val sqlcontext = new org.apache.spark.sql.SQLContext(sc)

    val dataframe_mysql = sqlcontext
      .read
      .format("jdbc")
      .option("url", "jdbc:mysql://192.168.130.238:3306/BDS_Poblacion_Banca")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("dbtable", "ACTOR")
      .option("user", "root")
      .option("password", "abbyl40L")
      .load()

    dataframe_mysql.registerTempTable("ALL_ACTORS")
    dataframe_mysql.sqlContext.sql("select * from ALL_ACTORS").collect().foreach(println)

    sc.stop()

  }
}
