package gpsgooglemaps.monroy.com.a58calllog;

import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    String [][] logs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getCallDetails();
        allCalls();
    }

    private void init(){
        recyclerView=findViewById(R.id.recyclerView);
    }

    private void getCallDetails(){
        Uri allCalls = Uri.parse("content://call_log/calls");
        Cursor c = managedQuery(allCalls,null,null,null,null);
        logs = new String[c.getCount()][4];
        int counter =0;
        c.moveToFirst();
        while(c.moveToNext()){
            logs[counter][0]= c.getString(c.getColumnIndex(CallLog.Calls.NUMBER));// for  number
            logs[counter][1]= c.getString(c.getColumnIndex(CallLog.Calls.CACHED_NAME));// for name
            logs[counter][2]= c.getString(c.getColumnIndex(CallLog.Calls.DURATION));// for  number
            logs[counter][3]= c.getString(c.getColumnIndex(CallLog.Calls.TYPE));
            counter++;
        }
    }

    private void allCalls(){
        adapter = new CallAdapter(logs);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
