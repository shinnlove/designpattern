/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.designpattern.simplefactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 通过读取配置文件的简单工厂。
 *
 * @author shinnlove.jinsheng
 * @version $Id: SimpleFactory.java, v 0.1 2018-07-15 下午2:09 shinnlove.jinsheng Exp $$
 */
public class SimpleFactory {

    public static Api createApi() {
        // 从配置文件读入
        Properties p = new Properties();
        InputStream in = null;
        try {
            in = SimpleFactory.class.getResourceAsStream("FactoryTest.properties");
            p.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 反射创建具体实现的实例
        Api api = null;
        try {
            // ImplClass必须是全类名
            api = (Api) Class.forName(p.getProperty("ImplClass")).newInstance();
        } catch (InstantiationException e) {
            // 实例化失败
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // 反射不能调用构造器(私有)
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // 反射没找到类
            e.printStackTrace();
        }

        return api;
    }

}