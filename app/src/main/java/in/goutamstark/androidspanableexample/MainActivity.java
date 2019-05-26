package in.goutamstark.androidspanableexample;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String text = "I want THIS and THIS to be colored";

        TextView textView = findViewById(R.id.text_view);

        SpannableString  ss = new SpannableString(text);
        SpannableStringBuilder ssb = new SpannableStringBuilder(text);

        ForegroundColorSpan fcsRed = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan fcsGreen = new ForegroundColorSpan(Color.GREEN);
        BackgroundColorSpan bcsYellow = new BackgroundColorSpan(Color.YELLOW);

        ssb.setSpan(fcsRed,7,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(fcsGreen,16,20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(bcsYellow,27,34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ssb.append("and this is inserted");
        ssb.append("and THIS and THAT is clickable");


        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "One", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Two", Toast.LENGTH_SHORT).show();
            }
        };

        ssb.setSpan(clickableSpan1, 58,62, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(clickableSpan2, 67,71, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ssb);


        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();

        textView.setMovementMethod(LinkMovementMethod.getInstance()); //this is important for clickable
    }
}
