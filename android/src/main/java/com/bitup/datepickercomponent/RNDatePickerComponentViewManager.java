package com.bitup.datepickercomponent;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by vincentsong on 6/4/17.
 */

public class RNDatePickerComponentViewManager extends SimpleViewManager<DatePicker> {

    public static final String REACT_CLASS = "RCTDatePickerComponent";

    private static final DatePicker.OnDateChangedListener listener = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            ReactContext reactContext = (ReactContext) view.getContext();
            @SuppressLint("DefaultLocale") String date = String.format("%d-%d-%d", year, monthOfYear+1, dayOfMonth);
            reactContext.getNativeModule(UIManagerModule.class)
                    .getEventDispatcher()
                    .dispatchEvent(new RNDatePickerComponentEvent(view.getId(), 0, date));
        }
    };

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    /**
     * Create a native date picker from layout file with spinner mode
     * @param reactContext
     * @return Native date picker
     */
    @Override
    protected DatePicker createViewInstance(ThemedReactContext reactContext) {
        View view = LayoutInflater.from(reactContext).inflate(R.layout.date_picker, null, false);
        DatePicker picker = (DatePicker) view.findViewById(R.id.datepicker);
        ViewGroup viewParent = (ViewGroup) picker.getParent();
        if (viewParent != null) {
            viewParent.removeView(picker);
        }
        return picker;
    }

    /**
     * Show the calendar view
     * @param picker
     * @param show default is false
     */
    @ReactProp(name="showCalendar", defaultBoolean = false)
    public void setShowCalendar(DatePicker picker, boolean show) {
        picker.setCalendarViewShown(show);
        picker.setSpinnersShown(!show);
    }

    /**
     * Set the initial date, default date is 1980-01-01
     * @param picker
     * @param date initial date, format is 'yyyyy-MM-dd'
     */
    @ReactProp(name="date")
    public void setDate(DatePicker picker ,String date) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (d == null) {
            picker.init(1980, 0, 1, listener);
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);
            picker.init(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    listener);
        }
    }
}
