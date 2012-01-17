package com.test.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends Activity {
	
	TextView Text;
	Button b;
	Button s;
	Button f;
	int gamestate;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Text = (TextView)findViewById(R.id.text);
        b = (Button)findViewById(R.id.back_button);
        s = (Button)findViewById(R.id.shoot_button);
        f = (Button)findViewById(R.id.forward_button);
        
        Text.setText(R.string.intro);
        gamestate=1;
        
        b.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				if(gamestate == 10){
					Text.setText(R.string.intro);
					gamestate=1;
				}
				else{
					Text.setText(R.string.back);
					gamestate=10;
				}
			}
		});
        
        s.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				if(gamestate == 2){
					Text.setText(R.string.shoot2);
					gamestate=3;
				}
				else if(gamestate == 10){
					Text.setText(R.string.intro);
					gamestate=1;
				}					
				else
					Text.setText(R.string.shoot);
			}
		});
        
        f.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				if(gamestate == 1){
					Text.setText(R.string.fwd1);
					gamestate=2;
				}
				else if(gamestate == 2){
					Text.setText(R.string.fwd_m_not_dead);
					gamestate = 10;
				}
				else if(gamestate == 3){
					Text.setText(R.string.fwd_m_dead);
					gamestate=10;
				}
				else if(gamestate == 10){
					Text.setText(R.string.intro);
					gamestate=1;
				}
			}
		});
    }
}