package com.perrin.tony.consumer;/**
 * Created by tonyperrin on 31/01/2014.
 */

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 31/01/2014
 * Time: 08:27
 * To change this template use File | Settings | File Templates.
 */
public interface Consumer {
    public void init();
    public boolean isRunning();
    public boolean stopPolling();
    public boolean startPolling();
}
