package org.example;

import org.example.cli.ParamsParser;
import org.example.model.Params;
import org.example.business.Business;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            Params params;
            try {
                params = ParamsParser.parse(args);
            } catch (ParseException e) {
                logger.error("Ошибка парсинга аргументов: {}", e.getMessage());
                System.exit(2);
                return;
            }

            Business business = new Business();
            business.doSomething(params);

        } catch (Exception e) {
            logger.error("Произошла непредвиденная ошибка", e);
            System.out.println("Произошла непредвиденная ошибка" + e.getMessage());
            System.exit(3);
        }
    }
}