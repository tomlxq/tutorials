package com.tom.exceptions.exceptionhandling;

import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/6
 */
public class MoreExceptions extends Exceptions {
    @Override
    public List<Player> loadAllPlayers(String playersFile) throws MyCheckedException {
        // overridden
        throw new MyCheckedException();
    }
}
