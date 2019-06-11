import java.io.*;
import java.util.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class WordCounterMapper
    extends Mapper<LongWritable, Text, Text, IntWritable> {
@Override
public void map(LongWritable key, Text value, Context context)
throws IOException, InterruptedException {
String[] target = {"hackathon", "Dec", "Chicago", "Java"};
for (int i = 0; i < target.length; i++){
	context.write(new Text(target[i]), new IntWritable(0));
}
String line = value.toString();
String[] strs = line.split("[^a-zA-Z]");
for (String t : target){
	for (String str: strs){
		if (str.toLowerCase().equals(t.toLowerCase())) {
		    context.write(new Text(t), new IntWritable(1));
			break;
		}
	}
}
}
}
