package com.tom.web.service;

import java.util.concurrent.Callable;

public interface AsyncService {

    void asyncCall();

    Callable<Boolean> checkIfPrincipalPropagated();

}
