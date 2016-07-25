package com.melody.meishi.crawle.pipline;

import com.meishi.ws.dto.FoodDTO;
import com.meishi.ws.dto.MeishiDTO;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@ThreadSafe
@Component(value = "pipline")
public class DouguoPipline implements Pipeline {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private String filePath;

	public DouguoPipline(){}

	public DouguoPipline(String type) {
		filePath = "D:/meishi/douguo/"+type+"/";
	}
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {

				if (entry.getValue() instanceof FoodDTO) {
					FoodDTO dto = (FoodDTO) entry.getValue();
					writeFile(filePath+dto.getTitle()+".json", dto.toString());
//					logger.error(dto.toString());
				}
				else {
					System.out.println(entry.getKey() + ":\t"
							+ entry.getValue());
				}
			}
			httpclient.close();
		} catch (IOException e) {
			logger.warn("write file error", e);
		}
	}


	public void writeFile(String filePath, String sets) throws IOException {
		File file = new File(filePath);
		if (!file.exists()){
			file.createNewFile();
		}
	    FileWriter fw = new FileWriter(filePath);
	    PrintWriter out = new PrintWriter(fw);
	    out.write(sets);
	    out.println();
	    fw.close();
	    out.close();
	   }
}