package com.system.ccew.common;

import groovy.util.logging.Commons;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Ticknick
 * @date 06/06/2017
 */
@Component
public class LoggerFactory {

    public  Logger getLogger(Class t){
        return org.slf4j.LoggerFactory.getLogger(t);
    }

}
