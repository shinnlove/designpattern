/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.designpattern.simplefactory.impl;

import com.shinnlove.designpattern.simplefactory.Api;

/**
 * @author shinnlove.jinsheng
 * @version $Id: ApiOneImpl.java, v 0.1 2018-07-15 下午2:11 shinnlove.jinsheng Exp $$
 */
public class ApiOneImpl implements Api {

    @Override
    public void handle(String message) {
        System.out.println("one: " + message);
    }

}