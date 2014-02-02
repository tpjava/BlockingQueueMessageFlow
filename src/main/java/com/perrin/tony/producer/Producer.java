package com.perrin.tony.producer;/**
 * Created by tonyperrin on 31/01/2014.
 */

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 31/01/2014
 * Time: 08:32
 * To change this template use File | Settings | File Templates.
 */
public interface Producer {
    public  void init();
    public boolean isRunning();
    public boolean stopPolling();
    public boolean startPolling();
}
