package com.bitup.datepickercomponent;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Created by vincentsong on 6/4/17.
 */

public class RNDatePickerComponentEvent extends Event {

    public static final String EVENT_NAME = "topChange"; // Map to onChange event of RN

    private String date;

    public RNDatePickerComponentEvent(int viewTag, String date) {
        super(viewTag);
        this.date = date;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap eventData = Arguments.createMap();
        eventData.putInt("target", getViewTag());
        eventData.putString("value", this.date);
        return eventData;
    }
}
