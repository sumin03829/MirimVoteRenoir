package kr.hs.emirim.s2019s38.mirimvoterenoir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] imgNames={"1","2","3","4","5","6","7","8","9"};
    int[] voteCount=new int[imgNames.length];
    ImageView[] imgVs=new ImageView[imgNames.length];
    int[] imgVIds={R.id.im1,R.id.im2,R.id.im3,R.id.im4,R.id.im5,R.id.im6,R.id.im7,R.id.im8,R.id.im9};
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("투표");

        for(int i=0;i<voteCount.length;i++){
            voteCount[i]=0;
        }

        for(int i=0; i<imgVs.length;i++){
            index=i;
            imgVs[index]=findViewById(imgVIds[index]);
            imgVs[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),imgNames[index]+": 총"+voteCount[index]+"표",Toast.LENGTH_LONG).show();
                }
            });
        }

        Button btnDone=findViewById(R.id.btn_done);
        btnDone.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
            intent.putExtra("voteCount",voteCount);
            intent.putExtra("imgNames",imgNames);
            startActivity(intent);
        }
    };
}