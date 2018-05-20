package com.example.slowactiontwoapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import android.widget.TextView;

public class LongRunningThread extends Thread {
    private long total;
    private Handler handler;

    public LongRunningThread(long total, Handler handler)
    {
        this.total = total;
        this.handler = handler;
    }

    public void run()
    {
        long rest = total;
        while(rest > 0)
        {
            long thisTime = Math.min(rest, 1000L);
            try
            {
                Thread.sleep(thisTime);
            }
            catch(Exception e)
            {
            }
            rest -= thisTime;
            Message message = handler.obtainMessage(); // oder new Message();
            Bundle bundle = new Bundle();
            bundle.putLong("left", rest);
            message.setData(bundle);
            handler.sendMessage(message);
        }
        Message message = handler.obtainMessage(); // oder new Message();
        Bundle bundle = new Bundle();
        bundle.putLong("left", rest);
        bundle.putLong("total", total);
        message.setData(bundle);
        handler.sendMessage(message);
    }
}
