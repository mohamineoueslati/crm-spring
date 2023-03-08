package com.moh.crmspring.converters;

import com.moh.crmspring.dto.ActivityResponse;
import com.moh.crmspring.entities.Activity;
import org.springframework.core.convert.converter.Converter;

public class ActivityToActivityResponse implements Converter<Activity, ActivityResponse> {
    @Override
    public ActivityResponse convert(Activity activity) {
        return new ActivityResponse(activity);
    }
}
