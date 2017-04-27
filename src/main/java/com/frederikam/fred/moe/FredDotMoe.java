package com.frederikam.fred.moe;

import org.apache.tika.exception.TikaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;

import java.io.File;
import java.io.IOException;

public class FredDotMoe {

    private static final Logger log = LoggerFactory.getLogger(FredDotMoe.class);

    @Value("{fredDotMoe.baseUrl}")
    static String baseUrl;
    @Value("{fredDotMoe.dataDir}")
    private static String dataDirLocation;

    public static void main(String[] args) throws IOException, TikaException {
        /*InputStream is = new FileInputStream(new File("./config.json"));
        Scanner scanner = new Scanner(is);
        JSONObject config = new JSONObject(scanner.useDelimiter("\\A").next());
        ResourceManager.dataDir = new File(config.getString("dataDir"));
        baseUrl = config.optString("baseUrl", "http://localhost/");
        scanner.close();*/

        //Tomcat changes the working dir, so we make this absolute
        ResourceManager.dataDir = new File(dataDirLocation).getAbsoluteFile();

        //noinspection ResultOfMethodCallIgnored
        ResourceManager.dataDir.mkdirs();

        SpringApplication.run(SpringController.class, args);
    }

}
