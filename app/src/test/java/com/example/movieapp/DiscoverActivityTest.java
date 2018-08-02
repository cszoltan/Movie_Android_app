package com.example.movieapp;

import android.support.constraint.ConstraintLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class DiscoverActivityTest {
    private DiscoverActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(DiscoverActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void shouldHaveDefaultMargin() throws Exception {
        TextView textView = (TextView) activity.findViewById(R.id.textView2);
        int topMargin = ((ConstraintLayout.LayoutParams) textView.getLayoutParams()).topMargin;
        assertEquals(16, topMargin);
        int rightMargin = ((ConstraintLayout.LayoutParams) textView.getLayoutParams()).rightMargin;
        assertEquals(16, rightMargin);
        int leftMargin = ((ConstraintLayout.LayoutParams) textView.getLayoutParams()).leftMargin;
        assertEquals(16, leftMargin);
    }
}

