package com.esys.mvvmstarter.utils.threads;

/**
 * callback used for asynchronous
 * @see RThreader for details
 * */
public interface IRThreader {
    <T> T onExecute();
}
